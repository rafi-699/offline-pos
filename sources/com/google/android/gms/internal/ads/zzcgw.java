package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcgw implements Runnable {
    final /* synthetic */ zzchb zza;

    zzcgw(zzchb zzchbVar) {
        Objects.requireNonNull(zzchbVar);
        this.zza = zzchbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzI("surfaceDestroyed", new String[0]);
    }
}
