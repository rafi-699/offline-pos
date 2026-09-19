package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfuj {
    private boolean zza;

    final boolean zza() {
        return this.zza;
    }

    final void zzb(Context context) {
        zzfwi.zzb(context, "Application Context cannot be null");
        if (this.zza) {
            return;
        }
        this.zza = true;
        zzfvq.zza().zzb(context);
        zzfvh.zza().zzd(context);
        zzfwd.zza(context);
        zzfwe.zza(context);
        zzfwh.zza(context);
        zzfvn.zza().zzc(context);
        zzfvg.zza().zzc(context);
        zzfvs.zza().zzb(context);
    }
}
