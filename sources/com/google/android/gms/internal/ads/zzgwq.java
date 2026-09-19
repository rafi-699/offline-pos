package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgwq extends zzgza {
    final Iterator zza;
    Object zzb;
    Iterator zzc;
    final /* synthetic */ zzgwu zzd;

    zzgwq(zzgwu zzgwuVar) {
        Objects.requireNonNull(zzgwuVar);
        this.zzd = zzgwuVar;
        this.zza = zzgwuVar.map.entrySet().zze().listIterator(0);
        this.zzb = null;
        this.zzc = zzgxc.zza;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzc.hasNext() || this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        if (!this.zzc.hasNext()) {
            Map.Entry entry = (Map.Entry) this.zza.next();
            this.zzb = entry.getKey();
            this.zzc = ((zzgwi) entry.getValue()).iterator();
        }
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(this.zzb), this.zzc.next());
    }
}
