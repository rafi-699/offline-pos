package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdee implements zzimu {
    private final zzind zza;

    private zzdee(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdee zza(zzind zzindVar) {
        return new zzdee(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzded(((zzing) this.zza).zzb());
    }
}
