package com.google.android.gms.ads.nonagon.devicetier;

import com.google.android.gms.internal.ads.zzcns;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zza implements zzimu {
    private final zzind zza;

    private zza(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zza zza(zzind zzindVar) {
        return new zza(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new DeviceTierManager(((zzcns) this.zza).zza());
    }
}
