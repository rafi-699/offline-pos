package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzvl extends zzit {
    public final int zza;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzvl(Throwable th, zzvm zzvmVar) {
        String str = zzvmVar == null ? null : zzvmVar.zza;
        String.valueOf(str);
        super("Decoder failed: ".concat(String.valueOf(str)), th);
        boolean z = th instanceof MediaCodec.CodecException;
        if (z) {
            ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        this.zza = z ? ((MediaCodec.CodecException) th).getErrorCode() : 0;
    }
}
