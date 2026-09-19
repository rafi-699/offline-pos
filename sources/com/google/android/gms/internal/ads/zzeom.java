package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeom implements zzhbt {
    final /* synthetic */ zzfkf zza;
    final /* synthetic */ zzeon zzb;

    zzeom(zzeon zzeonVar, zzfkf zzfkfVar) {
        this.zza = zzfkfVar;
        Objects.requireNonNull(zzeonVar);
        this.zzb = zzeonVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzeon zzeonVar = this.zzb;
        synchronized (zzeonVar) {
            zzeoo zzeooVarZzc = zzeonVar.zzc();
            zzfkf zzfkfVar = this.zza;
            zzeooVarZzc.zzc(th, zzfkfVar);
            zzfkf zzfkfVarZza = zzeonVar.zzc().zza();
            if (zzfkfVar.zzav) {
                while (zzfkfVarZza != null) {
                    zzeonVar.zzb(zzfkfVarZza);
                    zzfkfVarZza = zzeonVar.zzc().zza();
                }
            } else if (zzfkfVarZza != null) {
                zzeonVar.zzb(zzfkfVarZza);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeon zzeonVar = this.zzb;
        zzepe zzepeVar = (zzepe) obj;
        synchronized (zzeonVar) {
            zzeonVar.zzc().zzb(zzepeVar, this.zza);
            zzfkf zzfkfVarZza = zzeonVar.zzc().zza();
            if (zzfkfVarZza != null) {
                zzeonVar.zzb(zzfkfVarZza);
            }
        }
    }
}
