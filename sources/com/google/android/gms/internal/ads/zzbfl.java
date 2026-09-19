package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzbfl {
    private final Object zza = new Object();
    private zzbfj zzb = null;
    private boolean zzc = false;

    public final void zza(Context context) {
        synchronized (this.zza) {
            if (!this.zzc) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext == null) {
                    applicationContext = context;
                }
                Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
                if (application == null) {
                    int i = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Can not cast Context to Application");
                } else {
                    if (this.zzb == null) {
                        this.zzb = new zzbfj();
                    }
                    this.zzb.zza(application, context);
                    this.zzc = true;
                }
            }
        }
    }

    public final void zzb(zzbfk zzbfkVar) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new zzbfj();
            }
            this.zzb.zzb(zzbfkVar);
        }
    }

    public final Activity zzd() {
        synchronized (this.zza) {
            zzbfj zzbfjVar = this.zzb;
            if (zzbfjVar == null) {
                return null;
            }
            return zzbfjVar.zzd();
        }
    }

    public final Context zze() {
        synchronized (this.zza) {
            zzbfj zzbfjVar = this.zzb;
            if (zzbfjVar == null) {
                return null;
            }
            return zzbfjVar.zze();
        }
    }

    public final boolean zzf() {
        synchronized (this.zza) {
            zzbfj zzbfjVar = this.zzb;
            if (zzbfjVar == null) {
                return false;
            }
            return zzbfjVar.zzg().get();
        }
    }

    public final void zzg(zzdwu zzdwuVar) {
        synchronized (this.zza) {
            if (this.zzb == null) {
                this.zzb = new zzbfj();
            }
            this.zzb.zzj(zzdwuVar);
        }
    }

    public final void zzc(zzbfk zzbfkVar) {
        synchronized (this.zza) {
            zzbfj zzbfjVar = this.zzb;
            if (zzbfjVar == null) {
                return;
            }
            zzbfjVar.zzc(zzbfkVar);
        }
    }
}
