package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import com.polidea.rxandroidble2.exceptions.BleConflictingNotificationAlreadySetException;
import com.polidea.rxandroidble2.internal.util.ActiveCharacteristicNotification;
import com.polidea.rxandroidble2.internal.util.CharacteristicChangedEvent;
import com.polidea.rxandroidble2.internal.util.CharacteristicNotificationId;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.CompletableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.internal.functions.Functions;
import io.reactivex.subjects.PublishSubject;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
@ConnectionScope
class NotificationAndIndicationManager {
    static final UUID CLIENT_CHARACTERISTIC_CONFIG_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    final Map<CharacteristicNotificationId, ActiveCharacteristicNotification> activeNotificationObservableMap = new HashMap();
    final BluetoothGatt bluetoothGatt;
    final byte[] configDisable;
    final byte[] configEnableIndication;
    final byte[] configEnableNotification;
    final DescriptorWriter descriptorWriter;
    final RxBleGattCallback gattCallback;

    @Inject
    NotificationAndIndicationManager(@Named(ClientComponent.BluetoothConstants.ENABLE_NOTIFICATION_VALUE) byte[] bArr, @Named(ClientComponent.BluetoothConstants.ENABLE_INDICATION_VALUE) byte[] bArr2, @Named(ClientComponent.BluetoothConstants.DISABLE_NOTIFICATION_VALUE) byte[] bArr3, BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, DescriptorWriter descriptorWriter) {
        this.configEnableNotification = bArr;
        this.configEnableIndication = bArr2;
        this.configDisable = bArr3;
        this.bluetoothGatt = bluetoothGatt;
        this.gattCallback = rxBleGattCallback;
        this.descriptorWriter = descriptorWriter;
    }

    Observable<Observable<byte[]>> setupServerInitiatedCharacteristicRead(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final NotificationSetupMode notificationSetupMode, final boolean z) {
        return Observable.defer(new Callable() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.m1278xff447fe3(bluetoothGattCharacteristic, z, notificationSetupMode);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$setupServerInitiatedCharacteristicRead$2$com-polidea-rxandroidble2-internal-connection-NotificationAndIndicationManager, reason: not valid java name */
    /* synthetic */ ObservableSource m1278xff447fe3(final BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z, final NotificationSetupMode notificationSetupMode) throws Exception {
        Throwable th;
        synchronized (this.activeNotificationObservableMap) {
            try {
                try {
                    final CharacteristicNotificationId characteristicNotificationId = new CharacteristicNotificationId(bluetoothGattCharacteristic.getUuid(), Integer.valueOf(bluetoothGattCharacteristic.getInstanceId()));
                    ActiveCharacteristicNotification activeCharacteristicNotification = this.activeNotificationObservableMap.get(characteristicNotificationId);
                    try {
                        if (activeCharacteristicNotification != null) {
                            if (activeCharacteristicNotification.isIndication == z) {
                                return activeCharacteristicNotification.notificationObservable;
                            }
                            return Observable.error(new BleConflictingNotificationAlreadySetException(bluetoothGattCharacteristic.getUuid(), !z));
                        }
                        byte[] bArr = z ? this.configEnableIndication : this.configEnableNotification;
                        final PublishSubject publishSubjectCreate = PublishSubject.create();
                        Observable observableRefCount = setCharacteristicNotification(this.bluetoothGatt, bluetoothGattCharacteristic, true).andThen(ObservableUtil.justOnNext(observeOnCharacteristicChangeCallbacks(this.gattCallback, characteristicNotificationId))).compose(setupModeTransformer(this.descriptorWriter, bluetoothGattCharacteristic, bArr, notificationSetupMode)).map(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda8
                            @Override // io.reactivex.functions.Function
                            public final Object apply(Object obj) {
                                PublishSubject publishSubject = publishSubjectCreate;
                                return Observable.amb(Arrays.asList(publishSubject.cast(byte[].class), ((Observable) obj).takeUntil(publishSubject)));
                            }
                        }).doFinally(new Action() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda9
                            @Override // io.reactivex.functions.Action
                            public final void run() throws Exception {
                                this.f$0.m1277x21511a04(publishSubjectCreate, characteristicNotificationId, bluetoothGattCharacteristic, notificationSetupMode);
                            }
                        }).mergeWith(this.gattCallback.observeDisconnect()).replay(1).refCount();
                        this.activeNotificationObservableMap.put(characteristicNotificationId, new ActiveCharacteristicNotification(observableRefCount, z));
                        return observableRefCount;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    th = th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: lambda$setupServerInitiatedCharacteristicRead$1$com-polidea-rxandroidble2-internal-connection-NotificationAndIndicationManager, reason: not valid java name */
    /* synthetic */ void m1277x21511a04(PublishSubject publishSubject, CharacteristicNotificationId characteristicNotificationId, BluetoothGattCharacteristic bluetoothGattCharacteristic, NotificationSetupMode notificationSetupMode) throws Exception {
        publishSubject.onComplete();
        synchronized (this.activeNotificationObservableMap) {
            this.activeNotificationObservableMap.remove(characteristicNotificationId);
        }
        setCharacteristicNotification(this.bluetoothGatt, bluetoothGattCharacteristic, false).compose(teardownModeTransformer(this.descriptorWriter, bluetoothGattCharacteristic, this.configDisable, notificationSetupMode)).subscribe(Functions.EMPTY_ACTION, Functions.emptyConsumer());
    }

    static Completable setCharacteristicNotification(final BluetoothGatt bluetoothGatt, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final boolean z) {
        return Completable.fromAction(new Action() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda5
            @Override // io.reactivex.functions.Action
            public final void run() throws Exception {
                NotificationAndIndicationManager.lambda$setCharacteristicNotification$3(bluetoothGatt, bluetoothGattCharacteristic, z);
            }
        });
    }

    static /* synthetic */ void lambda$setCharacteristicNotification$3(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) throws Exception {
        if (!bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z)) {
            throw new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode;

        static {
            int[] iArr = new int[NotificationSetupMode.values().length];
            $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode = iArr;
            try {
                iArr[NotificationSetupMode.COMPAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[NotificationSetupMode.QUICK_SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[NotificationSetupMode.DEFAULT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static ObservableTransformer<Observable<byte[]>, Observable<byte[]>> setupModeTransformer(final DescriptorWriter descriptorWriter, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final NotificationSetupMode notificationSetupMode) {
        return new ObservableTransformer() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda3
            @Override // io.reactivex.ObservableTransformer
            /* JADX INFO: renamed from: apply */
            public final ObservableSource apply2(Observable observable) {
                return NotificationAndIndicationManager.lambda$setupModeTransformer$5(notificationSetupMode, bluetoothGattCharacteristic, descriptorWriter, bArr, observable);
            }
        };
    }

    static /* synthetic */ ObservableSource lambda$setupModeTransformer$5(NotificationSetupMode notificationSetupMode, BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter, byte[] bArr, Observable observable) {
        int i = AnonymousClass1.$SwitchMap$com$polidea$rxandroidble2$NotificationSetupMode[notificationSetupMode.ordinal()];
        if (i == 1) {
            return observable;
        }
        if (i == 2) {
            final Completable completableIgnoreElements = writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter, bArr).toObservable().publish().autoConnect(2).ignoreElements();
            return observable.mergeWith(completableIgnoreElements).map(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda2
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return ((Observable) obj).mergeWith(completableIgnoreElements.onErrorComplete());
                }
            });
        }
        return writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter, bArr).andThen(observable);
    }

    static CompletableTransformer teardownModeTransformer(final DescriptorWriter descriptorWriter, final BluetoothGattCharacteristic bluetoothGattCharacteristic, final byte[] bArr, final NotificationSetupMode notificationSetupMode) {
        return new CompletableTransformer() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda7
            @Override // io.reactivex.CompletableTransformer
            public final CompletableSource apply(Completable completable) {
                return NotificationAndIndicationManager.lambda$teardownModeTransformer$6(notificationSetupMode, bluetoothGattCharacteristic, descriptorWriter, bArr, completable);
            }
        };
    }

    static /* synthetic */ CompletableSource lambda$teardownModeTransformer$6(NotificationSetupMode notificationSetupMode, BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter, byte[] bArr, Completable completable) {
        return notificationSetupMode == NotificationSetupMode.COMPAT ? completable : completable.andThen(writeClientCharacteristicConfig(bluetoothGattCharacteristic, descriptorWriter, bArr));
    }

    static Observable<byte[]> observeOnCharacteristicChangeCallbacks(RxBleGattCallback rxBleGattCallback, final CharacteristicNotificationId characteristicNotificationId) {
        return rxBleGattCallback.getOnCharacteristicChanged().filter(new Predicate() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                return ((CharacteristicChangedEvent) obj).equals(characteristicNotificationId);
            }
        }).map(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return ((CharacteristicChangedEvent) obj).data;
            }
        });
    }

    static Completable writeClientCharacteristicConfig(final BluetoothGattCharacteristic bluetoothGattCharacteristic, DescriptorWriter descriptorWriter, byte[] bArr) {
        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIG_UUID);
        if (descriptor == null) {
            return Completable.error(new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 2, null));
        }
        return descriptorWriter.writeDescriptor(descriptor, bArr).onErrorResumeNext(new Function() { // from class: com.polidea.rxandroidble2.internal.connection.NotificationAndIndicationManager$$ExternalSyntheticLambda6
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return Completable.error(new BleCannotSetCharacteristicNotificationException(bluetoothGattCharacteristic, 3, (Throwable) obj));
            }
        });
    }
}
