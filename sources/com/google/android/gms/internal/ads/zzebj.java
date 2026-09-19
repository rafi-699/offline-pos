package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzebj implements zzeau {
    private final long zza;
    private final zzeay zzb;
    private final zzfjw zzc;

    zzebj(long j, Context context, zzeay zzeayVar, zzcnj zzcnjVar, String str) {
        this.zza = j;
        this.zzb = zzeayVar;
        zzfjy zzfjyVarZzq = zzcnjVar.zzq();
        zzfjyVarZzq.zzc(context);
        zzfjyVarZzq.zzb(str);
        this.zzc = zzfjyVarZzq.zza().zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final void zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            this.zzc.zzc(zzmVar, new zzebh(this));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final void zzb() {
        try {
            zzfjw zzfjwVar = this.zzc;
            zzfjwVar.zze(new zzebi(this));
            zzfjwVar.zzb(ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzl("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final void zzc() {
    }

    final /* synthetic */ long zzd() {
        return this.zza;
    }

    final /* synthetic */ zzeay zze() {
        return this.zzb;
    }
}
