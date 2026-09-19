package com.google.android.gms.internal.ads;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.mp4.Atom;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamc implements zzafy {
    public static final /* synthetic */ int zza = 0;
    private zzagb zzA;
    private zzamb[] zzB;
    private long[][] zzC;
    private int zzD;
    private final zzanj zzb;
    private final int zzc;
    private final zzet zzd;
    private final zzet zze;
    private final zzet zzf;
    private final zzet zzg;
    private final ArrayDeque zzh;
    private final zzamg zzi;
    private final List zzj;
    private zzgwm zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private int zzo;
    private zzet zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private int zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private long zzx;
    private boolean zzy;
    private long zzz;

    static {
        int i = zzaly.zza;
    }

    @Deprecated
    public zzamc() {
        this(zzanj.zza, 16);
    }

    static /* synthetic */ long zzh(zzaml zzamlVar, long j, long j2) {
        int iZzl = zzl(zzamlVar, j);
        return iZzl == -1 ? j2 : Math.min(zzamlVar.zzc[iZzl], j2);
    }

    private final void zzj() {
        this.zzl = 0;
        this.zzo = 0;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0299  */
    /* JADX WARN: Code duplicated, block: B:125:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:128:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:129:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:132:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:133:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:177:0x03bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:183:0x0002 A[SYNTHETIC] */
    private final void zzk(long j) throws zzat {
        zzap zzapVarZze;
        ArrayDeque arrayDeque;
        zzap zzapVar;
        List list;
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        int i2;
        long j2;
        int i3;
        zzap zzapVar2;
        List list2;
        zzap zzapVar3;
        int size;
        ArrayList arrayList3;
        zzfv zzfvVar;
        int i4;
        while (true) {
            ArrayDeque arrayDeque2 = this.zzh;
            if (arrayDeque2.isEmpty() || ((zzfx) arrayDeque2.peek()).zza != j) {
                break;
            }
            zzfx zzfxVar = (zzfx) arrayDeque2.pop();
            if (zzfxVar.zzd == 1836019574) {
                zzfx zzfxVarZzd = zzfxVar.zzd(Atom.TYPE_meta);
                ArrayList arrayList4 = new ArrayList();
                if (zzfxVarZzd != null) {
                    zzapVarZze = zzalj.zze(zzfxVarZzd);
                    if (this.zzy) {
                        zzapVarZze.getClass();
                        zzfv zzfvVar2 = (zzfv) zzapVarZze.zzc(zzfv.class, zzalw.zza);
                        if (zzfvVar2 != null && zzfvVar2.zzb[0] == 0) {
                            this.zzz = this.zzx + 16;
                        }
                        zzfv zzfvVar3 = (zzfv) zzapVarZze.zzc(zzfv.class, zzalx.zza);
                        zzfvVar3.getClass();
                        List listZzb = zzfvVar3.zzb();
                        ArrayList arrayList5 = new ArrayList(listZzb.size());
                        for (int i5 = 0; i5 < listZzb.size(); i5++) {
                            int iIntValue = ((Integer) listZzb.get(i5)).intValue();
                            if (iIntValue == 0) {
                                i4 = 1;
                            } else if (iIntValue == 1) {
                                i4 = 2;
                            } else if (iIntValue != 2) {
                                i4 = iIntValue != 3 ? 0 : 4;
                            } else {
                                i4 = 3;
                            }
                            arrayList5.add(Integer.valueOf(i4));
                        }
                        arrayList4 = arrayList5;
                    } else {
                        if (zzapVarZze != null && (this.zzc & 64) != 0 && (zzfvVar = (zzfv) zzapVarZze.zzc(zzfv.class, zzalv.zza)) != null) {
                            long jZzJ = new zzet(zzfvVar.zzb).zzJ();
                            if (jZzJ > 0) {
                                this.zzx = jZzJ;
                                this.zzw = true;
                                arrayDeque = arrayDeque2;
                            }
                        }
                        arrayDeque.clear();
                        if (!this.zzw) {
                            this.zzl = 2;
                        }
                    }
                } else {
                    zzapVarZze = null;
                }
                ArrayList arrayList6 = new ArrayList();
                int i6 = this.zzD;
                ArrayList arrayList7 = arrayList4;
                zzagr zzagrVar = new zzagr();
                zzfy zzfyVarZzc = zzfxVar.zzc(Atom.TYPE_udta);
                if (zzfyVarZzc != null) {
                    zzap zzapVarZzc = zzalj.zzc(zzfyVarZzc);
                    zzagrVar.zza(zzapVarZzc);
                    zzapVar = zzapVarZzc;
                } else {
                    zzapVar = null;
                }
                zzao[] zzaoVarArr = new zzao[1];
                zzfy zzfyVarZzc2 = zzfxVar.zzc(Atom.TYPE_mvhd);
                zzfyVarZzc2.getClass();
                boolean z = 1 == i6;
                zzaoVarArr[0] = zzalj.zzd(zzfyVarZzc2.zza);
                zzap zzapVar4 = new zzap(C.TIME_UNSET, zzaoVarArr);
                int i7 = this.zzc;
                ArrayList arrayList8 = arrayList7;
                ArrayList arrayList9 = arrayList6;
                List listZzb2 = zzalj.zzb(zzfxVar, zzagrVar, C.TIME_UNSET, null, 1 == (i7 & 1), z, zzalz.zza, false);
                if (this.zzy) {
                    zzgtj.zzj(arrayList8.size() == listZzb2.size(), String.format(Locale.US, "The number of auxiliary track types from metadata (%d) is not same as the number of auxiliary tracks (%d)", Integer.valueOf(arrayList8.size()), Integer.valueOf(listZzb2.size())));
                }
                String strZza = zzalu.zza(listZzb2);
                long j3 = -9223372036854775807L;
                long j4 = -9223372036854775807L;
                int i8 = 0;
                int i9 = 0;
                int i10 = -1;
                while (i8 < listZzb2.size()) {
                    zzaml zzamlVar = (zzaml) listZzb2.get(i8);
                    int i11 = zzamlVar.zzb;
                    if (i11 == 0) {
                        list = listZzb2;
                        size = i10;
                        arrayList2 = arrayList8;
                        arrayList3 = arrayList9;
                        i = i8;
                    } else {
                        zzami zzamiVar = zzamlVar.zza;
                        zzagb zzagbVar = this.zzA;
                        int i12 = i9 + 1;
                        int i13 = zzamiVar.zzb;
                        zzamb zzambVar = new zzamb(zzamiVar, zzamlVar, zzagbVar.zzu(i9, i13));
                        List list3 = listZzb2;
                        long j5 = zzamiVar.zze;
                        if (j5 == j4) {
                            j5 = zzamlVar.zzi;
                        }
                        list = list3;
                        zzahk zzahkVar = zzambVar.zzc;
                        zzahkVar.zzO(j5);
                        long jMax = Math.max(j3, j5);
                        zzv zzvVar = zzamiVar.zzg;
                        String str = zzvVar.zzp;
                        int i14 = MimeTypes.AUDIO_TRUEHD.equals(str) ? zzamlVar.zze * 16 : zzamlVar.zze + 30;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzp(i14);
                        if (i13 == 2) {
                            int i15 = zzvVar.zzf;
                            if ((i7 & 8) != 0) {
                                i15 |= i10 == -1 ? 1 : 2;
                            }
                            if (this.zzy) {
                                arrayList = arrayList8;
                                zztVarZza.zzh(((Integer) arrayList.get(i8)).intValue());
                                i15 |= 32768;
                            } else {
                                arrayList = arrayList8;
                            }
                            zztVarZza.zzg(i15);
                            i13 = 2;
                        } else {
                            arrayList = arrayList8;
                        }
                        if (zzas.zzb(str)) {
                            i = i8;
                            boolean z2 = zzamlVar.zzj;
                            arrayList2 = arrayList;
                            int iMin = Math.min(!z2 ? zzamlVar.zzh.length : i11, 20);
                            zzgtj.zzi(j5 != j4);
                            i2 = i10;
                            long jMin = Math.min(j5, 10000000L);
                            int i16 = 0;
                            int i17 = -1;
                            for (int i18 = 0; i18 < iMin; i18++) {
                                int i19 = z2 ? i18 : zzamlVar.zzh[i18];
                                long j6 = zzamlVar.zzf[i19];
                                if (j6 > jMin) {
                                    break;
                                }
                                if (j6 >= 0 && (i3 = zzamlVar.zzd[i19]) > i16) {
                                    i16 = i3;
                                    i17 = i19;
                                }
                            }
                            if (i17 != -1) {
                                j2 = zzamlVar.zzf[i17];
                            }
                            if (j2 != j4) {
                                zzapVar2 = new zzap(j4, new zzaiz(j2));
                            } else {
                                zzapVar2 = null;
                            }
                            zzalt.zzb(i13, zzagrVar, zztVarZza);
                            zzap zzapVar5 = zzvVar.zzl;
                            zzap[] zzapVarArr = new zzap[4];
                            list2 = this.zzj;
                            if (list2.isEmpty()) {
                                zzapVar3 = null;
                            } else {
                                zzapVar3 = new zzap(list2);
                            }
                            zzapVarArr[0] = zzapVar3;
                            zzapVarArr[1] = zzapVar;
                            zzapVarArr[2] = zzapVar4;
                            zzapVarArr[3] = zzapVar2;
                            zzalt.zza(i13, zzapVarZze, zztVarZza, zzapVar5, zzapVarArr);
                            zztVarZza.zzn(strZza);
                            if (Objects.equals(str, MimeTypes.AUDIO_MPEG)) {
                                zzambVar.zzf = zztVarZza.zzO();
                            } else {
                                zzahkVar.zzA(zztVarZza.zzO());
                            }
                            size = i2;
                            if (i13 == 2 && size == -1) {
                                size = arrayList9.size();
                            }
                            arrayList3 = arrayList9;
                            arrayList3.add(zzambVar);
                            i9 = i12;
                            j3 = jMax;
                        } else {
                            i = i8;
                            arrayList2 = arrayList;
                            i2 = i10;
                        }
                        j2 = j4;
                        if (j2 != j4) {
                            zzapVar2 = new zzap(j4, new zzaiz(j2));
                        } else {
                            zzapVar2 = null;
                        }
                        zzalt.zzb(i13, zzagrVar, zztVarZza);
                        zzap zzapVar6 = zzvVar.zzl;
                        zzap[] zzapVarArr2 = new zzap[4];
                        list2 = this.zzj;
                        if (list2.isEmpty()) {
                            zzapVar3 = null;
                        } else {
                            zzapVar3 = new zzap(list2);
                        }
                        zzapVarArr2[0] = zzapVar3;
                        zzapVarArr2[1] = zzapVar;
                        zzapVarArr2[2] = zzapVar4;
                        zzapVarArr2[3] = zzapVar2;
                        zzalt.zza(i13, zzapVarZze, zztVarZza, zzapVar6, zzapVarArr2);
                        zztVarZza.zzn(strZza);
                        if (Objects.equals(str, MimeTypes.AUDIO_MPEG)) {
                            zzambVar.zzf = zztVarZza.zzO();
                        } else {
                            zzahkVar.zzA(zztVarZza.zzO());
                        }
                        size = i2;
                        if (i13 == 2) {
                            size = arrayList9.size();
                        }
                        arrayList3 = arrayList9;
                        arrayList3.add(zzambVar);
                        i9 = i12;
                        j3 = jMax;
                    }
                    i8 = i + 1;
                    i10 = size;
                    arrayList9 = arrayList3;
                    arrayDeque2 = arrayDeque2;
                    listZzb2 = list;
                    arrayList8 = arrayList2;
                    j4 = C.TIME_UNSET;
                }
                arrayDeque = arrayDeque2;
                int i20 = i10;
                int i21 = -1;
                zzamb[] zzambVarArr = (zzamb[]) arrayList9.toArray(new zzamb[0]);
                this.zzB = zzambVarArr;
                int length = zzambVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i22 = 0; i22 < zzambVarArr.length; i22++) {
                    jArr[i22] = new long[zzambVarArr[i22].zzb.zzb];
                    jArr2[i22] = zzambVarArr[i22].zzb.zzf[0];
                }
                int i23 = 0;
                long j7 = 0;
                while (i23 < zzambVarArr.length) {
                    long j8 = Long.MAX_VALUE;
                    int i24 = i21;
                    for (int i25 = 0; i25 < zzambVarArr.length; i25++) {
                        if (!zArr[i25]) {
                            long j9 = jArr2[i25];
                            if (j9 <= j8) {
                                i24 = i25;
                                j8 = j9;
                            }
                        }
                    }
                    int i26 = iArr[i24];
                    long[] jArr3 = jArr[i24];
                    jArr3[i26] = j7;
                    zzaml zzamlVar2 = zzambVarArr[i24].zzb;
                    zzamb[] zzambVarArr2 = zzambVarArr;
                    j7 += (long) zzamlVar2.zzd[i26];
                    int i27 = i26 + 1;
                    iArr[i24] = i27;
                    if (i27 < jArr3.length) {
                        jArr2[i24] = zzamlVar2.zzf[i27];
                    } else {
                        zArr[i24] = true;
                        i23++;
                    }
                    zzambVarArr = zzambVarArr2;
                    i21 = -1;
                }
                this.zzC = jArr;
                this.zzA.zzv();
                this.zzA.zzw(new zzama(j3, this.zzB, i20));
                arrayDeque.clear();
                if (!this.zzw) {
                    this.zzl = 2;
                }
            } else if (!arrayDeque2.isEmpty()) {
                ((zzfx) arrayDeque2.peek()).zzb(zzfxVar);
            }
        }
        if (this.zzl != 2) {
            zzj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzl(zzaml zzamlVar, long j) {
        int iZza = zzamlVar.zza(j);
        return iZza == -1 ? zzamlVar.zzb(j) : iZza;
    }

    private static int zzm(int i) {
        return i != 1903435808 ? 0 : 1;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzahf zzahfVarZzb = zzamh.zzb(zzafzVar);
        this.zzk = zzahfVarZzb != null ? zzgwm.zzj(zzahfVarZzb) : zzgwm.zzi();
        return zzahfVarZzb == null;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final /* synthetic */ List zzb() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        if ((this.zzc & 16) == 0) {
            zzagbVar = new zzanm(zzagbVar, this.zzb);
        }
        this.zzA = zzagbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        this.zzh.clear();
        this.zzo = 0;
        this.zzq = -1;
        this.zzr = 0;
        this.zzs = 0;
        this.zzt = 0;
        this.zzu = false;
        if (j == 0) {
            if (this.zzl != 3) {
                zzj();
                return;
            } else {
                this.zzi.zza();
                this.zzj.clear();
                return;
            }
        }
        for (zzamb zzambVar : this.zzB) {
            zzaml zzamlVar = zzambVar.zzb;
            int iZza = zzamlVar.zza(j2);
            if (iZza == -1) {
                iZza = zzamlVar.zzb(j2);
            }
            zzambVar.zze = iZza;
            zzahl zzahlVar = zzambVar.zzd;
            if (zzahlVar != null) {
                zzahlVar.zza();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }

    public zzamc(zzanj zzanjVar, int i) {
        this.zzb = zzanjVar;
        this.zzc = i;
        this.zzk = zzgwm.zzi();
        this.zzl = (i & 4) != 0 ? 3 : 0;
        this.zzi = new zzamg();
        this.zzj = new ArrayList();
        this.zzg = new zzet(16);
        this.zzh = new ArrayDeque();
        this.zzd = new zzet(zzgp.zza);
        this.zze = new zzet(6);
        this.zzf = new zzet();
        this.zzq = -1;
        this.zzA = zzagb.zza;
        this.zzB = new zzamb[0];
    }

    /* JADX WARN: Code duplicated, block: B:163:0x033c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:270:0x0346 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:271:0x0332 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x0340 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:292:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:293:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:299:0x009a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0085  */
    /* JADX WARN: Code duplicated, block: B:38:0x0094  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        long j;
        long j2;
        int i;
        int iZzc;
        boolean z;
        boolean z2;
        int i2;
        while (true) {
            int i3 = this.zzl;
            if (i3 == 0) {
                if (this.zzo == 0) {
                    zzet zzetVar = this.zzg;
                    if (!zzafzVar.zzb(zzetVar.zzi(), 0, 8, true)) {
                        return -1;
                    }
                    this.zzo = 8;
                    zzetVar.zzh(0);
                    this.zzn = zzetVar.zzz();
                    this.zzm = zzetVar.zzB();
                }
                long j3 = this.zzn;
                if (j3 == 1) {
                    zzet zzetVar2 = this.zzg;
                    zzafzVar.zzc(zzetVar2.zzi(), 8, 8);
                    this.zzo += 8;
                    this.zzn = zzetVar2.zzJ();
                } else if (j3 == 0) {
                    long jZzo = zzafzVar.zzo();
                    if (jZzo == -1) {
                        zzfx zzfxVar = (zzfx) this.zzh.peek();
                        jZzo = zzfxVar != null ? zzfxVar.zza : -1L;
                    }
                    if (jZzo != -1) {
                        this.zzn = (jZzo - zzafzVar.zzn()) + ((long) this.zzo);
                    }
                }
                long j4 = this.zzn;
                int i4 = this.zzo;
                long j5 = i4;
                if (j4 < j5) {
                    if (this.zzm != 1718773093 || i4 != 8) {
                        throw zzat.zzc("Atom size less than header length (unsupported).");
                    }
                    this.zzn = j5;
                    i4 = 8;
                }
                int i5 = this.zzm;
                if (i5 == 1836019574 || i5 == 1953653099 || i5 == 1835297121 || i5 == 1835626086 || i5 == 1937007212 || i5 == 1701082227 || i5 == 1835365473 || i5 == 1635284069) {
                    long jZzn = zzafzVar.zzn();
                    long j6 = this.zzn;
                    long j7 = jZzn + j6;
                    long j8 = this.zzo;
                    if (j6 != j8 && this.zzm == 1835365473) {
                        zzet zzetVar3 = this.zzf;
                        zzetVar3.zza(8);
                        zzafzVar.zzi(zzetVar3.zzi(), 0, 8);
                        zzalj.zzf(zzetVar3);
                        zzafzVar.zzf(zzetVar3.zzg());
                        zzafzVar.zzl();
                    }
                    long j9 = j7 - j8;
                    this.zzh.push(new zzfx(this.zzm, j9));
                    if (this.zzn == this.zzo) {
                        zzk(j9);
                    } else {
                        zzj();
                    }
                } else {
                    if (i5 == 1835296868 || i5 == 1836476516 || i5 == 1751411826 || i5 == 1937011556 || i5 == 1937011827 || i5 == 1937011571 || i5 == 1668576371 || i5 == 1701606260 || i5 == 1937011555 || i5 == 1937011578 || i5 == 1937013298 || i5 == 1937007471 || i5 == 1668232756 || i5 == 1953196132 || i5 == 1718909296 || i5 == 1969517665 || i5 == 1801812339 || i5 == 1768715124) {
                        zzgtj.zzi(i4 == 8);
                        zzgtj.zzi(this.zzn <= 2147483647L);
                        zzet zzetVar4 = new zzet((int) this.zzn);
                        System.arraycopy(this.zzg.zzi(), 0, zzetVar4.zzi(), 0, 8);
                        this.zzp = zzetVar4;
                    } else {
                        this.zzp = null;
                    }
                    this.zzl = 1;
                }
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        this.zzi.zzb(zzafzVar, zzagyVar, this.zzj);
                        if (zzagyVar.zza == 0) {
                            zzj();
                        }
                        return 1;
                    }
                    long jZzn2 = zzafzVar.zzn();
                    int i6 = this.zzq;
                    if (i6 == -1) {
                        j = 0;
                        int i7 = -1;
                        int i8 = -1;
                        boolean z3 = true;
                        boolean z4 = true;
                        long j10 = Long.MAX_VALUE;
                        long j11 = Long.MAX_VALUE;
                        long j12 = Long.MAX_VALUE;
                        int i9 = 0;
                        while (true) {
                            zzamb[] zzambVarArr = this.zzB;
                            if (i9 >= zzambVarArr.length) {
                                break;
                            }
                            zzamb zzambVar = zzambVarArr[i9];
                            int i10 = zzambVar.zze;
                            zzaml zzamlVar = zzambVar.zzb;
                            if (i10 != zzamlVar.zzb) {
                                long j13 = zzamlVar.zzc[i10];
                                long[][] jArr = this.zzC;
                                jArr.getClass();
                                long j14 = jArr[i9][i10];
                                long j15 = j13 - jZzn2;
                                boolean z5 = j15 < 0 || j15 >= 262144;
                                if (z5) {
                                    z = z4;
                                } else {
                                    if (z4) {
                                        z4 = z5;
                                        i8 = i9;
                                        j12 = j15;
                                        j11 = j14;
                                    } else {
                                        z = false;
                                    }
                                    if (j14 < j10) {
                                        z3 = z5;
                                        i7 = i9;
                                        j10 = j14;
                                    }
                                }
                                if (z5 != z || j15 >= j12) {
                                    z4 = z;
                                } else {
                                    z4 = z5;
                                    i8 = i9;
                                    j12 = j15;
                                    j11 = j14;
                                }
                                if (j14 < j10) {
                                    z3 = z5;
                                    i7 = i9;
                                    j10 = j14;
                                }
                            }
                            i9++;
                        }
                        j2 = 262144;
                        i6 = (j10 == Long.MAX_VALUE || !z3 || j11 < j10 + 10485760) ? i8 : i7;
                        this.zzq = i6;
                        if (i6 == -1) {
                            return -1;
                        }
                    } else {
                        j = 0;
                        j2 = 262144;
                    }
                    zzamb zzambVar2 = this.zzB[i6];
                    zzahk zzahkVar = zzambVar2.zzc;
                    int i11 = zzambVar2.zze;
                    zzaml zzamlVar2 = zzambVar2.zzb;
                    long j16 = zzamlVar2.zzc[i11] + this.zzz;
                    int[] iArr = zzamlVar2.zzd;
                    int i12 = iArr[i11];
                    zzahl zzahlVar = zzambVar2.zzd;
                    int i13 = 0;
                    long j17 = (j16 - jZzn2) + ((long) this.zzr);
                    if (j17 < j || j17 >= j2) {
                        zzagyVar.zza = j16;
                        return 1;
                    }
                    zzami zzamiVar = zzambVar2.zza;
                    if (zzamiVar.zzh == 1) {
                        j17 += 8;
                        i12 -= 8;
                    }
                    int i14 = i12;
                    zzafzVar.zzf((int) j17);
                    zzv zzvVar = zzamiVar.zzg;
                    String str = zzvVar.zzp;
                    if (!Objects.equals(str, MimeTypes.VIDEO_H264) ? !(!Objects.equals(str, MimeTypes.VIDEO_H265) ? Objects.equals(str, "video/apv") : (this.zzc & 128) != 0) : (this.zzc & 32) == 0) {
                        this.zzu = true;
                    }
                    int i15 = zzamiVar.zzk;
                    if (i15 == 0) {
                        if (MimeTypes.AUDIO_AC4.equals(str)) {
                            if (this.zzs == 0) {
                                zzet zzetVar5 = this.zzf;
                                zzafb.zzc(i14, zzetVar5);
                                zzahkVar.zzc(zzetVar5, 7);
                                this.zzs += 7;
                            }
                            i14 += 7;
                        } else if (zzambVar2.zzf != null && Objects.equals(str, MimeTypes.AUDIO_MPEG)) {
                            zzv zzvVarZzO = zzambVar2.zzf;
                            zzet zzetVar6 = this.zzf;
                            zzetVar6.zza(4);
                            zzafzVar.zzi(zzetVar6.zzi(), 0, 4);
                            zzafzVar.zzl();
                            zzagv zzagvVar = new zzagv();
                            if (zzagvVar.zza(zzetVar6.zzB()) && !Objects.equals(zzvVarZzO.zzp, zzagvVar.zzb)) {
                                zzt zztVarZza = zzvVarZzO.zza();
                                String str2 = zzagvVar.zzb;
                                str2.getClass();
                                zztVarZza.zzo(str2);
                                zzvVarZzO = zztVarZza.zzO();
                            }
                            zzahkVar.zzA(zzvVarZzO);
                            zzambVar2.zzf = null;
                        } else if (zzahlVar != null) {
                            zzahlVar.zzb(zzafzVar);
                        }
                        while (true) {
                            int i16 = this.zzs;
                            if (i16 >= i14) {
                                break;
                            }
                            int iZza = zzahkVar.zza(zzafzVar, i14 - i16, false);
                            this.zzr += iZza;
                            this.zzs += iZza;
                            this.zzt -= iZza;
                        }
                    } else {
                        zzet zzetVar7 = this.zze;
                        byte[] bArrZzi = zzetVar7.zzi();
                        bArrZzi[0] = 0;
                        bArrZzi[1] = 0;
                        bArrZzi[2] = 0;
                        int i17 = 4 - i15;
                        i14 += i17;
                        while (this.zzs < i14) {
                            int i18 = this.zzt;
                            if (i18 == 0) {
                                if (this.zzu || zzgp.zzc(zzvVar) + i15 > iArr[i11] - this.zzr) {
                                    i = i15;
                                    iZzc = i13;
                                } else {
                                    iZzc = zzgp.zzc(zzvVar);
                                    i = i15 + iZzc;
                                }
                                zzafzVar.zzc(bArrZzi, i17, i);
                                this.zzr += i;
                                int i19 = i13;
                                zzetVar7.zzh(i19);
                                int iZzB = zzetVar7.zzB();
                                if (iZzB < 0) {
                                    throw zzat.zzb("Invalid NAL length", null);
                                }
                                this.zzt = iZzB - iZzc;
                                zzet zzetVar8 = this.zzd;
                                zzetVar8.zzh(i19);
                                zzahkVar.zzc(zzetVar8, 4);
                                this.zzs += 4;
                                if (iZzc > 0) {
                                    zzahkVar.zzc(zzetVar7, iZzc);
                                    this.zzs += iZzc;
                                    if (zzgp.zzd(bArrZzi, 4, iZzc, zzvVar)) {
                                        this.zzu = true;
                                    }
                                }
                                i13 = 0;
                            } else {
                                int iZza2 = zzahkVar.zza(zzafzVar, i18, i13);
                                this.zzr += iZza2;
                                this.zzs += iZza2;
                                this.zzt -= iZza2;
                            }
                            i13 = 0;
                        }
                    }
                    int i20 = i14;
                    long j18 = zzamlVar2.zzf[i11];
                    int i21 = zzamlVar2.zzg[i11];
                    if (!this.zzu) {
                        i21 |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                    }
                    int i22 = i21;
                    if (zzahlVar != null) {
                        zzahlVar.zzc(zzahkVar, j18, i22, i20, 0, null);
                        if (i11 + 1 == zzamlVar2.zzb) {
                            zzahlVar.zzd(zzahkVar, null);
                        }
                    } else {
                        zzahkVar.zze(j18, i22, i20, 0, null);
                    }
                    zzambVar2.zze++;
                    this.zzq = -1;
                    this.zzr = 0;
                    this.zzs = 0;
                    this.zzt = 0;
                    this.zzu = false;
                    return 0;
                }
                long j19 = this.zzn - ((long) this.zzo);
                long jZzn3 = zzafzVar.zzn() + j19;
                zzet zzetVar9 = this.zzp;
                if (zzetVar9 != null) {
                    zzafzVar.zzc(zzetVar9.zzi(), this.zzo, (int) j19);
                    if (this.zzm == 1718909296) {
                        this.zzv = true;
                        zzetVar9.zzh(8);
                        if (zzm(zzetVar9.zzB()) == 0) {
                            zzetVar9.zzk(4);
                            while (true) {
                                if (zzetVar9.zzd() <= 0) {
                                    i2 = 0;
                                    break;
                                }
                                if (zzm(zzetVar9.zzB()) != 0) {
                                    i2 = 1;
                                    break;
                                }
                            }
                        } else {
                            i2 = 1;
                            break;
                        }
                        this.zzD = i2;
                    } else {
                        ArrayDeque arrayDeque = this.zzh;
                        if (!arrayDeque.isEmpty()) {
                            ((zzfx) arrayDeque.peek()).zza(new zzfy(this.zzm, zzetVar9));
                        }
                    }
                } else {
                    if (!this.zzv && this.zzm == 1835295092) {
                        this.zzD = 1;
                    }
                    if (j19 < 262144) {
                        zzafzVar.zzf((int) j19);
                    } else {
                        zzagyVar.zza = zzafzVar.zzn() + j19;
                        z2 = true;
                    }
                    zzk(jZzn3);
                    if (this.zzw) {
                        this.zzy = true;
                        zzagyVar.zza = this.zzx;
                        this.zzw = false;
                    } else if (!z2) {
                        continue;
                    }
                    if (this.zzl != 2) {
                        return 1;
                    }
                }
                z2 = false;
                zzk(jZzn3);
                if (this.zzw) {
                    this.zzy = true;
                    zzagyVar.zza = this.zzx;
                    this.zzw = false;
                } else if (!z2) {
                    continue;
                }
                if (this.zzl != 2) {
                    return 1;
                }
            }
        }
    }
}
