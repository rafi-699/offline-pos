package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhve extends zzhxi {
    private final zzhvd zza;

    private zzhve(zzhvd zzhvdVar) {
        this.zza = zzhvdVar;
    }

    public static zzhve zzb(zzhvd zzhvdVar) {
        return new zzhve(zzhvdVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzhve) && ((zzhve) obj).zza == this.zza;
    }

    public final int hashCode() {
        return Objects.hash(zzhve.class, this.zza);
    }

    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(string.length() + 30);
        sb.append("Ed25519 Parameters (variant: ");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzheh
    public final boolean zza() {
        return this.zza != zzhvd.zzd;
    }

    public final zzhvd zzc() {
        return this.zza;
    }
}
