package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgqg implements zzhbt {
    final /* synthetic */ zzgqf zza;

    zzgqg(zzgqh zzgqhVar, zzgqf zzgqfVar) {
        this.zza = zzgqfVar;
        Objects.requireNonNull(zzgqhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzgqf zzgqfVar = this.zza;
        zzgqfVar.zzb(th);
        zzgqfVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        this.zza.zzc();
    }
}
