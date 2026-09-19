package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothDevice;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes4.dex */
public interface RxBleDevice {
    Observable<RxBleConnection> establishConnection(boolean z);

    Observable<RxBleConnection> establishConnection(boolean z, Timeout timeout);

    BluetoothDevice getBluetoothDevice();

    RxBleConnection.RxBleConnectionState getConnectionState();

    String getMacAddress();

    String getName();

    Observable<RxBleConnection.RxBleConnectionState> observeConnectionStateChanges();
}
