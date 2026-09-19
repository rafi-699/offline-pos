package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhhc extends zzhet {
    private final zzhhg zza;
    private final zziaz zzb;

    @Nullable
    private final Integer zzc;

    private zzhhc(zzhhg zzhhgVar, zziaz zziazVar, @Nullable Integer num) {
        this.zza = zzhhgVar;
        this.zzb = zziazVar;
        this.zzc = num;
    }

    public static zzhhc zzd(zzhhg zzhhgVar, @Nullable Integer num) throws GeneralSecurityException {
        zziaz zziazVarZzb;
        if (zzhhgVar.zzc() == zzhhf.zzb) {
            if (num != null) {
                throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
            }
            zziazVarZzb = zzhms.zza;
        } else {
            if (zzhhgVar.zzc() != zzhhf.zza) {
                String strValueOf = String.valueOf(zzhhgVar.zzc());
                String.valueOf(strValueOf);
                throw new GeneralSecurityException("Unknown Variant: ".concat(String.valueOf(strValueOf)));
            }
            if (num == null) {
                throw new GeneralSecurityException("For given Variant TINK the value of idRequirement must be non-null");
            }
            zziazVarZzb = zzhms.zzb(num.intValue());
        }
        return new zzhhc(zzhhgVar, zziazVarZzb, num);
    }

    @Override // com.google.android.gms.internal.ads.zzhet, com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    public final Integer zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhet
    public final zziaz zzc() {
        return this.zzb;
    }

    public final zzhhg zze() {
        return this.zza;
    }
}
