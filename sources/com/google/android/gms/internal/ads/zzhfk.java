package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhfk implements zzhln {
    static final /* synthetic */ zzhfk zza = new zzhfk();

    private /* synthetic */ zzhfk() {
    }

    @Override // com.google.android.gms.internal.ads.zzhln
    public final /* synthetic */ zzhdq zza(zzheh zzhehVar, Integer num) throws GeneralSecurityException {
        zzhfo zzhfoVar = (zzhfo) zzhehVar;
        int i = zzhfl.zza;
        if (zzhfoVar.zzc() == 24) {
            throw new GeneralSecurityException("192 bit AES EAX Parameters are not valid");
        }
        zzhfh zzhfhVar = new zzhfh(null);
        zzhfhVar.zza(zzhfoVar);
        zzhfhVar.zzc(num);
        zzhfhVar.zzb(zzibb.zzb(zzhfoVar.zzc()));
        return zzhfhVar.zzd();
    }
}
