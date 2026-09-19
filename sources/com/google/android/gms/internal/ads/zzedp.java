package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAdOptions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzedp {
    private AdRequest zza;
    private NativeAdOptions zzb;
    private VideoOptions zzc;
    private AdSize zzd = AdSize.BANNER;
    private String zze = "";
    private String zzf = "";
    private boolean zzg = false;

    public zzedp() {
        Bundle bundle = new Bundle();
        bundle.putString("request_origin", "inspector_ooct");
        this.zza = new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build();
    }

    public final String zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzf;
    }

    public final AdRequest zzc() {
        return this.zza;
    }

    public final AdSize zzd() {
        return this.zzd;
    }

    public final NativeAdOptions zze() {
        return this.zzb;
    }

    public final VideoOptions zzf() {
        return this.zzc;
    }

    public final boolean zzg() {
        return this.zzg;
    }

    public final void zzh(String str) {
        this.zze = str;
    }

    public final void zzi(String str) {
        this.zzf = str;
    }

    public final void zzj(AdRequest adRequest) {
        this.zza = adRequest;
    }

    public final void zzk(AdSize adSize) {
        this.zzd = adSize;
    }

    public final void zzl(NativeAdOptions nativeAdOptions) {
        this.zzb = nativeAdOptions;
    }

    public final void zzm(VideoOptions videoOptions) {
        this.zzc = videoOptions;
    }

    public final void zzn(boolean z) {
        this.zzg = z;
    }
}
