package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgft implements zzhbe {
    final /* synthetic */ zzgfy zza;

    zzgft(zzgfy zzgfyVar) {
        Objects.requireNonNull(zzgfyVar);
        this.zza = zzgfyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzgfr zzgfrVar = (zzgfr) obj;
        if (zzgfrVar != null) {
            return zzhbw.zza(zzgfrVar);
        }
        zzgfy zzgfyVar = this.zza;
        zzgfyVar.zza().zzb(51);
        return zzgfyVar.zzd(zzgfyVar.zze());
    }
}
