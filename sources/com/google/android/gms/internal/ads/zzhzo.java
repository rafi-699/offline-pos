package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhzo implements zzhej {
    private final byte[] zza;

    private zzhzo(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException(String.format("Given private key's length is not %s", 32));
        }
        byte[] bArrZzb = zzhlc.zzb(bArr);
        this.zza = bArrZzb;
        zzhlc.zza(bArrZzb);
    }

    public static zzhej zzb(zzhvf zzhvfVar) throws GeneralSecurityException {
        if (!zzhkr.zza(1)) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        try {
            return zzhyb.zzb(zzhvfVar);
        } catch (GeneralSecurityException unused) {
            return new zzhzo(zzhvfVar.zzf().zzc(zzhdo.zza()), zzhvfVar.zze().zze().zzc(), zzhvfVar.zzd().zzc().equals(zzhvd.zzc) ? new byte[]{0} : new byte[0]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        throw null;
    }
}
