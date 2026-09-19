package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.ClientApi;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsv extends zzfub {
    public zzfsv(ClientApi clientApi, Context context, int i, zzflu zzfluVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzcb zzcbVar, ScheduledExecutorService scheduledExecutorService, zzfoo zzfooVar, zzfsw zzfswVar, Clock clock) {
        super(clientApi, context, i, zzfluVar, zzfpVar, zzcbVar, scheduledExecutorService, zzfooVar, zzfswVar, clock);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0080  */
    @Override // com.google.android.gms.internal.ads.zzfub
    protected final ListenableFuture zza(Context context) {
        zzfsv zzfsvVar;
        zzbvc zzbvcVarZzd = this.zzd.zzd();
        if (zzbvcVarZzd == null) {
            return zzhbw.zzc(new zzfso(1, "Failed to create an app open ad manager."));
        }
        zzfgm zzfgmVar = (zzfgm) this.zza.zzm(ObjectWrapper.wrap(context), com.google.android.gms.ads.internal.client.zzr.zzd(), ((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).zza, zzbvcVarZzd, this.zzc);
        if (zzfgmVar == null) {
            return zzhbw.zzc(new zzfso(1, "Failed to create an app open ad manager."));
        }
        zzhcp zzhcpVarZze = zzhcp.zze();
        try {
            zzB(((com.google.android.gms.ads.internal.client.zzfp) this.zze.get()).zzc);
            zzfsn zzfsnVar = this.zzf;
            if (zzfsnVar != null) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzT)).booleanValue()) {
                    zzfsvVar = this;
                    try {
                        zzfgmVar.zzL(new zzfsy(zzfsnVar, this.zzi, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzW)).longValue(), zzfsvVar));
                    } catch (RemoteException e) {
                        e = e;
                        com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to load app open ad.", e);
                        return zzhbw.zzc(new zzfso(1, "remote exception"));
                    }
                } else {
                    zzfsvVar = this;
                }
            } else {
                zzfsvVar = this;
            }
            zzfgmVar.zzJ(new zzfsu(new zzfto(this, zzhcpVarZze), ((com.google.android.gms.ads.internal.client.zzfp) zzfsvVar.zze.get()).zza));
            zzfgmVar.zze(((com.google.android.gms.ads.internal.client.zzfp) zzfsvVar.zze.get()).zzc);
            return zzhcpVarZze;
        } catch (RemoteException e2) {
            e = e2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfub
    protected final long zzb() {
        return ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzS)).longValue();
    }

    @Override // com.google.android.gms.internal.ads.zzfub
    protected final /* bridge */ /* synthetic */ com.google.android.gms.ads.internal.client.zzdx zzc(Object obj) {
        try {
            return ((zzbgj) obj).zzg();
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Failed to get response info for the app open ad.", e);
            return null;
        }
    }

    public zzfsv(String str, ClientApi clientApi, Context context, int i, zzflu zzfluVar, com.google.android.gms.ads.internal.client.zzfp zzfpVar, com.google.android.gms.ads.internal.client.zzce zzceVar, ScheduledExecutorService scheduledExecutorService, zzfoo zzfooVar, zzfsw zzfswVar, Clock clock, zzfsn zzfsnVar) {
        super(str, clientApi, context, i, zzfluVar, zzfpVar, zzceVar, scheduledExecutorService, zzfooVar, zzfswVar, clock, zzfsnVar);
    }
}
