package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzics extends zzict {
    final /* synthetic */ zzida zza;
    private int zzb;
    private final int zzc;

    zzics(zzida zzidaVar) {
        Objects.requireNonNull(zzidaVar);
        this.zza = zzidaVar;
        this.zzb = 0;
        this.zzc = zzidaVar.zzb();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzicv
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zza(i);
    }
}
