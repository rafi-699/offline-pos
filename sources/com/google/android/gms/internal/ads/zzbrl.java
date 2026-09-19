package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbrl implements Runnable {
    final /* synthetic */ zzbro zza;

    zzbrl(zzbro zzbroVar) {
        Objects.requireNonNull(zzbroVar);
        this.zza = zzbroVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb();
    }
}
