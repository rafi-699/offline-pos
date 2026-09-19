package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfpn implements zzimu {
    private final zzind zza;

    private zzfpn(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzfpn zzc(zzind zzindVar) {
        return new zzfpn(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzfpj zzb() {
        return new zzfpj(((zzing) this.zza).zzb());
    }
}
