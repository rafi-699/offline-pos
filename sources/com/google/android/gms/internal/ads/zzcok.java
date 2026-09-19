package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcok implements zzimu {
    private final zzind zza;

    private zzcok(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzcok zza(zzind zzindVar, zzind zzindVar2) {
        return new zzcok(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzflx((zzduv) this.zza.zzb(), zzfoa.zzc());
    }
}
