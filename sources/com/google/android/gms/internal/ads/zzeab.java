package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeab implements zzimu {
    private final zzind zza;

    private zzeab(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzeab zza(zzeaa zzeaaVar, zzind zzindVar, zzind zzindVar2) {
        return new zzeab(zzeaaVar, zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setZza = zzeaa.zza((zzeak) this.zza.zzb(), zzfoa.zzc());
        zzinc.zzb(setZza);
        return setZza;
    }
}
