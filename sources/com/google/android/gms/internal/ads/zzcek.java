package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcek extends zzbee implements zzcem {
    zzcek(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zze(IObjectWrapper iObjectWrapper, zzceq zzceqVar, zzcej zzcejVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zzc(parcelZza, zzceqVar);
        zzbeg.zze(parcelZza, zzcejVar);
        zzda(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzf(IObjectWrapper iObjectWrapper) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzi(zzbzt zzbztVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzda(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzcem
    public final IObjectWrapper zzm(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzbeg.zze(parcelZza, iObjectWrapper);
        zzbeg.zze(parcelZza, iObjectWrapper2);
        parcelZza.writeString(str);
        zzbeg.zze(parcelZza, iObjectWrapper3);
        Parcel parcelZzcZ = zzcZ(11, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzcZ.readStrongBinder());
        parcelZzcZ.recycle();
        return iObjectWrapperAsInterface;
    }
}
