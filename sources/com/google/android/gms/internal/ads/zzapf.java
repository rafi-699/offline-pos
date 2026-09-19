package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzapf implements Comparator {
    static final /* synthetic */ zzapf zza = new zzapf();

    private /* synthetic */ zzapf() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return Long.compare(((zzaow) obj).zzb, ((zzaow) obj2).zzb);
    }
}
