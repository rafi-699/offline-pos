package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothDevice;
import bleshadow.dagger.Lazy;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.RxBleDeviceProvider;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.operations.LegacyScanOperation;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResultLegacy;
import com.polidea.rxandroidble2.internal.scan.ScanPreconditionsVerifier;
import com.polidea.rxandroidble2.internal.scan.ScanSetup;
import com.polidea.rxandroidble2.internal.scan.ScanSetupBuilder;
import com.polidea.rxandroidble2.internal.serialization.ClientOperationQueue;
import com.polidea.rxandroidble2.internal.util.BluetoothManagerWrapper;
import com.polidea.rxandroidble2.internal.util.CheckerConnectPermission;
import com.polidea.rxandroidble2.internal.util.CheckerScanPermission;
import com.polidea.rxandroidble2.internal.util.ClientStateObservable;
import com.polidea.rxandroidble2.internal.util.LocationServicesStatus;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;
import com.polidea.rxandroidble2.scan.BackgroundScanner;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
class RxBleClientImpl extends RxBleClient {

    @Deprecated
    public static final String TAG = "RxBleClient";
    private final BackgroundScanner backgroundScanner;
    final Scheduler bluetoothInteractionScheduler;
    private final BluetoothManagerWrapper bluetoothManagerWrapper;
    private final CheckerConnectPermission checkerConnectPermission;
    private final CheckerScanPermission checkerScanPermission;
    private final ClientComponent.ClientComponentFinalizer clientComponentFinalizer;
    final Function<RxBleInternalScanResult, ScanResult> internalToExternalScanResultMapFunction;
    private final Lazy<ClientStateObservable> lazyClientStateObservable;
    private final LocationServicesStatus locationServicesStatus;
    final ClientOperationQueue operationQueue;
    final Map<Set<UUID>, Observable<RxBleScanResult>> queuedScanOperations = new HashMap();
    private final Observable<RxBleAdapterStateObservable.BleAdapterState> rxBleAdapterStateObservable;
    private final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final RxBleDeviceProvider rxBleDeviceProvider;
    final ScanPreconditionsVerifier scanPreconditionVerifier;
    private final ScanRecordParser scanRecordParser;
    final ScanSetupBuilder scanSetupBuilder;

    @Inject
    RxBleClientImpl(BluetoothManagerWrapper bluetoothManagerWrapper, RxBleAdapterWrapper rxBleAdapterWrapper, ClientOperationQueue clientOperationQueue, Observable<RxBleAdapterStateObservable.BleAdapterState> observable, ScanRecordParser scanRecordParser, LocationServicesStatus locationServicesStatus, Lazy<ClientStateObservable> lazy, RxBleDeviceProvider rxBleDeviceProvider, ScanSetupBuilder scanSetupBuilder, ScanPreconditionsVerifier scanPreconditionsVerifier, Function<RxBleInternalScanResult, ScanResult> function, @Named(ClientComponent.NamedSchedulers.BLUETOOTH_INTERACTION) Scheduler scheduler, ClientComponent.ClientComponentFinalizer clientComponentFinalizer, BackgroundScanner backgroundScanner, CheckerScanPermission checkerScanPermission, CheckerConnectPermission checkerConnectPermission) {
        this.operationQueue = clientOperationQueue;
        this.bluetoothManagerWrapper = bluetoothManagerWrapper;
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
        this.rxBleAdapterStateObservable = observable;
        this.scanRecordParser = scanRecordParser;
        this.locationServicesStatus = locationServicesStatus;
        this.lazyClientStateObservable = lazy;
        this.rxBleDeviceProvider = rxBleDeviceProvider;
        this.scanSetupBuilder = scanSetupBuilder;
        this.scanPreconditionVerifier = scanPreconditionsVerifier;
        this.internalToExternalScanResultMapFunction = function;
        this.bluetoothInteractionScheduler = scheduler;
        this.clientComponentFinalizer = clientComponentFinalizer;
        this.backgroundScanner = backgroundScanner;
        this.checkerScanPermission = checkerScanPermission;
        this.checkerConnectPermission = checkerConnectPermission;
    }

    protected void finalize() throws Throwable {
        this.clientComponentFinalizer.onFinalize();
        super.finalize();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public RxBleDevice getBleDevice(String str) {
        guardBluetoothAdapterAvailable();
        return this.rxBleDeviceProvider.getBleDevice(str);
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public Set<RxBleDevice> getBondedDevices() {
        guardBluetoothAdapterAvailable();
        HashSet hashSet = new HashSet();
        Iterator<BluetoothDevice> it = this.rxBleAdapterWrapper.getBondedDevices().iterator();
        while (it.hasNext()) {
            hashSet.add(getBleDevice(it.next().getAddress()));
        }
        return hashSet;
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public Set<RxBleDevice> getConnectedPeripherals() {
        HashSet hashSet = new HashSet();
        Iterator<BluetoothDevice> it = this.bluetoothManagerWrapper.getConnectedPeripherals().iterator();
        while (it.hasNext()) {
            hashSet.add(getBleDevice(it.next().getAddress()));
        }
        return hashSet;
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public Observable<ScanResult> scanBleDevices(final ScanSettings scanSettings, final ScanFilter... scanFilterArr) {
        return Observable.defer(new Callable() { // from class: com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1272xa3ae48c3(scanSettings, scanFilterArr);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$scanBleDevices$1$com-polidea-rxandroidble2-RxBleClientImpl, reason: not valid java name */
    /* synthetic */ ObservableSource m1272xa3ae48c3(ScanSettings scanSettings, ScanFilter[] scanFilterArr) throws Exception {
        this.scanPreconditionVerifier.verify(scanSettings.shouldCheckLocationProviderState());
        ScanSetup scanSetupBuild = this.scanSetupBuilder.build(scanSettings, scanFilterArr);
        return this.operationQueue.queue(scanSetupBuild.scanOperation).unsubscribeOn(this.bluetoothInteractionScheduler).compose(scanSetupBuild.scanOperationBehaviourEmulatorTransformer).map(this.internalToExternalScanResultMapFunction).doOnNext(new Consumer() { // from class: com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda4
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) throws Exception {
                RxBleClientImpl.lambda$scanBleDevices$0((ScanResult) obj);
            }
        }).mergeWith(bluetoothAdapterOffExceptionObservable());
    }

    static /* synthetic */ void lambda$scanBleDevices$0(ScanResult scanResult) throws Exception {
        if (RxBleLog.getShouldLogScannedPeripherals()) {
            RxBleLog.i("%s", scanResult);
        }
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public BackgroundScanner getBackgroundScanner() {
        return this.backgroundScanner;
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    @Deprecated
    public Observable<RxBleScanResult> scanBleDevices(final UUID... uuidArr) {
        return Observable.defer(new Callable() { // from class: com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1273x88efb784(uuidArr);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$scanBleDevices$2$com-polidea-rxandroidble2-RxBleClientImpl, reason: not valid java name */
    /* synthetic */ ObservableSource m1273x88efb784(UUID[] uuidArr) throws Exception {
        this.scanPreconditionVerifier.verify(true);
        return initializeScan(uuidArr);
    }

    private Set<UUID> toDistinctSet(UUID[] uuidArr) {
        if (uuidArr == null) {
            uuidArr = new UUID[0];
        }
        return new HashSet(Arrays.asList(uuidArr));
    }

    Observable<RxBleScanResult> initializeScan(UUID[] uuidArr) {
        Observable<RxBleScanResult> observableCreateScanOperationApi18;
        Set<UUID> distinctSet = toDistinctSet(uuidArr);
        synchronized (this.queuedScanOperations) {
            observableCreateScanOperationApi18 = this.queuedScanOperations.get(distinctSet);
            if (observableCreateScanOperationApi18 == null) {
                observableCreateScanOperationApi18 = createScanOperationApi18(uuidArr);
                this.queuedScanOperations.put(distinctSet, observableCreateScanOperationApi18);
            }
        }
        return observableCreateScanOperationApi18;
    }

    <T> Observable<T> bluetoothAdapterOffExceptionObservable() {
        return this.rxBleAdapterStateObservable.filter(new Predicate() { // from class: com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return RxBleClientImpl.lambda$bluetoothAdapterOffExceptionObservable$3((RxBleAdapterStateObservable.BleAdapterState) obj);
            }
        }).firstElement().flatMap(new Function() { // from class: com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda7
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Maybe.error(new BleScanException(1));
            }
        }).toObservable();
    }

    static /* synthetic */ boolean lambda$bluetoothAdapterOffExceptionObservable$3(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) throws Exception {
        return bleAdapterState != RxBleAdapterStateObservable.BleAdapterState.STATE_ON;
    }

    RxBleScanResult convertToPublicScanResult(RxBleInternalScanResultLegacy rxBleInternalScanResultLegacy) {
        return new RxBleScanResult(getBleDevice(rxBleInternalScanResultLegacy.getBluetoothDevice().getAddress()), rxBleInternalScanResultLegacy.getRssi(), rxBleInternalScanResultLegacy.getScanRecord());
    }

    private Observable<RxBleScanResult> createScanOperationApi18(UUID[] uuidArr) {
        final Set<UUID> distinctSet = toDistinctSet(uuidArr);
        return this.operationQueue.queue(new LegacyScanOperation(uuidArr, this.rxBleAdapterWrapper, this.scanRecordParser)).doFinally(new Action() { // from class: com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                this.f$0.m1271xfe6216bb(distinctSet);
            }
        }).mergeWith(bluetoothAdapterOffExceptionObservable()).map(new Function() { // from class: com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return this.f$0.convertToPublicScanResult((RxBleInternalScanResultLegacy) obj);
            }
        }).doOnNext(new Consumer() { // from class: com.polidea.rxandroidble2.RxBleClientImpl$$ExternalSyntheticLambda2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                RxBleLog.i("%s", (RxBleScanResult) obj);
            }
        }).share();
    }

    /* JADX INFO: renamed from: lambda$createScanOperationApi18$5$com-polidea-rxandroidble2-RxBleClientImpl, reason: not valid java name */
    /* synthetic */ void m1271xfe6216bb(Set set) throws Exception {
        synchronized (this.queuedScanOperations) {
            this.queuedScanOperations.remove(set);
        }
    }

    private void guardBluetoothAdapterAvailable() {
        if (!this.rxBleAdapterWrapper.hasBluetoothAdapter()) {
            throw new UnsupportedOperationException("RxAndroidBle library needs a BluetoothAdapter to be available in the system to work. If this is a test on an emulator then you can use 'https://github.com/Polidea/RxAndroidBle/tree/master/mockrxandroidble'");
        }
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public Observable<RxBleClient.State> observeStateChanges() {
        return this.lazyClientStateObservable.get();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public RxBleClient.State getState() {
        if (!this.rxBleAdapterWrapper.hasBluetoothAdapter()) {
            return RxBleClient.State.BLUETOOTH_NOT_AVAILABLE;
        }
        if (!this.locationServicesStatus.isLocationPermissionOk()) {
            return RxBleClient.State.LOCATION_PERMISSION_NOT_GRANTED;
        }
        if (!this.rxBleAdapterWrapper.isBluetoothEnabled()) {
            return RxBleClient.State.BLUETOOTH_NOT_ENABLED;
        }
        if (!this.locationServicesStatus.isLocationProviderOk()) {
            return RxBleClient.State.LOCATION_SERVICES_NOT_ENABLED;
        }
        return RxBleClient.State.READY;
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public boolean isScanRuntimePermissionGranted() {
        return this.checkerScanPermission.isScanRuntimePermissionGranted();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public boolean isConnectRuntimePermissionGranted() {
        return this.checkerConnectPermission.isConnectRuntimePermissionGranted();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public String[] getRecommendedScanRuntimePermissions() {
        return this.checkerScanPermission.getRecommendedScanRuntimePermissions();
    }

    @Override // com.polidea.rxandroidble2.RxBleClient
    public String[] getRecommendedConnectRuntimePermissions() {
        return this.checkerConnectPermission.getRecommendedConnectRuntimePermissions();
    }
}
