package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbpe implements zzbpq {
    zzbpe() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        if (map.containsKey("start")) {
            zzckuVar.zzas(true);
        }
        if (map.containsKey("stop")) {
            zzckuVar.zzas(false);
        }
    }
}
