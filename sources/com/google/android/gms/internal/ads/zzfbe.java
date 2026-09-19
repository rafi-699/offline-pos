package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfbe implements zzfck {
    private final Context zza;
    private final zzhcg zzb;
    private final zzfky zzc;
    private final VersionInfoParcel zzd;

    zzfbe(Context context, zzhcg zzhcgVar, zzfky zzfkyVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzhcgVar;
        this.zzc = zzfkyVar;
        this.zzd = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zzb.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfbd
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 53;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0041 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:12:0x0043 A[Catch: IOException -> 0x0124, TryCatch #0 {IOException -> 0x0124, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:9:0x002f, B:14:0x0055, B:15:0x0079, B:17:0x008b, B:19:0x00a1, B:21:0x00aa, B:26:0x00d0, B:28:0x00ee, B:29:0x0112, B:31:0x011d, B:24:0x00be, B:12:0x0043), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0055 A[Catch: IOException -> 0x0124, TryCatch #0 {IOException -> 0x0124, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:9:0x002f, B:14:0x0055, B:15:0x0079, B:17:0x008b, B:19:0x00a1, B:21:0x00aa, B:26:0x00d0, B:28:0x00ee, B:29:0x0112, B:31:0x011d, B:24:0x00be, B:12:0x0043), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x00bc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x00be A[Catch: IOException -> 0x0124, TryCatch #0 {IOException -> 0x0124, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:9:0x002f, B:14:0x0055, B:15:0x0079, B:17:0x008b, B:19:0x00a1, B:21:0x00aa, B:26:0x00d0, B:28:0x00ee, B:29:0x0112, B:31:0x011d, B:24:0x00be, B:12:0x0043), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00d0 A[Catch: IOException -> 0x0124, TryCatch #0 {IOException -> 0x0124, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:9:0x002f, B:14:0x0055, B:15:0x0079, B:17:0x008b, B:19:0x00a1, B:21:0x00aa, B:26:0x00d0, B:28:0x00ee, B:29:0x0112, B:31:0x011d, B:24:0x00be, B:12:0x0043), top: B:36:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x00ee A[Catch: IOException -> 0x0124, TryCatch #0 {IOException -> 0x0124, blocks: (B:2:0x0000, B:4:0x0015, B:6:0x0027, B:9:0x002f, B:14:0x0055, B:15:0x0079, B:17:0x008b, B:19:0x00a1, B:21:0x00aa, B:26:0x00d0, B:28:0x00ee, B:29:0x0112, B:31:0x011d, B:24:0x00be, B:12:0x0043), top: B:36:0x0000 }] */
    final /* synthetic */ zzfbf zzc() {
        zzgcg zzgcgVar;
        boolean z;
        boolean zZze;
        zzgcl zzgclVarZzh;
        zzgch zzgchVarZza;
        try {
            Context context = this.zza;
            boolean zZza = this.zzc.zza();
            zzgcg zzgcgVar2 = new zzgcg();
            zzgcg zzgcgVar3 = new zzgcg();
            boolean zZzc = true;
            if (zZza) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzea)).booleanValue()) {
                    return new zzfbf(true);
                }
            }
            if (!zZza) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdW)).booleanValue()) {
                    zzgcgVar2 = zzgck.zzh(context).zzi(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeh)).longValue(), com.google.android.gms.ads.internal.zzt.zzh().zzo().zzx());
                } else if (zZza) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdY)).booleanValue()) {
                        zzgcgVar2 = zzgck.zzh(context).zzi(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeh)).longValue(), com.google.android.gms.ads.internal.zzt.zzh().zzo().zzx());
                    }
                }
            } else if (zZza) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdY)).booleanValue()) {
                    zzgcgVar2 = zzgck.zzh(context).zzi(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzeh)).longValue(), com.google.android.gms.ads.internal.zzt.zzh().zzo().zzx());
                }
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzee)).booleanValue()) {
                if (this.zzd.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzed)).intValue()) {
                    zzgcl.zzh(context).zzj();
                }
            }
            if (zZza) {
                if (zZza) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdZ)).booleanValue()) {
                        zzgclVarZzh = zzgcl.zzh(context);
                        zzgchVarZza = zzgch.zza(context);
                        if (this.zzd.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzed)).intValue()) {
                            zzgcgVar3 = zzgclVarZzh.zzi(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzei)).longValue(), com.google.android.gms.ads.internal.zzt.zzh().zzo().zzx());
                            zZzc = zzgchVarZza.zzc();
                        }
                        zZze = zzgchVarZza.zze();
                        zzgcgVar = zzgcgVar3;
                        z = zZzc;
                    }
                }
                zzgcgVar = zzgcgVar3;
                z = true;
                zZze = true;
            } else {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdX)).booleanValue()) {
                    zzgclVarZzh = zzgcl.zzh(context);
                    zzgchVarZza = zzgch.zza(context);
                    if (this.zzd.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzed)).intValue()) {
                        zzgcgVar3 = zzgclVarZzh.zzi(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzei)).longValue(), com.google.android.gms.ads.internal.zzt.zzh().zzo().zzx());
                        zZzc = zzgchVarZza.zzc();
                    }
                    zZze = zzgchVarZza.zze();
                    zzgcgVar = zzgcgVar3;
                    z = zZzc;
                } else {
                    if (zZza) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzdZ)).booleanValue()) {
                            zzgclVarZzh = zzgcl.zzh(context);
                            zzgchVarZza = zzgch.zza(context);
                            if (this.zzd.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzed)).intValue()) {
                                zzgcgVar3 = zzgclVarZzh.zzi(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzei)).longValue(), com.google.android.gms.ads.internal.zzt.zzh().zzo().zzx());
                                zZzc = zzgchVarZza.zzc();
                            }
                            zZze = zzgchVarZza.zze();
                            zzgcgVar = zzgcgVar3;
                            z = zZzc;
                        }
                    }
                    zzgcgVar = zzgcgVar3;
                    z = true;
                    zZze = true;
                }
            }
            return new zzfbf(zzgcgVar2, zzgcgVar, z, zZze, zZza);
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "PerAppIdSignal");
            return new zzfbf(this.zzc.zza());
        }
    }
}
