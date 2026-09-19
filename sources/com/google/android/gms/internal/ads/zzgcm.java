package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgcm {
    private static zzgcm zzb;
    final zzgci zza;

    private zzgcm(Context context) {
        this.zza = zzgci.zza(context);
        zzgch.zza(context);
    }

    public static final zzgcm zza(Context context) {
        zzgcm zzgcmVar;
        synchronized (zzgcm.class) {
            if (zzb == null) {
                zzb = new zzgcm(context);
            }
            zzgcmVar = zzb;
        }
        return zzgcmVar;
    }

    public final void zzb(zzgcg zzgcgVar) throws IOException {
        synchronized (zzgcm.class) {
            zzgci zzgciVar = this.zza;
            zzgciVar.zzf("vendor_scoped_gpid_v2_id");
            zzgciVar.zzf("vendor_scoped_gpid_v2_creation_time");
        }
    }
}
