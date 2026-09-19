package com.polidea.rxandroidble2.internal.util;

import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.ClientComponent;

/* JADX INFO: loaded from: classes4.dex */
public class LocationServicesStatusApi31 implements LocationServicesStatus {
    private final CheckerLocationProvider checkerLocationProvider;
    private final CheckerScanPermission checkerScanPermission;
    private final boolean isAndroidWear;
    private final boolean isNearbyPermissionNeverForLoc;

    @Inject
    LocationServicesStatusApi31(CheckerLocationProvider checkerLocationProvider, CheckerScanPermission checkerScanPermission, @Named(ClientComponent.PlatformConstants.BOOL_IS_ANDROID_WEAR) boolean z, @Named(ClientComponent.PlatformConstants.BOOL_IS_NEARBY_PERMISSION_NEVER_FOR_LOCATION) boolean z2) {
        this.checkerLocationProvider = checkerLocationProvider;
        this.checkerScanPermission = checkerScanPermission;
        this.isAndroidWear = z;
        this.isNearbyPermissionNeverForLoc = z2;
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
        return !this.isNearbyPermissionNeverForLoc;
    }
}
