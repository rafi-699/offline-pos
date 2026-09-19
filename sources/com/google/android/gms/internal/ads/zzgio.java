package com.google.android.gms.internal.ads;

import android.net.NetworkCapabilities;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgio extends zzgix {
    private final Map zza;

    zzgio(zzaxm zzaxmVar, zzght zzghtVar, Map map, zzgqh zzgqhVar) {
        super("G2/bixlyGCE81T8XD1821hdaWkYSafkSwXLAJIGuuGqYRgIdSuokiuQCkAmmYtmy", "cUq8+LlkvVToJpkHwW06ohwTjEjO/Tpp50dyOy2nlqU=", zzaxmVar, zzghtVar, zzgqhVar.zza(Imgproc.COLOR_YUV2BGR_YVYU));
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        Map map = this.zza;
        Object[] objArr = (Object[]) method.invoke("", (NetworkCapabilities) map.get("ntc"), (Long) map.get("vs"), (Long) map.get("vf"));
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaxmVar) {
            zzaxmVar.zzf(((Long) objArr2[0]).longValue());
            long jLongValue = ((Long) objArr2[1]).longValue();
            if (jLongValue >= 0) {
                zzaxmVar.zzW(jLongValue);
            }
            long jLongValue2 = ((Long) objArr2[2]).longValue();
            if (jLongValue2 >= 0) {
                zzaxmVar.zzX(jLongValue2);
            }
        }
    }
}
