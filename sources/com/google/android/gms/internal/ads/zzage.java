package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzage {
    static {
        int i = zzagd.zza;
    }

    zzafy[] zza();

    default zzafy[] zzb(Uri uri, Map map) {
        return zza();
    }
}
