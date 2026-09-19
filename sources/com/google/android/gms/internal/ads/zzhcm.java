package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhcm extends zzhci implements zzhch {
    final ScheduledExecutorService zza;

    zzhcm(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzhch, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzd */
    public final zzhcf schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzhcv zzhcvVarZze = zzhcv.zze(runnable, null);
        return new zzhck(zzhcvVarZze, scheduledExecutorService.schedule(zzhcvVarZze, j, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzhch, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zze */
    public final zzhcf schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzhcv zzhcvVar = new zzhcv(callable);
        return new zzhck(zzhcvVar, this.zza.schedule(zzhcvVar, j, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzhch, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzf */
    public final zzhcf scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzhcl zzhclVar = new zzhcl(runnable);
        return new zzhck(zzhclVar, this.zza.scheduleAtFixedRate(zzhclVar, j, j2, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzhch, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzg */
    public final zzhcf scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzhcl zzhclVar = new zzhcl(runnable);
        return new zzhck(zzhclVar, this.zza.scheduleWithFixedDelay(zzhclVar, j, j2, timeUnit));
    }
}
