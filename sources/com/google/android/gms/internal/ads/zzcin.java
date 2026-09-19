package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcin extends zzaul {
    static final zzcin zzb = new zzcin();

    zzcin() {
    }

    @Override // com.google.android.gms.internal.ads.zzaul
    public final zzaup zza(String str, byte[] bArr, String str2) {
        if ("moov".equals(str)) {
            return new zzaur();
        }
        return "mvhd".equals(str) ? new zzaus() : new zzaut(str);
    }
}
