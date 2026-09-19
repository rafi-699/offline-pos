package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaqp {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfi zza = new zzfi(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzet zzb = new zzet();

    zzaqp() {
    }

    public static long zze(zzet zzetVar) {
        int iZzg = zzetVar.zzg();
        if (zzetVar.zzd() < 9) {
            return C.TIME_UNSET;
        }
        byte[] bArr = new byte[9];
        zzetVar.zzm(bArr, 0, 9);
        zzetVar.zzh(iZzg);
        byte b = bArr[0];
        if ((b & 196) != 68) {
            return C.TIME_UNSET;
        }
        byte b2 = bArr[2];
        if ((b2 & 4) != 4) {
            return C.TIME_UNSET;
        }
        byte b3 = bArr[4];
        if ((b3 & 4) != 4 || (bArr[5] & 1) != 1 || (bArr[8] & 3) != 3) {
            return C.TIME_UNSET;
        }
        long j = b;
        long j2 = b2;
        long j3 = (248 & j2) >> 3;
        long j4 = (j2 & 3) << 13;
        return j4 | ((bArr[1] & 255) << 20) | ((j & 3) << 28) | (((j & 56) >> 3) << 30) | (j3 << 15) | ((((long) bArr[3]) & 255) << 5) | ((((long) b3) & 248) >> 3);
    }

    private final int zzf(zzafz zzafzVar) {
        byte[] bArr = zzfl.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
        this.zzc = true;
        zzafzVar.zzl();
        return 0;
    }

    private static final int zzg(byte[] bArr, int i) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final zzfi zzb() {
        return this.zza;
    }

    public final int zzc(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        boolean z = this.zze;
        long j = C.TIME_UNSET;
        if (!z) {
            long jZzo = zzafzVar.zzo();
            int iMin = (int) Math.min(20000L, jZzo);
            long j2 = jZzo - ((long) iMin);
            if (zzafzVar.zzn() != j2) {
                zzagyVar.zza = j2;
                return 1;
            }
            zzet zzetVar = this.zzb;
            zzetVar.zza(iMin);
            zzafzVar.zzl();
            zzafzVar.zzi(zzetVar.zzi(), 0, iMin);
            int iZzg = zzetVar.zzg();
            for (int iZze = zzetVar.zze() - 4; iZze >= iZzg; iZze--) {
                if (zzg(zzetVar.zzi(), iZze) == 442) {
                    zzetVar.zzh(iZze + 4);
                    long jZze = zze(zzetVar);
                    if (jZze != C.TIME_UNSET) {
                        j = jZze;
                        break;
                    }
                }
            }
            this.zzg = j;
            this.zze = true;
            return 0;
        }
        if (this.zzg == C.TIME_UNSET) {
            zzf(zzafzVar);
            return 0;
        }
        if (this.zzd) {
            long j3 = this.zzf;
            if (j3 == C.TIME_UNSET) {
                zzf(zzafzVar);
                return 0;
            }
            zzfi zzfiVar = this.zza;
            this.zzh = zzfiVar.zzf(this.zzg) - zzfiVar.zze(j3);
            zzf(zzafzVar);
            return 0;
        }
        int iMin2 = (int) Math.min(20000L, zzafzVar.zzo());
        if (zzafzVar.zzn() != 0) {
            zzagyVar.zza = 0L;
            return 1;
        }
        zzet zzetVar2 = this.zzb;
        zzetVar2.zza(iMin2);
        zzafzVar.zzl();
        zzafzVar.zzi(zzetVar2.zzi(), 0, iMin2);
        int iZze2 = zzetVar2.zze();
        for (int iZzg2 = zzetVar2.zzg(); iZzg2 < iZze2 - 3; iZzg2++) {
            if (zzg(zzetVar2.zzi(), iZzg2) == 442) {
                zzetVar2.zzh(iZzg2 + 4);
                long jZze2 = zze(zzetVar2);
                if (jZze2 != C.TIME_UNSET) {
                    j = jZze2;
                    break;
                }
            }
        }
        this.zzf = j;
        this.zzd = true;
        return 0;
    }

    public final long zzd() {
        return this.zzh;
    }
}
