package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhis {
    public static final /* synthetic */ int zza = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhir.zza, zzhfo.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhio.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhip.zza, zzhfi.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhiq.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) throws GeneralSecurityException {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    static /* synthetic */ zzhnn zzb(zzhfo zzhfoVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzhrb zzhrbVarZzd = zzhrc.zzd();
        zzhrbVarZzd.zza(zzh(zzhfoVar));
        zzhrbVarZzd.zzb(zzhfoVar.zzc());
        zzhssVarZze.zzb(((zzhrc) zzhrbVarZzd.zzbu()).zzaM());
        zzhssVarZze.zzc(zzf(zzhfoVar.zze()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbu());
    }

    static /* synthetic */ zzhfo zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            String strZza = zzhnnVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzhrc zzhrcVarZzc = zzhrc.zzc(zzhnnVar.zzc().zzb(), zzido.zza());
            zzhfm zzhfmVarZzb = zzhfo.zzb();
            zzhfmVarZzb.zza(zzhrcVarZzc.zzb());
            zzhfmVarZzb.zzb(zzhrcVarZzc.zza().zza());
            zzhfmVarZzb.zzc(16);
            zzhfmVarZzb.zzd(zzg(zzhnnVar.zzc().zzc()));
            return zzhfmVarZzb.zze();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e);
        }
    }

    static /* synthetic */ zzhnm zzd(zzhfi zzhfiVar, zzhel zzhelVar) {
        zzhqz zzhqzVarZze = zzhra.zze();
        zzhqzVarZze.zza(zzh(zzhfiVar.zzf()));
        byte[] bArrZzc = zzhfiVar.zze().zzc(zzhelVar);
        zzhqzVarZze.zzb(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", ((zzhra) zzhqzVarZze.zzbu()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhfiVar.zzf().zze()), zzhfiVar.zzb());
    }

    static /* synthetic */ zzhfi zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxProtoSerialization.parseKey");
        }
        try {
            zzhra zzhraVarZzd = zzhra.zzd(zzhnmVar.zzb(), zzido.zza());
            if (zzhraVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhfm zzhfmVarZzb = zzhfo.zzb();
            zzhfmVarZzb.zza(zzhraVarZzd.zzc().zzb());
            zzhfmVarZzb.zzb(zzhraVarZzd.zzb().zza());
            zzhfmVarZzb.zzc(16);
            zzhfmVarZzb.zzd(zzg(zzhnmVar.zzd()));
            zzhfo zzhfoVarZze = zzhfmVarZzb.zze();
            zzhfh zzhfhVarZzd = zzhfi.zzd();
            zzhfhVarZzd.zza(zzhfoVarZze);
            zzhfhVarZzd.zzb(zzibb.zza(zzhraVarZzd.zzc().zzA(), zzhelVar));
            zzhfhVarZzd.zzc(zzhnmVar.zze());
            return zzhfhVarZzd.zzd();
        } catch (zziet unused) {
            throw new GeneralSecurityException("Parsing AesEaxKey failed");
        }
    }

    private static zzhtm zzf(zzhfn zzhfnVar) throws GeneralSecurityException {
        if (zzhfn.zza.equals(zzhfnVar)) {
            return zzhtm.TINK;
        }
        if (zzhfn.zzb.equals(zzhfnVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhfn.zzc.equals(zzhfnVar)) {
            return zzhtm.RAW;
        }
        String strValueOf = String.valueOf(zzhfnVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzhfn zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhfn.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhfn.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
                sb.append("Unable to parse OutputPrefixType: ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return zzhfn.zzb;
    }

    private static zzhre zzh(zzhfo zzhfoVar) throws GeneralSecurityException {
        zzhrd zzhrdVarZzb = zzhre.zzb();
        zzhrdVarZzb.zza(zzhfoVar.zzd());
        return (zzhre) zzhrdVarZzb.zzbu();
    }
}
