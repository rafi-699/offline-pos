package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.extractor.ts.TsExtractor;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaqz {
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private final zzfi zza = new zzfi(0);
    private long zzf = C.TIME_UNSET;
    private long zzg = C.TIME_UNSET;
    private long zzh = C.TIME_UNSET;
    private final zzet zzb = new zzet();

    zzaqz(int i) {
    }

    private final int zze(zzafz zzafzVar) {
        byte[] bArr = zzfl.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
        this.zzc = true;
        zzafzVar.zzl();
        return 0;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final int zzb(zzafz zzafzVar, zzagy zzagyVar, int i) throws IOException {
        if (i <= 0) {
            zze(zzafzVar);
            return 0;
        }
        boolean z = this.zze;
        long j = C.TIME_UNSET;
        if (z) {
            if (this.zzg == C.TIME_UNSET) {
                zze(zzafzVar);
                return 0;
            }
            if (this.zzd) {
                long j2 = this.zzf;
                if (j2 == C.TIME_UNSET) {
                    zze(zzafzVar);
                    return 0;
                }
                zzfi zzfiVar = this.zza;
                this.zzh = zzfiVar.zzf(this.zzg) - zzfiVar.zze(j2);
                zze(zzafzVar);
                return 0;
            }
            int iMin = (int) Math.min(112800L, zzafzVar.zzo());
            if (zzafzVar.zzn() != 0) {
                zzagyVar.zza = 0L;
                return 1;
            }
            zzet zzetVar = this.zzb;
            zzetVar.zza(iMin);
            zzafzVar.zzl();
            zzafzVar.zzi(zzetVar.zzi(), 0, iMin);
            int iZze = zzetVar.zze();
            for (int iZzg = zzetVar.zzg(); iZzg < iZze; iZzg++) {
                if (zzetVar.zzi()[iZzg] == 71) {
                    long jZzb = zzarj.zzb(zzetVar, iZzg, i);
                    if (jZzb != C.TIME_UNSET) {
                        j = jZzb;
                        break;
                    }
                }
            }
            this.zzf = j;
            this.zzd = true;
            return 0;
        }
        long jZzo = zzafzVar.zzo();
        int iMin2 = (int) Math.min(112800L, jZzo);
        long j3 = jZzo - ((long) iMin2);
        if (zzafzVar.zzn() != j3) {
            zzagyVar.zza = j3;
            return 1;
        }
        zzet zzetVar2 = this.zzb;
        zzetVar2.zza(iMin2);
        zzafzVar.zzl();
        zzafzVar.zzi(zzetVar2.zzi(), 0, iMin2);
        int iZzg2 = zzetVar2.zzg();
        int iZze2 = zzetVar2.zze();
        for (int i2 = iZze2 - 188; i2 >= iZzg2; i2--) {
            byte[] bArrZzi = zzetVar2.zzi();
            int i3 = 0;
            for (int i4 = -4; i4 <= 4; i4++) {
                int i5 = (i4 * TsExtractor.TS_PACKET_SIZE) + i2;
                if (i5 >= iZzg2 && i5 < iZze2 && bArrZzi[i5] == 71) {
                    i3++;
                    if (i3 == 5) {
                        long jZzb2 = zzarj.zzb(zzetVar2, i2, i);
                        if (jZzb2 == C.TIME_UNSET) {
                            break;
                        }
                        j = jZzb2;
                        break;
                    }
                } else {
                    i3 = 0;
                }
            }
        }
        this.zzg = j;
        this.zze = true;
        return 0;
    }

    public final long zzc() {
        return this.zzh;
    }

    public final zzfi zzd() {
        return this.zza;
    }
}
