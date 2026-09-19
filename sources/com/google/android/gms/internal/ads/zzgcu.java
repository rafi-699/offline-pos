package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgcu implements zzimu {
    private final zzind zza;

    private zzgcu(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgcu zza(zzind zzindVar) {
        return new zzgcu(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzhcg zzhcgVarZzb = zzhcn.zzb((ExecutorService) this.zza.zzb());
        zzinc.zzb(zzhcgVarZzb);
        return zzhcgVarZzb;
    }
}
