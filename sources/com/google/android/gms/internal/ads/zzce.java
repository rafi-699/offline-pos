package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzce {
    private AudioManager.OnAudioFocusChangeListener zza;
    private Handler zzb;
    private zzd zzc = zzd.zza;
    private boolean zzd;

    public zzce(int i) {
    }

    public final zzce zza(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        this.zza = onAudioFocusChangeListener;
        this.zzb = handler;
        return this;
    }

    public final zzce zzb(zzd zzdVar) {
        this.zzc = zzdVar;
        return this;
    }

    public final zzce zzc(boolean z) {
        this.zzd = true;
        return this;
    }

    public final zzch zzd() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = this.zza;
        if (onAudioFocusChangeListener == null) {
            throw new IllegalStateException("Can't build an AudioFocusRequestCompat instance without a listener");
        }
        Handler handler = this.zzb;
        handler.getClass();
        return new zzch(1, onAudioFocusChangeListener, handler, this.zzc, false, this.zzd);
    }
}
