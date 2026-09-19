package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzanb extends zzamz {
    private zzana zza;
    private int zzb;
    private boolean zzc;
    private zzhd zzd;
    private zzhb zze;

    zzanb() {
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final void zza(boolean z) {
        super.zza(z);
        if (z) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final long zzb(zzet zzetVar) {
        if ((zzetVar.zzi()[0] & 1) == 1) {
            return -1L;
        }
        zzana zzanaVar = this.zza;
        zzanaVar.getClass();
        byte b = zzetVar.zzi()[0];
        zzhd zzhdVar = zzanaVar.zza;
        zzhc[] zzhcVarArr = zzanaVar.zzd;
        int i = zzhcVarArr[(b >> 1) & (255 >>> (8 - zzhe.zza(zzhcVarArr.length + (-1))))].zza ? zzhdVar.zzf : zzhdVar.zze;
        int i2 = this.zzc ? (this.zzb + i) / 4 : 0;
        if (zzetVar.zzj() < zzetVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzetVar.zzi(), zzetVar.zze() + 4);
            zzetVar.zzb(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzetVar.zzf(zzetVar.zze() + 4);
        }
        long j = i2;
        byte[] bArrZzi = zzetVar.zzi();
        bArrZzi[zzetVar.zze() - 4] = (byte) (j & 255);
        bArrZzi[zzetVar.zze() - 3] = (byte) ((j >>> 8) & 255);
        bArrZzi[zzetVar.zze() - 2] = (byte) ((j >>> 16) & 255);
        bArrZzi[zzetVar.zze() - 1] = (byte) ((j >>> 24) & 255);
        this.zzc = true;
        this.zzb = i;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final void zzj(long j) {
        super.zzj(j);
        this.zzc = j != 0;
        zzhd zzhdVar = this.zzd;
        this.zzb = zzhdVar != null ? zzhdVar.zze : 0;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x03e8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:169:0x03ea  */
    @Override // com.google.android.gms.internal.ads.zzamz
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzet zzetVar, long j, zzamx zzamxVar) throws IOException {
        zzana zzanaVar;
        int i;
        int iZzb;
        int i2;
        int[] iArr;
        if (this.zza != null) {
            zzamxVar.zza.getClass();
            return false;
        }
        zzhd zzhdVar = this.zzd;
        int i3 = 1;
        if (zzhdVar != null) {
            int i4 = 4;
            zzhb zzhbVar = this.zze;
            if (zzhbVar == null) {
                this.zze = zzhe.zzb(zzetVar, true, true);
            } else {
                byte[] bArr = new byte[zzetVar.zze()];
                System.arraycopy(zzetVar.zzi(), 0, bArr, 0, zzetVar.zze());
                int i5 = zzhdVar.zza;
                int i6 = 5;
                zzhe.zzc(5, zzetVar, false);
                int iZzs = zzetVar.zzs() + 1;
                zzha zzhaVar = new zzha(zzetVar.zzi());
                zzhaVar.zzc(zzetVar.zzg() * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 2;
                    int i9 = 16;
                    if (i7 >= iZzs) {
                        int i10 = i3;
                        int i11 = 6;
                        int iZzb2 = zzhaVar.zzb(6) + i10;
                        for (int i12 = 0; i12 < iZzb2; i12++) {
                            if (zzhaVar.zzb(16) != 0) {
                                throw zzat.zzb("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int iZzb3 = zzhaVar.zzb(6) + i10;
                        int i13 = 0;
                        while (true) {
                            int i14 = 3;
                            if (i13 >= iZzb3) {
                                int i15 = 1;
                                int iZzb4 = zzhaVar.zzb(i11) + 1;
                                int i16 = 0;
                                while (i16 < iZzb4) {
                                    if (zzhaVar.zzb(16) > 2) {
                                        throw zzat.zzb("residueType greater than 2 is not decodable", null);
                                    }
                                    zzhaVar.zzc(24);
                                    zzhaVar.zzc(24);
                                    zzhaVar.zzc(24);
                                    int iZzb5 = zzhaVar.zzb(i11) + i15;
                                    int i17 = 8;
                                    zzhaVar.zzc(8);
                                    int[] iArr2 = new int[iZzb5];
                                    for (int i18 = 0; i18 < iZzb5; i18++) {
                                        iArr2[i18] = ((zzhaVar.zza() ? zzhaVar.zzb(5) : 0) * 8) + zzhaVar.zzb(3);
                                    }
                                    int i19 = 0;
                                    while (i19 < iZzb5) {
                                        int i20 = 0;
                                        while (i20 < i17) {
                                            if ((iArr2[i19] & (1 << i20)) != 0) {
                                                zzhaVar.zzc(i17);
                                            }
                                            i20++;
                                            i17 = 8;
                                        }
                                        i19++;
                                        i17 = 8;
                                    }
                                    i16++;
                                    i11 = 6;
                                    i15 = 1;
                                }
                                int iZzb6 = zzhaVar.zzb(i11) + 1;
                                for (int i21 = 0; i21 < iZzb6; i21++) {
                                    int iZzb7 = zzhaVar.zzb(16);
                                    if (iZzb7 != 0) {
                                        StringBuilder sb = new StringBuilder(String.valueOf(iZzb7).length() + 41);
                                        sb.append("mapping type other than 0 not supported: ");
                                        sb.append(iZzb7);
                                        zzeg.zze("VorbisUtil", sb.toString());
                                    } else {
                                        if (zzhaVar.zza()) {
                                            i = 1;
                                            iZzb = zzhaVar.zzb(4) + 1;
                                        } else {
                                            i = 1;
                                            iZzb = 1;
                                        }
                                        if (zzhaVar.zza()) {
                                            int iZzb8 = zzhaVar.zzb(8) + i;
                                            for (int i22 = 0; i22 < iZzb8; i22++) {
                                                int i23 = i5 - 1;
                                                zzhaVar.zzc(zzhe.zza(i23));
                                                zzhaVar.zzc(zzhe.zza(i23));
                                            }
                                        }
                                        if (zzhaVar.zzb(2) != 0) {
                                            throw zzat.zzb("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i24 = 0; i24 < i5; i24++) {
                                                zzhaVar.zzc(4);
                                            }
                                        }
                                        for (int i25 = 0; i25 < iZzb; i25++) {
                                            zzhaVar.zzc(8);
                                            zzhaVar.zzc(8);
                                            zzhaVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb9 = zzhaVar.zzb(6);
                                int i26 = iZzb9 + 1;
                                zzhc[] zzhcVarArr = new zzhc[i26];
                                for (int i27 = 0; i27 < i26; i27++) {
                                    zzhcVarArr[i27] = new zzhc(zzhaVar.zza(), zzhaVar.zzb(16), zzhaVar.zzb(16), zzhaVar.zzb(8));
                                }
                                if (!zzhaVar.zza()) {
                                    throw zzat.zzb("framing bit after modes not set as expected", null);
                                }
                                zzanaVar = new zzana(zzhdVar, zzhbVar, bArr, zzhcVarArr, zzhe.zza(iZzb9));
                                break;
                            }
                            int iZzb10 = zzhaVar.zzb(i9);
                            if (iZzb10 == 0) {
                                int i28 = 8;
                                zzhaVar.zzc(8);
                                zzhaVar.zzc(16);
                                zzhaVar.zzc(16);
                                zzhaVar.zzc(6);
                                zzhaVar.zzc(8);
                                int iZzb11 = zzhaVar.zzb(4) + 1;
                                int i29 = 0;
                                while (i29 < iZzb11) {
                                    zzhaVar.zzc(i28);
                                    i29++;
                                    i28 = 8;
                                }
                            } else {
                                if (iZzb10 != i10) {
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(iZzb10).length() + 41);
                                    sb2.append("floor type greater than 1 not decodable: ");
                                    sb2.append(iZzb10);
                                    throw zzat.zzb(sb2.toString(), null);
                                }
                                int iZzb12 = zzhaVar.zzb(5);
                                int[] iArr3 = new int[iZzb12];
                                int i30 = -1;
                                for (int i31 = 0; i31 < iZzb12; i31++) {
                                    int iZzb13 = zzhaVar.zzb(4);
                                    iArr3[i31] = iZzb13;
                                    if (iZzb13 > i30) {
                                        i30 = iZzb13;
                                    }
                                }
                                int i32 = i30 + 1;
                                int[] iArr4 = new int[i32];
                                int i33 = 0;
                                while (i33 < i32) {
                                    int i34 = 1;
                                    iArr4[i33] = zzhaVar.zzb(i14) + 1;
                                    int iZzb14 = zzhaVar.zzb(2);
                                    if (iZzb14 > 0) {
                                        i2 = 8;
                                        zzhaVar.zzc(8);
                                    } else {
                                        i2 = 8;
                                    }
                                    int i35 = i32;
                                    int i36 = 0;
                                    while (true) {
                                        int i37 = i34 << iZzb14;
                                        iArr = iArr3;
                                        if (i36 < i37) {
                                            zzhaVar.zzc(i2);
                                            i36++;
                                            iArr3 = iArr;
                                            i2 = 8;
                                            i34 = 1;
                                        }
                                    }
                                    i33++;
                                    iArr3 = iArr;
                                    i32 = i35;
                                    i14 = 3;
                                }
                                int[] iArr5 = iArr3;
                                zzhaVar.zzc(2);
                                int iZzb15 = zzhaVar.zzb(4);
                                int i38 = 0;
                                int i39 = 0;
                                for (int i40 = 0; i40 < iZzb12; i40++) {
                                    i38 += iArr4[iArr5[i40]];
                                    while (i39 < i38) {
                                        zzhaVar.zzc(iZzb15);
                                        i39++;
                                    }
                                }
                            }
                            i13++;
                            i11 = 6;
                            i9 = 16;
                            i10 = 1;
                        }
                    } else {
                        if (zzhaVar.zzb(24) != 5653314) {
                            int iZzd = zzhaVar.zzd();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(iZzd).length() + 55);
                            sb3.append("expected code book to start with [0x56, 0x43, 0x42] at ");
                            sb3.append(iZzd);
                            throw zzat.zzb(sb3.toString(), null);
                        }
                        int iZzb16 = zzhaVar.zzb(16);
                        int iZzb17 = zzhaVar.zzb(24);
                        if (zzhaVar.zza()) {
                            zzhaVar.zzc(i6);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzhaVar.zzb(zzhe.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZza = zzhaVar.zza();
                            for (int i41 = 0; i41 < iZzb17; i41++) {
                                if (!zZza) {
                                    zzhaVar.zzc(i6);
                                } else if (zzhaVar.zza()) {
                                    zzhaVar.zzc(i6);
                                }
                            }
                        }
                        int i42 = i4;
                        int iZzb19 = zzhaVar.zzb(i42);
                        if (iZzb19 > 2) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(iZzb19).length() + 42);
                            sb4.append("lookup type greater than 2 not decodable: ");
                            sb4.append(iZzb19);
                            throw zzat.zzb(sb4.toString(), null);
                        }
                        if (iZzb19 != i3) {
                            if (iZzb19 != 2) {
                                i3 = i3;
                            }
                            i7++;
                            i3 = i3;
                            i4 = 4;
                            i6 = 5;
                        } else {
                            i8 = iZzb19;
                        }
                        zzhaVar.zzc(32);
                        zzhaVar.zzc(32);
                        int iZzb20 = zzhaVar.zzb(i42) + i3;
                        zzhaVar.zzc(i3);
                        zzhaVar.zzc((int) ((i8 == i3 ? iZzb16 != 0 ? (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16))) : 0L : ((long) iZzb16) * ((long) iZzb17)) * ((long) iZzb20)));
                        i7++;
                        i3 = i3;
                        i4 = 4;
                        i6 = 5;
                    }
                }
            }
            this.zza = zzanaVar;
            if (zzanaVar == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            zzhd zzhdVar2 = zzanaVar.zza;
            arrayList.add(zzhdVar2.zzg);
            arrayList.add(zzanaVar.zzc);
            zzap zzapVarZzb = zzahm.zzb(zzgwm.zzr(zzanaVar.zzb.zza));
            zzt zztVar = new zzt();
            zztVar.zzn(MimeTypes.AUDIO_OGG);
            zztVar.zzo(MimeTypes.AUDIO_VORBIS);
            zztVar.zzi(zzhdVar2.zzd);
            zztVar.zzj(zzhdVar2.zzc);
            zztVar.zzG(zzhdVar2.zza);
            zztVar.zzH(zzhdVar2.zzb);
            zztVar.zzr(arrayList);
            zztVar.zzl(zzapVarZzb);
            zzamxVar.zza = zztVar.zzO();
            return true;
        }
        zzhe.zzc(1, zzetVar, false);
        int iZzI = zzetVar.zzI();
        int iZzs2 = zzetVar.zzs();
        int iZzI2 = zzetVar.zzI();
        int iZzC = zzetVar.zzC();
        int i43 = iZzC <= 0 ? -1 : iZzC;
        int iZzC2 = zzetVar.zzC();
        int i44 = iZzC2 <= 0 ? -1 : iZzC2;
        int iZzC3 = zzetVar.zzC();
        int i45 = iZzC3 <= 0 ? -1 : iZzC3;
        int iZzs3 = zzetVar.zzs();
        this.zzd = new zzhd(iZzI, iZzs2, iZzI2, i43, i44, i45, (int) Math.pow(2.0d, iZzs3 & 15), (int) Math.pow(2.0d, (iZzs3 & PsExtractor.VIDEO_STREAM_MASK) >> 4), 1 == (zzetVar.zzs() & 1), Arrays.copyOf(zzetVar.zzi(), zzetVar.zze()));
        zzanaVar = null;
        this.zza = zzanaVar;
        if (zzanaVar == null) {
            return true;
        }
        ArrayList arrayList2 = new ArrayList();
        zzhd zzhdVar3 = zzanaVar.zza;
        arrayList2.add(zzhdVar3.zzg);
        arrayList2.add(zzanaVar.zzc);
        zzap zzapVarZzb2 = zzahm.zzb(zzgwm.zzr(zzanaVar.zzb.zza));
        zzt zztVar2 = new zzt();
        zztVar2.zzn(MimeTypes.AUDIO_OGG);
        zztVar2.zzo(MimeTypes.AUDIO_VORBIS);
        zztVar2.zzi(zzhdVar3.zzd);
        zztVar2.zzj(zzhdVar3.zzc);
        zztVar2.zzG(zzhdVar3.zza);
        zztVar2.zzH(zzhdVar3.zzb);
        zztVar2.zzr(arrayList2);
        zztVar2.zzl(zzapVarZzb2);
        zzamxVar.zza = zztVar2.zzO();
        return true;
    }
}
