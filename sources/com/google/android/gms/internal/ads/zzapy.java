package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzapy implements zzapt {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    private final zzarl zzb;
    private zzapx zzg;
    private long zzh;
    private String zzi;
    private zzahk zzj;
    private boolean zzk;
    private final boolean[] zzd = new boolean[4];
    private final zzapw zze = new zzapw(128);
    private long zzl = C.TIME_UNSET;
    private final zzaqk zzf = new zzaqk(178, 128);
    private final zzet zzc = new zzet();

    zzapy(zzarl zzarlVar, String str) {
        this.zzb = zzarlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        zzgp.zzj(this.zzd);
        this.zze.zza();
        zzapx zzapxVar = this.zzg;
        if (zzapxVar != null) {
            zzapxVar.zza();
        }
        this.zzf.zza();
        this.zzh = 0L;
        this.zzl = C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzi = zzarhVar.zzc();
        this.zzj = zzagbVar.zzu(zzarhVar.zzb(), 2);
        this.zzg = new zzapx(this.zzj);
        this.zzb.zza(zzagbVar, zzarhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzl = j;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0111  */
    /* JADX WARN: Code duplicated, block: B:50:0x0187  */
    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) {
        int i;
        int i2;
        this.zzg.getClass();
        this.zzj.getClass();
        int iZzg = zzetVar.zzg();
        int iZze = zzetVar.zze();
        byte[] bArrZzi = zzetVar.zzi();
        this.zzh += (long) zzetVar.zzd();
        this.zzj.zzc(zzetVar, zzetVar.zzd());
        while (true) {
            int iZzi = zzgp.zzi(bArrZzi, iZzg, iZze, this.zzd);
            if (iZzi == iZze) {
                break;
            }
            int i3 = iZzi + 3;
            int i4 = zzetVar.zzi()[i3] & 255;
            int i5 = iZzi - iZzg;
            if (!this.zzk) {
                if (i5 > 0) {
                    this.zze.zzc(bArrZzi, iZzg, iZzi);
                }
                int i6 = i5 < 0 ? -i5 : 0;
                zzapw zzapwVar = this.zze;
                if (zzapwVar.zzb(i4, i6)) {
                    zzahk zzahkVar = this.zzj;
                    int i7 = zzapwVar.zzb;
                    String str = this.zzi;
                    str.getClass();
                    byte[] bArrCopyOf = Arrays.copyOf(zzapwVar.zzc, zzapwVar.zza);
                    zzes zzesVar = new zzes(bArrCopyOf, bArrCopyOf.length);
                    zzesVar.zzo(i7);
                    zzesVar.zzo(4);
                    zzesVar.zzg();
                    zzesVar.zzh(8);
                    if (zzesVar.zzi()) {
                        zzesVar.zzh(4);
                        zzesVar.zzh(3);
                    }
                    int iZzj = zzesVar.zzj(4);
                    float f = 1.0f;
                    if (iZzj == 15) {
                        int iZzj2 = zzesVar.zzj(8);
                        int iZzj3 = zzesVar.zzj(8);
                        if (iZzj3 == 0) {
                            zzeg.zzc("H263Reader", "Invalid aspect ratio");
                        } else {
                            f = iZzj2 / iZzj3;
                        }
                    } else if (iZzj < 7) {
                        f = zza[iZzj];
                    } else {
                        zzeg.zzc("H263Reader", "Invalid aspect ratio");
                    }
                    float f2 = f;
                    if (zzesVar.zzi()) {
                        zzesVar.zzh(2);
                        zzesVar.zzh(1);
                        if (zzesVar.zzi()) {
                            zzesVar.zzh(15);
                            zzesVar.zzg();
                            zzesVar.zzh(15);
                            zzesVar.zzg();
                            zzesVar.zzh(15);
                            zzesVar.zzg();
                            zzesVar.zzh(3);
                            zzesVar.zzh(11);
                            zzesVar.zzg();
                            zzesVar.zzh(15);
                            zzesVar.zzg();
                            i2 = 2;
                        } else {
                            i2 = 2;
                        }
                    } else {
                        i2 = 2;
                    }
                    if (zzesVar.zzj(i2) != 0) {
                        zzeg.zzc("H263Reader", "Unhandled video object layer shape");
                    }
                    zzesVar.zzg();
                    int iZzj4 = zzesVar.zzj(16);
                    zzesVar.zzg();
                    if (zzesVar.zzi()) {
                        if (iZzj4 == 0) {
                            zzeg.zzc("H263Reader", "Invalid vop_increment_time_resolution");
                        } else {
                            int i8 = iZzj4 - 1;
                            int i9 = 0;
                            while (i8 > 0) {
                                i8 >>= 1;
                                i9++;
                            }
                            zzesVar.zzh(i9);
                        }
                    }
                    zzesVar.zzg();
                    int iZzj5 = zzesVar.zzj(13);
                    zzesVar.zzg();
                    int iZzj6 = zzesVar.zzj(13);
                    zzesVar.zzg();
                    zzesVar.zzg();
                    zzt zztVar = new zzt();
                    zztVar.zza(str);
                    zztVar.zzn(MimeTypes.VIDEO_MP2T);
                    zztVar.zzo(MimeTypes.VIDEO_MP4V);
                    zztVar.zzv(iZzj5);
                    zztVar.zzw(iZzj6);
                    zztVar.zzB(f2);
                    zztVar.zzr(Collections.singletonList(bArrCopyOf));
                    zzahkVar.zzA(zztVar.zzO());
                    this.zzk = true;
                }
            }
            this.zzg.zzc(bArrZzi, iZzg, iZzi);
            zzaqk zzaqkVar = this.zzf;
            if (i5 > 0) {
                zzaqkVar.zzd(bArrZzi, iZzg, iZzi);
                i = 0;
            } else {
                i = -i5;
            }
            if (zzaqkVar.zze(i)) {
                int iZza = zzgp.zza(zzaqkVar.zza, zzaqkVar.zzb);
                zzet zzetVar2 = this.zzc;
                String str2 = zzfl.zza;
                zzetVar2.zzb(zzaqkVar.zza, iZza);
                this.zzb.zzb(this.zzl, zzetVar2);
            }
            if (i4 == 178) {
                if (zzetVar.zzi()[iZzi + 2] == 1) {
                    zzaqkVar.zzc(178);
                }
                i4 = 178;
            }
            int i10 = iZze - iZzi;
            this.zzg.zzd(this.zzh - ((long) i10), i10, this.zzk);
            this.zzg.zzb(i4, this.zzl);
            iZzg = i3;
            iZze = iZze;
        }
        if (!this.zzk) {
            this.zze.zzc(bArrZzi, iZzg, iZze);
        }
        this.zzg.zzc(bArrZzi, iZzg, iZze);
        this.zzf.zzd(bArrZzi, iZzg, iZze);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
        zzapx zzapxVar = this.zzg;
        zzapxVar.getClass();
        if (z) {
            zzapxVar.zzd(this.zzh, 0, this.zzk);
            this.zzg.zza();
        }
    }
}
