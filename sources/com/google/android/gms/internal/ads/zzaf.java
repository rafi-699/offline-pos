package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaf {
    public final long zza = C.TIME_UNSET;
    public final long zzb = C.TIME_UNSET;
    public final long zzc = C.TIME_UNSET;
    public final float zzd = -3.4028235E38f;
    public final float zze = -3.4028235E38f;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
    }

    /* synthetic */ zzaf(zzae zzaeVar, byte[] bArr) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaf)) {
            return false;
        }
        zzaf zzafVar = (zzaf) obj;
        long j = zzafVar.zza;
        long j2 = zzafVar.zzb;
        long j3 = zzafVar.zzc;
        float f = zzafVar.zzd;
        float f2 = zzafVar.zze;
        return true;
    }

    public final int hashCode() {
        int i = (int) (-9223372034707292159L);
        return (((((((i * 31) + i) * 31) + i) * 31) + Float.floatToIntBits(-3.4028235E38f)) * 31) + Float.floatToIntBits(-3.4028235E38f);
    }
}
