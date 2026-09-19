package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbto extends zzcgd {
    private final Object zza = new Object();
    private final zzbtt zzb;
    private boolean zzc;

    public zzbto(zzbtt zzbttVar) {
        this.zzb = zzbttVar;
    }

    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("release: Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("release: Lock acquired");
            if (this.zzc) {
                com.google.android.gms.ads.internal.util.zze.zza("release: Lock already released");
                return;
            }
            this.zzc = true;
            zze(new zzbtl(this), new zzcfz());
            zze(new zzbtm(this), new zzbtn(this));
            com.google.android.gms.ads.internal.util.zze.zza("release: Lock released");
        }
    }

    final /* synthetic */ zzbtt zzb() {
        return this.zzb;
    }
}
