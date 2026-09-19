package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.common.C;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacd {
    public static final zzabx zza = new zzabx(2, C.TIME_UNSET, null);
    public static final zzabx zzb = new zzabx(3, C.TIME_UNSET, null);
    private final zzacj zzc = zzacj.zzb(zzfl.zzg("ExoPlayer:Loader:ProgressiveMediaPeriod"), zzabw.zza);
    private zzaby zzd;
    private IOException zze;

    public zzacd(String str) {
    }

    public static zzabx zza(boolean z, long j) {
        return new zzabx(z ? 1 : 0, j, null);
    }

    public final boolean zzb() {
        return this.zze != null;
    }

    public final void zzc() {
        this.zze = null;
    }

    public final long zzd(zzabz zzabzVar, zzabv zzabvVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        this.zze = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new zzaby(this, looperMyLooper, zzabzVar, zzabvVar, i, jElapsedRealtime).zzb(0L);
        return jElapsedRealtime;
    }

    public final boolean zze() {
        return this.zzd != null;
    }

    public final void zzg(zzaca zzacaVar) {
        zzaby zzabyVar = this.zzd;
        if (zzabyVar != null) {
            zzabyVar.zzc(true);
        }
        zzacj zzacjVar = this.zzc;
        zzacjVar.execute(new zzacb(zzacaVar));
        zzacjVar.zza();
    }

    public final void zzh(int i) throws IOException {
        IOException iOException = this.zze;
        if (iOException != null) {
            throw iOException;
        }
        zzaby zzabyVar = this.zzd;
        if (zzabyVar != null) {
            zzabyVar.zza(i);
        }
    }

    final /* synthetic */ zzacj zzi() {
        return this.zzc;
    }

    final /* synthetic */ zzaby zzj() {
        return this.zzd;
    }

    final /* synthetic */ void zzk(zzaby zzabyVar) {
        this.zzd = zzabyVar;
    }

    final /* synthetic */ void zzl(IOException iOException) {
        this.zze = iOException;
    }

    public final void zzf() {
        zzaby zzabyVar = this.zzd;
        zzabyVar.getClass();
        zzabyVar.zzc(false);
    }
}
