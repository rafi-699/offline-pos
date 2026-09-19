package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgyg implements Comparator {
    protected zzgyg() {
    }

    public static zzgyg zzb() {
        return zzgye.zza;
    }

    public static zzgyg zzc(Comparator comparator) {
        return new zzgvv(comparator);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzgyg zza() {
        return new zzgyp(this);
    }

    public final zzgyg zzd(zzgta zzgtaVar) {
        return new zzgvh(zzgtaVar, this);
    }
}
