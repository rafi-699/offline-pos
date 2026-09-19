package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfqd implements zzhbt {
    final /* synthetic */ zzfqg zza;
    final /* synthetic */ zzfpw zzb;

    zzfqd(zzfqg zzfqgVar, zzfpw zzfpwVar) {
        this.zza = zzfqgVar;
        this.zzb = zzfpwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfpw zzfpwVar = this.zzb;
        zzfpwVar.zzj(th);
        zzfpwVar.zzd(false);
        this.zza.zza(zzfpwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
    }
}
