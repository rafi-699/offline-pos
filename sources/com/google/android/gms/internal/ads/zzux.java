package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzux implements zzvk {
    private static final ArrayDeque zza = new ArrayDeque();
    private static final Object zzb = new Object();
    private final MediaCodec zzc;
    private final HandlerThread zzd;
    private Handler zze;
    private final AtomicReference zzf;
    private final zzds zzg;
    private boolean zzh;

    public zzux(MediaCodec mediaCodec, HandlerThread handlerThread) {
        zzds zzdsVar = new zzds(zzdo.zza);
        this.zzc = mediaCodec;
        this.zzd = handlerThread;
        this.zzg = zzdsVar;
        this.zzf = new AtomicReference();
    }

    private static zzuw zzi() {
        ArrayDeque arrayDeque = zza;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new zzuw();
            }
            return (zzuw) arrayDeque.removeFirst();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zza() {
        if (this.zzh) {
            return;
        }
        HandlerThread handlerThread = this.zzd;
        handlerThread.start();
        this.zze = new zzuv(this, handlerThread.getLooper());
        this.zzh = true;
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzb(int i, int i2, int i3, long j, int i4) {
        zzg();
        zzuw zzuwVarZzi = zzi();
        zzuwVarZzi.zza(i, 0, i3, j, i4);
        Handler handler = this.zze;
        String str = zzfl.zza;
        handler.obtainMessage(1, zzuwVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzc(int i, int i2, zzis zzisVar, long j, int i3) {
        zzg();
        zzuw zzuwVarZzi = zzi();
        zzuwVarZzi.zza(i, 0, 0, j, i3);
        MediaCodec.CryptoInfo cryptoInfo = zzuwVarZzi.zzd;
        cryptoInfo.numSubSamples = zzisVar.zzf;
        cryptoInfo.numBytesOfClearData = zzj(zzisVar.zzd, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = zzj(zzisVar.zze, cryptoInfo.numBytesOfEncryptedData);
        byte[] bArrZzk = zzk(zzisVar.zzb, cryptoInfo.key);
        bArrZzk.getClass();
        cryptoInfo.key = bArrZzk;
        byte[] bArrZzk2 = zzk(zzisVar.zza, cryptoInfo.iv);
        bArrZzk2.getClass();
        cryptoInfo.iv = bArrZzk2;
        cryptoInfo.mode = zzisVar.zzc;
        cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(zzisVar.zzg, zzisVar.zzh));
        Handler handler = this.zze;
        String str = zzfl.zza;
        handler.obtainMessage(2, zzuwVarZzi).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzd(Bundle bundle) {
        zzg();
        Handler handler = this.zze;
        String str = zzfl.zza;
        handler.obtainMessage(4, bundle).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zze() {
        if (this.zzh) {
            try {
                Handler handler = this.zze;
                if (handler == null) {
                    throw null;
                }
                handler.removeCallbacksAndMessages(null);
                zzds zzdsVar = this.zzg;
                zzdsVar.zzb();
                Handler handler2 = this.zze;
                if (handler2 == null) {
                    throw null;
                }
                handler2.obtainMessage(3).sendToTarget();
                zzdsVar.zzc();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzf() {
        if (this.zzh) {
            zze();
            this.zzd.quit();
        }
        this.zzh = false;
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzg() {
        RuntimeException runtimeException = (RuntimeException) this.zzf.getAndSet(null);
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0079  */
    /* JADX WARN: Code duplicated, block: B:43:0x0084 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final /* synthetic */ void zzh(Message message) {
        zzuw zzuwVar;
        ArrayDeque arrayDeque;
        int i = message.what;
        zzuw zzuwVar2 = null;
        if (i != 1) {
            if (i == 2) {
                zzuwVar = (zzuw) message.obj;
                int i2 = zzuwVar.zza;
                int i3 = zzuwVar.zzb;
                MediaCodec.CryptoInfo cryptoInfo = zzuwVar.zzd;
                long j = zzuwVar.zze;
                int i4 = zzuwVar.zzf;
                try {
                    synchronized (zzb) {
                        try {
                            this.zzc.queueSecureInputBuffer(i2, 0, cryptoInfo, j, i4);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                } catch (RuntimeException e) {
                    LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.zzf, null, e);
                }
            } else if (i == 3) {
                this.zzg.zza();
            } else if (i != 4) {
                LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.zzf, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                try {
                    this.zzc.setParameters((Bundle) message.obj);
                } catch (RuntimeException e2) {
                    LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.zzf, null, e2);
                }
            }
            if (zzuwVar2 != null) {
                arrayDeque = zza;
                synchronized (arrayDeque) {
                    arrayDeque.add(zzuwVar2);
                }
            }
        }
        zzuwVar = (zzuw) message.obj;
        int i5 = zzuwVar.zza;
        int i6 = zzuwVar.zzb;
        try {
            this.zzc.queueInputBuffer(i5, 0, zzuwVar.zzc, zzuwVar.zze, zzuwVar.zzf);
        } catch (RuntimeException e3) {
            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.zzf, null, e3);
        }
        zzuwVar2 = zzuwVar;
        if (zzuwVar2 != null) {
            arrayDeque = zza;
            synchronized (arrayDeque) {
                arrayDeque.add(zzuwVar2);
            }
        }
    }

    private static int[] zzj(int[] iArr, int[] iArr2) {
        int length;
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < (length = iArr.length)) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, length);
        return iArr2;
    }

    private static byte[] zzk(byte[] bArr, byte[] bArr2) {
        int length;
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < (length = bArr.length)) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
