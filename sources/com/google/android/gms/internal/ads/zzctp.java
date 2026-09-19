package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzctp implements zzhbt {
    final /* synthetic */ String zza;
    final /* synthetic */ zzctv zzb;

    zzctp(zzctv zzctvVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzctvVar);
        this.zzb = zzctvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzctv zzctvVar = this.zzb;
        zzctvVar.zzu().zza(zzctvVar.zzt().zzb(zzctvVar.zzr(), zzctvVar.zzs(), false, this.zza, null, zzctvVar.zzp(), zzctvVar.zzw(), zzctvVar.zzx()), null);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = this.zza;
        String str2 = (String) obj;
        zzctv zzctvVar = this.zzb;
        zzctvVar.zzu().zza(zzctvVar.zzt().zzb(zzctvVar.zzr(), zzctvVar.zzs(), false, str, str2, zzctvVar.zzp(), zzctvVar.zzw(), zzctvVar.zzx()), zzctvVar.zzv());
    }
}
