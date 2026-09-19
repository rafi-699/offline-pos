package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadf extends HandlerThread implements Handler.Callback {
    private zzdv zza;
    private Handler zzb;
    private Error zzc;
    private RuntimeException zzd;
    private zzadg zze;

    public zzadf() {
        super("ExoPlayer:PlaceholderSurface");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i == 1) {
                try {
                    try {
                        int i2 = message.arg1;
                        zzdv zzdvVar = this.zza;
                        if (zzdvVar == null) {
                            throw null;
                        }
                        zzdvVar.zza(i2);
                        this.zze = new zzadg(this, this.zza.zzc(), i2 != 0, null);
                        synchronized (this) {
                            notify();
                        }
                    } catch (Error e) {
                        zzeg.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e);
                        this.zzc = e;
                        synchronized (this) {
                            notify();
                        }
                    } catch (RuntimeException e2) {
                        zzeg.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e2);
                        this.zzd = e2;
                        synchronized (this) {
                            notify();
                        }
                    }
                } catch (zzdw e3) {
                    zzeg.zzf("PlaceholderSurface", "Failed to initialize placeholder surface", e3);
                    this.zzd = new IllegalStateException(e3);
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i == 2) {
                try {
                    zzdv zzdvVar2 = this.zza;
                    if (zzdvVar2 == null) {
                        throw null;
                    }
                    zzdvVar2.zzb();
                    return true;
                } catch (Throwable th) {
                    try {
                        zzeg.zzf("PlaceholderSurface", "Failed to release placeholder surface", th);
                    } finally {
                        quit();
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }

    public final zzadg zza(int i) {
        boolean z;
        start();
        this.zzb = new Handler(getLooper(), this);
        this.zza = new zzdv(this.zzb, null);
        synchronized (this) {
            z = false;
            this.zzb.obtainMessage(1, i, 0).sendToTarget();
            while (this.zze == null && this.zzd == null && this.zzc == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzd;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.zzc;
        if (error != null) {
            throw error;
        }
        zzadg zzadgVar = this.zze;
        zzadgVar.getClass();
        return zzadgVar;
    }

    public final void zzb() {
        Handler handler = this.zzb;
        handler.getClass();
        handler.sendEmptyMessage(2);
    }
}
