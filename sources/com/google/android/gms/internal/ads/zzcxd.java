package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcxd implements zzbeq {
    private final zzcku zza;
    private final Executor zzb;
    private final AtomicReference zzc = new AtomicReference();

    zzcxd(zzcku zzckuVar, Executor executor) {
        this.zza = zzckuVar;
        this.zzb = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbeq
    public final synchronized void zzdj(zzbep zzbepVar) {
        final zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoc)).booleanValue()) {
                if (zzbepVar.zzj) {
                    if (!Boolean.TRUE.equals(this.zzc.getAndSet(true))) {
                        Executor executor = this.zzb;
                        Objects.requireNonNull(zzckuVar);
                        executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcxc
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzckuVar.onResume();
                            }
                        });
                    }
                } else {
                    if (!Boolean.FALSE.equals(this.zzc.getAndSet(false))) {
                        Executor executor2 = this.zzb;
                        Objects.requireNonNull(zzckuVar);
                        executor2.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcxb
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzckuVar.onPause();
                            }
                        });
                    }
                }
            }
        }
    }
}
