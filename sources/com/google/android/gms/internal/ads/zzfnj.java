package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfnj {
    private final zzfmn zza;
    private final zzfng zzb;
    private final zzfmj zzc;
    private zzfnp zze;
    private int zzf = 1;
    private final ArrayDeque zzd = new ArrayDeque();

    public zzfnj(zzfmn zzfmnVar, zzfmj zzfmjVar, zzfng zzfngVar) {
        this.zza = zzfmnVar;
        this.zzc = zzfmjVar;
        this.zzb = zzfngVar;
        zzfmjVar.zza(new zzfmi() { // from class: com.google.android.gms.internal.ads.zzfni
            @Override // com.google.android.gms.internal.ads.zzfmi
            public final /* synthetic */ void zza() {
                this.zza.zzc();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final synchronized void zzd() {
        zzfnh zzfnhVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhk)).booleanValue() && !com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzi()) {
            this.zzd.clear();
            return;
        }
        if (zzi()) {
            while (true) {
                ArrayDeque arrayDeque = this.zzd;
                if (!arrayDeque.isEmpty()) {
                    zzfnhVar = (zzfnh) arrayDeque.pollFirst();
                    if (zzfnhVar == null || (zzfnhVar.zzb() != null && this.zza.zzc(zzfnhVar.zzb()))) {
                        break;
                    }
                }
            }
            zzfnp zzfnpVar = new zzfnp(this.zza, this.zzb, zzfnhVar);
            this.zze = zzfnpVar;
            zzfnpVar.zza(new zzfne(this, zzfnhVar));
        }
    }

    private final synchronized boolean zzi() {
        return this.zze == null;
    }

    public final synchronized void zza(zzfnh zzfnhVar) {
        this.zzd.add(zzfnhVar);
    }

    public final synchronized ListenableFuture zzb(zzfnh zzfnhVar) {
        this.zzf = 2;
        if (zzi()) {
            return null;
        }
        return this.zze.zzb(zzfnhVar);
    }

    final /* synthetic */ void zzc() {
        synchronized (this) {
            this.zzf = 1;
            zzd();
        }
    }

    final /* synthetic */ ArrayDeque zze() {
        return this.zzd;
    }

    final /* synthetic */ void zzf(zzfnp zzfnpVar) {
        this.zze = null;
    }

    final /* synthetic */ int zzg() {
        return this.zzf;
    }
}
