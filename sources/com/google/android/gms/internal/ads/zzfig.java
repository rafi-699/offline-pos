package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfig implements zzhbt {
    final /* synthetic */ zzetr zza;
    final /* synthetic */ zzfqg zzb;
    final /* synthetic */ zzfpw zzc;
    final /* synthetic */ zzdng zzd;
    final /* synthetic */ zzfii zze;

    zzfig(zzfii zzfiiVar, zzetr zzetrVar, zzfqg zzfqgVar, zzfpw zzfpwVar, zzdng zzdngVar) {
        this.zza = zzetrVar;
        this.zzb = zzfqgVar;
        this.zzc = zzfpwVar;
        this.zzd = zzdngVar;
        Objects.requireNonNull(zzfiiVar);
        this.zze = zzfiiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfqg zzfqgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgL)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Interstitial ad failed to load", th);
        }
        zzdng zzdngVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzdngVar.zzb().zzg(th);
        zzfii zzfiiVar = this.zze;
        synchronized (zzfiiVar) {
            zzfiiVar.zzi(null);
            zzdngVar.zza().zzdJ(zzeVarZzg);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjw)).booleanValue()) {
                zzfiiVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfid
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzf().zzdJ(zzeVarZzg);
                    }
                });
                zzfiiVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfie
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzg().zzdJ(zzeVarZzg);
                    }
                });
            }
            zzflv.zza(zzeVarZzg.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                zzfqj zzfqjVarZzh = zzfiiVar.zzh();
                zzfpw zzfpwVar = this.zzc;
                zzfpwVar.zzh(zzeVarZzg);
                zzfpwVar.zzj(th);
                zzfpwVar.zzd(false);
                zzfqjVarZzh.zzb(zzfpwVar.zzm());
            } else {
                zzfqgVar.zzf(zzeVarZzg);
                zzfpw zzfpwVar2 = this.zzc;
                zzfpwVar2.zzj(th);
                zzfpwVar2.zzd(false);
                zzfqgVar.zza(zzfpwVar2);
                zzfqgVar.zzh();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0047 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x0032, B:11:0x0047, B:12:0x005f, B:14:0x006e, B:16:0x0072, B:18:0x00b6, B:17:0x0092), top: B:23:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0092 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x0032, B:11:0x0047, B:12:0x005f, B:14:0x006e, B:16:0x0072, B:18:0x00b6, B:17:0x0092), top: B:23:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0020 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x0032, B:11:0x0047, B:12:0x005f, B:14:0x006e, B:16:0x0072, B:18:0x00b6, B:17:0x0092), top: B:23:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbih zzbihVar;
        zzfqg zzfqgVar;
        zzfii zzfiiVar = this.zze;
        zzdlz zzdlzVar = (zzdlz) obj;
        synchronized (zzfiiVar) {
            if (zzdlzVar != null) {
                zzdlzVar.zzt();
                zzfiiVar.zzi(null);
                zzbihVar = zzbiq.zzjw;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
                    zzdgh zzdghVarZzq = zzdlzVar.zzq();
                    zzdghVarZzq.zza(zzfiiVar.zzf());
                    zzdghVarZzq.zzd(zzfiiVar.zzg());
                }
                this.zza.zzb(zzdlzVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
                    zzfiiVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfif
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzf().zzg();
                        }
                    });
                    zzfiiVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfic
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzg().zzg();
                        }
                    });
                }
                if (((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zzb) == null) {
                    zzfqj zzfqjVarZzh = zzfiiVar.zzh();
                    zzfpw zzfpwVar = this.zzc;
                    zzfpwVar.zzg(zzdlzVar.zzr().zzb);
                    zzfpwVar.zzi(zzdlzVar.zzn().zze());
                    zzfpwVar.zzd(true);
                    zzfqjVarZzh.zzb(zzfpwVar.zzm());
                } else {
                    zzfqgVar.zze(zzdlzVar.zzr().zzb);
                    zzfqgVar.zzg(zzdlzVar.zzn().zze());
                    zzfpw zzfpwVar2 = this.zzc;
                    zzfpwVar2.zzd(true);
                    zzfqgVar.zza(zzfpwVar2);
                    zzfqgVar.zzh();
                }
            } else {
                zzfiiVar.zzi(null);
                zzbihVar = zzbiq.zzjw;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
                    zzdgh zzdghVarZzq2 = zzdlzVar.zzq();
                    zzdghVarZzq2.zza(zzfiiVar.zzf());
                    zzdghVarZzq2.zzd(zzfiiVar.zzg());
                }
                this.zza.zzb(zzdlzVar);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).booleanValue()) {
                    zzfiiVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfif
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzf().zzg();
                        }
                    });
                    zzfiiVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfic
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzg().zzg();
                        }
                    });
                }
                if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                    zzfqj zzfqjVarZzh2 = zzfiiVar.zzh();
                    zzfpw zzfpwVar3 = this.zzc;
                    zzfpwVar3.zzg(zzdlzVar.zzr().zzb);
                    zzfpwVar3.zzi(zzdlzVar.zzn().zze());
                    zzfpwVar3.zzd(true);
                    zzfqjVarZzh2.zzb(zzfpwVar3.zzm());
                } else {
                    zzfqj zzfqjVarZzh3 = zzfiiVar.zzh();
                    zzfpw zzfpwVar4 = this.zzc;
                    zzfpwVar4.zzg(zzdlzVar.zzr().zzb);
                    zzfpwVar4.zzi(zzdlzVar.zzn().zze());
                    zzfpwVar4.zzd(true);
                    zzfqjVarZzh3.zzb(zzfpwVar4.zzm());
                }
            }
            throw th;
        }
    }
}
