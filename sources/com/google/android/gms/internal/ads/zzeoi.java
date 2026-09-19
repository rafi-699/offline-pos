package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzeoi extends zzbwu {
    final /* synthetic */ zzeoj zza;
    private final zzelv zzb;

    /* synthetic */ zzeoi(zzeoj zzeojVar, zzelv zzelvVar, byte[] bArr) {
        Objects.requireNonNull(zzeojVar);
        this.zza = zzeojVar;
        this.zzb = zzelvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zze(zzbvr zzbvrVar) throws RemoteException {
        this.zza.zzc(zzbvrVar);
        ((zzenh) this.zzb.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzf(String str) throws RemoteException {
        ((zzenh) this.zzb.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbwv
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzenh) this.zzb.zzc).zzx(zzeVar);
    }
}
