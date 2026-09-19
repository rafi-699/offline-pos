package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgiy extends zzgix {
    private final Map zza;
    private final zzgec zzb;

    zzgiy(zzaxm zzaxmVar, zzght zzghtVar, zzgec zzgecVar, Map map, zzgqh zzgqhVar) {
        super("XWXJTGd1s4KBDryg9VrXAlY4jSAcYHe04/o6OdELnmUPXEyQBHBmyyV+Jg4HZM6P", "cfM2dBB5yNtLTWMY73EdilHQtVEOY0O+uF0cubJKH2M=", zzaxmVar, zzghtVar, zzgqhVar.zza(Imgproc.COLOR_YUV2BGRA_YVYU));
        this.zza = map;
        this.zzb = zzgecVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        Long[] lArr = new Long[9];
        Arrays.fill((Object[]) lArr, (Object) (-1L));
        Map map = this.zza;
        lArr[0] = (Long) zzgtg.zza((Long) map.get("tcq"), -1L);
        lArr[1] = (Long) zzgtg.zza((Long) map.get("tpq"), -1L);
        lArr[2] = (Long) zzgtg.zza((Long) map.get("tcv"), -1L);
        lArr[3] = (Long) zzgtg.zza((Long) map.get("tpv"), -1L);
        lArr[4] = (Long) zzgtg.zza((Long) map.get("tchv"), -1L);
        lArr[5] = (Long) zzgtg.zza((Long) map.get("tphv"), -1L);
        lArr[6] = (Long) zzgtg.zza((Long) map.get("tcc"), -1L);
        lArr[7] = (Long) zzgtg.zza((Long) map.get("tpc"), -1L);
        lArr[8] = (Long) zzgtg.zza((Long) map.get("tst"), -1L);
        for (int i = 0; i < 9; i++) {
            if (lArr[i] == null) {
                lArr[i] = -1L;
            }
        }
        Long[] lArr2 = (Long[]) method.invoke("", lArr, Integer.valueOf(this.zzb.ordinal()));
        lArr2.getClass();
        Long[] lArr3 = lArr2;
        synchronized (zzaxmVar) {
            zzaxmVar.zzac(lArr3[0].longValue());
            zzaxmVar.zzs(lArr3[1].longValue());
            zzaxmVar.zzn(lArr3[2].longValue());
            zzaxmVar.zzk(lArr3[3].longValue());
            zzaxmVar.zzY(lArr3[4].longValue());
            zzaxmVar.zzZ(lArr3[5].longValue());
            zzaxmVar.zzF(lArr3[6].longValue());
            zzaxmVar.zzG(lArr3[7].longValue());
        }
    }
}
