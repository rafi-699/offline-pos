package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.media3.common.MimeTypes;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzakg {
    public byte[] zzN;
    public zzahl zzT;
    public boolean zzV;
    public zzahk zzX;
    public zzv zzY;
    public int zzZ;
    public boolean zza;
    private int zzaa;
    public String zzb;
    public String zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;
    public boolean zzh;
    public byte[] zzi;
    public zzahj zzj;
    public byte[] zzk;
    public zzq zzl;
    public int zzm = -1;
    public int zzn = -1;
    public int zzo = -1;
    public int zzp = -1;
    public int zzq = -1;
    public int zzr = 0;
    public int zzs = -1;
    public float zzt = 0.0f;
    public float zzu = 0.0f;
    public float zzv = 0.0f;
    public byte[] zzw = null;
    public int zzx = -1;
    public int zzy = -1;
    public int zzz = -1;
    public int zzA = -1;
    public int zzB = 1000;
    public int zzC = 200;
    public float zzD = -1.0f;
    public float zzE = -1.0f;
    public float zzF = -1.0f;
    public float zzG = -1.0f;
    public float zzH = -1.0f;
    public float zzI = -1.0f;
    public float zzJ = -1.0f;
    public float zzK = -1.0f;
    public float zzL = -1.0f;
    public float zzM = -1.0f;
    public int zzO = 1;
    public int zzP = -1;
    public int zzQ = 8000;
    public long zzR = 0;
    public long zzS = 0;
    public boolean zzU = false;
    public boolean zzW = true;
    private String zzab = "eng";

    protected zzakg() {
    }

    private static Pair zzf(zzet zzetVar) throws zzat {
        try {
            zzetVar.zzk(16);
            long jZzA = zzetVar.zzA();
            if (jZzA == 1482049860) {
                return new Pair(MimeTypes.VIDEO_DIVX, null);
            }
            if (jZzA == 859189832) {
                return new Pair(MimeTypes.VIDEO_H263, null);
            }
            if (jZzA != 826496599) {
                zzeg.zzc("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                return new Pair(MimeTypes.VIDEO_UNKNOWN, null);
            }
            int iZzg = zzetVar.zzg() + 20;
            byte[] bArrZzi = zzetVar.zzi();
            while (true) {
                int length = bArrZzi.length;
                if (iZzg >= length - 4) {
                    throw zzat.zzb("Failed to find FourCC VC1 initialization data", null);
                }
                int i = iZzg + 1;
                if (bArrZzi[iZzg] == 0 && bArrZzi[i] == 0 && bArrZzi[iZzg + 2] == 1 && bArrZzi[iZzg + 3] == 15) {
                    return new Pair(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(bArrZzi, iZzg, length)));
                }
                iZzg = i;
            }
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing FourCC private data", null);
        }
    }

    private static List zzg(byte[] bArr) throws zzat {
        int i;
        int i2;
        try {
            if (bArr[0] != 2) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i3 = 0;
            int i4 = 1;
            while (true) {
                int i5 = bArr[i4];
                i4++;
                i = i5 & 255;
                if (i != 255) {
                    break;
                }
                i3 += 255;
            }
            int i6 = i3 + i;
            int i7 = 0;
            while (true) {
                int i8 = bArr[i4];
                i4++;
                i2 = i8 & 255;
                if (i2 != 255) {
                    break;
                }
                i7 += 255;
            }
            int i9 = i7 + i2;
            if (bArr[i4] != 1) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i4, bArr2, 0, i6);
            int i10 = i4 + i6;
            if (bArr[i10] != 3) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int i11 = i10 + i9;
            if (bArr[i11] != 5) {
                throw zzat.zzb("Error parsing vorbis codec private", null);
            }
            int length = bArr.length - i11;
            byte[] bArr3 = new byte[length];
            System.arraycopy(bArr, i11, bArr3, 0, length);
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(bArr2);
            arrayList.add(bArr3);
            return arrayList;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing vorbis codec private", null);
        }
    }

    private static boolean zzh(zzet zzetVar) throws zzat {
        try {
            int iZzu = zzetVar.zzu();
            if (iZzu == 1) {
                return true;
            }
            if (iZzu == 65534) {
                zzetVar.zzh(24);
                if (zzetVar.zzD() == zzakh.zzf.getMostSignificantBits() && zzetVar.zzD() == zzakh.zzf.getLeastSignificantBits()) {
                    return true;
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw zzat.zzb("Error parsing MS/ACM codec private", null);
        }
    }

    @EnsuresNonNull({"codecPrivate"})
    private final byte[] zzi(String str) throws zzat {
        byte[] bArr = this.zzk;
        if (bArr != null) {
            return bArr;
        }
        String.valueOf(str);
        throw zzat.zzb("Missing CodecPrivate for codec ".concat(String.valueOf(str)), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:107:0x0198  */
    /* JADX WARN: Code duplicated, block: B:176:0x043e  */
    /* JADX WARN: Code duplicated, block: B:179:0x0456  */
    /* JADX WARN: Code duplicated, block: B:182:0x0462  */
    /* JADX WARN: Code duplicated, block: B:183:0x0465  */
    /* JADX WARN: Code duplicated, block: B:186:0x0474  */
    /* JADX WARN: Code duplicated, block: B:187:0x0483  */
    /* JADX WARN: Code duplicated, block: B:189:0x0489  */
    /* JADX WARN: Code duplicated, block: B:191:0x048d  */
    /* JADX WARN: Code duplicated, block: B:193:0x0492  */
    /* JADX WARN: Code duplicated, block: B:196:0x049a  */
    /* JADX WARN: Code duplicated, block: B:198:0x049f  */
    /* JADX WARN: Code duplicated, block: B:201:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:204:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:206:0x04b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:207:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:208:0x04bb  */
    /* JADX WARN: Code duplicated, block: B:209:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:212:0x04c6  */
    /* JADX WARN: Code duplicated, block: B:214:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:218:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:220:0x04da  */
    /* JADX WARN: Code duplicated, block: B:221:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:224:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:244:0x05ac  */
    /* JADX WARN: Code duplicated, block: B:247:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:249:0x05db  */
    /* JADX WARN: Code duplicated, block: B:252:0x05f0  */
    /* JADX WARN: Code duplicated, block: B:271:0x063d  */
    /* JADX WARN: Code duplicated, block: B:273:0x065c  */
    /* JADX WARN: Code duplicated, block: B:275:0x0662  */
    /* JADX WARN: Code duplicated, block: B:290:0x068f  */
    /* JADX WARN: Code duplicated, block: B:292:0x069d  */
    /* JADX WARN: Code duplicated, block: B:295:0x06ac  */
    /* JADX WARN: Code duplicated, block: B:296:0x06af  */
    @RequiresNonNull({"codecId"})
    public final void zza(int i) throws zzat {
        byte b;
        List listZzj;
        int i2;
        int i3;
        int i4;
        int i5;
        List listZzk;
        int i6;
        int iZzB;
        int i7;
        List list;
        String str;
        int i8;
        int i9;
        String str2;
        List listZzg;
        int i10;
        String str3;
        String str4;
        int i11;
        zzt zztVar;
        int iIntValue;
        int i12;
        float f;
        int i13;
        int i14;
        byte[] bArr;
        int i15;
        int i16;
        int i17;
        int i18;
        String str5;
        zzfu zzfuVarZza;
        String str6 = this.zzc;
        switch (str6) {
            case "V_MPEG4/ISO/AP":
                b = 6;
                break;
            case "V_MPEG4/ISO/SP":
                b = 4;
                break;
            case "A_MS/ACM":
                b = Ascii.ETB;
                break;
            case "A_TRUEHD":
                b = Ascii.DC2;
                break;
            case "A_VORBIS":
                b = Ascii.VT;
                break;
            case "A_MPEG/L2":
                b = Ascii.SO;
                break;
            case "A_MPEG/L3":
                b = Ascii.SI;
                break;
            case "V_MS/VFW/FOURCC":
                b = 9;
                break;
            case "S_DVBSUB":
                b = 33;
                break;
            case "V_MPEG4/ISO/ASP":
                b = 5;
                break;
            case "V_MPEG4/ISO/AVC":
                b = 7;
                break;
            case "S_VOBSUB":
                b = Ascii.US;
                break;
            case "A_DTS/LOSSLESS":
                b = Ascii.NAK;
                break;
            case "A_AAC":
                b = Ascii.CR;
                break;
            case "A_AC3":
                b = Ascii.DLE;
                break;
            case "A_DTS":
                b = 19;
                break;
            case "V_AV1":
                b = 2;
                break;
            case "V_VP8":
                b = 0;
                break;
            case "V_VP9":
                b = 1;
                break;
            case "S_HDMV/PGS":
                b = 32;
                break;
            case "V_THEORA":
                b = 10;
                break;
            case "A_DTS/EXPRESS":
                b = Ascii.DC4;
                break;
            case "A_PCM/FLOAT/IEEE":
                b = Ascii.SUB;
                break;
            case "A_PCM/INT/BIG":
                b = Ascii.EM;
                break;
            case "A_PCM/INT/LIT":
                b = Ascii.CAN;
                break;
            case "S_TEXT/ASS":
                b = Ascii.FS;
                break;
            case "S_TEXT/SSA":
                b = Ascii.GS;
                break;
            case "V_MPEGH/ISO/HEVC":
                b = 8;
                break;
            case "S_TEXT/WEBVTT":
                b = Ascii.RS;
                break;
            case "S_TEXT/UTF8":
                b = Ascii.ESC;
                break;
            case "V_MPEG2":
                b = 3;
                break;
            case "A_EAC3":
                b = 17;
                break;
            case "A_FLAC":
                b = Ascii.SYN;
                break;
            case "A_OPUS":
                b = Ascii.FF;
                break;
            default:
                b = -1;
                break;
        }
        String str7 = MimeTypes.AUDIO_RAW;
        switch (b) {
            case 0:
                str7 = MimeTypes.VIDEO_VP8;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null || (zzfuVarZza = zzfu.zza(new zzet(this.zzN))) == null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str4 = zzfuVarZza.zza;
                    str3 = MimeTypes.VIDEO_DOLBY_VISION;
                }
                boolean z = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i19 = (z ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue || (i16 = this.zzq) == iIntValue) {
                        f = -1.0f;
                    } else {
                        f = (this.zzn * i12) / (this.zzm * i16);
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue && this.zzA == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue && (i6 = this.zzo) == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f || this.zzE == -1.0f || this.zzF == -1.0f || this.zzG == -1.0f || this.zzH == -1.0f || this.zzI == -1.0f || this.zzJ == -1.0f || this.zzK == -1.0f || this.zzL == -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else if (this.zzM == -1.0f) {
                        bArr = null;
                        i14 = 0;
                    } else {
                        bArr = new byte[25];
                        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                        i14 = 0;
                        byteBufferOrder.put((byte) 0);
                        byteBufferOrder.putShort((short) ((this.zzD * 50000.0f) + 0.5f));
                        byteBufferOrder.putShort((short) ((this.zzE * 50000.0f) + 0.5f));
                        byteBufferOrder.putShort((short) ((this.zzF * 50000.0f) + 0.5f));
                        byteBufferOrder.putShort((short) ((this.zzG * 50000.0f) + 0.5f));
                        byteBufferOrder.putShort((short) ((this.zzH * 50000.0f) + 0.5f));
                        byteBufferOrder.putShort((short) ((this.zzI * 50000.0f) + 0.5f));
                        byteBufferOrder.putShort((short) ((this.zzJ * 50000.0f) + 0.5f));
                        byteBufferOrder.putShort((short) ((this.zzK * 50000.0f) + 0.5f));
                        byteBufferOrder.putShort((short) (this.zzL + 0.5f));
                        byteBufferOrder.putShort((short) (this.zzM + 0.5f));
                        byteBufferOrder.putShort((short) this.zzB);
                        byteBufferOrder.putShort((short) this.zzC);
                    }
                    zzh zzhVar = new zzh();
                    zzhVar.zza(i2);
                    zzhVar.zzb(i4);
                    zzhVar.zzc(i3);
                    zzhVar.zzd(bArr);
                    zzhVar.zze(i6);
                    zzhVar.zzf(i13);
                    zzi zziVarZzg = zzhVar.zzg();
                    if (this.zzb != null) {
                        int i20 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0 || Float.compare(this.zzt, 0.0f) != 0 || Float.compare(this.zzu, 0.0f) != 0) {
                        i15 = iIntValue;
                    } else if (Float.compare(this.zzv, 0.0f) == 0) {
                        i15 = i14;
                    } else if (Float.compare(this.zzv, 90.0f) == 0) {
                        i15 = 90;
                    } else if (Float.compare(this.zzv, -180.0f) == 0 || Float.compare(this.zzv, 180.0f) == 0) {
                        i15 = RotationOptions.ROTATE_180;
                    } else if (Float.compare(this.zzv, -90.0f) == 0) {
                        i15 = RotationOptions.ROTATE_270;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3) && !MimeTypes.TEXT_SSA.equals(str3) && !MimeTypes.TEXT_VTT.equals(str3) && !MimeTypes.APPLICATION_VOBSUB.equals(str3) && !MimeTypes.APPLICATION_PGS.equals(str3) && !MimeTypes.APPLICATION_DVBSUBS.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i21 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i19);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 1:
                byte[] bArr2 = this.zzk;
                listZzj = bArr2 == null ? null : zzgwm.zzj(bArr2);
                str7 = MimeTypes.VIDEO_VP9;
                listZzk = listZzj;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z2 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i110 = (z2 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar2 = new zzh();
                    zzhVar2.zza(i2);
                    zzhVar2.zzb(i4);
                    zzhVar2.zzc(i3);
                    zzhVar2.zzd(bArr);
                    zzhVar2.zze(i6);
                    zzhVar2.zzf(i13);
                    zzi zziVarZzg2 = zzhVar2.zzg();
                    if (this.zzb != null) {
                        int i22 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg2);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i23 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i110);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 2:
                byte[] bArr3 = this.zzk;
                str7 = MimeTypes.VIDEO_AV1;
                if (bArr3 != null) {
                    zzafc zzafcVarZza = zzafc.zza(bArr3);
                    List list2 = zzafcVarZza.zza;
                    i2 = zzafcVarZza.zzc;
                    i3 = zzafcVarZza.zze;
                    i4 = zzafcVarZza.zzd;
                    i5 = zzafcVarZza.zzb;
                    listZzk = list2;
                    i6 = i5;
                    iZzB = -1;
                    i7 = -1;
                    str2 = null;
                    if (this.zzN != null) {
                        str3 = str7;
                        str4 = str2;
                    } else {
                        str3 = str7;
                        str4 = str2;
                    }
                    boolean z3 = this.zzW;
                    if (true != this.zzV) {
                        i11 = 0;
                    } else {
                        i11 = 2;
                    }
                    int i111 = (z3 ? 1 : 0) | i11;
                    zztVar = new zzt();
                    if (zzas.zza(str3)) {
                        zztVar.zzG(this.zzO);
                        zztVar.zzH(this.zzQ);
                        zztVar.zzI(iZzB);
                    } else if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i17 = this.zzp;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzm;
                            }
                            this.zzp = i17;
                            i18 = this.zzq;
                            if (i18 == -1) {
                                i18 = this.zzn;
                            }
                            this.zzq = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i12 = this.zzp;
                        if (i12 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (i2 == iIntValue) {
                            if (i3 != iIntValue) {
                                i2 = iIntValue;
                            } else if (i4 == iIntValue) {
                                i2 = this.zzy;
                                i3 = this.zzz;
                                i4 = this.zzA;
                            } else {
                                i2 = this.zzy;
                                i3 = this.zzz;
                                i4 = this.zzA;
                            }
                        }
                        if (i6 == iIntValue) {
                            i6 = 8;
                        }
                        if (i5 == iIntValue) {
                            i13 = this.zzo;
                            if (i13 == iIntValue) {
                                i13 = 8;
                            }
                        } else {
                            i13 = i5;
                        }
                        if (this.zzD != -1.0f) {
                            i14 = 0;
                            bArr = null;
                        } else {
                            i14 = 0;
                            bArr = null;
                        }
                        zzh zzhVar3 = new zzh();
                        zzhVar3.zza(i2);
                        zzhVar3.zzb(i4);
                        zzhVar3.zzc(i3);
                        zzhVar3.zzd(bArr);
                        zzhVar3.zze(i6);
                        zzhVar3.zzf(i13);
                        zzi zziVarZzg3 = zzhVar3.zzg();
                        if (this.zzb != null) {
                            int i24 = zzakh.zza;
                            if (zzakh.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i15 = iIntValue;
                        } else {
                            i15 = iIntValue;
                        }
                        zztVar.zzv(this.zzm);
                        zztVar.zzw(this.zzn);
                        zztVar.zzB(f);
                        zztVar.zzA(i15);
                        zztVar.zzC(this.zzw);
                        zztVar.zzD(this.zzx);
                        zztVar.zzE(zziVarZzg3);
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        throw zzat.zzb("Unexpected MIME type.", null);
                    }
                    if (this.zzb != null) {
                        int i25 = zzakh.zza;
                        if (!zzakh.zzg.containsKey(this.zzb)) {
                            zztVar.zzc(this.zzb);
                        }
                    }
                    zztVar.zzb(i);
                    if (true != this.zza) {
                        str5 = MimeTypes.VIDEO_MATROSKA;
                    } else {
                        str5 = MimeTypes.VIDEO_WEBM;
                    }
                    zztVar.zzn(str5);
                    zztVar.zzo(str3);
                    zztVar.zzp(i7);
                    zztVar.zze(this.zzab);
                    zztVar.zzf(i111);
                    zztVar.zzr(listZzk);
                    zztVar.zzk(str4);
                    zztVar.zzs(this.zzl);
                    this.zzY = zztVar.zzO();
                    return;
                }
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z4 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i112 = (z4 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar4 = new zzh();
                    zzhVar4.zza(i2);
                    zzhVar4.zzb(i4);
                    zzhVar4.zzc(i3);
                    zzhVar4.zzd(bArr);
                    zzhVar4.zze(i6);
                    zzhVar4.zzf(i13);
                    zzi zziVarZzg4 = zzhVar4.zzg();
                    if (this.zzb != null) {
                        int i26 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg4);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i27 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i112);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 3:
                str7 = MimeTypes.VIDEO_MPEG2;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z5 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i113 = (z5 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar5 = new zzh();
                    zzhVar5.zza(i2);
                    zzhVar5.zzb(i4);
                    zzhVar5.zzc(i3);
                    zzhVar5.zzd(bArr);
                    zzhVar5.zze(i6);
                    zzhVar5.zzf(i13);
                    zzi zziVarZzg5 = zzhVar5.zzg();
                    if (this.zzb != null) {
                        int i28 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg5);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i29 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i113);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 4:
            case 5:
            case 6:
                byte[] bArr4 = this.zzk;
                listZzj = bArr4 == null ? null : Collections.singletonList(bArr4);
                str7 = MimeTypes.VIDEO_MP4V;
                listZzk = listZzj;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z6 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i114 = (z6 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar6 = new zzh();
                    zzhVar6.zza(i2);
                    zzhVar6.zzb(i4);
                    zzhVar6.zzc(i3);
                    zzhVar6.zzd(bArr);
                    zzhVar6.zze(i6);
                    zzhVar6.zzf(i13);
                    zzi zziVarZzg6 = zzhVar6.zzg();
                    if (this.zzb != null) {
                        int i210 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg6);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i211 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i114);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 7:
                zzafd zzafdVarZza = zzafd.zza(new zzet(zzi(this.zzc)));
                list = zzafdVarZza.zza;
                this.zzZ = zzafdVarZza.zzb;
                str = zzafdVarZza.zzl;
                i2 = zzafdVarZza.zzg;
                i3 = zzafdVarZza.zzi;
                i4 = zzafdVarZza.zzh;
                i8 = zzafdVarZza.zze;
                i9 = zzafdVarZza.zzf;
                str7 = MimeTypes.VIDEO_H264;
                listZzk = list;
                str2 = str;
                i6 = i8;
                i7 = -1;
                i5 = i9;
                iZzB = -1;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z7 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i115 = (z7 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar7 = new zzh();
                    zzhVar7.zza(i2);
                    zzhVar7.zzb(i4);
                    zzhVar7.zzc(i3);
                    zzhVar7.zzd(bArr);
                    zzhVar7.zze(i6);
                    zzhVar7.zzf(i13);
                    zzi zziVarZzg7 = zzhVar7.zzg();
                    if (this.zzb != null) {
                        int i212 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg7);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i213 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i115);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 8:
                zzags zzagsVarZza = zzags.zza(new zzet(zzi(this.zzc)));
                list = zzagsVarZza.zza;
                this.zzZ = zzagsVarZza.zzb;
                str = zzagsVarZza.zzn;
                i2 = zzagsVarZza.zzh;
                i3 = zzagsVarZza.zzj;
                i4 = zzagsVarZza.zzi;
                i8 = zzagsVarZza.zzf;
                i9 = zzagsVarZza.zzg;
                str7 = MimeTypes.VIDEO_H265;
                listZzk = list;
                str2 = str;
                i6 = i8;
                i7 = -1;
                i5 = i9;
                iZzB = -1;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z8 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i116 = (z8 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar8 = new zzh();
                    zzhVar8.zza(i2);
                    zzhVar8.zzb(i4);
                    zzhVar8.zzc(i3);
                    zzhVar8.zzd(bArr);
                    zzhVar8.zze(i6);
                    zzhVar8.zzf(i13);
                    zzi zziVarZzg8 = zzhVar8.zzg();
                    if (this.zzb != null) {
                        int i214 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg8);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i215 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i116);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 9:
                Pair pairZzf = zzf(new zzet(zzi(this.zzc)));
                str7 = (String) pairZzf.first;
                listZzj = (List) pairZzf.second;
                listZzk = listZzj;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z9 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i117 = (z9 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar9 = new zzh();
                    zzhVar9.zza(i2);
                    zzhVar9.zzb(i4);
                    zzhVar9.zzc(i3);
                    zzhVar9.zzd(bArr);
                    zzhVar9.zze(i6);
                    zzhVar9.zzf(i13);
                    zzi zziVarZzg9 = zzhVar9.zzg();
                    if (this.zzb != null) {
                        int i216 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg9);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i217 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i117);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 10:
                str7 = MimeTypes.VIDEO_UNKNOWN;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z10 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i118 = (z10 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar10 = new zzh();
                    zzhVar10.zza(i2);
                    zzhVar10.zzb(i4);
                    zzhVar10.zzc(i3);
                    zzhVar10.zzd(bArr);
                    zzhVar10.zze(i6);
                    zzhVar10.zzf(i13);
                    zzi zziVarZzg10 = zzhVar10.zzg();
                    if (this.zzb != null) {
                        int i218 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg10);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i219 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i118);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 11:
                listZzg = zzg(zzi(str6));
                i10 = 8192;
                str7 = MimeTypes.AUDIO_VORBIS;
                listZzk = listZzg;
                i7 = i10;
                iZzB = -1;
                i6 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z11 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i119 = (z11 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar11 = new zzh();
                    zzhVar11.zza(i2);
                    zzhVar11.zzb(i4);
                    zzhVar11.zzc(i3);
                    zzhVar11.zzd(bArr);
                    zzhVar11.zze(i6);
                    zzhVar11.zzf(i13);
                    zzi zziVarZzg11 = zzhVar11.zzg();
                    if (this.zzb != null) {
                        int i2110 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg11);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2111 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i119);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 12:
                listZzg = new ArrayList(3);
                listZzg.add(zzi(this.zzc));
                listZzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzR).array());
                listZzg.add(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.zzS).array());
                i10 = 5760;
                str7 = MimeTypes.AUDIO_OPUS;
                listZzk = listZzg;
                i7 = i10;
                iZzB = -1;
                i6 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z12 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1110 = (z12 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar12 = new zzh();
                    zzhVar12.zza(i2);
                    zzhVar12.zzb(i4);
                    zzhVar12.zzc(i3);
                    zzhVar12.zzd(bArr);
                    zzhVar12.zze(i6);
                    zzhVar12.zzf(i13);
                    zzi zziVarZzg12 = zzhVar12.zzg();
                    if (this.zzb != null) {
                        int i2112 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg12);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2113 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1110);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 13:
                List listSingletonList = Collections.singletonList(zzi(str6));
                zzaev zzaevVarZza = zzaew.zza(this.zzk);
                this.zzQ = zzaevVarZza.zza;
                this.zzO = zzaevVarZza.zzb;
                String str8 = zzaevVarZza.zzc;
                str7 = MimeTypes.AUDIO_AAC;
                listZzk = listSingletonList;
                str2 = str8;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z13 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1111 = (z13 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar13 = new zzh();
                    zzhVar13.zza(i2);
                    zzhVar13.zzb(i4);
                    zzhVar13.zzc(i3);
                    zzhVar13.zzd(bArr);
                    zzhVar13.zze(i6);
                    zzhVar13.zzf(i13);
                    zzi zziVarZzg13 = zzhVar13.zzg();
                    if (this.zzb != null) {
                        int i2114 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg13);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2115 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1111);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 14:
                str7 = MimeTypes.AUDIO_MPEG_L2;
                i7 = 4096;
                iZzB = -1;
                i6 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z14 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1112 = (z14 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar14 = new zzh();
                    zzhVar14.zza(i2);
                    zzhVar14.zzb(i4);
                    zzhVar14.zzc(i3);
                    zzhVar14.zzd(bArr);
                    zzhVar14.zze(i6);
                    zzhVar14.zzf(i13);
                    zzi zziVarZzg14 = zzhVar14.zzg();
                    if (this.zzb != null) {
                        int i2116 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg14);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2117 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1112);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 15:
                str7 = MimeTypes.AUDIO_MPEG;
                i7 = 4096;
                iZzB = -1;
                i6 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z15 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1113 = (z15 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar15 = new zzh();
                    zzhVar15.zza(i2);
                    zzhVar15.zzb(i4);
                    zzhVar15.zzc(i3);
                    zzhVar15.zzd(bArr);
                    zzhVar15.zze(i6);
                    zzhVar15.zzf(i13);
                    zzi zziVarZzg15 = zzhVar15.zzg();
                    if (this.zzb != null) {
                        int i2118 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg15);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2119 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1113);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 16:
                str7 = MimeTypes.AUDIO_AC3;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z16 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1114 = (z16 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar16 = new zzh();
                    zzhVar16.zza(i2);
                    zzhVar16.zzb(i4);
                    zzhVar16.zzc(i3);
                    zzhVar16.zzd(bArr);
                    zzhVar16.zze(i6);
                    zzhVar16.zzf(i13);
                    zzi zziVarZzg16 = zzhVar16.zzg();
                    if (this.zzb != null) {
                        int i21110 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg16);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i21111 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1114);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 17:
                str7 = MimeTypes.AUDIO_E_AC3;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z17 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1115 = (z17 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar17 = new zzh();
                    zzhVar17.zza(i2);
                    zzhVar17.zzb(i4);
                    zzhVar17.zzc(i3);
                    zzhVar17.zzd(bArr);
                    zzhVar17.zze(i6);
                    zzhVar17.zzf(i13);
                    zzi zziVarZzg17 = zzhVar17.zzg();
                    if (this.zzb != null) {
                        int i21112 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg17);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i21113 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1115);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 18:
                this.zzT = new zzahl();
                str7 = MimeTypes.AUDIO_TRUEHD;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z18 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1116 = (z18 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar18 = new zzh();
                    zzhVar18.zza(i2);
                    zzhVar18.zzb(i4);
                    zzhVar18.zzc(i3);
                    zzhVar18.zzd(bArr);
                    zzhVar18.zze(i6);
                    zzhVar18.zzf(i13);
                    zzi zziVarZzg18 = zzhVar18.zzg();
                    if (this.zzb != null) {
                        int i21114 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg18);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i21115 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1116);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 19:
            case 20:
                this.zzU = true;
                str7 = MimeTypes.AUDIO_DTS;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z19 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1117 = (z19 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar19 = new zzh();
                    zzhVar19.zza(i2);
                    zzhVar19.zzb(i4);
                    zzhVar19.zzc(i3);
                    zzhVar19.zzd(bArr);
                    zzhVar19.zze(i6);
                    zzhVar19.zzf(i13);
                    zzi zziVarZzg19 = zzhVar19.zzg();
                    if (this.zzb != null) {
                        int i21116 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg19);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i21117 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1117);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 21:
                str7 = MimeTypes.AUDIO_DTS_HD;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z110 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1118 = (z110 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar110 = new zzh();
                    zzhVar110.zza(i2);
                    zzhVar110.zzb(i4);
                    zzhVar110.zzc(i3);
                    zzhVar110.zzd(bArr);
                    zzhVar110.zze(i6);
                    zzhVar110.zzf(i13);
                    zzi zziVarZzg110 = zzhVar110.zzg();
                    if (this.zzb != null) {
                        int i21118 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg110);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i21119 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1118);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 22:
                listZzj = Collections.singletonList(zzi(str6));
                str7 = MimeTypes.AUDIO_FLAC;
                listZzk = listZzj;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z111 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i1119 = (z111 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar111 = new zzh();
                    zzhVar111.zza(i2);
                    zzhVar111.zzb(i4);
                    zzhVar111.zzc(i3);
                    zzhVar111.zzd(bArr);
                    zzhVar111.zze(i6);
                    zzhVar111.zzf(i13);
                    zzi zziVarZzg111 = zzhVar111.zzg();
                    if (this.zzb != null) {
                        int i211110 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg111);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i211111 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i1119);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 23:
                if (zzh(new zzet(zzi(this.zzc)))) {
                    iZzB = zzfl.zzB(this.zzP, ByteOrder.LITTLE_ENDIAN);
                    if (iZzB == 0) {
                        int i30 = this.zzP;
                        StringBuilder sb = new StringBuilder(String.valueOf(i30).length() + 64);
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(i30);
                        sb.append(". Setting mimeType to audio/x-unknown");
                        zzeg.zzc("MatroskaExtractor", sb.toString());
                    }
                    i6 = -1;
                    i7 = -1;
                    i2 = -1;
                    i3 = -1;
                    i4 = -1;
                    i5 = -1;
                    str2 = null;
                    listZzk = null;
                    if (this.zzN != null) {
                        str3 = str7;
                        str4 = str2;
                    } else {
                        str3 = str7;
                        str4 = str2;
                    }
                    boolean z112 = this.zzW;
                    if (true != this.zzV) {
                        i11 = 0;
                    } else {
                        i11 = 2;
                    }
                    int i11110 = (z112 ? 1 : 0) | i11;
                    zztVar = new zzt();
                    if (zzas.zza(str3)) {
                        zztVar.zzG(this.zzO);
                        zztVar.zzH(this.zzQ);
                        zztVar.zzI(iZzB);
                    } else if (zzas.zzb(str3)) {
                        if (this.zzr == 0) {
                            i17 = this.zzp;
                            iIntValue = -1;
                            if (i17 == -1) {
                                i17 = this.zzm;
                            }
                            this.zzp = i17;
                            i18 = this.zzq;
                            if (i18 == -1) {
                                i18 = this.zzn;
                            }
                            this.zzq = i18;
                        } else {
                            iIntValue = -1;
                        }
                        i12 = this.zzp;
                        if (i12 != iIntValue) {
                            f = -1.0f;
                        } else {
                            f = -1.0f;
                        }
                        if (i2 == iIntValue) {
                            if (i3 != iIntValue) {
                                i2 = iIntValue;
                            } else if (i4 == iIntValue) {
                                i2 = this.zzy;
                                i3 = this.zzz;
                                i4 = this.zzA;
                            } else {
                                i2 = this.zzy;
                                i3 = this.zzz;
                                i4 = this.zzA;
                            }
                        }
                        if (i6 == iIntValue) {
                            i6 = 8;
                        }
                        if (i5 == iIntValue) {
                            i13 = this.zzo;
                            if (i13 == iIntValue) {
                                i13 = 8;
                            }
                        } else {
                            i13 = i5;
                        }
                        if (this.zzD != -1.0f) {
                            i14 = 0;
                            bArr = null;
                        } else {
                            i14 = 0;
                            bArr = null;
                        }
                        zzh zzhVar112 = new zzh();
                        zzhVar112.zza(i2);
                        zzhVar112.zzb(i4);
                        zzhVar112.zzc(i3);
                        zzhVar112.zzd(bArr);
                        zzhVar112.zze(i6);
                        zzhVar112.zzf(i13);
                        zzi zziVarZzg112 = zzhVar112.zzg();
                        if (this.zzb != null) {
                            int i211112 = zzakh.zza;
                            if (zzakh.zzg.containsKey(this.zzb)) {
                                iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                            }
                        }
                        if (this.zzs == 0) {
                            i15 = iIntValue;
                        } else {
                            i15 = iIntValue;
                        }
                        zztVar.zzv(this.zzm);
                        zztVar.zzw(this.zzn);
                        zztVar.zzB(f);
                        zztVar.zzA(i15);
                        zztVar.zzC(this.zzw);
                        zztVar.zzD(this.zzx);
                        zztVar.zzE(zziVarZzg112);
                    } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                        throw zzat.zzb("Unexpected MIME type.", null);
                    }
                    if (this.zzb != null) {
                        int i211113 = zzakh.zza;
                        if (!zzakh.zzg.containsKey(this.zzb)) {
                            zztVar.zzc(this.zzb);
                        }
                    }
                    zztVar.zzb(i);
                    if (true != this.zza) {
                        str5 = MimeTypes.VIDEO_MATROSKA;
                    } else {
                        str5 = MimeTypes.VIDEO_WEBM;
                    }
                    zztVar.zzn(str5);
                    zztVar.zzo(str3);
                    zztVar.zzp(i7);
                    zztVar.zze(this.zzab);
                    zztVar.zzf(i11110);
                    zztVar.zzr(listZzk);
                    zztVar.zzk(str4);
                    zztVar.zzs(this.zzl);
                    this.zzY = zztVar.zzO();
                    return;
                }
                zzeg.zzc("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                str7 = MimeTypes.AUDIO_UNKNOWN;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z113 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i11111 = (z113 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar113 = new zzh();
                    zzhVar113.zza(i2);
                    zzhVar113.zzb(i4);
                    zzhVar113.zzc(i3);
                    zzhVar113.zzd(bArr);
                    zzhVar113.zze(i6);
                    zzhVar113.zzf(i13);
                    zzi zziVarZzg113 = zzhVar113.zzg();
                    if (this.zzb != null) {
                        int i211114 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg113);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i211115 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i11111);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 24:
                iZzB = zzfl.zzB(this.zzP, ByteOrder.LITTLE_ENDIAN);
                if (iZzB == 0) {
                    int i31 = this.zzP;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i31).length() + 78);
                    sb2.append("Unsupported little endian PCM bit depth: ");
                    sb2.append(i31);
                    sb2.append(". Setting mimeType to audio/x-unknown");
                    zzeg.zzc("MatroskaExtractor", sb2.toString());
                    str7 = MimeTypes.AUDIO_UNKNOWN;
                    iZzB = -1;
                }
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z114 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i11112 = (z114 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar114 = new zzh();
                    zzhVar114.zza(i2);
                    zzhVar114.zzb(i4);
                    zzhVar114.zzc(i3);
                    zzhVar114.zzd(bArr);
                    zzhVar114.zze(i6);
                    zzhVar114.zzf(i13);
                    zzi zziVarZzg114 = zzhVar114.zzg();
                    if (this.zzb != null) {
                        int i211116 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg114);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i211117 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i11112);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 25:
                iZzB = zzfl.zzB(this.zzP, ByteOrder.BIG_ENDIAN);
                if (iZzB == 0) {
                    int i32 = this.zzP;
                    StringBuilder sb3 = new StringBuilder(String.valueOf(i32).length() + 75);
                    sb3.append("Unsupported big endian PCM bit depth: ");
                    sb3.append(i32);
                    sb3.append(". Setting mimeType to audio/x-unknown");
                    zzeg.zzc("MatroskaExtractor", sb3.toString());
                    str7 = MimeTypes.AUDIO_UNKNOWN;
                    iZzB = -1;
                }
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z115 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i11113 = (z115 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar115 = new zzh();
                    zzhVar115.zza(i2);
                    zzhVar115.zzb(i4);
                    zzhVar115.zzc(i3);
                    zzhVar115.zzd(bArr);
                    zzhVar115.zze(i6);
                    zzhVar115.zzf(i13);
                    zzi zziVarZzg115 = zzhVar115.zzg();
                    if (this.zzb != null) {
                        int i211118 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg115);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i211119 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i11113);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 26:
                iZzB = zzfl.zzC(this.zzP);
                if (iZzB == 0) {
                    int i33 = this.zzP;
                    StringBuilder sb4 = new StringBuilder(String.valueOf(i33).length() + 79);
                    sb4.append("Unsupported floating point PCM bit depth: ");
                    sb4.append(i33);
                    sb4.append(". Setting mimeType to audio/x-unknown");
                    zzeg.zzc("MatroskaExtractor", sb4.toString());
                    str7 = MimeTypes.AUDIO_UNKNOWN;
                    iZzB = -1;
                }
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z116 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i11114 = (z116 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar116 = new zzh();
                    zzhVar116.zza(i2);
                    zzhVar116.zzb(i4);
                    zzhVar116.zzc(i3);
                    zzhVar116.zzd(bArr);
                    zzhVar116.zze(i6);
                    zzhVar116.zzf(i13);
                    zzi zziVarZzg116 = zzhVar116.zzg();
                    if (this.zzb != null) {
                        int i2111110 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg116);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2111111 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i11114);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 27:
                str7 = MimeTypes.APPLICATION_SUBRIP;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z117 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i11115 = (z117 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar117 = new zzh();
                    zzhVar117.zza(i2);
                    zzhVar117.zzb(i4);
                    zzhVar117.zzc(i3);
                    zzhVar117.zzd(bArr);
                    zzhVar117.zze(i6);
                    zzhVar117.zzf(i13);
                    zzi zziVarZzg117 = zzhVar117.zzg();
                    if (this.zzb != null) {
                        int i2111112 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg117);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2111113 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i11115);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 28:
            case 29:
                int i34 = zzakh.zza;
                listZzk = zzgwm.zzk(zzakh.zzc, zzi(this.zzc));
                str7 = MimeTypes.TEXT_SSA;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z118 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i11116 = (z118 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar118 = new zzh();
                    zzhVar118.zza(i2);
                    zzhVar118.zzb(i4);
                    zzhVar118.zzc(i3);
                    zzhVar118.zzd(bArr);
                    zzhVar118.zze(i6);
                    zzhVar118.zzf(i13);
                    zzi zziVarZzg118 = zzhVar118.zzg();
                    if (this.zzb != null) {
                        int i2111114 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg118);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2111115 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i11116);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 30:
                str7 = MimeTypes.TEXT_VTT;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z119 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i11117 = (z119 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar119 = new zzh();
                    zzhVar119.zza(i2);
                    zzhVar119.zzb(i4);
                    zzhVar119.zzc(i3);
                    zzhVar119.zzd(bArr);
                    zzhVar119.zze(i6);
                    zzhVar119.zzf(i13);
                    zzi zziVarZzg119 = zzhVar119.zzg();
                    if (this.zzb != null) {
                        int i2111116 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg119);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2111117 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i11117);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 31:
                listZzk = zzgwm.zzj(zzi(str6));
                str7 = MimeTypes.APPLICATION_VOBSUB;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z1110 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i11118 = (z1110 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar1110 = new zzh();
                    zzhVar1110.zza(i2);
                    zzhVar1110.zzb(i4);
                    zzhVar1110.zzc(i3);
                    zzhVar1110.zzd(bArr);
                    zzhVar1110.zze(i6);
                    zzhVar1110.zzf(i13);
                    zzi zziVarZzg1110 = zzhVar1110.zzg();
                    if (this.zzb != null) {
                        int i2111118 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg1110);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i2111119 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i11118);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 32:
                str7 = MimeTypes.APPLICATION_PGS;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                listZzk = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z1111 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i11119 = (z1111 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar1111 = new zzh();
                    zzhVar1111.zza(i2);
                    zzhVar1111.zzb(i4);
                    zzhVar1111.zzc(i3);
                    zzhVar1111.zzd(bArr);
                    zzhVar1111.zze(i6);
                    zzhVar1111.zzf(i13);
                    zzi zziVarZzg1111 = zzhVar1111.zzg();
                    if (this.zzb != null) {
                        int i21111110 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg1111);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i21111111 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i11119);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            case 33:
                byte[] bArr5 = new byte[4];
                System.arraycopy(zzi(str6), 0, bArr5, 0, 4);
                listZzj = zzgwm.zzj(bArr5);
                str7 = MimeTypes.APPLICATION_DVBSUBS;
                listZzk = listZzj;
                iZzB = -1;
                i6 = -1;
                i7 = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                str2 = null;
                if (this.zzN != null) {
                    str3 = str7;
                    str4 = str2;
                } else {
                    str3 = str7;
                    str4 = str2;
                }
                boolean z1112 = this.zzW;
                if (true != this.zzV) {
                    i11 = 0;
                } else {
                    i11 = 2;
                }
                int i111110 = (z1112 ? 1 : 0) | i11;
                zztVar = new zzt();
                if (zzas.zza(str3)) {
                    zztVar.zzG(this.zzO);
                    zztVar.zzH(this.zzQ);
                    zztVar.zzI(iZzB);
                } else if (zzas.zzb(str3)) {
                    if (this.zzr == 0) {
                        i17 = this.zzp;
                        iIntValue = -1;
                        if (i17 == -1) {
                            i17 = this.zzm;
                        }
                        this.zzp = i17;
                        i18 = this.zzq;
                        if (i18 == -1) {
                            i18 = this.zzn;
                        }
                        this.zzq = i18;
                    } else {
                        iIntValue = -1;
                    }
                    i12 = this.zzp;
                    if (i12 != iIntValue) {
                        f = -1.0f;
                    } else {
                        f = -1.0f;
                    }
                    if (i2 == iIntValue) {
                        if (i3 != iIntValue) {
                            i2 = iIntValue;
                        } else if (i4 == iIntValue) {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        } else {
                            i2 = this.zzy;
                            i3 = this.zzz;
                            i4 = this.zzA;
                        }
                    }
                    if (i6 == iIntValue) {
                        i6 = 8;
                    }
                    if (i5 == iIntValue) {
                        i13 = this.zzo;
                        if (i13 == iIntValue) {
                            i13 = 8;
                        }
                    } else {
                        i13 = i5;
                    }
                    if (this.zzD != -1.0f) {
                        i14 = 0;
                        bArr = null;
                    } else {
                        i14 = 0;
                        bArr = null;
                    }
                    zzh zzhVar1112 = new zzh();
                    zzhVar1112.zza(i2);
                    zzhVar1112.zzb(i4);
                    zzhVar1112.zzc(i3);
                    zzhVar1112.zzd(bArr);
                    zzhVar1112.zze(i6);
                    zzhVar1112.zzf(i13);
                    zzi zziVarZzg1112 = zzhVar1112.zzg();
                    if (this.zzb != null) {
                        int i21111112 = zzakh.zza;
                        if (zzakh.zzg.containsKey(this.zzb)) {
                            iIntValue = ((Integer) zzakh.zzg.get(this.zzb)).intValue();
                        }
                    }
                    if (this.zzs == 0) {
                        i15 = iIntValue;
                    } else {
                        i15 = iIntValue;
                    }
                    zztVar.zzv(this.zzm);
                    zztVar.zzw(this.zzn);
                    zztVar.zzB(f);
                    zztVar.zzA(i15);
                    zztVar.zzC(this.zzw);
                    zztVar.zzD(this.zzx);
                    zztVar.zzE(zziVarZzg1112);
                } else if (!MimeTypes.APPLICATION_SUBRIP.equals(str3)) {
                    throw zzat.zzb("Unexpected MIME type.", null);
                }
                if (this.zzb != null) {
                    int i21111113 = zzakh.zza;
                    if (!zzakh.zzg.containsKey(this.zzb)) {
                        zztVar.zzc(this.zzb);
                    }
                }
                zztVar.zzb(i);
                if (true != this.zza) {
                    str5 = MimeTypes.VIDEO_MATROSKA;
                } else {
                    str5 = MimeTypes.VIDEO_WEBM;
                }
                zztVar.zzn(str5);
                zztVar.zzo(str3);
                zztVar.zzp(i7);
                zztVar.zze(this.zzab);
                zztVar.zzf(i111110);
                zztVar.zzr(listZzk);
                zztVar.zzk(str4);
                zztVar.zzs(this.zzl);
                this.zzY = zztVar.zzO();
                return;
            default:
                throw zzat.zzb("Unrecognized codec identifier.", null);
        }
    }

    final /* synthetic */ void zzb() {
        this.zzX.getClass();
    }

    final /* synthetic */ int zzc() {
        return this.zzaa;
    }

    final /* synthetic */ void zzd(int i) {
        this.zzaa = i;
    }

    final /* synthetic */ void zze(String str) {
        this.zzab = str;
    }
}
