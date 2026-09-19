package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgje {
    private final Context zza;
    private final zzgqh zzb;
    private final zzgha zzc;
    private final String zzd;

    zzgje(Context context, zzgqh zzgqhVar, zzgha zzghaVar, zzgdf zzgdfVar) {
        this.zza = context;
        this.zzb = zzgqhVar;
        this.zzc = zzghaVar;
        this.zzd = zzgdfVar.zzd();
    }

    public final String zza(boolean z, long j) {
        zzgqf zzgqfVarZza = this.zzb.zza(55);
        try {
            zzgqfVarZza.zza();
            zzayx zzayxVarZza = zzayy.zza();
            zzayxVarZza.zzb(this.zzd);
            zzayxVarZza.zza("0.878096153");
            Context context = this.zza;
            zzayxVarZza.zzd(context.getPackageName());
            zzayxVarZza.zzc(System.currentTimeMillis() / 1000);
            zzayxVarZza.zzf((System.currentTimeMillis() - j) / 1000);
            try {
                zzayxVarZza.zze(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
                zzayxVarZza.zze(-1L);
            }
            zzgha zzghaVar = this.zzc;
            if (!zzghaVar.zzc()) {
                zzghaVar.zza();
            }
            zzaze zzazeVarZzf = zzghaVar.zzf(((zzayy) zzayxVarZza.zzbu()).zzaN(), null);
            zzazeVarZzf.zzc(5);
            zzazeVarZzf.zzd(2);
            String strZza = zzgea.zza(((zzazf) zzazeVarZzf.zzbu()).zzaN(), true);
            zzgqfVarZza.zzc();
            return strZza;
        } catch (Throwable th) {
            try {
                zzgqfVarZza.zzb(th);
                throw th;
            } catch (Throwable th2) {
                zzgqfVarZza.zzc();
                throw th2;
            }
        }
    }
}
