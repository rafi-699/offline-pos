package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzsv extends AudioTrack.StreamEventCallback {
    final /* synthetic */ zzsx zza;

    zzsv(zzsx zzsxVar) {
        Objects.requireNonNull(zzsxVar);
        this.zza = zzsxVar;
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onDataRequest(AudioTrack audioTrack, int i) {
        zzef zzefVarZzu = this.zza.zza.zzu();
        zzefVarZzu.zze(-1, zzsu.zza);
        zzefVarZzu.zzf();
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onPresentationEnded(AudioTrack audioTrack) {
        zzef zzefVarZzu = this.zza.zza.zzu();
        zzefVarZzu.zze(-1, zzss.zza);
        zzefVarZzu.zzf();
    }

    @Override // android.media.AudioTrack.StreamEventCallback
    public final void onTearDown(AudioTrack audioTrack) {
        zzef zzefVarZzu = this.zza.zza.zzu();
        zzefVarZzu.zze(-1, zzst.zza);
        zzefVarZzu.zzf();
    }
}
