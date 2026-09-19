package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhmy {
    private final Class zza;
    private final Class zzb;

    /* synthetic */ zzhmy(Class cls, Class cls2, byte[] bArr) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzhmy zzd(zzhmx zzhmxVar, Class cls, Class cls2) {
        return new zzhmw(cls, cls2, zzhmxVar);
    }

    public abstract zzhns zza(zzheh zzhehVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zza;
    }

    public final Class zzc() {
        return this.zzb;
    }
}
