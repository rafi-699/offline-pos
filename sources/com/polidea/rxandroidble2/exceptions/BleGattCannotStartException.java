package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothGatt;

/* JADX INFO: loaded from: classes4.dex */
public class BleGattCannotStartException extends BleGattException {
    @Deprecated
    public BleGattCannotStartException(BleGattOperationType bleGattOperationType) {
        super((BluetoothGatt) null, bleGattOperationType);
    }

    public BleGattCannotStartException(BluetoothGatt bluetoothGatt, BleGattOperationType bleGattOperationType) {
        super(bluetoothGatt, bleGattOperationType);
    }
}
