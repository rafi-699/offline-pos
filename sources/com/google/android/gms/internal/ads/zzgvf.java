package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgvf<K, V> implements zzgxu<K, V> {
    private transient Set zza;
    private transient Collection zzb;
    private transient Map zzc;

    zzgvf() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgxu) {
            return zzu().equals(((zzgxu) obj).zzu());
        }
        return false;
    }

    public final int hashCode() {
        return zzu().hashCode();
    }

    public final String toString() {
        return zzu().toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public boolean zze(Object obj, Object obj2) {
        throw null;
    }

    abstract Set zzh();

    abstract Collection zzj();

    Iterator zzk() {
        throw null;
    }

    abstract Map zzl();

    public boolean zzr(Object obj) {
        Iterator<V> it = zzu().values().iterator();
        while (it.hasNext()) {
            if (((Collection) it.next()).contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final Set zzs() {
        Set set = this.zza;
        if (set != null) {
            return set;
        }
        Set setZzh = zzh();
        this.zza = setZzh;
        return setZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public Collection zzt() {
        Collection collection = this.zzb;
        if (collection != null) {
            return collection;
        }
        Collection collectionZzj = zzj();
        this.zzb = collectionZzj;
        return collectionZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzgxu
    public Map zzu() {
        Map map = this.zzc;
        if (map != null) {
            return map;
        }
        Map mapZzl = zzl();
        this.zzc = mapZzl;
        return mapZzl;
    }
}
