package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdiu implements zzimu {
    private final zzdir zza;

    private zzdiu(zzdir zzdirVar) {
        this.zza = zzdirVar;
    }

    public static zzdiu zza(zzdir zzdirVar) {
        return new zzdiu(zzdirVar);
    }

    public static Set zzc(zzdir zzdirVar) {
        Set setEmptySet = Collections.emptySet();
        zzinc.zzb(setEmptySet);
        return setEmptySet;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzc(this.zza);
    }
}
