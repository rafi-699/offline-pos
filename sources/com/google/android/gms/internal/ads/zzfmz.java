package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfmz implements zzfmx {
    private final String zza;

    public zzfmz(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfmx
    public final boolean equals(Object obj) {
        if (obj instanceof zzfmz) {
            return this.zza.equals(((zzfmz) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfmx
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
