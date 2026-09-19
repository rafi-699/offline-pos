package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zziam implements zzhqd {
    public static zzhqd zzb(zzhqb zzhqbVar) throws GeneralSecurityException {
        zzhqd zzhqdVarZzb = zzhqh.zzb(zzhqbVar);
        try {
            return new zzial(zzhqdVarZzb, zzhqi.zzb(zzhqbVar), null);
        } catch (GeneralSecurityException unused) {
            return zzhqdVarZzb;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhqd
    public final byte[] zza(byte[] bArr, int i) throws GeneralSecurityException {
        throw null;
    }
}
