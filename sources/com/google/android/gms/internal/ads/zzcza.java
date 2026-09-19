package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcza implements zzimu {
    private final zzind zza;

    private zzcza(zzcyz zzcyzVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcza zza(zzcyz zzcyzVar, zzind zzindVar) {
        return new zzcza(zzcyzVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzczj) this.zza.zzb(), zzcfr.zzh);
    }
}
