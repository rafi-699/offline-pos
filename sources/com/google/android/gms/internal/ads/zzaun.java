package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaun extends zzimf implements Closeable {
    static {
        zzimm.zzb(zzaun.class);
    }

    public zzaun(zzimg zzimgVar, zzaum zzaumVar) throws IOException {
        zzd(zzimgVar, zzimgVar.zzb(), zzaumVar);
    }

    @Override // com.google.android.gms.internal.ads.zzimf, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzimf
    public final String toString() {
        String string = this.zzc.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
