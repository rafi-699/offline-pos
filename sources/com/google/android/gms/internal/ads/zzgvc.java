package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgvc extends zzgvf implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    protected zzgvc(Map map) {
        zzgtj.zza(map.isEmpty());
        this.zza = map;
    }

    Collection zza(Collection collection) {
        throw null;
    }

    Collection zzb(Object obj, Collection collection) {
        throw null;
    }

    abstract Collection zzc();

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgvf, com.google.android.gms.internal.ads.zzgxu
    public final boolean zze(Object obj, Object obj2) {
        Map map = this.zza;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZzc = zzc();
        if (!collectionZzc.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        map.put(obj, collectionZzc);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public final void zzf() {
        Map map = this.zza;
        Iterator it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.zzb = 0;
    }

    final List zzg(Object obj, List list, zzguz zzguzVar) {
        return list instanceof RandomAccess ? new zzguv(this, obj, list, zzguzVar) : new zzgvb(this, obj, list, zzguzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    Set zzh() {
        throw null;
    }

    final Set zzi() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzguu(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzgux(this, (SortedMap) map) : new zzgus(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    final Collection zzj() {
        return new zzgve(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    final Iterator zzk() {
        return new zzgum(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgvf
    Map zzl() {
        throw null;
    }

    final Map zzm() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzgut(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzguw(this, (SortedMap) map) : new zzgup(this, map);
    }

    final /* synthetic */ void zzn(Object obj) {
        Object objRemove;
        try {
            objRemove = this.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.zzb -= size;
        }
    }

    final /* synthetic */ Map zzo() {
        return this.zza;
    }

    final /* synthetic */ int zzp() {
        return this.zzb;
    }

    final /* synthetic */ void zzq(int i) {
        this.zzb = i;
    }
}
