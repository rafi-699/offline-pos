package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzimy extends zzimq {
    static {
        zzimv.zza(Collections.emptyMap());
    }

    /* synthetic */ zzimy(Map map, zzimw zzimwVar) {
        super(map);
    }

    public static zzimx zzc(int i) {
        return new zzimx(i, null);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    /* JADX INFO: renamed from: zzd */
    public final Map zzb() {
        LinkedHashMap linkedHashMapZzc = zzimr.zzc(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            linkedHashMapZzc.put(entry.getKey(), ((zzind) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(linkedHashMapZzc);
    }
}
