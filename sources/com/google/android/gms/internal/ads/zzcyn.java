package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcyn implements zzimu {
    private final zzcyj zza;

    private zzcyn(zzcyj zzcyjVar) {
        this.zza = zzcyjVar;
    }

    public static zzcyn zzc(zzcyj zzcyjVar) {
        return new zzcyn(zzcyjVar);
    }

    public static zzfkq zzd(zzcyj zzcyjVar) {
        zzfkq zzfkqVarZza = zzcyjVar.zza();
        zzinc.zzb(zzfkqVarZza);
        return zzfkqVarZza;
    }

    public final zzfkq zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
