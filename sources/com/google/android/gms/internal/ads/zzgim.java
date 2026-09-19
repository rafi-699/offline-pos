package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgim extends zzgix {
    private static volatile Long zza;
    private static final Object zzb = new Object();

    zzgim(zzaxm zzaxmVar, zzght zzghtVar, zzgqh zzgqhVar) {
        super("F5pwKdQUkBR2T28FTRLzecwttaHUl7VLDmgba7+ac24MPIR3NLD5sQMDLkLV832D", "Zvn3l46JDaJW0+pj8K/1DTe7U1wFUhv/KBF/UwuPk/A=", zzaxmVar, zzghtVar, zzgqhVar.zza(Imgproc.COLOR_YUV2RGB_YVYU));
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        if (zza == null) {
            synchronized (zzb) {
                if (zza == null) {
                    Long l = (Long) method.invoke("", new Object[0]);
                    if (l == null) {
                        throw null;
                    }
                    zza = l;
                }
            }
        }
        synchronized (zzaxmVar) {
            if (zza != null) {
                zzaxmVar.zzm(zza.longValue());
            }
        }
    }
}
