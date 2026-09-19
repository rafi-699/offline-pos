package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.media3.common.C;
import com.brentvatne.exoplayer.ReactExoplayerView;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzakm implements zzakt {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzakm(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == C.TIME_UNSET ? zzfl.zzs(jArr2[jArr2.length - 1]) : j;
    }

    public static zzakm zze(long j, zzajr zzajrVar, long j2) {
        int[] iArr = zzajrVar.zzd;
        int length = iArr.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (zzajrVar.zzb + iArr[i3]);
            j3 += (long) (zzajrVar.zzc + zzajrVar.zze[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new zzakm(jArr, jArr2, j2);
    }

    private static Pair zzi(long j, long[] jArr, long[] jArr2) {
        int iZzo = zzfl.zzo(jArr, j, true, true);
        long j2 = jArr[iZzo];
        long j3 = jArr2[iZzo];
        int i = iZzo + 1;
        if (i == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        long j4 = jArr[i];
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((j4 == j2 ? ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE : (j - j2) / (j4 - j2)) * (jArr2[i] - j3))) + j3));
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        String str = zzfl.zza;
        Pair pairZzi = zzi(zzfl.zzr(Math.max(0L, Math.min(j, this.zzc))), this.zzb, this.zza);
        zzahc zzahcVar = new zzahc(zzfl.zzs(((Long) pairZzi.first).longValue()), ((Long) pairZzi.second).longValue());
        return new zzagz(zzahcVar, zzahcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzf(long j) {
        return zzfl.zzs(((Long) zzi(j, this.zza, this.zzb).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final long zzg() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzakt
    public final int zzh() {
        return C.RATE_UNSET_INT;
    }
}
