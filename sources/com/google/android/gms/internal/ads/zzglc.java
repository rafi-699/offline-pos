package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzglc extends RuntimeException {
    public zzglc() {
        this(0);
    }

    public zzglc(int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 3);
        sb.append("r: ");
        sb.append(i);
        super(sb.toString());
    }

    public zzglc(int i, Throwable th) {
        super("r: 2", th);
    }
}
