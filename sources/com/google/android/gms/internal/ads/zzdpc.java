package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdpc implements zzimu {
    private final zzind zza;

    private zzdpc(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdpc zzc(zzind zzindVar) {
        return new zzdpc(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdpb zzb() {
        return new zzdpb(((zzdql) this.zza).zza());
    }
}
