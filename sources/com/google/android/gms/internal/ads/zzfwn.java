package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfwn implements Runnable {
    final /* synthetic */ zzfws zza;

    zzfwn(zzfws zzfwsVar) {
        Objects.requireNonNull(zzfwsVar);
        this.zza = zzfwsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzh().zzc();
    }
}
