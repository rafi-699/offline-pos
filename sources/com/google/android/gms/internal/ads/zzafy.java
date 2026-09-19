package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzafy {
    boolean zza(zzafz zzafzVar) throws IOException;

    default List zzb() {
        return zzgwm.zzi();
    }

    void zzc(zzagb zzagbVar);

    int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException;

    void zze(long j, long j2);

    void zzf();

    @SideEffectFree
    default zzafy zzg() {
        return this;
    }
}
