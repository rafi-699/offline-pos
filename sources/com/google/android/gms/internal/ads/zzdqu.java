package com.google.android.gms.internal.ads;

import android.view.View;
import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdqu {
    private final zzdzl zza;

    zzdqu(zzdzl zzdzlVar) {
        this.zza = zzdzlVar;
    }

    public final void zza(View view, zzfkf zzfkfVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzot)).booleanValue() || view == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzab.zza(view) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1";
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "hcp");
        zzdzkVarZza.zzc("hcp", str);
        zzdzkVarZza.zzb(zzfkfVar);
        zzdzkVarZza.zzd();
    }
}
