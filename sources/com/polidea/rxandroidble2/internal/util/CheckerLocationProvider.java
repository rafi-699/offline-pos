package com.polidea.rxandroidble2.internal.util;

import android.content.ContentResolver;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.internal.RxBleLog;

/* JADX INFO: loaded from: classes4.dex */
public class CheckerLocationProvider {
    private final ContentResolver contentResolver;
    private final LocationManager locationManager;

    @Inject
    CheckerLocationProvider(ContentResolver contentResolver, LocationManager locationManager) {
        this.contentResolver = contentResolver;
        this.locationManager = locationManager;
    }

    public boolean isLocationProviderEnabled() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.locationManager.isLocationEnabled();
        }
        return isLocationProviderEnabledBelowApi28();
    }

    private boolean isLocationProviderEnabledBelowApi28() {
        try {
            return Settings.Secure.getInt(this.contentResolver, "location_mode") != 0;
        } catch (Settings.SettingNotFoundException e) {
            RxBleLog.w(e, "Could not use LOCATION_MODE check. Falling back to a legacy/heuristic function.", new Object[0]);
            return isLocationProviderEnabledBelowApi19();
        }
    }

    private boolean isLocationProviderEnabledBelowApi19() {
        return this.locationManager.isProviderEnabled("network") || this.locationManager.isProviderEnabled("gps");
    }
}
