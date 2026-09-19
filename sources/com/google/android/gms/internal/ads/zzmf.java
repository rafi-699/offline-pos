package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.exoplayer.MediaPeriodQueue;
import androidx.media3.exoplayer.dash.DashMediaSource;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmf {
    private final zznm zzc;
    private final zzdz zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzju zzh;
    private zzmc zzi;
    private zzmc zzj;
    private zzmc zzk;
    private zzmc zzl;
    private zzmc zzm;
    private int zzn;
    private Object zzo;
    private long zzp;
    private final zzln zzr;
    private final zzbd zza = new zzbd();
    private final zzbe zzb = new zzbe();
    private List zzq = new ArrayList();

    public zzmf(zznm zznmVar, zzdz zzdzVar, zzln zzlnVar, zzju zzjuVar) {
        this.zzc = zznmVar;
        this.zzd = zzdzVar;
        this.zzr = zzlnVar;
        this.zzh = zzjuVar;
    }

    private static zzxk zzA(zzbf zzbfVar, Object obj, long j, long j2, zzbe zzbeVar, zzbd zzbdVar) {
        zzbfVar.zzo(obj, zzbdVar);
        zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L);
        zzbfVar.zze(obj);
        zzbdVar.zzb();
        zzbfVar.zzo(obj, zzbdVar);
        int iZze = zzbdVar.zze(j);
        return iZze == -1 ? new zzxk(obj, j2, zzbdVar.zzf(j)) : new zzxk(obj, iZze, zzbdVar.zzd(iZze), j2);
    }

    private final void zzB() {
        int i = zzgwm.zzd;
        final zzgwj zzgwjVar = new zzgwj();
        for (zzmc zzmcVarZzp = this.zzi; zzmcVarZzp != null; zzmcVarZzp = zzmcVarZzp.zzp()) {
            zzgwjVar.zzf(zzmcVarZzp.zzg.zza);
        }
        zzmc zzmcVar = this.zzj;
        final zzxk zzxkVar = zzmcVar == null ? null : zzmcVar.zzg.zza;
        this.zzd.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzme
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzz(zzgwjVar, zzxkVar);
            }
        });
    }

    private final long zzC(Object obj) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzmc zzmcVar = (zzmc) this.zzq.get(i);
            if (zzmcVar.zzb.equals(obj)) {
                return zzmcVar.zzg.zza.zzd;
            }
        }
        return -1L;
    }

    private final int zzD(zzbf zzbfVar) {
        zzbf zzbfVar2;
        zzmc zzmcVarZzp = this.zzi;
        if (zzmcVarZzp == null) {
            return 0;
        }
        int iZze = zzbfVar.zze(zzmcVarZzp.zzb);
        while (true) {
            zzbfVar2 = zzbfVar;
            iZze = zzbfVar2.zzl(iZze, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzmcVarZzp.getClass();
                if (zzmcVarZzp.zzp() == null || zzmcVarZzp.zzg.zzi) {
                    break;
                }
                zzmcVarZzp = zzmcVarZzp.zzp();
            }
            zzmc zzmcVarZzp2 = zzmcVarZzp.zzp();
            if (iZze == -1 || zzmcVarZzp2 == null || zzbfVar2.zze(zzmcVarZzp2.zzb) != iZze) {
                break;
            }
            zzmcVarZzp = zzmcVarZzp2;
            zzbfVar = zzbfVar2;
        }
        int iZzs = zzs(zzmcVarZzp);
        zzmcVarZzp.zzg = zzx(zzbfVar2, zzmcVarZzp.zzg);
        return iZzs;
    }

    private final zzmd zzE(zzbf zzbfVar, zzmc zzmcVar, long j) {
        zzbf zzbfVar2;
        long j2;
        long j3;
        zzbe zzbeVar;
        long j4;
        long j5;
        Object obj;
        long j6;
        long j7;
        zzmd zzmdVar = zzmcVar.zzg;
        long jZza = zzmcVar.zza();
        long j8 = zzmdVar.zzf;
        long j9 = (jZza + j8) - j;
        long j10 = 0;
        if (!zzmdVar.zzi) {
            zzxk zzxkVar = zzmdVar.zza;
            Object obj2 = zzxkVar.zza;
            zzbd zzbdVar = this.zza;
            zzbfVar.zzo(obj2, zzbdVar);
            boolean z = zzmdVar.zzh;
            if (!zzxkVar.zzb()) {
                int i = zzxkVar.zze;
                if (i != -1) {
                    zzbdVar.zzi(i);
                }
                int iZzd = zzbdVar.zzd(i);
                zzbdVar.zzk(i);
                if (iZzd != zzbdVar.zzg(i)) {
                    return zzG(zzbfVar, obj2, i, iZzd, j8, zzxkVar.zzd, false);
                }
                zzK(zzbfVar, obj2, i);
                return zzH(zzbfVar, obj2, 0L, C.TIME_UNSET, j8, zzxkVar.zzd, false);
            }
            int i2 = zzxkVar.zzb;
            if (zzbdVar.zzg(i2) == -1) {
                return null;
            }
            int iZza = zzbdVar.zzg.zza(i2).zza(zzxkVar.zzc);
            if (iZza < 0) {
                return zzG(zzbfVar, obj2, i2, iZza, zzmdVar.zzd, zzxkVar.zzd, false);
            }
            long jLongValue = zzmdVar.zzd;
            if (jLongValue == C.TIME_UNSET) {
                zzbe zzbeVar2 = this.zzb;
                long jMax = zzL(zzbfVar, zzbdVar.zzc, zzbdVar.zzd, zzbeVar2) ? Math.max(0L, j9) : -9223372036854775807L;
                zzbfVar2 = zzbfVar;
                Pair pairZzn = zzbfVar2.zzn(zzbeVar2, zzbdVar, zzbdVar.zzc, C.TIME_UNSET, jMax);
                if (pairZzn == null) {
                    return null;
                }
                jLongValue = ((Long) pairZzn.second).longValue();
                j3 = jMax;
                j2 = -9223372036854775807L;
            } else {
                zzbfVar2 = zzbfVar;
                j2 = jLongValue;
                j3 = -9223372036854775807L;
            }
            zzK(zzbfVar2, obj2, i2);
            return zzH(zzbfVar2, obj2, Math.max(0L, jLongValue), j3, j2, zzxkVar.zzd, false);
        }
        zzxk zzxkVar2 = zzmdVar.zza;
        Object obj3 = zzxkVar2.zza;
        int iZze = zzbfVar.zze(obj3);
        int i3 = this.zzf;
        boolean z2 = this.zzg;
        zzbe zzbeVar3 = this.zzb;
        zzbd zzbdVar2 = this.zza;
        int iZzl = zzbfVar.zzl(iZze, zzbdVar2, zzbeVar3, i3, z2);
        if (iZzl == -1) {
            return null;
        }
        int i4 = zzbfVar.zzd(iZzl, zzbdVar2, true).zzc;
        Object obj4 = zzbdVar2.zzb;
        obj4.getClass();
        long j11 = zzxkVar2.zzd;
        if (zzbfVar.zzb(i4, zzbeVar3, 0L).zzn == iZzl) {
            long jMax2 = zzL(zzbfVar, zzbdVar2.zzc, zzbdVar2.zzd, zzbeVar3) ? Math.max(0L, j9) : -9223372036854775807L;
            Pair pairZzn2 = zzbfVar.zzn(zzbeVar3, zzbdVar2, i4, C.TIME_UNSET, jMax2);
            if (pairZzn2 == null) {
                return null;
            }
            Object obj5 = pairZzn2.first;
            long jLongValue2 = ((Long) pairZzn2.second).longValue();
            zzmc zzmcVarZzp = zzmcVar.zzp();
            if (zzmcVarZzp == null || !zzmcVarZzp.zzb.equals(obj5)) {
                long jZzC = zzC(obj5);
                if (jZzC == -1) {
                    jZzC = this.zze;
                    this.zze = 1 + jZzC;
                }
                j7 = jZzC;
            } else {
                j7 = zzmcVarZzp.zzg.zza.zzd;
            }
            long j12 = jMax2;
            zzbeVar = zzbeVar3;
            obj = obj5;
            j4 = j7;
            j6 = j12;
            j5 = jLongValue2;
            j10 = -9223372036854775807L;
        } else {
            zzbeVar = zzbeVar3;
            j4 = j11;
            j5 = 0;
            obj = obj4;
            j6 = -9223372036854775807L;
        }
        zzxk zzxkVarZzA = zzA(zzbfVar, obj, j5, j4, zzbeVar, zzbdVar2);
        long j13 = j5;
        if (j10 != C.TIME_UNSET && zzmdVar.zzd != C.TIME_UNSET) {
            zzbfVar.zzo(obj3, zzbdVar2).zzb();
            int i5 = zzbdVar2.zzg.zzd;
        }
        return zzF(zzbfVar, zzxkVarZzA, j10, j13, j6);
    }

    private final zzmd zzF(zzbf zzbfVar, zzxk zzxkVar, long j, long j2, long j3) {
        Object obj = zzxkVar.zza;
        zzbfVar.zzo(obj, this.zza);
        return zzxkVar.zzb() ? zzG(zzbfVar, obj, zzxkVar.zzb, zzxkVar.zzc, j, zzxkVar.zzd, false) : zzH(zzbfVar, obj, j2, j3, j, zzxkVar.zzd, false);
    }

    private final zzmd zzG(zzbf zzbfVar, Object obj, int i, int i2, long j, long j2, boolean z) {
        zzxk zzxkVar = new zzxk(obj, i, i2, j2);
        Object obj2 = zzxkVar.zza;
        int i3 = zzxkVar.zzb;
        int i4 = zzxkVar.zzc;
        zzbd zzbdVar = this.zza;
        long jZzh = zzbfVar.zzo(obj2, zzbdVar).zzh(i3, i4);
        if (i2 == zzbdVar.zzd(i)) {
            zzbdVar.zzj();
        }
        zzbdVar.zzk(i3);
        long jMax = 0;
        if (jZzh != C.TIME_UNSET && jZzh <= 0) {
            jMax = Math.max(0L, (-1) + jZzh);
        }
        return new zzmd(zzxkVar, jMax, C.TIME_UNSET, j, C.TIME_UNSET, jZzh, false, false, false, false, false);
    }

    private final zzmd zzH(zzbf zzbfVar, Object obj, long j, long j2, long j3, long j4, boolean z) {
        long j5;
        long j6;
        long j7;
        long jMax = j;
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        int iZzf = zzbdVar.zzf(jMax);
        if (iZzf == -1) {
            zzbdVar.zzb();
        } else {
            zzbdVar.zzk(iZzf);
        }
        zzxk zzxkVar = new zzxk(obj, j4, iZzf);
        boolean zZzM = zzM(zzxkVar);
        boolean zZzI = zzI(zzbfVar, zzxkVar);
        boolean zZzJ = zzJ(zzbfVar, zzxkVar, zZzM);
        if (iZzf != -1) {
            zzbdVar.zzk(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzi(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzc(iZzf);
            j5 = 0;
        } else {
            j5 = -9223372036854775807L;
        }
        if (j5 != C.TIME_UNSET) {
            j7 = j5;
            j6 = j7;
        } else {
            j6 = zzbdVar.zzd;
            j7 = -9223372036854775807L;
        }
        if (j6 != C.TIME_UNSET && jMax >= j6) {
            jMax = Math.max(0L, j6 - 1);
        }
        return new zzmd(zzxkVar, jMax, j2, j3, j7, j6, false, false, zZzM, zZzI, zZzJ);
    }

    private final boolean zzI(zzbf zzbfVar, zzxk zzxkVar) {
        if (!zzM(zzxkVar)) {
            return false;
        }
        Object obj = zzxkVar.zza;
        return zzbfVar.zzb(zzbfVar.zzo(obj, this.zza).zzc, this.zzb, 0L).zzo == zzbfVar.zze(obj);
    }

    private final boolean zzJ(zzbf zzbfVar, zzxk zzxkVar, boolean z) {
        int iZze = zzbfVar.zze(zzxkVar.zza);
        zzbd zzbdVar = this.zza;
        int i = zzbfVar.zzd(iZze, zzbdVar, false).zzc;
        zzbe zzbeVar = this.zzb;
        return !zzbfVar.zzb(i, zzbeVar, 0L).zzi && zzbfVar.zzl(iZze, zzbdVar, zzbeVar, this.zzf, this.zzg) == -1 && z;
    }

    private final long zzK(zzbf zzbfVar, Object obj, int i) {
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        zzbdVar.zzc(i);
        long j = zzbdVar.zzg.zza(i).zzi;
        return 0L;
    }

    private static boolean zzL(zzbf zzbfVar, int i, long j, zzbe zzbeVar) {
        if (j == C.TIME_UNSET) {
            zzbfVar.zzb(i, zzbeVar, 0L);
            if (zzbeVar.zzi && !zzbeVar.zzk) {
                return true;
            }
        }
        return false;
    }

    private static final boolean zzM(zzxk zzxkVar) {
        return !zzxkVar.zzb() && zzxkVar.zze == -1;
    }

    public final int zza(zzbf zzbfVar, int i) {
        this.zzf = i;
        return zzD(zzbfVar);
    }

    public final int zzb(zzbf zzbfVar, boolean z) {
        this.zzg = z;
        return zzD(zzbfVar);
    }

    public final void zzc(zzbf zzbfVar, zzju zzjuVar) {
        this.zzh = zzjuVar;
        long j = zzjuVar.zzb;
        zzj();
    }

    public final boolean zzd(zzxi zzxiVar) {
        zzmc zzmcVar = this.zzl;
        return zzmcVar != null && zzmcVar.zza == zzxiVar;
    }

    public final boolean zze(zzxi zzxiVar) {
        zzmc zzmcVar = this.zzm;
        return zzmcVar != null && zzmcVar.zza == zzxiVar;
    }

    public final void zzf(long j) {
        zzmc zzmcVar = this.zzl;
        if (zzmcVar != null) {
            zzmcVar.zzi(j);
        }
    }

    public final boolean zzg() {
        zzmc zzmcVar = this.zzl;
        if (zzmcVar != null) {
            return !zzmcVar.zzg.zzk && zzmcVar.zzd() && this.zzl.zzg.zzf != C.TIME_UNSET && this.zzn < 100;
        }
        return true;
    }

    public final zzmd zzh(long j, zzms zzmsVar) {
        zzmc zzmcVar = this.zzl;
        return zzmcVar == null ? zzF(zzmsVar.zza, zzmsVar.zzb, zzmsVar.zzc, zzmsVar.zzs, C.TIME_UNSET) : zzE(zzmsVar.zza, zzmcVar, j);
    }

    public final void zzj() {
        if (this.zzq.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.zzq.size(); i++) {
            ((zzmc) this.zzq.get(i)).zzn();
        }
        this.zzq = arrayList;
        this.zzm = null;
        zzt();
    }

    public final zzmc zzk() {
        return this.zzl;
    }

    public final zzmc zzl() {
        return this.zzm;
    }

    public final zzmc zzm() {
        return this.zzi;
    }

    public final zzmc zzn() {
        return this.zzj;
    }

    public final zzmc zzo() {
        return this.zzk;
    }

    public final zzmc zzp() {
        zzmc zzmcVar = this.zzk;
        zzmc zzmcVar2 = this.zzj;
        if (zzmcVar == zzmcVar2) {
            zzmcVar2.getClass();
            this.zzk = zzmcVar2.zzp();
        }
        zzmcVar2.getClass();
        this.zzj = zzmcVar2.zzp();
        zzB();
        zzmc zzmcVar3 = this.zzj;
        zzmcVar3.getClass();
        return zzmcVar3;
    }

    public final zzmc zzq() {
        zzmc zzmcVar = this.zzk;
        zzmcVar.getClass();
        this.zzk = zzmcVar.zzp();
        zzB();
        zzmc zzmcVar2 = this.zzk;
        zzmcVar2.getClass();
        return zzmcVar2;
    }

    public final zzmc zzr() {
        zzmc zzmcVar = this.zzi;
        if (zzmcVar == null) {
            return null;
        }
        if (zzmcVar == this.zzj) {
            this.zzj = zzmcVar.zzp();
        }
        if (zzmcVar == this.zzk) {
            this.zzk = zzmcVar.zzp();
        }
        zzmcVar.zzn();
        int i = this.zzn - 1;
        this.zzn = i;
        if (i == 0) {
            this.zzl = null;
            zzmc zzmcVar2 = this.zzi;
            this.zzo = zzmcVar2.zzb;
            this.zzp = zzmcVar2.zzg.zza.zzd;
        }
        this.zzi = this.zzi.zzp();
        zzB();
        return this.zzi;
    }

    public final void zzt() {
        zzmc zzmcVar = this.zzm;
        if (zzmcVar == null || zzmcVar.zze()) {
            this.zzm = null;
            for (int i = 0; i < this.zzq.size(); i++) {
                zzmc zzmcVar2 = (zzmc) this.zzq.get(i);
                if (!zzmcVar2.zze()) {
                    this.zzm = zzmcVar2;
                    return;
                }
            }
        }
    }

    public final zzmc zzu(zzxi zzxiVar) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzmc zzmcVar = (zzmc) this.zzq.get(i);
            if (zzmcVar.zza == zzxiVar) {
                return zzmcVar;
            }
        }
        return null;
    }

    public final void zzv() {
        if (this.zzn == 0) {
            return;
        }
        zzmc zzmcVarZzp = this.zzi;
        zzmcVarZzp.getClass();
        this.zzo = zzmcVarZzp.zzb;
        this.zzp = zzmcVarZzp.zzg.zza.zzd;
        while (zzmcVarZzp != null) {
            zzmcVarZzp.zzn();
            zzmcVarZzp = zzmcVarZzp.zzp();
        }
        this.zzi = null;
        this.zzl = null;
        this.zzj = null;
        this.zzk = null;
        this.zzn = 0;
        zzB();
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ac  */
    public final int zzw(zzbf zzbfVar, long j, long j2, long j3) {
        zzmd zzmdVarZzE;
        long j4;
        int i;
        zzmd zzmdVar;
        int i2;
        zzmc zzmcVarZzp = this.zzi;
        zzmc zzmcVar = null;
        while (zzmcVarZzp != null) {
            zzmd zzmdVar2 = zzmcVarZzp.zzg;
            if (zzmcVar != null) {
                zzmdVarZzE = zzE(zzbfVar, zzmcVar, j);
                if (zzmdVarZzE != null && zzmdVar2.zza.equals(zzmdVarZzE.zza)) {
                    long j5 = zzmdVar2.zzb;
                    long j6 = zzmdVarZzE.zzb;
                    if (j5 == j6) {
                        j4 = C.TIME_UNSET;
                        i = 0;
                    } else {
                        j4 = C.TIME_UNSET;
                        long j7 = zzmdVar2.zzc;
                        if (j7 != C.TIME_UNSET) {
                            i = 0;
                            long j8 = zzmdVarZzE.zzc;
                            if (j8 != C.TIME_UNSET) {
                                if (Math.abs((j6 - j8) - (j5 - j7)) >= DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                                }
                            }
                        }
                    }
                    if (j5 != j6) {
                        zzmdVar = zzmdVar2;
                        zzmdVarZzE = zzmdVarZzE.zza(j5, zzmdVar.zzc);
                    } else {
                        zzmdVar = zzmdVar2;
                    }
                }
                return zzs(zzmcVar);
            }
            zzmdVarZzE = zzx(zzbfVar, zzmdVar2);
            zzmdVar = zzmdVar2;
            j4 = C.TIME_UNSET;
            i = 0;
            zzmcVarZzp.zzg = zzmdVarZzE.zzb(zzmdVar.zzd);
            long j9 = zzmdVar.zzf;
            long j10 = zzmdVarZzE.zzf;
            if (j9 != j10) {
                zzmcVarZzp.zzs();
                long jZza = j10 == j4 ? Long.MAX_VALUE : j10 + zzmcVarZzp.zza();
                if (zzmcVarZzp == this.zzj) {
                    boolean z = zzmcVarZzp.zzg.zzh;
                    if (j2 == Long.MIN_VALUE || j2 >= jZza) {
                        i2 = 1;
                    } else {
                        i2 = i;
                    }
                } else {
                    i2 = i;
                }
                int i3 = (zzmcVarZzp != this.zzk || (j3 != Long.MIN_VALUE && j3 < jZza)) ? i : 1;
                int iZzs = zzs(zzmcVarZzp);
                if (iZzs != 0) {
                    return iZzs;
                }
                if (j9 == j4) {
                    long j11 = zzmdVar.zze;
                    j9 = j4;
                }
                int i4 = (i2 == 0 || j9 == j4) ? i : 1;
                return i3 != 0 ? i4 | 2 : i4;
            }
            zzmcVar = zzmcVarZzp;
            zzmcVarZzp = zzmcVarZzp.zzp();
        }
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0055  */
    /* JADX WARN: Code duplicated, block: B:20:0x005b  */
    /* JADX WARN: Code duplicated, block: B:22:0x005f  */
    public final zzmd zzx(zzbf zzbfVar, zzmd zzmdVar) {
        long j;
        long jZzh;
        long j2;
        long j3;
        int i;
        int i2;
        zzxk zzxkVar = zzmdVar.zza;
        boolean zZzM = zzM(zzxkVar);
        boolean zZzI = zzI(zzbfVar, zzxkVar);
        boolean zZzJ = zzJ(zzbfVar, zzxkVar, zZzM);
        Object obj = zzxkVar.zza;
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        if (zzxkVar.zzb() || (i2 = zzxkVar.zze) == -1) {
            j = -9223372036854775807L;
        } else {
            zzbdVar.zzc(i2);
            j = 0;
        }
        if (!zzxkVar.zzb()) {
            if (j != C.TIME_UNSET) {
                j2 = 0;
                j3 = 0;
            } else {
                jZzh = zzbdVar.zzd;
            }
            if (zzxkVar.zzb()) {
                zzbdVar.zzk(zzxkVar.zzb);
            } else {
                i = zzxkVar.zze;
                if (i != -1) {
                    zzbdVar.zzk(i);
                }
            }
            long j4 = zzmdVar.zzb;
            long j5 = zzmdVar.zzc;
            long j6 = zzmdVar.zzd;
            boolean z = zzmdVar.zzg;
            return new zzmd(zzxkVar, j4, j5, j6, j2, j3, false, false, zZzM, zZzI, zZzJ);
        }
        jZzh = zzbdVar.zzh(zzxkVar.zzb, zzxkVar.zzc);
        j2 = j;
        j3 = jZzh;
        if (zzxkVar.zzb()) {
            zzbdVar.zzk(zzxkVar.zzb);
        } else {
            i = zzxkVar.zze;
            if (i != -1) {
                zzbdVar.zzk(i);
            }
        }
        long j7 = zzmdVar.zzb;
        long j8 = zzmdVar.zzc;
        long j9 = zzmdVar.zzd;
        boolean z2 = zzmdVar.zzg;
        return new zzmd(zzxkVar, j7, j8, j9, j2, j3, false, false, zZzM, zZzI, zZzJ);
    }

    public final zzxk zzy(zzbf zzbfVar, Object obj, long j) {
        long jZzC;
        int iZze;
        zzbd zzbdVar = this.zza;
        int i = zzbfVar.zzo(obj, zzbdVar).zzc;
        Object obj2 = this.zzo;
        if (obj2 == null || (iZze = zzbfVar.zze(obj2)) == -1 || zzbfVar.zzd(iZze, zzbdVar, false).zzc != i) {
            zzmc zzmcVarZzp = this.zzi;
            while (true) {
                if (zzmcVarZzp == null) {
                    zzmc zzmcVarZzp2 = this.zzi;
                    while (true) {
                        if (zzmcVarZzp2 == null) {
                            jZzC = zzC(obj);
                            if (jZzC != -1) {
                                break;
                            }
                            jZzC = this.zze;
                            this.zze = 1 + jZzC;
                            if (this.zzi != null) {
                                break;
                            }
                            this.zzo = obj;
                            this.zzp = jZzC;
                            break;
                        }
                        int iZze2 = zzbfVar.zze(zzmcVarZzp2.zzb);
                        if (iZze2 != -1 && zzbfVar.zzd(iZze2, zzbdVar, false).zzc == i) {
                            jZzC = zzmcVarZzp2.zzg.zza.zzd;
                            break;
                        }
                        zzmcVarZzp2 = zzmcVarZzp2.zzp();
                    }
                } else {
                    if (zzmcVarZzp.zzb.equals(obj)) {
                        jZzC = zzmcVarZzp.zzg.zza.zzd;
                        break;
                    }
                    zzmcVarZzp = zzmcVarZzp.zzp();
                }
            }
        } else {
            jZzC = this.zzp;
        }
        long j2 = jZzC;
        zzbfVar.zzo(obj, zzbdVar);
        int i2 = zzbdVar.zzc;
        zzbe zzbeVar = this.zzb;
        zzbfVar.zzb(i2, zzbeVar, 0L);
        Object obj3 = obj;
        for (int iZze3 = zzbfVar.zze(obj); iZze3 >= zzbeVar.zzn; iZze3--) {
            zzbfVar.zzd(iZze3, zzbdVar, true);
            zzbdVar.zzb();
            if (zzbdVar.zze(zzbdVar.zzd) != -1) {
                Object obj4 = zzbdVar.zzb;
                obj4.getClass();
                obj3 = obj4;
            }
        }
        return zzA(zzbfVar, obj3, j, j2, zzbeVar, zzbdVar);
    }

    final /* synthetic */ void zzz(zzgwj zzgwjVar, zzxk zzxkVar) {
        this.zzc.zzz(zzgwjVar.zzi(), zzxkVar);
    }

    public final zzmc zzi(zzmd zzmdVar) {
        zzmc zzmcVarZza;
        zzmc zzmcVar = this.zzl;
        long jZza = zzmcVar == null ? MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : (zzmcVar.zza() + zzmcVar.zzg.zzf) - zzmdVar.zzb;
        int i = 0;
        while (true) {
            if (i >= this.zzq.size()) {
                zzmcVarZza = null;
                break;
            }
            zzmd zzmdVar2 = ((zzmc) this.zzq.get(i)).zzg;
            long j = zzmdVar2.zzf;
            long j2 = zzmdVar.zzf;
            if ((j == C.TIME_UNSET || j == j2) && zzmdVar2.zzb == zzmdVar.zzb && zzmdVar2.zza.equals(zzmdVar.zza)) {
                zzmcVarZza = (zzmc) this.zzq.remove(i);
                break;
            }
            i++;
        }
        if (zzmcVarZza == null) {
            zzmcVarZza = this.zzr.zza(zzmdVar, jZza);
        } else {
            zzmcVarZza.zzg = zzmdVar;
            zzmcVarZza.zzb(jZza);
        }
        zzmc zzmcVar2 = this.zzl;
        if (zzmcVar2 != null) {
            zzmcVar2.zzo(zzmcVarZza);
        } else {
            this.zzi = zzmcVarZza;
            this.zzj = zzmcVarZza;
            this.zzk = zzmcVarZza;
        }
        this.zzo = null;
        this.zzl = zzmcVarZza;
        this.zzn++;
        zzB();
        return zzmcVarZza;
    }

    public final int zzs(zzmc zzmcVar) {
        zzmcVar.getClass();
        int i = 0;
        if (zzmcVar.equals(this.zzl)) {
            return 0;
        }
        this.zzl = zzmcVar;
        while (zzmcVar.zzp() != null) {
            zzmcVar = zzmcVar.zzp();
            zzmcVar.getClass();
            if (zzmcVar == this.zzj) {
                zzmc zzmcVar2 = this.zzi;
                this.zzj = zzmcVar2;
                this.zzk = zzmcVar2;
                i = 3;
            }
            if (zzmcVar == this.zzk) {
                this.zzk = this.zzj;
                i |= 2;
            }
            zzmcVar.zzn();
            this.zzn--;
        }
        zzmc zzmcVar3 = this.zzl;
        zzmcVar3.getClass();
        zzmcVar3.zzo(null);
        zzB();
        return i;
    }
}
