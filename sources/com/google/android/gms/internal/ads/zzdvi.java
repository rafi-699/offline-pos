package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdvi implements zzimu {
    private final zzind zza;

    private zzdvi(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdvi zzc(zzind zzindVar) {
        return new zzdvi(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdvh zzb() {
        return new zzdvh(((zzdql) this.zza).zza());
    }
}
