package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcoj implements zzimu {
    private final zzcnl zza;

    private zzcoj(zzcnl zzcnlVar) {
        this.zza = zzcnlVar;
    }

    public static zzcoj zza(zzcnl zzcnlVar) {
        return new zzcoj(zzcnlVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return Long.valueOf(this.zza.zzi());
    }
}
