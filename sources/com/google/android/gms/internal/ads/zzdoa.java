package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdoa implements zzimu {
    private final zzdnx zza;

    private zzdoa(zzdnx zzdnxVar) {
        this.zza = zzdnxVar;
    }

    public static zzdoa zzc(zzdnx zzdnxVar) {
        return new zzdoa(zzdnxVar);
    }

    public static zzdqd zzd(zzdnx zzdnxVar) {
        zzdqd zzdqdVarZza = zzdnxVar.zza();
        zzinc.zzb(zzdqdVarZza);
        return zzdqdVarZza;
    }

    public final zzdqd zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
