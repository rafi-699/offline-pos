package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhkk {
    public static final /* synthetic */ int zza = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhkj.zza, zzhii.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhkg.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhkh.zza, zzhic.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhki.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) throws GeneralSecurityException {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    static /* synthetic */ zzhnn zzb(zzhii zzhiiVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzhssVarZze.zzb(zzhuo.zzc().zzaM());
        zzhssVarZze.zzc(zzf(zzhiiVar.zzc()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbu());
    }

    static /* synthetic */ zzhii zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            String strZza = zzhnnVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            if (zzhuo.zzb(zzhnnVar.zzc().zzb(), zzido.zza()).zza() == 0) {
                return zzhii.zzb(zzg(zzhnnVar.zzc().zzc()));
            }
            throw new GeneralSecurityException("Only version 0 parameters are accepted");
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e);
        }
    }

    static /* synthetic */ zzhnm zzd(zzhic zzhicVar, zzhel zzhelVar) {
        zzhul zzhulVarZzd = zzhum.zzd();
        byte[] bArrZzc = zzhicVar.zze().zzc(zzhelVar);
        zzhulVarZzd.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key", ((zzhum) zzhulVarZzd.zzbu()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhicVar.zzf().zzc()), zzhicVar.zzb());
    }

    static /* synthetic */ zzhic zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzhum zzhumVarZzc = zzhum.zzc(zzhnmVar.zzb(), zzido.zza());
            if (zzhumVarZzc.zza() == 0) {
                return zzhic.zzd(zzg(zzhnmVar.zzd()), zzibb.zza(zzhumVarZzc.zzb().zzA(), zzhelVar), zzhnmVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zziet unused) {
            throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
        }
    }

    private static zzhtm zzf(zzhih zzhihVar) throws GeneralSecurityException {
        if (zzhih.zza.equals(zzhihVar)) {
            return zzhtm.TINK;
        }
        if (zzhih.zzb.equals(zzhihVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhih.zzc.equals(zzhihVar)) {
            return zzhtm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhihVar.toString()));
    }

    private static zzhih zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhih.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhih.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
                sb.append("Unable to parse OutputPrefixType: ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return zzhih.zzb;
    }
}
