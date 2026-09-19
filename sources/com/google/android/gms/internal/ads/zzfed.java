package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfed implements zzimu {
    private final zzind zza;

    private zzfed(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzfed zza(zzind zzindVar) {
        return new zzfed(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzfec(((zzcns) this.zza).zza());
    }
}
