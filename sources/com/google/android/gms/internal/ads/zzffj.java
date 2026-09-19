package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzffj implements zzhbt {
    final /* synthetic */ zzetr zza;
    final /* synthetic */ zzfqg zzb;
    final /* synthetic */ zzfpw zzc;
    final /* synthetic */ zzffk zzd;
    final /* synthetic */ zzffn zze;

    zzffj(zzffn zzffnVar, zzetr zzetrVar, zzfqg zzfqgVar, zzfpw zzfpwVar, zzffk zzffkVar) {
        this.zza = zzetrVar;
        this.zzb = zzfqgVar;
        this.zzc = zzfpwVar;
        this.zzd = zzffkVar;
        Objects.requireNonNull(zzffnVar);
        this.zze = zzffnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfqg zzfqgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgL)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("App open ad failed to load", th);
        }
        zzffn zzffnVar = this.zze;
        zzcuv zzcuvVar = (zzcuv) zzffnVar.zzj().zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzcuvVar == null ? zzfma.zzb(th, null) : zzcuvVar.zza().zzg(th);
        synchronized (zzffnVar) {
            zzffnVar.zzl(null);
            if (zzcuvVar != null) {
                zzcuvVar.zze().zzdJ(zzeVarZzb);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjv)).booleanValue()) {
                    zzffnVar.zzh().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffi
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzi().zzdJ(zzeVarZzb);
                        }
                    });
                }
            } else {
                zzffnVar.zzi().zzdJ(zzeVarZzb);
                ((zzcuv) zzffnVar.zzg(this.zzd).zzh()).zza().zzd().zzo();
            }
            zzflv.zza(zzeVarZzb.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                zzfqj zzfqjVarZzk = zzffnVar.zzk();
                zzfpw zzfpwVar = this.zzc;
                zzfpwVar.zzh(zzeVarZzb);
                zzfpwVar.zzj(th);
                zzfpwVar.zzd(false);
                zzfqjVarZzk.zzb(zzfpwVar.zzm());
            } else {
                zzfqgVar.zzf(zzeVarZzb);
                zzfpw zzfpwVar2 = this.zzc;
                zzfpwVar2.zzj(th);
                zzfpwVar2.zzd(false);
                zzfqgVar.zza(zzfpwVar2);
                zzfqgVar.zzh();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0063 A[Catch: all -> 0x0089, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x002b, B:11:0x003f, B:13:0x0043, B:15:0x0087, B:14:0x0063), top: B:20:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0020 A[Catch: all -> 0x0089, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x002b, B:11:0x003f, B:13:0x0043, B:15:0x0087, B:14:0x0063), top: B:20:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfqg zzfqgVar;
        zzffn zzffnVar = this.zze;
        zzcxt zzcxtVar = (zzcxt) obj;
        synchronized (zzffnVar) {
            if (zzcxtVar != null) {
                zzcxtVar.zzt();
                zzffnVar.zzl(null);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjv)).booleanValue()) {
                    zzcxtVar.zzq().zzc(zzffnVar.zzi());
                }
                this.zza.zzb(zzcxtVar);
                if (((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                    zzfqj zzfqjVarZzk = zzffnVar.zzk();
                    zzfpw zzfpwVar = this.zzc;
                    zzfpwVar.zzg(zzcxtVar.zzr().zzb);
                    zzfpwVar.zzi(zzcxtVar.zzn().zze());
                    zzfpwVar.zzd(true);
                    zzfqjVarZzk.zzb(zzfpwVar.zzm());
                } else {
                    zzfqgVar.zze(zzcxtVar.zzr().zzb);
                    zzfqgVar.zzg(zzcxtVar.zzn().zze());
                    zzfpw zzfpwVar2 = this.zzc;
                    zzfpwVar2.zzd(true);
                    zzfqgVar.zza(zzfpwVar2);
                    zzfqgVar.zzh();
                }
            } else {
                zzffnVar.zzl(null);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjv)).booleanValue()) {
                    zzcxtVar.zzq().zzc(zzffnVar.zzi());
                }
                this.zza.zzb(zzcxtVar);
                if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                    zzfqj zzfqjVarZzk2 = zzffnVar.zzk();
                    zzfpw zzfpwVar3 = this.zzc;
                    zzfpwVar3.zzg(zzcxtVar.zzr().zzb);
                    zzfpwVar3.zzi(zzcxtVar.zzn().zze());
                    zzfpwVar3.zzd(true);
                    zzfqjVarZzk2.zzb(zzfpwVar3.zzm());
                } else {
                    zzfqj zzfqjVarZzk3 = zzffnVar.zzk();
                    zzfpw zzfpwVar4 = this.zzc;
                    zzfpwVar4.zzg(zzcxtVar.zzr().zzb);
                    zzfpwVar4.zzi(zzcxtVar.zzn().zze());
                    zzfpwVar4.zzd(true);
                    zzfqjVarZzk3.zzb(zzfpwVar4.zzm());
                }
            }
            throw th;
        }
    }
}
