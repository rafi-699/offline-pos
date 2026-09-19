package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhfo extends zzheu {
    private final int zza;
    private final int zzb;
    private final int zzc = 16;
    private final zzhfn zzd;

    /* synthetic */ zzhfo(int i, int i2, int i3, zzhfn zzhfnVar, byte[] bArr) {
        this.zza = i;
        this.zzb = i2;
        this.zzd = zzhfnVar;
    }

    public static zzhfm zzb() {
        return new zzhfm(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhfo)) {
            return false;
        }
        zzhfo zzhfoVar = (zzhfo) obj;
        if (zzhfoVar.zza == this.zza && zzhfoVar.zzb == this.zzb) {
            int i = zzhfoVar.zzc;
            if (zzhfoVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzhfo.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = String.valueOf(strValueOf).length();
        int i = this.zzb;
        int length2 = String.valueOf(i).length();
        int length3 = String.valueOf(16).length();
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 10 + length3 + 15 + String.valueOf(i2).length() + 10);
        sb.append("AesEax Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", ");
        sb.append(i);
        sb.append("-byte IV, 16-byte tag, and ");
        sb.append(i2);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhfn.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzb;
    }

    public final zzhfn zze() {
        return this.zzd;
    }
}
