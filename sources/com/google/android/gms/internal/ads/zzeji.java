package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeji implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeji(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeji zzc(zzind zzindVar, zzind zzindVar2) {
        return new zzeji(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzejh zzb() {
        return new zzejh(((zzeja) this.zza).zzb(), ((zzcnm) this.zzb).zzb());
    }
}
