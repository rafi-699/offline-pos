package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhpl {
    public static final /* synthetic */ int zza = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhpk.zza, zzhoi.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhph.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhpi.zza, zzhob.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhpj.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) throws GeneralSecurityException {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    static /* synthetic */ zzhnn zzb(zzhoi zzhoiVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzhql zzhqlVarZzd = zzhqm.zzd();
        zzhqlVarZzd.zzb(zzh(zzhoiVar));
        zzhqlVarZzd.zza(zzhoiVar.zzc());
        zzhssVarZze.zzb(((zzhqm) zzhqlVarZzd.zzbu()).zzaM());
        zzhssVarZze.zzc(zzf(zzhoiVar.zzf()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbu());
    }

    static /* synthetic */ zzhoi zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            String strZza = zzhnnVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzhqm zzhqmVarZzc = zzhqm.zzc(zzhnnVar.zzc().zzb(), zzido.zza());
            zzhog zzhogVarZzb = zzhoi.zzb();
            zzhogVarZzb.zza(zzhqmVarZzc.zza());
            zzhogVarZzb.zzb(zzhqmVarZzc.zzb().zza());
            zzhogVarZzb.zzc(zzg(zzhnnVar.zzc().zzc()));
            return zzhogVarZzb.zzd();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e);
        }
    }

    static /* synthetic */ zzhnm zzd(zzhob zzhobVar, zzhel zzhelVar) {
        zzhqj zzhqjVarZze = zzhqk.zze();
        zzhqjVarZze.zzb(zzh(zzhobVar.zzf()));
        byte[] bArrZzc = zzhobVar.zzd().zzc(zzhelVar);
        zzhqjVarZze.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.AesCmacKey", ((zzhqk) zzhqjVarZze.zzbu()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhobVar.zzf().zzf()), zzhobVar.zzb());
    }

    static /* synthetic */ zzhob zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacProtoSerialization.parseKey");
        }
        try {
            zzhqk zzhqkVarZzd = zzhqk.zzd(zzhnmVar.zzb(), zzido.zza());
            if (zzhqkVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhog zzhogVarZzb = zzhoi.zzb();
            zzhogVarZzb.zza(zzhqkVarZzd.zzb().zzb());
            zzhogVarZzb.zzb(zzhqkVarZzd.zzc().zza());
            zzhogVarZzb.zzc(zzg(zzhnmVar.zzd()));
            zzhoi zzhoiVarZzd = zzhogVarZzb.zzd();
            zzhoa zzhoaVarZzc = zzhob.zzc();
            zzhoaVarZzc.zza(zzhoiVarZzd);
            zzhoaVarZzc.zzb(zzibb.zza(zzhqkVarZzd.zzb().zzA(), zzhelVar));
            zzhoaVarZzc.zzc(zzhnmVar.zze());
            return zzhoaVarZzc.zzd();
        } catch (zziet | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing AesCmacKey failed");
        }
    }

    private static zzhtm zzf(zzhoh zzhohVar) throws GeneralSecurityException {
        if (zzhoh.zza.equals(zzhohVar)) {
            return zzhtm.TINK;
        }
        if (zzhoh.zzb.equals(zzhohVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhoh.zzd.equals(zzhohVar)) {
            return zzhtm.RAW;
        }
        if (zzhoh.zzc.equals(zzhohVar)) {
            return zzhtm.LEGACY;
        }
        String strValueOf = String.valueOf(zzhohVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzhoh zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhoh.zza;
        }
        if (iOrdinal == 2) {
            return zzhoh.zzc;
        }
        if (iOrdinal == 3) {
            return zzhoh.zzd;
        }
        if (iOrdinal == 4) {
            return zzhoh.zzb;
        }
        int iZza = zzhtmVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
        sb.append("Unable to parse OutputPrefixType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }

    private static zzhqo zzh(zzhoi zzhoiVar) {
        zzhqn zzhqnVarZzb = zzhqo.zzb();
        zzhqnVarZzb.zza(zzhoiVar.zzd());
        return (zzhqo) zzhqnVarZzb.zzbu();
    }
}
