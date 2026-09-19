package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzez {
    private static final zzez zzb = new zzez(true);
    final zzhd zza = new zzgy();
    private boolean zzc;
    private boolean zzd;

    private zzez() {
    }

    static int zza(zzhs zzhsVar, int i, Object obj) {
        int iZzC = zzep.zzC(i << 3);
        if (zzhsVar == zzhs.GROUP) {
            zzfo.zzd((zzgl) obj);
            iZzC += iZzC;
        }
        return iZzC + zzb(zzhsVar, obj);
    }

    static int zzb(zzhs zzhsVar, Object obj) {
        int iZzd;
        int iZzC;
        zzhs zzhsVar2 = zzhs.DOUBLE;
        zzht zzhtVar = zzht.INT;
        switch (zzhsVar.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                int i = zzep.zzb;
                return 8;
            case 1:
                ((Float) obj).floatValue();
                int i2 = zzep.zzb;
                return 4;
            case 2:
                return zzep.zzD(((Long) obj).longValue());
            case 3:
                return zzep.zzD(((Long) obj).longValue());
            case 4:
                return zzep.zzD(((Integer) obj).intValue());
            case 5:
                ((Long) obj).longValue();
                int i3 = zzep.zzb;
                return 8;
            case 6:
                ((Integer) obj).intValue();
                int i4 = zzep.zzb;
                return 4;
            case 7:
                ((Boolean) obj).booleanValue();
                int i5 = zzep.zzb;
                return 1;
            case 8:
                if (!(obj instanceof zzei)) {
                    return zzep.zzB((String) obj);
                }
                int i6 = zzep.zzb;
                iZzd = ((zzei) obj).zzd();
                iZzC = zzep.zzC(iZzd);
                break;
                break;
            case 9:
                return ((zzgl) obj).zzj();
            case 10:
                if (!(obj instanceof zzfv)) {
                    return zzep.zzz((zzgl) obj);
                }
                int i7 = zzep.zzb;
                iZzd = ((zzfv) obj).zza();
                iZzC = zzep.zzC(iZzd);
                break;
                break;
            case 11:
                if (!(obj instanceof zzei)) {
                    int i8 = zzep.zzb;
                    iZzd = ((byte[]) obj).length;
                    iZzC = zzep.zzC(iZzd);
                } else {
                    int i9 = zzep.zzb;
                    iZzd = ((zzei) obj).zzd();
                    iZzC = zzep.zzC(iZzd);
                }
                break;
            case 12:
                return zzep.zzC(((Integer) obj).intValue());
            case 13:
                return obj instanceof zzfk ? zzep.zzD(((zzfk) obj).zza()) : zzep.zzD(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).intValue();
                int i10 = zzep.zzb;
                return 4;
            case 15:
                ((Long) obj).longValue();
                int i11 = zzep.zzb;
                return 8;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                return zzep.zzC((iIntValue >> 31) ^ (iIntValue + iIntValue));
            case 17:
                long jLongValue = ((Long) obj).longValue();
                return zzep.zzD((jLongValue >> 63) ^ (jLongValue + jLongValue));
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZzC + iZzd;
    }

    public static int zzc(zzey zzeyVar, Object obj) {
        zzhs zzhsVarZzb = zzeyVar.zzb();
        int iZza = zzeyVar.zza();
        if (!zzeyVar.zze()) {
            return zza(zzhsVarZzb, iZza, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i = 0;
        if (!zzeyVar.zzd()) {
            int iZza2 = 0;
            while (i < size) {
                iZza2 += zza(zzhsVarZzb, iZza, list.get(i));
                i++;
            }
            return iZza2;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iZzb = 0;
        while (i < size) {
            iZzb += zzb(zzhsVarZzb, list.get(i));
            i++;
        }
        return zzep.zzC(iZza << 3) + iZzb + zzep.zzC(iZzb);
    }

    public static zzez zze() {
        return zzb;
    }

    private static boolean zzj(Map.Entry entry) {
        zzey zzeyVar = (zzey) entry.getKey();
        if (zzeyVar.zzc() != zzht.MESSAGE) {
            return true;
        }
        if (!zzeyVar.zze()) {
            return zzk(entry.getValue());
        }
        List list = (List) entry.getValue();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!zzk(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzk(Object obj) {
        if (obj instanceof zzgm) {
            return ((zzgm) obj).zzk();
        }
        if (obj instanceof zzfv) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzl(Map.Entry entry) {
        int i;
        int iZzC;
        int iZzC2;
        zzey zzeyVar = (zzey) entry.getKey();
        Object value = entry.getValue();
        if (zzeyVar.zzc() != zzht.MESSAGE || zzeyVar.zze() || zzeyVar.zzd()) {
            return zzc(zzeyVar, value);
        }
        if (value instanceof zzfv) {
            int iZza = ((zzey) entry.getKey()).zza();
            int iZzC3 = zzep.zzC(8);
            i = iZzC3 + iZzC3;
            iZzC = zzep.zzC(16) + zzep.zzC(iZza);
            int iZzC4 = zzep.zzC(24);
            int iZza2 = ((zzfv) value).zza();
            iZzC2 = iZzC4 + zzep.zzC(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzey) entry.getKey()).zza();
            int iZzC5 = zzep.zzC(8);
            i = iZzC5 + iZzC5;
            iZzC = zzep.zzC(16) + zzep.zzC(iZza3);
            iZzC2 = zzep.zzC(24) + zzep.zzz((zzgl) value);
        }
        return i + iZzC + iZzC2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:? A[RETURN, SYNTHETIC] */
    private static final void zzm(zzey zzeyVar, Object obj) {
        boolean z;
        zzhs zzhsVarZzb = zzeyVar.zzb();
        byte[] bArr = zzfo.zzb;
        obj.getClass();
        zzhs zzhsVar = zzhs.DOUBLE;
        zzht zzhtVar = zzht.INT;
        switch (zzhsVarZzb.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case 1:
                z = obj instanceof Long;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case 2:
                z = obj instanceof Float;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case 3:
                z = obj instanceof Double;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case 4:
                z = obj instanceof Boolean;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case 5:
                z = obj instanceof String;
                if (z) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case 6:
                if ((obj instanceof zzei) || (obj instanceof byte[])) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzfk)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            case 8:
                if ((obj instanceof zzgl) || (obj instanceof zzfv)) {
                    return;
                }
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzeyVar.zza()), zzeyVar.zzb().zza(), obj.getClass().getName()));
        }
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzez zzezVar = new zzez();
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = zzhdVar.zzg(i);
            zzezVar.zzh((zzey) ((zzgz) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : zzhdVar.zzd()) {
            zzezVar.zzh((zzey) entry.getKey(), entry.getValue());
        }
        zzezVar.zzd = this.zzd;
        return zzezVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzez) {
            return this.zza.equals(((zzez) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzd() {
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        int iZzl = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzl += zzl(zzhdVar.zzg(i));
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            iZzl += zzl((Map.Entry) it.next());
        }
        return iZzl;
    }

    public final Iterator zzf() {
        zzhd zzhdVar = this.zza;
        if (zzhdVar.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzd ? new zzft(zzhdVar.entrySet().iterator()) : zzhdVar.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            Object value = zzhdVar.zzg(i).getValue();
            if (value instanceof zzfi) {
                ((zzfi) value).zzu();
            }
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            Object value2 = ((Map.Entry) it.next()).getValue();
            if (value2 instanceof zzfi) {
                ((zzfi) value2).zzu();
            }
        }
        zzhdVar.zza();
        this.zzc = true;
    }

    public final void zzh(zzey zzeyVar, Object obj) {
        if (!zzeyVar.zze()) {
            zzm(zzeyVar, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) obj;
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                Object obj2 = list.get(i);
                zzm(zzeyVar, obj2);
                arrayList.add(obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzfv) {
            this.zzd = true;
        }
        this.zza.put(zzeyVar, obj);
    }

    public final boolean zzi() {
        zzhd zzhdVar = this.zza;
        int iZzc = zzhdVar.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzj(zzhdVar.zzg(i))) {
                return false;
            }
        }
        Iterator it = zzhdVar.zzd().iterator();
        while (it.hasNext()) {
            if (!zzj((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzez(boolean z) {
        zzg();
        zzg();
    }
}
