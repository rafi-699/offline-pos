package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzbmq extends IInterface {
    IObjectWrapper zzb() throws RemoteException;

    String zzc() throws RemoteException;

    List zzd() throws RemoteException;

    String zze() throws RemoteException;

    zzbme zzf() throws RemoteException;

    String zzg() throws RemoteException;

    double zzh() throws RemoteException;

    String zzi() throws RemoteException;

    String zzj() throws RemoteException;

    Bundle zzk() throws RemoteException;

    void zzl() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzea zzm() throws RemoteException;

    void zzn(Bundle bundle) throws RemoteException;

    boolean zzo(Bundle bundle) throws RemoteException;

    void zzp(Bundle bundle) throws RemoteException;

    zzblx zzq() throws RemoteException;

    IObjectWrapper zzr() throws RemoteException;

    String zzs() throws RemoteException;
}
