package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhjg {
    public static final /* synthetic */ int zza = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhjf.zza, zzhgg.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhjc.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhjd.zza, zzhfz.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhje.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) throws GeneralSecurityException {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    static /* synthetic */ zzhnn zzb(zzhgg zzhggVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzhrl zzhrlVarZzd = zzhrm.zzd();
        zzhrlVarZzd.zza(zzhggVar.zzc());
        zzhssVarZze.zzb(((zzhrm) zzhrlVarZzd.zzbu()).zzaM());
        zzhssVarZze.zzc(zzf(zzhggVar.zzd()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbu());
    }

    static /* synthetic */ zzhgg zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            String strZza = zzhnnVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzhrm zzhrmVarZzc = zzhrm.zzc(zzhnnVar.zzc().zzb(), zzido.zza());
            if (zzhrmVarZzc.zzb() != 0) {
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            }
            zzhge zzhgeVarZzb = zzhgg.zzb();
            zzhgeVarZzb.zza(zzhrmVarZzc.zza());
            zzhgeVarZzb.zzb(zzg(zzhnnVar.zzc().zzc()));
            return zzhgeVarZzb.zzc();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e);
        }
    }

    static /* synthetic */ zzhnm zzd(zzhfz zzhfzVar, zzhel zzhelVar) {
        zzhrj zzhrjVarZzd = zzhrk.zzd();
        byte[] bArrZzc = zzhfzVar.zze().zzc(zzhelVar);
        zzhrjVarZzd.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", ((zzhrk) zzhrjVarZzd.zzbu()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhfzVar.zzf().zzd()), zzhfzVar.zzb());
    }

    static /* synthetic */ zzhfz zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivProtoSerialization.parseKey");
        }
        try {
            zzhrk zzhrkVarZzc = zzhrk.zzc(zzhnmVar.zzb(), zzido.zza());
            if (zzhrkVarZzc.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhge zzhgeVarZzb = zzhgg.zzb();
            zzhgeVarZzb.zza(zzhrkVarZzc.zzb().zzb());
            zzhgeVarZzb.zzb(zzg(zzhnmVar.zzd()));
            zzhgg zzhggVarZzc = zzhgeVarZzb.zzc();
            zzhfy zzhfyVarZzd = zzhfz.zzd();
            zzhfyVarZzd.zza(zzhggVarZzc);
            zzhfyVarZzd.zzb(zzibb.zza(zzhrkVarZzc.zzb().zzA(), zzhelVar));
            zzhfyVarZzd.zzc(zzhnmVar.zze());
            return zzhfyVarZzd.zzd();
        } catch (zziet unused) {
            throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
        }
    }

    private static zzhtm zzf(zzhgf zzhgfVar) throws GeneralSecurityException {
        if (zzhgf.zza.equals(zzhgfVar)) {
            return zzhtm.TINK;
        }
        if (zzhgf.zzb.equals(zzhgfVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhgf.zzc.equals(zzhgfVar)) {
            return zzhtm.RAW;
        }
        String strValueOf = String.valueOf(zzhgfVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzhgf zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhgf.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhgf.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
                sb.append("Unable to parse OutputPrefixType: ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return zzhgf.zzb;
    }
}
