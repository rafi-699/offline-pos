package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzatw implements zzatz {
    final /* synthetic */ File zza;

    zzatw(zzaua zzauaVar, File file) {
        this.zza = file;
        Objects.requireNonNull(zzauaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzatz
    public final File zza() {
        return this.zza;
    }
}
