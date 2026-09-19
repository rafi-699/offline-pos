package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdih implements zzimu {
    private final zzind zza;

    private zzdih(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdih zza(zzind zzindVar) {
        return new zzdih(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdig(((zzing) this.zza).zzb());
    }
}
