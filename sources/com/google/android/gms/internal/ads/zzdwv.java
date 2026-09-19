package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdwv implements zzimu {
    private final zzind zza;

    private zzdwv(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdwv zza(zzind zzindVar) {
        return new zzdwv(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdwu(((zzgcf) this.zza).zzb());
    }
}
