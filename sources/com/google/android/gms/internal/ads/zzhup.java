package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhup {
    private zzhus zza = null;
    private zzhuq zzb = null;
    private zzhur zzc = null;
    private zzhut zzd = zzhut.zzd;

    private zzhup() {
    }

    /* synthetic */ zzhup(byte[] bArr) {
    }

    public final zzhup zza(zzhus zzhusVar) {
        this.zza = zzhusVar;
        return this;
    }

    public final zzhup zzb(zzhuq zzhuqVar) {
        this.zzb = zzhuqVar;
        return this;
    }

    public final zzhup zzc(zzhur zzhurVar) {
        this.zzc = zzhurVar;
        return this;
    }

    public final zzhup zzd(zzhut zzhutVar) {
        this.zzd = zzhutVar;
        return this;
    }

    public final zzhuu zze() throws GeneralSecurityException {
        zzhus zzhusVar = this.zza;
        if (zzhusVar == null) {
            throw new GeneralSecurityException("signature encoding is not set");
        }
        zzhuq zzhuqVar = this.zzb;
        if (zzhuqVar == null) {
            throw new GeneralSecurityException("EC curve type is not set");
        }
        zzhur zzhurVar = this.zzc;
        if (zzhurVar == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        zzhut zzhutVar = this.zzd;
        if (zzhutVar == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (zzhuqVar == zzhuq.zza && zzhurVar != zzhur.zza) {
            throw new GeneralSecurityException("NIST_P256 requires SHA256");
        }
        if (zzhuqVar == zzhuq.zzb && zzhurVar != zzhur.zzb && zzhurVar != zzhur.zzc) {
            throw new GeneralSecurityException("NIST_P384 requires SHA384 or SHA512");
        }
        if (zzhuqVar != zzhuq.zzc || zzhurVar == zzhur.zzc) {
            return new zzhuu(zzhusVar, zzhuqVar, zzhurVar, zzhutVar, null);
        }
        throw new GeneralSecurityException("NIST_P521 requires SHA512");
    }
}
