package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgth implements Serializable {
    zzgth() {
    }

    public static zzgth zzc() {
        return zzgsq.zza;
    }

    public static zzgth zzd(Object obj) {
        return obj == null ? zzgsq.zza : new zzgto(obj);
    }

    public abstract Object zza(Object obj);

    public abstract zzgth zzb(zzgta zzgtaVar);
}
