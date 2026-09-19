package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzham extends zzhao {
    zzham(ListenableFuture listenableFuture, Class cls, zzhbe zzhbeVar) {
        super(listenableFuture, cls, zzhbeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhao
    final /* synthetic */ void zze(Object obj) {
        zzk((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhao
    final /* bridge */ /* synthetic */ Object zzf(Object obj, Throwable th) throws Exception {
        zzhbe zzhbeVar = (zzhbe) obj;
        ListenableFuture listenableFutureZza = zzhbeVar.zza(th);
        zzgtj.zzl(listenableFutureZza, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzhbeVar);
        return listenableFutureZza;
    }
}
