package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.AacUtil;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.ts.PsExtractor;
import com.facebook.imagepipeline.common.RotationOptions;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzalj {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb;

    static {
        String str = zzfl.zza;
        zzb = "OpusHead".getBytes(StandardCharsets.UTF_8);
    }

    public static int zza(int i) {
        return (i >> 24) & 255;
    }

    /* JADX WARN: Code duplicated, block: B:290:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:571:0x0beb  */
    /* JADX WARN: Code duplicated, block: B:572:0x0bed  */
    /* JADX WARN: Code duplicated, block: B:607:0x0d64  */
    /* JADX WARN: Code duplicated, block: B:608:0x0d68  */
    /* JADX WARN: Code duplicated, block: B:610:0x0d6c  */
    /* JADX WARN: Code duplicated, block: B:612:0x0d79  */
    /* JADX WARN: Code duplicated, block: B:613:0x0d85  */
    /* JADX WARN: Code duplicated, block: B:618:0x0dd1  */
    /* JADX WARN: Code duplicated, block: B:619:0x0e05  */
    /* JADX WARN: Code duplicated, block: B:72:0x014c  */
    /* JADX WARN: Code duplicated, block: B:73:0x014e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x0150  */
    /* JADX WARN: Code duplicated, block: B:75:0x0152 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:76:0x0154  */
    /* JADX WARN: Code duplicated, block: B:77:0x0157  */
    /* JADX WARN: Code duplicated, block: B:80:0x015d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x015f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0162  */
    /* JADX WARN: Code duplicated, block: B:84:0x0165  */
    /* JADX WARN: Code duplicated, block: B:86:0x016d  */
    /* JADX WARN: Multi-variable type inference failed */
    public static List zzb(zzfx zzfxVar, zzagr zzagrVar, long j, zzq zzqVar, boolean z, boolean z2, zzgta zzgtaVar, boolean z3) throws zzat {
        int i;
        int i2;
        long jZzz;
        int i3;
        int i4;
        boolean z4;
        int i5;
        boolean z5;
        long j2;
        long jZzv;
        long jZzv2;
        String str;
        zzfx zzfxVar2;
        long[] jArr;
        long[] jArr2;
        zzv zzvVarZzO;
        zzami zzamiVar;
        zzfw zzfwVar;
        zzap zzapVar;
        zzap zzapVar2;
        Pair pairZzn;
        int i6;
        short s;
        int i7;
        long j3;
        ArrayList arrayList;
        zzq zzqVar2;
        int i8;
        String str2;
        long j4;
        int i9;
        int i10;
        char c;
        String str3;
        String str4;
        int i11;
        int i12;
        zzalf zzalfVar;
        int i13;
        String str5;
        String str6;
        zzalf zzalfVar2;
        int i14;
        int i15;
        int i16;
        zzgm zzgmVar;
        boolean z6;
        int i17;
        int i18;
        boolean z7;
        boolean z8;
        boolean z9;
        zzq zzqVarZzb;
        zzgwm zzgwmVarZzj;
        String str7;
        String str8;
        String str9;
        long j5;
        zzgwm zzgwmVar;
        boolean z10;
        zzami zzamiVar2;
        ArrayList arrayList2;
        ArrayList arrayList3 = new ArrayList();
        int i19 = 0;
        while (true) {
            List list = zzfxVar.zzc;
            if (i19 >= list.size()) {
                return arrayList3;
            }
            zzfx zzfxVar3 = (zzfx) list.get(i19);
            if (zzfxVar3.zzd != 1953653099) {
                arrayList2 = arrayList3;
                i2 = i19;
            } else {
                zzfy zzfyVarZzc = zzfxVar.zzc(Atom.TYPE_mvhd);
                zzfyVarZzc.getClass();
                zzfx zzfxVarZzd = zzfxVar3.zzd(Atom.TYPE_mdia);
                zzfxVarZzd.getClass();
                zzfy zzfyVarZzc2 = zzfxVarZzd.zzc(Atom.TYPE_hdlr);
                zzfyVarZzc2.getClass();
                int iZzj = zzj(zzfyVarZzc2.zza);
                int i20 = 1;
                if (iZzj == 1936684398) {
                    i = 1;
                } else if (iZzj == 1986618469) {
                    i = 2;
                } else if (iZzj == 1952807028 || iZzj == 1935832172 || iZzj == 1937072756 || iZzj == 1668047728 || iZzj == 1937072752) {
                    i = 3;
                } else {
                    i = iZzj == 1835365473 ? 5 : -1;
                }
                if (i == -1) {
                    i2 = i19;
                    zzfxVar2 = zzfxVar3;
                } else {
                    zzfy zzfyVarZzc3 = zzfxVar3.zzc(Atom.TYPE_tkhd);
                    zzfyVarZzc3.getClass();
                    zzet zzetVar = zzfyVarZzc3.zza;
                    int i21 = 8;
                    zzetVar.zzh(8);
                    int iZza = zza(zzetVar.zzB());
                    zzetVar.zzk(iZza == 0 ? 8 : 16);
                    int iZzB = zzetVar.zzB();
                    char c2 = 0;
                    int i22 = 4;
                    zzetVar.zzk(4);
                    int iZzg = zzetVar.zzg();
                    int i23 = 0;
                    while (true) {
                        if (iZza == 0) {
                            i21 = i22;
                        }
                        i2 = i19;
                        if (i23 >= i21) {
                            zzetVar.zzk(i21);
                        } else {
                            if (zzetVar.zzi()[iZzg + i23] != -1) {
                                jZzz = iZza == 0 ? zzetVar.zzz() : zzetVar.zzJ();
                                if (jZzz != 0) {
                                    break;
                                }
                                break;
                            }
                            i23++;
                            i19 = i2;
                            i21 = 8;
                            i22 = 4;
                        }
                        jZzz = C.TIME_UNSET;
                        break;
                    }
                    zzetVar.zzk(10);
                    int iZzt = zzetVar.zzt();
                    zzetVar.zzk(4);
                    int iZzB2 = zzetVar.zzB();
                    int iZzB3 = zzetVar.zzB();
                    zzetVar.zzk(4);
                    int iZzB4 = zzetVar.zzB();
                    int iZzB5 = zzetVar.zzB();
                    if (iZzB2 != 0) {
                        if (iZzB2 == 0) {
                            if (iZzB3 == -65536) {
                                if (iZzB4 != 65536) {
                                    if (iZzB4 == -65536) {
                                        if (iZzB5 == 0) {
                                            z5 = false;
                                        } else {
                                            z5 = true;
                                        }
                                        z4 = z5;
                                        iZzB4 = -65536;
                                    }
                                    iZzB3 = -65536;
                                } else if (iZzB5 == 0) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (true != z4) {
                                    i5 = RotationOptions.ROTATE_270;
                                    i4 = i5;
                                    i20 = 1;
                                }
                                iZzB3 = -65536;
                            }
                            i3 = 0;
                        } else {
                            i3 = iZzB2;
                        }
                        i4 = ((i3 != -65536 || i3 == 65536) && iZzB3 == 0 && iZzB4 == 0 && iZzB5 == -65536) ? 180 : 0;
                    } else {
                        if (iZzB3 == 65536) {
                            if (iZzB4 != -65536) {
                                if (iZzB4 == 65536) {
                                    z10 = iZzB5 != 0;
                                    iZzB4 = 65536;
                                }
                                iZzB3 = 65536;
                            } else {
                                z10 = iZzB5 != 0;
                            }
                            if (true != z10) {
                                i5 = 90;
                            } else {
                                iZzB3 = 65536;
                            }
                            i4 = i5;
                            i20 = 1;
                        }
                        iZzB2 = 0;
                        if (iZzB2 == 0) {
                            if (iZzB3 == -65536) {
                                if (iZzB4 != 65536) {
                                    if (iZzB4 == -65536) {
                                        if (iZzB5 == 0) {
                                            z5 = false;
                                        } else {
                                            z5 = true;
                                        }
                                        z4 = z5;
                                        iZzB4 = -65536;
                                    }
                                    iZzB3 = -65536;
                                } else if (iZzB5 == 0) {
                                    z4 = false;
                                } else {
                                    z4 = true;
                                }
                                if (true != z4) {
                                    i5 = RotationOptions.ROTATE_270;
                                    i4 = i5;
                                    i20 = 1;
                                }
                                iZzB3 = -65536;
                            }
                            i3 = 0;
                        } else {
                            i3 = iZzB2;
                        }
                        if (i3 != -65536) {
                        }
                    }
                    zzetVar.zzk(16);
                    short sZzv = zzetVar.zzv();
                    zzetVar.zzk(2);
                    short sZzv2 = zzetVar.zzv();
                    long j6 = j == C.TIME_UNSET ? jZzz : j;
                    long j7 = zzd(zzfyVarZzc.zza).zzc;
                    if (j6 == C.TIME_UNSET) {
                        j2 = j7;
                        jZzv = -9223372036854775807L;
                    } else {
                        j2 = j7;
                        jZzv = zzfl.zzv(j6, 1000000L, j2, RoundingMode.DOWN);
                    }
                    zzfx zzfxVarZzd2 = zzfxVarZzd.zzd(Atom.TYPE_minf);
                    zzfxVarZzd2.getClass();
                    zzfx zzfxVarZzd3 = zzfxVarZzd2.zzd(Atom.TYPE_stbl);
                    zzfxVarZzd3.getClass();
                    zzfy zzfyVarZzc4 = zzfxVarZzd.zzc(Atom.TYPE_mdhd);
                    zzfyVarZzc4.getClass();
                    zzet zzetVar2 = zzfyVarZzc4.zza;
                    int i24 = 8;
                    zzetVar2.zzh(8);
                    int iZza2 = zza(zzetVar2.zzB());
                    zzetVar2.zzk(iZza2 == 0 ? 8 : 16);
                    long jZzz2 = zzetVar2.zzz();
                    int iZzg2 = zzetVar2.zzg();
                    int i25 = 0;
                    while (true) {
                        if (iZza2 == 0) {
                            i24 = 4;
                        }
                        if (i25 >= i24) {
                            zzfxVar3 = zzfxVar3;
                            zzetVar2.zzk(i24);
                            jZzv2 = -9223372036854775807L;
                            break;
                        }
                        if (zzetVar2.zzi()[iZzg2 + i25] != -1) {
                            long jZzz3 = iZza2 == 0 ? zzetVar2.zzz() : zzetVar2.zzJ();
                            jZzv2 = jZzz3 == 0 ? -9223372036854775807L : zzfl.zzv(jZzz3, 1000000L, jZzz2, RoundingMode.DOWN);
                            break;
                        }
                        i25++;
                        zzfxVar3 = zzfxVar3;
                        i24 = 8;
                    }
                    int iZzt2 = zzetVar2.zzt();
                    char c3 = (char) (((iZzt2 >> 10) & 31) + 96);
                    char c4 = (char) (((iZzt2 >> 5) & 31) + 96);
                    char c5 = (char) ((iZzt2 & 31) + 96);
                    int i26 = 3;
                    char[] cArr = new char[3];
                    cArr[0] = c3;
                    cArr[i20] = c4;
                    char c6 = 2;
                    cArr[2] = c5;
                    int i27 = 0;
                    while (true) {
                        if (i27 >= i26) {
                            str = new String(cArr);
                            break;
                        }
                        char c7 = cArr[i27];
                        if (c7 < 'a' || c7 > 'z') {
                            str = null;
                            break;
                        }
                        i27++;
                        i26 = 3;
                    }
                    zzfy zzfyVarZzc5 = zzfxVarZzd3.zzc(Atom.TYPE_stsd);
                    if (zzfyVarZzc5 == null) {
                        zzeg.zzc("BoxParsers", "Ignoring track where sample table (stbl) box is missing a sample description (stsd).");
                        zzfxVar2 = zzfxVar3;
                    } else {
                        String strZzc = zzalc.zzc(jZzz2, jZzv2, str);
                        zzet zzetVar3 = zzfyVarZzc5.zza;
                        zzetVar3.zzh(12);
                        int iZzB6 = zzetVar3.zzB();
                        zzalf zzalfVar3 = new zzalf(iZzB6);
                        int i28 = i;
                        int i29 = 0;
                        while (i29 < iZzB6) {
                            int i30 = i29;
                            int iZzg3 = zzetVar3.zzg();
                            int iZzB7 = zzetVar3.zzB();
                            int i31 = iZzt;
                            String str10 = "childAtomSize must be positive";
                            zzagc.zza(iZzB7 > 0 ? i20 : c2, "childAtomSize must be positive");
                            int iZzB8 = zzetVar3.zzB();
                            long j8 = jZzv2;
                            if (iZzB8 == 1635148593 || iZzB8 == 1635148595 || iZzB8 == 1701733238 || iZzB8 == 1831958048 || iZzB8 == 1836070006 || iZzB8 == 1752589105 || iZzB8 == 1751479857 || iZzB8 == 1987470129 || iZzB8 == 1987471665 || iZzB8 == 1932670515 || iZzB8 == 1211250227 || iZzB8 == 1748121139 || iZzB8 == 1987063864 || iZzB8 == 1987063865 || iZzB8 == 1635135537 || iZzB8 == 1685479798 || iZzB8 == 1685479729 || iZzB8 == 1685481573 || iZzB8 == 1685481521 || iZzB8 == 1634760241 || iZzB8 == 1684108849) {
                                sZzv2 = sZzv2;
                                i6 = iZzB6;
                                zzalf zzalfVar4 = zzalfVar3;
                                s = sZzv;
                                int i32 = iZzB7;
                                i7 = i31;
                                j3 = j8;
                                String str11 = strZzc;
                                int i33 = iZzB8;
                                int i34 = iZzB;
                                zzetVar3 = zzetVar3;
                                zzetVar3.zzh(iZzg3 + 16);
                                zzetVar3.zzk(16);
                                int iZzt3 = zzetVar3.zzt();
                                i30 = i30;
                                int iZzt4 = zzetVar3.zzt();
                                arrayList = arrayList3;
                                zzetVar3.zzk(50);
                                int iZzg4 = zzetVar3.zzg();
                                str = str;
                                int i35 = Atom.TYPE_encv;
                                if (i33 == 1701733238) {
                                    Pair pairZzr = zzr(zzetVar3, iZzg3, i32);
                                    if (pairZzr != null) {
                                        int iIntValue = ((Integer) pairZzr.first).intValue();
                                        zzqVarZzb = zzqVar == null ? null : zzqVar.zzb(((zzamj) pairZzr.second).zzb);
                                        zzalfVar4.zza[i30] = (zzamj) pairZzr.second;
                                        i35 = iIntValue;
                                    } else {
                                        zzqVarZzb = zzqVar;
                                    }
                                    zzetVar3.zzh(iZzg4);
                                    i33 = i35;
                                    zzqVar2 = zzqVarZzb;
                                } else {
                                    zzqVar2 = zzqVar;
                                }
                                if (i33 == 1831958048) {
                                    int i36 = i33;
                                    str2 = MimeTypes.VIDEO_MPEG;
                                    i8 = i36;
                                } else {
                                    i8 = Atom.TYPE_H263;
                                    if (i33 == 1211250227) {
                                        str2 = MimeTypes.VIDEO_H263;
                                    } else {
                                        i8 = i33;
                                        str2 = null;
                                    }
                                }
                                zzq zzqVar3 = zzqVar2;
                                int i37 = iZzg4;
                                int i38 = i4;
                                String str12 = str2;
                                j4 = jZzz2;
                                float fZzH = 1.0f;
                                int i39 = 8;
                                int iZzc = -1;
                                int i40 = 8;
                                List listZzj = null;
                                int i41 = -1;
                                zzgm zzgmVar2 = null;
                                int i42 = -1;
                                ByteBuffer byteBufferZzm = null;
                                String str13 = null;
                                zzaky zzakyVarZzq = null;
                                zzala zzalaVar = null;
                                int i43 = -1;
                                int i44 = -1;
                                byte[] bArrCopyOfRange = null;
                                int i45 = -1;
                                boolean z11 = false;
                                int i46 = -1;
                                zzfu zzfuVarZza = null;
                                i9 = iZzg3;
                                int i47 = -1;
                                while (i37 - i9 < i32) {
                                    zzetVar3.zzh(i37);
                                    int iZzg5 = zzetVar3.zzg();
                                    int iZzB9 = zzetVar3.zzB();
                                    if (iZzB9 != 0) {
                                        i13 = iZzB9;
                                    } else {
                                        if (zzetVar3.zzg() - i9 == i32) {
                                            break;
                                        }
                                        i13 = 0;
                                    }
                                    zzagc.zza(i13 > 0, str10);
                                    int iZzB10 = zzetVar3.zzB();
                                    if (iZzB10 == 1635148611) {
                                        int i48 = iZzg5 + 8;
                                        zzagc.zza(str12 == null, null);
                                        zzetVar3.zzh(i48);
                                        zzafd zzafdVarZza = zzafd.zza(zzetVar3);
                                        List list2 = zzafdVarZza.zza;
                                        zzalfVar4.zzc = zzafdVarZza.zzb;
                                        if (z11) {
                                            z9 = true;
                                        } else {
                                            fZzH = zzafdVarZza.zzk;
                                            z9 = false;
                                        }
                                        String str14 = zzafdVarZza.zzl;
                                        int i49 = zzafdVarZza.zzj;
                                        int i50 = zzafdVarZza.zzg;
                                        int i51 = zzafdVarZza.zzh;
                                        int i52 = zzafdVarZza.zzi;
                                        int i53 = zzafdVarZza.zze;
                                        int i54 = zzafdVarZza.zzf;
                                        i8 = i8;
                                        z11 = z9;
                                        str6 = str10;
                                        i44 = i49;
                                        zzalfVar2 = zzalfVar4;
                                        i47 = i50;
                                        str5 = MimeTypes.VIDEO_H264;
                                        i40 = i54;
                                        str13 = str14;
                                        iZzc = i52;
                                        i39 = i53;
                                        i41 = i51;
                                        listZzj = list2;
                                    } else if (iZzB10 == 1752589123) {
                                        int i55 = iZzg5 + 8;
                                        zzagc.zza(str12 == null, null);
                                        zzetVar3.zzh(i55);
                                        zzags zzagsVarZza = zzags.zza(zzetVar3);
                                        List list3 = zzagsVarZza.zza;
                                        zzalfVar4.zzc = zzagsVarZza.zzb;
                                        if (z11) {
                                            z8 = true;
                                        } else {
                                            fZzH = zzagsVarZza.zzl;
                                            z8 = false;
                                        }
                                        int i56 = zzagsVarZza.zzm;
                                        int i57 = zzagsVarZza.zzc;
                                        String str15 = zzagsVarZza.zzn;
                                        int i58 = zzagsVarZza.zzk;
                                        if (i58 == -1) {
                                            i58 = i42;
                                        }
                                        int i59 = zzagsVarZza.zzd;
                                        int i60 = zzagsVarZza.zze;
                                        int i61 = zzagsVarZza.zzh;
                                        int i62 = zzagsVarZza.zzi;
                                        int i63 = zzagsVarZza.zzj;
                                        int i64 = zzagsVarZza.zzf;
                                        int i65 = zzagsVarZza.zzg;
                                        zzgm zzgmVar3 = zzagsVarZza.zzo;
                                        i8 = i8;
                                        z11 = z8;
                                        str6 = str10;
                                        zzalfVar2 = zzalfVar4;
                                        i46 = i59;
                                        i41 = i62;
                                        i47 = i61;
                                        str5 = MimeTypes.VIDEO_H265;
                                        i42 = i58;
                                        i45 = i60;
                                        listZzj = list3;
                                        zzgmVar2 = zzgmVar3;
                                        str13 = str15;
                                        i39 = i64;
                                        i40 = i65;
                                        i44 = i56;
                                        iZzc = i63;
                                        i43 = i57;
                                    } else if (iZzB10 == 1818785347) {
                                        int i66 = iZzg5 + 8;
                                        zzagc.zza(MimeTypes.VIDEO_H265.equals(str12), "lhvC must follow hvcC atom");
                                        if (zzgmVar2 != null) {
                                            z7 = zzgmVar2.zza.size() >= 2;
                                        } else {
                                            z7 = false;
                                            zzgmVar2 = null;
                                        }
                                        zzagc.zza(z7, "must have at least two layers");
                                        zzetVar3.zzh(i66);
                                        zzgmVar2.getClass();
                                        zzags zzagsVarZzb = zzags.zzb(zzetVar3, zzgmVar2);
                                        zzagc.zza(zzalfVar4.zzc == zzagsVarZzb.zzb, "nalUnitLengthFieldLength must be same for both hvcC and lhvC atoms");
                                        int i67 = zzagsVarZzb.zzh;
                                        if (i67 != -1) {
                                            zzagc.zza(i47 == i67, "colorSpace must be the same for both views");
                                        }
                                        int i68 = zzagsVarZzb.zzi;
                                        if (i68 != -1) {
                                            zzagc.zza(i41 == i68, "colorRange must be the same for both views");
                                        }
                                        int i69 = zzagsVarZzb.zzj;
                                        if (i69 != -1) {
                                            zzagc.zza(iZzc == i69, "colorTransfer must be the same for both views");
                                        }
                                        zzagc.zza(i39 == zzagsVarZzb.zzf, "bitdepthLuma must be the same for both views");
                                        zzagc.zza(i40 == zzagsVarZzb.zzg, "bitdepthChroma must be the same for both views");
                                        if (listZzj != null) {
                                            int i70 = zzgwm.zzd;
                                            zzgwj zzgwjVar = new zzgwj();
                                            zzgwjVar.zzh(listZzj);
                                            zzgwjVar.zzh(zzagsVarZzb.zza);
                                            listZzj = zzgwjVar.zzi();
                                        } else {
                                            zzagc.zza(false, "initializationData must be already set from hvcC atom");
                                        }
                                        str13 = zzagsVarZzb.zzn;
                                        str6 = str10;
                                        str5 = "video/mv-hevc";
                                        zzalfVar2 = zzalfVar4;
                                    } else if (iZzB10 == 1987470147) {
                                        int i71 = iZzg5 + 8;
                                        zzagc.zza(str12 == null, null);
                                        zzetVar3.zzh(i71);
                                        zzahn zzahnVarZza = zzahn.zza(zzetVar3);
                                        List list4 = zzahnVarZza.zza;
                                        zzalfVar4.zzc = zzahnVarZza.zzb;
                                        String str16 = zzahnVarZza.zzc;
                                        i39 = zzahnVarZza.zzd;
                                        i8 = i8;
                                        listZzj = list4;
                                        str6 = str10;
                                        str13 = str16;
                                        zzalfVar2 = zzalfVar4;
                                        str5 = "video/vvc";
                                        i44 = 16;
                                        i40 = i39;
                                    } else if (iZzB10 == 1986361461) {
                                        zzetVar3.zzh(iZzg5 + 8);
                                        str5 = str12;
                                        int iZzg6 = zzetVar3.zzg();
                                        zzalb zzalbVar = null;
                                        while (iZzg6 - iZzg5 < i13) {
                                            zzetVar3.zzh(iZzg6);
                                            int iZzB11 = zzetVar3.zzB();
                                            zzagc.zza(iZzB11 > 0, str10);
                                            zzalf zzalfVar5 = zzalfVar4;
                                            if (zzetVar3.zzB() == 1702454643) {
                                                zzetVar3.zzh(iZzg6 + 8);
                                                int iZzg7 = zzetVar3.zzg();
                                                while (true) {
                                                    if (iZzg7 - iZzg6 >= iZzB11) {
                                                        i18 = iZzB11;
                                                        zzalbVar = null;
                                                        break;
                                                    }
                                                    zzetVar3.zzh(iZzg7);
                                                    int iZzB12 = zzetVar3.zzB();
                                                    zzagc.zza(iZzB12 > 0, str10);
                                                    i18 = iZzB11;
                                                    if (zzetVar3.zzB() == 1937011305) {
                                                        zzetVar3.zzk(4);
                                                        int iZzs = zzetVar3.zzs();
                                                        zzalbVar = new zzalb(new zzale(1 == (iZzs & 1), (iZzs & 2) == 2, (iZzs & 8) == 8));
                                                        break;
                                                    }
                                                    iZzg7 += iZzB12;
                                                    iZzB11 = i18;
                                                }
                                            } else {
                                                i18 = iZzB11;
                                            }
                                            iZzg6 += i18;
                                            zzalfVar4 = zzalfVar5;
                                            str10 = str10;
                                        }
                                        str6 = str10;
                                        zzalfVar2 = zzalfVar4;
                                        zzali zzaliVar = zzalbVar == null ? null : new zzali(zzalbVar);
                                        if (zzaliVar != null) {
                                            if (zzgmVar2 == null) {
                                                zzgmVar2 = null;
                                            } else if (zzgmVar2.zza.size() >= 2) {
                                                zzagc.zza(zzaliVar.zza(), "both eye views must be marked as available");
                                                zzagc.zza(!zzaliVar.zzb().zza().zzc(), "for MV-HEVC, eye_views_reversed must be set to false");
                                            }
                                            if (i42 == -1) {
                                                i8 = i8;
                                                i42 = true != zzaliVar.zzb().zza().zzc() ? 4 : 5;
                                            } else {
                                                i8 = i8;
                                            }
                                        }
                                        i14 = i39;
                                        i8 = i8;
                                        i15 = i40;
                                        i16 = i41;
                                        zzgmVar = zzgmVar2;
                                        zzgmVar2 = zzgmVar;
                                        i40 = i15;
                                        i39 = i14;
                                        i41 = i16;
                                    } else {
                                        str5 = str12;
                                        str6 = str10;
                                        zzalfVar2 = zzalfVar4;
                                        if (iZzB10 == 1685480259 || iZzB10 == 1685485123 || iZzB10 == 1685485379) {
                                            i14 = i39;
                                            i8 = i8;
                                            i15 = i40;
                                            i16 = i41;
                                            zzgmVar = zzgmVar2;
                                            zzfuVarZza = zzfu.zza(zzetVar3);
                                        } else if (iZzB10 == 1987076931) {
                                            int i72 = iZzg5 + 12;
                                            zzagc.zza(str5 == null, null);
                                            zzetVar3.zzh(i72);
                                            byte bZzs = (byte) zzetVar3.zzs();
                                            byte bZzs2 = (byte) zzetVar3.zzs();
                                            int iZzs2 = zzetVar3.zzs();
                                            int i73 = iZzs2 >> 4;
                                            int i74 = iZzs2 >> 1;
                                            String str17 = i8 == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                                            if (str17.equals(MimeTypes.VIDEO_VP9)) {
                                                listZzj = zzdq.zza(bZzs, bZzs2, (byte) i73, (byte) (i74 & 7));
                                            }
                                            int i75 = iZzs2 & 1;
                                            int iZzs3 = zzetVar3.zzs();
                                            int iZzs4 = zzetVar3.zzs();
                                            int iZzb = zzi.zzb(iZzs3);
                                            int i76 = 1 != i75 ? 2 : 1;
                                            int iZzc2 = zzi.zzc(iZzs4);
                                            i8 = i8;
                                            i47 = iZzb;
                                            i40 = i73;
                                            i41 = i76;
                                            str5 = str17;
                                            iZzc = iZzc2;
                                            i39 = i40;
                                        } else if (iZzB10 == 1635135811) {
                                            int i77 = i13 - 8;
                                            byte[] bArr = new byte[i77];
                                            zzetVar3.zzm(bArr, 0, i77);
                                            zzafc zzafcVarZza = zzafc.zza(bArr);
                                            List list5 = zzafcVarZza.zza;
                                            int i78 = zzafcVarZza.zzb;
                                            int i79 = zzafcVarZza.zzc;
                                            int i80 = zzafcVarZza.zzd;
                                            int i81 = zzafcVarZza.zze;
                                            i8 = i8;
                                            listZzj = list5;
                                            i40 = i78;
                                            i41 = i80;
                                            str5 = MimeTypes.VIDEO_AV1;
                                            iZzc = i81;
                                            i39 = i40;
                                            i47 = i79;
                                        } else if (iZzB10 == 1668050025) {
                                            if (byteBufferZzm == null) {
                                                byteBufferZzm = zzm();
                                            }
                                            ByteBuffer byteBuffer = byteBufferZzm;
                                            byteBuffer.position(21);
                                            byteBuffer.putShort(zzetVar3.zzv());
                                            byteBuffer.putShort(zzetVar3.zzv());
                                            byteBufferZzm = byteBuffer;
                                        } else if (iZzB10 == 1835295606) {
                                            if (byteBufferZzm == null) {
                                                byteBufferZzm = zzm();
                                            }
                                            ByteBuffer byteBuffer2 = byteBufferZzm;
                                            short sZzv3 = zzetVar3.zzv();
                                            short sZzv4 = zzetVar3.zzv();
                                            short sZzv5 = zzetVar3.zzv();
                                            short sZzv6 = zzetVar3.zzv();
                                            short sZzv7 = zzetVar3.zzv();
                                            zzgm zzgmVar4 = zzgmVar2;
                                            short sZzv8 = zzetVar3.zzv();
                                            int i82 = i40;
                                            short sZzv9 = zzetVar3.zzv();
                                            int i83 = i39;
                                            short sZzv10 = zzetVar3.zzv();
                                            long jZzz4 = zzetVar3.zzz();
                                            long jZzz5 = zzetVar3.zzz();
                                            byteBuffer2.position(1);
                                            byteBuffer2.putShort(sZzv7);
                                            byteBuffer2.putShort(sZzv8);
                                            byteBuffer2.putShort(sZzv3);
                                            byteBuffer2.putShort(sZzv4);
                                            byteBuffer2.putShort(sZzv5);
                                            byteBuffer2.putShort(sZzv6);
                                            byteBuffer2.putShort(sZzv9);
                                            byteBuffer2.putShort(sZzv10);
                                            byteBuffer2.putShort((short) (jZzz4 / 10000));
                                            byteBuffer2.putShort((short) (jZzz5 / 10000));
                                            byteBufferZzm = byteBuffer2;
                                            zzgmVar2 = zzgmVar4;
                                            i40 = i82;
                                            i39 = i83;
                                            i41 = i41;
                                        } else {
                                            i14 = i39;
                                            i8 = i8;
                                            i15 = i40;
                                            i16 = i41;
                                            zzgmVar = zzgmVar2;
                                            if (iZzB10 == 1681012275) {
                                                zzagc.zza(str5 == null, null);
                                                str5 = MimeTypes.VIDEO_H263;
                                            } else if (iZzB10 == 1702061171) {
                                                zzagc.zza(str5 == null, null);
                                                zzala zzalaVarZzp = zzp(zzetVar3, iZzg5);
                                                String strZza = zzalaVarZzp.zza();
                                                byte[] bArrZzb = zzalaVarZzp.zzb();
                                                if (bArrZzb != null) {
                                                    zzalaVar = zzalaVarZzp;
                                                    str5 = strZza;
                                                    listZzj = zzgwm.zzj(bArrZzb);
                                                } else {
                                                    zzalaVar = zzalaVarZzp;
                                                    str5 = strZza;
                                                }
                                            } else if (iZzB10 == 1651798644) {
                                                zzakyVarZzq = zzq(zzetVar3, iZzg5);
                                            } else if (iZzB10 == 1885434736) {
                                                zzetVar3.zzh(iZzg5 + 8);
                                                fZzH = zzetVar3.zzH() / zzetVar3.zzH();
                                                zzgmVar2 = zzgmVar;
                                                i40 = i15;
                                                i39 = i14;
                                                i41 = i16;
                                                z11 = true;
                                            } else if (iZzB10 == 1937126244) {
                                                int i84 = iZzg5 + 8;
                                                while (true) {
                                                    if (i84 - iZzg5 >= i13) {
                                                        bArrCopyOfRange = null;
                                                        break;
                                                    }
                                                    zzetVar3.zzh(i84);
                                                    int iZzB13 = zzetVar3.zzB() + i84;
                                                    if (zzetVar3.zzB() == 1886547818) {
                                                        bArrCopyOfRange = Arrays.copyOfRange(zzetVar3.zzi(), i84, iZzB13);
                                                        break;
                                                    }
                                                    i84 = iZzB13;
                                                }
                                            } else if (iZzB10 == 1936995172) {
                                                int iZzs5 = zzetVar3.zzs();
                                                zzetVar3.zzk(3);
                                                if (iZzs5 == 0) {
                                                    int iZzs6 = zzetVar3.zzs();
                                                    if (iZzs6 == 0) {
                                                        zzgmVar2 = zzgmVar;
                                                        i40 = i15;
                                                        i39 = i14;
                                                        i41 = i16;
                                                        i42 = 0;
                                                    } else if (iZzs6 == 1) {
                                                        zzgmVar2 = zzgmVar;
                                                        i40 = i15;
                                                        i39 = i14;
                                                        i41 = i16;
                                                        i42 = 1;
                                                    } else if (iZzs6 == 2) {
                                                        zzgmVar2 = zzgmVar;
                                                        i40 = i15;
                                                        i39 = i14;
                                                        i41 = i16;
                                                        i42 = 2;
                                                    } else if (iZzs6 == 3) {
                                                        i42 = 3;
                                                        zzgmVar2 = zzgmVar;
                                                        i40 = i15;
                                                        i39 = i14;
                                                        i41 = i16;
                                                    }
                                                }
                                            } else if (iZzB10 == 1634760259) {
                                                int i85 = i13 - 12;
                                                byte[] bArr2 = new byte[i85];
                                                zzetVar3.zzh(iZzg5 + 12);
                                                zzetVar3.zzm(bArr2, 0, i85);
                                                String strZzd = zzdq.zzd(bArr2);
                                                zzgwm zzgwmVarZzj2 = zzgwm.zzj(bArr2);
                                                zzi zziVarZzl = zzl(new zzet(bArr2));
                                                int i86 = zziVarZzl.zzf;
                                                int i87 = zziVarZzl.zzg;
                                                int i88 = zziVarZzl.zzb;
                                                str13 = strZzd;
                                                i39 = i86;
                                                i41 = zziVarZzl.zzc;
                                                str5 = "video/apv";
                                                zzgmVar2 = zzgmVar;
                                                iZzc = zziVarZzl.zzd;
                                                listZzj = zzgwmVarZzj2;
                                                i40 = i87;
                                                i47 = i88;
                                            } else if (iZzB10 == 1668246642 && i47 == -1) {
                                                if (iZzc == -1) {
                                                    int iZzB14 = zzetVar3.zzB();
                                                    if (iZzB14 == 1852009592 || iZzB14 == 1852009571) {
                                                        int iZzt5 = zzetVar3.zzt();
                                                        int iZzt6 = zzetVar3.zzt();
                                                        zzetVar3.zzk(2);
                                                        int i89 = 19;
                                                        if (i13 == 19) {
                                                            z6 = (zzetVar3.zzs() & 128) != 0;
                                                            int iZzb2 = zzi.zzb(iZzt5);
                                                            if (true != z6) {
                                                                i17 = 2;
                                                            } else {
                                                                i17 = 1;
                                                            }
                                                            i13 = i89;
                                                            i41 = i17;
                                                            zzgmVar2 = zzgmVar;
                                                            i40 = i15;
                                                            iZzc = zzi.zzc(iZzt6);
                                                            i47 = iZzb2;
                                                            i39 = i14;
                                                        } else {
                                                            i89 = i13;
                                                        }
                                                        int iZzb3 = zzi.zzb(iZzt5);
                                                        if (true != z6) {
                                                            i17 = 2;
                                                        } else {
                                                            i17 = 1;
                                                        }
                                                        i13 = i89;
                                                        i41 = i17;
                                                        zzgmVar2 = zzgmVar;
                                                        i40 = i15;
                                                        iZzc = zzi.zzc(iZzt6);
                                                        i47 = iZzb3;
                                                        i39 = i14;
                                                    } else {
                                                        zzeg.zzc("BoxParsers", "Unsupported color type: ".concat(zzfz.zze(iZzB14)));
                                                        i47 = -1;
                                                        iZzc = -1;
                                                        zzgmVar2 = zzgmVar;
                                                        i40 = i15;
                                                        i39 = i14;
                                                        i41 = i16;
                                                    }
                                                } else {
                                                    i47 = -1;
                                                }
                                            }
                                            zzgmVar2 = zzgmVar;
                                            i40 = i15;
                                            i39 = i14;
                                            i41 = i16;
                                        }
                                        zzgmVar2 = zzgmVar;
                                        i40 = i15;
                                        i39 = i14;
                                        i41 = i16;
                                    }
                                    i37 += i13;
                                    i32 = i32;
                                    str12 = str5;
                                    i8 = i8;
                                    zzalfVar4 = zzalfVar2;
                                    str10 = str6;
                                }
                                int i90 = i39;
                                String str18 = str12;
                                i10 = i32;
                                zzalf zzalfVar6 = zzalfVar4;
                                int i91 = i40;
                                int i92 = i41;
                                c = 2;
                                if (zzfuVarZza != null) {
                                    str3 = zzfuVarZza.zza;
                                    str4 = MimeTypes.VIDEO_DOLBY_VISION;
                                } else {
                                    str3 = str13;
                                    str4 = str18;
                                }
                                if (str4 == null) {
                                    strZzc = str11;
                                    i12 = i38;
                                    i11 = i34;
                                    zzalfVar = zzalfVar6;
                                } else {
                                    zzt zztVar = new zzt();
                                    i11 = i34;
                                    zztVar.zzb(i11);
                                    zztVar.zzo(str4);
                                    zztVar.zzk(str3);
                                    zztVar.zzv(iZzt3);
                                    zztVar.zzw(iZzt4);
                                    zztVar.zzx(i46);
                                    zztVar.zzy(i45);
                                    zztVar.zzB(fZzH);
                                    i12 = i38;
                                    zztVar.zzA(i12);
                                    zztVar.zzC(bArrCopyOfRange);
                                    zztVar.zzD(i42);
                                    zztVar.zzr(listZzj);
                                    zztVar.zzq(i44);
                                    zztVar.zzF(i43);
                                    zztVar.zzs(zzqVar3);
                                    strZzc = str11;
                                    zztVar.zze(strZzc);
                                    zzh zzhVar = new zzh();
                                    zzhVar.zza(i47);
                                    zzhVar.zzb(i92);
                                    zzhVar.zzc(iZzc);
                                    zzhVar.zzd(byteBufferZzm != null ? byteBufferZzm.array() : null);
                                    zzhVar.zze(i90);
                                    zzhVar.zzf(i91);
                                    zztVar.zzE(zzhVar.zzg());
                                    if (zzakyVarZzq != null) {
                                        zztVar.zzi(zzhah.zzb(zzakyVarZzq.zza()));
                                        zztVar.zzj(zzhah.zzb(zzakyVarZzq.zzb()));
                                    } else if (zzalaVar != null) {
                                        zztVar.zzi(zzhah.zzb(zzalaVar.zzc()));
                                        zztVar.zzj(zzhah.zzb(zzalaVar.zzd()));
                                    }
                                    zzalfVar = zzalfVar6;
                                    zzalfVar.zzb = zztVar.zzO();
                                }
                            } else if (iZzB8 == 1836069985 || iZzB8 == 1701733217 || iZzB8 == 1633889587 || iZzB8 == 1700998451 || iZzB8 == 1633889588 || iZzB8 == 1835823201 || iZzB8 == 1685353315 || iZzB8 == 1685353317 || iZzB8 == 1685353320 || iZzB8 == 1685353324 || iZzB8 == 1685353336 || iZzB8 == 1935764850 || iZzB8 == 1935767394 || iZzB8 == 1819304813 || iZzB8 == 1936684916 || iZzB8 == 1953984371 || iZzB8 == 778924082 || iZzB8 == 778924083 || iZzB8 == 1835557169 || iZzB8 == 1835560241 || iZzB8 == 1634492771 || iZzB8 == 1634492791 || iZzB8 == 1970037111 || iZzB8 == 1332770163 || iZzB8 == 1716281667 || iZzB8 == 1767992678 || iZzB8 == 1768973165 || iZzB8 == 1718641517) {
                                int i93 = iZzB;
                                sZzv2 = sZzv2;
                                i6 = iZzB6;
                                zzalf zzalfVar7 = zzalfVar3;
                                s = sZzv;
                                i7 = i31;
                                j3 = j8;
                                String str19 = strZzc;
                                zzo(zzetVar3, iZzB8, iZzg3, iZzB7, i93, str19, z2, zzqVar, zzalfVar7, i30);
                                zzetVar3 = zzetVar3;
                                i11 = i93;
                                strZzc = str19;
                                zzalfVar = zzalfVar7;
                                str = str;
                                i9 = iZzg3;
                                i10 = iZzB7;
                                i30 = i30;
                                arrayList = arrayList3;
                                i12 = i4;
                                j4 = jZzz2;
                                c = 2;
                            } else {
                                if (iZzB8 == 1414810956 || iZzB8 == 1954034535 || iZzB8 == 2004251764 || iZzB8 == 1937010800 || iZzB8 == 1664495672 || iZzB8 == 1836070003) {
                                    zzetVar3.zzh(iZzg3 + 16);
                                    if (iZzB8 == 1414810956) {
                                        str9 = MimeTypes.APPLICATION_TTML;
                                    } else {
                                        if (iZzB8 == 1954034535) {
                                            int i94 = iZzB7 - 16;
                                            byte[] bArr3 = new byte[i94];
                                            zzetVar3.zzm(bArr3, 0, i94);
                                            zzgwmVarZzj = zzgwm.zzj(bArr3);
                                            str8 = MimeTypes.APPLICATION_TX3G;
                                        } else if (iZzB8 == 2004251764) {
                                            str9 = MimeTypes.APPLICATION_MP4VTT;
                                        } else {
                                            if (iZzB8 == 1937010800) {
                                                str9 = MimeTypes.APPLICATION_TTML;
                                                j5 = 0;
                                            } else if (iZzB8 == 1664495672) {
                                                zzalfVar3.zzd = i20;
                                                str9 = MimeTypes.APPLICATION_MP4CEA608;
                                            } else {
                                                int iZzg8 = zzetVar3.zzg();
                                                zzetVar3.zzk(4);
                                                if (zzetVar3.zzB() == 1702061171) {
                                                    zzala zzalaVarZzp2 = zzp(zzetVar3, iZzg8);
                                                    if (zzalaVarZzp2.zzb() != null && zzalaVarZzp2.zzb().length == 64) {
                                                        String strZzk = zzk(zzalaVarZzp2.zzb(), sZzv, sZzv2);
                                                        String str20 = zzfl.zza;
                                                        zzgwmVarZzj = zzgwm.zzj(strZzk.getBytes(StandardCharsets.UTF_8));
                                                        str7 = MimeTypes.APPLICATION_VOBSUB;
                                                    }
                                                    i6 = iZzB6;
                                                    zzalfVar = zzalfVar3;
                                                    i12 = i4;
                                                    s = sZzv;
                                                    j4 = jZzz2;
                                                    c = c6;
                                                    i10 = iZzB7;
                                                    i9 = iZzg3;
                                                    i7 = i31;
                                                    j3 = j8;
                                                    i11 = iZzB;
                                                    arrayList = arrayList3;
                                                } else {
                                                    zzgwmVarZzj = null;
                                                    str7 = null;
                                                }
                                                str8 = str7;
                                            }
                                            zzgwmVar = null;
                                            if (str9 != null) {
                                                zzt zztVar2 = new zzt();
                                                zztVar2.zzb(iZzB);
                                                zztVar2.zzo(str9);
                                                zztVar2.zze(strZzc);
                                                zztVar2.zzt(j5);
                                                zztVar2.zzr(zzgwmVar);
                                                zzalfVar3.zzb = zztVar2.zzO();
                                            }
                                            i6 = iZzB6;
                                            zzalfVar = zzalfVar3;
                                            i12 = i4;
                                            s = sZzv;
                                            j4 = jZzz2;
                                            c = c6;
                                            i10 = iZzB7;
                                            i9 = iZzg3;
                                            i7 = i31;
                                            j3 = j8;
                                            i11 = iZzB;
                                            arrayList = arrayList3;
                                        }
                                        zzgwmVar = zzgwmVarZzj;
                                        str9 = str8;
                                        sZzv2 = sZzv2;
                                        j5 = Long.MAX_VALUE;
                                        if (str9 != null) {
                                            zzt zztVar3 = new zzt();
                                            zztVar3.zzb(iZzB);
                                            zztVar3.zzo(str9);
                                            zztVar3.zze(strZzc);
                                            zztVar3.zzt(j5);
                                            zztVar3.zzr(zzgwmVar);
                                            zzalfVar3.zzb = zztVar3.zzO();
                                        }
                                        i6 = iZzB6;
                                        zzalfVar = zzalfVar3;
                                        i12 = i4;
                                        s = sZzv;
                                        j4 = jZzz2;
                                        c = c6;
                                        i10 = iZzB7;
                                        i9 = iZzg3;
                                        i7 = i31;
                                        j3 = j8;
                                        i11 = iZzB;
                                        arrayList = arrayList3;
                                    }
                                    j5 = Long.MAX_VALUE;
                                    zzgwmVar = null;
                                    if (str9 != null) {
                                        zzt zztVar4 = new zzt();
                                        zztVar4.zzb(iZzB);
                                        zztVar4.zzo(str9);
                                        zztVar4.zze(strZzc);
                                        zztVar4.zzt(j5);
                                        zztVar4.zzr(zzgwmVar);
                                        zzalfVar3.zzb = zztVar4.zzO();
                                    }
                                    i6 = iZzB6;
                                    zzalfVar = zzalfVar3;
                                    i12 = i4;
                                    s = sZzv;
                                    j4 = jZzz2;
                                    c = c6;
                                    i10 = iZzB7;
                                    i9 = iZzg3;
                                    i7 = i31;
                                    j3 = j8;
                                    i11 = iZzB;
                                    arrayList = arrayList3;
                                } else if (iZzB8 == 1835365492) {
                                    zzetVar3.zzh(iZzg3 + 16);
                                    char c8 = c2;
                                    zzetVar3.zzM(c8);
                                    String strZzM = zzetVar3.zzM(c8);
                                    if (strZzM != null) {
                                        zzt zztVar5 = new zzt();
                                        zztVar5.zzb(iZzB);
                                        zztVar5.zzo(strZzM);
                                        zzalfVar3.zzb = zztVar5.zzO();
                                    }
                                } else if (iZzB8 == 1667329389) {
                                    zzt zztVar6 = new zzt();
                                    zztVar6.zzb(iZzB);
                                    zztVar6.zzo(MimeTypes.APPLICATION_CAMERA_MOTION);
                                    zzalfVar3.zzb = zztVar6.zzO();
                                }
                                sZzv2 = sZzv2;
                                i6 = iZzB6;
                                zzalfVar = zzalfVar3;
                                i12 = i4;
                                s = sZzv;
                                j4 = jZzz2;
                                c = c6;
                                i10 = iZzB7;
                                i9 = iZzg3;
                                i7 = i31;
                                j3 = j8;
                                i11 = iZzB;
                                arrayList = arrayList3;
                            }
                            zzetVar3.zzh(i9 + i10);
                            i4 = i12;
                            zzetVar3 = zzetVar3;
                            i29 = i30 + 1;
                            strZzc = strZzc;
                            zzalfVar3 = zzalfVar;
                            c6 = c;
                            iZzB = i11;
                            sZzv2 = sZzv2;
                            iZzB6 = i6;
                            str = str;
                            arrayList3 = arrayList;
                            sZzv = s;
                            jZzz2 = j4;
                            iZzt = i7;
                            jZzv2 = j3;
                            i20 = 1;
                            c2 = 0;
                        }
                        String str21 = str;
                        int i95 = iZzB;
                        int i96 = iZzt;
                        long j9 = jZzv2;
                        zzalf zzalfVar8 = zzalfVar3;
                        arrayList3 = arrayList3;
                        long j10 = jZzz2;
                        if (z) {
                            zzfxVar2 = zzfxVar3;
                        } else {
                            zzfxVar2 = zzfxVar3;
                            zzfx zzfxVarZzd4 = zzfxVar2.zzd(Atom.TYPE_edts);
                            if (zzfxVarZzd4 != null && (pairZzn = zzn(zzfxVarZzd4)) != null) {
                                long[] jArr3 = (long[]) pairZzn.first;
                                jArr2 = (long[]) pairZzn.second;
                                jArr = jArr3;
                            }
                            zzvVarZzO = zzalfVar8.zzb;
                            if (zzvVarZzO == null) {
                                zzgtaVar = zzgtaVar;
                                zzamiVar = null;
                            } else {
                                if (i96 != 0) {
                                    zzfwVar = new zzfw(i96);
                                    zzt zztVarZza = zzvVarZzO.zza();
                                    zzapVar = zzvVarZzO.zzl;
                                    if (zzapVar != null) {
                                        zzapVar2 = zzapVar.zzg(zzfwVar);
                                    } else {
                                        zzapVar2 = new zzap(C.TIME_UNSET, zzfwVar);
                                    }
                                    zztVarZza.zzl(zzapVar2);
                                    zzvVarZzO = zztVarZza.zzO();
                                }
                                zzami zzamiVar3 = new zzami(i95, i28, zzalc.zza(j10, j9, str21), j2, jZzv, zzalc.zzb(j10, j9, str21), zzvVarZzO, zzalfVar8.zzd, zzalfVar8.zza, zzalfVar8.zzc, jArr, jArr2);
                                zzgtaVar = zzgtaVar;
                                zzamiVar = zzamiVar3;
                            }
                        }
                        jArr = null;
                        jArr2 = null;
                        zzvVarZzO = zzalfVar8.zzb;
                        if (zzvVarZzO == null) {
                            zzgtaVar = zzgtaVar;
                            zzamiVar = null;
                        } else {
                            if (i96 != 0) {
                                zzfwVar = new zzfw(i96);
                                zzt zztVarZza2 = zzvVarZzO.zza();
                                zzapVar = zzvVarZzO.zzl;
                                if (zzapVar != null) {
                                    zzapVar2 = zzapVar.zzg(zzfwVar);
                                } else {
                                    zzapVar2 = new zzap(C.TIME_UNSET, zzfwVar);
                                }
                                zztVarZza2.zzl(zzapVar2);
                                zzvVarZzO = zztVarZza2.zzO();
                            }
                            zzami zzamiVar4 = new zzami(i95, i28, zzalc.zza(j10, j9, str21), j2, jZzv, zzalc.zzb(j10, j9, str21), zzvVarZzO, zzalfVar8.zzd, zzalfVar8.zza, zzalfVar8.zzc, jArr, jArr2);
                            zzgtaVar = zzgtaVar;
                            zzamiVar = zzamiVar4;
                        }
                    }
                    zzamiVar2 = (zzami) zzgtaVar.apply(zzamiVar);
                    if (zzamiVar2 != null) {
                        zzfx zzfxVarZzd5 = zzfxVar2.zzd(Atom.TYPE_mdia);
                        zzfxVarZzd5.getClass();
                        zzfx zzfxVarZzd6 = zzfxVarZzd5.zzd(Atom.TYPE_minf);
                        zzfxVarZzd6.getClass();
                        zzfx zzfxVarZzd7 = zzfxVarZzd6.zzd(Atom.TYPE_stbl);
                        zzfxVarZzd7.getClass();
                        zzaml zzamlVarZzg = zzg(zzamiVar2, zzfxVarZzd7, zzagrVar, false);
                        arrayList2 = arrayList3;
                        arrayList2.add(zzamlVarZzg);
                    } else {
                        arrayList2 = arrayList3;
                    }
                    i19 = i2 + 1;
                    arrayList3 = arrayList2;
                }
                zzamiVar = null;
                zzamiVar2 = (zzami) zzgtaVar.apply(zzamiVar);
                if (zzamiVar2 != null) {
                    zzfx zzfxVarZzd8 = zzfxVar2.zzd(Atom.TYPE_mdia);
                    zzfxVarZzd8.getClass();
                    zzfx zzfxVarZzd9 = zzfxVarZzd8.zzd(Atom.TYPE_minf);
                    zzfxVarZzd9.getClass();
                    zzfx zzfxVarZzd10 = zzfxVarZzd9.zzd(Atom.TYPE_stbl);
                    zzfxVarZzd10.getClass();
                    zzaml zzamlVarZzg2 = zzg(zzamiVar2, zzfxVarZzd10, zzagrVar, false);
                    arrayList2 = arrayList3;
                    arrayList2.add(zzamlVarZzg2);
                } else {
                    arrayList2 = arrayList3;
                }
                i19 = i2 + 1;
                arrayList3 = arrayList2;
            }
            i19 = i2 + 1;
            arrayList3 = arrayList2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00da  */
    public static zzap zzc(zzfy zzfyVar) {
        int iZzF;
        zzet zzetVar = zzfyVar.zza;
        zzetVar.zzh(8);
        zzap zzapVar = new zzap(C.TIME_UNSET, new zzao[0]);
        while (zzetVar.zzd() >= 8) {
            int iZzg = zzetVar.zzg();
            int iZzB = zzetVar.zzB() + iZzg;
            int iZzB2 = zzetVar.zzB();
            zzap zzapVar2 = null;
            if (iZzB2 == 1835365473) {
                zzetVar.zzh(iZzg);
                zzetVar.zzk(8);
                zzf(zzetVar);
                while (zzetVar.zzg() < iZzB) {
                    int iZzg2 = zzetVar.zzg();
                    int iZzB3 = zzetVar.zzB() + iZzg2;
                    if (zzetVar.zzB() == 1768715124) {
                        zzetVar.zzh(iZzg2);
                        zzetVar.zzk(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzetVar.zzg() < iZzB3) {
                            zzao zzaoVarZzc = zzalt.zzc(zzetVar);
                            if (zzaoVarZzc != null) {
                                arrayList.add(zzaoVarZzc);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            zzapVar2 = new zzap(arrayList);
                            break;
                        }
                        break;
                    }
                    zzetVar.zzh(iZzB3);
                }
                zzapVar = zzapVar.zzf(zzapVar2);
            } else if (iZzB2 == 1936553057) {
                zzetVar.zzh(iZzg);
                zzetVar.zzk(12);
                while (zzetVar.zzg() < iZzB) {
                    int iZzg3 = zzetVar.zzg();
                    int iZzB4 = zzetVar.zzB();
                    if (zzetVar.zzB() == 1935766900) {
                        if (iZzB4 < 16) {
                            break;
                        }
                        zzetVar.zzk(4);
                        int i = -1;
                        int i2 = 0;
                        for (int i3 = 0; i3 < 2; i3++) {
                            int iZzs = zzetVar.zzs();
                            int iZzs2 = zzetVar.zzs();
                            if (iZzs == 0) {
                                i = iZzs2;
                            } else if (iZzs == 1) {
                                i2 = iZzs2;
                            }
                        }
                        if (i == 12) {
                            iZzF = PsExtractor.VIDEO_STREAM_MASK;
                        } else if (i == 13) {
                            iZzF = 120;
                        } else if (i == 21 && zzetVar.zzd() >= 8 && zzetVar.zzg() + 8 <= iZzB) {
                            int iZzB5 = zzetVar.zzB();
                            int iZzB6 = zzetVar.zzB();
                            if (iZzB5 < 12 || iZzB6 != 1936877170) {
                                iZzF = -2147483647;
                            } else {
                                iZzF = zzetVar.zzF();
                            }
                        } else {
                            iZzF = -2147483647;
                        }
                        if (iZzF == -2147483647) {
                            break;
                        }
                        zzapVar2 = new zzap(C.TIME_UNSET, new zzajx(iZzF, i2));
                        break;
                    }
                    zzetVar.zzh(iZzg3 + iZzB4);
                }
                zzapVar = zzapVar.zzf(zzapVar2);
            } else if (iZzB2 == -1451722374) {
                zzapVar = zzapVar.zzf(zzi(zzetVar));
            } else if (iZzB2 == 1667788908) {
                zzapVar = zzapVar.zzf(zzh(zzetVar));
            }
            zzetVar.zzh(iZzB);
        }
        return zzapVar;
    }

    public static zzgb zzd(zzet zzetVar) {
        long jZzD;
        long jZzD2;
        zzetVar.zzh(8);
        if (zza(zzetVar.zzB()) == 0) {
            jZzD = zzetVar.zzz();
            jZzD2 = zzetVar.zzz();
        } else {
            jZzD = zzetVar.zzD();
            jZzD2 = zzetVar.zzD();
        }
        return new zzgb(jZzD, jZzD2, zzetVar.zzz());
    }

    public static zzap zze(zzfx zzfxVar) {
        zzfv zzfvVar;
        zzfy zzfyVarZzc = zzfxVar.zzc(Atom.TYPE_hdlr);
        zzfy zzfyVarZzc2 = zzfxVar.zzc(Atom.TYPE_keys);
        zzfy zzfyVarZzc3 = zzfxVar.zzc(Atom.TYPE_ilst);
        if (zzfyVarZzc != null && zzfyVarZzc2 != null && zzfyVarZzc3 != null && zzj(zzfyVarZzc.zza) == 1835299937) {
            zzet zzetVar = zzfyVarZzc2.zza;
            zzetVar.zzh(12);
            int iZzB = zzetVar.zzB();
            String[] strArr = new String[iZzB];
            for (int i = 0; i < iZzB; i++) {
                int iZzB2 = zzetVar.zzB();
                zzetVar.zzk(4);
                strArr[i] = zzetVar.zzK(iZzB2 - 8, StandardCharsets.UTF_8);
            }
            zzet zzetVar2 = zzfyVarZzc3.zza;
            zzetVar2.zzh(8);
            ArrayList arrayList = new ArrayList();
            while (zzetVar2.zzd() > 8) {
                int iZzg = zzetVar2.zzg() + zzetVar2.zzB();
                int iZzB3 = zzetVar2.zzB() - 1;
                if (iZzB3 < 0 || iZzB3 >= iZzB) {
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzB3).length() + 41);
                    sb.append("Skipped metadata with unknown key index: ");
                    sb.append(iZzB3);
                    zzeg.zzc("BoxParsers", sb.toString());
                } else {
                    String str = strArr[iZzB3];
                    while (true) {
                        int iZzg2 = zzetVar2.zzg();
                        if (iZzg2 < iZzg) {
                            int iZzB4 = zzetVar2.zzB();
                            if (zzetVar2.zzB() == 1684108385) {
                                int iZzB5 = zzetVar2.zzB();
                                int iZzB6 = zzetVar2.zzB();
                                int i2 = iZzB4 - 16;
                                byte[] bArr = new byte[i2];
                                zzetVar2.zzm(bArr, 0, i2);
                                try {
                                    zzfvVar = new zzfv(str, bArr, iZzB6, iZzB5);
                                    break;
                                } catch (Exception unused) {
                                    String.valueOf(str);
                                    zzeg.zzc("MetadataUtil", "Failed to parse metadata entry with key: ".concat(String.valueOf(str)));
                                    zzfvVar = null;
                                    break;
                                }
                            }
                            zzetVar2.zzh(iZzg2 + iZzB4);
                        }
                        zzfvVar = null;
                        break;
                    }
                    if (zzfvVar != null) {
                        arrayList.add(zzfvVar);
                    }
                }
                zzetVar2.zzh(iZzg);
            }
            if (!arrayList.isEmpty()) {
                return new zzap(arrayList);
            }
        }
        return null;
    }

    public static void zzf(zzet zzetVar) {
        int iZzg = zzetVar.zzg();
        zzetVar.zzk(4);
        if (zzetVar.zzB() != 1751411826) {
            iZzg += 4;
        }
        zzetVar.zzh(iZzg);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x029a  */
    /* JADX WARN: Code duplicated, block: B:105:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:108:0x02b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:110:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:115:0x02e3 A[DONT_INVERT, LOOP:14: B:115:0x02e3->B:119:0x02ee, LOOP_START, PHI: r33
  0x02e3: PHI (r33v2 int) = (r33v1 int), (r33v3 int) binds: [B:114:0x02e1, B:119:0x02ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:116:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:119:0x02ee A[LOOP:14: B:115:0x02e3->B:119:0x02ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:120:0x02f4 A[EDGE_INSN: B:120:0x02f4->B:121:0x02f6 BREAK  A[LOOP:14: B:115:0x02e3->B:119:0x02ee]] */
    /* JADX WARN: Code duplicated, block: B:122:0x02f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:123:0x02fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:124:0x02fc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:125:0x02fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x0300 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0302  */
    /* JADX WARN: Code duplicated, block: B:128:0x030f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0317  */
    /* JADX WARN: Code duplicated, block: B:130:0x0322  */
    /* JADX WARN: Code duplicated, block: B:131:0x032c  */
    /* JADX WARN: Code duplicated, block: B:132:0x0335  */
    /* JADX WARN: Code duplicated, block: B:136:0x0345  */
    /* JADX WARN: Code duplicated, block: B:139:0x039e  */
    /* JADX WARN: Code duplicated, block: B:140:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:145:0x0401  */
    /* JADX WARN: Code duplicated, block: B:152:0x043e  */
    /* JADX WARN: Code duplicated, block: B:154:0x044d  */
    /* JADX WARN: Code duplicated, block: B:156:0x0453  */
    /* JADX WARN: Code duplicated, block: B:181:0x0509  */
    /* JADX WARN: Code duplicated, block: B:183:0x050d  */
    /* JADX WARN: Code duplicated, block: B:195:0x0564  */
    /* JADX WARN: Code duplicated, block: B:196:0x0566  */
    /* JADX WARN: Code duplicated, block: B:200:0x057e  */
    /* JADX WARN: Code duplicated, block: B:202:0x0588  */
    /* JADX WARN: Code duplicated, block: B:205:0x05b5  */
    /* JADX WARN: Code duplicated, block: B:207:0x05bb  */
    /* JADX WARN: Code duplicated, block: B:208:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:220:0x05e4  */
    /* JADX WARN: Code duplicated, block: B:222:0x05ec  */
    /* JADX WARN: Code duplicated, block: B:228:0x0601  */
    /* JADX WARN: Code duplicated, block: B:231:0x060a  */
    /* JADX WARN: Code duplicated, block: B:232:0x060c  */
    /* JADX WARN: Code duplicated, block: B:234:0x0613  */
    /* JADX WARN: Code duplicated, block: B:238:0x062f  */
    /* JADX WARN: Code duplicated, block: B:239:0x0631  */
    /* JADX WARN: Code duplicated, block: B:242:0x0637  */
    /* JADX WARN: Code duplicated, block: B:243:0x063a  */
    /* JADX WARN: Code duplicated, block: B:245:0x063d  */
    /* JADX WARN: Code duplicated, block: B:246:0x0640  */
    /* JADX WARN: Code duplicated, block: B:249:0x0644  */
    /* JADX WARN: Code duplicated, block: B:251:0x0648  */
    /* JADX WARN: Code duplicated, block: B:252:0x064b  */
    /* JADX WARN: Code duplicated, block: B:254:0x064e  */
    /* JADX WARN: Code duplicated, block: B:258:0x0662  */
    /* JADX WARN: Code duplicated, block: B:260:0x066e  */
    /* JADX WARN: Code duplicated, block: B:262:0x067b  */
    /* JADX WARN: Code duplicated, block: B:264:0x069e  */
    /* JADX WARN: Code duplicated, block: B:265:0x06a1  */
    /* JADX WARN: Code duplicated, block: B:280:0x06f8  */
    /* JADX WARN: Code duplicated, block: B:293:0x05c9 A[EDGE_INSN: B:293:0x05c9->B:212:0x05c9 BREAK  A[LOOP:6: B:203:0x05b2->B:211:0x05c6], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:296:0x05c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:308:0x02d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:309:0x023b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:311:0x02c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:313:0x0232 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:314:0x0235 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:316:0x0268 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:317:0x02f4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:318:0x02eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:56:0x013e  */
    /* JADX WARN: Code duplicated, block: B:57:0x0141  */
    /* JADX WARN: Code duplicated, block: B:59:0x0145  */
    /* JADX WARN: Code duplicated, block: B:62:0x0151 A[LOOP:0: B:60:0x014b->B:62:0x0151, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:65:0x0165 A[LOOP:1: B:64:0x0163->B:65:0x0165, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x0189  */
    /* JADX WARN: Code duplicated, block: B:70:0x019d A[LOOP:3: B:69:0x019b->B:70:0x019d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:77:0x0219  */
    /* JADX WARN: Code duplicated, block: B:79:0x021f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0225 A[LOOP:12: B:78:0x021d->B:81:0x0225, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x0256 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x0259 A[ADDED_TO_REGION, LOOP:13: B:89:0x0259->B:91:0x025d, LOOP_START, PHI: r9 r33 r34
  0x0259: PHI (r9v9 int) = (r9v3 int), (r9v10 int) binds: [B:87:0x0256, B:91:0x025d] A[DONT_GENERATE, DONT_INLINE]
  0x0259: PHI (r33v5 int) = (r33v1 int), (r33v6 int) binds: [B:87:0x0256, B:91:0x025d] A[DONT_GENERATE, DONT_INLINE]
  0x0259: PHI (r34v4 int) = (r34v1 int), (r34v8 int) binds: [B:87:0x0256, B:91:0x025d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:90:0x025b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:91:0x025d A[LOOP:13: B:89:0x0259->B:91:0x025d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:96:0x0279  */
    /* JADX WARN: Code duplicated, block: B:99:0x0289  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v18 */
    /* JADX WARN: Type inference failed for: r15v19 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r23v32 */
    /* JADX WARN: Type inference failed for: r23v33 */
    /* JADX WARN: Type inference failed for: r23v34 */
    /* JADX WARN: Type inference failed for: r23v7 */
    /* JADX WARN: Type inference failed for: r23v8 */
    /* JADX WARN: Type inference failed for: r23v9 */
    /* JADX WARN: Type inference failed for: r29v2, types: [int[], java.lang.Object] */
    /* JADX WARN: Type inference failed for: r29v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r31v2 */
    /* JADX WARN: Type inference failed for: r38v0 */
    /* JADX WARN: Type inference failed for: r38v1 */
    /* JADX WARN: Type inference failed for: r42v0, types: [int[]] */
    /* JADX WARN: Type inference failed for: r42v1 */
    /* JADX WARN: Type inference failed for: r42v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v6, types: [int[]] */
    /* JADX WARN: Type inference failed for: r4v75 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v30 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v47 */
    /* JADX WARN: Type inference failed for: r5v48 */
    public static zzaml zzg(zzami zzamiVar, zzfx zzfxVar, zzagr zzagrVar, boolean z) throws zzat {
        zzald zzalhVar;
        boolean z2;
        int iZzH;
        int iZzH2;
        int i;
        int iZzH3;
        int i2;
        int i3;
        ArrayList arrayList;
        ?? r31;
        long[] jArr;
        int[] iArr;
        zzet zzetVar;
        long[] jArrCopyOf;
        int i4;
        zzald zzaldVar;
        int iZzH4;
        int i5;
        int i6;
        long j;
        long j2;
        long j3;
        int i7;
        int i8;
        int i9;
        int iZzH5;
        int iZzB;
        int iZzB2;
        ?? r4;
        long[] jArr2;
        ?? CopyOf;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        long[] jArr3;
        int i16;
        int[] iArr2;
        long j4;
        long j5;
        int i17;
        String str;
        long j6;
        ?? r23;
        int i18;
        ?? r24;
        int i19;
        int iZzc;
        ?? r38;
        int i20;
        boolean zZza;
        ?? r15;
        long[] jArr4;
        long j7;
        long j8;
        long jZzv;
        int[] iArrZzf;
        long[] jArr5;
        ?? r29;
        int length;
        long j9;
        int i21;
        long j10;
        int[] iArr3;
        int i22;
        boolean z3;
        long[] jArr6;
        int[] iArr4;
        int[] iArr5;
        long[] jArr7;
        int i23;
        int i24;
        int i25;
        boolean z4;
        int[] iArr6;
        boolean z5;
        boolean z6;
        long[] jArr8;
        int[] iArr7;
        ?? r5;
        long[] jArr9;
        int i26;
        boolean z7;
        int i27;
        int i28;
        long j11;
        ?? r6;
        long j12;
        int i29;
        int i30;
        long[] jArr10;
        long jZzv2;
        boolean z8;
        int[] iArr8;
        int[] iArr9;
        long j13;
        int i31;
        long jZzv3;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        boolean z9;
        boolean z10;
        int length2;
        long jZzv4;
        int i37;
        long[] jArr11;
        int[] iArr10;
        long j14;
        int i38;
        int i39;
        int i40;
        int[] iArr11;
        int[] iArr12;
        int i41;
        int i42;
        int i43;
        int i44;
        int i45;
        long j15;
        int iMax;
        int i46;
        int i47;
        zzami zzamiVarZzb = zzamiVar;
        zzfy zzfyVarZzc = zzfxVar.zzc(Atom.TYPE_stsz);
        if (zzfyVarZzc != null) {
            zzalhVar = new zzalg(zzfyVarZzc, zzamiVarZzb.zzg);
        } else {
            zzfy zzfyVarZzc2 = zzfxVar.zzc(Atom.TYPE_stz2);
            if (zzfyVarZzc2 == null) {
                throw zzat.zzb("Track has no sample table size information", null);
            }
            zzalhVar = new zzalh(zzfyVarZzc2);
        }
        int iZza = zzalhVar.zza();
        if (iZza == 0) {
            return new zzaml(zzamiVarZzb, new long[0], new int[0], 0, new long[0], new int[0], new int[0], false, 0L, 0);
        }
        if (zzamiVarZzb.zzb == 2) {
            long j16 = zzamiVarZzb.zzf;
            if (j16 > 0) {
                zzt zztVarZza = zzamiVarZzb.zzg.zza();
                zztVarZza.zzz(iZza / (j16 / 1000000.0f));
                zzamiVarZzb = zzamiVarZzb.zzb(zztVarZza.zzO());
            }
        }
        zzfy zzfyVarZzc3 = zzfxVar.zzc(Atom.TYPE_stco);
        if (zzfyVarZzc3 == null) {
            zzfyVarZzc3 = zzfxVar.zzc(Atom.TYPE_co64);
            zzfyVarZzc3.getClass();
            z2 = true;
        } else {
            z2 = false;
        }
        zzfy zzfyVarZzc4 = zzfxVar.zzc(Atom.TYPE_stsc);
        zzfyVarZzc4.getClass();
        zzet zzetVar2 = zzfyVarZzc4.zza;
        zzfy zzfyVarZzc5 = zzfxVar.zzc(Atom.TYPE_stts);
        zzfyVarZzc5.getClass();
        zzet zzetVar3 = zzfyVarZzc5.zza;
        zzfy zzfyVarZzc6 = zzfxVar.zzc(Atom.TYPE_stss);
        zzet zzetVar4 = zzfyVarZzc6 != null ? zzfyVarZzc6.zza : null;
        zzfy zzfyVarZzc7 = zzfxVar.zzc(Atom.TYPE_ctts);
        zzet zzetVar5 = zzfyVarZzc7 != null ? zzfyVarZzc7.zza : null;
        zzakz zzakzVar = new zzakz(zzetVar2, zzfyVarZzc3.zza, z2);
        zzetVar3.zzh(12);
        int iZzH6 = zzetVar3.zzH() - 1;
        int iZzH7 = zzetVar3.zzH();
        int iZzH8 = zzetVar3.zzH();
        if (zzetVar5 != null) {
            zzetVar5.zzh(12);
            iZzH = zzetVar5.zzH();
        } else {
            iZzH = 0;
        }
        if (zzetVar4 != null) {
            zzetVar4.zzh(12);
            iZzH2 = zzetVar4.zzH();
            if (iZzH2 > 0) {
                iZzH3 = zzetVar4.zzH() - 1;
                i = 0;
            } else {
                i = 0;
                iZzH3 = -1;
                zzetVar4 = null;
            }
        } else {
            iZzH2 = 0;
            i = 0;
            iZzH3 = -1;
        }
        int iZzb = zzalhVar.zzb();
        zzv zzvVar = zzamiVarZzb.zzg;
        if (iZzb != -1) {
            String str2 = zzvVar.zzp;
            i2 = 1;
            if ((MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2)) && iZzH6 == 0) {
                if (iZzH == 0 && iZzH2 == 0) {
                    iZzH6 = i;
                    i3 = 1;
                } else {
                    i3 = i;
                    iZzH6 = i3;
                }
            }
            arrayList = new ArrayList();
            if (zzetVar4 == null) {
                r31 = i2;
            } else {
                r31 = i;
            }
            if (i3 != 0) {
                i37 = zzakzVar.zza;
                jArr11 = new long[i37];
                iArr10 = new int[i37];
                while (zzakzVar.zza()) {
                    int i48 = zzakzVar.zzb;
                    jArr11[i48] = zzakzVar.zzd;
                    iArr10[i48] = zzakzVar.zzc;
                }
                j14 = iZzH8;
                i38 = 8192 / iZzb;
                i39 = i;
                i40 = i39;
                while (i39 < i37) {
                    int i49 = iArr10[i39];
                    String str3 = zzfl.zza;
                    i40 += ((i49 + i38) - 1) / i38;
                    i39++;
                }
                jArr2 = new long[i40];
                iArr11 = new int[i40];
                jArr3 = new long[i40];
                iArr12 = new int[i40];
                i41 = i;
                i42 = i41;
                i43 = i42;
                i44 = i43;
                i45 = i44;
                while (i41 < i37) {
                    int i50 = iArr10[i41];
                    j15 = jArr11[i41];
                    int i51 = i45;
                    int i52 = i37;
                    iMax = i44;
                    i46 = i51;
                    int i53 = i41;
                    i47 = i50;
                    while (i47 > 0) {
                        int iMin = Math.min(i38, i47);
                        jArr2[i46] = j15;
                        int i54 = i47;
                        int i55 = iZzb * iMin;
                        iArr11[i46] = i55;
                        int i56 = i43 + i55;
                        iMax = Math.max(iMax, i55);
                        long j17 = j14;
                        jArr3[i46] = j17 * ((long) i42);
                        iArr12[i46] = i2;
                        j15 += (long) iArr11[i46];
                        i42 += iMin;
                        i47 = i54 - iMin;
                        i46++;
                        i43 = i56;
                        j14 = j17;
                    }
                    long j18 = j14;
                    i41 = i53 + 1;
                    int i57 = i46;
                    i44 = iMax;
                    i37 = i52;
                    i45 = i57;
                    j14 = j18;
                }
                j5 = i43;
                j4 = j14 * ((long) i42);
                i16 = i40;
                iArr2 = iArr11;
                i17 = i44;
                r15 = iArr12;
            } else {
                jArr = new long[iZza];
                iArr = new int[iZza];
                zzetVar = zzetVar5;
                jArrCopyOf = new long[iZza];
                i4 = iZzH2;
                int i58 = iZzH3;
                zzaldVar = zzalhVar;
                iZzH4 = i58;
                i5 = iZzH;
                i6 = iZzH6;
                j = 0;
                j2 = 0;
                j3 = 0;
                i7 = i;
                i8 = i7;
                i9 = i8;
                iZzH5 = i9;
                iZzB = iZzH8;
                iZzB2 = iZzH5;
                r4 = new int[iZza];
                while (true) {
                    if (i7 < iZza) {
                        jArr2 = jArr;
                        CopyOf = r4;
                        break;
                    }
                    j6 = j;
                    r23 = i2;
                    while (true) {
                        if (i9 != 0) {
                            i18 = i9;
                            r24 = r23;
                            break;
                        }
                        zZza = zzakzVar.zza();
                        if (zZza) {
                            i18 = i;
                            r24 = zZza;
                            break;
                        }
                        j6 = zzakzVar.zzd;
                        i9 = zzakzVar.zzc;
                        iZza = iZza;
                        r23 = zZza;
                    }
                    i19 = iZza;
                    if (r24 == 0) {
                        zzeg.zzc("BoxParsers", "Unexpected end of chunk data");
                        long[] jArrCopyOf2 = Arrays.copyOf(jArr, i7);
                        int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
                        jArrCopyOf = Arrays.copyOf(jArrCopyOf, i7);
                        jArr2 = jArrCopyOf2;
                        iArr = iArrCopyOf;
                        CopyOf = Arrays.copyOf((int[]) r4, i7);
                        iZza = i7;
                        break;
                    }
                    if (zzetVar != null) {
                        while (iZzH5 == 0) {
                            if (i5 > 0) {
                                iZzH5 = i;
                                break;
                            }
                            i5--;
                            iZzH5 = zzetVar.zzH();
                            iZzB2 = zzetVar.zzB();
                        }
                        iZzH5--;
                    }
                    iZzc = zzaldVar.zzc();
                    r38 = r4;
                    long[] jArr12 = jArr;
                    long j19 = iZzc;
                    j3 += j19;
                    if (iZzc > i8) {
                        i8 = iZzc;
                    }
                    jArr12[i7] = j6;
                    iArr[i7] = iZzc;
                    int i59 = i18;
                    jArrCopyOf[i7] = j2 + ((long) iZzB2);
                    r38[i7] = r31;
                    if (i7 == iZzH4) {
                        r38[i7] = i2;
                        arrayList.add(Integer.valueOf(i7));
                    }
                    if (zzetVar4 != null && i7 == iZzH4) {
                        i20 = i4 - 1;
                        if (i20 > 0) {
                            i4 = i20;
                            iZzH4 = zzetVar4.zzH() - 1;
                        } else {
                            i4 = i20;
                        }
                    }
                    j2 += (long) iZzB;
                    iZzH7--;
                    if (iZzH7 != 0) {
                        if (i6 > 0) {
                            i6--;
                            iZzH7 = zzetVar3.zzH();
                            iZzB = zzetVar3.zzB();
                        } else {
                            iZzH7 = i;
                        }
                    }
                    long j20 = j6 + j19;
                    i9 = i59 - 1;
                    i7++;
                    jArr = jArr12;
                    r4 = r38;
                    iZza = i19;
                    j = j20;
                }
                long j21 = j2 + ((long) iZzB2);
                if (zzetVar != null) {
                    i10 = i2;
                    break;
                }
                while (true) {
                    if (i5 > 0) {
                        i10 = i2;
                        break;
                    }
                    if (zzetVar.zzH() != 0) {
                        i10 = i;
                        break;
                    }
                    zzetVar.zzB();
                    i5--;
                }
                if (i4 == 0) {
                    if (iZzH7 == 0) {
                        if (i9 == 0) {
                            i15 = i;
                            i11 = i15;
                        } else if (i6 == 0) {
                            jArrCopyOf = jArrCopyOf;
                            i10 = i10;
                            iZza = iZza;
                            i15 = i;
                            i11 = i15;
                            i12 = i11;
                            i13 = i6;
                            i14 = iZzH5;
                        } else if (iZzH5 == 0) {
                            jArrCopyOf = jArrCopyOf;
                            i10 = i10;
                            iZza = iZza;
                            i15 = i;
                            i11 = i15;
                            i12 = i11;
                            i13 = i12;
                            i14 = iZzH5;
                        } else if (i10 == 0) {
                            jArrCopyOf = jArrCopyOf;
                            iZza = iZza;
                            i10 = i;
                            i15 = i10;
                            i11 = i15;
                            i12 = i11;
                            i13 = i12;
                            i14 = i13;
                        } else {
                            jArrCopyOf = jArrCopyOf;
                            iZza = iZza;
                        }
                        jArr3 = jArrCopyOf;
                        i16 = iZza;
                        iArr2 = iArr;
                        j4 = j21;
                        j5 = j3;
                        i17 = i8;
                        r15 = CopyOf;
                    } else {
                        i11 = iZzH7;
                        i15 = i;
                    }
                    i12 = i9;
                    i13 = i6;
                    i14 = iZzH5;
                } else {
                    jArrCopyOf = jArrCopyOf;
                    i10 = i10;
                    iZza = iZza;
                    i11 = iZzH7;
                    i12 = i9;
                    i13 = i6;
                    i14 = iZzH5;
                    i15 = i4;
                }
                int i60 = zzamiVarZzb.zza;
                int length3 = String.valueOf(i60).length() + 66 + String.valueOf(i15).length() + 35 + String.valueOf(i11).length() + 26 + String.valueOf(i12).length() + 33 + String.valueOf(i13).length() + 36;
                int length4 = String.valueOf(i14).length();
                if (i2 != i10) {
                    str = ", ctts invalid";
                } else {
                    str = "";
                }
                StringBuilder sb = new StringBuilder(length3 + length4 + str.length());
                sb.append("Inconsistent stbl box for track ");
                sb.append(i60);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i15);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i11);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i12);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i13);
                sb.append(", remainingSamplesAtTimestampOffset ");
                sb.append(i14);
                sb.append(str);
                zzeg.zzc("BoxParsers", sb.toString());
                jArr3 = jArrCopyOf;
                i16 = iZza;
                iArr2 = iArr;
                j4 = j21;
                j5 = j3;
                i17 = i8;
                r15 = CopyOf;
            }
            jArr4 = jArr2;
            j7 = zzamiVarZzb.zzf;
            if (j7 > 0) {
                jZzv4 = zzfl.zzv(j5 * 8, 1000000L, j7, RoundingMode.HALF_DOWN);
                if (jZzv4 > 0 && jZzv4 < 2147483647L) {
                    zzt zztVarZza2 = zzvVar.zza();
                    zztVarZza2.zzi((int) jZzv4);
                    zzamiVarZzb = zzamiVarZzb.zzb(zztVarZza2.zzO());
                }
            }
            j8 = zzamiVarZzb.zzc;
            jZzv = zzfl.zzv(j4, 1000000L, j8, RoundingMode.DOWN);
            iArrZzf = zzhah.zzf(arrayList);
            jArr5 = zzamiVarZzb.zzi;
            if (jArr5 == null) {
                zzfl.zzw(jArr3, 1000000L, j8);
                return new zzaml(zzamiVarZzb, jArr4, iArr2, i17, jArr3, r15, iArrZzf, r31, jZzv, i16);
            }
            r29 = r15;
            length = jArr5.length;
            if (length == 1) {
                if (zzamiVarZzb.zzb == 1 || (length2 = jArr3.length) < 2) {
                    j9 = j8;
                } else {
                    long[] jArr13 = zzamiVarZzb.zzj;
                    jArr13.getClass();
                    long j22 = jArr13[i];
                    long j23 = jArr5[i];
                    long j24 = zzamiVarZzb.zzd;
                    long jZzv5 = zzfl.zzv(j23, j8, j24, RoundingMode.DOWN) + j22;
                    int i61 = length2 - 1;
                    int i62 = i;
                    int iMax2 = Math.max(i62, Math.min(4, i61));
                    int iMax3 = Math.max(i62, Math.min(length2 - 4, i61));
                    if (jArr3[i62] > j22 || j22 >= jArr3[iMax2] || jArr3[iMax3] >= jZzv5 || jZzv5 > 2 + j4) {
                        j9 = j8;
                    } else {
                        long jMax = Math.max(0L, j4 - jZzv5);
                        long j25 = j22 - jArr3[0];
                        long j26 = zzamiVarZzb.zzg.zzI;
                        long jZzv6 = zzfl.zzv(j25, j26, j8, RoundingMode.DOWN);
                        long jZzv7 = zzfl.zzv(jMax, j26, j8, RoundingMode.DOWN);
                        j9 = j8;
                        if (jZzv6 != 0) {
                            if (jZzv6 <= 2147483647L && jZzv7 <= 2147483647L) {
                                zzagrVar.zza = (int) jZzv6;
                                zzagrVar.zzb = (int) jZzv7;
                                zzfl.zzw(jArr3, 1000000L, j9);
                                return new zzaml(zzamiVarZzb, jArr4, iArr2, i17, jArr3, r29, iArrZzf, r31, zzfl.zzv(jArr5[0], 1000000L, j24, RoundingMode.DOWN), i16);
                            }
                        } else if (jZzv7 != 0) {
                            jZzv6 = 0;
                            if (jZzv6 <= 2147483647L) {
                                zzagrVar.zza = (int) jZzv6;
                                zzagrVar.zzb = (int) jZzv7;
                                zzfl.zzw(jArr3, 1000000L, j9);
                                return new zzaml(zzamiVarZzb, jArr4, iArr2, i17, jArr3, r29, iArrZzf, r31, zzfl.zzv(jArr5[0], 1000000L, j24, RoundingMode.DOWN), i16);
                            }
                        }
                    }
                }
                i21 = 1;
                length = 1;
            } else {
                j9 = j8;
                i21 = 1;
            }
            if (length != i21 && jArr5[0] == 0) {
                long[] jArr14 = zzamiVarZzb.zzj;
                jArr14.getClass();
                long j27 = jArr14[0];
                int i63 = 0;
                while (i63 < jArr3.length) {
                    long j28 = j9;
                    jArr3[i63] = zzfl.zzv(jArr3[i63] - j27, 1000000L, j28, RoundingMode.DOWN);
                    i63++;
                    j9 = j28;
                }
                return new zzaml(zzamiVarZzb, jArr4, iArr2, i17, jArr3, r29, iArrZzf, r31, zzfl.zzv(j4 - j27, 1000000L, j9, RoundingMode.DOWN), i16);
            }
            j10 = j9;
            iArr3 = iArr2;
            i22 = i16;
            if (zzamiVarZzb.zzb == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            jArr6 = zzamiVarZzb.zzj;
            iArr4 = new int[length];
            iArr5 = new int[length];
            jArr6.getClass();
            jArr7 = jArr6;
            i23 = 0;
            i24 = 0;
            i25 = 0;
            z4 = false;
            while (i24 < jArr5.length) {
                iArr9 = iArr4;
                j13 = jArr7[i24];
                if (j13 != -1) {
                    i31 = i24;
                    long j29 = j10;
                    j10 = j29;
                    jZzv3 = zzfl.zzv(jArr5[i24], j29, zzamiVarZzb.zzd, RoundingMode.DOWN) + j13;
                    boolean z11 = z4;
                    iArr9[i31] = zzfl.zzo(jArr3, j13, true, true);
                    int iZzq = zzfl.zzq(jArr3, jZzv3, z3, false);
                    i33 = iZzq - 1;
                    i34 = 0;
                    for (i32 = iZzq; i32 < jArr3.length; i32++) {
                        if (jArr3[i32] < jZzv3) {
                            i34++;
                            if (i34 > zzamiVarZzb.zzg.zzr) {
                                break;
                            }
                        } else {
                            i33 = i32;
                        }
                    }
                    iArr5[i31] = i33 + 1;
                    i35 = iArr9[i31];
                    while (true) {
                        i36 = iArr9[i31];
                        if (i36 > 0 || (r29[i36] & 1) != 0) {
                            break;
                            break;
                        }
                        iArr9[i31] = i36 - 1;
                    }
                    if (i36 == 0) {
                        z9 = false;
                        if ((r29[0] & 1) == 0) {
                            iArr9[i31] = i35;
                            while (true) {
                                i36 = iArr9[i31];
                                if (i36 >= iArr5[i31] || (r29[i36] & 1) != 0) {
                                    break;
                                }
                                iArr9[i31] = i36 + 1;
                            }
                        }
                    } else {
                        z9 = false;
                    }
                    int i64 = iArr5[i31];
                    i25 += i64 - i36;
                    if (i23 != i36) {
                        z10 = true;
                    } else {
                        z10 = z9;
                    }
                    z4 = z11 | z10;
                    i23 = i64;
                } else {
                    i31 = i24;
                }
                i24 = i31 + 1;
                jArr7 = jArr7;
                iArr4 = iArr9;
                z3 = z3;
            }
            iArr6 = iArr4;
            boolean z12 = z4;
            if (i25 != i22) {
                z5 = true;
            } else {
                z5 = false;
            }
            z6 = z12 | z5;
            if (z6) {
                jArr8 = new long[i25];
            } else {
                jArr8 = jArr4;
            }
            if (z6) {
                iArr7 = new int[i25];
            } else {
                iArr7 = iArr3;
            }
            if (true == z6) {
                i17 = 0;
            }
            if (z6) {
                iArr8 = new int[i25];
            } else {
                r5 = r29;
            }
            if (z6) {
                r5 = iArr8;
                arrayList = new ArrayList();
            }
            r5 = iArr8;
            jArr9 = new long[i25];
            i26 = 0;
            z7 = false;
            i27 = 0;
            i28 = i17;
            j11 = 0;
            r6 = r5;
            while (i26 < jArr5.length) {
                j12 = jArr6[i26];
                i29 = iArr6[i26];
                long[] jArr15 = jArr5;
                i30 = iArr5[i26];
                jArr10 = jArr9;
                if (z6) {
                    int i65 = i30 - i29;
                    System.arraycopy(jArr4, i29, jArr8, i27, i65);
                    System.arraycopy(iArr3, i29, iArr7, i27, i65);
                    System.arraycopy(r29, i29, r6, i27, i65);
                }
                while (i29 < i30) {
                    int[] iArr13 = iArr7;
                    ?? r42 = r6;
                    long jZzv8 = zzfl.zzv(j11, 1000000L, zzamiVarZzb.zzd, RoundingMode.DOWN);
                    jZzv2 = zzfl.zzv(jArr3[i29] - j12, 1000000L, j10, RoundingMode.DOWN);
                    if (jZzv2 < 0) {
                        z8 = false;
                    } else {
                        z8 = true;
                    }
                    z7 = (!z8) | z7;
                    jArr10[i27] = jZzv8 + jZzv2;
                    if (z6 && iArr13[i27] > i28) {
                        i28 = iArr3[i29];
                    }
                    if (!z6 && r31 == 0 && (r42[i27] & 1) != 0) {
                        arrayList.add(Integer.valueOf(i27));
                    }
                    i27++;
                    i29++;
                    iArr7 = iArr13;
                    r6 = r42;
                }
                j11 += jArr15[i26];
                i26++;
                iArr7 = iArr7;
                jArr5 = jArr15;
                jArr9 = jArr10;
                r6 = r6;
            }
            ?? r43 = r6;
            long[] jArr16 = jArr9;
            int[] iArr14 = iArr7;
            long jZzv9 = zzfl.zzv(j11, 1000000L, zzamiVarZzb.zzd, RoundingMode.DOWN);
            if (z7) {
                zzt zztVarZza3 = zzamiVarZzb.zzg.zza();
                zztVarZza3.zzu(true);
                zzamiVarZzb = zzamiVarZzb.zzb(zztVarZza3.zzO());
            }
            return new zzaml(zzamiVarZzb, jArr8, iArr14, i28, jArr16, r43, zzhah.zzf(arrayList), r31, jZzv9, jArr8.length);
        }
        i2 = 1;
        i3 = i;
        arrayList = new ArrayList();
        if (zzetVar4 == null) {
            r31 = i2;
        } else {
            r31 = i;
        }
        if (i3 != 0) {
            i37 = zzakzVar.zza;
            jArr11 = new long[i37];
            iArr10 = new int[i37];
            while (zzakzVar.zza()) {
                int i410 = zzakzVar.zzb;
                jArr11[i410] = zzakzVar.zzd;
                iArr10[i410] = zzakzVar.zzc;
            }
            j14 = iZzH8;
            i38 = 8192 / iZzb;
            i39 = i;
            i40 = i39;
            while (i39 < i37) {
                int i411 = iArr10[i39];
                String str4 = zzfl.zza;
                i40 += ((i411 + i38) - 1) / i38;
                i39++;
            }
            jArr2 = new long[i40];
            iArr11 = new int[i40];
            jArr3 = new long[i40];
            iArr12 = new int[i40];
            i41 = i;
            i42 = i41;
            i43 = i42;
            i44 = i43;
            i45 = i44;
            while (i41 < i37) {
                int i510 = iArr10[i41];
                j15 = jArr11[i41];
                int i511 = i45;
                int i512 = i37;
                iMax = i44;
                i46 = i511;
                int i513 = i41;
                i47 = i510;
                while (i47 > 0) {
                    int iMin2 = Math.min(i38, i47);
                    jArr2[i46] = j15;
                    int i514 = i47;
                    int i515 = iZzb * iMin2;
                    iArr11[i46] = i515;
                    int i516 = i43 + i515;
                    iMax = Math.max(iMax, i515);
                    long j110 = j14;
                    jArr3[i46] = j110 * ((long) i42);
                    iArr12[i46] = i2;
                    j15 += (long) iArr11[i46];
                    i42 += iMin2;
                    i47 = i514 - iMin2;
                    i46++;
                    i43 = i516;
                    j14 = j110;
                }
                long j111 = j14;
                i41 = i513 + 1;
                int i517 = i46;
                i44 = iMax;
                i37 = i512;
                i45 = i517;
                j14 = j111;
            }
            j5 = i43;
            j4 = j14 * ((long) i42);
            i16 = i40;
            iArr2 = iArr11;
            i17 = i44;
            r15 = iArr12;
        } else {
            jArr = new long[iZza];
            iArr = new int[iZza];
            zzetVar = zzetVar5;
            jArrCopyOf = new long[iZza];
            i4 = iZzH2;
            int i518 = iZzH3;
            zzaldVar = zzalhVar;
            iZzH4 = i518;
            i5 = iZzH;
            i6 = iZzH6;
            j = 0;
            j2 = 0;
            j3 = 0;
            i7 = i;
            i8 = i7;
            i9 = i8;
            iZzH5 = i9;
            iZzB = iZzH8;
            iZzB2 = iZzH5;
            r4 = new int[iZza];
            while (true) {
                if (i7 < iZza) {
                    jArr2 = jArr;
                    CopyOf = r4;
                    break;
                }
                j6 = j;
                r23 = i2;
                while (true) {
                    if (i9 != 0) {
                        i18 = i9;
                        r24 = r23;
                        break;
                    }
                    zZza = zzakzVar.zza();
                    if (zZza) {
                        i18 = i;
                        r24 = zZza;
                        break;
                    }
                    j6 = zzakzVar.zzd;
                    i9 = zzakzVar.zzc;
                    iZza = iZza;
                    r23 = zZza;
                }
                i19 = iZza;
                if (r24 == 0) {
                    zzeg.zzc("BoxParsers", "Unexpected end of chunk data");
                    long[] jArrCopyOf3 = Arrays.copyOf(jArr, i7);
                    int[] iArrCopyOf2 = Arrays.copyOf(iArr, i7);
                    jArrCopyOf = Arrays.copyOf(jArrCopyOf, i7);
                    jArr2 = jArrCopyOf3;
                    iArr = iArrCopyOf2;
                    CopyOf = Arrays.copyOf((int[]) r4, i7);
                    iZza = i7;
                    break;
                }
                if (zzetVar != null) {
                    while (iZzH5 == 0) {
                        if (i5 > 0) {
                            iZzH5 = i;
                            break;
                        }
                        i5--;
                        iZzH5 = zzetVar.zzH();
                        iZzB2 = zzetVar.zzB();
                    }
                    iZzH5--;
                }
                iZzc = zzaldVar.zzc();
                r38 = r4;
                long[] jArr17 = jArr;
                long j112 = iZzc;
                j3 += j112;
                if (iZzc > i8) {
                    i8 = iZzc;
                }
                jArr17[i7] = j6;
                iArr[i7] = iZzc;
                int i519 = i18;
                jArrCopyOf[i7] = j2 + ((long) iZzB2);
                r38[i7] = r31;
                if (i7 == iZzH4) {
                    r38[i7] = i2;
                    arrayList.add(Integer.valueOf(i7));
                }
                if (zzetVar4 != null) {
                    i20 = i4 - 1;
                    if (i20 > 0) {
                        i4 = i20;
                        iZzH4 = zzetVar4.zzH() - 1;
                    } else {
                        i4 = i20;
                    }
                }
                j2 += (long) iZzB;
                iZzH7--;
                if (iZzH7 != 0) {
                    if (i6 > 0) {
                        i6--;
                        iZzH7 = zzetVar3.zzH();
                        iZzB = zzetVar3.zzB();
                    } else {
                        iZzH7 = i;
                    }
                }
                long j210 = j6 + j112;
                i9 = i519 - 1;
                i7++;
                jArr = jArr17;
                r4 = r38;
                iZza = i19;
                j = j210;
            }
            long j211 = j2 + ((long) iZzB2);
            if (zzetVar != null) {
                i10 = i2;
                break;
            }
            while (true) {
                if (i5 > 0) {
                    i10 = i2;
                    break;
                }
                if (zzetVar.zzH() != 0) {
                    i10 = i;
                    break;
                }
                zzetVar.zzB();
                i5--;
            }
            if (i4 == 0) {
                if (iZzH7 == 0) {
                    if (i9 == 0) {
                        i15 = i;
                        i11 = i15;
                    } else if (i6 == 0) {
                        jArrCopyOf = jArrCopyOf;
                        i10 = i10;
                        iZza = iZza;
                        i15 = i;
                        i11 = i15;
                        i12 = i11;
                        i13 = i6;
                        i14 = iZzH5;
                    } else if (iZzH5 == 0) {
                        jArrCopyOf = jArrCopyOf;
                        i10 = i10;
                        iZza = iZza;
                        i15 = i;
                        i11 = i15;
                        i12 = i11;
                        i13 = i12;
                        i14 = iZzH5;
                    } else if (i10 == 0) {
                        jArrCopyOf = jArrCopyOf;
                        iZza = iZza;
                        i10 = i;
                        i15 = i10;
                        i11 = i15;
                        i12 = i11;
                        i13 = i12;
                        i14 = i13;
                    } else {
                        jArrCopyOf = jArrCopyOf;
                        iZza = iZza;
                    }
                    jArr3 = jArrCopyOf;
                    i16 = iZza;
                    iArr2 = iArr;
                    j4 = j211;
                    j5 = j3;
                    i17 = i8;
                    r15 = CopyOf;
                } else {
                    i11 = iZzH7;
                    i15 = i;
                }
                i12 = i9;
                i13 = i6;
                i14 = iZzH5;
            } else {
                jArrCopyOf = jArrCopyOf;
                i10 = i10;
                iZza = iZza;
                i11 = iZzH7;
                i12 = i9;
                i13 = i6;
                i14 = iZzH5;
                i15 = i4;
            }
            int i66 = zzamiVarZzb.zza;
            int length5 = String.valueOf(i66).length() + 66 + String.valueOf(i15).length() + 35 + String.valueOf(i11).length() + 26 + String.valueOf(i12).length() + 33 + String.valueOf(i13).length() + 36;
            int length6 = String.valueOf(i14).length();
            if (i2 != i10) {
                str = ", ctts invalid";
            } else {
                str = "";
            }
            StringBuilder sb2 = new StringBuilder(length5 + length6 + str.length());
            sb2.append("Inconsistent stbl box for track ");
            sb2.append(i66);
            sb2.append(": remainingSynchronizationSamples ");
            sb2.append(i15);
            sb2.append(", remainingSamplesAtTimestampDelta ");
            sb2.append(i11);
            sb2.append(", remainingSamplesInChunk ");
            sb2.append(i12);
            sb2.append(", remainingTimestampDeltaChanges ");
            sb2.append(i13);
            sb2.append(", remainingSamplesAtTimestampOffset ");
            sb2.append(i14);
            sb2.append(str);
            zzeg.zzc("BoxParsers", sb2.toString());
            jArr3 = jArrCopyOf;
            i16 = iZza;
            iArr2 = iArr;
            j4 = j211;
            j5 = j3;
            i17 = i8;
            r15 = CopyOf;
        }
        jArr4 = jArr2;
        j7 = zzamiVarZzb.zzf;
        if (j7 > 0) {
            jZzv4 = zzfl.zzv(j5 * 8, 1000000L, j7, RoundingMode.HALF_DOWN);
            if (jZzv4 > 0) {
                zzt zztVarZza4 = zzvVar.zza();
                zztVarZza4.zzi((int) jZzv4);
                zzamiVarZzb = zzamiVarZzb.zzb(zztVarZza4.zzO());
            }
        }
        j8 = zzamiVarZzb.zzc;
        jZzv = zzfl.zzv(j4, 1000000L, j8, RoundingMode.DOWN);
        iArrZzf = zzhah.zzf(arrayList);
        jArr5 = zzamiVarZzb.zzi;
        if (jArr5 == null) {
            zzfl.zzw(jArr3, 1000000L, j8);
            return new zzaml(zzamiVarZzb, jArr4, iArr2, i17, jArr3, r15, iArrZzf, r31, jZzv, i16);
        }
        r29 = r15;
        length = jArr5.length;
        if (length == 1) {
            if (zzamiVarZzb.zzb == 1) {
                j9 = j8;
            } else {
                j9 = j8;
            }
            i21 = 1;
            length = 1;
        } else {
            j9 = j8;
            i21 = 1;
        }
        if (length != i21) {
        }
        j10 = j9;
        iArr3 = iArr2;
        i22 = i16;
        if (zzamiVarZzb.zzb == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        jArr6 = zzamiVarZzb.zzj;
        iArr4 = new int[length];
        iArr5 = new int[length];
        jArr6.getClass();
        jArr7 = jArr6;
        i23 = 0;
        i24 = 0;
        i25 = 0;
        z4 = false;
        while (i24 < jArr5.length) {
            iArr9 = iArr4;
            j13 = jArr7[i24];
            if (j13 != -1) {
                i31 = i24;
                long j212 = j10;
                j10 = j212;
                jZzv3 = zzfl.zzv(jArr5[i24], j212, zzamiVarZzb.zzd, RoundingMode.DOWN) + j13;
                boolean z13 = z4;
                iArr9[i31] = zzfl.zzo(jArr3, j13, true, true);
                int iZzq2 = zzfl.zzq(jArr3, jZzv3, z3, false);
                i33 = iZzq2 - 1;
                i34 = 0;
                while (i32 < jArr3.length) {
                    if (jArr3[i32] < jZzv3) {
                        i34++;
                        if (i34 > zzamiVarZzb.zzg.zzr) {
                            break;
                            break;
                        }
                    } else {
                        i33 = i32;
                    }
                }
                iArr5[i31] = i33 + 1;
                i35 = iArr9[i31];
                while (true) {
                    i36 = iArr9[i31];
                    if (i36 > 0) {
                        break;
                    }
                    iArr9[i31] = i36 - 1;
                }
                if (i36 == 0) {
                    z9 = false;
                    if ((r29[0] & 1) == 0) {
                        iArr9[i31] = i35;
                        while (true) {
                            i36 = iArr9[i31];
                            if (i36 >= iArr5[i31]) {
                                break;
                            }
                            break;
                            break;
                            iArr9[i31] = i36 + 1;
                        }
                    }
                } else {
                    z9 = false;
                }
                int i67 = iArr5[i31];
                i25 += i67 - i36;
                if (i23 != i36) {
                    z10 = true;
                } else {
                    z10 = z9;
                }
                z4 = z13 | z10;
                i23 = i67;
            } else {
                i31 = i24;
            }
            i24 = i31 + 1;
            jArr7 = jArr7;
            iArr4 = iArr9;
            z3 = z3;
        }
        iArr6 = iArr4;
        boolean z14 = z4;
        if (i25 != i22) {
            z5 = true;
        } else {
            z5 = false;
        }
        z6 = z14 | z5;
        if (z6) {
            jArr8 = new long[i25];
        } else {
            jArr8 = jArr4;
        }
        if (z6) {
            iArr7 = new int[i25];
        } else {
            iArr7 = iArr3;
        }
        if (true == z6) {
            i17 = 0;
        }
        if (z6) {
            iArr8 = new int[i25];
        } else {
            r5 = r29;
        }
        if (z6) {
            r5 = iArr8;
            arrayList = new ArrayList();
        }
        r5 = iArr8;
        jArr9 = new long[i25];
        i26 = 0;
        z7 = false;
        i27 = 0;
        i28 = i17;
        j11 = 0;
        r6 = r5;
        while (i26 < jArr5.length) {
            j12 = jArr6[i26];
            i29 = iArr6[i26];
            long[] jArr18 = jArr5;
            i30 = iArr5[i26];
            jArr10 = jArr9;
            if (z6) {
                int i68 = i30 - i29;
                System.arraycopy(jArr4, i29, jArr8, i27, i68);
                System.arraycopy(iArr3, i29, iArr7, i27, i68);
                System.arraycopy(r29, i29, r6, i27, i68);
            }
            while (i29 < i30) {
                int[] iArr15 = iArr7;
                ?? r44 = r6;
                long jZzv10 = zzfl.zzv(j11, 1000000L, zzamiVarZzb.zzd, RoundingMode.DOWN);
                jZzv2 = zzfl.zzv(jArr3[i29] - j12, 1000000L, j10, RoundingMode.DOWN);
                if (jZzv2 < 0) {
                    z8 = false;
                } else {
                    z8 = true;
                }
                z7 = (!z8) | z7;
                jArr10[i27] = jZzv10 + jZzv2;
                if (z6) {
                    i28 = iArr3[i29];
                }
                if (!z6) {
                }
                i27++;
                i29++;
                iArr7 = iArr15;
                r6 = r44;
            }
            j11 += jArr18[i26];
            i26++;
            iArr7 = iArr7;
            jArr5 = jArr18;
            jArr9 = jArr10;
            r6 = r6;
        }
        ?? r45 = r6;
        long[] jArr19 = jArr9;
        int[] iArr16 = iArr7;
        long jZzv11 = zzfl.zzv(j11, 1000000L, zzamiVarZzb.zzd, RoundingMode.DOWN);
        if (z7) {
            zzt zztVarZza5 = zzamiVarZzb.zzg.zza();
            zztVarZza5.zzu(true);
            zzamiVarZzb = zzamiVarZzb.zzb(zztVarZza5.zzO());
        }
        return new zzaml(zzamiVarZzb, jArr8, iArr16, i28, jArr19, r45, zzhah.zzf(arrayList), r31, jZzv11, jArr8.length);
    }

    static zzap zzh(zzet zzetVar) {
        try {
            zzetVar.zzk(5);
            int iZzB = zzetVar.zzB();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < iZzB; i++) {
                long jZzD = zzetVar.zzD() / 10000;
                if (jZzD < 0) {
                    jZzD = -9223372036854775807L;
                }
                arrayList.add(zzaiv.zzb(jZzD, C.TIME_UNSET, zzetVar.zzK(zzetVar.zzs(), StandardCharsets.UTF_8)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new zzap(arrayList);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    private static zzap zzi(zzet zzetVar) {
        short sZzv = zzetVar.zzv();
        zzetVar.zzk(2);
        String strZzK = zzetVar.zzK(sZzv, StandardCharsets.UTF_8);
        int iMax = Math.max(strZzK.lastIndexOf(43), strZzK.lastIndexOf(45));
        try {
            return new zzap(C.TIME_UNSET, new zzga(Float.parseFloat(strZzK.substring(0, iMax)), Float.parseFloat(strZzK.substring(iMax, strZzK.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    private static int zzj(zzet zzetVar) {
        zzetVar.zzh(16);
        return zzetVar.zzB();
    }

    private static String zzk(byte[] bArr, int i, int i2) {
        zzgtj.zzi(bArr.length == 64);
        ArrayList arrayList = new ArrayList(16);
        for (int i3 = 0; i3 < bArr.length - 3; i3 += 4) {
            int iZze = zzhah.zze(bArr[i3], bArr[i3 + 1], bArr[i3 + 2], bArr[i3 + 3]);
            String str = zzfl.zza;
            int i4 = ((iZze >> 8) & 255) - 128;
            int i5 = (iZze >> 16) & 255;
            int i6 = (iZze & 255) - 128;
            arrayList.add(String.format("%06x", Integer.valueOf(Math.max(0, Math.min(i5 + ((i6 * 17790) / 10000), 255)) | (Math.max(0, Math.min(((i4 * 14075) / 10000) + i5, 255)) << 16) | (Math.max(0, Math.min((i5 - ((i6 * 3455) / 10000)) - ((i4 * 7169) / 10000), 255)) << 8))));
        }
        String strZzd = zzgtd.zzd(arrayList, ", ");
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 7 + String.valueOf(i2).length() + 10 + strZzd.length() + 1);
        sb.append("size: ");
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        sb.append("\npalette: ");
        sb.append(strZzd);
        sb.append("\n");
        return sb.toString();
    }

    private static zzi zzl(zzet zzetVar) {
        zzh zzhVar = new zzh();
        byte[] bArrZzi = zzetVar.zzi();
        zzes zzesVar = new zzes(bArrZzi, bArrZzi.length);
        zzesVar.zzf(zzetVar.zzg() * 8);
        zzesVar.zzo(1);
        int iZzj = zzesVar.zzj(8);
        for (int i = 0; i < iZzj; i++) {
            zzesVar.zzo(1);
            int iZzj2 = zzesVar.zzj(8);
            for (int i2 = 0; i2 < iZzj2; i2++) {
                zzesVar.zzh(6);
                boolean zZzi = zzesVar.zzi();
                zzesVar.zzg();
                zzesVar.zzo(11);
                zzesVar.zzh(4);
                int iZzj3 = zzesVar.zzj(4) + 8;
                zzhVar.zze(iZzj3);
                zzhVar.zzf(iZzj3);
                zzesVar.zzo(1);
                if (zZzi) {
                    int iZzj4 = zzesVar.zzj(8);
                    int iZzj5 = zzesVar.zzj(8);
                    zzesVar.zzo(1);
                    boolean zZzi2 = zzesVar.zzi();
                    zzhVar.zza(zzi.zzb(iZzj4));
                    zzhVar.zzb(true != zZzi2 ? 2 : 1);
                    zzhVar.zzc(zzi.zzc(iZzj5));
                }
            }
        }
        return zzhVar.zzg();
    }

    private static ByteBuffer zzm() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static Pair zzn(zzfx zzfxVar) {
        zzfy zzfyVarZzc = zzfxVar.zzc(Atom.TYPE_elst);
        if (zzfyVarZzc == null) {
            return null;
        }
        zzet zzetVar = zzfyVarZzc.zza;
        zzetVar.zzh(8);
        int iZza = zza(zzetVar.zzB());
        int iZzH = zzetVar.zzH();
        long[] jArr = new long[iZzH];
        long[] jArr2 = new long[iZzH];
        for (int i = 0; i < iZzH; i++) {
            jArr[i] = iZza == 1 ? zzetVar.zzJ() : zzetVar.zzz();
            jArr2[i] = iZza == 1 ? zzetVar.zzD() : zzetVar.zzB();
            if (zzetVar.zzv() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            zzetVar.zzk(2);
        }
        return Pair.create(jArr, jArr2);
    }

    /* JADX WARN: Code duplicated, block: B:75:0x013e  */
    private static void zzo(zzet zzetVar, int i, int i2, int i3, int i4, String str, boolean z, zzq zzqVar, zzalf zzalfVar, int i5) throws zzat {
        int iZzt;
        int iZzB;
        int iZzH;
        int iRound;
        int iZzC;
        String strZza;
        int i6;
        int i7;
        int i8 = i;
        int i9 = i3;
        zzq zzqVarZzb = zzqVar;
        zzetVar.zzh(i2 + 16);
        if (z) {
            iZzt = zzetVar.zzt();
            zzetVar.zzk(6);
        } else {
            zzetVar.zzk(8);
            iZzt = 0;
        }
        int i10 = 2;
        if (iZzt == 0 || iZzt == 1) {
            int iZzt2 = zzetVar.zzt();
            zzetVar.zzk(6);
            int iZzF = zzetVar.zzF();
            zzetVar.zzh(zzetVar.zzg() - 4);
            iZzB = zzetVar.zzB();
            if (iZzt == 1) {
                zzetVar.zzk(16);
            }
            iZzH = iZzt2;
            iRound = iZzF;
            iZzC = -1;
        } else {
            if (iZzt != 2) {
                return;
            }
            zzetVar.zzk(16);
            iRound = (int) Math.round(Double.longBitsToDouble(zzetVar.zzD()));
            iZzH = zzetVar.zzH();
            zzetVar.zzk(4);
            int iZzH2 = zzetVar.zzH();
            int iZzH3 = zzetVar.zzH();
            int i11 = iZzH3 & 1;
            int i12 = iZzH3 & 2;
            if (i11 == 0) {
                iZzC = zzfl.zzB(iZzH2, i12 != 0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            } else {
                iZzC = i12 == 0 ? zzfl.zzC(iZzH2) : -1;
            }
            if (iZzC == 0) {
                iZzC = -1;
            }
            zzetVar.zzk(8);
            iZzB = 0;
        }
        if (i8 == 1767992678) {
            iRound = -1;
            iZzH = -1;
        } else {
            if (i8 == 1935764850) {
                iRound = 8000;
            } else if (i8 == 1935767394) {
                iRound = AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
                i8 = 1935767394;
            }
            iZzH = 1;
        }
        int iZzg = zzetVar.zzg();
        int iIntValue = Atom.TYPE_enca;
        if (i8 == 1701733217) {
            Pair pairZzr = zzr(zzetVar, i2, i9);
            if (pairZzr != null) {
                iIntValue = ((Integer) pairZzr.first).intValue();
                zzqVarZzb = zzqVarZzb == null ? null : zzqVarZzb.zzb(((zzamj) pairZzr.second).zzb);
                zzalfVar.zza[i5] = (zzamj) pairZzr.second;
            }
            i8 = iIntValue;
            zzetVar.zzh(iZzg);
        }
        String str2 = MimeTypes.AUDIO_MPEGH_MHM1;
        if (i8 == 1633889587) {
            strZza = MimeTypes.AUDIO_AC3;
        } else if (i8 == 1700998451) {
            strZza = MimeTypes.AUDIO_E_AC3;
        } else if (i8 == 1633889588) {
            strZza = MimeTypes.AUDIO_AC4;
        } else if (i8 == 1685353315) {
            strZza = MimeTypes.AUDIO_DTS;
        } else if (i8 == 1685353320 || i8 == 1685353324) {
            strZza = MimeTypes.AUDIO_DTS_HD;
        } else if (i8 == 1685353317) {
            strZza = MimeTypes.AUDIO_DTS_EXPRESS;
        } else if (i8 == 1685353336) {
            strZza = MimeTypes.AUDIO_DTS_X;
        } else if (i8 == 1935764850) {
            strZza = MimeTypes.AUDIO_AMR_NB;
        } else if (i8 == 1935767394) {
            strZza = MimeTypes.AUDIO_AMR_WB;
        } else if (i8 != 1936684916) {
            if (i8 == 1953984371) {
                iZzC = 268435456;
            } else if (i8 == 1819304813) {
                if (iZzC == -1) {
                    iZzC = i10;
                }
            } else if (i8 == 778924082 || i8 == 778924083) {
                strZza = MimeTypes.AUDIO_MPEG;
            } else if (i8 == 1835557169) {
                strZza = MimeTypes.AUDIO_MPEGH_MHA1;
            } else if (i8 == 1835560241) {
                strZza = MimeTypes.AUDIO_MPEGH_MHM1;
            } else if (i8 == 1634492771) {
                strZza = MimeTypes.AUDIO_ALAC;
            } else if (i8 == 1634492791) {
                strZza = MimeTypes.AUDIO_ALAW;
            } else if (i8 == 1970037111) {
                strZza = MimeTypes.AUDIO_MLAW;
            } else if (i8 == 1332770163) {
                strZza = MimeTypes.AUDIO_OPUS;
            } else if (i8 == 1716281667) {
                strZza = MimeTypes.AUDIO_FLAC;
            } else if (i8 == 1835823201) {
                strZza = MimeTypes.AUDIO_TRUEHD;
            } else if (i8 == 1767992678) {
                strZza = "audio/iamf";
                i8 = 1767992678;
            } else {
                strZza = null;
            }
            strZza = MimeTypes.AUDIO_RAW;
        } else {
            iZzC = i10;
            strZza = MimeTypes.AUDIO_RAW;
        }
        int iZzC2 = iZzC;
        List listZzj = null;
        String string = null;
        zzala zzalaVarZzp = null;
        zzaky zzakyVarZzq = null;
        while (iZzg - i2 < i9) {
            zzetVar.zzh(iZzg);
            int iZzB2 = zzetVar.zzB();
            String str3 = string;
            String str4 = "childAtomSize must be positive";
            zzagc.zza(iZzB2 > 0, "childAtomSize must be positive");
            int iZzB3 = zzetVar.zzB();
            iRound = iRound;
            if (iZzB3 == 1835557187) {
                zzetVar.zzh(iZzg + 8);
                zzetVar.zzk(1);
                int iZzs = zzetVar.zzs();
                zzetVar.zzk(1);
                String str5 = Objects.equals(strZza, str2) ? String.format("mhm1.%02X", Integer.valueOf(iZzs)) : String.format("mha1.%02X", Integer.valueOf(iZzs));
                int iZzt3 = zzetVar.zzt();
                byte[] bArr = new byte[iZzt3];
                str3 = str5;
                zzetVar.zzm(bArr, 0, iZzt3);
                if (listZzj == null) {
                    listZzj = zzgwm.zzj(bArr);
                    iZzB2 = iZzB2;
                    iZzB = iZzB;
                    str2 = str2;
                    iRound = iRound;
                    string = str3;
                } else {
                    listZzj = zzgwm.zzk(bArr, (byte[]) listZzj.get(0));
                    iZzB2 = iZzB2;
                    iZzB = iZzB;
                    str2 = str2;
                    string = str3;
                    iRound = iRound;
                }
            } else if (iZzB3 == 1835557200) {
                zzetVar.zzh(iZzg + 8);
                int iZzs2 = zzetVar.zzs();
                if (iZzs2 > 0) {
                    byte[] bArr2 = new byte[iZzs2];
                    zzetVar.zzm(bArr2, 0, iZzs2);
                    if (listZzj == null) {
                        listZzj = zzgwm.zzj(bArr2);
                        iZzC2 = iZzC2;
                        iZzB2 = iZzB2;
                        iZzB = iZzB;
                        str2 = str2;
                        string = str3;
                        iRound = iRound;
                    } else {
                        listZzj = zzgwm.zzk((byte[]) listZzj.get(0), bArr2);
                        iZzB2 = iZzB2;
                        iZzB = iZzB;
                        str2 = str2;
                        string = str3;
                        iRound = iRound;
                    }
                } else {
                    iZzB2 = iZzB2;
                    iZzB = iZzB;
                    str2 = str2;
                    iRound = iRound;
                    string = str3;
                }
            } else {
                if (iZzB3 == 1702061171) {
                    i6 = iZzg;
                    i7 = -1;
                } else if (z && iZzB3 == 2002876005) {
                    int iZzg2 = zzetVar.zzg();
                    zzagc.zza(iZzg2 >= iZzg, null);
                    int i13 = iZzg2;
                    while (true) {
                        if (i13 - iZzg >= iZzB2) {
                            i6 = -1;
                            i7 = -1;
                            break;
                        }
                        zzetVar.zzh(i13);
                        int iZzB4 = zzetVar.zzB();
                        zzagc.zza(iZzB4 > 0, str4);
                        String str6 = str4;
                        if (zzetVar.zzB() == 1702061171) {
                            i6 = i13;
                            i7 = -1;
                            break;
                        } else {
                            i13 += iZzB4;
                            str4 = str6;
                        }
                    }
                } else if (iZzB3 == 1651798644) {
                    zzakyVarZzq = zzq(zzetVar, iZzg);
                    iZzB2 = iZzB2;
                    iZzB = iZzB;
                    str2 = str2;
                    string = str3;
                    iRound = iRound;
                } else {
                    if (iZzB3 == 1684103987) {
                        zzetVar.zzh(iZzg + 8);
                        zzalfVar.zzb = zzaey.zza(zzetVar, Integer.toString(i4), str, zzqVarZzb);
                    } else if (iZzB3 == 1684366131) {
                        zzetVar.zzh(iZzg + 8);
                        zzalfVar.zzb = zzaey.zzb(zzetVar, Integer.toString(i4), str, zzqVarZzb);
                    } else if (iZzB3 == 1684103988) {
                        zzetVar.zzh(iZzg + 8);
                        zzalfVar.zzb = zzafb.zza(zzetVar, Integer.toString(i4), str, zzqVarZzb);
                    } else {
                        if (iZzB3 != 1684892784) {
                            if (iZzB3 == 1684305011 || iZzB3 == 1969517683) {
                                iZzB2 = iZzB2;
                                iZzB = iZzB;
                                str2 = str2;
                                zzt zztVar = new zzt();
                                zztVar.zzb(i4);
                                zztVar.zzo(strZza);
                                zztVar.zzG(iZzH);
                                iRound = iRound;
                                zztVar.zzH(iRound);
                                zztVar.zzs(zzqVarZzb);
                                zztVar.zze(str);
                                zzalfVar.zzb = zztVar.zzO();
                            } else {
                                if (iZzB3 == 1682927731) {
                                    int i14 = iZzB2 - 8;
                                    byte[] bArr3 = zzb;
                                    int length = bArr3.length;
                                    iZzB2 = iZzB2;
                                    byte[] bArrCopyOf = Arrays.copyOf(bArr3, length + i14);
                                    zzetVar.zzh(iZzg + 8);
                                    zzetVar.zzm(bArrCopyOf, length, i14);
                                    listZzj = zzgv.zza(bArrCopyOf);
                                } else {
                                    iZzB2 = iZzB2;
                                    if (iZzB3 == 1684425825) {
                                        byte[] bArr4 = new byte[iZzB2 - 8];
                                        bArr4[0] = 102;
                                        bArr4[1] = 76;
                                        bArr4[i10] = 97;
                                        bArr4[3] = 67;
                                        zzetVar.zzh(iZzg + 12);
                                        zzetVar.zzm(bArr4, 4, iZzB2 - 12);
                                        listZzj = zzgwm.zzj(bArr4);
                                    } else if (iZzB3 == 1634492771) {
                                        int i15 = iZzB2 - 12;
                                        byte[] bArr5 = new byte[i15];
                                        zzetVar.zzh(iZzg + 12);
                                        zzetVar.zzm(bArr5, 0, i15);
                                        int i16 = zzdq.zza;
                                        zzet zzetVar2 = new zzet(bArr5);
                                        zzetVar2.zzh(5);
                                        int iZzs3 = zzetVar2.zzs();
                                        zzetVar2.zzh(9);
                                        int iZzs4 = zzetVar2.zzs();
                                        zzetVar2.zzh(20);
                                        int[] iArr = {zzetVar2.zzH(), iZzs4, iZzs3};
                                        int i17 = iArr[0];
                                        int i18 = iArr[1];
                                        int iZzB5 = zzfl.zzB(iZzs3, ByteOrder.LITTLE_ENDIAN);
                                        if (iZzB5 == 0) {
                                            iZzB5 = -1;
                                        }
                                        iZzH = i18;
                                        listZzj = zzgwm.zzj(bArr5);
                                        iZzC2 = iZzB5;
                                        iRound = i17;
                                        iZzB = iZzB;
                                    } else {
                                        if (iZzB3 == 1767990114) {
                                            zzetVar.zzh(iZzg + 9);
                                            int iZza = zzhah.zza(zzetVar.zzP());
                                            byte[] bArr6 = new byte[iZza];
                                            zzetVar.zzm(bArr6, 0, iZza);
                                            int i19 = zzdq.zza;
                                            zzet zzetVar3 = new zzet(bArr6);
                                            String str7 = null;
                                            String str8 = null;
                                            while (zzetVar3.zzd() > 0 && (str7 == null || str8 == null)) {
                                                int iZzs5 = zzetVar3.zzs();
                                                int i20 = iZzs5 >> 3;
                                                int i21 = iZzs5 & 2;
                                                int i22 = iZzs5 & 1;
                                                int iZza2 = zzhah.zza(zzetVar3.zzP());
                                                byte[] bArr7 = bArr6;
                                                if (i20 > 4 && i20 < 24 && i21 != 0) {
                                                    zzetVar3.zzQ();
                                                    zzetVar3.zzQ();
                                                }
                                                if (i22 != 0) {
                                                    zzetVar3.zzk(zzhah.zza(zzetVar3.zzP()));
                                                }
                                                int iZzg3 = zzetVar3.zzg() + iZza2;
                                                int i23 = iZzB;
                                                if (i20 == 31) {
                                                    zzetVar3.zzk(4);
                                                    Object[] objArr = {Integer.valueOf(zzetVar3.zzs()), Integer.valueOf(zzetVar3.zzs())};
                                                    String str9 = zzfl.zza;
                                                    str7 = String.format(Locale.US, "iamf.%03X.%03X", objArr);
                                                } else {
                                                    if (i20 == 0) {
                                                        zzetVar3.zzQ();
                                                        String strZzK = zzetVar3.zzK(4, StandardCharsets.UTF_8);
                                                        if (strZzK.equals("mp4a")) {
                                                            zzetVar3.zzQ();
                                                            zzetVar3.zzk(i10);
                                                            zzes zzesVar = new zzes();
                                                            zzesVar.zza(zzetVar3);
                                                            int iZzj = zzesVar.zzj(5);
                                                            if (iZzj == 31) {
                                                                iZzj = zzesVar.zzj(6) + 32;
                                                            }
                                                            StringBuilder sb = new StringBuilder(strZzK.length() + 4 + String.valueOf(iZzj).length());
                                                            sb.append(strZzK);
                                                            sb.append(".40.");
                                                            sb.append(iZzj);
                                                            strZzK = sb.toString();
                                                        }
                                                        str8 = strZzK;
                                                    }
                                                    zzetVar3.zzh(iZzg3);
                                                    iZzB = i23;
                                                    str2 = str2;
                                                    bArr6 = bArr7;
                                                    i10 = 2;
                                                }
                                                str2 = str2;
                                                zzetVar3.zzh(iZzg3);
                                                iZzB = i23;
                                                str2 = str2;
                                                bArr6 = bArr7;
                                                i10 = 2;
                                            }
                                            byte[] bArr8 = bArr6;
                                            iZzB = iZzB;
                                            str2 = str2;
                                            if (str7 == null || str8 == null) {
                                                string = null;
                                            } else {
                                                StringBuilder sb2 = new StringBuilder(str7.length() + 1 + str8.length());
                                                sb2.append(str7);
                                                sb2.append(".");
                                                sb2.append(str8);
                                                string = sb2.toString();
                                            }
                                            listZzj = zzgwm.zzj(bArr8);
                                            iZzC2 = iZzC2;
                                        } else {
                                            iZzB = iZzB;
                                            str2 = str2;
                                            if (iZzB3 == 1885564227) {
                                                zzetVar.zzh(iZzg + 12);
                                                ByteOrder byteOrder = (zzetVar.zzs() & 1) != 0 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;
                                                int iZzs6 = zzetVar.zzs();
                                                if (i8 == 1768973165) {
                                                    iZzC2 = zzfl.zzB(iZzs6, byteOrder);
                                                } else {
                                                    iZzC2 = (i8 == 1718641517 && byteOrder.equals(ByteOrder.LITTLE_ENDIAN)) ? zzfl.zzC(iZzs6) : iZzC2;
                                                }
                                                if (iZzC2 == 0) {
                                                    iZzC2 = -1;
                                                }
                                                if (iZzC2 != -1) {
                                                    strZza = MimeTypes.AUDIO_RAW;
                                                }
                                                string = str3;
                                            } else {
                                                iRound = iRound;
                                            }
                                        }
                                        iRound = iRound;
                                    }
                                }
                                iZzB = iZzB;
                                str2 = str2;
                                string = str3;
                                iRound = iRound;
                            }
                            string = str3;
                        } else {
                            if (iZzB <= 0) {
                                StringBuilder sb3 = new StringBuilder(String.valueOf(iZzB).length() + 49);
                                sb3.append("Invalid sample rate for Dolby TrueHD MLP stream: ");
                                sb3.append(iZzB);
                                throw zzat.zzb(sb3.toString(), null);
                            }
                            iZzC2 = iZzC2;
                            iZzB2 = iZzB2;
                            iRound = iZzB;
                            iZzB = iRound;
                            iZzH = i10;
                        }
                        string = str3;
                    }
                    iZzB2 = iZzB2;
                    iZzB = iZzB;
                    str2 = str2;
                    iRound = iRound;
                    string = str3;
                }
                if (i6 != i7) {
                    zzalaVarZzp = zzp(zzetVar, i6);
                    strZza = zzalaVarZzp.zza();
                    byte[] bArrZzb = zzalaVarZzp.zzb();
                    if (bArrZzb != null) {
                        if (MimeTypes.AUDIO_VORBIS.equals(strZza)) {
                            int i24 = zzahm.zza;
                            zzet zzetVar4 = new zzet(bArrZzb);
                            int i25 = 1;
                            zzetVar4.zzk(1);
                            int i26 = 0;
                            while (zzetVar4.zzd() > 0 && zzetVar4.zzn() == 255) {
                                zzetVar4.zzk(i25);
                                i26 += 255;
                                i25 = 1;
                            }
                            int iZzs7 = i26 + zzetVar4.zzs();
                            int i27 = 0;
                            while (zzetVar4.zzd() > 0 && zzetVar4.zzn() == 255) {
                                zzetVar4.zzk(1);
                                i27 += 255;
                            }
                            int iZzs8 = i27 + zzetVar4.zzs();
                            byte[] bArr9 = new byte[iZzs7];
                            int iZzg4 = zzetVar4.zzg();
                            System.arraycopy(bArrZzb, iZzg4, bArr9, 0, iZzs7);
                            int i28 = iZzg4 + iZzs7 + iZzs8;
                            int length2 = bArrZzb.length - i28;
                            byte[] bArr10 = new byte[length2];
                            System.arraycopy(bArrZzb, i28, bArr10, 0, length2);
                            listZzj = zzgwm.zzk(bArr9, bArr10);
                        } else {
                            if (MimeTypes.AUDIO_AAC.equals(strZza)) {
                                zzaev zzaevVarZza = zzaew.zza(bArrZzb);
                                iRound = zzaevVarZza.zza;
                                iZzH = zzaevVarZza.zzb;
                                string = zzaevVarZza.zzc;
                            } else {
                                string = str3;
                            }
                            listZzj = zzgwm.zzj(bArrZzb);
                        }
                        iZzC2 = iZzC2;
                    }
                    string = str3;
                    iZzC2 = iZzC2;
                } else {
                    string = str3;
                }
            }
            iZzg += iZzB2;
            iZzC2 = iZzC2;
            iZzB = iZzB;
            str2 = str2;
            i10 = 2;
            i9 = i3;
        }
        String str10 = string;
        if (zzalfVar.zzb != null || strZza == null) {
            return;
        }
        zzt zztVar2 = new zzt();
        zztVar2.zzb(i4);
        zztVar2.zzo(strZza);
        zztVar2.zzk(str10);
        zztVar2.zzG(iZzH);
        zztVar2.zzH(iRound);
        zztVar2.zzI(iZzC2);
        zztVar2.zzr(listZzj);
        zztVar2.zzs(zzqVarZzb);
        zztVar2.zze(str);
        if (zzalaVarZzp != null) {
            zztVar2.zzi(zzhah.zzb(zzalaVarZzp.zzc()));
            zztVar2.zzj(zzhah.zzb(zzalaVarZzp.zzd()));
        } else if (zzakyVarZzq != null) {
            zztVar2.zzi(zzhah.zzb(zzakyVarZzq.zza()));
            zztVar2.zzj(zzhah.zzb(zzakyVarZzq.zzb()));
        }
        zzalfVar.zzb = zztVar2.zzO();
    }

    private static zzala zzp(zzet zzetVar, int i) {
        zzetVar.zzh(i + 12);
        zzetVar.zzk(1);
        zzs(zzetVar);
        zzetVar.zzk(2);
        int iZzs = zzetVar.zzs();
        if ((iZzs & 128) != 0) {
            zzetVar.zzk(2);
        }
        if ((iZzs & 64) != 0) {
            zzetVar.zzk(zzetVar.zzs());
        }
        if ((iZzs & 32) != 0) {
            zzetVar.zzk(2);
        }
        zzetVar.zzk(1);
        zzs(zzetVar);
        String strZze = zzas.zze(zzetVar.zzs());
        if (MimeTypes.AUDIO_MPEG.equals(strZze) || MimeTypes.AUDIO_DTS.equals(strZze) || MimeTypes.AUDIO_DTS_HD.equals(strZze)) {
            return new zzala(strZze, null, -1L, -1L);
        }
        zzetVar.zzk(4);
        long jZzz = zzetVar.zzz();
        long jZzz2 = zzetVar.zzz();
        zzetVar.zzk(1);
        int iZzs2 = zzs(zzetVar);
        long j = jZzz2;
        byte[] bArr = new byte[iZzs2];
        zzetVar.zzm(bArr, 0, iZzs2);
        if (j <= 0) {
            j = -1;
        }
        return new zzala(strZze, bArr, j, jZzz > 0 ? jZzz : -1L);
    }

    private static zzaky zzq(zzet zzetVar, int i) {
        zzetVar.zzh(i + 8);
        zzetVar.zzk(4);
        return new zzaky(zzetVar.zzz(), zzetVar.zzz());
    }

    private static Pair zzr(zzet zzetVar, int i, int i2) throws zzat {
        zzamj zzamjVar;
        Pair pairCreate;
        int i3;
        int i4;
        int iZzg = zzetVar.zzg();
        while (iZzg - i < i2) {
            zzetVar.zzh(iZzg);
            int iZzB = zzetVar.zzB();
            zzagc.zza(iZzB > 0, "childAtomSize must be positive");
            if (zzetVar.zzB() == 1936289382) {
                int i5 = iZzg + 8;
                int i6 = 0;
                int i7 = -1;
                Integer numValueOf = null;
                String strZzK = null;
                while (i5 - iZzg < iZzB) {
                    zzetVar.zzh(i5);
                    int iZzB2 = zzetVar.zzB();
                    int iZzB3 = zzetVar.zzB();
                    if (iZzB3 == 1718775137) {
                        numValueOf = Integer.valueOf(zzetVar.zzB());
                    } else if (iZzB3 == 1935894637) {
                        zzetVar.zzk(4);
                        strZzK = zzetVar.zzK(4, StandardCharsets.UTF_8);
                    } else if (iZzB3 == 1935894633) {
                        i7 = i5;
                        i6 = iZzB2;
                    }
                    i5 += iZzB2;
                }
                byte[] bArr = null;
                if (C.CENC_TYPE_cenc.equals(strZzK) || C.CENC_TYPE_cbc1.equals(strZzK) || C.CENC_TYPE_cens.equals(strZzK) || C.CENC_TYPE_cbcs.equals(strZzK)) {
                    zzagc.zza(numValueOf != null, "frma atom is mandatory");
                    zzagc.zza(i7 != -1, "schi atom is mandatory");
                    int i8 = i7 + 8;
                    while (true) {
                        if (i8 - i7 >= i6) {
                            zzamjVar = null;
                            break;
                        }
                        zzetVar.zzh(i8);
                        int iZzB4 = zzetVar.zzB();
                        if (zzetVar.zzB() == 1952804451) {
                            int iZza = zza(zzetVar.zzB());
                            zzetVar.zzk(1);
                            if (iZza == 0) {
                                zzetVar.zzk(1);
                                i4 = 0;
                                i3 = 0;
                            } else {
                                int iZzs = zzetVar.zzs();
                                i3 = iZzs & 15;
                                i4 = (iZzs & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                            }
                            boolean z = zzetVar.zzs() == 1;
                            int iZzs2 = zzetVar.zzs();
                            byte[] bArr2 = new byte[16];
                            zzetVar.zzm(bArr2, 0, 16);
                            if (z && iZzs2 == 0) {
                                int iZzs3 = zzetVar.zzs();
                                byte[] bArr3 = new byte[iZzs3];
                                zzetVar.zzm(bArr3, 0, iZzs3);
                                bArr = bArr3;
                            }
                            zzamjVar = new zzamj(z, strZzK, iZzs2, bArr2, i4, i3, bArr);
                            break;
                        }
                        i8 += iZzB4;
                    }
                    zzagc.zza(zzamjVar != null, "tenc atom is mandatory");
                    String str = zzfl.zza;
                    pairCreate = Pair.create(numValueOf, zzamjVar);
                } else {
                    pairCreate = null;
                }
                if (pairCreate != null) {
                    return pairCreate;
                }
            }
            iZzg += iZzB;
        }
        return null;
    }

    private static int zzs(zzet zzetVar) {
        int iZzs = zzetVar.zzs();
        int i = iZzs & 127;
        while ((iZzs & 128) == 128) {
            iZzs = zzetVar.zzs();
            i = (i << 7) | (iZzs & 127);
        }
        return i;
    }
}
