package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzna extends zzmv {
    String zzU();

    default long zzV(long j, long j2) {
        if (zze() == 1) {
            return (zzaa() || zzab()) ? 1000000L : 10000L;
        }
        return 10000L;
    }

    default boolean zzW(long j) {
        return false;
    }

    default void zzX(float f, float f2) throws zzjk {
    }

    default void zzY() {
    }

    void zzZ(long j, long j2) throws zzjk;

    int zza();

    boolean zzaa();

    boolean zzab();

    zznc zzb();

    void zzc(int i, zzqf zzqfVar, zzdo zzdoVar);

    void zzcT() throws zzjk;

    void zzcU(zzv[] zzvVarArr, zzzc zzzcVar, long j, long j2, zzxk zzxkVar) throws zzjk;

    zzzc zzcV();

    boolean zzcW();

    zzmb zzd();

    int zze();

    void zzf(zznd zzndVar, zzv[] zzvVarArr, zzzc zzzcVar, long j, boolean z, boolean z2, long j2, long j3, zzxk zzxkVar) throws zzjk;

    long zzk();

    void zzl();

    boolean zzm();

    void zzn() throws IOException;

    void zzo(zzbf zzbfVar);

    void zzp(long j, boolean z) throws zzjk;

    void zzq();

    void zzr();

    void zzs();

    default void zzt() {
    }
}
