package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzczm implements zzimu {
    private final zzind zza;

    private zzczm(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzczm zza(zzind zzindVar, zzind zzindVar2) {
        return new zzczm(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzctv) this.zza.zzb(), zzfoa.zzc());
    }
}
