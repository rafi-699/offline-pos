package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbym extends zzbne {
    final /* synthetic */ zzbyo zza;

    /* synthetic */ zzbym(zzbyo zzbyoVar, byte[] bArr) {
        Objects.requireNonNull(zzbyoVar);
        this.zza = zzbyoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void zze(zzbmv zzbmvVar, String str) {
        zzbyo zzbyoVar = this.zza;
        if (zzbyoVar.zze() == null) {
            return;
        }
        zzbyoVar.zze().onCustomClick(zzbyoVar.zzc(zzbmvVar), str);
    }
}
