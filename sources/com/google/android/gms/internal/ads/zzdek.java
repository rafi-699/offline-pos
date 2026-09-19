package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzdek implements zzdio {
    static final /* synthetic */ zzdek zza = new zzdek();

    private /* synthetic */ zzdek() {
    }

    @Override // com.google.android.gms.internal.ads.zzdio
    public final /* synthetic */ void zza(Object obj) {
        ((OnAdMetadataChangedListener) obj).onAdMetadataChanged();
    }
}
