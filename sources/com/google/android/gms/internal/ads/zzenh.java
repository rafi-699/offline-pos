package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzenh extends zzbvh implements zzdeb {
    private zzbvi zza;
    private zzdea zzb;

    @Override // com.google.android.gms.internal.ads.zzdeb
    public final synchronized void zza(zzdea zzdeaVar) {
        this.zzb = zzdeaVar;
    }

    public final synchronized void zzc(zzbvi zzbviVar) {
        this.zza = zzbviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zze() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzf() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzg(int i) throws RemoteException {
        zzdea zzdeaVar = this.zzb;
        if (zzdeaVar != null) {
            zzdeaVar.zzb(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzh() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzi() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzi();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzj() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzj();
        }
        zzdea zzdeaVar = this.zzb;
        if (zzdeaVar != null) {
            zzdeaVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzk() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzl(String str, String str2) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzl(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzm(zzbmv zzbmvVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzn() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzo() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzo();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzp(zzccb zzccbVar) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzp(zzccbVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzq() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzq();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzr(zzccf zzccfVar) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzr(zzccfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzs(int i) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzs(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzt() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzu() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzv(String str) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzv(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzw(int i, String str) throws RemoteException {
        zzdea zzdeaVar = this.zzb;
        if (zzdeaVar != null) {
            zzdeaVar.zzc(i, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzx(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdea zzdeaVar = this.zzb;
        if (zzdeaVar != null) {
            zzdeaVar.zzd(zzeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzy(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzy(zzeVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvi
    public final synchronized void zzz() throws RemoteException {
        zzbvi zzbviVar = this.zza;
        if (zzbviVar != null) {
            zzbviVar.zzz();
        }
    }
}
