package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzz implements zzimu {
    private final zzind zza;

    private zzdzz(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdzz zza(zzind zzindVar) {
        return new zzdzz(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdzy((Clock) this.zza.zzb());
    }
}
