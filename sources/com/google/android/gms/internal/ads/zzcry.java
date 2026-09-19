package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcry implements zzimu {
    private final zzind zza;

    private zzcry(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcry zza(zzind zzindVar) {
        return new zzcry(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcrx(((zzcnm) this.zza).zzb());
    }
}
