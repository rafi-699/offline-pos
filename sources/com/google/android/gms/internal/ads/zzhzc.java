package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhzc {
    public static zzhek zza(zzhec zzhecVar, zzhnk zzhnkVar) throws GeneralSecurityException {
        zziaz zziazVarZzd;
        zzhna zzhnaVar = new zzhna();
        for (int i = 0; i < zzhecVar.zzd(); i++) {
            zzhdz zzhdzVarZze = ((zzheb) zzhecVar).zze(i);
            if (zzhdzVarZze.zzb().equals(zzhds.zza)) {
                zzhek zzhekVar = (zzhek) zzhnkVar.zza(zzhdzVarZze);
                zzhdq zzhdqVarZza = zzhdzVarZze.zza();
                if (zzhdqVarZza instanceof zzhxk) {
                    zziazVarZzd = ((zzhxk) zzhdqVarZza).zze();
                } else {
                    if (!(zzhdqVarZza instanceof zzhlz)) {
                        String name = zzhdqVarZza.getClass().getName();
                        String strValueOf = String.valueOf(zzhdqVarZza.zza());
                        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 59 + String.valueOf(strValueOf).length());
                        sb.append("Cannot get output prefix for key of class ");
                        sb.append(name);
                        sb.append(" with parameters ");
                        sb.append(strValueOf);
                        throw new GeneralSecurityException(sb.toString());
                    }
                    zziazVarZzd = ((zzhlz) zzhdqVarZza).zzd();
                }
                zzhnaVar.zza(zziazVarZzd, new zzhzb(zzhekVar, zzhdzVarZze.zzc()));
            }
        }
        zzhmc zzhmcVar = (zzhmc) zzhecVar.zzf(zzhmc.class);
        return new zzhza(zzhnaVar.zzb(), (zzhmcVar == null || zzhmcVar.zza()) ? zzhmg.zza : zzhmm.zza().zzb().zza(zzhecVar, zzhmcVar, "public_key_verify", "verify"));
    }
}
