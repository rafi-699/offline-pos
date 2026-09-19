package com.google.android.gms.internal.ads;

import androidx.media3.extractor.metadata.id3.ChapterFrame;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzajg extends zzajo implements zzaiv {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzajo[] zzg;

    public zzajg(String str, int i, int i2, long j, long j2, zzajo[] zzajoVarArr) {
        super(ChapterFrame.ID);
        zzgtj.zza(i <= i2);
        this.zza = str;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = j2;
        this.zzg = zzajoVarArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzajg zzajgVar = (zzajg) obj;
            if (this.zzb == zzajgVar.zzb && this.zzc == zzajgVar.zzc && this.zzd == zzajgVar.zzd && this.zze == zzajgVar.zze && Objects.equals(this.zza, zzajgVar.zza) && Arrays.equals(this.zzg, zzajgVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb + 527;
        String str = this.zza;
        long j = this.zze;
        return (((((((i * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) j)) * 31) + str.hashCode();
    }
}
