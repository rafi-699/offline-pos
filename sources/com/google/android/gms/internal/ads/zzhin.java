package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhin {
    public static final /* synthetic */ int zza = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhim.zza, zzhfg.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhij.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhik.zza, zzhey.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhil.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) throws GeneralSecurityException {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    static /* synthetic */ zzhnn zzb(zzhfg zzhfgVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzhqr zzhqrVarZzd = zzhqs.zzd();
        zzhqv zzhqvVarZzc = zzhqw.zzc();
        zzhqx zzhqxVarZzb = zzhqy.zzb();
        zzhqxVarZzb.zza(zzhfgVar.zzf());
        zzhqvVarZzc.zza((zzhqy) zzhqxVarZzb.zzbu());
        zzhqvVarZzc.zzb(zzhfgVar.zzc());
        zzhqrVarZzd.zza((zzhqw) zzhqvVarZzc.zzbu());
        zzhsk zzhskVarZze = zzhsl.zze();
        zzhskVarZze.zza(zzi(zzhfgVar));
        zzhskVarZze.zzb(zzhfgVar.zzd());
        zzhqrVarZzd.zzb((zzhsl) zzhskVarZze.zzbu());
        zzhssVarZze.zzb(((zzhqs) zzhqrVarZzd.zzbu()).zzaM());
        zzhssVarZze.zzc(zzf(zzhfgVar.zzg()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbu());
    }

    static /* synthetic */ zzhfg zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            String strZza = zzhnnVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            zzhqs zzhqsVarZzc = zzhqs.zzc(zzhnnVar.zzc().zzb(), zzido.zza());
            if (zzhqsVarZzc.zzb().zzc() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            zzhfd zzhfdVarZzb = zzhfg.zzb();
            zzhfdVarZzb.zza(zzhqsVarZzc.zza().zzb());
            zzhfdVarZzb.zzb(zzhqsVarZzc.zzb().zzb());
            zzhfdVarZzb.zzc(zzhqsVarZzc.zza().zza().zza());
            zzhfdVarZzb.zzd(zzhqsVarZzc.zzb().zza().zzb());
            zzhfdVarZzb.zzf(zzh(zzhqsVarZzc.zzb().zza().zza()));
            zzhfdVarZzb.zze(zzg(zzhnnVar.zzc().zzc()));
            return zzhfdVarZzb.zzg();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e);
        }
    }

    static /* synthetic */ zzhnm zzd(zzhey zzheyVar, zzhel zzhelVar) {
        zzhqp zzhqpVarZze = zzhqq.zze();
        zzhqt zzhqtVarZzd = zzhqu.zzd();
        zzhqx zzhqxVarZzb = zzhqy.zzb();
        zzhqxVarZzb.zza(zzheyVar.zzg().zzf());
        zzhqtVarZzd.zza((zzhqy) zzhqxVarZzb.zzbu());
        byte[] bArrZzc = zzheyVar.zze().zzc(zzhelVar);
        zzhqtVarZzd.zzb(zzida.zzt(bArrZzc, 0, bArrZzc.length));
        zzhqpVarZze.zza((zzhqu) zzhqtVarZzd.zzbu());
        zzhsi zzhsiVarZze = zzhsj.zze();
        zzhsiVarZze.zza(zzi(zzheyVar.zzg()));
        byte[] bArrZzc2 = zzheyVar.zzf().zzc(zzhelVar);
        zzhsiVarZze.zzb(zzida.zzt(bArrZzc2, 0, bArrZzc2.length));
        zzhqpVarZze.zzb((zzhsj) zzhsiVarZze.zzbu());
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey", ((zzhqq) zzhqpVarZze.zzbu()).zzaM(), zzhsp.SYMMETRIC, zzf(zzheyVar.zzg().zzg()), zzheyVar.zzb());
    }

    static /* synthetic */ zzhey zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
        try {
            zzhqq zzhqqVarZzd = zzhqq.zzd(zzhnmVar.zzb(), zzido.zza());
            if (zzhqqVarZzd.zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            }
            if (zzhqqVarZzd.zzb().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
            }
            if (zzhqqVarZzd.zzc().zza() != 0) {
                throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
            }
            zzhfd zzhfdVarZzb = zzhfg.zzb();
            zzhfdVarZzb.zza(zzhqqVarZzd.zzb().zzc().zzb());
            zzhfdVarZzb.zzb(zzhqqVarZzd.zzc().zzc().zzb());
            zzhfdVarZzb.zzc(zzhqqVarZzd.zzb().zzb().zza());
            zzhfdVarZzb.zzd(zzhqqVarZzd.zzc().zzb().zzb());
            zzhfdVarZzb.zzf(zzh(zzhqqVarZzd.zzc().zzb().zza()));
            zzhfdVarZzb.zze(zzg(zzhnmVar.zzd()));
            zzhfg zzhfgVarZzg = zzhfdVarZzb.zzg();
            zzhex zzhexVarZzd = zzhey.zzd();
            zzhexVarZzd.zza(zzhfgVarZzg);
            zzhexVarZzd.zzb(zzibb.zza(zzhqqVarZzd.zzb().zzc().zzA(), zzhelVar));
            zzhexVarZzd.zzc(zzibb.zza(zzhqqVarZzd.zzc().zzc().zzA(), zzhelVar));
            zzhexVarZzd.zzd(zzhnmVar.zze());
            return zzhexVarZzd.zze();
        } catch (zziet unused) {
            throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
        }
    }

    private static zzhtm zzf(zzhff zzhffVar) throws GeneralSecurityException {
        if (zzhff.zza.equals(zzhffVar)) {
            return zzhtm.TINK;
        }
        if (zzhff.zzb.equals(zzhffVar)) {
            return zzhtm.CRUNCHY;
        }
        if (zzhff.zzc.equals(zzhffVar)) {
            return zzhtm.RAW;
        }
        String strValueOf = String.valueOf(zzhffVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzhff zzg(zzhtm zzhtmVar) throws GeneralSecurityException {
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            return zzhff.zza;
        }
        if (iOrdinal != 2) {
            if (iOrdinal == 3) {
                return zzhff.zzc;
            }
            if (iOrdinal != 4) {
                int iZza = zzhtmVar.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
                sb.append("Unable to parse OutputPrefixType: ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
        }
        return zzhff.zzb;
    }

    private static zzhfe zzh(zzhsh zzhshVar) throws GeneralSecurityException {
        int iOrdinal = zzhshVar.ordinal();
        if (iOrdinal == 1) {
            return zzhfe.zza;
        }
        if (iOrdinal == 2) {
            return zzhfe.zzd;
        }
        if (iOrdinal == 3) {
            return zzhfe.zzc;
        }
        if (iOrdinal == 4) {
            return zzhfe.zze;
        }
        if (iOrdinal == 5) {
            return zzhfe.zzb;
        }
        int iZza = zzhshVar.zza();
        StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 26);
        sb.append("Unable to parse HashType: ");
        sb.append(iZza);
        throw new GeneralSecurityException(sb.toString());
    }

    private static zzhsn zzi(zzhfg zzhfgVar) throws GeneralSecurityException {
        zzhsh zzhshVar;
        zzhsm zzhsmVarZzc = zzhsn.zzc();
        zzhsmVarZzc.zzb(zzhfgVar.zze());
        zzhfe zzhfeVarZzh = zzhfgVar.zzh();
        if (zzhfe.zza.equals(zzhfeVarZzh)) {
            zzhshVar = zzhsh.SHA1;
        } else if (zzhfe.zzb.equals(zzhfeVarZzh)) {
            zzhshVar = zzhsh.SHA224;
        } else if (zzhfe.zzc.equals(zzhfeVarZzh)) {
            zzhshVar = zzhsh.SHA256;
        } else if (zzhfe.zzd.equals(zzhfeVarZzh)) {
            zzhshVar = zzhsh.SHA384;
        } else {
            if (!zzhfe.zze.equals(zzhfeVarZzh)) {
                String strValueOf = String.valueOf(zzhfeVarZzh);
                String.valueOf(strValueOf);
                throw new GeneralSecurityException("Unable to serialize HashType ".concat(String.valueOf(strValueOf)));
            }
            zzhshVar = zzhsh.SHA512;
        }
        zzhsmVarZzc.zza(zzhshVar);
        return (zzhsn) zzhsmVarZzc.zzbu();
    }
}
