package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.exoplayer.MediaPeriodQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlu implements Handler.Callback, zzxh, zzabg, zzmq, zzjh, zzmu, zzcc, zzadr {
    private static final long zza = zzfl.zzr(10000);
    private final boolean zzA;
    private zzni zzB;
    private boolean zzD;
    private boolean zzE;
    private zzlt zzF;
    private int zzG;
    private zzms zzH;
    private zzlr zzI;
    private boolean zzJ;
    private boolean zzL;
    private boolean zzM;
    private boolean zzO;
    private boolean zzR;
    private int zzS;
    private zzlt zzT;
    private long zzU;
    private long zzV;
    private int zzW;
    private boolean zzX;
    private zzjk zzY;
    private zzju zzaa;
    private boolean zzac;
    private final zzjd zzae;
    private final zzne[] zzb;
    private final zznc[] zzc;
    private final boolean[] zzd;
    private final zzabh zze;
    private final zzabi zzf;
    private final zzly zzg;
    private final zzabq zzh;
    private final zzdz zzi;
    private final zzmt zzj;
    private final Looper zzk;
    private final zzbe zzl;
    private final zzbd zzm;
    private final long zzn;
    private final zzji zzo;
    private final ArrayList zzp;
    private final zzdo zzq;
    private final zzls zzr;
    private final zzmf zzs;
    private final zzmr zzt;
    private final long zzu;
    private final zzqf zzv;
    private final zznm zzw;
    private final zzdz zzx;
    private final boolean zzy;
    private final zzcd zzz;
    private long zzab = C.TIME_UNSET;
    private int zzP = 0;
    private boolean zzQ = false;
    private boolean zzK = false;
    private float zzad = 1.0f;
    private zznh zzC = zznh.zza;
    private long zzZ = C.TIME_UNSET;
    private long zzN = C.TIME_UNSET;

    public zzlu(Context context, zzna[] zznaVarArr, zzna[] zznaVarArr2, zzabh zzabhVar, zzabi zzabiVar, zzly zzlyVar, zzabq zzabqVar, int i, boolean z, zznm zznmVar, zzni zzniVar, zzjd zzjdVar, long j, boolean z2, boolean z3, Looper looper, zzdo zzdoVar, zzls zzlsVar, zzqf zzqfVar, zzmt zzmtVar, zzju zzjuVar, final zzadr zzadrVar, boolean z4) {
        this.zzr = zzlsVar;
        this.zze = zzabhVar;
        this.zzf = zzabiVar;
        this.zzg = zzlyVar;
        this.zzh = zzabqVar;
        int i2 = 0;
        this.zzB = zzniVar;
        this.zzae = zzjdVar;
        this.zzu = j;
        this.zzq = zzdoVar;
        this.zzv = zzqfVar;
        this.zzaa = zzjuVar;
        this.zzw = zznmVar;
        this.zzA = z4;
        this.zzn = zzlyVar.zzf(zzqfVar);
        zzlyVar.zzg(zzqfVar);
        zzbf zzbfVar = zzbf.zza;
        this.zzH = zzms.zza(zzabiVar);
        this.zzI = new zzlr(this.zzH);
        int length = zznaVarArr.length;
        this.zzc = new zznc[2];
        this.zzd = new boolean[2];
        zznb zznbVarZzg = zzabhVar.zzg();
        this.zzb = new zzne[2];
        boolean z5 = false;
        while (true) {
            int length2 = zznaVarArr.length;
            if (i2 >= 2) {
                this.zzy = z5;
                this.zzo = new zzji(this, zzdoVar);
                this.zzp = new ArrayList();
                this.zzl = new zzbe();
                this.zzm = new zzbd();
                zzabhVar.zzs(this, zzabqVar);
                this.zzX = true;
                zzdz zzdzVarZzd = zzdoVar.zzd(looper, null);
                this.zzx = zzdzVarZzd;
                this.zzs = new zzmf(zznmVar, zzdzVarZzd, new zzln(this), zzjuVar);
                this.zzt = new zzmr(this, zznmVar, zzdzVarZzd, zzqfVar);
                zzmt zzmtVar2 = new zzmt(null);
                this.zzj = zzmtVar2;
                Looper looperZza = zzmtVar2.zza();
                this.zzk = looperZza;
                zzdz zzdzVarZzd2 = zzdoVar.zzd(looperZza, this);
                this.zzi = zzdzVarZzd2;
                this.zzz = new zzcd(context, looperZza, this);
                zzdzVarZzd2.zzd(35, new zzadr() { // from class: com.google.android.gms.internal.ads.zzlj
                    @Override // com.google.android.gms.internal.ads.zzadr
                    public final /* synthetic */ void zzcS(long j2, long j3, zzv zzvVar, MediaFormat mediaFormat) {
                        this.zza.zzcS(j2, j3, zzvVar, mediaFormat);
                    }
                }).zza();
                return;
            }
            zznaVarArr[i2].zzc(i2, zzqfVar, zzdoVar);
            this.zzc[i2] = zznaVarArr[i2].zzb();
            this.zzc[i2].zzv(zznbVarZzg);
            zzna zznaVar = zznaVarArr2[i2];
            if (zznaVar != null) {
                zznaVar.zzc(i2, zzqfVar, zzdoVar);
                z5 = true;
            }
            this.zzb[i2] = new zzne(zznaVarArr[i2], zznaVarArr2[i2], i2);
            i2++;
        }
    }

    private final void zzA(IOException iOException, int i) {
        zzmf zzmfVar = this.zzs;
        zzjk zzjkVarZza = zzjk.zza(iOException, i);
        zzmc zzmcVarZzm = zzmfVar.zzm();
        if (zzmcVarZzm != null) {
            zzjkVarZza = zzjkVarZza.zzd(zzmcVarZzm.zzg.zza);
        }
        zzeg.zzf("ExoPlayerImplInternal", "Playback error", zzjkVarZza);
        zzW(false, false);
        this.zzH = this.zzH.zzf(zzjkVarZza);
    }

    private final void zzB(int i) {
        zzms zzmsVar = this.zzH;
        if (zzmsVar.zze != i) {
            if (i != 2) {
                this.zzZ = C.TIME_UNSET;
            }
            if (i != 3) {
                boolean z = zzmsVar.zzp;
            }
            this.zzH = this.zzH.zze(i);
        }
    }

    private final void zzC() {
        this.zzI.zzb(this.zzH);
        if (this.zzI.zzd()) {
            this.zzr.zza(this.zzI);
            this.zzI = new zzlr(this.zzH);
        }
    }

    private final void zzD(float f) throws zzjk {
        this.zzad = f;
        float fZza = f * this.zzz.zza();
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzneVarArr[i].zzL(fZza);
            i++;
        }
    }

    private final void zzE(boolean z, int i, boolean z2, int i2) throws zzjk {
        this.zzI.zza(z2 ? 1 : 0);
        zzG(z, i, i2);
    }

    private final void zzF() throws zzjk {
        zzms zzmsVar = this.zzH;
        zzG(zzmsVar.zzl, zzmsVar.zzn, zzmsVar.zzm);
    }

    private final void zzG(boolean z, int i, int i2) throws zzjk {
        zzH(z, this.zzz.zzc(z, this.zzH.zze), i, i2);
    }

    private final void zzH(boolean z, int i, int i2, int i3) throws zzjk {
        boolean z2;
        if (!z) {
            z2 = false;
        } else if (i != -1) {
            z2 = true;
        } else {
            i = -1;
            z2 = false;
        }
        if (i == -1) {
            i3 = 2;
        } else if (i3 == 2) {
            i3 = 1;
        }
        boolean z3 = this.zzD;
        if (i == 0) {
            i2 = 1;
        } else if (i2 == 1) {
            i2 = z3 ? 4 : 0;
        }
        zzms zzmsVar = this.zzH;
        if (zzmsVar.zzl == z2 && zzmsVar.zzn == i2 && zzmsVar.zzm == i3) {
            return;
        }
        this.zzH = zzmsVar.zzi(z2, i3, i2);
        zzaD(false, false);
        zzmf zzmfVar = this.zzs;
        for (zzmc zzmcVarZzm = zzmfVar.zzm(); zzmcVarZzm != null; zzmcVarZzm = zzmcVarZzm.zzp()) {
            for (zzaba zzabaVar : zzmcVarZzm.zzr().zzc) {
            }
        }
        if (!zzay()) {
            zzK();
            zzL();
            boolean z4 = this.zzH.zzp;
            zzmfVar.zzf(this.zzU);
            return;
        }
        int i4 = this.zzH.zze;
        if (i4 == 3) {
            this.zzo.zza();
            zzJ();
            this.zzi.zzh(2);
        } else if (i4 == 2) {
            this.zzi.zzh(2);
        }
    }

    private final void zzI(boolean z) throws zzjk {
        zzxk zzxkVar = this.zzs.zzm().zzg.zza;
        long jZzT = zzT(zzxkVar, this.zzH.zzs, true, false);
        if (jZzT != this.zzH.zzs) {
            zzms zzmsVar = this.zzH;
            this.zzH = zzap(zzxkVar, jZzT, zzmsVar.zzc, zzmsVar.zzd, z, 5);
        }
    }

    private final void zzJ() throws zzjk {
        zzmc zzmcVarZzm = this.zzs.zzm();
        if (zzmcVarZzm == null) {
            return;
        }
        zzabi zzabiVarZzr = zzmcVarZzm.zzr();
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            if (zzabiVarZzr.zza(i)) {
                zzneVarArr[i].zzv();
            }
            i++;
        }
    }

    private final void zzK() throws zzjk {
        this.zzo.zzb();
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzneVarArr[i].zzw();
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        r13 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzL() throws com.google.android.gms.internal.ads.zzjk {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzL():void");
    }

    private final void zzM(zzav zzavVar) {
        this.zzi.zzk(16);
        this.zzo.zzi(zzavVar);
    }

    private final void zzN(final int i, final boolean z) {
        boolean[] zArr = this.zzd;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.zzx.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlk
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(i, z);
                }
            });
        }
    }

    private final long zzO(zzbf zzbfVar, Object obj, long j) {
        int i = zzbfVar.zzo(obj, this.zzm).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i, zzbeVar, 0L);
        if (zzbeVar.zzf == C.TIME_UNSET || !zzbeVar.zzb() || !zzbeVar.zzi) {
            return C.TIME_UNSET;
        }
        long j2 = zzbeVar.zzg;
        String str = zzfl.zza;
        return zzfl.zzs((j2 == C.TIME_UNSET ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - zzbeVar.zzf) - j;
    }

    private final boolean zzP(zzbf zzbfVar, zzxk zzxkVar) {
        if (!zzxkVar.zzb() && !zzbfVar.zzg()) {
            int i = zzbfVar.zzo(zzxkVar.zza, this.zzm).zzc;
            zzbe zzbeVar = this.zzl;
            zzbfVar.zzb(i, zzbeVar, 0L);
            if (zzbeVar.zzb() && zzbeVar.zzi && zzbeVar.zzf != C.TIME_UNSET) {
                return true;
            }
        }
        return false;
    }

    private final void zzQ(long j) {
        long jMin = 1000;
        if (zzw()) {
            jMin = this.zzH.zze != 3 ? zza : 1000L;
            zzne[] zzneVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                jMin = Math.min(jMin, zzfl.zzr(zzneVarArr[i].zzk(this.zzU, this.zzV)));
            }
            if (this.zzH.zzj()) {
                zzmf zzmfVar = this.zzs;
                zzmc zzmcVarZzp = zzmfVar.zzm() != null ? zzmfVar.zzm().zzp() : null;
                if (zzmcVarZzp != null) {
                    if (this.zzU + (zzfl.zzs(jMin) * this.zzH.zzo.zzb) >= zzmcVarZzp.zzc()) {
                        jMin = Math.min(jMin, zza);
                    }
                }
            }
        } else if (this.zzH.zze != 3 || zzay()) {
            jMin = zza;
        }
        this.zzi.zzj(2, j + jMin);
    }

    private final void zzR(zzlt zzltVar) throws Throwable {
        long jLongValue;
        zzxk zzxkVarZzy;
        boolean z;
        boolean z2;
        long j;
        long j2;
        long j3;
        long j4;
        long jZzk;
        zzms zzmsVar;
        int i;
        if (this.zzE) {
            if (this.zzF != null) {
                this.zzG++;
                this.zzI.zza(1);
            }
            this.zzF = zzltVar;
            return;
        }
        this.zzI.zza(1);
        zzbf zzbfVar = this.zzH.zza;
        int i2 = this.zzP;
        boolean z3 = this.zzQ;
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzaE = zzaE(zzbfVar, zzltVar, true, i2, z3, zzbeVar, zzbdVar);
        long jMax = C.TIME_UNSET;
        if (pairZzaE == null) {
            Pair pairZzY = zzY(this.zzH.zza);
            zzxk zzxkVar = (zzxk) pairZzY.first;
            jLongValue = ((Long) pairZzY.second).longValue();
            z = !this.zzH.zza.zzg();
            zzxkVarZzy = zzxkVar;
            jMax = -9223372036854775807L;
        } else {
            Object obj = pairZzaE.first;
            jLongValue = ((Long) pairZzaE.second).longValue();
            long j5 = zzltVar.zzc;
            if (j5 != C.TIME_UNSET) {
                jMax = jLongValue;
            }
            zzxkVarZzy = this.zzs.zzy(this.zzH.zza, obj, jLongValue);
            if (zzxkVarZzy.zzb()) {
                this.zzH.zza.zzo(zzxkVarZzy.zza, zzbdVar);
                int i3 = zzxkVarZzy.zzb;
                if (zzbdVar.zzd(i3) == zzxkVarZzy.zzc) {
                    zzbdVar.zzj();
                }
                zza zzaVarZza = zzbdVar.zzg.zza(i3);
                long j6 = zzaVarZza.zza;
                long j7 = zzaVarZza.zzi;
                jMax = Math.max(jMax, 0L);
                jLongValue = 0;
            } else if (j5 != C.TIME_UNSET) {
                z = false;
            }
            z = true;
        }
        try {
            if (this.zzH.zza.zzg()) {
                this.zzT = zzltVar;
            } else if (pairZzaE == null) {
                if (this.zzH.zze != 1) {
                    zzB(4);
                }
                zzX(false, true, false, true);
            } else {
                if (zzxkVarZzy.equals(this.zzH.zzb)) {
                    zzmc zzmcVarZzm = this.zzs.zzm();
                    if (zzmcVarZzm == null || !zzmcVarZzm.zze || jLongValue == 0) {
                        jZzk = jLongValue;
                    } else {
                        zzxi zzxiVar = zzmcVarZzm.zza;
                        long j8 = zzbeVar.zzm;
                        if (this.zzD && j8 != jMax) {
                            Double d = this.zzC.zzc;
                        }
                        jZzk = zzxiVar.zzk(jLongValue, this.zzB);
                    }
                    long j9 = jZzk;
                    if (zzfl.zzr(jZzk) == zzfl.zzr(this.zzH.zzs) && ((i = (zzmsVar = this.zzH).zze) == 2 || i == 3)) {
                        jLongValue = zzmsVar.zzs;
                    } else {
                        j2 = j9;
                    }
                } else {
                    j2 = jLongValue;
                }
                if (this.zzD) {
                    zzne[] zzneVarArr = this.zzb;
                    for (int i4 = 0; i4 < 2; i4++) {
                        zzne zzneVar = zzneVarArr[i4];
                        if (zzneVar.zzM() && zzneVar.zze() == 2) {
                            this.zzE = true;
                            break;
                        }
                    }
                }
                long jZzS = zzS(zzxkVarZzy, j2, this.zzH.zze == 4);
                z2 = (jLongValue != jZzS) | z;
                try {
                    zzms zzmsVar2 = this.zzH;
                    zzxk zzxkVar2 = zzxkVarZzy;
                    try {
                        zzbf zzbfVar2 = zzmsVar2.zza;
                        long j10 = jMax;
                        try {
                            zzag(zzbfVar2, zzxkVar2, zzbfVar2, zzmsVar2.zzb, j10, true);
                            zzxkVarZzy = zzxkVar2;
                            j3 = j10;
                            j4 = jZzS;
                            this.zzH = zzap(zzxkVarZzy, j4, j3, j4, z2, 2);
                        } catch (Throwable th) {
                            th = th;
                            zzxkVarZzy = zzxkVar2;
                            jMax = j10;
                            j = jZzS;
                            this.zzH = zzap(zzxkVarZzy, j, jMax, j, z2, 2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zzxkVarZzy = zzxkVar2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            }
            z2 = z;
            j3 = jMax;
            j4 = jLongValue;
            this.zzH = zzap(zzxkVarZzy, j4, j3, j4, z2, 2);
        } catch (Throwable th4) {
            th = th4;
            z2 = z;
            j = jLongValue;
        }
    }

    private final long zzS(zzxk zzxkVar, long j, boolean z) throws zzjk {
        zzmf zzmfVar = this.zzs;
        return zzT(zzxkVar, j, zzmfVar.zzm() != zzmfVar.zzn(), z);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00d0  */
    private final long zzT(zzxk zzxkVar, long j, boolean z, boolean z2) throws zzjk {
        zzK();
        boolean z3 = true;
        zzaD(false, true);
        if (z2 || this.zzH.zze == 3) {
            zzB(2);
        }
        zzmf zzmfVar = this.zzs;
        zzmc zzmcVarZzm = zzmfVar.zzm();
        zzmc zzmcVarZzp = zzmcVarZzm;
        while (zzmcVarZzp != null && !zzxkVar.equals(zzmcVarZzp.zzg.zza)) {
            zzmcVarZzp = zzmcVarZzp.zzp();
        }
        if (z || zzmcVarZzm != zzmcVarZzp || (zzmcVarZzp != null && zzmcVarZzp.zza() + j < 0)) {
            zzaa();
            if (zzmcVarZzp != null) {
                while (zzmfVar.zzm() != zzmcVarZzp) {
                    zzmfVar.zzr();
                }
                zzmfVar.zzs(zzmcVarZzp);
                zzmcVarZzp.zzb(MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US);
                zzaq();
                zzmcVarZzp.zzh = true;
            }
        }
        zzab();
        if (zzmcVarZzp != null) {
            zzmfVar.zzs(zzmcVarZzp);
            if (!zzmcVarZzp.zze) {
                zzmcVarZzp.zzg = zzmcVarZzp.zzg.zza(j, C.TIME_UNSET);
            } else if (zzmcVarZzp.zzf) {
                if (this.zzD) {
                    boolean z4 = this.zzC.zzi;
                    if (this.zzH.zza.zzg() || !zzmcVarZzp.zzg.zza.equals(this.zzH.zzb)) {
                        zzxi zzxiVar = zzmcVarZzp.zza;
                        j = zzxiVar.zzj(j);
                        zzxiVar.zzf(j - this.zzn, false);
                    } else {
                        long jZza = zzmcVarZzp.zza() + j;
                        zzne[] zzneVarArr = this.zzb;
                        boolean zZzF = true;
                        for (int i = 0; i < 2; i++) {
                            zzne zzneVar = zzneVarArr[i];
                            if (zzneVar.zzM()) {
                                zZzF &= zzneVar.zzF(zzmcVarZzp, jZza);
                            }
                        }
                        if (zZzF) {
                            zzxi zzxiVar2 = zzmcVarZzp.zza;
                            long j2 = this.zzH.zzs;
                            zzni zzniVar = zzni.zzb;
                            if (zzxiVar2.zzk(j2, zzniVar) == zzxiVar2.zzk(j, zzniVar)) {
                                z3 = false;
                            } else {
                                zzxi zzxiVar3 = zzmcVarZzp.zza;
                                j = zzxiVar3.zzj(j);
                                zzxiVar3.zzf(j - this.zzn, false);
                            }
                        } else {
                            zzxi zzxiVar4 = zzmcVarZzp.zza;
                            j = zzxiVar4.zzj(j);
                            zzxiVar4.zzf(j - this.zzn, false);
                        }
                    }
                } else {
                    zzxi zzxiVar5 = zzmcVarZzp.zza;
                    j = zzxiVar5.zzj(j);
                    zzxiVar5.zzf(j - this.zzn, false);
                }
            }
            zzU(j, z3);
            zzan();
        } else {
            zzmfVar.zzv();
            zzU(j, true);
        }
        zzat(false);
        this.zzi.zzh(2);
        return j;
    }

    private final void zzU(long j, boolean z) throws zzjk {
        zzmc zzmcVarZzm = this.zzs.zzm();
        long jZza = j + (zzmcVarZzm == null ? MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : zzmcVarZzm.zza());
        this.zzU = jZza;
        this.zzo.zzc(jZza);
        zzne[] zzneVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            zzneVarArr[i].zzE(zzmcVarZzm, this.zzU, z);
        }
        for (zzmc zzmcVarZzm2 = r0.zzm(); zzmcVarZzm2 != null; zzmcVarZzm2 = zzmcVarZzm2.zzp()) {
            for (zzaba zzabaVar : zzmcVarZzm2.zzr().zzc) {
            }
        }
    }

    private final void zzV() throws zzjk {
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzneVarArr[i].zzz(this.zzD ? this.zzC : null);
            i++;
        }
    }

    private final void zzW(boolean z, boolean z2) {
        zzX(z || !this.zzR, false, true, false);
        this.zzI.zza(z2 ? 1 : 0);
        this.zzg.zzc(this.zzv);
        this.zzz.zzc(this.zzH.zzl, 1);
        zzB(1);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x009b A[PHI: r2 r7 r9
  0x009b: PHI (r2v2 com.google.android.gms.internal.ads.zzxk) = (r2v1 com.google.android.gms.internal.ads.zzxk), (r2v19 com.google.android.gms.internal.ads.zzxk) binds: [B:28:0x0073, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
  0x009b: PHI (r7v3 long) = (r7v2 long), (r7v11 long) binds: [B:28:0x0073, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]
  0x009b: PHI (r9v2 long) = (r9v1 long), (r9v7 long) binds: [B:28:0x0073, B:30:0x0098] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:42:0x00e0 A[PHI: r3
  0x00e0: PHI (r3v3 com.google.android.gms.internal.ads.zzbf) = 
  (r3v2 com.google.android.gms.internal.ads.zzbf)
  (r3v2 com.google.android.gms.internal.ads.zzbf)
  (r3v6 com.google.android.gms.internal.ads.zzbf)
  (r3v6 com.google.android.gms.internal.ads.zzbf)
 binds: [B:34:0x00a9, B:36:0x00ad, B:38:0x00be, B:40:0x00d4] A[DONT_GENERATE, DONT_INLINE]] */
    private final void zzX(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        zzxk zzxkVar;
        zzbf zzbfVar;
        this.zzi.zzk(2);
        this.zzE = false;
        if (this.zzF != null) {
            this.zzI.zza(1);
            this.zzF = null;
        }
        this.zzY = null;
        zzaD(false, true);
        this.zzo.zzb();
        this.zzU = MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US;
        try {
            zzaa();
        } catch (zzjk | RuntimeException e) {
            zzeg.zzf("ExoPlayerImplInternal", "Disable failed.", e);
        }
        if (z) {
            zzne[] zzneVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                try {
                    zzneVarArr[i].zzG();
                } catch (RuntimeException e2) {
                    zzeg.zzf("ExoPlayerImplInternal", "Reset failed.", e2);
                }
            }
        }
        this.zzS = 0;
        zzms zzmsVar = this.zzH;
        zzxk zzxkVar2 = zzmsVar.zzb;
        long jLongValue = zzmsVar.zzs;
        long j = (this.zzH.zzb.zzb() || zzaC(this.zzH, this.zzm)) ? this.zzH.zzc : this.zzH.zzs;
        if (z2) {
            this.zzT = null;
            Pair pairZzY = zzY(this.zzH.zza);
            zzxkVar2 = (zzxk) pairZzY.first;
            jLongValue = ((Long) pairZzY.second).longValue();
            boolean zEquals = zzxkVar2.equals(this.zzH.zzb);
            j = C.TIME_UNSET;
            z5 = zEquals ? false : true;
        }
        long j2 = jLongValue;
        long j3 = j;
        zzmf zzmfVar = this.zzs;
        zzmfVar.zzv();
        this.zzO = false;
        zzbf zzbfVarZzx = this.zzH.zza;
        if (z3 && (zzbfVarZzx instanceof zzmy)) {
            zzbfVarZzx = ((zzmy) zzbfVarZzx).zzx(this.zzt.zzq());
            if (zzxkVar2.zzb != -1) {
                Object obj = zzxkVar2.zza;
                zzbd zzbdVar = this.zzm;
                zzbfVarZzx.zzo(obj, zzbdVar);
                zzbe zzbeVar = this.zzl;
                zzbfVarZzx.zzb(zzbdVar.zzc, zzbeVar, 0L);
                if (zzbeVar.zzb()) {
                    zzbfVar = zzbfVarZzx;
                    zzxkVar = new zzxk(obj, zzxkVar2.zzd);
                } else {
                    zzxkVar = zzxkVar2;
                    zzbfVar = zzbfVarZzx;
                }
            } else {
                zzxkVar = zzxkVar2;
                zzbfVar = zzbfVarZzx;
            }
        } else {
            zzxkVar = zzxkVar2;
            zzbfVar = zzbfVarZzx;
        }
        zzms zzmsVar2 = this.zzH;
        int i2 = zzmsVar2.zze;
        zzjk zzjkVar = z4 ? null : zzmsVar2.zzf;
        zzzn zzznVar = z5 ? zzzn.zza : zzmsVar2.zzh;
        zzabi zzabiVar = z5 ? this.zzf : this.zzH.zzi;
        List listZzi = z5 ? zzgwm.zzi() : this.zzH.zzj;
        zzms zzmsVar3 = this.zzH;
        this.zzH = new zzms(zzbfVar, zzxkVar, j3, j2, i2, zzjkVar, false, zzznVar, zzabiVar, listZzi, zzxkVar, zzmsVar3.zzl, zzmsVar3.zzm, zzmsVar3.zzn, zzmsVar3.zzo, j2, 0L, j2, 0L, false);
        if (z3) {
            zzmfVar.zzj();
            this.zzt.zzg();
        }
    }

    private final Pair zzY(zzbf zzbfVar) {
        long j = 0;
        if (zzbfVar.zzg()) {
            return Pair.create(zzms.zzb(), 0L);
        }
        int iZzk = zzbfVar.zzk(this.zzQ);
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzm = zzbfVar.zzm(zzbeVar, zzbdVar, iZzk, C.TIME_UNSET);
        zzxk zzxkVarZzy = this.zzs.zzy(zzbfVar, pairZzm.first, 0L);
        long jLongValue = ((Long) pairZzm.second).longValue();
        if (zzxkVarZzy.zzb()) {
            zzbfVar.zzo(zzxkVarZzy.zza, zzbdVar);
            if (zzxkVarZzy.zzc == zzbdVar.zzd(zzxkVarZzy.zzb)) {
                zzbdVar.zzj();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(zzxkVarZzy, Long.valueOf(j));
    }

    private final void zzZ(zzbf zzbfVar, zzbf zzbfVar2) {
        if (zzbfVar.zzg() && zzbfVar2.zzg()) {
            return;
        }
        ArrayList arrayList = this.zzp;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
            return;
        }
        zzlq zzlqVar = (zzlq) arrayList.get(size);
        Object obj = zzlqVar.zzb;
        zzmw zzmwVar = zzlqVar.zza;
        String str = zzfl.zza;
        throw null;
    }

    private final boolean zzaA() {
        if (!this.zzy) {
            return false;
        }
        zzne[] zzneVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            if (zzneVarArr[i].zzc()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaB, reason: merged with bridge method [inline-methods] */
    public final boolean zzw() {
        if (!this.zzD) {
            return false;
        }
        boolean z = this.zzC.zzg;
        return true;
    }

    private static boolean zzaC(zzms zzmsVar, zzbd zzbdVar) {
        zzxk zzxkVar = zzmsVar.zzb;
        zzbf zzbfVar = zzmsVar.zza;
        return zzbfVar.zzg() || zzbfVar.zzo(zzxkVar.zza, zzbdVar).zzf;
    }

    private final void zzaD(boolean z, boolean z2) {
        this.zzM = z;
        long jElapsedRealtime = C.TIME_UNSET;
        if (z && !z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzN = jElapsedRealtime;
    }

    private static Pair zzaE(zzbf zzbfVar, zzlt zzltVar, boolean z, int i, boolean z2, zzbe zzbeVar, zzbd zzbdVar) {
        zzbf zzbfVar2;
        zzbf zzbfVar3 = zzltVar.zza;
        if (zzbfVar.zzg()) {
            return null;
        }
        if (true == zzbfVar3.zzg()) {
            zzbfVar2 = zzbfVar3;
            zzbfVar2 = zzbfVar;
        }
        try {
            zzbfVar2 = zzbfVar3;
            Pair pairZzm = zzbfVar2.zzm(zzbeVar, zzbdVar, zzltVar.zzb, zzltVar.zzc);
            zzbf zzbfVar4 = zzbfVar2;
            if (!zzbfVar.equals(zzbfVar4)) {
                if (zzbfVar.zze(pairZzm.first) == -1) {
                    int iZzr = zzr(zzbeVar, zzbdVar, i, z2, pairZzm.first, zzbfVar4, zzbfVar);
                    if (iZzr != -1) {
                        return zzbfVar.zzm(zzbeVar, zzbdVar, iZzr, C.TIME_UNSET);
                    }
                    return null;
                }
                if (zzbfVar4.zzo(pairZzm.first, zzbdVar).zzf && zzbfVar4.zzb(zzbdVar.zzc, zzbeVar, 0L).zzn == zzbfVar4.zze(pairZzm.first)) {
                    return zzbfVar.zzm(zzbeVar, zzbdVar, zzbfVar.zzo(pairZzm.first, zzbdVar).zzc, zzltVar.zzc);
                }
            }
            return pairZzm;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private static final void zzaF(zzmw zzmwVar) throws zzjk {
        zzmwVar.zzh();
        try {
            zzmwVar.zza().zzx(zzmwVar.zzc(), zzmwVar.zze());
        } finally {
            zzmwVar.zzi(true);
        }
    }

    private static final boolean zzaG(zzmc zzmcVar) {
        if (zzmcVar != null) {
            try {
                if (zzmcVar.zze) {
                    zzzc[] zzzcVarArr = zzmcVar.zzc;
                    for (int i = 0; i < 2; i++) {
                        zzzc zzzcVar = zzzcVarArr[i];
                        if (zzzcVar != null) {
                            zzzcVar.zzc();
                        }
                    }
                } else {
                    zzmcVar.zza.zzc();
                }
                if (zzmcVar.zzg() != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private final void zzaa() throws zzjk {
        int i = 0;
        while (true) {
            zzne[] zzneVarArr = this.zzb;
            if (i >= 2) {
                this.zzab = C.TIME_UNSET;
                return;
            }
            int iZzd = zzneVarArr[i].zzd();
            zzneVarArr[i].zzA(this.zzo);
            zzN(i, false);
            this.zzS -= iZzd;
            i++;
        }
    }

    private final void zzab() {
        if (this.zzy && zzaA()) {
            zzne[] zzneVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                zzne zzneVar = zzneVarArr[i];
                int iZzd = zzneVar.zzd();
                zzneVar.zzC(this.zzo);
                this.zzS -= iZzd - zzneVar.zzd();
            }
            this.zzab = C.TIME_UNSET;
        }
    }

    private final void zzac() throws zzjk {
        zzad();
        zzI(true);
    }

    private final void zzad() throws zzjk {
        zzabi zzabiVarZzk;
        zzabi zzabiVar;
        boolean z;
        zzlu zzluVar;
        int i;
        zzji zzjiVar = this.zzo;
        float f = zzjiVar.zzj().zzb;
        zzmf zzmfVar = this.zzs;
        zzmc zzmcVarZzm = zzmfVar.zzm();
        zzmc zzmcVarZzn = zzmfVar.zzn();
        zzabi zzabiVar2 = null;
        boolean z2 = true;
        loop0: while (true) {
            if (zzmcVarZzm == null || !zzmcVarZzm.zze) {
                return;
            }
            zzms zzmsVar = this.zzH;
            zzabiVarZzk = zzmcVarZzm.zzk(f, zzmsVar.zza, zzmsVar.zzl);
            zzabiVar = zzmcVarZzm == zzmfVar.zzm() ? zzabiVarZzk : zzabiVar2;
            zzabi zzabiVarZzr = zzmcVarZzm.zzr();
            z = false;
            if (zzabiVarZzr == null) {
                break;
            }
            zzaba[] zzabaVarArr = zzabiVarZzk.zzc;
            if (zzabiVarZzr.zzc.length != zzabaVarArr.length) {
                break;
            }
            for (int i2 = 0; i2 < zzabaVarArr.length; i2++) {
                if (!zzabiVarZzk.zzb(zzabiVarZzr, i2)) {
                    break loop0;
                }
            }
            if (zzmcVarZzm != zzmcVarZzn) {
                z = true;
            }
            z2 &= z;
            zzmcVarZzm = zzmcVarZzm.zzp();
            zzabiVar2 = zzabiVar;
        }
        if (z2) {
            zzmc zzmcVarZzm2 = zzmfVar.zzm();
            int iZzs = zzmfVar.zzs(zzmcVarZzm2) & 1;
            zzne[] zzneVarArr = this.zzb;
            boolean[] zArr = new boolean[2];
            zzabiVar.getClass();
            long jZzm = zzmcVarZzm2.zzm(zzabiVar, this.zzH.zzs, 1 == iZzs, zArr);
            zzms zzmsVar2 = this.zzH;
            if (zzmsVar2.zze != 4 && jZzm != zzmsVar2.zzs) {
                z = true;
            }
            zzms zzmsVar3 = this.zzH;
            i = 2;
            zzluVar = this;
            zzluVar.zzH = zzap(zzmsVar3.zzb, jZzm, zzmsVar3.zzc, zzmsVar3.zzd, z, 5);
            if (z) {
                zzluVar.zzU(jZzm, true);
            }
            zzluVar.zzab();
            boolean[] zArr2 = new boolean[2];
            for (int i3 = 0; i3 < 2; i3++) {
                int iZzd = zzneVarArr[i3].zzd();
                zArr2[i3] = zzneVarArr[i3].zzM();
                zzneVarArr[i3].zzD(zzmcVarZzm2.zzc[i3], zzjiVar, zzluVar.zzU, zArr[i3]);
                if (iZzd - zzneVarArr[i3].zzd() > 0) {
                    zzluVar.zzN(i3, false);
                }
                zzluVar.zzS -= iZzd - zzneVarArr[i3].zzd();
            }
            zzluVar.zzar(zArr2, zzluVar.zzU);
            zzmcVarZzm2.zzh = true;
        } else {
            zzluVar = this;
            i = 2;
            zzmfVar.zzs(zzmcVarZzm);
            if (zzmcVarZzm.zze) {
                long jMax = Math.max(zzmcVarZzm.zzg.zzb, zzluVar.zzU - zzmcVarZzm.zza());
                if (zzluVar.zzy && zzluVar.zzaA() && zzmfVar.zzo() == zzmcVarZzm) {
                    zzluVar.zzab();
                }
                zzmcVarZzm.zzl(zzabiVarZzk, jMax, false);
            }
        }
        zzluVar.zzat(true);
        if (zzluVar.zzH.zze != 4) {
            zzluVar.zzan();
            zzluVar.zzL();
            zzluVar.zzi.zzh(i);
        }
    }

    private final boolean zzae() {
        zzmc zzmcVarZzm = this.zzs.zzm();
        long j = zzmcVarZzm.zzg.zzf;
        if (zzmcVarZzm.zze) {
            return j == C.TIME_UNSET || this.zzH.zzs < j || !zzay();
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x022b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0234  */
    /* JADX WARN: Code duplicated, block: B:108:0x023b  */
    /* JADX WARN: Code duplicated, block: B:110:0x0241  */
    /* JADX WARN: Code duplicated, block: B:111:0x0243 A[PHI: r3
  0x0243: PHI (r3v9 long) = (r3v5 long), (r3v5 long), (r3v14 long) binds: [B:116:0x025b, B:118:0x0261, B:110:0x0241] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:112:0x0245  */
    /* JADX WARN: Code duplicated, block: B:114:0x0254  */
    /* JADX WARN: Code duplicated, block: B:116:0x025b  */
    /* JADX WARN: Code duplicated, block: B:139:0x02af  */
    /* JADX WARN: Code duplicated, block: B:142:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:143:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:158:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:18:0x0043  */
    /* JADX WARN: Code duplicated, block: B:233:0x042c  */
    /* JADX WARN: Code duplicated, block: B:234:0x042f  */
    /* JADX WARN: Code duplicated, block: B:237:0x0439  */
    /* JADX WARN: Code duplicated, block: B:239:0x0441 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:240:0x0443  */
    /* JADX WARN: Code duplicated, block: B:241:0x0446  */
    /* JADX WARN: Code duplicated, block: B:245:0x046d  */
    /* JADX WARN: Code duplicated, block: B:88:0x0206  */
    /* JADX WARN: Code duplicated, block: B:98:0x0220  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12, types: [com.google.android.gms.internal.ads.zzlt] */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18, types: [com.google.android.gms.internal.ads.zzlt] */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v24 */
    /* JADX WARN: Type inference failed for: r12v25 */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v28 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v12 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARN: Type inference failed for: r16v16 */
    /* JADX WARN: Type inference failed for: r16v17 */
    /* JADX WARN: Type inference failed for: r16v18 */
    /* JADX WARN: Type inference failed for: r16v19 */
    /* JADX WARN: Type inference failed for: r16v20 */
    /* JADX WARN: Type inference failed for: r16v21 */
    /* JADX WARN: Type inference failed for: r16v22 */
    /* JADX WARN: Type inference failed for: r16v23 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.google.android.gms.internal.ads.zzlu] */
    /*  JADX ERROR: JadxRuntimeException in pass: SimplifyVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r16v2 int, still in use, count: 4, list:
          (r16v2 int) from MOVE (r16v20 ??) = (r16v2 int) A[SYNTHETIC]
          (r16v2 int) from MOVE (r16v21 ??) = (r16v2 int) A[SYNTHETIC]
          (r16v2 int) from MOVE (r16v22 ??) = (r16v2 int) A[SYNTHETIC]
          (r16v2 int) from MOVE (r16v23 ??) = (r16v2 int) A[SYNTHETIC]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyIf(SimplifyVisitor.java:298)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyInsn(SimplifyVisitor.java:138)
        	at jadx.core.dex.visitors.SimplifyVisitor.simplifyBlock(SimplifyVisitor.java:86)
        	at jadx.core.dex.visitors.SimplifyVisitor.visit(SimplifyVisitor.java:71)
        */
    private final void zzaf(com.google.android.gms.internal.ads.zzbf r35, boolean r36) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1146
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.zzaf(com.google.android.gms.internal.ads.zzbf, boolean):void");
    }

    private final void zzag(zzbf zzbfVar, zzxk zzxkVar, zzbf zzbfVar2, zzxk zzxkVar2, long j, boolean z) throws zzjk {
        if (!zzP(zzbfVar, zzxkVar)) {
            zzav zzavVar = zzxkVar.zzb() ? zzav.zza : this.zzH.zzo;
            if (this.zzo.zzj().equals(zzavVar)) {
                return;
            }
            zzM(zzavVar);
            zzam(this.zzH.zzo, zzavVar.zzb, false, false);
            return;
        }
        Object obj = zzxkVar.zza;
        zzbd zzbdVar = this.zzm;
        int i = zzbfVar.zzo(obj, zzbdVar).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i, zzbeVar, 0L);
        zzjd zzjdVar = this.zzae;
        zzaf zzafVar = zzbeVar.zzj;
        String str = zzfl.zza;
        zzjdVar.zza(zzafVar);
        if (j != C.TIME_UNSET) {
            zzjdVar.zzb(zzO(zzbfVar, obj, j));
            return;
        }
        if (!Objects.equals(!zzbfVar2.zzg() ? zzbfVar2.zzb(zzbfVar2.zzo(zzxkVar2.zza, zzbdVar).zzc, zzbeVar, 0L).zzb : null, zzbeVar.zzb) || z) {
            zzjdVar.zzb(C.TIME_UNSET);
        }
    }

    private final long zzah(zzmc zzmcVar) {
        if (zzmcVar == null) {
            return 0L;
        }
        long jZza = zzmcVar.zza();
        if (zzmcVar.zze) {
            int i = 0;
            while (true) {
                zzne[] zzneVarArr = this.zzb;
                if (i >= 2) {
                    break;
                }
                if (zzneVarArr[i].zzp(zzmcVar)) {
                    long jZzf = zzneVarArr[i].zzf(zzmcVar);
                    if (jZzf == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    jZza = Math.max(jZzf, jZza);
                }
                i++;
            }
        }
        return jZza;
    }

    /* JADX WARN: Code duplicated, block: B:119:0x0215 A[LOOP:9: B:118:0x0213->B:119:0x0215, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:185:0x0326  */
    /* JADX WARN: Code duplicated, block: B:63:0x0108 A[EDGE_INSN: B:63:0x0108->B:139:0x025c BREAK  A[LOOP:6: B:72:0x0126->B:76:0x0132]] */
    /* JADX WARN: Multi-variable type inference failed */
    private final void zzai() throws zzjk {
        int i;
        int i2;
        boolean z;
        zzmc zzmcVarZzm;
        zzmc zzmcVarZzp;
        boolean z2;
        zzne[] zzneVarArr;
        zzmc zzmcVarZzo;
        zzmd zzmdVarZzh;
        if (this.zzH.zza.zzg() || !this.zzt.zzb()) {
            return;
        }
        zzmf zzmfVar = this.zzs;
        zzmfVar.zzf(this.zzU);
        if (zzmfVar.zzg() && (zzmdVarZzh = zzmfVar.zzh(this.zzU, this.zzH)) != null) {
            zzmc zzmcVarZzi = zzmfVar.zzi(zzmdVarZzh);
            if (!zzmcVarZzi.zzd) {
                zzmcVarZzi.zzt(this, zzmdVarZzh.zzb);
            } else if (zzmcVarZzi.zze) {
                this.zzi.zzd(8, zzmcVarZzi.zza).zza();
            }
            if (zzmfVar.zzm() == zzmcVarZzi) {
                zzU(zzmdVarZzh.zzb, true);
            }
            zzat(false);
        }
        if (this.zzO) {
            this.zzO = zzaG(zzmfVar.zzk());
            zzao();
        } else {
            zzan();
        }
        if (!this.zzL && this.zzy && !this.zzac && !zzaA() && (zzmcVarZzo = zzmfVar.zzo()) != null && zzmcVarZzo == zzmfVar.zzn() && zzmcVarZzo.zzp() != null && zzmcVarZzo.zzp().zze && zzaw(zzmcVarZzo.zzp()) <= 10000000) {
            zzmfVar.zzq();
            zzmc zzmcVarZzo2 = zzmfVar.zzo();
            if (zzmcVarZzo2 != null) {
                zzabi zzabiVarZzr = zzmcVarZzo2.zzr();
                int i3 = 0;
                while (true) {
                    zzne[] zzneVarArr2 = this.zzb;
                    if (i3 >= 2) {
                        break;
                    }
                    if (zzabiVarZzr.zza(i3) && zzneVarArr2[i3].zza() && !zzneVarArr2[i3].zzc()) {
                        zzneVarArr2[i3].zzb();
                        zzas(zzmcVarZzo2, i3, false, zzmcVarZzo2.zzc());
                    }
                    i3++;
                }
                if (zzaA()) {
                    this.zzab = zzmcVarZzo2.zza.zzh();
                    if (!zzmcVarZzo2.zzd()) {
                        zzmfVar.zzs(zzmcVarZzo2);
                        zzat(false);
                        zzan();
                    }
                }
            }
        }
        zzmc zzmcVarZzn = zzmfVar.zzn();
        if (zzmcVarZzn == null) {
            i = 1;
            break;
        }
        if (zzmcVarZzn.zzp() != null && !this.zzL) {
            zzmc zzmcVarZzn2 = zzmfVar.zzn();
            if (!zzmcVarZzn2.zze) {
                i = 1;
                break;
            }
            int i4 = 0;
            while (true) {
                zzne[] zzneVarArr3 = this.zzb;
                if (i4 >= 2) {
                    if ((!zzaA() || zzmfVar.zzo() != zzmfVar.zzn()) && ((zzmcVarZzn.zzp().zze || this.zzU >= zzmcVarZzn.zzp().zzc()) && (!zzmcVarZzn.zzp().zze || zzaw(zzmcVarZzn.zzp()) <= 10000000))) {
                        zzabi zzabiVarZzr2 = zzmcVarZzn.zzr();
                        zzmc zzmcVarZzp2 = zzmfVar.zzp();
                        zzabi zzabiVarZzr3 = zzmcVarZzp2.zzr();
                        zzbf zzbfVar = this.zzH.zza;
                        i = 1;
                        zzag(zzbfVar, zzmcVarZzp2.zzg.zza, zzbfVar, zzmcVarZzn.zzg.zza, C.TIME_UNSET, false);
                        if (zzmcVarZzp2.zze && (((z = this.zzy) && this.zzab != C.TIME_UNSET) || zzmcVarZzp2.zza.zzh() != C.TIME_UNSET)) {
                            this.zzab = C.TIME_UNSET;
                            if (z && !this.zzac) {
                                int i5 = 0;
                                while (true) {
                                    if (i5 >= 2) {
                                        for (i2 = 0; i2 < 2; i2++) {
                                            zzneVarArr3[i2].zzi(zzabiVarZzr2, zzabiVarZzr3, zzmcVarZzp2.zzc());
                                        }
                                        break;
                                        break;
                                    }
                                    if (zzabiVarZzr3.zza(i5)) {
                                        zzneVarArr3[i5].zze();
                                        zzaba[] zzabaVarArr = zzabiVarZzr3.zzc;
                                        if (zzas.zzd(zzabaVarArr[i5].zzc().zzp, zzabaVarArr[i5].zzc().zzk) || zzneVarArr3[i5].zzc()) {
                                        }
                                    }
                                    i5++;
                                }
                            }
                            long jZzc = zzmcVarZzp2.zzc();
                            for (int i6 = 0; i6 < 2; i6++) {
                                zzneVarArr3[i6].zzj(jZzc);
                            }
                            if (!zzmcVarZzp2.zzd()) {
                                zzmfVar.zzs(zzmcVarZzp2);
                                zzat(false);
                                zzan();
                                break;
                            }
                            break;
                        }
                        while (i2 < 2) {
                            zzneVarArr3[i2].zzi(zzabiVarZzr2, zzabiVarZzr3, zzmcVarZzp2.zzc());
                        }
                        break;
                    }
                } else if (zzneVarArr3[i4].zzr(zzmcVarZzn2)) {
                    i4++;
                }
                i = 1;
                break;
            }
        } else {
            i = 1;
            if (zzmcVarZzn.zzg.zzk || this.zzL) {
                zzne[] zzneVarArr4 = this.zzb;
                for (int i7 = 0; i7 < 2; i7++) {
                    zzne zzneVar = zzneVarArr4[i7];
                    if (zzneVar.zzp(zzmcVarZzn) && zzneVar.zzg(zzmcVarZzn)) {
                        long j = zzmcVarZzn.zzg.zzf;
                        zzneVar.zzh(zzmcVarZzn, (j == C.TIME_UNSET || j == Long.MIN_VALUE) ? -9223372036854775807L : zzmcVarZzn.zza() + j);
                    }
                }
            }
        }
        zzmc zzmcVarZzn3 = zzmfVar.zzn();
        if (zzmcVarZzn3 != null && zzmfVar.zzm() != zzmcVarZzn3 && !zzmcVarZzn3.zzh) {
            zzmc zzmcVarZzn4 = zzmfVar.zzn();
            zzabi zzabiVarZzr4 = zzmcVarZzn4.zzr();
            int i8 = i;
            int i9 = 0;
            while (true) {
                zzneVarArr = this.zzb;
                if (i9 >= 2) {
                    break;
                }
                int iZzd = zzneVarArr[i9].zzd();
                int iZzH = zzneVarArr[i9].zzH(zzmcVarZzn4, zzabiVarZzr4, this.zzo);
                this.zzS -= iZzd - zzneVarArr[i9].zzd();
                i8 &= iZzH & 1;
                i9++;
            }
            if (i8 != 0) {
                for (int i10 = 0; i10 < 2; i10++) {
                    if (zzabiVarZzr4.zza(i10) && !zzneVarArr[i10].zzp(zzmcVarZzn4)) {
                        zzas(zzmcVarZzn4, i10, false, zzmcVarZzn4.zzc());
                    }
                }
                zzmfVar.zzn().zzh = i;
            }
        }
        boolean z3 = false;
        while (zzay() && !this.zzL && (zzmcVarZzm = zzmfVar.zzm()) != null && (zzmcVarZzp = zzmcVarZzm.zzp()) != null && this.zzU >= zzmcVarZzp.zzc() && zzmcVarZzp.zzh) {
            if (z3) {
                zzC();
            }
            this.zzac = false;
            zzmc zzmcVarZzr = zzmfVar.zzr();
            zzmcVarZzr.getClass();
            if (this.zzH.zzb.zza.equals(zzmcVarZzr.zzg.zza.zza)) {
                zzxk zzxkVar = this.zzH.zzb;
                if (zzxkVar.zzb == -1) {
                    zzxk zzxkVar2 = zzmcVarZzr.zzg.zza;
                    if (zzxkVar2.zzb != -1 || zzxkVar.zze == zzxkVar2.zze) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                }
            } else {
                z2 = false;
            }
            zzmd zzmdVar = zzmcVarZzr.zzg;
            boolean z4 = z2;
            zzxk zzxkVar3 = zzmdVar.zza;
            long j2 = zzmdVar.zzb;
            this.zzH = zzap(zzxkVar3, j2, zzmdVar.zzd, j2, !z4, 0);
            zzak();
            zzL();
            if (zzaA() && zzmcVarZzr == zzmfVar.zzo()) {
                zzne[] zzneVarArr5 = this.zzb;
                for (int i11 = 0; i11 < 2; i11++) {
                    zzneVarArr5[i11].zzB();
                }
            }
            if (this.zzH.zze == 3) {
                zzJ();
            }
            zzabi zzabiVarZzr5 = zzmfVar.zzm().zzr();
            int i12 = 0;
            while (true) {
                zzne[] zzneVarArr6 = this.zzb;
                if (i12 < 2) {
                    if (zzabiVarZzr5.zza(i12)) {
                        zzneVarArr6[i12].zzl();
                    }
                    i12++;
                }
            }
            z3 = true;
        }
        long j3 = this.zzaa.zzb;
    }

    private final void zzaj() {
        zzmf zzmfVar = this.zzs;
        zzmfVar.zzt();
        zzmc zzmcVarZzl = zzmfVar.zzl();
        if (zzmcVarZzl != null) {
            if (!zzmcVarZzl.zzd || zzmcVarZzl.zze) {
                zzxi zzxiVar = zzmcVarZzl.zza;
                if (zzxiVar.zzn()) {
                    return;
                }
                if (this.zzg.zzj(this.zzv, this.zzH.zza, zzmcVarZzl.zzg.zza, zzmcVarZzl.zze ? zzxiVar.zzi() : 0L)) {
                    if (!zzmcVarZzl.zzd) {
                        zzmcVarZzl.zzt(this, zzmcVarZzl.zzg.zzb);
                        return;
                    }
                    zzlz zzlzVar = new zzlz();
                    zzlzVar.zza(this.zzU - zzmcVarZzl.zza());
                    zzlzVar.zzb(this.zzo.zzj().zzb);
                    zzlzVar.zzc(this.zzN);
                    zzmcVarZzl.zzj(new zzma(zzlzVar, null));
                }
            }
        }
    }

    private final void zzak() {
        zzmc zzmcVarZzm = this.zzs.zzm();
        boolean z = false;
        if (zzmcVarZzm != null && zzmcVarZzm.zzg.zzj && this.zzK) {
            z = true;
        }
        this.zzL = z;
    }

    private final void zzal(zzav zzavVar, boolean z) throws zzjk {
        zzam(zzavVar, zzavVar.zzb, true, z);
    }

    private final void zzam(zzav zzavVar, float f, boolean z, boolean z2) throws zzjk {
        int i;
        if (z) {
            if (z2) {
                this.zzI.zza(1);
            }
            zzms zzmsVar = this.zzH;
            zzbf zzbfVar = zzmsVar.zza;
            zzxk zzxkVar = zzmsVar.zzb;
            long j = zzmsVar.zzc;
            long j2 = zzmsVar.zzd;
            int i2 = zzmsVar.zze;
            zzjk zzjkVar = zzmsVar.zzf;
            boolean z3 = zzmsVar.zzg;
            zzzn zzznVar = zzmsVar.zzh;
            zzabi zzabiVar = zzmsVar.zzi;
            List list = zzmsVar.zzj;
            zzxk zzxkVar2 = zzmsVar.zzk;
            boolean z4 = zzmsVar.zzl;
            int i3 = zzmsVar.zzm;
            int i4 = zzmsVar.zzn;
            long j3 = zzmsVar.zzq;
            long j4 = zzmsVar.zzr;
            long j5 = zzmsVar.zzs;
            long j6 = zzmsVar.zzt;
            boolean z5 = zzmsVar.zzp;
            this.zzH = new zzms(zzbfVar, zzxkVar, j, j2, i2, zzjkVar, z3, zzznVar, zzabiVar, list, zzxkVar2, z4, i3, i4, zzavVar, j3, j4, j5, j6, false);
        }
        float f2 = zzavVar.zzb;
        zzmc zzmcVarZzm = this.zzs.zzm();
        while (true) {
            i = 0;
            if (zzmcVarZzm == null) {
                break;
            }
            zzaba[] zzabaVarArr = zzmcVarZzm.zzr().zzc;
            int length = zzabaVarArr.length;
            while (i < length) {
                zzaba zzabaVar = zzabaVarArr[i];
                i++;
            }
            zzmcVarZzm = zzmcVarZzm.zzp();
        }
        zzne[] zzneVarArr = this.zzb;
        while (i < 2) {
            zzneVarArr[i].zzm(f, f2);
            i++;
        }
    }

    private final void zzan() {
        long jZza;
        long jZza2;
        zzmf zzmfVar = this.zzs;
        boolean zZzh = false;
        if (zzaG(zzmfVar.zzk())) {
            zzmc zzmcVarZzk = zzmfVar.zzk();
            long jZzav = zzav(zzmcVarZzk.zzg());
            if (zzmcVarZzk == zzmfVar.zzm()) {
                jZza = this.zzU;
                jZza2 = zzmcVarZzk.zza();
            } else {
                jZza = this.zzU - zzmcVarZzk.zza();
                jZza2 = zzmcVarZzk.zzg.zzb;
            }
            zzlx zzlxVar = new zzlx(this.zzv, this.zzH.zza, zzmcVarZzk.zzg.zza, jZza - jZza2, jZzav, this.zzo.zzj().zzb, this.zzH.zzl, this.zzM, zzP(this.zzH.zza, zzmcVarZzk.zzg.zza) ? this.zzae.zze() : C.TIME_UNSET, this.zzN);
            zzly zzlyVar = this.zzg;
            boolean zZzh2 = zzlyVar.zzh(zzlxVar);
            zzmc zzmcVarZzm = zzmfVar.zzm();
            if (zZzh2 || !zzmcVarZzm.zze || jZzav >= 500000 || this.zzn <= 0) {
                zZzh = zZzh2;
            } else {
                zzmcVarZzm.zza.zzf(this.zzH.zzs, false);
                zZzh = zzlyVar.zzh(zzlxVar);
            }
        }
        this.zzO = zZzh;
        if (zZzh) {
            zzmc zzmcVarZzk2 = zzmfVar.zzk();
            zzmcVarZzk2.getClass();
            zzlz zzlzVar = new zzlz();
            zzlzVar.zza(this.zzU - zzmcVarZzk2.zza());
            zzlzVar.zzb(this.zzo.zzj().zzb);
            zzlzVar.zzc(this.zzN);
            zzmcVarZzk2.zzj(new zzma(zzlzVar, null));
        }
        zzao();
    }

    private final void zzao() {
        zzmc zzmcVarZzk = this.zzs.zzk();
        boolean z = true;
        if (!this.zzO && (zzmcVarZzk == null || !zzmcVarZzk.zza.zzn())) {
            z = false;
        }
        zzms zzmsVar = this.zzH;
        if (z != zzmsVar.zzg) {
            this.zzH = zzmsVar.zzg(z);
        }
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0099  */
    private final zzms zzap(zzxk zzxkVar, long j, long j2, long j3, boolean z, int i) {
        List list;
        zzabi zzabiVar;
        zzmc zzmcVarZzm;
        int i2 = 0;
        this.zzX = (!this.zzX && j == this.zzH.zzs && zzxkVar.equals(this.zzH.zzb)) ? false : true;
        zzak();
        zzms zzmsVar = this.zzH;
        zzzn zzznVar = zzmsVar.zzh;
        zzabi zzabiVar2 = zzmsVar.zzi;
        List listZzi = zzmsVar.zzj;
        if (this.zzt.zzb()) {
            zzmf zzmfVar = this.zzs;
            zzmc zzmcVarZzm2 = zzmfVar.zzm();
            zzzn zzznVarZzq = zzmcVarZzm2 == null ? zzzn.zza : zzmcVarZzm2.zzq();
            zzabi zzabiVarZzr = zzmcVarZzm2 == null ? this.zzf : zzmcVarZzm2.zzr();
            zzaba[] zzabaVarArr = zzabiVarZzr.zzc;
            zzgwj zzgwjVar = new zzgwj();
            boolean z2 = false;
            for (zzaba zzabaVar : zzabaVarArr) {
                if (zzabaVar != null) {
                    zzap zzapVar = zzabaVar.zzb(0).zzl;
                    if (zzapVar == null) {
                        zzgwjVar.zzf(new zzap(C.TIME_UNSET, new zzao[0]));
                    } else {
                        zzgwjVar.zzf(zzapVar);
                        z2 = true;
                    }
                }
            }
            zzgwm zzgwmVarZzi = z2 ? zzgwjVar.zzi() : zzgwm.zzi();
            if (zzmcVarZzm2 != null) {
                zzmd zzmdVar = zzmcVarZzm2.zzg;
                if (zzmdVar.zzd != j2) {
                    zzmcVarZzm2.zzg = zzmdVar.zzb(j2);
                }
            }
            if (zzmfVar.zzm() == zzmfVar.zzn() && (zzmcVarZzm = zzmfVar.zzm()) != null) {
                zzabi zzabiVarZzr2 = zzmcVarZzm.zzr();
                while (true) {
                    zzne[] zzneVarArr = this.zzb;
                    if (i2 >= 2) {
                        break;
                    }
                    if (zzabiVarZzr2.zza(i2)) {
                        if (zzneVarArr[i2].zze() != 1) {
                            break;
                        }
                        int i3 = zzabiVarZzr2.zzb[i2].zzb;
                    }
                    i2++;
                }
            }
            list = zzgwmVarZzi;
            zzznVar = zzznVarZzq;
            zzabiVar = zzabiVarZzr;
        } else {
            if (!zzxkVar.equals(this.zzH.zzb)) {
                zzabiVar2 = this.zzf;
                zzznVar = zzzn.zza;
                listZzi = zzgwm.zzi();
            }
            list = listZzi;
            zzabiVar = zzabiVar2;
        }
        if (z) {
            this.zzI.zzc(i);
        }
        return this.zzH.zzc(zzxkVar, j, j2, j3, zzau(), zzznVar, zzabiVar, list);
    }

    private final void zzaq() throws zzjk {
        zzar(new boolean[2], this.zzs.zzn().zzc());
    }

    private final void zzar(boolean[] zArr, long j) throws zzjk {
        zzne[] zzneVarArr;
        long j2;
        zzmc zzmcVarZzn = this.zzs.zzn();
        zzabi zzabiVarZzr = zzmcVarZzn.zzr();
        int i = 0;
        while (true) {
            zzneVarArr = this.zzb;
            if (i >= 2) {
                break;
            }
            if (!zzabiVarZzr.zza(i)) {
                zzneVarArr[i].zzG();
            }
            i++;
        }
        int i2 = 0;
        while (i2 < 2) {
            if (!zzabiVarZzr.zza(i2) || zzneVarArr[i2].zzp(zzmcVarZzn)) {
                j2 = j;
            } else {
                j2 = j;
                zzas(zzmcVarZzn, i2, zArr[i2], j2);
            }
            i2++;
            j = j2;
        }
    }

    private final void zzas(zzmc zzmcVar, int i, boolean z, long j) throws zzjk {
        zzne zzneVar = this.zzb[i];
        if (zzneVar.zzM()) {
            return;
        }
        boolean z2 = zzmcVar == this.zzs.zzm();
        zzabi zzabiVarZzr = zzmcVar.zzr();
        zznd zzndVar = zzabiVarZzr.zzb[i];
        zzaba zzabaVar = zzabiVarZzr.zzc[i];
        boolean z3 = zzay() && this.zzH.zze == 3;
        boolean z4 = !z && z3;
        this.zzS++;
        zzneVar.zzx(zzndVar, zzabaVar, zzmcVar.zzc[i], this.zzU, z4, z2, j, zzmcVar.zza(), zzmcVar.zzg.zza, this.zzo);
        zzneVar.zzy(11, new zzli(this), zzmcVar);
        if (z3 && z2) {
            zzneVar.zzv();
        }
    }

    private final void zzat(boolean z) {
        zzmc zzmcVarZzk = this.zzs.zzk();
        zzxk zzxkVar = zzmcVarZzk == null ? this.zzH.zzb : zzmcVarZzk.zzg.zza;
        boolean zEquals = this.zzH.zzk.equals(zzxkVar);
        if (!zEquals) {
            this.zzH = this.zzH.zzh(zzxkVar);
        }
        zzms zzmsVar = this.zzH;
        zzmsVar.zzq = zzmcVarZzk == null ? zzmsVar.zzs : zzmcVarZzk.zzf();
        this.zzH.zzr = zzau();
        if ((!zEquals || z) && zzmcVarZzk != null && zzmcVarZzk.zze) {
            zzax(zzmcVarZzk.zzg.zza, zzmcVarZzk.zzq(), zzmcVarZzk.zzr());
        }
    }

    private final long zzau() {
        return zzav(this.zzH.zzq);
    }

    private final long zzav(long j) {
        zzmc zzmcVarZzk = this.zzs.zzk();
        if (zzmcVarZzk == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzU - zzmcVarZzk.zza()));
    }

    private final long zzaw(zzmc zzmcVar) {
        zzgtj.zzi(zzmcVar.zze);
        return (long) ((zzmcVar.zzc() - this.zzU) / this.zzo.zzj().zzb);
    }

    private final void zzax(zzxk zzxkVar, zzzn zzznVar, zzabi zzabiVar) {
        long jZza;
        long jZza2;
        zzmf zzmfVar = this.zzs;
        zzmc zzmcVarZzk = zzmfVar.zzk();
        zzmcVarZzk.getClass();
        if (zzmcVarZzk == zzmfVar.zzm()) {
            jZza = this.zzU;
            jZza2 = zzmcVarZzk.zza();
        } else {
            jZza = this.zzU - zzmcVarZzk.zza();
            jZza2 = zzmcVarZzk.zzg.zzb;
        }
        this.zzg.zzb(new zzlx(this.zzv, this.zzH.zza, zzxkVar, jZza - jZza2, zzav(zzmcVarZzk.zzf()), this.zzo.zzj().zzb, this.zzH.zzl, this.zzM, zzP(this.zzH.zza, zzmcVarZzk.zzg.zza) ? this.zzae.zze() : C.TIME_UNSET, this.zzN), zzznVar, zzabiVar.zzc);
    }

    private final boolean zzay() {
        zzms zzmsVar = this.zzH;
        return zzmsVar.zzl && zzmsVar.zzn == 0;
    }

    private final void zzaz(int i) throws IOException, zzjk {
        zzne zzneVar = this.zzb[i];
        try {
            zzmc zzmcVarZzm = this.zzs.zzm();
            if (zzmcVarZzm == null) {
                throw null;
            }
            zzmc zzmcVar = zzmcVarZzm;
            zzneVar.zzu(zzmcVarZzm);
        } catch (IOException | RuntimeException e) {
            zzneVar.zze();
            throw e;
        }
    }

    static int zzr(zzbe zzbeVar, zzbd zzbdVar, int i, boolean z, Object obj, zzbf zzbfVar, zzbf zzbfVar2) {
        zzbf zzbfVar3 = zzbfVar;
        Object obj2 = zzbfVar3.zzb(zzbfVar3.zzo(obj, zzbdVar).zzc, zzbeVar, 0L).zzb;
        for (int i2 = 0; i2 < zzbfVar2.zza(); i2++) {
            if (zzbfVar2.zzb(i2, zzbeVar, 0L).zzb.equals(obj2)) {
                return i2;
            }
        }
        int iZze = zzbfVar3.zze(obj);
        int iZzc = zzbfVar3.zzc();
        int iZze2 = -1;
        int i3 = 0;
        while (i3 < iZzc && iZze2 == -1) {
            zzbf zzbfVar4 = zzbfVar3;
            int iZzl = zzbfVar4.zzl(iZze, zzbdVar, zzbeVar, i, z);
            if (iZzl == -1) {
                iZze2 = -1;
                break;
            }
            iZze2 = zzbfVar2.zze(zzbfVar4.zzf(iZzl));
            i3++;
            zzbfVar3 = zzbfVar4;
            iZze = iZzl;
        }
        if (iZze2 == -1) {
            return -1;
        }
        return zzbfVar2.zzd(iZze2, zzbdVar, false).zzc;
    }

    static final /* synthetic */ void zzz(zzmw zzmwVar) {
        try {
            zzaF(zzmwVar);
        } catch (zzjk e) {
            zzeg.zzf("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:287:0x0616 A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:291:0x062d A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:293:0x0631 A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:295:0x0637  */
    /* JADX WARN: Code duplicated, block: B:296:0x0638 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:297:0x063a A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:299:0x0649 A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:301:0x064f A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:303:0x0659 A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, LOOP:7: B:302:0x0657->B:303:0x0659, LOOP_END, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:309:0x0671  */
    /* JADX WARN: Code duplicated, block: B:312:0x0676 A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:314:0x067e A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:332:0x06c7 A[Catch: RuntimeException -> 0x0717, zzjk -> 0x0719, IOException -> 0x0746, zzwk -> 0x074d, zzhq -> 0x0754, zzat -> 0x075b, zzuf -> 0x0771, TryCatch #24 {zzjk -> 0x0719, RuntimeException -> 0x0717, blocks: (B:243:0x0531, B:247:0x053a, B:249:0x053e, B:250:0x0549, B:252:0x054f, B:307:0x066b, B:310:0x0672, B:312:0x0676, B:314:0x067e, B:315:0x0681, B:316:0x0684, B:318:0x068a, B:320:0x0693, B:322:0x069d, B:324:0x06a3, B:326:0x06a9, B:333:0x06cb, B:335:0x06d1, B:339:0x06db, B:349:0x06f5, B:346:0x06ee, B:348:0x06f2, B:327:0x06b0, B:330:0x06be, B:331:0x06c6, B:332:0x06c7, B:254:0x055c, B:256:0x0562, B:258:0x0566, B:285:0x0609, B:287:0x0616, B:289:0x0626, B:291:0x062d, B:293:0x0631, B:297:0x063a, B:299:0x0649, B:301:0x064f, B:303:0x0659, B:304:0x065e, B:305:0x0663, B:306:0x0668, B:261:0x0573, B:263:0x0577, B:265:0x0589, B:267:0x0594, B:269:0x059e, B:273:0x05a7, B:275:0x05b1, B:281:0x05bc, B:352:0x06ff, B:356:0x0708), top: B:450:0x0012 }] */
    /* JADX WARN: Code duplicated, block: B:338:0x06da  */
    /* JADX WARN: Code duplicated, block: B:370:0x072e  */
    /* JADX WARN: Code duplicated, block: B:381:0x0761  */
    /* JADX WARN: Code duplicated, block: B:383:0x0765  */
    /* JADX WARN: Code duplicated, block: B:384:0x0768  */
    /* JADX WARN: Code duplicated, block: B:385:0x076b  */
    /* JADX WARN: Code duplicated, block: B:419:0x07fa  */
    /* JADX WARN: Code duplicated, block: B:421:0x07fe  */
    /* JADX WARN: Code duplicated, block: B:424:0x0808  */
    /* JADX WARN: Code duplicated, block: B:426:0x0814 A[LOOP:9: B:426:0x0814->B:428:0x081e, LOOP_START] */
    /* JADX WARN: Code duplicated, block: B:428:0x081e A[LOOP:9: B:426:0x0814->B:428:0x081e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:432:0x0847  */
    /* JADX WARN: Code duplicated, block: B:463:0x0684 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:465:0x0681 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:301:0x064f, please report this as an issue */
    /* JADX WARN: Not initialized variable reg: 20, insn: 0x071a: MOVE (r11 I:??[OBJECT, ARRAY]) = (r20 I:??[OBJECT, ARRAY]), block:B:361:0x071a */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        int i;
        int i2;
        zzjk zzjkVar;
        boolean z;
        int i3;
        zzmf zzmfVar;
        zzxk zzxkVar;
        zzmc zzmcVarZzn;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        zzmc zzmcVarZzm;
        int i4;
        boolean zZzi;
        boolean z5;
        int i5;
        int i6;
        zzne[] zzneVarArr;
        zzms zzmsVar;
        int i7;
        String str2 = "Playback error";
        try {
            try {
                try {
                    zzd zzdVar = null;
                    try {
                        switch (message.what) {
                            case 1:
                                zzE(message.arg1 != 0, message.arg2 >> 4, true, message.arg2 & 15);
                                z = true;
                                zzC();
                                return z;
                            case 2:
                                z2 = true;
                                boolean z6 = false;
                                try {
                                    long jUptimeMillis = SystemClock.uptimeMillis();
                                    this.zzi.zzk(2);
                                    boolean z7 = this.zzA;
                                    if (!z7) {
                                        zzai();
                                    }
                                    int i8 = this.zzH.zze;
                                    if (i8 != 1 && i8 != 4) {
                                        if (z7) {
                                            zzai();
                                        }
                                        zzmf zzmfVar2 = this.zzs;
                                        zzmc zzmcVarZzm2 = zzmfVar2.zzm();
                                        if (zzmcVarZzm2 != null) {
                                            Trace.beginSection("doSomeWork");
                                            zzL();
                                            if (zzmcVarZzm2.zze) {
                                                this.zzV = zzfl.zzs(SystemClock.elapsedRealtime());
                                                zzmcVarZzm2.zza.zzf(this.zzH.zzs - this.zzn, false);
                                                z3 = true;
                                                z4 = true;
                                                int i9 = 0;
                                                while (true) {
                                                    zzne[] zzneVarArr2 = this.zzb;
                                                    if (i9 < 2) {
                                                        zzne zzneVar = zzneVarArr2[i9];
                                                        if (zzneVar.zzd() == 0) {
                                                            zzN(i9, z6);
                                                            i7 = i9;
                                                        } else {
                                                            int i10 = i9;
                                                            zzneVar.zzs(this.zzU, this.zzV);
                                                            z3 = z3 && zzneVar.zzo();
                                                            boolean zZzt = zzneVar.zzt(zzmcVarZzm2);
                                                            i7 = i10;
                                                            zzN(i7, zZzt);
                                                            z4 = z4 && zZzt;
                                                            if (!zZzt) {
                                                                zzaz(i7);
                                                            }
                                                        }
                                                        i9 = i7 + 1;
                                                        z6 = false;
                                                    }
                                                }
                                            } else {
                                                zzmcVarZzm2.zza.zzc();
                                                z3 = true;
                                                z4 = true;
                                            }
                                            long j = zzmcVarZzm2.zzg.zzf;
                                            long j2 = C.TIME_UNSET;
                                            if (z3 && zzmcVarZzm2.zze) {
                                                if (j == C.TIME_UNSET || j <= this.zzH.zzs) {
                                                    if (this.zzL) {
                                                        this.zzL = false;
                                                        zzE(false, this.zzH.zzn, false, 5);
                                                    }
                                                    if (zzmcVarZzm2.zzg.zzk) {
                                                        zzB(4);
                                                        zzK();
                                                        j2 = -9223372036854775807L;
                                                    }
                                                }
                                                if (this.zzH.zze == 2) {
                                                    i6 = 0;
                                                    while (true) {
                                                        zzneVarArr = this.zzb;
                                                        if (i6 < 2) {
                                                            if (zzneVarArr[i6].zzp(zzmcVarZzm2)) {
                                                                zzaz(i6);
                                                            }
                                                            i6++;
                                                        } else {
                                                            zzmsVar = this.zzH;
                                                            if (!zzmsVar.zzg || zzmsVar.zzr >= 500000 || !zzaG(zzmfVar2.zzk()) || !zzay()) {
                                                                this.zzZ = j2;
                                                            } else if (this.zzZ == j2) {
                                                                this.zzZ = SystemClock.elapsedRealtime();
                                                            } else if (SystemClock.elapsedRealtime() - this.zzZ >= 4000) {
                                                                throw new zzfd(0, 4000);
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    this.zzZ = j2;
                                                }
                                                if (zzay() || this.zzH.zze != 3) {
                                                    z5 = false;
                                                } else {
                                                    z5 = true;
                                                }
                                                boolean z8 = this.zzH.zzp;
                                                i5 = this.zzH.zze;
                                                if (i5 != 4 && (z5 || i5 == 2 || (i5 == 3 && this.zzS != 0))) {
                                                    zzQ(jUptimeMillis);
                                                }
                                                Trace.endSection();
                                                z = true;
                                                zzC();
                                                return z;
                                            }
                                            zzms zzmsVar2 = this.zzH;
                                            if (zzmsVar2.zze != 2) {
                                                j2 = -9223372036854775807L;
                                                z4 = z4;
                                                if (this.zzH.zze == 3) {
                                                    if (this.zzS == 0) {
                                                        if (!zzae()) {
                                                            zzaD(zzay(), false);
                                                            zzB(2);
                                                            if (this.zzM) {
                                                                for (zzmcVarZzm = zzmfVar2.zzm(); zzmcVarZzm != null; zzmcVarZzm = zzmcVarZzm.zzp()) {
                                                                    for (zzaba zzabaVar : zzmcVarZzm.zzr().zzc) {
                                                                    }
                                                                }
                                                                this.zzae.zzc();
                                                            }
                                                            zzK();
                                                        }
                                                    } else if (!z4) {
                                                        zzaD(zzay(), false);
                                                        zzB(2);
                                                        if (this.zzM) {
                                                            while (zzmcVarZzm != null) {
                                                                while (i4 < r7) {
                                                                }
                                                            }
                                                            this.zzae.zzc();
                                                        }
                                                        zzK();
                                                    }
                                                }
                                            } else {
                                                if (this.zzS == 0) {
                                                    zZzi = zzae();
                                                } else if (z4) {
                                                    if (zzmsVar2.zzg) {
                                                        zzmc zzmcVarZzm3 = zzmfVar2.zzm();
                                                        long jZze = zzP(this.zzH.zza, zzmcVarZzm3.zzg.zza) ? this.zzae.zze() : -9223372036854775807L;
                                                        zzmc zzmcVarZzk = zzmfVar2.zzk();
                                                        boolean z9 = zzmcVarZzk.zzd() && zzmcVarZzk.zzg.zzk;
                                                        boolean z10 = zzmcVarZzk.zzg.zza.zzb() && !zzmcVarZzk.zze;
                                                        if (!z9 && !z10) {
                                                            zZzi = this.zzg.zzi(new zzlx(this.zzv, this.zzH.zza, zzmcVarZzm3.zzg.zza, this.zzU - zzmcVarZzm3.zza(), zzav(zzmcVarZzk.zzf()), this.zzo.zzj().zzb, this.zzH.zzl, this.zzM, jZze, this.zzN));
                                                        }
                                                        zzB(3);
                                                        this.zzY = null;
                                                        if (zzay()) {
                                                            zzaD(false, false);
                                                            this.zzo.zza();
                                                            zzJ();
                                                        }
                                                    }
                                                    j2 = -9223372036854775807L;
                                                    zzB(3);
                                                    this.zzY = null;
                                                    if (zzay()) {
                                                        zzaD(false, false);
                                                        this.zzo.zza();
                                                        zzJ();
                                                    }
                                                } else {
                                                    j2 = -9223372036854775807L;
                                                    z4 = z4;
                                                    if (this.zzH.zze == 3) {
                                                        if (this.zzS == 0) {
                                                            if (!zzae()) {
                                                                zzaD(zzay(), false);
                                                                zzB(2);
                                                                if (this.zzM) {
                                                                    while (zzmcVarZzm != null) {
                                                                        while (i4 < r7) {
                                                                        }
                                                                    }
                                                                    this.zzae.zzc();
                                                                }
                                                                zzK();
                                                            }
                                                        } else if (!z4) {
                                                            zzaD(zzay(), false);
                                                            zzB(2);
                                                            if (this.zzM) {
                                                                while (zzmcVarZzm != null) {
                                                                    while (i4 < r7) {
                                                                    }
                                                                }
                                                                this.zzae.zzc();
                                                            }
                                                            zzK();
                                                        }
                                                    }
                                                }
                                                if (zZzi) {
                                                    zzB(3);
                                                    this.zzY = null;
                                                    if (zzay()) {
                                                        zzaD(false, false);
                                                        this.zzo.zza();
                                                        zzJ();
                                                    }
                                                } else if (this.zzH.zze == 3) {
                                                    if (this.zzS == 0) {
                                                        if (!zzae()) {
                                                            zzaD(zzay(), false);
                                                            zzB(2);
                                                            if (this.zzM) {
                                                                while (zzmcVarZzm != null) {
                                                                    while (i4 < r7) {
                                                                    }
                                                                }
                                                                this.zzae.zzc();
                                                            }
                                                            zzK();
                                                        }
                                                    } else if (!z4) {
                                                        zzaD(zzay(), false);
                                                        zzB(2);
                                                        if (this.zzM) {
                                                            while (zzmcVarZzm != null) {
                                                                while (i4 < r7) {
                                                                }
                                                            }
                                                            this.zzae.zzc();
                                                        }
                                                        zzK();
                                                    }
                                                }
                                            }
                                            if (this.zzH.zze == 2) {
                                                i6 = 0;
                                                while (true) {
                                                    zzneVarArr = this.zzb;
                                                    if (i6 < 2) {
                                                        if (zzneVarArr[i6].zzp(zzmcVarZzm2)) {
                                                            zzaz(i6);
                                                        }
                                                        i6++;
                                                    } else {
                                                        zzmsVar = this.zzH;
                                                        if (!zzmsVar.zzg) {
                                                            this.zzZ = j2;
                                                        } else {
                                                            this.zzZ = j2;
                                                        }
                                                    }
                                                }
                                            } else {
                                                this.zzZ = j2;
                                            }
                                            if (zzay()) {
                                                z5 = false;
                                            } else {
                                                z5 = false;
                                            }
                                            boolean z11 = this.zzH.zzp;
                                            i5 = this.zzH.zze;
                                            if (i5 != 4) {
                                                zzQ(jUptimeMillis);
                                            }
                                            Trace.endSection();
                                            z = true;
                                            zzC();
                                            return z;
                                        }
                                        zzQ(jUptimeMillis);
                                    }
                                    z = z2;
                                } catch (zzjk e) {
                                    e = e;
                                    if (e.zzc == 1 && (zzmcVarZzn = this.zzs.zzn()) != null && e.zzh == null) {
                                        e = e.zzd(zzmcVarZzn.zzg.zza);
                                    }
                                    if (e.zzc == 1 || (zzxkVar = e.zzh) == null) {
                                        zzjkVar = this.zzY;
                                        if (zzjkVar != null) {
                                            zzjkVar.addSuppressed(e);
                                            e = this.zzY;
                                        }
                                        if (e.zzc == 1) {
                                            zzmfVar = this.zzs;
                                            if (zzmfVar.zzm() != zzmfVar.zzn()) {
                                                while (zzmfVar.zzm() != zzmfVar.zzn()) {
                                                    zzmfVar.zzr();
                                                }
                                                zzmc zzmcVarZzm4 = zzmfVar.zzm();
                                                zzmcVarZzm4.getClass();
                                                zzC();
                                                zzmd zzmdVar = zzmcVarZzm4.zzg;
                                                zzxk zzxkVar2 = zzmdVar.zza;
                                                long j3 = zzmdVar.zzb;
                                                this.zzH = zzap(zzxkVar2, j3, zzmdVar.zzd, j3, true, 0);
                                            }
                                        }
                                        if (e.zzi || !(this.zzY == null || (i3 = e.zza) == 5004 || i3 == 5003)) {
                                            zzeg.zzf("ExoPlayerImplInternal", str2, e);
                                            z = true;
                                            zzW(true, false);
                                            this.zzH = this.zzH.zzf(e);
                                        } else {
                                            zzeg.zzd("ExoPlayerImplInternal", "Recoverable renderer error", e);
                                            if (this.zzY == null) {
                                                this.zzY = e;
                                            }
                                            zzdz zzdzVar = this.zzi;
                                            zzdzVar.zzg(zzdzVar.zzd(25, e));
                                            z = true;
                                        }
                                    } else {
                                        int i11 = e.zze;
                                        zzmf zzmfVar3 = this.zzs;
                                        if (zzmfVar3.zzo() != null && zzmfVar3.zzo().zzg.zza.equals(zzxkVar) && this.zzb[i11].zzq(zzmfVar3.zzo())) {
                                            this.zzac = true;
                                            zzab();
                                            zzmc zzmcVarZzo = zzmfVar3.zzo();
                                            zzmc zzmcVarZzm5 = zzmfVar3.zzm();
                                            if (zzmfVar3.zzm() != zzmcVarZzo) {
                                                while (zzmcVarZzm5 != null && zzmcVarZzm5.zzp() != zzmcVarZzo) {
                                                    zzmcVarZzm5 = zzmcVarZzm5.zzp();
                                                }
                                            }
                                            zzmfVar3.zzs(zzmcVarZzm5);
                                            if (this.zzH.zze != 4) {
                                                zzan();
                                                this.zzi.zzh(2);
                                            }
                                        } else {
                                            zzjkVar = this.zzY;
                                            if (zzjkVar != null) {
                                                zzjkVar.addSuppressed(e);
                                                e = this.zzY;
                                            }
                                            if (e.zzc == 1) {
                                                zzmfVar = this.zzs;
                                                if (zzmfVar.zzm() != zzmfVar.zzn()) {
                                                    while (zzmfVar.zzm() != zzmfVar.zzn()) {
                                                        zzmfVar.zzr();
                                                    }
                                                    zzmc zzmcVarZzm6 = zzmfVar.zzm();
                                                    zzmcVarZzm6.getClass();
                                                    zzC();
                                                    zzmd zzmdVar2 = zzmcVarZzm6.zzg;
                                                    zzxk zzxkVar3 = zzmdVar2.zza;
                                                    long j4 = zzmdVar2.zzb;
                                                    this.zzH = zzap(zzxkVar3, j4, zzmdVar2.zzd, j4, true, 0);
                                                }
                                            }
                                            if (e.zzi) {
                                            }
                                            zzeg.zzf("ExoPlayerImplInternal", str2, e);
                                            z = true;
                                            zzW(true, false);
                                            this.zzH = this.zzH.zzf(e);
                                        }
                                        z = true;
                                    }
                                }
                                zzC();
                                return z;
                            case 3:
                                z2 = true;
                                zzR((zzlt) message.obj);
                                z = z2;
                                zzC();
                                return z;
                            case 4:
                                z2 = true;
                                zzM((zzav) message.obj);
                                zzal(this.zzo.zzj(), true);
                                z = z2;
                                zzC();
                                return z;
                            case 5:
                                z2 = true;
                                this.zzB = (zzni) message.obj;
                                z = z2;
                                zzC();
                                return z;
                            case 6:
                                z2 = true;
                                zzW(false, true);
                                z = z2;
                                zzC();
                                return z;
                            case 7:
                                zzds zzdsVar = (zzds) message.obj;
                                try {
                                    zzX(true, false, true, false);
                                    int i12 = 0;
                                    while (true) {
                                        zzne[] zzneVarArr3 = this.zzb;
                                        if (i12 >= 2) {
                                            this.zzg.zzd(this.zzv);
                                            this.zzz.zzd();
                                            this.zze.zzb();
                                            zzB(1);
                                            return true;
                                        }
                                        this.zzc[i12].zzw();
                                        zzneVarArr3[i12].zzI();
                                        i12++;
                                    }
                                } finally {
                                    this.zzi.zzl(null);
                                    this.zzj.zzb();
                                    zzdsVar.zza();
                                }
                                break;
                            case 8:
                                try {
                                    zzxi zzxiVar = (zzxi) message.obj;
                                    zzmf zzmfVar4 = this.zzs;
                                    if (zzmfVar4.zzd(zzxiVar)) {
                                        zzmc zzmcVarZzk2 = zzmfVar4.zzk();
                                        if (zzmcVarZzk2 == null) {
                                            throw null;
                                        }
                                        zzmc zzmcVar = zzmcVarZzk2;
                                        if (!zzmcVarZzk2.zze) {
                                            float f = this.zzo.zzj().zzb;
                                            zzms zzmsVar3 = this.zzH;
                                            zzmcVarZzk2.zzh(f, zzmsVar3.zza, zzmsVar3.zzl);
                                        }
                                        zzax(zzmcVarZzk2.zzg.zza, zzmcVarZzk2.zzq(), zzmcVarZzk2.zzr());
                                        if (zzmcVarZzk2 == zzmfVar4.zzm()) {
                                            zzU(zzmcVarZzk2.zzg.zzb, true);
                                            zzaq();
                                            zzmcVarZzk2.zzh = true;
                                            zzms zzmsVar4 = this.zzH;
                                            try {
                                                zzxk zzxkVar4 = zzmsVar4.zzb;
                                                long j5 = zzmcVarZzk2.zzg.zzb;
                                                z2 = true;
                                                this.zzH = zzap(zzxkVar4, j5, zzmsVar4.zzc, j5, false, 5);
                                            } catch (zzat e2) {
                                                e = e2;
                                                if (e.zzb == 1) {
                                                    i2 = 1000;
                                                } else if (true != e.zza) {
                                                    i2 = 3003;
                                                } else {
                                                    i2 = 3001;
                                                }
                                                zzA(e, i2);
                                                z = true;
                                            } catch (zzhq e3) {
                                                e = e3;
                                                zzA(e, e.zza);
                                                z = true;
                                            } catch (zzjk e4) {
                                                e = e4;
                                                if (e.zzc == 1) {
                                                    e = e.zzd(zzmcVarZzn.zzg.zza);
                                                }
                                                if (e.zzc == 1) {
                                                    zzjkVar = this.zzY;
                                                    if (zzjkVar != null) {
                                                        zzjkVar.addSuppressed(e);
                                                        e = this.zzY;
                                                    }
                                                    if (e.zzc == 1) {
                                                        zzmfVar = this.zzs;
                                                        if (zzmfVar.zzm() != zzmfVar.zzn()) {
                                                            while (zzmfVar.zzm() != zzmfVar.zzn()) {
                                                                zzmfVar.zzr();
                                                            }
                                                            zzmc zzmcVarZzm7 = zzmfVar.zzm();
                                                            zzmcVarZzm7.getClass();
                                                            zzC();
                                                            zzmd zzmdVar3 = zzmcVarZzm7.zzg;
                                                            zzxk zzxkVar5 = zzmdVar3.zza;
                                                            long j6 = zzmdVar3.zzb;
                                                            this.zzH = zzap(zzxkVar5, j6, zzmdVar3.zzd, j6, true, 0);
                                                        }
                                                    }
                                                    if (e.zzi) {
                                                    }
                                                    zzeg.zzf("ExoPlayerImplInternal", str2, e);
                                                    z = true;
                                                    zzW(true, false);
                                                    this.zzH = this.zzH.zzf(e);
                                                } else {
                                                    zzjkVar = this.zzY;
                                                    if (zzjkVar != null) {
                                                        zzjkVar.addSuppressed(e);
                                                        e = this.zzY;
                                                    }
                                                    if (e.zzc == 1) {
                                                        zzmfVar = this.zzs;
                                                        if (zzmfVar.zzm() != zzmfVar.zzn()) {
                                                            while (zzmfVar.zzm() != zzmfVar.zzn()) {
                                                                zzmfVar.zzr();
                                                            }
                                                            zzmc zzmcVarZzm8 = zzmfVar.zzm();
                                                            zzmcVarZzm8.getClass();
                                                            zzC();
                                                            zzmd zzmdVar4 = zzmcVarZzm8.zzg;
                                                            zzxk zzxkVar6 = zzmdVar4.zza;
                                                            long j7 = zzmdVar4.zzb;
                                                            this.zzH = zzap(zzxkVar6, j7, zzmdVar4.zzd, j7, true, 0);
                                                        }
                                                    }
                                                    if (e.zzi) {
                                                    }
                                                    zzeg.zzf("ExoPlayerImplInternal", str2, e);
                                                    z = true;
                                                    zzW(true, false);
                                                    this.zzH = this.zzH.zzf(e);
                                                }
                                            } catch (zzuf e5) {
                                                e = e5;
                                                zzA(e, e.zza);
                                                z = true;
                                            } catch (zzwk e6) {
                                                e = e6;
                                                zzA(e, 1002);
                                                z = true;
                                            } catch (IOException e7) {
                                                e = e7;
                                                zzA(e, 2000);
                                                z = true;
                                            } catch (RuntimeException e8) {
                                                e = e8;
                                                if (e instanceof IllegalStateException) {
                                                    i = 1004;
                                                } else {
                                                    i = 1004;
                                                }
                                                zzjk zzjkVarZzc = zzjk.zzc(e, i);
                                                zzeg.zzf("ExoPlayerImplInternal", "Playback error", zzjkVarZzc);
                                                zzW(true, false);
                                                this.zzH = this.zzH.zzf(zzjkVarZzc);
                                                z = true;
                                            }
                                        } else {
                                            z2 = true;
                                        }
                                        zzan();
                                        break;
                                        if (e.zzb == 1) {
                                            i2 = 1000;
                                        } else if (true != e.zza) {
                                            i2 = 3003;
                                        } else {
                                            i2 = 3001;
                                        }
                                        zzA(e, i2);
                                        z = true;
                                        zzC();
                                        return z;
                                    }
                                    z2 = true;
                                    zzmc zzmcVarZzu = zzmfVar4.zzu(zzxiVar);
                                    if (zzmcVarZzu != null) {
                                        zzgtj.zzi(!zzmcVarZzu.zze);
                                        float f2 = this.zzo.zzj().zzb;
                                        zzms zzmsVar5 = this.zzH;
                                        zzmcVarZzu.zzh(f2, zzmsVar5.zza, zzmsVar5.zzl);
                                        if (zzmfVar4.zze(zzxiVar)) {
                                            zzaj();
                                        }
                                    }
                                    z = z2;
                                } catch (zzat e9) {
                                    e = e9;
                                } catch (zzhq e10) {
                                    e = e10;
                                } catch (zzjk e11) {
                                    e = e11;
                                } catch (zzuf e12) {
                                    e = e12;
                                } catch (zzwk e13) {
                                    e = e13;
                                } catch (IOException e14) {
                                    e = e14;
                                } catch (RuntimeException e15) {
                                    e = e15;
                                }
                                zzC();
                                return z;
                            case 9:
                                zzxi zzxiVar2 = (zzxi) message.obj;
                                zzmf zzmfVar5 = this.zzs;
                                if (zzmfVar5.zzd(zzxiVar2)) {
                                    zzmfVar5.zzf(this.zzU);
                                    zzan();
                                } else if (zzmfVar5.zze(zzxiVar2)) {
                                    zzaj();
                                }
                                z = true;
                                zzC();
                                return z;
                            case 10:
                                zzad();
                                z = true;
                                zzC();
                                return z;
                            case 11:
                                int i13 = message.arg1;
                                this.zzP = i13;
                                int iZza = this.zzs.zza(this.zzH.zza, i13);
                                if ((iZza & 1) != 0) {
                                    zzI(true);
                                } else if ((iZza & 2) != 0) {
                                    zzab();
                                }
                                zzat(false);
                                z = true;
                                zzC();
                                return z;
                            case 12:
                                boolean z12 = message.arg1 != 0;
                                this.zzQ = z12;
                                int iZzb = this.zzs.zzb(this.zzH.zza, z12);
                                if ((iZzb & 1) != 0) {
                                    zzI(true);
                                } else if ((iZzb & 2) != 0) {
                                    zzab();
                                }
                                zzat(false);
                                z = true;
                                zzC();
                                return z;
                            case 13:
                                boolean z13 = message.arg1 != 0;
                                zzds zzdsVar2 = (zzds) message.obj;
                                if (this.zzR != z13) {
                                    this.zzR = z13;
                                    if (!z13) {
                                        zzne[] zzneVarArr4 = this.zzb;
                                        for (int i14 = 0; i14 < 2; i14++) {
                                            zzneVarArr4[i14].zzG();
                                        }
                                    }
                                }
                                if (zzdsVar2 != null) {
                                    zzdsVar2.zza();
                                }
                                z = true;
                                zzC();
                                return z;
                            case 14:
                                zzmw zzmwVar = (zzmw) message.obj;
                                if (zzmwVar.zzf() == this.zzk) {
                                    zzaF(zzmwVar);
                                    int i15 = this.zzH.zze;
                                    if (i15 == 3 || i15 == 2) {
                                        this.zzi.zzh(2);
                                    }
                                } else {
                                    this.zzi.zzd(15, zzmwVar).zza();
                                }
                                z = true;
                                zzC();
                                return z;
                            case 15:
                                final zzmw zzmwVar2 = (zzmw) message.obj;
                                Looper looperZzf = zzmwVar2.zzf();
                                if (looperZzf.getThread().isAlive()) {
                                    this.zzq.zzd(looperZzf, null).zzm(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzlm
                                        @Override // java.lang.Runnable
                                        public final /* synthetic */ void run() {
                                            zzlu.zzz(zzmwVar2);
                                        }
                                    });
                                } else {
                                    zzeg.zzc("TAG", "Trying to send message on a dead thread.");
                                    zzmwVar2.zzi(false);
                                }
                                z = true;
                                zzC();
                                return z;
                            case 16:
                                zzal((zzav) message.obj, false);
                                z = true;
                                zzC();
                                return z;
                            case 17:
                                zzlo zzloVar = (zzlo) message.obj;
                                this.zzI.zza(1);
                                if (zzloVar.zzb() != -1) {
                                    this.zzT = new zzlt(new zzmy(zzloVar.zza(), zzloVar.zzd()), zzloVar.zzb(), zzloVar.zzc());
                                }
                                zzaf(this.zzt.zzl(zzloVar.zza(), zzloVar.zzd()), false);
                                z = true;
                                zzC();
                                return z;
                            case 18:
                                zzlo zzloVar2 = (zzlo) message.obj;
                                int iZzc = message.arg1;
                                this.zzI.zza(1);
                                zzmr zzmrVar = this.zzt;
                                if (iZzc == -1) {
                                    iZzc = zzmrVar.zzc();
                                }
                                zzaf(zzmrVar.zzm(iZzc, zzloVar2.zza(), zzloVar2.zzd()), false);
                                z = true;
                                zzC();
                                return z;
                            case 19:
                                zzlp zzlpVar = (zzlp) message.obj;
                                this.zzI.zza(1);
                                zzmr zzmrVar2 = this.zzt;
                                int i16 = zzlpVar.zza;
                                int i17 = zzlpVar.zzb;
                                int i18 = zzlpVar.zzc;
                                zzzf zzzfVar = zzlpVar.zzd;
                                zzaf(zzmrVar2.zzo(0, 0, 0, null), false);
                                z = true;
                                zzC();
                                return z;
                            case 20:
                                int i19 = message.arg1;
                                int i20 = message.arg2;
                                zzzf zzzfVar2 = (zzzf) message.obj;
                                this.zzI.zza(1);
                                zzaf(this.zzt.zzn(i19, i20, zzzfVar2), false);
                                z = true;
                                zzC();
                                return z;
                            case 21:
                                zzzf zzzfVar3 = (zzzf) message.obj;
                                this.zzI.zza(1);
                                zzaf(this.zzt.zzp(zzzfVar3), false);
                                z = true;
                                zzC();
                                return z;
                            case 22:
                                zzaf(this.zzt.zzh(), true);
                                z = true;
                                zzC();
                                return z;
                            case 23:
                                this.zzK = message.arg1 != 0;
                                zzak();
                                if (this.zzL) {
                                    zzmf zzmfVar6 = this.zzs;
                                    if (zzmfVar6.zzn() != zzmfVar6.zzm()) {
                                        zzI(true);
                                        zzat(false);
                                    }
                                }
                                z = true;
                                zzC();
                                return z;
                            case 24:
                            default:
                                return false;
                            case 25:
                                zzac();
                                z = true;
                                zzC();
                                return z;
                            case 26:
                                zzac();
                                z = true;
                                zzC();
                                return z;
                            case 27:
                                int i21 = message.arg1;
                                int i22 = message.arg2;
                                List list = (List) message.obj;
                                this.zzI.zza(1);
                                zzaf(this.zzt.zza(i21, i22, list), false);
                                z = true;
                                zzC();
                                return z;
                            case 28:
                                zzju zzjuVar = (zzju) message.obj;
                                this.zzaa = zzjuVar;
                                this.zzs.zzc(this.zzH.zza, zzjuVar);
                                z = true;
                                zzC();
                                return z;
                            case 29:
                                this.zzI.zza(1);
                                zzX(false, false, false, true);
                                this.zzg.zza(this.zzv);
                                zzB(true != this.zzH.zza.zzg() ? 2 : 4);
                                zzF();
                                this.zzt.zzd(this.zzh.zze());
                                this.zzi.zzh(2);
                                z = true;
                                zzC();
                                return z;
                            case 30:
                                Pair pair = (Pair) message.obj;
                                Object obj = pair.first;
                                zzds zzdsVar3 = (zzds) pair.second;
                                zzne[] zzneVarArr5 = this.zzb;
                                for (int i23 = 0; i23 < 2; i23++) {
                                    zzneVarArr5[i23].zzJ(obj);
                                }
                                int i24 = this.zzH.zze;
                                if (i24 == 3 || i24 == 2) {
                                    this.zzi.zzh(2);
                                }
                                if (zzdsVar3 != null) {
                                    zzdsVar3.zza();
                                }
                                z = true;
                                zzC();
                                return z;
                            case 31:
                                zzd zzdVar2 = (zzd) message.obj;
                                int i25 = message.arg1;
                                this.zze.zze(zzdVar2);
                                zzcd zzcdVar = this.zzz;
                                if (i25 != 0) {
                                    zzdVar = zzdVar2;
                                }
                                zzcdVar.zzb(zzdVar);
                                zzF();
                                z = true;
                                zzC();
                                return z;
                            case 32:
                                zzD(((Float) message.obj).floatValue());
                                z = true;
                                zzC();
                                return z;
                            case 33:
                                int i26 = message.arg1;
                                zzms zzmsVar6 = this.zzH;
                                zzH(zzmsVar6.zzl, i26, zzmsVar6.zzn, zzmsVar6.zzm);
                                z = true;
                                zzC();
                                return z;
                            case 34:
                                zzD(this.zzad);
                                z = true;
                                zzC();
                                return z;
                            case 35:
                                zzadr zzadrVar = (zzadr) message.obj;
                                zzne[] zzneVarArr6 = this.zzb;
                                for (int i27 = 0; i27 < 2; i27++) {
                                    zzneVarArr6[i27].zzK(zzadrVar);
                                }
                                z = true;
                                zzC();
                                return z;
                            case 36:
                                boolean zBooleanValue = ((Boolean) message.obj).booleanValue();
                                if (!zBooleanValue) {
                                    if (this.zzF != null && this.zzE && !this.zzi.zzb(37)) {
                                        this.zzG++;
                                    }
                                    final int i28 = this.zzG;
                                    if (i28 > 0) {
                                        this.zzx.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzll
                                            @Override // java.lang.Runnable
                                            public final /* synthetic */ void run() {
                                                this.zza.zzv(i28);
                                            }
                                        });
                                    }
                                    this.zzG = 0;
                                    this.zzE = false;
                                    this.zzi.zzk(37);
                                    zzlt zzltVar = this.zzF;
                                    if (zzltVar != null) {
                                        zzR(zzltVar);
                                        this.zzF = null;
                                        this.zzE = false;
                                    }
                                }
                                this.zzD = zBooleanValue;
                                zzV();
                                z = true;
                                zzC();
                                return z;
                            case 37:
                                this.zzE = false;
                                zzlt zzltVar2 = this.zzF;
                                if (zzltVar2 != null) {
                                    zzR(zzltVar2);
                                    this.zzF = null;
                                }
                                z = true;
                                zzC();
                                return z;
                            case 38:
                                this.zzC = (zznh) message.obj;
                                zzV();
                                z = true;
                                zzC();
                                return z;
                        }
                    } catch (zzjk e16) {
                        e = e16;
                        str2 = str;
                    } catch (RuntimeException e17) {
                        e = e17;
                        if ((e instanceof IllegalStateException) || (e instanceof IllegalArgumentException)) {
                            i = 1004;
                        } else {
                            i = 1000;
                        }
                        zzjk zzjkVarZzc2 = zzjk.zzc(e, i);
                        zzeg.zzf("ExoPlayerImplInternal", "Playback error", zzjkVarZzc2);
                        zzW(true, false);
                        this.zzH = this.zzH.zzf(zzjkVarZzc2);
                    }
                } catch (zzat e18) {
                    e = e18;
                } catch (zzhq e19) {
                    e = e19;
                } catch (zzuf e20) {
                    e = e20;
                } catch (zzwk e21) {
                    e = e21;
                } catch (IOException e22) {
                    e = e22;
                }
            } catch (zzjk e23) {
                e = e23;
            }
        } catch (RuntimeException e24) {
            e = e24;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final void zza(float f) {
        this.zzi.zzh(34);
    }

    @Override // com.google.android.gms.internal.ads.zzcc
    public final void zzb(int i) {
        this.zzi.zze(33, i, 0).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzjh
    public final void zzc(zzav zzavVar) {
        this.zzi.zzd(16, zzavVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzadr
    public final void zzcS(long j, long j2, zzv zzvVar, MediaFormat mediaFormat) {
        if (this.zzE) {
            this.zzi.zzc(37).zza();
        }
    }

    public final void zzd() {
        this.zzi.zzc(29).zza();
    }

    public final void zze(boolean z, int i, int i2) {
        this.zzi.zze(1, z ? 1 : 0, (i2 << 4) | 1).zza();
    }

    public final void zzf(zzbf zzbfVar, int i, long j) {
        this.zzi.zzd(3, new zzlt(zzbfVar, i, j)).zza();
    }

    public final void zzg(zznh zznhVar) {
        this.zzi.zzd(38, zznhVar).zza();
    }

    public final void zzh() {
        this.zzi.zzc(6).zza();
    }

    public final void zzi(zzd zzdVar, boolean z) {
        this.zzi.zzf(31, 0, 0, zzdVar).zza();
    }

    public final void zzj(float f) {
        this.zzi.zzd(32, Float.valueOf(f)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzmu
    public final void zzk(zzmw zzmwVar) {
        if (!this.zzJ && this.zzk.getThread().isAlive()) {
            this.zzi.zzd(14, zzmwVar).zza();
        } else {
            zzeg.zzc("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            zzmwVar.zzi(false);
        }
    }

    public final boolean zzl(Object obj, long j) {
        if (this.zzJ || !this.zzk.getThread().isAlive()) {
            return true;
        }
        zzds zzdsVar = new zzds(this.zzq);
        this.zzi.zzd(30, new Pair(obj, zzdsVar)).zza();
        if (j != C.TIME_UNSET) {
            return zzdsVar.zze(j);
        }
        return true;
    }

    public final boolean zzm() {
        if (this.zzJ || !this.zzk.getThread().isAlive()) {
            return true;
        }
        this.zzJ = true;
        zzds zzdsVar = new zzds(this.zzq);
        this.zzi.zzd(7, zzdsVar).zza();
        return zzdsVar.zze(this.zzu);
    }

    public final Looper zzn() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzmq
    public final void zzo() {
        zzdz zzdzVar = this.zzi;
        zzdzVar.zzk(2);
        zzdzVar.zzh(22);
    }

    @Override // com.google.android.gms.internal.ads.zzxh
    public final void zzp(zzxi zzxiVar) {
        this.zzi.zzd(8, zzxiVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzabg
    public final void zzq() {
        this.zzi.zzh(10);
    }

    @Override // com.google.android.gms.internal.ads.zzzd
    public final /* bridge */ /* synthetic */ void zzs(zzze zzzeVar) {
        this.zzi.zzd(9, (zzxi) zzzeVar).zza();
    }

    final /* synthetic */ zzmc zzt(zzmd zzmdVar, long j) {
        zzabl zzablVarZze = this.zzg.zze(this.zzv);
        long j2 = this.zzaa.zzb;
        zzabi zzabiVar = this.zzf;
        zzmr zzmrVar = this.zzt;
        return new zzmc(this.zzc, j, this.zze, zzablVarZze, zzmrVar, zzmdVar, zzabiVar, C.TIME_UNSET);
    }

    final /* synthetic */ void zzu(int i, boolean z) {
        this.zzw.zzB(i, this.zzb[i].zze(), z);
    }

    final /* synthetic */ void zzv(int i) {
        this.zzw.zzW(i);
    }

    final /* synthetic */ zzdz zzx() {
        return this.zzi;
    }

    public final void zzy(List list, int i, long j, zzzf zzzfVar) {
        this.zzi.zzd(17, new zzlo(list, zzzfVar, i, j, null)).zza();
    }
}
