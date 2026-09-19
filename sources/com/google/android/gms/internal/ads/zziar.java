package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPublicKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zziar implements zzhek {
    static final zzhli zza;
    private static final byte[] zzb = new byte[0];
    private static final byte[] zzc = {0};

    static {
        zzhlh zzhlhVarZza = zzhli.zza();
        zzhlhVarZza.zza(zziai.SHA256, zzhwk.zza);
        zzhlhVarZza.zza(zziai.SHA384, zzhwk.zzb);
        zzhlhVarZza.zza(zziai.SHA512, zzhwk.zzc);
        zza = zzhlhVarZza.zzb();
    }

    public static zzhek zzb(zzhwq zzhwqVar) throws GeneralSecurityException {
        try {
            return zzhyn.zzd(zzhwqVar);
        } catch (NoSuchProviderException unused) {
            return new zziaq((RSAPublicKey) ((KeyFactory) zzhzz.zzf.zzb("RSA")).generatePublic(new RSAPublicKeySpec(zzhwqVar.zzd(), zzhwqVar.zzf().zzd())), (zziai) zza.zzb(zzhwqVar.zzf().zzf()), zzhwqVar.zze().zzc(), zzhwqVar.zzf().zze().equals(zzhwl.zzc) ? zzc : zzb, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
