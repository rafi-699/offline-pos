package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzhko implements zzhkq {
    private final AtomicBoolean zza = new AtomicBoolean(false);

    zzhko(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzhkq
    public final boolean zza() {
        return this.zza.get();
    }
}
