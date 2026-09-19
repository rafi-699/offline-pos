package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqi implements zzimu {
    private final zzind zza;

    private zzdqi(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzdqi zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdqi(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkq((zzetf) this.zza.zzb(), zzfoa.zzc());
    }
}
