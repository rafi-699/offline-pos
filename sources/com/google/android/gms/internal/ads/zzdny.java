package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdny implements zzimu {
    private final zzdnx zza;

    private zzdny(zzdnx zzdnxVar) {
        this.zza = zzdnxVar;
    }

    public static zzdny zzc(zzdnx zzdnxVar) {
        return new zzdny(zzdnxVar);
    }

    public final com.google.android.gms.ads.internal.client.zzbh zza() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return this.zza.zzb();
    }
}
