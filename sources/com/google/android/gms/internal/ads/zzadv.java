package com.google.android.gms.internal.ads;

import android.util.Range;
import androidx.media3.common.C;
import com.brentvatne.exoplayer.ReactExoplayerView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzadv {
    private long zza;
    private long zzb;
    private double zzc;
    private Range zzd;

    public zzadv(float f) {
        Range range = new Range(Double.valueOf(ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE), Double.valueOf(1.0d));
        this.zzd = range;
        this.zzc = ((Double) range.getUpper()).doubleValue();
        this.zza = C.TIME_UNSET;
        this.zzb = C.TIME_UNSET;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0032  */
    public final void zza(long j, long j2) {
        double dDoubleValue;
        zzgtj.zza(j != C.TIME_UNSET);
        zzgtj.zza(j2 != C.TIME_UNSET);
        long j3 = this.zza;
        if (j3 != C.TIME_UNSET) {
            long j4 = this.zzb;
            if (j4 == C.TIME_UNSET || j == j3) {
                dDoubleValue = ((Double) this.zzd.getUpper()).doubleValue();
            } else {
                dDoubleValue = (j2 - j4) / (j - j3);
            }
        } else {
            dDoubleValue = ((Double) this.zzd.getUpper()).doubleValue();
        }
        this.zzc = (this.zzc * 0.800000011920929d) + (((Double) this.zzd.clamp(Double.valueOf(dDoubleValue))).doubleValue() * 0.20000000298023224d);
        this.zza = j;
        this.zzb = j2;
    }

    public final long zzb(long j) {
        long j2 = this.zza;
        if (j2 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        return (long) (this.zzb + ((j - j2) * this.zzc));
    }

    public final void zzc(float f) {
        zzgtj.zza(f > 0.0f);
        this.zzd = new Range(Double.valueOf(ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE), Double.valueOf(1.0d / ((double) f)));
        zzd();
    }

    public final void zzd() {
        this.zzc = ((Double) this.zzd.getUpper()).doubleValue();
        this.zza = C.TIME_UNSET;
        this.zzb = C.TIME_UNSET;
    }
}
