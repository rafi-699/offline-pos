package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgkt implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzgkt(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzgkt zza(zzind zzindVar, zzind zzindVar2) {
        return new zzgkt(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbds zzbdsVarZzb = zzfyd.zzb((Context) this.zza.zzb(), (zzfxg) this.zzb.zzb());
        zzinc.zzb(zzbdsVarZzb);
        return zzbdsVarZzb;
    }
}
