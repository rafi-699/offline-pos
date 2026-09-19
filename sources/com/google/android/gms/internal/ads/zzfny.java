package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfny implements zzimu {
    public static zzfny zza() {
        return zzfnx.zza;
    }

    public static ExecutorService zzc() {
        ExecutorService executorService = zzcfr.zzg;
        zzinc.zzb(executorService);
        return executorService;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzc();
    }
}
