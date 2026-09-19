package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepx implements zzelu {
    private final Map zza = new HashMap();
    private final zzdxc zzb;

    public zzepx(zzdxc zzdxcVar) {
        this.zzb = zzdxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelu
    public final zzelv zza(String str, JSONObject jSONObject) throws zzflf {
        zzelv zzelvVar;
        synchronized (this) {
            Map map = this.zza;
            zzelvVar = (zzelv) map.get(str);
            if (zzelvVar == null) {
                zzelvVar = new zzelv(this.zzb.zza(str, jSONObject), new zzeni(), str);
                map.put(str, zzelvVar);
            }
        }
        return zzelvVar;
    }
}
