package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzefx extends zzegc {
    private final Context zzg;
    private final VersionInfoParcel zzh;
    private final zzefw zzi;

    zzefx(Context context, VersionInfoParcel versionInfoParcel, zzefw zzefwVar, zzcag zzcagVar) {
        this.zzg = context;
        this.zzh = versionInfoParcel;
        this.zzi = zzefwVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzi(this.zzh.afmaVersion);
                    this.zzi.zza();
                } catch (RemoteException e) {
                    this.zzi.zzb(e);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzegc, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        super.onConnectionFailed(connectionResult);
        String errorMessage = connectionResult.getErrorMessage();
        String.valueOf(errorMessage);
        this.zzi.zzb(new RemoteException("Connection failed: ".concat(String.valueOf(errorMessage))));
    }

    @Override // com.google.android.gms.internal.ads.zzegc, com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        int i2 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzd("Cannot connect to remote service, fallback to local instance.");
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 33);
        sb.append("Connection suspended with cause: ");
        sb.append(i);
        this.zzi.zzb(new RemoteException(sb.toString()));
    }

    public final void zza() {
        synchronized (this.zzb) {
            if (this.zzc) {
                return;
            }
            this.zzc = true;
            this.zzf = new zzcaf(this.zzg, com.google.android.gms.ads.internal.zzt.zzs().zza(), this, this);
            this.zzf.checkAvailabilityAndConnect();
        }
    }
}
