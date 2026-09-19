package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdau implements zzimu {
    private final zzind zza;

    private zzdau(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzdau zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdau(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdyq) this.zza.zzb(), zzfoa.zzc());
    }
}
