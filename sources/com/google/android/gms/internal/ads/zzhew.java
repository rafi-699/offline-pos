package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhew implements zzhnl {
    private static final zzhew zza = new zzhew();
    private static final zzhnf zzb = zzhnf.zzd(zzhev.zza, zzhlz.class, zzhdi.class);

    zzhew() {
    }

    public static void zzc() throws GeneralSecurityException {
        zzhmo.zza().zzc(zza);
        zzhmo.zza().zzb(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzhnl
    public final Class zza() {
        return zzhdi.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhnl
    public final Class zzb() {
        return zzhdi.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhnl
    public final /* synthetic */ Object zzd(zzhec zzhecVar, zzhnk zzhnkVar) throws GeneralSecurityException {
        return zzhjy.zza(zzhecVar, zzhnkVar);
    }
}
