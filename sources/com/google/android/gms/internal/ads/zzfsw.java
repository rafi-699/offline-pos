package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.Random;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfsw {
    private final long zza;
    private final long zzb;
    private final Clock zzf;
    private long zzg;
    private long zzd = 5;
    private long zze = 0;
    private final Random zzh = new Random();
    private long zzc = 0;

    public zzfsw(long j, double d, long j2, double d2, Clock clock) {
        this.zza = j;
        this.zzb = j2;
        this.zzf = clock;
        zza();
    }

    public final synchronized void zza() {
        this.zzg = this.zza;
        this.zzc = 0L;
        this.zze = 0L;
    }

    public final synchronized long zzb() {
        long j;
        long j2;
        double d = this.zzg;
        double d2 = 0.2d * d;
        j = (long) (d + d2);
        j2 = (long) (d - d2);
        return j2 + ((long) (this.zzh.nextDouble() * ((j - j2) + 1)));
    }

    public final synchronized void zzc() {
        this.zze = this.zzf.currentTimeMillis() + zzb();
        double d = this.zzg;
        this.zzg = Math.min((long) (d + d), this.zzb);
        this.zzc++;
    }

    public final synchronized boolean zzd() {
        return this.zzf.currentTimeMillis() < this.zze;
    }

    public final synchronized boolean zze() {
        zzbih zzbihVar = zzbiq.zzI;
        if (((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).intValue() < 0) {
            return false;
        }
        return this.zzc > Math.max(this.zzd, (long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbihVar)).intValue()) && this.zzg >= this.zzb;
    }

    public final synchronized void zzf(int i) {
        Preconditions.checkArgument(i > 0);
        this.zzd = i;
    }
}
