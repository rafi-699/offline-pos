package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.media3.common.C;
import androidx.media3.extractor.ts.TsExtractor;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzard implements zzafy {
    private final int zza;
    private final List zzb;
    private final zzet zzc;
    private final SparseIntArray zzd;
    private final zzarg zze;
    private final zzanj zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzaqz zzj;
    private zzaqy zzk;
    private zzagb zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    static {
        int i = zzarc.zza;
    }

    @Deprecated
    public zzard() {
        this(1, 1, zzanj.zza, new zzfi(0L), new zzapq(0), TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        byte[] bArrZzi = this.zzc.zzi();
        zzafp zzafpVar = (zzafp) zzafzVar;
        zzafpVar.zzh(bArrZzi, 0, 940, false);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    zzafpVar.zze(i, false);
                    return true;
                }
                if (bArrZzi[(i2 * TsExtractor.TS_PACKET_SIZE) + i] != 71) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        if (this.zza == 0) {
            zzagbVar = new zzanm(zzagbVar, this.zzf);
        }
        this.zzl = zzagbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        long j;
        long jZzo = zzafzVar.zzo();
        long j2 = -1;
        if (this.zzn) {
            if (jZzo != -1) {
                zzaqz zzaqzVar = this.zzj;
                if (!zzaqzVar.zza()) {
                    return zzaqzVar.zzb(zzafzVar, zzagyVar, this.zzr);
                }
            }
            if (this.zzo) {
                j = 0;
            } else {
                this.zzo = true;
                zzaqz zzaqzVar2 = this.zzj;
                if (zzaqzVar2.zzc() != C.TIME_UNSET) {
                    j = 0;
                    zzaqy zzaqyVar = new zzaqy(zzaqzVar2.zzd(), zzaqzVar2.zzc(), jZzo, this.zzr, TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
                    this.zzk = zzaqyVar;
                    this.zzl.zzw(zzaqyVar.zza());
                } else {
                    j = 0;
                    this.zzl.zzw(new zzaha(zzaqzVar2.zzc(), 0L));
                }
            }
            if (this.zzp) {
                this.zzp = false;
                zze(j, j);
                if (zzafzVar.zzn() != j) {
                    zzagyVar.zza = j;
                    return 1;
                }
            }
            zzaqy zzaqyVar2 = this.zzk;
            if (zzaqyVar2 != null && zzaqyVar2.zzc()) {
                return zzaqyVar2.zzd(zzafzVar, zzagyVar);
            }
        } else {
            j2 = -1;
        }
        zzet zzetVar = this.zzc;
        byte[] bArrZzi = zzetVar.zzi();
        if (9400 - zzetVar.zzg() < 188) {
            int iZzd = zzetVar.zzd();
            if (iZzd > 0) {
                System.arraycopy(bArrZzi, zzetVar.zzg(), bArrZzi, 0, iZzd);
            }
            zzetVar.zzb(bArrZzi, iZzd);
        }
        while (zzetVar.zzd() < 188) {
            int iZze = zzetVar.zze();
            int iZza = zzafzVar.zza(bArrZzi, iZze, 9400 - iZze);
            if (iZza == -1) {
                int i = 0;
                while (true) {
                    SparseArray sparseArray = this.zzg;
                    if (i >= sparseArray.size()) {
                        return -1;
                    }
                    zzari zzariVar = (zzari) sparseArray.valueAt(i);
                    if (zzariVar instanceof zzaqm) {
                        zzaqm zzaqmVar = (zzaqm) zzariVar;
                        if (zzaqmVar.zzd(false)) {
                            zzaqmVar.zzc(new zzet(), 1);
                        }
                    }
                    i++;
                }
            } else {
                zzetVar.zzf(iZze + iZza);
            }
        }
        int iZzg = zzetVar.zzg();
        int iZze2 = zzetVar.zze();
        int iZza2 = zzarj.zza(zzetVar.zzi(), iZzg, iZze2);
        zzetVar.zzh(iZza2);
        int i2 = iZza2 + TsExtractor.TS_PACKET_SIZE;
        if (i2 > iZze2) {
            this.zzq += iZza2 - iZzg;
        } else {
            this.zzq = 0;
        }
        int iZze3 = zzetVar.zze();
        if (i2 > iZze3) {
            return 0;
        }
        int iZzB = zzetVar.zzB();
        if ((8388608 & iZzB) != 0) {
            zzetVar.zzh(i2);
            return 0;
        }
        int i3 = (4194304 & iZzB) != 0 ? 1 : 0;
        int i4 = iZzB & 32;
        int i5 = (iZzB >> 8) & 8191;
        zzari zzariVar2 = (iZzB & 16) != 0 ? (zzari) this.zzg.get(i5) : null;
        if (zzariVar2 == null) {
            zzetVar.zzh(i2);
            return 0;
        }
        int i6 = iZzB & 15;
        SparseIntArray sparseIntArray = this.zzd;
        int i7 = sparseIntArray.get(i5, i6 - 1);
        sparseIntArray.put(i5, i6);
        if (i7 == i6) {
            zzetVar.zzh(i2);
            return 0;
        }
        if (i6 != ((i7 + 1) & 15)) {
            zzariVar2.zzb();
        }
        if (i4 != 0) {
            int iZzs = zzetVar.zzs();
            i3 |= (zzetVar.zzs() & 64) != 0 ? 2 : 0;
            zzetVar.zzk(iZzs - 1);
        }
        boolean z = this.zzn;
        if (z || !this.zzi.get(i5, false)) {
            zzetVar.zzf(i2);
            zzariVar2.zzc(zzetVar, i3);
            zzetVar.zzf(iZze3);
        }
        if (!z && this.zzn && jZzo != j2) {
            this.zzp = true;
        }
        zzetVar.zzh(i2);
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x002f  */
    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        zzaqy zzaqyVar;
        List list = this.zzb;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            zzfi zzfiVar = (zzfi) list.get(i);
            if (zzfiVar.zzc() != C.TIME_UNSET) {
                long jZza = zzfiVar.zza();
                if (jZza != C.TIME_UNSET && jZza != 0 && jZza != j2) {
                    zzfiVar.zzd(j2);
                }
            } else {
                zzfiVar.zzd(j2);
            }
        }
        if (j2 != 0 && (zzaqyVar = this.zzk) != null) {
            zzaqyVar.zzb(j2);
        }
        this.zzc.zza(0);
        this.zzd.clear();
        int i2 = 0;
        while (true) {
            SparseArray sparseArray = this.zzg;
            if (i2 >= sparseArray.size()) {
                this.zzq = 0;
                return;
            } else {
                ((zzari) sparseArray.valueAt(i2)).zzb();
                i2++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }

    final /* synthetic */ List zzh() {
        return this.zzb;
    }

    final /* synthetic */ zzarg zzi() {
        return this.zze;
    }

    final /* synthetic */ SparseArray zzj() {
        return this.zzg;
    }

    final /* synthetic */ SparseBooleanArray zzk() {
        return this.zzh;
    }

    final /* synthetic */ SparseBooleanArray zzl() {
        return this.zzi;
    }

    final /* synthetic */ zzagb zzm() {
        return this.zzl;
    }

    final /* synthetic */ int zzn() {
        return this.zzm;
    }

    final /* synthetic */ void zzo(int i) {
        this.zzm = i;
    }

    final /* synthetic */ void zzp(boolean z) {
        this.zzn = true;
    }

    final /* synthetic */ void zzq(int i) {
        this.zzr = i;
    }

    public zzard(int i, int i2, zzanj zzanjVar, zzfi zzfiVar, zzarg zzargVar, int i3) {
        this.zze = zzargVar;
        this.zza = i2;
        this.zzf = zzanjVar;
        this.zzb = Collections.singletonList(zzfiVar);
        this.zzc = new zzet(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzaqz(TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES);
        this.zzl = zzagb.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArrayZza = zzargVar.zza();
        int size = sparseArrayZza.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.zzg.put(sparseArrayZza.keyAt(i4), (zzari) sparseArrayZza.valueAt(i4));
        }
        this.zzg.put(0, new zzaqu(new zzara(this)));
    }
}
