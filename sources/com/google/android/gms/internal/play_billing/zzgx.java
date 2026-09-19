package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgx {
    public static final /* synthetic */ int zza = 0;
    private static final zzhh zzb;

    static {
        int i = zzgs.zza;
        zzb = new zzhj();
    }

    public static void zzA(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzC(i, list, z);
    }

    public static void zzB(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzE(i, list, z);
    }

    public static void zzC(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzJ(i, list, z);
    }

    public static void zzD(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzL(i, list, z);
    }

    static boolean zzE(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static int zza(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfj)) {
            int iZzD = 0;
            while (i < size) {
                iZzD += zzep.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzD;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzD2 = 0;
        while (i < size) {
            iZzD2 += zzep.zzD(zzfjVar.zze(i));
            i++;
        }
        return iZzD2;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzep.zzC(i << 3) + 4);
    }

    static int zzc(List list) {
        return list.size() * 4;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * (zzep.zzC(i << 3) + 8);
    }

    static int zze(List list) {
        return list.size() * 8;
    }

    static int zzf(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfj)) {
            int iZzD = 0;
            while (i < size) {
                iZzD += zzep.zzD(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzD;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzD2 = 0;
        while (i < size) {
            iZzD2 += zzep.zzD(zzfjVar.zze(i));
            i++;
        }
        return iZzD2;
    }

    static int zzg(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzga)) {
            int iZzD = 0;
            while (i < size) {
                iZzD += zzep.zzD(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzD;
        }
        zzga zzgaVar = (zzga) list;
        int iZzD2 = 0;
        while (i < size) {
            iZzD2 += zzep.zzD(zzgaVar.zze(i));
            i++;
        }
        return iZzD2;
    }

    static int zzh(int i, Object obj, zzgv zzgvVar) {
        int i2 = i << 3;
        if (!(obj instanceof zzfw)) {
            return zzep.zzC(i2) + zzep.zzA((zzgl) obj, zzgvVar);
        }
        int iZzC = zzep.zzC(i2);
        int iZza = ((zzfw) obj).zza();
        return iZzC + zzep.zzC(iZza) + iZza;
    }

    static int zzi(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfj)) {
            int iZzC = 0;
            while (i < size) {
                int iIntValue = ((Integer) list.get(i)).intValue();
                iZzC += zzep.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
                i++;
            }
            return iZzC;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzC2 = 0;
        while (i < size) {
            int iZze = zzfjVar.zze(i);
            iZzC2 += zzep.zzC((iZze >> 31) ^ (iZze + iZze));
            i++;
        }
        return iZzC2;
    }

    static int zzj(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzga)) {
            int iZzD = 0;
            while (i < size) {
                long jLongValue = ((Long) list.get(i)).longValue();
                iZzD += zzep.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
                i++;
            }
            return iZzD;
        }
        zzga zzgaVar = (zzga) list;
        int iZzD2 = 0;
        while (i < size) {
            long jZze = zzgaVar.zze(i);
            iZzD2 += zzep.zzD((jZze >> 63) ^ (jZze + jZze));
            i++;
        }
        return iZzD2;
    }

    static int zzk(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzfj)) {
            int iZzC = 0;
            while (i < size) {
                iZzC += zzep.zzC(((Integer) list.get(i)).intValue());
                i++;
            }
            return iZzC;
        }
        zzfj zzfjVar = (zzfj) list;
        int iZzC2 = 0;
        while (i < size) {
            iZzC2 += zzep.zzC(zzfjVar.zze(i));
            i++;
        }
        return iZzC2;
    }

    static int zzl(List list) {
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (!(list instanceof zzga)) {
            int iZzD = 0;
            while (i < size) {
                iZzD += zzep.zzD(((Long) list.get(i)).longValue());
                i++;
            }
            return iZzD;
        }
        zzga zzgaVar = (zzga) list;
        int iZzD2 = 0;
        while (i < size) {
            iZzD2 += zzep.zzD(zzgaVar.zze(i));
            i++;
        }
        return iZzD2;
    }

    public static zzhh zzm() {
        return zzb;
    }

    static Object zzn(Object obj, int i, int i2, Object obj2, zzhh zzhhVar) {
        if (obj2 == null) {
            obj2 = zzhhVar.zza(obj);
        }
        ((zzhi) obj2).zzj(i << 3, Long.valueOf(i2));
        return obj2;
    }

    static void zzo(zzev zzevVar, Object obj, Object obj2) {
        if (((zzff) obj2).zzb.zza.isEmpty()) {
            return;
        }
        throw null;
    }

    static void zzp(zzhh zzhhVar, Object obj, Object obj2) {
        zzfi zzfiVar = (zzfi) obj;
        zzhi zzhiVarZze = zzfiVar.zzc;
        zzhi zzhiVar = ((zzfi) obj2).zzc;
        if (!zzhi.zzc().equals(zzhiVar)) {
            if (zzhi.zzc().equals(zzhiVarZze)) {
                zzhiVarZze = zzhi.zze(zzhiVarZze, zzhiVar);
            } else {
                zzhiVarZze.zzd(zzhiVar);
            }
        }
        zzfiVar.zzc = zzhiVarZze;
    }

    public static void zzq(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzc(i, list, z);
    }

    public static void zzr(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzg(i, list, z);
    }

    public static void zzs(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzj(i, list, z);
    }

    public static void zzt(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzl(i, list, z);
    }

    public static void zzu(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzn(i, list, z);
    }

    public static void zzv(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzp(i, list, z);
    }

    public static void zzw(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzs(i, list, z);
    }

    public static void zzx(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzu(i, list, z);
    }

    public static void zzy(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzy(i, list, z);
    }

    public static void zzz(int i, List list, zzhu zzhuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzhuVar.zzA(i, list, z);
    }
}
