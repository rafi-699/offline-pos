package com.polidea.rxandroidble2.internal.scan;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class EmulatedScanFilterMatcher {
    private final boolean isEmpty;
    private final ScanFilterInterface[] scanFilters;

    public EmulatedScanFilterMatcher(ScanFilterInterface... scanFilterInterfaceArr) {
        boolean z;
        this.scanFilters = scanFilterInterfaceArr;
        if (scanFilterInterfaceArr == null || scanFilterInterfaceArr.length == 0) {
            z = true;
        } else {
            z = false;
            for (ScanFilterInterface scanFilterInterface : scanFilterInterfaceArr) {
                if (scanFilterInterface.isAllFieldsEmpty()) {
                }
            }
            z = true;
        }
        this.isEmpty = z;
    }

    public boolean matches(RxBleInternalScanResult rxBleInternalScanResult) {
        ScanFilterInterface[] scanFilterInterfaceArr = this.scanFilters;
        if (scanFilterInterfaceArr == null || scanFilterInterfaceArr.length == 0) {
            return true;
        }
        for (ScanFilterInterface scanFilterInterface : scanFilterInterfaceArr) {
            if (scanFilterInterface.matches(rxBleInternalScanResult)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        return "emulatedFilters=" + Arrays.toString(this.scanFilters);
    }
}
