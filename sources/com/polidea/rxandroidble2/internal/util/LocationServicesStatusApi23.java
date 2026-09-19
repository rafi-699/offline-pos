package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientComponent;

/* JADX INFO: loaded from: classes4.dex */
public class LocationServicesStatusApi23 implements LocationServicesStatus {
    private final CheckerLocationProvider checkerLocationProvider;
    private final CheckerScanPermission checkerScanPermission;
    private final int deviceSdk;
    private final boolean isAndroidWear;
    private final int targetSdk;

    @Inject
    LocationServicesStatusApi23(CheckerLocationProvider checkerLocationProvider, CheckerScanPermission checkerScanPermission, @Named(ClientComponent.PlatformConstants.INT_TARGET_SDK) int i, @Named(ClientComponent.PlatformConstants.INT_DEVICE_SDK) int i2, @Named(ClientComponent.PlatformConstants.BOOL_IS_ANDROID_WEAR) boolean z) {
        this.checkerLocationProvider = checkerLocationProvider;
        this.checkerScanPermission = checkerScanPermission;
        this.targetSdk = i;
        this.deviceSdk = i2;
        this.isAndroidWear = z;
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public boolean isLocationPermissionOk() {
        return this.checkerScanPermission.isScanRuntimePermissionGranted();
    }

    @Override // com.polidea.rxandroidble2.internal.util.LocationServicesStatus
    public boolean isLocationProviderOk() {
        return !isLocationProviderEnabledRequired() || this.checkerLocationProvider.isLocationProviderEnabled();
    }

    private boolean isLocationProviderEnabledRequired() {
        if (this.isAndroidWear) {
            return false;
        }
        return this.deviceSdk >= 29 || this.targetSdk >= 23;
    }
}
