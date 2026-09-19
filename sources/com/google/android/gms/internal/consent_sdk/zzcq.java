package com.google.android.gms.internal.consent_sdk;

import android.os.Build;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcq {
    public static boolean zza(boolean z) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Build.FINGERPRINT.contains("generic") || Build.FINGERPRINT.contains("emulator") || Build.HARDWARE.contains("ranchu");
        }
        return Build.DEVICE.startsWith("generic");
    }
}
