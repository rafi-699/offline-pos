package com.google.android.gms.internal.ads;

import android.view.ViewGroup;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcvj implements zzimu {
    private final zzcvi zza;

    private zzcvj(zzcvi zzcviVar) {
        this.zza = zzcviVar;
    }

    public static zzcvj zzc(zzcvi zzcviVar) {
        return new zzcvj(zzcviVar);
    }

    public final ViewGroup zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return this.zza.zza();
    }
}
