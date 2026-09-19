package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhfl {
    public static final /* synthetic */ int zza = 0;
    private static final zzhnf zzb = zzhnf.zzd(zzhfj.zza, zzhfi.class, zzhdi.class);
    private static final zzhdr zzc = zzhlw.zze("type.googleapis.com/google.crypto.tink.AesEaxKey", zzhdi.class, zzhsp.SYMMETRIC, zzhra.zzg());
    private static final zzhln zzd = zzhfk.zza;

    public static void zza(boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Registering AES EAX is not supported in FIPS mode");
        }
        int i = zzhis.zza;
        zzhis.zza(zzhmr.zza());
        zzhmo.zza().zzb(zzb);
        zzhmn zzhmnVarZza = zzhmn.zza();
        HashMap map = new HashMap();
        map.put("AES128_EAX", zzhhv.zzc);
        zzhfm zzhfmVar = new zzhfm(null);
        zzhfmVar.zzb(16);
        zzhfmVar.zza(16);
        zzhfmVar.zzc(16);
        zzhfn zzhfnVar = zzhfn.zzc;
        zzhfmVar.zzd(zzhfnVar);
        map.put("AES128_EAX_RAW", zzhfmVar.zze());
        map.put("AES256_EAX", zzhhv.zzd);
        zzhfm zzhfmVar2 = new zzhfm(null);
        zzhfmVar2.zzb(16);
        zzhfmVar2.zza(32);
        zzhfmVar2.zzc(16);
        zzhfmVar2.zzd(zzhfnVar);
        map.put("AES256_EAX_RAW", zzhfmVar2.zze());
        zzhmnVarZza.zzd(Collections.unmodifiableMap(map));
        zzhmi.zza().zzb(zzd, zzhfo.class);
        zzhlo.zza().zzb(zzc, true);
    }
}
