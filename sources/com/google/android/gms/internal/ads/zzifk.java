package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzifk {
    zzifk() {
    }

    public static final boolean zza(Object obj) {
        return !((zzifj) obj).zze();
    }

    public static final Object zzb(Object obj, Object obj2) {
        zzifj zzifjVarZzc = (zzifj) obj;
        zzifj zzifjVar = (zzifj) obj2;
        if (!zzifjVar.isEmpty()) {
            if (!zzifjVarZzc.zze()) {
                zzifjVarZzc = zzifjVarZzc.zzc();
            }
            zzifjVarZzc.zzb(zzifjVar);
        }
        return zzifjVarZzc;
    }
}
