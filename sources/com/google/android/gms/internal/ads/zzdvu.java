package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdvu implements zzimu {
    private final zzind zza;

    private zzdvu(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdvu zza(zzind zzindVar) {
        return new zzdvu(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbhv.zza.EnumC0021zza enumC0021zza = ((zzdci) this.zza).zza().zzp.zza == 3 ? zzbhv.zza.EnumC0021zza.REWARDED_INTERSTITIAL : zzbhv.zza.EnumC0021zza.REWARD_BASED_VIDEO_AD;
        zzinc.zzb(enumC0021zza);
        return enumC0021zza;
    }
}
