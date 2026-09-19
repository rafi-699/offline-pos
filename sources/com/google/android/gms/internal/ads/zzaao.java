package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaao extends zzaaq implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;

    public zzaao(int i, zzbg zzbgVar, int i2, zzaam zzaamVar, int i3, String str, String str2) {
        int iZzj;
        int i4;
        boolean z;
        super(i, zzbgVar, i2);
        int i5 = 0;
        this.zzf = zznc.zzac(i3, false);
        int i6 = this.zzd.zze;
        int i7 = zzaamVar.zzC;
        this.zzg = 1 == (i6 & 1);
        this.zzh = (i6 & 2) != 0;
        zzgwm zzgwmVarZzj = str2 != null ? zzgwm.zzj(str2) : zzaamVar.zzy.isEmpty() ? zzgwm.zzj("") : zzaamVar.zzy;
        int i8 = 0;
        while (true) {
            if (i8 >= zzgwmVarZzj.size()) {
                iZzj = 0;
                i8 = Integer.MAX_VALUE;
                break;
            }
            zzv zzvVar = this.zzd;
            String str3 = (String) zzgwmVarZzj.get(i8);
            boolean z2 = zzaamVar.zzD;
            iZzj = zzaay.zzj(zzvVar, str3, false);
            if (iZzj > 0) {
                break;
            } else {
                i8++;
            }
        }
        this.zzi = i8;
        this.zzj = iZzj;
        if (str2 != null) {
            i4 = 1088;
        } else {
            int i9 = zzaamVar.zzA;
            i4 = 0;
        }
        int iZzm = zzaay.zzm(this.zzd.zzf, i4);
        this.zzk = iZzm;
        zzv zzvVar2 = this.zzd;
        this.zzn = (1088 & zzvVar2.zzf) != 0;
        int iZzn = zzaay.zzn(zzvVar2, zzaamVar.zzz);
        this.zzl = iZzn;
        int iZzj2 = zzaay.zzj(this.zzd, str, zzaay.zzi(str) == null);
        this.zzm = iZzj2;
        if (iZzj > 0 || ((zzaamVar.zzy.isEmpty() && iZzm > 0) || ((zzaamVar.zzy.isEmpty() && iZzn != Integer.MAX_VALUE) || this.zzg || (this.zzh && iZzj2 > 0)))) {
            z = true;
        } else {
            boolean z3 = zzaamVar.zzx;
            z = false;
        }
        if (zznc.zzac(i3, zzaamVar.zzV) && z) {
            i5 = 1;
        }
        this.zze = i5;
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final int zza() {
        return this.zze;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzaao zzaaoVar) {
        zzgvz zzgvzVarZza = zzgvz.zzg().zzd(this.zzf, zzaaoVar.zzf).zza(Integer.valueOf(this.zzi), Integer.valueOf(zzaaoVar.zzi), zzgyg.zzb().zza());
        int i = this.zzj;
        zzgvz zzgvzVarZzb = zzgvzVarZza.zzb(i, zzaaoVar.zzj);
        int i2 = this.zzk;
        zzgvz zzgvzVarZzb2 = zzgvzVarZzb.zzb(i2, zzaaoVar.zzk).zza(Integer.valueOf(this.zzl), Integer.valueOf(zzaaoVar.zzl), zzgyg.zzb().zza()).zzd(this.zzg, zzaaoVar.zzg).zza(Boolean.valueOf(this.zzh), Boolean.valueOf(zzaaoVar.zzh), i == 0 ? zzgyg.zzb() : zzgyg.zzb().zza()).zzb(this.zzm, zzaaoVar.zzm);
        if (i2 == 0) {
            zzgvzVarZzb2 = zzgvzVarZzb2.zzc(this.zzn, zzaaoVar.zzn);
        }
        return zzgvzVarZzb2.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* bridge */ /* synthetic */ boolean zzc(zzaaq zzaaqVar) {
        return false;
    }
}
