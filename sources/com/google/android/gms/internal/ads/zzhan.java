package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhan extends zzhao {
    zzhan(ListenableFuture listenableFuture, Class cls, zzgta zzgtaVar) {
        super(listenableFuture, cls, zzgtaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhao
    final void zze(Object obj) {
        zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhao
    final /* synthetic */ Object zzf(Object obj, Throwable th) throws Exception {
        return ((zzgta) obj).apply(th);
    }
}
