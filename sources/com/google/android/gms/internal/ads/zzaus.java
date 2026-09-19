package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Date;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaus extends zzimd {
    private Date zzg;
    private Date zzh;
    private long zzi;
    private long zzj;
    private double zzk;
    private float zzl;
    private zzimn zzm;
    private long zzn;

    public zzaus() {
        super("mvhd");
        this.zzk = 1.0d;
        this.zzl = 1.0f;
        this.zzm = zzimn.zzj;
    }

    public final String toString() {
        return "MovieHeaderBox[creationTime=" + this.zzg + ";modificationTime=" + this.zzh + ";timescale=" + this.zzi + ";duration=" + this.zzj + ";rate=" + this.zzk + ";volume=" + this.zzl + ";matrix=" + this.zzm + ";nextTrackId=" + this.zzn + "]";
    }

    public final long zzc() {
        return this.zzi;
    }

    public final long zzd() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzimb
    public final void zze(ByteBuffer byteBuffer) {
        zzh(byteBuffer);
        if (zzg() == 1) {
            this.zzg = zzimi.zza(zzauo.zzd(byteBuffer));
            this.zzh = zzimi.zza(zzauo.zzd(byteBuffer));
            this.zzi = zzauo.zza(byteBuffer);
            this.zzj = zzauo.zzd(byteBuffer);
        } else {
            this.zzg = zzimi.zza(zzauo.zza(byteBuffer));
            this.zzh = zzimi.zza(zzauo.zza(byteBuffer));
            this.zzi = zzauo.zza(byteBuffer);
            this.zzj = zzauo.zza(byteBuffer);
        }
        this.zzk = zzauo.zze(byteBuffer);
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        this.zzl = ((short) ((bArr[1] & 255) | ((short) (65280 & (bArr[0] << 8))))) / 256.0f;
        zzauo.zzb(byteBuffer);
        zzauo.zza(byteBuffer);
        zzauo.zza(byteBuffer);
        this.zzm = new zzimn(zzauo.zze(byteBuffer), zzauo.zze(byteBuffer), zzauo.zze(byteBuffer), zzauo.zze(byteBuffer), zzauo.zzf(byteBuffer), zzauo.zzf(byteBuffer), zzauo.zzf(byteBuffer), zzauo.zze(byteBuffer), zzauo.zze(byteBuffer));
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        byteBuffer.getInt();
        this.zzn = zzauo.zza(byteBuffer);
    }
}
