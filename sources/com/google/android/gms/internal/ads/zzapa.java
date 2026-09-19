package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzapa implements Comparable {
    public final int zza;
    public final zzaov zzb;

    public zzapa(int i, zzaov zzaovVar) {
        this.zza = i;
        this.zzb = zzaovVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.zza, ((zzapa) obj).zza);
    }
}
