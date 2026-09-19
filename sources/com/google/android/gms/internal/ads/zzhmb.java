package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhmb {
    private HashMap zza = new HashMap();

    public final zzhmc zza() {
        if (this.zza == null) {
            throw new IllegalStateException("cannot call build() twice");
        }
        zzhmc zzhmcVar = new zzhmc(Collections.unmodifiableMap(this.zza), null);
        this.zza = null;
        return zzhmcVar;
    }
}
