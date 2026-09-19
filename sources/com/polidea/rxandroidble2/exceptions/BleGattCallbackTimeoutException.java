package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothGatt;

/* JADX INFO: loaded from: classes4.dex */
public class BleGattCallbackTimeoutException extends BleGattException {
    public BleGattCallbackTimeoutException(BluetoothGatt bluetoothGatt, BleGattOperationType bleGattOperationType) {
        super(bluetoothGatt, bleGattOperationType);
    }
}
