package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhem {
    public static zzheb zza(String str) throws GeneralSecurityException {
        try {
            try {
                try {
                    zzhsz zzhszVarZze = zzhsz.zze(zzhdp.zza(str).zzb().zzaN(), zzido.zza());
                    for (zzhsy zzhsyVar : zzhszVarZze.zzb()) {
                        if (zzhsyVar.zzb().zzc() == zzhsp.UNKNOWN_KEYMATERIAL || zzhsyVar.zzb().zzc() == zzhsp.SYMMETRIC || zzhsyVar.zzb().zzc() == zzhsp.ASYMMETRIC_PRIVATE) {
                            throw new GeneralSecurityException(String.format("keyset contains key material of type %s for type url %s", zzhsyVar.zzb().zzc().name(), zzhsyVar.zzb().zza()));
                        }
                    }
                    return zzheb.zza(zzhszVarZze);
                } catch (zziet unused) {
                    throw new GeneralSecurityException("invalid keyset");
                }
            } catch (zziet unused2) {
                throw new GeneralSecurityException("invalid keyset");
            }
        } catch (IOException unused3) {
            throw new GeneralSecurityException("Parse keyset failed");
        }
    }
}
