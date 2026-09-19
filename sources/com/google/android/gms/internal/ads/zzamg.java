package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzamg {
    private static final zzgty zza = zzgty.zza(zzgsx.zzc(':'));
    private static final zzgty zzb = zzgty.zza(zzgsx.zzc('*'));
    private final List zzc = new ArrayList();
    private int zzd = 0;
    private int zze;

    public final void zza() {
        this.zzc.clear();
        this.zzd = 0;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a6 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:39:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:42:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:87:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x011c A[SYNTHETIC] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final int zzb(zzafz zzafzVar, zzagy zzagyVar, List list) throws IOException {
        char c;
        int i;
        ArrayList arrayList;
        List listZze;
        int i2;
        List listZze2;
        int i3 = this.zzd;
        if (i3 == 0) {
            long jZzo = zzafzVar.zzo();
            zzagyVar.zza = (jZzo == -1 || jZzo < 8) ? 0L : jZzo - 8;
            this.zzd = 1;
            return 1;
        }
        int i4 = 8;
        if (i3 != 1) {
            char c2 = 2820;
            short s = 2819;
            short s2 = 2817;
            short s3 = 2816;
            short s4 = 2192;
            if (i3 != 2) {
                long jZzn = zzafzVar.zzn();
                int iZzo = (int) ((zzafzVar.zzo() - zzafzVar.zzn()) - ((long) this.zze));
                zzet zzetVar = new zzet(iZzo);
                zzafzVar.zzc(zzetVar.zzi(), 0, iZzo);
                int i5 = 0;
                while (true) {
                    List list2 = this.zzc;
                    if (i5 >= list2.size()) {
                        zzagyVar.zza = 0L;
                        return 1;
                    }
                    zzamf zzamfVar = (zzamf) list2.get(i5);
                    zzetVar.zzh((int) (zzamfVar.zza - jZzn));
                    zzetVar.zzk(4);
                    int iZzC = zzetVar.zzC();
                    String strZzK = zzetVar.zzK(iZzC, StandardCharsets.UTF_8);
                    switch (strZzK.hashCode()) {
                        case -1711564334:
                            if (!strZzK.equals("SlowMotion_Data")) {
                                throw zzat.zzb("Invalid SEF name", null);
                            }
                            c = 2192;
                            i = zzamfVar.zzb - (iZzC + 8);
                            if (c == 2192) {
                                arrayList = new ArrayList();
                                listZze = zzb.zze(zzetVar.zzK(i, StandardCharsets.UTF_8));
                                for (i2 = 0; i2 < listZze.size(); i2++) {
                                    listZze2 = zza.zze((CharSequence) listZze.get(i2));
                                    if (listZze2.size() != 3) {
                                        throw zzat.zzb(null, null);
                                    }
                                    try {
                                        arrayList.add(new zzajv(Long.parseLong((String) listZze2.get(0)), Long.parseLong((String) listZze2.get(1)), 1 << (Integer.parseInt((String) listZze2.get(2)) - 1)));
                                    } catch (NumberFormatException e) {
                                        throw zzat.zzb(null, e);
                                    }
                                }
                                list.add(new zzajw(arrayList));
                            } else if (c == 2816 && c != 2817 && c != 2819 && c != c2) {
                                throw new IllegalStateException();
                            }
                            i5++;
                            c2 = 2820;
                            break;
                            break;
                        case -1332107749:
                            if (!strZzK.equals("Super_SlowMotion_Edit_Data")) {
                                throw zzat.zzb("Invalid SEF name", null);
                            }
                            c = 2819;
                            i = zzamfVar.zzb - (iZzC + 8);
                            if (c == 2192) {
                                arrayList = new ArrayList();
                                listZze = zzb.zze(zzetVar.zzK(i, StandardCharsets.UTF_8));
                                while (i2 < listZze.size()) {
                                    listZze2 = zza.zze((CharSequence) listZze.get(i2));
                                    if (listZze2.size() != 3) {
                                        throw zzat.zzb(null, null);
                                    }
                                    arrayList.add(new zzajv(Long.parseLong((String) listZze2.get(0)), Long.parseLong((String) listZze2.get(1)), 1 << (Integer.parseInt((String) listZze2.get(2)) - 1)));
                                }
                                list.add(new zzajw(arrayList));
                            } else if (c == 2816) {
                            }
                            i5++;
                            c2 = 2820;
                            break;
                            break;
                        case -1251387154:
                            if (!strZzK.equals("Super_SlowMotion_Data")) {
                                throw zzat.zzb("Invalid SEF name", null);
                            }
                            c = 2816;
                            i = zzamfVar.zzb - (iZzC + 8);
                            if (c == 2192) {
                                arrayList = new ArrayList();
                                listZze = zzb.zze(zzetVar.zzK(i, StandardCharsets.UTF_8));
                                while (i2 < listZze.size()) {
                                    listZze2 = zza.zze((CharSequence) listZze.get(i2));
                                    if (listZze2.size() != 3) {
                                        throw zzat.zzb(null, null);
                                    }
                                    arrayList.add(new zzajv(Long.parseLong((String) listZze2.get(0)), Long.parseLong((String) listZze2.get(1)), 1 << (Integer.parseInt((String) listZze2.get(2)) - 1)));
                                }
                                list.add(new zzajw(arrayList));
                            } else if (c == 2816) {
                            }
                            i5++;
                            c2 = 2820;
                            break;
                            break;
                        case -830665521:
                            if (!strZzK.equals("Super_SlowMotion_Deflickering_On")) {
                                throw zzat.zzb("Invalid SEF name", null);
                            }
                            c = c2;
                            i = zzamfVar.zzb - (iZzC + 8);
                            if (c == 2192) {
                                arrayList = new ArrayList();
                                listZze = zzb.zze(zzetVar.zzK(i, StandardCharsets.UTF_8));
                                while (i2 < listZze.size()) {
                                    listZze2 = zza.zze((CharSequence) listZze.get(i2));
                                    if (listZze2.size() != 3) {
                                        throw zzat.zzb(null, null);
                                    }
                                    arrayList.add(new zzajv(Long.parseLong((String) listZze2.get(0)), Long.parseLong((String) listZze2.get(1)), 1 << (Integer.parseInt((String) listZze2.get(2)) - 1)));
                                }
                                list.add(new zzajw(arrayList));
                            } else if (c == 2816) {
                            }
                            i5++;
                            c2 = 2820;
                            break;
                            break;
                        case 1760745220:
                            if (!strZzK.equals("Super_SlowMotion_BGM")) {
                                throw zzat.zzb("Invalid SEF name", null);
                            }
                            c = 2817;
                            i = zzamfVar.zzb - (iZzC + 8);
                            if (c == 2192) {
                                arrayList = new ArrayList();
                                listZze = zzb.zze(zzetVar.zzK(i, StandardCharsets.UTF_8));
                                while (i2 < listZze.size()) {
                                    listZze2 = zza.zze((CharSequence) listZze.get(i2));
                                    if (listZze2.size() != 3) {
                                        throw zzat.zzb(null, null);
                                    }
                                    arrayList.add(new zzajv(Long.parseLong((String) listZze2.get(0)), Long.parseLong((String) listZze2.get(1)), 1 << (Integer.parseInt((String) listZze2.get(2)) - 1)));
                                }
                                list.add(new zzajw(arrayList));
                            } else if (c == 2816) {
                            }
                            i5++;
                            c2 = 2820;
                            break;
                            break;
                        default:
                            throw zzat.zzb("Invalid SEF name", null);
                    }
                }
            } else {
                long jZzo2 = zzafzVar.zzo();
                int i6 = this.zze - 20;
                zzet zzetVar2 = new zzet(i6);
                zzafzVar.zzc(zzetVar2.zzi(), 0, i6);
                int i7 = 0;
                while (i7 < i6 / 12) {
                    zzetVar2.zzk(2);
                    zzet zzetVar3 = zzetVar2;
                    short sZzw = zzetVar3.zzw();
                    if (sZzw == s4 || sZzw == s3 || sZzw == s2 || sZzw == s || sZzw == 2820) {
                        this.zzc.add(new zzamf(sZzw, (jZzo2 - ((long) this.zze)) - ((long) zzetVar3.zzC()), zzetVar3.zzC()));
                    } else {
                        zzetVar3.zzk(i4);
                    }
                    i7++;
                    i6 = i6;
                    zzetVar2 = zzetVar3;
                    i4 = 8;
                    s = 2819;
                    s2 = 2817;
                    s3 = 2816;
                    s4 = 2192;
                }
                List list3 = this.zzc;
                if (list3.isEmpty()) {
                    zzagyVar.zza = 0L;
                } else {
                    this.zzd = 3;
                    zzagyVar.zza = ((zzamf) list3.get(0)).zza;
                }
            }
        } else {
            zzet zzetVar4 = new zzet(8);
            zzafzVar.zzc(zzetVar4.zzi(), 0, 8);
            this.zze = zzetVar4.zzC() + 8;
            if (zzetVar4.zzB() != 1397048916) {
                zzagyVar.zza = 0L;
            } else {
                zzagyVar.zza = zzafzVar.zzn() - ((long) (this.zze - 12));
                this.zzd = 2;
            }
        }
        return 1;
    }
}
