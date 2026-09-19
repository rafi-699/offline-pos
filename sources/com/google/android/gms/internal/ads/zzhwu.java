package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhwu {
    public static final /* synthetic */ int zza = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhwr.zza, zzhwo.class, zzhej.class);
    private static final zzhnf zzc = zzhnf.zzd(zzhwt.zza, zzhwq.class, zzhek.class);
    private static final zzhei zzd = zzhlw.zzf("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey", zzhej.class, zzhtu.zzl());
    private static final zzhdr zze = zzhlw.zze("type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PublicKey", zzhek.class, zzhsp.ASYMMETRIC_PUBLIC, zzhtw.zzi());
    private static final zzhln zzf = zzhws.zza;
    private static final int zzg = 2;

    public static void zza(boolean z) throws GeneralSecurityException {
        int i = zzg;
        if (!zzhkr.zza(i)) {
            throw new GeneralSecurityException("Can not use RSA SSA PKCS1 in FIPS-mode, as BoringCrypto module is not available.");
        }
        int i2 = zzhyl.zza;
        zzhyl.zza(zzhmr.zza());
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("RSA_SSA_PKCS1_3072_SHA256_F4", zzhwe.zzh);
        BigInteger bigInteger = zzhwm.zza;
        zzhwj zzhwjVar = new zzhwj(null);
        zzhwjVar.zzd(zzhwk.zza);
        zzhwjVar.zza(3072);
        BigInteger bigInteger2 = zzhwm.zza;
        zzhwjVar.zzb(bigInteger2);
        zzhwl zzhwlVar = zzhwl.zzd;
        zzhwjVar.zzc(zzhwlVar);
        map.put("RSA_SSA_PKCS1_3072_SHA256_F4_RAW", zzhwjVar.zze());
        map.put("RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX", zzhwe.zzi);
        map.put("RSA_SSA_PKCS1_4096_SHA512_F4", zzhwe.zzj);
        zzhwj zzhwjVar2 = new zzhwj(null);
        zzhwjVar2.zzd(zzhwk.zzc);
        zzhwjVar2.zza(4096);
        zzhwjVar2.zzb(bigInteger2);
        zzhwjVar2.zzc(zzhwlVar);
        map.put("RSA_SSA_PKCS1_4096_SHA512_F4_RAW", zzhwjVar2.zze());
        zzhmnVarZza.zzd(map);
        zzhmo.zza().zzb(zzb);
        zzhmo.zza().zzb(zzc);
        zzhmi.zza().zzb(zzf, zzhwm.class);
        zzhlo.zza().zzf(zzd, i, true);
        zzhlo.zza().zzf(zze, i, false);
    }
}
