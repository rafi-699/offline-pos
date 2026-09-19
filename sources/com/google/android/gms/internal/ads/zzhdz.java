package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhdz {
    private static final zzhdx zza = zzhdy.zza;
    private final zzhdq zzb;
    private final zzhds zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzhdx zzg;
    private final int zzh;

    /* synthetic */ zzhdz(zzhdq zzhdqVar, int i, int i2, boolean z, boolean z2, zzhdx zzhdxVar, byte[] bArr) {
        this.zzb = zzhdqVar;
        this.zzh = i;
        int i3 = i - 2;
        this.zzc = i3 != 1 ? i3 != 3 ? zzhds.zzb : zzhds.zzc : zzhds.zza;
        this.zzd = i2;
        this.zze = z;
        this.zzf = z2;
        this.zzg = zzhdxVar;
    }

    public final zzhdq zza() {
        this.zzg.zza(this);
        return this.zzb;
    }

    public final zzhds zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zze;
    }

    final /* synthetic */ zzhdq zzf() {
        return this.zzb;
    }

    final /* synthetic */ int zzg() {
        return this.zzd;
    }

    final /* synthetic */ boolean zzh() {
        return this.zze;
    }

    final /* synthetic */ boolean zzi() {
        return this.zzf;
    }

    final /* synthetic */ int zzj() {
        return this.zzh;
    }
}
