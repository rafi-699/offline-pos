package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbdd implements Runnable {
    final /* synthetic */ zzbde zza;

    zzbdd(zzbde zzbdeVar) {
        Objects.requireNonNull(zzbdeVar);
        this.zza = zzbdeVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb();
    }
}
