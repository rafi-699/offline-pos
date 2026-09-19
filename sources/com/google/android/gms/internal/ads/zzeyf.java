package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeyf implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;
    private final zzind zzd;

    private zzeyf(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
        this.zzd = zzindVar4;
    }

    public static zzeyf zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3, zzind zzindVar4) {
        return new zzeyf(zzindVar, zzindVar2, zzindVar3, zzindVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfaw zzfawVar;
        zzewi zzewiVarZzb = ((zzewk) this.zza).zzb();
        zzewy zzewyVar = (zzewy) this.zzb.zzb();
        List list = (List) this.zzc.zzb();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zzd.zzb();
        if (list.contains("13")) {
            zzfawVar = new zzfaw(zzewyVar, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznN)).intValue(), scheduledExecutorService);
        } else {
            zzfawVar = new zzfaw(zzewiVarZzb, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznN)).intValue(), scheduledExecutorService);
        }
        return zzfawVar;
    }
}
