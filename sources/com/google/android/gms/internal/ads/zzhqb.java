package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhqb extends zzhqe {
    private final zzhqc zza;
    private final zzibb zzb;

    private zzhqb(zzhqc zzhqcVar, zzibb zzibbVar) {
        this.zza = zzhqcVar;
        this.zzb = zzibbVar;
    }

    public static zzhqb zzc(zzhqc zzhqcVar, zzibb zzibbVar) throws GeneralSecurityException {
        if (zzhqcVar.zzc() == zzibbVar.zzd()) {
            return new zzhqb(zzhqcVar, zzibbVar);
        }
        throw new GeneralSecurityException("Key size mismatch");
    }

    @Override // com.google.android.gms.internal.ads.zzhqe, com.google.android.gms.internal.ads.zzhdq
    public final /* synthetic */ zzheh zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhdq
    @Nullable
    public final Integer zzb() {
        return null;
    }

    public final zzibb zzd() {
        return this.zzb;
    }
}
