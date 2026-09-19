package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzigg extends zzida {
    static final int[] zzb = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzc;
    private final zzida zzd;
    private final zzida zze;
    private final int zzf;
    private final int zzg;

    private zzigg(zzida zzidaVar, zzida zzidaVar2) {
        this.zzd = zzidaVar;
        this.zze = zzidaVar2;
        int iZzb = zzidaVar.zzb();
        this.zzf = iZzb;
        this.zzc = iZzb + zzidaVar2.zzb();
        this.zzg = Math.max(zzidaVar.zzp(), zzidaVar2.zzp()) + 1;
    }

    /* synthetic */ zzigg(zzida zzidaVar, zzida zzidaVar2, byte[] bArr) {
        this(zzidaVar, zzidaVar2);
    }

    private static zzida zzG(zzida zzidaVar, zzida zzidaVar2) {
        int iZzb = zzidaVar.zzb();
        int iZzb2 = zzidaVar2.zzb();
        byte[] bArr = new byte[iZzb + iZzb2];
        zzidaVar.zzz(bArr, 0, 0, iZzb);
        zzidaVar2.zzz(bArr, 0, iZzb, iZzb2);
        return zzida.zzv(bArr);
    }

    static zzida zzk(zzida zzidaVar, zzida zzidaVar2) {
        if (zzidaVar2.zzb() == 0) {
            return zzidaVar;
        }
        if (zzidaVar.zzb() == 0) {
            return zzidaVar2;
        }
        int iZzb = zzidaVar.zzb() + zzidaVar2.zzb();
        if (iZzb < 128) {
            return zzG(zzidaVar, zzidaVar2);
        }
        if (zzidaVar instanceof zzigg) {
            zzigg zziggVar = (zzigg) zzidaVar;
            zzida zzidaVar3 = zziggVar.zze;
            if (zzidaVar3.zzb() + zzidaVar2.zzb() < 128) {
                return new zzigg(zziggVar.zzd, zzG(zzidaVar3, zzidaVar2));
            }
            zzida zzidaVar4 = zziggVar.zzd;
            if (zzidaVar4.zzp() > zzidaVar3.zzp() && zziggVar.zzg > zzidaVar2.zzp()) {
                return new zzigg(zzidaVar4, new zzigg(zzidaVar3, zzidaVar2));
            }
        }
        return iZzb >= zzn(Math.max(zzidaVar.zzp(), zzidaVar2.zzp()) + 1) ? new zzigg(zzidaVar, zzidaVar2) : zzige.zza(zzidaVar, zzidaVar2, new ArrayDeque());
    }

    static int zzn(int i) {
        int[] iArr = zzb;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzida, java.lang.Iterable
    public final /* synthetic */ Iterator<Byte> iterator() {
        return new zzigd(this);
    }

    final /* synthetic */ zzida zzF() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    final byte zza(int i) {
        int i2 = this.zzf;
        return i < i2 ? this.zzd.zza(i) : this.zze.zza(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzc(int i, int i2) {
        return zzd(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzida zzd(int i, int i2) {
        int i3 = this.zzc;
        int iZzD = zzD(i, i2, i3);
        if (iZzD == 0) {
            return zzida.zza;
        }
        if (iZzD == i3) {
            return this;
        }
        int i4 = this.zzf;
        if (i2 <= i4) {
            return this.zzd.zzc(i, i2);
        }
        int i5 = i2 - i4;
        if (i >= i4) {
            return this.zze.zzc(i - i4, i5);
        }
        zzida zzidaVar = this.zzd;
        return new zzigg(zzidaVar.zzc(i, zzidaVar.zzb()), this.zze.zzc(0, i5));
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            this.zzd.zze(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zze.zze(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzd.zze(bArr, i, i2, i6);
            this.zze.zze(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final ByteBuffer zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    final void zzg(zzicr zzicrVar) throws IOException {
        this.zzd.zzg(zzicrVar);
        this.zze.zzg(zzicrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final String zzh(Charset charset) {
        return new String(zzA(), charset);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final boolean zzi() {
        zzigf zzigfVar = new zzigf(this, null);
        while (zzigfVar.hasNext()) {
            if (!zzigfVar.next().zzi()) {
                return zzihf.zza(zzA());
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final boolean zzj(zzida zzidaVar) {
        zzicx zzicxVarZza;
        byte[] bArr = null;
        zzigf zzigfVar = new zzigf(this, bArr);
        zzicx zzicxVarZza2 = zzigfVar.next();
        zzigf zzigfVar2 = new zzigf(zzidaVar, bArr);
        zzicx zzicxVarZza3 = zzigfVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int iZzb = zzicxVarZza2.zzb() - i;
            int iZzb2 = zzicxVarZza3.zzb() - i2;
            int iMin = Math.min(iZzb, iZzb2);
            if (!(i == 0 ? zzicxVarZza2.zzk(zzicxVarZza3, i2, iMin) : zzicxVarZza3.zzk(zzicxVarZza2, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.zzc;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iZzb) {
                zzicxVarZza = zzigfVar.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == iZzb2) {
                zzicxVarZza2 = zzicxVarZza2;
                zzicxVarZza2 = zzicxVarZza;
                zzicxVarZza3 = zzigfVar2.next();
                i2 = 0;
            } else {
                zzicxVarZza2 = zzicxVarZza2;
                zzicxVarZza2 = zzicxVarZza;
                i2 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final int zzl(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzf;
        if (i4 <= i5) {
            return this.zzd.zzl(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zze.zzl(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zze.zzl(this.zzd.zzl(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    public final zzide zzm() {
        ArrayList arrayList = new ArrayList();
        zzigf zzigfVar = new zzigf(this, null);
        while (zzigfVar.hasNext()) {
            arrayList.add(zzigfVar.next().zzf());
        }
        int i = zzide.zze;
        return zzide.zzH(new zzieu(arrayList), 4096);
    }

    final /* synthetic */ zzida zzo() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final int zzp() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzida
    protected final boolean zzq() {
        return this.zzc >= zzn(this.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzida
    /* JADX INFO: renamed from: zzr */
    public final zzicv iterator() {
        return new zzigd(this);
    }
}
