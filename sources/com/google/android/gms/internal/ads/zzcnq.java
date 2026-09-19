package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcnq implements zzimu {
    private final zzcnl zza;

    private zzcnq(zzcnl zzcnlVar) {
        this.zza = zzcnlVar;
    }

    public static zzcnq zzc(zzcnl zzcnlVar) {
        return new zzcnq(zzcnlVar);
    }

    public static Context zzd(zzcnl zzcnlVar) {
        Context contextZzb = zzcnlVar.zzb();
        zzinc.zzb(contextZzb);
        return contextZzb;
    }

    public final Context zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
