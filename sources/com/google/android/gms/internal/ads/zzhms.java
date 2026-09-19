package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhms {
    public static final zziaz zza = zziaz.zza(new byte[0]);

    public static final zziaz zza(int i) {
        return zziaz.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(i).array());
    }

    public static final zziaz zzb(int i) {
        return zziaz.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(i).array());
    }
}
