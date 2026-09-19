package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.ScanResultInterface;

/* JADX INFO: loaded from: classes4.dex */
public interface ScanFilterInterface {
    boolean isAllFieldsEmpty();

    boolean matches(ScanResultInterface scanResultInterface);
}
