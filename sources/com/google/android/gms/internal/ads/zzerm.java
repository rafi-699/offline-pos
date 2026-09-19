package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzerm implements zzdno {
    final /* synthetic */ zzfkf zza;

    zzerm(zzerp zzerpVar, zzfkf zzfkfVar) {
        this.zza = zzfkfVar;
        Objects.requireNonNull(zzerpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final void zza(boolean z, Context context, zzdde zzddeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdno
    public final zzfkf zzb() {
        return this.zza;
    }
}
