package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.le.ScanResult;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.scan.IsConnectable;

/* JADX INFO: loaded from: classes4.dex */
public class IsConnectableCheckerApi26 implements IsConnectableChecker {
    @Inject
    public IsConnectableCheckerApi26() {
    }

    @Override // com.polidea.rxandroidble2.internal.scan.IsConnectableChecker
    public IsConnectable check(ScanResult scanResult) {
        return scanResult.isConnectable() ? IsConnectable.CONNECTABLE : IsConnectable.NOT_CONNECTABLE;
    }
}
