package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbgw implements BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzbgx zza;

    zzbgw(zzbgx zzbgxVar) {
        Objects.requireNonNull(zzbgxVar);
        this.zza = zzbgxVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zzbgx zzbgxVar = this.zza;
        synchronized (zzbgxVar.zzh()) {
            zzbgxVar.zzk(null);
            if (zzbgxVar.zzi() != null) {
                zzbgxVar.zzj(null);
            }
            zzbgxVar.zzh().notifyAll();
        }
    }
}
