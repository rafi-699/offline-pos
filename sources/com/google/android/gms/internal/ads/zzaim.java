package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzaim {
    protected final zzahk zza;

    protected zzaim(zzahk zzahkVar) {
        this.zza = zzahkVar;
    }

    protected abstract boolean zza(zzet zzetVar) throws zzat;

    protected abstract boolean zzb(zzet zzetVar, long j) throws zzat;

    public final boolean zzf(zzet zzetVar, long j) throws zzat {
        return zza(zzetVar) && zzb(zzetVar, j);
    }
}
