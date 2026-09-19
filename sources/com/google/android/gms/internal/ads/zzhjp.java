package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzhjp {
    int[] zza;
    private final int zzb;

    public zzhjp(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzhjn.zzd(bArr);
        this.zzb = i;
    }

    abstract int[] zza(int[] iArr, int i);

    abstract int zzb();

    public final byte[] zzc(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length != zzb()) {
            int iZzb = zzb();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzb).length() + 36);
            sb.append("The nonce length (in bytes) must be ");
            sb.append(iZzb);
            throw new GeneralSecurityException(sb.toString());
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining / 64;
        for (int i2 = 0; i2 < i + 1; i2++) {
            ByteBuffer byteBufferZzd = zzd(bArr, this.zzb + i2);
            if (i2 == i) {
                zzhzl.zzc(byteBufferAllocate, byteBuffer, byteBufferZzd, iRemaining % 64);
            } else {
                zzhzl.zzc(byteBufferAllocate, byteBuffer, byteBufferZzd, 64);
            }
        }
        return byteBufferAllocate.array();
    }

    final ByteBuffer zzd(byte[] bArr, int i) {
        int[] iArrZza = zza(zzhjn.zzd(bArr), i);
        int[] iArr = (int[]) iArrZza.clone();
        zzhjn.zzb(iArr);
        for (int i2 = 0; i2 < 16; i2++) {
            iArrZza[i2] = iArrZza[i2] + iArr[i2];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZza, 0, 16);
        return byteBufferOrder;
    }
}
