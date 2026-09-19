package com.google.android.gms.internal.play_billing;

import java.io.IOException;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes4.dex */
public class zzfq extends IOException {
    public zzfq(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public zzfq(String str) {
        super(str);
    }
}
