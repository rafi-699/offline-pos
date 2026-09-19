package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfoo implements zzbfk {
    private final ScheduledExecutorService zza;
    private final Executor zzb;
    private final Map zzc = new HashMap();
    private boolean zzd = false;

    zzfoo(ScheduledExecutorService scheduledExecutorService, Executor executor) {
        this.zza = scheduledExecutorService;
        this.zzb = executor;
    }

    /* JADX INFO: renamed from: zzf */
    public final synchronized void zzc() {
        Map map = this.zzc;
        ArrayList arrayList = new ArrayList(map.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ScheduledFuture scheduledFuture = (ScheduledFuture) arrayList.get(i);
            zzfon zzfonVar = (zzfon) map.get(scheduledFuture);
            if (zzfonVar != null && scheduledFuture != null && !scheduledFuture.isDone()) {
                scheduledFuture.cancel(false);
                map.remove(scheduledFuture);
                zzb(zzfonVar.zza, Math.max(0L, zzfonVar.zzb - com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis()), TimeUnit.MILLISECONDS);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void zza(boolean z) {
        if (z) {
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfom
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzc();
                }
            });
        }
    }

    public final synchronized void zzb(Runnable runnable, long j, TimeUnit timeUnit) {
        if (!this.zzd) {
            com.google.android.gms.ads.internal.zzt.zzg().zzb(this);
            this.zzd = true;
        }
        final zzfon zzfonVar = new zzfon(this, runnable, com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() + timeUnit.toMillis(j));
        ScheduledExecutorService scheduledExecutorService = this.zza;
        Objects.requireNonNull(zzfonVar);
        zzfonVar.zzc = scheduledExecutorService.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfol
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzfon zzfonVar2;
                zzfon zzfonVar3 = zzfonVar;
                zzfoo zzfooVar = zzfonVar3.zzd;
                synchronized (zzfooVar) {
                    ScheduledFuture scheduledFuture = zzfonVar3.zzc;
                    zzfonVar2 = scheduledFuture != null ? (zzfon) zzfooVar.zze().remove(scheduledFuture) : null;
                }
                if (zzfonVar2 != null) {
                    zzfonVar3.zzd.zzd().execute(zzfonVar3.zza);
                }
            }
        }, j, timeUnit);
        this.zzc.put(zzfonVar.zzc, zzfonVar);
    }

    final /* synthetic */ Executor zzd() {
        return this.zzb;
    }

    final /* synthetic */ Map zze() {
        return this.zzc;
    }
}
