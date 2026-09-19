package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;

/* JADX INFO: loaded from: classes4.dex */
public class BleGattDescriptorException extends BleGattException {
    public final BluetoothGattDescriptor descriptor;

    public BleGattDescriptorException(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i, BleGattOperationType bleGattOperationType) {
        super(bluetoothGatt, i, bleGattOperationType);
        this.descriptor = bluetoothGattDescriptor;
    }
}
