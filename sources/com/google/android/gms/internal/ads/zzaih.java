package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaih extends zzaim {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzaih(zzahk zzahkVar) {
        super(zzahkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    protected final boolean zza(zzet zzetVar) throws zzail {
        if (this.zzc) {
            zzetVar.zzk(1);
        } else {
            int iZzs = zzetVar.zzs();
            int i = iZzs >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(iZzs >> 2) & 3];
                zzt zztVar = new zzt();
                zztVar.zzn(MimeTypes.VIDEO_FLV);
                zztVar.zzo(MimeTypes.AUDIO_MPEG);
                zztVar.zzG(1);
                zztVar.zzH(i2);
                this.zza.zzA(zztVar.zzO());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzt zztVar2 = new zzt();
                zztVar2.zzn(MimeTypes.VIDEO_FLV);
                zztVar2.zzo(i == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW);
                zztVar2.zzG(1);
                zztVar2.zzH(8000);
                this.zza.zzA(zztVar2.zzO());
                this.zzd = true;
            } else if (i != 10) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 28);
                sb.append("Audio format not supported: ");
                sb.append(i);
                throw new zzail(sb.toString());
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaim
    protected final boolean zzb(zzet zzetVar, long j) throws zzat {
        if (this.zze == 2) {
            int iZzd = zzetVar.zzd();
            zzahk zzahkVar = this.zza;
            zzahkVar.zzc(zzetVar, iZzd);
            zzahkVar.zze(j, 1, iZzd, 0, null);
            return true;
        }
        int iZzs = zzetVar.zzs();
        if (iZzs != 0 || this.zzd) {
            if (this.zze == 10 && iZzs != 1) {
                return false;
            }
            int iZzd2 = zzetVar.zzd();
            zzahk zzahkVar2 = this.zza;
            zzahkVar2.zzc(zzetVar, iZzd2);
            zzahkVar2.zze(j, 1, iZzd2, 0, null);
            return true;
        }
        int iZzd3 = zzetVar.zzd();
        byte[] bArr = new byte[iZzd3];
        zzetVar.zzm(bArr, 0, iZzd3);
        zzaev zzaevVarZza = zzaew.zza(bArr);
        zzt zztVar = new zzt();
        zztVar.zzn(MimeTypes.VIDEO_FLV);
        zztVar.zzo(MimeTypes.AUDIO_AAC);
        zztVar.zzk(zzaevVarZza.zzc);
        zztVar.zzG(zzaevVarZza.zzb);
        zztVar.zzH(zzaevVarZza.zza);
        zztVar.zzr(Collections.singletonList(bArr));
        this.zza.zzA(zztVar.zzO());
        this.zzd = true;
        return false;
    }
}
