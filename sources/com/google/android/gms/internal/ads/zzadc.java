package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzadc {
    private final Context zza;
    private boolean zzb;
    private zzvv zzc = zzvv.zzb;
    private final zzvh zzd;
    private Handler zze;
    private zzaep zzf;

    public zzadc(Context context) {
        this.zza = context;
        this.zzd = new zzvb(context, null, null);
    }

    public final zzadc zza(zzvv zzvvVar) {
        this.zzc = zzvvVar;
        return this;
    }

    public final zzadc zzb(Handler handler) {
        this.zze = handler;
        return this;
    }

    public final zzadc zzc(zzaep zzaepVar) {
        this.zzf = zzaepVar;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0010  */
    public final zzade zzd() {
        boolean z;
        zzgtj.zzi(!this.zzb);
        Handler handler = this.zze;
        if (handler == null && this.zzf == null) {
            z = true;
        } else {
            z = false;
            if (handler != null && this.zzf != null) {
                z = true;
            }
        }
        zzgtj.zzi(z);
        this.zzb = true;
        return new zzade(this);
    }

    final /* synthetic */ Context zze() {
        return this.zza;
    }

    final /* synthetic */ zzvv zzf() {
        return this.zzc;
    }

    final /* synthetic */ zzvh zzg() {
        return this.zzd;
    }

    final /* synthetic */ Handler zzh() {
        return this.zze;
    }

    final /* synthetic */ zzaep zzi() {
        return this.zzf;
    }
}
