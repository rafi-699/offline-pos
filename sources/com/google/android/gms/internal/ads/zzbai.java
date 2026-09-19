package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbai implements Runnable {
    final /* synthetic */ zzbaj zza;

    zzbai(zzbaj zzbajVar) {
        Objects.requireNonNull(zzbajVar);
        this.zza = zzbajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zBooleanValue;
        zzbaj zzbajVar = this.zza;
        if (zzbajVar.zzb != null) {
            return;
        }
        synchronized (zzbaj.zzd) {
            if (zzbajVar.zzb != null) {
                return;
            }
            boolean z = false;
            try {
                zBooleanValue = ((Boolean) zzbiq.zzdu.zze()).booleanValue();
            } catch (IllegalStateException unused) {
                zBooleanValue = false;
            }
            if (zBooleanValue) {
                try {
                    zzbaj.zza = zzfzc.zzb(this.zza.zzb().zza, "ADSHIELD", null);
                } catch (Throwable unused2) {
                }
            }
            z = zBooleanValue;
            this.zza.zzb = Boolean.valueOf(z);
            zzbaj.zzd.open();
        }
    }
}
