package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzlz {
    private long zza;
    private float zzb;
    private long zzc;

    public zzlz() {
        this.zza = C.TIME_UNSET;
        this.zzb = -3.4028235E38f;
        this.zzc = C.TIME_UNSET;
    }

    /* synthetic */ zzlz(zzma zzmaVar, byte[] bArr) {
        this.zza = zzmaVar.zza;
        this.zzb = zzmaVar.zzb;
        this.zzc = zzmaVar.zzc;
    }

    public final zzlz zza(long j) {
        this.zza = j;
        return this;
    }

    public final zzlz zzb(float f) {
        boolean z = true;
        if (f <= 0.0f && f != -3.4028235E38f) {
            z = false;
        }
        zzgtj.zza(z);
        this.zzb = f;
        return this;
    }

    public final zzlz zzc(long j) {
        boolean z = true;
        if (j < 0) {
            if (j == C.TIME_UNSET) {
                j = -9223372036854775807L;
            } else {
                z = false;
            }
        }
        zzgtj.zza(z);
        this.zzc = j;
        return this;
    }

    public final zzma zzd() {
        return new zzma(this, null);
    }

    final /* synthetic */ long zze() {
        return this.zza;
    }

    final /* synthetic */ float zzf() {
        return this.zzb;
    }

    final /* synthetic */ long zzg() {
        return this.zzc;
    }
}
