package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzicy extends zzicx {
    private final byte[] zzb;

    zzicy(byte[] bArr) {
        super(null);
        bArr.getClass();
        this.zzb = bArr;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    final byte zza(int i) {
        return this.zzb[i];
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final int zzb() {
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzc(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzD = zzD(i, i2, bArr.length);
        return iZzD == 0 ? zzida.zza : new zzicu(bArr, i, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzd(int i, int i2) {
        byte[] bArr = this.zzb;
        int iZzD = zzD(i, i2, bArr.length);
        return iZzD == 0 ? zzida.zza : new zzicu(bArr, i, iZzD);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzb, i, bArr, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final ByteBuffer zzf() {
        return ByteBuffer.wrap(this.zzb).asReadOnlyBuffer();
    }

    @Override // com.google.android.gms.internal.ads.zzida
    final void zzg(zzicr zzicrVar) throws IOException {
        byte[] bArr = this.zzb;
        zzicrVar.zza(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final String zzh(Charset charset) {
        return new String(this.zzb, charset);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final boolean zzi() {
        return zzihf.zza(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final boolean zzj(zzida zzidaVar) {
        if (zzidaVar instanceof zzicy) {
            return Arrays.equals(this.zzb, ((zzicy) zzidaVar).zzb);
        }
        return zzidaVar instanceof zzicu ? zzk(zzidaVar, 0, this.zzb.length) : zzidaVar.zzj(this);
    }

    @Override // com.google.android.gms.internal.ads.zzicx
    final boolean zzk(zzida zzidaVar, int i, int i2) {
        if (i2 > zzidaVar.zzb()) {
            byte[] bArr = this.zzb;
            int length = String.valueOf(i2).length();
            int length2 = bArr.length;
            StringBuilder sb = new StringBuilder(length + 18 + String.valueOf(length2).length());
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        int i3 = i + i2;
        if (i3 <= zzidaVar.zzb()) {
            if (zzidaVar instanceof zzicy) {
                return zzida.zzE(this.zzb, 0, ((zzicy) zzidaVar).zzb, i, i2);
            }
            if (!(zzidaVar instanceof zzicu)) {
                return zzidaVar.zzd(i, i3).equals(zzd(0, i2));
            }
            zzicu zzicuVar = (zzicu) zzidaVar;
            return zzida.zzE(this.zzb, 0, zzicuVar.zzn(), zzicuVar.zzo() + i, i2);
        }
        int iZzb = zzidaVar.zzb();
        int length3 = String.valueOf(i).length();
        StringBuilder sb2 = new StringBuilder(length3 + 24 + String.valueOf(i2).length() + 2 + String.valueOf(iZzb).length());
        sb2.append("Ran off end of other: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(iZzb);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final int zzl(int i, int i2, int i3) {
        return zzier.zzb(i, this.zzb, i2, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzide zzm() {
        byte[] bArr = this.zzb;
        return zzide.zzI(bArr, 0, bArr.length, true);
    }

    final /* synthetic */ byte[] zzn() {
        return this.zzb;
    }
}
