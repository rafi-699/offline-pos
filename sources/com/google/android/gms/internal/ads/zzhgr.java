package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzhgr implements zzhne {
    static final /* synthetic */ zzhgr zza = new zzhgr();

    private /* synthetic */ zzhgr() {
    }

    @Override // com.google.android.gms.internal.ads.zzhne
    public final /* synthetic */ Object zza(zzhdq zzhdqVar) throws GeneralSecurityException {
        zzhhc zzhhcVar = (zzhhc) zzhdqVar;
        int i = zzhgt.zza;
        String strZzb = zzhhcVar.zze().zzb();
        zzheu zzheuVarZzd = zzhhcVar.zze().zzd();
        zzhdi zzhdiVarZzb = zzhef.zza(strZzb).zzb();
        int i2 = zzhgq.zza;
        try {
            return zzhju.zzc(new zzhgq(zzhst.zzd(zzhen.zza(zzheuVarZzd), zzido.zza()), zzhdiVarZzb), zzhhcVar.zzc());
        } catch (zziet e) {
            throw new GeneralSecurityException(e);
        }
    }
}
