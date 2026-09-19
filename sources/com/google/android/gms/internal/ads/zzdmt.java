package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdmt implements zzimu {
    private final zzind zza;

    private zzdmt(zzdmd zzdmdVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdmt zza(zzdmd zzdmdVar, zzind zzindVar) {
        return new zzdmt(zzdmdVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdbs) this.zza.zzb(), zzcfr.zzf);
    }
}
