package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientComponent;
import com.polidea.rxandroidble2.ClientScope;

/* JADX INFO: loaded from: classes4.dex */
@ClientScope
public class CheckerScanPermission {
    private final CheckerPermission checkerPermission;
    private final String[][] scanPermissions;

    @Inject
    CheckerScanPermission(CheckerPermission checkerPermission, @Named(ClientComponent.PlatformConstants.STRING_ARRAY_SCAN_PERMISSIONS) String[][] strArr) {
        this.checkerPermission = checkerPermission;
        this.scanPermissions = strArr;
    }

    public boolean isScanRuntimePermissionGranted() {
        boolean zIsAnyPermissionGranted = true;
        for (String[] strArr : this.scanPermissions) {
            zIsAnyPermissionGranted &= this.checkerPermission.isAnyPermissionGranted(strArr);
        }
        return zIsAnyPermissionGranted;
    }

    public String[] getRecommendedScanRuntimePermissions() {
        int length = 0;
        for (String[] strArr : this.scanPermissions) {
            length += strArr.length;
        }
        String[] strArr2 = new String[length];
        int i = 0;
        for (String[] strArr3 : this.scanPermissions) {
            int length2 = strArr3.length;
            int i2 = 0;
            while (i2 < length2) {
                strArr2[i] = strArr3[i2];
                i2++;
                i++;
            }
        }
        return strArr2;
    }
}
