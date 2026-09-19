package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeym implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeym(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeym zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeym(zzindVar, zzindVar2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0036  */
    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgww zzgwwVarZzh;
        zzezk zzezkVarZzb = ((zzezm) this.zza).zzb();
        Context contextZza = ((zzcns) this.zzb).zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmN)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzc();
            if (com.google.android.gms.ads.internal.util.zzs.zzE(contextZza)) {
                zzgwwVarZzh = zzgww.zzi(zzezkVarZzb);
            } else {
                zzgwwVarZzh = zzgww.zzh();
            }
        } else {
            zzgwwVarZzh = zzgww.zzh();
        }
        zzinc.zzb(zzgwwVarZzh);
        return zzgwwVarZzh;
    }
}
