package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeot extends zzeos {
    private final zzcnj zza;
    private final zzdca zzb;
    private final zzdir zzc;
    private final zzepd zzd;
    private final zzelx zze;

    zzeot(zzcnj zzcnjVar, zzdca zzdcaVar, zzdir zzdirVar, zzepd zzepdVar, zzelx zzelxVar) {
        this.zza = zzcnjVar;
        this.zzb = zzdcaVar;
        this.zzc = zzdirVar;
        this.zzd = zzepdVar;
        this.zze = zzelxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeos
    protected final ListenableFuture zzc(zzfky zzfkyVar, Bundle bundle, zzfkf zzfkfVar, zzfkq zzfkqVar) {
        zzdca zzdcaVar = this.zzb;
        zzdcaVar.zzb(zzfkyVar);
        zzdcaVar.zzc(bundle);
        zzdcaVar.zzd(new zzdbu(zzfkqVar, zzfkfVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzew)).booleanValue()) {
            zzdcaVar.zzg(this.zze);
        }
        zzcuy zzcuyVarZzk = this.zza.zzk();
        zzcuyVarZzk.zzd(zzdcaVar.zze());
        zzcuyVarZzk.zze(this.zzc);
        zzcyx zzcyxVarZza = zzcuyVarZzk.zzh().zza();
        return zzcyxVarZza.zzc(zzcyxVarZza.zzb());
    }
}
