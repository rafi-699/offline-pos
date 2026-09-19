package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;
import java.security.Signature;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhym implements zzhej {
    private static final byte[] zzb = new byte[0];
    private static final byte[] zzc = {0};
    private static final byte[] zzd = {1, 2, 3};

    @Nullable
    Provider zza;
    private final RSAPrivateCrtKey zze;
    private final String zzf;
    private final byte[] zzg;
    private final byte[] zzh;
    private final zzhek zzi;

    private zzhym(RSAPrivateCrtKey rSAPrivateCrtKey, zzhwk zzhwkVar, byte[] bArr, byte[] bArr2, zzhek zzhekVar, @Nullable Provider provider) throws GeneralSecurityException {
        if (!zzhkr.zza(2)) {
            throw new GeneralSecurityException("Can not use RSA PKCS1.5 in FIPS-mode, as BoringCrypto module is not available.");
        }
        if (zzhwkVar != zzhwk.zza && zzhwkVar != zzhwk.zzb && zzhwkVar != zzhwk.zzc) {
            String strValueOf = String.valueOf(zzhwkVar);
            String.valueOf(strValueOf);
            throw new GeneralSecurityException("Unsupported hash: ".concat(String.valueOf(strValueOf)));
        }
        zziax.zzc(rSAPrivateCrtKey.getModulus().bitLength());
        zziax.zzd(rSAPrivateCrtKey.getPublicExponent());
        this.zze = rSAPrivateCrtKey;
        this.zzf = zzhyn.zzc(zzhwkVar);
        this.zzg = bArr;
        this.zzh = bArr2;
        this.zzi = zzhekVar;
        this.zza = provider;
    }

    public static zzhej zzb(zzhwo zzhwoVar) throws GeneralSecurityException {
        Provider providerZzb = zzhyn.zzb();
        zzhym zzhymVar = new zzhym((RSAPrivateCrtKey) (providerZzb != null ? KeyFactory.getInstance("RSA", providerZzb) : (KeyFactory) zzhzz.zzf.zzb("RSA")).generatePrivate(new RSAPrivateCrtKeySpec(zzhwoVar.zze().zzd(), zzhwoVar.zzd().zzd(), zzhwoVar.zzi().zzb(zzhdo.zza()), zzhwoVar.zzf().zzb(zzhdo.zza()), zzhwoVar.zzh().zzb(zzhdo.zza()), zzhwoVar.zzj().zzb(zzhdo.zza()), zzhwoVar.zzk().zzb(zzhdo.zza()), zzhwoVar.zzl().zzb(zzhdo.zza()))), zzhwoVar.zzd().zzf(), zzhwoVar.zze().zze().zzc(), zzhwoVar.zzd().zze().equals(zzhwl.zzc) ? zzc : zzb, providerZzb != null ? zzhyn.zze(zzhwoVar.zze(), providerZzb) : zziar.zzb(zzhwoVar.zze()), providerZzb);
        zzhymVar.zza(zzd);
        return zzhymVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        Signature signature;
        Provider provider = this.zza;
        if (provider != null) {
            signature = Signature.getInstance(this.zzf, provider);
        } else {
            signature = (Signature) zzhzz.zzc.zzb(this.zzf);
        }
        signature.initSign(this.zze);
        signature.update(bArr);
        byte[] bArr2 = this.zzh;
        if (bArr2.length > 0) {
            signature.update(bArr2);
        }
        byte[] bArrSign = signature.sign();
        byte[] bArr3 = this.zzg;
        if (bArr3.length > 0) {
            bArrSign = zzhzl.zza(bArr3, bArrSign);
        }
        try {
            this.zzi.zza(bArrSign, bArr);
            return bArrSign;
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException("RSA signature computation error", e);
        }
    }
}
