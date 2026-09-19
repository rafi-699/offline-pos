package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzicp {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzico zzicoVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzicoVar);
        }
        zzicoVar.zza = b;
        return i2;
    }

    static int zzb(int i, byte[] bArr, int i2, zzico zzicoVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzicoVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzicoVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzicoVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzicoVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzicoVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzc(byte[] bArr, int i, zzico zzicoVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzicoVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzicoVar.zzb = j2;
        return i3;
    }

    static int zzd(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static long zze(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    static int zzf(byte[] bArr, int i, zzico zzicoVar) throws zziet {
        int iZza = zza(bArr, i, zzicoVar);
        int i2 = zzicoVar.zza;
        if (i2 < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zzicoVar.zzc = "";
            return iZza;
        }
        zzicoVar.zzc = zzihf.zze(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zzg(byte[] bArr, int i, zzico zzicoVar) throws zziet {
        int iZza = zza(bArr, i, zzicoVar);
        int i2 = zzicoVar.zza;
        if (i2 < 0) {
            throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZza) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzicoVar.zzc = zzida.zza;
            return iZza;
        }
        zzicoVar.zzc = zzida.zzt(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zzh(zzigh zzighVar, byte[] bArr, int i, int i2, zzico zzicoVar) throws IOException {
        Object objZza = zzighVar.zza();
        int iZzj = zzj(objZza, zzighVar, bArr, i, i2, zzicoVar);
        zzighVar.zzk(objZza);
        zzicoVar.zzc = objZza;
        return iZzj;
    }

    static int zzi(zzigh zzighVar, byte[] bArr, int i, int i2, int i3, zzico zzicoVar) throws IOException {
        Object objZza = zzighVar.zza();
        int iZzk = zzk(objZza, zzighVar, bArr, i, i2, i3, zzicoVar);
        zzighVar.zzk(objZza);
        zzicoVar.zzc = objZza;
        return iZzk;
    }

    static int zzj(Object obj, zzigh zzighVar, byte[] bArr, int i, int i2, zzico zzicoVar) throws IOException {
        int iZzb = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzb = zzb(i3, bArr, iZzb, zzicoVar);
            i3 = zzicoVar.zza;
        }
        int i4 = iZzb;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzicoVar.zze + 1;
        zzicoVar.zze = i5;
        zzq(i5);
        int i6 = i4 + i3;
        zzighVar.zzj(obj, bArr, i4, i6, zzicoVar);
        zzicoVar.zze--;
        zzicoVar.zzc = obj;
        return i6;
    }

    static int zzk(Object obj, zzigh zzighVar, byte[] bArr, int i, int i2, int i3, zzico zzicoVar) throws IOException {
        int i4 = zzicoVar.zze + 1;
        zzicoVar.zze = i4;
        zzq(i4);
        int iZzi = ((zzifs) zzighVar).zzi(obj, bArr, i, i2, i3, zzicoVar);
        zzicoVar.zze--;
        zzicoVar.zzc = obj;
        return iZzi;
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzieq zzieqVar, zzico zzicoVar) {
        zzief zziefVar = (zzief) zzieqVar;
        int iZza = zza(bArr, i2, zzicoVar);
        zziefVar.zzi(zzicoVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzicoVar);
            if (i != zzicoVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzicoVar);
            zziefVar.zzi(zzicoVar.zza);
        }
        return iZza;
    }

    static int zzm(byte[] bArr, int i, zzieq zzieqVar, zzico zzicoVar) throws IOException {
        zzief zziefVar = (zzief) zzieqVar;
        int iZza = zza(bArr, i, zzicoVar);
        int i2 = zzicoVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzicoVar);
            zziefVar.zzi(zzicoVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzn(zzigh zzighVar, int i, byte[] bArr, int i2, int i3, zzieq zzieqVar, zzico zzicoVar) throws IOException {
        int iZzh = zzh(zzighVar, bArr, i2, i3, zzicoVar);
        zzieqVar.add(zzicoVar.zzc);
        while (iZzh < i3) {
            int iZza = zza(bArr, iZzh, zzicoVar);
            if (i != zzicoVar.zza) {
                break;
            }
            iZzh = zzh(zzighVar, bArr, iZza, i3, zzicoVar);
            zzieqVar.add(zzicoVar.zzc);
        }
        return iZzh;
    }

    static int zzo(int i, byte[] bArr, int i2, int i3, zzigu zziguVar, zzico zzicoVar) throws zziet {
        if ((i >>> 3) == 0) {
            throw new zziet("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzc = zzc(bArr, i2, zzicoVar);
            zziguVar.zzk(i, Long.valueOf(zzicoVar.zzb));
            return iZzc;
        }
        if (i4 == 1) {
            zziguVar.zzk(i, Long.valueOf(zze(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzicoVar);
            int i5 = zzicoVar.zza;
            if (i5 < 0) {
                throw new zziet("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZza) {
                throw new zziet("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zziguVar.zzk(i, zzida.zza);
            } else {
                zziguVar.zzk(i, zzida.zzt(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zziet("Protocol message contained an invalid tag (zero).");
            }
            zziguVar.zzk(i, Integer.valueOf(zzd(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzigu zziguVarZzb = zzigu.zzb();
        int i7 = zzicoVar.zze + 1;
        zzicoVar.zze = i7;
        zzq(i7);
        int i8 = 0;
        while (i2 < i3) {
            int iZza2 = zza(bArr, i2, zzicoVar);
            int i9 = zzicoVar.zza;
            if (i9 == i6) {
                i8 = i9;
                i2 = iZza2;
                break;
            }
            i2 = zzo(i9, bArr, iZza2, i3, zziguVarZzb, zzicoVar);
            i8 = i9;
        }
        zzicoVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zziet("Failed to parse the message.");
        }
        zziguVar.zzk(i, zziguVarZzb);
        return i2;
    }

    static int zzp(int i, byte[] bArr, int i2, int i3, zzico zzicoVar) throws zziet {
        if ((i >>> 3) == 0) {
            throw new zziet("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzc(bArr, i2, zzicoVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zza(bArr, i2, zzicoVar) + zzicoVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zziet("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzicoVar);
            i6 = zzicoVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzp(i6, bArr, i2, i3, zzicoVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new zziet("Failed to parse the message.");
        }
        return i2;
    }

    private static void zzq(int i) throws zziet {
        if (i >= zzb) {
            throw new zziet("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
