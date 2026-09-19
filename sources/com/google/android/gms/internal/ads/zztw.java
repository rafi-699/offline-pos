package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zztw implements zzsb {
    final /* synthetic */ zztx zza;

    /* synthetic */ zztw(zztx zztxVar, byte[] bArr) {
        Objects.requireNonNull(zztxVar);
        this.zza = zztxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzsb
    public final void zza(Exception exc) {
        zzeg.zzf("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzaz().zzi(exc);
    }
}
