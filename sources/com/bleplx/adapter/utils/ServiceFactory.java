package com.bleplx.adapter.utils;

import android.bluetooth.BluetoothGattService;
import com.bleplx.adapter.Service;

/* JADX INFO: loaded from: classes2.dex */
public class ServiceFactory {
    public Service create(String str, BluetoothGattService bluetoothGattService) {
        return new Service(IdGenerator.getIdForKey(new IdGeneratorKey(str, bluetoothGattService.getUuid(), bluetoothGattService.getInstanceId())), str, bluetoothGattService);
    }
}
