package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.extractor.OpusUtil;
import com.google.common.primitives.SignedBytes;
import java.util.Locale;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafb {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {PlaybackException.ERROR_CODE_IO_NETWORK_CONNECTION_TIMEOUT, 2000, 1920, 1601, Videoio.CAP_OPENNI2, 1001, 1000, 960, Videoio.CAP_PVAPI, Videoio.CAP_PVAPI, Videoio.CAP_PROP_XI_CC_MATRIX_01, 400, 400, 2048};

    /* JADX WARN: Code duplicated, block: B:146:0x020b  */
    /* JADX WARN: Code duplicated, block: B:148:0x0211  */
    /* JADX WARN: Code duplicated, block: B:155:0x0225  */
    /* JADX WARN: Code duplicated, block: B:157:0x0239 A[LOOP:2: B:156:0x0237->B:157:0x0239, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:159:0x0248  */
    /* JADX WARN: Code duplicated, block: B:162:0x0251  */
    /* JADX WARN: Code duplicated, block: B:164:0x025b  */
    /* JADX WARN: Code duplicated, block: B:165:0x0260  */
    /* JADX WARN: Code duplicated, block: B:169:0x026b  */
    /* JADX WARN: Code duplicated, block: B:172:0x0271  */
    /* JADX WARN: Code duplicated, block: B:178:0x029b  */
    /* JADX WARN: Code duplicated, block: B:181:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:182:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:183:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:184:0x02af  */
    /* JADX WARN: Code duplicated, block: B:185:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:186:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:187:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:188:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:189:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:190:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:191:0x02be  */
    /* JADX WARN: Code duplicated, block: B:192:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:195:0x02c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:201:0x02d1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:202:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:205:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:208:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:209:0x02df  */
    /* JADX WARN: Code duplicated, block: B:210:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:212:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:214:0x02ee  */
    /* JADX WARN: Code duplicated, block: B:217:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:219:0x02f9  */
    /* JADX WARN: Code duplicated, block: B:221:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:223:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:225:0x0302  */
    /* JADX WARN: Code duplicated, block: B:227:0x0305  */
    /* JADX WARN: Code duplicated, block: B:228:0x032b  */
    /* JADX WARN: Code duplicated, block: B:229:0x032d  */
    /* JADX WARN: Code duplicated, block: B:230:0x0330  */
    /* JADX WARN: Code duplicated, block: B:231:0x0332  */
    /* JADX WARN: Code duplicated, block: B:232:0x0334  */
    /* JADX WARN: Code duplicated, block: B:235:0x0338  */
    /* JADX WARN: Code duplicated, block: B:237:0x037d  */
    public static zzv zza(zzet zzetVar, String str, String str2, zzq zzqVar) throws zzat {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        boolean zZzi;
        int iZzj;
        int iZzj2;
        int iZzj3;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int i14;
        int i15;
        int iZzc;
        int iZzj4;
        int i16;
        zzes zzesVar = new zzes();
        zzesVar.zza(zzetVar);
        int iZzc2 = zzesVar.zzc();
        int iZzj5 = zzesVar.zzj(3);
        if (iZzj5 > 1) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzj5).length() + 30);
            sb.append("Unsupported AC-4 DSI version: ");
            sb.append(iZzj5);
            throw zzat.zzc(sb.toString());
        }
        int iZzj6 = zzesVar.zzj(7);
        int i17 = true != zzesVar.zzi() ? 44100 : OpusUtil.SAMPLE_RATE;
        zzesVar.zzh(4);
        int iZzj7 = zzesVar.zzj(9);
        if (iZzj6 > 1) {
            if (iZzj5 == 0) {
                throw zzat.zzc("Invalid AC-4 DSI version: 0");
            }
            if (zzesVar.zzi()) {
                zzesVar.zzh(16);
                if (zzesVar.zzi()) {
                    zzesVar.zzh(128);
                }
            }
        }
        if (iZzj5 == 1) {
            if (!zzg(zzesVar)) {
                throw zzat.zzc("Invalid AC-4 DSI bitrate.");
            }
            zzesVar.zzm();
        }
        zzaez zzaezVar = new zzaez(null);
        int i18 = 0;
        while (true) {
            if (i18 < iZzj7) {
                if (iZzj5 == 0) {
                    zZzi = zzesVar.zzi();
                    iZzj = zzesVar.zzj(5);
                    iZzj2 = zzesVar.zzj(5);
                    iZzj3 = 0;
                    i11 = 0;
                    z2 = false;
                } else {
                    int iZzj8 = zzesVar.zzj(8);
                    iZzj3 = zzesVar.zzj(8);
                    if (iZzj3 == 255) {
                        iZzj3 = zzesVar.zzj(16) + 255;
                    }
                    if (iZzj8 > 2) {
                        zzesVar.zzh(iZzj3 * 8);
                        i18++;
                    } else {
                        int iZzc3 = (iZzc2 - zzesVar.zzc()) / 8;
                        iZzj = zzesVar.zzj(5);
                        iZzj2 = iZzj8;
                        z2 = iZzj == 31;
                        i11 = iZzc3;
                        zZzi = false;
                    }
                }
                zzaezVar.zzf = iZzj2;
                if (zZzi || z2 || iZzj != 6) {
                    zzaezVar.zzg = zzesVar.zzj(3);
                    if (zzesVar.zzi()) {
                        zzesVar.zzh(5);
                    }
                    zzesVar.zzh(2);
                    if (iZzj5 == 1) {
                        if (iZzj2 != 1) {
                            if (iZzj2 == 2) {
                                iZzj2 = 2;
                                zzesVar.zzh(2);
                            }
                            if (iZzj2 <= 0) {
                                i2 = 8;
                                i = 5;
                            } else {
                                if (!zzesVar.zzi() && !zzg(zzesVar)) {
                                    throw zzat.zzc("Can't parse bitrate DSI.");
                                }
                                if (zzesVar.zzi()) {
                                    zzesVar.zzm();
                                    zzesVar.zzo(zzesVar.zzj(16));
                                    i = 5;
                                    iZzj4 = zzesVar.zzj(5);
                                    for (i16 = 0; i16 < iZzj4; i16++) {
                                        zzesVar.zzh(3);
                                        zzesVar.zzh(8);
                                    }
                                    i2 = 8;
                                } else {
                                    i2 = 8;
                                    i = 5;
                                }
                            }
                            zzesVar.zzm();
                            if (iZzj5 == 1) {
                                iZzc = ((i12 - zzesVar.zzc()) / i2) - i11;
                                if (iZzj3 < iZzc) {
                                    throw zzat.zzc("pres_bytes is smaller than presentation bytes read.");
                                }
                                zzesVar.zzo(iZzj3 - iZzc);
                            }
                            if (zzaezVar.zza) {
                                i4 = -1;
                                if (zzaezVar.zzb == -1) {
                                    StringBuilder sb2 = new StringBuilder(String.valueOf(i18).length() + 45);
                                    sb2.append("Can't determine channel mode of presentation ");
                                    sb2.append(i18);
                                    throw zzat.zzc(sb2.toString());
                                }
                            }
                            if (zzaezVar.zza) {
                                i9 = zzaezVar.zzb;
                                z = zzaezVar.zzd;
                                i10 = zzaezVar.zze;
                                switch (i9) {
                                    case 0:
                                        i4 = 1;
                                        break;
                                    case 1:
                                        i4 = 2;
                                        break;
                                    case 2:
                                        i4 = 3;
                                        break;
                                    case 3:
                                        i4 = i;
                                        break;
                                    case 4:
                                        i4 = 6;
                                        break;
                                    case 5:
                                    case 7:
                                    case 9:
                                        i4 = i3;
                                        break;
                                    case 6:
                                    case 8:
                                    case 10:
                                        i4 = i2;
                                        break;
                                    case 11:
                                        i4 = 11;
                                        break;
                                    case 12:
                                        i4 = 12;
                                        break;
                                    case 13:
                                        i4 = 13;
                                        break;
                                    case 14:
                                        i4 = 14;
                                        break;
                                    case 15:
                                        i4 = 24;
                                        break;
                                }
                                if (i9 != 11 || i9 == 12 || i9 == 13 || i9 == 14) {
                                    if (!z) {
                                        i4 -= 2;
                                    }
                                    i8 = i4;
                                    if (i10 == 0) {
                                        i8 -= 4;
                                    } else if (i10 == 1) {
                                        i8 -= 2;
                                    }
                                } else {
                                    i8 = i4;
                                }
                            } else {
                                i5 = zzaezVar.zzc;
                                if (i5 > 0) {
                                    i8 = i5 + 1;
                                    if (zzaezVar.zzg == 4 && i8 == 17) {
                                        i8 = 21;
                                    }
                                } else {
                                    i6 = zzaezVar.zzg;
                                    if (i6 != 0) {
                                        i7 = 2;
                                    } else if (i6 != 1) {
                                        i7 = 2;
                                        if (i6 != 2) {
                                            i8 = i2;
                                        } else if (i6 != 3) {
                                            i8 = 10;
                                        } else if (i6 != 4) {
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(i6).length() + 33);
                                            sb3.append("AC-4 level ");
                                            sb3.append(i6);
                                            sb3.append(" has not been defined.");
                                            zzeg.zzc("Ac4Util", sb3.toString());
                                        } else {
                                            i8 = 12;
                                        }
                                    } else {
                                        i8 = 6;
                                    }
                                    i8 = i7;
                                }
                            }
                            if (i8 > 0) {
                                throw zzat.zzc("Cannot determine channel count of presentation.");
                            }
                            Object[] objArr = {Integer.valueOf(iZzj6), Integer.valueOf(zzaezVar.zzf), Integer.valueOf(zzaezVar.zzg)};
                            String str3 = zzfl.zza;
                            String str4 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr);
                            zzt zztVar = new zzt();
                            zztVar.zza(str);
                            zztVar.zzo(MimeTypes.AUDIO_AC4);
                            zztVar.zzG(i8);
                            zztVar.zzH(i17);
                            zztVar.zzs(zzqVar);
                            zztVar.zze(str2);
                            zztVar.zzk(str4);
                            return zztVar.zzO();
                        }
                        zzesVar.zzh(2);
                    }
                    zzesVar.zzh(5);
                    zzesVar.zzh(10);
                    if (iZzj5 == 1) {
                        if (iZzj2 > 0) {
                            zzaezVar.zza = zzesVar.zzi();
                        }
                        if (zzaezVar.zza) {
                            if (iZzj2 != 1) {
                                i13 = 2;
                                if (iZzj2 == 2) {
                                    i15 = 2;
                                } else {
                                    i12 = iZzc2;
                                    i15 = iZzj2;
                                }
                                zzesVar.zzh(24);
                                i14 = 1;
                            } else {
                                i15 = 1;
                            }
                            i12 = iZzc2;
                            int iZzj9 = zzesVar.zzj(5);
                            if (iZzj9 >= 0 && iZzj9 <= 15) {
                                zzaezVar.zzb = iZzj9;
                            }
                            if (iZzj9 < 11 || iZzj9 > 14) {
                                i13 = 2;
                            } else {
                                zzaezVar.zzd = zzesVar.zzi();
                                i13 = 2;
                                zzaezVar.zze = zzesVar.zzj(2);
                            }
                            zzesVar.zzh(24);
                            i14 = 1;
                        } else {
                            i12 = iZzc2;
                            i13 = 2;
                            i14 = 1;
                            i15 = iZzj2;
                        }
                        if (iZzj2 == i14 || iZzj2 == i13) {
                            if (zzesVar.zzi() && zzesVar.zzi()) {
                                zzesVar.zzh(i13);
                            }
                            if (zzesVar.zzi()) {
                                zzesVar.zzg();
                                int i19 = 8;
                                int iZzj10 = zzesVar.zzj(8);
                                int i20 = 0;
                                while (i20 < iZzj10) {
                                    zzesVar.zzh(i19);
                                    i20++;
                                    i19 = 8;
                                }
                            }
                        }
                        iZzj2 = i15;
                    } else {
                        i12 = iZzc2;
                    }
                    if (!zZzi && !z2) {
                        zzesVar.zzg();
                        if (iZzj == 0 || iZzj == 1 || iZzj == 2) {
                            if (iZzj2 == 0) {
                                for (int i21 = 0; i21 < 2; i21++) {
                                    zzd(zzesVar, zzaezVar);
                                }
                                iZzj2 = 0;
                            } else {
                                for (int i22 = 0; i22 < 2; i22++) {
                                    zze(zzesVar, zzaezVar);
                                }
                            }
                        } else if (iZzj == 3 || iZzj == 4) {
                            if (iZzj2 == 0) {
                                for (int i23 = 0; i23 < 3; i23++) {
                                    zzd(zzesVar, zzaezVar);
                                }
                                iZzj2 = 0;
                            } else {
                                for (int i24 = 0; i24 < 3; i24++) {
                                    zze(zzesVar, zzaezVar);
                                }
                            }
                        } else if (iZzj != 5) {
                            int iZzj11 = zzesVar.zzj(7);
                            for (int i25 = 0; i25 < iZzj11; i25++) {
                                zzesVar.zzh(8);
                            }
                        } else if (iZzj2 == 0) {
                            zzd(zzesVar, zzaezVar);
                            iZzj2 = 0;
                        } else {
                            int iZzj12 = zzesVar.zzj(3);
                            for (int i26 = 0; i26 < iZzj12 + 2; i26++) {
                                zze(zzesVar, zzaezVar);
                            }
                        }
                    } else if (iZzj2 == 0) {
                        zzd(zzesVar, zzaezVar);
                        iZzj2 = 0;
                    } else {
                        zze(zzesVar, zzaezVar);
                    }
                    zzesVar.zzg();
                    if (!zzesVar.zzi()) {
                        i3 = 7;
                    }
                    if (iZzj2 <= 0) {
                        i2 = 8;
                        i = 5;
                    } else {
                        if (!zzesVar.zzi()) {
                        }
                        if (zzesVar.zzi()) {
                            zzesVar.zzm();
                            zzesVar.zzo(zzesVar.zzj(16));
                            i = 5;
                            iZzj4 = zzesVar.zzj(5);
                            while (i16 < iZzj4) {
                                zzesVar.zzh(3);
                                zzesVar.zzh(8);
                            }
                            i2 = 8;
                        } else {
                            i2 = 8;
                            i = 5;
                        }
                    }
                    zzesVar.zzm();
                    if (iZzj5 == 1) {
                        iZzc = ((i12 - zzesVar.zzc()) / i2) - i11;
                        if (iZzj3 < iZzc) {
                            throw zzat.zzc("pres_bytes is smaller than presentation bytes read.");
                        }
                        zzesVar.zzo(iZzj3 - iZzc);
                    }
                    if (zzaezVar.zza) {
                        i4 = -1;
                        if (zzaezVar.zzb == -1) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(i18).length() + 45);
                            sb4.append("Can't determine channel mode of presentation ");
                            sb4.append(i18);
                            throw zzat.zzc(sb4.toString());
                        }
                    }
                    if (zzaezVar.zza) {
                        i9 = zzaezVar.zzb;
                        z = zzaezVar.zzd;
                        i10 = zzaezVar.zze;
                        switch (i9) {
                            case 0:
                                i4 = 1;
                                break;
                            case 1:
                                i4 = 2;
                                break;
                            case 2:
                                i4 = 3;
                                break;
                            case 3:
                                i4 = i;
                                break;
                            case 4:
                                i4 = 6;
                                break;
                            case 5:
                            case 7:
                            case 9:
                                i4 = i3;
                                break;
                            case 6:
                            case 8:
                            case 10:
                                i4 = i2;
                                break;
                            case 11:
                                i4 = 11;
                                break;
                            case 12:
                                i4 = 12;
                                break;
                            case 13:
                                i4 = 13;
                                break;
                            case 14:
                                i4 = 14;
                                break;
                            case 15:
                                i4 = 24;
                                break;
                        }
                        if (i9 != 11) {
                            if (!z) {
                                i4 -= 2;
                            }
                            i8 = i4;
                            if (i10 == 0) {
                                i8 -= 4;
                            } else if (i10 == 1) {
                                i8 -= 2;
                            }
                        } else {
                            if (!z) {
                                i4 -= 2;
                            }
                            i8 = i4;
                            if (i10 == 0) {
                                i8 -= 4;
                            } else if (i10 == 1) {
                                i8 -= 2;
                            }
                        }
                    } else {
                        i5 = zzaezVar.zzc;
                        if (i5 > 0) {
                            i8 = i5 + 1;
                            if (zzaezVar.zzg == 4) {
                                i8 = 21;
                            }
                        } else {
                            i6 = zzaezVar.zzg;
                            if (i6 != 0) {
                                i7 = 2;
                            } else if (i6 != 1) {
                                i7 = 2;
                                if (i6 != 2) {
                                    i8 = i2;
                                } else if (i6 != 3) {
                                    i8 = 10;
                                } else if (i6 != 4) {
                                    StringBuilder sb5 = new StringBuilder(String.valueOf(i6).length() + 33);
                                    sb5.append("AC-4 level ");
                                    sb5.append(i6);
                                    sb5.append(" has not been defined.");
                                    zzeg.zzc("Ac4Util", sb5.toString());
                                } else {
                                    i8 = 12;
                                }
                            } else {
                                i8 = 6;
                            }
                            i8 = i7;
                        }
                    }
                    if (i8 > 0) {
                        throw zzat.zzc("Cannot determine channel count of presentation.");
                    }
                    Object[] objArr2 = {Integer.valueOf(iZzj6), Integer.valueOf(zzaezVar.zzf), Integer.valueOf(zzaezVar.zzg)};
                    String str5 = zzfl.zza;
                    String str6 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr2);
                    zzt zztVar2 = new zzt();
                    zztVar2.zza(str);
                    zztVar2.zzo(MimeTypes.AUDIO_AC4);
                    zztVar2.zzG(i8);
                    zztVar2.zzH(i17);
                    zztVar2.zzs(zzqVar);
                    zztVar2.zze(str2);
                    zztVar2.zzk(str6);
                    return zztVar2.zzO();
                }
                i12 = iZzc2;
                i3 = 7;
                int iZzj13 = zzesVar.zzj(7);
                for (int i27 = 0; i27 < iZzj13; i27++) {
                    zzesVar.zzh(15);
                }
                if (iZzj2 <= 0) {
                    i2 = 8;
                    i = 5;
                } else {
                    if (!zzesVar.zzi()) {
                    }
                    if (zzesVar.zzi()) {
                        zzesVar.zzm();
                        zzesVar.zzo(zzesVar.zzj(16));
                        i = 5;
                        iZzj4 = zzesVar.zzj(5);
                        while (i16 < iZzj4) {
                            zzesVar.zzh(3);
                            zzesVar.zzh(8);
                        }
                        i2 = 8;
                    } else {
                        i2 = 8;
                        i = 5;
                    }
                }
                zzesVar.zzm();
                if (iZzj5 == 1) {
                    iZzc = ((i12 - zzesVar.zzc()) / i2) - i11;
                    if (iZzj3 < iZzc) {
                        throw zzat.zzc("pres_bytes is smaller than presentation bytes read.");
                    }
                    zzesVar.zzo(iZzj3 - iZzc);
                }
                if (zzaezVar.zza) {
                    i4 = -1;
                    if (zzaezVar.zzb == -1) {
                        StringBuilder sb6 = new StringBuilder(String.valueOf(i18).length() + 45);
                        sb6.append("Can't determine channel mode of presentation ");
                        sb6.append(i18);
                        throw zzat.zzc(sb6.toString());
                    }
                }
                if (zzaezVar.zza) {
                    i9 = zzaezVar.zzb;
                    z = zzaezVar.zzd;
                    i10 = zzaezVar.zze;
                    switch (i9) {
                        case 0:
                            i4 = 1;
                            break;
                        case 1:
                            i4 = 2;
                            break;
                        case 2:
                            i4 = 3;
                            break;
                        case 3:
                            i4 = i;
                            break;
                        case 4:
                            i4 = 6;
                            break;
                        case 5:
                        case 7:
                        case 9:
                            i4 = i3;
                            break;
                        case 6:
                        case 8:
                        case 10:
                            i4 = i2;
                            break;
                        case 11:
                            i4 = 11;
                            break;
                        case 12:
                            i4 = 12;
                            break;
                        case 13:
                            i4 = 13;
                            break;
                        case 14:
                            i4 = 14;
                            break;
                        case 15:
                            i4 = 24;
                            break;
                    }
                    if (i9 != 11) {
                        if (!z) {
                            i4 -= 2;
                        }
                        i8 = i4;
                        if (i10 == 0) {
                            i8 -= 4;
                        } else if (i10 == 1) {
                            i8 -= 2;
                        }
                    } else {
                        if (!z) {
                            i4 -= 2;
                        }
                        i8 = i4;
                        if (i10 == 0) {
                            i8 -= 4;
                        } else if (i10 == 1) {
                            i8 -= 2;
                        }
                    }
                } else {
                    i5 = zzaezVar.zzc;
                    if (i5 > 0) {
                        i8 = i5 + 1;
                        if (zzaezVar.zzg == 4) {
                            i8 = 21;
                        }
                    } else {
                        i6 = zzaezVar.zzg;
                        if (i6 != 0) {
                            i7 = 2;
                        } else if (i6 != 1) {
                            i7 = 2;
                            if (i6 != 2) {
                                i8 = i2;
                            } else if (i6 != 3) {
                                i8 = 10;
                            } else if (i6 != 4) {
                                StringBuilder sb7 = new StringBuilder(String.valueOf(i6).length() + 33);
                                sb7.append("AC-4 level ");
                                sb7.append(i6);
                                sb7.append(" has not been defined.");
                                zzeg.zzc("Ac4Util", sb7.toString());
                            } else {
                                i8 = 12;
                            }
                        } else {
                            i8 = 6;
                        }
                        i8 = i7;
                    }
                }
                if (i8 > 0) {
                    throw zzat.zzc("Cannot determine channel count of presentation.");
                }
                Object[] objArr3 = {Integer.valueOf(iZzj6), Integer.valueOf(zzaezVar.zzf), Integer.valueOf(zzaezVar.zzg)};
                String str7 = zzfl.zza;
                String str8 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr3);
                zzt zztVar3 = new zzt();
                zztVar3.zza(str);
                zztVar3.zzo(MimeTypes.AUDIO_AC4);
                zztVar3.zzG(i8);
                zztVar3.zzH(i17);
                zztVar3.zzs(zzqVar);
                zztVar3.zze(str2);
                zztVar3.zzk(str8);
                return zztVar3.zzO();
            }
            i = 5;
            i2 = 8;
            i3 = 7;
            i4 = -1;
            if (zzaezVar.zza) {
                i9 = zzaezVar.zzb;
                z = zzaezVar.zzd;
                i10 = zzaezVar.zze;
                switch (i9) {
                    case 0:
                        i4 = 1;
                        break;
                    case 1:
                        i4 = 2;
                        break;
                    case 2:
                        i4 = 3;
                        break;
                    case 3:
                        i4 = i;
                        break;
                    case 4:
                        i4 = 6;
                        break;
                    case 5:
                    case 7:
                    case 9:
                        i4 = i3;
                        break;
                    case 6:
                    case 8:
                    case 10:
                        i4 = i2;
                        break;
                    case 11:
                        i4 = 11;
                        break;
                    case 12:
                        i4 = 12;
                        break;
                    case 13:
                        i4 = 13;
                        break;
                    case 14:
                        i4 = 14;
                        break;
                    case 15:
                        i4 = 24;
                        break;
                }
                if (i9 != 11) {
                    if (!z) {
                        i4 -= 2;
                    }
                    i8 = i4;
                    if (i10 == 0) {
                        i8 -= 4;
                    } else if (i10 == 1) {
                        i8 -= 2;
                    }
                } else {
                    if (!z) {
                        i4 -= 2;
                    }
                    i8 = i4;
                    if (i10 == 0) {
                        i8 -= 4;
                    } else if (i10 == 1) {
                        i8 -= 2;
                    }
                }
            } else {
                i5 = zzaezVar.zzc;
                if (i5 > 0) {
                    i8 = i5 + 1;
                    if (zzaezVar.zzg == 4) {
                        i8 = 21;
                    }
                } else {
                    i6 = zzaezVar.zzg;
                    if (i6 != 0) {
                        i7 = 2;
                    } else if (i6 != 1) {
                        i7 = 2;
                        if (i6 != 2) {
                            i8 = i2;
                        } else if (i6 != 3) {
                            i8 = 10;
                        } else if (i6 != 4) {
                            StringBuilder sb8 = new StringBuilder(String.valueOf(i6).length() + 33);
                            sb8.append("AC-4 level ");
                            sb8.append(i6);
                            sb8.append(" has not been defined.");
                            zzeg.zzc("Ac4Util", sb8.toString());
                        } else {
                            i8 = 12;
                        }
                    } else {
                        i8 = 6;
                    }
                    i8 = i7;
                }
            }
            if (i8 > 0) {
                throw zzat.zzc("Cannot determine channel count of presentation.");
            }
            Object[] objArr4 = {Integer.valueOf(iZzj6), Integer.valueOf(zzaezVar.zzf), Integer.valueOf(zzaezVar.zzg)};
            String str9 = zzfl.zza;
            String str10 = String.format(Locale.US, "ac-4.%02d.%02d.%02d", objArr4);
            zzt zztVar4 = new zzt();
            zztVar4.zza(str);
            zztVar4.zzo(MimeTypes.AUDIO_AC4);
            zztVar4.zzG(i8);
            zztVar4.zzH(i17);
            zztVar4.zzs(zzqVar);
            zztVar4.zze(str2);
            zztVar4.zzk(str10);
            return zztVar4.zzO();
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0098  */
    /* JADX WARN: Code duplicated, block: B:49:0x009c  */
    public static zzafa zzb(zzes zzesVar) {
        int i;
        int iZzj;
        int iZzj2 = zzesVar.zzj(16);
        int iZzj3 = zzesVar.zzj(16);
        if (iZzj3 == 65535) {
            iZzj3 = zzesVar.zzj(24);
            i = 7;
        } else {
            i = 4;
        }
        int i2 = iZzj3 + i;
        if (iZzj2 == 44097) {
            i2 += 2;
        }
        int i3 = i2;
        int iZzj4 = zzesVar.zzj(2);
        int i4 = 0;
        if (iZzj4 == 3) {
            int i5 = 0;
            while (true) {
                iZzj = i5 + zzesVar.zzj(2);
                if (!zzesVar.zzi()) {
                    break;
                }
                i5 = (iZzj + 1) << 2;
            }
            iZzj4 = iZzj + 3;
        }
        int i6 = iZzj4;
        int iZzj5 = zzesVar.zzj(10);
        if (zzesVar.zzi() && zzesVar.zzj(3) > 0) {
            zzesVar.zzh(2);
        }
        int i7 = 44100;
        if (true == zzesVar.zzi()) {
            i7 = 48000;
        }
        int iZzj6 = zzesVar.zzj(4);
        if (i7 == 44100 && iZzj6 == 13) {
            i4 = zzb[13];
        } else if (i7 == 48000 && iZzj6 < 14) {
            i4 = zzb[iZzj6];
            int i8 = iZzj5 % 5;
            if (i8 == 1) {
                if (iZzj6 != 3 || iZzj6 == 8) {
                    i4++;
                }
            } else if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 == 4 && (iZzj6 == 3 || iZzj6 == 8 || iZzj6 == 11)) {
                        i4++;
                    }
                } else if (iZzj6 != 3) {
                    i4++;
                } else {
                    i4++;
                }
            } else if (iZzj6 == 8 || iZzj6 == 11) {
                i4++;
            }
        }
        return new zzafa(i6, 2, i7, i3, i4, null);
    }

    public static void zzc(int i, zzet zzetVar) {
        zzetVar.zza(7);
        byte[] bArrZzi = zzetVar.zzi();
        bArrZzi[0] = -84;
        bArrZzi[1] = SignedBytes.MAX_POWER_OF_TWO;
        bArrZzi[2] = -1;
        bArrZzi[3] = -1;
        bArrZzi[4] = (byte) ((i >> 16) & 255);
        bArrZzi[5] = (byte) ((i >> 8) & 255);
        bArrZzi[6] = (byte) (i & 255);
    }

    private static void zzd(zzes zzesVar, zzaez zzaezVar) throws zzat {
        int iZzj = zzesVar.zzj(5);
        zzesVar.zzh(2);
        if (zzesVar.zzi()) {
            zzesVar.zzh(5);
        }
        if (iZzj >= 7 && iZzj <= 10) {
            zzesVar.zzg();
        }
        if (zzesVar.zzi()) {
            int iZzj2 = zzesVar.zzj(3);
            if (zzaezVar.zzb == -1 && iZzj >= 0 && iZzj <= 15 && (iZzj2 == 0 || iZzj2 == 1)) {
                zzaezVar.zzb = iZzj;
            }
            if (zzesVar.zzi()) {
                zzf(zzesVar);
            }
        }
    }

    private static void zze(zzes zzesVar, zzaez zzaezVar) throws zzat {
        zzesVar.zzh(2);
        boolean zZzi = zzesVar.zzi();
        int iZzj = zzesVar.zzj(8);
        for (int i = 0; i < iZzj; i++) {
            zzesVar.zzh(2);
            if (zzesVar.zzi()) {
                zzesVar.zzh(5);
            }
            if (zZzi) {
                zzesVar.zzh(24);
            } else {
                if (zzesVar.zzi()) {
                    if (!zzesVar.zzi()) {
                        zzesVar.zzh(4);
                    }
                    zzaezVar.zzc = zzesVar.zzj(6) + 1;
                }
                zzesVar.zzh(4);
            }
        }
        if (zzesVar.zzi()) {
            zzesVar.zzh(3);
            if (zzesVar.zzi()) {
                zzf(zzesVar);
            }
        }
    }

    private static void zzf(zzes zzesVar) throws zzat {
        int iZzj = zzesVar.zzj(6);
        if (iZzj < 2 || iZzj > 42) {
            throw zzat.zzc(String.format("Invalid language tag bytes number: %d. Must be between 2 and 42.", Integer.valueOf(iZzj)));
        }
        zzesVar.zzh(iZzj * 8);
    }

    private static boolean zzg(zzes zzesVar) {
        if (zzesVar.zzc() < 66) {
            return false;
        }
        zzesVar.zzh(66);
        return true;
    }
}
