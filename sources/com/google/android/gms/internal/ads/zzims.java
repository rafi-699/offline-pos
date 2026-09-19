package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzims implements zzimu {
    private zzind zza;

    public static void zza(zzind zzindVar, zzind zzindVar2) {
        zzims zzimsVar = (zzims) zzindVar;
        if (zzimsVar.zza != null) {
            throw new IllegalStateException();
        }
        zzimsVar.zza = zzindVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final Object zzb() {
        zzind zzindVar = this.zza;
        if (zzindVar != null) {
            return zzindVar.zzb();
        }
        throw new IllegalStateException();
    }
}
