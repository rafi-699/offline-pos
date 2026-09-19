package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzese extends com.google.android.gms.ads.internal.client.zzbm {
    private final zzetn zza;

    public zzese(Context context, zzcnj zzcnjVar, zzfkx zzfkxVar, zzdqd zzdqdVar, com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        zzetp zzetpVar = new zzetp(zzdqdVar, zzcnjVar.zzD());
        zzetpVar.zza(zzbhVar);
        this.zza = new zzetn(new zzetz(zzcnjVar, context, zzetpVar, zzfkxVar), zzfkxVar.zzh());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zze(com.google.android.gms.ads.internal.client.zzm zzmVar) throws RemoteException {
        this.zza.zzb(zzmVar, 1);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final synchronized String zzf() {
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final synchronized boolean zzg() throws RemoteException {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final synchronized String zzh() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final synchronized void zzi(com.google.android.gms.ads.internal.client.zzm zzmVar, int i) throws RemoteException {
        this.zza.zzb(zzmVar, i);
    }
}
