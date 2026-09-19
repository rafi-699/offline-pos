package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvl extends zzgvp {
    final /* synthetic */ zzgvt zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgvl(zzgvt zzgvtVar) {
        super(zzgvtVar, null);
        Objects.requireNonNull(zzgvtVar);
        this.zza = zzgvtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgvp
    final Object zza(int i) {
        return this.zza.zzo(i);
    }
}
