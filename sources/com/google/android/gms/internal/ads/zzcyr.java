package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcyr implements zzimu {
    private final zzind zza;

    private zzcyr(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzcyr zza(zzind zzindVar, zzind zzindVar2) {
        return new zzcyr(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzdfg) this.zza.zzb(), zzfoa.zzc());
    }
}
