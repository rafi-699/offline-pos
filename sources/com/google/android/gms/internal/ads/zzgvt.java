package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgvt extends AbstractMap implements Serializable {
    private static final Object zzd = new Object();
    transient int[] zza;
    transient Object[] zzb;
    transient Object[] zzc;
    private transient Object zze;
    private transient int zzf;
    private transient int zzg;
    private transient Set zzh;
    private transient Set zzi;
    private transient Collection zzj;

    zzgvt() {
        zza(3);
    }

    /* JADX INFO: renamed from: zzA */
    public final int[] zzl() {
        return (int[]) Objects.requireNonNull(this.zza);
    }

    /* JADX INFO: renamed from: zzB */
    public final Object[] zzm() {
        return (Object[]) Objects.requireNonNull(this.zzb);
    }

    /* JADX INFO: renamed from: zzC */
    public final Object[] zzn() {
        return (Object[]) Objects.requireNonNull(this.zzc);
    }

    private final void zzv(int i) {
        this.zzf = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.zzf & (-32));
    }

    /* JADX INFO: renamed from: zzw */
    public final int zzh() {
        return (1 << (this.zzf & 31)) - 1;
    }

    private final int zzx(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object objZza = zzgvu.zza(i2);
        if (i4 != 0) {
            zzgvu.zzc(objZza, i3 & i5, i4 + 1);
        }
        Object objRequireNonNull = Objects.requireNonNull(this.zze);
        int[] iArrZzl = zzl();
        for (int i6 = 0; i6 <= i; i6++) {
            int iZzb = zzgvu.zzb(objRequireNonNull, i6);
            while (iZzb != 0) {
                int i7 = iZzb - 1;
                int i8 = iArrZzl[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iZzb2 = zzgvu.zzb(objZza, i10);
                zzgvu.zzc(objZza, i10, iZzb);
                iArrZzl[i7] = ((~i5) & i9) | (iZzb2 & i5);
                iZzb = i8 & i;
            }
        }
        this.zze = objZza;
        zzv(i5);
        return i5;
    }

    /* JADX INFO: renamed from: zzy */
    public final int zzi(Object obj) {
        if (zzb()) {
            return -1;
        }
        int iZzb = zzgwf.zzb(obj);
        int iZzh = zzh();
        int iZzb2 = zzgvu.zzb(Objects.requireNonNull(this.zze), iZzb & iZzh);
        if (iZzb2 != 0) {
            int i = ~iZzh;
            int i2 = iZzb & i;
            do {
                int i3 = iZzb2 - 1;
                int i4 = zzl()[i3];
                if ((i4 & i) == i2 && Objects.equals(obj, zzm()[i3])) {
                    return i3;
                }
                iZzb2 = i4 & iZzh;
            } while (iZzb2 != 0);
        }
        return -1;
    }

    /* JADX INFO: renamed from: zzz */
    public final Object zzj(Object obj) {
        int iZzh;
        int iZze;
        if (zzb() || (iZze = zzgvu.zze(obj, null, (iZzh = zzh()), Objects.requireNonNull(this.zze), zzl(), zzm(), null)) == -1) {
            return zzd;
        }
        Object obj2 = zzn()[iZze];
        zze(iZze, iZzh);
        this.zzg--;
        zzd();
        return obj2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (zzb()) {
            return;
        }
        zzd();
        Map mapZzc = zzc();
        if (mapZzc != null) {
            this.zzf = zzhah.zzc(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            mapZzc.clear();
            this.zze = null;
            this.zzg = 0;
            return;
        }
        Arrays.fill(zzm(), 0, this.zzg, (Object) null);
        Arrays.fill(zzn(), 0, this.zzg, (Object) null);
        Object objRequireNonNull = Objects.requireNonNull(this.zze);
        if (objRequireNonNull instanceof byte[]) {
            Arrays.fill((byte[]) objRequireNonNull, (byte) 0);
        } else if (objRequireNonNull instanceof short[]) {
            Arrays.fill((short[]) objRequireNonNull, (short) 0);
        } else {
            Arrays.fill((int[]) objRequireNonNull, 0);
        }
        Arrays.fill(zzl(), 0, this.zzg, 0);
        this.zzg = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.containsKey(obj);
        }
        return zzi(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.containsValue(obj);
        }
        for (int i = 0; i < this.zzg; i++) {
            if (Objects.equals(obj, zzn()[i])) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.zzi;
        if (set != null) {
            return set;
        }
        zzgvo zzgvoVar = new zzgvo(this, null);
        this.zzi = zzgvoVar;
        return zzgvoVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.get(obj);
        }
        int iZzi = zzi(obj);
        if (iZzi == -1) {
            return null;
        }
        return zzn()[iZzi];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.zzh;
        if (set != null) {
            return set;
        }
        zzgvq zzgvqVar = new zzgvq(this, null);
        this.zzh = zzgvqVar;
        return zzgvqVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int i;
        if (zzb()) {
            zzgtj.zzj(zzb(), "Arrays already allocated");
            int i2 = this.zzf;
            int iMax = Math.max(i2 + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.zze = zzgvu.zza(iMax2);
            zzv(iMax2 - 1);
            this.zza = new int[i2];
            this.zzb = new Object[i2];
            this.zzc = new Object[i2];
        }
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.put(obj, obj2);
        }
        int[] iArrZzl = zzl();
        Object[] objArrZzm = zzm();
        Object[] objArrZzn = zzn();
        int i3 = this.zzg;
        int i4 = i3 + 1;
        int iZzb = zzgwf.zzb(obj);
        int iZzh = zzh();
        int i5 = iZzb & iZzh;
        int iZzb2 = zzgvu.zzb(Objects.requireNonNull(this.zze), i5);
        if (iZzb2 == 0) {
            if (i4 > iZzh) {
                iZzh = zzx(iZzh, zzgvu.zzd(iZzh), iZzb, i3);
            } else {
                zzgvu.zzc(Objects.requireNonNull(this.zze), i5, i4);
            }
            i = 1;
        } else {
            int i6 = ~iZzh;
            int i7 = iZzb & i6;
            int i8 = 0;
            while (true) {
                int i9 = iZzb2 - 1;
                int i10 = iArrZzl[i9];
                i = 1;
                int i11 = i10 & i6;
                if (i11 == i7 && Objects.equals(obj, objArrZzm[i9])) {
                    Object obj3 = objArrZzn[i9];
                    objArrZzn[i9] = obj2;
                    return obj3;
                }
                int i12 = i10 & iZzh;
                i8++;
                if (i12 == 0) {
                    if (i8 < 9) {
                        if (i4 <= iZzh) {
                            iArrZzl[i9] = (i4 & iZzh) | i11;
                            break;
                        }
                        iZzh = zzx(iZzh, zzgvu.zzd(iZzh), iZzb, i3);
                        break;
                    }
                    LinkedHashMap linkedHashMap = new LinkedHashMap(zzh() + 1, 1.0f);
                    int iZzf = zzf();
                    while (iZzf >= 0) {
                        linkedHashMap.put(zzm()[iZzf], zzn()[iZzf]);
                        iZzf = zzg(iZzf);
                    }
                    this.zze = linkedHashMap;
                    this.zza = null;
                    this.zzb = null;
                    this.zzc = null;
                    zzd();
                    return linkedHashMap.put(obj, obj2);
                }
                iZzb2 = i12;
            }
        }
        int length = zzl().length;
        if (i4 > length) {
            int i13 = i;
            int iMin = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(i13, length >>> 1) + length) | i13);
            if (iMin != length) {
                this.zza = Arrays.copyOf(zzl(), iMin);
                this.zzb = Arrays.copyOf(zzm(), iMin);
                this.zzc = Arrays.copyOf(zzn(), iMin);
            }
        }
        zzl()[i3] = (~iZzh) & iZzb;
        zzm()[i3] = obj;
        zzn()[i3] = obj2;
        this.zzg = i4;
        zzd();
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapZzc = zzc();
        if (mapZzc != null) {
            return mapZzc.remove(obj);
        }
        Object objZzj = zzj(obj);
        if (objZzj == zzd) {
            return null;
        }
        return objZzj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapZzc = zzc();
        return mapZzc != null ? mapZzc.size() : this.zzg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.zzj;
        if (collection != null) {
            return collection;
        }
        zzgvs zzgvsVar = new zzgvs(this, null);
        this.zzj = zzgvsVar;
        return zzgvsVar;
    }

    final void zza(int i) {
        this.zzf = zzhah.zzc(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    final boolean zzb() {
        return this.zze == null;
    }

    final Map zzc() {
        Object obj = this.zze;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    final void zzd() {
        this.zzf += 32;
    }

    final void zze(int i, int i2) {
        Object objRequireNonNull = Objects.requireNonNull(this.zze);
        int[] iArrZzl = zzl();
        Object[] objArrZzm = zzm();
        Object[] objArrZzn = zzn();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrZzm[i] = null;
            objArrZzn[i] = null;
            iArrZzl[i] = 0;
            return;
        }
        int i4 = i + 1;
        Object obj = objArrZzm[i3];
        objArrZzm[i] = obj;
        objArrZzn[i] = objArrZzn[i3];
        objArrZzm[i3] = null;
        objArrZzn[i3] = null;
        iArrZzl[i] = iArrZzl[i3];
        iArrZzl[i3] = 0;
        int iZzb = zzgwf.zzb(obj) & i2;
        int iZzb2 = zzgvu.zzb(objRequireNonNull, iZzb);
        if (iZzb2 == size) {
            zzgvu.zzc(objRequireNonNull, iZzb, i4);
            return;
        }
        while (true) {
            int i5 = iZzb2 - 1;
            int i6 = iArrZzl[i5];
            int i7 = i6 & i2;
            if (i7 == size) {
                iArrZzl[i5] = (i6 & (~i2)) | (i2 & i4);
                return;
            }
            iZzb2 = i7;
        }
    }

    final int zzf() {
        return isEmpty() ? -1 : 0;
    }

    final int zzg(int i) {
        int i2 = i + 1;
        if (i2 < this.zzg) {
            return i2;
        }
        return -1;
    }

    final /* synthetic */ Object zzk() {
        return Objects.requireNonNull(this.zze);
    }

    final /* synthetic */ Object zzo(int i) {
        return zzm()[i];
    }

    final /* synthetic */ Object zzp(int i) {
        return zzn()[i];
    }

    final /* synthetic */ void zzq(int i, Object obj) {
        zzn()[i] = obj;
    }

    final /* synthetic */ int zzs() {
        return this.zzf;
    }

    final /* synthetic */ int zzt() {
        return this.zzg;
    }

    final /* synthetic */ void zzu(int i) {
        this.zzg = i;
    }

    zzgvt(int i) {
        zza(8);
    }
}
