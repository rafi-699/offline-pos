package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzn extends LinkedHashMap {
    final /* synthetic */ zzq zza;

    zzn(zzq zzqVar) {
        Objects.requireNonNull(zzqVar);
        this.zza = zzqVar;
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry entry) {
        zzq zzqVar = this.zza;
        synchronized (zzqVar) {
            if (size() <= zzqVar.zzg()) {
                return false;
            }
            zzqVar.zzh().add(new Pair((String) entry.getKey(), ((zzo) entry.getValue()).zzb));
            return size() > zzqVar.zzg();
        }
    }
}
