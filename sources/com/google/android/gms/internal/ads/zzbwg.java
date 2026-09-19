package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbwg extends zzbvh {
    private final Adapter zza;
    private final zzcca zzb;

    zzbwg(Adapter adapter, zzcca zzccaVar) {
        this.zza = adapter;
        this.zzb = zzccaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zze() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzl(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzf() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzg(int i) throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzm(ObjectWrapper.wrap(this.zza), i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzh() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzi() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzh(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzj() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzg(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzk() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzl(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzm(zzbmv zzbmvVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzn() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzo() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzp(zzccb zzccbVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzq() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzr(zzccf zzccfVar) throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzk(ObjectWrapper.wrap(this.zza), new zzccb(zzccfVar.zze(), zzccfVar.zzf()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzs(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzt() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzo(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzu() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzv(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzw(int i, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzx(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzy(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final void zzz() throws RemoteException {
        zzcca zzccaVar = this.zzb;
        if (zzccaVar != null) {
            zzccaVar.zzp(ObjectWrapper.wrap(this.zza));
        }
    }
}
