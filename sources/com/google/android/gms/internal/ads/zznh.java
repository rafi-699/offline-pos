package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznh {
    public static final zznh zza = new zznh(new zzng());
    public final zzgww zzb;
    public final Double zzc = null;
    public final Double zzd = null;
    public final boolean zze = true;
    public final boolean zzf = true;
    public final boolean zzi = true;
    public final boolean zzg = true;
    public final boolean zzh = true;

    private zznh(zzng zzngVar) {
        this.zzb = zzngVar.zza();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zznh)) {
            return false;
        }
        zznh zznhVar = (zznh) obj;
        if (!this.zzb.equals(zznhVar.zzb)) {
            return false;
        }
        boolean z = zznhVar.zzf;
        boolean z2 = zznhVar.zzi;
        Double d = zznhVar.zzc;
        if (!Objects.equals(null, null)) {
            return false;
        }
        Double d2 = zznhVar.zzd;
        if (!Objects.equals(null, null)) {
            return false;
        }
        boolean z3 = zznhVar.zze;
        boolean z4 = zznhVar.zzg;
        boolean z5 = zznhVar.zzh;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.zzb, null, null, true, true, true, true, true);
    }
}
