package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhyz {
    public static zzhej zza(zzhec zzhecVar, zzhnk zzhnkVar) throws GeneralSecurityException {
        zzhmc zzhmcVar = (zzhmc) zzhecVar.zzf(zzhmc.class);
        zzhmd zzhmdVarZza = (zzhmcVar == null || zzhmcVar.zza()) ? zzhmg.zza : zzhmm.zza().zzb().zza(zzhecVar, zzhmcVar, "public_key_sign", "sign");
        zzheb zzhebVar = (zzheb) zzhecVar;
        return new zzhyx(new zzhyy((zzhej) zzhnkVar.zza(zzhebVar.zzc()), zzhebVar.zzc().zzc()), zzhmdVarZza);
    }
}
