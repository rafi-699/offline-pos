package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhgt {
    public static final /* synthetic */ int zza = 0;
    private static final zzhdr zzb = zzhlw.zze("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", zzhdi.class, zzhsp.SYMMETRIC, zzhtj.zze());
    private static final zzhln zzc = zzhgs.zza;
    private static final zzhnf zzd = zzhnf.zzd(zzhgr.zza, zzhhc.class, zzhdi.class);

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Registering KMS Envelope AEAD is not supported in FIPS mode");
        }
        int i = zzhhl.zza;
        zzhhl.zza(zzhmr.zza());
        zzhmi.zza().zzb(zzc, zzhhg.class);
        zzhmo.zza().zzb(zzd);
        zzhlo.zza().zzb(zzb, true);
    }
}
