package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaax extends zzaaq {
    private final boolean zze;
    private final zzaam zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final boolean zzt;
    private final boolean zzu;
    private final int zzv;

    /* JADX WARN: Code duplicated, block: B:111:0x0172  */
    /* JADX WARN: Code duplicated, block: B:25:0x0040  */
    /* JADX WARN: Code duplicated, block: B:32:0x004f  */
    /* JADX WARN: Code duplicated, block: B:34:0x0053  */
    /* JADX WARN: Code duplicated, block: B:36:0x0057  */
    /* JADX WARN: Code duplicated, block: B:38:0x005d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0064  */
    /* JADX WARN: Code duplicated, block: B:42:0x0068  */
    /* JADX WARN: Code duplicated, block: B:45:0x006e  */
    public zzaax(int i, zzbg zzbgVar, int i2, zzaam zzaamVar, int i3, String str, int i4, boolean z) {
        boolean z2;
        boolean z3;
        int i5;
        int iZzj;
        int i6;
        boolean z4;
        int i7;
        float f;
        int i8;
        zzv zzvVar;
        int i9;
        int i10;
        int i11;
        super(i, zzbgVar, i2);
        this.zzf = zzaamVar;
        int i12 = 1;
        int i13 = true != zzaamVar.zzM ? 16 : 24;
        boolean z5 = zzaamVar.zzL;
        if (!z || (((i9 = (zzvVar = this.zzd).zzw) != -1 && i9 > zzaamVar.zza) || ((i10 = zzvVar.zzx) != -1 && i10 > zzaamVar.zzb))) {
            z2 = false;
        } else {
            float f2 = zzvVar.zzA;
            if ((f2 == -1.0f || f2 <= zzaamVar.zzc) && ((i11 = zzvVar.zzj) == -1 || i11 <= zzaamVar.zzd)) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        this.zze = z2;
        if (z) {
            zzv zzvVar2 = this.zzd;
            int i14 = zzvVar2.zzw;
            if (i14 != -1) {
                int i15 = zzaamVar.zze;
                if (i14 >= 0) {
                    i7 = zzvVar2.zzx;
                    if (i7 != -1) {
                        int i16 = zzaamVar.zzf;
                        if (i7 >= 0) {
                            f = zzvVar2.zzA;
                            if (f != -1.0f) {
                                int i17 = zzaamVar.zzg;
                                if (f >= 0.0f) {
                                    i8 = zzvVar2.zzj;
                                    if (i8 != -1) {
                                        int i18 = zzaamVar.zzh;
                                        if (i8 >= 0) {
                                            z3 = false;
                                        }
                                    }
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                            } else {
                                i8 = zzvVar2.zzj;
                                if (i8 != -1) {
                                    int i19 = zzaamVar.zzh;
                                    if (i8 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            }
                        } else {
                            z3 = false;
                        }
                    } else {
                        f = zzvVar2.zzA;
                        if (f != -1.0f) {
                            int i110 = zzaamVar.zzg;
                            if (f >= 0.0f) {
                                i8 = zzvVar2.zzj;
                                if (i8 != -1) {
                                    int i111 = zzaamVar.zzh;
                                    if (i8 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i8 = zzvVar2.zzj;
                            if (i8 != -1) {
                                int i112 = zzaamVar.zzh;
                                if (i8 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    }
                } else {
                    z3 = false;
                }
            } else {
                i7 = zzvVar2.zzx;
                if (i7 != -1) {
                    int i113 = zzaamVar.zzf;
                    if (i7 >= 0) {
                        f = zzvVar2.zzA;
                        if (f != -1.0f) {
                            int i114 = zzaamVar.zzg;
                            if (f >= 0.0f) {
                                i8 = zzvVar2.zzj;
                                if (i8 != -1) {
                                    int i115 = zzaamVar.zzh;
                                    if (i8 >= 0) {
                                        z3 = false;
                                    }
                                }
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                        } else {
                            i8 = zzvVar2.zzj;
                            if (i8 != -1) {
                                int i116 = zzaamVar.zzh;
                                if (i8 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        }
                    } else {
                        z3 = false;
                    }
                } else {
                    f = zzvVar2.zzA;
                    if (f != -1.0f) {
                        int i117 = zzaamVar.zzg;
                        if (f >= 0.0f) {
                            i8 = zzvVar2.zzj;
                            if (i8 != -1) {
                                int i118 = zzaamVar.zzh;
                                if (i8 >= 0) {
                                    z3 = false;
                                }
                            }
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                    } else {
                        i8 = zzvVar2.zzj;
                        if (i8 != -1) {
                            int i119 = zzaamVar.zzh;
                            if (i8 >= 0) {
                                z3 = false;
                            }
                        }
                        z3 = true;
                    }
                }
            }
        } else {
            z3 = false;
        }
        this.zzg = z3;
        this.zzh = zznc.zzac(i3, false);
        zzv zzvVar3 = this.zzd;
        float f3 = zzvVar3.zzA;
        this.zzi = f3 != -1.0f && f3 >= 10.0f;
        this.zzj = zzvVar3.zzj;
        this.zzk = zzvVar3.zzc();
        int i20 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i20 >= zzaamVar.zzo.size()) {
                iZzj = 0;
                i20 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzaay.zzj(this.zzd, (String) zzaamVar.zzo.get(i20), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i20++;
                }
            }
        }
        this.zzm = i20;
        this.zzn = iZzj;
        int i21 = this.zzd.zzf;
        int i22 = zzaamVar.zzp;
        this.zzo = zzaay.zzm(i21, 0);
        int i23 = this.zzd.zzf;
        this.zzq = i23 == 0 || (i23 & 1) != 0;
        this.zzr = zzaay.zzj(this.zzd, str, zzaay.zzi(str) == null);
        for (int i24 = 0; i24 < zzaamVar.zzm.size(); i24++) {
            String str2 = this.zzd.zzp;
            if (str2 != null && str2.equals(zzaamVar.zzm.get(i24))) {
                i5 = i24;
                break;
            }
        }
        this.zzl = i5;
        this.zzp = zzaay.zzn(this.zzd, zzaamVar.zzn);
        this.zzt = (i3 & 384) == 128;
        this.zzu = (i3 & 64) == 64;
        zzv zzvVar4 = this.zzd;
        String str3 = zzvVar4.zzp;
        if (str3 != null) {
            switch (str3) {
                case "video/dolby-vision":
                    i6 = 5;
                    break;
                case "video/av01":
                    i6 = 4;
                    break;
                case "video/hevc":
                    i6 = 3;
                    break;
                case "video/avc":
                    i6 = 1;
                    break;
                case "video/x-vnd.on2.vp9":
                    i6 = 2;
                    break;
                default:
                    i6 = 0;
                    break;
            }
        } else {
            i6 = 0;
        }
        this.zzv = i6;
        if ((zzvVar4.zzf & 16384) != 0) {
            i12 = 0;
        } else {
            zzaam zzaamVar2 = this.zzf;
            if (!zznc.zzac(i3, zzaamVar2.zzV) || (!(z4 = this.zze) && !zzaamVar2.zzK)) {
                i12 = 0;
            } else if (zznc.zzac(i3, false) && this.zzg && z4 && zzvVar4.zzj != -1) {
                boolean z6 = zzaamVar2.zzG;
                boolean z7 = zzaamVar2.zzF;
                if ((i13 & i3) != 0) {
                    i12 = 2;
                }
            }
        }
        this.zzs = i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzi(zzaax zzaaxVar, zzaax zzaaxVar2) {
        zzgvz zzgvzVarZza = zzgvz.zzg().zzd(zzaaxVar.zzh, zzaaxVar2.zzh).zza(Integer.valueOf(zzaaxVar.zzm), Integer.valueOf(zzaaxVar2.zzm), zzgyg.zzb().zza()).zzb(zzaaxVar.zzn, zzaaxVar2.zzn).zzb(zzaaxVar.zzo, zzaaxVar2.zzo).zza(Integer.valueOf(zzaaxVar.zzp), Integer.valueOf(zzaaxVar2.zzp), zzgyg.zzb().zza()).zzd(zzaaxVar.zzq, zzaaxVar2.zzq).zzb(zzaaxVar.zzr, zzaaxVar2.zzr).zzd(zzaaxVar.zzi, zzaaxVar2.zzi).zzd(zzaaxVar.zze, zzaaxVar2.zze).zzd(zzaaxVar.zzg, zzaaxVar2.zzg).zza(Integer.valueOf(zzaaxVar.zzl), Integer.valueOf(zzaaxVar2.zzl), zzgyg.zzb().zza());
        boolean z = zzaaxVar.zzt;
        zzgvz zzgvzVarZzd = zzgvzVarZza.zzd(z, zzaaxVar2.zzt);
        boolean z2 = zzaaxVar.zzu;
        zzgvz zzgvzVarZzd2 = zzgvzVarZzd.zzd(z2, zzaaxVar2.zzu);
        if (z && z2) {
            zzgvzVarZzd2 = zzgvzVarZzd2.zzb(zzaaxVar.zzv, zzaaxVar2.zzv);
        }
        return zzgvzVarZzd2.zze();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzj(zzaax zzaaxVar, zzaax zzaaxVar2) {
        zzgyg zzgygVarZza = (zzaaxVar.zze && zzaaxVar.zzh) ? zzaay.zzc : zzaay.zzc.zza();
        zzgvz zzgvzVarZzg = zzgvz.zzg();
        boolean z = zzaaxVar.zzf.zzF;
        return zzgvzVarZzg.zza(Integer.valueOf(zzaaxVar.zzk), Integer.valueOf(zzaaxVar2.zzk), zzgygVarZza).zza(Integer.valueOf(zzaaxVar.zzj), Integer.valueOf(zzaaxVar2.zzj), zzgygVarZza).zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final int zza() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* bridge */ /* synthetic */ boolean zzc(zzaaq zzaaqVar) {
        zzaax zzaaxVar = (zzaax) zzaaqVar;
        if (!Objects.equals(this.zzd.zzp, zzaaxVar.zzd.zzp)) {
            return false;
        }
        boolean z = this.zzf.zzN;
        return this.zzt == zzaaxVar.zzt && this.zzu == zzaaxVar.zzu;
    }
}
