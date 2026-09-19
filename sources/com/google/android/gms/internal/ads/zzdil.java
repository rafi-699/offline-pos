package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdil implements zzimu {
    private final zzind zza;

    private zzdil(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdil zza(zzind zzindVar) {
        return new zzdil(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdik(((zzing) this.zza).zzb());
    }
}
