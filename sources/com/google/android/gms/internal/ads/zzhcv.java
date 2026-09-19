package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhcv extends zzhbn implements RunnableFuture {
    private volatile zzhcd zza;

    zzhcv(zzhbd zzhbdVar) {
        this.zza = new zzhct(this, zzhbdVar);
    }

    static zzhcv zze(Runnable runnable, Object obj) {
        return new zzhcv(Executors.callable(runnable, obj));
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        zzhcd zzhcdVar = this.zza;
        if (zzhcdVar != null) {
            zzhcdVar.run();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    protected final void zzc() {
        zzhcd zzhcdVar;
        if (zzj() && (zzhcdVar = this.zza) != null) {
            zzhcdVar.zzh();
        }
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzhap
    protected final String zzd() {
        zzhcd zzhcdVar = this.zza;
        if (zzhcdVar == null) {
            return super.zzd();
        }
        String string = zzhcdVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 7);
        sb.append("task=[");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }

    zzhcv(Callable callable) {
        this.zza = new zzhcu(this, callable);
    }
}
