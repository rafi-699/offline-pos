package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzapp implements zzapt {
    private static final byte[] zza = {73, 68, 51};
    private final boolean zzb;
    private final String zze;
    private final int zzf;
    private final String zzg;
    private String zzh;
    private zzahk zzi;
    private zzahk zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzr;
    private boolean zzs;
    private int zzu;
    private zzahk zzw;
    private long zzx;
    private final zzes zzc = new zzes(new byte[7], 7);
    private final zzet zzd = new zzet(Arrays.copyOf(zza, 10));
    private int zzp = -1;
    private int zzq = -1;
    private long zzt = C.TIME_UNSET;
    private long zzv = C.TIME_UNSET;

    public zzapp(boolean z, String str, int i, String str2) {
        this.zzb = z;
        this.zze = str;
        this.zzf = i;
        this.zzg = str2;
        zzi();
    }

    public static boolean zzf(int i) {
        return (i & 65526) == 65520;
    }

    private final void zzg() {
        this.zzo = false;
        zzi();
    }

    private final boolean zzh(zzet zzetVar, byte[] bArr, int i) {
        int iMin = Math.min(zzetVar.zzd(), i - this.zzl);
        zzetVar.zzm(bArr, this.zzl, iMin);
        int i2 = this.zzl + iMin;
        this.zzl = i2;
        return i2 == i;
    }

    private final void zzi() {
        this.zzk = 0;
        this.zzl = 0;
        this.zzm = 256;
    }

    private final void zzj(zzahk zzahkVar, long j, int i, int i2) {
        this.zzk = 4;
        this.zzl = i;
        this.zzw = zzahkVar;
        this.zzx = j;
        this.zzu = i2;
    }

    private final void zzk() {
        this.zzk = 3;
        this.zzl = 0;
    }

    private static final boolean zzl(byte b, byte b2) {
        return zzf((b2 & 255) | MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    private static final boolean zzm(zzet zzetVar, byte[] bArr, int i) {
        if (zzetVar.zzd() < i) {
            return false;
        }
        zzetVar.zzm(bArr, 0, i);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzv = C.TIME_UNSET;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzh = zzarhVar.zzc();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 1);
        this.zzi = zzahkVarZzu;
        this.zzw = zzahkVarZzu;
        if (!this.zzb) {
            this.zzj = new zzafv();
            return;
        }
        zzarhVar.zza();
        zzahk zzahkVarZzu2 = zzagbVar.zzu(zzarhVar.zzb(), 5);
        this.zzj = zzahkVarZzu2;
        zzt zztVar = new zzt();
        zztVar.zza(zzarhVar.zzc());
        zztVar.zzn(this.zzg);
        zztVar.zzo(MimeTypes.APPLICATION_ID3);
        zzahkVarZzu2.zzA(zztVar.zzO());
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzv = j;
    }

    /* JADX WARN: Code duplicated, block: B:143:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:145:0x0249 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:71:0x0201  */
    /* JADX WARN: Code duplicated, block: B:73:0x020f  */
    /* JADX WARN: Code duplicated, block: B:75:0x021a  */
    /* JADX WARN: Code duplicated, block: B:77:0x021e  */
    /* JADX WARN: Code duplicated, block: B:79:0x0222  */
    /* JADX WARN: Code duplicated, block: B:84:0x0231  */
    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) throws zzat {
        int i;
        boolean z;
        int i2;
        int iZzj;
        byte[] bArrZzi;
        int iZze;
        int i3;
        byte b;
        int i4;
        int i5;
        int i6;
        byte b2;
        this.zzi.getClass();
        String str = zzfl.zza;
        while (zzetVar.zzd() > 0) {
            int i7 = this.zzk;
            char c = 7;
            int i8 = 3;
            int i9 = 2;
            if (i7 == 0) {
                byte[] bArrZzi2 = zzetVar.zzi();
                int iZzg = zzetVar.zzg();
                int iZze2 = zzetVar.zze();
                while (true) {
                    if (iZzg < iZze2) {
                        int i10 = iZzg + 1;
                        byte b3 = bArrZzi2[iZzg];
                        int i11 = b3 & 255;
                        int i12 = i8;
                        if (this.zzm == 512 && zzl((byte) -1, (byte) i11)) {
                            if (!this.zzo) {
                                int i13 = iZzg - 1;
                                zzetVar.zzh(iZzg);
                                zzes zzesVar = this.zzc;
                                if (zzm(zzetVar, zzesVar.zza, 1)) {
                                    zzesVar.zzf(4);
                                    int iZzj2 = zzesVar.zzj(1);
                                    int i14 = this.zzp;
                                    if (i14 != -1 && iZzj2 != i14) {
                                        c = 7;
                                    } else if (this.zzq == -1) {
                                        if (zzm(zzetVar, zzesVar.zza, 4)) {
                                            zzesVar.zzf(14);
                                            iZzj = zzesVar.zzj(13);
                                            c = 7;
                                            if (iZzj >= 7) {
                                                bArrZzi = zzetVar.zzi();
                                                iZze = zzetVar.zze();
                                                i3 = i13 + iZzj;
                                                if (i3 >= iZze) {
                                                    b = bArrZzi[i3];
                                                    if (b == -1) {
                                                        i6 = i3 + 1;
                                                        if (i6 != iZze) {
                                                            b2 = bArrZzi[i6];
                                                            if (zzl((byte) -1, b2) || ((b2 & 8) >> 3) != iZzj2) {
                                                            }
                                                        }
                                                    } else if (b == 73 || ((i4 = i3 + 1) != iZze && (bArrZzi[i4] != 68 || ((i5 = i3 + 2) != iZze && bArrZzi[i5] != 51)))) {
                                                    }
                                                }
                                            }
                                        }
                                    } else if (zzm(zzetVar, zzesVar.zza, 1)) {
                                        zzesVar.zzf(i9);
                                        if (zzesVar.zzj(4) == this.zzq) {
                                            zzetVar.zzh(iZzg + 1);
                                            if (zzm(zzetVar, zzesVar.zza, 4)) {
                                                zzesVar.zzf(14);
                                                iZzj = zzesVar.zzj(13);
                                                c = 7;
                                                if (iZzj >= 7) {
                                                    bArrZzi = zzetVar.zzi();
                                                    iZze = zzetVar.zze();
                                                    i3 = i13 + iZzj;
                                                    if (i3 >= iZze) {
                                                        b = bArrZzi[i3];
                                                        if (b == -1) {
                                                            i6 = i3 + 1;
                                                            if (i6 != iZze) {
                                                                b2 = bArrZzi[i6];
                                                                if (zzl((byte) -1, b2)) {
                                                                }
                                                            }
                                                        } else if (b == 73) {
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            c = 7;
                                        }
                                    }
                                } else {
                                    c = 7;
                                }
                            }
                            this.zzr = (b3 & 8) >> 3;
                            this.zzn = 1 == ((b3 & 1) ^ 1);
                            if (this.zzo) {
                                zzk();
                            } else {
                                this.zzk = 1;
                                this.zzl = 0;
                            }
                            zzetVar.zzh(i10);
                        } else {
                            c = c;
                        }
                        int i15 = this.zzm;
                        int i16 = i15 | i11;
                        if (i16 == 329) {
                            i = 2;
                            z = false;
                            i2 = 768;
                        } else if (i16 == 511) {
                            i = 2;
                            z = false;
                            i2 = 512;
                        } else if (i16 == 836) {
                            i = 2;
                            z = false;
                            i2 = 1024;
                        } else if (i16 == 1075) {
                            this.zzk = 2;
                            this.zzl = i12;
                            this.zzu = 0;
                            this.zzd.zzh(0);
                            zzetVar.zzh(i10);
                        } else if (i15 != 256) {
                            this.zzm = 256;
                            i8 = i12;
                            i9 = 2;
                        } else {
                            i12 = i12;
                            i = 2;
                            z = false;
                            iZzg = i10;
                            i8 = i12;
                            i9 = i;
                        }
                        this.zzm = i2;
                        iZzg = i10;
                        i8 = i12;
                        i9 = i;
                    } else {
                        zzetVar.zzh(iZzg);
                    }
                }
            } else if (i7 != 1) {
                if (i7 == 2) {
                    zzet zzetVar2 = this.zzd;
                    if (zzh(zzetVar, zzetVar2.zzi(), 10)) {
                        this.zzj.zzc(zzetVar2, 10);
                        zzetVar2.zzh(6);
                        zzj(this.zzj, 0L, 10, zzetVar2.zzG() + 10);
                    }
                } else if (i7 != 3) {
                    int iMin = Math.min(zzetVar.zzd(), this.zzu - this.zzl);
                    this.zzw.zzc(zzetVar, iMin);
                    int i17 = this.zzl + iMin;
                    this.zzl = i17;
                    if (i17 == this.zzu) {
                        zzgtj.zzi(this.zzv != C.TIME_UNSET);
                        this.zzw.zze(this.zzv, 1, this.zzu, 0, null);
                        this.zzv += this.zzx;
                        zzi();
                    }
                } else {
                    int i18 = true != this.zzn ? 5 : 7;
                    zzes zzesVar2 = this.zzc;
                    if (zzh(zzetVar, zzesVar2.zza, i18)) {
                        zzesVar2.zzf(0);
                        if (this.zzs) {
                            zzesVar2.zzh(10);
                        } else {
                            int iZzj3 = zzesVar2.zzj(2) + 1;
                            if (iZzj3 != 2) {
                                StringBuilder sb = new StringBuilder(String.valueOf(iZzj3).length() + 50);
                                sb.append("Detected audio object type: ");
                                sb.append(iZzj3);
                                sb.append(", but assuming AAC LC.");
                                zzeg.zzc("AdtsReader", sb.toString());
                            }
                            zzesVar2.zzh(5);
                            int iZzj4 = zzesVar2.zzj(3);
                            int i19 = this.zzq;
                            int i20 = zzaew.zza;
                            byte[] bArr = {(byte) (((i19 >> 1) & 7) | 16), (byte) (((iZzj4 << 3) & 120) | ((i19 << 7) & 128))};
                            zzaev zzaevVarZza = zzaew.zza(bArr);
                            zzt zztVar = new zzt();
                            zztVar.zza(this.zzh);
                            zztVar.zzn(this.zzg);
                            zztVar.zzo(MimeTypes.AUDIO_AAC);
                            zztVar.zzk(zzaevVarZza.zzc);
                            zztVar.zzG(zzaevVarZza.zzb);
                            zztVar.zzH(zzaevVarZza.zza);
                            zztVar.zzr(Collections.singletonList(bArr));
                            zztVar.zze(this.zze);
                            zztVar.zzg(this.zzf);
                            zzv zzvVarZzO = zztVar.zzO();
                            this.zzt = 1024000000 / ((long) zzvVarZzO.zzI);
                            this.zzi.zzA(zzvVarZzO);
                            this.zzs = true;
                        }
                        zzesVar2.zzh(4);
                        int iZzj5 = zzesVar2.zzj(13);
                        int i21 = iZzj5 - 7;
                        if (this.zzn) {
                            i21 = iZzj5 - 9;
                        }
                        zzj(this.zzi, this.zzt, 0, i21);
                    }
                }
            } else if (zzetVar.zzd() != 0) {
                zzes zzesVar3 = this.zzc;
                zzesVar3.zza[0] = zzetVar.zzi()[zzetVar.zzg()];
                zzesVar3.zzf(2);
                int iZzj6 = zzesVar3.zzj(4);
                int i22 = this.zzq;
                if (i22 == -1 || iZzj6 == i22) {
                    if (!this.zzo) {
                        this.zzo = true;
                        this.zzp = this.zzr;
                        this.zzq = iZzj6;
                    }
                    zzk();
                } else {
                    zzg();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
    }
}
