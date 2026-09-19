package com.google.android.gms.internal.ads;

import com.facebook.react.uimanager.ViewProps;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbot implements zzbpq {
    zzbot() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        try {
            String str = (String) map.get(ViewProps.ENABLED);
            zzbpq zzbpqVar = zzbpp.zza;
            if (!zzgss.zze("true", str) && !zzgss.zze("false", str)) {
                return;
            }
            zzgch.zza(zzckuVar.getContext()).zzd(Boolean.parseBoolean(str));
        } catch (IOException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "DefaultGmsgHandlers.SetPaidv2PersonalizationEnabled");
        }
    }
}
