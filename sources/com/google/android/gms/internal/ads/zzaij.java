package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.recyclerview.widget.ItemTouchHelper;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaij implements zzafy {
    private zzagb zzf;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private boolean zzn;
    private zzaih zzo;
    private zzain zzp;
    private final zzet zza = new zzet(4);
    private final zzet zzb = new zzet(9);
    private final zzet zzc = new zzet(11);
    private final zzet zzd = new zzet();
    private final zzaik zze = new zzaik();
    private int zzg = 1;

    static {
        int i = zzaii.zza;
    }

    private final zzet zzh(zzafz zzafzVar) throws IOException {
        zzet zzetVar = this.zzd;
        if (this.zzl > zzetVar.zzj()) {
            int iZzj = zzetVar.zzj();
            zzetVar.zzb(new byte[Math.max(iZzj + iZzj, this.zzl)], 0);
        } else {
            zzetVar.zzh(0);
        }
        zzetVar.zzf(this.zzl);
        zzafzVar.zzc(zzetVar.zzi(), 0, this.zzl);
        return zzetVar;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzi() {
        if (this.zzn) {
            return;
        }
        this.zzf.zzw(new zzaha(C.TIME_UNSET, 0L));
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        zzet zzetVar = this.zza;
        zzafp zzafpVar = (zzafp) zzafzVar;
        zzafpVar.zzh(zzetVar.zzi(), 0, 3, false);
        zzetVar.zzh(0);
        if (zzetVar.zzx() != 4607062) {
            return false;
        }
        zzafpVar.zzh(zzetVar.zzi(), 0, 2, false);
        zzetVar.zzh(0);
        if ((zzetVar.zzt() & ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION) != 0) {
            return false;
        }
        zzafpVar.zzh(zzetVar.zzi(), 0, 4, false);
        zzetVar.zzh(0);
        int iZzB = zzetVar.zzB();
        zzafzVar.zzl();
        zzafpVar.zzj(iZzB, false);
        zzafpVar.zzh(zzetVar.zzi(), 0, 4, false);
        zzetVar.zzh(0);
        return zzetVar.zzB() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzf = zzagbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        if (j == 0) {
            this.zzg = 1;
            this.zzh = false;
        } else {
            this.zzg = 3;
        }
        this.zzj = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0096  */
    /* JADX WARN: Code duplicated, block: B:40:0x00af  */
    /* JADX WARN: Code duplicated, block: B:41:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0009 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        long j;
        boolean zZzf;
        boolean z;
        long j2;
        this.zzf.getClass();
        while (true) {
            int i = this.zzg;
            int i2 = 8;
            if (i == 1) {
                zzet zzetVar = this.zzb;
                if (!zzafzVar.zzb(zzetVar.zzi(), 0, 9, true)) {
                    return -1;
                }
                zzetVar.zzh(0);
                zzetVar.zzk(4);
                int iZzs = zzetVar.zzs();
                int i3 = iZzs & 4;
                int i4 = iZzs & 1;
                if (i3 != 0 && this.zzo == null) {
                    this.zzo = new zzaih(this.zzf.zzu(8, 1));
                }
                if (i4 != 0 && this.zzp == null) {
                    this.zzp = new zzain(this.zzf.zzu(9, 2));
                }
                this.zzf.zzv();
                this.zzj = zzetVar.zzB() - 5;
                this.zzg = 2;
            } else if (i == 2) {
                zzafzVar.zzf(this.zzj);
                this.zzj = 0;
                this.zzg = 3;
            } else if (i == 3) {
                zzet zzetVar2 = this.zzc;
                if (!zzafzVar.zzb(zzetVar2.zzi(), 0, 11, true)) {
                    return -1;
                }
                zzetVar2.zzh(0);
                this.zzk = zzetVar2.zzs();
                this.zzl = zzetVar2.zzx();
                this.zzm = zzetVar2.zzx();
                this.zzm = (((long) (zzetVar2.zzs() << 24)) | this.zzm) * 1000;
                zzetVar2.zzk(3);
                this.zzg = 4;
            } else {
                if (i != 4) {
                    throw new IllegalStateException();
                }
                if (this.zzh) {
                    j = this.zzi + this.zzm;
                } else {
                    j = this.zze.zzc() == C.TIME_UNSET ? 0L : this.zzm;
                }
                int i5 = this.zzk;
                if (i5 == 8) {
                    if (this.zzo != null) {
                        zzi();
                        zZzf = this.zzo.zzf(zzh(zzafzVar), j);
                    }
                    z = true;
                    if (!this.zzh && zZzf) {
                        this.zzh = true;
                        if (this.zze.zzc() == C.TIME_UNSET) {
                            j2 = -this.zzm;
                        } else {
                            j2 = 0;
                        }
                        this.zzi = j2;
                    }
                    this.zzj = 4;
                    this.zzg = 2;
                    if (z) {
                        return 0;
                    }
                } else {
                    i2 = i5;
                }
                if (i2 == 9) {
                    if (this.zzp != null) {
                        zzi();
                        zZzf = this.zzp.zzf(zzh(zzafzVar), j);
                        z = true;
                    } else {
                        zzafzVar.zzf(this.zzl);
                        zZzf = false;
                        z = false;
                    }
                } else if (i2 != 18 || this.zzn) {
                    zzafzVar.zzf(this.zzl);
                    zZzf = false;
                    z = false;
                } else {
                    zzaik zzaikVar = this.zze;
                    zZzf = zzaikVar.zzf(zzh(zzafzVar), j);
                    long jZzc = zzaikVar.zzc();
                    if (jZzc != C.TIME_UNSET) {
                        this.zzf.zzw(new zzagu(zzaikVar.zze(), zzaikVar.zzd(), jZzc));
                        this.zzn = true;
                    }
                    z = true;
                }
                if (!this.zzh) {
                    this.zzh = true;
                    if (this.zze.zzc() == C.TIME_UNSET) {
                        j2 = -this.zzm;
                    } else {
                        j2 = 0;
                    }
                    this.zzi = j2;
                }
                this.zzj = 4;
                this.zzg = 2;
                if (z) {
                    return 0;
                }
            }
        }
    }
}
