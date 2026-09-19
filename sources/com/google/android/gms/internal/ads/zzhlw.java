package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzhlw implements zzhdr {
    final String zza;
    final Class zzb;
    final zzhsp zzc;

    zzhlw(String str, Class cls, zzhsp zzhspVar, zzifx zzifxVar) {
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzhspVar;
    }

    public static zzhdr zze(String str, Class cls, zzhsp zzhspVar, zzifx zzifxVar) {
        return new zzhlw(str, cls, zzhspVar, zzifxVar);
    }

    public static zzhei zzf(String str, Class cls, zzifx zzifxVar) {
        return new zzhlv(str, cls, zzifxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhdr
    public final Object zza(zzida zzidaVar) throws GeneralSecurityException {
        return zzhmo.zza().zzd(zzhmr.zza().zzg(zzhnm.zza(this.zza, zzidaVar, this.zzc, zzhtm.RAW, null), zzhdo.zza()), this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzhdr
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdr
    public final Class zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhdr
    public final zzhsq zzd(zzida zzidaVar) throws GeneralSecurityException {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza(this.zza);
        zzhssVarZze.zzb(zzidaVar);
        zzhssVarZze.zzc(zzhtm.RAW);
        zzhnm zzhnmVar = (zzhnm) zzhmr.zza().zzh(zzhmi.zza().zzc(zzhmr.zza().zzj(zzhnn.zzb((zzhst) zzhssVarZze.zzbu())), null), zzhnm.class, zzhdo.zza());
        zzhso zzhsoVarZzd = zzhsq.zzd();
        zzhsoVarZzd.zza(zzhnmVar.zzg());
        zzhsoVarZzd.zzb(zzhnmVar.zzb());
        zzhsoVarZzd.zzc(zzhnmVar.zzc());
        return (zzhsq) zzhsoVarZzd.zzbu();
    }
}
