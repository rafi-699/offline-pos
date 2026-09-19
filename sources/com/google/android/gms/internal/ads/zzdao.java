package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdao implements zzimu {
    private final zzind zza;

    private zzdao(zzdag zzdagVar, zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdao zza(zzdag zzdagVar, zzind zzindVar) {
        return new zzdao(zzdagVar, zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzcyo) this.zza.zzb(), zzcfr.zzh);
    }
}
