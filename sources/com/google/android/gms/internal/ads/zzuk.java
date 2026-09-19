package com.google.android.gms.internal.ads;

import androidx.media3.common.PlaybackException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzuk implements zzun {
    zzuk() {
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final zzug zza(zzui zzuiVar, zzv zzvVar) {
        if (zzvVar.zzt == null) {
            return null;
        }
        return new zzuo(new zzuf(new zzup(1), PlaybackException.ERROR_CODE_DRM_SCHEME_UNSUPPORTED));
    }

    @Override // com.google.android.gms.internal.ads.zzun
    public final int zzb(zzv zzvVar) {
        return zzvVar.zzt != null ? 1 : 0;
    }
}
