package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgww<E> extends zzgwi<E> implements Set<E> {
    private transient zzgwm zza;

    zzgww() {
    }

    public static zzgww zzh() {
        return zzgyn.zza;
    }

    public static zzgww zzi(Object obj) {
        return new zzgyx(obj);
    }

    public static zzgww zzj(Object obj, Object obj2) {
        return zzw(2, obj, obj2);
    }

    public static zzgww zzk(Object obj, Object obj2, Object obj3) {
        return zzw(3, obj, obj2, obj3);
    }

    public static zzgww zzl(Object obj, Object obj2, Object obj3, Object obj4) {
        return zzw(4, obj, obj2, obj3, obj4);
    }

    public static zzgww zzm(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzw(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzgww zzn(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        int length = objArr.length;
        int i = length + 6;
        Object[] objArr2 = new Object[i];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, length);
        return zzw(i, objArr2);
    }

    static int zzo(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzgtj.zzb(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzgww zzp(Collection collection) {
        if ((collection instanceof zzgww) && !(collection instanceof SortedSet)) {
            zzgww zzgwwVar = (zzgww) collection;
            if (!zzgwwVar.zzf()) {
                return zzgwwVar;
            }
        }
        Object[] array = collection.toArray();
        return zzw(array.length, array);
    }

    public static zzgww zzq(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? zzw(length, (Object[]) objArr.clone()) : new zzgyx(objArr[0]);
        }
        return zzgyn.zza;
    }

    public static zzgwv zzt(int i) {
        zzgvi.zzb(i, "expectedSize");
        return new zzgwv(i, true);
    }

    public static boolean zzx(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzgww) && zzr() && ((zzgww) obj).zzr() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzgyw.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzgyw.zzc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza */
    public abstract zzgza iterator();

    @Override // com.google.android.gms.internal.ads.zzgwi
    public zzgwm zze() {
        zzgwm zzgwmVar = this.zza;
        if (zzgwmVar != null) {
            return zzgwmVar;
        }
        zzgwm zzgwmVarZzs = zzs();
        this.zza = zzgwmVarZzs;
        return zzgwmVarZzs;
    }

    boolean zzr() {
        return false;
    }

    zzgwm zzs() {
        Object[] array = toArray();
        int i = zzgwm.zzd;
        return zzgwm.zzt(array, array.length);
    }

    public static zzgww zzw(int i, Object... objArr) {
        if (i == 0) {
            return zzgyn.zza;
        }
        if (i == 1) {
            return new zzgyx(Objects.requireNonNull(objArr[0]));
        }
        int iZzo = zzo(i);
        Object[] objArr2 = new Object[iZzo];
        int i2 = iZzo - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object obj = objArr[i5];
            zzgyf.zzb(obj, i5);
            int iHashCode = obj.hashCode();
            int iZza = zzgwf.zza(iHashCode);
            while (true) {
                int i6 = iZza & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = obj;
                    objArr2[i6] = obj;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(obj)) {
                    break;
                }
                iZza++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new zzgyx(Objects.requireNonNull(objArr[0]));
        }
        if (zzo(i4) < iZzo / 2) {
            return zzw(i4, objArr);
        }
        if (zzx(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new zzgyn(objArr, i3, objArr2, i2, i4);
    }
}
