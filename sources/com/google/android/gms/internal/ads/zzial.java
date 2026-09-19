package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzial implements zzhqd {
    final zzhqd zza;
    final zzhqd zzb;

    /* synthetic */ zzial(zzhqd zzhqdVar, zzhqd zzhqdVar2, byte[] bArr) {
        this.zza = zzhqdVar;
        this.zzb = zzhqdVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhqd
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        return bArr.length <= 64 ? this.zza.zza(bArr, i) : this.zzb.zza(bArr, i);
    }
}
