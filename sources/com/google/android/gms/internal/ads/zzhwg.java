package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhwg implements zzhnl {
    private static final zzhwg zza = new zzhwg();
    private static final zzhnf zzb = zzhnf.zzd(zzhwf.zza, zzhlz.class, zzhej.class);

    zzhwg() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzhmo.zza().zzc(zza);
        zzhmo.zza().zzb(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzhnl
    public final Class zza() {
        return zzhej.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhnl
    public final Class zzb() {
        return zzhej.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhnl
    public final /* synthetic */ Object zzd(zzhec zzhecVar, zzhnk zzhnkVar) throws GeneralSecurityException {
        return zzhyz.zza(zzhecVar, zzhnkVar);
    }
}
