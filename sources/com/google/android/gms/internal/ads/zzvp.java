package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzvp extends Exception {
    public final String zza;
    public final boolean zzb;
    public final zzvm zzc;
    public final String zzd;

    public zzvp(zzv zzvVar, Throwable th, boolean z, int i) {
        String string = zzvVar.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 25 + string.length());
        sb.append("Decoder init failed: [");
        sb.append(i);
        sb.append("], ");
        sb.append(string);
        String string2 = sb.toString();
        String str = zzvVar.zzp;
        int iAbs = Math.abs(i);
        StringBuilder sb2 = new StringBuilder(String.valueOf(iAbs).length() + 60);
        sb2.append("androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_neg_");
        sb2.append(iAbs);
        this(string2, th, str, false, null, sb2.toString(), null);
    }

    final /* synthetic */ zzvp zza(zzvp zzvpVar) {
        return new zzvp(getMessage(), getCause(), this.zza, false, this.zzc, this.zzd, zzvpVar);
    }

    public zzvp(zzv zzvVar, Throwable th, boolean z, zzvm zzvmVar) {
        String str = zzvmVar.zza;
        int length = str.length();
        String string = zzvVar.toString();
        StringBuilder sb = new StringBuilder(length + 23 + string.length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(string);
        this(sb.toString(), th, zzvVar.zzp, false, zzvmVar, th instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th).getDiagnosticInfo() : null, null);
    }

    private zzvp(String str, Throwable th, String str2, boolean z, zzvm zzvmVar, String str3, zzvp zzvpVar) {
        super(str, th);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzvmVar;
        this.zzd = str3;
    }
}
