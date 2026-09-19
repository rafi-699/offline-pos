package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzbxb extends IInterface {
    void zze(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbxe zzbxeVar) throws RemoteException;

    zzbxq zzf() throws RemoteException;

    zzbxq zzg() throws RemoteException;

    com.google.android.gms.ads.internal.client.zzea zzh() throws RemoteException;

    void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwp zzbwpVar, zzbvi zzbviVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException;

    void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbws zzbwsVar, zzbvi zzbviVar) throws RemoteException;

    boolean zzk(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwy zzbwyVar, zzbvi zzbviVar) throws RemoteException;

    boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwv zzbwvVar, zzbvi zzbviVar) throws RemoteException;

    void zzo(String str) throws RemoteException;

    void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwy zzbwyVar, zzbvi zzbviVar) throws RemoteException;

    void zzq(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwp zzbwpVar, zzbvi zzbviVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException;

    void zzr(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwv zzbwvVar, zzbvi zzbviVar, zzblt zzbltVar) throws RemoteException;

    void zzs(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbwm zzbwmVar, zzbvi zzbviVar) throws RemoteException;

    boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException;
}
