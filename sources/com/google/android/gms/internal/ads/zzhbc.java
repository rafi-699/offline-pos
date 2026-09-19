package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzhbc extends zzhap.zzf {
    private static final zzhaz zzbq;
    private static final zzhce zzbr = new zzhce(zzhbc.class);
    volatile int remainingField;
    volatile Set<Throwable> seenExceptionsField = null;

    static {
        Throwable th;
        zzhaz zzhbbVar;
        try {
            zzhbbVar = new zzhba(null);
            th = null;
        } catch (Throwable th2) {
            th = th2;
            zzhbbVar = new zzhbb(null);
        }
        zzbq = zzhbbVar;
        if (th != null) {
            zzbr.zza().logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFutureState", "<clinit>", "SafeAtomicHelper is broken!", th);
        }
    }

    zzhbc(int i) {
        this.remainingField = i;
    }

    final Set zzB() {
        Set<Throwable> set = this.seenExceptionsField;
        if (set != null) {
            return set;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        zzf(setNewSetFromMap);
        zzbq.zza(this, null, setNewSetFromMap);
        return (Set) Objects.requireNonNull(this.seenExceptionsField);
    }

    final int zzC() {
        return zzbq.zzb(this);
    }

    abstract void zzf(Set set);
}
