package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzguf {
    public static zzgub zza(zzgub zzgubVar) {
        if ((zzgubVar instanceof zzgue) || (zzgubVar instanceof zzguc)) {
            return zzgubVar;
        }
        return zzgubVar instanceof Serializable ? new zzguc(zzgubVar) : new zzgue(zzgubVar);
    }
}
