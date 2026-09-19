package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzlh extends zzf implements zzjv {
    public static final /* synthetic */ int zzd = 0;
    private final long zzA;
    private final zzdm zzB;
    private final zzfc zzC;
    private final zzlg zzD;
    private final zzjx zzE;
    private final zzjx zzF;
    private int zzG;
    private int zzH;
    private boolean zzI;
    private zznh zzJ;
    private zzni zzK;
    private zzju zzL;
    private zzax zzM;
    private zzan zzN;
    private Object zzO;
    private Surface zzP;
    private int zzQ;
    private zzeu zzR;
    private zzd zzS;
    private float zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private int zzX;
    private boolean zzY;
    private zzan zzZ;
    private zzms zzaa;
    private int zzab;
    private long zzac;
    private zzzf zzad;
    final zzabi zzb;
    final zzax zzc;
    private final zzds zze = new zzds(zzdo.zza);
    private final Context zzf;
    private final zzbb zzg;
    private final zzna[] zzh;
    private final zzna[] zzi;
    private final zzabh zzj;
    private final zzdz zzk;
    private final zzls zzl;
    private final zzlu zzm;
    private final zzef zzn;
    private final CopyOnWriteArraySet zzo;
    private final zzbd zzp;
    private final List zzq;
    private final boolean zzr;
    private final zznm zzs;
    private final Looper zzt;
    private final zzabq zzu;
    private final zzdo zzv;
    private final zzkd zzw;
    private final zzlc zzx;
    private final zzfr zzy;
    private final zzfs zzz;

    static {
        zzal.zzb("media3.exoplayer");
    }

    public zzlh(zzjt zzjtVar, zzbb zzbbVar) {
        try {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            String str = zzfl.zza;
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 36 + String.valueOf(str).length() + 1);
            sb.append("Init ");
            sb.append(hexString);
            sb.append(" [AndroidXMedia3/1.10.0-rc02] [");
            sb.append(str);
            sb.append("]");
            zzeg.zzb("ExoPlayerImpl", sb.toString());
            this.zzf = zzjtVar.zza.getApplicationContext();
            this.zzs = (zznm) zzjtVar.zzh.apply(zzjtVar.zzb);
            this.zzX = zzjtVar.zzj;
            this.zzS = zzjtVar.zzk;
            this.zzQ = zzjtVar.zzl;
            this.zzU = false;
            this.zzA = zzjtVar.zzq;
            zzkd zzkdVar = new zzkd(this, null);
            this.zzw = zzkdVar;
            this.zzx = new zzlc(null);
            zzna[] zznaVarArrZza = ((zznf) zzjtVar.zzc.zza()).zza(new Handler(zzjtVar.zzi), zzkdVar, zzkdVar, zzkdVar, zzkdVar);
            this.zzh = zznaVarArrZza;
            int length = zznaVarArrZza.length;
            this.zzi = new zzna[2];
            int i = 0;
            while (true) {
                zzna[] zznaVarArr = this.zzi;
                int length2 = zznaVarArr.length;
                if (i >= 2) {
                    break;
                }
                zzna zznaVar = this.zzh[i];
                zznaVarArr[i] = null;
                i++;
            }
            zzabh zzabhVar = (zzabh) zzjtVar.zze.zza();
            this.zzj = zzabhVar;
            zzabq zzabqVar = (zzabq) zzjtVar.zzg.zza();
            this.zzu = zzabqVar;
            this.zzr = zzjtVar.zzm;
            this.zzK = zzjtVar.zzn;
            this.zzJ = zzjtVar.zzo;
            Looper looper = zzjtVar.zzi;
            this.zzt = looper;
            zzdo zzdoVar = zzjtVar.zzb;
            this.zzv = zzdoVar;
            this.zzg = zzbbVar;
            this.zzn = new zzef(looper, zzdoVar, new zzeb() { // from class: com.google.android.gms.internal.ads.zzlb
                @Override // com.google.android.gms.internal.ads.zzeb
                public final /* synthetic */ void zza(Object obj, zzs zzsVar) {
                    this.zza.zzJ((zzaz) obj, zzsVar);
                }
            });
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzo = copyOnWriteArraySet;
            this.zzq = new ArrayList();
            this.zzad = new zzzf(0);
            this.zzL = zzju.zza;
            int length3 = this.zzh.length;
            zzabi zzabiVar = new zzabi(new zznd[2], new zzaba[2], zzbn.zza, null);
            this.zzb = zzabiVar;
            this.zzp = new zzbd();
            zzaw zzawVar = new zzaw();
            zzawVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzabhVar.zzd();
            zzawVar.zzb(29, true);
            zzawVar.zzb(23, false);
            zzawVar.zzb(25, false);
            zzawVar.zzb(33, false);
            zzawVar.zzb(26, false);
            zzawVar.zzb(34, false);
            zzax zzaxVarZze = zzawVar.zze();
            this.zzc = zzaxVarZze;
            zzaw zzawVar2 = new zzaw();
            zzawVar2.zzd(zzaxVarZze);
            zzawVar2.zza(4);
            zzawVar2.zza(10);
            this.zzM = zzawVar2.zze();
            this.zzk = zzdoVar.zzd(looper, null);
            zzls zzlsVar = new zzls() { // from class: com.google.android.gms.internal.ads.zzke
                @Override // com.google.android.gms.internal.ads.zzls
                public final /* synthetic */ void zza(zzlr zzlrVar) {
                    this.zza.zzK(zzlrVar);
                }
            };
            this.zzl = zzlsVar;
            this.zzaa = zzms.zza(zzabiVar);
            this.zzs.zzx(zzbbVar, looper);
            final zzqf zzqfVar = new zzqf(zzjtVar.zzx);
            zzlu zzluVar = new zzlu(this.zzf, this.zzh, this.zzi, zzabhVar, zzabiVar, (zzly) zzjtVar.zzf.zza(), zzabqVar, 0, false, this.zzs, this.zzK, zzjtVar.zzz, zzjtVar.zzp, false, false, looper, zzdoVar, zzlsVar, zzqfVar, null, this.zzL, this.zzx, zzjtVar.zzy);
            this.zzm = zzluVar;
            Looper looperZzn = zzluVar.zzn();
            this.zzT = 1.0f;
            zzan zzanVar = zzan.zza;
            this.zzN = zzanVar;
            this.zzZ = zzanVar;
            this.zzab = -1;
            int i2 = zzcz.zza;
            this.zzV = true;
            zze(this.zzs);
            zzabqVar.zzf(new Handler(looper), this.zzs);
            copyOnWriteArraySet.add(this.zzw);
            if (Build.VERSION.SDK_INT >= 31) {
                final Context context = this.zzf;
                final boolean z = zzjtVar.zzv;
                zzdoVar.zzd(zzluVar.zzn(), null).zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjw
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzqb zzqbVarZza = zzqb.zza(context);
                        if (zzqbVarZza == null) {
                            zzeg.zzc("ExoPlayerImpl", "MediaMetricsService unavailable.");
                            return;
                        }
                        if (z) {
                            this.zzD(zzqbVarZza);
                        }
                        zzqfVar.zzb(zzqbVarZza.zzb());
                    }
                });
            }
            zzdm zzdmVar = new zzdm(0, looperZzn, looper, zzdoVar, new zzdl() { // from class: com.google.android.gms.internal.ads.zzkp
                @Override // com.google.android.gms.internal.ads.zzdl
                public final /* synthetic */ void zza(Object obj, Object obj2) {
                    int iIntValue = ((Integer) obj2).intValue();
                    this.zza.zzL(((Integer) obj).intValue(), iIntValue);
                }
            });
            this.zzB = zzdmVar;
            zzdmVar.zzd(new Runnable() { // from class: com.google.android.gms.internal.ads.zzku
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzM();
                }
            });
            new zzbz(zzjtVar.zza, looperZzn, zzjtVar.zzi, this.zzw, zzdoVar);
            boolean z2 = (zzjtVar.zzs == Integer.MAX_VALUE || zzjtVar.zzt == Integer.MAX_VALUE) ? false : true;
            zzfr zzfrVar = new zzfr(zzjtVar.zza, looperZzn, zzdoVar);
            this.zzy = zzfrVar;
            zzfrVar.zza(z2);
            this.zzz = new zzfs(zzjtVar.zza, looperZzn, zzdoVar);
            int i3 = zzm.zza;
            zzbv zzbvVar = zzbv.zza;
            this.zzR = zzeu.zza;
            this.zzD = Build.VERSION.SDK_INT >= 34 ? new zzlg(this, zzjtVar.zza, null) : null;
            this.zzE = new zzjx(this, 1, null);
            this.zzF = new zzjx(this, 2, null);
            this.zzC = new zzfc(this, this.zzw, zzdoVar, zzjtVar.zzr, zzjtVar.zzs, zzjtVar.zzt, zzjtVar.zzu);
            zzluVar.zzg(this.zzJ);
            zzluVar.zzi(this.zzS, false);
            zzau(1, 3, this.zzS);
            zzau(2, 4, Integer.valueOf(this.zzQ));
            zzau(2, 5, 0);
            zzau(1, 9, Boolean.valueOf(this.zzU));
            zzau(6, 8, this.zzx);
            zzau(-1, 16, Integer.valueOf(this.zzX));
        } finally {
            this.zze.zza();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaf, reason: merged with bridge method [inline-methods] */
    public final void zzP(zzjk zzjkVar) {
        zzms zzmsVar = this.zzaa;
        zzms zzmsVarZzh = zzmsVar.zzh(zzmsVar.zzb);
        zzmsVarZzh.zzq = zzmsVarZzh.zzs;
        zzmsVarZzh.zzr = 0L;
        zzms zzmsVarZzam = zzam(zzmsVarZzh, 1);
        if (zzjkVar != null) {
            zzmsVarZzam = zzmsVarZzam.zzf(zzjkVar);
        }
        this.zzG++;
        this.zzm.zzh();
        zzaj(zzmsVarZzam, 0, false, 5, C.TIME_UNSET, -1, false);
    }

    private final int zzag(zzms zzmsVar) {
        zzbf zzbfVar = zzmsVar.zza;
        return zzbfVar.zzg() ? this.zzab : zzbfVar.zzo(zzmsVar.zzb.zza, this.zzp).zzc;
    }

    private final long zzah(zzms zzmsVar) {
        zzxk zzxkVar = zzmsVar.zzb;
        if (!zzxkVar.zzb()) {
            return zzfl.zzr(zzai(zzmsVar));
        }
        zzbf zzbfVar = zzmsVar.zza;
        zzbfVar.zzo(zzxkVar.zza, this.zzp);
        long j = zzmsVar.zzc;
        if (j != C.TIME_UNSET) {
            return zzfl.zzr(0L) + zzfl.zzr(j);
        }
        long j2 = zzbfVar.zzb(zzag(zzmsVar), this.zza, 0L).zzl;
        return zzfl.zzr(0L);
    }

    private final long zzai(zzms zzmsVar) {
        zzbf zzbfVar = zzmsVar.zza;
        if (zzbfVar.zzg()) {
            return zzfl.zzs(this.zzac);
        }
        boolean z = zzmsVar.zzp;
        long j = zzmsVar.zzs;
        zzxk zzxkVar = zzmsVar.zzb;
        if (zzxkVar.zzb()) {
            return j;
        }
        zzao(zzbfVar, zzxkVar, j);
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:103:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:105:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:107:0x02da  */
    /* JADX WARN: Code duplicated, block: B:108:0x02e6  */
    /* JADX WARN: Code duplicated, block: B:111:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:113:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:116:0x0309  */
    /* JADX WARN: Code duplicated, block: B:118:0x031d  */
    /* JADX WARN: Code duplicated, block: B:120:0x032d  */
    /* JADX WARN: Code duplicated, block: B:123:0x033d  */
    /* JADX WARN: Code duplicated, block: B:126:0x034b  */
    /* JADX WARN: Code duplicated, block: B:131:0x035e  */
    /* JADX WARN: Code duplicated, block: B:134:0x036f  */
    /* JADX WARN: Code duplicated, block: B:137:0x0384  */
    /* JADX WARN: Code duplicated, block: B:140:0x039a  */
    /* JADX WARN: Code duplicated, block: B:143:0x03bd  */
    /* JADX WARN: Code duplicated, block: B:145:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:146:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:150:0x03de  */
    /* JADX WARN: Code duplicated, block: B:151:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:153:0x03f5  */
    /* JADX WARN: Code duplicated, block: B:154:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:157:0x0404  */
    /* JADX WARN: Code duplicated, block: B:158:0x0406  */
    /* JADX WARN: Code duplicated, block: B:160:0x0416  */
    /* JADX WARN: Code duplicated, block: B:163:0x0421  */
    /* JADX WARN: Code duplicated, block: B:165:0x0435  */
    /* JADX WARN: Code duplicated, block: B:166:0x0437  */
    /* JADX WARN: Code duplicated, block: B:170:0x0446  */
    /* JADX WARN: Code duplicated, block: B:173:0x0456  */
    /* JADX WARN: Code duplicated, block: B:176:0x046e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:178:0x0472  */
    /* JADX WARN: Code duplicated, block: B:181:0x0478 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:183:0x047c  */
    /* JADX WARN: Code duplicated, block: B:186:0x0482 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:191:0x048d  */
    /* JADX WARN: Code duplicated, block: B:194:0x0494 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:196:0x0498  */
    /* JADX WARN: Code duplicated, block: B:199:0x04a0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:204:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:207:0x04b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:209:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:212:0x04c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:214:0x04cb  */
    /* JADX WARN: Code duplicated, block: B:217:0x04df  */
    /* JADX WARN: Code duplicated, block: B:39:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:41:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:42:0x0107  */
    /* JADX WARN: Code duplicated, block: B:44:0x010d  */
    /* JADX WARN: Code duplicated, block: B:48:0x011a  */
    /* JADX WARN: Code duplicated, block: B:51:0x012a  */
    /* JADX WARN: Code duplicated, block: B:54:0x0138 A[LOOP:1: B:52:0x0132->B:54:0x0138, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:59:0x0155  */
    /* JADX WARN: Code duplicated, block: B:60:0x0158  */
    /* JADX WARN: Code duplicated, block: B:63:0x0183  */
    /* JADX WARN: Code duplicated, block: B:64:0x0185  */
    /* JADX WARN: Code duplicated, block: B:67:0x018d  */
    /* JADX WARN: Code duplicated, block: B:68:0x018f  */
    /* JADX WARN: Code duplicated, block: B:71:0x0195  */
    /* JADX WARN: Code duplicated, block: B:74:0x019e  */
    /* JADX WARN: Code duplicated, block: B:75:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:77:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:81:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:86:0x0201  */
    /* JADX WARN: Code duplicated, block: B:87:0x020e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0213  */
    /* JADX WARN: Code duplicated, block: B:90:0x021a  */
    /* JADX WARN: Code duplicated, block: B:91:0x021d  */
    /* JADX WARN: Code duplicated, block: B:93:0x0225  */
    /* JADX WARN: Code duplicated, block: B:94:0x022c  */
    /* JADX WARN: Code duplicated, block: B:98:0x025c  */
    /* JADX WARN: Code duplicated, block: B:99:0x028d  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v15 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzbf] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private final void zzaj(final zzms zzmsVar, final int i, boolean z, int i2, long j, int i3, boolean z2) {
        int i4;
        zzms zzmsVar2;
        zzbf zzbfVar;
        final int i5;
        boolean z3;
        Pair pair;
        boolean z4;
        boolean z5;
        int i6;
        boolean zBooleanValue;
        final int iIntValue;
        final zzak zzakVar;
        zzam zzamVarZza;
        List list;
        int i7;
        zzap zzapVar;
        int i8;
        zzbf zzbfVarZzq;
        zzan zzanVarZzw;
        boolean zEquals;
        int i9;
        int i10;
        int i11;
        zzjk zzjkVar;
        zzjk zzjkVar2;
        zzabi zzabiVar;
        zzabi zzabiVar2;
        zzax zzaxVar;
        zzbb zzbbVar;
        zzf zzfVar;
        zzbf zzbfVarZzq2;
        zzax zzaxVar2;
        boolean z6;
        zzbf zzbfVarZzq3;
        ?? r15;
        int iZzi;
        int i12;
        boolean z7;
        ?? Zzq;
        int iZzs;
        ?? r5;
        zzbf zzbfVarZzq4;
        zzbb zzbbVar2;
        long j2;
        zzbf zzbfVarZzq5;
        boolean z8;
        boolean zZzg;
        boolean z9;
        boolean z10;
        int i13;
        boolean z11;
        boolean z12;
        boolean z13;
        int i14;
        boolean z14;
        int i15;
        boolean z15;
        zzax zzaxVarZze;
        zzef zzefVar;
        zzbd zzbdVar;
        int i16;
        int i17;
        Object obj;
        zzak zzakVar2;
        Object obj2;
        long jZzak;
        long jZzak2;
        int iZzs2;
        int iZzr;
        int i18;
        Object obj3;
        zzak zzakVar3;
        Object obj4;
        long jZzr;
        long jZzr2;
        zzxk zzxkVar;
        int i19 = i2;
        zzms zzmsVar3 = this.zzaa;
        this.zzaa = zzmsVar;
        zzbf zzbfVar2 = zzmsVar3.zza;
        zzbf zzbfVar3 = zzmsVar.zza;
        boolean zEquals2 = zzbfVar2.equals(zzbfVar3);
        if (!zzbfVar3.zzg() || !zzbfVar2.zzg()) {
            if (zzbfVar3.zzg() != zzbfVar2.zzg()) {
                pair = new Pair(true, 3);
            } else {
                zzxk zzxkVar2 = zzmsVar3.zzb;
                Object obj5 = zzxkVar2.zza;
                i4 = 0;
                zzbd zzbdVar2 = this.zzp;
                int i20 = zzbfVar2.zzo(obj5, zzbdVar2).zzc;
                zzbe zzbeVar = this.zza;
                Object obj6 = zzbfVar2.zzb(i20, zzbeVar, 0L).zzb;
                zzxk zzxkVar3 = zzmsVar.zzb;
                zzmsVar2 = zzmsVar3;
                zzbfVar = zzbfVar2;
                if (obj6.equals(zzbfVar3.zzb(zzbfVar3.zzo(zzxkVar3.zza, zzbdVar2).zzc, zzbeVar, 0L).zzb)) {
                    if (z) {
                        if (i19 != 0) {
                            i5 = i19;
                        } else if (zzxkVar2.zzd < zzxkVar3.zzd) {
                            pair = new Pair(true, 0);
                            i5 = 0;
                            z3 = true;
                        } else {
                            i5 = 0;
                        }
                        z3 = true;
                    } else {
                        i5 = i19;
                        z3 = false;
                    }
                    pair = new Pair(false, -1);
                } else {
                    if (z) {
                        if (i19 == 0) {
                            i19 = 0;
                            i6 = 1;
                            z5 = true;
                        } else {
                            z4 = true;
                            z5 = true;
                        }
                        pair = new Pair(true, Integer.valueOf(i6));
                        i5 = i19;
                        z3 = z5;
                    } else {
                        z4 = false;
                        z5 = false;
                    }
                    if (z4 && i19 == 1) {
                        i6 = 2;
                    } else {
                        if (zEquals2) {
                            throw new IllegalStateException();
                        }
                        i6 = 3;
                    }
                    pair = new Pair(true, Integer.valueOf(i6));
                    i5 = i19;
                    z3 = z5;
                }
            }
            zBooleanValue = ((Boolean) pair.first).booleanValue();
            iIntValue = ((Integer) pair.second).intValue();
            if (zBooleanValue) {
                if (zzbfVar3.zzg()) {
                    zzakVar = null;
                } else {
                    zzakVar = zzbfVar3.zzb(zzbfVar3.zzo(zzmsVar.zzb.zza, this.zzp).zzc, this.zza, 0L).zzd;
                }
                this.zzZ = zzan.zza;
            } else {
                zzakVar = null;
            }
            if (zBooleanValue || !zzmsVar2.zzj.equals(zzmsVar.zzj)) {
                zzamVarZza = this.zzZ.zza();
                list = zzmsVar.zzj;
                for (i7 = i4; i7 < list.size(); i7++) {
                    zzapVar = (zzap) list.get(i7);
                    for (i8 = i4; i8 < zzapVar.zza(); i8++) {
                        zzapVar.zzb(i8).zza(zzamVarZza);
                    }
                }
                this.zzZ = zzamVarZza.zzw();
            }
            zzbfVarZzq = zzq();
            if (zzbfVarZzq.zzg()) {
                zzanVarZzw = this.zzZ;
            } else {
                zzak zzakVar4 = zzbfVarZzq.zzb(zzs(), this.zza, 0L).zzd;
                zzam zzamVarZza2 = this.zzZ.zza();
                zzamVarZza2.zzv(zzakVar4.zzd);
                zzanVarZzw = zzamVarZza2.zzw();
            }
            zEquals = zzanVarZzw.equals(this.zzN);
            this.zzN = zzanVarZzw;
            if (zzmsVar2.zzl != zzmsVar.zzl) {
                i9 = 1;
            } else {
                i9 = i4;
            }
            if (zzmsVar2.zze != zzmsVar.zze) {
                i10 = 1;
            } else {
                i10 = i4;
            }
            if (i10 == 0 || i9 != 0) {
                zzas();
            }
            if (zzmsVar2.zzg != zzmsVar.zzg) {
                i11 = 1;
            } else {
                i11 = i4;
            }
            if (!zEquals2) {
                this.zzn.zze(i4, new zzea() { // from class: com.google.android.gms.internal.ads.zzkx
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj7) {
                        int i21 = zzlh.zzd;
                        ((zzaz) obj7).zzb(zzmsVar.zza, i);
                    }
                });
            }
            if (z3) {
                zzbdVar = new zzbd();
                if (zzbfVar.zzg()) {
                    i16 = i3;
                    i17 = i16;
                    obj = null;
                    zzakVar2 = null;
                    obj2 = null;
                } else {
                    Object obj7 = zzmsVar2.zzb.zza;
                    zzbf zzbfVar4 = zzbfVar;
                    zzbfVar4.zzo(obj7, zzbdVar);
                    int i21 = zzbdVar.zzc;
                    int iZze = zzbfVar4.zze(obj7);
                    zzbe zzbeVar2 = this.zza;
                    Object obj8 = zzbfVar4.zzb(i21, zzbeVar2, 0L).zzb;
                    zzakVar2 = zzbeVar2.zzd;
                    i16 = i21;
                    obj = obj8;
                    obj2 = obj7;
                    i17 = iZze;
                }
                if (i5 == 0) {
                    zzxkVar = zzmsVar2.zzb;
                    if (zzxkVar.zzb()) {
                        jZzak = zzbdVar.zzh(zzxkVar.zzb, zzxkVar.zzc);
                        jZzak2 = zzak(zzmsVar2);
                    } else {
                        if (zzxkVar.zze != -1) {
                            jZzak = zzak(this.zzaa);
                        } else {
                            jZzak = zzbdVar.zzd;
                        }
                        jZzak2 = jZzak;
                    }
                } else if (zzmsVar2.zzb.zzb()) {
                    jZzak = zzmsVar2.zzs;
                    jZzak2 = zzak(zzmsVar2);
                } else {
                    jZzak = zzmsVar2.zzs;
                    jZzak2 = jZzak;
                }
                String str = zzfl.zza;
                zzxk zzxkVar4 = zzmsVar2.zzb;
                final zzba zzbaVar = new zzba(obj, i16, zzakVar2, obj2, i17, zzfl.zzr(jZzak), zzfl.zzr(jZzak2), zzxkVar4.zzb, zzxkVar4.zzc);
                iZzs2 = zzs();
                iZzr = zzr();
                if (this.zzaa.zza.zzg()) {
                    i18 = iZzr;
                    obj3 = null;
                    zzakVar3 = null;
                    obj4 = null;
                } else {
                    zzms zzmsVar4 = this.zzaa;
                    Object obj9 = zzmsVar4.zzb.zza;
                    zzmsVar4.zza.zzo(obj9, this.zzp);
                    int iZze2 = this.zzaa.zza.zze(obj9);
                    zzbf zzbfVar5 = this.zzaa.zza;
                    zzbe zzbeVar3 = this.zza;
                    i18 = iZze2;
                    obj3 = zzbfVar5.zzb(iZzs2, zzbeVar3, 0L).zzb;
                    zzakVar3 = zzbeVar3.zzd;
                    obj4 = obj9;
                }
                jZzr = zzfl.zzr(j);
                if (this.zzaa.zzb.zzb()) {
                    jZzr2 = zzfl.zzr(zzak(this.zzaa));
                } else {
                    jZzr2 = jZzr;
                }
                zzxk zzxkVar5 = this.zzaa.zzb;
                final zzba zzbaVar2 = new zzba(obj3, iZzs2, zzakVar3, obj4, i18, jZzr, jZzr2, zzxkVar5.zzb, zzxkVar5.zzc);
                this.zzn.zze(11, new zzea() { // from class: com.google.android.gms.internal.ads.zzky
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zzo(zzbaVar, zzbaVar2, i5);
                    }
                });
            } else {
                i9 = i9;
                zEquals = zEquals;
            }
            if (zBooleanValue) {
                this.zzn.zze(1, new zzea() { // from class: com.google.android.gms.internal.ads.zzkz
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zzc(zzakVar, iIntValue);
                    }
                });
            }
            zzjkVar = zzmsVar2.zzf;
            zzjkVar2 = zzmsVar.zzf;
            if (zzjkVar != zzjkVar2) {
                zzefVar = this.zzn;
                zzefVar.zze(10, new zzea() { // from class: com.google.android.gms.internal.ads.zzla
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zzn(zzmsVar.zzf);
                    }
                });
                if (zzjkVar2 != null) {
                    zzefVar.zze(10, new zzea() { // from class: com.google.android.gms.internal.ads.zzkf
                        @Override // com.google.android.gms.internal.ads.zzea
                        public final /* synthetic */ void zza(Object obj10) {
                            int i22 = zzlh.zzd;
                            ((zzaz) obj10).zzm(zzmsVar.zzf);
                        }
                    });
                }
            }
            zzabiVar = zzmsVar2.zzi;
            zzabiVar2 = zzmsVar.zzi;
            if (zzabiVar != zzabiVar2) {
                this.zzj.zzq(zzabiVar2.zze);
                this.zzn.zze(2, new zzea() { // from class: com.google.android.gms.internal.ads.zzkg
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zzd(zzmsVar.zzi.zzd);
                    }
                });
            }
            if (!zEquals) {
                final zzan zzanVar = this.zzN;
                this.zzn.zze(14, new zzea() { // from class: com.google.android.gms.internal.ads.zzkh
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zze(zzanVar);
                    }
                });
            }
            if (i11 != 0) {
                this.zzn.zze(3, new zzea() { // from class: com.google.android.gms.internal.ads.zzki
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zzf(zzmsVar.zzg);
                    }
                });
            }
            if (i10 == 0 || i9 != 0) {
                this.zzn.zze(-1, new zzea() { // from class: com.google.android.gms.internal.ads.zzkj
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        zzms zzmsVar5 = zzmsVar;
                        ((zzaz) obj10).zzh(zzmsVar5.zzl, zzmsVar5.zze);
                    }
                });
            }
            if (i10 != 0) {
                this.zzn.zze(4, new zzea() { // from class: com.google.android.gms.internal.ads.zzkk
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zzi(zzmsVar.zze);
                    }
                });
            }
            if (i9 == 0 || zzmsVar2.zzm != zzmsVar.zzm) {
                this.zzn.zze(5, new zzea() { // from class: com.google.android.gms.internal.ads.zzkl
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        zzms zzmsVar5 = zzmsVar;
                        ((zzaz) obj10).zzj(zzmsVar5.zzl, zzmsVar5.zzm);
                    }
                });
            }
            if (zzmsVar2.zzn != zzmsVar.zzn) {
                this.zzn.zze(6, new zzea() { // from class: com.google.android.gms.internal.ads.zzkm
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zzk(zzmsVar.zzn);
                    }
                });
            }
            if (zzmsVar2.zzj() != zzmsVar.zzj()) {
                this.zzn.zze(7, new zzea() { // from class: com.google.android.gms.internal.ads.zzkn
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zzl(zzmsVar.zzj());
                    }
                });
            }
            if (!zzmsVar2.zzo.equals(zzmsVar.zzo)) {
                this.zzn.zze(12, new zzea() { // from class: com.google.android.gms.internal.ads.zzko
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        int i22 = zzlh.zzd;
                        ((zzaz) obj10).zzp(zzmsVar.zzo);
                    }
                });
            }
            zzaxVar = this.zzM;
            zzbbVar = this.zzg;
            zzax zzaxVar3 = this.zzc;
            String str2 = zzfl.zza;
            boolean zZzx = zzbbVar.zzx();
            zzfVar = (zzf) zzbbVar;
            zzbfVarZzq2 = zzfVar.zzq();
            if (!zzbfVarZzq2.zzg()) {
                zzaxVar2 = zzaxVar;
                z6 = zzbfVarZzq2.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzh;
                zzbfVarZzq3 = zzfVar.zzq();
                if (zzbfVarZzq3.zzg()) {
                    i12 = -1;
                    r15 = 0;
                    z7 = false;
                } else {
                    int iZzs3 = zzfVar.zzs();
                    zzfVar.zzl();
                    zzfVar.zzm();
                    r15 = 0;
                    r15 = 0;
                    iZzi = zzbfVarZzq3.zzi(iZzs3, 0, false);
                    i12 = -1;
                    if (iZzi != -1) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                }
                Zzq = zzfVar.zzq();
                if (Zzq.zzg()) {
                    r5 = r15;
                } else {
                    iZzs = zzfVar.zzs();
                    zzfVar.zzl();
                    zzfVar.zzm();
                    if (Zzq.zzh(iZzs, r15, r15) != i12) {
                        r5 = 1;
                    } else {
                        r5 = r15;
                    }
                }
                zzbfVarZzq4 = zzfVar.zzq();
                if (!zzbfVarZzq4.zzg()) {
                    zzbbVar2 = zzbbVar;
                    j2 = 0;
                    boolean z16 = zzbfVarZzq4.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzb();
                    zzbfVarZzq5 = zzfVar.zzq();
                    if (zzbfVarZzq5.zzg() && zzbfVarZzq5.zzb(zzfVar.zzs(), zzfVar.zza, j2).zzi) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zZzg = zzbbVar2.zzq().zzg();
                    zzaw zzawVar = new zzaw();
                    zzawVar.zzd(zzaxVar3);
                    boolean z17 = !zZzx;
                    zzawVar.zzb(4, z17);
                    if (z6 || zZzx) {
                        z9 = false;
                    } else {
                        z9 = true;
                    }
                    zzawVar.zzb(5, z9);
                    if (z7 || zZzx) {
                        z10 = false;
                    } else {
                        z10 = true;
                    }
                    zzawVar.zzb(6, z10);
                    if (!zZzg || (!(z7 || !z16 || z6) || zZzx)) {
                        i13 = 7;
                        z11 = false;
                    } else {
                        i13 = 7;
                        z11 = true;
                    }
                    zzawVar.zzb(i13, z11);
                    if (r5 != 0 || zZzx) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    zzawVar.zzb(8, z12);
                    if (!zZzg || ((r5 == 0 && !(z16 && z8)) || zZzx)) {
                        z13 = false;
                    } else {
                        z13 = true;
                    }
                    zzawVar.zzb(9, z13);
                    zzawVar.zzb(10, z17);
                    if (z6 || zZzx) {
                        i14 = 11;
                        z14 = false;
                    } else {
                        i14 = 11;
                        z14 = true;
                    }
                    zzawVar.zzb(i14, z14);
                    if (z6 || zZzx) {
                        i15 = 12;
                        z15 = false;
                    } else {
                        i15 = 12;
                        z15 = true;
                    }
                    zzawVar.zzb(i15, z15);
                    zzaxVarZze = zzawVar.zze();
                    this.zzM = zzaxVarZze;
                    if (!zzaxVarZze.equals(zzaxVar2)) {
                        this.zzn.zze(13, new zzea() { // from class: com.google.android.gms.internal.ads.zzkq
                            @Override // com.google.android.gms.internal.ads.zzea
                            public final /* synthetic */ void zza(Object obj10) {
                                this.zza.zzN((zzaz) obj10);
                            }
                        });
                    }
                    this.zzn.zzf();
                    boolean z18 = zzmsVar2.zzp;
                    boolean z19 = zzmsVar.zzp;
                }
                zzbbVar2 = zzbbVar;
                j2 = 0;
                zzbfVarZzq5 = zzfVar.zzq();
                if (zzbfVarZzq5.zzg()) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                zZzg = zzbbVar2.zzq().zzg();
                zzaw zzawVar2 = new zzaw();
                zzawVar2.zzd(zzaxVar3);
                boolean z110 = !zZzx;
                zzawVar2.zzb(4, z110);
                if (z6) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                zzawVar2.zzb(5, z9);
                if (z7) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                zzawVar2.zzb(6, z10);
                if (zZzg) {
                    i13 = 7;
                    z11 = false;
                } else {
                    i13 = 7;
                    z11 = false;
                }
                zzawVar2.zzb(i13, z11);
                if (r5 != 0) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                zzawVar2.zzb(8, z12);
                if (zZzg) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                zzawVar2.zzb(9, z13);
                zzawVar2.zzb(10, z110);
                if (z6) {
                    i14 = 11;
                    z14 = false;
                } else {
                    i14 = 11;
                    z14 = false;
                }
                zzawVar2.zzb(i14, z14);
                if (z6) {
                    i15 = 12;
                    z15 = false;
                } else {
                    i15 = 12;
                    z15 = false;
                }
                zzawVar2.zzb(i15, z15);
                zzaxVarZze = zzawVar2.zze();
                this.zzM = zzaxVarZze;
                if (!zzaxVarZze.equals(zzaxVar2)) {
                    this.zzn.zze(13, new zzea() { // from class: com.google.android.gms.internal.ads.zzkq
                        @Override // com.google.android.gms.internal.ads.zzea
                        public final /* synthetic */ void zza(Object obj10) {
                            this.zza.zzN((zzaz) obj10);
                        }
                    });
                }
                this.zzn.zzf();
                boolean z111 = zzmsVar2.zzp;
                boolean z112 = zzmsVar.zzp;
            }
            zzaxVar2 = zzaxVar;
            zzbfVarZzq3 = zzfVar.zzq();
            if (zzbfVarZzq3.zzg()) {
                i12 = -1;
                r15 = 0;
                z7 = false;
            } else {
                int iZzs4 = zzfVar.zzs();
                zzfVar.zzl();
                zzfVar.zzm();
                r15 = 0;
                r15 = 0;
                iZzi = zzbfVarZzq3.zzi(iZzs4, 0, false);
                i12 = -1;
                if (iZzi != -1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            Zzq = zzfVar.zzq();
            if (Zzq.zzg()) {
                r5 = r15;
            } else {
                iZzs = zzfVar.zzs();
                zzfVar.zzl();
                zzfVar.zzm();
                if (Zzq.zzh(iZzs, r15, r15) != i12) {
                    r5 = 1;
                } else {
                    r5 = r15;
                }
            }
            zzbfVarZzq4 = zzfVar.zzq();
            if (!zzbfVarZzq4.zzg()) {
                zzbbVar2 = zzbbVar;
                j2 = 0;
                if (zzbfVarZzq4.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzb()) {
                }
                zzbfVarZzq5 = zzfVar.zzq();
                if (zzbfVarZzq5.zzg()) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                zZzg = zzbbVar2.zzq().zzg();
                zzaw zzawVar3 = new zzaw();
                zzawVar3.zzd(zzaxVar3);
                boolean z113 = !zZzx;
                zzawVar3.zzb(4, z113);
                if (z6) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                zzawVar3.zzb(5, z9);
                if (z7) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                zzawVar3.zzb(6, z10);
                if (zZzg) {
                    i13 = 7;
                    z11 = false;
                } else {
                    i13 = 7;
                    z11 = false;
                }
                zzawVar3.zzb(i13, z11);
                if (r5 != 0) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                zzawVar3.zzb(8, z12);
                if (zZzg) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                zzawVar3.zzb(9, z13);
                zzawVar3.zzb(10, z113);
                if (z6) {
                    i14 = 11;
                    z14 = false;
                } else {
                    i14 = 11;
                    z14 = false;
                }
                zzawVar3.zzb(i14, z14);
                if (z6) {
                    i15 = 12;
                    z15 = false;
                } else {
                    i15 = 12;
                    z15 = false;
                }
                zzawVar3.zzb(i15, z15);
                zzaxVarZze = zzawVar3.zze();
                this.zzM = zzaxVarZze;
                if (!zzaxVarZze.equals(zzaxVar2)) {
                    this.zzn.zze(13, new zzea() { // from class: com.google.android.gms.internal.ads.zzkq
                        @Override // com.google.android.gms.internal.ads.zzea
                        public final /* synthetic */ void zza(Object obj10) {
                            this.zza.zzN((zzaz) obj10);
                        }
                    });
                }
                this.zzn.zzf();
                boolean z114 = zzmsVar2.zzp;
                boolean z115 = zzmsVar.zzp;
            }
            zzbbVar2 = zzbbVar;
            j2 = 0;
            zzbfVarZzq5 = zzfVar.zzq();
            if (zzbfVarZzq5.zzg()) {
                z8 = false;
            } else {
                z8 = false;
            }
            zZzg = zzbbVar2.zzq().zzg();
            zzaw zzawVar4 = new zzaw();
            zzawVar4.zzd(zzaxVar3);
            boolean z116 = !zZzx;
            zzawVar4.zzb(4, z116);
            if (z6) {
                z9 = false;
            } else {
                z9 = false;
            }
            zzawVar4.zzb(5, z9);
            if (z7) {
                z10 = false;
            } else {
                z10 = false;
            }
            zzawVar4.zzb(6, z10);
            if (zZzg) {
                i13 = 7;
                z11 = false;
            } else {
                i13 = 7;
                z11 = false;
            }
            zzawVar4.zzb(i13, z11);
            if (r5 != 0) {
                z12 = false;
            } else {
                z12 = false;
            }
            zzawVar4.zzb(8, z12);
            if (zZzg) {
                z13 = false;
            } else {
                z13 = false;
            }
            zzawVar4.zzb(9, z13);
            zzawVar4.zzb(10, z116);
            if (z6) {
                i14 = 11;
                z14 = false;
            } else {
                i14 = 11;
                z14 = false;
            }
            zzawVar4.zzb(i14, z14);
            if (z6) {
                i15 = 12;
                z15 = false;
            } else {
                i15 = 12;
                z15 = false;
            }
            zzawVar4.zzb(i15, z15);
            zzaxVarZze = zzawVar4.zze();
            this.zzM = zzaxVarZze;
            if (!zzaxVarZze.equals(zzaxVar2)) {
                this.zzn.zze(13, new zzea() { // from class: com.google.android.gms.internal.ads.zzkq
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj10) {
                        this.zza.zzN((zzaz) obj10);
                    }
                });
            }
            this.zzn.zzf();
            boolean z117 = zzmsVar2.zzp;
            boolean z118 = zzmsVar.zzp;
        }
        pair = new Pair(false, -1);
        zzmsVar2 = zzmsVar3;
        zzbfVar = zzbfVar2;
        i4 = 0;
        i5 = i19;
        z3 = z;
        zBooleanValue = ((Boolean) pair.first).booleanValue();
        iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            if (zzbfVar3.zzg()) {
                zzakVar = zzbfVar3.zzb(zzbfVar3.zzo(zzmsVar.zzb.zza, this.zzp).zzc, this.zza, 0L).zzd;
            } else {
                zzakVar = null;
            }
            this.zzZ = zzan.zza;
        } else {
            zzakVar = null;
        }
        if (zBooleanValue) {
            zzamVarZza = this.zzZ.zza();
            list = zzmsVar.zzj;
            while (i7 < list.size()) {
                zzapVar = (zzap) list.get(i7);
                while (i8 < zzapVar.zza()) {
                    zzapVar.zzb(i8).zza(zzamVarZza);
                }
            }
            this.zzZ = zzamVarZza.zzw();
        } else {
            zzamVarZza = this.zzZ.zza();
            list = zzmsVar.zzj;
            while (i7 < list.size()) {
                zzapVar = (zzap) list.get(i7);
                while (i8 < zzapVar.zza()) {
                    zzapVar.zzb(i8).zza(zzamVarZza);
                }
            }
            this.zzZ = zzamVarZza.zzw();
        }
        zzbfVarZzq = zzq();
        if (zzbfVarZzq.zzg()) {
            zzanVarZzw = this.zzZ;
        } else {
            zzak zzakVar5 = zzbfVarZzq.zzb(zzs(), this.zza, 0L).zzd;
            zzam zzamVarZza3 = this.zzZ.zza();
            zzamVarZza3.zzv(zzakVar5.zzd);
            zzanVarZzw = zzamVarZza3.zzw();
        }
        zEquals = zzanVarZzw.equals(this.zzN);
        this.zzN = zzanVarZzw;
        if (zzmsVar2.zzl != zzmsVar.zzl) {
            i9 = 1;
        } else {
            i9 = i4;
        }
        if (zzmsVar2.zze != zzmsVar.zze) {
            i10 = 1;
        } else {
            i10 = i4;
        }
        if (i10 == 0) {
            zzas();
        } else {
            zzas();
        }
        if (zzmsVar2.zzg != zzmsVar.zzg) {
            i11 = 1;
        } else {
            i11 = i4;
        }
        if (!zEquals2) {
            this.zzn.zze(i4, new zzea() { // from class: com.google.android.gms.internal.ads.zzkx
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj10) {
                    int i22 = zzlh.zzd;
                    ((zzaz) obj10).zzb(zzmsVar.zza, i);
                }
            });
        }
        if (z3) {
            zzbdVar = new zzbd();
            if (zzbfVar.zzg()) {
                Object obj10 = zzmsVar2.zzb.zza;
                zzbf zzbfVar6 = zzbfVar;
                zzbfVar6.zzo(obj10, zzbdVar);
                int i22 = zzbdVar.zzc;
                int iZze3 = zzbfVar6.zze(obj10);
                zzbe zzbeVar4 = this.zza;
                Object obj11 = zzbfVar6.zzb(i22, zzbeVar4, 0L).zzb;
                zzakVar2 = zzbeVar4.zzd;
                i16 = i22;
                obj = obj11;
                obj2 = obj10;
                i17 = iZze3;
            } else {
                i16 = i3;
                i17 = i16;
                obj = null;
                zzakVar2 = null;
                obj2 = null;
            }
            if (i5 == 0) {
                zzxkVar = zzmsVar2.zzb;
                if (zzxkVar.zzb()) {
                    jZzak = zzbdVar.zzh(zzxkVar.zzb, zzxkVar.zzc);
                    jZzak2 = zzak(zzmsVar2);
                } else {
                    if (zzxkVar.zze != -1) {
                        jZzak = zzak(this.zzaa);
                    } else {
                        jZzak = zzbdVar.zzd;
                    }
                    jZzak2 = jZzak;
                }
            } else if (zzmsVar2.zzb.zzb()) {
                jZzak = zzmsVar2.zzs;
                jZzak2 = zzak(zzmsVar2);
            } else {
                jZzak = zzmsVar2.zzs;
                jZzak2 = jZzak;
            }
            String str3 = zzfl.zza;
            zzxk zzxkVar6 = zzmsVar2.zzb;
            final zzba zzbaVar3 = new zzba(obj, i16, zzakVar2, obj2, i17, zzfl.zzr(jZzak), zzfl.zzr(jZzak2), zzxkVar6.zzb, zzxkVar6.zzc);
            iZzs2 = zzs();
            iZzr = zzr();
            if (this.zzaa.zza.zzg()) {
                zzms zzmsVar5 = this.zzaa;
                Object obj12 = zzmsVar5.zzb.zza;
                zzmsVar5.zza.zzo(obj12, this.zzp);
                int iZze4 = this.zzaa.zza.zze(obj12);
                zzbf zzbfVar7 = this.zzaa.zza;
                zzbe zzbeVar5 = this.zza;
                i18 = iZze4;
                obj3 = zzbfVar7.zzb(iZzs2, zzbeVar5, 0L).zzb;
                zzakVar3 = zzbeVar5.zzd;
                obj4 = obj12;
            } else {
                i18 = iZzr;
                obj3 = null;
                zzakVar3 = null;
                obj4 = null;
            }
            jZzr = zzfl.zzr(j);
            if (this.zzaa.zzb.zzb()) {
                jZzr2 = zzfl.zzr(zzak(this.zzaa));
            } else {
                jZzr2 = jZzr;
            }
            zzxk zzxkVar7 = this.zzaa.zzb;
            final zzba zzbaVar4 = new zzba(obj3, iZzs2, zzakVar3, obj4, i18, jZzr, jZzr2, zzxkVar7.zzb, zzxkVar7.zzc);
            this.zzn.zze(11, new zzea() { // from class: com.google.android.gms.internal.ads.zzky
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zzo(zzbaVar3, zzbaVar4, i5);
                }
            });
        } else {
            i9 = i9;
            zEquals = zEquals;
        }
        if (zBooleanValue) {
            this.zzn.zze(1, new zzea() { // from class: com.google.android.gms.internal.ads.zzkz
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zzc(zzakVar, iIntValue);
                }
            });
        }
        zzjkVar = zzmsVar2.zzf;
        zzjkVar2 = zzmsVar.zzf;
        if (zzjkVar != zzjkVar2) {
            zzefVar = this.zzn;
            zzefVar.zze(10, new zzea() { // from class: com.google.android.gms.internal.ads.zzla
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zzn(zzmsVar.zzf);
                }
            });
            if (zzjkVar2 != null) {
                zzefVar.zze(10, new zzea() { // from class: com.google.android.gms.internal.ads.zzkf
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj13) {
                        int i23 = zzlh.zzd;
                        ((zzaz) obj13).zzm(zzmsVar.zzf);
                    }
                });
            }
        }
        zzabiVar = zzmsVar2.zzi;
        zzabiVar2 = zzmsVar.zzi;
        if (zzabiVar != zzabiVar2) {
            this.zzj.zzq(zzabiVar2.zze);
            this.zzn.zze(2, new zzea() { // from class: com.google.android.gms.internal.ads.zzkg
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zzd(zzmsVar.zzi.zzd);
                }
            });
        }
        if (!zEquals) {
            final zzan zzanVar2 = this.zzN;
            this.zzn.zze(14, new zzea() { // from class: com.google.android.gms.internal.ads.zzkh
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zze(zzanVar2);
                }
            });
        }
        if (i11 != 0) {
            this.zzn.zze(3, new zzea() { // from class: com.google.android.gms.internal.ads.zzki
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zzf(zzmsVar.zzg);
                }
            });
        }
        if (i10 == 0) {
            this.zzn.zze(-1, new zzea() { // from class: com.google.android.gms.internal.ads.zzkj
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    zzms zzmsVar6 = zzmsVar;
                    ((zzaz) obj13).zzh(zzmsVar6.zzl, zzmsVar6.zze);
                }
            });
        } else {
            this.zzn.zze(-1, new zzea() { // from class: com.google.android.gms.internal.ads.zzkj
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    zzms zzmsVar6 = zzmsVar;
                    ((zzaz) obj13).zzh(zzmsVar6.zzl, zzmsVar6.zze);
                }
            });
        }
        if (i10 != 0) {
            this.zzn.zze(4, new zzea() { // from class: com.google.android.gms.internal.ads.zzkk
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zzi(zzmsVar.zze);
                }
            });
        }
        if (i9 == 0) {
            this.zzn.zze(5, new zzea() { // from class: com.google.android.gms.internal.ads.zzkl
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    zzms zzmsVar6 = zzmsVar;
                    ((zzaz) obj13).zzj(zzmsVar6.zzl, zzmsVar6.zzm);
                }
            });
        } else {
            this.zzn.zze(5, new zzea() { // from class: com.google.android.gms.internal.ads.zzkl
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    zzms zzmsVar6 = zzmsVar;
                    ((zzaz) obj13).zzj(zzmsVar6.zzl, zzmsVar6.zzm);
                }
            });
        }
        if (zzmsVar2.zzn != zzmsVar.zzn) {
            this.zzn.zze(6, new zzea() { // from class: com.google.android.gms.internal.ads.zzkm
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zzk(zzmsVar.zzn);
                }
            });
        }
        if (zzmsVar2.zzj() != zzmsVar.zzj()) {
            this.zzn.zze(7, new zzea() { // from class: com.google.android.gms.internal.ads.zzkn
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zzl(zzmsVar.zzj());
                }
            });
        }
        if (!zzmsVar2.zzo.equals(zzmsVar.zzo)) {
            this.zzn.zze(12, new zzea() { // from class: com.google.android.gms.internal.ads.zzko
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    int i23 = zzlh.zzd;
                    ((zzaz) obj13).zzp(zzmsVar.zzo);
                }
            });
        }
        zzaxVar = this.zzM;
        zzbbVar = this.zzg;
        zzax zzaxVar4 = this.zzc;
        String str4 = zzfl.zza;
        boolean zZzx2 = zzbbVar.zzx();
        zzfVar = (zzf) zzbbVar;
        zzbfVarZzq2 = zzfVar.zzq();
        if (!zzbfVarZzq2.zzg()) {
            zzaxVar2 = zzaxVar;
            if (zzbfVarZzq2.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzh) {
            }
            zzbfVarZzq3 = zzfVar.zzq();
            if (zzbfVarZzq3.zzg()) {
                i12 = -1;
                r15 = 0;
                z7 = false;
            } else {
                int iZzs5 = zzfVar.zzs();
                zzfVar.zzl();
                zzfVar.zzm();
                r15 = 0;
                r15 = 0;
                iZzi = zzbfVarZzq3.zzi(iZzs5, 0, false);
                i12 = -1;
                if (iZzi != -1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
            }
            Zzq = zzfVar.zzq();
            if (Zzq.zzg()) {
                r5 = r15;
            } else {
                iZzs = zzfVar.zzs();
                zzfVar.zzl();
                zzfVar.zzm();
                if (Zzq.zzh(iZzs, r15, r15) != i12) {
                    r5 = 1;
                } else {
                    r5 = r15;
                }
            }
            zzbfVarZzq4 = zzfVar.zzq();
            if (!zzbfVarZzq4.zzg()) {
                zzbbVar2 = zzbbVar;
                j2 = 0;
                if (zzbfVarZzq4.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzb()) {
                }
                zzbfVarZzq5 = zzfVar.zzq();
                if (zzbfVarZzq5.zzg()) {
                    z8 = false;
                } else {
                    z8 = false;
                }
                zZzg = zzbbVar2.zzq().zzg();
                zzaw zzawVar5 = new zzaw();
                zzawVar5.zzd(zzaxVar4);
                boolean z119 = !zZzx2;
                zzawVar5.zzb(4, z119);
                if (z6) {
                    z9 = false;
                } else {
                    z9 = false;
                }
                zzawVar5.zzb(5, z9);
                if (z7) {
                    z10 = false;
                } else {
                    z10 = false;
                }
                zzawVar5.zzb(6, z10);
                if (zZzg) {
                    i13 = 7;
                    z11 = false;
                } else {
                    i13 = 7;
                    z11 = false;
                }
                zzawVar5.zzb(i13, z11);
                if (r5 != 0) {
                    z12 = false;
                } else {
                    z12 = false;
                }
                zzawVar5.zzb(8, z12);
                if (zZzg) {
                    z13 = false;
                } else {
                    z13 = false;
                }
                zzawVar5.zzb(9, z13);
                zzawVar5.zzb(10, z119);
                if (z6) {
                    i14 = 11;
                    z14 = false;
                } else {
                    i14 = 11;
                    z14 = false;
                }
                zzawVar5.zzb(i14, z14);
                if (z6) {
                    i15 = 12;
                    z15 = false;
                } else {
                    i15 = 12;
                    z15 = false;
                }
                zzawVar5.zzb(i15, z15);
                zzaxVarZze = zzawVar5.zze();
                this.zzM = zzaxVarZze;
                if (!zzaxVarZze.equals(zzaxVar2)) {
                    this.zzn.zze(13, new zzea() { // from class: com.google.android.gms.internal.ads.zzkq
                        @Override // com.google.android.gms.internal.ads.zzea
                        public final /* synthetic */ void zza(Object obj13) {
                            this.zza.zzN((zzaz) obj13);
                        }
                    });
                }
                this.zzn.zzf();
                boolean z1110 = zzmsVar2.zzp;
                boolean z1111 = zzmsVar.zzp;
            }
            zzbbVar2 = zzbbVar;
            j2 = 0;
            zzbfVarZzq5 = zzfVar.zzq();
            if (zzbfVarZzq5.zzg()) {
                z8 = false;
            } else {
                z8 = false;
            }
            zZzg = zzbbVar2.zzq().zzg();
            zzaw zzawVar6 = new zzaw();
            zzawVar6.zzd(zzaxVar4);
            boolean z1112 = !zZzx2;
            zzawVar6.zzb(4, z1112);
            if (z6) {
                z9 = false;
            } else {
                z9 = false;
            }
            zzawVar6.zzb(5, z9);
            if (z7) {
                z10 = false;
            } else {
                z10 = false;
            }
            zzawVar6.zzb(6, z10);
            if (zZzg) {
                i13 = 7;
                z11 = false;
            } else {
                i13 = 7;
                z11 = false;
            }
            zzawVar6.zzb(i13, z11);
            if (r5 != 0) {
                z12 = false;
            } else {
                z12 = false;
            }
            zzawVar6.zzb(8, z12);
            if (zZzg) {
                z13 = false;
            } else {
                z13 = false;
            }
            zzawVar6.zzb(9, z13);
            zzawVar6.zzb(10, z1112);
            if (z6) {
                i14 = 11;
                z14 = false;
            } else {
                i14 = 11;
                z14 = false;
            }
            zzawVar6.zzb(i14, z14);
            if (z6) {
                i15 = 12;
                z15 = false;
            } else {
                i15 = 12;
                z15 = false;
            }
            zzawVar6.zzb(i15, z15);
            zzaxVarZze = zzawVar6.zze();
            this.zzM = zzaxVarZze;
            if (!zzaxVarZze.equals(zzaxVar2)) {
                this.zzn.zze(13, new zzea() { // from class: com.google.android.gms.internal.ads.zzkq
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj13) {
                        this.zza.zzN((zzaz) obj13);
                    }
                });
            }
            this.zzn.zzf();
            boolean z1113 = zzmsVar2.zzp;
            boolean z1114 = zzmsVar.zzp;
        }
        zzaxVar2 = zzaxVar;
        zzbfVarZzq3 = zzfVar.zzq();
        if (zzbfVarZzq3.zzg()) {
            i12 = -1;
            r15 = 0;
            z7 = false;
        } else {
            int iZzs6 = zzfVar.zzs();
            zzfVar.zzl();
            zzfVar.zzm();
            r15 = 0;
            r15 = 0;
            iZzi = zzbfVarZzq3.zzi(iZzs6, 0, false);
            i12 = -1;
            if (iZzi != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        Zzq = zzfVar.zzq();
        if (Zzq.zzg()) {
            r5 = r15;
        } else {
            iZzs = zzfVar.zzs();
            zzfVar.zzl();
            zzfVar.zzm();
            if (Zzq.zzh(iZzs, r15, r15) != i12) {
                r5 = 1;
            } else {
                r5 = r15;
            }
        }
        zzbfVarZzq4 = zzfVar.zzq();
        if (!zzbfVarZzq4.zzg()) {
            zzbbVar2 = zzbbVar;
            j2 = 0;
            if (zzbfVarZzq4.zzb(zzfVar.zzs(), zzfVar.zza, 0L).zzb()) {
            }
            zzbfVarZzq5 = zzfVar.zzq();
            if (zzbfVarZzq5.zzg()) {
                z8 = false;
            } else {
                z8 = false;
            }
            zZzg = zzbbVar2.zzq().zzg();
            zzaw zzawVar7 = new zzaw();
            zzawVar7.zzd(zzaxVar4);
            boolean z1115 = !zZzx2;
            zzawVar7.zzb(4, z1115);
            if (z6) {
                z9 = false;
            } else {
                z9 = false;
            }
            zzawVar7.zzb(5, z9);
            if (z7) {
                z10 = false;
            } else {
                z10 = false;
            }
            zzawVar7.zzb(6, z10);
            if (zZzg) {
                i13 = 7;
                z11 = false;
            } else {
                i13 = 7;
                z11 = false;
            }
            zzawVar7.zzb(i13, z11);
            if (r5 != 0) {
                z12 = false;
            } else {
                z12 = false;
            }
            zzawVar7.zzb(8, z12);
            if (zZzg) {
                z13 = false;
            } else {
                z13 = false;
            }
            zzawVar7.zzb(9, z13);
            zzawVar7.zzb(10, z1115);
            if (z6) {
                i14 = 11;
                z14 = false;
            } else {
                i14 = 11;
                z14 = false;
            }
            zzawVar7.zzb(i14, z14);
            if (z6) {
                i15 = 12;
                z15 = false;
            } else {
                i15 = 12;
                z15 = false;
            }
            zzawVar7.zzb(i15, z15);
            zzaxVarZze = zzawVar7.zze();
            this.zzM = zzaxVarZze;
            if (!zzaxVarZze.equals(zzaxVar2)) {
                this.zzn.zze(13, new zzea() { // from class: com.google.android.gms.internal.ads.zzkq
                    @Override // com.google.android.gms.internal.ads.zzea
                    public final /* synthetic */ void zza(Object obj13) {
                        this.zza.zzN((zzaz) obj13);
                    }
                });
            }
            this.zzn.zzf();
            boolean z1116 = zzmsVar2.zzp;
            boolean z1117 = zzmsVar.zzp;
        }
        zzbbVar2 = zzbbVar;
        j2 = 0;
        zzbfVarZzq5 = zzfVar.zzq();
        if (zzbfVarZzq5.zzg()) {
            z8 = false;
        } else {
            z8 = false;
        }
        zZzg = zzbbVar2.zzq().zzg();
        zzaw zzawVar8 = new zzaw();
        zzawVar8.zzd(zzaxVar4);
        boolean z1118 = !zZzx2;
        zzawVar8.zzb(4, z1118);
        if (z6) {
            z9 = false;
        } else {
            z9 = false;
        }
        zzawVar8.zzb(5, z9);
        if (z7) {
            z10 = false;
        } else {
            z10 = false;
        }
        zzawVar8.zzb(6, z10);
        if (zZzg) {
            i13 = 7;
            z11 = false;
        } else {
            i13 = 7;
            z11 = false;
        }
        zzawVar8.zzb(i13, z11);
        if (r5 != 0) {
            z12 = false;
        } else {
            z12 = false;
        }
        zzawVar8.zzb(8, z12);
        if (zZzg) {
            z13 = false;
        } else {
            z13 = false;
        }
        zzawVar8.zzb(9, z13);
        zzawVar8.zzb(10, z1118);
        if (z6) {
            i14 = 11;
            z14 = false;
        } else {
            i14 = 11;
            z14 = false;
        }
        zzawVar8.zzb(i14, z14);
        if (z6) {
            i15 = 12;
            z15 = false;
        } else {
            i15 = 12;
            z15 = false;
        }
        zzawVar8.zzb(i15, z15);
        zzaxVarZze = zzawVar8.zze();
        this.zzM = zzaxVarZze;
        if (!zzaxVarZze.equals(zzaxVar2)) {
            this.zzn.zze(13, new zzea() { // from class: com.google.android.gms.internal.ads.zzkq
                @Override // com.google.android.gms.internal.ads.zzea
                public final /* synthetic */ void zza(Object obj13) {
                    this.zza.zzN((zzaz) obj13);
                }
            });
        }
        this.zzn.zzf();
        boolean z1119 = zzmsVar2.zzp;
        boolean z11110 = zzmsVar.zzp;
    }

    private static long zzak(zzms zzmsVar) {
        zzbe zzbeVar = new zzbe();
        zzbd zzbdVar = new zzbd();
        zzbf zzbfVar = zzmsVar.zza;
        zzbfVar.zzo(zzmsVar.zzb.zza, zzbdVar);
        long j = zzmsVar.zzc;
        if (j != C.TIME_UNSET) {
            return j;
        }
        long j2 = zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L).zzl;
        return 0L;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0097  */
    private final zzms zzal(zzms zzmsVar, zzbf zzbfVar, Pair pair) {
        boolean z;
        zzgtj.zza(zzbfVar.zzg() || pair != null);
        zzbf zzbfVar2 = zzmsVar.zza;
        long jZzah = zzah(zzmsVar);
        zzms zzmsVarZzd = zzmsVar.zzd(zzbfVar);
        if (zzbfVar.zzg()) {
            zzxk zzxkVarZzb = zzms.zzb();
            long jZzs = zzfl.zzs(this.zzac);
            zzms zzmsVarZzh = zzmsVarZzd.zzc(zzxkVarZzb, jZzs, jZzs, jZzs, 0L, zzzn.zza, this.zzb, zzgwm.zzi()).zzh(zzxkVarZzb);
            zzmsVarZzh.zzq = zzmsVarZzh.zzs;
            return zzmsVarZzh;
        }
        zzxk zzxkVar = zzmsVarZzd.zzb;
        Object obj = zzxkVar.zza;
        String str = zzfl.zza;
        boolean zEquals = obj.equals(pair.first);
        zzxk zzxkVar2 = !zEquals ? new zzxk(pair.first, -1L) : zzxkVar;
        long jLongValue = ((Long) pair.second).longValue();
        long jZzs2 = zzfl.zzs(jZzah);
        if (zzbfVar2.zzg()) {
            z = true;
        } else {
            zzbd zzbdVar = this.zzp;
            zzbfVar2.zzo(obj, zzbdVar);
            if (zEquals && jZzs2 - jLongValue == 1) {
                zzbd zzbdVarZzo = zzbfVar2.zzo(obj, zzbdVar);
                z = true;
                if (jZzs2 == zzbdVarZzo.zzd) {
                    jZzs2--;
                }
            } else {
                z = true;
            }
        }
        if (!zEquals || jLongValue < jZzs2) {
            zzgtj.zzi(zzxkVar2.zzb() ^ z);
            zzxk zzxkVar3 = zzxkVar2;
            zzms zzmsVarZzh2 = zzmsVarZzd.zzc(zzxkVar3, jLongValue, jLongValue, jLongValue, 0L, !zEquals ? zzzn.zza : zzmsVarZzd.zzh, !zEquals ? this.zzb : zzmsVarZzd.zzi, !zEquals ? zzgwm.zzi() : zzmsVarZzd.zzj).zzh(zzxkVar3);
            zzmsVarZzh2.zzq = jLongValue;
            return zzmsVarZzh2;
        }
        if (jLongValue != jZzs2) {
            zzgtj.zzi(zzxkVar2.zzb() ^ z);
            long jMax = Math.max(0L, zzmsVarZzd.zzr - (jLongValue - jZzs2));
            long j = zzmsVarZzd.zzq;
            if (zzmsVarZzd.zzk.equals(zzxkVar)) {
                j = jLongValue + jMax;
            }
            zzms zzmsVarZzc = zzmsVarZzd.zzc(zzxkVar2, jLongValue, jLongValue, jLongValue, jMax, zzmsVarZzd.zzh, zzmsVarZzd.zzi, zzmsVarZzd.zzj);
            zzmsVarZzc.zzq = j;
            return zzmsVarZzc;
        }
        int iZze = zzbfVar.zze(zzmsVarZzd.zzk.zza);
        if (iZze != -1) {
            zzbd zzbdVar2 = this.zzp;
            if (zzbfVar.zzd(iZze, zzbdVar2, false).zzc == zzbfVar.zzo(zzxkVar2.zza, zzbdVar2).zzc) {
                return zzmsVarZzd;
            }
        }
        Object obj2 = zzxkVar2.zza;
        zzbd zzbdVar3 = this.zzp;
        zzbfVar.zzo(obj2, zzbdVar3);
        long jZzh = zzxkVar2.zzb() ? zzbdVar3.zzh(zzxkVar2.zzb, zzxkVar2.zzc) : zzbdVar3.zzd;
        zzxk zzxkVar4 = zzxkVar2;
        zzms zzmsVarZzh3 = zzmsVarZzd.zzc(zzxkVar4, zzmsVarZzd.zzs, zzmsVarZzd.zzs, zzmsVarZzd.zzd, jZzh - zzmsVarZzd.zzs, zzmsVarZzd.zzh, zzmsVarZzd.zzi, zzmsVarZzd.zzj).zzh(zzxkVar4);
        zzmsVarZzh3.zzq = jZzh;
        return zzmsVarZzh3;
    }

    private static zzms zzam(zzms zzmsVar, int i) {
        zzms zzmsVarZze = zzmsVar.zze(i);
        return (i == 1 || i == 4) ? zzmsVarZze.zzg(false) : zzmsVarZze;
    }

    private final Pair zzan(zzbf zzbfVar, int i, long j) {
        if (zzbfVar.zzg()) {
            this.zzab = i;
            if (j == C.TIME_UNSET) {
                j = 0;
            }
            this.zzac = j;
            return null;
        }
        if (i == -1 || i >= zzbfVar.zza()) {
            i = zzbfVar.zzk(false);
            long j2 = zzbfVar.zzb(i, this.zza, 0L).zzl;
            j = zzfl.zzr(0L);
        }
        return zzbfVar.zzm(this.zza, this.zzp, i, zzfl.zzs(j));
    }

    private final long zzao(zzbf zzbfVar, zzxk zzxkVar, long j) {
        zzbfVar.zzo(zzxkVar.zza, this.zzp);
        return j;
    }

    private final zzmw zzap(zzmv zzmvVar) {
        int iZzag = zzag(this.zzaa);
        zzbf zzbfVar = this.zzaa.zza;
        if (iZzag == -1) {
            iZzag = 0;
        }
        zzdo zzdoVar = this.zzv;
        zzlu zzluVar = this.zzm;
        return new zzmw(zzluVar, zzmvVar, zzbfVar, iZzag, zzdoVar, zzluVar.zzn());
    }

    private final void zzaq(Object obj) {
        Object obj2 = this.zzO;
        boolean z = false;
        if (obj2 != null && obj2 != obj) {
            z = true;
        }
        boolean zZzl = this.zzm.zzl(obj, z ? this.zzA : C.TIME_UNSET);
        if (z) {
            Object obj3 = this.zzO;
            Surface surface = this.zzP;
            if (obj3 == surface) {
                surface.release();
                this.zzP = null;
            }
        }
        this.zzO = obj;
        if (zZzl) {
            return;
        }
        zzP(zzjk.zzc(new zzlv(3), 1003));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzar, reason: merged with bridge method [inline-methods] */
    public final void zzS(final int i, final int i2) {
        if (i == this.zzR.zza() && i2 == this.zzR.zzb()) {
            return;
        }
        this.zzR = new zzeu(i, i2);
        zzef zzefVar = this.zzn;
        zzefVar.zze(24, new zzea() { // from class: com.google.android.gms.internal.ads.zzkr
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                int i3 = zzlh.zzd;
                ((zzaz) obj).zzu(i, i2);
            }
        });
        zzefVar.zzf();
        zzau(2, 14, new zzeu(i, i2));
    }

    private final void zzas() {
        int iZzh = zzh();
        if (iZzh != 2 && iZzh != 3) {
            this.zzy.zzb(false);
            this.zzz.zza(false);
        } else {
            zzat();
            boolean z = this.zzaa.zzp;
            this.zzy.zzb(zzk());
            this.zzz.zza(zzk());
        }
    }

    private final void zzat() {
        this.zze.zzd();
        Looper looper = this.zzt;
        if (Thread.currentThread() != looper.getThread()) {
            Object[] objArr = {Thread.currentThread().getName(), looper.getThread().getName()};
            String str = zzfl.zza;
            String str2 = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", objArr);
            if (this.zzV) {
                throw new IllegalStateException(str2);
            }
            zzeg.zzd("ExoPlayerImpl", str2, this.zzW ? null : new IllegalStateException());
            this.zzW = true;
        }
    }

    private final void zzau(int i, int i2, Object obj) {
        zzna[] zznaVarArr = this.zzh;
        int length = zznaVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            zzna zznaVar = zznaVarArr[i3];
            if (i == -1 || zznaVar.zza() == i) {
                zzmw zzmwVarZzap = zzap(zznaVar);
                zzmwVarZzap.zzb(i2);
                zzmwVarZzap.zzd(obj);
                zzmwVarZzap.zzg();
            }
        }
        zzna[] zznaVarArr2 = this.zzi;
        int length2 = zznaVarArr2.length;
        for (int i4 = 0; i4 < 2; i4++) {
            zzna zznaVar2 = zznaVarArr2[i4];
            if (zznaVar2 != null && (i == -1 || zznaVar2.zza() == i)) {
                zzmw zzmwVarZzap2 = zzap(zznaVar2);
                zzmwVarZzap2.zzb(i2);
                zzmwVarZzap2.zzd(obj);
                zzmwVarZzap2.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzA() {
        zzat();
        return zzah(this.zzaa);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzB(float f) {
        zzat();
        String str = zzfl.zza;
        final float fMax = Math.max(0.0f, Math.min(f, 1.0f));
        if (this.zzT == fMax) {
            return;
        }
        this.zzT = fMax;
        this.zzm.zzj(fMax);
        zzef zzefVar = this.zzn;
        zzefVar.zze(22, new zzea() { // from class: com.google.android.gms.internal.ads.zzkw
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                int i = zzlh.zzd;
                ((zzaz) obj).zzr(fMax);
            }
        });
        zzefVar.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzC(Surface surface) {
        zzat();
        zzaq(surface);
        int i = surface == null ? 0 : -1;
        zzS(i, i);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzD(zznp zznpVar) {
        this.zzs.zzv(zznpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzE(zznp zznpVar) {
        zzat();
        this.zzs.zzw(zznpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final int zzF() {
        zzat();
        int length = this.zzh.length;
        return 2;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0097  */
    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzG(zzxm zzxmVar) {
        zzat();
        List listSingletonList = Collections.singletonList(zzxmVar);
        zzat();
        zzat();
        zzag(this.zzaa);
        zzu();
        this.zzG++;
        List list = this.zzq;
        list.clear();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < listSingletonList.size(); i++) {
            zzmo zzmoVar = new zzmo((zzxm) listSingletonList.get(i), this.zzr);
            arrayList.add(zzmoVar);
            list.add(i, new zzld(zzmoVar.zzb, zzmoVar.zza));
        }
        this.zzad = this.zzad.zzg().zzf(0, arrayList.size());
        zzmy zzmyVar = new zzmy(list, this.zzad);
        if (!zzmyVar.zzg() && zzmyVar.zza() < 0) {
            throw new zzw(zzmyVar, -1, C.TIME_UNSET);
        }
        int iZzk = zzmyVar.zzk(false);
        zzms zzmsVarZzal = zzal(this.zzaa, zzmyVar, zzan(zzmyVar, iZzk, C.TIME_UNSET));
        int i2 = zzmsVarZzal.zze;
        if (i2 == 1) {
            i2 = 1;
        } else if (zzmyVar.zzg()) {
            i2 = 4;
        } else if (iZzk != -1) {
            if (iZzk >= zzmyVar.zza()) {
                i2 = 4;
            } else {
                i2 = 2;
            }
        }
        zzms zzmsVarZzam = zzam(zzmsVarZzal, i2);
        this.zzm.zzy(arrayList, iZzk, zzfl.zzs(C.TIME_UNSET), this.zzad);
        zzaj(zzmsVarZzam, 0, (this.zzaa.zzb.zza.equals(zzmsVarZzam.zzb.zza) || this.zzaa.zza.zzg()) ? false : true, 4, zzai(zzmsVarZzam), -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzjv
    public final void zzH() {
        String hexString = Integer.toHexString(System.identityHashCode(this));
        String str = zzfl.zza;
        String strZza = zzal.zza();
        int length = String.valueOf(hexString).length();
        StringBuilder sb = new StringBuilder(length + 39 + String.valueOf(str).length() + 3 + String.valueOf(strZza).length() + 1);
        sb.append("Release ");
        sb.append(hexString);
        sb.append(" [AndroidXMedia3/1.10.0-rc02] [");
        sb.append(str);
        sb.append("] [");
        sb.append(strZza);
        sb.append("]");
        zzeg.zzb("ExoPlayerImpl", sb.toString());
        zzat();
        this.zzy.zzb(false);
        this.zzz.zza(false);
        zzlg zzlgVar = this.zzD;
        if (zzlgVar != null && Build.VERSION.SDK_INT >= 34) {
            zzlgVar.zza();
        }
        this.zzC.zza();
        if (!this.zzm.zzm()) {
            zzef zzefVar = this.zzn;
            zzefVar.zze(10, zzkv.zza);
            zzefVar.zzf();
        }
        this.zzn.zzg();
        this.zzk.zzl(null);
        zzabq zzabqVar = this.zzu;
        zznm zznmVar = this.zzs;
        zzabqVar.zzg(zznmVar);
        boolean z = this.zzaa.zzp;
        zzms zzmsVarZzam = zzam(this.zzaa, 1);
        this.zzaa = zzmsVarZzam;
        zzms zzmsVarZzh = zzmsVarZzam.zzh(zzmsVarZzam.zzb);
        this.zzaa = zzmsVarZzh;
        zzmsVarZzh.zzq = zzmsVarZzh.zzs;
        this.zzaa.zzr = 0L;
        zznmVar.zzy();
        Surface surface = this.zzP;
        if (surface != null) {
            surface.release();
            this.zzP = null;
        }
        int i = zzcz.zza;
        this.zzY = true;
    }

    public final zzjk zzI() {
        zzat();
        return this.zzaa.zzf;
    }

    final /* synthetic */ void zzJ(zzaz zzazVar, zzs zzsVar) {
        zzazVar.zza(this.zzg, new zzay(zzsVar));
    }

    final /* synthetic */ void zzK(final zzlr zzlrVar) {
        this.zzk.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkt
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzO(zzlrVar);
            }
        });
    }

    final /* synthetic */ void zzL(int i, final int i2) {
        zzat();
        Integer numValueOf = Integer.valueOf(i2);
        zzau(1, 10, numValueOf);
        zzau(2, 10, numValueOf);
        zzea zzeaVar = new zzea() { // from class: com.google.android.gms.internal.ads.zzks
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                int i3 = zzlh.zzd;
                ((zzaz) obj).zzq(i2);
            }
        };
        zzef zzefVar = this.zzn;
        zzefVar.zze(21, zzeaVar);
        zzefVar.zzf();
    }

    final /* synthetic */ void zzM() {
        String str = zzfl.zza;
        int iGenerateAudioSessionId = zzcj.zza(this.zzf).generateAudioSessionId();
        if (iGenerateAudioSessionId == -1) {
            iGenerateAudioSessionId = 0;
        }
        zzdm zzdmVar = this.zzB;
        if (((Integer) zzdmVar.zza()).intValue() != iGenerateAudioSessionId) {
            Integer numValueOf = Integer.valueOf(iGenerateAudioSessionId);
            zzdmVar.zzc(numValueOf);
            zzau(1, 10, numValueOf);
            zzau(2, 10, numValueOf);
        }
    }

    final /* synthetic */ void zzN(zzaz zzazVar) {
        zzazVar.zzg(this.zzM);
    }

    final /* synthetic */ void zzO(zzlr zzlrVar) {
        int i;
        long j;
        boolean z;
        int i2 = this.zzG - zzlrVar.zzb;
        this.zzG = i2;
        boolean z2 = true;
        if (zzlrVar.zzc) {
            this.zzH = zzlrVar.zzd;
            this.zzI = true;
        }
        if (i2 == 0) {
            zzbf zzbfVar = zzlrVar.zza.zza;
            int iZzs = -1;
            if (!this.zzaa.zza.zzg() && zzbfVar.zzg()) {
                this.zzab = -1;
                this.zzac = 0L;
            }
            if (!zzbfVar.zzg()) {
                List listZzw = ((zzmy) zzbfVar).zzw();
                int size = listZzw.size();
                List list = this.zzq;
                zzgtj.zzi(size == list.size());
                for (int i3 = 0; i3 < listZzw.size(); i3++) {
                    ((zzld) list.get(i3)).zzc((zzbf) listZzw.get(i3));
                }
            }
            boolean z3 = this.zzI;
            long j2 = C.TIME_UNSET;
            if (z3) {
                boolean z4 = zzlrVar.zza.zza.zzg() && this.zzaa.zza.zzg();
                boolean zEquals = zzlrVar.zza.zzb.equals(this.zzaa.zzb);
                long j3 = zzlrVar.zza.zzd;
                long j4 = this.zzaa.zzs;
                if (z4 || (zEquals && j3 == j4)) {
                    z2 = false;
                }
                if (z2) {
                    iZzs = zzs();
                    if (zzbfVar.zzg() || zzlrVar.zza.zzb.zzb()) {
                        j2 = zzlrVar.zza.zzd;
                    } else {
                        zzms zzmsVar = zzlrVar.zza;
                        zzxk zzxkVar = zzmsVar.zzb;
                        long j5 = zzmsVar.zzd;
                        zzao(zzbfVar, zzxkVar, j5);
                        j2 = j5;
                    }
                }
                z = z2;
                long j6 = j2;
                i = iZzs;
                j = j6;
            } else {
                i = -1;
                j = -9223372036854775807L;
                z = false;
            }
            this.zzI = false;
            zzaj(zzlrVar.zza, 1, z, this.zzH, j, i, false);
        }
    }

    final /* synthetic */ void zzQ(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzaq(surface);
        this.zzP = surface;
    }

    final /* synthetic */ void zzR(Object obj) {
        zzaq(null);
    }

    final /* synthetic */ void zzT(int i, int i2, Object obj) {
        zzau(1, 19, obj);
    }

    final /* synthetic */ zzef zzU() {
        return this.zzn;
    }

    final /* synthetic */ zznm zzV() {
        return this.zzs;
    }

    final /* synthetic */ Looper zzW() {
        return this.zzt;
    }

    final /* synthetic */ zzdo zzX() {
        return this.zzv;
    }

    final /* synthetic */ zzdm zzY() {
        return this.zzB;
    }

    final /* synthetic */ zzjx zzZ() {
        return this.zzE;
    }

    final /* synthetic */ zzjx zzaa() {
        return this.zzF;
    }

    final /* synthetic */ Object zzab() {
        return this.zzO;
    }

    final /* synthetic */ boolean zzac() {
        return this.zzU;
    }

    final /* synthetic */ void zzad(boolean z) {
        this.zzU = z;
    }

    final /* synthetic */ boolean zzae() {
        return this.zzY;
    }

    @Override // com.google.android.gms.internal.ads.zzf
    protected final void zzc(int i, long j, int i2, boolean z) {
        zzat();
        if (i == -1) {
            return;
        }
        zzgtj.zza(i >= 0);
        zzbf zzbfVar = this.zzaa.zza;
        if (zzbfVar.zzg() || i < zzbfVar.zza()) {
            this.zzs.zzA();
            this.zzG++;
            if (zzx()) {
                zzeg.zzc("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzlr zzlrVar = new zzlr(this.zzaa);
                zzlrVar.zza(1);
                this.zzl.zza(zzlrVar);
                return;
            }
            zzms zzmsVarZzam = this.zzaa;
            int i3 = zzmsVarZzam.zze;
            if (i3 == 3 || (i3 == 4 && !zzbfVar.zzg())) {
                zzmsVarZzam = zzam(this.zzaa, 2);
            }
            int iZzs = zzs();
            zzms zzmsVarZzal = zzal(zzmsVarZzam, zzbfVar, zzan(zzbfVar, i, j));
            this.zzm.zzf(zzbfVar, i, zzfl.zzs(j));
            zzaj(zzmsVarZzal, 0, true, 1, zzai(zzmsVarZzal), iZzs, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final Looper zzd() {
        return this.zzt;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzf(zzaz zzazVar) {
        zzat();
        zzazVar.getClass();
        this.zzn.zzd(zzazVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzg() {
        zzat();
        zzms zzmsVar = this.zzaa;
        if (zzmsVar.zze != 1) {
            return;
        }
        zzms zzmsVarZzf = zzmsVar.zzf(null);
        zzms zzmsVarZzam = zzam(zzmsVarZzf, true != zzmsVarZzf.zza.zzg() ? 2 : 4);
        this.zzG++;
        this.zzm.zzd();
        zzaj(zzmsVarZzam, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzh() {
        zzat();
        return this.zzaa.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzi() {
        zzat();
        return this.zzaa.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzj(boolean z) {
        zzat();
        zzms zzmsVar = this.zzaa;
        int i = zzmsVar.zzn;
        int i2 = 0;
        if (i == 1) {
            if (z) {
                i = 1;
            } else {
                i = 1;
                i2 = 1;
            }
        }
        if (zzmsVar.zzl == z && i == i2 && zzmsVar.zzm == 1) {
            return;
        }
        this.zzG++;
        boolean z2 = zzmsVar.zzp;
        zzms zzmsVarZzi = zzmsVar.zzi(z, 1, i2);
        this.zzm.zze(z, 1, i2);
        zzaj(zzmsVarZzi, 0, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzk() {
        zzat();
        return this.zzaa.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzl() {
        zzat();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzm() {
        zzat();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzav zzn() {
        zzat();
        return this.zzaa.zzo;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zzo() {
        zzat();
        zzP(null);
        new zzcz(zzgwm.zzi(), this.zzaa.zzs);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbn zzp() {
        zzat();
        return this.zzaa.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final zzbf zzq() {
        zzat();
        return this.zzaa.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzr() {
        zzat();
        if (!this.zzaa.zza.zzg()) {
            zzms zzmsVar = this.zzaa;
            return zzmsVar.zza.zze(zzmsVar.zzb.zza);
        }
        int i = this.zzab;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzs() {
        zzat();
        int iZzag = zzag(this.zzaa);
        if (iZzag == -1) {
            return 0;
        }
        return iZzag;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzt() {
        zzat();
        if (!zzx()) {
            zzbf zzbfVarZzq = zzq();
            return zzbfVarZzq.zzg() ? C.TIME_UNSET : zzfl.zzr(zzbfVarZzq.zzb(zzs(), this.zza, 0L).zzm);
        }
        zzms zzmsVar = this.zzaa;
        zzxk zzxkVar = zzmsVar.zzb;
        zzbf zzbfVar = zzmsVar.zza;
        Object obj = zzxkVar.zza;
        zzbd zzbdVar = this.zzp;
        zzbfVar.zzo(obj, zzbdVar);
        return zzfl.zzr(zzbdVar.zzh(zzxkVar.zzb, zzxkVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzu() {
        zzat();
        return zzfl.zzr(zzai(this.zzaa));
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzv() {
        zzat();
        if (zzx()) {
            zzms zzmsVar = this.zzaa;
            return zzmsVar.zzk.equals(zzmsVar.zzb) ? zzfl.zzr(this.zzaa.zzq) : zzt();
        }
        zzat();
        if (this.zzaa.zza.zzg()) {
            return this.zzac;
        }
        zzms zzmsVar2 = this.zzaa;
        long j = 0;
        if (zzmsVar2.zzk.zzd != zzmsVar2.zzb.zzd) {
            return zzfl.zzr(zzmsVar2.zza.zzb(zzs(), this.zza, 0L).zzm);
        }
        long j2 = zzmsVar2.zzq;
        if (this.zzaa.zzk.zzb()) {
            zzms zzmsVar3 = this.zzaa;
            zzmsVar3.zza.zzo(zzmsVar3.zzk.zza, this.zzp).zzc(this.zzaa.zzk.zzb);
        } else {
            j = j2;
        }
        zzms zzmsVar4 = this.zzaa;
        zzao(zzmsVar4.zza, zzmsVar4.zzk, j);
        return zzfl.zzr(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final long zzw() {
        zzat();
        return zzfl.zzr(this.zzaa.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final boolean zzx() {
        zzat();
        return this.zzaa.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzy() {
        zzat();
        if (zzx()) {
            return this.zzaa.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final int zzz() {
        zzat();
        if (zzx()) {
            return this.zzaa.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbb
    public final void zze(zzaz zzazVar) {
        zzazVar.getClass();
        this.zzn.zzc(zzazVar);
    }
}
