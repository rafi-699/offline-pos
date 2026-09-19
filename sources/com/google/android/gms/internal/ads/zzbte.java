package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbte implements zzcfy {
    final /* synthetic */ zzbtt zza;
    final /* synthetic */ zzfpw zzb;
    final /* synthetic */ zzbtu zzc;

    zzbte(zzbtu zzbtuVar, zzbtt zzbttVar, zzfpw zzfpwVar) {
        this.zza = zzbttVar;
        this.zzb = zzfpwVar;
        Objects.requireNonNull(zzbtuVar);
        this.zzc = zzbtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfy
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Trying to acquire lock");
        zzbtu zzbtuVar = this.zzc;
        synchronized (zzbtuVar.zzg()) {
            com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock acquired");
            zzbtuVar.zzl(1);
            com.google.android.gms.ads.internal.util.zze.zza("Failed loading new engine. Marking new engine destroyable.");
            this.zza.zzc();
            if (((Boolean) zzbkj.zzd.zze()).booleanValue() && zzbtuVar.zzh() != null) {
                zzfqj zzfqjVarZzh = zzbtuVar.zzh();
                zzfpw zzfpwVar = this.zzb;
                zzfpwVar.zzk("Failed loading new engine");
                zzfpwVar.zzd(false);
                zzfqjVarZzh.zzb(zzfpwVar.zzm());
            }
        }
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine (failure): Lock released");
    }
}
