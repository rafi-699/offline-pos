package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzjd {
    private final long zza;
    private final long zzb;
    private long zzc = C.TIME_UNSET;
    private long zzd = C.TIME_UNSET;
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private float zzj = 0.97f;
    private float zzi = 1.03f;
    private float zzk = 1.0f;
    private long zzl = C.TIME_UNSET;
    private long zze = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private long zzm = C.TIME_UNSET;
    private long zzn = C.TIME_UNSET;

    /* synthetic */ zzjd(float f, float f2, long j, float f3, long j2, long j3, float f4, byte[] bArr) {
        this.zza = j2;
        this.zzb = j3;
    }

    private final void zzf() {
        long j;
        long j2 = this.zzc;
        if (j2 != C.TIME_UNSET) {
            j = this.zzd;
            if (j == C.TIME_UNSET) {
                long j3 = this.zzf;
                if (j3 != C.TIME_UNSET && j2 < j3) {
                    j2 = j3;
                }
                j = this.zzg;
                if (j == C.TIME_UNSET || j2 <= j) {
                    j = j2;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.zze == j) {
            return;
        }
        this.zze = j;
        this.zzh = j;
        this.zzm = C.TIME_UNSET;
        this.zzn = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
    }

    private static long zzg(long j, long j2, float f) {
        return (long) ((j * 0.999f) + (j2 * 9.999871E-4f));
    }

    public final void zza(zzaf zzafVar) {
        long j = zzafVar.zza;
        this.zzc = zzfl.zzs(C.TIME_UNSET);
        long j2 = zzafVar.zzb;
        this.zzf = zzfl.zzs(C.TIME_UNSET);
        long j3 = zzafVar.zzc;
        this.zzg = zzfl.zzs(C.TIME_UNSET);
        float f = zzafVar.zzd;
        this.zzj = 0.97f;
        float f2 = zzafVar.zze;
        this.zzi = 1.03f;
        zzf();
    }

    public final void zzb(long j) {
        this.zzd = j;
        zzf();
    }

    public final void zzc() {
        long j = this.zzh;
        if (j == C.TIME_UNSET) {
            return;
        }
        long j2 = j + this.zzb;
        this.zzh = j2;
        long j3 = this.zzg;
        if (j3 != C.TIME_UNSET && j2 > j3) {
            this.zzh = j3;
        }
        this.zzl = C.TIME_UNSET;
    }

    public final long zze() {
        return this.zzh;
    }

    public final float zzd(long j, long j2) {
        long j3;
        if (this.zzc == C.TIME_UNSET) {
            return 1.0f;
        }
        long j4 = j - j2;
        long j5 = this.zzm;
        if (j5 == C.TIME_UNSET) {
            this.zzm = j4;
            this.zzn = 0L;
        } else {
            long jMax = Math.max(j4, zzg(j5, j4, 0.999f));
            this.zzm = jMax;
            this.zzn = zzg(this.zzn, Math.abs(j4 - jMax), 0.999f);
        }
        if (this.zzl != C.TIME_UNSET && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j6 = this.zzm + (this.zzn * 3);
        if (this.zzh > j6) {
            float fZzs = zzfl.zzs(1000L);
            long[] jArr = {j6, this.zze, this.zzh - (((long) ((this.zzk - 1.0f) * fZzs)) + ((long) ((this.zzi - 1.0f) * fZzs)))};
            j3 = jArr[0];
            for (int i = 1; i < 3; i++) {
                long j7 = jArr[i];
                if (j7 > j3) {
                    j3 = j7;
                }
            }
            this.zzh = j3;
        } else {
            long jMax2 = j - ((long) (Math.max(0.0f, this.zzk - 1.0f) / 1.0E-7f));
            long j8 = this.zzh;
            String str = zzfl.zza;
            long jMax3 = Math.max(j8, Math.min(jMax2, j6));
            this.zzh = jMax3;
            long j9 = this.zzg;
            if (j9 == C.TIME_UNSET || jMax3 <= j9) {
                j3 = jMax3;
            } else {
                this.zzh = j9;
                j3 = j9;
            }
        }
        long j10 = j - j3;
        if (Math.abs(j10) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float fMax = Math.max(this.zzj, Math.min((j10 * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = fMax;
        return fMax;
    }
}
