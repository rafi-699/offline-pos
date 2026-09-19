package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzhbj extends zzhcd {
    private final Executor zza;
    final /* synthetic */ zzhbk zzb;

    zzhbj(zzhbk zzhbkVar, Executor executor) {
        Objects.requireNonNull(zzhbkVar);
        this.zzb = zzhbkVar;
        executor.getClass();
        this.zza = executor;
    }

    abstract void zzb(Object obj);

    @Override // com.google.android.gms.internal.ads.zzhcd
    final boolean zzd() {
        return this.zzb.isDone();
    }

    final void zze() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final void zzf(Object obj) {
        this.zzb.zzD(null);
        zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzhcd
    final void zzg(Throwable th) {
        zzhbk zzhbkVar = this.zzb;
        zzhbkVar.zzD(null);
        if (th instanceof ExecutionException) {
            zzhbkVar.zzb(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            zzhbkVar.cancel(false);
        } else {
            zzhbkVar.zzb(th);
        }
    }
}
