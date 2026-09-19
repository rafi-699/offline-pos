package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzhbo extends zzhbx {
    zzhbo() {
    }

    public static zzhbo zzw(ListenableFuture listenableFuture) {
        return listenableFuture instanceof zzhbo ? (zzhbo) listenableFuture : new zzhbp(listenableFuture);
    }
}
