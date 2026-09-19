package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzepm {
    private zzepd zza;

    zzepm() {
    }

    private zzepm(zzepd zzepdVar) {
        this.zza = zzepdVar;
    }

    public static zzepm zza(zzepd zzepdVar) {
        return new zzepm(zzepdVar);
    }

    public final zzepd zzb(Clock clock, zzepf zzepfVar, zzelx zzelxVar, zzfsc zzfscVar) {
        zzepd zzepdVar = this.zza;
        return zzepdVar != null ? zzepdVar : new zzepd(clock, zzepfVar, zzelxVar, zzfscVar);
    }
}
