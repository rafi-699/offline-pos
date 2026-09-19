package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzama implements zzahb {
    private final long zza;
    private final zzamb[] zzb;
    private final int zzc;

    public zzama(long j, zzamb[] zzambVarArr, int i) {
        this.zza = j;
        this.zzb = zzambVarArr;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0062 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:26:0x0064  */
    /* JADX WARN: Code duplicated, block: B:28:0x0070  */
    /* JADX WARN: Code duplicated, block: B:32:0x0081  */
    /* JADX WARN: Code duplicated, block: B:34:0x0087  */
    /* JADX WARN: Code duplicated, block: B:38:0x0075 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0075 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        int i;
        long jZzh;
        long jZzh2;
        zzaml zzamlVar;
        int iZzb;
        zzamb[] zzambVarArr = this.zzb;
        if (zzambVarArr.length == 0) {
            zzahc zzahcVar = zzahc.zza;
            return new zzagz(zzahcVar, zzahcVar);
        }
        int i2 = this.zzc;
        if (i2 != -1) {
            zzaml zzamlVar2 = zzambVarArr[i2].zzb;
            int iZzl = zzamc.zzl(zzamlVar2, j);
            if (iZzl == -1) {
                zzahc zzahcVar2 = zzahc.zza;
                return new zzagz(zzahcVar2, zzahcVar2);
            }
            long[] jArr = zzamlVar2.zzf;
            j3 = jArr[iZzl];
            long[] jArr2 = zzamlVar2.zzc;
            j2 = jArr2[iZzl];
            if (j3 < j && iZzl < zzamlVar2.zzb - 1 && (iZzb = zzamlVar2.zzb(j)) != -1 && iZzb != iZzl) {
                j4 = jArr[iZzb];
                j5 = jArr2[iZzb];
            }
            jZzh = j2;
            jZzh2 = j5;
            for (i = 0; i < zzambVarArr.length; i++) {
                if (i != i2) {
                    zzamlVar = zzambVarArr[i].zzb;
                    jZzh = zzamc.zzh(zzamlVar, j3, jZzh);
                    if (j4 != C.TIME_UNSET) {
                        jZzh2 = zzamc.zzh(zzamlVar, j4, jZzh2);
                    }
                }
            }
            zzahc zzahcVar3 = new zzahc(j3, jZzh);
            return j4 == C.TIME_UNSET ? new zzagz(zzahcVar3, zzahcVar3) : new zzagz(zzahcVar3, new zzahc(j4, jZzh2));
        }
        j2 = Long.MAX_VALUE;
        j3 = j;
        j4 = C.TIME_UNSET;
        j5 = -1;
        jZzh = j2;
        jZzh2 = j5;
        while (i < zzambVarArr.length) {
            if (i != i2) {
                zzamlVar = zzambVarArr[i].zzb;
                jZzh = zzamc.zzh(zzamlVar, j3, jZzh);
                if (j4 != C.TIME_UNSET) {
                    jZzh2 = zzamc.zzh(zzamlVar, j4, jZzh2);
                }
            }
        }
        zzahc zzahcVar4 = new zzahc(j3, jZzh);
        if (j4 == C.TIME_UNSET) {
        }
    }
}
