package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcgc implements zzhbt {
    final /* synthetic */ zzcga zza;
    final /* synthetic */ zzcfy zzb;

    zzcgc(zzcgd zzcgdVar, zzcga zzcgaVar, zzcfy zzcfyVar) {
        this.zza = zzcgaVar;
        this.zzb = zzcfyVar;
        Objects.requireNonNull(zzcgdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        this.zzb.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zza.zza(obj);
    }
}
