package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzelp implements zzimu {
    private final zzind zza;

    private zzelp(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzelp zza(zzind zzindVar) {
        return new zzelp(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzelo(((zzcns) this.zza).zza());
    }
}
