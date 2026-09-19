package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzahk {
    void zzA(zzv zzvVar);

    default void zzO(long j) {
    }

    default int zza(zzj zzjVar, int i, boolean z) throws IOException {
        return zzb(zzjVar, i, z, 0);
    }

    int zzb(zzj zzjVar, int i, boolean z, int i2) throws IOException;

    default void zzc(zzet zzetVar, int i) {
        zzd(zzetVar, i, 0);
    }

    void zzd(zzet zzetVar, int i, int i2);

    void zze(long j, int i, int i2, int i3, zzahj zzahjVar);
}
