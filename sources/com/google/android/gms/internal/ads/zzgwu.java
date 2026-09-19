package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzgwu<K, V> extends zzgvg<K, V> implements Serializable {
    final transient zzgwp<K, ? extends zzgwi<V>> map;
    final transient int size;

    zzgwu(zzgwp zzgwpVar, int i) {
        this.map = zzgwpVar;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final int zzd() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgvf, com.google.android.gms.internal.ads.zzgxu
    @Deprecated
    public final boolean zze(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    @Deprecated
    public final void zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    final Set zzh() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    final /* synthetic */ Collection zzj() {
        return new zzgwt(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    final Map zzl() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    public final boolean zzr(Object obj) {
        return obj != null && super.zzr(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgvf, com.google.android.gms.internal.ads.zzgxu
    public final /* bridge */ /* synthetic */ Collection zzt() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgvf, com.google.android.gms.internal.ads.zzgxu
    public /* synthetic */ Map zzu() {
        return this.map;
    }
}
