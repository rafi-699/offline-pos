package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhmv {
    private final zziaz zza;
    private final Class zzb;

    /* synthetic */ zzhmv(zziaz zziazVar, Class cls, byte[] bArr) {
        this.zza = zziazVar;
        this.zzb = cls;
    }

    public static zzhmv zzd(zzhmu zzhmuVar, zziaz zziazVar, Class cls) {
        return new zzhmt(zziazVar, cls, zzhmuVar);
    }

    public abstract zzheh zza(zzhns zzhnsVar) throws GeneralSecurityException;

    public final zziaz zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
