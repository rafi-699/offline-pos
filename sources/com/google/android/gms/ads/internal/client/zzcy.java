package com.google.android.gms.ads.internal.client;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbrw;
import com.google.android.gms.internal.ads.zzbvc;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzcy extends IInterface {
    void zze() throws RemoteException;

    void zzf(float f) throws RemoteException;

    void zzg(String str) throws RemoteException;

    void zzh(boolean z) throws RemoteException;

    void zzi(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzj(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    float zzk() throws RemoteException;

    boolean zzl() throws RemoteException;

    String zzm() throws RemoteException;

    void zzn(String str) throws RemoteException;

    void zzo(zzbvc zzbvcVar) throws RemoteException;

    void zzp(zzbrw zzbrwVar) throws RemoteException;

    List zzq() throws RemoteException;

    void zzr(zzfr zzfrVar) throws RemoteException;

    void zzs() throws RemoteException;

    void zzt(zzdk zzdkVar) throws RemoteException;

    void zzu(boolean z) throws RemoteException;

    void zzv(String str) throws RemoteException;

    void zzw() throws RemoteException;
}
