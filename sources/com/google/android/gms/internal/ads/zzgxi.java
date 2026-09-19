package com.google.android.gms.internal.ads;

import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgxi extends zzgyz {
    final /* synthetic */ zzgxj zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgxi(zzgxj zzgxjVar, ListIterator listIterator) {
        super(listIterator);
        Objects.requireNonNull(zzgxjVar);
        this.zza = zzgxjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyy
    final Object zza(Object obj) {
        return this.zza.zzb.apply(obj);
    }
}
