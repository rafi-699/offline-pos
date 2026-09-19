package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhjz implements zzhdi {
    private final byte[] zza;
    private final int zzb;
    private final zzhqd zzc;

    private zzhjz(byte[] bArr, zziaz zziazVar, int i) throws GeneralSecurityException {
        this.zzc = zziam.zzb(zzhqb.zzc(zzhqc.zzb(bArr.length), zzibb.zza(bArr, zzhdo.zza())));
        this.zza = zziazVar.zzc();
        this.zzb = i;
    }

    public static zzhdi zzb(zzhhw zzhhwVar) throws GeneralSecurityException {
        zzhhwVar.zzf();
        zzhhwVar.zzf();
        return new zzhjz(zzhhwVar.zze().zzc(zzhdo.zza()), zzhhwVar.zzc(), zzhhwVar.zzf().zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzhdi
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (bArr == null) {
            throw new NullPointerException("ciphertext is null");
        }
        byte[] bArr3 = this.zza;
        int i = this.zzb;
        int length = bArr.length;
        int length2 = bArr3.length;
        int i2 = i + length2;
        if (length < i2 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        if (!zzhnz.zze(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, length2, i2);
        byte[] bArr4 = {0, 1, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        byte[] bArr5 = {0, 2, 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int length3 = bArrCopyOfRange.length;
        if (length3 > 12 || length3 < 8) {
            throw new GeneralSecurityException("invalid salt size");
        }
        System.arraycopy(bArrCopyOfRange, 0, bArr4, 4, length3);
        System.arraycopy(bArrCopyOfRange, 0, bArr5, 4, length3);
        zzhqd zzhqdVar = this.zzc;
        byte[] bArr6 = new byte[32];
        System.arraycopy(zzhqdVar.zza(bArr4, 16), 0, bArr6, 0, 16);
        System.arraycopy(zzhqdVar.zza(bArr5, 16), 0, bArr6, 16, 16);
        if (!zzhkr.zza(2)) {
            throw new GeneralSecurityException("Can not use AES-GCM in FIPS-mode, as BoringCrypto module is not available.");
        }
        SecretKey secretKeyZzb = zzhiu.zzb(bArr6);
        int i3 = i2 + 12;
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i2, i3);
        if (bArrCopyOfRange2.length != 12) {
            throw new GeneralSecurityException("iv is wrong size");
        }
        if (length < i2 + 28) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        AlgorithmParameterSpec algorithmParameterSpecZzc = zzhiu.zzc(bArrCopyOfRange2, 0, 12);
        Cipher cipherZza = zzhiu.zza();
        cipherZza.init(2, secretKeyZzb, algorithmParameterSpecZzc);
        if (bArr2 != null && bArr2.length != 0) {
            cipherZza.updateAAD(bArr2);
        }
        return cipherZza.doFinal(bArr, i3, length - i3);
    }
}
