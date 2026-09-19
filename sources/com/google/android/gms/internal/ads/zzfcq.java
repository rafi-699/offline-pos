package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfcq implements zzfck {
    private final Context zza;
    private final zzhcg zzb;

    zzfcq(Context context, zzhcg zzhcgVar) {
        this.zza = context;
        this.zzb = zzhcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return ((Boolean) zzbki.zzb.zze()).booleanValue() ? this.zzb.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfcp
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        }) : zzhbw.zza(new zzfcr(-1, -1));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 59;
    }

    final /* synthetic */ zzfcr zzc() {
        Context context = this.zza;
        return new zzfcr(zzbib.zzc(context), zzbib.zzd(context));
    }
}
