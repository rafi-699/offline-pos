package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdmw implements zzimu {
    private final zzind zza;

    private zzdmw(zzdmd zzdmdVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzdmw zza(zzdmd zzdmdVar, zzind zzindVar, zzind zzindVar2) {
        return new zzdmw(zzdmdVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdnt) this.zza.zzb(), zzfoa.zzc());
    }
}
