package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhbi extends zzhbj {
    final /* synthetic */ zzhbk zza;
    private final Callable zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhbi(zzhbk zzhbkVar, Callable callable, Executor executor) {
        super(zzhbkVar, executor);
        Objects.requireNonNull(zzhbkVar);
        this.zza = zzhbkVar;
        this.zzc = callable;
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final Object zza() throws Exception {
        return this.zzc.call();
    }

    @Override // com.google.android.gms.internal.ads.zzhbj
    final void zzb(Object obj) {
        this.zza.zza(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final String zzc() {
        return this.zzc.toString();
    }
}
