package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzqg {
    public static final zzqg zza;
    public final int zzb;
    public final int zzc;
    private final zzgww zzd;

    static {
        zzqg zzqgVar;
        if (Build.VERSION.SDK_INT >= 33) {
            zzgwv zzgwvVar = new zzgwv();
            for (int i = 1; i <= 10; i++) {
                zzgwvVar.zzf(Integer.valueOf(zzfl.zzE(i)));
            }
            zzqgVar = new zzqg(2, zzgwvVar.zzh());
        } else {
            zzqgVar = new zzqg(2, 10);
        }
        zza = zzqgVar;
    }

    public zzqg(int i, int i2) {
        this.zzb = i;
        this.zzc = i2;
        this.zzd = null;
    }

    public zzqg(int i, Set set) {
        this.zzb = i;
        zzgww zzgwwVarZzp = zzgww.zzp(set);
        this.zzd = zzgwwVarZzp;
        zzgza it = zzgwwVarZzp.iterator();
        int iMax = 0;
        while (it.hasNext()) {
            iMax = Math.max(iMax, Integer.bitCount(((Integer) it.next()).intValue()));
        }
        this.zzc = iMax;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzqg)) {
            return false;
        }
        zzqg zzqgVar = (zzqg) obj;
        return this.zzb == zzqgVar.zzb && this.zzc == zzqgVar.zzc && Objects.equals(this.zzd, zzqgVar.zzd);
    }

    public final int hashCode() {
        zzgww zzgwwVar = this.zzd;
        return (((this.zzb * 31) + this.zzc) * 31) + (zzgwwVar == null ? 0 : zzgwwVar.hashCode());
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zzd);
        int i = this.zzb;
        int length = String.valueOf(i).length();
        int i2 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 38 + String.valueOf(i2).length() + 15 + String.valueOf(strValueOf).length() + 1);
        sb.append("AudioProfile[format=");
        sb.append(i);
        sb.append(", maxChannelCount=");
        sb.append(i2);
        sb.append(", channelMasks=");
        sb.append(strValueOf);
        sb.append("]");
        return sb.toString();
    }

    public final boolean zza(int i) {
        zzgww zzgwwVar = this.zzd;
        if (zzgwwVar == null) {
            return i <= this.zzc;
        }
        int iZzE = zzfl.zzE(i);
        if (iZzE == 0) {
            return false;
        }
        return zzgwwVar.contains(Integer.valueOf(iZzE));
    }

    public final int zzb(int i, zzd zzdVar) {
        if (this.zzd != null) {
            return this.zzc;
        }
        if (Build.VERSION.SDK_INT < 29) {
            Integer num = (Integer) zzqh.zzb.getOrDefault(Integer.valueOf(this.zzb), 0);
            num.getClass();
            return num.intValue();
        }
        int i2 = this.zzb;
        for (int i3 = 10; i3 > 0; i3--) {
            int iZzE = zzfl.zzE(i3);
            if (iZzE != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i2).setSampleRate(i).setChannelMask(iZzE).build(), zzdVar.zza())) {
                return i3;
            }
        }
        return 0;
    }
}
