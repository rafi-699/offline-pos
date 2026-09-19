package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzenu extends zzbwr {
    private final zzelv zza;

    /* synthetic */ zzenu(zzenv zzenvVar, zzelv zzelvVar, byte[] bArr) {
        Objects.requireNonNull(zzenvVar);
        this.zza = zzelvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zze() throws RemoteException {
        ((zzenh) this.zza.zzc).zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzf(String str) throws RemoteException {
        ((zzenh) this.zza.zzc).zzw(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzenh) this.zza.zzc).zzx(zzeVar);
    }
}
