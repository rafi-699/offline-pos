package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdbb implements zzimu {
    private final zzind zza;

    private zzdbb(zzdba zzdbaVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdbb zza(zzdba zzdbaVar, zzind zzindVar) {
        return new zzdbb(zzdbaVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdae) this.zza.zzb(), zzcfr.zzh);
    }
}
