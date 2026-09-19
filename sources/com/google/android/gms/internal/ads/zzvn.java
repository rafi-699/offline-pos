package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.os.Build;
import androidx.media3.common.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzvn {
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
        if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
            return 0;
        }
        int iZzc = zzc(supportedPerformancePoints, new MediaCodecInfo.VideoCapabilities.PerformancePoint(i, i2, (int) d));
        boolean z = true;
        if (iZzc == 1 && zzvo.zza == null) {
            if (Build.VERSION.SDK_INT >= 37) {
                z = false;
            } else {
                int iZzb = zzb(true);
                if (Build.VERSION.SDK_INT < 35 ? !(zzb(false) != 2 || iZzb == 1) : iZzb != 1) {
                    z = false;
                }
            }
            zzvo.zza = Boolean.valueOf(z);
            if (zzvo.zza.booleanValue()) {
                return 0;
            }
        }
        return iZzc;
    }

    private static int zzb(boolean z) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints;
        try {
            zzt zztVar = new zzt();
            zztVar.zzo(MimeTypes.VIDEO_H264);
            zzv zzvVarZzO = zztVar.zzO();
            if (zzvVarZzO.zzp != null) {
                List listZzc = zzwf.zzc(zzvv.zzb, zzvVarZzO, z, false);
                for (int i = 0; i < listZzc.size(); i++) {
                    if (((zzvm) listZzc.get(i)).zzd != null && (videoCapabilities = ((zzvm) listZzc.get(i)).zzd.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                        return zzc(supportedPerformancePoints, new MediaCodecInfo.VideoCapabilities.PerformancePoint(1280, 720, 60));
                    }
                }
            }
        } catch (zzvx unused) {
        }
        return 0;
    }

    private static int zzc(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i = 0; i < list.size(); i++) {
            if (((MediaCodecInfo.VideoCapabilities.PerformancePoint) list.get(i)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
