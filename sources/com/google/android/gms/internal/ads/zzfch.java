package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfch implements zzimu {
    private final zzind zza;

    private zzfch(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzfch zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzfch(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfcg zzb() {
        return new zzfcg(zzfoa.zzc(), ((zzcns) this.zza).zza());
    }
}
