package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfyn extends zzbee implements IInterface {
    zzfyn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfyl zze(zzfyj zzfyjVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzfyjVar);
        Parcel parcelZzcZ = zzcZ(1, parcelZza);
        zzfyl zzfylVar = (zzfyl) zzbeg.zzb(parcelZzcZ, zzfyl.CREATOR);
        parcelZzcZ.recycle();
        return zzfylVar;
    }

    public final void zzf(zzfyg zzfygVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzfygVar);
        zzda(2, parcelZza);
    }

    public final zzfyu zzg(zzfys zzfysVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zzc(parcelZza, zzfysVar);
        Parcel parcelZzcZ = zzcZ(3, parcelZza);
        zzfyu zzfyuVar = (zzfyu) zzbeg.zzb(parcelZzcZ, zzfyu.CREATOR);
        parcelZzcZ.recycle();
        return zzfyuVar;
    }
}
