package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhpa implements zzhnl {
    private static final zzhpa zza = new zzhpa();
    private static final zzhnf zzb = zzhnf.zzd(zzhoz.zza, zzhlz.class, zzheg.class);

    zzhpa() {
    }

    static void zzc() throws GeneralSecurityException {
        zzhmo.zza().zzc(zza);
        zzhmo.zza().zzb(zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzhnl
    public final Class zza() {
        return zzheg.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhnl
    public final Class zzb() {
        return zzheg.class;
    }

    @Override // com.google.android.gms.internal.ads.zzhnl
    public final /* synthetic */ Object zzd(zzhec zzhecVar, zzhnk zzhnkVar) throws GeneralSecurityException {
        return zzhqa.zza(zzhecVar, zzhnkVar);
    }
}
