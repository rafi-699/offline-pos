package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzifs<T> implements zzigh<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zziha.zzr();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzifp zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzigt zzm;
    private final zzidp zzn;

    private zzifs(int[] iArr, Object[] objArr, int i, int i2, zzifp zzifpVar, boolean z, int[] iArr2, int i3, int i4, zzifv zzifvVar, zzifb zzifbVar, zzigt zzigtVar, zzidp zzidpVar, zzifk zzifkVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzifpVar instanceof zziee;
        boolean z2 = false;
        if (zzidpVar != null && (zzifpVar instanceof zziea)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzj = iArr2;
        this.zzk = i3;
        this.zzl = i4;
        this.zzm = zzigtVar;
        this.zzn = zzidpVar;
        this.zzg = zzifpVar;
    }

    private final int zzA(int i) {
        return this.zzc[i + 1];
    }

    private final int zzB(int i) {
        return this.zzc[i + 2];
    }

    private static int zzC(int i) {
        return (i >>> 20) & 255;
    }

    private static boolean zzD(int i) {
        return (i & 536870912) != 0;
    }

    private static boolean zzE(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zziee) {
            return ((zziee) obj).zzaX();
        }
        return true;
    }

    private static void zzF(Object obj) {
        if (zzE(obj)) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        String.valueOf(strValueOf);
        throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(strValueOf)));
    }

    private static int zzG(Object obj, long j) {
        return ((Integer) zziha.zzm(obj, j)).intValue();
    }

    private static long zzH(Object obj, long j) {
        return ((Long) zziha.zzm(obj, j)).longValue();
    }

    private final boolean zzI(Object obj, Object obj2, int i) {
        return zzK(obj, i) == zzK(obj2, i);
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzK(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zzK(Object obj, int i) {
        int iZzB = zzB(i);
        long j = iZzB & 1048575;
        if (j != 1048575) {
            return (zziha.zzc(obj, j) & (1 << (iZzB >>> 20))) != 0;
        }
        int iZzA = zzA(i);
        long j2 = iZzA & 1048575;
        switch (zzC(iZzA)) {
            case 0:
                return Double.doubleToRawLongBits(zziha.zzk(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zziha.zzi(obj, j2)) != 0;
            case 2:
                return zziha.zze(obj, j2) != 0;
            case 3:
                return zziha.zze(obj, j2) != 0;
            case 4:
                return zziha.zzc(obj, j2) != 0;
            case 5:
                return zziha.zze(obj, j2) != 0;
            case 6:
                return zziha.zzc(obj, j2) != 0;
            case 7:
                return zziha.zzg(obj, j2);
            case 8:
                Object objZzm = zziha.zzm(obj, j2);
                if (objZzm instanceof String) {
                    return !((String) objZzm).isEmpty();
                }
                if (objZzm instanceof zzida) {
                    return !zzida.zza.equals(objZzm);
                }
                throw new IllegalArgumentException();
            case 9:
                return zziha.zzm(obj, j2) != null;
            case 10:
                return !zzida.zza.equals(zziha.zzm(obj, j2));
            case 11:
                return zziha.zzc(obj, j2) != 0;
            case 12:
                return zziha.zzc(obj, j2) != 0;
            case 13:
                return zziha.zzc(obj, j2) != 0;
            case 14:
                return zziha.zze(obj, j2) != 0;
            case 15:
                return zziha.zzc(obj, j2) != 0;
            case 16:
                return zziha.zze(obj, j2) != 0;
            case 17:
                return zziha.zzm(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final void zzL(Object obj, int i) {
        int iZzB = zzB(i);
        long j = 1048575 & iZzB;
        if (j == 1048575) {
            return;
        }
        zziha.zzd(obj, j, (1 << (iZzB >>> 20)) | zziha.zzc(obj, j));
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zziha.zzc(obj, (long) (zzB(i2) & 1048575)) == i;
    }

    private final boolean zzN(Object obj, Object obj2, int i) {
        long jZzB = zzB(i) & 1048575;
        return zziha.zzc(obj, jZzB) == zziha.zzc(obj2, jZzB);
    }

    private final void zzO(Object obj, int i, int i2) {
        zziha.zzd(obj, zzB(i2) & 1048575, i);
    }

    private final int zzP(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzQ(i, 0);
    }

    private final int zzQ(int i, int i2) {
        int[] iArr = this.zzc;
        int length = (iArr.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = iArr[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    private static final int zzR(byte[] bArr, int i, int i2, zzihg zzihgVar, Class cls, zzico zzicoVar) throws IOException {
        zzihg zzihgVar2 = zzihg.DOUBLE;
        switch (zzihgVar) {
            case DOUBLE:
                int i3 = i + 8;
                zzicoVar.zzc = Double.valueOf(Double.longBitsToDouble(zzicp.zze(bArr, i)));
                return i3;
            case FLOAT:
                int i4 = i + 4;
                zzicoVar.zzc = Float.valueOf(Float.intBitsToFloat(zzicp.zzd(bArr, i)));
                return i4;
            case INT64:
            case UINT64:
                int iZzc = zzicp.zzc(bArr, i, zzicoVar);
                zzicoVar.zzc = Long.valueOf(zzicoVar.zzb);
                return iZzc;
            case INT32:
            case UINT32:
            case ENUM:
                int iZza = zzicp.zza(bArr, i, zzicoVar);
                zzicoVar.zzc = Integer.valueOf(zzicoVar.zza);
                return iZza;
            case FIXED64:
            case SFIXED64:
                int i5 = i + 8;
                zzicoVar.zzc = Long.valueOf(zzicp.zze(bArr, i));
                return i5;
            case FIXED32:
            case SFIXED32:
                int i6 = i + 4;
                zzicoVar.zzc = Integer.valueOf(zzicp.zzd(bArr, i));
                return i6;
            case BOOL:
                int iZzc2 = zzicp.zzc(bArr, i, zzicoVar);
                zzicoVar.zzc = Boolean.valueOf(zzicoVar.zzb != 0);
                return iZzc2;
            case STRING:
                return zzicp.zzf(bArr, i, zzicoVar);
            case GROUP:
            default:
                throw new RuntimeException("unsupported field type.");
            case MESSAGE:
                return zzicp.zzh(zzifz.zza().zzb(cls), bArr, i, i2, zzicoVar);
            case BYTES:
                return zzicp.zzg(bArr, i, zzicoVar);
            case SINT32:
                int iZza2 = zzicp.zza(bArr, i, zzicoVar);
                zzicoVar.zzc = Integer.valueOf(zzide.zzM(zzicoVar.zza));
                return iZza2;
            case SINT64:
                int iZzc3 = zzicp.zzc(bArr, i, zzicoVar);
                zzicoVar.zzc = Long.valueOf(zzide.zzN(zzicoVar.zzb));
                return iZzc3;
        }
    }

    private static final void zzS(int i, Object obj, zzihi zzihiVar) throws IOException {
        if (obj instanceof String) {
            zzihiVar.zzm(i, (String) obj);
        } else {
            zzihiVar.zzn(i, (zzida) obj);
        }
    }

    static zzigu zzh(Object obj) {
        zziee zzieeVar = (zziee) obj;
        zzigu zziguVar = zzieeVar.zzt;
        if (zziguVar != zzigu.zza()) {
            return zziguVar;
        }
        zzigu zziguVarZzb = zzigu.zzb();
        zzieeVar.zzt = zziguVarZzb;
        return zziguVarZzb;
    }

    /* JADX WARN: Code duplicated, block: B:125:0x0260  */
    /* JADX WARN: Code duplicated, block: B:126:0x0263  */
    /* JADX WARN: Code duplicated, block: B:129:0x0283  */
    /* JADX WARN: Code duplicated, block: B:130:0x0286  */
    /* JADX WARN: Code duplicated, block: B:169:0x0342  */
    /* JADX WARN: Code duplicated, block: B:187:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:188:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:191:0x03b6  */
    /* JADX WARN: Code duplicated, block: B:192:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:194:0x03bc  */
    /* JADX WARN: Code duplicated, block: B:195:0x03bf  */
    static zzifs zzm(Class cls, zzifm zzifmVar, zzifv zzifvVar, zzifb zzifbVar, zzigt zzigtVar, zzidp zzidpVar, zzifk zzifkVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        int i10;
        char cCharAt2;
        int i11;
        char cCharAt3;
        int i12;
        char cCharAt4;
        int i13;
        char cCharAt5;
        int i14;
        char cCharAt6;
        int i15;
        char cCharAt7;
        int i16;
        int i17;
        int i18;
        int i19;
        int iObjectFieldOffset;
        int i20;
        char c;
        int i21;
        int i22;
        int i23;
        int i24;
        Field fieldZzn;
        int iObjectFieldOffset2;
        int i25;
        char cCharAt8;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        Object obj;
        Field fieldZzn2;
        int i35;
        Object obj2;
        Field fieldZzn3;
        int i36;
        char cCharAt9;
        int i37;
        char cCharAt10;
        int i38;
        char cCharAt11;
        int i39;
        char cCharAt12;
        if (!(zzifmVar instanceof zzigb)) {
            throw null;
        }
        zzigb zzigbVar = (zzigb) zzifmVar;
        String strZzd = zzigbVar.zzd();
        int length = strZzd.length();
        char c2 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i40 = 1;
            while (true) {
                i = i40 + 1;
                if (strZzd.charAt(i40) < 55296) {
                    break;
                }
                i40 = i;
            }
        } else {
            i = 1;
        }
        int i41 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i42 = iCharAt2 & 8191;
            int i43 = 13;
            while (true) {
                i39 = i41 + 1;
                cCharAt12 = strZzd.charAt(i41);
                if (cCharAt12 < 55296) {
                    break;
                }
                i42 |= (cCharAt12 & 8191) << i43;
                i43 += 13;
                i41 = i39;
            }
            iCharAt2 = i42 | (cCharAt12 << i43);
            i41 = i39;
        }
        if (iCharAt2 == 0) {
            i6 = 0;
            i4 = 0;
            iCharAt = 0;
            i5 = 0;
            i3 = 0;
            i7 = 0;
            iArr = zza;
            i2 = 0;
        } else {
            int i44 = i41 + 1;
            int iCharAt3 = strZzd.charAt(i41);
            if (iCharAt3 >= 55296) {
                int i45 = iCharAt3 & 8191;
                int i46 = 13;
                while (true) {
                    i15 = i44 + 1;
                    cCharAt7 = strZzd.charAt(i44);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i45 |= (cCharAt7 & 8191) << i46;
                    i46 += 13;
                    i44 = i15;
                }
                iCharAt3 = i45 | (cCharAt7 << i46);
                i44 = i15;
            }
            int i47 = i44 + 1;
            int iCharAt4 = strZzd.charAt(i44);
            if (iCharAt4 >= 55296) {
                int i48 = iCharAt4 & 8191;
                int i49 = 13;
                while (true) {
                    i14 = i47 + 1;
                    cCharAt6 = strZzd.charAt(i47);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i48 |= (cCharAt6 & 8191) << i49;
                    i49 += 13;
                    i47 = i14;
                }
                iCharAt4 = i48 | (cCharAt6 << i49);
                i47 = i14;
            }
            int i50 = i47 + 1;
            int iCharAt5 = strZzd.charAt(i47);
            if (iCharAt5 >= 55296) {
                int i51 = iCharAt5 & 8191;
                int i52 = 13;
                while (true) {
                    i13 = i50 + 1;
                    cCharAt5 = strZzd.charAt(i50);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i51 |= (cCharAt5 & 8191) << i52;
                    i52 += 13;
                    i50 = i13;
                }
                iCharAt5 = i51 | (cCharAt5 << i52);
                i50 = i13;
            }
            int i53 = i50 + 1;
            int iCharAt6 = strZzd.charAt(i50);
            if (iCharAt6 >= 55296) {
                int i54 = iCharAt6 & 8191;
                int i55 = 13;
                while (true) {
                    i12 = i53 + 1;
                    cCharAt4 = strZzd.charAt(i53);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i54 |= (cCharAt4 & 8191) << i55;
                    i55 += 13;
                    i53 = i12;
                }
                iCharAt6 = i54 | (cCharAt4 << i55);
                i53 = i12;
            }
            int i56 = i53 + 1;
            iCharAt = strZzd.charAt(i53);
            if (iCharAt >= 55296) {
                int i57 = iCharAt & 8191;
                int i58 = 13;
                while (true) {
                    i11 = i56 + 1;
                    cCharAt3 = strZzd.charAt(i56);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i57 |= (cCharAt3 & 8191) << i58;
                    i58 += 13;
                    i56 = i11;
                }
                iCharAt = i57 | (cCharAt3 << i58);
                i56 = i11;
            }
            int i59 = i56 + 1;
            int iCharAt7 = strZzd.charAt(i56);
            if (iCharAt7 >= 55296) {
                int i60 = iCharAt7 & 8191;
                int i61 = 13;
                while (true) {
                    i10 = i59 + 1;
                    cCharAt2 = strZzd.charAt(i59);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i60 |= (cCharAt2 & 8191) << i61;
                    i61 += 13;
                    i59 = i10;
                }
                iCharAt7 = i60 | (cCharAt2 << i61);
                i59 = i10;
            }
            int i62 = i59 + 1;
            if (strZzd.charAt(i59) >= 55296) {
                while (true) {
                    i9 = i62 + 1;
                    if (strZzd.charAt(i62) < 55296) {
                        break;
                    }
                    i62 = i9;
                }
                i62 = i9;
            }
            int i63 = i62 + 1;
            int iCharAt8 = strZzd.charAt(i62);
            if (iCharAt8 >= 55296) {
                int i64 = iCharAt8 & 8191;
                int i65 = 13;
                while (true) {
                    i8 = i63 + 1;
                    cCharAt = strZzd.charAt(i63);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i64 |= (cCharAt & 8191) << i65;
                    i65 += 13;
                    i63 = i8;
                }
                iCharAt8 = i64 | (cCharAt << i65);
                i63 = i8;
            }
            int i66 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt8 + iCharAt7 + iCharAt3];
            i2 = iCharAt3;
            i41 = i63;
            i3 = iCharAt6;
            i4 = i66;
            iArr = iArr2;
            int i67 = iCharAt7;
            i5 = iCharAt5;
            i6 = i67;
            i7 = iCharAt8;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzigbVar.zze();
        Class<?> cls2 = zzigbVar.zzb().getClass();
        int i68 = i7 + i6;
        int i69 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i69];
        int i70 = i7;
        int i71 = i68;
        int i72 = 0;
        int i73 = 0;
        while (i41 < length) {
            int i74 = i41 + 1;
            int iCharAt9 = strZzd.charAt(i41);
            if (iCharAt9 >= c2) {
                int i75 = iCharAt9 & 8191;
                int i76 = i74;
                int i77 = 13;
                while (true) {
                    i38 = i76 + 1;
                    cCharAt11 = strZzd.charAt(i76);
                    if (cCharAt11 < c2) {
                        break;
                    }
                    i75 |= (cCharAt11 & 8191) << i77;
                    i77 += 13;
                    i76 = i38;
                }
                iCharAt9 = i75 | (cCharAt11 << i77);
                i16 = i38;
            } else {
                i16 = i74;
            }
            int i78 = i16 + 1;
            int iCharAt10 = strZzd.charAt(i16);
            if (iCharAt10 >= c2) {
                int i79 = iCharAt10 & 8191;
                int i80 = i78;
                int i81 = 13;
                while (true) {
                    i37 = i80 + 1;
                    cCharAt10 = strZzd.charAt(i80);
                    if (cCharAt10 < c2) {
                        break;
                    }
                    i79 |= (cCharAt10 & 8191) << i81;
                    i81 += 13;
                    i80 = i37;
                }
                iCharAt10 = i79 | (cCharAt10 << i81);
                i17 = i37;
            } else {
                i17 = i78;
            }
            if ((iCharAt10 & 1024) != 0) {
                iArr[i72] = i73;
                i72++;
            }
            int i82 = iCharAt10 & 255;
            zzigb zzigbVar2 = zzigbVar;
            int i83 = iCharAt10 & 2048;
            if (i82 >= 51) {
                int i84 = i17 + 1;
                int iCharAt11 = strZzd.charAt(i17);
                char c3 = 55296;
                if (iCharAt11 >= 55296) {
                    int i85 = iCharAt11 & 8191;
                    int i86 = i84;
                    int i87 = 13;
                    while (true) {
                        i36 = i86 + 1;
                        cCharAt9 = strZzd.charAt(i86);
                        if (cCharAt9 < c3) {
                            break;
                        }
                        i85 |= (cCharAt9 & 8191) << i87;
                        i87 += 13;
                        i86 = i36;
                        c3 = 55296;
                    }
                    iCharAt11 = i85 | (cCharAt9 << i87);
                    i31 = i36;
                } else {
                    i31 = i84;
                }
                i21 = i31;
                int i88 = i82 - 51;
                i18 = length;
                if (i88 == 9 || i88 == 17) {
                    i32 = i4 + 1;
                    int i89 = i73 / 3;
                    objArr[i89 + i89 + 1] = objArrZze[i4];
                } else {
                    if (i88 != 12) {
                        i33 = i83;
                    } else if (zzigbVar2.zzc() == 1 || i83 != 0) {
                        i32 = i4 + 1;
                        int i90 = i73 / 3;
                        objArr[i90 + i90 + 1] = objArrZze[i4];
                    } else {
                        i33 = 0;
                    }
                    i34 = iCharAt11 + iCharAt11;
                    obj = objArrZze[i34];
                    i83 = i33;
                    if (obj instanceof Field) {
                        fieldZzn2 = (Field) obj;
                    } else {
                        fieldZzn2 = zzn(cls2, (String) obj);
                        objArrZze[i34] = fieldZzn2;
                        iArr[i71] = i73;
                        i71++;
                    }
                    int i91 = i2;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzn2);
                    i35 = i34 + 1;
                    obj2 = objArrZze[i35];
                    i19 = i91;
                    if (obj2 instanceof Field) {
                        fieldZzn3 = (Field) obj2;
                    } else {
                        fieldZzn3 = zzn(cls2, (String) obj2);
                        objArrZze[i35] = fieldZzn3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn3);
                    strZzd = strZzd;
                    i23 = iObjectFieldOffset3;
                    i24 = 0;
                    c = 55296;
                }
                i4 = i32;
                i33 = i83;
                i34 = iCharAt11 + iCharAt11;
                obj = objArrZze[i34];
                i83 = i33;
                if (obj instanceof Field) {
                    fieldZzn2 = (Field) obj;
                } else {
                    fieldZzn2 = zzn(cls2, (String) obj);
                    objArrZze[i34] = fieldZzn2;
                    iArr[i71] = i73;
                    i71++;
                }
                int i92 = i2;
                int iObjectFieldOffset4 = (int) unsafe.objectFieldOffset(fieldZzn2);
                i35 = i34 + 1;
                obj2 = objArrZze[i35];
                i19 = i92;
                if (obj2 instanceof Field) {
                    fieldZzn3 = (Field) obj2;
                } else {
                    fieldZzn3 = zzn(cls2, (String) obj2);
                    objArrZze[i35] = fieldZzn3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn3);
                strZzd = strZzd;
                i23 = iObjectFieldOffset4;
                i24 = 0;
                c = 55296;
            } else {
                i18 = length;
                i19 = i2;
                int i93 = i4 + 1;
                Field fieldZzn4 = zzn(cls2, (String) objArrZze[i4]);
                if (i82 == 9 || i82 == 17) {
                    int i94 = i73 / 3;
                    objArr[i94 + i94 + 1] = fieldZzn4.getType();
                } else {
                    if (i82 != 27) {
                        if (i82 == 49) {
                            i4 += 2;
                            i26 = 1;
                        } else if (i82 == 12 || i82 == 30 || i82 == 44) {
                            if (zzigbVar2.zzc() == 1 || i83 != 0) {
                                i4 += 2;
                                int i95 = i73 / 3;
                                objArr[i95 + i95 + 1] = objArrZze[i93];
                            } else {
                                i4 = i93;
                                i83 = 0;
                            }
                        } else if (i82 == 50) {
                            int i96 = i4 + 2;
                            int i97 = i70 + 1;
                            iArr[i70] = i73;
                            int i98 = i73 / 3;
                            int i99 = i98 + i98;
                            objArr[i99] = objArrZze[i93];
                            if (i83 != 0) {
                                objArr[i99 + 1] = objArrZze[i96];
                                i4 += 3;
                                i70 = i97;
                            } else {
                                i4 = i96;
                                i70 = i97;
                                i83 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
                        i20 = 1048575;
                        if ((iCharAt10 & 4096) != 0 || i82 > 17) {
                            c = 55296;
                            i21 = i17;
                            i22 = i83;
                            i23 = iObjectFieldOffset;
                            i24 = 0;
                        } else {
                            int i100 = i17 + 1;
                            int iCharAt12 = strZzd.charAt(i17);
                            if (iCharAt12 >= 55296) {
                                int i101 = iCharAt12 & 8191;
                                int i102 = 13;
                                while (true) {
                                    i25 = i100 + 1;
                                    cCharAt8 = strZzd.charAt(i100);
                                    if (cCharAt8 < 55296) {
                                        break;
                                    }
                                    i101 |= (cCharAt8 & 8191) << i102;
                                    i102 += 13;
                                    i100 = i25;
                                }
                                iCharAt12 = i101 | (cCharAt8 << i102);
                                i100 = i25;
                            }
                            int i103 = i19 + i19 + (iCharAt12 / 32);
                            Object obj3 = objArrZze[i103];
                            int i104 = i100;
                            if (obj3 instanceof Field) {
                                fieldZzn = (Field) obj3;
                            } else {
                                fieldZzn = zzn(cls2, (String) obj3);
                                objArrZze[i103] = fieldZzn;
                            }
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzn);
                            i23 = iObjectFieldOffset;
                            i21 = i104;
                            c = 55296;
                            i24 = iCharAt12 % 32;
                        }
                        int i105 = i73 + 1;
                        iArr3[i73] = iCharAt9;
                        int i106 = i73 + 2;
                        i27 = i22;
                        if ((iCharAt10 & 512) != 0) {
                            i28 = 536870912;
                        } else {
                            i28 = 0;
                        }
                        if ((iCharAt10 & 256) != 0) {
                            i29 = 268435456;
                        } else {
                            i29 = 0;
                        }
                        if (i27 != 0) {
                            i30 = Integer.MIN_VALUE;
                        } else {
                            i30 = 0;
                        }
                        iArr3[i105] = i28 | i29 | i30 | (i82 << 20) | i23;
                        i73 += 3;
                        iArr3[i106] = (i24 << 20) | i20;
                        strZzd = strZzd;
                        c2 = c;
                        zzigbVar = zzigbVar2;
                        i41 = i21;
                        length = i18;
                        i2 = i19;
                    } else {
                        i26 = 1;
                        i4 += 2;
                    }
                    int i107 = i73 / 3;
                    objArr[i107 + i107 + i26] = objArrZze[i93];
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
                    i20 = 1048575;
                    if ((iCharAt10 & 4096) != 0) {
                    }
                    c = 55296;
                    i21 = i17;
                    i22 = i83;
                    i23 = iObjectFieldOffset;
                    i24 = 0;
                    int i108 = i73 + 1;
                    iArr3[i73] = iCharAt9;
                    int i109 = i73 + 2;
                    i27 = i22;
                    if ((iCharAt10 & 512) != 0) {
                        i28 = 536870912;
                    } else {
                        i28 = 0;
                    }
                    if ((iCharAt10 & 256) != 0) {
                        i29 = 268435456;
                    } else {
                        i29 = 0;
                    }
                    if (i27 != 0) {
                        i30 = Integer.MIN_VALUE;
                    } else {
                        i30 = 0;
                    }
                    iArr3[i108] = i28 | i29 | i30 | (i82 << 20) | i23;
                    i73 += 3;
                    iArr3[i109] = (i24 << 20) | i20;
                    strZzd = strZzd;
                    c2 = c;
                    zzigbVar = zzigbVar2;
                    i41 = i21;
                    length = i18;
                    i2 = i19;
                }
                i4 = i93;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzn4);
                i20 = 1048575;
                if ((iCharAt10 & 4096) != 0) {
                }
                c = 55296;
                i21 = i17;
                i22 = i83;
                i23 = iObjectFieldOffset;
                i24 = 0;
                int i1010 = i73 + 1;
                iArr3[i73] = iCharAt9;
                int i1011 = i73 + 2;
                i27 = i22;
                if ((iCharAt10 & 512) != 0) {
                    i28 = 536870912;
                } else {
                    i28 = 0;
                }
                if ((iCharAt10 & 256) != 0) {
                    i29 = 268435456;
                } else {
                    i29 = 0;
                }
                if (i27 != 0) {
                    i30 = Integer.MIN_VALUE;
                } else {
                    i30 = 0;
                }
                iArr3[i1010] = i28 | i29 | i30 | (i82 << 20) | i23;
                i73 += 3;
                iArr3[i1011] = (i24 << 20) | i20;
                strZzd = strZzd;
                c2 = c;
                zzigbVar = zzigbVar2;
                i41 = i21;
                length = i18;
                i2 = i19;
            }
            i20 = iObjectFieldOffset2;
            i22 = i83;
            int i1012 = i73 + 1;
            iArr3[i73] = iCharAt9;
            int i1013 = i73 + 2;
            i27 = i22;
            if ((iCharAt10 & 512) != 0) {
                i28 = 536870912;
            } else {
                i28 = 0;
            }
            if ((iCharAt10 & 256) != 0) {
                i29 = 268435456;
            } else {
                i29 = 0;
            }
            if (i27 != 0) {
                i30 = Integer.MIN_VALUE;
            } else {
                i30 = 0;
            }
            iArr3[i1012] = i28 | i29 | i30 | (i82 << 20) | i23;
            i73 += 3;
            iArr3[i1013] = (i24 << 20) | i20;
            strZzd = strZzd;
            c2 = c;
            zzigbVar = zzigbVar2;
            i41 = i21;
            length = i18;
            i2 = i19;
        }
        return new zzifs(iArr3, objArr, i5, i3, zzigbVar.zzb(), false, iArr, i7, i68, zzifvVar, zzifbVar, zzigtVar, zzidpVar, zzifkVar);
    }

    private static Field zzn(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String string = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 11 + String.valueOf(name).length() + 29 + String.valueOf(string).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(string);
            throw new RuntimeException(sb.toString(), e);
        }
    }

    private final void zzo(Object obj, Object obj2, int i) {
        if (zzK(obj2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i2 = this.zzc[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i2);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzigh zzighVarZzq = zzq(i);
            if (!zzK(obj, i)) {
                if (zzE(object)) {
                    Object objZza = zzighVarZzq.zza();
                    zzighVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzL(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzighVarZzq.zza();
                zzighVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzighVarZzq.zzd(object2, object);
        }
    }

    private final void zzp(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int iZzA = zzA(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzA;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                int i3 = iArr[i];
                String string = obj2.toString();
                StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 38 + string.length());
                sb.append("Source subfield ");
                sb.append(i3);
                sb.append(" is present but null: ");
                sb.append(string);
                throw new IllegalStateException(sb.toString());
            }
            zzigh zzighVarZzq = zzq(i);
            if (!zzM(obj, i2, i)) {
                if (zzE(object)) {
                    Object objZza = zzighVarZzq.zza();
                    zzighVarZzq.zzd(objZza, object);
                    unsafe.putObject(obj, j, objZza);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzO(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzE(object2)) {
                Object objZza2 = zzighVarZzq.zza();
                zzighVarZzq.zzd(objZza2, object2);
                unsafe.putObject(obj, j, objZza2);
                object2 = objZza2;
            }
            zzighVarZzq.zzd(object2, object);
        }
    }

    private final zzigh zzq(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzigh zzighVar = (zzigh) objArr[i3];
        if (zzighVar != null) {
            return zzighVar;
        }
        zzigh zzighVarZzb = zzifz.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzighVarZzb;
        return zzighVarZzb;
    }

    private final Object zzr(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final zziek zzs(int i) {
        int i2 = i / 3;
        return (zziek) this.zzd[i2 + i2 + 1];
    }

    private final Object zzt(Object obj, int i) {
        zzigh zzighVarZzq = zzq(i);
        int iZzA = zzA(i) & 1048575;
        if (!zzK(obj, i)) {
            return zzighVarZzq.zza();
        }
        Object object = zzb.getObject(obj, iZzA);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzighVarZzq.zza();
        if (object != null) {
            zzighVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzu(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzA(i) & 1048575, obj2);
        zzL(obj, i);
    }

    private final Object zzv(Object obj, int i, int i2) {
        zzigh zzighVarZzq = zzq(i2);
        if (!zzM(obj, i, i2)) {
            return zzighVarZzq.zza();
        }
        Object object = zzb.getObject(obj, zzA(i2) & 1048575);
        if (zzE(object)) {
            return object;
        }
        Object objZza = zzighVarZzq.zza();
        if (object != null) {
            zzighVarZzq.zzd(objZza, object);
        }
        return objZza;
    }

    private final void zzw(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzA(i2) & 1048575, obj2);
        zzO(obj, i, i2);
    }

    private final Object zzx(Object obj, int i, Object obj2, zzigt zzigtVar, Object obj3) {
        zziek zziekVarZzs;
        int i2 = this.zzc[i];
        Object objZzm = zziha.zzm(obj, zzA(i) & 1048575);
        if (objZzm == null || (zziekVarZzs = zzs(i)) == null) {
            return obj2;
        }
        zzifh zzifhVarZze = ((zzifi) zzr(i)).zze();
        Iterator it = ((zzifj) objZzm).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!zziekVarZzs.zza(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = zzigtVar.zzh(obj3);
                }
                int iZzc = zzifi.zzc(zzifhVarZze, entry.getKey(), entry.getValue());
                zzida zzidaVar = zzida.zza;
                byte[] bArr = new byte[iZzc];
                int i3 = zzidj.zzb;
                zzidg zzidgVar = new zzidg(bArr, 0, iZzc);
                try {
                    zzifi.zzb(zzidgVar, zzifhVarZze, entry.getKey(), entry.getValue());
                    zzigtVar.zzd(obj2, i2, zzicw.zza(zzidgVar, bArr));
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return obj2;
    }

    private static boolean zzy(Object obj, int i, zzigh zzighVar) {
        return zzighVar.zzl(zziha.zzm(obj, i & 1048575));
    }

    private final void zzz(Object obj, int i, zzigc zzigcVar) throws IOException {
        long j = i & 1048575;
        if (zzD(i)) {
            zziha.zzn(obj, j, zzigcVar.zzn());
        } else if (this.zzi) {
            zziha.zzn(obj, j, zzigcVar.zzm());
        } else {
            zziha.zzn(obj, j, zzigcVar.zzq());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final Object zza() {
        return ((zziee) this.zzg).zzbg();
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final boolean zzb(Object obj, Object obj2) {
        boolean zZzG;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzA = zzA(i);
            int iZzC = zzC(iZzA);
            if (iZzC <= 50 || iZzC >= 69) {
                long j = iZzA & 1048575;
                switch (iZzC) {
                    case 0:
                        if (!zzI(obj, obj2, i) || Double.doubleToLongBits(zziha.zzk(obj, j)) != Double.doubleToLongBits(zziha.zzk(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 1:
                        if (!zzI(obj, obj2, i) || Float.floatToIntBits(zziha.zzi(obj, j)) != Float.floatToIntBits(zziha.zzi(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 2:
                        if (!zzI(obj, obj2, i) || zziha.zze(obj, j) != zziha.zze(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 3:
                        if (!zzI(obj, obj2, i) || zziha.zze(obj, j) != zziha.zze(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 4:
                        if (!zzI(obj, obj2, i) || zziha.zzc(obj, j) != zziha.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 5:
                        if (!zzI(obj, obj2, i) || zziha.zze(obj, j) != zziha.zze(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 6:
                        if (!zzI(obj, obj2, i) || zziha.zzc(obj, j) != zziha.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 7:
                        if (!zzI(obj, obj2, i) || zziha.zzg(obj, j) != zziha.zzg(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 8:
                        if (!zzI(obj, obj2, i) || !zzigi.zzG(zziha.zzm(obj, j), zziha.zzm(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 9:
                        if (!zzI(obj, obj2, i) || !zzigi.zzG(zziha.zzm(obj, j), zziha.zzm(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 10:
                        if (!zzI(obj, obj2, i) || !zzigi.zzG(zziha.zzm(obj, j), zziha.zzm(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 11:
                        if (!zzI(obj, obj2, i) || zziha.zzc(obj, j) != zziha.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 12:
                        if (!zzI(obj, obj2, i) || zziha.zzc(obj, j) != zziha.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 13:
                        if (!zzI(obj, obj2, i) || zziha.zzc(obj, j) != zziha.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 14:
                        if (!zzI(obj, obj2, i) || zziha.zze(obj, j) != zziha.zze(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 15:
                        if (!zzI(obj, obj2, i) || zziha.zzc(obj, j) != zziha.zzc(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 16:
                        if (!zzI(obj, obj2, i) || zziha.zze(obj, j) != zziha.zze(obj2, j)) {
                            return false;
                        }
                        continue;
                        break;
                    case 17:
                        if (!zzI(obj, obj2, i) || !zzigi.zzG(zziha.zzm(obj, j), zziha.zzm(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        zZzG = zzigi.zzG(zziha.zzm(obj, j), zziha.zzm(obj2, j));
                        break;
                    case 50:
                        zZzG = zzigi.zzG(zziha.zzm(obj, j), zziha.zzm(obj2, j));
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                        if (!zzN(obj, obj2, i) || !zzigi.zzG(zziha.zzm(obj, j), zziha.zzm(obj2, j))) {
                            return false;
                        }
                        continue;
                        break;
                    default:
                        continue;
                }
                if (!zZzG) {
                    return false;
                }
            }
        }
        int i2 = this.zzl;
        while (true) {
            int[] iArr = this.zzj;
            if (i2 >= iArr.length) {
                if (!((zziee) obj).zzt.equals(((zziee) obj2).zzt)) {
                    return false;
                }
                if (this.zzh) {
                    return ((zziea) obj).zza.equals(((zziea) obj2).zza);
                }
                return true;
            }
            int i3 = iArr[i2];
            if (!zzN(obj, obj2, i3)) {
                return false;
            }
            if (!zzM(obj, 0, i3)) {
                long jZzA = zzA(i3) & 1048575;
                if (!zzigi.zzG(zziha.zzm(obj, jZzA), zziha.zzm(obj2, jZzA))) {
                    return false;
                }
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final int zzc(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int iHashCode = 0;
        for (int i3 = 0; i3 < this.zzc.length; i3 += 3) {
            int iZzA = zzA(i3);
            int iZzC = zzC(iZzA);
            if (iZzC <= 50 || iZzC >= 69) {
                long j = iZzA & 1048575;
                int iHashCode2 = 37;
                switch (iZzC) {
                    case 0:
                        i = iHashCode * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zziha.zzk(obj, j));
                        byte[] bArr = zzier.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 1:
                        i = iHashCode * 53;
                        iFloatToIntBits = Float.floatToIntBits(zziha.zzi(obj, j));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 2:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zziha.zze(obj, j);
                        byte[] bArr2 = zzier.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 3:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zziha.zze(obj, j);
                        byte[] bArr3 = zzier.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 4:
                        i = iHashCode * 53;
                        iFloatToIntBits = zziha.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 5:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zziha.zze(obj, j);
                        byte[] bArr4 = zzier.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 6:
                        i = iHashCode * 53;
                        iFloatToIntBits = zziha.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 7:
                        i = iHashCode * 53;
                        iFloatToIntBits = zzier.zza(zziha.zzg(obj, j));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 8:
                        i = iHashCode * 53;
                        iFloatToIntBits = ((String) zziha.zzm(obj, j)).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 9:
                        i2 = iHashCode * 53;
                        Object objZzm = zziha.zzm(obj, j);
                        if (objZzm != null) {
                            iHashCode2 = objZzm.hashCode();
                        }
                        iHashCode = i2 + iHashCode2;
                        break;
                    case 10:
                        i = iHashCode * 53;
                        iFloatToIntBits = zziha.zzm(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 11:
                        i = iHashCode * 53;
                        iFloatToIntBits = zziha.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 12:
                        i = iHashCode * 53;
                        iFloatToIntBits = zziha.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 13:
                        i = iHashCode * 53;
                        iFloatToIntBits = zziha.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 14:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zziha.zze(obj, j);
                        byte[] bArr5 = zzier.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 15:
                        i = iHashCode * 53;
                        iFloatToIntBits = zziha.zzc(obj, j);
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 16:
                        i = iHashCode * 53;
                        jDoubleToLongBits = zziha.zze(obj, j);
                        byte[] bArr6 = zzier.zza;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 17:
                        i2 = iHashCode * 53;
                        Object objZzm2 = zziha.zzm(obj, j);
                        if (objZzm2 != null) {
                            iHashCode2 = objZzm2.hashCode();
                        }
                        iHashCode = i2 + iHashCode2;
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        i = iHashCode * 53;
                        iFloatToIntBits = zziha.zzm(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                    case 50:
                        i = iHashCode * 53;
                        iFloatToIntBits = zziha.zzm(obj, j).hashCode();
                        iHashCode = i + iFloatToIntBits;
                        break;
                }
            }
        }
        int i4 = this.zzl;
        while (true) {
            int[] iArr = this.zzj;
            if (i4 >= iArr.length) {
                int iHashCode3 = (iHashCode * 53) + ((zziee) obj).zzt.hashCode();
                return this.zzh ? (iHashCode3 * 53) + ((zziea) obj).zza.zza.hashCode() : iHashCode3;
            }
            int i5 = iArr[i4];
            if (!zzM(obj, 0, i5)) {
                iHashCode = (iHashCode * 53) + zziha.zzm(obj, zzA(i5) & 1048575).hashCode();
            }
            i4++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzd(Object obj, Object obj2) {
        zzF(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzigi.zzI(this.zzm, obj, obj2);
                if (this.zzh) {
                    zzigi.zzH(this.zzn, obj, obj2);
                    return;
                }
                return;
            }
            int iZzA = zzA(i);
            int i2 = 1048575 & iZzA;
            int iZzC = zzC(iZzA);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzC) {
                case 0:
                    if (zzK(obj2, i)) {
                        zziha.zzl(obj, j, zziha.zzk(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 1:
                    if (zzK(obj2, i)) {
                        zziha.zzj(obj, j, zziha.zzi(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 2:
                    if (zzK(obj2, i)) {
                        zziha.zzf(obj, j, zziha.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 3:
                    if (zzK(obj2, i)) {
                        zziha.zzf(obj, j, zziha.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 4:
                    if (zzK(obj2, i)) {
                        zziha.zzd(obj, j, zziha.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 5:
                    if (zzK(obj2, i)) {
                        zziha.zzf(obj, j, zziha.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 6:
                    if (zzK(obj2, i)) {
                        zziha.zzd(obj, j, zziha.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 7:
                    if (zzK(obj2, i)) {
                        zziha.zzh(obj, j, zziha.zzg(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 8:
                    if (zzK(obj2, i)) {
                        zziha.zzn(obj, j, zziha.zzm(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 9:
                    zzo(obj, obj2, i);
                    break;
                case 10:
                    if (zzK(obj2, i)) {
                        zziha.zzn(obj, j, zziha.zzm(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 11:
                    if (zzK(obj2, i)) {
                        zziha.zzd(obj, j, zziha.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 12:
                    if (zzK(obj2, i)) {
                        zziha.zzd(obj, j, zziha.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 13:
                    if (zzK(obj2, i)) {
                        zziha.zzd(obj, j, zziha.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 14:
                    if (zzK(obj2, i)) {
                        zziha.zzf(obj, j, zziha.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 15:
                    if (zzK(obj2, i)) {
                        zziha.zzd(obj, j, zziha.zzc(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 16:
                    if (zzK(obj2, i)) {
                        zziha.zzf(obj, j, zziha.zze(obj2, j));
                        zzL(obj, i);
                    }
                    break;
                case 17:
                    zzo(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zzieq zzieqVarZzh = (zzieq) zziha.zzm(obj, j);
                    zzieq zzieqVar = (zzieq) zziha.zzm(obj2, j);
                    int size = zzieqVarZzh.size();
                    int size2 = zzieqVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzieqVarZzh.zza()) {
                            zzieqVarZzh = zzieqVarZzh.zzh(size2 + size);
                        }
                        zzieqVarZzh.addAll(zzieqVar);
                    }
                    if (size > 0) {
                        zzieqVar = zzieqVarZzh;
                    }
                    zziha.zzn(obj, j, zzieqVar);
                    break;
                case 50:
                    int i4 = zzigi.zza;
                    zziha.zzn(obj, j, zzifk.zzb(zziha.zzm(obj, j), zziha.zzm(obj2, j)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(obj2, i3, i)) {
                        zziha.zzn(obj, j, zziha.zzm(obj2, j));
                        zzO(obj, i3, i);
                    }
                    break;
                case 60:
                    zzp(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zziha.zzn(obj, j, zziha.zzm(obj2, j));
                        zzO(obj, i3, i);
                    }
                    break;
                case 68:
                    zzp(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    /* JADX WARN: Code duplicated, block: B:141:0x0390  */
    /* JADX WARN: Code duplicated, block: B:211:0x055a  */
    @Override // com.google.android.gms.internal.ads.zzigh
    public final int zze(Object obj) {
        int i;
        int iZzF;
        int iZzF2;
        int iZzG;
        int iZzF3;
        int iZzF4;
        int iZzF5;
        int iZzc;
        int iZzF6;
        int iZzD;
        int iZzs;
        int size;
        int iZzt;
        int iZzF7;
        int iZzc2;
        int iZzF8;
        int iZzc3;
        int iZzF9;
        int iZzF10;
        int iZzaT;
        int iZzF11;
        int iZzF12;
        int iZzG2;
        int iZzB;
        int iZzF13;
        int iZzF14;
        int iZzE;
        int iZzF15;
        int iZzF16;
        int iZzF17;
        int iZzc4;
        int iZzF18;
        zzifs<T> zzifsVar = this;
        Unsafe unsafe = zzb;
        int i2 = 0;
        int i3 = 0;
        int iZzF19 = 0;
        int i4 = 1048575;
        while (true) {
            int[] iArr = zzifsVar.zzc;
            if (i2 >= iArr.length) {
                int iZzi = iZzF19 + ((zziee) obj).zzt.zzi();
                if (!zzifsVar.zzh) {
                    return iZzi;
                }
                zzign zzignVar = ((zziea) obj).zza.zza;
                int iZzc5 = zzignVar.zzc();
                int iZzj = 0;
                for (int i5 = 0; i5 < iZzc5; i5++) {
                    Map.Entry entryZzd = zzignVar.zzd(i5);
                    iZzj += zzidt.zzj((zzids) ((zzigk) entryZzd).zza(), entryZzd.getValue());
                }
                for (Map.Entry entry : zzignVar.zze()) {
                    iZzj += zzidt.zzj((zzids) entry.getKey(), entry.getValue());
                }
                return iZzi + iZzj;
            }
            int iZzA = zzifsVar.zzA(i2);
            int iZzC = zzC(iZzA);
            int i6 = iArr[i2];
            int i7 = iArr[i2 + 2];
            int i8 = i7 & 1048575;
            if (iZzC <= 17) {
                if (i8 != i4) {
                    i3 = i8 == 1048575 ? 0 : unsafe.getInt(obj, i8);
                    i4 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = iZzA & 1048575;
            if (iZzC >= zzidu.DOUBLE_LIST_PACKED.zza()) {
                zzidu.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzC) {
                case 0:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzF19 += zzidj.zzF(i6 << 3) + 8;
                    }
                    break;
                case 1:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzF = zzidj.zzF(i6 << 3);
                        iZzF4 = iZzF + 4;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 2:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzF2 = zzidj.zzF(i6 << 3);
                        iZzG = zzidj.zzG(j2);
                        iZzF4 = iZzF2 + iZzG;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 3:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzF2 = zzidj.zzF(i6 << 3);
                        iZzG = zzidj.zzG(j3);
                        iZzF4 = iZzF2 + iZzG;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 4:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzF2 = zzidj.zzF(i6 << 3);
                        iZzG = zzidj.zzG(j4);
                        iZzF4 = iZzF2 + iZzG;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 5:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzF3 = zzidj.zzF(i6 << 3);
                        iZzF4 = iZzF3 + 8;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 6:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzF = zzidj.zzF(i6 << 3);
                        iZzF4 = iZzF + 4;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 7:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzF4 = zzidj.zzF(i6 << 3) + 1;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 8:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzida) {
                            iZzF5 = zzidj.zzF(i10);
                            iZzc = ((zzida) object).zzb();
                            iZzF6 = zzidj.zzF(iZzc);
                        } else {
                            iZzF5 = zzidj.zzF(i10);
                            iZzc = zzihf.zzc((String) object);
                            iZzF6 = zzidj.zzF(iZzc);
                        }
                        iZzF4 = iZzF5 + iZzF6 + iZzc;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 9:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzD = zzigi.zzD(i6, unsafe.getObject(obj, j), zzifsVar.zzq(i2));
                        iZzF19 += iZzD;
                    }
                    break;
                case 10:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        zzida zzidaVar = (zzida) unsafe.getObject(obj, j);
                        iZzF5 = zzidj.zzF(i6 << 3);
                        iZzc = zzidaVar.zzb();
                        iZzF6 = zzidj.zzF(iZzc);
                        iZzF4 = iZzF5 + iZzF6 + iZzc;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 11:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzF2 = zzidj.zzF(i6 << 3);
                        iZzG = zzidj.zzF(i11);
                        iZzF4 = iZzF2 + iZzG;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 12:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzF2 = zzidj.zzF(i6 << 3);
                        iZzG = zzidj.zzG(j5);
                        iZzF4 = iZzF2 + iZzG;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 13:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzF = zzidj.zzF(i6 << 3);
                        iZzF4 = iZzF + 4;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 14:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzF3 = zzidj.zzF(i6 << 3);
                        iZzF4 = iZzF3 + 8;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 15:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzF2 = zzidj.zzF(i6 << 3);
                        iZzG = zzidj.zzF((i12 >> 31) ^ (i12 + i12));
                        iZzF4 = iZzF2 + iZzG;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 16:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzF2 = zzidj.zzF(i6 << 3);
                        iZzG = zzidj.zzG((j6 >> 63) ^ (j6 + j6));
                        iZzF4 = iZzF2 + iZzG;
                        iZzF19 += iZzF4;
                    }
                    zzifsVar = this;
                    break;
                case 17:
                    if (zzifsVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzD = zzigi.zzE(i6, (zzifp) unsafe.getObject(obj, j), zzifsVar.zzq(i2));
                        iZzF19 += iZzD;
                    }
                    break;
                case 18:
                    iZzD = zzigi.zzC(i6, (List) unsafe.getObject(obj, j), false);
                    iZzF19 += iZzD;
                    break;
                case 19:
                    iZzD = zzigi.zzA(i6, (List) unsafe.getObject(obj, j), false);
                    iZzF19 += iZzD;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzigi.zza;
                    if (list.size() == 0) {
                        iZzs = 0;
                    } else {
                        iZzs = zzigi.zzs(list) + (list.size() * zzidj.zzF(i6 << 3));
                    }
                    iZzF19 += iZzs;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i14 = zzigi.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzigi.zzt(list2);
                        iZzF7 = zzidj.zzF(i6 << 3);
                        iZzG2 = size * iZzF7;
                        iZzD = iZzt + iZzG2;
                    }
                    iZzF19 += iZzD;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzigi.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzigi.zzw(list3);
                        iZzF7 = zzidj.zzF(i6 << 3);
                        iZzG2 = size * iZzF7;
                        iZzD = iZzt + iZzG2;
                    }
                    iZzF19 += iZzD;
                    break;
                case 23:
                    iZzD = zzigi.zzC(i6, (List) unsafe.getObject(obj, j), false);
                    iZzF19 += iZzD;
                    break;
                case 24:
                    iZzD = zzigi.zzA(i6, (List) unsafe.getObject(obj, j), false);
                    iZzF19 += iZzD;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i16 = zzigi.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzD = 0;
                    } else {
                        iZzD = size2 * (zzidj.zzF(i6 << 3) + 1);
                    }
                    iZzF19 += iZzD;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i17 = zzigi.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzs = 0;
                    } else {
                        iZzs = zzidj.zzF(i6 << 3) * size3;
                        if (list5 instanceof zzifa) {
                            zzifa zzifaVar = (zzifa) list5;
                            for (int i18 = 0; i18 < size3; i18++) {
                                Object objZzc = zzifaVar.zzc();
                                if (objZzc instanceof zzida) {
                                    iZzc3 = ((zzida) objZzc).zzb();
                                    iZzF9 = zzidj.zzF(iZzc3);
                                } else {
                                    iZzc3 = zzihf.zzc((String) objZzc);
                                    iZzF9 = zzidj.zzF(iZzc3);
                                }
                                iZzs += iZzF9 + iZzc3;
                            }
                        } else {
                            for (int i19 = 0; i19 < size3; i19++) {
                                Object obj2 = list5.get(i19);
                                if (obj2 instanceof zzida) {
                                    iZzc2 = ((zzida) obj2).zzb();
                                    iZzF8 = zzidj.zzF(iZzc2);
                                } else {
                                    iZzc2 = zzihf.zzc((String) obj2);
                                    iZzF8 = zzidj.zzF(iZzc2);
                                }
                                iZzs += iZzF8 + iZzc2;
                            }
                        }
                    }
                    iZzF19 += iZzs;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zzigh zzighVarZzq = zzifsVar.zzq(i2);
                    int i20 = zzigi.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzF10 = 0;
                    } else {
                        iZzF10 = zzidj.zzF(i6 << 3) * size4;
                        for (int i21 = 0; i21 < size4; i21++) {
                            Object obj3 = list6.get(i21);
                            if (obj3 instanceof zziez) {
                                iZzaT = ((zziez) obj3).zzb();
                                iZzF11 = zzidj.zzF(iZzaT);
                            } else {
                                iZzaT = ((zzicj) obj3).zzaT(zzighVarZzq);
                                iZzF11 = zzidj.zzF(iZzaT);
                            }
                            iZzF10 += iZzF11 + iZzaT;
                        }
                    }
                    iZzF19 += iZzF10;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i22 = zzigi.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzF12 = 0;
                    } else {
                        iZzF12 = size5 * zzidj.zzF(i6 << 3);
                        for (int i23 = 0; i23 < list7.size(); i23++) {
                            int iZzb = ((zzida) list7.get(i23)).zzb();
                            iZzF12 += zzidj.zzF(iZzb) + iZzb;
                        }
                    }
                    iZzF19 += iZzF12;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzigi.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzigi.zzx(list8);
                        iZzF7 = zzidj.zzF(i6 << 3);
                        iZzG2 = size * iZzF7;
                        iZzD = iZzt + iZzG2;
                    }
                    iZzF19 += iZzD;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzigi.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzigi.zzv(list9);
                        iZzF7 = zzidj.zzF(i6 << 3);
                        iZzG2 = size * iZzF7;
                        iZzD = iZzt + iZzG2;
                    }
                    iZzF19 += iZzD;
                    break;
                case 31:
                    iZzD = zzigi.zzA(i6, (List) unsafe.getObject(obj, j), false);
                    iZzF19 += iZzD;
                    break;
                case 32:
                    iZzD = zzigi.zzC(i6, (List) unsafe.getObject(obj, j), false);
                    iZzF19 += iZzD;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i26 = zzigi.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzigi.zzy(list10);
                        iZzF7 = zzidj.zzF(i6 << 3);
                        iZzG2 = size * iZzF7;
                        iZzD = iZzt + iZzG2;
                    }
                    iZzF19 += iZzD;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i27 = zzigi.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzD = 0;
                    } else {
                        iZzt = zzigi.zzu(list11);
                        iZzF7 = zzidj.zzF(i6 << 3);
                        iZzG2 = size * iZzF7;
                        iZzD = iZzt + iZzG2;
                    }
                    iZzF19 += iZzD;
                    break;
                case 35:
                    iZzB = zzigi.zzB((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 36:
                    iZzB = zzigi.zzz((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 37:
                    iZzB = zzigi.zzs((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 38:
                    iZzB = zzigi.zzt((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 39:
                    iZzB = zzigi.zzw((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 40:
                    iZzB = zzigi.zzB((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 41:
                    iZzB = zzigi.zzz((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i28 = zzigi.zza;
                    iZzB = list12.size();
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 43:
                    iZzB = zzigi.zzx((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 44:
                    iZzB = zzigi.zzv((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 45:
                    iZzB = zzigi.zzz((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 46:
                    iZzB = zzigi.zzB((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 47:
                    iZzB = zzigi.zzy((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 48:
                    iZzB = zzigi.zzu((List) unsafe.getObject(obj, j));
                    if (iZzB > 0) {
                        iZzF13 = zzidj.zzF(i6 << 3);
                        iZzF14 = zzidj.zzF(iZzB);
                        iZzF12 = iZzF13 + iZzF14 + iZzB;
                        iZzF19 += iZzF12;
                    }
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    zzigh zzighVarZzq2 = zzifsVar.zzq(i2);
                    int i29 = zzigi.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzE = 0;
                    } else {
                        iZzE = 0;
                        for (int i30 = 0; i30 < size6; i30++) {
                            iZzE += zzigi.zzE(i6, (zzifp) list13.get(i30), zzighVarZzq2);
                        }
                    }
                    iZzF19 += iZzE;
                    break;
                case 50:
                    zzifj zzifjVar = (zzifj) unsafe.getObject(obj, j);
                    zzifi zzifiVar = (zzifi) zzifsVar.zzr(i2);
                    if (zzifjVar.isEmpty()) {
                        iZzs = 0;
                    } else {
                        iZzs = 0;
                        for (Map.Entry entry2 : zzifjVar.entrySet()) {
                            iZzs += zzifiVar.zzd(i6, entry2.getKey(), entry2.getValue());
                        }
                    }
                    iZzF19 += iZzs;
                    break;
                case 51:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        iZzF15 = zzidj.zzF(i6 << 3);
                        iZzD = iZzF15 + 8;
                        iZzF19 += iZzD;
                    }
                    break;
                case 52:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        iZzF16 = zzidj.zzF(i6 << 3);
                        iZzD = iZzF16 + 4;
                        iZzF19 += iZzD;
                    }
                    break;
                case 53:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        long jZzH = zzH(obj, j);
                        iZzt = zzidj.zzF(i6 << 3);
                        iZzG2 = zzidj.zzG(jZzH);
                        iZzD = iZzt + iZzG2;
                        iZzF19 += iZzD;
                    }
                    break;
                case 54:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        long jZzH2 = zzH(obj, j);
                        iZzt = zzidj.zzF(i6 << 3);
                        iZzG2 = zzidj.zzG(jZzH2);
                        iZzD = iZzt + iZzG2;
                        iZzF19 += iZzD;
                    }
                    break;
                case 55:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        long jZzG = zzG(obj, j);
                        iZzt = zzidj.zzF(i6 << 3);
                        iZzG2 = zzidj.zzG(jZzG);
                        iZzD = iZzt + iZzG2;
                        iZzF19 += iZzD;
                    }
                    break;
                case 56:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        iZzF15 = zzidj.zzF(i6 << 3);
                        iZzD = iZzF15 + 8;
                        iZzF19 += iZzD;
                    }
                    break;
                case 57:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        iZzF16 = zzidj.zzF(i6 << 3);
                        iZzD = iZzF16 + 4;
                        iZzF19 += iZzD;
                    }
                    break;
                case 58:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        iZzD = zzidj.zzF(i6 << 3) + 1;
                        iZzF19 += iZzD;
                    }
                    break;
                case 59:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        int i31 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzida) {
                            iZzF17 = zzidj.zzF(i31);
                            iZzc4 = ((zzida) object2).zzb();
                            iZzF18 = zzidj.zzF(iZzc4);
                        } else {
                            iZzF17 = zzidj.zzF(i31);
                            iZzc4 = zzihf.zzc((String) object2);
                            iZzF18 = zzidj.zzF(iZzc4);
                        }
                        iZzD = iZzF17 + iZzF18 + iZzc4;
                        iZzF19 += iZzD;
                    }
                    break;
                case 60:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        iZzD = zzigi.zzD(i6, unsafe.getObject(obj, j), zzifsVar.zzq(i2));
                        iZzF19 += iZzD;
                    }
                    break;
                case 61:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        zzida zzidaVar2 = (zzida) unsafe.getObject(obj, j);
                        iZzF17 = zzidj.zzF(i6 << 3);
                        iZzc4 = zzidaVar2.zzb();
                        iZzF18 = zzidj.zzF(iZzc4);
                        iZzD = iZzF17 + iZzF18 + iZzc4;
                        iZzF19 += iZzD;
                    }
                    break;
                case 62:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        int iZzG3 = zzG(obj, j);
                        iZzt = zzidj.zzF(i6 << 3);
                        iZzG2 = zzidj.zzF(iZzG3);
                        iZzD = iZzt + iZzG2;
                        iZzF19 += iZzD;
                    }
                    break;
                case 63:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        long jZzG2 = zzG(obj, j);
                        iZzt = zzidj.zzF(i6 << 3);
                        iZzG2 = zzidj.zzG(jZzG2);
                        iZzD = iZzt + iZzG2;
                        iZzF19 += iZzD;
                    }
                    break;
                case 64:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        iZzF16 = zzidj.zzF(i6 << 3);
                        iZzD = iZzF16 + 4;
                        iZzF19 += iZzD;
                    }
                    break;
                case 65:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        iZzF15 = zzidj.zzF(i6 << 3);
                        iZzD = iZzF15 + 8;
                        iZzF19 += iZzD;
                    }
                    break;
                case 66:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        int iZzG4 = zzG(obj, j);
                        iZzt = zzidj.zzF(i6 << 3);
                        iZzG2 = zzidj.zzF((iZzG4 >> 31) ^ (iZzG4 + iZzG4));
                        iZzD = iZzt + iZzG2;
                        iZzF19 += iZzD;
                    }
                    break;
                case 67:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        long jZzH3 = zzH(obj, j);
                        iZzt = zzidj.zzF(i6 << 3);
                        iZzG2 = zzidj.zzG((jZzH3 >> 63) ^ (jZzH3 + jZzH3));
                        iZzD = iZzt + iZzG2;
                        iZzF19 += iZzD;
                    }
                    break;
                case 68:
                    if (zzifsVar.zzM(obj, i6, i2)) {
                        iZzD = zzigi.zzE(i6, (zzifp) unsafe.getObject(obj, j), zzifsVar.zzq(i2));
                        iZzF19 += iZzD;
                    }
                    break;
            }
            i2 += 3;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzf(Object obj, zzihi zzihiVar) throws IOException {
        Map.Entry entry;
        Iterator it;
        boolean z;
        int i;
        int i2;
        int i3;
        zzifs<T> zzifsVar = this;
        if (zzifsVar.zzh) {
            zzidt zzidtVar = ((zziea) obj).zza;
            if (zzidtVar.zza.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itZzc = zzidtVar.zzc();
                entry = (Map.Entry) itZzc.next();
                it = itZzc;
            }
        } else {
            entry = null;
            it = null;
        }
        int[] iArr = zzifsVar.zzc;
        Unsafe unsafe = zzb;
        int i4 = 1048575;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        while (i6 < iArr.length) {
            int iZzA = zzifsVar.zzA(i6);
            int iZzC = zzC(iZzA);
            int i8 = iArr[i6];
            if (iZzC <= 17) {
                int i9 = iArr[i6 + 2];
                z = true;
                int i10 = i9 & i4;
                if (i10 != i5) {
                    i7 = i10 == i4 ? 0 : unsafe.getInt(obj, i10);
                    i5 = i10;
                }
                i = i5;
                i2 = i7;
                i3 = 1 << (i9 >>> 20);
            } else {
                z = true;
                i = i5;
                i2 = i7;
                i3 = 0;
            }
            while (true) {
                if (entry != null) {
                    zzidp zzidpVar = zzifsVar.zzn;
                    i4 = i4;
                    if (((zzieb) entry.getKey()).zza <= i8) {
                        zzidpVar.zzb(zzihiVar, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                } else {
                    i4 = i4;
                }
            }
            long j = iZzA & i4;
            switch (iZzC) {
                case 0:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzf(i8, zziha.zzk(obj, j));
                    }
                    break;
                case 1:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zze(i8, zziha.zzi(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 2:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzc(i8, unsafe.getLong(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 3:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzh(i8, unsafe.getLong(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 4:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzi(i8, unsafe.getInt(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 5:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzj(i8, unsafe.getLong(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 6:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzk(i8, unsafe.getInt(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 7:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzl(i8, zziha.zzg(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 8:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzS(i8, unsafe.getObject(obj, j), zzihiVar);
                    }
                    zzifsVar = this;
                    break;
                case 9:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzr(i8, unsafe.getObject(obj, j), zzifsVar.zzq(i6));
                    }
                    break;
                case 10:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzn(i8, (zzida) unsafe.getObject(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 11:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzo(i8, unsafe.getInt(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 12:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzg(i8, unsafe.getInt(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 13:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzb(i8, unsafe.getInt(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 14:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzd(i8, unsafe.getLong(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 15:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzp(i8, unsafe.getInt(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 16:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzq(i8, unsafe.getLong(obj, j));
                    }
                    zzifsVar = this;
                    break;
                case 17:
                    if (zzifsVar.zzJ(obj, i6, i, i2, i3)) {
                        zzihiVar.zzs(i8, unsafe.getObject(obj, j), zzifsVar.zzq(i6));
                    }
                    break;
                case 18:
                    zzigi.zza(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 19:
                    zzigi.zzb(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 20:
                    zzigi.zzc(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 21:
                    zzigi.zzd(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 22:
                    zzigi.zzh(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 23:
                    zzigi.zzf(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 24:
                    zzigi.zzk(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 25:
                    zzigi.zzn(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 26:
                    zzigi.zzo(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar);
                    break;
                case 27:
                    zzigi.zzq(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, zzifsVar.zzq(i6));
                    break;
                case 28:
                    zzigi.zzp(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar);
                    break;
                case 29:
                    zzigi.zzi(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 30:
                    zzigi.zzm(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 31:
                    zzigi.zzl(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 32:
                    zzigi.zzg(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 33:
                    zzigi.zzj(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 34:
                    zzigi.zze(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, false);
                    break;
                case 35:
                    zzigi.zza(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 36:
                    zzigi.zzb(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 37:
                    zzigi.zzc(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 38:
                    zzigi.zzd(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 39:
                    zzigi.zzh(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 40:
                    zzigi.zzf(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 41:
                    zzigi.zzk(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 42:
                    zzigi.zzn(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 43:
                    zzigi.zzi(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 44:
                    zzigi.zzm(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 45:
                    zzigi.zzl(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 46:
                    zzigi.zzg(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 47:
                    zzigi.zzj(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 48:
                    zzigi.zze(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, z);
                    break;
                case 49:
                    zzigi.zzr(iArr[i6], (List) unsafe.getObject(obj, j), zzihiVar, zzifsVar.zzq(i6));
                    break;
                case 50:
                    Object object = unsafe.getObject(obj, j);
                    if (object != null) {
                        zzihiVar.zzM(i8, ((zzifi) zzifsVar.zzr(i6)).zze(), (zzifj) object);
                    }
                    break;
                case 51:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzf(i8, ((Double) zziha.zzm(obj, j)).doubleValue());
                    }
                    break;
                case 52:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zze(i8, ((Float) zziha.zzm(obj, j)).floatValue());
                    }
                    break;
                case 53:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzc(i8, zzH(obj, j));
                    }
                    break;
                case 54:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzh(i8, zzH(obj, j));
                    }
                    break;
                case 55:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzi(i8, zzG(obj, j));
                    }
                    break;
                case 56:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzj(i8, zzH(obj, j));
                    }
                    break;
                case 57:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzk(i8, zzG(obj, j));
                    }
                    break;
                case 58:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzl(i8, ((Boolean) zziha.zzm(obj, j)).booleanValue());
                    }
                    break;
                case 59:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzS(i8, unsafe.getObject(obj, j), zzihiVar);
                    }
                    break;
                case 60:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzr(i8, unsafe.getObject(obj, j), zzifsVar.zzq(i6));
                    }
                    break;
                case 61:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzn(i8, (zzida) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzo(i8, zzG(obj, j));
                    }
                    break;
                case 63:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzg(i8, zzG(obj, j));
                    }
                    break;
                case 64:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzb(i8, zzG(obj, j));
                    }
                    break;
                case 65:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzd(i8, zzH(obj, j));
                    }
                    break;
                case 66:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzp(i8, zzG(obj, j));
                    }
                    break;
                case 67:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzq(i8, zzH(obj, j));
                    }
                    break;
                case 68:
                    if (zzifsVar.zzM(obj, i8, i6)) {
                        zzihiVar.zzs(i8, unsafe.getObject(obj, j), zzifsVar.zzq(i6));
                    }
                    break;
                default:
                    break;
            }
            i6 += 3;
            i7 = i2;
            i4 = i4;
            i5 = i;
            entry = entry;
        }
        while (entry != null) {
            zzifsVar.zzn.zzb(zzihiVar, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        ((zziee) obj).zzt.zzg(zzihiVar);
    }

    /* JADX WARN: Code duplicated, block: B:179:0x057c A[LOOP:3: B:177:0x0578->B:179:0x057c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:181:0x058c  */
    /* JADX WARN: Code duplicated, block: B:192:0x05a1 A[LOOP:1: B:190:0x059d->B:192:0x05a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:195:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:206:0x056a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:295:0x0575 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:304:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:305:? A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzg(Object obj, zzigc zzigcVar, zzido zzidoVar) throws Throwable {
        zzifs<T> zzifsVar;
        Object obj2;
        Throwable th;
        int i;
        Object objZzx;
        zzigt zzigtVar;
        Object objZzx2;
        Object obj3;
        int i2;
        zzidoVar.getClass();
        zzF(obj);
        zzigt zzigtVar2 = this.zzm;
        Object objZzh = null;
        while (true) {
            try {
                int iZzb = zzigcVar.zzb();
                int iZzP = zzP(iZzb);
                if (iZzP >= 0) {
                    obj3 = obj;
                    zzifsVar = this;
                    try {
                        int iZzA = zzA(iZzP);
                        try {
                            switch (zzC(iZzA)) {
                                case 0:
                                    obj2 = obj3;
                                    zziha.zzl(obj2, iZzA & 1048575, zzigcVar.zze());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 1:
                                    obj2 = obj3;
                                    zziha.zzj(obj2, iZzA & 1048575, zzigcVar.zzf());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 2:
                                    obj2 = obj3;
                                    zziha.zzf(obj2, iZzA & 1048575, zzigcVar.zzh());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 3:
                                    obj2 = obj3;
                                    zziha.zzf(obj2, iZzA & 1048575, zzigcVar.zzg());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 4:
                                    obj2 = obj3;
                                    zziha.zzd(obj2, iZzA & 1048575, zzigcVar.zzi());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 5:
                                    obj2 = obj3;
                                    zziha.zzf(obj2, iZzA & 1048575, zzigcVar.zzj());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 6:
                                    obj2 = obj3;
                                    zziha.zzd(obj2, iZzA & 1048575, zzigcVar.zzk());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 7:
                                    obj2 = obj3;
                                    zziha.zzh(obj2, iZzA & 1048575, zzigcVar.zzl());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 8:
                                    obj2 = obj3;
                                    zzz(obj2, iZzA, zzigcVar);
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 9:
                                    obj2 = obj3;
                                    zzifp zzifpVar = (zzifp) zzt(obj2, iZzP);
                                    zzigcVar.zzo(zzifpVar, zzq(iZzP), zzidoVar);
                                    zzu(obj2, iZzP, zzifpVar);
                                    obj = obj2;
                                    break;
                                case 10:
                                    obj2 = obj3;
                                    zziha.zzn(obj2, iZzA & 1048575, zzigcVar.zzq());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 11:
                                    obj2 = obj3;
                                    zziha.zzd(obj2, iZzA & 1048575, zzigcVar.zzr());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 12:
                                    obj2 = obj3;
                                    int iZzs = zzigcVar.zzs();
                                    zziek zziekVarZzs = zzs(iZzP);
                                    if (zziekVarZzs == null || zziekVarZzs.zza(iZzs)) {
                                        zziha.zzd(obj2, iZzA & 1048575, iZzs);
                                        zzL(obj2, iZzP);
                                    } else {
                                        objZzh = zzigi.zzK(obj2, iZzb, iZzs, objZzh, zzigtVar2);
                                    }
                                    obj = obj2;
                                    break;
                                case 13:
                                    obj2 = obj3;
                                    zziha.zzd(obj2, iZzA & 1048575, zzigcVar.zzt());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 14:
                                    obj2 = obj3;
                                    zziha.zzf(obj2, iZzA & 1048575, zzigcVar.zzu());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 15:
                                    obj2 = obj3;
                                    zziha.zzd(obj2, iZzA & 1048575, zzigcVar.zzv());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 16:
                                    obj2 = obj3;
                                    zziha.zzf(obj2, iZzA & 1048575, zzigcVar.zzw());
                                    zzL(obj2, iZzP);
                                    obj = obj2;
                                    break;
                                case 17:
                                    obj2 = obj3;
                                    zzifp zzifpVar2 = (zzifp) zzt(obj2, iZzP);
                                    zzigcVar.zzp(zzifpVar2, zzq(iZzP), zzidoVar);
                                    zzu(obj2, iZzP, zzifpVar2);
                                    obj = obj2;
                                    break;
                                case 18:
                                    obj2 = obj3;
                                    zzigcVar.zzx(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 19:
                                    obj2 = obj3;
                                    zzigcVar.zzy(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 20:
                                    obj2 = obj3;
                                    zzigcVar.zzA(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 21:
                                    obj2 = obj3;
                                    zzigcVar.zzz(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 22:
                                    obj2 = obj3;
                                    zzigcVar.zzB(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 23:
                                    obj2 = obj3;
                                    zzigcVar.zzC(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 24:
                                    obj2 = obj3;
                                    zzigcVar.zzD(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 25:
                                    obj2 = obj3;
                                    zzigcVar.zzE(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 26:
                                    obj2 = obj3;
                                    if (zzD(iZzA)) {
                                        ((zzidf) zzigcVar).zzF(zzifb.zza(obj2, iZzA & 1048575), true);
                                    } else {
                                        ((zzidf) zzigcVar).zzF(zzifb.zza(obj2, iZzA & 1048575), false);
                                    }
                                    obj = obj2;
                                    break;
                                case 27:
                                    obj2 = obj3;
                                    zzigcVar.zzG(zzifb.zza(obj2, iZzA & 1048575), zzq(iZzP), zzidoVar);
                                    obj = obj2;
                                    break;
                                case 28:
                                    obj2 = obj3;
                                    zzigcVar.zzI(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 29:
                                    obj2 = obj3;
                                    zzigcVar.zzJ(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 30:
                                    List listZza = zzifb.zza(obj3, iZzA & 1048575);
                                    zzigcVar.zzK(listZza);
                                    objZzh = zzigi.zzJ(obj3, iZzb, listZza, zzs(iZzP), objZzh, zzigtVar2);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 31:
                                    obj2 = obj3;
                                    zzigcVar.zzL(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 32:
                                    obj2 = obj3;
                                    zzigcVar.zzM(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 33:
                                    obj2 = obj3;
                                    zzigcVar.zzN(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 34:
                                    obj2 = obj3;
                                    zzigcVar.zzO(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 35:
                                    obj2 = obj3;
                                    zzigcVar.zzx(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 36:
                                    obj2 = obj3;
                                    zzigcVar.zzy(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 37:
                                    obj2 = obj3;
                                    zzigcVar.zzA(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 38:
                                    obj2 = obj3;
                                    zzigcVar.zzz(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 39:
                                    obj2 = obj3;
                                    zzigcVar.zzB(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 40:
                                    obj2 = obj3;
                                    zzigcVar.zzC(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 41:
                                    obj2 = obj3;
                                    zzigcVar.zzD(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 42:
                                    obj2 = obj3;
                                    zzigcVar.zzE(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 43:
                                    obj2 = obj3;
                                    zzigcVar.zzJ(zzifb.zza(obj2, iZzA & 1048575));
                                    obj = obj2;
                                    break;
                                case 44:
                                    try {
                                        List listZza2 = zzifb.zza(obj3, iZzA & 1048575);
                                        zzigcVar.zzK(listZza2);
                                        try {
                                            objZzh = zzigi.zzJ(obj3, iZzb, listZza2, zzs(iZzP), objZzh, zzigtVar2);
                                            obj2 = obj3;
                                        } catch (zzies unused) {
                                            obj2 = obj3;
                                            if (objZzh == null) {
                                                try {
                                                    objZzh = zzigtVar2.zzh(obj2);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    th = th;
                                                    i = zzifsVar.zzk;
                                                    objZzx = objZzh;
                                                    while (i < zzifsVar.zzl) {
                                                        zzigt zzigtVar3 = zzigtVar2;
                                                        objZzx = zzifsVar.zzx(obj2, zzifsVar.zzj[i], objZzx, zzigtVar3, obj2);
                                                        i++;
                                                        zzifsVar = this;
                                                        zzigtVar2 = zzigtVar3;
                                                    }
                                                    zzigtVar = zzigtVar2;
                                                    if (objZzx == null) {
                                                        throw th;
                                                    }
                                                    zzigtVar.zzi(obj2, objZzx);
                                                    throw th;
                                                }
                                            }
                                            if (!zzigtVar2.zzk(objZzh, zzigcVar, 0)) {
                                                objZzx2 = objZzh;
                                                for (i2 = zzifsVar.zzk; i2 < zzifsVar.zzl; i2++) {
                                                    zzigt zzigtVar4 = zzigtVar2;
                                                    objZzx2 = zzifsVar.zzx(obj2, zzifsVar.zzj[i2], objZzx2, zzigtVar4, obj2);
                                                    zzigtVar2 = zzigtVar4;
                                                }
                                                if (objZzx2 != null) {
                                                    zzigtVar2.zzi(obj2, objZzx2);
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            th = th3;
                                            obj2 = obj3;
                                            th = th;
                                            zzifsVar = zzifsVar;
                                            i = zzifsVar.zzk;
                                            objZzx = objZzh;
                                            while (i < zzifsVar.zzl) {
                                                zzigt zzigtVar5 = zzigtVar2;
                                                objZzx = zzifsVar.zzx(obj2, zzifsVar.zzj[i], objZzx, zzigtVar5, obj2);
                                                i++;
                                                zzifsVar = this;
                                                zzigtVar2 = zzigtVar5;
                                            }
                                            zzigtVar = zzigtVar2;
                                            if (objZzx == null) {
                                                throw th;
                                            }
                                            zzigtVar.zzi(obj2, objZzx);
                                            throw th;
                                        }
                                        obj = obj2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        obj2 = obj3;
                                    }
                                    break;
                                case 45:
                                    zzigcVar.zzL(zzifb.zza(obj3, iZzA & 1048575));
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 46:
                                    zzigcVar.zzM(zzifb.zza(obj3, iZzA & 1048575));
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 47:
                                    zzigcVar.zzN(zzifb.zza(obj3, iZzA & 1048575));
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 48:
                                    zzigcVar.zzO(zzifb.zza(obj3, iZzA & 1048575));
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 49:
                                    zzigcVar.zzH(zzifb.zza(obj3, iZzA & 1048575), zzq(iZzP), zzidoVar);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 50:
                                    Object objZzr = zzr(iZzP);
                                    long jZzA = zzA(iZzP) & 1048575;
                                    Object objZzm = zziha.zzm(obj3, jZzA);
                                    if (objZzm == null) {
                                        objZzm = zzifj.zza().zzc();
                                        zziha.zzn(obj3, jZzA, objZzm);
                                    } else if (zzifk.zza(objZzm)) {
                                        Object objZzc = zzifj.zza().zzc();
                                        zzifk.zzb(objZzc, objZzm);
                                        zziha.zzn(obj3, jZzA, objZzc);
                                        objZzm = objZzc;
                                    }
                                    zzigcVar.zzP((zzifj) objZzm, ((zzifi) objZzr).zze(), zzidoVar);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 51:
                                    zziha.zzn(obj3, iZzA & 1048575, Double.valueOf(zzigcVar.zze()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 52:
                                    zziha.zzn(obj3, iZzA & 1048575, Float.valueOf(zzigcVar.zzf()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 53:
                                    zziha.zzn(obj3, iZzA & 1048575, Long.valueOf(zzigcVar.zzh()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 54:
                                    zziha.zzn(obj3, iZzA & 1048575, Long.valueOf(zzigcVar.zzg()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 55:
                                    zziha.zzn(obj3, iZzA & 1048575, Integer.valueOf(zzigcVar.zzi()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 56:
                                    zziha.zzn(obj3, iZzA & 1048575, Long.valueOf(zzigcVar.zzj()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 57:
                                    zziha.zzn(obj3, iZzA & 1048575, Integer.valueOf(zzigcVar.zzk()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 58:
                                    zziha.zzn(obj3, iZzA & 1048575, Boolean.valueOf(zzigcVar.zzl()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 59:
                                    zzz(obj3, iZzA, zzigcVar);
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 60:
                                    zzifp zzifpVar3 = (zzifp) zzv(obj3, iZzb, iZzP);
                                    zzigcVar.zzo(zzifpVar3, zzq(iZzP), zzidoVar);
                                    zzw(obj3, iZzb, iZzP, zzifpVar3);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 61:
                                    zziha.zzn(obj3, iZzA & 1048575, zzigcVar.zzq());
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 62:
                                    zziha.zzn(obj3, iZzA & 1048575, Integer.valueOf(zzigcVar.zzr()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 63:
                                    int iZzs2 = zzigcVar.zzs();
                                    zziek zziekVarZzs2 = zzs(iZzP);
                                    if (zziekVarZzs2 != null && !zziekVarZzs2.zza(iZzs2)) {
                                        objZzh = zzigi.zzK(obj3, iZzb, iZzs2, objZzh, zzigtVar2);
                                        obj = obj3;
                                    }
                                    zziha.zzn(obj3, iZzA & 1048575, Integer.valueOf(iZzs2));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 64:
                                    zziha.zzn(obj3, iZzA & 1048575, Integer.valueOf(zzigcVar.zzt()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 65:
                                    zziha.zzn(obj3, iZzA & 1048575, Long.valueOf(zzigcVar.zzu()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 66:
                                    zziha.zzn(obj3, iZzA & 1048575, Integer.valueOf(zzigcVar.zzv()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 67:
                                    zziha.zzn(obj3, iZzA & 1048575, Long.valueOf(zzigcVar.zzw()));
                                    zzO(obj3, iZzb, iZzP);
                                    obj2 = obj3;
                                    obj = obj2;
                                    break;
                                case 68:
                                    try {
                                        zzifp zzifpVar4 = (zzifp) zzv(obj3, iZzb, iZzP);
                                        zzigcVar.zzp(zzifpVar4, zzq(iZzP), zzidoVar);
                                        zzw(obj3, iZzb, iZzP, zzifpVar4);
                                        obj2 = obj3;
                                        obj = obj2;
                                    } catch (Throwable th5) {
                                        th = th5;
                                        zzifsVar = zzifsVar;
                                        obj2 = obj3;
                                        i = zzifsVar.zzk;
                                        objZzx = objZzh;
                                        while (i < zzifsVar.zzl) {
                                            zzigt zzigtVar6 = zzigtVar2;
                                            objZzx = zzifsVar.zzx(obj2, zzifsVar.zzj[i], objZzx, zzigtVar6, obj2);
                                            i++;
                                            zzifsVar = this;
                                            zzigtVar2 = zzigtVar6;
                                        }
                                        zzigtVar = zzigtVar2;
                                        if (objZzx == null) {
                                            throw th;
                                        }
                                        zzigtVar.zzi(obj2, objZzx);
                                        throw th;
                                    }
                                    break;
                                default:
                                    obj2 = obj3;
                                    if (objZzh == null) {
                                        try {
                                            try {
                                                objZzh = zzigtVar2.zzh(obj2);
                                            } catch (Throwable th6) {
                                                th = th6;
                                                th = th;
                                                zzifsVar = zzifsVar;
                                                i = zzifsVar.zzk;
                                                objZzx = objZzh;
                                                while (i < zzifsVar.zzl) {
                                                    zzigt zzigtVar7 = zzigtVar2;
                                                    objZzx = zzifsVar.zzx(obj2, zzifsVar.zzj[i], objZzx, zzigtVar7, obj2);
                                                    i++;
                                                    zzifsVar = this;
                                                    zzigtVar2 = zzigtVar7;
                                                }
                                                zzigtVar = zzigtVar2;
                                                if (objZzx == null) {
                                                    throw th;
                                                }
                                                zzigtVar.zzi(obj2, objZzx);
                                                throw th;
                                            }
                                        } catch (zzies unused2) {
                                            if (objZzh == null) {
                                                objZzh = zzigtVar2.zzh(obj2);
                                            }
                                            if (!zzigtVar2.zzk(objZzh, zzigcVar, 0)) {
                                                objZzx2 = objZzh;
                                                while (i2 < zzifsVar.zzl) {
                                                    zzigt zzigtVar8 = zzigtVar2;
                                                    objZzx2 = zzifsVar.zzx(obj2, zzifsVar.zzj[i2], objZzx2, zzigtVar8, obj2);
                                                    zzigtVar2 = zzigtVar8;
                                                }
                                                if (objZzx2 != null) {
                                                    zzigtVar2.zzi(obj2, objZzx2);
                                                }
                                            }
                                        }
                                    }
                                    try {
                                        if (zzigtVar2.zzk(objZzh, zzigcVar, 0)) {
                                            obj = obj2;
                                        } else {
                                            objZzx2 = objZzh;
                                            for (int i3 = zzifsVar.zzk; i3 < zzifsVar.zzl; i3++) {
                                                zzigt zzigtVar9 = zzigtVar2;
                                                objZzx2 = zzifsVar.zzx(obj2, zzifsVar.zzj[i3], objZzx2, zzigtVar9, obj2);
                                                zzigtVar2 = zzigtVar9;
                                            }
                                        }
                                    } catch (Throwable th7) {
                                        th = th7;
                                        zzifsVar = zzifsVar;
                                        th = th;
                                        i = zzifsVar.zzk;
                                        objZzx = objZzh;
                                        while (i < zzifsVar.zzl) {
                                            zzigt zzigtVar10 = zzigtVar2;
                                            objZzx = zzifsVar.zzx(obj2, zzifsVar.zzj[i], objZzx, zzigtVar10, obj2);
                                            i++;
                                            zzifsVar = this;
                                            zzigtVar2 = zzigtVar10;
                                        }
                                        zzigtVar = zzigtVar2;
                                        if (objZzx == null) {
                                            throw th;
                                        }
                                        zzigtVar.zzi(obj2, objZzx);
                                        throw th;
                                    }
                                    break;
                            }
                        } catch (zzies unused3) {
                            obj2 = obj3;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        zzifsVar = zzifsVar;
                        obj2 = obj3;
                    }
                } else if (iZzb == Integer.MAX_VALUE) {
                    objZzx2 = objZzh;
                    for (int i4 = this.zzk; i4 < this.zzl; i4++) {
                        zzigt zzigtVar11 = zzigtVar2;
                        objZzx2 = zzx(obj, this.zzj[i4], objZzx2, zzigtVar11, obj);
                        zzigtVar2 = zzigtVar11;
                    }
                    obj2 = obj;
                } else {
                    zzifsVar = this;
                    try {
                        if ((!zzifsVar.zzh ? null : zzidoVar.zzc(zzifsVar.zzg, iZzb)) != null) {
                            obj3 = obj;
                            zzifsVar = zzifsVar;
                            throw null;
                        }
                        if (objZzh == null) {
                            try {
                                objZzh = zzigtVar2.zzh(obj);
                            } catch (Throwable th9) {
                                th = th9;
                                obj2 = obj;
                                i = zzifsVar.zzk;
                                objZzx = objZzh;
                                while (i < zzifsVar.zzl) {
                                    zzigt zzigtVar12 = zzigtVar2;
                                    objZzx = zzifsVar.zzx(obj2, zzifsVar.zzj[i], objZzx, zzigtVar12, obj2);
                                    i++;
                                    zzifsVar = this;
                                    zzigtVar2 = zzigtVar12;
                                }
                                zzigtVar = zzigtVar2;
                                if (objZzx == null) {
                                    throw th;
                                }
                                zzigtVar.zzi(obj2, objZzx);
                                throw th;
                            }
                        }
                        if (zzigtVar2.zzk(objZzh, zzigcVar, 0)) {
                            obj3 = obj;
                            obj = obj3;
                        } else {
                            int i5 = zzifsVar.zzk;
                            objZzx2 = objZzh;
                            while (i5 < zzifsVar.zzl) {
                                zzigt zzigtVar13 = zzigtVar2;
                                Object obj4 = obj;
                                objZzx2 = zzifsVar.zzx(obj4, zzifsVar.zzj[i5], objZzx2, zzigtVar13, obj);
                                zzigtVar2 = zzigtVar13;
                                i5++;
                                obj = obj4;
                            }
                            obj2 = obj;
                        }
                    } catch (Throwable th10) {
                        obj3 = obj;
                        th = th10;
                        obj2 = obj3;
                        i = zzifsVar.zzk;
                        objZzx = objZzh;
                        while (i < zzifsVar.zzl) {
                            zzigt zzigtVar14 = zzigtVar2;
                            objZzx = zzifsVar.zzx(obj2, zzifsVar.zzj[i], objZzx, zzigtVar14, obj2);
                            i++;
                            zzifsVar = this;
                            zzigtVar2 = zzigtVar14;
                        }
                        zzigtVar = zzigtVar2;
                        if (objZzx == null) {
                            throw th;
                        }
                        zzigtVar.zzi(obj2, objZzx);
                        throw th;
                    }
                }
            } catch (Throwable th11) {
                th = th11;
                zzifsVar = this;
                obj2 = obj;
            }
        }
        if (objZzx2 != null) {
            zzigtVar2.zzi(obj2, objZzx2);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 36661. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zzi(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.ads.zzico r40) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3666
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzifs.zzi(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzico):int");
    }

    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzj(Object obj, byte[] bArr, int i, int i2, zzico zzicoVar) throws IOException {
        zzi(obj, bArr, i, i2, 0, zzicoVar);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzigh
    public final void zzk(Object obj) {
        if (zzE(obj)) {
            if (obj instanceof zziee) {
                zziee zzieeVar = (zziee) obj;
                zzieeVar.zzbq();
                zzieeVar.zzbb();
                zzieeVar.zzaY();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzA = zzA(i);
                int i2 = 1048575 & iZzA;
                int iZzC = zzC(iZzA);
                long j = i2;
                if (iZzC != 9) {
                    if (iZzC != 60 && iZzC != 68) {
                        switch (iZzC) {
                            case 17:
                                if (zzK(obj, i)) {
                                    zzq(i).zzk(zzb.getObject(obj, j));
                                }
                                break;
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                ((zzieq) zziha.zzm(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzifj) object).zzd();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzq(i).zzk(zzb.getObject(obj, j));
                    }
                } else if (zzK(obj, i)) {
                    zzq(i).zzk(zzb.getObject(obj, j));
                }
            }
            this.zzm.zzj(obj);
            if (this.zzh) {
                this.zzn.zza(obj);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00be  */
    /* JADX WARN: Code duplicated, block: B:51:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e3 A[LOOP:2: B:52:0x00d2->B:57:0x00e3, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:74:0x00e2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x00f7 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzigh
    public final boolean zzl(Object obj) {
        int i;
        int i2;
        List list;
        zzigh zzighVarZzq;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i4 < this.zzk) {
            int i7 = this.zzj[i4];
            int iZzA = zzA(i7);
            int[] iArr = this.zzc;
            int i8 = iArr[i7 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i6) {
                if (i9 != 1048575) {
                    i5 = zzb.getInt(obj, i9);
                }
                i2 = i5;
                i = i9;
            } else {
                i = i6;
                i2 = i5;
            }
            Object obj2 = obj;
            if ((268435456 & iZzA) != 0 && !zzJ(obj2, i7, i, i2, i10)) {
                return false;
            }
            int iZzC = zzC(iZzA);
            if (iZzC == 9 || iZzC == 17) {
                if (zzJ(obj2, i7, i, i2, i10) && !zzy(obj2, iZzA, zzq(i7))) {
                    return false;
                }
            } else if (iZzC == 27) {
                list = (List) zziha.zzm(obj2, iZzA & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzighVarZzq = zzq(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzighVarZzq.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzC == 60 || iZzC == 68) {
                if (zzM(obj2, iArr[i7], i7) && !zzy(obj2, iZzA, zzq(i7))) {
                    return false;
                }
            } else if (iZzC == 49) {
                list = (List) zziha.zzm(obj2, iZzA & 1048575);
                if (list.isEmpty()) {
                    zzighVarZzq = zzq(i7);
                    while (i3 < list.size()) {
                        if (!zzighVarZzq.zzl(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzC != 50) {
                continue;
            } else {
                zzifj zzifjVar = (zzifj) zziha.zzm(obj2, iZzA & 1048575);
                if (!zzifjVar.isEmpty() && ((zzifi) zzr(i7)).zze().zzc.zza() == zzihh.MESSAGE) {
                    zzigh zzighVarZzb = null;
                    for (Object obj3 : zzifjVar.values()) {
                        if (zzighVarZzb == null) {
                            zzighVarZzb = zzifz.zza().zzb(obj3.getClass());
                        }
                        if (!zzighVarZzb.zzl(obj3)) {
                            return false;
                        }
                    }
                }
            }
            i4++;
            obj = obj2;
            i6 = i;
            i5 = i2;
        }
        return !this.zzh || ((zziea) obj).zza.zze();
    }
}
