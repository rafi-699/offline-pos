package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcns implements zzimu {
    private final zzcnl zza;

    private zzcns(zzcnl zzcnlVar) {
        this.zza = zzcnlVar;
    }

    public static zzcns zzc(zzcnl zzcnlVar) {
        return new zzcns(zzcnlVar);
    }

    public static Context zzd(zzcnl zzcnlVar) {
        Context contextZza = zzcnlVar.zza();
        zzinc.zzb(contextZza);
        return contextZza;
    }

    public final Context zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
