package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzhp extends zzj {
    long zzb(zzht zzhtVar) throws IOException;

    Uri zzc();

    void zzd() throws IOException;

    void zze(zzin zzinVar);

    default Map zzj() {
        return Collections.emptyMap();
    }
}
