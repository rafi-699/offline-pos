package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzhkx {
    final long[] zza;
    final long[] zzb;
    final long[] zzc;

    zzhkx() {
        this(new long[10], new long[10], new long[10]);
    }

    zzhkx(long[] jArr, long[] jArr2, long[] jArr3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = jArr3;
    }

    void zza(long[] jArr, long[] jArr2) {
        System.arraycopy(jArr2, 0, jArr, 0, 10);
    }

    final void zzb(zzhkx zzhkxVar, int i) {
        zzhkw.zza(this.zza, zzhkxVar.zza, i);
        zzhkw.zza(this.zzb, zzhkxVar.zzb, i);
        zzhkw.zza(this.zzc, zzhkxVar.zzc, i);
    }

    zzhkx(zzhkx zzhkxVar) {
        this.zza = Arrays.copyOf(zzhkxVar.zza, 10);
        this.zzb = Arrays.copyOf(zzhkxVar.zzb, 10);
        this.zzc = Arrays.copyOf(zzhkxVar.zzc, 10);
    }
}
