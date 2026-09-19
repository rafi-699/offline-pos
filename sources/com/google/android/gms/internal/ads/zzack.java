package com.google.android.gms.internal.ads;

import android.media.Spatializer;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzack implements Spatializer.OnSpatializerStateChangedListener {
    final /* synthetic */ Runnable zza;

    zzack(zzacm zzacmVar, Runnable runnable) {
        this.zza = runnable;
        Objects.requireNonNull(zzacmVar);
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.run();
    }

    @Override // android.media.Spatializer.OnSpatializerStateChangedListener
    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.run();
    }
}
