package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzcem extends IInterface {
    void zze(IObjectWrapper iObjectWrapper, zzceq zzceqVar, zzcej zzcejVar) throws RemoteException;

    void zzf(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzg(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException;

    void zzh(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException;

    void zzi(zzbzt zzbztVar) throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzk(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException;

    void zzl(List list, IObjectWrapper iObjectWrapper, zzbzq zzbzqVar) throws RemoteException;

    IObjectWrapper zzm(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException;
}
