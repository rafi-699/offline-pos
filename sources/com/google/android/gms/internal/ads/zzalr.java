package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalr implements zzafy {
    private static final byte[] zza;
    private static final zzv zzb;
    private long zzA;
    private long zzB;
    private zzalq zzC;
    private int zzD;
    private int zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private zzagb zzI;
    private zzahk[] zzJ;
    private zzahk[] zzK;
    private boolean zzL;
    private boolean zzM;
    private long zzN;
    private long zzO;
    private final zzanj zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzet zzg;
    private final zzet zzh;
    private final zzet zzi;
    private final byte[] zzj;
    private final zzet zzk;
    private final zzajb zzl;
    private final zzet zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private final zzgz zzp;
    private final zzafn zzq;
    private zzgwm zzr;
    private int zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private zzet zzw;
    private long zzx;
    private int zzy;
    private long zzz;

    static {
        int i = zzalm.zza;
        zza = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        zzt zztVar = new zzt();
        zztVar.zzo(MimeTypes.APPLICATION_EMSG);
        zzb = zztVar.zzO();
    }

    @Deprecated
    public zzalr() {
        this(zzanj.zza, 32, null, null, zzgwm.zzi(), null);
    }

    private final void zzi() {
        this.zzs = 0;
        this.zzv = 0;
    }

    /* JADX WARN: Code duplicated, block: B:139:0x0400  */
    /* JADX WARN: Code duplicated, block: B:142:0x0415 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x0417  */
    /* JADX WARN: Code duplicated, block: B:144:0x0420  */
    /* JADX WARN: Code duplicated, block: B:147:0x0429  */
    /* JADX WARN: Code duplicated, block: B:148:0x0434  */
    /* JADX WARN: Code duplicated, block: B:151:0x043d  */
    /* JADX WARN: Code duplicated, block: B:152:0x0442  */
    /* JADX WARN: Code duplicated, block: B:153:0x0444 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:154:0x0446  */
    /* JADX WARN: Code duplicated, block: B:155:0x044b  */
    /* JADX WARN: Code duplicated, block: B:156:0x044d A[PHI: r32
  0x044d: PHI (r32v4 int) = (r5v57 int), (r32v5 int) binds: [B:152:0x0442, B:155:0x044b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:158:0x0451  */
    /* JADX WARN: Code duplicated, block: B:159:0x045a  */
    /* JADX WARN: Code duplicated, block: B:162:0x0474  */
    /* JADX WARN: Code duplicated, block: B:165:0x0486 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:166:0x0488 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:167:0x048a  */
    /* JADX WARN: Code duplicated, block: B:168:0x048f  */
    /* JADX WARN: Code duplicated, block: B:169:0x0492  */
    private final void zzj(long j) throws zzat {
        zzap zzapVar;
        int i;
        int i2;
        byte[] bArr;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        long[] jArr;
        boolean[] zArr;
        int i7;
        boolean z2;
        int i8;
        long j2;
        long j3;
        int i9;
        int iZzB;
        int iZzB2;
        int iZzB3;
        int iZzB4;
        long jZzv;
        boolean z3;
        long[] jArr2;
        while (true) {
            ArrayDeque arrayDeque = this.zzn;
            if (arrayDeque.isEmpty() || ((zzfx) arrayDeque.peek()).zza != j) {
                break;
            }
            zzfx zzfxVar = (zzfx) arrayDeque.pop();
            int i10 = zzfxVar.zzd;
            int i11 = 12;
            int i12 = 8;
            char c = 1;
            if (i10 == 1836019574) {
                zzq zzqVarZzn = zzn(zzfxVar.zzb);
                zzfx zzfxVarZzd = zzfxVar.zzd(Atom.TYPE_mvex);
                zzfxVarZzd.getClass();
                SparseArray sparseArray = new SparseArray();
                List list = zzfxVarZzd.zzb;
                int size = list.size();
                int i13 = 0;
                long jZzz = C.TIME_UNSET;
                while (i13 < size) {
                    zzfy zzfyVar = (zzfy) list.get(i13);
                    int i14 = zzfyVar.zzd;
                    if (i14 == 1953654136) {
                        zzet zzetVar = zzfyVar.zza;
                        zzetVar.zzh(i11);
                        Pair pairCreate = Pair.create(Integer.valueOf(zzetVar.zzB()), new zzalk(zzetVar.zzB() - 1, zzetVar.zzB(), zzetVar.zzB(), zzetVar.zzB()));
                        sparseArray.put(((Integer) pairCreate.first).intValue(), (zzalk) pairCreate.second);
                    } else if (i14 == 1835362404) {
                        zzet zzetVar2 = zzfyVar.zza;
                        zzetVar2.zzh(8);
                        jZzz = zzalj.zza(zzetVar2.zzB()) == 0 ? zzetVar2.zzz() : zzetVar2.zzJ();
                    }
                    i13++;
                    i11 = 12;
                }
                zzfx zzfxVarZzd2 = zzfxVar.zzd(Atom.TYPE_meta);
                zzap zzapVarZze = zzfxVarZzd2 != null ? zzalj.zze(zzfxVarZzd2) : null;
                zzagr zzagrVar = new zzagr();
                zzfy zzfyVarZzc = zzfxVar.zzc(Atom.TYPE_udta);
                if (zzfyVarZzc != null) {
                    zzap zzapVarZzc = zzalj.zzc(zzfyVarZzc);
                    zzagrVar.zza(zzapVarZzc);
                    zzapVar = zzapVarZzc;
                } else {
                    zzapVar = null;
                }
                zzfy zzfyVarZzc2 = zzfxVar.zzc(Atom.TYPE_mvhd);
                zzfyVarZzc2.getClass();
                zzap zzapVar2 = new zzap(C.TIME_UNSET, zzalj.zzd(zzfyVarZzc2.zza));
                List listZzb = zzalj.zzb(zzfxVar, zzagrVar, jZzz, zzqVarZzn, (this.zzd & 16) != 0, false, new zzgta(this) { // from class: com.google.android.gms.internal.ads.zzall
                    @Override // com.google.android.gms.internal.ads.zzgta
                    public final /* synthetic */ Object apply(Object obj) {
                        return (zzami) obj;
                    }
                }, false);
                int size2 = listZzb.size();
                SparseArray sparseArray2 = this.zzf;
                if (sparseArray2.size() == 0) {
                    String strZza = zzalu.zza(listZzb);
                    int i15 = 0;
                    while (i15 < size2) {
                        zzaml zzamlVar = (zzaml) listZzb.get(i15);
                        zzami zzamiVar = zzamlVar.zza;
                        zzagb zzagbVar = this.zzI;
                        int i16 = zzamiVar.zzb;
                        zzahk zzahkVarZzu = zzagbVar.zzu(i15, i16);
                        char c2 = c;
                        long j4 = zzamiVar.zze;
                        zzahkVarZzu.zzO(j4);
                        int i17 = i15;
                        zzv zzvVar = zzamiVar.zzg;
                        zzap zzapVar3 = zzapVar2;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzn(strZza);
                        zzalt.zzb(i16, zzagrVar, zztVarZza);
                        zzagr zzagrVar2 = zzagrVar;
                        String str = strZza;
                        zzap[] zzapVarArr = new zzap[2];
                        zzapVarArr[0] = zzapVar;
                        zzapVarArr[c2] = zzapVar3;
                        zzalt.zza(i16, zzapVarZze, zztVarZza, zzvVar.zzl, zzapVarArr);
                        int i18 = zzamiVar.zza;
                        sparseArray2.put(i18, new zzalq(zzahkVarZzu, zzamlVar, zzp(sparseArray, i18), zztVarZza.zzO()));
                        this.zzA = Math.max(this.zzA, j4);
                        i15 = i17 + 1;
                        c = c2;
                        zzagrVar = zzagrVar2;
                        zzapVar2 = zzapVar3;
                        strZza = str;
                    }
                    this.zzI.zzv();
                } else {
                    zzgtj.zzi(sparseArray2.size() == size2);
                    for (int i19 = 0; i19 < size2; i19++) {
                        zzaml zzamlVar2 = (zzaml) listZzb.get(i19);
                        int i20 = zzamlVar2.zza.zza;
                        ((zzalq) sparseArray2.get(i20)).zza(zzamlVar2, zzp(sparseArray, i20));
                    }
                }
            } else {
                boolean z4 = true;
                int i21 = 16;
                int i22 = 0;
                if (i10 == 1836019558) {
                    SparseArray sparseArray3 = this.zzf;
                    int i23 = this.zzd;
                    byte[] bArr2 = this.zzj;
                    List list2 = zzfxVar.zzc;
                    int size3 = list2.size();
                    int i24 = 0;
                    while (i24 < size3) {
                        zzfx zzfxVar2 = (zzfx) list2.get(i24);
                        if (zzfxVar2.zzd == 1953653094) {
                            zzfy zzfyVarZzc3 = zzfxVar2.zzc(Atom.TYPE_tfhd);
                            zzfyVarZzc3.getClass();
                            zzet zzetVar3 = zzfyVarZzc3.zza;
                            zzetVar3.zzh(i12);
                            int iZzB5 = zzetVar3.zzB();
                            int i25 = zzalj.zza;
                            zzalq zzalqVar = (zzalq) sparseArray3.get(zzetVar3.zzB());
                            if (zzalqVar == null) {
                                zzalqVar = null;
                            } else {
                                if ((iZzB5 & 1) != 0) {
                                    long jZzJ = zzetVar3.zzJ();
                                    zzamk zzamkVar = zzalqVar.zzb;
                                    zzamkVar.zzb = jZzJ;
                                    zzamkVar.zzc = jZzJ;
                                }
                                zzalk zzalkVar = zzalqVar.zze;
                                zzalqVar.zzb.zza = new zzalk((iZzB5 & 2) != 0 ? zzetVar3.zzB() - 1 : zzalkVar.zza, (iZzB5 & 8) != 0 ? zzetVar3.zzB() : zzalkVar.zzb, (iZzB5 & 16) != 0 ? zzetVar3.zzB() : zzalkVar.zzc, (iZzB5 & 32) != 0 ? zzetVar3.zzB() : zzalkVar.zzd);
                            }
                            if (zzalqVar == null) {
                                i = 8;
                            } else {
                                zzamk zzamkVar2 = zzalqVar.zzb;
                                long j5 = zzamkVar2.zzp;
                                boolean z5 = zzamkVar2.zzq;
                                zzalqVar.zzc();
                                boolean z6 = z4;
                                zzalqVar.zzl(z6);
                                zzfy zzfyVarZzc4 = zzfxVar2.zzc(Atom.TYPE_tfdt);
                                if (zzfyVarZzc4 == null || (i23 & 2) != 0) {
                                    zzamkVar2.zzp = j5;
                                    zzamkVar2.zzq = z5;
                                } else {
                                    zzet zzetVar4 = zzfyVarZzc4.zza;
                                    zzetVar4.zzh(8);
                                    zzamkVar2.zzp = zzalj.zza(zzetVar4.zzB()) == z6 ? zzetVar4.zzJ() : zzetVar4.zzz();
                                    zzamkVar2.zzq = z6;
                                }
                                List list3 = zzfxVar2.zzb;
                                int size4 = list3.size();
                                i23 = i23;
                                int i26 = i22;
                                int i27 = i26;
                                int i28 = i27;
                                while (true) {
                                    i2 = Atom.TYPE_trun;
                                    if (i26 >= size4) {
                                        break;
                                    }
                                    List list4 = list2;
                                    zzfy zzfyVar2 = (zzfy) list3.get(i26);
                                    int i29 = size3;
                                    if (zzfyVar2.zzd == 1953658222) {
                                        zzet zzetVar5 = zzfyVar2.zza;
                                        zzetVar5.zzh(12);
                                        int iZzH = zzetVar5.zzH();
                                        if (iZzH > 0) {
                                            i28 += iZzH;
                                            i27++;
                                        }
                                    }
                                    i26++;
                                    size3 = i29;
                                    list2 = list4;
                                }
                                list2 = list2;
                                size3 = size3;
                                int i30 = i22;
                                zzalqVar.zzh = i30;
                                zzalqVar.zzg = i30;
                                zzalqVar.zzf = i30;
                                zzamkVar2.zzd = i27;
                                zzamkVar2.zze = i28;
                                if (zzamkVar2.zzg.length < i27) {
                                    zzamkVar2.zzf = new long[i27];
                                    zzamkVar2.zzg = new int[i27];
                                }
                                if (zzamkVar2.zzh.length < i28) {
                                    int i31 = (i28 * 125) / 100;
                                    zzamkVar2.zzh = new int[i31];
                                    zzamkVar2.zzi = new long[i31];
                                    zzamkVar2.zzj = new boolean[i31];
                                    zzamkVar2.zzl = new boolean[i31];
                                }
                                int i32 = 0;
                                int i33 = 0;
                                int i34 = 0;
                                while (i32 < size4) {
                                    long j6 = 0;
                                    zzfy zzfyVar3 = (zzfy) list3.get(i32);
                                    if (zzfyVar3.zzd == i2) {
                                        int i35 = i33 + 1;
                                        zzet zzetVar6 = zzfyVar3.zza;
                                        zzetVar6.zzh(8);
                                        int iZzB6 = zzetVar6.zzB();
                                        zzami zzamiVar2 = zzalqVar.zzd.zza;
                                        int i36 = i33;
                                        zzalk zzalkVar2 = zzamkVar2.zza;
                                        String str2 = zzfl.zza;
                                        zzamkVar2.zzg[i36] = zzetVar6.zzH();
                                        long[] jArr3 = zzamkVar2.zzf;
                                        int i37 = i34;
                                        long j7 = zzamkVar2.zzb;
                                        jArr3[i36] = j7;
                                        if ((iZzB6 & 1) != 0) {
                                            jArr3[i36] = j7 + ((long) zzetVar6.zzB());
                                        }
                                        boolean z7 = (iZzB6 & 4) != 0;
                                        int i38 = zzalkVar2.zzd;
                                        int iZzB7 = z7 ? zzetVar6.zzB() : i38;
                                        boolean z8 = z7;
                                        int i39 = iZzB6 & 256;
                                        int i40 = iZzB6 & 512;
                                        int i41 = iZzB6 & 1024;
                                        int i42 = iZzB6 & 2048;
                                        long[] jArr4 = zzamiVar2.zzi;
                                        if (jArr4 != null) {
                                            i4 = i41;
                                            if (jArr4.length == 1 && (jArr2 = zzamiVar2.zzj) != null) {
                                                long j8 = jArr4[0];
                                                if (j8 == 0) {
                                                    i5 = i38;
                                                    i6 = iZzB7;
                                                } else {
                                                    i5 = i38;
                                                    i6 = iZzB7;
                                                    if (zzfl.zzv(j8, 1000000L, zzamiVar2.zzd, RoundingMode.DOWN) + zzfl.zzv(jArr2[0], 1000000L, zzamiVar2.zzc, RoundingMode.DOWN) >= zzamiVar2.zze) {
                                                    }
                                                }
                                                j6 = jArr2[0];
                                            }
                                            iArr = zzamkVar2.zzh;
                                            jArr = zzamkVar2.zzi;
                                            zArr = zzamkVar2.zzj;
                                            i7 = i5;
                                            if (zzamiVar2.zzb == 2 || (i23 & 1) == 0) {
                                                z2 = false;
                                            } else {
                                                z2 = true;
                                            }
                                            i8 = i37 + zzamkVar2.zzg[i36];
                                            j2 = zzamiVar2.zzc;
                                            j3 = zzamkVar2.zzp;
                                            i9 = i37;
                                            while (i9 < i8) {
                                                if (i39 != 0) {
                                                    iZzB = zzetVar6.zzB();
                                                } else {
                                                    iZzB = zzalkVar2.zzb;
                                                }
                                                zzk(iZzB);
                                                if (i40 != 0) {
                                                    iZzB2 = zzetVar6.zzB();
                                                } else {
                                                    iZzB2 = zzalkVar2.zzc;
                                                }
                                                zzk(iZzB2);
                                                if (i4 != 0) {
                                                    iZzB3 = zzetVar6.zzB();
                                                } else if (i9 != 0) {
                                                    iZzB3 = i7;
                                                } else if (z8) {
                                                    iZzB3 = i6;
                                                    i9 = 0;
                                                } else {
                                                    i9 = 0;
                                                    iZzB3 = i7;
                                                }
                                                if (i42 != 0) {
                                                    iZzB4 = zzetVar6.zzB();
                                                } else {
                                                    iZzB4 = 0;
                                                }
                                                zzalk zzalkVar3 = zzalkVar2;
                                                jZzv = zzfl.zzv((((long) iZzB4) + j3) - j6, 1000000L, j2, RoundingMode.DOWN);
                                                jArr[i9] = jZzv;
                                                if (!zzamkVar2.zzq) {
                                                    jArr[i9] = jZzv + zzalqVar.zzd.zzi;
                                                }
                                                iArr[i9] = iZzB2;
                                                if (((iZzB3 >> 16) & 1) != 0) {
                                                    z3 = false;
                                                } else if (z2) {
                                                    z3 = true;
                                                } else if (i9 == 0) {
                                                    z3 = true;
                                                    i9 = 0;
                                                } else {
                                                    z3 = false;
                                                }
                                                zArr[i9] = z3;
                                                j3 += (long) iZzB;
                                                i9++;
                                                z2 = z2;
                                                zzalkVar2 = zzalkVar3;
                                            }
                                            zzamkVar2.zzp = j3;
                                            i34 = i8;
                                            i33 = i35;
                                        } else {
                                            i4 = i41;
                                        }
                                        i5 = i38;
                                        i6 = iZzB7;
                                        iArr = zzamkVar2.zzh;
                                        jArr = zzamkVar2.zzi;
                                        zArr = zzamkVar2.zzj;
                                        i7 = i5;
                                        if (zzamiVar2.zzb == 2) {
                                            z2 = false;
                                        } else {
                                            z2 = false;
                                        }
                                        i8 = i37 + zzamkVar2.zzg[i36];
                                        j2 = zzamiVar2.zzc;
                                        j3 = zzamkVar2.zzp;
                                        i9 = i37;
                                        while (i9 < i8) {
                                            if (i39 != 0) {
                                                iZzB = zzetVar6.zzB();
                                            } else {
                                                iZzB = zzalkVar2.zzb;
                                            }
                                            zzk(iZzB);
                                            if (i40 != 0) {
                                                iZzB2 = zzetVar6.zzB();
                                            } else {
                                                iZzB2 = zzalkVar2.zzc;
                                            }
                                            zzk(iZzB2);
                                            if (i4 != 0) {
                                                iZzB3 = zzetVar6.zzB();
                                            } else if (i9 != 0) {
                                                iZzB3 = i7;
                                            } else if (z8) {
                                                iZzB3 = i6;
                                                i9 = 0;
                                            } else {
                                                i9 = 0;
                                                iZzB3 = i7;
                                            }
                                            if (i42 != 0) {
                                                iZzB4 = zzetVar6.zzB();
                                            } else {
                                                iZzB4 = 0;
                                            }
                                            zzalk zzalkVar4 = zzalkVar2;
                                            jZzv = zzfl.zzv((((long) iZzB4) + j3) - j6, 1000000L, j2, RoundingMode.DOWN);
                                            jArr[i9] = jZzv;
                                            if (!zzamkVar2.zzq) {
                                                jArr[i9] = jZzv + zzalqVar.zzd.zzi;
                                            }
                                            iArr[i9] = iZzB2;
                                            if (((iZzB3 >> 16) & 1) != 0) {
                                                z3 = false;
                                            } else if (z2) {
                                                z3 = true;
                                            } else if (i9 == 0) {
                                                z3 = true;
                                                i9 = 0;
                                            } else {
                                                z3 = false;
                                            }
                                            zArr[i9] = z3;
                                            j3 += (long) iZzB;
                                            i9++;
                                            z2 = z2;
                                            zzalkVar2 = zzalkVar4;
                                        }
                                        zzamkVar2.zzp = j3;
                                        i34 = i8;
                                        i33 = i35;
                                    }
                                    i32++;
                                    i24 = i24;
                                    i2 = Atom.TYPE_trun;
                                }
                                i24 = i24;
                                zzami zzamiVar3 = zzalqVar.zzd.zza;
                                zzalk zzalkVar5 = zzamkVar2.zza;
                                zzalkVar5.getClass();
                                zzamj zzamjVarZza = zzamiVar3.zza(zzalkVar5.zza);
                                zzfy zzfyVarZzc5 = zzfxVar2.zzc(Atom.TYPE_saiz);
                                if (zzfyVarZzc5 != null) {
                                    zzamjVarZza.getClass();
                                    int i43 = zzamjVarZza.zzd;
                                    zzet zzetVar7 = zzfyVarZzc5.zza;
                                    zzetVar7.zzh(8);
                                    if ((zzetVar7.zzB() & 1) == 1) {
                                        zzetVar7.zzk(8);
                                    }
                                    int iZzs = zzetVar7.zzs();
                                    int iZzH2 = zzetVar7.zzH();
                                    int i44 = zzamkVar2.zze;
                                    if (iZzH2 > i44) {
                                        StringBuilder sb = new StringBuilder(String.valueOf(iZzH2).length() + 56 + String.valueOf(i44).length());
                                        sb.append("Saiz sample count ");
                                        sb.append(iZzH2);
                                        sb.append(" is greater than fragment sample count");
                                        sb.append(i44);
                                        throw zzat.zzb(sb.toString(), null);
                                    }
                                    if (iZzs == 0) {
                                        boolean[] zArr2 = zzamkVar2.zzl;
                                        i3 = 0;
                                        for (int i45 = 0; i45 < iZzH2; i45++) {
                                            int iZzs2 = zzetVar7.zzs();
                                            i3 += iZzs2;
                                            zArr2[i45] = iZzs2 > i43;
                                        }
                                        z = false;
                                    } else {
                                        boolean z9 = iZzs > i43;
                                        i3 = iZzs * iZzH2;
                                        z = false;
                                        Arrays.fill(zzamkVar2.zzl, 0, iZzH2, z9);
                                    }
                                    Arrays.fill(zzamkVar2.zzl, iZzH2, zzamkVar2.zze, z);
                                    if (i3 > 0) {
                                        zzamkVar2.zza(i3);
                                    }
                                }
                                zzfy zzfyVarZzc6 = zzfxVar2.zzc(Atom.TYPE_saio);
                                if (zzfyVarZzc6 != null) {
                                    zzet zzetVar8 = zzfyVarZzc6.zza;
                                    zzetVar8.zzh(8);
                                    int iZzB8 = zzetVar8.zzB();
                                    if ((iZzB8 & 1) == 1) {
                                        zzetVar8.zzk(8);
                                    }
                                    int iZzH3 = zzetVar8.zzH();
                                    if (iZzH3 != 1) {
                                        StringBuilder sb2 = new StringBuilder(String.valueOf(iZzH3).length() + 29);
                                        sb2.append("Unexpected saio entry count: ");
                                        sb2.append(iZzH3);
                                        throw zzat.zzb(sb2.toString(), null);
                                    }
                                    zzamkVar2.zzc += zzalj.zza(iZzB8) == 0 ? zzetVar8.zzz() : zzetVar8.zzJ();
                                }
                                zzfy zzfyVarZzc7 = zzfxVar2.zzc(Atom.TYPE_senc);
                                if (zzfyVarZzc7 != null) {
                                    zzl(zzfyVarZzc7.zza, 0, zzamkVar2);
                                }
                                String str3 = zzamjVarZza != null ? zzamjVarZza.zzb : null;
                                zzet zzetVar9 = null;
                                zzet zzetVar10 = null;
                                for (int i46 = 0; i46 < list3.size(); i46++) {
                                    zzfy zzfyVar4 = (zzfy) list3.get(i46);
                                    zzet zzetVar11 = zzfyVar4.zza;
                                    int i47 = zzfyVar4.zzd;
                                    if (i47 == 1935828848) {
                                        zzetVar11.zzh(12);
                                        if (zzetVar11.zzB() == 1936025959) {
                                            zzetVar9 = zzetVar11;
                                        }
                                    } else if (i47 == 1936158820) {
                                        zzetVar11.zzh(12);
                                        if (zzetVar11.zzB() == 1936025959) {
                                            zzetVar10 = zzetVar11;
                                        }
                                    }
                                }
                                if (zzetVar9 == null || zzetVar10 == null) {
                                    z4 = true;
                                } else {
                                    zzetVar9.zzh(8);
                                    int iZza = zzalj.zza(zzetVar9.zzB());
                                    zzetVar9.zzk(4);
                                    if (iZza == 1) {
                                        zzetVar9.zzk(4);
                                    }
                                    if (zzetVar9.zzB() != 1) {
                                        throw zzat.zzc("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    zzetVar10.zzh(8);
                                    int iZza2 = zzalj.zza(zzetVar10.zzB());
                                    zzetVar10.zzk(4);
                                    if (iZza2 == 1) {
                                        if (zzetVar10.zzz() == 0) {
                                            throw zzat.zzc("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iZza2 >= 2) {
                                        zzetVar10.zzk(4);
                                    }
                                    if (zzetVar10.zzz() != 1) {
                                        throw zzat.zzc("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    z4 = true;
                                    zzetVar10.zzk(1);
                                    int iZzs3 = zzetVar10.zzs();
                                    int i48 = (iZzs3 & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                                    int i49 = iZzs3 & 15;
                                    if (zzetVar10.zzs() == 1) {
                                        int iZzs4 = zzetVar10.zzs();
                                        int i50 = i21;
                                        byte[] bArr3 = new byte[i50];
                                        zzetVar10.zzm(bArr3, 0, i50);
                                        if (iZzs4 == 0) {
                                            int iZzs5 = zzetVar10.zzs();
                                            byte[] bArr4 = new byte[iZzs5];
                                            zzetVar10.zzm(bArr4, 0, iZzs5);
                                            bArr = bArr4;
                                        } else {
                                            bArr = null;
                                        }
                                        zzamkVar2.zzk = true;
                                        zzamkVar2.zzm = new zzamj(true, str3, iZzs4, bArr3, i48, i49, bArr);
                                    }
                                }
                                int size5 = list3.size();
                                for (int i51 = 0; i51 < size5; i51++) {
                                    zzfy zzfyVar5 = (zzfy) list3.get(i51);
                                    if (zzfyVar5.zzd == 1970628964) {
                                        zzet zzetVar12 = zzfyVar5.zza;
                                        zzetVar12.zzh(8);
                                        zzetVar12.zzm(bArr2, 0, 16);
                                        if (Arrays.equals(bArr2, zza)) {
                                            zzl(zzetVar12, 16, zzamkVar2);
                                        }
                                    }
                                }
                                i = 8;
                                i22 = 0;
                                i21 = 16;
                            }
                            i24++;
                            i12 = i;
                            i22 = i22;
                            z4 = z4;
                            i21 = i21;
                            i23 = i23;
                            size3 = size3;
                            list2 = list2;
                        } else {
                            i = i12;
                        }
                        i24++;
                        i12 = i;
                        i22 = i22;
                        z4 = z4;
                        i21 = i21;
                        i23 = i23;
                        size3 = size3;
                        list2 = list2;
                    }
                    int i52 = i22;
                    zzq zzqVarZzn2 = zzn(zzfxVar.zzb);
                    if (zzqVarZzn2 != null) {
                        int size6 = sparseArray3.size();
                        for (int i53 = i52; i53 < size6; i53++) {
                            ((zzalq) sparseArray3.valueAt(i53)).zzb(zzqVarZzn2);
                        }
                    }
                    if (this.zzz != C.TIME_UNSET) {
                        int size7 = sparseArray3.size();
                        for (int i54 = i52; i54 < size7; i54++) {
                            zzalq zzalqVar2 = (zzalq) sparseArray3.valueAt(i54);
                            long j9 = this.zzz;
                            int i55 = zzalqVar2.zzf;
                            while (true) {
                                zzamk zzamkVar3 = zzalqVar2.zzb;
                                if (i55 >= zzamkVar3.zze || zzamkVar3.zzi[i55] > j9) {
                                    break;
                                }
                                if (zzamkVar3.zzj[i55]) {
                                    zzalqVar2.zzi = i55;
                                }
                                i55++;
                            }
                        }
                        this.zzz = C.TIME_UNSET;
                    }
                } else if (!arrayDeque.isEmpty()) {
                    ((zzfx) arrayDeque.peek()).zzb(zzfxVar);
                }
            }
        }
        zzi();
    }

    private static int zzk(int i) throws zzat {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 27);
        sb.append("Unexpected negative value: ");
        sb.append(i);
        throw zzat.zzb(sb.toString(), null);
    }

    private static void zzl(zzet zzetVar, int i, zzamk zzamkVar) throws zzat {
        zzetVar.zzh(i + 8);
        int iZzB = zzetVar.zzB();
        int i2 = zzalj.zza;
        if ((iZzB & 1) != 0) {
            throw zzat.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iZzB & 2) != 0;
        int iZzH = zzetVar.zzH();
        if (iZzH == 0) {
            Arrays.fill(zzamkVar.zzl, 0, zzamkVar.zze, false);
            return;
        }
        int i3 = zzamkVar.zze;
        if (iZzH != i3) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzH).length() + 58 + String.valueOf(i3).length());
            sb.append("Senc sample count ");
            sb.append(iZzH);
            sb.append(" is different from fragment sample count");
            sb.append(i3);
            throw zzat.zzb(sb.toString(), null);
        }
        Arrays.fill(zzamkVar.zzl, 0, iZzH, z);
        zzamkVar.zza(zzetVar.zzd());
        zzet zzetVar2 = zzamkVar.zzn;
        zzetVar.zzm(zzetVar2.zzi(), 0, zzetVar2.zze());
        zzetVar2.zzh(0);
        zzamkVar.zzo = false;
    }

    private static Pair zzm(zzet zzetVar, long j) throws zzat {
        long jZzJ;
        long jZzJ2;
        zzet zzetVar2 = zzetVar;
        zzetVar2.zzh(8);
        int iZza = zzalj.zza(zzetVar2.zzB());
        zzetVar2.zzk(4);
        long jZzz = zzetVar2.zzz();
        if (iZza == 0) {
            jZzJ = zzetVar2.zzz();
            jZzJ2 = zzetVar2.zzz();
        } else {
            jZzJ = zzetVar2.zzJ();
            jZzJ2 = zzetVar2.zzJ();
        }
        long j2 = j + jZzJ2;
        long jZzv = zzfl.zzv(jZzJ, 1000000L, jZzz, RoundingMode.DOWN);
        zzetVar2.zzk(2);
        int iZzt = zzetVar2.zzt();
        int[] iArr = new int[iZzt];
        long[] jArr = new long[iZzt];
        long[] jArr2 = new long[iZzt];
        long[] jArr3 = new long[iZzt];
        long j3 = j2;
        long j4 = jZzv;
        int i = 0;
        while (i < iZzt) {
            int iZzB = zzetVar2.zzB();
            if ((Integer.MIN_VALUE & iZzB) != 0) {
                throw zzat.zzb("Unhandled indirect reference", null);
            }
            long jZzz2 = zzetVar2.zzz();
            iArr[i] = iZzB & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            jZzJ += jZzz2;
            long[] jArr4 = jArr2;
            long[] jArr5 = jArr3;
            long jZzv2 = zzfl.zzv(jZzJ, 1000000L, jZzz, RoundingMode.DOWN);
            jArr4[i] = jZzv2 - jArr5[i];
            zzetVar2.zzk(4);
            j3 += (long) iArr[i];
            i++;
            zzetVar2 = zzetVar;
            iZzt = iZzt;
            j4 = jZzv2;
            jArr2 = jArr4;
            jArr3 = jArr5;
        }
        return Pair.create(Long.valueOf(jZzv), new zzafm(iArr, jArr, jArr2, jArr3));
    }

    private static zzq zzn(List list) {
        int i;
        UUID[] uuidArr;
        zzame zzameVar;
        int size = list.size();
        int i2 = 0;
        ArrayList arrayList = null;
        while (i2 < size) {
            zzfy zzfyVar = (zzfy) list.get(i2);
            if (zzfyVar.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArrZzi = zzfyVar.zza.zzi();
                zzet zzetVar = new zzet(bArrZzi);
                if (zzetVar.zze() < 32) {
                    i = i2;
                    zzameVar = null;
                } else {
                    zzetVar.zzh(0);
                    int iZzd = zzetVar.zzd();
                    int iZzB = zzetVar.zzB();
                    if (iZzB != iZzd) {
                        StringBuilder sb = new StringBuilder(String.valueOf(iZzB).length() + 52 + String.valueOf(iZzd).length());
                        sb.append("Advertised atom size (");
                        sb.append(iZzB);
                        sb.append(") does not match buffer size: ");
                        sb.append(iZzd);
                        zzeg.zzc("PsshAtomUtil", sb.toString());
                    } else {
                        int iZzB2 = zzetVar.zzB();
                        if (iZzB2 != 1886614376) {
                            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzB2).length() + 23);
                            sb2.append("Atom type is not pssh: ");
                            sb2.append(iZzB2);
                            zzeg.zzc("PsshAtomUtil", sb2.toString());
                        } else {
                            int iZza = zzalj.zza(zzetVar.zzB());
                            if (iZza > 1) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(iZza).length() + 26);
                                sb3.append("Unsupported pssh version: ");
                                sb3.append(iZza);
                                zzeg.zzc("PsshAtomUtil", sb3.toString());
                            } else {
                                UUID uuid = new UUID(zzetVar.zzD(), zzetVar.zzD());
                                if (iZza == 1) {
                                    int iZzH = zzetVar.zzH();
                                    uuidArr = new UUID[iZzH];
                                    int i3 = 0;
                                    while (i3 < iZzH) {
                                        UUID[] uuidArr2 = uuidArr;
                                        int i4 = i3;
                                        uuidArr2[i4] = new UUID(zzetVar.zzD(), zzetVar.zzD());
                                        i3 = i4 + 1;
                                        i2 = i2;
                                        uuidArr = uuidArr2;
                                    }
                                } else {
                                    uuidArr = null;
                                }
                                i = i2;
                                int iZzH2 = zzetVar.zzH();
                                int iZzd2 = zzetVar.zzd();
                                if (iZzH2 != iZzd2) {
                                    StringBuilder sb4 = new StringBuilder(String.valueOf(iZzH2).length() + 49 + String.valueOf(iZzd2).length());
                                    sb4.append("Atom data size (");
                                    sb4.append(iZzH2);
                                    sb4.append(") does not match the bytes left: ");
                                    sb4.append(iZzd2);
                                    zzeg.zzc("PsshAtomUtil", sb4.toString());
                                    zzameVar = null;
                                } else {
                                    byte[] bArr = new byte[iZzH2];
                                    zzetVar.zzm(bArr, 0, iZzH2);
                                    zzameVar = new zzame(uuid, iZza, bArr, uuidArr);
                                }
                            }
                        }
                    }
                    i = i2;
                    zzameVar = null;
                }
                UUID uuid2 = zzameVar == null ? null : zzameVar.zza;
                if (uuid2 == null) {
                    zzeg.zzc("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzp(uuid2, null, MimeTypes.VIDEO_MP4, bArrZzi));
                }
                i2 = i + 1;
            } else {
                i = i2;
            }
            i2 = i + 1;
        }
        if (arrayList == null) {
            return null;
        }
        return new zzq(arrayList);
    }

    private final void zzo(zzahb zzahbVar, zzagy zzagyVar) {
        this.zzI.zzw(zzahbVar);
        this.zzL = true;
        zzagyVar.zza = this.zzO;
        zzi();
    }

    private static final zzalk zzp(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzalk) sparseArray.valueAt(0);
        }
        zzalk zzalkVar = (zzalk) sparseArray.get(i);
        zzalkVar.getClass();
        return zzalkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzahf zzahfVarZza = zzamh.zza(zzafzVar);
        this.zzr = zzahfVarZza != null ? zzgwm.zzj(zzahfVarZza) : zzgwm.zzi();
        return zzahfVarZza == null;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final /* synthetic */ List zzb() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        int i;
        int i2 = this.zzd;
        if ((i2 & 32) == 0) {
            zzagbVar = new zzanm(zzagbVar, this.zzc);
        }
        this.zzI = zzagbVar;
        zzi();
        zzahk[] zzahkVarArr = new zzahk[2];
        this.zzJ = zzahkVarArr;
        int i3 = 100;
        int i4 = 0;
        if ((i2 & 4) != 0) {
            zzahkVarArr[0] = this.zzI.zzu(100, 5);
            i = 1;
            i3 = 101;
        } else {
            i = 0;
        }
        zzahk[] zzahkVarArr2 = (zzahk[]) zzfl.zzb(this.zzJ, i);
        this.zzJ = zzahkVarArr2;
        for (zzahk zzahkVar : zzahkVarArr2) {
            zzahkVar.zzA(zzb);
        }
        List list = this.zze;
        this.zzK = new zzahk[list.size()];
        while (i4 < this.zzK.length) {
            zzahk zzahkVarZzu = this.zzI.zzu(i3, 3);
            zzahkVarZzu.zzA((zzv) list.get(i4));
            this.zzK[i4] = zzahkVarZzu;
            i4++;
            i3++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:378:0x08ab  */
    /* JADX WARN: Code duplicated, block: B:380:0x08b4 A[LOOP:1: B:379:0x08b2->B:380:0x08b4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:383:0x08ca  */
    /* JADX WARN: Code duplicated, block: B:384:0x08d7  */
    /* JADX WARN: Code duplicated, block: B:479:0x09e9  */
    /* JADX WARN: Code duplicated, block: B:481:0x09f7  */
    /* JADX WARN: Code duplicated, block: B:486:0x0a30  */
    /* JADX WARN: Code duplicated, block: B:487:0x0a34  */
    /* JADX WARN: Code duplicated, block: B:93:0x01bd  */
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
        int i;
        zzalq zzalqVar;
        char c;
        int iZza;
        int iZzc;
        int iZzi;
        int i2;
        int i3;
        long j;
        long j2;
        long jZzz;
        long j3;
        long jZzv;
        long jZzz2;
        String str;
        String str2;
        long j4;
        int i4;
        long j5;
        long j6;
        SparseArray sparseArray;
        int size;
        int i5;
        while (true) {
            int i6 = this.zzs;
            char c2 = 2;
            i = 0;
            if (i6 == 0) {
                if (this.zzv == 0) {
                    zzet zzetVar = this.zzm;
                    if (!zzafzVar.zzb(zzetVar.zzi(), 0, 8, true)) {
                        long j7 = this.zzN;
                        if (j7 == -1) {
                            this.zzp.zze();
                            return -1;
                        }
                        zzagyVar.zza = j7;
                        this.zzN = -1L;
                        this.zzI.zzw(this.zzq.zzb());
                        this.zzM = true;
                        return 1;
                    }
                    this.zzv = 8;
                    zzetVar.zzh(0);
                    this.zzu = zzetVar.zzz();
                    this.zzt = zzetVar.zzB();
                }
                long j8 = this.zzu;
                if (j8 == 1) {
                    zzet zzetVar2 = this.zzm;
                    zzafzVar.zzc(zzetVar2.zzi(), 8, 8);
                    this.zzv += 8;
                    this.zzu = zzetVar2.zzJ();
                } else if (j8 == 0) {
                    long jZzo = zzafzVar.zzo();
                    if (jZzo == -1) {
                        ArrayDeque arrayDeque = this.zzn;
                        jZzo = !arrayDeque.isEmpty() ? ((zzfx) arrayDeque.peek()).zza : -1L;
                    }
                    if (jZzo != -1) {
                        this.zzu = (jZzo - zzafzVar.zzn()) + ((long) this.zzv);
                    }
                }
                long j9 = this.zzu;
                int i7 = this.zzv;
                long j10 = i7;
                if (j9 < j10) {
                    if (this.zzt != 1718773093 || i7 != 8) {
                        throw zzat.zzc("Atom size less than header length (unsupported).");
                    }
                    this.zzu = j10;
                    j9 = j10;
                }
                if (this.zzN != -1) {
                    if (this.zzt == 1936286840) {
                        zzet zzetVar3 = this.zzk;
                        zzetVar3.zza((int) j9);
                        System.arraycopy(this.zzm.zzi(), 0, zzetVar3.zzi(), 0, 8);
                        zzafzVar.zzc(zzetVar3.zzi(), 8, (int) (this.zzu - ((long) this.zzv)));
                        this.zzq.zza((zzafm) zzm(new zzfy(Atom.TYPE_sidx, zzetVar3).zza, zzafzVar.zzm()).second);
                    } else {
                        zzafzVar.zze((int) (j9 - j10), true);
                    }
                    zzi();
                } else {
                    long jZzn = zzafzVar.zzn() - j10;
                    int i8 = this.zzt;
                    if (!(i8 == 1836019558 || i8 == 1835295092) || this.zzL) {
                        if (this.zzt == 1836019558) {
                            sparseArray = this.zzf;
                            size = sparseArray.size();
                            for (i5 = 0; i5 < size; i5++) {
                                zzamk zzamkVar = ((zzalq) sparseArray.valueAt(i5)).zzb;
                                zzamkVar.zzc = jZzn;
                                zzamkVar.zzb = jZzn;
                            }
                        }
                        i4 = this.zzt;
                        if (i4 == 1835295092) {
                            this.zzC = null;
                            this.zzx = jZzn + this.zzu;
                            this.zzs = 2;
                        } else if (i4 != 1836019574) {
                            long jZzn2 = zzafzVar.zzn();
                            j5 = this.zzu;
                            long j11 = jZzn2 + j5;
                            if (j5 != this.zzv) {
                                zzet zzetVar4 = this.zzk;
                                zzetVar4.zza(8);
                                zzafzVar.zzi(zzetVar4.zzi(), 0, 8);
                                zzalj.zzf(zzetVar4);
                                zzafzVar.zzf(zzetVar4.zzg());
                                zzafzVar.zzl();
                            }
                            j6 = j11 - 8;
                            this.zzn.push(new zzfx(this.zzt, j6));
                            if (this.zzu == this.zzv) {
                                zzj(j6);
                            } else {
                                zzi();
                            }
                        } else {
                            long jZzn3 = zzafzVar.zzn();
                            j5 = this.zzu;
                            long j12 = jZzn3 + j5;
                            if (j5 != this.zzv) {
                                zzet zzetVar5 = this.zzk;
                                zzetVar5.zza(8);
                                zzafzVar.zzi(zzetVar5.zzi(), 0, 8);
                                zzalj.zzf(zzetVar5);
                                zzafzVar.zzf(zzetVar5.zzg());
                                zzafzVar.zzl();
                            }
                            j6 = j12 - 8;
                            this.zzn.push(new zzfx(this.zzt, j6));
                            if (this.zzu == this.zzv) {
                                zzj(j6);
                            } else {
                                zzi();
                            }
                        }
                    } else if (zzafzVar.zzo() == -1 || this.zzO != -1 || (this.zzd & 512) == 0) {
                        this.zzI.zzw(new zzaha(this.zzA, jZzn));
                        this.zzL = true;
                        if (this.zzt == 1836019558) {
                            sparseArray = this.zzf;
                            size = sparseArray.size();
                            while (i5 < size) {
                                zzamk zzamkVar2 = ((zzalq) sparseArray.valueAt(i5)).zzb;
                                zzamkVar2.zzc = jZzn;
                                zzamkVar2.zzb = jZzn;
                            }
                        }
                        i4 = this.zzt;
                        if (i4 == 1835295092) {
                            this.zzC = null;
                            this.zzx = jZzn + this.zzu;
                            this.zzs = 2;
                        } else if (i4 != 1836019574 || i4 == 1953653099 || i4 == 1835297121 || i4 == 1835626086 || i4 == 1937007212 || i4 == 1836019558 || i4 == 1953653094 || i4 == 1836475768 || i4 == 1701082227 || i4 == 1835365473) {
                            long jZzn4 = zzafzVar.zzn();
                            j5 = this.zzu;
                            long j13 = jZzn4 + j5;
                            if (j5 != this.zzv && i4 == 1835365473) {
                                zzet zzetVar6 = this.zzk;
                                zzetVar6.zza(8);
                                zzafzVar.zzi(zzetVar6.zzi(), 0, 8);
                                zzalj.zzf(zzetVar6);
                                zzafzVar.zzf(zzetVar6.zzg());
                                zzafzVar.zzl();
                            }
                            j6 = j13 - 8;
                            this.zzn.push(new zzfx(this.zzt, j6));
                            if (this.zzu == this.zzv) {
                                zzj(j6);
                            } else {
                                zzi();
                            }
                        } else if (i4 == 1751411826 || i4 == 1835296868 || i4 == 1836476516 || i4 == 1936286840 || i4 == 1937011556 || i4 == 1937011827 || i4 == 1668576371 || i4 == 1937011555 || i4 == 1937011578 || i4 == 1937013298 || i4 == 1937007471 || i4 == 1668232756 || i4 == 1937011571 || i4 == 1952867444 || i4 == 1952868452 || i4 == 1953196132 || i4 == 1953654136 || i4 == 1953658222 || i4 == 1886614376 || i4 == 1935763834 || i4 == 1935763823 || i4 == 1936027235 || i4 == 1970628964 || i4 == 1935828848 || i4 == 1936158820 || i4 == 1701606260 || i4 == 1835362404 || i4 == 1701671783 || i4 == 1969517665 || i4 == 1801812339 || i4 == 1768715124) {
                            if (this.zzv != 8) {
                                throw zzat.zzc("Leaf atom defines extended atom size (unsupported).");
                            }
                            if (this.zzu > 2147483647L) {
                                throw zzat.zzc("Leaf atom with length > 2147483647 (unsupported).");
                            }
                            zzet zzetVar7 = new zzet((int) this.zzu);
                            System.arraycopy(this.zzm.zzi(), 0, zzetVar7.zzi(), 0, 8);
                            this.zzw = zzetVar7;
                            this.zzs = 1;
                        } else {
                            if (this.zzu > 2147483647L) {
                                throw zzat.zzc("Skipping atom with length > 2147483647 (unsupported).");
                            }
                            this.zzw = null;
                            this.zzs = 1;
                        }
                    } else {
                        this.zzO = jZzn;
                        zzagyVar.zza = zzafzVar.zzo() - 16;
                        this.zzs = 5;
                    }
                }
                if (this.zzs == 5) {
                    return 1;
                }
            } else if (i6 != 1) {
                long j14 = Long.MAX_VALUE;
                if (i6 == 2) {
                    SparseArray sparseArray2 = this.zzf;
                    int size2 = sparseArray2.size();
                    zzalq zzalqVar2 = null;
                    for (int i9 = 0; i9 < size2; i9++) {
                        zzamk zzamkVar3 = ((zzalq) sparseArray2.valueAt(i9)).zzb;
                        if (zzamkVar3.zzo) {
                            long j15 = zzamkVar3.zzc;
                            if (j15 < j14) {
                                zzalqVar2 = (zzalq) sparseArray2.valueAt(i9);
                                j14 = j15;
                            }
                        }
                    }
                    if (zzalqVar2 == null) {
                        this.zzs = 3;
                    } else {
                        int iZzn = (int) (j14 - zzafzVar.zzn());
                        if (iZzn < 0) {
                            throw zzat.zzb("Offset to encryption data was negative.", null);
                        }
                        zzafzVar.zzf(iZzn);
                        zzamk zzamkVar4 = zzalqVar2.zzb;
                        zzet zzetVar8 = zzamkVar4.zzn;
                        zzafzVar.zzc(zzetVar8.zzi(), 0, zzetVar8.zze());
                        zzetVar8.zzh(0);
                        zzamkVar4.zzo = false;
                    }
                } else if (i6 == 5) {
                    zzet zzetVar9 = this.zzk;
                    zzetVar9.zza(16);
                    if (zzafzVar.zzb(zzetVar9.zzi(), 0, 16, true)) {
                        zzetVar9.zzh(0);
                        int iZzB = zzetVar9.zzB();
                        int iZzB2 = zzetVar9.zzB();
                        if (iZzB == 16 && iZzB2 == 1835430511) {
                            zzetVar9.zzk(4);
                            long jZzz3 = zzetVar9.zzz();
                            long jZzo2 = zzafzVar.zzo() - jZzz3;
                            if (jZzz3 <= 0 || jZzz3 > 2147483647L || jZzo2 < 0 || jZzo2 < this.zzO) {
                                zzo(new zzaha(this.zzA, this.zzO), zzagyVar);
                            } else {
                                zzagyVar.zza = jZzo2;
                                this.zzs = 6;
                            }
                        } else {
                            zzo(new zzaha(this.zzA, this.zzO), zzagyVar);
                        }
                    } else {
                        zzo(new zzaha(this.zzA, this.zzO), zzagyVar);
                    }
                    int i10 = this.zzs;
                    if (i10 == 6 || i10 == 0) {
                        return 1;
                    }
                } else if (i6 != 6) {
                    zzalqVar = this.zzC;
                    if (zzalqVar != null) {
                        c = 2;
                        break;
                    }
                    SparseArray sparseArray3 = this.zzf;
                    int size3 = sparseArray3.size();
                    zzalq zzalqVar3 = null;
                    int i11 = 0;
                    while (i11 < size3) {
                        char c3 = c2;
                        zzalq zzalqVar4 = (zzalq) sparseArray3.valueAt(i11);
                        if ((zzalqVar4.zzk() || zzalqVar4.zzf != zzalqVar4.zzd.zzb) && (!zzalqVar4.zzk() || zzalqVar4.zzh != zzalqVar4.zzb.zzd)) {
                            long jZze = zzalqVar4.zze();
                            if (jZze < j14) {
                                zzalqVar3 = zzalqVar4;
                                j14 = jZze;
                            }
                        }
                        i11++;
                        c2 = c3;
                    }
                    c = c2;
                    if (zzalqVar3 != null) {
                        int iZze = (int) (zzalqVar3.zze() - zzafzVar.zzn());
                        if (iZze < 0) {
                            zzeg.zzc("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            iZze = 0;
                        }
                        zzafzVar.zzf(iZze);
                        this.zzC = zzalqVar3;
                        zzalqVar = zzalqVar3;
                        break;
                    }
                    int iZzn2 = (int) (this.zzx - zzafzVar.zzn());
                    if (iZzn2 < 0) {
                        throw zzat.zzb("Offset to end of mdat was negative.", null);
                    }
                    zzafzVar.zzf(iZzn2);
                    zzi();
                } else {
                    int i12 = 2;
                    int iZzo = (int) (zzafzVar.zzo() - zzafzVar.zzn());
                    zzet zzetVar10 = new zzet(iZzo);
                    zzafzVar.zzc(zzetVar10.zzi(), 0, iZzo);
                    zzetVar10.zzh(0);
                    zzetVar10.zzh(zzetVar10.zzB() == 1 ? 16 : 8);
                    SparseArray sparseArray4 = new SparseArray();
                    SparseArray sparseArray5 = new SparseArray();
                    for (int i13 = 8; zzetVar10.zzd() >= i13; i13 = 8) {
                        int iZzg = zzetVar10.zzg();
                        long jZzz4 = zzetVar10.zzz();
                        int iZzB3 = zzetVar10.zzB();
                        if (jZzz4 == 1) {
                            if (zzetVar10.zzd() < i13) {
                                break;
                            }
                            jZzz4 = zzetVar10.zzD();
                        } else if (jZzz4 == 0) {
                            jZzz4 = ((long) zzetVar10.zze()) - ((long) iZzg);
                        }
                        int i14 = jZzz4 == 1 ? 16 : i13;
                        if (jZzz4 < i14) {
                            break;
                        }
                        long j16 = iZzg;
                        if (jZzz4 > ((long) zzetVar10.zze()) - j16) {
                            break;
                        }
                        if (iZzB3 == 1952871009) {
                            if (jZzz4 < i14 + 16) {
                                zzetVar10.zzh((int) (j16 + jZzz4));
                            } else {
                                int iZza2 = zzalj.zza(zzetVar10.zzB());
                                int iZzB4 = zzetVar10.zzB();
                                zzalq zzalqVar5 = (zzalq) this.zzf.get(iZzB4);
                                if (zzalqVar5 == null) {
                                    zzetVar10.zzh((int) (j16 + jZzz4));
                                } else {
                                    long j17 = zzalqVar5.zzd.zza.zzc;
                                    int iZzB5 = zzetVar10.zzB();
                                    int i15 = iZzB5 >> 4;
                                    int i16 = iZzB5 >> 2;
                                    int i17 = iZzB5 & 3;
                                    j = jZzz4;
                                    long jZzz5 = zzetVar10.zzz();
                                    int i18 = (i15 & 3) + 1;
                                    int i19 = (i16 & 3) + 1;
                                    int i20 = i17 + 1;
                                    j2 = j16;
                                    if (((iZza2 == 1 ? 16L : 8L) + ((long) i18) + ((long) i19) + ((long) i20)) * jZzz5 > zzetVar10.zzd()) {
                                        zzetVar10.zzh((int) (j2 + j));
                                    } else {
                                        int i21 = (int) jZzz5;
                                        long[] jArr = new long[i21];
                                        long[] jArr2 = new long[i21];
                                        int i22 = 0;
                                        while (i22 < i21) {
                                            if (iZza2 == 1) {
                                                jZzz = zzetVar10.zzJ();
                                                iZza2 = 1;
                                            } else {
                                                jZzz = zzetVar10.zzz();
                                            }
                                            long jZzJ = iZza2 == 1 ? zzetVar10.zzJ() : zzetVar10.zzz();
                                            zzetVar10.zzk(i18 + i19 + i20);
                                            jArr[i22] = zzfl.zzv(jZzz, 1000000L, j17, RoundingMode.DOWN);
                                            jArr2[i22] = jZzJ;
                                            i22++;
                                            iZza2 = iZza2;
                                        }
                                        sparseArray4.put(iZzB4, jArr);
                                        sparseArray5.put(iZzB4, jArr2);
                                    }
                                }
                            }
                        } else {
                            j = jZzz4;
                            j2 = j16;
                        }
                        zzetVar10.zzh((int) (j2 + j));
                    }
                    if (sparseArray4.size() == 0) {
                        zzo(new zzaha(this.zzA, this.zzO), zzagyVar);
                    } else {
                        int iKeyAt = -1;
                        int i23 = -1;
                        int i24 = 0;
                        while (i24 < sparseArray4.size()) {
                            int iKeyAt2 = sparseArray4.keyAt(i24);
                            zzalq zzalqVar6 = (zzalq) this.zzf.get(iKeyAt2);
                            if (zzalqVar6 != null) {
                                int i25 = zzalqVar6.zzd.zza.zzb;
                                if (iKeyAt != -1) {
                                    i3 = iKeyAt;
                                } else if (i25 == i12) {
                                    iKeyAt = iKeyAt2;
                                } else {
                                    i3 = -1;
                                }
                                if (i23 == -1) {
                                    i23 = i25 == 1 ? iKeyAt2 : -1;
                                }
                                iKeyAt = i3;
                            }
                            i24++;
                            i12 = 2;
                        }
                        if (iKeyAt != -1) {
                            i2 = iKeyAt;
                        } else if (i23 != -1) {
                            i2 = i23;
                        } else {
                            iKeyAt = sparseArray4.keyAt(0);
                            i2 = iKeyAt;
                        }
                        zzo(new zzalp(sparseArray4, sparseArray5, this.zzA, this.zzO, i2, null), zzagyVar);
                    }
                    if (this.zzs == 0) {
                        return 1;
                    }
                }
            } else {
                long j18 = this.zzu - ((long) this.zzv);
                zzet zzetVar11 = this.zzw;
                int i26 = (int) j18;
                if (zzetVar11 != null) {
                    zzafzVar.zzc(zzetVar11.zzi(), 8, i26);
                    zzfy zzfyVar = new zzfy(this.zzt, zzetVar11);
                    ArrayDeque arrayDeque2 = this.zzn;
                    if (arrayDeque2.isEmpty()) {
                        int i27 = zzfyVar.zzd;
                        if (i27 == 1936286840) {
                            Pair pairZzm = zzm(zzfyVar.zza, zzafzVar.zzn());
                            zzafn zzafnVar = this.zzq;
                            zzafnVar.zza((zzafm) pairZzm.second);
                            this.zzB = ((Long) pairZzm.first).longValue();
                            if (!this.zzL) {
                                this.zzI.zzw((zzahb) pairZzm.second);
                                this.zzL = true;
                            } else if ((this.zzd & 256) != 0 && !this.zzM && zzafnVar.zzc() > 1) {
                                this.zzN = zzafzVar.zzn();
                            }
                        } else if (i27 == 1701671783) {
                            zzet zzetVar12 = zzfyVar.zza;
                            if (this.zzJ.length != 0) {
                                zzetVar12.zzh(8);
                                int iZza3 = zzalj.zza(zzetVar12.zzB());
                                if (iZza3 == 0) {
                                    String strZzM = zzetVar12.zzM((char) 0);
                                    strZzM.getClass();
                                    String strZzM2 = zzetVar12.zzM((char) 0);
                                    strZzM2.getClass();
                                    long jZzz6 = zzetVar12.zzz();
                                    long jZzv2 = zzfl.zzv(zzetVar12.zzz(), 1000000L, jZzz6, RoundingMode.DOWN);
                                    long j19 = this.zzB;
                                    long j20 = j19 != C.TIME_UNSET ? j19 + jZzv2 : -9223372036854775807L;
                                    long jZzv3 = zzfl.zzv(zzetVar12.zzz(), 1000L, jZzz6, RoundingMode.DOWN);
                                    long j21 = j20;
                                    j3 = jZzv2;
                                    jZzv = j21;
                                    jZzz2 = zzetVar12.zzz();
                                    str = strZzM;
                                    str2 = strZzM2;
                                    j4 = jZzv3;
                                } else if (iZza3 != 1) {
                                    StringBuilder sb = new StringBuilder(String.valueOf(iZza3).length() + 35);
                                    sb.append("Skipping unsupported emsg version: ");
                                    sb.append(iZza3);
                                    zzeg.zzc("FragmentedMp4Extractor", sb.toString());
                                } else {
                                    long jZzz7 = zzetVar12.zzz();
                                    jZzv = zzfl.zzv(zzetVar12.zzJ(), 1000000L, jZzz7, RoundingMode.DOWN);
                                    long jZzv4 = zzfl.zzv(zzetVar12.zzz(), 1000L, jZzz7, RoundingMode.DOWN);
                                    long jZzz8 = zzetVar12.zzz();
                                    String strZzM3 = zzetVar12.zzM((char) 0);
                                    strZzM3.getClass();
                                    String strZzM4 = zzetVar12.zzM((char) 0);
                                    strZzM4.getClass();
                                    jZzz2 = jZzz8;
                                    str = strZzM3;
                                    str2 = strZzM4;
                                    j4 = jZzv4;
                                    j3 = -9223372036854775807L;
                                }
                                byte[] bArr = new byte[zzetVar12.zzd()];
                                zzetVar12.zzm(bArr, 0, zzetVar12.zzd());
                                zzet zzetVar13 = new zzet(this.zzl.zza(new zzaja(str, str2, j4, jZzz2, bArr)));
                                int iZzd = zzetVar13.zzd();
                                for (zzahk zzahkVar : this.zzJ) {
                                    zzetVar13.zzh(0);
                                    zzahkVar.zzc(zzetVar13, iZzd);
                                }
                                if (jZzv == C.TIME_UNSET) {
                                    this.zzo.addLast(new zzalo(j3, true, iZzd));
                                    this.zzy += iZzd;
                                } else {
                                    ArrayDeque arrayDeque3 = this.zzo;
                                    if (arrayDeque3.isEmpty()) {
                                        for (zzahk zzahkVar2 : this.zzJ) {
                                            zzahkVar2.zze(jZzv, 1, iZzd, 0, null);
                                        }
                                    } else {
                                        arrayDeque3.addLast(new zzalo(jZzv, false, iZzd));
                                        this.zzy += iZzd;
                                    }
                                }
                            }
                        }
                    } else {
                        ((zzfx) arrayDeque2.peek()).zza(zzfyVar);
                    }
                } else {
                    zzafzVar.zzf(i26);
                }
                zzj(zzafzVar.zzn());
            }
        }
        if (this.zzs == 3) {
            this.zzD = zzalqVar.zzf();
            String str3 = zzalqVar.zzd.zza.zzg.zzp;
            this.zzG = !(!Objects.equals(str3, MimeTypes.VIDEO_H264) ? !Objects.equals(str3, MimeTypes.VIDEO_H265) || (this.zzd & 128) == 0 : (this.zzd & 64) == 0);
            if (zzalqVar.zzf < zzalqVar.zzi) {
                zzafzVar.zzf(this.zzD);
                zzamj zzamjVarZzj = zzalqVar.zzj();
                if (zzamjVarZzj != null) {
                    zzamk zzamkVar5 = zzalqVar.zzb;
                    zzet zzetVar14 = zzamkVar5.zzn;
                    int i28 = zzamjVarZzj.zzd;
                    if (i28 != 0) {
                        zzetVar14.zzk(i28);
                    }
                    if (zzamkVar5.zzb(zzalqVar.zzf)) {
                        zzetVar14.zzk(zzetVar14.zzt() * 6);
                    }
                }
                if (!zzalqVar.zzh()) {
                    this.zzC = null;
                }
                this.zzs = 3;
                return 0;
            }
            if (zzalqVar.zzd.zza.zzh == 1) {
                this.zzD -= 8;
                zzafzVar.zzf(8);
            }
            if (MimeTypes.AUDIO_AC4.equals(zzalqVar.zzd.zza.zzg.zzp)) {
                this.zzE = zzalqVar.zzi(this.zzD, 7);
                int i29 = this.zzD;
                zzet zzetVar15 = this.zzk;
                zzafb.zzc(i29, zzetVar15);
                zzalqVar.zza.zzc(zzetVar15, 7);
                iZzi = this.zzE + 7;
                this.zzE = iZzi;
            } else {
                iZzi = zzalqVar.zzi(this.zzD, 0);
                this.zzE = iZzi;
            }
            this.zzD += iZzi;
            this.zzs = 4;
            this.zzF = 0;
        }
        zzami zzamiVar = zzalqVar.zzd.zza;
        zzahk zzahkVar3 = zzalqVar.zza;
        long jZzd = zzalqVar.zzd();
        int i30 = zzamiVar.zzk;
        if (i30 == 0) {
            while (true) {
                int i31 = this.zzE;
                int i32 = this.zzD;
                if (i31 >= i32) {
                    break;
                }
                this.zzE += zzahkVar3.zza(zzafzVar, i32 - i31, false);
            }
        } else {
            zzet zzetVar16 = this.zzh;
            byte[] bArrZzi = zzetVar16.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 0;
            bArrZzi[c] = 0;
            int i33 = 4 - i30;
            while (this.zzE < this.zzD) {
                int i34 = this.zzF;
                if (i34 == 0) {
                    if (this.zzK.length > 0 || !this.zzG) {
                        iZzc = zzgp.zzc(zzamiVar.zzg);
                        if (i30 + iZzc > this.zzD - this.zzE) {
                            iZzc = i;
                        }
                    } else {
                        iZzc = i;
                    }
                    zzafzVar.zzc(bArrZzi, i33, i30 + iZzc);
                    zzetVar16.zzh(i);
                    int iZzB6 = zzetVar16.zzB();
                    if (iZzB6 < 0) {
                        throw zzat.zzb("Invalid NAL length", null);
                    }
                    this.zzF = iZzB6 - iZzc;
                    zzet zzetVar17 = this.zzg;
                    zzetVar17.zzh(i);
                    zzahkVar3.zzc(zzetVar17, 4);
                    this.zzE += 4;
                    this.zzD += i33;
                    this.zzH = (this.zzK.length <= 0 || iZzc <= 0 || !zzgp.zzb(zzamiVar.zzg, bArrZzi, 4)) ? i : 1;
                    zzahkVar3.zzc(zzetVar16, iZzc);
                    this.zzE += iZzc;
                    if (iZzc > 0 && !this.zzG && zzgp.zzd(bArrZzi, 4, iZzc, zzamiVar.zzg)) {
                        this.zzG = true;
                    }
                } else {
                    if (this.zzH) {
                        zzet zzetVar18 = this.zzi;
                        zzetVar18.zza(i34);
                        zzafzVar.zzc(zzetVar18.zzi(), i, this.zzF);
                        zzahkVar3.zzc(zzetVar18, this.zzF);
                        iZza = this.zzF;
                        int iZza4 = zzgp.zza(zzetVar18.zzi(), zzetVar18.zze());
                        zzetVar18.zzh(i);
                        zzetVar18.zzf(iZza4);
                        int i35 = zzamiVar.zzg.zzr;
                        if (i35 == -1) {
                            zzgz zzgzVar = this.zzp;
                            if (zzgzVar.zzb() != 0) {
                                zzgzVar.zza(i);
                            }
                        } else {
                            zzgz zzgzVar2 = this.zzp;
                            if (zzgzVar2.zzb() != i35) {
                                zzgzVar2.zza(i35);
                            }
                        }
                        zzgz zzgzVar3 = this.zzp;
                        zzgzVar3.zzc(jZzd, zzetVar18);
                        if ((zzalqVar.zzg() & 4) != 0) {
                            zzgzVar3.zze();
                        }
                    } else {
                        iZza = zzahkVar3.zza(zzafzVar, i34, i);
                    }
                    this.zzE += iZza;
                    this.zzF -= iZza;
                    i = 0;
                }
            }
        }
        int iZzg2 = zzalqVar.zzg();
        if (!this.zzG) {
            iZzg2 |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        }
        int i36 = iZzg2;
        zzamj zzamjVarZzj2 = zzalqVar.zzj();
        zzahkVar3.zze(jZzd, i36, this.zzD, 0, zzamjVarZzj2 != null ? zzamjVarZzj2.zzc : null);
        while (true) {
            ArrayDeque arrayDeque4 = this.zzo;
            if (arrayDeque4.isEmpty()) {
                break;
            }
            zzalo zzaloVar = (zzalo) arrayDeque4.removeFirst();
            int i37 = this.zzy;
            int i38 = zzaloVar.zzc;
            this.zzy = i37 - i38;
            long j22 = zzaloVar.zza;
            if (zzaloVar.zzb) {
                j22 += jZzd;
            }
            long j23 = j22;
            for (zzahk zzahkVar4 : this.zzJ) {
                zzahkVar4.zze(j23, 1, i38, this.zzy, null);
            }
        }
        if (!zzalqVar.zzh()) {
            this.zzC = null;
        }
        this.zzs = 3;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        SparseArray sparseArray = this.zzf;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((zzalq) sparseArray.valueAt(i)).zzc();
        }
        this.zzo.clear();
        this.zzy = 0;
        this.zzp.zzd();
        this.zzz = j2;
        this.zzn.clear();
        this.zzO = -1L;
        zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }

    final /* synthetic */ void zzh(long j, zzet zzetVar) {
        zzafl.zza(j, zzetVar, this.zzK);
    }

    public zzalr(zzanj zzanjVar, int i, zzfi zzfiVar, zzami zzamiVar, List list, zzahk zzahkVar) {
        this.zzc = zzanjVar;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzajb();
        this.zzm = new zzet(16);
        this.zzg = new zzet(zzgp.zza);
        this.zzh = new zzet(6);
        this.zzi = new zzet();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzet(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzr = zzgwm.zzi();
        this.zzA = C.TIME_UNSET;
        this.zzz = C.TIME_UNSET;
        this.zzB = C.TIME_UNSET;
        this.zzI = zzagb.zza;
        this.zzJ = new zzahk[0];
        this.zzK = new zzahk[0];
        this.zzp = new zzgz(new zzgy() { // from class: com.google.android.gms.internal.ads.zzaln
            @Override // com.google.android.gms.internal.ads.zzgy
            public final /* synthetic */ void zza(long j, zzet zzetVar) {
                this.zza.zzh(j, zzetVar);
            }
        });
        this.zzq = new zzafn();
        this.zzN = -1L;
        this.zzO = -1L;
    }
}
