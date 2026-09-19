package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhxh {
    static {
        int i = zzhto.zza;
        try {
            zza();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzhwg.zzc();
        zzhwi.zzc();
        zzhvc.zza(true);
        zzhwu.zza(true);
        zzhxg.zza(true);
        if (zzhks.zza()) {
            return;
        }
        zzhvk.zza(true);
    }
}
