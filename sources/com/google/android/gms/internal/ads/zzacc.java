package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzacc extends IOException {
    public zzacc(Throwable th) {
        String strConcat;
        String simpleName = th.getClass().getSimpleName();
        if (th.getMessage() != null) {
            String message = th.getMessage();
            String.valueOf(message);
            strConcat = ": ".concat(String.valueOf(message));
        } else {
            strConcat = "";
        }
        StringBuilder sb = new StringBuilder(String.valueOf(simpleName).length() + 11 + strConcat.length());
        sb.append("Unexpected ");
        sb.append(simpleName);
        sb.append(strConcat);
        super(sb.toString(), th);
    }
}
