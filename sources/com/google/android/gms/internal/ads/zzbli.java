package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbli {
    private static final AtomicReference zza = new AtomicReference();
    private static final AtomicReference zzb = new AtomicReference();

    static {
        new AtomicBoolean();
    }

    static zzblg zza() {
        return (zzblg) zza.get();
    }

    static zzblh zzb() {
        return (zzblh) zzb.get();
    }

    public static void zzc(zzblg zzblgVar) {
        zza.set(zzblgVar);
    }
}
