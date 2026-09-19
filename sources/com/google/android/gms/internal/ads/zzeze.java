package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeze implements zzimu {
    private final zzind zza;

    private zzeze(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzeze zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzeze(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzezd zzb() {
        return new zzezd(((zzcns) this.zza).zza(), zzfoa.zzc());
    }
}
