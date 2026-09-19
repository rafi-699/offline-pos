package com.google.android.gms.internal.ads;

import androidx.media3.common.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaec {
    private final zzadu zza;
    private final zzadv zzf;
    private long zzk;
    private final zzacu zzl;
    private final zzads zzb = new zzads();
    private final zzfh zzc = new zzfh(10);
    private final zzfh zzd = new zzfh(10);
    private final zzei zze = new zzei(16);
    private long zzg = C.TIME_UNSET;
    private zzbv zzj = zzbv.zza;
    private long zzh = C.TIME_UNSET;
    private long zzi = C.TIME_UNSET;

    public zzaec(zzacu zzacuVar, zzadu zzaduVar, zzadv zzadvVar) {
        this.zzl = zzacuVar;
        this.zza = zzaduVar;
        this.zzf = zzadvVar;
    }

    private static Object zzh(zzfh zzfhVar) {
        zzgtj.zza(zzfhVar.zzc() > 0);
        while (zzfhVar.zzc() > 1) {
            zzfhVar.zzd();
        }
        Object objZzd = zzfhVar.zzd();
        objZzd.getClass();
        return objZzd;
    }

    public final void zza() {
        this.zze.zze();
        this.zzg = C.TIME_UNSET;
        this.zzh = C.TIME_UNSET;
        this.zzi = C.TIME_UNSET;
        zzfh zzfhVar = this.zzd;
        if (zzfhVar.zzc() > 0) {
            this.zzk = ((Long) zzh(zzfhVar)).longValue();
        }
        zzfh zzfhVar2 = this.zzc;
        if (zzfhVar2.zzc() > 0) {
            zzfhVar2.zza(0L, (zzbv) zzh(zzfhVar2));
        }
    }

    public final void zzb(long j, long j2) throws zzjk {
        while (true) {
            zzei zzeiVar = this.zze;
            if (zzeiVar.zzd()) {
                return;
            }
            zzfh zzfhVar = this.zzd;
            long jZzc = zzeiVar.zzc();
            Long l = (Long) zzfhVar.zze(jZzc);
            if (l != null && l.longValue() != this.zzk) {
                this.zzk = l.longValue();
                this.zza.zza(2);
            }
            zzadu zzaduVar = this.zza;
            long j3 = this.zzk;
            zzads zzadsVar = this.zzb;
            int iZzk = zzaduVar.zzk(jZzc, j, j2, j3, false, false, zzadsVar);
            if (iZzk != 5 && iZzk != 4) {
                this.zzf.zza(jZzc, zzadsVar.zza());
            }
            if (iZzk == 0 || iZzk == 1) {
                this.zzh = jZzc;
                long jZzb = zzeiVar.zzb();
                zzbv zzbvVar = (zzbv) this.zzc.zze(jZzb);
                if (zzbvVar != null && !zzbvVar.equals(zzbv.zza) && !zzbvVar.equals(this.zzj)) {
                    this.zzj = zzbvVar;
                    this.zzl.zza(zzbvVar);
                }
                this.zzl.zzb(iZzk == 0 ? System.nanoTime() : zzadsVar.zzb(), jZzb, zzaduVar.zzf());
            } else if (iZzk == 2 || iZzk == 3) {
                this.zzh = jZzc;
                zzeiVar.zzb();
                final zzacu zzacuVar = this.zzl;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzacs
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzacuVar.zza.zzB().zzc();
                    }
                };
                zzacv zzacvVar = zzacuVar.zza;
                zzacvVar.zzC().execute(runnable);
                ((zzaes) zzacvVar.zzz().remove()).zzb();
            } else if (iZzk != 4) {
                return;
            } else {
                this.zzh = jZzc;
            }
        }
    }

    public final void zzc(int i, int i2) {
        long j = this.zzg;
        this.zzc.zza(j == C.TIME_UNSET ? 0L : j + 1, new zzbv(i, i2, 1.0f));
    }

    public final void zzd(int i, long j) {
        if (this.zze.zzd()) {
            this.zza.zza(i);
            this.zzk = j;
        } else {
            zzfh zzfhVar = this.zzd;
            long j2 = this.zzg;
            zzfhVar.zza(j2 == C.TIME_UNSET ? -4611686018427387904L : j2 + 1, Long.valueOf(j));
        }
    }

    public final void zze(long j) {
        this.zze.zza(j);
        this.zzg = j;
        this.zzi = C.TIME_UNSET;
    }

    public final void zzf() {
        long j = this.zzg;
        if (j == C.TIME_UNSET) {
            j = Long.MIN_VALUE;
            this.zzg = Long.MIN_VALUE;
            this.zzh = Long.MIN_VALUE;
        }
        this.zzi = j;
    }

    public final boolean zzg() {
        long j = this.zzi;
        return j != C.TIME_UNSET && this.zzh == j;
    }
}
