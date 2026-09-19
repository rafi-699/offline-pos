package com.google.android.gms.internal.ads;

import android.net.ConnectivityManager;
import android.net.Network;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcfa extends ConnectivityManager.NetworkCallback {
    final /* synthetic */ zzcfd zza;

    zzcfa(zzcfd zzcfdVar) {
        Objects.requireNonNull(zzcfdVar);
        this.zza = zzcfdVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        this.zza.zzC().set(true);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        this.zza.zzC().set(false);
    }
}
