package com.google.android.gms.internal.ads;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztg extends zzcp {
    private zzhaf zzd;
    private zzhaf zze;

    /* JADX WARN: Code duplicated, block: B:28:0x0086  */
    /* JADX WARN: Code duplicated, block: B:29:0x008f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0097  */
    /* JADX WARN: Code duplicated, block: B:32:0x0099  */
    /* JADX WARN: Code duplicated, block: B:35:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:42:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:53:0x0106  */
    /* JADX WARN: Code duplicated, block: B:54:0x0109  */
    /* JADX WARN: Code duplicated, block: B:58:0x012b  */
    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzd(ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        zzhaf zzhafVar = this.zze;
        zzhafVar.getClass();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferZzk = zzk(((iLimit - iPosition) / this.zzb.zze) * this.zzc.zze);
        while (iPosition < iLimit) {
            for (int i6 = 0; i6 < zzhafVar.zzh(); i6++) {
                int iZzG = (zzfl.zzG(this.zzb.zzd) * zzhafVar.zzi(i6)) + iPosition;
                int i7 = this.zzb.zzd;
                if (i7 == 2) {
                    byteBufferZzk.putShort(byteBuffer.getShort(iZzG));
                } else if (i7 == 3) {
                    byteBufferZzk.put(byteBuffer.get(iZzG));
                } else if (i7 == 4) {
                    byteBufferZzk.putFloat(byteBuffer.getFloat(iZzG));
                } else if (i7 == 21) {
                    if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
                        i = iZzG;
                    } else {
                        i = iZzG + 2;
                    }
                    byte b = byteBuffer.get(i);
                    byte b2 = byteBuffer.get(iZzG + 1);
                    if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
                        iZzG += 2;
                    }
                    i2 = ((b << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) | ((b2 << Ascii.DLE) & 16711680) | ((byteBuffer.get(iZzG) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
                    i3 = i2 >> 8;
                    if ((i3 & ViewCompat.MEASURED_STATE_MASK) != 0 || (i3 & (-8388608)) == -8388608) {
                        z = true;
                    } else {
                        z = false;
                    }
                    zzgtj.zzf(z, "Value out of range of 24-bit integer: %s", Integer.toHexString(i3));
                    zzgtj.zza(byteBufferZzk.remaining() >= 3);
                    if (byteBufferZzk.order() == ByteOrder.BIG_ENDIAN) {
                        i4 = (i2 >> 24) & 255;
                    } else {
                        i4 = i3 & 255;
                    }
                    byte b3 = (byte) i4;
                    int i8 = (i2 >> 16) & 255;
                    if (byteBufferZzk.order() == ByteOrder.BIG_ENDIAN) {
                        i5 = i3 & 255;
                    } else {
                        i5 = (i2 >> 24) & 255;
                    }
                    byteBufferZzk.put(b3).put((byte) i8).put((byte) i5);
                } else if (i7 == 22) {
                    byteBufferZzk.putInt(byteBuffer.getInt(iZzG));
                } else if (i7 == 268435456) {
                    byteBufferZzk.putShort(byteBuffer.getShort(iZzG));
                } else if (i7 == 1342177280) {
                    if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
                        i = iZzG;
                    } else {
                        i = iZzG + 2;
                    }
                    byte b4 = byteBuffer.get(i);
                    byte b5 = byteBuffer.get(iZzG + 1);
                    if (byteBuffer.order() == ByteOrder.BIG_ENDIAN) {
                        iZzG += 2;
                    }
                    i2 = ((b4 << Ascii.CAN) & ViewCompat.MEASURED_STATE_MASK) | ((b5 << Ascii.DLE) & 16711680) | ((byteBuffer.get(iZzG) << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
                    i3 = i2 >> 8;
                    if ((i3 & ViewCompat.MEASURED_STATE_MASK) != 0) {
                        z = true;
                    } else {
                        z = true;
                    }
                    zzgtj.zzf(z, "Value out of range of 24-bit integer: %s", Integer.toHexString(i3));
                    zzgtj.zza(byteBufferZzk.remaining() >= 3);
                    if (byteBufferZzk.order() == ByteOrder.BIG_ENDIAN) {
                        i4 = (i2 >> 24) & 255;
                    } else {
                        i4 = i3 & 255;
                    }
                    byte b6 = (byte) i4;
                    int i9 = (i2 >> 16) & 255;
                    if (byteBufferZzk.order() == ByteOrder.BIG_ENDIAN) {
                        i5 = i3 & 255;
                    } else {
                        i5 = (i2 >> 24) & 255;
                    }
                    byteBufferZzk.put(b6).put((byte) i9).put((byte) i5);
                } else if (i7 == 1610612736) {
                    byteBufferZzk.putInt(byteBuffer.getInt(iZzG));
                } else {
                    if (i7 != 1879048192) {
                        StringBuilder sb = new StringBuilder(String.valueOf(i7).length() + 21);
                        sb.append("Unexpected encoding: ");
                        sb.append(i7);
                        throw new IllegalStateException(sb.toString());
                    }
                    byteBufferZzk.putDouble(byteBuffer.getDouble(iZzG));
                }
            }
            iPosition += this.zzb.zze;
        }
        byteBuffer.position(iLimit);
        byteBufferZzk.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl zzm(zzcl zzclVar) throws zzcn {
        zzhaf zzhafVar = this.zzd;
        if (zzhafVar == null) {
            return zzcl.zza;
        }
        int i = zzclVar.zzd;
        if (!zzfl.zzD(i)) {
            throw new zzcn("Unhandled input format:", zzclVar);
        }
        int iZzh = zzhafVar.zzh();
        int i2 = zzclVar.zzc;
        boolean z = i2 != iZzh;
        int i3 = 0;
        while (i3 < iZzh) {
            int iZzi = zzhafVar.zzi(i3);
            if (iZzi >= i2) {
                String string = zzhafVar.toString();
                StringBuilder sb = new StringBuilder(string.length() + 59);
                sb.append("Channel map (");
                sb.append(string);
                sb.append(") trying to access non-existent input channel.");
                throw new zzcn(sb.toString(), zzclVar);
            }
            z |= iZzi != i3;
            i3++;
        }
        return z ? new zzcl(zzclVar.zzb, iZzh, i) : zzcl.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    protected final void zzo(zzcm zzcmVar) {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    protected final void zzp() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzq(zzhaf zzhafVar) {
        this.zzd = zzhafVar;
    }
}
