package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhlc {
    private static final zzhkx zzb = new zzhkx(new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    private static final zzhkz zzc = new zzhkz(new zzhla(new long[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0}), new long[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0});
    static final byte[] zza = {-19, -45, -11, 92, Ascii.SUB, 99, Ascii.DC2, 88, -42, -100, -9, -94, -34, -7, -34, Ascii.DC4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.DLE};

    public static byte[] zza(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[64];
        int i2 = 0;
        while (true) {
            if (i2 >= 32) {
                break;
            }
            int i3 = i2 + i2;
            bArr2[i3] = (byte) (bArr[i2] & Ascii.SI);
            bArr2[i3 + 1] = (byte) ((bArr[i2] & 255) >> 4);
            i2++;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < 63) {
            byte b = (byte) (bArr2[i4] + i5);
            bArr2[i4] = b;
            int i6 = (b + 8) >> 4;
            bArr2[i4] = (byte) (b - (i6 << 4));
            i4++;
            i5 = i6;
        }
        bArr2[63] = (byte) (bArr2[63] + i5);
        zzhkz zzhkzVar = new zzhkz(zzc);
        zzhlb zzhlbVar = new zzhlb();
        for (i = 1; i < 64; i += 2) {
            zzhkx zzhkxVar = new zzhkx(zzb);
            zzk(zzhkxVar, i / 2, bArr2[i]);
            zzhlb.zza(zzhlbVar, zzhkzVar);
            zzg(zzhkzVar, zzhlbVar, zzhkxVar);
        }
        zzhla zzhlaVar = new zzhla();
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        zzhla.zza(zzhlaVar, zzhkzVar);
        zzi(zzhkzVar, zzhlaVar);
        for (int i7 = 0; i7 < 64; i7 += 2) {
            zzhkx zzhkxVar2 = new zzhkx(zzb);
            zzk(zzhkxVar2, i7 / 2, bArr2[i7]);
            zzhlb.zza(zzhlbVar, zzhkzVar);
            zzg(zzhkzVar, zzhlbVar, zzhkxVar2);
        }
        zzhla zzhlaVar2 = new zzhla(zzhkzVar);
        long[] jArr = new long[10];
        zzhlj.zzf(jArr, zzhlaVar2.zza);
        long[] jArr2 = new long[10];
        zzhlj.zzf(jArr2, zzhlaVar2.zzb);
        long[] jArr3 = new long[10];
        zzhlj.zzf(jArr3, zzhlaVar2.zzc);
        long[] jArr4 = new long[10];
        zzhlj.zzf(jArr4, jArr3);
        long[] jArr5 = new long[10];
        zzhlj.zzb(jArr5, jArr2, jArr);
        zzhlj.zze(jArr5, jArr5, jArr3);
        long[] jArr6 = new long[10];
        zzhlj.zze(jArr6, jArr, jArr2);
        zzhlj.zze(jArr6, jArr6, zzhle.zza);
        zzhlj.zza(jArr6, jArr6, jArr4);
        zzhlj.zzc(jArr6, jArr6);
        if (MessageDigest.isEqual(zzhlj.zzh(jArr5), zzhlj.zzh(jArr6))) {
            return zzhlaVar2.zzb();
        }
        throw new IllegalStateException("arithmetic error in scalar multiplication");
    }

    public static byte[] zzb(byte[] bArr) throws GeneralSecurityException {
        MessageDigest messageDigest = (MessageDigest) zzhzz.zzd.zzb("SHA-512");
        messageDigest.update(bArr, 0, 32);
        byte[] bArrDigest = messageDigest.digest();
        bArrDigest[0] = (byte) (bArrDigest[0] & 248);
        int i = bArrDigest[31] & 127;
        bArrDigest[31] = (byte) i;
        bArrDigest[31] = (byte) (i | 64);
        return bArrDigest;
    }

    public static boolean zzc(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte b;
        byte[] bArr4 = bArr2;
        if (bArr4.length != 64) {
            return false;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, 32, 64);
        int i = 31;
        while (i >= 0) {
            int i2 = bArrCopyOfRange[i] & 255;
            int i3 = zza[i] & 255;
            if (i2 != i3) {
                if (i2 >= i3) {
                    break;
                }
                MessageDigest messageDigest = (MessageDigest) zzhzz.zzd.zzb("SHA-512");
                messageDigest.update(bArr4, 0, 32);
                messageDigest.update(bArr3);
                messageDigest.update(bArr);
                byte[] bArrDigest = messageDigest.digest();
                long jZzn = zzn(bArrDigest, 0) & 2097151;
                long jZzo = zzo(bArrDigest, 2) >> 5;
                long jZzn2 = zzn(bArrDigest, 5) >> 2;
                long jZzo2 = zzo(bArrDigest, 7) >> 7;
                long jZzo3 = zzo(bArrDigest, 10) >> 4;
                long jZzn3 = zzn(bArrDigest, 13) >> 1;
                long jZzo4 = zzo(bArrDigest, 15) >> 6;
                long jZzn4 = zzn(bArrDigest, 18) >> 3;
                long jZzn5 = zzn(bArrDigest, 21) & 2097151;
                long jZzo5 = zzo(bArrDigest, 23) >> 5;
                long jZzn6 = zzn(bArrDigest, 26) >> 2;
                long jZzo6 = zzo(bArrDigest, 28) >> 7;
                long jZzo7 = zzo(bArrDigest, 31) >> 4;
                long jZzn7 = zzn(bArrDigest, 34) >> 1;
                long jZzo8 = zzo(bArrDigest, 36) >> 6;
                long jZzn8 = zzn(bArrDigest, 39) >> 3;
                long jZzn9 = zzn(bArrDigest, 42) & 2097151;
                long jZzo9 = zzo(bArrDigest, 44) >> 5;
                long jZzn10 = (zzn(bArrDigest, 47) >> 2) & 2097151;
                long jZzo10 = (zzo(bArrDigest, 49) >> 7) & 2097151;
                long jZzo11 = (zzo(bArrDigest, 52) >> 4) & 2097151;
                long jZzn11 = (zzn(bArrDigest, 55) >> 1) & 2097151;
                long jZzo12 = (zzo(bArrDigest, 57) >> 6) & 2097151;
                long jZzo13 = zzo(bArrDigest, 60) >> 3;
                long j = (jZzo4 & 2097151) + (jZzn10 * 666643);
                long j2 = (j + 1048576) >> 21;
                long j3 = j2 << 21;
                long j4 = jZzn5 + (jZzo11 * 666643) + (jZzo10 * 470296) + (jZzn10 * 654183);
                long j5 = (j4 + 1048576) >> 21;
                long j6 = j5 << 21;
                long j7 = (((((jZzn6 & 2097151) + (jZzo12 * 666643)) + (jZzn11 * 470296)) + (jZzo11 * 654183)) - (jZzo10 * 997805)) + (jZzn10 * 136657);
                long j8 = (j7 + 1048576) >> 21;
                long j9 = j8 << 21;
                long j10 = (((((jZzo7 & 2097151) + (jZzo13 * 470296)) + (jZzo12 * 654183)) - (jZzn11 * 997805)) + (jZzo11 * 136657)) - (jZzo10 * 683901);
                long j11 = (j10 + 1048576) >> 21;
                long j12 = (((jZzo8 & 2097151) - (jZzo13 * 997805)) + (jZzo12 * 136657)) - (jZzn11 * 683901);
                long j13 = (j12 + 1048576) >> 21;
                long j14 = jZzn9 - (jZzo13 * 683901);
                long j15 = (j14 + 1048576) >> 21;
                long j16 = jZzn4 + (jZzo10 * 666643) + (jZzn10 * 470296) + j2;
                long j17 = (j16 + 1048576) >> 21;
                long j18 = j17 << 21;
                long j19 = (((((jZzo5 & 2097151) + (jZzn11 * 666643)) + (jZzo11 * 470296)) + (jZzo10 * 654183)) - (jZzn10 * 997805)) + j5;
                long j20 = (j19 + 1048576) >> 21;
                long j21 = j20 << 21;
                long j22 = (((((((jZzo6 & 2097151) + (jZzo13 * 666643)) + (jZzo12 * 470296)) + (jZzn11 * 654183)) - (jZzo11 * 997805)) + (jZzo10 * 136657)) - (jZzn10 * 683901)) + j8;
                long j23 = (j22 + 1048576) >> 21;
                long j24 = j23 << 21;
                long j25 = (((((jZzn7 & 2097151) + (jZzo13 * 654183)) - (jZzo12 * 997805)) + (jZzn11 * 136657)) - (jZzo11 * 683901)) + j11;
                long j26 = (j25 + 1048576) >> 21;
                long j27 = ((jZzn8 + (jZzo13 * 136657)) - (jZzo12 * 683901)) + j13;
                long j28 = (j27 + 1048576) >> 21;
                long j29 = (j10 - (j11 << 21)) + j23;
                long j30 = jZzn + (j29 * 666643);
                long j31 = (j30 + 1048576) >> 21;
                long j32 = j31 << 21;
                long j33 = (j12 - (j13 << 21)) + j26;
                long j34 = j25 - (j26 << 21);
                long j35 = (jZzn2 & 2097151) + (j33 * 666643) + (j34 * 470296) + (j29 * 654183);
                long j36 = (j35 + 1048576) >> 21;
                long j37 = j36 << 21;
                long j38 = (j14 - (j15 << 21)) + j28;
                long j39 = j27 - (j28 << 21);
                long j40 = (((((jZzo3 & 2097151) + (j38 * 666643)) + (j39 * 470296)) + (j33 * 654183)) - (j34 * 997805)) + (j29 * 136657);
                long j41 = (j40 + 1048576) >> 21;
                long j42 = j41 << 21;
                long j43 = (jZzo9 & 2097151) + j15;
                long j44 = (((((j - j3) + (j43 * 470296)) + (j38 * 654183)) - (j39 * 997805)) + (j33 * 136657)) - (j34 * 683901);
                long j45 = (j44 + 1048576) >> 21;
                long j46 = j45 << 21;
                long j47 = ((((j4 - j6) + j17) - (j43 * 997805)) + (j38 * 136657)) - (j39 * 683901);
                long j48 = (j47 + 1048576) >> 21;
                long j49 = j48 << 21;
                long j50 = ((j7 - j9) + j20) - (j43 * 683901);
                long j51 = (j50 + 1048576) >> 21;
                long j52 = (jZzo & 2097151) + (j34 * 666643) + (j29 * 470296) + j31;
                long j53 = (j52 + 1048576) >> 21;
                long j54 = (((((jZzo2 & 2097151) + (j39 * 666643)) + (j33 * 470296)) + (j34 * 654183)) - (j29 * 997805)) + j36;
                long j55 = (j54 + 1048576) >> 21;
                long j56 = (((((((jZzn3 & 2097151) + (j43 * 666643)) + (j38 * 470296)) + (j39 * 654183)) - (j33 * 997805)) + (j34 * 136657)) - (j29 * 683901)) + j41;
                long j57 = (j56 + 1048576) >> 21;
                long j58 = (((((j16 - j18) + (j43 * 654183)) - (j38 * 997805)) + (j39 * 136657)) - (j33 * 683901)) + j45;
                long j59 = (j58 + 1048576) >> 21;
                long j60 = (((j19 - j21) + (j43 * 136657)) - (j38 * 683901)) + j48;
                long j61 = (j60 + 1048576) >> 21;
                long j62 = (j22 - j24) + j51;
                long j63 = (j62 + 1048576) >> 21;
                long j64 = j63 << 21;
                long j65 = (j30 - j32) + (j63 * 666643);
                long j66 = j65 >> 21;
                long j67 = j66 << 21;
                long j68 = (j52 - (j53 << 21)) + (j63 * 470296) + j66;
                long j69 = j68 >> 21;
                long j70 = j69 << 21;
                long j71 = (j35 - j37) + j53 + (j63 * 654183) + j69;
                long j72 = j71 >> 21;
                long j73 = j72 << 21;
                long j74 = ((j54 - (j55 << 21)) - (j63 * 997805)) + j72;
                long j75 = j74 >> 21;
                long j76 = j75 << 21;
                long j77 = (j40 - j42) + j55 + (j63 * 136657) + j75;
                long j78 = j77 >> 21;
                long j79 = j78 << 21;
                long j80 = ((j56 - (j57 << 21)) - (j63 * 683901)) + j78;
                long j81 = j80 >> 21;
                long j82 = j81 << 21;
                long j83 = (j44 - j46) + j57 + j81;
                long j84 = j83 >> 21;
                long j85 = j84 << 21;
                long j86 = (j58 - (j59 << 21)) + j84;
                long j87 = j86 >> 21;
                long j88 = j87 << 21;
                long j89 = (j47 - j49) + j59 + j87;
                long j90 = j89 >> 21;
                long j91 = j90 << 21;
                long j92 = (j60 - (j61 << 21)) + j90;
                long j93 = j92 >> 21;
                long j94 = j93 << 21;
                long j95 = (j50 - (j51 << 21)) + j61 + j93;
                long j96 = j95 >> 21;
                long j97 = j96 << 21;
                long j98 = (j62 - j64) + j96;
                long j99 = j98 >> 21;
                long j100 = j99 << 21;
                long j101 = (j65 - j67) + (666643 * j99);
                long j102 = j101 >> 21;
                long j103 = j102 << 21;
                long j104 = (j68 - j70) + (470296 * j99) + j102;
                long j105 = j104 >> 21;
                long j106 = j105 << 21;
                long j107 = (j71 - j73) + (654183 * j99) + j105;
                long j108 = j107 >> 21;
                long j109 = j108 << 21;
                long j110 = ((j74 - j76) - (997805 * j99)) + j108;
                long j111 = j110 >> 21;
                long j112 = j111 << 21;
                long j113 = (j77 - j79) + (136657 * j99) + j111;
                long j114 = j113 >> 21;
                long j115 = ((j80 - j82) - (j99 * 683901)) + j114;
                long j116 = j115 >> 21;
                long j117 = j116 << 21;
                long j118 = (j83 - j85) + j116;
                long j119 = j118 >> 21;
                long j120 = j119 << 21;
                long j121 = (j86 - j88) + j119;
                long j122 = j121 >> 21;
                long j123 = j122 << 21;
                long j124 = (j89 - j91) + j122;
                long j125 = j124 >> 21;
                long j126 = j125 << 21;
                long j127 = (j92 - j94) + j125;
                long j128 = j127 >> 21;
                long j129 = j128 << 21;
                long j130 = (j95 - j97) + j128;
                long j131 = j130 >> 21;
                long j132 = j101 - j103;
                bArrDigest[0] = (byte) j132;
                long j133 = j121 - j123;
                long j134 = j118 - j120;
                long j135 = j115 - j117;
                long j136 = j113 - (j114 << 21);
                long j137 = j110 - j112;
                long j138 = j107 - j109;
                long j139 = j104 - j106;
                bArrDigest[1] = (byte) (j132 >> 8);
                bArrDigest[2] = (byte) ((j132 >> 16) | (j139 << 5));
                bArrDigest[3] = (byte) (j139 >> 3);
                bArrDigest[4] = (byte) (j139 >> 11);
                bArrDigest[5] = (byte) ((j139 >> 19) | (j138 << 2));
                bArrDigest[6] = (byte) (j138 >> 6);
                bArrDigest[7] = (byte) ((j138 >> 14) | (j137 << 7));
                bArrDigest[8] = (byte) (j137 >> 1);
                bArrDigest[9] = (byte) (j137 >> 9);
                bArrDigest[10] = (byte) ((j137 >> 17) | (j136 << 4));
                bArrDigest[11] = (byte) (j136 >> 4);
                bArrDigest[12] = (byte) (j136 >> 12);
                bArrDigest[13] = (byte) ((j136 >> 20) | (j135 + j135));
                bArrDigest[14] = (byte) (j135 >> 7);
                bArrDigest[15] = (byte) ((j135 >> 15) | (j134 << 6));
                bArrDigest[16] = (byte) (j134 >> 2);
                bArrDigest[17] = (byte) (j134 >> 10);
                bArrDigest[18] = (byte) ((j134 >> 18) | (j133 << 3));
                long j140 = j130 - (j131 << 21);
                long j141 = (j98 - j100) + j131;
                long j142 = j127 - j129;
                long j143 = j124 - j126;
                bArrDigest[19] = (byte) (j133 >> 5);
                bArrDigest[20] = (byte) (j133 >> 13);
                bArrDigest[21] = (byte) j143;
                bArrDigest[22] = (byte) (j143 >> 8);
                bArrDigest[23] = (byte) ((j143 >> 16) | (j142 << 5));
                bArrDigest[24] = (byte) (j142 >> 3);
                bArrDigest[25] = (byte) (j142 >> 11);
                bArrDigest[26] = (byte) ((j142 >> 19) | (j140 << 2));
                bArrDigest[27] = (byte) (j140 >> 6);
                bArrDigest[28] = (byte) ((j140 >> 14) | (j141 << 7));
                bArrDigest[29] = (byte) (j141 >> 1);
                bArrDigest[30] = (byte) (j141 >> 9);
                bArrDigest[31] = (byte) (j141 >> 17);
                long[] jArr = new long[10];
                long[] jArrZzg = zzhlj.zzg(bArr3);
                long[] jArr2 = new long[10];
                jArr2[0] = 1;
                long[] jArr3 = new long[10];
                long[] jArr4 = new long[10];
                long[] jArr5 = new long[10];
                long[] jArr6 = new long[10];
                long[] jArr7 = new long[10];
                zzhlj.zzf(jArr4, jArrZzg);
                zzhlj.zze(jArr5, jArr4, zzhle.zza);
                zzhlj.zzb(jArr4, jArr4, jArr2);
                zzhlj.zza(jArr5, jArr5, jArr2);
                long[] jArr8 = new long[10];
                zzhlj.zzf(jArr8, jArr5);
                zzhlj.zze(jArr8, jArr8, jArr5);
                zzhlj.zzf(jArr, jArr8);
                zzhlj.zze(jArr, jArr, jArr5);
                zzhlj.zze(jArr, jArr, jArr4);
                long[] jArr9 = new long[10];
                long[] jArr10 = new long[10];
                long[] jArr11 = new long[10];
                zzhlj.zzf(jArr9, jArr);
                zzhlj.zzf(jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr10);
                zzhlj.zze(jArr10, jArr, jArr10);
                zzhlj.zze(jArr9, jArr9, jArr10);
                zzhlj.zzf(jArr9, jArr9);
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr9);
                for (int i4 = 1; i4 < 5; i4++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr9);
                for (int i5 = 1; i5 < 10; i5++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr10, jArr10, jArr9);
                zzhlj.zzf(jArr11, jArr10);
                for (int i6 = 1; i6 < 20; i6++) {
                    zzhlj.zzf(jArr11, jArr11);
                }
                zzhlj.zze(jArr10, jArr11, jArr10);
                zzhlj.zzf(jArr10, jArr10);
                for (int i7 = 1; i7 < 10; i7++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr10, jArr9);
                for (int i8 = 1; i8 < 50; i8++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr10, jArr10, jArr9);
                zzhlj.zzf(jArr11, jArr10);
                for (int i9 = 1; i9 < 100; i9++) {
                    zzhlj.zzf(jArr11, jArr11);
                }
                zzhlj.zze(jArr10, jArr11, jArr10);
                zzhlj.zzf(jArr10, jArr10);
                for (int i10 = 1; i10 < 50; i10++) {
                    zzhlj.zzf(jArr10, jArr10);
                }
                zzhlj.zze(jArr9, jArr10, jArr9);
                zzhlj.zzf(jArr9, jArr9);
                zzhlj.zzf(jArr9, jArr9);
                zzhlj.zze(jArr, jArr9, jArr);
                zzhlj.zze(jArr, jArr, jArr8);
                zzhlj.zze(jArr, jArr, jArr4);
                zzhlj.zzf(jArr6, jArr);
                zzhlj.zze(jArr6, jArr6, jArr5);
                zzhlj.zzb(jArr7, jArr6, jArr4);
                if (zze(jArr7)) {
                    zzhlj.zza(jArr7, jArr6, jArr4);
                    if (zze(jArr7)) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. No square root exists for modulo 2^255-19");
                    }
                    zzhlj.zze(jArr, jArr, zzhle.zzc);
                }
                if (zze(jArr)) {
                    b = 255;
                } else {
                    b = 255;
                    if (((bArr3[31] & 255) >> 7) != 0) {
                        throw new GeneralSecurityException("Cannot convert given bytes to extended projective coordinates. Computed x is zero and encoded x's least significant bit is not zero");
                    }
                }
                if (zzf(jArr) == ((bArr3[31] & b) >> 7)) {
                    zzm(jArr, jArr);
                }
                zzhlj.zze(jArr3, jArr, jArrZzg);
                zzhlb zzhlbVar = new zzhlb(new zzhla(jArr, jArrZzg, jArr2), jArr3);
                zzhky[] zzhkyVarArr = new zzhky[8];
                zzhkyVarArr[0] = new zzhky(zzhlbVar);
                zzhkz zzhkzVar = new zzhkz(new zzhla(), new long[10]);
                zzi(zzhkzVar, zzhlbVar.zza);
                zzhlb zzhlbVar2 = new zzhlb(zzhkzVar);
                for (int i11 = 1; i11 < 8; i11++) {
                    zzg(zzhkzVar, zzhlbVar2, zzhkyVarArr[i11 - 1]);
                    zzhkyVarArr[i11] = new zzhky(new zzhlb(zzhkzVar));
                }
                byte[] bArrZzl = zzl(bArrDigest);
                byte[] bArrZzl2 = zzl(bArrCopyOfRange);
                zzhkz zzhkzVar2 = new zzhkz(zzc);
                zzhlb zzhlbVar3 = new zzhlb();
                int i12 = b;
                while (i12 >= 0 && bArrZzl[i12] == 0 && bArrZzl2[i12] == 0) {
                    i12--;
                }
                while (i12 >= 0) {
                    zzi(zzhkzVar2, new zzhla(zzhkzVar2));
                    byte b2 = bArrZzl[i12];
                    if (b2 > 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzg(zzhkzVar2, zzhlbVar3, zzhkyVarArr[bArrZzl[i12] / 2]);
                    } else if (b2 < 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzh(zzhkzVar2, zzhlbVar3, zzhkyVarArr[(-bArrZzl[i12]) / 2]);
                    }
                    byte b3 = bArrZzl2[i12];
                    if (b3 > 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzg(zzhkzVar2, zzhlbVar3, zzhle.zze[bArrZzl2[i12] / 2]);
                    } else if (b3 < 0) {
                        zzhlb.zza(zzhlbVar3, zzhkzVar2);
                        zzh(zzhkzVar2, zzhlbVar3, zzhle.zze[(-bArrZzl2[i12]) / 2]);
                    }
                    i12--;
                }
                byte[] bArrZzb = new zzhla(zzhkzVar2).zzb();
                for (int i13 = 0; i13 < 32; i13++) {
                    if (bArrZzb[i13] != bArr2[i13]) {
                        return false;
                    }
                }
                return true;
            }
            i--;
            bArr4 = bArr2;
        }
        return false;
    }

    public static void zzd() {
        if (zzhle.zza == null) {
            throw new IllegalStateException("Could not initialize Ed25519.");
        }
    }

    static /* synthetic */ boolean zze(long[] jArr) {
        long[] jArr2 = new long[11];
        System.arraycopy(jArr, 0, jArr2, 0, 10);
        zzhlj.zzd(jArr2);
        byte[] bArrZzh = zzhlj.zzh(jArr2);
        for (int i = 0; i < 32; i++) {
            if (bArrZzh[i] != 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ int zzf(long[] jArr) {
        return zzhlj.zzh(jArr)[0] & 1;
    }

    private static void zzg(zzhkz zzhkzVar, zzhlb zzhlbVar, zzhkx zzhkxVar) {
        zzhla zzhlaVar = zzhlbVar.zza;
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhlaVar2.zza;
        long[] jArr3 = zzhlaVar.zzb;
        long[] jArr4 = zzhlaVar.zza;
        zzhlj.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhlaVar2.zzb;
        zzhlj.zzb(jArr5, jArr3, jArr4);
        zzhlj.zze(jArr5, jArr5, zzhkxVar.zzb);
        long[] jArr6 = zzhkxVar.zza;
        long[] jArr7 = zzhlaVar2.zzc;
        zzhlj.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhkzVar.zzb;
        zzhlj.zze(jArr8, zzhlbVar.zzb, zzhkxVar.zzc);
        zzhkxVar.zza(jArr2, zzhlaVar.zzc);
        zzhlj.zza(jArr, jArr2, jArr2);
        zzhlj.zzb(jArr2, jArr7, jArr5);
        zzhlj.zza(jArr5, jArr7, jArr5);
        zzhlj.zza(jArr7, jArr, jArr8);
        zzhlj.zzb(jArr8, jArr, jArr8);
    }

    private static void zzh(zzhkz zzhkzVar, zzhlb zzhlbVar, zzhkx zzhkxVar) {
        zzhla zzhlaVar = zzhlbVar.zza;
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = new long[10];
        long[] jArr2 = zzhlaVar2.zza;
        long[] jArr3 = zzhlaVar.zzb;
        long[] jArr4 = zzhlaVar.zza;
        zzhlj.zza(jArr2, jArr3, jArr4);
        long[] jArr5 = zzhlaVar2.zzb;
        zzhlj.zzb(jArr5, jArr3, jArr4);
        zzhlj.zze(jArr5, jArr5, zzhkxVar.zza);
        long[] jArr6 = zzhkxVar.zzb;
        long[] jArr7 = zzhlaVar2.zzc;
        zzhlj.zze(jArr7, jArr2, jArr6);
        long[] jArr8 = zzhkzVar.zzb;
        zzhlj.zze(jArr8, zzhlbVar.zzb, zzhkxVar.zzc);
        zzhkxVar.zza(jArr2, zzhlaVar.zzc);
        zzhlj.zza(jArr, jArr2, jArr2);
        zzhlj.zzb(jArr2, jArr7, jArr5);
        zzhlj.zza(jArr5, jArr7, jArr5);
        zzhlj.zzb(jArr7, jArr, jArr8);
        zzhlj.zza(jArr8, jArr, jArr8);
    }

    private static void zzi(zzhkz zzhkzVar, zzhla zzhlaVar) {
        zzhla zzhlaVar2 = zzhkzVar.zza;
        long[] jArr = zzhlaVar2.zza;
        long[] jArr2 = zzhlaVar.zza;
        long[] jArr3 = new long[10];
        zzhlj.zzf(jArr, jArr2);
        long[] jArr4 = zzhlaVar2.zzc;
        long[] jArr5 = zzhlaVar.zzb;
        zzhlj.zzf(jArr4, jArr5);
        long[] jArr6 = zzhkzVar.zzb;
        zzhlj.zzf(jArr6, zzhlaVar.zzc);
        zzhlj.zza(jArr6, jArr6, jArr6);
        long[] jArr7 = zzhlaVar2.zzb;
        zzhlj.zza(jArr7, jArr2, jArr5);
        zzhlj.zzf(jArr3, jArr7);
        zzhlj.zza(jArr7, jArr4, jArr);
        zzhlj.zzb(jArr4, jArr4, jArr);
        zzhlj.zzb(jArr, jArr3, jArr7);
        zzhlj.zzb(jArr6, jArr6, jArr4);
    }

    private static int zzj(int i, int i2) {
        int i3 = (~(i ^ i2)) & 255;
        int i4 = i3 & (i3 << 4);
        int i5 = i4 & (i4 << 2);
        return (i5 & (i5 + i5)) >> 7;
    }

    private static void zzk(zzhkx zzhkxVar, int i, byte b) {
        zzhkx[][] zzhkxVarArr = zzhle.zzd;
        int i2 = (b & 255) >> 7;
        int i3 = (-i2) & b;
        int i4 = b - (i3 + i3);
        zzhkxVar.zzb(zzhkxVarArr[i][0], zzj(i4, 1));
        zzhkxVar.zzb(zzhkxVarArr[i][1], zzj(i4, 2));
        zzhkxVar.zzb(zzhkxVarArr[i][2], zzj(i4, 3));
        zzhkxVar.zzb(zzhkxVarArr[i][3], zzj(i4, 4));
        zzhkxVar.zzb(zzhkxVarArr[i][4], zzj(i4, 5));
        zzhkxVar.zzb(zzhkxVarArr[i][5], zzj(i4, 6));
        zzhkxVar.zzb(zzhkxVarArr[i][6], zzj(i4, 7));
        zzhkxVar.zzb(zzhkxVarArr[i][7], zzj(i4, 8));
        long[] jArr = zzhkxVar.zzc;
        long[] jArr2 = zzhkxVar.zza;
        long[] jArrCopyOf = Arrays.copyOf(zzhkxVar.zzb, 10);
        long[] jArrCopyOf2 = Arrays.copyOf(jArr2, 10);
        long[] jArrCopyOf3 = Arrays.copyOf(jArr, 10);
        zzm(jArrCopyOf3, jArrCopyOf3);
        zzhkxVar.zzb(new zzhkx(jArrCopyOf, jArrCopyOf2, jArrCopyOf3), i2);
    }

    private static byte[] zzl(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[256];
        for (int i2 = 0; i2 < 256; i2++) {
            bArr2[i2] = (byte) (1 & ((bArr[i2 >> 3] & 255) >> (i2 & 7)));
        }
        for (int i3 = 0; i3 < 256; i3++) {
            if (bArr2[i3] != 0) {
                for (int i4 = 1; i4 <= 6 && (i = i3 + i4) < 256; i4++) {
                    byte b = bArr2[i];
                    if (b != 0) {
                        byte b2 = bArr2[i3];
                        int i5 = b << i4;
                        int i6 = b2 + i5;
                        if (i6 > 15) {
                            int i7 = b2 - i5;
                            if (i7 < -15) {
                                break;
                            }
                            bArr2[i3] = (byte) i7;
                            while (i < 256) {
                                if (bArr2[i] == 0) {
                                    bArr2[i] = 1;
                                    break;
                                }
                                bArr2[i] = 0;
                                i++;
                            }
                        } else {
                            bArr2[i3] = (byte) i6;
                            bArr2[i] = 0;
                        }
                    }
                }
            }
        }
        return bArr2;
    }

    private static void zzm(long[] jArr, long[] jArr2) {
        for (int i = 0; i < jArr2.length; i++) {
            jArr[i] = -jArr2[i];
        }
    }

    private static long zzn(byte[] bArr, int i) {
        return (((long) (bArr[i + 2] & 255)) << 16) | (bArr[i] & 255) | (((long) (bArr[i + 1] & 255)) << 8);
    }

    private static long zzo(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] & 255)) << 24) | zzn(bArr, i);
    }
}
