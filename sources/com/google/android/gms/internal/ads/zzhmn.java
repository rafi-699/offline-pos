package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhmn {
    private static final zzhmn zzb = new zzhmn();
    private final Map zza = new HashMap();

    zzhmn() {
    }

    public static zzhmn zza() {
        return zzb;
    }

    public final synchronized void zzb(String str, zzheh zzhehVar) throws GeneralSecurityException {
        Map map = this.zza;
        if (!map.containsKey(str)) {
            map.put(str, zzhehVar);
            return;
        }
        if (((zzheh) map.get(str)).equals(zzhehVar)) {
            return;
        }
        String strValueOf = String.valueOf(map.get(str));
        String strValueOf2 = String.valueOf(zzhehVar);
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 45 + String.valueOf(strValueOf).length() + 17 + String.valueOf(strValueOf2).length());
        sb.append("Parameters object with name ");
        sb.append(str);
        sb.append(" already exists (");
        sb.append(strValueOf);
        sb.append("), cannot insert ");
        sb.append(strValueOf2);
        throw new GeneralSecurityException(sb.toString());
    }

    public final synchronized zzheh zzc(String str) throws GeneralSecurityException {
        Map map;
        map = this.zza;
        if (!map.containsKey("AES128_GCM")) {
            throw new GeneralSecurityException("Name AES128_GCM does not exist");
        }
        return (zzheh) map.get("AES128_GCM");
    }

    public final synchronized void zzd(Map map) throws GeneralSecurityException {
        for (Map.Entry entry : map.entrySet()) {
            zzb((String) entry.getKey(), (zzheh) entry.getValue());
        }
    }
}
