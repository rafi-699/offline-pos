package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Queue;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgwe extends zzgwb implements Queue {
    protected zzgwe() {
    }

    @Override // java.util.Queue
    public final Object element() {
        return zza().element();
    }

    @Override // java.util.Queue
    public final boolean offer(Object obj) {
        return zza().offer(obj);
    }

    @Override // java.util.Queue
    public final Object peek() {
        return zza().peek();
    }

    @Override // java.util.Queue
    public final Object poll() {
        return zza().poll();
    }

    @Override // java.util.Queue
    public final Object remove() {
        return zza().remove();
    }

    protected abstract Queue zza();

    @Override // com.google.android.gms.internal.ads.zzgwb
    protected /* bridge */ /* synthetic */ Collection zzc() {
        throw null;
    }
}
