package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcuj implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcuj(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar3;
    }

    public static zzcuj zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzcuj(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setEmptySet = ((JSONObject) this.zzb.zzb()) == null ? Collections.emptySet() : Collections.singleton(new zzdkq((zzcug) this.zza.zzb(), zzfoa.zzc()));
        zzinc.zzb(setEmptySet);
        return setEmptySet;
    }
}
