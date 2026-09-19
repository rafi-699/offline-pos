package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzbvf extends IInterface {
    void zzA(boolean z) throws RemoteException;

    com.google.android.gms.ads.internal.client.zzea zzB() throws RemoteException;

    zzbvr zzC() throws RemoteException;

    void zzD(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException;

    void zzE(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzF(IObjectWrapper iObjectWrapper, zzbrt zzbrtVar, List list) throws RemoteException;

    void zzG(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException;

    zzbxq zzH() throws RemoteException;

    zzbxq zzI() throws RemoteException;

    void zzJ(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar) throws RemoteException;

    zzbvl zzK() throws RemoteException;

    void zzL(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzM(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException;

    void zzN(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzbvn zzO() throws RemoteException;

    zzbvo zzP() throws RemoteException;

    void zze(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException;

    IObjectWrapper zzf() throws RemoteException;

    void zzg(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbvi zzbviVar) throws RemoteException;

    void zzh() throws RemoteException;

    void zzi() throws RemoteException;

    void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar) throws RemoteException;

    void zzk(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar) throws RemoteException;

    void zzl() throws RemoteException;

    void zzm() throws RemoteException;

    void zzn(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzcca zzccaVar, String str2) throws RemoteException;

    void zzo(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) throws RemoteException;

    void zzp() throws RemoteException;

    boolean zzq() throws RemoteException;

    void zzr(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbvi zzbviVar, zzblt zzbltVar, List list) throws RemoteException;

    Bundle zzs() throws RemoteException;

    Bundle zzt() throws RemoteException;

    Bundle zzu() throws RemoteException;

    void zzv(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2) throws RemoteException;

    void zzw(IObjectWrapper iObjectWrapper) throws RemoteException;

    boolean zzx() throws RemoteException;

    void zzy(IObjectWrapper iObjectWrapper, zzcca zzccaVar, List list) throws RemoteException;

    zzbmv zzz() throws RemoteException;
}
