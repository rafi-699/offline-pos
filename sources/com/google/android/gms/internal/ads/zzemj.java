package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzemj extends zzbwl {
    private final zzelv zza;

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zze() throws RemoteException {
        ((zzenh) this.zza.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzf(String str) throws RemoteException {
        ((zzenh) this.zza.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbwm
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzenh) this.zza.zzc).zzx(zzeVar);
    }
}
