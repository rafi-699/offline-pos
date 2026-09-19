package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcxq implements zzimu {
    private final zzind zza;

    private zzcxq(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcxq zza(zzind zzindVar) {
        return new zzcxq(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxp(((zzcwg) this.zza).zzb());
    }
}
