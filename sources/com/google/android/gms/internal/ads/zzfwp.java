package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfwp implements Runnable {
    zzfwp() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (zzfws.zzc != null) {
            zzfws.zzc.post(zzfws.zzk);
            zzfws.zzc.postDelayed(zzfws.zzl, 200L);
        }
    }
}
