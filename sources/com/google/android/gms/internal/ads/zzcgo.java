package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcgo implements Runnable {
    final /* synthetic */ zzcgr zza;

    zzcgo(zzcgr zzcgrVar) {
        Objects.requireNonNull(zzcgrVar);
        this.zza = zzcgrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcgr zzcgrVar = this.zza;
        if (zzcgrVar.zzt() != null) {
            if (!zzcgrVar.zzu()) {
                zzcgrVar.zzt().zzk();
                zzcgrVar.zzv(true);
            }
            zzcgrVar.zzt().zzc();
        }
    }
}
