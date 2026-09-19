package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfgo implements zzhbt {
    final /* synthetic */ zzfqg zza;
    final /* synthetic */ zzfpw zzb;
    final /* synthetic */ zzcwq zzc;
    final /* synthetic */ zzfgs zzd;

    zzfgo(zzfgs zzfgsVar, zzfqg zzfqgVar, zzfpw zzfpwVar, zzcwq zzcwqVar) {
        this.zza = zzfqgVar;
        this.zzb = zzfpwVar;
        this.zzc = zzcwqVar;
        Objects.requireNonNull(zzfgsVar);
        this.zzd = zzfgsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfqg zzfqgVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgL)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Banner ad failed to load", th);
        }
        zzfgs zzfgsVar = this.zzd;
        synchronized (zzfgsVar) {
            zzcwq zzcwqVar = this.zzc;
            com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzcwqVar.zzc().zzg(th);
            zzfgsVar.zzs(zzeVarZzg);
            zzcwqVar.zzb().zzdJ(zzeVarZzg);
            zzflv.zza(zzeVarZzg.zza, th, "BannerAdLoader.onFailure");
            if (zzfgsVar.zzr()) {
                zzfgsVar.zzn();
                zzfgsVar.zzo().zzd(zzfgsVar.zzq().zzc());
            }
            if (!((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zza) == null) {
                zzfqj zzfqjVarZzp = zzfgsVar.zzp();
                zzfpw zzfpwVar = this.zzb;
                zzfpwVar.zzh(zzeVarZzg);
                zzfpwVar.zzj(th);
                zzfpwVar.zzd(false);
                zzfqjVarZzp.zzb(zzfpwVar.zzm());
            } else {
                zzfqgVar.zzf(zzeVarZzg);
                zzfpw zzfpwVar2 = this.zzb;
                zzfpwVar2.zzj(th);
                zzfpwVar2.zzd(false);
                zzfqgVar.zza(zzfpwVar2);
                zzfqgVar.zzh();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0046 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0010, B:9:0x0013, B:11:0x0022, B:13:0x0026, B:15:0x006a, B:14:0x0046), top: B:20:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:8:0x0010 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0010, B:9:0x0013, B:11:0x0022, B:13:0x0026, B:15:0x006a, B:14:0x0046), top: B:20:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfqg zzfqgVar;
        zzfgs zzfgsVar = this.zzd;
        zzcvl zzcvlVar = (zzcvl) obj;
        synchronized (zzfgsVar) {
            if (zzcvlVar != null) {
                zzcvlVar.zzt();
                if (zzfgsVar.zzr()) {
                    zzfgsVar.zzc();
                }
                if (((Boolean) zzbkj.zzc.zze()).booleanValue() || (zzfqgVar = this.zza) == null) {
                    zzfqj zzfqjVarZzp = zzfgsVar.zzp();
                    zzfpw zzfpwVar = this.zzb;
                    zzfpwVar.zzg(zzcvlVar.zzr().zzb);
                    zzfpwVar.zzi(zzcvlVar.zzn().zze());
                    zzfpwVar.zzd(true);
                    zzfqjVarZzp.zzb(zzfpwVar.zzm());
                } else {
                    zzfqgVar.zze(zzcvlVar.zzr().zzb);
                    zzfqgVar.zzg(zzcvlVar.zzn().zze());
                    zzfpw zzfpwVar2 = this.zzb;
                    zzfpwVar2.zzd(true);
                    zzfqgVar.zza(zzfpwVar2);
                    zzfqgVar.zzh();
                }
            } else {
                if (zzfgsVar.zzr()) {
                    zzfgsVar.zzc();
                }
                if (((Boolean) zzbkj.zzc.zze()).booleanValue()) {
                    zzfqj zzfqjVarZzp2 = zzfgsVar.zzp();
                    zzfpw zzfpwVar3 = this.zzb;
                    zzfpwVar3.zzg(zzcvlVar.zzr().zzb);
                    zzfpwVar3.zzi(zzcvlVar.zzn().zze());
                    zzfpwVar3.zzd(true);
                    zzfqjVarZzp2.zzb(zzfpwVar3.zzm());
                } else {
                    zzfqj zzfqjVarZzp3 = zzfgsVar.zzp();
                    zzfpw zzfpwVar4 = this.zzb;
                    zzfpwVar4.zzg(zzcvlVar.zzr().zzb);
                    zzfpwVar4.zzi(zzcvlVar.zzn().zze());
                    zzfpwVar4.zzd(true);
                    zzfqjVarZzp3.zzb(zzfpwVar4.zzm());
                }
            }
            throw th;
        }
    }
}
