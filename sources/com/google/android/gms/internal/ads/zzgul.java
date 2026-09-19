package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzgul extends zzgvc implements zzgxh {
    protected zzgul(Map map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.ads.zzgvc
    final Collection zza(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.android.gms.internal.ads.zzgvc
    final Collection zzb(Object obj, Collection collection) {
        return zzg(obj, (List) collection, null);
    }

    @Override // com.google.android.gms.internal.ads.zzgvc
    /* bridge */ /* synthetic */ Collection zzc() {
        throw null;
    }
}
