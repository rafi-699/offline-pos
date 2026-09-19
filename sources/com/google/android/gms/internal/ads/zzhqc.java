package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhqc extends zzhqf {
    private final int zza;

    private zzhqc(int i) {
        this.zza = i;
    }

    public static zzhqc zzb(int i) throws GeneralSecurityException {
        if (i == 16 || i == 32) {
            return new zzhqc(i);
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit are supported", Integer.valueOf(i * 8)));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhqc) && ((zzhqc) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzhqc.class, Integer.valueOf(this.zza));
    }

    public final String toString() {
        int i = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 34);
        sb.append("AesCmac PRF Parameters (");
        sb.append(i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return false;
    }

    public final int zzc() {
        return this.zza;
    }
}
