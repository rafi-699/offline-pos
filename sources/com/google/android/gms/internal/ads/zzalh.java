package com.google.android.gms.internal.ads;

import androidx.media3.extractor.ts.PsExtractor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalh implements zzald {
    private final zzet zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzalh(zzfy zzfyVar) {
        zzet zzetVar = zzfyVar.zza;
        this.zza = zzetVar;
        zzetVar.zzh(12);
        this.zzc = zzetVar.zzH() & 255;
        this.zzb = zzetVar.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final int zzb() {
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final int zzc() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzs();
        }
        if (i == 16) {
            return this.zza.zzt();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int iZzs = this.zza.zzs();
        this.zze = iZzs;
        return (iZzs & PsExtractor.VIDEO_STREAM_MASK) >> 4;
    }
}
