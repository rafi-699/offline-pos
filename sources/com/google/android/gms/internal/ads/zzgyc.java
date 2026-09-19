package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgyc extends zzgul {
    final transient zzgub zza;

    zzgyc(Map map, zzgub zzgubVar) {
        super(map);
        this.zza = zzgubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgul, com.google.android.gms.internal.ads.zzgvc
    protected final /* bridge */ /* synthetic */ Collection zzc() {
        return (List) this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzgvc, com.google.android.gms.internal.ads.zzgvf
    final Set zzh() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgvc, com.google.android.gms.internal.ads.zzgvf
    final Map zzl() {
        return zzm();
    }
}
