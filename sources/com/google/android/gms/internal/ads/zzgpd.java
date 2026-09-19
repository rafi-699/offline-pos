package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgpd implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzgpd(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzgpd zza(zzind zzindVar, zzind zzindVar2) {
        return new zzgpd(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgpc((zzgpt) this.zza.zzb(), ((zzing) this.zzb).zzb());
    }
}
