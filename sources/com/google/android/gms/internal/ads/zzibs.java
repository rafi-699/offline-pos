package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzibs extends zzibu {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzibs(zzibt zzibtVar) {
        super(zzibtVar.zza);
        Objects.requireNonNull(zzibtVar);
    }

    @Override // java.util.Iterator
    public final Object next() {
        return zza().zzf;
    }
}
