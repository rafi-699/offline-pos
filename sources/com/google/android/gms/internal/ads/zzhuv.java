package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhuv {
    private zzhuy zza = null;
    private zziba zzb = null;

    private zzhuv() {
    }

    /* synthetic */ zzhuv(byte[] bArr) {
    }

    public final zzhuv zza(zzhuy zzhuyVar) {
        this.zza = zzhuyVar;
        return this;
    }

    public final zzhuv zzb(zziba zzibaVar) {
        this.zzb = zzibaVar;
        return this;
    }

    public final zzhuw zzc() throws GeneralSecurityException {
        zzhuy zzhuyVar = this.zza;
        if (zzhuyVar == null) {
            throw new GeneralSecurityException("Cannot build without a ecdsa public key");
        }
        zziba zzibaVar = this.zzb;
        if (zzibaVar == null) {
            throw new GeneralSecurityException("Cannot build without a private value");
        }
        BigInteger bigIntegerZzb = zzibaVar.zzb(zzhdo.zza());
        ECPoint eCPointZzd = zzhuyVar.zzd();
        zzhuq zzhuqVarZzd = zzhuyVar.zzf().zzd();
        BigInteger order = zzhuqVarZzd.zza().getOrder();
        if (bigIntegerZzb.signum() <= 0 || bigIntegerZzb.compareTo(order) >= 0) {
            throw new GeneralSecurityException("Invalid private value");
        }
        if (zzhlg.zzd(bigIntegerZzb, zzhuqVarZzd.zza()).equals(eCPointZzd)) {
            return new zzhuw(this.zza, this.zzb, null);
        }
        throw new GeneralSecurityException("Invalid private value");
    }
}
