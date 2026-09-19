package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzgwz<K, V> extends zzgwu<K, V> implements zzgxu<K, V> {
    private final transient zzgww<V> emptySet;
    private transient zzgww zza;

    zzgwz(zzgwp zzgwpVar, int i, Comparator comparator) {
        super(zzgwpVar, i);
        this.emptySet = zzgyn.zza;
    }

    public final zzgww zza() {
        zzgww zzgwwVar = this.zza;
        if (zzgwwVar != null) {
            return zzgwwVar;
        }
        zzgwy zzgwyVar = new zzgwy(this);
        this.zza = zzgwyVar;
        return zzgwyVar;
    }
}
