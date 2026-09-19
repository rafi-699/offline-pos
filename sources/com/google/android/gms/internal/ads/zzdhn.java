package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdhn implements zzimu {
    private final zzind zza;

    private zzdhn(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdhn zza(zzind zzindVar) {
        return new zzdhn(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdhm(((zzing) this.zza).zzb());
    }
}
