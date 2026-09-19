package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzafo implements zzahb {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;
    private final boolean zzg;

    protected zzafo(long j, long j2, int i, int i2, boolean z, boolean z2) {
        long jZzf;
        this.zza = j;
        this.zzb = j2;
        this.zzc = i2 == -1 ? 1 : i2;
        this.zze = i;
        this.zzg = z2;
        if (j == -1) {
            this.zzd = -1L;
            jZzf = C.TIME_UNSET;
        } else {
            this.zzd = j - j2;
            jZzf = zzf(j, j2, i);
        }
        this.zzf = jZzf;
    }

    private static long zzf(long j, long j2, int i) {
        return (Math.max(0L, j - j2) * 8000000) / ((long) i);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return this.zzd != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        long j2 = this.zzd;
        if (j2 == -1) {
            zzahc zzahcVar = new zzahc(0L, this.zzb);
            return new zzagz(zzahcVar, zzahcVar);
        }
        long j3 = ((long) this.zze) * j;
        long j4 = this.zzc;
        long jMin = ((j3 / 8000000) / j4) * j4;
        if (j2 != -1) {
            jMin = Math.min(jMin, j2 - j4);
        }
        long jMax = this.zzb + Math.max(jMin, 0L);
        long jZze = zze(jMax);
        zzahc zzahcVar2 = new zzahc(jZze, jMax);
        if (j2 != -1 && jZze < j) {
            long j5 = jMax + j4;
            if (j5 < this.zza) {
                return new zzagz(zzahcVar2, new zzahc(zze(j5), j5));
            }
        }
        return new zzagz(zzahcVar2, zzahcVar2);
    }

    public final long zze(long j) {
        return zzf(j, this.zzb, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzj() {
        return this.zzg;
    }
}
