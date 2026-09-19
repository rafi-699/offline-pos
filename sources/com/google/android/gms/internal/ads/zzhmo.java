package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhmo {
    private static final zzhmo zza = new zzhmo();
    private final AtomicReference zzb = new AtomicReference(new zzhnj(new zzhng(null), null));

    zzhmo() {
    }

    public static zzhmo zza() {
        return zza;
    }

    public final synchronized void zzb(zzhnf zzhnfVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzhng zzhngVar = new zzhng((zzhnj) atomicReference.get(), null);
        zzhngVar.zza(zzhnfVar);
        atomicReference.set(new zzhnj(zzhngVar, null));
    }

    public final synchronized void zzc(zzhnl zzhnlVar) throws GeneralSecurityException {
        AtomicReference atomicReference = this.zzb;
        zzhng zzhngVar = new zzhng((zzhnj) atomicReference.get(), null);
        zzhngVar.zzb(zzhnlVar);
        atomicReference.set(new zzhnj(zzhngVar, null));
    }

    public final Object zzd(zzhdq zzhdqVar, Class cls) throws GeneralSecurityException {
        return ((zzhnj) this.zzb.get()).zza(zzhdqVar, cls);
    }

    public final Object zze(zzhec zzhecVar, Class cls) throws GeneralSecurityException {
        return ((zzhnj) this.zzb.get()).zzb(zzhecVar, cls);
    }
}
