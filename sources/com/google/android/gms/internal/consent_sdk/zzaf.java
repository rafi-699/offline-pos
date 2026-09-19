package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaf extends zza {
    private final zzaf zza = this;
    private final zzdn zzb;
    private final zzdn zzc;
    private final zzdn zzd;
    private final zzdn zze;
    private final zzdn zzf;
    private final zzdn zzg;
    private final zzdn zzh;
    private final zzdn zzi;
    private final zzdn zzj;
    private final zzdn zzk;
    private final zzdn zzl;

    /* synthetic */ zzaf(Application application, zzaj zzajVar) {
        zzdk zzdkVarZzb = zzdl.zzb(application);
        this.zzb = zzdkVarZzb;
        zzdn zzdnVarZzb = zzdj.zzb(new zzan(zzdkVarZzb));
        this.zzc = zzdnVarZzb;
        zzdn zzdnVarZzb2 = zzdj.zzb(zzac.zza);
        this.zzd = zzdnVarZzb2;
        zzae zzaeVar = new zzae(this);
        this.zze = zzaeVar;
        zzdn zzdnVarZzb3 = zzdj.zzb(new zzbl(zzaeVar, zzaq.zza));
        this.zzf = zzdnVarZzb3;
        zzo zzoVar = new zzo(zzdkVarZzb, zzdnVarZzb);
        this.zzg = zzoVar;
        zzdn zzdnVarZzb4 = zzdj.zzb(new zzf(zzaq.zza));
        this.zzh = zzdnVarZzb4;
        zzal zzalVar = new zzal(zzdkVarZzb, zzdnVarZzb, zzaq.zza);
        this.zzi = zzalVar;
        zzaa zzaaVar = new zzaa(zzdnVarZzb4, zzalVar, zzdnVarZzb);
        this.zzj = zzaaVar;
        zzv zzvVar = new zzv(zzdkVarZzb, zzdnVarZzb2, zzao.zza, zzaq.zza, zzdnVarZzb, zzdnVarZzb3, zzoVar, zzaaVar, zzdnVarZzb4);
        this.zzk = zzvVar;
        this.zzl = zzdj.zzb(new zzk(zzdnVarZzb, zzvVar, zzdnVarZzb3));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zza
    public final zzj zzb() {
        return (zzj) this.zzl.zza();
    }

    @Override // com.google.android.gms.internal.consent_sdk.zza
    public final zzbk zzc() {
        return (zzbk) this.zzf.zza();
    }
}
