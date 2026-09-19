package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzalg implements zzald {
    private final int zza;
    private final int zzb;
    private final zzet zzc;

    public zzalg(zzfy zzfyVar, zzv zzvVar) {
        zzet zzetVar = zzfyVar.zza;
        this.zzc = zzetVar;
        zzetVar.zzh(12);
        int iZzH = zzetVar.zzH();
        if (MimeTypes.AUDIO_RAW.equals(zzvVar.zzp)) {
            int iZzG = zzfl.zzG(zzvVar.zzJ) * zzvVar.zzH;
            if (iZzH % iZzG != 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(iZzG).length() + 66 + String.valueOf(iZzH).length());
                sb.append("Audio sample size mismatch. stsd sample size: ");
                sb.append(iZzG);
                sb.append(", stsz sample size: ");
                sb.append(iZzH);
                zzeg.zzc("BoxParsers", sb.toString());
                iZzH = iZzG;
            }
        }
        this.zza = iZzH == 0 ? -1 : iZzH;
        this.zzb = zzetVar.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final int zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzald
    public final int zzc() {
        int i = this.zza;
        return i == -1 ? this.zzc.zzH() : i;
    }
}
