package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbhl {
    private zzbha zza;
    private boolean zzb;
    private final Context zzc;
    private final Object zzd = new Object();

    zzbhl(Context context) {
        this.zzc = context;
    }

    final Future zza(zzbhb zzbhbVar) {
        zzbhf zzbhfVar = new zzbhf(this);
        zzbhj zzbhjVar = new zzbhj(this, zzbhbVar, zzbhfVar);
        zzbhk zzbhkVar = new zzbhk(this, zzbhfVar);
        synchronized (this.zzd) {
            zzbha zzbhaVar = new zzbha(this.zzc, com.google.android.gms.ads.internal.zzt.zzs().zza(), zzbhjVar, zzbhkVar);
            this.zza = zzbhaVar;
            zzbhaVar.checkAvailabilityAndConnect();
        }
        return zzbhfVar;
    }

    final /* synthetic */ zzbha zzc() {
        return this.zza;
    }

    final /* synthetic */ boolean zzd() {
        return this.zzb;
    }

    final /* synthetic */ void zze(boolean z) {
        this.zzb = true;
    }

    final /* synthetic */ Object zzf() {
        return this.zzd;
    }

    final /* synthetic */ void zzb() {
        synchronized (this.zzd) {
            zzbha zzbhaVar = this.zza;
            if (zzbhaVar == null) {
                return;
            }
            zzbhaVar.disconnect();
            this.zza = null;
            Binder.flushPendingCommands();
        }
    }
}
