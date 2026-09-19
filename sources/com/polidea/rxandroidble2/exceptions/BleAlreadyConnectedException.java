package com.polidea.rxandroidble2.exceptions;

/* JADX INFO: loaded from: classes4.dex */
public class BleAlreadyConnectedException extends BleException {
    public BleAlreadyConnectedException(String str) {
        super("Already connected to device with MAC address " + str);
    }
}
