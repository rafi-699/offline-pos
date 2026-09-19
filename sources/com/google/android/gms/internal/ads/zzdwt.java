package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdwt implements zzimu {
    private final zzind zza;

    private zzdwt(zzdws zzdwsVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdwt zza(zzdws zzdwsVar, zzind zzindVar) {
        return new zzdwt(zzdwsVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq(((zzdwr) this.zza).zzb(), zzcfr.zzf);
    }
}
