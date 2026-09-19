package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcqg implements zzimu {
    private final zzcqf zza;

    private zzcqg(zzcqf zzcqfVar) {
        this.zza = zzcqfVar;
    }

    public static zzcqg zzc(zzcqf zzcqfVar) {
        return new zzcqg(zzcqfVar);
    }

    public static com.google.android.gms.ads.internal.zza zzd(zzcqf zzcqfVar) {
        return new com.google.android.gms.ads.internal.zza(new zzcik(), new zzchf());
    }

    public final com.google.android.gms.ads.internal.zza zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
