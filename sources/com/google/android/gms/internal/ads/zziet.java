package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zziet extends IOException {
    private boolean zza;

    public zziet(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    final void zza() {
        this.zza = true;
    }

    final boolean zzb() {
        return this.zza;
    }

    public zziet(String str) {
        super(str);
    }

    public zziet(String str, IOException iOException) {
        super("Unable to parse map entry.", iOException);
    }
}
