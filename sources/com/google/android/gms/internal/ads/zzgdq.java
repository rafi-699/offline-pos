package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgdq implements zzind {
    final /* synthetic */ zzgdr zza;

    zzgdq(zzgdr zzgdrVar) {
        Objects.requireNonNull(zzgdrVar);
        this.zza = zzgdrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgdr zzgdrVar = this.zza;
        return new zzgdu(zzgdrVar.zzb(), zzgdrVar.zzc(), null);
    }
}
