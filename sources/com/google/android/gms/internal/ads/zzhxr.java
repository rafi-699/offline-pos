package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhxr {
    public static final /* synthetic */ int zza = 0;
    private static final zziaz zzb;
    private static final zziaz zzc;
    private static final zzhmy zzd;
    private static final zzhmv zze;
    private static final zzhlu zzf;
    private static final zzhlr zzg;
    private static final zzhlu zzh;
    private static final zzhlr zzi;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey");
        zzb = zziazVarZza;
        zziaz zziazVarZza2 = zzhnz.zza("type.googleapis.com/google.crypto.tink.EcdsaPublicKey");
        zzc = zziazVarZza2;
        zzd = zzhmy.zzd(zzhxq.zza, zzhuu.class, zzhnn.class);
        zze = zzhmv.zzd(zzhxl.zza, zziazVarZza, zzhnn.class);
        zzf = zzhlu.zzd(zzhxm.zza, zzhuy.class, zzhnm.class);
        zzg = zzhlr.zzd(zzhxn.zza, zziazVarZza2, zzhnm.class);
        zzh = zzhlu.zzd(zzhxo.zza, zzhuw.class, zzhnm.class);
        zzi = zzhlr.zzd(zzhxp.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) throws GeneralSecurityException {
        zzhmrVar.zzd(zzd);
        zzhmrVar.zze(zze);
        zzhmrVar.zzb(zzf);
        zzhmrVar.zzc(zzg);
        zzhmrVar.zzb(zzh);
        zzhmrVar.zzc(zzi);
    }

    static /* synthetic */ zzhnn zzb(zzhuu zzhuuVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey");
        zzhrr zzhrrVarZzc = zzhrs.zzc();
        zzhrrVarZzc.zza(zzl(zzhuuVar));
        zzhssVarZze.zzb(((zzhrs) zzhrrVarZzc.zzbu()).zzaM());
        zzhssVarZze.zzc(zzh(zzhuuVar.zzf()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbu());
    }

    static /* synthetic */ zzhuu zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey")) {
            String strZza = zzhnnVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzhrs zzhrsVarZzb = zzhrs.zzb(zzhnnVar.zzc().zzb(), zzido.zza());
            zzhup zzhupVarZzb = zzhuu.zzb();
            zzhupVarZzb.zzc(zzi(zzhrsVarZzb.zza().zza()));
            zzhupVarZzb.zza(zzo(zzhrsVarZzb.zza().zzh()));
            zzhupVarZzb.zzb(zzn(zzhrsVarZzb.zza().zzg()));
            zzhupVarZzb.zzd(zzj(zzhnnVar.zzc().zzc()));
            return zzhupVarZzb.zze();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing EcdsaParameters failed: ", e);
        }
    }

    static /* synthetic */ zzhuy zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.EcdsaPublicKey")) {
            String strZzg = zzhnmVar.zzg();
            String.valueOf(strZzg);
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePublicKey: ".concat(String.valueOf(strZzg)));
        }
        try {
            zzhry zzhryVarZze = zzhry.zze(zzhnmVar.zzb(), zzido.zza());
            if (zzhryVarZze.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhup zzhupVarZzb = zzhuu.zzb();
            zzhupVarZzb.zzc(zzi(zzhryVarZze.zzb().zza()));
            zzhupVarZzb.zza(zzo(zzhryVarZze.zzb().zzh()));
            zzhupVarZzb.zzb(zzn(zzhryVarZze.zzb().zzg()));
            zzhupVarZzb.zzd(zzj(zzhnmVar.zzd()));
            zzhuu zzhuuVarZze = zzhupVarZzb.zze();
            zzhux zzhuxVarZzc = zzhuy.zzc();
            zzhuxVarZzc.zza(zzhuuVarZze);
            zzhuxVarZzc.zzb(new ECPoint(new BigInteger(1, zzhryVarZze.zzc().zzA()), new BigInteger(1, zzhryVarZze.zzd().zzA())));
            zzhuxVarZzc.zzc(zzhnmVar.zze());
            return zzhuxVarZzc.zzd();
        } catch (zziet | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPublicKey failed");
        }
    }

    static /* synthetic */ zzhnm zzf(zzhuw zzhuwVar, zzhel zzhelVar) throws GeneralSecurityException {
        int iZzk = zzk(zzhuwVar.zzd().zzd());
        zzhrv zzhrvVarZze = zzhrw.zze();
        zzhrvVarZze.zza(zzm(zzhuwVar.zze()));
        byte[] bArrZzb = zzhku.zzb(zzhuwVar.zzf().zzb(zzhelVar), iZzk);
        zzida zzidaVar = zzida.zza;
        zzhrvVarZze.zzb(zzida.zzt(bArrZzb, 0, bArrZzb.length));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey", ((zzhrw) zzhrvVarZze.zzbu()).zzaM(), zzhsp.ASYMMETRIC_PRIVATE, zzh(zzhuwVar.zzd().zzf()), zzhuwVar.zze().zzb());
    }

    static /* synthetic */ zzhuw zzg(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey")) {
            String strZzg = zzhnmVar.zzg();
            String.valueOf(strZzg);
            throw new IllegalArgumentException("Wrong type URL in call to EcdsaProtoSerialization.parsePrivateKey: ".concat(String.valueOf(strZzg)));
        }
        try {
            zzhrw zzhrwVarZzd = zzhrw.zzd(zzhnmVar.zzb(), zzido.zza());
            if (zzhrwVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhry zzhryVarZzb = zzhrwVarZzd.zzb();
            if (zzhryVarZzb.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhup zzhupVarZzb = zzhuu.zzb();
            zzhupVarZzb.zzc(zzi(zzhryVarZzb.zzb().zza()));
            zzhupVarZzb.zza(zzo(zzhryVarZzb.zzb().zzh()));
            zzhupVarZzb.zzb(zzn(zzhryVarZzb.zzb().zzg()));
            zzhupVarZzb.zzd(zzj(zzhnmVar.zzd()));
            zzhuu zzhuuVarZze = zzhupVarZzb.zze();
            zzhux zzhuxVarZzc = zzhuy.zzc();
            zzhuxVarZzc.zza(zzhuuVarZze);
            zzhuxVarZzc.zzb(new ECPoint(new BigInteger(1, zzhryVarZzb.zzc().zzA()), new BigInteger(1, zzhryVarZzb.zzd().zzA())));
            zzhuxVarZzc.zzc(zzhnmVar.zze());
            zzhuy zzhuyVarZzd = zzhuxVarZzc.zzd();
            zzhuv zzhuvVarZzc = zzhuw.zzc();
            zzhuvVarZzc.zza(zzhuyVarZzd);
            zzhuvVarZzc.zzb(zziba.zza(new BigInteger(1, zzhrwVarZzd.zzc().zzA()), zzhelVar));
            return zzhuvVarZzc.zzc();
        } catch (zziet | IllegalArgumentException unused) {
            throw new GeneralSecurityException("Parsing EcdsaPrivateKey failed");
        }
    }

    private static zzhtm zzh(zzhut zzhutVar) throws GeneralSecurityException {
        if (zzhut.zza.equals(zzhutVar)) {
            return zzhtm.TINK;
        }
        if (zzhut.zzb.equals(zzhutVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhut.zzd.equals(zzhutVar)) {
            return zzhtm.RAW;
        }
        if (zzhut.zzc.equals(zzhutVar)) {
            return zzhtm.LEGACY;
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(zzhutVar.toString()));
    }

    private static zzhur zzi(zzhsh zzhshVar) throws GeneralSecurityException {
        int iOrdinal = zzhshVar.ordinal();
        if (iOrdinal == 2) {
            return zzhur.zzb;
        }
        if (iOrdinal == 3) {
            return zzhur.zza;
        }
        if (iOrdinal == 4) {
            return zzhur.zzc;
        }
        int iZza = zzhshVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 26);
        sb.append("Unable to parse HashType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }

    private static zzhut zzj(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhut.zza;
        }
        if (iOrdinal == 2) {
            return zzhut.zzc;
        }
        if (iOrdinal == 3) {
            return zzhut.zzd;
        }
        if (iOrdinal == 4) {
            return zzhut.zzb;
        }
        int iZza = zzhtmVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
        sb.append("Unable to parse OutputPrefixType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }

    private static int zzk(zzhuq zzhuqVar) throws GeneralSecurityException {
        if (zzhuq.zza.equals(zzhuqVar)) {
            return 33;
        }
        if (zzhuq.zzb.equals(zzhuqVar)) {
            return 49;
        }
        if (zzhuq.zzc.equals(zzhuqVar)) {
            return 67;
        }
        throw new GeneralSecurityException("Unable to serialize CurveType ".concat(zzhuqVar.toString()));
    }

    private static zzhru zzl(zzhuu zzhuuVar) throws GeneralSecurityException {
        zzhsh zzhshVar;
        int i;
        zzhrt zzhrtVarZzb = zzhru.zzb();
        zzhur zzhurVarZze = zzhuuVar.zze();
        if (zzhur.zza.equals(zzhurVarZze)) {
            zzhshVar = zzhsh.SHA256;
        } else if (zzhur.zzb.equals(zzhurVarZze)) {
            zzhshVar = zzhsh.SHA384;
        } else {
            if (!zzhur.zzc.equals(zzhurVarZze)) {
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(zzhurVarZze.toString()));
            }
            zzhshVar = zzhsh.SHA512;
        }
        zzhrtVarZzb.zza(zzhshVar);
        zzhuq zzhuqVarZzd = zzhuuVar.zzd();
        int i2 = 4;
        if (zzhuq.zza.equals(zzhuqVarZzd)) {
            i = 4;
        } else if (zzhuq.zzb.equals(zzhuqVarZzd)) {
            i = 5;
        } else {
            if (!zzhuq.zzc.equals(zzhuqVarZzd)) {
                throw new GeneralSecurityException("Unable to serialize CurveType ".concat(zzhuqVarZzd.toString()));
            }
            i = 6;
        }
        zzhrtVarZzb.zzb(i);
        zzhus zzhusVarZzc = zzhuuVar.zzc();
        if (zzhus.zza.equals(zzhusVarZzc)) {
            i2 = 3;
        } else if (!zzhus.zzb.equals(zzhusVarZzc)) {
            throw new GeneralSecurityException("Unable to serialize SignatureEncoding ".concat(zzhusVarZzc.toString()));
        }
        zzhrtVarZzb.zzc(i2);
        return (zzhru) zzhrtVarZzb.zzbu();
    }

    private static zzhry zzm(zzhuy zzhuyVar) throws GeneralSecurityException {
        int iZzk = zzk(zzhuyVar.zzf().zzd());
        ECPoint eCPointZzd = zzhuyVar.zzd();
        zzhrx zzhrxVarZzg = zzhry.zzg();
        zzhrxVarZzg.zza(zzl(zzhuyVar.zzf()));
        byte[] bArrZzb = zzhku.zzb(eCPointZzd.getAffineX(), iZzk);
        zzida zzidaVar = zzida.zza;
        zzhrxVarZzg.zzb(zzida.zzt(bArrZzb, 0, bArrZzb.length));
        byte[] bArrZzb2 = zzhku.zzb(eCPointZzd.getAffineY(), iZzk);
        zzhrxVarZzg.zzc(zzida.zzt(bArrZzb2, 0, bArrZzb2.length));
        return (zzhry) zzhrxVarZzg.zzbu();
    }

    private static zzhuq zzn(int i) throws GeneralSecurityException {
        int i2 = i - 2;
        if (i2 == 2) {
            return zzhuq.zza;
        }
        if (i2 == 3) {
            return zzhuq.zzb;
        }
        if (i2 == 4) {
            return zzhuq.zzc;
        }
        int iZza = zzhsg.zza(i);
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 35);
        sb.append("Unable to parse EllipticCurveType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }

    private static zzhus zzo(int i) throws GeneralSecurityException {
        int i2 = i - 2;
        if (i2 == 1) {
            return zzhus.zza;
        }
        if (i2 == 2) {
            return zzhus.zzb;
        }
        int iZza = zzhrz.zza(i);
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 40);
        sb.append("Unable to parse EcdsaSignatureEncoding: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }
}
