package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhjm {
    public static final /* synthetic */ int zza = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhjl.zza, zzhgm.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhji.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhjj.zza, zzhgh.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhjk.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) throws GeneralSecurityException {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    static /* synthetic */ zzhnn zzb(zzhgm zzhgmVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        zzhssVarZze.zzb(zzhrq.zzb().zzaM());
        zzhssVarZze.zzc(zzf(zzhgmVar.zzc()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbu());
    }

    static /* synthetic */ zzhgm zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            String strZza = zzhnnVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzhrq.zza(zzhnnVar.zzc().zzb(), zzido.zza());
            return zzhgm.zzb(zzg(zzhnnVar.zzc().zzc()));
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Parameters failed: ", e);
        }
    }

    static /* synthetic */ zzhnm zzd(zzhgh zzhghVar, zzhel zzhelVar) {
        zzhrn zzhrnVarZzd = zzhro.zzd();
        byte[] bArrZzc = zzhghVar.zze().zzc(zzhelVar);
        zzhrnVarZzd.zza(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key", ((zzhro) zzhrnVarZzd.zzbu()).zzaM(), zzhsp.SYMMETRIC, zzf(zzhghVar.zzf().zzc()), zzhghVar.zzb());
    }

    static /* synthetic */ zzhgh zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
            throw new IllegalArgumentException("Wrong type URL in call to ChaCha20Poly1305ProtoSerialization.parseKey");
        }
        try {
            zzhro zzhroVarZzc = zzhro.zzc(zzhnmVar.zzb(), zzido.zza());
            if (zzhroVarZzc.zza() == 0) {
                return zzhgh.zzd(zzg(zzhnmVar.zzd()), zzibb.zza(zzhroVarZzc.zzb().zzA(), zzhelVar), zzhnmVar.zze());
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zziet unused) {
            throw new GeneralSecurityException("Parsing ChaCha20Poly1305Key failed");
        }
    }

    private static zzhtm zzf(zzhgl zzhglVar) throws GeneralSecurityException {
        if (zzhgl.zza.equals(zzhglVar)) {
            return zzhtm.TINK;
        }
        if (zzhgl.zzb.equals(zzhglVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhgl.zzc.equals(zzhglVar)) {
            return zzhtm.RAW;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhglVar.toString()));
    }

    private static zzhgl zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhgl.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhgl.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
                sb.append("Unable to parse OutputPrefixType: ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return zzhgl.zzb;
    }
}
