package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzggz implements zzimu {
    private final zzind zza;

    private zzggz(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzggz zza(zzind zzindVar) {
        return new zzggz(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        DisplayMetrics displayMetrics = ((Context) this.zza.zzb()).getResources().getDisplayMetrics();
        zzinc.zzb(displayMetrics);
        return displayMetrics;
    }
}
