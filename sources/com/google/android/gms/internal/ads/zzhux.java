package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhux {

    @Nullable
    private zzhuu zza = null;

    @Nullable
    private ECPoint zzb = null;

    @Nullable
    private Integer zzc = null;

    private zzhux() {
    }

    /* synthetic */ zzhux(byte[] bArr) {
    }

    public final zzhux zza(zzhuu zzhuuVar) {
        this.zza = zzhuuVar;
        return this;
    }

    public final zzhux zzb(ECPoint eCPoint) {
        this.zzb = eCPoint;
        return this;
    }

    public final zzhux zzc(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhuy zzd() throws GeneralSecurityException {
        zziaz zziazVarZza;
        zzhuu zzhuuVar = this.zza;
        if (zzhuuVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        ECPoint eCPoint = this.zzb;
        if (eCPoint == null) {
            throw new GeneralSecurityException("Cannot build without public point");
        }
        zzhlg.zza(eCPoint, zzhuuVar.zzd().zza().getCurve());
        if (this.zza.zza() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzc != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzf() == zzhut.zzd) {
            zziazVarZza = zzhms.zza;
        } else if (this.zza.zzf() == zzhut.zzc || this.zza.zzf() == zzhut.zzb) {
            zziazVarZza = zzhms.zza(this.zzc.intValue());
        } else {
            if (this.zza.zzf() != zzhut.zza) {
                throw new IllegalStateException("Unknown EcdsaParameters.Variant: ".concat(this.zza.zzf().toString()));
            }
            zziazVarZza = zzhms.zzb(this.zzc.intValue());
        }
        return new zzhuy(this.zza, this.zzb, zziazVarZza, this.zzc, null);
    }
}
