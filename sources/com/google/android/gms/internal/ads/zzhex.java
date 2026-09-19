package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhex {

    @Nullable
    private zzhfg zza = null;

    @Nullable
    private zzibb zzb = null;

    @Nullable
    private zzibb zzc = null;

    @Nullable
    private Integer zzd = null;

    private zzhex() {
    }

    /* synthetic */ zzhex(byte[] bArr) {
    }

    public final zzhex zza(zzhfg zzhfgVar) {
        this.zza = zzhfgVar;
        return this;
    }

    public final zzhex zzb(zzibb zzibbVar) {
        this.zzb = zzibbVar;
        return this;
    }

    public final zzhex zzc(zzibb zzibbVar) {
        this.zzc = zzibbVar;
        return this;
    }

    public final zzhex zzd(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzhey zze() throws GeneralSecurityException {
        zziaz zziazVarZzb;
        zzhfg zzhfgVar = this.zza;
        if (zzhfgVar == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        zzibb zzibbVar = this.zzb;
        if (zzibbVar == null || this.zzc == null) {
            throw new GeneralSecurityException("Cannot build without key material");
        }
        if (zzhfgVar.zzc() != zzibbVar.zzd()) {
            throw new GeneralSecurityException("AES key size mismatch");
        }
        if (zzhfgVar.zzd() != this.zzc.zzd()) {
            throw new GeneralSecurityException("HMAC key size mismatch");
        }
        if (this.zza.zza() && this.zzd == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!this.zza.zza() && this.zzd != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        if (this.zza.zzg() == zzhff.zzc) {
            zziazVarZzb = zzhms.zza;
        } else if (this.zza.zzg() == zzhff.zzb) {
            zziazVarZzb = zzhms.zza(this.zzd.intValue());
        } else {
            if (this.zza.zzg() != zzhff.zza) {
                String strValueOf = String.valueOf(this.zza.zzg());
                String.valueOf(strValueOf);
                throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(strValueOf)));
            }
            zziazVarZzb = zzhms.zzb(this.zzd.intValue());
        }
        return new zzhey(this.zza, this.zzb, this.zzc, zziazVarZzb, this.zzd, null);
    }
}
