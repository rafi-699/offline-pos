package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdsq implements zzhbt {
    final /* synthetic */ zzcfw zza;

    zzdsq(zzdtc zzdtcVar, zzcfw zzcfwVar) {
        this.zza = zzcfwVar;
        Objects.requireNonNull(zzdtcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to load media data due to video view load failure.");
        this.zza.zzd(th);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcku zzckuVar = (zzcku) obj;
        if (zzckuVar == null) {
            this.zza.zzd(new zzeph(1, "Missing webview from video view future."));
            return;
        }
        final zzcfw zzcfwVar = this.zza;
        zzckuVar.zzab("/video", new zzcim(new zzcil() { // from class: com.google.android.gms.internal.ads.zzdsp
            @Override // com.google.android.gms.internal.ads.zzcil
            public final /* synthetic */ void zza(String str) {
                Bundle bundle = new Bundle();
                bundle.putString("mediaUrl", str);
                zzcfwVar.zzc(bundle);
            }
        }));
        zzckuVar.zzI();
    }
}
