package com.bleplx.adapter;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.bleplx.adapter.errors.BleError;
import com.bleplx.adapter.errors.BleErrorCode;
import com.bleplx.adapter.errors.BleErrorUtils;
import com.bleplx.adapter.errors.ErrorConverter;
import com.bleplx.adapter.exceptions.CannotMonitorCharacteristicException;
import com.bleplx.adapter.utils.Base64Converter;
import com.bleplx.adapter.utils.Constants;
import com.bleplx.adapter.utils.DisposableMap;
import com.bleplx.adapter.utils.IdGenerator;
import com.bleplx.adapter.utils.LogLevel;
import com.bleplx.adapter.utils.RefreshGattCustomOperation;
import com.bleplx.adapter.utils.SafeExecutor;
import com.bleplx.adapter.utils.ServiceFactory;
import com.bleplx.adapter.utils.UUIDConverter;
import com.bleplx.adapter.utils.mapper.RxBleDeviceToDeviceMapper;
import com.bleplx.adapter.utils.mapper.RxScanResultToScanResultMapper;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.RxBleDeviceServices;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class BleModule extends ReactContextBaseJavaModule implements BleAdapter {
    public static final String NAME = "Ble";
    private Disposable adapterStateChangesSubscription;
    private final BluetoothAdapter bluetoothAdapter;
    private final BluetoothManager bluetoothManager;
    private final Context context;
    private RxBleClient rxBleClient;
    private Disposable scanSubscription;
    private final ErrorConverter errorConverter = new ErrorConverter();
    private final HashMap<String, Device> discoveredDevices = new HashMap<>();
    private final HashMap<String, Device> connectedDevices = new HashMap<>();
    private final HashMap<String, RxBleConnection> activeConnections = new HashMap<>();
    private final SparseArray<Service> discoveredServices = new SparseArray<>();
    private final SparseArray<Characteristic> discoveredCharacteristics = new SparseArray<>();
    private final SparseArray<Descriptor> discoveredDescriptors = new SparseArray<>();
    private final DisposableMap pendingTransactions = new DisposableMap();
    private final DisposableMap connectingDevices = new DisposableMap();
    private final RxBleDeviceToDeviceMapper rxBleDeviceToDeviceMapper = new RxBleDeviceToDeviceMapper();
    private final RxScanResultToScanResultMapper rxScanResultToScanResultMapper = new RxScanResultToScanResultMapper();
    private final ServiceFactory serviceFactory = new ServiceFactory();
    private int currentLogLevel = Integer.MAX_VALUE;

    static /* synthetic */ boolean lambda$changeAdapterState$15(RxBleAdapterStateObservable.BleAdapterState bleAdapterState, RxBleAdapterStateObservable.BleAdapterState bleAdapterState2) throws Exception {
        return bleAdapterState == bleAdapterState2;
    }

    static /* synthetic */ RxBleConnection lambda$safeConnectToDevice$23(RxBleConnection rxBleConnection, Boolean bool) throws Exception {
        return rxBleConnection;
    }

    static /* synthetic */ RxBleConnection lambda$safeConnectToDevice$26(RxBleConnection rxBleConnection, Integer num) throws Exception {
        return rxBleConnection;
    }

    static /* synthetic */ ObservableSource lambda$safeMonitorCharacteristicForDevice$41(Observable observable) throws Exception {
        return observable;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    public BleModule(Context context) {
        this.context = context;
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService("bluetooth");
        this.bluetoothManager = bluetoothManager;
        this.bluetoothAdapter = bluetoothManager.getAdapter();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void createClient(String str, OnEventCallback<String> onEventCallback, OnEventCallback<Integer> onEventCallback2) {
        this.rxBleClient = RxBleClient.create(this.context);
        this.adapterStateChangesSubscription = monitorAdapterStateChanges(this.context, onEventCallback);
        if (str != null) {
            onEventCallback2.onEvent(null);
        }
    }

    private void clearActiveConnections() {
        this.pendingTransactions.removeAllSubscriptions();
        this.connectingDevices.removeAllSubscriptions();
        this.connectedDevices.clear();
        this.activeConnections.clear();
        this.discoveredDevices.clear();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void destroyClient() {
        Disposable disposable = this.adapterStateChangesSubscription;
        if (disposable != null) {
            disposable.dispose();
            this.adapterStateChangesSubscription = null;
        }
        Disposable disposable2 = this.scanSubscription;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.scanSubscription.dispose();
            this.scanSubscription = null;
        }
        clearActiveConnections();
        this.discoveredServices.clear();
        this.discoveredCharacteristics.clear();
        this.discoveredDescriptors.clear();
        this.rxBleClient = null;
        IdGenerator.clear();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void enable(String str, OnSuccessCallback<Void> onSuccessCallback, OnErrorCallback onErrorCallback) {
        changeAdapterState(RxBleAdapterStateObservable.BleAdapterState.STATE_ON, str, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void disable(String str, OnSuccessCallback<Void> onSuccessCallback, OnErrorCallback onErrorCallback) {
        changeAdapterState(RxBleAdapterStateObservable.BleAdapterState.STATE_OFF, str, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public String getCurrentState() {
        if (supportsBluetoothLowEnergy()) {
            return this.bluetoothManager == null ? Constants.BluetoothState.POWERED_OFF : mapNativeAdapterStateToLocalBluetoothState(this.bluetoothAdapter.getState());
        }
        return Constants.BluetoothState.UNSUPPORTED;
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void startDeviceScan(String[] strArr, int i, int i2, boolean z, OnEventCallback<ScanResult> onEventCallback, OnErrorCallback onErrorCallback) {
        UUID[] uuidArrConvert;
        if (strArr != null) {
            uuidArrConvert = UUIDConverter.convert(strArr);
            if (uuidArrConvert == null) {
                onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(strArr));
                return;
            }
        } else {
            uuidArrConvert = null;
        }
        safeStartDeviceScan(uuidArrConvert, i, i2, z, onEventCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void stopDeviceScan() {
        Disposable disposable = this.scanSubscription;
        if (disposable != null) {
            disposable.dispose();
            this.scanSubscription = null;
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void requestConnectionPriorityForDevice(String str, int i, final String str2, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            final Device deviceById = getDeviceById(str);
            RxBleConnection connectionOrEmitError = getConnectionOrEmitError(deviceById.getId(), onErrorCallback);
            if (connectionOrEmitError == null) {
                return;
            }
            final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
            this.pendingTransactions.replaceSubscription(str2, connectionOrEmitError.requestConnectionPriority(i, 1L, TimeUnit.MILLISECONDS).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda32
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$requestConnectionPriorityForDevice$0(safeExecutor, str2);
                }
            }).subscribe(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda34
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$requestConnectionPriorityForDevice$1(safeExecutor, deviceById, str2);
                }
            }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda35
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$requestConnectionPriorityForDevice$2(safeExecutor, str2, (Throwable) obj);
                }
            }));
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestConnectionPriorityForDevice$0(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestConnectionPriorityForDevice$1(SafeExecutor safeExecutor, Device device, String str) throws Exception {
        safeExecutor.success(device);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestConnectionPriorityForDevice$2(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readRSSIForDevice(String str, final String str2, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            final Device deviceById = getDeviceById(str);
            RxBleConnection connectionOrEmitError = getConnectionOrEmitError(deviceById.getId(), onErrorCallback);
            if (connectionOrEmitError == null) {
                return;
            }
            final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
            this.pendingTransactions.replaceSubscription(str2, connectionOrEmitError.readRssi().doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda39
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$readRSSIForDevice$3(safeExecutor, str2);
                }
            }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda40
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$readRSSIForDevice$4(deviceById, safeExecutor, str2, (Integer) obj);
                }
            }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda41
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$readRSSIForDevice$5(safeExecutor, str2, (Throwable) obj);
                }
            }));
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readRSSIForDevice$3(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readRSSIForDevice$4(Device device, SafeExecutor safeExecutor, String str, Integer num) throws Exception {
        device.setRssi(num);
        safeExecutor.success(device);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$readRSSIForDevice$5(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void requestMTUForDevice(String str, int i, final String str2, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            final Device deviceById = getDeviceById(str);
            RxBleConnection connectionOrEmitError = getConnectionOrEmitError(deviceById.getId(), onErrorCallback);
            if (connectionOrEmitError == null) {
                return;
            }
            final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
            this.pendingTransactions.replaceSubscription(str2, connectionOrEmitError.requestMtu(i).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda36
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$requestMTUForDevice$6(safeExecutor, str2);
                }
            }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda37
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$requestMTUForDevice$7(deviceById, safeExecutor, str2, (Integer) obj);
                }
            }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda38
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$requestMTUForDevice$8(safeExecutor, str2, (Throwable) obj);
                }
            }));
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMTUForDevice$6(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMTUForDevice$7(Device device, SafeExecutor safeExecutor, String str, Integer num) throws Exception {
        device.setMtu(num);
        safeExecutor.success(device);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestMTUForDevice$8(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void getKnownDevices(String[] strArr, OnSuccessCallback<Device[]> onSuccessCallback, OnErrorCallback onErrorCallback) {
        if (this.rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to get known devices", null));
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str == null) {
                onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(strArr));
                return;
            }
            Device device = this.discoveredDevices.get(str);
            if (device != null) {
                arrayList.add(device);
            }
        }
        onSuccessCallback.onSuccess((Device[]) arrayList.toArray(new Device[arrayList.size()]));
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void getConnectedDevices(String[] strArr, OnSuccessCallback<Device[]> onSuccessCallback, OnErrorCallback onErrorCallback) {
        if (this.rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to get connected devices", null));
            return;
        }
        if (strArr.length == 0) {
            onSuccessCallback.onSuccess(new Device[0]);
            return;
        }
        int length = strArr.length;
        UUID[] uuidArr = new UUID[length];
        for (int i = 0; i < strArr.length; i++) {
            UUID uuidConvert = UUIDConverter.convert(strArr[i]);
            if (uuidConvert == null) {
                onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(strArr));
                return;
            }
            uuidArr[i] = uuidConvert;
        }
        ArrayList arrayList = new ArrayList();
        for (Device device : this.connectedDevices.values()) {
            for (int i2 = 0; i2 < length; i2++) {
                if (device.getServiceByUUID(uuidArr[i2]) != null) {
                    arrayList.add(device);
                    break;
                }
            }
        }
        onSuccessCallback.onSuccess((Device[]) arrayList.toArray(new Device[arrayList.size()]));
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void connectToDevice(String str, ConnectionOptions connectionOptions, OnSuccessCallback<Device> onSuccessCallback, OnEventCallback<ConnectionState> onEventCallback, OnErrorCallback onErrorCallback) {
        RxBleClient rxBleClient = this.rxBleClient;
        if (rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to connect to device", null));
            return;
        }
        RxBleDevice bleDevice = rxBleClient.getBleDevice(str);
        if (bleDevice == null) {
            onErrorCallback.onError(BleErrorUtils.deviceNotFound(str));
        } else {
            safeConnectToDevice(bleDevice, connectionOptions.getAutoConnect().booleanValue(), connectionOptions.getRequestMTU(), connectionOptions.getRefreshGattMoment(), connectionOptions.getTimeoutInMillis(), connectionOptions.getConnectionPriority(), onSuccessCallback, onEventCallback, onErrorCallback);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void cancelDeviceConnection(String str, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleClient rxBleClient = this.rxBleClient;
        if (rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to cancel device connection", null));
            return;
        }
        RxBleDevice bleDevice = rxBleClient.getBleDevice(str);
        if (this.connectingDevices.removeSubscription(str) && bleDevice != null) {
            onSuccessCallback.onSuccess(this.rxBleDeviceToDeviceMapper.map(bleDevice, null));
        } else if (bleDevice == null) {
            onErrorCallback.onError(BleErrorUtils.deviceNotFound(str));
        } else {
            onErrorCallback.onError(BleErrorUtils.deviceNotConnected(str));
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void isDeviceConnected(String str, OnSuccessCallback<Boolean> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleClient rxBleClient = this.rxBleClient;
        if (rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to check if device is connected", null));
            return;
        }
        try {
            RxBleDevice bleDevice = rxBleClient.getBleDevice(str);
            if (bleDevice == null) {
                onErrorCallback.onError(BleErrorUtils.deviceNotFound(str));
            } else {
                onSuccessCallback.onSuccess(Boolean.valueOf(bleDevice.getConnectionState().equals(RxBleConnection.RxBleConnectionState.CONNECTED)));
            }
        } catch (Exception e) {
            RxBleLog.e(e, "Error while checking if device is connected", new Object[0]);
            onErrorCallback.onError(this.errorConverter.toError(e));
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void discoverAllServicesAndCharacteristicsForDevice(String str, String str2, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeDiscoverAllServicesAndCharacteristicsForDevice(getDeviceById(str), str2, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Service> getServicesForDevice(String str) throws BleError {
        Device deviceById = getDeviceById(str);
        List<Service> services = deviceById.getServices();
        if (services != null) {
            return services;
        }
        throw BleErrorUtils.deviceServicesNotDiscovered(deviceById.getId());
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Characteristic> getCharacteristicsForDevice(String str, String str2) throws BleError {
        UUID uuidConvert = UUIDConverter.convert(str2);
        if (uuidConvert == null) {
            throw BleErrorUtils.invalidIdentifiers(str2);
        }
        Service serviceByUUID = getDeviceById(str).getServiceByUUID(uuidConvert);
        if (serviceByUUID == null) {
            throw BleErrorUtils.serviceNotFound(str2);
        }
        return serviceByUUID.getCharacteristics();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Characteristic> getCharacteristicsForService(int i) throws BleError {
        Service service = this.discoveredServices.get(i);
        if (service == null) {
            throw BleErrorUtils.serviceNotFound(Integer.toString(i));
        }
        return service.getCharacteristics();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Descriptor> descriptorsForDevice(String str, String str2, String str3) throws BleError {
        UUID[] uuidArrConvert = UUIDConverter.convert(str2, str3);
        if (uuidArrConvert == null) {
            throw BleErrorUtils.invalidIdentifiers(str2, str3);
        }
        Service serviceByUUID = getDeviceById(str).getServiceByUUID(uuidArrConvert[0]);
        if (serviceByUUID == null) {
            throw BleErrorUtils.serviceNotFound(str2);
        }
        Characteristic characteristicByUUID = serviceByUUID.getCharacteristicByUUID(uuidArrConvert[1]);
        if (characteristicByUUID == null) {
            throw BleErrorUtils.characteristicNotFound(str3);
        }
        return characteristicByUUID.getDescriptors();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Descriptor> descriptorsForService(int i, String str) throws BleError {
        UUID uuidConvert = UUIDConverter.convert(str);
        if (uuidConvert == null) {
            throw BleErrorUtils.invalidIdentifiers(str);
        }
        Service service = this.discoveredServices.get(i);
        if (service == null) {
            throw BleErrorUtils.serviceNotFound(Integer.toString(i));
        }
        Characteristic characteristicByUUID = service.getCharacteristicByUUID(uuidConvert);
        if (characteristicByUUID == null) {
            throw BleErrorUtils.characteristicNotFound(str);
        }
        return characteristicByUUID.getDescriptors();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public List<Descriptor> descriptorsForCharacteristic(int i) throws BleError {
        Characteristic characteristic = this.discoveredCharacteristics.get(i);
        if (characteristic == null) {
            throw BleErrorUtils.characteristicNotFound(Integer.toString(i));
        }
        return characteristic.getDescriptors();
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readCharacteristicForDevice(String str, String str2, String str3, String str4, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(str, str2, str3, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeReadCharacteristicForDevice(characteristicOrEmitError, str4, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readCharacteristicForService(int i, String str, String str2, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, str, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeReadCharacteristicForDevice(characteristicOrEmitError, str2, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readCharacteristic(int i, String str, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeReadCharacteristicForDevice(characteristicOrEmitError, str, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeCharacteristicForDevice(String str, String str2, String str3, String str4, boolean z, String str5, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(str, str2, str3, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        writeCharacteristicWithValue(characteristicOrEmitError, str4, Boolean.valueOf(z), str5, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeCharacteristicForService(int i, String str, String str2, boolean z, String str3, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, str, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        writeCharacteristicWithValue(characteristicOrEmitError, str2, Boolean.valueOf(z), str3, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeCharacteristic(int i, String str, boolean z, String str2, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        writeCharacteristicWithValue(characteristicOrEmitError, str, Boolean.valueOf(z), str2, onSuccessCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void monitorCharacteristicForDevice(String str, String str2, String str3, String str4, String str5, OnEventCallback<Characteristic> onEventCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(str, str2, str3, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeMonitorCharacteristicForDevice(characteristicOrEmitError, str4, str5, onEventCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void monitorCharacteristicForService(int i, String str, String str2, String str3, OnEventCallback<Characteristic> onEventCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, str, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeMonitorCharacteristicForDevice(characteristicOrEmitError, str2, str3, onEventCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void monitorCharacteristic(int i, String str, String str2, OnEventCallback<Characteristic> onEventCallback, OnErrorCallback onErrorCallback) {
        Characteristic characteristicOrEmitError = getCharacteristicOrEmitError(i, onErrorCallback);
        if (characteristicOrEmitError == null) {
            return;
        }
        safeMonitorCharacteristicForDevice(characteristicOrEmitError, str, str2, onEventCallback, onErrorCallback);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readDescriptorForDevice(String str, String str2, String str3, String str4, String str5, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeReadDescriptorForDevice(getDescriptor(str, str2, str3, str4), str5, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readDescriptorForService(int i, String str, String str2, String str3, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeReadDescriptorForDevice(getDescriptor(i, str, str2), str3, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readDescriptorForCharacteristic(int i, String str, String str2, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeReadDescriptorForDevice(getDescriptor(i, str), str2, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void readDescriptor(int i, String str, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeReadDescriptorForDevice(getDescriptor(i), str, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    private void safeReadDescriptorForDevice(final Descriptor descriptor, final String str, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(descriptor.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, connectionOrEmitError.readDescriptor(descriptor.getNativeDescriptor()).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda15
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$safeReadDescriptorForDevice$9(safeExecutor, str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda16
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeReadDescriptorForDevice$10(descriptor, safeExecutor, str, (byte[]) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda17
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeReadDescriptorForDevice$11(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadDescriptorForDevice$9(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadDescriptorForDevice$10(Descriptor descriptor, SafeExecutor safeExecutor, String str, byte[] bArr) throws Exception {
        descriptor.logValue("Read from", bArr);
        descriptor.setValue(bArr);
        safeExecutor.success(new Descriptor(descriptor));
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadDescriptorForDevice$11(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeDescriptorForDevice(String str, String str2, String str3, String str4, String str5, String str6, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        OnErrorCallback onErrorCallback2;
        try {
            onErrorCallback2 = onErrorCallback;
            try {
                safeWriteDescriptorForDevice(getDescriptor(str, str2, str3, str4), str5, str6, onSuccessCallback, onErrorCallback2);
            } catch (BleError e) {
                e = e;
                onErrorCallback2.onError(e);
            }
        } catch (BleError e2) {
            e = e2;
            onErrorCallback2 = onErrorCallback;
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeDescriptorForService(int i, String str, String str2, String str3, String str4, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        OnErrorCallback onErrorCallback2;
        try {
            onErrorCallback2 = onErrorCallback;
            try {
                safeWriteDescriptorForDevice(getDescriptor(i, str, str2), str3, str4, onSuccessCallback, onErrorCallback2);
            } catch (BleError e) {
                e = e;
                onErrorCallback2.onError(e);
            }
        } catch (BleError e2) {
            e = e2;
            onErrorCallback2 = onErrorCallback;
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeDescriptorForCharacteristic(int i, String str, String str2, String str3, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            safeWriteDescriptorForDevice(getDescriptor(i, str), str2, str3, onSuccessCallback, onErrorCallback);
        } catch (BleError e) {
            onErrorCallback.onError(e);
        }
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void writeDescriptor(int i, String str, String str2, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        OnErrorCallback onErrorCallback2;
        try {
            onErrorCallback2 = onErrorCallback;
            try {
                safeWriteDescriptorForDevice(getDescriptor(i), str, str2, onSuccessCallback, onErrorCallback2);
            } catch (BleError e) {
                e = e;
                onErrorCallback2.onError(e);
            }
        } catch (BleError e2) {
            e = e2;
            onErrorCallback2 = onErrorCallback;
        }
    }

    private void safeWriteDescriptorForDevice(final Descriptor descriptor, String str, final String str2, OnSuccessCallback<Descriptor> onSuccessCallback, OnErrorCallback onErrorCallback) {
        BluetoothGattDescriptor nativeDescriptor = descriptor.getNativeDescriptor();
        if (nativeDescriptor.getUuid().equals(Constants.CLIENT_CHARACTERISTIC_CONFIG_UUID)) {
            onErrorCallback.onError(BleErrorUtils.descriptorWriteNotAllowed(UUIDConverter.fromUUID(nativeDescriptor.getUuid())));
            return;
        }
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(descriptor.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        try {
            final byte[] bArrDecode = Base64Converter.decode(str);
            final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
            this.pendingTransactions.replaceSubscription(str2, connectionOrEmitError.writeDescriptor(nativeDescriptor, bArrDecode).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$safeWriteDescriptorForDevice$12(safeExecutor, str2);
                }
            }).subscribe(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda11
                @Override // io.reactivex.functions.Action
                public final void run() throws Exception {
                    this.f$0.lambda$safeWriteDescriptorForDevice$13(descriptor, bArrDecode, safeExecutor, str2);
                }
            }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda22
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) throws Exception {
                    this.f$0.lambda$safeWriteDescriptorForDevice$14(safeExecutor, str2, (Throwable) obj);
                }
            }));
        } catch (Throwable unused) {
            onErrorCallback.onError(BleErrorUtils.invalidWriteDataForDescriptor(str, UUIDConverter.fromUUID(nativeDescriptor.getUuid())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteDescriptorForDevice$12(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteDescriptorForDevice$13(Descriptor descriptor, byte[] bArr, SafeExecutor safeExecutor, String str) throws Exception {
        descriptor.logValue("Write to", bArr);
        descriptor.setValue(bArr);
        safeExecutor.success(new Descriptor(descriptor));
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteDescriptorForDevice$14(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private Descriptor getDescriptor(String str, String str2, String str3, String str4) throws BleError {
        UUID[] uuidArrConvert = UUIDConverter.convert(str2, str3, str4);
        if (uuidArrConvert == null) {
            throw BleErrorUtils.invalidIdentifiers(str2, str3, str4);
        }
        Device device = this.connectedDevices.get(str);
        if (device == null) {
            throw BleErrorUtils.deviceNotConnected(str);
        }
        Service serviceByUUID = device.getServiceByUUID(uuidArrConvert[0]);
        if (serviceByUUID == null) {
            throw BleErrorUtils.serviceNotFound(str2);
        }
        Characteristic characteristicByUUID = serviceByUUID.getCharacteristicByUUID(uuidArrConvert[1]);
        if (characteristicByUUID == null) {
            throw BleErrorUtils.characteristicNotFound(str3);
        }
        Descriptor descriptorByUUID = characteristicByUUID.getDescriptorByUUID(uuidArrConvert[2]);
        if (descriptorByUUID != null) {
            return descriptorByUUID;
        }
        throw BleErrorUtils.descriptorNotFound(str4);
    }

    private Descriptor getDescriptor(int i, String str, String str2) throws BleError {
        UUID[] uuidArrConvert = UUIDConverter.convert(str, str2);
        if (uuidArrConvert == null) {
            throw BleErrorUtils.invalidIdentifiers(str, str2);
        }
        Service service = this.discoveredServices.get(i);
        if (service == null) {
            throw BleErrorUtils.serviceNotFound(Integer.toString(i));
        }
        Characteristic characteristicByUUID = service.getCharacteristicByUUID(uuidArrConvert[0]);
        if (characteristicByUUID == null) {
            throw BleErrorUtils.characteristicNotFound(str);
        }
        Descriptor descriptorByUUID = characteristicByUUID.getDescriptorByUUID(uuidArrConvert[1]);
        if (descriptorByUUID != null) {
            return descriptorByUUID;
        }
        throw BleErrorUtils.descriptorNotFound(str2);
    }

    private Descriptor getDescriptor(int i, String str) throws BleError {
        UUID uuidConvert = UUIDConverter.convert(str);
        if (uuidConvert == null) {
            throw BleErrorUtils.invalidIdentifiers(str);
        }
        Characteristic characteristic = this.discoveredCharacteristics.get(i);
        if (characteristic == null) {
            throw BleErrorUtils.characteristicNotFound(Integer.toString(i));
        }
        Descriptor descriptorByUUID = characteristic.getDescriptorByUUID(uuidConvert);
        if (descriptorByUUID != null) {
            return descriptorByUUID;
        }
        throw BleErrorUtils.descriptorNotFound(str);
    }

    private Descriptor getDescriptor(int i) throws BleError {
        Descriptor descriptor = this.discoveredDescriptors.get(i);
        if (descriptor != null) {
            return descriptor;
        }
        throw BleErrorUtils.descriptorNotFound(Integer.toString(i));
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void cancelTransaction(String str) {
        this.pendingTransactions.removeSubscription(str);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public void setLogLevel(String str) {
        int logLevel = LogLevel.toLogLevel(str);
        this.currentLogLevel = logLevel;
        RxBleLog.setLogLevel(logLevel);
    }

    @Override // com.bleplx.adapter.BleAdapter
    public String getLogLevel() {
        return LogLevel.fromLogLevel(this.currentLogLevel);
    }

    private Disposable monitorAdapterStateChanges(Context context, final OnEventCallback<String> onEventCallback) {
        if (!supportsBluetoothLowEnergy()) {
            return null;
        }
        Observable<R> map = new RxBleAdapterStateObservable(context).map(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.mapRxBleAdapterStateToLocalBluetoothState((RxBleAdapterStateObservable.BleAdapterState) obj);
            }
        });
        Objects.requireNonNull(onEventCallback);
        return map.subscribe((Consumer<? super R>) new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                onEventCallback.onEvent((String) obj);
            }
        });
    }

    private boolean supportsBluetoothLowEnergy() {
        return this.context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String mapRxBleAdapterStateToLocalBluetoothState(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) {
        if (bleAdapterState == RxBleAdapterStateObservable.BleAdapterState.STATE_ON) {
            return Constants.BluetoothState.POWERED_ON;
        }
        if (bleAdapterState == RxBleAdapterStateObservable.BleAdapterState.STATE_OFF) {
            return Constants.BluetoothState.POWERED_OFF;
        }
        return Constants.BluetoothState.RESETTING;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:29:0x00d1  */
    private void changeAdapterState(final RxBleAdapterStateObservable.BleAdapterState bleAdapterState, final String str, OnSuccessCallback<Void> onSuccessCallback, OnErrorCallback onErrorCallback) {
        boolean zDisable;
        if (this.bluetoothManager == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothStateChangeFailed, "BluetoothManager is null", null));
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        Disposable disposableSubscribe = new RxBleAdapterStateObservable(this.context).takeUntil(new Predicate() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda18
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return BleModule.lambda$changeAdapterState$15(bleAdapterState, (RxBleAdapterStateObservable.BleAdapterState) obj);
            }
        }).firstOrError().doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda19
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$changeAdapterState$16(safeExecutor, str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda20
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$changeAdapterState$17(safeExecutor, str, (RxBleAdapterStateObservable.BleAdapterState) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda21
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$changeAdapterState$18(safeExecutor, str, (Throwable) obj);
            }
        });
        boolean z = false;
        try {
            if (bleAdapterState == RxBleAdapterStateObservable.BleAdapterState.STATE_ON) {
                if (Build.VERSION.SDK_INT >= 31) {
                    Context context = this.context;
                    if (context instanceof Activity) {
                        ((Activity) context).startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
                        z = true;
                    }
                } else {
                    zDisable = this.bluetoothAdapter.enable();
                }
                if (z) {
                    disposableSubscribe.dispose();
                    onErrorCallback.onError(new BleError(BleErrorCode.BluetoothStateChangeFailed, String.format("Couldn't set bluetooth adapter state to %s", bleAdapterState.toString()), null));
                } else {
                    this.pendingTransactions.replaceSubscription(str, disposableSubscribe);
                }
            }
            zDisable = this.bluetoothAdapter.disable();
            z = !zDisable;
        } catch (SecurityException unused) {
            if (Build.VERSION.SDK_INT >= 31) {
                onErrorCallback.onError(new BleError(BleErrorCode.BluetoothUnauthorized, "Method requires BLUETOOTH_CONNECT permission", null));
            } else {
                onErrorCallback.onError(new BleError(BleErrorCode.BluetoothUnauthorized, "Method requires BLUETOOTH_ADMIN permission", null));
            }
        } catch (Exception e) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothStateChangeFailed, String.format("Couldn't set bluetooth adapter state because of: %s", e.getMessage() != null ? e.getMessage() : "unknown error"), null));
        }
        if (z) {
            disposableSubscribe.dispose();
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothStateChangeFailed, String.format("Couldn't set bluetooth adapter state to %s", bleAdapterState.toString()), null));
        } else {
            this.pendingTransactions.replaceSubscription(str, disposableSubscribe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeAdapterState$16(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeAdapterState$17(SafeExecutor safeExecutor, String str, RxBleAdapterStateObservable.BleAdapterState bleAdapterState) throws Exception {
        safeExecutor.success(null);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changeAdapterState$18(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private String mapNativeAdapterStateToLocalBluetoothState(int i) {
        switch (i) {
            case 10:
                return Constants.BluetoothState.POWERED_OFF;
            case 11:
            case 13:
                return Constants.BluetoothState.RESETTING;
            case 12:
                return Constants.BluetoothState.POWERED_ON;
            default:
                return "Unknown";
        }
    }

    private void safeStartDeviceScan(UUID[] uuidArr, int i, int i2, boolean z, final OnEventCallback<ScanResult> onEventCallback, final OnErrorCallback onErrorCallback) {
        if (this.rxBleClient == null) {
            onErrorCallback.onError(new BleError(BleErrorCode.BluetoothManagerDestroyed, "BleManager not created when tried to start device scan", null));
            return;
        }
        ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(i).setCallbackType(i2).setLegacy(z).build();
        int length = uuidArr == null ? 0 : uuidArr.length;
        ScanFilter[] scanFilterArr = new ScanFilter[length];
        for (int i3 = 0; i3 < length; i3++) {
            scanFilterArr[i3] = new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString(uuidArr[i3].toString())).build();
        }
        this.scanSubscription = this.rxBleClient.scanBleDevices(scanSettingsBuild, scanFilterArr).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda13
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeStartDeviceScan$19(onEventCallback, (com.polidea.rxandroidble2.scan.ScanResult) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda14
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeStartDeviceScan$20(onErrorCallback, (Throwable) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeStartDeviceScan$19(OnEventCallback onEventCallback, com.polidea.rxandroidble2.scan.ScanResult scanResult) throws Exception {
        String macAddress = scanResult.getBleDevice().getMacAddress();
        if (!this.discoveredDevices.containsKey(macAddress)) {
            this.discoveredDevices.put(macAddress, this.rxBleDeviceToDeviceMapper.map(scanResult.getBleDevice(), null));
        }
        onEventCallback.onEvent(this.rxScanResultToScanResultMapper.map(scanResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeStartDeviceScan$20(OnErrorCallback onErrorCallback, Throwable th) throws Exception {
        onErrorCallback.onError(this.errorConverter.toError(th));
    }

    private Device getDeviceById(String str) throws BleError {
        Device device = this.connectedDevices.get(str);
        if (device != null) {
            return device;
        }
        throw BleErrorUtils.deviceNotConnected(str);
    }

    private RxBleConnection getConnectionOrEmitError(String str, OnErrorCallback onErrorCallback) {
        RxBleConnection rxBleConnection = this.activeConnections.get(str);
        if (rxBleConnection != null) {
            return rxBleConnection;
        }
        onErrorCallback.onError(BleErrorUtils.deviceNotConnected(str));
        return null;
    }

    private void safeConnectToDevice(final RxBleDevice rxBleDevice, boolean z, final int i, RefreshGattMoment refreshGattMoment, Long l, final int i2, OnSuccessCallback<Device> onSuccessCallback, final OnEventCallback<ConnectionState> onEventCallback, OnErrorCallback onErrorCallback) {
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        Observable<RxBleConnection> observableDoFinally = rxBleDevice.establishConnection(z).doOnSubscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda24
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                onEventCallback.onEvent(ConnectionState.CONNECTING);
            }
        }).doFinally(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda25
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$safeConnectToDevice$22(safeExecutor, rxBleDevice, onEventCallback);
            }
        });
        if (refreshGattMoment == RefreshGattMoment.ON_CONNECTED) {
            observableDoFinally = observableDoFinally.flatMap(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda26
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    RxBleConnection rxBleConnection = (RxBleConnection) obj;
                    return rxBleConnection.queue(new RefreshGattCustomOperation()).map(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda23
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return BleModule.lambda$safeConnectToDevice$23(rxBleConnection, (Boolean) obj2);
                        }
                    });
                }
            });
        }
        if (i2 > 0) {
            observableDoFinally = observableDoFinally.flatMap(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda27
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    RxBleConnection rxBleConnection = (RxBleConnection) obj;
                    return rxBleConnection.requestConnectionPriority(i2, 1L, TimeUnit.MILLISECONDS).andThen(Observable.just(rxBleConnection));
                }
            });
        }
        if (i > 0) {
            observableDoFinally = observableDoFinally.flatMap(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda28
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    RxBleConnection rxBleConnection = (RxBleConnection) obj;
                    return rxBleConnection.requestMtu(i).map(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda44
                        @Override // io.reactivex.functions.Function
                        public final Object apply(Object obj2) {
                            return BleModule.lambda$safeConnectToDevice$26(rxBleConnection, (Integer) obj2);
                        }
                    }).toObservable();
                }
            });
        }
        if (l != null) {
            observableDoFinally = observableDoFinally.timeout(Observable.timer(l.longValue(), TimeUnit.MILLISECONDS), new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda29
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return Observable.never();
                }
            });
        }
        this.connectingDevices.replaceSubscription(rxBleDevice.getMacAddress(), observableDoFinally.subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda30
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeConnectToDevice$29(rxBleDevice, onEventCallback, safeExecutor, (RxBleConnection) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda31
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeConnectToDevice$30(safeExecutor, rxBleDevice, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeConnectToDevice$22(SafeExecutor safeExecutor, RxBleDevice rxBleDevice, OnEventCallback onEventCallback) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        onDeviceDisconnected(rxBleDevice);
        onEventCallback.onEvent(ConnectionState.DISCONNECTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeConnectToDevice$29(RxBleDevice rxBleDevice, OnEventCallback onEventCallback, SafeExecutor safeExecutor, RxBleConnection rxBleConnection) throws Exception {
        Device map = this.rxBleDeviceToDeviceMapper.map(rxBleDevice, rxBleConnection);
        onEventCallback.onEvent(ConnectionState.CONNECTED);
        cleanServicesAndCharacteristicsForDevice(map);
        this.connectedDevices.put(rxBleDevice.getMacAddress(), map);
        this.activeConnections.put(rxBleDevice.getMacAddress(), rxBleConnection);
        safeExecutor.success(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeConnectToDevice$30(SafeExecutor safeExecutor, RxBleDevice rxBleDevice, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        onDeviceDisconnected(rxBleDevice);
    }

    private void onDeviceDisconnected(RxBleDevice rxBleDevice) {
        this.activeConnections.remove(rxBleDevice.getMacAddress());
        Device deviceRemove = this.connectedDevices.remove(rxBleDevice.getMacAddress());
        if (deviceRemove == null) {
            return;
        }
        cleanServicesAndCharacteristicsForDevice(deviceRemove);
        this.connectingDevices.removeSubscription(deviceRemove.getId());
    }

    private void safeDiscoverAllServicesAndCharacteristicsForDevice(final Device device, final String str, OnSuccessCallback<Device> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(device.getId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, connectionOrEmitError.discoverServices().doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda33
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$31(safeExecutor, str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda42
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$32(device, safeExecutor, str, (RxBleDeviceServices) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda43
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$33(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$31(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$32(Device device, SafeExecutor safeExecutor, String str, RxBleDeviceServices rxBleDeviceServices) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (BluetoothGattService bluetoothGattService : rxBleDeviceServices.getBluetoothGattServices()) {
            Service serviceCreate = this.serviceFactory.create(device.getId(), bluetoothGattService);
            this.discoveredServices.put(serviceCreate.getId(), serviceCreate);
            arrayList.add(serviceCreate);
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                Characteristic characteristic = new Characteristic(serviceCreate, bluetoothGattCharacteristic);
                this.discoveredCharacteristics.put(characteristic.getId(), characteristic);
                Iterator<BluetoothGattDescriptor> it = bluetoothGattCharacteristic.getDescriptors().iterator();
                while (it.hasNext()) {
                    Descriptor descriptor = new Descriptor(characteristic, it.next());
                    this.discoveredDescriptors.put(descriptor.getId(), descriptor);
                }
            }
        }
        device.setServices(arrayList);
        safeExecutor.success(device);
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeDiscoverAllServicesAndCharacteristicsForDevice$33(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private void safeReadCharacteristicForDevice(final Characteristic characteristic, final String str, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(characteristic.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, connectionOrEmitError.readCharacteristic(characteristic.gattCharacteristic).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda9
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$safeReadCharacteristicForDevice$34(safeExecutor, str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda10
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeReadCharacteristicForDevice$35(characteristic, safeExecutor, str, (byte[]) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda12
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeReadCharacteristicForDevice$36(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadCharacteristicForDevice$34(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadCharacteristicForDevice$35(Characteristic characteristic, SafeExecutor safeExecutor, String str, byte[] bArr) throws Exception {
        characteristic.logValue("Read from", bArr);
        characteristic.setValue(bArr);
        safeExecutor.success(new Characteristic(characteristic));
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeReadCharacteristicForDevice$36(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private void writeCharacteristicWithValue(Characteristic characteristic, String str, Boolean bool, String str2, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        try {
            byte[] bArrDecode = Base64Converter.decode(str);
            characteristic.setWriteType(bool.booleanValue() ? 2 : 1);
            safeWriteCharacteristicForDevice(characteristic, bArrDecode, str2, onSuccessCallback, onErrorCallback);
        } catch (Throwable unused) {
            onErrorCallback.onError(BleErrorUtils.invalidWriteDataForCharacteristic(str, UUIDConverter.fromUUID(characteristic.getUuid())));
        }
    }

    private void safeWriteCharacteristicForDevice(final Characteristic characteristic, byte[] bArr, final String str, OnSuccessCallback<Characteristic> onSuccessCallback, OnErrorCallback onErrorCallback) {
        RxBleConnection connectionOrEmitError = getConnectionOrEmitError(characteristic.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(onSuccessCallback, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, connectionOrEmitError.writeCharacteristic(characteristic.gattCharacteristic, bArr).doOnDispose(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$safeWriteCharacteristicForDevice$37(safeExecutor, str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeWriteCharacteristicForDevice$38(characteristic, safeExecutor, str, (byte[]) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda8
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeWriteCharacteristicForDevice$39(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteCharacteristicForDevice$37(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteCharacteristicForDevice$38(Characteristic characteristic, SafeExecutor safeExecutor, String str, byte[] bArr) throws Exception {
        characteristic.logValue("Write to", bArr);
        characteristic.setValue(bArr);
        safeExecutor.success(new Characteristic(characteristic));
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeWriteCharacteristicForDevice$39(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private void safeMonitorCharacteristicForDevice(final Characteristic characteristic, final String str, final String str2, final OnEventCallback<Characteristic> onEventCallback, OnErrorCallback onErrorCallback) {
        final RxBleConnection connectionOrEmitError = getConnectionOrEmitError(characteristic.getDeviceId(), onErrorCallback);
        if (connectionOrEmitError == null) {
            return;
        }
        final SafeExecutor safeExecutor = new SafeExecutor(null, onErrorCallback);
        this.pendingTransactions.replaceSubscription(str, Observable.defer(new Callable() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda45
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return BleModule.lambda$safeMonitorCharacteristicForDevice$40(characteristic, str2, connectionOrEmitError);
            }
        }).flatMap(new Function() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda46
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return BleModule.lambda$safeMonitorCharacteristicForDevice$41((Observable) obj);
            }
        }).toFlowable(BackpressureStrategy.BUFFER).observeOn(Schedulers.computation()).doOnCancel(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda47
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$safeMonitorCharacteristicForDevice$42(safeExecutor, str);
            }
        }).doOnComplete(new Action() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.lambda$safeMonitorCharacteristicForDevice$43(str);
            }
        }).subscribe(new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                BleModule.lambda$safeMonitorCharacteristicForDevice$44(characteristic, onEventCallback, (byte[]) obj);
            }
        }, new Consumer() { // from class: com.bleplx.adapter.BleModule$$ExternalSyntheticLambda3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                this.f$0.lambda$safeMonitorCharacteristicForDevice$45(safeExecutor, str, (Throwable) obj);
            }
        }));
    }

    static /* synthetic */ ObservableSource lambda$safeMonitorCharacteristicForDevice$40(Characteristic characteristic, String str, RxBleConnection rxBleConnection) throws Exception {
        NotificationSetupMode notificationSetupMode;
        if (characteristic.getGattDescriptor(Constants.CLIENT_CHARACTERISTIC_CONFIG_UUID) != null) {
            notificationSetupMode = NotificationSetupMode.QUICK_SETUP;
        } else {
            notificationSetupMode = NotificationSetupMode.COMPAT;
        }
        if ("notification".equals(str) && characteristic.isNotifiable()) {
            return rxBleConnection.setupNotification(characteristic.gattCharacteristic, notificationSetupMode);
        }
        if ("indication".equals(str) && characteristic.isIndicatable()) {
            return rxBleConnection.setupIndication(characteristic.gattCharacteristic, notificationSetupMode);
        }
        if (characteristic.isNotifiable()) {
            return rxBleConnection.setupNotification(characteristic.gattCharacteristic, notificationSetupMode);
        }
        if (characteristic.isIndicatable()) {
            return rxBleConnection.setupIndication(characteristic.gattCharacteristic, notificationSetupMode);
        }
        return Observable.error(new CannotMonitorCharacteristicException(characteristic));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeMonitorCharacteristicForDevice$42(SafeExecutor safeExecutor, String str) throws Exception {
        safeExecutor.error(BleErrorUtils.cancelled());
        this.pendingTransactions.removeSubscription(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeMonitorCharacteristicForDevice$43(String str) throws Exception {
        this.pendingTransactions.removeSubscription(str);
    }

    static /* synthetic */ void lambda$safeMonitorCharacteristicForDevice$44(Characteristic characteristic, OnEventCallback onEventCallback, byte[] bArr) throws Exception {
        characteristic.logValue("Notification from", bArr);
        characteristic.setValue(bArr);
        onEventCallback.onEvent(new Characteristic(characteristic));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$safeMonitorCharacteristicForDevice$45(SafeExecutor safeExecutor, String str, Throwable th) throws Exception {
        safeExecutor.error(this.errorConverter.toError(th));
        this.pendingTransactions.removeSubscription(str);
    }

    private Characteristic getCharacteristicOrEmitError(String str, String str2, String str3, OnErrorCallback onErrorCallback) {
        UUID[] uuidArrConvert = UUIDConverter.convert(str2, str3);
        if (uuidArrConvert == null) {
            onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(str2, str3));
            return null;
        }
        Device device = this.connectedDevices.get(str);
        if (device == null) {
            onErrorCallback.onError(BleErrorUtils.deviceNotConnected(str));
            return null;
        }
        Service serviceByUUID = device.getServiceByUUID(uuidArrConvert[0]);
        if (serviceByUUID == null) {
            onErrorCallback.onError(BleErrorUtils.serviceNotFound(str2));
            return null;
        }
        Characteristic characteristicByUUID = serviceByUUID.getCharacteristicByUUID(uuidArrConvert[1]);
        if (characteristicByUUID != null) {
            return characteristicByUUID;
        }
        onErrorCallback.onError(BleErrorUtils.characteristicNotFound(str3));
        return null;
    }

    private Characteristic getCharacteristicOrEmitError(int i, String str, OnErrorCallback onErrorCallback) {
        UUID uuidConvert = UUIDConverter.convert(str);
        if (uuidConvert == null) {
            onErrorCallback.onError(BleErrorUtils.invalidIdentifiers(str));
            return null;
        }
        Service service = this.discoveredServices.get(i);
        if (service == null) {
            onErrorCallback.onError(BleErrorUtils.serviceNotFound(Integer.toString(i)));
            return null;
        }
        Characteristic characteristicByUUID = service.getCharacteristicByUUID(uuidConvert);
        if (characteristicByUUID != null) {
            return characteristicByUUID;
        }
        onErrorCallback.onError(BleErrorUtils.characteristicNotFound(str));
        return null;
    }

    private Characteristic getCharacteristicOrEmitError(int i, OnErrorCallback onErrorCallback) {
        Characteristic characteristic = this.discoveredCharacteristics.get(i);
        if (characteristic != null) {
            return characteristic;
        }
        onErrorCallback.onError(BleErrorUtils.characteristicNotFound(Integer.toString(i)));
        return null;
    }

    private void cleanServicesAndCharacteristicsForDevice(Device device) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.discoveredServices.size(); i++) {
            int iKeyAt = this.discoveredServices.keyAt(i);
            Service service = this.discoveredServices.get(iKeyAt);
            if (service == null || service.getDeviceID().equals(device.getId())) {
                arrayList.add(Integer.valueOf(iKeyAt));
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Integer) it.next()).intValue();
            if (this.discoveredServices.indexOfKey(iIntValue) >= 0) {
                this.discoveredServices.remove(iIntValue);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < this.discoveredCharacteristics.size(); i2++) {
            int iKeyAt2 = this.discoveredCharacteristics.keyAt(i2);
            Characteristic characteristic = this.discoveredCharacteristics.get(iKeyAt2);
            if (characteristic == null || characteristic.getDeviceId().equals(device.getId())) {
                arrayList2.add(Integer.valueOf(iKeyAt2));
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int iIntValue2 = ((Integer) it2.next()).intValue();
            if (this.discoveredCharacteristics.indexOfKey(iIntValue2) >= 0) {
                this.discoveredCharacteristics.remove(iIntValue2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (int i3 = 0; i3 < this.discoveredDescriptors.size(); i3++) {
            int iKeyAt3 = this.discoveredDescriptors.keyAt(i3);
            Descriptor descriptor = this.discoveredDescriptors.get(iKeyAt3);
            if (descriptor == null || descriptor.getDeviceId().equals(device.getId())) {
                arrayList3.add(Integer.valueOf(iKeyAt3));
            }
        }
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            int iIntValue3 = ((Integer) it3.next()).intValue();
            if (this.discoveredDescriptors.indexOfKey(iIntValue3) >= 0) {
                this.discoveredDescriptors.remove(iIntValue3);
            }
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void invalidate() {
        clearActiveConnections();
    }
}
