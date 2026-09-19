package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzebh extends zzcco {
    final /* synthetic */ zzebj zza;

    zzebh(zzebj zzebjVar) {
        Objects.requireNonNull(zzebjVar);
        this.zza = zzebjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zze() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzk(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzf(int i) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzl(zzebjVar.zzd(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzccp
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzl(zzebjVar.zzd(), zzeVar.zza);
    }
}
