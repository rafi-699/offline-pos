package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdcf implements zzimu {
    private final zzdcb zza;

    private zzdcf(zzdcb zzdcbVar) {
        this.zza = zzdcbVar;
    }

    public static zzdcf zzc(zzdcb zzdcbVar) {
        return new zzdcf(zzdcbVar);
    }

    public final zzdbu zza() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return this.zza.zze();
    }
}
