package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzcns;
import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzind;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzca implements zzimu {
    private final zzind zza;

    private zzca(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzca zza(zzind zzindVar) {
        return new zzca(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbz(((zzcns) this.zza).zza());
    }
}
