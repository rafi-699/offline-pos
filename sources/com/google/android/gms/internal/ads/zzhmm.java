package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhmm {
    private static final zzhmm zza = new zzhmm();
    private static final zzhml zzb = new zzhml(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzhmm zza() {
        return zza;
    }

    public final zzhme zzb() {
        zzhme zzhmeVar = (zzhme) this.zzc.get();
        return zzhmeVar == null ? zzb : zzhmeVar;
    }
}
