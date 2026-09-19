package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzimd extends zzimb implements zzaup {
    private int zzg;

    protected zzimd(String str) {
        super("mvhd");
    }

    public final int zzg() {
        if (!this.zzb) {
            zzf();
        }
        return this.zzg;
    }

    protected final long zzh(ByteBuffer byteBuffer) {
        this.zzg = zzauo.zzc(byteBuffer.get());
        zzauo.zzb(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
