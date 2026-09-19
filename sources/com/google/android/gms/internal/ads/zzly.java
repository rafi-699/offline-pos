package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzly {
    default void zza(zzqf zzqfVar) {
        throw new IllegalStateException("onPrepared not implemented");
    }

    default void zzb(zzlx zzlxVar, zzzn zzznVar, zzaba[] zzabaVarArr) {
        throw new IllegalStateException("onTracksSelected not implemented");
    }

    default void zzc(zzqf zzqfVar) {
        throw new IllegalStateException("onStopped not implemented");
    }

    default void zzd(zzqf zzqfVar) {
        throw new IllegalStateException("onReleased not implemented");
    }

    zzabl zze(zzqf zzqfVar);

    default long zzf(zzqf zzqfVar) {
        throw new IllegalStateException("getBackBufferDurationUs not implemented");
    }

    default boolean zzg(zzqf zzqfVar) {
        throw new IllegalStateException("retainBackBufferFromKeyframe not implemented");
    }

    default boolean zzh(zzlx zzlxVar) {
        long j = zzlxVar.zzd;
        throw null;
    }

    default boolean zzi(zzlx zzlxVar) {
        zzbf zzbfVar = zzlxVar.zzb;
        throw null;
    }

    default boolean zzj(zzqf zzqfVar, zzbf zzbfVar, zzxk zzxkVar, long j) {
        zzeg.zzc("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
        return false;
    }
}
