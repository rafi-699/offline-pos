package com.google.android.gms.internal.ads;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzasq extends Thread {
    private static final boolean zza = zzatq.zzb;
    private final BlockingQueue zzb;
    private final BlockingQueue zzc;
    private final zzaso zzd;
    private volatile boolean zze = false;
    private final zzatr zzf;
    private final zzasv zzg;

    public zzasq(BlockingQueue blockingQueue, BlockingQueue blockingQueue2, zzaso zzasoVar, zzasv zzasvVar) {
        this.zzb = blockingQueue;
        this.zzc = blockingQueue2;
        this.zzd = zzasoVar;
        this.zzg = zzasvVar;
        this.zzf = new zzatr(this, blockingQueue2, zzasvVar);
    }

    private void zzc() throws InterruptedException {
        zzate zzateVar = (zzate) this.zzb.take();
        zzateVar.zzc("cache-queue-take");
        zzateVar.zze(1);
        try {
            zzateVar.zzl();
            zzaso zzasoVar = this.zzd;
            zzasn zzasnVarZza = zzasoVar.zza(zzateVar.zzi());
            if (zzasnVarZza == null) {
                zzateVar.zzc("cache-miss");
                if (!this.zzf.zzc(zzateVar)) {
                    this.zzc.put(zzateVar);
                }
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (zzasnVarZza.zza(jCurrentTimeMillis)) {
                    zzateVar.zzc("cache-hit-expired");
                    zzateVar.zzj(zzasnVarZza);
                    if (!this.zzf.zzc(zzateVar)) {
                        this.zzc.put(zzateVar);
                    }
                } else {
                    zzateVar.zzc("cache-hit");
                    zzatk zzatkVarZzr = zzateVar.zzr(new zzata(zzasnVarZza.zza, zzasnVarZza.zzg));
                    zzateVar.zzc("cache-hit-parsed");
                    if (!zzatkVarZzr.zzc()) {
                        zzateVar.zzc("cache-parsing-failed");
                        zzasoVar.zzd(zzateVar.zzi(), true);
                        zzateVar.zzj(null);
                        if (!this.zzf.zzc(zzateVar)) {
                            this.zzc.put(zzateVar);
                        }
                    } else if (zzasnVarZza.zzf < jCurrentTimeMillis) {
                        zzateVar.zzc("cache-hit-refresh-needed");
                        zzateVar.zzj(zzasnVarZza);
                        zzatkVarZzr.zzd = true;
                        if (this.zzf.zzc(zzateVar)) {
                            this.zzg.zza(zzateVar, zzatkVarZzr, null);
                        } else {
                            this.zzg.zza(zzateVar, zzatkVarZzr, new zzasp(this, zzateVar));
                        }
                    } else {
                        this.zzg.zza(zzateVar, zzatkVarZzr, null);
                    }
                }
            }
        } finally {
            zzateVar.zze(2);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        if (zza) {
            zzatq.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.zzd.zzc();
        while (true) {
            try {
                zzc();
            } catch (InterruptedException unused) {
                if (this.zze) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzatq.zzc("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zze = true;
        interrupt();
    }

    final /* synthetic */ BlockingQueue zzb() {
        return this.zzc;
    }
}
