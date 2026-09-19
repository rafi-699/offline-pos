package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.os.Build;
import android.os.Trace;
import android.view.Surface;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzvb implements zzvh {
    private final Context zza;

    @Deprecated
    public zzvb() {
        this.zza = null;
    }

    public zzvb(Context context, zzgub zzgubVar, zzgub zzgubVar2) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final zzvj zzc(zzvg zzvgVar) throws Throwable {
        Context context;
        if (Build.VERSION.SDK_INT >= 31 || ((context = this.zza) != null && Build.VERSION.SDK_INT >= 28 && context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            int iZzf = zzas.zzf(zzvgVar.zzc.zzp);
            zzeg.zzb("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type ".concat(zzfl.zzS(iZzf)));
            zzut zzutVar = new zzut(iZzf);
            zzutVar.zza(true);
            return zzutVar.zzb(zzvgVar);
        }
        MediaCodec mediaCodec = null;
        try {
            zzvm zzvmVar = zzvgVar.zza;
            String str = zzvmVar.zza;
            Trace.beginSection("createCodec:".concat(str));
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            Trace.endSection();
            try {
                Trace.beginSection("configureCodec");
                Surface surface = zzvgVar.zzd;
                int i = 0;
                if (surface == null && zzvmVar.zzh && Build.VERSION.SDK_INT >= 35) {
                    i = 8;
                }
                mediaCodecCreateByCodecName.configure(zzvgVar.zzb, surface, (MediaCrypto) null, i);
                Trace.endSection();
                Trace.beginSection("startCodec");
                mediaCodecCreateByCodecName.start();
                Trace.endSection();
                return new zzwg(mediaCodecCreateByCodecName, zzvgVar.zzf, null);
            } catch (IOException | RuntimeException e) {
                e = e;
                mediaCodec = mediaCodecCreateByCodecName;
                if (mediaCodec != null) {
                    mediaCodec.release();
                }
                throw e;
            }
        } catch (IOException e2) {
            e = e2;
        } catch (RuntimeException e3) {
            e = e3;
        }
    }
}
