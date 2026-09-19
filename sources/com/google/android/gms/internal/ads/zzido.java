package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzido {
    static final zzido zza = new zzido(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzido zzd;
    private final Map zze;

    zzido() {
        this.zze = new HashMap();
    }

    public static zzido zza() {
        int i = zzicn.zza;
        return zza;
    }

    public static zzido zzb() {
        zzido zzidoVar = zzd;
        if (zzidoVar != null) {
            return zzidoVar;
        }
        synchronized (zzido.class) {
            zzido zzidoVar2 = zzd;
            if (zzidoVar2 != null) {
                return zzidoVar2;
            }
            int i = zzicn.zza;
            zzido zzidoVarZzb = zzidw.zzb(zzido.class);
            zzd = zzidoVarZzb;
            return zzidoVarZzb;
        }
    }

    public final zziec zzc(zzifp zzifpVar, int i) {
        return (zziec) this.zze.get(new zzidn(zzifpVar, i));
    }

    zzido(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
