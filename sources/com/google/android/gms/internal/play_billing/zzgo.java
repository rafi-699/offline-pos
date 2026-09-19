package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgo<T> implements zzgv<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzho.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgl zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzhh zzl;
    private final zzev zzm;

    private zzgo(int[] iArr, Object[] objArr, int i, int i2, zzgl zzglVar, boolean z, int[] iArr2, int i3, int i4, zzgq zzgqVar, zzfy zzfyVar, zzhh zzhhVar, zzev zzevVar, zzgg zzggVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        boolean z2 = false;
        if (zzevVar != null && (zzglVar instanceof zzff)) {
            z2 = true;
        }
        this.zzh = z2;
        this.zzi = iArr2;
        this.zzj = i3;
        this.zzk = i4;
        this.zzl = zzhhVar;
        this.zzm = zzevVar;
        this.zzg = zzglVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(String.valueOf(obj))));
        }
    }

    private final void zzB(Object obj, Object obj2, int i) {
        if (zzI(obj2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i] + " is present but null: " + obj2.toString());
            }
            zzgv zzgvVarZzv = zzv(i);
            if (!zzI(obj, i)) {
                if (zzL(object)) {
                    Object objZze = zzgvVarZzv.zze();
                    zzgvVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzD(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgvVarZzv.zze();
                zzgvVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgvVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i) {
        int[] iArr = this.zzc;
        int i2 = iArr[i];
        if (zzM(obj2, i2, i)) {
            int iZzs = zzs(i) & 1048575;
            Unsafe unsafe = zzb;
            long j = iZzs;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i] + " is present but null: " + obj2.toString());
            }
            zzgv zzgvVarZzv = zzv(i);
            if (!zzM(obj, i2, i)) {
                if (zzL(object)) {
                    Object objZze = zzgvVarZzv.zze();
                    zzgvVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j, objZze);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                zzE(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!zzL(object2)) {
                Object objZze2 = zzgvVarZzv.zze();
                zzgvVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j, objZze2);
                object2 = objZze2;
            }
            zzgvVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i) {
        int iZzp = zzp(i);
        long j = 1048575 & iZzp;
        if (j == 1048575) {
            return;
        }
        zzho.zzq(obj, j, (1 << (iZzp >>> 20)) | zzho.zzc(obj, j));
    }

    private final void zzE(Object obj, int i, int i2) {
        zzho.zzq(obj, zzp(i2) & 1048575, i);
    }

    private final void zzF(Object obj, int i, Object obj2) {
        zzb.putObject(obj, zzs(i) & 1048575, obj2);
        zzD(obj, i);
    }

    private final void zzG(Object obj, int i, int i2, Object obj2) {
        zzb.putObject(obj, zzs(i2) & 1048575, obj2);
        zzE(obj, i, i2);
    }

    private final boolean zzH(Object obj, Object obj2, int i) {
        return zzI(obj, i) == zzI(obj2, i);
    }

    private final boolean zzI(Object obj, int i) {
        int iZzp = zzp(i);
        long j = iZzp & 1048575;
        if (j != 1048575) {
            return (zzho.zzc(obj, j) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i);
        long j2 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzho.zza(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzho.zzb(obj, j2)) != 0;
            case 2:
                return zzho.zzd(obj, j2) != 0;
            case 3:
                return zzho.zzd(obj, j2) != 0;
            case 4:
                return zzho.zzc(obj, j2) != 0;
            case 5:
                return zzho.zzd(obj, j2) != 0;
            case 6:
                return zzho.zzc(obj, j2) != 0;
            case 7:
                return zzho.zzw(obj, j2);
            case 8:
                Object objZzf = zzho.zzf(obj, j2);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzei) {
                    return !zzei.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzho.zzf(obj, j2) != null;
            case 10:
                return !zzei.zzb.equals(zzho.zzf(obj, j2));
            case 11:
                return zzho.zzc(obj, j2) != 0;
            case 12:
                return zzho.zzc(obj, j2) != 0;
            case 13:
                return zzho.zzc(obj, j2) != 0;
            case 14:
                return zzho.zzd(obj, j2) != 0;
            case 15:
                return zzho.zzc(obj, j2) != 0;
            case 16:
                return zzho.zzd(obj, j2) != 0;
            case 17:
                return zzho.zzf(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zzI(obj, i);
        }
        return (i3 & i4) != 0;
    }

    private static boolean zzK(Object obj, int i, zzgv zzgvVar) {
        return zzgvVar.zzk(zzho.zzf(obj, i & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzfi) {
            return ((zzfi) obj).zzz();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i, int i2) {
        return zzho.zzc(obj, (long) (zzp(i2) & 1048575)) == i;
    }

    private static boolean zzN(Object obj, long j) {
        return ((Boolean) zzho.zzf(obj, j)).booleanValue();
    }

    private static final void zzO(int i, Object obj, zzhu zzhuVar) throws IOException {
        if (obj instanceof String) {
            zzhuVar.zzG(i, (String) obj);
        } else {
            zzhuVar.zzd(i, (zzei) obj);
        }
    }

    static zzhi zzd(Object obj) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVar = zzfiVar.zzc;
        if (zzhiVar != zzhi.zzc()) {
            return zzhiVar;
        }
        zzhi zzhiVarZzf = zzhi.zzf();
        zzfiVar.zzc = zzhiVarZzf;
        return zzhiVarZzf;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x026d  */
    /* JADX WARN: Code duplicated, block: B:127:0x0270  */
    /* JADX WARN: Code duplicated, block: B:130:0x028a  */
    /* JADX WARN: Code duplicated, block: B:131:0x028d  */
    /* JADX WARN: Code duplicated, block: B:170:0x034e  */
    /* JADX WARN: Code duplicated, block: B:185:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:188:0x03ad  */
    static zzgo zzl(Class cls, zzgi zzgiVar, zzgq zzgqVar, zzfy zzfyVar, zzhh zzhhVar, zzev zzevVar, zzgg zzggVar) {
        int i;
        int iCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int i7;
        int i8;
        char cCharAt;
        int i9;
        char cCharAt2;
        int i10;
        char cCharAt3;
        int i11;
        char cCharAt4;
        int i12;
        char cCharAt5;
        int i13;
        char cCharAt6;
        int i14;
        char cCharAt7;
        int i15;
        char cCharAt8;
        int i16;
        int i17;
        int i18;
        int iObjectFieldOffset;
        char c;
        int iObjectFieldOffset2;
        int i19;
        int i20;
        int i21;
        Field fieldZzz;
        char cCharAt9;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        Object obj;
        Field fieldZzz2;
        int i27;
        Object obj2;
        Field fieldZzz3;
        int i28;
        char cCharAt10;
        int i29;
        char cCharAt11;
        int i30;
        char cCharAt12;
        int i31;
        char cCharAt13;
        if (!(zzgiVar instanceof zzgu)) {
            throw null;
        }
        zzgu zzguVar = (zzgu) zzgiVar;
        String strZzd = zzguVar.zzd();
        int length = strZzd.length();
        char c2 = 55296;
        if (strZzd.charAt(0) >= 55296) {
            int i32 = 1;
            while (true) {
                i = i32 + 1;
                if (strZzd.charAt(i32) < 55296) {
                    break;
                }
                i32 = i;
            }
        } else {
            i = 1;
        }
        int i33 = i + 1;
        int iCharAt2 = strZzd.charAt(i);
        if (iCharAt2 >= 55296) {
            int i34 = iCharAt2 & 8191;
            int i35 = 13;
            while (true) {
                i31 = i33 + 1;
                cCharAt13 = strZzd.charAt(i33);
                if (cCharAt13 < 55296) {
                    break;
                }
                i34 |= (cCharAt13 & 8191) << i35;
                i35 += 13;
                i33 = i31;
            }
            iCharAt2 = i34 | (cCharAt13 << i35);
            i33 = i31;
        }
        if (iCharAt2 == 0) {
            i3 = 0;
            i6 = 0;
            iCharAt = 0;
            i2 = 0;
            i4 = 0;
            i5 = 0;
            iArr = zza;
            i7 = 0;
        } else {
            int i36 = i33 + 1;
            int iCharAt3 = strZzd.charAt(i33);
            if (iCharAt3 >= 55296) {
                int i37 = iCharAt3 & 8191;
                int i38 = 13;
                while (true) {
                    i15 = i36 + 1;
                    cCharAt8 = strZzd.charAt(i36);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt8 & 8191) << i38;
                    i38 += 13;
                    i36 = i15;
                }
                iCharAt3 = i37 | (cCharAt8 << i38);
                i36 = i15;
            }
            int i39 = i36 + 1;
            int iCharAt4 = strZzd.charAt(i36);
            if (iCharAt4 >= 55296) {
                int i40 = iCharAt4 & 8191;
                int i41 = 13;
                while (true) {
                    i14 = i39 + 1;
                    cCharAt7 = strZzd.charAt(i39);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt7 & 8191) << i41;
                    i41 += 13;
                    i39 = i14;
                }
                iCharAt4 = i40 | (cCharAt7 << i41);
                i39 = i14;
            }
            int i42 = i39 + 1;
            int iCharAt5 = strZzd.charAt(i39);
            if (iCharAt5 >= 55296) {
                int i43 = iCharAt5 & 8191;
                int i44 = 13;
                while (true) {
                    i13 = i42 + 1;
                    cCharAt6 = strZzd.charAt(i42);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt6 & 8191) << i44;
                    i44 += 13;
                    i42 = i13;
                }
                iCharAt5 = i43 | (cCharAt6 << i44);
                i42 = i13;
            }
            int i45 = i42 + 1;
            int iCharAt6 = strZzd.charAt(i42);
            if (iCharAt6 >= 55296) {
                int i46 = iCharAt6 & 8191;
                int i47 = 13;
                while (true) {
                    i12 = i45 + 1;
                    cCharAt5 = strZzd.charAt(i45);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt5 & 8191) << i47;
                    i47 += 13;
                    i45 = i12;
                }
                iCharAt6 = i46 | (cCharAt5 << i47);
                i45 = i12;
            }
            int i48 = i45 + 1;
            iCharAt = strZzd.charAt(i45);
            if (iCharAt >= 55296) {
                int i49 = iCharAt & 8191;
                int i50 = 13;
                while (true) {
                    i11 = i48 + 1;
                    cCharAt4 = strZzd.charAt(i48);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt4 & 8191) << i50;
                    i50 += 13;
                    i48 = i11;
                }
                iCharAt = i49 | (cCharAt4 << i50);
                i48 = i11;
            }
            int i51 = i48 + 1;
            int iCharAt7 = strZzd.charAt(i48);
            if (iCharAt7 >= 55296) {
                int i52 = iCharAt7 & 8191;
                int i53 = 13;
                while (true) {
                    i10 = i51 + 1;
                    cCharAt3 = strZzd.charAt(i51);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i52 |= (cCharAt3 & 8191) << i53;
                    i53 += 13;
                    i51 = i10;
                }
                iCharAt7 = i52 | (cCharAt3 << i53);
                i51 = i10;
            }
            int i54 = i51 + 1;
            int iCharAt8 = strZzd.charAt(i51);
            if (iCharAt8 >= 55296) {
                int i55 = iCharAt8 & 8191;
                int i56 = 13;
                while (true) {
                    i9 = i54 + 1;
                    cCharAt2 = strZzd.charAt(i54);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i55 |= (cCharAt2 & 8191) << i56;
                    i56 += 13;
                    i54 = i9;
                }
                iCharAt8 = i55 | (cCharAt2 << i56);
                i54 = i9;
            }
            int i57 = i54 + 1;
            int iCharAt9 = strZzd.charAt(i54);
            if (iCharAt9 >= 55296) {
                int i58 = iCharAt9 & 8191;
                int i59 = 13;
                while (true) {
                    i8 = i57 + 1;
                    cCharAt = strZzd.charAt(i57);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i58 |= (cCharAt & 8191) << i59;
                    i59 += 13;
                    i57 = i8;
                }
                iCharAt9 = i58 | (cCharAt << i59);
                i57 = i8;
            }
            int i60 = iCharAt3 + iCharAt3 + iCharAt4;
            int[] iArr2 = new int[iCharAt9 + iCharAt7 + iCharAt8];
            int i61 = iCharAt7;
            i2 = iCharAt5;
            i3 = i61;
            i4 = iCharAt6;
            i5 = iCharAt9;
            i6 = i60;
            iArr = iArr2;
            i7 = iCharAt3;
            i33 = i57;
        }
        Unsafe unsafe = zzb;
        Object[] objArrZze = zzguVar.zze();
        Class<?> cls2 = zzguVar.zza().getClass();
        int i62 = i5 + i3;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i5;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i33 < length) {
            int i68 = i33 + 1;
            int iCharAt10 = strZzd.charAt(i33);
            if (iCharAt10 >= c2) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i30 = i70 + 1;
                    cCharAt12 = strZzd.charAt(i70);
                    if (cCharAt12 < c2) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i30;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i16 = i30;
            } else {
                i16 = i68;
            }
            int i72 = i16 + 1;
            int iCharAt11 = strZzd.charAt(i16);
            if (iCharAt11 >= c2) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i29 = i74 + 1;
                    cCharAt11 = strZzd.charAt(i74);
                    if (cCharAt11 < c2) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i29;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i17 = i29;
            } else {
                i17 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            zzgu zzguVar2 = zzguVar;
            int i77 = iCharAt11 & 2048;
            if (i76 >= 51) {
                int i78 = i17 + 1;
                int iCharAt12 = strZzd.charAt(i17);
                char c3 = 55296;
                if (iCharAt12 >= 55296) {
                    int i79 = iCharAt12 & 8191;
                    int i80 = i78;
                    int i81 = 13;
                    while (true) {
                        i28 = i80 + 1;
                        cCharAt10 = strZzd.charAt(i80);
                        if (cCharAt10 < c3) {
                            break;
                        }
                        i79 |= (cCharAt10 & 8191) << i81;
                        i81 += 13;
                        i80 = i28;
                        c3 = 55296;
                    }
                    iCharAt12 = i79 | (cCharAt10 << i81);
                    i23 = i28;
                } else {
                    i23 = i78;
                }
                int i82 = i23;
                int i83 = i76 - 51;
                if (i83 == 9 || i83 == 17) {
                    i24 = i6 + 1;
                    int i84 = i67 / 3;
                    objArr[i84 + i84 + 1] = objArrZze[i6];
                } else {
                    if (i83 != 12) {
                        i25 = i77;
                    } else if (zzguVar2.zzc() == 1 || i77 != 0) {
                        i24 = i6 + 1;
                        int i85 = i67 / 3;
                        objArr[i85 + i85 + 1] = objArrZze[i6];
                    } else {
                        i25 = 0;
                    }
                    i26 = iCharAt12 + iCharAt12;
                    obj = objArrZze[i26];
                    int i86 = i25;
                    if (obj instanceof Field) {
                        fieldZzz2 = (Field) obj;
                    } else {
                        fieldZzz2 = zzz(cls2, (String) obj);
                        objArrZze[i26] = fieldZzz2;
                    }
                    int i87 = i7;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz2);
                    i27 = i26 + 1;
                    obj2 = objArrZze[i27];
                    i18 = i87;
                    if (obj2 instanceof Field) {
                        fieldZzz3 = (Field) obj2;
                    } else {
                        fieldZzz3 = zzz(cls2, (String) obj2);
                        objArrZze[i27] = fieldZzz3;
                    }
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                    strZzd = strZzd;
                    i20 = i86;
                    i17 = i82;
                    i19 = 0;
                    c = 55296;
                }
                i6 = i24;
                i25 = i77;
                i26 = iCharAt12 + iCharAt12;
                obj = objArrZze[i26];
                int i88 = i25;
                if (obj instanceof Field) {
                    fieldZzz2 = (Field) obj;
                } else {
                    fieldZzz2 = zzz(cls2, (String) obj);
                    objArrZze[i26] = fieldZzz2;
                }
                int i89 = i7;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz2);
                i27 = i26 + 1;
                obj2 = objArrZze[i27];
                i18 = i89;
                if (obj2 instanceof Field) {
                    fieldZzz3 = (Field) obj2;
                } else {
                    fieldZzz3 = zzz(cls2, (String) obj2);
                    objArrZze[i27] = fieldZzz3;
                }
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldZzz3);
                strZzd = strZzd;
                i20 = i88;
                i17 = i82;
                i19 = 0;
                c = 55296;
            } else {
                i18 = i7;
                int i90 = i6 + 1;
                Field fieldZzz4 = zzz(cls2, (String) objArrZze[i6]);
                if (i76 == 9 || i76 == 17) {
                    int i91 = i67 / 3;
                    objArr[i91 + i91 + 1] = fieldZzz4.getType();
                } else {
                    if (i76 != 27) {
                        if (i76 == 49) {
                            i6 += 2;
                            i22 = 1;
                        } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                            if (zzguVar2.zzc() == 1 || i77 != 0) {
                                i6 += 2;
                                int i92 = i67 / 3;
                                objArr[i92 + i92 + 1] = objArrZze[i90];
                            } else {
                                i6 = i90;
                                i77 = 0;
                            }
                        } else if (i76 == 50) {
                            int i93 = i6 + 2;
                            int i94 = i64 + 1;
                            iArr[i64] = i67;
                            int i95 = i67 / 3;
                            int i96 = i95 + i95;
                            objArr[i96] = objArrZze[i90];
                            if (i77 != 0) {
                                objArr[i96 + 1] = objArrZze[i93];
                                i6 += 3;
                                i64 = i94;
                            } else {
                                i6 = i93;
                                i64 = i94;
                                i77 = 0;
                            }
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                        if ((iCharAt11 & 4096) != 0 || i76 > 17) {
                            c = 55296;
                            iObjectFieldOffset2 = 1048575;
                            i19 = 0;
                        } else {
                            int i97 = i17 + 1;
                            int iCharAt13 = strZzd.charAt(i17);
                            if (iCharAt13 >= 55296) {
                                int i98 = iCharAt13 & 8191;
                                int i99 = 13;
                                while (true) {
                                    i21 = i97 + 1;
                                    cCharAt9 = strZzd.charAt(i97);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i98 |= (cCharAt9 & 8191) << i99;
                                    i99 += 13;
                                    i97 = i21;
                                }
                                iCharAt13 = i98 | (cCharAt9 << i99);
                            } else {
                                i21 = i97;
                            }
                            int i100 = i18 + i18 + (iCharAt13 / 32);
                            Object obj3 = objArrZze[i100];
                            if (obj3 instanceof Field) {
                                fieldZzz = (Field) obj3;
                            } else {
                                fieldZzz = zzz(cls2, (String) obj3);
                                objArrZze[i100] = fieldZzz;
                            }
                            int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldZzz);
                            i19 = iCharAt13 % 32;
                            i17 = i21;
                            c = 55296;
                            iObjectFieldOffset2 = iObjectFieldOffset3;
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i20 = i77;
                    } else {
                        i22 = 1;
                        i6 += 2;
                    }
                    int i101 = i67 / 3;
                    objArr[i101 + i101 + i22] = objArrZze[i90];
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                    if ((iCharAt11 & 4096) != 0) {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    } else {
                        c = 55296;
                        iObjectFieldOffset2 = 1048575;
                        i19 = 0;
                    }
                    if (i76 >= 18) {
                        iArr[i65] = iObjectFieldOffset;
                        i65++;
                    }
                    i20 = i77;
                }
                i6 = i90;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldZzz4);
                if ((iCharAt11 & 4096) != 0) {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                } else {
                    c = 55296;
                    iObjectFieldOffset2 = 1048575;
                    i19 = 0;
                }
                if (i76 >= 18) {
                    iArr[i65] = iObjectFieldOffset;
                    i65++;
                }
                i20 = i77;
            }
            int i102 = i67 + 1;
            iArr3[i67] = iCharAt10;
            int i103 = i67 + 2;
            iArr3[i102] = ((iCharAt11 & 512) != 0 ? 536870912 : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i20 != 0 ? Integer.MIN_VALUE : 0) | (i76 << 20) | iObjectFieldOffset;
            i67 += 3;
            iArr3[i103] = (i19 << 20) | iObjectFieldOffset2;
            i33 = i17;
            strZzd = strZzd;
            c2 = c;
            zzguVar = zzguVar2;
            length = length;
            i7 = i18;
        }
        return new zzgo(iArr3, objArr, i2, i4, zzguVar.zza(), false, iArr, i5, i62, zzgqVar, zzfyVar, zzhhVar, zzevVar, zzggVar);
    }

    private static double zzm(Object obj, long j) {
        return ((Double) zzho.zzf(obj, j)).doubleValue();
    }

    private static float zzn(Object obj, long j) {
        return ((Float) zzho.zzf(obj, j)).floatValue();
    }

    private static int zzo(Object obj, long j) {
        return ((Integer) zzho.zzf(obj, j)).intValue();
    }

    private final int zzp(int i) {
        return this.zzc[i + 2];
    }

    private final int zzq(int i, int i2) {
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

    private static int zzr(int i) {
        return (i >>> 20) & 255;
    }

    private final int zzs(int i) {
        return this.zzc[i + 1];
    }

    private static long zzt(Object obj, long j) {
        return ((Long) zzho.zzf(obj, j)).longValue();
    }

    private final zzfl zzu(int i) {
        int i2 = i / 3;
        return (zzfl) this.zzd[i2 + i2 + 1];
    }

    private final zzgv zzv(int i) {
        Object[] objArr = this.zzd;
        int i2 = i / 3;
        int i3 = i2 + i2;
        zzgv zzgvVar = (zzgv) objArr[i3];
        if (zzgvVar != null) {
            return zzgvVar;
        }
        zzgv zzgvVarZzb = zzgs.zza().zzb((Class) objArr[i3 + 1]);
        objArr[i3] = zzgvVarZzb;
        return zzgvVarZzb;
    }

    private final Object zzw(int i) {
        int i2 = i / 3;
        return this.zzd[i2 + i2];
    }

    private final Object zzx(Object obj, int i) {
        zzgv zzgvVarZzv = zzv(i);
        int iZzs = zzs(i) & 1048575;
        if (!zzI(obj, i)) {
            return zzgvVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgvVarZzv.zze();
        if (object != null) {
            zzgvVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i, int i2) {
        zzgv zzgvVarZzv = zzv(i2);
        if (!zzM(obj, i, i2)) {
            return zzgvVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i2) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzgvVarZzv.zze();
        if (object != null) {
            zzgvVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields), e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:141:0x0385  */
    /* JADX WARN: Code duplicated, block: B:211:0x0546  */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final int zza(Object obj) {
        int i;
        int iZzC;
        int iZzC2;
        int iZzD;
        int iZzC3;
        int iZzC4;
        int iZzC5;
        int iZzd;
        int iZzC6;
        int iZzh;
        int iZzg;
        int size;
        int iZzl;
        int iZzC7;
        int iZzC8;
        int iZzC9;
        int iZzD2;
        int iZze;
        int iZzC10;
        int iZzC11;
        int iZzy;
        int iZzC12;
        int iZzC13;
        int iZzC14;
        int iZzd2;
        int iZzC15;
        zzgo<T> zzgoVar = this;
        Unsafe unsafe = zzb;
        int i2 = 0;
        int i3 = 0;
        int iZzC16 = 0;
        int i4 = 1048575;
        while (true) {
            int[] iArr = zzgoVar.zzc;
            if (i2 >= iArr.length) {
                int iZza = iZzC16 + ((zzfi) obj).zzc.zza();
                if (!zzgoVar.zzh) {
                    return iZza;
                }
                zzhd zzhdVar = ((zzff) obj).zzb.zza;
                int iZzc = zzhdVar.zzc();
                int iZzc2 = 0;
                for (int i5 = 0; i5 < iZzc; i5++) {
                    Map.Entry entryZzg = zzhdVar.zzg(i5);
                    iZzc2 += zzez.zzc((zzey) ((zzgz) entryZzg).zza(), entryZzg.getValue());
                }
                for (Map.Entry entry : zzhdVar.zzd()) {
                    iZzc2 += zzez.zzc((zzey) entry.getKey(), entry.getValue());
                }
                return iZza + iZzc2;
            }
            int iZzs = zzgoVar.zzs(i2);
            int iZzr = zzr(iZzs);
            int i6 = iArr[i2];
            int i7 = iArr[i2 + 2];
            int i8 = i7 & 1048575;
            if (iZzr <= 17) {
                if (i8 != i4) {
                    i3 = i8 == 1048575 ? 0 : unsafe.getInt(obj, i8);
                    i4 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            int i9 = iZzs & 1048575;
            if (iZzr >= zzfa.DOUBLE_LIST_PACKED.zza()) {
                zzfa.SINT64_LIST_PACKED.zza();
            }
            long j = i9;
            switch (iZzr) {
                case 0:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzC16 += zzep.zzC(i6 << 3) + 8;
                    }
                    i2 += 3;
                    break;
                case 1:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzC = zzep.zzC(i6 << 3);
                        iZzC4 = iZzC + 4;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 2:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        long j2 = unsafe.getLong(obj, j);
                        iZzC2 = zzep.zzC(i6 << 3);
                        iZzD = zzep.zzD(j2);
                        iZzC4 = iZzC2 + iZzD;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 3:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        long j3 = unsafe.getLong(obj, j);
                        iZzC2 = zzep.zzC(i6 << 3);
                        iZzD = zzep.zzD(j3);
                        iZzC4 = iZzC2 + iZzD;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 4:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        long j4 = unsafe.getInt(obj, j);
                        iZzC2 = zzep.zzC(i6 << 3);
                        iZzD = zzep.zzD(j4);
                        iZzC4 = iZzC2 + iZzD;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 5:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzC3 = zzep.zzC(i6 << 3);
                        iZzC4 = iZzC3 + 8;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 6:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzC = zzep.zzC(i6 << 3);
                        iZzC4 = iZzC + 4;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 7:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzC4 = zzep.zzC(i6 << 3) + 1;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 8:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        int i10 = i6 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof zzei) {
                            iZzC5 = zzep.zzC(i10);
                            iZzd = ((zzei) object).zzd();
                            iZzC6 = zzep.zzC(iZzd);
                            iZzC4 = iZzC5 + iZzC6 + iZzd;
                            iZzC16 += iZzC4;
                        } else {
                            iZzC2 = zzep.zzC(i10);
                            iZzD = zzep.zzB((String) object);
                            iZzC4 = iZzC2 + iZzD;
                            iZzC16 += iZzC4;
                        }
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 9:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzh = zzgx.zzh(i6, unsafe.getObject(obj, j), zzgoVar.zzv(i2));
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 10:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        zzei zzeiVar = (zzei) unsafe.getObject(obj, j);
                        iZzC5 = zzep.zzC(i6 << 3);
                        iZzd = zzeiVar.zzd();
                        iZzC6 = zzep.zzC(iZzd);
                        iZzC4 = iZzC5 + iZzC6 + iZzd;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 11:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        int i11 = unsafe.getInt(obj, j);
                        iZzC2 = zzep.zzC(i6 << 3);
                        iZzD = zzep.zzC(i11);
                        iZzC4 = iZzC2 + iZzD;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 12:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        long j5 = unsafe.getInt(obj, j);
                        iZzC2 = zzep.zzC(i6 << 3);
                        iZzD = zzep.zzD(j5);
                        iZzC4 = iZzC2 + iZzD;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 13:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzC = zzep.zzC(i6 << 3);
                        iZzC4 = iZzC + 4;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 14:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzC3 = zzep.zzC(i6 << 3);
                        iZzC4 = iZzC3 + 8;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 15:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        int i12 = unsafe.getInt(obj, j);
                        iZzC2 = zzep.zzC(i6 << 3);
                        iZzD = zzep.zzC((i12 >> 31) ^ (i12 + i12));
                        iZzC4 = iZzC2 + iZzD;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 16:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        long j6 = unsafe.getLong(obj, j);
                        iZzC2 = zzep.zzC(i6 << 3);
                        iZzD = zzep.zzD((j6 >> 63) ^ (j6 + j6));
                        iZzC4 = iZzC2 + iZzD;
                        iZzC16 += iZzC4;
                    }
                    zzgoVar = this;
                    i2 += 3;
                    break;
                case 17:
                    if (zzgoVar.zzJ(obj, i2, i4, i3, i)) {
                        iZzh = zzep.zzy(i6, (zzgl) unsafe.getObject(obj, j), zzgoVar.zzv(i2));
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 18:
                    iZzh = zzgx.zzd(i6, (List) unsafe.getObject(obj, j), false);
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 19:
                    iZzh = zzgx.zzb(i6, (List) unsafe.getObject(obj, j), false);
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    int i13 = zzgx.zza;
                    if (list.size() == 0) {
                        iZzg = 0;
                    } else {
                        iZzg = zzgx.zzg(list) + (list.size() * zzep.zzC(i6 << 3));
                    }
                    iZzC16 += iZzg;
                    i2 += 3;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    int i14 = zzgx.zza;
                    size = list2.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgx.zzl(list2);
                        iZzC7 = zzep.zzC(i6 << 3);
                        iZzD2 = size * iZzC7;
                        iZzh = iZzl + iZzD2;
                    }
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzgx.zza;
                    size = list3.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgx.zzf(list3);
                        iZzC7 = zzep.zzC(i6 << 3);
                        iZzD2 = size * iZzC7;
                        iZzh = iZzl + iZzD2;
                    }
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 23:
                    iZzh = zzgx.zzd(i6, (List) unsafe.getObject(obj, j), false);
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 24:
                    iZzh = zzgx.zzb(i6, (List) unsafe.getObject(obj, j), false);
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    int i16 = zzgx.zza;
                    int size2 = list4.size();
                    if (size2 == 0) {
                        iZzh = 0;
                    } else {
                        iZzh = size2 * (zzep.zzC(i6 << 3) + 1);
                    }
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    int i17 = zzgx.zza;
                    int size3 = list5.size();
                    if (size3 == 0) {
                        iZzg = 0;
                    } else {
                        iZzg = zzep.zzC(i6 << 3) * size3;
                        if (list5 instanceof zzfx) {
                            zzfx zzfxVar = (zzfx) list5;
                            for (int i18 = 0; i18 < size3; i18++) {
                                Object objZza = zzfxVar.zza();
                                if (objZza instanceof zzei) {
                                    int iZzd3 = ((zzei) objZza).zzd();
                                    iZzg += zzep.zzC(iZzd3) + iZzd3;
                                } else {
                                    iZzg += zzep.zzB((String) objZza);
                                }
                            }
                        } else {
                            for (int i19 = 0; i19 < size3; i19++) {
                                Object obj2 = list5.get(i19);
                                if (obj2 instanceof zzei) {
                                    int iZzd4 = ((zzei) obj2).zzd();
                                    iZzg += zzep.zzC(iZzd4) + iZzd4;
                                } else {
                                    iZzg += zzep.zzB((String) obj2);
                                }
                            }
                        }
                    }
                    iZzC16 += iZzg;
                    i2 += 3;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    zzgv zzgvVarZzv = zzgoVar.zzv(i2);
                    int i20 = zzgx.zza;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iZzC8 = 0;
                    } else {
                        iZzC8 = zzep.zzC(i6 << 3) * size4;
                        for (int i21 = 0; i21 < size4; i21++) {
                            Object obj3 = list6.get(i21);
                            if (obj3 instanceof zzfw) {
                                int iZza2 = ((zzfw) obj3).zza();
                                iZzC8 += zzep.zzC(iZza2) + iZza2;
                            } else {
                                iZzC8 += zzep.zzA((zzgl) obj3, zzgvVarZzv);
                            }
                        }
                    }
                    iZzC16 += iZzC8;
                    i2 += 3;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    int i22 = zzgx.zza;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iZzC9 = 0;
                    } else {
                        iZzC9 = size5 * zzep.zzC(i6 << 3);
                        for (int i23 = 0; i23 < list7.size(); i23++) {
                            int iZzd5 = ((zzei) list7.get(i23)).zzd();
                            iZzC9 += zzep.zzC(iZzd5) + iZzd5;
                        }
                    }
                    iZzC16 += iZzC9;
                    i2 += 3;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    int i24 = zzgx.zza;
                    size = list8.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgx.zzk(list8);
                        iZzC7 = zzep.zzC(i6 << 3);
                        iZzD2 = size * iZzC7;
                        iZzh = iZzl + iZzD2;
                    }
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    int i25 = zzgx.zza;
                    size = list9.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgx.zza(list9);
                        iZzC7 = zzep.zzC(i6 << 3);
                        iZzD2 = size * iZzC7;
                        iZzh = iZzl + iZzD2;
                    }
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 31:
                    iZzh = zzgx.zzb(i6, (List) unsafe.getObject(obj, j), false);
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 32:
                    iZzh = zzgx.zzd(i6, (List) unsafe.getObject(obj, j), false);
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    int i26 = zzgx.zza;
                    size = list10.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgx.zzi(list10);
                        iZzC7 = zzep.zzC(i6 << 3);
                        iZzD2 = size * iZzC7;
                        iZzh = iZzl + iZzD2;
                    }
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    int i27 = zzgx.zza;
                    size = list11.size();
                    if (size == 0) {
                        iZzh = 0;
                    } else {
                        iZzl = zzgx.zzj(list11);
                        iZzC7 = zzep.zzC(i6 << 3);
                        iZzD2 = size * iZzC7;
                        iZzh = iZzl + iZzD2;
                    }
                    iZzC16 += iZzh;
                    i2 += 3;
                    break;
                case 35:
                    iZze = zzgx.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 36:
                    iZze = zzgx.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 37:
                    iZze = zzgx.zzg((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 38:
                    iZze = zzgx.zzl((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 39:
                    iZze = zzgx.zzf((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 40:
                    iZze = zzgx.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 41:
                    iZze = zzgx.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 42:
                    List list12 = (List) unsafe.getObject(obj, j);
                    int i28 = zzgx.zza;
                    iZze = list12.size();
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 43:
                    iZze = zzgx.zzk((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 44:
                    iZze = zzgx.zza((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 45:
                    iZze = zzgx.zzc((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 46:
                    iZze = zzgx.zze((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 47:
                    iZze = zzgx.zzi((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 48:
                    iZze = zzgx.zzj((List) unsafe.getObject(obj, j));
                    if (iZze > 0) {
                        iZzC10 = zzep.zzC(i6 << 3);
                        iZzC11 = zzep.zzC(iZze);
                        iZzC9 = iZzC10 + iZzC11 + iZze;
                        iZzC16 += iZzC9;
                    }
                    i2 += 3;
                    break;
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    zzgv zzgvVarZzv2 = zzgoVar.zzv(i2);
                    int i29 = zzgx.zza;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iZzy = 0;
                    } else {
                        iZzy = 0;
                        for (int i30 = 0; i30 < size6; i30++) {
                            iZzy += zzep.zzy(i6, (zzgl) list13.get(i30), zzgvVarZzv2);
                        }
                    }
                    iZzC16 += iZzy;
                    i2 += 3;
                    break;
                case 50:
                    zzgf zzgfVar = (zzgf) unsafe.getObject(obj, j);
                    if (zzgfVar.isEmpty()) {
                        continue;
                    } else {
                        Iterator it = zzgfVar.entrySet().iterator();
                        if (it.hasNext()) {
                            Map.Entry entry2 = (Map.Entry) it.next();
                            entry2.getKey();
                            entry2.getValue();
                            throw null;
                        }
                    }
                    i2 += 3;
                case 51:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        iZzC12 = zzep.zzC(i6 << 3);
                        iZzh = iZzC12 + 8;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 52:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        iZzC13 = zzep.zzC(i6 << 3);
                        iZzh = iZzC13 + 4;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 53:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        long jZzt = zzt(obj, j);
                        iZzl = zzep.zzC(i6 << 3);
                        iZzD2 = zzep.zzD(jZzt);
                        iZzh = iZzl + iZzD2;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 54:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        long jZzt2 = zzt(obj, j);
                        iZzl = zzep.zzC(i6 << 3);
                        iZzD2 = zzep.zzD(jZzt2);
                        iZzh = iZzl + iZzD2;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 55:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        long jZzo = zzo(obj, j);
                        iZzl = zzep.zzC(i6 << 3);
                        iZzD2 = zzep.zzD(jZzo);
                        iZzh = iZzl + iZzD2;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 56:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        iZzC12 = zzep.zzC(i6 << 3);
                        iZzh = iZzC12 + 8;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 57:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        iZzC13 = zzep.zzC(i6 << 3);
                        iZzh = iZzC13 + 4;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 58:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        iZzh = zzep.zzC(i6 << 3) + 1;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 59:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        int i31 = i6 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof zzei) {
                            iZzC14 = zzep.zzC(i31);
                            iZzd2 = ((zzei) object2).zzd();
                            iZzC15 = zzep.zzC(iZzd2);
                            iZzh = iZzC14 + iZzC15 + iZzd2;
                            iZzC16 += iZzh;
                        } else {
                            iZzl = zzep.zzC(i31);
                            iZzD2 = zzep.zzB((String) object2);
                            iZzh = iZzl + iZzD2;
                            iZzC16 += iZzh;
                        }
                    }
                    i2 += 3;
                    break;
                case 60:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        iZzh = zzgx.zzh(i6, unsafe.getObject(obj, j), zzgoVar.zzv(i2));
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 61:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        zzei zzeiVar2 = (zzei) unsafe.getObject(obj, j);
                        iZzC14 = zzep.zzC(i6 << 3);
                        iZzd2 = zzeiVar2.zzd();
                        iZzC15 = zzep.zzC(iZzd2);
                        iZzh = iZzC14 + iZzC15 + iZzd2;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 62:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        int iZzo = zzo(obj, j);
                        iZzl = zzep.zzC(i6 << 3);
                        iZzD2 = zzep.zzC(iZzo);
                        iZzh = iZzl + iZzD2;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 63:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        long jZzo2 = zzo(obj, j);
                        iZzl = zzep.zzC(i6 << 3);
                        iZzD2 = zzep.zzD(jZzo2);
                        iZzh = iZzl + iZzD2;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 64:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        iZzC13 = zzep.zzC(i6 << 3);
                        iZzh = iZzC13 + 4;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 65:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        iZzC12 = zzep.zzC(i6 << 3);
                        iZzh = iZzC12 + 8;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 66:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        int iZzo2 = zzo(obj, j);
                        iZzl = zzep.zzC(i6 << 3);
                        iZzD2 = zzep.zzC((iZzo2 >> 31) ^ (iZzo2 + iZzo2));
                        iZzh = iZzl + iZzD2;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 67:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        long jZzt3 = zzt(obj, j);
                        iZzl = zzep.zzC(i6 << 3);
                        iZzD2 = zzep.zzD((jZzt3 >> 63) ^ (jZzt3 + jZzt3));
                        iZzh = iZzl + iZzD2;
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                case 68:
                    if (zzgoVar.zzM(obj, i6, i2)) {
                        iZzh = zzep.zzy(i6, (zzgl) unsafe.getObject(obj, j), zzgoVar.zzv(i2));
                        iZzC16 += iZzh;
                    }
                    i2 += 3;
                    break;
                default:
                    i2 += 3;
                    break;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final int zzb(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i3 >= iArr.length) {
                int iHashCode = (i4 * 53) + ((zzfi) obj).zzc.hashCode();
                return this.zzh ? (iHashCode * 53) + ((zzff) obj).zzb.zza.hashCode() : iHashCode;
            }
            int iZzs = zzs(i3);
            int i5 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i6 = iArr[i3];
            long j = i5;
            int iHashCode2 = 37;
            switch (iZzr) {
                case 0:
                    i = i4 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzho.zza(obj, j));
                    byte[] bArr = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i4 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzho.zzb(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr2 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr3 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr4 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i4 * 53;
                    iFloatToIntBits = zzfo.zza(zzho.zzw(obj, j));
                    i4 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i4 * 53;
                    iFloatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i4 * 53;
                    Object objZzf = zzho.zzf(obj, j);
                    if (objZzf != null) {
                        iHashCode2 = objZzf.hashCode();
                    }
                    i4 = i2 + iHashCode2;
                    break;
                case 10:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr5 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzc(obj, j);
                    i4 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i4 * 53;
                    jDoubleToLongBits = zzho.zzd(obj, j);
                    byte[] bArr6 = zzfo.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i4 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i4 * 53;
                    Object objZzf2 = zzho.zzf(obj, j);
                    if (objZzf2 != null) {
                        iHashCode2 = objZzf2.hashCode();
                    }
                    i4 = i2 + iHashCode2;
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
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i4 * 53;
                    iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                    i4 = i + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j));
                        byte[] bArr7 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr8 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr9 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr10 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzfo.zza(zzN(obj, j));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = ((String) zzho.zzf(obj, j)).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr11 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzo(obj, j);
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        jDoubleToLongBits = zzt(obj, j);
                        byte[] bArr12 = zzfo.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i4 = i + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i6, i3)) {
                        i = i4 * 53;
                        iFloatToIntBits = zzho.zzf(obj, j).hashCode();
                        i4 = i + iFloatToIntBits;
                    }
                    break;
            }
            i3 += 3;
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 34261. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    final int zzc(java.lang.Object r35, byte[] r36, int r37, int r38, int r39, com.google.android.gms.internal.play_billing.zzdw r40) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzgo.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzdw):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final Object zze() {
        return ((zzfi) this.zzg).zzo();
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzf(Object obj) {
        if (zzL(obj)) {
            if (obj instanceof zzfi) {
                zzfi zzfiVar = (zzfi) obj;
                zzfiVar.zzx(Integer.MAX_VALUE);
                zzfiVar.zza = 0;
                zzfiVar.zzv();
            }
            int[] iArr = this.zzc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iZzs = zzs(i);
                int i2 = 1048575 & iZzs;
                int iZzr = zzr(iZzs);
                long j = i2;
                if (iZzr != 9) {
                    if (iZzr != 60 && iZzr != 68) {
                        switch (iZzr) {
                            case 17:
                                if (zzI(obj, i)) {
                                    zzv(i).zzf(zzb.getObject(obj, j));
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
                                ((zzfn) zzho.zzf(obj, j)).zzb();
                                break;
                            case 50:
                                Unsafe unsafe = zzb;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((zzgf) object).zzc();
                                    unsafe.putObject(obj, j, object);
                                }
                                break;
                        }
                    } else if (zzM(obj, iArr[i], i)) {
                        zzv(i).zzf(zzb.getObject(obj, j));
                    }
                } else if (zzI(obj, i)) {
                    zzv(i).zzf(zzb.getObject(obj, j));
                }
            }
            this.zzl.zzb(obj);
            if (this.zzh) {
                this.zzm.zza(obj);
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        int i = 0;
        while (true) {
            int[] iArr = this.zzc;
            if (i >= iArr.length) {
                zzgx.zzp(this.zzl, obj, obj2);
                if (this.zzh) {
                    zzgx.zzo(this.zzm, obj, obj2);
                    return;
                }
                return;
            }
            int iZzs = zzs(i);
            int i2 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i3 = iArr[i];
            long j = i2;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i)) {
                        zzho.zzo(obj, j, zzho.zza(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i)) {
                        zzho.zzp(obj, j, zzho.zzb(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i)) {
                        zzho.zzm(obj, j, zzho.zzw(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i)) {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i);
                    break;
                case 10:
                    if (zzI(obj2, i)) {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i)) {
                        zzho.zzq(obj, j, zzho.zzc(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i)) {
                        zzho.zzr(obj, j, zzho.zzd(obj2, j));
                        zzD(obj, i);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i);
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
                    zzfn zzfnVarZzd = (zzfn) zzho.zzf(obj, j);
                    zzfn zzfnVar = (zzfn) zzho.zzf(obj2, j);
                    int size = zzfnVarZzd.size();
                    int size2 = zzfnVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzfnVarZzd.zzc()) {
                            zzfnVarZzd = zzfnVarZzd.zzd(size2 + size);
                        }
                        zzfnVarZzd.addAll(zzfnVar);
                    }
                    if (size > 0) {
                        zzfnVar = zzfnVarZzd;
                    }
                    zzho.zzs(obj, j, zzfnVar);
                    break;
                case 50:
                    int i4 = zzgx.zza;
                    zzho.zzs(obj, j, zzgg.zza(zzho.zzf(obj, j), zzho.zzf(obj2, j)));
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
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i3, i)) {
                        zzho.zzs(obj, j, zzho.zzf(obj2, j));
                        zzE(obj, i3, i);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i);
                    break;
            }
            i += 3;
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzh(Object obj, byte[] bArr, int i, int i2, zzdw zzdwVar) throws IOException {
        zzc(obj, bArr, i, i2, 0, zzdwVar);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final void zzi(Object obj, zzhu zzhuVar) throws IOException {
        Map.Entry entry;
        int i;
        zzgo<T> zzgoVar = this;
        if (zzgoVar.zzh) {
            zzez zzezVar = ((zzff) obj).zzb;
            if (zzezVar.zza.isEmpty()) {
                entry = null;
            } else {
                entry = (Map.Entry) zzezVar.zzf().next();
            }
        } else {
            entry = null;
        }
        int[] iArr = zzgoVar.zzc;
        Unsafe unsafe = zzb;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < iArr.length) {
            int iZzs = zzgoVar.zzs(i4);
            int iZzr = zzr(iZzs);
            int i6 = iArr[i4];
            if (iZzr <= 17) {
                int i7 = iArr[i4 + 2];
                int i8 = i7 & i2;
                if (i8 != i3) {
                    i5 = i8 == i2 ? 0 : unsafe.getInt(obj, i8);
                    i3 = i8;
                }
                i = 1 << (i7 >>> 20);
            } else {
                i = 0;
            }
            if (entry != null) {
                throw null;
            }
            long j = iZzs & i2;
            switch (iZzr) {
                case 0:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzf(i6, zzho.zza(obj, j));
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 1:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzo(i6, zzho.zzb(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 2:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzt(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 3:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzK(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 4:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzr(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 5:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzm(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 6:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzk(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 7:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzb(i6, zzho.zzw(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 8:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzO(i6, unsafe.getObject(obj, j), zzhuVar);
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 9:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzv(i6, unsafe.getObject(obj, j), zzgoVar.zzv(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 10:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzd(i6, (zzei) unsafe.getObject(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 11:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzI(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 12:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzi(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 13:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzx(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 14:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzz(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 15:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzB(i6, unsafe.getInt(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 16:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzD(i6, unsafe.getLong(obj, j));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 17:
                    if (zzgoVar.zzJ(obj, i4, i3, i5, i)) {
                        zzhuVar.zzq(i6, unsafe.getObject(obj, j), zzgoVar.zzv(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 18:
                    zzgx.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 19:
                    zzgx.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 20:
                    zzgx.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 21:
                    zzgx.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 22:
                    zzgx.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 23:
                    zzgx.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 24:
                    zzgx.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 25:
                    zzgx.zzq(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 26:
                    int i9 = iArr[i4];
                    List list = (List) unsafe.getObject(obj, j);
                    int i10 = zzgx.zza;
                    if (list != null && !list.isEmpty()) {
                        zzhuVar.zzH(i9, list);
                    }
                    break;
                case 27:
                    int i11 = iArr[i4];
                    List list2 = (List) unsafe.getObject(obj, j);
                    zzgv zzgvVarZzv = zzgoVar.zzv(i4);
                    int i12 = zzgx.zza;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i13 = 0; i13 < list2.size(); i13++) {
                            ((zzeq) zzhuVar).zzv(i11, list2.get(i13), zzgvVarZzv);
                        }
                    }
                    break;
                case 28:
                    int i14 = iArr[i4];
                    List list3 = (List) unsafe.getObject(obj, j);
                    int i15 = zzgx.zza;
                    if (list3 != null && !list3.isEmpty()) {
                        zzhuVar.zze(i14, list3);
                    }
                    break;
                case 29:
                    zzgx.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 30:
                    zzgx.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 31:
                    zzgx.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 32:
                    zzgx.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 33:
                    zzgx.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 34:
                    zzgx.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                    zzgoVar = this;
                    break;
                case 35:
                    zzgx.zzr(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 36:
                    zzgx.zzv(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 37:
                    zzgx.zzx(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 38:
                    zzgx.zzD(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 39:
                    zzgx.zzw(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 40:
                    zzgx.zzu(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 41:
                    zzgx.zzt(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 42:
                    zzgx.zzq(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 43:
                    zzgx.zzC(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 44:
                    zzgx.zzs(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 45:
                    zzgx.zzy(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 46:
                    zzgx.zzz(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 47:
                    zzgx.zzA(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 48:
                    zzgx.zzB(iArr[i4], (List) unsafe.getObject(obj, j), zzhuVar, true);
                    break;
                case 49:
                    int i16 = iArr[i4];
                    List list4 = (List) unsafe.getObject(obj, j);
                    zzgv zzgvVarZzv2 = zzgoVar.zzv(i4);
                    int i17 = zzgx.zza;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i18 = 0; i18 < list4.size(); i18++) {
                            ((zzeq) zzhuVar).zzq(i16, list4.get(i18), zzgvVarZzv2);
                        }
                    }
                    break;
                case 50:
                    if (unsafe.getObject(obj, j) != null) {
                        throw null;
                    }
                    break;
                case 51:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzf(i6, zzm(obj, j));
                    }
                    break;
                case 52:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzo(i6, zzn(obj, j));
                    }
                    break;
                case 53:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzt(i6, zzt(obj, j));
                    }
                    break;
                case 54:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzK(i6, zzt(obj, j));
                    }
                    break;
                case 55:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzr(i6, zzo(obj, j));
                    }
                    break;
                case 56:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzm(i6, zzt(obj, j));
                    }
                    break;
                case 57:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzk(i6, zzo(obj, j));
                    }
                    break;
                case 58:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzb(i6, zzN(obj, j));
                    }
                    break;
                case 59:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzO(i6, unsafe.getObject(obj, j), zzhuVar);
                    }
                    break;
                case 60:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzv(i6, unsafe.getObject(obj, j), zzgoVar.zzv(i4));
                    }
                    break;
                case 61:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzd(i6, (zzei) unsafe.getObject(obj, j));
                    }
                    break;
                case 62:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzI(i6, zzo(obj, j));
                    }
                    break;
                case 63:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzi(i6, zzo(obj, j));
                    }
                    break;
                case 64:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzx(i6, zzo(obj, j));
                    }
                    break;
                case 65:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzz(i6, zzt(obj, j));
                    }
                    break;
                case 66:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzB(i6, zzo(obj, j));
                    }
                    break;
                case 67:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzD(i6, zzt(obj, j));
                    }
                    break;
                case 68:
                    if (zzgoVar.zzM(obj, i6, i4)) {
                        zzhuVar.zzq(i6, unsafe.getObject(obj, j), zzgoVar.zzv(i4));
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
            zzgoVar = this;
        }
        if (entry != null) {
            throw null;
        }
        ((zzfi) obj).zzc.zzl(zzhuVar);
    }

    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzE;
        for (int i = 0; i < this.zzc.length; i += 3) {
            int iZzs = zzs(i);
            long j = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i) || Double.doubleToLongBits(zzho.zza(obj, j)) != Double.doubleToLongBits(zzho.zza(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i) || Float.floatToIntBits(zzho.zzb(obj, j)) != Float.floatToIntBits(zzho.zzb(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i) || zzho.zzw(obj, j) != zzho.zzw(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i) || zzho.zzc(obj, j) != zzho.zzc(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i) || zzho.zzd(obj, j) != zzho.zzd(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
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
                    zZzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
                    break;
                case 50:
                    zZzE = zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j));
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
                    long jZzp = zzp(i) & 1048575;
                    if (zzho.zzc(obj, jZzp) != zzho.zzc(obj2, jZzp) || !zzgx.zzE(zzho.zzf(obj, j), zzho.zzf(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    continue;
                    break;
            }
            if (!zZzE) {
                return false;
            }
        }
        if (!((zzfi) obj).zzc.equals(((zzfi) obj2).zzc)) {
            return false;
        }
        if (this.zzh) {
            return ((zzff) obj).zzb.equals(((zzff) obj2).zzb);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x008d  */
    /* JADX WARN: Code duplicated, block: B:44:0x009c  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2 A[LOOP:1: B:45:0x00a1->B:50:0x00b2, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:67:0x00b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x00c8 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.play_billing.zzgv
    public final boolean zzk(Object obj) {
        int i;
        int i2;
        List list;
        zzgv zzgvVarZzv;
        int i3;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1048575;
        while (i5 < this.zzj) {
            int[] iArr = this.zzi;
            int[] iArr2 = this.zzc;
            int i7 = iArr[i5];
            int i8 = iArr2[i7];
            int iZzs = zzs(i7);
            int i9 = iArr2[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i6) {
                if (i10 != 1048575) {
                    i4 = zzb.getInt(obj, i10);
                }
                i2 = i4;
                i = i10;
            } else {
                int i12 = i4;
                i = i6;
                i2 = i12;
            }
            if ((268435456 & iZzs) != 0 && !zzJ(obj, i7, i, i2, i11)) {
                return false;
            }
            int iZzr = zzr(iZzs);
            if (iZzr == 9 || iZzr == 17) {
                if (zzJ(obj, i7, i, i2, i11) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 27) {
                list = (List) zzho.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    zzgvVarZzv = zzv(i7);
                    for (i3 = 0; i3 < list.size(); i3++) {
                        if (!zzgvVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                }
            } else if (iZzr == 60 || iZzr == 68) {
                if (zzM(obj, i8, i7) && !zzK(obj, iZzs, zzv(i7))) {
                    return false;
                }
            } else if (iZzr == 49) {
                list = (List) zzho.zzf(obj, iZzs & 1048575);
                if (list.isEmpty()) {
                    zzgvVarZzv = zzv(i7);
                    while (i3 < list.size()) {
                        if (!zzgvVarZzv.zzk(list.get(i3))) {
                            return false;
                        }
                    }
                } else {
                    continue;
                }
            } else if (iZzr == 50 && !((zzgf) zzho.zzf(obj, iZzs & 1048575)).isEmpty()) {
                throw null;
            }
            i5++;
            i6 = i;
            i4 = i2;
        }
        return !this.zzh || ((zzff) obj).zzb.zzi();
    }
}
