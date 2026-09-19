package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhwm extends zzhxi {
    public static final BigInteger zza = BigInteger.valueOf(65537);
    private final int zzb;
    private final BigInteger zzc;
    private final zzhwl zzd;
    private final zzhwk zze;

    /* synthetic */ zzhwm(int i, BigInteger bigInteger, zzhwl zzhwlVar, zzhwk zzhwkVar, byte[] bArr) {
        this.zzb = i;
        this.zzc = bigInteger;
        this.zzd = zzhwlVar;
        this.zze = zzhwkVar;
    }

    public static zzhwj zzb() {
        return new zzhwj(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhwm)) {
            return false;
        }
        zzhwm zzhwmVar = (zzhwm) obj;
        return zzhwmVar.zzb == this.zzb && Objects.equals(zzhwmVar.zzc, this.zzc) && zzhwmVar.zzd == this.zzd && zzhwmVar.zze == this.zze;
    }

    public final int hashCode() {
        return Objects.hash(zzhwm.class, Integer.valueOf(this.zzb), this.zzc, this.zzd, this.zze);
    }

    public final String toString() {
        BigInteger bigInteger = this.zzc;
        zzhwk zzhwkVar = this.zze;
        String strValueOf = String.valueOf(this.zzd);
        String strValueOf2 = String.valueOf(zzhwkVar);
        String strValueOf3 = String.valueOf(bigInteger);
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(strValueOf2).length();
        int length3 = String.valueOf(strValueOf3).length();
        int i = this.zzb;
        StringBuilder sb = new StringBuilder(length + 47 + length2 + 18 + length3 + 6 + String.valueOf(i).length() + 13);
        sb.append("RSA SSA PKCS1 Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", hashType: ");
        sb.append(strValueOf2);
        sb.append(", publicExponent: ");
        sb.append(strValueOf3);
        sb.append(", and ");
        sb.append(i);
        sb.append("-bit modulus)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhwl.zzd;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final BigInteger zzd() {
        return this.zzc;
    }

    public final zzhwl zze() {
        return this.zzd;
    }

    public final zzhwk zzf() {
        return this.zze;
    }
}
