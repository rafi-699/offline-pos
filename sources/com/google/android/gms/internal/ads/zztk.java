package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztk {
    private final Context zza;
    private final zzqh zzb;
    private boolean zzc;
    private zztj zzd;
    private zzrf zze;
    private zztm zzf;
    private zzth zzg;

    @Deprecated
    public zztk() {
        this.zza = null;
        this.zzb = zzqh.zza;
    }

    public final zztr zza() {
        zzgtj.zzi(!this.zzc);
        this.zzc = true;
        if (this.zzf == null) {
            this.zzf = new zztm(new zzco[0]);
        }
        if (this.zze == null) {
            if (this.zzg == null) {
                this.zzg = new zzth(this.zza);
            }
            if (this.zzd == null) {
                this.zzd = zztj.zza;
            }
            Context context = this.zza;
            zztb zztbVar = new zztb(context);
            zztbVar.zzb(context != null ? null : this.zzb);
            zztbVar.zzf(this.zzg);
            zztbVar.zza(this.zzd);
            this.zze = zztbVar.zzc();
        } else {
            zzgtj.zzi(this.zzg == null);
            zzgtj.zzi(this.zzd == null);
        }
        return new zztr(this, null);
    }

    final /* synthetic */ Context zzb() {
        return this.zza;
    }

    final /* synthetic */ zzrf zzc() {
        return this.zze;
    }

    final /* synthetic */ zztm zzd() {
        return this.zzf;
    }

    public zztk(Context context) {
        this.zza = context;
        this.zzb = zzqh.zza;
    }
}
