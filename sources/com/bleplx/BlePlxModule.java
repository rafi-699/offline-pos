package com.bleplx;

import com.bleplx.adapter.BleAdapter;
import com.bleplx.adapter.BleAdapterFactory;
import com.bleplx.adapter.Characteristic;
import com.bleplx.adapter.ConnectionOptions;
import com.bleplx.adapter.ConnectionState;
import com.bleplx.adapter.Descriptor;
import com.bleplx.adapter.Device;
import com.bleplx.adapter.OnErrorCallback;
import com.bleplx.adapter.OnEventCallback;
import com.bleplx.adapter.OnSuccessCallback;
import com.bleplx.adapter.RefreshGattMoment;
import com.bleplx.adapter.ScanResult;
import com.bleplx.adapter.Service;
import com.bleplx.adapter.errors.BleError;
import com.bleplx.adapter.errors.BleErrorCode;
import com.bleplx.converter.BleErrorToJsObjectConverter;
import com.bleplx.converter.CharacteristicToJsObjectConverter;
import com.bleplx.converter.DescriptorToJsObjectConverter;
import com.bleplx.converter.DeviceToJsObjectConverter;
import com.bleplx.converter.ScanResultToJsObjectConverter;
import com.bleplx.converter.ServiceToJsObjectConverter;
import com.bleplx.utils.ErrorDefaults;
import com.bleplx.utils.ReadableArrayConverter;
import com.bleplx.utils.SafePromise;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.ConnectionComponent;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@ReactModule(name = BlePlxModule.NAME)
public class BlePlxModule extends ReactContextBaseJavaModule {
    public static final String NAME = "BlePlx";
    private BleAdapter bleAdapter;
    private final CharacteristicToJsObjectConverter characteristicConverter;
    private final DescriptorToJsObjectConverter descriptorConverter;
    private final DeviceToJsObjectConverter deviceConverter;
    private final BleErrorToJsObjectConverter errorConverter;
    private final ReactApplicationContext reactContext;
    private final ScanResultToJsObjectConverter scanResultConverter;
    private final ServiceToJsObjectConverter serviceConverter;

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void removeListeners(int i) {
    }

    public BlePlxModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.errorConverter = new BleErrorToJsObjectConverter();
        this.scanResultConverter = new ScanResultToJsObjectConverter();
        this.deviceConverter = new DeviceToJsObjectConverter();
        this.characteristicConverter = new CharacteristicToJsObjectConverter();
        this.descriptorConverter = new DescriptorToJsObjectConverter();
        this.serviceConverter = new ServiceToJsObjectConverter();
        this.reactContext = reactApplicationContext;
        RxJavaPlugins.setErrorHandler(new Consumer() { // from class: com.bleplx.BlePlxModule$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                BlePlxModule.lambda$new$0((Throwable) obj);
            }
        });
    }

    static /* synthetic */ void lambda$new$0(Throwable th) throws Exception {
        if (th instanceof UndeliverableException) {
            RxBleLog.e("Handle all unhandled exceptions from RxJava: " + th.getMessage(), new Object[0]);
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadCurrentThread.getUncaughtExceptionHandler();
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(threadCurrentThread, th);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        for (Event event : Event.values()) {
            map.put(event.name, event.name);
        }
        return map;
    }

    @ReactMethod
    public void createClient(String str) {
        BleAdapter newAdapter = BleAdapterFactory.getNewAdapter(this.reactContext);
        this.bleAdapter = newAdapter;
        newAdapter.createClient(str, new OnEventCallback<String>() { // from class: com.bleplx.BlePlxModule.1
            @Override // com.bleplx.adapter.OnEventCallback
            public void onEvent(String str2) {
                BlePlxModule.this.sendEvent(Event.StateChangeEvent, str2);
            }
        }, new OnEventCallback<Integer>() { // from class: com.bleplx.BlePlxModule.2
            @Override // com.bleplx.adapter.OnEventCallback
            public void onEvent(Integer num) {
                BlePlxModule.this.sendEvent(Event.RestoreStateEvent, null);
            }
        });
    }

    @ReactMethod
    public void destroyClient(Promise promise) {
        if (isRequestPossibleHandler("destroyClient", promise)) {
            this.bleAdapter.destroyClient();
            this.bleAdapter = null;
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void cancelTransaction(String str, Promise promise) {
        if (isRequestPossibleHandler("cancelTransaction", promise)) {
            this.bleAdapter.cancelTransaction(str);
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void setLogLevel(String str, Promise promise) {
        if (isRequestPossibleHandler("setLogLevel", promise)) {
            this.bleAdapter.setLogLevel(str);
            promise.resolve(this.bleAdapter.getLogLevel());
        }
    }

    @ReactMethod
    public void logLevel(Promise promise) {
        if (isRequestPossibleHandler("logLevel", promise)) {
            promise.resolve(this.bleAdapter.getLogLevel());
        }
    }

    @ReactMethod
    public void enable(String str, Promise promise) {
        if (isRequestPossibleHandler("enable", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.enable(str, new OnSuccessCallback<Void>() { // from class: com.bleplx.BlePlxModule.3
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Void r2) {
                    safePromise.resolve(null);
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.4
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void disable(String str, Promise promise) {
        if (isRequestPossibleHandler("disable", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.disable(str, new OnSuccessCallback<Void>() { // from class: com.bleplx.BlePlxModule.5
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Void r2) {
                    safePromise.resolve(null);
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.6
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void state(Promise promise) {
        if (isRequestPossibleHandler(ServerProtocol.DIALOG_PARAM_STATE, promise)) {
            promise.resolve(this.bleAdapter.getCurrentState());
        }
    }

    @ReactMethod
    public void startDeviceScan(ReadableArray readableArray, ReadableMap readableMap, Promise promise) {
        int i;
        boolean z;
        int i2;
        if (isRequestPossibleHandler("startDeviceScan", promise)) {
            boolean z2 = true;
            int i3 = 0;
            if (readableMap != null) {
                if (readableMap.hasKey("scanMode") && readableMap.getType("scanMode") == ReadableType.Number) {
                    i3 = readableMap.getInt("scanMode");
                }
                int i4 = (readableMap.hasKey("callbackType") && readableMap.getType("callbackType") == ReadableType.Number) ? readableMap.getInt("callbackType") : 1;
                if (readableMap.hasKey("legacyScan") && readableMap.getType("legacyScan") == ReadableType.Boolean) {
                    z2 = readableMap.getBoolean("legacyScan");
                }
                z = z2;
                i2 = i3;
                i = i4;
            } else {
                i = 1;
                z = true;
                i2 = 0;
            }
            this.bleAdapter.startDeviceScan(readableArray != null ? ReadableArrayConverter.toStringArray(readableArray) : null, i2, i, z, new OnEventCallback<ScanResult>() { // from class: com.bleplx.BlePlxModule.7
                @Override // com.bleplx.adapter.OnEventCallback
                public void onEvent(ScanResult scanResult) {
                    BlePlxModule.this.sendEvent(Event.ScanEvent, BlePlxModule.this.scanResultConverter.toJSCallback(scanResult));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.8
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.sendEvent(Event.ScanEvent, BlePlxModule.this.errorConverter.toJSCallback(bleError));
                }
            });
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void stopDeviceScan(Promise promise) {
        if (isRequestPossibleHandler("stopDeviceScan", promise)) {
            this.bleAdapter.stopDeviceScan();
            promise.resolve(null);
        }
    }

    @ReactMethod
    public void devices(ReadableArray readableArray, final Promise promise) {
        if (isRequestPossibleHandler("devices", promise)) {
            this.bleAdapter.getKnownDevices(ReadableArrayConverter.toStringArray(readableArray), new OnSuccessCallback<Device[]>() { // from class: com.bleplx.BlePlxModule.9
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Device[] deviceArr) {
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    for (Device device : deviceArr) {
                        writableArrayCreateArray.pushMap(BlePlxModule.this.deviceConverter.toJSObject(device));
                    }
                    promise.resolve(writableArrayCreateArray);
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.10
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void connectedDevices(ReadableArray readableArray, final Promise promise) {
        if (isRequestPossibleHandler("connectedDevices", promise)) {
            this.bleAdapter.getConnectedDevices(ReadableArrayConverter.toStringArray(readableArray), new OnSuccessCallback<Device[]>() { // from class: com.bleplx.BlePlxModule.11
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Device[] deviceArr) {
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    for (Device device : deviceArr) {
                        writableArrayCreateArray.pushMap(BlePlxModule.this.deviceConverter.toJSObject(device));
                    }
                    promise.resolve(writableArrayCreateArray);
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.12
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void requestConnectionPriorityForDevice(String str, int i, String str2, Promise promise) {
        if (isRequestPossibleHandler("requestConnectionPriorityForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.requestConnectionPriorityForDevice(str, i, str2, new OnSuccessCallback<Device>() { // from class: com.bleplx.BlePlxModule.13
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.14
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void requestMTUForDevice(String str, int i, String str2, Promise promise) {
        if (isRequestPossibleHandler("requestMTUForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.requestMTUForDevice(str, i, str2, new OnSuccessCallback<Device>() { // from class: com.bleplx.BlePlxModule.15
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.16
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readRSSIForDevice(String str, String str2, Promise promise) {
        if (isRequestPossibleHandler("readRSSIForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.readRSSIForDevice(str, str2, new OnSuccessCallback<Device>() { // from class: com.bleplx.BlePlxModule.17
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.18
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void connectToDevice(final String str, ReadableMap readableMap, Promise promise) {
        Integer num;
        RefreshGattMoment refreshGattMoment;
        int i;
        int i2;
        if (isRequestPossibleHandler("connectToDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            boolean z = false;
            i = 0;
            int i3 = 0;
            if (readableMap != null) {
                boolean z2 = (readableMap.hasKey(ConnectionComponent.NamedBooleans.AUTO_CONNECT) && readableMap.getType(ConnectionComponent.NamedBooleans.AUTO_CONNECT) == ReadableType.Boolean) ? readableMap.getBoolean(ConnectionComponent.NamedBooleans.AUTO_CONNECT) : false;
                int i4 = (readableMap.hasKey("requestMTU") && readableMap.getType("requestMTU") == ReadableType.Number) ? readableMap.getInt("requestMTU") : 0;
                RefreshGattMoment byName = (readableMap.hasKey("refreshGatt") && readableMap.getType("refreshGatt") == ReadableType.String) ? RefreshGattMoment.getByName(readableMap.getString("refreshGatt")) : null;
                Integer numValueOf = (readableMap.hasKey(ClientComponent.NamedSchedulers.TIMEOUT) && readableMap.getType(ClientComponent.NamedSchedulers.TIMEOUT) == ReadableType.Number) ? Integer.valueOf(readableMap.getInt(ClientComponent.NamedSchedulers.TIMEOUT)) : null;
                if (readableMap.hasKey("connectionPriority") && readableMap.getType("connectionPriority") == ReadableType.Number) {
                    i3 = readableMap.getInt("connectionPriority");
                }
                i2 = i3;
                z = z2;
                num = numValueOf;
                refreshGattMoment = byName;
                i = i4;
            } else {
                num = null;
                refreshGattMoment = null;
                i = 0;
                i2 = 0;
            }
            this.bleAdapter.connectToDevice(str, new ConnectionOptions(Boolean.valueOf(z), i, refreshGattMoment, num != null ? Long.valueOf(num.longValue()) : null, i2), new OnSuccessCallback<Device>() { // from class: com.bleplx.BlePlxModule.19
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnEventCallback<ConnectionState>() { // from class: com.bleplx.BlePlxModule.20
                @Override // com.bleplx.adapter.OnEventCallback
                public void onEvent(ConnectionState connectionState) {
                    if (connectionState == ConnectionState.DISCONNECTED) {
                        WritableArray writableArrayCreateArray = Arguments.createArray();
                        writableArrayCreateArray.pushNull();
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putString("id", str);
                        writableArrayCreateArray.pushMap(writableMapCreateMap);
                        BlePlxModule.this.sendEvent(Event.DisconnectionEvent, writableArrayCreateArray);
                    }
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.21
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void cancelDeviceConnection(String str, Promise promise) {
        if (isRequestPossibleHandler("cancelDeviceConnection", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.cancelDeviceConnection(str, new OnSuccessCallback<Device>() { // from class: com.bleplx.BlePlxModule.22
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.23
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void isDeviceConnected(String str, final Promise promise) {
        if (isRequestPossibleHandler("isDeviceConnected", promise)) {
            this.bleAdapter.isDeviceConnected(str, new OnSuccessCallback<Boolean>() { // from class: com.bleplx.BlePlxModule.24
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Boolean bool) {
                    promise.resolve(bool);
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.25
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void discoverAllServicesAndCharacteristicsForDevice(String str, String str2, Promise promise) {
        if (isRequestPossibleHandler("discoverAllServicesAndCharacteristicsForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.discoverAllServicesAndCharacteristicsForDevice(str, str2, new OnSuccessCallback<Device>() { // from class: com.bleplx.BlePlxModule.26
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Device device) {
                    safePromise.resolve(BlePlxModule.this.deviceConverter.toJSObject(device));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.27
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void servicesForDevice(String str, Promise promise) {
        if (isRequestPossibleHandler("servicesForDevice", promise)) {
            try {
                List<Service> servicesForDevice = this.bleAdapter.getServicesForDevice(str);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Iterator<Service> it = servicesForDevice.iterator();
                while (it.hasNext()) {
                    writableArrayCreateArray.pushMap(this.serviceConverter.toJSObject(it.next()));
                }
                promise.resolve(writableArrayCreateArray);
            } catch (BleError e) {
                rejectWithBleError(promise, e);
            }
        }
    }

    @ReactMethod
    public void characteristicsForDevice(String str, String str2, Promise promise) {
        if (isRequestPossibleHandler("characteristicsForDevice", promise)) {
            try {
                List<Characteristic> characteristicsForDevice = this.bleAdapter.getCharacteristicsForDevice(str, str2);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Iterator<Characteristic> it = characteristicsForDevice.iterator();
                while (it.hasNext()) {
                    writableArrayCreateArray.pushMap(this.characteristicConverter.toJSObject(it.next()));
                }
                promise.resolve(writableArrayCreateArray);
            } catch (BleError e) {
                rejectWithBleError(promise, e);
            }
        }
    }

    @ReactMethod
    public void characteristicsForService(int i, Promise promise) {
        if (isRequestPossibleHandler("characteristicsForService", promise)) {
            try {
                List<Characteristic> characteristicsForService = this.bleAdapter.getCharacteristicsForService(i);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Iterator<Characteristic> it = characteristicsForService.iterator();
                while (it.hasNext()) {
                    writableArrayCreateArray.pushMap(this.characteristicConverter.toJSObject(it.next()));
                }
                promise.resolve(writableArrayCreateArray);
            } catch (BleError e) {
                rejectWithBleError(promise, e);
            }
        }
    }

    @ReactMethod
    public void descriptorsForDevice(String str, String str2, String str3, Promise promise) {
        if (isRequestPossibleHandler("descriptorsForDevice", promise)) {
            try {
                List<Descriptor> listDescriptorsForDevice = this.bleAdapter.descriptorsForDevice(str, str2, str3);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Iterator<Descriptor> it = listDescriptorsForDevice.iterator();
                while (it.hasNext()) {
                    writableArrayCreateArray.pushMap(this.descriptorConverter.toJSObject(it.next()));
                }
                promise.resolve(writableArrayCreateArray);
            } catch (BleError e) {
                rejectWithBleError(promise, e);
            }
        }
    }

    @ReactMethod
    public void descriptorsForService(int i, String str, Promise promise) {
        if (isRequestPossibleHandler("descriptorsForService", promise)) {
            try {
                List<Descriptor> listDescriptorsForService = this.bleAdapter.descriptorsForService(i, str);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Iterator<Descriptor> it = listDescriptorsForService.iterator();
                while (it.hasNext()) {
                    writableArrayCreateArray.pushMap(this.descriptorConverter.toJSObject(it.next()));
                }
                promise.resolve(writableArrayCreateArray);
            } catch (BleError e) {
                rejectWithBleError(promise, e);
            }
        }
    }

    @ReactMethod
    public void descriptorsForCharacteristic(int i, Promise promise) {
        if (isRequestPossibleHandler("descriptorsForCharacteristic", promise)) {
            try {
                List<Descriptor> listDescriptorsForCharacteristic = this.bleAdapter.descriptorsForCharacteristic(i);
                WritableArray writableArrayCreateArray = Arguments.createArray();
                Iterator<Descriptor> it = listDescriptorsForCharacteristic.iterator();
                while (it.hasNext()) {
                    writableArrayCreateArray.pushMap(this.descriptorConverter.toJSObject(it.next()));
                }
                promise.resolve(writableArrayCreateArray);
            } catch (BleError e) {
                rejectWithBleError(promise, e);
            }
        }
    }

    @ReactMethod
    public void writeCharacteristicForDevice(String str, String str2, String str3, String str4, Boolean bool, String str5, Promise promise) {
        if (isRequestPossibleHandler("writeCharacteristicForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.writeCharacteristicForDevice(str, str2, str3, str4, bool.booleanValue(), str5, new OnSuccessCallback<Characteristic>() { // from class: com.bleplx.BlePlxModule.28
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.29
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void writeCharacteristicForService(int i, String str, String str2, Boolean bool, String str3, Promise promise) {
        if (isRequestPossibleHandler("writeCharacteristicForService", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.writeCharacteristicForService(i, str, str2, bool.booleanValue(), str3, new OnSuccessCallback<Characteristic>() { // from class: com.bleplx.BlePlxModule.30
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.31
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void writeCharacteristic(int i, String str, Boolean bool, String str2, Promise promise) {
        if (isRequestPossibleHandler("writeCharacteristic", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.writeCharacteristic(i, str, bool.booleanValue(), str2, new OnSuccessCallback<Characteristic>() { // from class: com.bleplx.BlePlxModule.32
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.33
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readCharacteristicForDevice(String str, String str2, String str3, String str4, Promise promise) {
        if (isRequestPossibleHandler("readCharacteristicForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.readCharacteristicForDevice(str, str2, str3, str4, new OnSuccessCallback<Characteristic>() { // from class: com.bleplx.BlePlxModule.34
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.35
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readCharacteristicForService(int i, String str, String str2, Promise promise) {
        if (isRequestPossibleHandler("readCharacteristicForService", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.readCharacteristicForService(i, str, str2, new OnSuccessCallback<Characteristic>() { // from class: com.bleplx.BlePlxModule.36
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.37
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readCharacteristic(int i, String str, Promise promise) {
        if (isRequestPossibleHandler("readCharacteristic", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.readCharacteristic(i, str, new OnSuccessCallback<Characteristic>() { // from class: com.bleplx.BlePlxModule.38
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Characteristic characteristic) {
                    safePromise.resolve(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.39
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void monitorCharacteristicForDevice(String str, String str2, String str3, final String str4, String str5, Promise promise) {
        if (isRequestPossibleHandler("monitorCharacteristicForDevice", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.monitorCharacteristicForDevice(str, str2, str3, str4, str5, new OnEventCallback<Characteristic>() { // from class: com.bleplx.BlePlxModule.40
                @Override // com.bleplx.adapter.OnEventCallback
                public void onEvent(Characteristic characteristic) {
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    writableArrayCreateArray.pushNull();
                    writableArrayCreateArray.pushMap(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                    writableArrayCreateArray.pushString(str4);
                    BlePlxModule.this.sendEvent(Event.ReadEvent, writableArrayCreateArray);
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.41
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void monitorCharacteristicForService(int i, String str, final String str2, String str3, Promise promise) {
        if (isRequestPossibleHandler("monitorCharacteristicForService", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.monitorCharacteristicForService(i, str, str2, str3, new OnEventCallback<Characteristic>() { // from class: com.bleplx.BlePlxModule.42
                @Override // com.bleplx.adapter.OnEventCallback
                public void onEvent(Characteristic characteristic) {
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    writableArrayCreateArray.pushNull();
                    writableArrayCreateArray.pushMap(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                    writableArrayCreateArray.pushString(str2);
                    BlePlxModule.this.sendEvent(Event.ReadEvent, writableArrayCreateArray);
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.43
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void monitorCharacteristic(int i, final String str, String str2, Promise promise) {
        if (isRequestPossibleHandler("monitorCharacteristic", promise)) {
            final SafePromise safePromise = new SafePromise(promise);
            this.bleAdapter.monitorCharacteristic(i, str, str2, new OnEventCallback<Characteristic>() { // from class: com.bleplx.BlePlxModule.44
                @Override // com.bleplx.adapter.OnEventCallback
                public void onEvent(Characteristic characteristic) {
                    WritableArray writableArrayCreateArray = Arguments.createArray();
                    writableArrayCreateArray.pushNull();
                    writableArrayCreateArray.pushMap(BlePlxModule.this.characteristicConverter.toJSObject(characteristic));
                    writableArrayCreateArray.pushString(str);
                    BlePlxModule.this.sendEvent(Event.ReadEvent, writableArrayCreateArray);
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.45
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    safePromise.reject(BlePlxModule.this.getErrorCode(bleError), BlePlxModule.this.errorConverter.toJs(bleError));
                }
            });
        }
    }

    @ReactMethod
    public void readDescriptorForDevice(String str, String str2, String str3, String str4, String str5, final Promise promise) {
        if (isRequestPossibleHandler("readDescriptorForDevice", promise)) {
            this.bleAdapter.readDescriptorForDevice(str, str2, str3, str4, str5, new OnSuccessCallback<Descriptor>() { // from class: com.bleplx.BlePlxModule.46
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.47
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void readDescriptorForService(int i, String str, String str2, String str3, final Promise promise) {
        if (isRequestPossibleHandler("readDescriptorForService", promise)) {
            this.bleAdapter.readDescriptorForService(i, str, str2, str3, new OnSuccessCallback<Descriptor>() { // from class: com.bleplx.BlePlxModule.48
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.49
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void readDescriptorForCharacteristic(int i, String str, String str2, final Promise promise) {
        if (isRequestPossibleHandler("readDescriptorForCharacteristic", promise)) {
            this.bleAdapter.readDescriptorForCharacteristic(i, str, str2, new OnSuccessCallback<Descriptor>() { // from class: com.bleplx.BlePlxModule.50
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.51
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void readDescriptor(int i, String str, final Promise promise) {
        if (isRequestPossibleHandler("readDescriptor", promise)) {
            this.bleAdapter.readDescriptor(i, str, new OnSuccessCallback<Descriptor>() { // from class: com.bleplx.BlePlxModule.52
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.53
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void writeDescriptorForDevice(String str, String str2, String str3, String str4, String str5, String str6, final Promise promise) {
        if (isRequestPossibleHandler("writeDescriptorForDevice", promise)) {
            this.bleAdapter.writeDescriptorForDevice(str, str2, str3, str4, str5, str6, new OnSuccessCallback<Descriptor>() { // from class: com.bleplx.BlePlxModule.54
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.55
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void writeDescriptorForService(int i, String str, String str2, String str3, String str4, final Promise promise) {
        if (isRequestPossibleHandler("writeDescriptorForService", promise)) {
            this.bleAdapter.writeDescriptorForService(i, str, str2, str3, str4, new OnSuccessCallback<Descriptor>() { // from class: com.bleplx.BlePlxModule.56
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.57
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void writeDescriptorForCharacteristic(int i, String str, String str2, String str3, final Promise promise) {
        if (isRequestPossibleHandler("writeDescriptorForCharacteristic", promise)) {
            this.bleAdapter.writeDescriptorForCharacteristic(i, str, str2, str3, new OnSuccessCallback<Descriptor>() { // from class: com.bleplx.BlePlxModule.58
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.59
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    @ReactMethod
    public void writeDescriptor(int i, String str, String str2, final Promise promise) {
        if (isRequestPossibleHandler("writeDescriptor", promise)) {
            this.bleAdapter.writeDescriptor(i, str, str2, new OnSuccessCallback<Descriptor>() { // from class: com.bleplx.BlePlxModule.60
                @Override // com.bleplx.adapter.OnSuccessCallback
                public void onSuccess(Descriptor descriptor) {
                    promise.resolve(BlePlxModule.this.descriptorConverter.toJSObject(descriptor));
                }
            }, new OnErrorCallback() { // from class: com.bleplx.BlePlxModule.61
                @Override // com.bleplx.adapter.OnErrorCallback
                public void onError(BleError bleError) {
                    BlePlxModule.this.rejectWithBleError(promise, bleError);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rejectWithBleError(Promise promise, BleError bleError) {
        String js = this.errorConverter.toJs(bleError);
        String errorCode = getErrorCode(bleError);
        if (js == null) {
            js = "";
        }
        promise.reject(errorCode, js);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getErrorCode(BleError bleError) {
        if (bleError == null || bleError.errorCode == null) {
            return ErrorDefaults.CODE;
        }
        return bleError.errorCode.name();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(Event event, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(event.name, obj);
    }

    private boolean isRequestPossibleHandler(String str, Promise promise) {
        if (this.bleAdapter != null) {
            return true;
        }
        rejectWithBleError(promise, new BleError(BleErrorCode.BluetoothManagerDestroyed, String.format("BleManager cannot call the %s function because BleManager has been destroyed", str), null));
        return false;
    }
}
