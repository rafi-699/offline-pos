package com.google.android.gms.internal.ads;

import androidx.media3.common.PlaybackException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzig extends zzie {
    public final int zzc;

    public zzig(int i, String str, IOException iOException, Map map, zzht zzhtVar, byte[] bArr) {
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 15);
        sb.append("Response code: ");
        sb.append(i);
        super(sb.toString(), iOException, zzhtVar, PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, 1);
        this.zzc = i;
    }
}
