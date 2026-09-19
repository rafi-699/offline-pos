package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgct implements zzimu {
    private final zzind zza;

    private zzgct(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzgct zza(zzind zzindVar) {
        return new zzgct(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        File dir = ((Context) this.zza.zzb()).getDir("yqzdkcache", 0);
        zzinc.zzb(dir);
        return dir;
    }
}
