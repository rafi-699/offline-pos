package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzegf implements zzimu {
    private final zzind zza;

    private zzegf(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzegf zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzegf(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzege zzb() {
        return new zzege(((zzcns) this.zza).zza(), zzfoa.zzc());
    }
}
