package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhza implements zzhek {
    private final zzhnc zza;

    zzhza(zzhnc zzhncVar, zzhmd zzhmdVar) {
        this.zza = zzhncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhek
    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        for (zzhzb zzhzbVar : this.zza.zza(bArr)) {
            try {
                zzhzbVar.zza.zza(bArr, bArr2);
                int i = zzhzbVar.zzb;
                return;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("invalid signature");
    }
}
