package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcls implements Runnable {
    final /* synthetic */ zzclx zza;

    zzcls(zzclx zzclxVar) {
        Objects.requireNonNull(zzclxVar);
        this.zza = zzclxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
