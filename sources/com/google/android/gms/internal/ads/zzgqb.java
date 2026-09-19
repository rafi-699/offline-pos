package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgqb implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzgqd zza;

    zzgqb(zzgqd zzgqdVar) {
        Objects.requireNonNull(zzgqdVar);
        this.zza = zzgqdVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        zzgqd zzgqdVar = this.zza;
        synchronized (zzgqdVar) {
            try {
                if (z) {
                    zzgqdVar.zzg(System.currentTimeMillis());
                    zzgqdVar.zzj(true);
                } else {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (zzgqdVar.zzh() > 0 && jCurrentTimeMillis >= zzgqdVar.zzh()) {
                        zzgqdVar.zzi(jCurrentTimeMillis - zzgqdVar.zzh());
                    }
                    zzgqdVar.zzj(false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
