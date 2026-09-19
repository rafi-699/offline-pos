package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbbr implements Runnable {
    final /* synthetic */ zzbbs zza;

    zzbbr(zzbbs zzbbsVar) {
        Objects.requireNonNull(zzbbsVar);
        this.zza = zzbbsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbiq.zza(this.zza.zza);
    }
}
