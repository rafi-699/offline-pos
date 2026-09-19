package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfau implements zzimu {
    private final zzind zza;

    private zzfau(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzfau zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzfau(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfas zzb() {
        return new zzfas(zzfoa.zzc(), (zzeao) this.zza.zzb());
    }
}
