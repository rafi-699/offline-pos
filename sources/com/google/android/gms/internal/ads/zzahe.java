package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzahe implements zzahb {
    public zzahe(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        zzahc zzahcVar = new zzahc(j, 0L);
        return new zzagz(zzahcVar, zzahcVar);
    }
}
