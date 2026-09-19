package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import com.facebook.internal.FacebookRequestErrorClassification;
import java.math.RoundingMode;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzarm implements zzarn {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, Imgproc.COLOR_YUV2BGR_YVYU, 130, 143, 157, 173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, Videoio.CAP_PROP_XI_GPI_LEVEL, Videoio.CAP_PROP_XI_WB_KG, Videoio.CAP_PROP_XI_CC_MATRIX_33, Videoio.CAP_PROP_XI_TRG_DELAY, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzagb zzc;
    private final zzahk zzd;
    private final zzarr zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzet zzh;
    private final int zzi;
    private final zzv zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzarm(zzagb zzagbVar, zzahk zzahkVar, zzarr zzarrVar) throws zzat {
        this.zzc = zzagbVar;
        this.zzd = zzahkVar;
        this.zze = zzarrVar;
        int iMax = Math.max(1, zzarrVar.zzc / 10);
        this.zzi = iMax;
        zzet zzetVar = new zzet(zzarrVar.zzf);
        zzetVar.zzu();
        int iZzu = zzetVar.zzu();
        this.zzf = iZzu;
        int i = zzarrVar.zzb;
        int i2 = (((zzarrVar.zzd - (i * 4)) * 8) / (zzarrVar.zze * i)) + 1;
        if (iZzu != i2) {
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 34 + String.valueOf(iZzu).length());
            sb.append("Expected frames per block: ");
            sb.append(i2);
            sb.append("; got: ");
            sb.append(iZzu);
            throw zzat.zzb(sb.toString(), null);
        }
        String str = zzfl.zza;
        int i3 = ((iMax + iZzu) - 1) / iZzu;
        this.zzg = new byte[zzarrVar.zzd * i3];
        this.zzh = new zzet(i3 * (iZzu + iZzu) * i);
        int i4 = ((zzarrVar.zzc * zzarrVar.zzd) * 8) / iZzu;
        zzt zztVar = new zzt();
        zztVar.zzo(MimeTypes.AUDIO_RAW);
        zztVar.zzi(i4);
        zztVar.zzj(i4);
        zztVar.zzp((iMax + iMax) * i);
        zztVar.zzG(zzarrVar.zzb);
        zztVar.zzH(zzarrVar.zzc);
        zztVar.zzI(2);
        this.zzj = zztVar.zzO();
    }

    private final void zzd(int i) {
        long jZzv = this.zzl + zzfl.zzv(this.zzn, 1000000L, this.zze.zzc, RoundingMode.DOWN);
        int iZzf = zzf(i);
        this.zzd.zze(jZzv, 1, iZzf, this.zzm - iZzf, null);
        this.zzn += (long) i;
        this.zzm -= iZzf;
    }

    private final int zze(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zzf(int i) {
        return (i + i) * this.zze.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zza(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzarn
    public final void zzb(int i, long j) {
        zzaru zzaruVar = new zzaru(this.zze, this.zzf, i, j);
        this.zzc.zzw(zzaruVar);
        zzahk zzahkVar = this.zzd;
        zzahkVar.zzA(this.zzj);
        zzahkVar.zzO(zzaruVar.zza());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x003f A[LOOP:0: B:6:0x0024->B:12:0x003f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x0021 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0026  */
    /* JADX WARN: Code duplicated, block: B:9:0x002a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:4:0x0021). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.google.android.gms.internal.ads.zzarn
    public final boolean zzc(com.google.android.gms.internal.ads.zzafz r26, long r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzarm.zzc(com.google.android.gms.internal.ads.zzafz, long):boolean");
    }
}
