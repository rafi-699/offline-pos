package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhfx extends zzheu {
    private final int zza;
    private final int zzb = 12;
    private final int zzc = 16;
    private final zzhfw zzd;

    /* synthetic */ zzhfx(int i, int i2, int i3, zzhfw zzhfwVar, byte[] bArr) {
        this.zza = i;
        this.zzd = zzhfwVar;
    }

    public static zzhfv zzb() {
        return new zzhfv(null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzhfx)) {
            return false;
        }
        zzhfx zzhfxVar = (zzhfx) obj;
        if (zzhfxVar.zza == this.zza) {
            int i = zzhfxVar.zzb;
            int i2 = zzhfxVar.zzc;
            if (zzhfxVar.zzd == this.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzhfx.class, Integer.valueOf(this.zza), 12, 16, this.zzd);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int length = String.valueOf(strValueOf).length();
        int length2 = String.valueOf(12).length();
        int length3 = String.valueOf(16).length();
        int i = this.zza;
        StringBuilder sb = new StringBuilder(length + 30 + length2 + 10 + length3 + 15 + String.valueOf(i).length() + 10);
        sb.append("AesGcm Parameters (variant: ");
        sb.append(strValueOf);
        sb.append(", 12-byte IV, 16-byte tag, and ");
        sb.append(i);
        sb.append("-byte key)");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zzd != zzhfw.zzc;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzhfw zzd() {
        return this.zzd;
    }
}
