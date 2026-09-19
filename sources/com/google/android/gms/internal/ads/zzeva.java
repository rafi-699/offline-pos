package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeva implements zzimu {
    private final zzind zza;

    private zzeva(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzeva zza(zzind zzindVar) {
        return new zzeva(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeuz((Set) this.zza.zzb());
    }
}
