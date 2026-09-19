package com.google.android.gms.internal.play_billing;

import android.os.SystemClock;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaz {
    private static final zzbl zza;

    static {
        zzbl zzayVar;
        try {
            SystemClock.elapsedRealtimeNanos();
            zzayVar = new zzax();
        } catch (Throwable unused) {
            SystemClock.elapsedRealtime();
            zzayVar = new zzay();
        }
        zza = zzayVar;
    }

    public static zzbl zza() {
        return zza;
    }
}
