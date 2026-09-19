package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzimc extends zzimf implements zzaup {
    protected final String zza = "moov";

    public zzimc(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaup
    public final void zzb(zzimg zzimgVar, ByteBuffer byteBuffer, long j, zzaum zzaumVar) throws IOException {
        zzimgVar.zzc();
        byteBuffer.remaining();
        byteBuffer.remaining();
        this.zzc = zzimgVar;
        this.zze = zzimgVar.zzc();
        zzimgVar.zzd(zzimgVar.zzc() + j);
        this.zzf = zzimgVar.zzc();
        this.zzb = zzaumVar;
    }
}
