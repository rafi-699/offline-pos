package com.bleplx.adapter.utils;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.RxBleCustomOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class RefreshGattCustomOperation implements RxBleCustomOperation<Boolean> {
    @Override // com.polidea.rxandroidble2.RxBleCustomOperation
    public Observable<Boolean> asObservable(final BluetoothGatt bluetoothGatt, RxBleGattCallback rxBleGattCallback, Scheduler scheduler) {
        return Observable.ambArray(Observable.fromCallable(new Callable() { // from class: com.bleplx.adapter.utils.RefreshGattCustomOperation$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return RefreshGattCustomOperation.lambda$asObservable$0(bluetoothGatt);
            }
        }).subscribeOn(scheduler).delay(1L, TimeUnit.SECONDS, scheduler), rxBleGattCallback.observeDisconnect());
    }

    static /* synthetic */ Boolean lambda$asObservable$0(BluetoothGatt bluetoothGatt) throws Exception {
        boolean zBooleanValue;
        try {
            zBooleanValue = ((Boolean) bluetoothGatt.getClass().getMethod("refresh", new Class[0]).invoke(bluetoothGatt, new Object[0])).booleanValue();
            if (!zBooleanValue) {
                try {
                    RxBleLog.d("BluetoothGatt.refresh() returned false", new Object[0]);
                } catch (Exception e) {
                    e = e;
                    RxBleLog.d(e, "Could not call function BluetoothGatt.refresh()", new Object[0]);
                }
            }
        } catch (Exception e2) {
            e = e2;
            zBooleanValue = false;
        }
        RxBleLog.i("Calling BluetoothGatt.refresh() status: %s", zBooleanValue ? "Success" : "Failure");
        return Boolean.valueOf(zBooleanValue);
    }
}
