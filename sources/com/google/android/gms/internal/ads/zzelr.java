package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzelr implements zzimu {
    private final zzind zza;

    private zzelr(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzelr zzc(zzind zzindVar) {
        return new zzelr(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzelq zzb() {
        return new zzelq(((zzcns) this.zza).zza());
    }
}
