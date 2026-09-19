package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhii extends zzheu {
    private final zzhih zza;

    private zzhii(zzhih zzhihVar) {
        this.zza = zzhihVar;
    }

    public static zzhii zzb(zzhih zzhihVar) {
        return new zzhii(zzhihVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhii) && ((zzhii) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzhii.class, this.zza);
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 40);
        sb.append("XChaCha20Poly1305 Parameters (variant: ");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zza != zzhih.zzc;
    }

    public final zzhih zzc() {
        return this.zza;
    }
}
