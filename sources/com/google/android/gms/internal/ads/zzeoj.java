package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeoj implements zzely {
    private final Context zza;
    private final zzdoc zzb;
    private zzbvr zzc;
    private final VersionInfoParcel zzd;

    public zzeoj(Context context, zzdoc zzdocVar, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzdocVar;
        this.zzd = versionInfoParcel;
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final void zza(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf {
        try {
            zzbxb zzbxbVar = (zzbxb) zzelvVar.zzb;
            zzbxbVar.zzo(zzfkfVar.zzZ);
            if (this.zzd.clientJarVersion < ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcs)).intValue()) {
                zzbxbVar.zzn(zzfkfVar.zzU, zzfkfVar.zzv.toString(), zzfkqVar.zza.zza.zzd, ObjectWrapper.wrap(this.zza), new zzeoi(this, zzelvVar, null), (zzbvi) zzelvVar.zzc);
                return;
            }
            String str = zzfkfVar.zzU;
            String string = zzfkfVar.zzv.toString();
            zzfky zzfkyVar = zzfkqVar.zza.zza;
            zzbxbVar.zzr(str, string, zzfkyVar.zzd, ObjectWrapper.wrap(this.zza), new zzeoi(this, zzelvVar, null), (zzbvi) zzelvVar.zzc, zzfkyVar.zzj);
        } catch (RemoteException e) {
            throw new zzflf(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzely
    public final /* bridge */ /* synthetic */ Object zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, zzelv zzelvVar) throws zzflf, zzeph {
        ArrayList arrayList = zzfkqVar.zza.zza.zzh;
        if (!arrayList.contains(Integer.toString(6))) {
            throw new zzeph(2, "Unified must be used for RTB.");
        }
        zzdpt zzdptVarZzaf = zzdpt.zzaf(this.zzc);
        if (!arrayList.contains(Integer.toString(zzdptVarZzaf.zzx()))) {
            throw new zzeph(1, "No corresponding native ad listener");
        }
        zzdpv zzdpvVarZze = this.zzb.zze(new zzcyj(zzfkqVar, zzfkfVar, zzelvVar.zza), new zzdqe(zzdptVarZzaf), new zzdrx(null, null, this.zzc));
        ((zzenh) zzelvVar.zzc).zzc(zzdpvVarZze.zzg());
        return zzdpvVarZze.zzh();
    }

    final /* synthetic */ void zzc(zzbvr zzbvrVar) {
        this.zzc = zzbvrVar;
    }
}
