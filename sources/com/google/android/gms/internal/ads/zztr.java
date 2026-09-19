package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import com.brentvatne.exoplayer.ReactExoplayerView;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zztr implements zzse {
    private static final AtomicInteger zza = new AtomicInteger();
    private long zzA;
    private long zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private long zzF;
    private float zzG;
    private ByteBuffer zzH;
    private int zzI;
    private ByteBuffer zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private int zzO;
    private boolean zzP;
    private zze zzQ;
    private AudioDeviceInfo zzR;
    private int zzS;
    private long zzT;
    private boolean zzU;
    private boolean zzV;
    private long zzW;
    private long zzX;
    private Handler zzY;
    private final zztm zzZ;
    private final Context zzb;
    private final zztg zzc;
    private final zzud zzd;
    private final zzcv zze;
    private final zzuc zzf;
    private final zzgwm zzg;
    private final ArrayDeque zzh;
    private zzti zzi;
    private final zztq zzj;
    private final zztq zzk;
    private zzqf zzl;
    private zzsb zzm;
    private zztl zzn;
    private zztl zzo;
    private zzck zzp;
    private final zzrf zzq;
    private zzrc zzr;
    private zzqv zzs;
    private zzd zzt;
    private zztp zzu;
    private zztp zzv;
    private zzav zzw;
    private boolean zzx;
    private long zzy;
    private long zzz;

    static /* synthetic */ boolean zzH() {
        return zza.get() > 0;
    }

    private final void zzR() {
        zzck zzckVarZzk = this.zzo.zzk();
        this.zzp = zzckVarZzk;
        zzckVarZzk.zzb(zzcm.zza);
    }

    private final zzqv zzS(zzre zzreVar) throws zzsa {
        try {
            return ((zztd) this.zzq).zzf(zzreVar);
        } catch (zzrb e) {
            zzsa zzsaVar = new zzsa(0, zzreVar.zzb, zzreVar.zzc, zzreVar.zza, zzreVar.zze, this.zzo.zzf(), false, e);
            zzsb zzsbVar = this.zzm;
            if (zzsbVar == null) {
                throw zzsaVar;
            }
            zzsbVar.zza(zzsaVar);
            throw zzsaVar;
        }
    }

    private final void zzT(long j) throws Exception {
        zzW(j);
        if (this.zzJ != null) {
            return;
        }
        if (!this.zzp.zzc()) {
            ByteBuffer byteBuffer = this.zzH;
            if (byteBuffer != null) {
                zzV(byteBuffer);
                zzW(j);
                return;
            }
            return;
        }
        while (!this.zzp.zzg()) {
            do {
                ByteBuffer byteBufferZze = this.zzp.zze();
                if (byteBufferZze.hasRemaining()) {
                    zzV(byteBufferZze);
                    zzW(j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzH;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzp.zzd(this.zzH);
                    }
                }
            } while (this.zzJ == null);
            return;
        }
    }

    private final boolean zzU() throws Exception {
        if (!this.zzp.zzc()) {
            zzW(Long.MIN_VALUE);
            return this.zzJ == null;
        }
        this.zzp.zzf();
        zzT(Long.MIN_VALUE);
        if (!this.zzp.zzg()) {
            return false;
        }
        ByteBuffer byteBuffer = this.zzJ;
        return byteBuffer == null || !byteBuffer.hasRemaining();
    }

    /* JADX WARN: Code duplicated, block: B:52:0x0177 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0179 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x017b  */
    /* JADX WARN: Code duplicated, block: B:56:0x017f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0183  */
    /* JADX WARN: Code duplicated, block: B:60:0x0187  */
    /* JADX WARN: Code duplicated, block: B:62:0x018b  */
    /* JADX WARN: Code duplicated, block: B:64:0x018f  */
    /* JADX WARN: Code duplicated, block: B:66:0x0193 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x0195  */
    /* JADX WARN: Code duplicated, block: B:68:0x019e  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:72:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:74:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:75:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:76:0x020e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x0210  */
    /* JADX WARN: Code duplicated, block: B:78:0x0218  */
    /* JADX WARN: Code duplicated, block: B:79:0x021f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0226  */
    /* JADX WARN: Code duplicated, block: B:85:0x024c  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:92:0x023a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:94:0x0059 A[SYNTHETIC] */
    private final void zzV(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        zzgtj.zzi(this.zzJ == null);
        if (byteBuffer.hasRemaining()) {
            if (this.zzo.zze()) {
                int iZzu = (int) zzfl.zzu(zzfl.zzs(20L), this.zzo.zzj().zzb);
                long jZzae = zzae();
                long j = iZzu;
                if (jZzae < j) {
                    int i10 = this.zzo.zzj().zza;
                    int iZzi = this.zzo.zzi();
                    ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(byteBuffer.remaining()).order(ByteOrder.nativeOrder());
                    int iPosition = byteBuffer.position();
                    int i11 = (int) jZzae;
                    while (byteBuffer.hasRemaining() && i11 < iZzu) {
                        if (i10 != 2) {
                            if (i10 == 3) {
                                i3 = (byteBuffer.get() & 255) << 24;
                            } else if (i10 != 4) {
                                if (i10 != 21) {
                                    if (i10 == 22) {
                                        int i12 = byteBuffer.get() & 255;
                                        int i13 = (byteBuffer.get() & 255) << 8;
                                        int i14 = (byteBuffer.get() & 255) << 16;
                                        i8 = (byteBuffer.get() & 255) << 24;
                                        i9 = i12 | i13 | i14;
                                    } else if (i10 == 268435456) {
                                        i = (byteBuffer.get() & 255) << 24;
                                        i2 = (byteBuffer.get() & 255) << 16;
                                    } else if (i10 == 1342177280) {
                                        i5 = (byteBuffer.get() & 255) << 24;
                                        i6 = (byteBuffer.get() & 255) << 16;
                                        i7 = (byteBuffer.get() & 255) << 8;
                                    } else if (i10 == 1610612736) {
                                        int i15 = (byteBuffer.get() & 255) << 24;
                                        int i16 = (byteBuffer.get() & 255) << 16;
                                        int i17 = (byteBuffer.get() & 255) << 8;
                                        i8 = byteBuffer.get() & 255;
                                        i9 = i17 | i15 | i16;
                                    } else {
                                        if (i10 != 1879048192) {
                                            throw new IllegalStateException();
                                        }
                                        double dZzm = zzfl.zzm(byteBuffer.getDouble(), -1.0d, 1.0d);
                                        i3 = (int) (dZzm < ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE ? (-dZzm) * (-2.147483648E9d) : dZzm * 2.147483647E9d);
                                    }
                                    i3 = i9 | i8;
                                } else {
                                    i5 = (byteBuffer.get() & 255) << 8;
                                    i6 = (byteBuffer.get() & 255) << 16;
                                    i7 = (byteBuffer.get() & 255) << 24;
                                }
                                i3 = i5 | i6 | i7;
                            } else {
                                float fMax = Math.max(-1.0f, Math.min(byteBuffer.getFloat(), 1.0f));
                                i3 = (int) (fMax < 0.0f ? (-fMax) * (-2.1474836E9f) : fMax * 2.1474836E9f);
                            }
                            i4 = (int) ((((long) i3) * ((long) i11)) / j);
                            if (i10 != 2) {
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i10 != 3) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i10 != 4) {
                                if (i10 != 21) {
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i10 != 22) {
                                    byteBufferOrder.put((byte) i4);
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                } else if (i10 != 268435456) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                } else if (i10 != 1342177280) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                } else if (i10 != 1610612736) {
                                    byteBufferOrder.put((byte) (i4 >> 24));
                                    byteBufferOrder.put((byte) (i4 >> 16));
                                    byteBufferOrder.put((byte) (i4 >> 8));
                                    byteBufferOrder.put((byte) i4);
                                } else {
                                    if (i10 == 1879048192) {
                                        throw new IllegalStateException();
                                    }
                                    if (i4 < 0) {
                                        byteBufferOrder.putDouble((-i4) / (-2.147483648E9d));
                                    } else {
                                        byteBufferOrder.putDouble(((double) i4) / 2.147483647E9d);
                                    }
                                }
                            } else if (i4 < 0) {
                                byteBufferOrder.putFloat((-i4) / (-2.1474836E9f));
                            } else {
                                byteBufferOrder.putFloat(i4 / 2.1474836E9f);
                            }
                            if (byteBuffer.position() == iPosition + iZzi) {
                                i11++;
                                iPosition = byteBuffer.position();
                            }
                        } else {
                            i = (byteBuffer.get() & 255) << 16;
                            i2 = (byteBuffer.get() & 255) << 24;
                        }
                        i3 = i2 | i;
                        i4 = (int) ((((long) i3) * ((long) i11)) / j);
                        if (i10 != 2) {
                            byteBufferOrder.put((byte) (i4 >> 16));
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i10 != 3) {
                            byteBufferOrder.put((byte) (i4 >> 24));
                        } else if (i10 != 4) {
                            if (i10 != 21) {
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i10 != 22) {
                                byteBufferOrder.put((byte) i4);
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 24));
                            } else if (i10 != 268435456) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                            } else if (i10 != 1342177280) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                            } else if (i10 != 1610612736) {
                                byteBufferOrder.put((byte) (i4 >> 24));
                                byteBufferOrder.put((byte) (i4 >> 16));
                                byteBufferOrder.put((byte) (i4 >> 8));
                                byteBufferOrder.put((byte) i4);
                            } else {
                                if (i10 == 1879048192) {
                                    throw new IllegalStateException();
                                }
                                if (i4 < 0) {
                                    byteBufferOrder.putDouble((-i4) / (-2.147483648E9d));
                                } else {
                                    byteBufferOrder.putDouble(((double) i4) / 2.147483647E9d);
                                }
                            }
                        } else if (i4 < 0) {
                            byteBufferOrder.putFloat((-i4) / (-2.1474836E9f));
                        } else {
                            byteBufferOrder.putFloat(i4 / 2.1474836E9f);
                        }
                        if (byteBuffer.position() == iPosition + iZzi) {
                            i11++;
                            iPosition = byteBuffer.position();
                        }
                    }
                    byteBufferOrder.put(byteBuffer);
                    byteBufferOrder.flip();
                    byteBuffer2 = byteBufferOrder;
                } else {
                    byteBuffer2 = byteBuffer;
                }
            } else {
                byteBuffer2 = byteBuffer;
            }
            this.zzJ = byteBuffer2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009d  */
    private final void zzW(long j) throws Exception {
        zzsb zzsbVar;
        if (this.zzJ == null || this.zzk.zzb()) {
            return;
        }
        int iRemaining = this.zzJ.remaining();
        boolean z = true;
        try {
            boolean zZzc = this.zzs.zzc(this.zzJ, this.zzI, j);
            this.zzT = SystemClock.elapsedRealtime();
            this.zzk.zzc();
            if (this.zzs.zzg()) {
                if (this.zzB > 0) {
                    this.zzV = false;
                }
                if (this.zzN && (zzsbVar = this.zzm) != null && !zZzc) {
                }
            }
            if (this.zzo.zze()) {
                this.zzA += (long) (iRemaining - this.zzJ.remaining());
            }
            if (zZzc) {
                if (!this.zzo.zze()) {
                    zzgtj.zzi(this.zzJ == this.zzH);
                    this.zzB += ((long) this.zzC) * ((long) this.zzI);
                }
                this.zzJ = null;
            }
        } catch (zzqu e) {
            boolean z2 = e.zzb;
            if (!z2) {
                z = false;
            } else if (zzae() <= 0) {
                if (this.zzs.zzg()) {
                    zzX();
                } else {
                    z = false;
                }
            }
            zzsd zzsdVar = new zzsd(e.zza, this.zzo.zzf(), z);
            zzsb zzsbVar2 = this.zzm;
            if (zzsbVar2 != null) {
                zzsbVar2.zza(zzsdVar);
            }
            if (z2) {
                throw zzsdVar;
            }
            this.zzk.zza(zzsdVar);
        }
    }

    private final void zzX() {
        this.zzo.zzj();
    }

    private final void zzY() {
        if (zzad()) {
            this.zzs.zzf(this.zzG);
        }
    }

    private final void zzZ() {
        if (this.zzo != null) {
            zztl zztlVar = this.zzn;
            if (zztlVar != null) {
                this.zzo = zztlVar;
                this.zzn = null;
            }
            try {
                this.zzo = new zztl(this.zzo.zzf(), this.zzo.zzg(), this.zzo.zzh(), this.zzo.zzi(), this.zzq.zzb(zzaf(this.zzo.zzg(), -1)), this.zzo.zzk(), null);
            } catch (zzqw e) {
                throw new IllegalStateException(new zzrz(e, this.zzo.zzf()));
            }
        }
        zzB();
    }

    private final void zzaa(zzav zzavVar) {
        zztp zztpVar = new zztp(zzavVar, C.TIME_UNSET, C.TIME_UNSET, null);
        if (zzad()) {
            this.zzu = zztpVar;
        } else {
            this.zzv = zztpVar;
        }
    }

    private final void zzab(long j) {
        zzav zzavVar;
        boolean z;
        if (zzac()) {
            zztm zztmVar = this.zzZ;
            zzavVar = this.zzw;
            zztmVar.zzb(zzavVar);
        } else {
            zzavVar = zzav.zza;
        }
        zzav zzavVar2 = zzavVar;
        this.zzw = zzavVar2;
        if (zzac()) {
            zztm zztmVar2 = this.zzZ;
            z = this.zzx;
            zztmVar2.zzc(z);
        } else {
            z = false;
        }
        this.zzx = z;
        this.zzh.add(new zztp(zzavVar2, Math.max(0L, j), this.zzo.zzc(zzae()), null));
        zzR();
        zzsb zzsbVar = this.zzm;
        if (zzsbVar != null) {
            ((zztw) zzsbVar).zza.zzaz().zzh(this.zzx);
        }
    }

    private final boolean zzac() {
        if (!this.zzo.zze()) {
            return false;
        }
        int i = this.zzo.zzf().zzJ;
        return true;
    }

    private final boolean zzad() {
        return this.zzs != null;
    }

    private final long zzae() {
        if (!this.zzo.zze()) {
            return this.zzB;
        }
        long j = this.zzA;
        long jZzi = this.zzo.zzi();
        String str = zzfl.zza;
        return ((j + jZzi) - 1) / jZzi;
    }

    private final zzqy zzaf(zzv zzvVar, int i) {
        zzqx zzqxVar = new zzqx(zzvVar);
        zzqxVar.zza(this.zzt);
        zzqxVar.zzb(this.zzR);
        zzqxVar.zzc(this.zzO);
        zzqxVar.zze(-1);
        zzqxVar.zzd(this.zzS);
        return new zzqy(zzqxVar, null);
    }

    private final void zzag() {
        if (this.zzL) {
            return;
        }
        this.zzL = true;
        if (this.zzs.zzg()) {
            this.zzM = false;
        }
        this.zzs.zzd();
    }

    private static int zzah(int i) {
        if (i == 0 || i == -1) {
            return -1;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzA() {
        this.zzN = false;
        if (zzad()) {
            this.zzs.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzB() {
        if (zzad()) {
            this.zzy = 0L;
            this.zzz = 0L;
            this.zzA = 0L;
            this.zzB = 0L;
            this.zzV = false;
            this.zzC = 0;
            this.zzv = new zztp(this.zzw, 0L, 0L, null);
            this.zzF = 0L;
            this.zzu = null;
            this.zzh.clear();
            this.zzH = null;
            this.zzI = 0;
            this.zzJ = null;
            this.zzL = false;
            this.zzK = false;
            this.zzM = false;
            this.zzd.zzr();
            zzR();
            this.zzi = null;
            zztl zztlVar = this.zzn;
            if (zztlVar != null) {
                this.zzo = zztlVar;
                this.zzn = null;
            }
            zza.incrementAndGet();
            this.zzs.zze();
            this.zzs = null;
        }
        this.zzk.zzc();
        this.zzj.zzc();
        this.zzW = 0L;
        this.zzX = 0L;
        Handler handler = this.zzY;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzC() {
        zzB();
        zzgwm zzgwmVar = this.zzg;
        int size = zzgwmVar.size();
        for (int i = 0; i < size; i++) {
            ((zzco) zzgwmVar.get(i)).zzj();
        }
        this.zze.zzj();
        this.zzf.zzj();
        zzck zzckVar = this.zzp;
        if (zzckVar != null) {
            zzckVar.zzh();
        }
        this.zzN = false;
        this.zzU = false;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzD() {
        this.zzq.zze();
    }

    final /* synthetic */ void zzF() {
        if (this.zzX >= 300000) {
            ((zztw) this.zzm).zza.zzaB(true);
            this.zzX = 0L;
        }
    }

    final /* synthetic */ void zzG() {
        zzsb zzsbVar = this.zzm;
        if (zzsbVar != null) {
            ((zztw) zzsbVar).zza.zzT();
        }
    }

    final /* synthetic */ zzti zzJ() {
        return this.zzi;
    }

    final /* synthetic */ zzsb zzK() {
        return this.zzm;
    }

    final /* synthetic */ zztl zzL() {
        return this.zzo;
    }

    final /* synthetic */ zzqv zzM() {
        return this.zzs;
    }

    final /* synthetic */ boolean zzN() {
        return this.zzL;
    }

    final /* synthetic */ void zzO(boolean z) {
        this.zzM = true;
    }

    final /* synthetic */ boolean zzP() {
        return this.zzN;
    }

    final /* synthetic */ long zzQ() {
        return this.zzT;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zza(zzsb zzsbVar) {
        this.zzm = zzsbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzb(zzqf zzqfVar) {
        this.zzl = zzqfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzc(zzdo zzdoVar) {
        this.zzq.zzd(zzdoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzd(zzv zzvVar) {
        return zze(zzvVar) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final int zze(zzv zzvVar) {
        boolean z;
        int i = zzvVar.zzJ;
        if (!zzfl.zzD(i) || i == 2) {
            z = false;
        } else {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzI(2);
            zzvVar = zztVarZza.zzO();
            z = true;
        }
        int i2 = this.zzq.zza(zzaf(zzvVar, -1)).zzd;
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 2) {
            return 0;
        }
        return z ? 1 : 2;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final zzqs zzf(zzv zzvVar) {
        if (this.zzU) {
            return zzqs.zza;
        }
        zzra zzraVarZza = this.zzq.zza(zzaf(zzvVar, -1));
        zzqr zzqrVar = new zzqr();
        zzqrVar.zza(zzraVarZza.zza);
        zzqrVar.zzb(zzraVarZza.zzb);
        zzqrVar.zzc(zzraVarZza.zzc);
        return zzqrVar.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final long zzg(boolean z) {
        ArrayDeque arrayDeque;
        long j;
        if (!zzad() || this.zzE) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzs.zzk(), this.zzo.zzc(zzae()));
        while (true) {
            arrayDeque = this.zzh;
            if (arrayDeque.isEmpty() || jMin < ((zztp) arrayDeque.getFirst()).zzc) {
                break;
            }
            this.zzv = (zztp) arrayDeque.remove();
        }
        zztp zztpVar = this.zzv;
        long j2 = jMin - zztpVar.zzc;
        long jZzx = zzfl.zzx(j2, zztpVar.zza.zzb);
        if (arrayDeque.isEmpty()) {
            long jZzd = this.zzZ.zzd(j2);
            zztp zztpVar2 = this.zzv;
            j = zztpVar2.zzb + jZzd;
            zztpVar2.zzd = jZzd - jZzx;
        } else {
            zztp zztpVar3 = this.zzv;
            j = zztpVar3.zzb + jZzx + zztpVar3.zzd;
        }
        long jZze = this.zzZ.zze();
        long jZzc = j + this.zzo.zzc(jZze);
        long j3 = this.zzW;
        if (jZze > j3) {
            long jZzc2 = this.zzo.zzc(jZze - j3);
            this.zzW = jZze;
            this.zzX += jZzc2;
            if (this.zzY == null) {
                this.zzY = new Handler(Looper.myLooper());
            }
            this.zzY.removeCallbacksAndMessages(null);
            this.zzY.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzto
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzF();
                }
            }, 100L);
        }
        return jZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzh(zzrx zzrxVar) throws zzrz {
        int i;
        zzv zzvVarZzO;
        zzck zzckVar;
        int iZzG;
        if (this.zzr == null && this.zzb != null) {
            zzrc zzrcVar = new zzrc() { // from class: com.google.android.gms.internal.ads.zztn
                @Override // com.google.android.gms.internal.ads.zzrc
                public final /* synthetic */ void zza() {
                    this.zza.zzG();
                }
            };
            this.zzr = zzrcVar;
            this.zzq.zzc(zzrcVar);
        }
        zzv zzvVar = zzrxVar.zza;
        if (MimeTypes.AUDIO_RAW.equals(zzvVar.zzp)) {
            int i2 = zzvVar.zzJ;
            zzgtj.zza(zzfl.zzD(i2));
            int i3 = zzvVar.zzH;
            int iZzG2 = zzfl.zzG(i2) * i3;
            zzgwj zzgwjVar = new zzgwj();
            zzgwjVar.zzh(this.zzg);
            zzgwjVar.zzf(this.zze);
            zzgwjVar.zzg(this.zzZ.zza());
            zzck zzckVar2 = new zzck(zzgwjVar.zzi());
            if (zzckVar2.equals(this.zzp)) {
                zzckVar2 = this.zzp;
            }
            this.zzd.zzq(zzvVar.zzK, zzvVar.zzL);
            this.zzc.zzq(zzrxVar.zzc);
            try {
                zzcl zzclVarZza = zzckVar2.zza(new zzcl(zzvVar.zzI, i3, i2));
                zzt zztVarZza = zzvVar.zza();
                int i4 = zzclVarZza.zzd;
                zztVarZza.zzI(i4);
                zztVarZza.zzH(zzclVarZza.zzb);
                int i5 = zzclVarZza.zzc;
                zztVarZza.zzG(i5);
                i = iZzG2;
                zzckVar = zzckVar2;
                zzvVarZzO = zztVarZza.zzO();
                iZzG = zzfl.zzG(i4) * i5;
            } catch (zzcn e) {
                throw new zzrz(e, zzvVar);
            }
        } else {
            i = -1;
            zzvVarZzO = zzvVar;
            zzckVar = new zzck(zzgwm.zzi());
            iZzG = -1;
        }
        zzqy zzqyVarZzaf = zzaf(zzvVarZzO, -1);
        try {
            zzre zzreVarZzb = this.zzq.zzb(zzqyVarZzaf);
            if (zzreVarZzb.zza == 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(false).length() + 36);
                sb.append("Invalid output encoding (isOffload=false)");
                throw new zzrz(sb.toString(), zzqyVarZzaf.zza);
            }
            if (zzreVarZzb.zzc == 0) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(false).length() + 42);
                sb2.append("Invalid output channel config (isOffload=false)");
                throw new zzrz(sb2.toString(), zzqyVarZzaf.zza);
            }
            this.zzU = false;
            zztl zztlVar = new zztl(zzvVar, zzvVarZzO, i, iZzG, zzreVarZzb, zzckVar, null);
            if (zzad()) {
                this.zzn = zztlVar;
            } else {
                this.zzo = zztlVar;
            }
        } catch (zzqw e2) {
            throw new zzrz(e2, zzvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzi() {
        this.zzN = true;
        if (zzad()) {
            this.zzs.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzj() {
        this.zzD = true;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzk(ByteBuffer byteBuffer, long j, int i) throws Exception {
        zzqv zzqvVarZzS;
        zzqv zzqvVar;
        ByteBuffer byteBuffer2 = this.zzH;
        zzgtj.zza(byteBuffer2 == null || byteBuffer == byteBuffer2);
        byte[] bArr = null;
        if (this.zzn != null) {
            if (!zzU()) {
                return false;
            }
            if (this.zzs != null) {
                zzre zzreVarZzj = this.zzo.zzj();
                zzaf(this.zzn.zzg(), -1);
                if (this.zzn.zzj().equals(zzreVarZzj)) {
                    this.zzo = this.zzn;
                    this.zzn = null;
                    zzqvVar = this.zzs;
                    if (zzqvVar != null && zzqvVar.zzg()) {
                        this.zzo.zzj();
                    }
                } else {
                    zzag();
                    if (zzn()) {
                        return false;
                    }
                    zzB();
                }
            } else {
                this.zzo = this.zzn;
                this.zzn = null;
                zzqvVar = this.zzs;
                if (zzqvVar != null) {
                    this.zzo.zzj();
                }
            }
            zzab(j);
        }
        if (!zzad()) {
            try {
                if (this.zzj.zzb()) {
                    return false;
                }
                try {
                    zzqvVarZzS = zzS(this.zzo.zzj());
                } catch (zzsa e) {
                    int i2 = this.zzo.zzj().zze;
                    while (true) {
                        if (i2 <= 1000000) {
                            zzX();
                            throw e;
                        }
                        int i3 = i2 >> 1;
                        int iZzi = this.zzo.zzi() != -1 ? this.zzo.zzi() : 1;
                        int i4 = i3 % iZzi;
                        if (i4 != 0) {
                            i3 += iZzi - i4;
                        }
                        int i5 = i3;
                        zzrd zzrdVar = new zzrd(this.zzo.zzj(), null);
                        zzrdVar.zze(i5);
                        zzre zzreVar = new zzre(zzrdVar, null);
                        try {
                            zzqv zzqvVarZzS2 = zzS(zzreVar);
                            this.zzo = this.zzo.zza(zzreVar);
                            zzqvVarZzS = zzqvVarZzS2;
                            break;
                        } catch (zzsa e2) {
                            e.addSuppressed(e2);
                            i2 = i5;
                        }
                    }
                }
                this.zzs = zzqvVarZzS;
                zzti zztiVar = new zzti(this, this.zzo.zzj(), bArr);
                this.zzi = zztiVar;
                this.zzs.zzm(zztiVar);
                if (this.zzs.zzg()) {
                    this.zzo.zzj();
                }
                zzqf zzqfVar = this.zzl;
                if (zzqfVar != null) {
                    this.zzs.zzn(zzqfVar);
                }
                zzY();
                int i6 = this.zzQ.zza;
                AudioDeviceInfo audioDeviceInfo = this.zzR;
                if (audioDeviceInfo != null) {
                    this.zzs.zzo(audioDeviceInfo);
                }
                this.zzE = true;
                int iZzh = this.zzs.zzh();
                int i7 = this.zzO;
                this.zzO = iZzh;
                zzsb zzsbVar = this.zzm;
                if (zzsbVar != null) {
                    ((zztw) zzsbVar).zza.zzaz().zzk(this.zzo.zzd());
                    if (iZzh != i7) {
                        this.zzP = true;
                        zztl zztlVar = this.zzo;
                        zzrd zzrdVar2 = new zzrd(zztlVar.zzj(), null);
                        zzrdVar2.zzg(this.zzO);
                        this.zzo = zztlVar.zza(new zzre(zzrdVar2, null));
                        zztl zztlVar2 = this.zzn;
                        if (zztlVar2 != null) {
                            zzrd zzrdVar3 = new zzrd(zztlVar2.zzj(), null);
                            zzrdVar3.zzg(this.zzO);
                            this.zzn = zztlVar2.zza(new zzre(zzrdVar3, null));
                        }
                        zzsb zzsbVar2 = this.zzm;
                        int i8 = this.zzO;
                        if (Build.VERSION.SDK_INT >= 35) {
                            zztx zztxVar = ((zztw) zzsbVar2).zza;
                            if (zztxVar.zzaA() != null) {
                                zztxVar.zzaA().zza(i8);
                            }
                        }
                        ((zztw) zzsbVar2).zza.zzaz().zzm(i8);
                    }
                }
            } catch (zzsa e3) {
                this.zzj.zza(e3);
                return false;
            }
        }
        this.zzj.zzc();
        if (this.zzE) {
            this.zzF = Math.max(0L, j);
            this.zzD = false;
            this.zzE = false;
            zzab(j);
            if (this.zzN) {
                zzi();
            }
        }
        if (this.zzH == null) {
            zzgtj.zza(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.zzo.zze() && this.zzC == 0) {
                int iZzE = zzE(this.zzo.zzj().zza, byteBuffer);
                this.zzC = iZzE;
                if (iZzE == 0) {
                    return true;
                }
            }
            if (this.zzu != null) {
                if (!zzU()) {
                    return false;
                }
                zzab(j);
                this.zzu = null;
            }
            long j2 = this.zzF;
            zztl zztlVar3 = this.zzo;
            long jZzb = j2 + zztlVar3.zzb((zztlVar3.zze() ? this.zzy / ((long) this.zzo.zzh()) : this.zzz) - this.zzd.zzs());
            if (!this.zzD && Math.abs(jZzb - j) > 200000) {
                zzsb zzsbVar3 = this.zzm;
                if (zzsbVar3 != null) {
                    zzsbVar3.zza(new zzsc(j, jZzb));
                }
                this.zzD = true;
            }
            if (this.zzD) {
                if (!zzU()) {
                    return false;
                }
                long j3 = j - jZzb;
                this.zzF += j3;
                this.zzD = false;
                zzab(j);
                zzsb zzsbVar4 = this.zzm;
                if (zzsbVar4 != null && j3 != 0) {
                    ((zztw) zzsbVar4).zza.zzaq();
                }
            }
            if (this.zzo.zze()) {
                this.zzy += (long) byteBuffer.remaining();
            } else {
                this.zzz += ((long) this.zzC) * ((long) i);
            }
            this.zzH = byteBuffer;
            this.zzI = i;
        }
        zzT(j);
        if (!this.zzH.hasRemaining()) {
            this.zzH = null;
            this.zzI = 0;
            return true;
        }
        if (!this.zzs.zzl()) {
            return false;
        }
        zzeg.zzc("DefaultAudioSink", "Resetting stalled audio output");
        zzB();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzl() throws zzsd {
        if (!this.zzK && zzad() && zzU()) {
            zzag();
            this.zzK = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzm() {
        if (zzad()) {
            return this.zzK && !zzn();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final boolean zzn() {
        if (!zzad()) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29 && this.zzs.zzg() && this.zzM) {
            return false;
        }
        long jZzae = zzae();
        long jZzk = this.zzs.zzk();
        zzqv zzqvVar = this.zzs;
        zzqvVar.getClass();
        return jZzae > zzfl.zzu(jZzk, zzqvVar.zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzo(zzav zzavVar) {
        float f = zzavVar.zzb;
        String str = zzfl.zza;
        zzav zzavVar2 = new zzav(Math.max(0.1f, Math.min(f, 8.0f)), Math.max(0.1f, Math.min(zzavVar.zzc, 8.0f)));
        this.zzw = zzavVar2;
        zzaa(zzavVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final zzav zzp() {
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzq(boolean z) {
        this.zzx = z;
        zzaa(this.zzw);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzr(zzd zzdVar) {
        if (this.zzt.equals(zzdVar)) {
            return;
        }
        this.zzt = zzdVar;
        zzZ();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final zzqh zzs() {
        zzrf zzrfVar = this.zzq;
        if (zzrfVar instanceof zztd) {
            return ((zztd) zzrfVar).zzg();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzt(int i) {
        if (this.zzP) {
            if (this.zzO != i) {
                return;
            } else {
                this.zzP = false;
            }
        }
        if (this.zzO != i) {
            this.zzO = i;
            zzZ();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzu(zze zzeVar) {
        if (this.zzQ.equals(zzeVar)) {
            return;
        }
        if (this.zzs != null) {
            int i = this.zzQ.zza;
        }
        this.zzQ = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzv(AudioDeviceInfo audioDeviceInfo) {
        this.zzR = audioDeviceInfo;
        zzqv zzqvVar = this.zzs;
        if (zzqvVar != null) {
            zzqvVar.zzo(audioDeviceInfo);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzw(int i) {
        int i2 = this.zzS;
        int iZzah = zzah(i);
        if (i2 == iZzah) {
            return;
        }
        this.zzS = iZzah;
        zzZ();
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final long zzx() {
        if (!zzad()) {
            return C.TIME_UNSET;
        }
        if (this.zzo.zze()) {
            return this.zzo.zzc(this.zzs.zzj());
        }
        long jZzj = this.zzs.zzj();
        int iZzf = zzagc.zzf(this.zzo.zzj().zza);
        zzgtj.zzi(iZzf != -2147483647);
        return zzfl.zzv(jZzj, 1000000L, iZzf, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzy(int i, int i2) {
        zzqv zzqvVar = this.zzs;
        if (zzqvVar != null) {
            zzqvVar.zzg();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzse
    public final void zzz(float f) {
        if (this.zzG != f) {
            this.zzG = f;
            zzY();
        }
    }

    /* synthetic */ zztr(zztk zztkVar, byte[] bArr) {
        this.zzb = zztkVar.zzb() == null ? null : zztkVar.zzb().getApplicationContext();
        this.zzt = zzd.zza;
        this.zzZ = zztkVar.zzd();
        this.zzq = zztkVar.zzc();
        zztg zztgVar = new zztg();
        this.zzc = zztgVar;
        zzud zzudVar = new zzud();
        this.zzd = zzudVar;
        this.zze = new zzcv();
        this.zzf = new zzuc();
        this.zzg = zzgwm.zzk(zzudVar, zztgVar);
        this.zzG = 1.0f;
        this.zzO = 0;
        this.zzQ = new zze(0, 0.0f);
        zzav zzavVar = zzav.zza;
        this.zzv = new zztp(zzavVar, 0L, 0L, null);
        this.zzw = zzavVar;
        this.zzx = false;
        this.zzh = new ArrayDeque();
        this.zzj = new zztq();
        this.zzk = new zztq();
        int iZzah = -1;
        if (Build.VERSION.SDK_INT >= 34 && zztkVar.zzb() != null) {
            iZzah = zzah(zztkVar.zzb().getDeviceId());
        }
        this.zzS = iZzah;
    }

    static int zzE(int i, ByteBuffer byteBuffer) {
        int i2;
        int i3;
        byte b;
        int i4;
        int i5;
        if (i == 20) {
            return zzgv.zzb(byteBuffer);
        }
        if (i != 30) {
            switch (i) {
                case 5:
                case 6:
                    break;
                case 7:
                case 8:
                    break;
                case 9:
                    int iZzb = zzagw.zzb(zzfl.zzM(byteBuffer, byteBuffer.position()));
                    if (iZzb != -1) {
                        return iZzb;
                    }
                    throw new IllegalArgumentException();
                case 10:
                    return 1024;
                case 11:
                case 12:
                    return 2048;
                default:
                    switch (i) {
                        case 14:
                            int i6 = zzaey.zza;
                            int iPosition = byteBuffer.position();
                            int iLimit = byteBuffer.limit() - 10;
                            int i7 = iPosition;
                            while (true) {
                                if (i7 > iLimit) {
                                    i5 = -1;
                                } else if ((zzfl.zzM(byteBuffer, i7 + 4) & (-2)) == -126718022) {
                                    i5 = i7 - iPosition;
                                } else {
                                    i7++;
                                }
                            }
                            if (i5 == -1) {
                                return 0;
                            }
                            return (40 << ((byteBuffer.get((byteBuffer.position() + i5) + ((byteBuffer.get((byteBuffer.position() + i5) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7)) * 16;
                        case 15:
                            return 512;
                        case 16:
                            return 1024;
                        case 17:
                            int i8 = zzafb.zza;
                            byte[] bArr = new byte[16];
                            int iPosition2 = byteBuffer.position();
                            byteBuffer.get(bArr);
                            byteBuffer.position(iPosition2);
                            return zzafb.zzb(new zzes(bArr, 16)).zzc;
                        case 18:
                            break;
                        default:
                            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 27);
                            sb.append("Unexpected audio encoding: ");
                            sb.append(i);
                            throw new IllegalStateException(sb.toString());
                    }
                    break;
            }
            return zzaey.zze(byteBuffer);
        }
        int i9 = zzafx.zza;
        if (byteBuffer.getInt(0) == -233094848 || byteBuffer.getInt(0) == -398277519) {
            return 1024;
        }
        if (byteBuffer.getInt(0) == 622876772) {
            return 4096;
        }
        int iPosition3 = byteBuffer.position();
        byte b2 = byteBuffer.get(iPosition3);
        if (b2 != -2) {
            if (b2 != -1) {
                if (b2 != 31) {
                    i3 = (byteBuffer.get(iPosition3 + 4) & 1) << 6;
                    i4 = byteBuffer.get(iPosition3 + 5) & 252;
                } else {
                    i3 = (byteBuffer.get(iPosition3 + 5) & 7) << 4;
                    b = byteBuffer.get(iPosition3 + 6);
                }
                i2 = (i4 >> 2) | i3;
            } else {
                i3 = (byteBuffer.get(iPosition3 + 4) & 7) << 4;
                b = byteBuffer.get(iPosition3 + 7);
            }
            i4 = b & 60;
            i2 = (i4 >> 2) | i3;
        } else {
            i2 = ((byteBuffer.get(iPosition3 + 5) & 1) << 6) | ((byteBuffer.get(iPosition3 + 4) & 252) >> 2);
        }
        return (i2 + 1) * 32;
    }
}
