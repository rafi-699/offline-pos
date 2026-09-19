package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzetw implements zzhbt {
    final /* synthetic */ zzetr zza;
    final /* synthetic */ zzfqg zzb;
    final /* synthetic */ zzfpw zzc;
    final /* synthetic */ zzdoc zzd;
    final /* synthetic */ zzetz zze;

    zzetw(zzetz zzetzVar, zzetr zzetrVar, zzfqg zzfqgVar, zzfpw zzfpwVar, zzdoc zzdocVar) {
        this.zza = zzetrVar;
        this.zzb = zzfqgVar;
        this.zzc = zzfpwVar;
        this.zzd = zzdocVar;
        Objects.requireNonNull(zzetzVar);
        this.zze = zzetzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfqg zzfqgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgL)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Native ad failed to load", th);
        }
        zzdoc zzdocVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzdocVar.zza().zzg(th);
        zzdocVar.zzb().zzdJ(zzeVarZzg);
        zzetz zzetzVar = this.zze;
        zzetzVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzetu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze.zzf().zze().zzdJ(zzeVarZzg);
            }
        });
        zzflv.zza(zzeVarZzg.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
            zzfqj zzfqjVarZzg = zzetzVar.zzg();
            zzfpw zzfpwVar = this.zzc;
            zzfpwVar.zzh(zzeVarZzg);
            zzfpwVar.zzj(th);
            zzfpwVar.zzd(false);
            zzfqjVarZzg.zzb(zzfpwVar.zzm());
            return;
        }
        zzfqgVar.zzf(zzeVarZzg);
        zzfpw zzfpwVar2 = this.zzc;
        zzfpwVar2.zzj(th);
        zzfpwVar2.zzd(false);
        zzfqgVar.zza(zzfpwVar2);
        zzfqgVar.zzh();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0061 A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x003d, B:10:0x0041, B:12:0x0085, B:11:0x0061), top: B:17:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfqg zzfqgVar;
        zzetz zzetzVar = this.zze;
        zzcxt zzcxtVar = (zzcxt) obj;
        synchronized (zzetzVar) {
            if (zzcxtVar != null) {
                zzcxtVar.zzt();
                zzcxtVar.zzq().zza(zzetzVar.zzf().zzc());
                this.zza.zzb(zzcxtVar);
                zzetzVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzetv
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzf().zzd().zzg();
                    }
                });
                if (((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                    zzfqj zzfqjVarZzg = zzetzVar.zzg();
                    zzfpw zzfpwVar = this.zzc;
                    zzfpwVar.zzg(zzcxtVar.zzr().zzb);
                    zzfpwVar.zzi(zzcxtVar.zzn().zze());
                    zzfpwVar.zzd(true);
                    zzfqjVarZzg.zzb(zzfpwVar.zzm());
                } else {
                    zzfqgVar.zze(zzcxtVar.zzr().zzb);
                    zzfqgVar.zzg(zzcxtVar.zzn().zze());
                    zzfpw zzfpwVar2 = this.zzc;
                    zzfpwVar2.zzd(true);
                    zzfqgVar.zza(zzfpwVar2);
                    zzfqgVar.zzh();
                }
            } else {
                zzcxtVar.zzq().zza(zzetzVar.zzf().zzc());
                this.zza.zzb(zzcxtVar);
                zzetzVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzetv
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzf().zzd().zzg();
                    }
                });
                if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                    zzfqj zzfqjVarZzg2 = zzetzVar.zzg();
                    zzfpw zzfpwVar3 = this.zzc;
                    zzfpwVar3.zzg(zzcxtVar.zzr().zzb);
                    zzfpwVar3.zzi(zzcxtVar.zzn().zze());
                    zzfpwVar3.zzd(true);
                    zzfqjVarZzg2.zzb(zzfpwVar3.zzm());
                } else {
                    zzfqj zzfqjVarZzg3 = zzetzVar.zzg();
                    zzfpw zzfpwVar4 = this.zzc;
                    zzfpwVar4.zzg(zzcxtVar.zzr().zzb);
                    zzfpwVar4.zzi(zzcxtVar.zzn().zze());
                    zzfpwVar4.zzd(true);
                    zzfqjVarZzg3.zzb(zzfpwVar4.zzm());
                }
            }
            throw th;
        }
    }
}
