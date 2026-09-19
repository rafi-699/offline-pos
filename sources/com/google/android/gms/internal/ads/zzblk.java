package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzblk {
    private final Context zza;

    public zzblk(Context context) {
        this.zza = context;
    }

    public final void zza(zzcae zzcaeVar) {
        try {
            ((zzbll) com.google.android.gms.ads.internal.util.client.zzs.zza(this.zza, "com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy", zzblj.zza)).zze(zzcaeVar);
        } catch (RemoteException e) {
            String message = e.getMessage();
            String.valueOf(message);
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Error calling setFlagsAccessedBeforeInitializedListener: ".concat(String.valueOf(message)));
        } catch (com.google.android.gms.ads.internal.util.client.zzr e2) {
            String message2 = e2.getMessage();
            String.valueOf(message2);
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not load com.google.android.gms.ads.flags.FlagRetrieverSupplierProxy:".concat(String.valueOf(message2)));
        }
    }
}
