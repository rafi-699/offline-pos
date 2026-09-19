package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhhl {
    public static final /* synthetic */ int zza = 0;
    private static final zziaz zzb;
    private static final zzhmy zzc;
    private static final zzhmv zzd;
    private static final zzhlu zze;
    private static final zzhlr zzf;

    static {
        zziaz zziazVarZza = zzhnz.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzb = zziazVarZza;
        zzc = zzhmy.zzd(zzhhk.zza, zzhhg.class, zzhnn.class);
        zzd = zzhmv.zzd(zzhhh.zza, zziazVarZza, zzhnn.class);
        zze = zzhlu.zzd(zzhhi.zza, zzhhc.class, zzhnm.class);
        zzf = zzhlr.zzd(zzhhj.zza, zziazVarZza, zzhnm.class);
    }

    public static void zza(zzhmr zzhmrVar) throws GeneralSecurityException {
        zzhmrVar.zzd(zzc);
        zzhmrVar.zze(zzd);
        zzhmrVar.zzb(zze);
        zzhmrVar.zzc(zzf);
    }

    static /* synthetic */ zzhnn zzb(zzhhg zzhhgVar) {
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
        zzhssVarZze.zzb(zzg(zzhhgVar).zzaM());
        zzhssVarZze.zzc(zzf(zzhhgVar.zzc()));
        return zzhnn.zza((zzhst) zzhssVarZze.zzbu());
    }

    static /* synthetic */ zzhhg zzc(zzhnn zzhnnVar) throws GeneralSecurityException {
        if (!zzhnnVar.zzc().zza().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            String strZza = zzhnnVar.zzc().zza();
            String.valueOf(strZza);
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseParameters: ".concat(String.valueOf(strZza)));
        }
        try {
            return zzh(zzhtl.zzc(zzhnnVar.zzc().zzb(), zzido.zza()), zzhnnVar.zzc().zzc());
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    static /* synthetic */ zzhnm zzd(zzhhc zzhhcVar, zzhel zzhelVar) {
        zzhti zzhtiVarZzd = zzhtj.zzd();
        zzhtiVarZzd.zza(zzg(zzhhcVar.zze()));
        return zzhnm.zza("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey", ((zzhtj) zzhtiVarZzd.zzbu()).zzaM(), zzhsp.REMOTE, zzf(zzhhcVar.zze().zzc()), zzhhcVar.zzb());
    }

    static /* synthetic */ zzhhc zze(zzhnm zzhnmVar, zzhel zzhelVar) throws GeneralSecurityException {
        if (!zzhnmVar.zzg().equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
            throw new IllegalArgumentException("Wrong type URL in call to LegacyKmsEnvelopeAeadProtoSerialization.parseKey");
        }
        try {
            zzhtj zzhtjVarZzc = zzhtj.zzc(zzhnmVar.zzb(), zzido.zza());
            if (zzhtjVarZzc.zza() == 0) {
                return zzhhc.zzd(zzh(zzhtjVarZzc.zzb(), zzhnmVar.zzd()), zzhnmVar.zze());
            }
            String strValueOf = String.valueOf(zzhtjVarZzc);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 58);
            sb.append("KmsEnvelopeAeadKeys are only accepted with version 0, got ");
            sb.append(strValueOf);
            throw new GeneralSecurityException(sb.toString());
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKey failed: ", e);
        }
    }

    private static zzhtm zzf(zzhhf zzhhfVar) throws GeneralSecurityException {
        if (zzhhf.zza.equals(zzhhfVar)) {
            return zzhtm.TINK;
        }
        if (zzhhf.zzb.equals(zzhhfVar)) {
            return zzhtm.RAW;
        }
        String strValueOf = String.valueOf(zzhhfVar);
        String.valueOf(strValueOf);
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(strValueOf)));
    }

    private static zzhtl zzg(zzhhg zzhhgVar) throws GeneralSecurityException {
        try {
            zzhst zzhstVarZzd = zzhst.zzd(zzhen.zza(zzhhgVar.zzd()), zzido.zza());
            zzhtk zzhtkVarZzd = zzhtl.zzd();
            zzhtkVarZzd.zza(zzhhgVar.zzb());
            zzhtkVarZzd.zzb(zzhstVarZzd);
            return (zzhtl) zzhtkVarZzd.zzbu();
        } catch (zziet e) {
            throw new GeneralSecurityException("Parsing KmsEnvelopeAeadKeyFormat failed: ", e);
        }
    }

    private static zzhhg zzh(zzhtl zzhtlVar, zzhtm zzhtmVar) throws GeneralSecurityException {
        zzhhe zzhheVar;
        zzhhf zzhhfVar;
        zzhss zzhssVarZze = zzhst.zze();
        zzhssVarZze.zza(zzhtlVar.zzb().zza());
        zzhssVarZze.zzb(zzhtlVar.zzb().zzb());
        zzhssVarZze.zzc(zzhtm.RAW);
        zzheh zzhehVarZzb = zzhen.zzb(((zzhst) zzhssVarZze.zzbu()).zzaN());
        if (zzhehVarZzb instanceof zzhfx) {
            zzhheVar = zzhhe.zza;
        } else if (zzhehVarZzb instanceof zzhgm) {
            zzhheVar = zzhhe.zzc;
        } else if (zzhehVarZzb instanceof zzhii) {
            zzhheVar = zzhhe.zzb;
        } else if (zzhehVarZzb instanceof zzhfg) {
            zzhheVar = zzhhe.zzd;
        } else if (zzhehVarZzb instanceof zzhfo) {
            zzhheVar = zzhhe.zze;
        } else {
            if (!(zzhehVarZzb instanceof zzhgg)) {
                throw new GeneralSecurityException("Unsupported DEK parameters when parsing ".concat(zzhehVarZzb.toString()));
            }
            zzhheVar = zzhhe.zzf;
        }
        zzhhd zzhhdVar = new zzhhd(null);
        int iOrdinal = zzhtmVar.ordinal();
        if (iOrdinal == 1) {
            zzhhfVar = zzhhf.zza;
        } else {
            if (iOrdinal != 3) {
                int iZza = zzhtmVar.zza();
                StringBuilder sb = new StringBuilder(String.valueOf(iZza).length() + 34);
                sb.append("Unable to parse OutputPrefixType: ");
                sb.append(iZza);
                throw new GeneralSecurityException(sb.toString());
            }
            zzhhfVar = zzhhf.zzb;
        }
        zzhhdVar.zza(zzhhfVar);
        zzhhdVar.zzb(zzhtlVar.zza());
        zzhhdVar.zzd((zzheu) zzhehVarZzb);
        zzhhdVar.zzc(zzhheVar);
        return zzhhdVar.zze();
    }
}
