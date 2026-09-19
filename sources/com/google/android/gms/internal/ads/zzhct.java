package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhct extends zzhcd {
    final /* synthetic */ zzhcv zza;
    private final zzhbd zzb;

    zzhct(zzhcv zzhcvVar, zzhbd zzhbdVar) {
        Objects.requireNonNull(zzhcvVar);
        this.zza = zzhcvVar;
        this.zzb = zzhbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final /* bridge */ /* synthetic */ Object zza() throws Exception {
        zzhbd zzhbdVar = this.zzb;
        ListenableFuture listenableFutureZza = zzhbdVar.zza();
        zzgtj.zzl(listenableFutureZza, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzhbdVar);
        return listenableFutureZza;
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final String zzc() {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final boolean zzd() {
        return this.zza.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final /* synthetic */ void zzf(Object obj) {
        this.zza.zzk((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final void zzg(Throwable th) {
        this.zza.zzb(th);
    }
}
