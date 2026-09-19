package com.google.android.gms.internal.ads;

import android.app.AppOpsManager;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbca implements AppOpsManager.OnOpActiveChangedListener {
    final /* synthetic */ zzbcb zza;

    zzbca(zzbcb zzbcbVar) {
        Objects.requireNonNull(zzbcbVar);
        this.zza = zzbcbVar;
    }

    @Override // android.app.AppOpsManager.OnOpActiveChangedListener
    public final void onOpActiveChanged(String str, int i, String str2, boolean z) {
        if (z) {
            zzbcb zzbcbVar = this.zza;
            zzbcbVar.zze(System.currentTimeMillis());
            zzbcbVar.zzh(true);
            return;
        }
        zzbcb zzbcbVar2 = this.zza;
        long jZzf = zzbcbVar2.zzf();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jZzf > 0 && jCurrentTimeMillis >= zzbcbVar2.zzf()) {
            zzbcbVar2.zzg(jCurrentTimeMillis - zzbcbVar2.zzf());
        }
        zzbcbVar2.zzh(false);
    }
}
