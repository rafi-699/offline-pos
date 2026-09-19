package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhpx {
    public static zzhoj zza(zzhec zzhecVar, zzhnk zzhnkVar) throws GeneralSecurityException {
        zziaz zziazVarZzd;
        zzheb zzhebVar = (zzheb) zzhecVar;
        zzhdz zzhdzVarZzc = zzhebVar.zzc();
        zzhna zzhnaVar = new zzhna();
        for (int i = 0; i < zzhecVar.zzd(); i++) {
            zzhdz zzhdzVarZze = zzhebVar.zze(i);
            if (zzhdzVarZze.zzb().equals(zzhds.zza)) {
                zzhoj zzhojVar = (zzhoj) zzhnkVar.zza(zzhdzVarZze);
                zzhdq zzhdqVarZza = zzhdzVarZze.zza();
                if (zzhdqVarZza instanceof zzhox) {
                    zziazVarZzd = ((zzhox) zzhdqVarZza).zze();
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
                zzhnaVar.zza(zziazVarZzd, zzhojVar);
            }
        }
        return new zzhpw(zzhnaVar.zzb(), (zzhoj) zzhnkVar.zza(zzhdzVarZzc), null);
    }
}
