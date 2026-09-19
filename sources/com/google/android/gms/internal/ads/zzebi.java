package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzebi extends zzcck {
    final /* synthetic */ zzebj zza;

    zzebi(zzebj zzebjVar) {
        Objects.requireNonNull(zzebjVar);
        this.zza = zzebjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zze() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzm(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzf() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzo(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzg(zzccf zzccfVar) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzp(zzebjVar.zzd(), zzccfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzh(int i) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzn(zzebjVar.zzd(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzn(zzebjVar.zzd(), zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzj() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzq(zzebjVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzccl
    public final void zzk() throws RemoteException {
        zzebj zzebjVar = this.zza;
        zzebjVar.zze().zzr(zzebjVar.zzd());
    }
}
