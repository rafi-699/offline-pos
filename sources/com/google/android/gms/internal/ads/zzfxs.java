package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfxs implements zzfxv {
    private static final zzaym zza;

    static {
        zzaxm zzaxmVarZzj = zzaym.zzj();
        zzaxmVarZzj.zzo(ExifInterface.LONGITUDE_EAST);
        zza = (zzaym) zzaxmVarZzj.zzbu();
    }

    zzfxs() {
    }

    @Override // com.google.android.gms.internal.ads.zzfxv
    public final zzaym zza() {
        return zza;
    }
}
