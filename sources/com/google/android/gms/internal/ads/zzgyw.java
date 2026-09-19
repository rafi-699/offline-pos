package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgyw {
    public static zzgyv zza(Set set, Set set2) {
        zzgtj.zzk(set, "set1");
        zzgtj.zzk(set2, "set2");
        return new zzgyr(set, set2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Set zzb(Set set, zzgtk zzgtkVar) {
        if (!(set instanceof SortedSet)) {
            if (!(set instanceof zzgys)) {
                set.getClass();
                return new zzgys(set, zzgtkVar);
            }
            zzgys zzgysVar = (zzgys) set;
            return new zzgys((Set) zzgysVar.zza, zzgtn.zzb(zzgysVar.zzb, zzgtkVar));
        }
        SortedSet sortedSet = (SortedSet) set;
        if (!(sortedSet instanceof zzgys)) {
            sortedSet.getClass();
            return new zzgyt(sortedSet, zzgtkVar);
        }
        zzgys zzgysVar2 = (zzgys) sortedSet;
        return new zzgyt((SortedSet) zzgysVar2.zza, zzgtn.zzb(zzgysVar2.zzb, zzgtkVar));
    }

    static int zzc(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    static boolean zzd(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size() && set.containsAll(set2)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static boolean zze(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    static boolean zzf(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzgyd) {
            collection = ((zzgyd) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zze(set, collection.iterator());
        }
        Iterator it = set.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
