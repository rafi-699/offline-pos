package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhyd implements zzhej {
    private zzhyd(zzhej zzhejVar, byte[] bArr, byte[] bArr2) {
    }

    public static zzhej zzb(zzhlz zzhlzVar) throws GeneralSecurityException {
        zzhnm zzhnmVarZzc = zzhlzVar.zzc(zzhdo.zza());
        return new zzhyd((zzhej) zzhlo.zza().zzc(zzhnmVarZzc.zzg(), zzhej.class).zza(zzhnmVarZzc.zzb()), zzhye.zzc(zzhnmVarZzc), zzhye.zzd(zzhnmVarZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzhej
    public final byte[] zza(byte[] bArr) throws GeneralSecurityException {
        throw null;
    }
}
