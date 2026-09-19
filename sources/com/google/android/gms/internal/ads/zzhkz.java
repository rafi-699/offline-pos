package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhkz {
    final zzhla zza;
    final long[] zzb;

    zzhkz() {
        this(new zzhla(), new long[10]);
    }

    zzhkz(zzhla zzhlaVar, long[] jArr) {
        this.zza = zzhlaVar;
        this.zzb = jArr;
    }

    zzhkz(zzhkz zzhkzVar) {
        this.zza = new zzhla(zzhkzVar.zza);
        this.zzb = Arrays.copyOf(zzhkzVar.zzb, 10);
    }
}
