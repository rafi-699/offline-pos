package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdbo implements zzimu {
    private final zzind zza;

    private zzdbo(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdbo zza(zzind zzindVar) {
        return new zzdbo(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdbn(((zzcyn) this.zza).zza());
    }
}
