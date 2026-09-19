package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzacf implements Comparator {
    static final /* synthetic */ zzacf zza = new zzacf();

    private /* synthetic */ zzacf() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return Float.compare(((zzace) obj).zzc, ((zzace) obj2).zzc);
    }
}
