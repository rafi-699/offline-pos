package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbhf extends zzcfw {
    final /* synthetic */ zzbhl zza;

    zzbhf(zzbhl zzbhlVar) {
        Objects.requireNonNull(zzbhlVar);
        this.zza = zzbhlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfw, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.zza.zzb();
        return super.cancel(z);
    }
}
