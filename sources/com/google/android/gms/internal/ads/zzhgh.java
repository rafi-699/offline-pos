package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhgh extends zzhet {
    private final zzhgm zza;
    private final zzibb zzb;
    private final zziaz zzc;

    @Nullable
    private final Integer zzd;

    private zzhgh(zzhgm zzhgmVar, zzibb zzibbVar, zziaz zziazVar, @Nullable Integer num) {
        this.zza = zzhgmVar;
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

    public final zzhgm zzf() {
        return this.zza;
    }

    public static zzhgh zzd(zzhgl zzhglVar, zzibb zzibbVar, @Nullable Integer num) throws GeneralSecurityException {
        zziaz zziazVarZzb;
        zzhgl zzhglVar2 = zzhgl.zzc;
        if (zzhglVar != zzhglVar2 && num == null) {
            String string = zzhglVar.toString();
            StringBuilder sb = new StringBuilder(string.length() + 62);
            sb.append("For given Variant ");
            sb.append(string);
            sb.append(" the value of idRequirement must be non-null");
            throw new GeneralSecurityException(sb.toString());
        }
        if (zzhglVar == zzhglVar2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        }
        if (zzibbVar.zzd() != 32) {
            int iZzd = zzibbVar.zzd();
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzd).length() + 74);
            sb2.append("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not ");
            sb2.append(iZzd);
            throw new GeneralSecurityException(sb2.toString());
        }
        zzhgm zzhgmVarZzb = zzhgm.zzb(zzhglVar);
        if (zzhgmVarZzb.zzc() == zzhglVar2) {
            zziazVarZzb = zzhms.zza;
        } else if (zzhgmVarZzb.zzc() == zzhgl.zzb) {
            zziazVarZzb = zzhms.zza(num.intValue());
        } else {
            if (zzhgmVarZzb.zzc() != zzhgl.zza) {
                throw new IllegalStateException("Unknown Variant: ".concat(zzhgmVarZzb.zzc().toString()));
            }
            zziazVarZzb = zzhms.zzb(num.intValue());
        }
        return new zzhgh(zzhgmVarZzb, zzibbVar, zziazVarZzb, num);
    }
}
