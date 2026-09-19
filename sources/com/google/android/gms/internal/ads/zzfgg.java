package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfgg extends zzffn {
    public zzfgg(Context context, Executor executor, zzcnj zzcnjVar, zzfhw zzfhwVar, zzfge zzfgeVar, zzfkx zzfkxVar, VersionInfoParcel versionInfoParcel) {
        super(context, executor, zzcnjVar, zzfhwVar, zzfgeVar, zzfkxVar, versionInfoParcel);
    }

    @Override // com.google.android.gms.internal.ads.zzffn
    protected final /* bridge */ /* synthetic */ zzdby zzc(zzcvi zzcviVar, zzdcb zzdcbVar, zzdir zzdirVar) {
        zzcuy zzcuyVarZzk = this.zza.zzk();
        zzcuyVarZzk.zzd(zzdcbVar);
        zzcuyVarZzk.zze(zzdirVar);
        return zzcuyVarZzk;
    }
}
