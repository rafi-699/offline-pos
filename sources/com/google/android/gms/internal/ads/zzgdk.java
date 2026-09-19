package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdk implements zzind {
    final /* synthetic */ zzgdl zza;

    zzgdk(zzgdl zzgdlVar) {
        Objects.requireNonNull(zzgdlVar);
        this.zza = zzgdlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzgds(this.zza.zza(), null);
    }
}
