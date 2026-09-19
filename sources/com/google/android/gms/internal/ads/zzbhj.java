package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbhj implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbhb zza;
    final /* synthetic */ zzcfw zzb;
    final /* synthetic */ zzbhl zzc;

    zzbhj(zzbhl zzbhlVar, zzbhb zzbhbVar, zzcfw zzcfwVar) {
        this.zza = zzbhbVar;
        this.zzb = zzcfwVar;
        Objects.requireNonNull(zzbhlVar);
        this.zzc = zzbhlVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        zzbhl zzbhlVar = this.zzc;
        synchronized (zzbhlVar.zzf()) {
            if (zzbhlVar.zzd()) {
                return;
            }
            zzbhlVar.zze(true);
            final zzbha zzbhaVarZzc = zzbhlVar.zzc();
            if (zzbhaVarZzc == null) {
                return;
            }
            zzhcg zzhcgVar = zzcfr.zza;
            final zzbhb zzbhbVar = this.zza;
            final zzcfw zzcfwVar = this.zzb;
            final ListenableFuture listenableFutureSubmit = zzhcgVar.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhi
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzcfw zzcfwVar2 = zzcfwVar;
                    zzbha zzbhaVar = zzbhaVarZzc;
                    zzbhj zzbhjVar = this.zza;
                    try {
                        zzbhd zzbhdVarZzq = zzbhaVar.zzq();
                        boolean zZzp = zzbhaVar.zzp();
                        zzbhb zzbhbVar2 = zzbhbVar;
                        zzbgy zzbgyVarZzf = zZzp ? zzbhdVarZzq.zzf(zzbhbVar2) : zzbhdVarZzq.zze(zzbhbVar2);
                        if (!zzbgyVarZzf.zza()) {
                            zzcfwVar2.zzd(new RuntimeException("No entry contents."));
                            zzbhjVar.zzc.zzb();
                            return;
                        }
                        zzbhg zzbhgVar = new zzbhg(zzbhjVar, zzbgyVarZzf.zzb(), 1);
                        int i = zzbhgVar.read();
                        if (i == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zzbhgVar.unread(i);
                        zzcfwVar2.zzc(zzbhn.zza(zzbhgVar, zzbgyVarZzf.zzd(), zzbgyVarZzf.zzg(), zzbgyVarZzf.zzf(), zzbgyVarZzf.zze()));
                    } catch (RemoteException | IOException e) {
                        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to obtain a cache service instance.", e);
                        zzcfwVar2.zzd(e);
                        zzbhjVar.zzc.zzb();
                    }
                }
            });
            zzcfwVar.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbhh
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzbhj.zzd;
                    if (zzcfwVar.isCancelled()) {
                        listenableFutureSubmit.cancel(true);
                    }
                }
            }, zzcfr.zzh);
        }
    }
}
