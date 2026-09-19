package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeve {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzevd zzb;

    public final void zza(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzb() {
        return this.zza.get();
    }

    final void zzc(zzevd zzevdVar) {
        this.zzb = zzevdVar;
    }

    final zzevd zzd() {
        return this.zzb;
    }
}
