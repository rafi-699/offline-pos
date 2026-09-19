package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhic extends zzhet {
    private final zzhii zza;
    private final zzibb zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    private zzhic(zzhii zzhiiVar, zzibb zzibbVar, zziaz zziazVar, @Nullable Integer num) {
        this.zza = zzhiiVar;
        this.zzb = zzibbVar;
        this.zzc = zziazVar;
        this.zzd = num;
    }

    @Override // com.google.android.gms.internal.ads.zzhet, com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    @Nullable
    public final Integer zzb() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhet
    public final zziaz zzc() {
        return this.zzc;
    }

    public final zzibb zze() {
        return this.zzb;
    }

    public final zzhii zzf() {
        return this.zza;
    }

    public static zzhic zzd(zzhih zzhihVar, zzibb zzibbVar, @Nullable Integer num) throws GeneralSecurityException {
        zziaz zziazVarZzb;
        zzhih zzhihVar2 = zzhih.zzc;
        if (zzhihVar != zzhihVar2 && num == null) {
            String string = zzhihVar.toString();
            StringBuilder sb = new StringBuilder(string.length() + 62);
            sb.append("For given Variant ");
            sb.append(string);
            sb.append(" the value of idRequirement must be non-null");
            throw new GeneralSecurityException(sb.toString());
        }
        if (zzhihVar == zzhihVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzibbVar.zzd() != 32) {
            int iZzd = zzibbVar.zzd();
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzd).length() + 75);
            sb2.append("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not ");
            sb2.append(iZzd);
            throw new GeneralSecurityException(sb2.toString());
        }
        zzhii zzhiiVarZzb = zzhii.zzb(zzhihVar);
        if (zzhiiVarZzb.zzc() == zzhihVar2) {
            zziazVarZzb = zzhms.zza;
        } else if (zzhiiVarZzb.zzc() == zzhih.zzb) {
            zziazVarZzb = zzhms.zza(num.intValue());
        } else {
            if (zzhiiVarZzb.zzc() != zzhih.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzhiiVarZzb.zzc().toString()));
            }
            zziazVarZzb = zzhms.zzb(num.intValue());
        }
        return new zzhic(zzhiiVarZzb, zzibbVar, zziazVarZzb, num);
    }
}
