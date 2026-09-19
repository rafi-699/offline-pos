package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
@Deprecated
public final class zzbjf {
    private final List zza = new LinkedList();
    private final Map zzb;
    private final Object zzc;

    public zzbjf(boolean z, String str, String str2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        this.zzc = new Object();
        linkedHashMap.put("action", "make_wv");
        linkedHashMap.put(FirebaseAnalytics.Param.AD_FORMAT, str2);
    }

    public static final zzbjc zzf() {
        return new zzbjc(com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime(), null, null);
    }

    public final void zza(zzbjf zzbjfVar) {
        synchronized (this.zzc) {
        }
    }

    public final boolean zzb(zzbjc zzbjcVar, long j, String... strArr) {
        synchronized (this.zzc) {
            this.zza.add(new zzbjc(j, strArr[0], zzbjcVar));
        }
        return true;
    }

    public final zzbje zzc() {
        zzbje zzbjeVar;
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcB)).booleanValue();
        StringBuilder sb = new StringBuilder();
        HashMap map = new HashMap();
        synchronized (this.zzc) {
            List<zzbjc> list = this.zza;
            for (zzbjc zzbjcVar : list) {
                long jZza = zzbjcVar.zza();
                String strZzb = zzbjcVar.zzb();
                zzbjc zzbjcVarZzc = zzbjcVar.zzc();
                if (zzbjcVarZzc != null && jZza > 0) {
                    long jZza2 = jZza - zzbjcVarZzc.zza();
                    sb.append(strZzb);
                    sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    sb.append(jZza2);
                    sb.append(',');
                    if (zBooleanValue) {
                        if (map.containsKey(Long.valueOf(zzbjcVarZzc.zza()))) {
                            StringBuilder sb2 = (StringBuilder) map.get(Long.valueOf(zzbjcVarZzc.zza()));
                            sb2.append('+');
                            sb2.append(strZzb);
                        } else {
                            map.put(Long.valueOf(zzbjcVarZzc.zza()), new StringBuilder(strZzb));
                        }
                    }
                }
            }
            list.clear();
            String string = null;
            if (!TextUtils.isEmpty(null)) {
                sb.append((String) null);
            } else if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            StringBuilder sb3 = new StringBuilder();
            if (zBooleanValue) {
                for (Map.Entry entry : map.entrySet()) {
                    sb3.append((CharSequence) entry.getValue());
                    sb3.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    sb3.append(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() + (((Long) entry.getKey()).longValue() - com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime()));
                    sb3.append(',');
                }
                if (sb3.length() > 0) {
                    sb3.setLength(sb3.length() - 1);
                }
                string = sb3.toString();
            }
            zzbjeVar = new zzbje(sb.toString(), string);
        }
        return zzbjeVar;
    }

    public final void zzd(String str, String str2) {
        zzbiv zzbivVarZza;
        if (TextUtils.isEmpty(str2) || (zzbivVarZza = com.google.android.gms.ads.internal.zzt.zzh().zza()) == null) {
            return;
        }
        synchronized (this.zzc) {
            zzbjb zzbjbVarZzd = zzbivVarZza.zzd(str);
            Map map = this.zzb;
            map.put(str, zzbjbVarZzd.zza((String) map.get(str), str2));
        }
    }

    public final Map zze() {
        Map map;
        synchronized (this.zzc) {
            com.google.android.gms.ads.internal.zzt.zzh().zza();
            map = this.zzb;
        }
        return map;
    }
}
