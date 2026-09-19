package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzafk {
    protected final zzafe zza;
    protected final zzafj zzb;
    protected zzafg zzc;
    private final int zzd;

    protected zzafk(zzafh zzafhVar, zzafj zzafjVar, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.zzb = zzafjVar;
        this.zzd = i;
        this.zza = new zzafe(zzafhVar, j, 0L, j3, j4, j5, j6);
    }

    protected static final int zzf(zzafz zzafzVar, long j, zzagy zzagyVar) {
        if (j == zzafzVar.zzn()) {
            return 0;
        }
        zzagyVar.zza = j;
        return 1;
    }

    protected static final boolean zzg(zzafz zzafzVar, long j) throws IOException {
        long jZzn = j - zzafzVar.zzn();
        if (jZzn < 0 || jZzn > 262144) {
            return false;
        }
        zzafzVar.zzf((int) jZzn);
        return true;
    }

    public final zzahb zza() {
        return this.zza;
    }

    public final void zzb(long j) {
        zzafg zzafgVar = this.zzc;
        if (zzafgVar == null || zzafgVar.zze() != j) {
            zzafe zzafeVar = this.zza;
            this.zzc = new zzafg(j, zzafeVar.zzd(j), 0L, zzafeVar.zze(), zzafeVar.zzf(), zzafeVar.zzg(), zzafeVar.zzh());
        }
    }

    public final boolean zzc() {
        return this.zzc != null;
    }

    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        while (true) {
            zzafg zzafgVar = this.zzc;
            zzafgVar.getClass();
            long jZzb = zzafgVar.zzb();
            long jZzc = zzafgVar.zzc();
            long jZzh = zzafgVar.zzh();
            if (jZzc - jZzb <= this.zzd) {
                zze(false, jZzb);
                return zzf(zzafzVar, jZzb, zzagyVar);
            }
            if (!zzg(zzafzVar, jZzh)) {
                return zzf(zzafzVar, jZzh, zzagyVar);
            }
            zzafzVar.zzl();
            zzafi zzafiVarZza = this.zzb.zza(zzafzVar, zzafgVar.zzd());
            int iZzd = zzafiVarZza.zzd();
            if (iZzd == -3) {
                zze(false, jZzh);
                return zzf(zzafzVar, jZzh, zzagyVar);
            }
            if (iZzd == -2) {
                zzafgVar.zzf(zzafiVarZza.zze(), zzafiVarZza.zzf());
            } else {
                if (iZzd != -1) {
                    zzg(zzafzVar, zzafiVarZza.zzf());
                    zze(true, zzafiVarZza.zzf());
                    return zzf(zzafzVar, zzafiVarZza.zzf(), zzagyVar);
                }
                zzafgVar.zzg(zzafiVarZza.zze(), zzafiVarZza.zzf());
            }
        }
    }

    protected final void zze(boolean z, long j) {
        this.zzc = null;
        this.zzb.zzb();
    }
}
