package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzczo implements zzimu {
    private final zzind zza;

    private zzczo(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzczo zza(zzind zzindVar, zzind zzindVar2) {
        return new zzczo(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzctv) this.zza.zzb(), zzfoa.zzc());
    }
}
