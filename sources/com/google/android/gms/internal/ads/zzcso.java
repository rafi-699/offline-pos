package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.devicetier.DeviceTierManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcso implements zzimu {
    private final zzind zza;

    private zzcso(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcso zza(zzind zzindVar) {
        return new zzcso(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcsn((DeviceTierManager) this.zza.zzb());
    }
}
