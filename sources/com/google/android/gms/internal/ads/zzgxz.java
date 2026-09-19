package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgxz extends zzgxy {
    final /* synthetic */ zzgya zza;

    zzgxz(zzgya zzgyaVar, int i) {
        Objects.requireNonNull(zzgyaVar);
        this.zza = zzgyaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgxy
    public final zzgxh zza() {
        return new zzgyc(this.zza.zza(), new zzgxx(2));
    }
}
