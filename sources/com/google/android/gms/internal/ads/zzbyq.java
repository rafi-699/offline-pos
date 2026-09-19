package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nativead.NativeAd;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbyq extends zzbno {
    private final NativeAd.OnNativeAdLoadedListener zza;

    public zzbyq(NativeAd.OnNativeAdLoadedListener onNativeAdLoadedListener) {
        this.zza = onNativeAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzbnp
    public final void zze(zzbnv zzbnvVar) {
        this.zza.onNativeAdLoaded(new zzbyl(zzbnvVar));
    }
}
