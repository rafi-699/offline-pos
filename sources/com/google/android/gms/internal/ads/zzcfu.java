package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcfu {
    public static void zza(ListenableFuture listenableFuture, String str, Executor executor) {
        zzhbw.zzr(listenableFuture, new zzcfs(str), executor);
    }

    public static void zzb(ListenableFuture listenableFuture, String str) {
        zzhbw.zzr(listenableFuture, new zzcft(str), zzcfr.zzh);
    }
}
