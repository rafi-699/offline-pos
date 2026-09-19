package com.bleplx.adapter.exceptions;

import com.bleplx.adapter.Characteristic;

/* JADX INFO: loaded from: classes2.dex */
public class CannotMonitorCharacteristicException extends RuntimeException {
    private Characteristic characteristic;

    public CannotMonitorCharacteristicException(Characteristic characteristic) {
        this.characteristic = characteristic;
    }

    public Characteristic getCharacteristic() {
        return this.characteristic;
    }
}
