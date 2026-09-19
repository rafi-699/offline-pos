package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfai implements zzimu {
    private final zzind zza;

    private zzfai(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzfai zzc(zzind zzindVar) {
        return new zzfai(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfag zzb() {
        return new zzfag((zzfke) this.zza.zzb());
    }
}
