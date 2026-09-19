package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewl implements zzfck {
    private final zzfky zza;

    zzewl(zzfky zzfkyVar) {
        this.zza = zzfkyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return zzhbw.zza(new zzewm(this.zza.zzq));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 58;
    }
}
