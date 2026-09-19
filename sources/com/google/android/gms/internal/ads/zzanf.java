package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzanf {
    public static void zza(zzang zzangVar, zzank zzankVar, zzdt zzdtVar) {
        for (int i = 0; i < zzangVar.zza(); i++) {
            long jZzb = zzangVar.zzb(i);
            List listZzc = zzangVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i == zzangVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                long jZzb2 = zzangVar.zzb(i + 1) - zzangVar.zzb(i);
                if (jZzb2 > 0) {
                    zzdtVar.zza(new zzand(listZzc, jZzb, jZzb2));
                }
            }
        }
    }
}
