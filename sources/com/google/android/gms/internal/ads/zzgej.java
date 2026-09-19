package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgej implements zzged {
    private final int zza;
    private final byte[] zzb;

    zzgej(int i, byte[] bArr) {
        this.zza = i;
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzged
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzged
    public final String zzb() throws IOException {
        return new String(this.zzb);
    }
}
