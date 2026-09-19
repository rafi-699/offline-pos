package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhvf extends zzhxj {
    private final zzhvl zza;
    private final zzibb zzb;

    private zzhvf(zzhvl zzhvlVar, zzibb zzibbVar) {
        this.zza = zzhvlVar;
        this.zzb = zzibbVar;
    }

    public static zzhvf zzc(zzhvl zzhvlVar, zzibb zzibbVar) throws GeneralSecurityException {
        if (zzibbVar.zzd() == 32) {
            if (Arrays.equals(zzhvlVar.zzd().zzc(), zzhlc.zza(zzhlc.zzb(zzibbVar.zzc(zzhdo.zza()))))) {
                return new zzhvf(zzhvlVar, zzibbVar);
            }
            throw new GeneralSecurityException("Ed25519 keys mismatch");
        }
        int iZzd = zzibbVar.zzd();
        StringBuilder sb = new StringBuilder(String.valueOf(iZzd).length() + 65);
        sb.append("Ed25519 key must be constructed with key of length 32 bytes, not ");
        sb.append(iZzd);
        throw new GeneralSecurityException(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhxj, com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza.zzf();
    }

    public final zzhve zzd() {
        return this.zza.zzf();
    }

    public final zzhvl zze() {
        return this.zza;
    }

    public final zzibb zzf() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhxj
    public final /* synthetic */ zzhxk zzg() {
        return this.zza;
    }
}
