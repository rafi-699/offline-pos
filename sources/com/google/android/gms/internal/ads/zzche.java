package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzche {
    private static final AtomicInteger zza = new AtomicInteger(0);
    private static final AtomicInteger zzb = new AtomicInteger(0);

    public static int zzP() {
        return zza.get();
    }

    public static int zzQ() {
        return zzb.get();
    }

    protected static AtomicInteger zzf() {
        return zza;
    }

    protected static AtomicInteger zzi() {
        return zzb;
    }

    public abstract void zzA(int i);

    public abstract boolean zzB();

    public abstract int zzC();

    public abstract long zzD();

    public abstract void zzE(boolean z);

    public abstract void zzF(int i);

    public abstract void zzG(int i);

    public abstract long zzH();

    public abstract long zzI();

    public abstract long zzJ();

    public abstract long zzK();

    public abstract int zzL();

    public abstract void zzM(boolean z);

    public abstract long zzN();

    public abstract long zzO();

    public abstract Integer zzj();

    public abstract void zzn(Integer num);

    public abstract void zzq(Uri[] uriArr, String str);

    public abstract void zzr(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z);

    public abstract void zzs(zzchd zzchdVar);

    public abstract void zzt();

    public abstract void zzu(Surface surface, boolean z) throws IOException;

    public abstract void zzv(float f, boolean z) throws IOException;

    public abstract void zzw();

    public abstract void zzx(long j);

    public abstract void zzy(int i);

    public abstract void zzz(int i);
}
