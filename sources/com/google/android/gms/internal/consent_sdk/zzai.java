package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzai implements zzat {
    private final zzaf zza;
    private final zzdn zzb;
    private final zzdn zzc;
    private final zzdn zzd;
    private final zzdn zze;
    private final zzdn zzf;

    /* synthetic */ zzai(zzaf zzafVar, zzbm zzbmVar, zzaj zzajVar) {
        this.zza = zzafVar;
        zzdn zzdnVarZzb = zzdj.zzb(new zzbu(zzafVar.zzb));
        this.zzb = zzdnVarZzb;
        zzdk zzdkVarZzb = zzdl.zzb(zzbmVar);
        this.zzc = zzdkVarZzb;
        zzdi zzdiVar = new zzdi();
        this.zzd = zzdiVar;
        zzby zzbyVar = new zzby(zzafVar.zzb, zzdnVarZzb, zzao.zza, zzaq.zza, zzafVar.zzh, zzafVar.zzi, zzdiVar, zzafVar.zzc);
        this.zze = zzbyVar;
        zzbs zzbsVar = new zzbs(zzdnVarZzb, zzao.zza, zzbyVar);
        this.zzf = zzbsVar;
        zzdi.zzb(zzdiVar, zzdj.zzb(new zzaz(zzafVar.zzb, zzafVar.zzd, zzdnVarZzb, zzafVar.zzc, zzdkVarZzb, zzbsVar)));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzat
    public final zzay zza() {
        return (zzay) this.zzd.zza();
    }
}
