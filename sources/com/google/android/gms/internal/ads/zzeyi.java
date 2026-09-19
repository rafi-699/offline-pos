package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeyi implements zzimu {
    private final zzind zza;

    private zzeyi(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar2;
    }

    public static zzeyi zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeyi(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgww zzgwwVarZzh;
        zzexa zzexaVarZzc = zzexc.zzc();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zza.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeY)).booleanValue()) {
            zzgwwVarZzh = zzgww.zzi(new zzfaw(zzexaVarZzc, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeZ)).intValue(), scheduledExecutorService));
        } else {
            zzgwwVarZzh = zzgww.zzh();
        }
        zzinc.zzb(zzgwwVarZzh);
        return zzgwwVarZzh;
    }
}
