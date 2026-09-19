package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhjq extends zzhjr {
    public zzhjq(byte[] bArr) throws GeneralSecurityException {
        super(bArr);
    }

    @Override // com.google.android.gms.internal.ads.zzhjr
    final zzhjp zza(byte[] bArr, int i) throws InvalidKeyException {
        return new zzhjo(bArr, i);
    }
}
