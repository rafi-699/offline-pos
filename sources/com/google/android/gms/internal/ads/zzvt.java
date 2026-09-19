package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzvt extends zzix {
    private static final byte[] zzb = {0, 0, 1, 103, 66, -64, Ascii.VT, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, 49, -61, 39, 93, 120};
    private boolean zzA;
    private float zzB;
    private ArrayDeque zzC;
    private zzvp zzD;
    private zzvm zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private long zzL;
    private boolean zzM;
    private long zzN;
    private int zzO;
    private int zzP;
    private ByteBuffer zzQ;
    private boolean zzR;
    private boolean zzS;
    private boolean zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private int zzX;
    private int zzY;
    private int zzZ;
    protected zzjb zza;
    private boolean zzaa;
    private boolean zzab;
    private boolean zzac;
    private long zzad;
    private boolean zzae;
    private boolean zzaf;
    private boolean zzag;
    private zzvs zzah;
    private long zzai;
    private boolean zzaj;
    private boolean zzak;
    private boolean zzal;
    private long zzam;
    private zziz zzan;
    private zziz zzao;
    private zzgww zzap;
    private final Context zzc;
    private final zzvh zzd;
    private final zzvv zze;
    private final float zzf;
    private final zziv zzg;
    private final zziv zzh;
    private final zziv zzi;
    private final zzva zzj;
    private final MediaCodec.BufferInfo zzk;
    private final ArrayDeque zzl;
    private final zzty zzm;
    private final AtomicInteger zzn;
    private zzv zzo;
    private zzv zzp;
    private zzug zzq;
    private zzug zzr;
    private zzmz zzs;
    private MediaCrypto zzt;
    private long zzu;
    private float zzv;
    private float zzw;
    private zzvj zzx;
    private zzv zzy;
    private MediaFormat zzz;

    public zzvt(Context context, int i, zzvh zzvhVar, zzvv zzvvVar, boolean z, float f) {
        super(i);
        this.zzc = context.getApplicationContext();
        this.zzd = zzvhVar;
        zzvvVar.getClass();
        this.zze = zzvvVar;
        this.zzf = f;
        this.zzn = new AtomicInteger();
        this.zzg = new zziv(0, 0);
        this.zzh = new zziv(0, 0);
        this.zzi = new zziv(2, 0);
        zzva zzvaVar = new zzva();
        this.zzj = zzvaVar;
        this.zzk = new MediaCodec.BufferInfo();
        this.zzv = 1.0f;
        this.zzw = 1.0f;
        this.zzu = C.TIME_UNSET;
        this.zzl = new ArrayDeque();
        this.zzah = zzvs.zza;
        zzvaVar.zzj(0);
        zzvaVar.zzc.order(ByteOrder.nativeOrder());
        this.zzm = new zzty();
        this.zzB = -1.0f;
        this.zzF = 0;
        this.zzX = 0;
        this.zzO = -1;
        this.zzP = -1;
        this.zzN = C.TIME_UNSET;
        this.zzad = C.TIME_UNSET;
        this.zzai = C.TIME_UNSET;
        this.zzL = C.TIME_UNSET;
        this.zzY = 0;
        this.zzZ = 0;
        this.zza = new zzjb();
        this.zzal = false;
        this.zzam = 0L;
        this.zzap = zzgww.zzh();
        zziz zzizVar = zziz.zza;
        this.zzan = zzizVar;
        this.zzao = zzizVar;
    }

    private final boolean zzaA(int i) throws zzjk {
        zzlw zzlwVarZzI = zzI();
        zziv zzivVar = this.zzg;
        zzivVar.zza();
        int iZzQ = zzQ(zzlwVarZzI, zzivVar, i | 4);
        if (iZzQ == -5) {
            zzao(zzlwVarZzI);
            return true;
        }
        if (iZzQ != -4 || !zzivVar.zzb()) {
            return false;
        }
        this.zzae = true;
        zzbr();
        return false;
    }

    private final boolean zzaB(long j) {
        return this.zzu == C.TIME_UNSET || zzM().zzb() - j < this.zzu;
    }

    private final boolean zzaC() {
        return this.zzP >= 0;
    }

    private final void zzaq() {
        this.zzT = false;
        zzaw();
    }

    private final void zzaw() {
        zzaz();
        this.zzV = false;
        this.zzj.zza();
        this.zzi.zza();
        this.zzU = false;
        this.zzm.zzb();
    }

    private final boolean zzax() {
        if (this.zzx == null) {
            return false;
        }
        if (zzaO()) {
            zzaM();
            return true;
        }
        if (zzaP()) {
            zzay();
            return false;
        }
        this.zzal = true;
        return false;
    }

    private final void zzay() {
        try {
            zzvj zzvjVar = this.zzx;
            if (zzvjVar == null) {
                throw null;
            }
            zzvjVar.zzk();
            zzaR();
        } catch (Throwable th) {
            zzaR();
            throw th;
        }
    }

    private final void zzaz() {
        this.zzad = C.TIME_UNSET;
        zzbt().zzf = C.TIME_UNSET;
        this.zzai = C.TIME_UNSET;
    }

    protected static boolean zzbj(zzv zzvVar) {
        return zzvVar.zzO == 0;
    }

    private final void zzbm() {
        this.zzO = -1;
        this.zzh.zzc = null;
    }

    private final void zzbn() {
        this.zzP = -1;
        this.zzQ = null;
    }

    private final boolean zzbo(zzv zzvVar) throws zzjk {
        if (this.zzx != null && this.zzZ != 3 && zze() != 0) {
            float f = this.zzw;
            zzvVar.getClass();
            float fZzak = zzak(f, zzvVar, zzJ());
            float f2 = this.zzB;
            if (f2 != fZzak) {
                if (fZzak == -1.0f) {
                    zzbq();
                    return false;
                }
                if (f2 != -1.0f || fZzak > this.zzf) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", fZzak);
                    zzvj zzvjVar = this.zzx;
                    zzvjVar.getClass();
                    zzvjVar.zzp(bundle);
                    this.zzB = fZzak;
                }
            }
        }
        return true;
    }

    private final boolean zzbp() throws zzjk {
        if (this.zzaa) {
            this.zzY = 1;
            if (this.zzH) {
                this.zzZ = 3;
                return false;
            }
            this.zzZ = 2;
        } else {
            zzbu();
        }
        return true;
    }

    private final void zzbq() throws zzjk {
        if (this.zzaa) {
            this.zzY = 1;
            this.zzZ = 3;
        } else {
            zzaM();
            zzaE();
        }
    }

    private final void zzbs(zzvs zzvsVar) {
        this.zzah = zzvsVar;
        if (zzvsVar.zzd != C.TIME_UNSET) {
            this.zzaj = true;
        }
    }

    private final zzvs zzbt() {
        ArrayDeque arrayDeque = this.zzl;
        return !arrayDeque.isEmpty() ? (zzvs) arrayDeque.getLast() : this.zzah;
    }

    private final boolean zzbv(long j, long j2) {
        if (j2 >= j) {
            return false;
        }
        zzv zzvVar = this.zzp;
        return (zzvVar != null && Objects.equals(zzvVar.zzp, MimeTypes.AUDIO_OPUS) && zzgv.zzf(j, j2)) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected void zzA(long j, boolean z, boolean z2) throws zzjk {
        ArrayDeque arrayDeque = this.zzl;
        if (!arrayDeque.isEmpty()) {
            this.zzah = (zzvs) arrayDeque.getLast();
        }
        arrayDeque.clear();
        if (z2) {
            this.zzae = false;
            this.zzaf = false;
            if (this.zzT) {
                zzaw();
            } else {
                zzaN();
            }
            zzfh zzfhVar = this.zzah.zze;
            if (zzfhVar.zzc() > 0) {
                this.zzag = true;
            }
            zzfhVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected void zzD() {
        this.zzo = null;
        zzbs(zzvs.zza);
        this.zzl.clear();
        if (this.zzT) {
            zzaq();
        } else {
            zzax();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected void zzE() {
        try {
            zzaq();
            zzaM();
        } finally {
            this.zzr = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final long zzV(long j, long j2) {
        return zzaj(j, j2, this.zzM);
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public void zzX(float f, float f2) throws zzjk {
        this.zzv = f;
        this.zzw = f2;
        zzbo(this.zzy);
    }

    /* JADX WARN: Code duplicated, block: B:246:0x03ed A[LOOP:0: B:118:0x01f2->B:246:0x03ed, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:386:0x0627  */
    /* JADX WARN: Code duplicated, block: B:388:0x062e  */
    /* JADX WARN: Code duplicated, block: B:392:0x0641  */
    /* JADX WARN: Code duplicated, block: B:395:0x064c  */
    /* JADX WARN: Code duplicated, block: B:397:0x064f  */
    /* JADX WARN: Code duplicated, block: B:400:0x065e  */
    /* JADX WARN: Code duplicated, block: B:401:0x0661  */
    /* JADX WARN: Code duplicated, block: B:428:0x03ec A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:469:0x0156 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:475:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:476:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:477:0x01ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:478:0x00ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:479:0x00e4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:480:? A[LOOP:5: B:51:0x00c1->B:480:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00b2 A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d4 A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, EDGE_INSN: B:57:0x00d4->B:97:0x01af BREAK  A[LOOP:5: B:51:0x00c1->B:480:?], TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00de A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:61:0x00f0 A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:65:0x0108 A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0116 A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TRY_ENTER, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:71:0x011a A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:84:0x016c A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:87:0x017f A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:90:0x018e  */
    /* JADX WARN: Code duplicated, block: B:91:0x018f A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Code duplicated, block: B:99:0x01b5 A[Catch: IllegalStateException -> 0x0618, CryptoException -> 0x061c, TryCatch #6 {IllegalStateException -> 0x0618, blocks: (B:107:0x01c7, B:40:0x0093, B:42:0x0097, B:44:0x009b, B:47:0x00a4, B:50:0x00b2, B:51:0x00c1, B:55:0x00ce, B:57:0x00d4, B:97:0x01af, B:99:0x01b5, B:100:0x01b8, B:102:0x01be, B:104:0x01c2, B:58:0x00de, B:60:0x00e4, B:61:0x00f0, B:63:0x0100, B:66:0x0110, B:69:0x0116, B:71:0x011a, B:73:0x0127, B:75:0x0131, B:76:0x014e, B:77:0x0156, B:78:0x0157, B:80:0x015e, B:82:0x0166, B:84:0x016c, B:85:0x0173, B:87:0x017f, B:88:0x0188, B:93:0x01a3, B:95:0x01a9, B:91:0x018f, B:65:0x0108, B:96:0x01ac, B:115:0x01dd, B:117:0x01e4, B:118:0x01f2, B:120:0x01f6, B:127:0x0210, B:129:0x0216, B:131:0x0221, B:133:0x022b, B:135:0x0233, B:136:0x0237, B:138:0x023d, B:141:0x0247, B:142:0x0254, B:144:0x025a, B:146:0x0266, B:155:0x0277, B:156:0x027f, B:157:0x0287, B:158:0x028f, B:159:0x0297, B:160:0x029f, B:162:0x02ab, B:163:0x02b0, B:165:0x02b7, B:166:0x02b8, B:168:0x02bc, B:170:0x02c0, B:172:0x02c4, B:173:0x02c7, B:175:0x02cd, B:177:0x02dc), top: B:411:0x001f }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v21 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzvt] */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9, types: [android.media.MediaFormat, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v5 */
    @Override // com.google.android.gms.internal.ads.zzna
    public void zzZ(long j, long j2) throws Throwable {
        boolean z;
        ?? r10;
        ?? r11;
        boolean z2;
        ?? r2;
        zzvl zzvlVarZzaT;
        int i;
        StackTraceElement[] stackTrace;
        ?? r3;
        boolean z3;
        zzlw zzlwVarZzI;
        zziv zzivVar;
        int iZzQ;
        byte b;
        zzv zzvVar;
        long jZzH;
        zzv zzvVar2;
        Throwable th;
        long j3;
        boolean z4 = true;
        try {
            try {
                if (this.zzaf) {
                    zzau();
                    return;
                }
                int i2 = 2;
                if (this.zzo == null && !zzaA(2)) {
                    return;
                }
                zzaE();
                byte b2 = -5;
                ?? r6 = 0;
                try {
                    try {
                        try {
                            try {
                                if (this.zzT) {
                                    try {
                                        try {
                                            Trace.beginSection("bypassRender");
                                            while (true) {
                                                zzgtj.zzi(this.zzaf ^ z4);
                                                zzva zzvaVar = this.zzj;
                                                try {
                                                    if (zzvaVar.zzp()) {
                                                        ByteBuffer byteBuffer = zzvaVar.zzc;
                                                        int i3 = this.zzP;
                                                        int iZzo = zzvaVar.zzo();
                                                        long j4 = zzvaVar.zze;
                                                        boolean zZzbv = zzbv(zzH(), zzvaVar.zzn());
                                                        boolean zZzb = zzvaVar.zzb();
                                                        zzv zzvVar3 = this.zzp;
                                                        if (zzvVar3 == null) {
                                                            throw r6;
                                                        }
                                                        if (zzas(j, j2, null, byteBuffer, i3, 0, iZzo, j4, zZzbv, zZzb, zzvVar3)) {
                                                            zzaZ(zzvaVar.zzn());
                                                            zzvaVar.zza();
                                                            r3 = 0;
                                                        } else {
                                                            z4 = true;
                                                        }
                                                        z3 = false;
                                                        break;
                                                    }
                                                    r3 = r6;
                                                    if (this.zzae) {
                                                        z4 = true;
                                                        this.zzaf = true;
                                                        z3 = false;
                                                        break;
                                                    }
                                                    z4 = true;
                                                    if (this.zzU) {
                                                        zzgtj.zzi(zzvaVar.zzq(this.zzi));
                                                        z3 = false;
                                                        this.zzU = false;
                                                    } else {
                                                        z3 = false;
                                                    }
                                                    if (this.zzV) {
                                                        if (!zzvaVar.zzp()) {
                                                            zzaq();
                                                            this.zzV = z3;
                                                            zzaE();
                                                            if (!this.zzT) {
                                                                break;
                                                            }
                                                            zzgtj.zzi(!this.zzae);
                                                            zzlwVarZzI = zzI();
                                                            zzivVar = this.zzi;
                                                            zzivVar.zza();
                                                            while (true) {
                                                                zzivVar.zza();
                                                                iZzQ = zzQ(zzlwVarZzI, zzivVar, z3 ? 1 : 0);
                                                                b = -5;
                                                                if (iZzQ != -5) {
                                                                    zzao(zzlwVarZzI);
                                                                    break;
                                                                }
                                                                if (iZzQ != -4) {
                                                                    if (zzcW()) {
                                                                        break;
                                                                    }
                                                                    zzbt().zzf = this.zzad;
                                                                    break;
                                                                }
                                                                if (zzivVar.zzb()) {
                                                                    this.zzae = true;
                                                                    zzbt().zzf = this.zzad;
                                                                    break;
                                                                }
                                                                this.zzad = Math.max(this.zzad, zzivVar.zze);
                                                                if (zzcW()) {
                                                                    zzbt().zzf = this.zzad;
                                                                } else {
                                                                    zzbt().zzf = this.zzad;
                                                                }
                                                                if (this.zzag) {
                                                                    zzvVar2 = this.zzo;
                                                                    if (zzvVar2 != null) {
                                                                        throw r3;
                                                                    }
                                                                    this.zzp = zzvVar2;
                                                                    if (Objects.equals(zzvVar2.zzp, MimeTypes.AUDIO_OPUS)) {
                                                                        int iZze = zzgv.zze((byte[]) this.zzp.zzs.get(z3 ? 1 : 0));
                                                                        zzt zztVarZza = this.zzp.zza();
                                                                        zztVarZza.zzJ(iZze);
                                                                        this.zzp = zztVarZza.zzO();
                                                                    }
                                                                    zzap(this.zzp, r3);
                                                                    this.zzag = z3;
                                                                }
                                                                zzivVar.zzl();
                                                                zzvVar = this.zzp;
                                                                if (zzvVar != null) {
                                                                    if (zzivVar.zze()) {
                                                                        zzivVar.zza = this.zzp;
                                                                        zzav(zzivVar);
                                                                    }
                                                                    if (zzgv.zzf(zzH(), zzivVar.zze)) {
                                                                        this.zzm.zza(zzivVar, this.zzp.zzs);
                                                                    }
                                                                }
                                                                if (!zzvaVar.zzp()) {
                                                                    jZzH = zzH();
                                                                    if (zzbv(jZzH, zzvaVar.zzn()) == zzbv(jZzH, zzivVar.zze)) {
                                                                    }
                                                                    this.zzU = true;
                                                                    break;
                                                                }
                                                                if (!zzvaVar.zzq(zzivVar)) {
                                                                    this.zzU = true;
                                                                    break;
                                                                }
                                                            }
                                                            if (zzvaVar.zzp()) {
                                                                zzvaVar.zzl();
                                                            }
                                                            if (!zzvaVar.zzp()) {
                                                                break;
                                                                break;
                                                            }
                                                            continue;
                                                        } else {
                                                            b = -5;
                                                        }
                                                        r6 = r3;
                                                    } else {
                                                        zzgtj.zzi(!this.zzae);
                                                        zzlwVarZzI = zzI();
                                                        zzivVar = this.zzi;
                                                        zzivVar.zza();
                                                        while (true) {
                                                            zzivVar.zza();
                                                            iZzQ = zzQ(zzlwVarZzI, zzivVar, z3 ? 1 : 0);
                                                            b = -5;
                                                            if (iZzQ != -5) {
                                                                zzao(zzlwVarZzI);
                                                                break;
                                                            }
                                                            if (iZzQ != -4) {
                                                                if (zzcW()) {
                                                                    break;
                                                                }
                                                                zzbt().zzf = this.zzad;
                                                                break;
                                                            }
                                                            if (zzivVar.zzb()) {
                                                                this.zzae = true;
                                                                zzbt().zzf = this.zzad;
                                                                break;
                                                            }
                                                            this.zzad = Math.max(this.zzad, zzivVar.zze);
                                                            if (zzcW() || this.zzh.zzd()) {
                                                                zzbt().zzf = this.zzad;
                                                            }
                                                            if (this.zzag) {
                                                                zzvVar2 = this.zzo;
                                                                if (zzvVar2 != null) {
                                                                    throw r3;
                                                                }
                                                                this.zzp = zzvVar2;
                                                                if (Objects.equals(zzvVar2.zzp, MimeTypes.AUDIO_OPUS) && !this.zzp.zzs.isEmpty()) {
                                                                    int iZze2 = zzgv.zze((byte[]) this.zzp.zzs.get(z3 ? 1 : 0));
                                                                    zzt zztVarZza2 = this.zzp.zza();
                                                                    zztVarZza2.zzJ(iZze2);
                                                                    this.zzp = zztVarZza2.zzO();
                                                                }
                                                                zzap(this.zzp, r3);
                                                                this.zzag = z3;
                                                            }
                                                            zzivVar.zzl();
                                                            zzvVar = this.zzp;
                                                            if (zzvVar != null && Objects.equals(zzvVar.zzp, MimeTypes.AUDIO_OPUS)) {
                                                                if (zzivVar.zze()) {
                                                                    zzivVar.zza = this.zzp;
                                                                    zzav(zzivVar);
                                                                }
                                                                if (zzgv.zzf(zzH(), zzivVar.zze)) {
                                                                    this.zzm.zza(zzivVar, this.zzp.zzs);
                                                                }
                                                            }
                                                            if (!zzvaVar.zzp()) {
                                                                jZzH = zzH();
                                                                if (zzbv(jZzH, zzvaVar.zzn()) == zzbv(jZzH, zzivVar.zze)) {
                                                                }
                                                                this.zzU = true;
                                                                break;
                                                            }
                                                            if (!zzvaVar.zzq(zzivVar)) {
                                                                this.zzU = true;
                                                                break;
                                                            }
                                                        }
                                                        if (zzvaVar.zzp()) {
                                                            zzvaVar.zzl();
                                                        }
                                                        if (!zzvaVar.zzp() && !this.zzae && !this.zzV) {
                                                            break;
                                                        }
                                                        r6 = r3;
                                                    }
                                                } catch (IllegalStateException e) {
                                                    e = e;
                                                    z4 = true;
                                                    b2 = 0;
                                                    z = z4;
                                                    r11 = b2;
                                                    z2 = e instanceof MediaCodec.CodecException;
                                                    if (!z2) {
                                                        stackTrace = e.getStackTrace();
                                                        if (stackTrace.length > 0) {
                                                        }
                                                        throw e;
                                                    }
                                                    zzan(e);
                                                    if (z2) {
                                                        r2 = r11;
                                                    } else {
                                                        r2 = r11;
                                                    }
                                                    if (r2 != 0) {
                                                        zzaM();
                                                    }
                                                    zzvlVarZzaT = zzaT(e, this.zzE);
                                                    if (zzvlVarZzaT.zza == 1101) {
                                                        i = PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED;
                                                    } else {
                                                        i = PlaybackException.ERROR_CODE_DECODING_FAILED;
                                                    }
                                                    throw zzP(zzvlVarZzaT, this.zzo, r2, i);
                                                }
                                            }
                                            Trace.endSection();
                                        } catch (MediaCodec.CryptoException e2) {
                                            e = e2;
                                            b2 = 0;
                                            r10 = b2;
                                            throw zzP(e, this.zzo, r10, zzfl.zzH(e.getErrorCode()));
                                        }
                                    } catch (IllegalStateException e3) {
                                        e = e3;
                                    }
                                } else {
                                    byte b3 = -5;
                                    Throwable th2 = null;
                                    boolean z5 = false;
                                    if (this.zzx != null) {
                                        long jZzb = zzM().zzb();
                                        Trace.beginSection("drainAndFeed");
                                        long j5 = jZzb;
                                        while (true) {
                                            zzvj zzvjVar = this.zzx;
                                            if (zzvjVar == null) {
                                                throw th2;
                                            }
                                            if (!zzaC()) {
                                                try {
                                                    MediaCodec.BufferInfo bufferInfo = this.zzk;
                                                    int iZzf = zzvjVar.zzf(bufferInfo);
                                                    if (iZzf >= 0) {
                                                        th = th2;
                                                        bufferInfo.presentationTimeUs -= this.zzam;
                                                        if (!this.zzJ) {
                                                            if (bufferInfo.size == 0 && (bufferInfo.flags & 4) != 0) {
                                                                zzbr();
                                                                j3 = j5;
                                                                break;
                                                            }
                                                            this.zzP = iZzf;
                                                            ByteBuffer byteBufferZzj = zzvjVar.zzj(iZzf);
                                                            this.zzQ = byteBufferZzj;
                                                            if (byteBufferZzj != null) {
                                                                byteBufferZzj.position(bufferInfo.offset);
                                                                this.zzQ.limit(bufferInfo.offset + bufferInfo.size);
                                                            }
                                                            zzv zzvVar4 = (zzv) this.zzah.zze.zze(bufferInfo.presentationTimeUs);
                                                            if (zzvVar4 == null && this.zzaj && this.zzz != null) {
                                                                zzvVar4 = (zzv) this.zzah.zze.zzd();
                                                            }
                                                            if (zzvVar4 != null) {
                                                                this.zzp = zzvVar4;
                                                            } else if (this.zzA && this.zzp != null) {
                                                            }
                                                            zzv zzvVar5 = this.zzp;
                                                            if (zzvVar5 == null) {
                                                                throw th;
                                                            }
                                                            zzap(zzvVar5, this.zzz);
                                                            this.zzA = z5;
                                                            this.zzaj = z5;
                                                        } else {
                                                            this.zzJ = z5;
                                                            zzvjVar.zzc(iZzf, z5);
                                                            j3 = j5;
                                                            if (!zzaB(j3)) {
                                                                break;
                                                                break;
                                                            }
                                                            j5 = j3;
                                                            th2 = th;
                                                            z4 = true;
                                                            i2 = 2;
                                                            z5 = false;
                                                            b3 = -5;
                                                        }
                                                    } else {
                                                        if (iZzf != -2) {
                                                            if (this.zzK && (this.zzae || this.zzY == i2)) {
                                                                zzbr();
                                                            }
                                                            long j6 = this.zzL;
                                                            if (j6 != C.TIME_UNSET && j6 + 100 < zzM().zza()) {
                                                                zzbr();
                                                            }
                                                            th = th2;
                                                            j3 = j5;
                                                            break;
                                                        }
                                                        this.zzac = z4;
                                                        zzvj zzvjVar2 = this.zzx;
                                                        if (zzvjVar2 == null) {
                                                            throw th2;
                                                        }
                                                        MediaFormat mediaFormatZzg = zzvjVar2.zzg();
                                                        if (this.zzF != 0 && mediaFormatZzg.getInteger("width") == 32 && mediaFormatZzg.getInteger("height") == 32) {
                                                            this.zzJ = z4;
                                                        } else {
                                                            if (Build.VERSION.SDK_INT >= 29 && !this.zzap.isEmpty()) {
                                                                zzgww<String> zzgwwVar = this.zzap;
                                                                zziz zzizVar = zziz.zza;
                                                                zziy zziyVar = new zziy();
                                                                for (String str : zzgwwVar) {
                                                                    if (mediaFormatZzg.containsKey(str)) {
                                                                        int valueTypeForKey = mediaFormatZzg.getValueTypeForKey(str);
                                                                        if (valueTypeForKey == z4) {
                                                                            zziyVar.zza(str, mediaFormatZzg.getInteger(str));
                                                                        } else if (valueTypeForKey == i2) {
                                                                            zziyVar.zzb(str, mediaFormatZzg.getLong(str));
                                                                        } else if (valueTypeForKey == 3) {
                                                                            zziyVar.zzc(str, mediaFormatZzg.getFloat(str));
                                                                        } else if (valueTypeForKey == 4) {
                                                                            zziyVar.zzd(str, mediaFormatZzg.getString(str));
                                                                        } else if (valueTypeForKey == 5) {
                                                                            zziyVar.zze(str, mediaFormatZzg.getByteBuffer(str));
                                                                        }
                                                                    }
                                                                }
                                                                zziz zzizVarZzg = zziyVar.zzg();
                                                                if (!zzizVarZzg.equals(this.zzao)) {
                                                                    this.zzao = zzizVarZzg;
                                                                    zzat(zzizVarZzg);
                                                                }
                                                            }
                                                            this.zzz = mediaFormatZzg;
                                                            this.zzA = z4;
                                                        }
                                                        th = th2;
                                                        j3 = j5;
                                                        if (!zzaB(j3)) {
                                                            break;
                                                        }
                                                        j5 = j3;
                                                        th2 = th;
                                                        z4 = true;
                                                        i2 = 2;
                                                        z5 = false;
                                                        b3 = -5;
                                                    }
                                                } catch (IllegalStateException e4) {
                                                    e = e4;
                                                    r11 = z5;
                                                    z = true;
                                                    z2 = e instanceof MediaCodec.CodecException;
                                                    if (!z2) {
                                                        stackTrace = e.getStackTrace();
                                                        if (stackTrace.length > 0) {
                                                        }
                                                        throw e;
                                                    }
                                                    zzan(e);
                                                    if (z2) {
                                                        r2 = r11;
                                                    } else {
                                                        r2 = r11;
                                                    }
                                                    if (r2 != 0) {
                                                        zzaM();
                                                    }
                                                    zzvlVarZzaT = zzaT(e, this.zzE);
                                                    if (zzvlVarZzaT.zza == 1101) {
                                                        i = PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED;
                                                    } else {
                                                        i = PlaybackException.ERROR_CODE_DECODING_FAILED;
                                                    }
                                                    throw zzP(zzvlVarZzaT, this.zzo, r2, i);
                                                }
                                                z2 = e instanceof MediaCodec.CodecException;
                                                if (!z2) {
                                                    stackTrace = e.getStackTrace();
                                                    if (stackTrace.length > 0 || !stackTrace[r11].getClassName().equals("android.media.MediaCodec")) {
                                                        throw e;
                                                    }
                                                }
                                                zzan(e);
                                                if (z2 || !((MediaCodec.CodecException) e).isRecoverable()) {
                                                    r2 = r11;
                                                } else {
                                                    r2 = z;
                                                }
                                                if (r2 != 0) {
                                                    zzaM();
                                                }
                                                zzvlVarZzaT = zzaT(e, this.zzE);
                                                if (zzvlVarZzaT.zza == 1101) {
                                                    i = PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED;
                                                } else {
                                                    i = PlaybackException.ERROR_CODE_DECODING_FAILED;
                                                }
                                                throw zzP(zzvlVarZzaT, this.zzo, r2, i);
                                            }
                                            th = th2;
                                            this.zzR = (this.zzal || this.zzk.presentationTimeUs < zzH()) ? true : z5;
                                            long j7 = this.zzah.zzf;
                                            this.zzS = (j7 == C.TIME_UNSET || j7 > this.zzk.presentationTimeUs) ? z5 : true;
                                            ByteBuffer byteBuffer2 = this.zzQ;
                                            int i4 = this.zzP;
                                            MediaCodec.BufferInfo bufferInfo2 = this.zzk;
                                            long j8 = j5;
                                            int i5 = bufferInfo2.flags;
                                            long j9 = bufferInfo2.presentationTimeUs;
                                            boolean z6 = this.zzR;
                                            boolean z7 = this.zzS;
                                            zzv zzvVar6 = this.zzp;
                                            if (zzvVar6 == null) {
                                                throw th;
                                            }
                                            if (zzas(j, j2, zzvjVar, byteBuffer2, i4, i5, 1, j9, z6, z7, zzvVar6)) {
                                                zzaZ(bufferInfo2.presentationTimeUs);
                                                boolean z8 = (bufferInfo2.flags & 4) != 0;
                                                if (!z8 && this.zzab && this.zzS) {
                                                    this.zzL = zzM().zza();
                                                }
                                                zzbn();
                                                if (z8) {
                                                    zzbr();
                                                } else {
                                                    j3 = j8;
                                                    if (!zzaB(j3)) {
                                                        break;
                                                        break;
                                                    }
                                                    j5 = j3;
                                                    th2 = th;
                                                    z4 = true;
                                                    i2 = 2;
                                                    z5 = false;
                                                    b3 = -5;
                                                }
                                            }
                                            j3 = j8;
                                            break;
                                        }
                                        do {
                                            zzvj zzvjVar3 = this.zzx;
                                            if (zzvjVar3 == null || this.zzY == 2 || this.zzae) {
                                                break;
                                            }
                                            if (this.zzO < 0) {
                                                int iZze3 = zzvjVar3.zze();
                                                this.zzO = iZze3;
                                                if (iZze3 < 0) {
                                                    break;
                                                    break;
                                                } else {
                                                    zziv zzivVar2 = this.zzh;
                                                    zzivVar2.zzc = zzvjVar3.zzh(iZze3);
                                                    zzivVar2.zza();
                                                }
                                            }
                                            z = true;
                                            if (this.zzY == 1) {
                                                if (!this.zzK) {
                                                    this.zzab = true;
                                                    zzvjVar3.zza(this.zzO, 0, 0, 0L, 4);
                                                    zzbm();
                                                }
                                                this.zzY = 2;
                                                break;
                                            }
                                            try {
                                                if (this.zzI) {
                                                    this.zzI = false;
                                                    ByteBuffer byteBuffer3 = this.zzh.zzc;
                                                    if (byteBuffer3 == null) {
                                                        throw th;
                                                    }
                                                    byteBuffer3.put(zzb);
                                                    zzvjVar3.zza(this.zzO, 0, 38, 0L, 0);
                                                    zzbm();
                                                    this.zzaa = true;
                                                } else {
                                                    r10 = 0;
                                                    r11 = 0;
                                                    if (this.zzX == 1) {
                                                        int i6 = 0;
                                                        while (true) {
                                                            zzv zzvVar7 = this.zzy;
                                                            if (zzvVar7 == null) {
                                                                throw th;
                                                            }
                                                            if (i6 >= zzvVar7.zzs.size()) {
                                                                this.zzX = 2;
                                                                break;
                                                            }
                                                            byte[] bArr = (byte[]) this.zzy.zzs.get(i6);
                                                            ByteBuffer byteBuffer4 = this.zzh.zzc;
                                                            if (byteBuffer4 == null) {
                                                                throw th;
                                                            }
                                                            byteBuffer4.put(bArr);
                                                            i6++;
                                                        }
                                                    }
                                                    ByteBuffer byteBuffer5 = this.zzh.zzc;
                                                    if (byteBuffer5 == null) {
                                                        throw th;
                                                    }
                                                    int iPosition = byteBuffer5.position();
                                                    final zzlw zzlwVarZzI2 = zzI();
                                                    try {
                                                        zzvjVar3.zzi(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvq
                                                            @Override // java.lang.Runnable
                                                            public final /* synthetic */ void run() {
                                                                this.zza.zzbk(zzlwVarZzI2);
                                                            }
                                                        });
                                                        int i7 = this.zzn.get();
                                                        if (i7 == -3) {
                                                            if (!zzcW()) {
                                                                break;
                                                            }
                                                            zzbt().zzf = this.zzad;
                                                            break;
                                                        }
                                                        if (i7 == -5) {
                                                            if (this.zzX == 2) {
                                                                this.zzh.zza();
                                                                this.zzX = 1;
                                                            }
                                                            zzao(zzlwVarZzI2);
                                                        } else {
                                                            zziv zzivVar3 = this.zzh;
                                                            if (zzivVar3.zzb()) {
                                                                zzbt().zzf = this.zzad;
                                                                if (this.zzX == 2) {
                                                                    zzivVar3.zza();
                                                                    this.zzX = 1;
                                                                }
                                                                this.zzae = true;
                                                                if (this.zzaa) {
                                                                    if (!this.zzK) {
                                                                        this.zzab = true;
                                                                        zzvjVar3.zza(this.zzO, 0, 0, 0L, 4);
                                                                        zzbm();
                                                                        break;
                                                                    }
                                                                    break;
                                                                }
                                                                zzbr();
                                                                break;
                                                            }
                                                            if (this.zzaa || zzivVar3.zzc()) {
                                                                long j10 = zzivVar3.zze;
                                                                if (!zzaX(zzivVar3)) {
                                                                    boolean zZzk = zzivVar3.zzk();
                                                                    if (zZzk) {
                                                                        zzivVar3.zzb.zzc(iPosition);
                                                                    }
                                                                    if (this.zzag) {
                                                                        zzfh zzfhVar = zzbt().zze;
                                                                        zzv zzvVar8 = this.zzo;
                                                                        if (zzvVar8 == null) {
                                                                            throw th;
                                                                        }
                                                                        zzfhVar.zza(j10, zzvVar8);
                                                                        this.zzag = false;
                                                                    }
                                                                    this.zzad = Math.max(this.zzad, j10);
                                                                    if (zzcW() || zzivVar3.zzd()) {
                                                                        zzbt().zzf = this.zzad;
                                                                    }
                                                                    zzivVar3.zzl();
                                                                    if (zzivVar3.zze()) {
                                                                        zzav(zzivVar3);
                                                                    }
                                                                    if (this.zzal) {
                                                                        long j11 = this.zzad;
                                                                        if (j10 <= j11) {
                                                                            this.zzam += (j11 - j10) + 1;
                                                                        }
                                                                        this.zzad = j10;
                                                                        this.zzal = false;
                                                                    }
                                                                    zzaV(zzivVar3);
                                                                    int iZzaW = zzaW(zzivVar3);
                                                                    long j12 = j10 + this.zzam;
                                                                    if (zZzk) {
                                                                        zzvjVar3.zzb(this.zzO, 0, zzivVar3.zzb, j12, iZzaW);
                                                                    } else {
                                                                        int i8 = this.zzO;
                                                                        ByteBuffer byteBuffer6 = zzivVar3.zzc;
                                                                        if (byteBuffer6 == null) {
                                                                            throw th;
                                                                        }
                                                                        zzvjVar3.zza(i8, 0, byteBuffer6.limit(), j12, iZzaW);
                                                                    }
                                                                    zzbm();
                                                                    this.zzaa = true;
                                                                    this.zzX = 0;
                                                                    this.zza.zzc++;
                                                                }
                                                            } else {
                                                                zzivVar3.zza();
                                                                if (this.zzX == 2) {
                                                                    this.zzX = 1;
                                                                }
                                                            }
                                                        }
                                                    } catch (zziu e5) {
                                                        zzan(e5);
                                                        zzaA(0);
                                                        zzay();
                                                    }
                                                }
                                            } catch (IllegalStateException e6) {
                                                e = e6;
                                                r11 = 0;
                                                z2 = e instanceof MediaCodec.CodecException;
                                                if (!z2) {
                                                    stackTrace = e.getStackTrace();
                                                    if (stackTrace.length > 0) {
                                                    }
                                                    throw e;
                                                }
                                                zzan(e);
                                                if (z2) {
                                                    r2 = r11;
                                                } else {
                                                    r2 = r11;
                                                }
                                                if (r2 != 0) {
                                                    zzaM();
                                                }
                                                zzvlVarZzaT = zzaT(e, this.zzE);
                                                if (zzvlVarZzaT.zza == 1101) {
                                                    i = PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED;
                                                } else {
                                                    i = PlaybackException.ERROR_CODE_DECODING_FAILED;
                                                }
                                                throw zzP(zzvlVarZzaT, this.zzo, r2, i);
                                            }
                                        } while (zzaB(j3));
                                        Trace.endSection();
                                    } else {
                                        this.zza.zzd += zzR(j);
                                        zzaA(1);
                                    }
                                }
                                this.zza.zza();
                            } catch (MediaCodec.CryptoException e7) {
                                e = e7;
                                throw zzP(e, this.zzo, r10, zzfl.zzH(e.getErrorCode()));
                            } catch (IllegalStateException e8) {
                                e = e8;
                            }
                        } catch (MediaCodec.CryptoException e9) {
                            e = e9;
                        }
                    } catch (IllegalStateException e10) {
                        e = e10;
                    }
                } catch (IllegalStateException e11) {
                    e = e11;
                    r11 = 0;
                }
            } catch (IllegalStateException e12) {
                e = e12;
                z = true;
            }
        } catch (MediaCodec.CryptoException e13) {
            e = e13;
            r10 = 0;
        }
    }

    public final void zzaD() {
        this.zzak = true;
    }

    /* JADX WARN: Code duplicated, block: B:153:0x02a6 A[Catch: zzvp -> 0x02d4, TryCatch #7 {zzvp -> 0x02d4, blocks: (B:25:0x0055, B:27:0x005c, B:29:0x0063, B:31:0x0079, B:32:0x0084, B:37:0x0091, B:39:0x0099, B:41:0x009d, B:42:0x00a0, B:44:0x00a4, B:46:0x00ad, B:151:0x028d, B:153:0x02a6, B:155:0x02af, B:158:0x02bb, B:159:0x02bd, B:154:0x02a9, B:161:0x02bf, B:162:0x02c0, B:164:0x02c5, B:165:0x02c6, B:166:0x02d0, B:35:0x0088, B:36:0x0090, B:168:0x02d3), top: B:186:0x0055, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x02a9 A[Catch: zzvp -> 0x02d4, TryCatch #7 {zzvp -> 0x02d4, blocks: (B:25:0x0055, B:27:0x005c, B:29:0x0063, B:31:0x0079, B:32:0x0084, B:37:0x0091, B:39:0x0099, B:41:0x009d, B:42:0x00a0, B:44:0x00a4, B:46:0x00ad, B:151:0x028d, B:153:0x02a6, B:155:0x02af, B:158:0x02bb, B:159:0x02bd, B:154:0x02a9, B:161:0x02bf, B:162:0x02c0, B:164:0x02c5, B:165:0x02c6, B:166:0x02d0, B:35:0x0088, B:36:0x0090, B:168:0x02d3), top: B:186:0x0055, inners: #5 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x02bb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x02b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:0x010a  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c6  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v36, types: [com.google.android.gms.internal.ads.zzvh] */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v4, types: [com.google.android.gms.internal.ads.zzvm] */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.google.android.gms.internal.ads.zzvg] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r17v1, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r26v0, types: [com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzvt] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.util.ArrayDeque] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    protected final void zzaE() throws zzjk {
        zzv zzvVar;
        boolean z;
        ?? Zzah;
        zzvp zzvpVar;
        zzvp zzvpVar2;
        boolean z2;
        zzvm zzvmVar;
        if (this.zzx != null || this.zzT || (zzvVar = this.zzo) == null) {
            return;
        }
        boolean z3 = true;
        if (zzaF(zzvVar)) {
            zzaq();
            String str = zzvVar.zzp;
            if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
                this.zzj.zzm(32);
            } else {
                this.zzj.zzm(1);
            }
            this.zzT = true;
            return;
        }
        zzug zzugVar = this.zzr;
        this.zzq = zzugVar;
        if (zzugVar != null) {
            zzgtj.zzi(true);
            this.zzq.zza();
        }
        try {
            zzv zzvVar2 = this.zzo;
            MediaCrypto mediaCrypto = null;
            if (zzvVar2 == null) {
                throw null;
            }
            if (this.zzC == null) {
                try {
                    List listZzaf = zzaf(this.zze, zzvVar2, false);
                    listZzaf.isEmpty();
                    this.zzC = new ArrayDeque();
                    if (!listZzaf.isEmpty()) {
                        this.zzC.add((zzvm) listZzaf.get(0));
                    }
                    this.zzD = null;
                } catch (zzvx e) {
                    throw new zzvp(zzvVar2, (Throwable) e, false, -49998);
                }
            }
            if (this.zzC.isEmpty()) {
                throw new zzvp(zzvVar2, (Throwable) null, false, -49999);
            }
            ArrayDeque arrayDeque = this.zzC;
            if (arrayDeque == null) {
                throw null;
            }
            while (this.zzx == null) {
                zzvm zzvmVar2 = (zzvm) arrayDeque.peekFirst();
                if (zzvmVar2 == null) {
                    throw mediaCrypto;
                }
                zzaU(zzvVar2);
                if (!zzaG(zzvmVar2)) {
                    return;
                }
                try {
                    this.zzE = zzvmVar2;
                    zzv zzvVar3 = this.zzo;
                    if (zzvVar3 == null) {
                        throw mediaCrypto;
                    }
                    String str2 = zzvmVar2.zza;
                    float fZzak = zzak(this.zzw, zzvVar3, zzJ());
                    if (fZzak <= this.zzf) {
                        fZzak = -1.0f;
                    }
                    long jZzb = zzM().zzb();
                    z = z3;
                    try {
                        Zzah = zzah(zzvmVar2, zzvVar3, mediaCrypto, fZzak);
                        if (Build.VERSION.SDK_INT >= 31) {
                            LogSessionId logSessionIdZza = zzL().zza();
                            if (!logSessionIdZza.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                                Zzah.zzb.setString("log-session-id", logSessionIdZza.getStringId());
                            }
                        }
                        try {
                            StringBuilder sb = new StringBuilder(str2.length() + 12);
                            sb.append("createCodec:");
                            sb.append(str2);
                            Trace.beginSection(sb.toString());
                            zzvj zzvjVarZzc = this.zzd.zzc(Zzah);
                            this.zzx = zzvjVarZzc;
                            this.zzM = zzvjVarZzc.zzm(new zzvr(this, null));
                            Trace.endSection();
                            long jZzb2 = zzM().zzb();
                            if (!zzvmVar2.zzc(this.zzc, zzvVar3)) {
                                Object[] objArr = {zzv.zze(zzvVar3), str2};
                                String str3 = zzfl.zza;
                                zzeg.zzc("MediaCodecRenderer", String.format(Locale.US, "Format exceeds selected codec's capabilities [%s, %s]", objArr));
                            }
                            this.zzB = fZzak;
                            this.zzy = zzvVar3;
                            this.zzF = (Build.VERSION.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str2) && (Build.MODEL.startsWith("SM-T585") || Build.MODEL.startsWith("SM-A510") || Build.MODEL.startsWith("SM-A520") || Build.MODEL.startsWith("SM-J700"))) ? 2 : 0;
                            this.zzG = (Build.VERSION.SDK_INT == 29 && "c2.android.aac.decoder".equals(str2)) ? z : false;
                            this.zzH = false;
                            String str4 = zzvmVar2.zza;
                            if (Build.VERSION.SDK_INT <= 25 && "OMX.rk.video_decoder.avc".equals(str4)) {
                                z2 = z;
                            } else if ((Build.VERSION.SDK_INT > 29 || !("OMX.broadcom.video_decoder.tunnel".equals(str4) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str4) || "OMX.bcm.vdec.avc.tunnel".equals(str4) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str4) || "OMX.bcm.vdec.hevc.tunnel".equals(str4) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str4))) && !("Amazon".equals(Build.MANUFACTURER) && "AFTS".equals(Build.MODEL) && zzvmVar2.zzf)) {
                                z2 = false;
                            } else {
                                z2 = z;
                            }
                            this.zzK = z2;
                            zzvj zzvjVar = this.zzx;
                            if (zzvjVar == null) {
                                throw null;
                            }
                            if (zze() == 2) {
                                try {
                                    zzvmVar = zzvmVar2;
                                    try {
                                        this.zzN = zzM().zzb() + 1000;
                                    } catch (Exception e2) {
                                        e = e2;
                                        Zzah = zzvmVar;
                                        zzeg.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(Zzah.zza), e);
                                        arrayDeque.removeFirst();
                                        zzvpVar = new zzvp(zzvVar2, (Throwable) e, false, (zzvm) Zzah);
                                        zzan(zzvpVar);
                                        zzvpVar2 = this.zzD;
                                        if (zzvpVar2 == null) {
                                            this.zzD = zzvpVar;
                                        } else {
                                            this.zzD = zzvpVar2.zza(zzvpVar);
                                        }
                                        if (!arrayDeque.isEmpty()) {
                                            throw this.zzD;
                                        }
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    zzvmVar = zzvmVar2;
                                    Zzah = zzvmVar;
                                    zzeg.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(Zzah.zza), e);
                                    arrayDeque.removeFirst();
                                    zzvpVar = new zzvp(zzvVar2, (Throwable) e, false, (zzvm) Zzah);
                                    zzan(zzvpVar);
                                    zzvpVar2 = this.zzD;
                                    if (zzvpVar2 == null) {
                                        this.zzD = zzvpVar;
                                    } else {
                                        this.zzD = zzvpVar2.zza(zzvpVar);
                                    }
                                    if (!arrayDeque.isEmpty()) {
                                        throw this.zzD;
                                    }
                                }
                            } else {
                                zzvmVar = zzvmVar2;
                            }
                            this.zza.zza++;
                            long j = jZzb2 - jZzb;
                            if (Build.VERSION.SDK_INT >= 31 && !this.zzap.isEmpty()) {
                                zzvj zzvjVar2 = this.zzx;
                                if (zzvjVar2 == null) {
                                    throw null;
                                }
                                zzvjVar2.zzr(new ArrayList(this.zzap));
                            }
                            Zzah = zzvmVar;
                            try {
                                zzal(str2, Zzah, jZzb2, j);
                            } catch (Exception e4) {
                                e = e4;
                                zzeg.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(Zzah.zza), e);
                                arrayDeque.removeFirst();
                                zzvpVar = new zzvp(zzvVar2, (Throwable) e, false, (zzvm) Zzah);
                                zzan(zzvpVar);
                                zzvpVar2 = this.zzD;
                                if (zzvpVar2 == null) {
                                    this.zzD = zzvpVar;
                                } else {
                                    this.zzD = zzvpVar2.zza(zzvpVar);
                                }
                                if (!arrayDeque.isEmpty()) {
                                    throw this.zzD;
                                }
                            }
                            z3 = z;
                            mediaCrypto = null;
                        } catch (Throwable th) {
                            Trace.endSection();
                            throw th;
                        }
                    } catch (Exception e5) {
                        e = e5;
                        Zzah = zzvmVar2;
                    }
                } catch (Exception e6) {
                    e = e6;
                    z = z3;
                }
                Zzah = zzvmVar2;
                zzeg.zzd("MediaCodecRenderer", "Failed to initialize decoder: ".concat(Zzah.zza), e);
                arrayDeque.removeFirst();
                zzvpVar = new zzvp(zzvVar2, (Throwable) e, false, (zzvm) Zzah);
                zzan(zzvpVar);
                zzvpVar2 = this.zzD;
                if (zzvpVar2 == null) {
                    this.zzD = zzvpVar;
                } else {
                    this.zzD = zzvpVar2.zza(zzvpVar);
                }
                if (!arrayDeque.isEmpty()) {
                    throw this.zzD;
                }
                z3 = z;
                mediaCrypto = null;
            }
            this.zzC = mediaCrypto;
        } catch (zzvp e7) {
            throw zzP(e7, zzvVar, false, PlaybackException.ERROR_CODE_DECODER_INIT_FAILED);
        }
    }

    protected final boolean zzaF(zzv zzvVar) {
        return this.zzr == null && zzag(zzvVar);
    }

    protected boolean zzaG(zzvm zzvmVar) {
        return true;
    }

    protected final boolean zzaH() {
        return this.zzT;
    }

    protected final zzvj zzaI() {
        return this.zzx;
    }

    protected final zzv zzaJ() {
        return this.zzy;
    }

    protected final MediaFormat zzaK() {
        return this.zzz;
    }

    protected final zzvm zzaL() {
        return this.zzE;
    }

    protected final void zzaM() {
        try {
            zzvj zzvjVar = this.zzx;
            if (zzvjVar != null) {
                zzvjVar.zzl();
                this.zza.zzb++;
                zzvm zzvmVar = this.zzE;
                if (zzvmVar == null) {
                    throw null;
                }
                zzam(zzvmVar.zza);
            }
            this.zzx = null;
            this.zzt = null;
            this.zzq = null;
            zzaS();
        } catch (Throwable th) {
            this.zzx = null;
            this.zzt = null;
            this.zzq = null;
            zzaS();
            throw th;
        }
    }

    protected final boolean zzaN() throws zzjk {
        boolean zZzax = zzax();
        if (zZzax) {
            zzaE();
        }
        return zZzax;
    }

    protected boolean zzaO() {
        int i = this.zzZ;
        if (i == 3 || ((this.zzG && !this.zzac) || (this.zzH && this.zzab))) {
            return true;
        }
        if (i != 2) {
            return false;
        }
        try {
            zzbu();
            return false;
        } catch (zzjk e) {
            zzeg.zzd("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e);
            return true;
        }
    }

    protected boolean zzaP() {
        return true;
    }

    protected final long zzaQ() {
        return this.zzam;
    }

    protected void zzaR() {
        zzbm();
        zzbn();
        zzaz();
        this.zzN = C.TIME_UNSET;
        this.zzab = false;
        this.zzL = C.TIME_UNSET;
        this.zzaa = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzR = false;
        this.zzS = false;
        this.zzY = 0;
        this.zzZ = 0;
        this.zzX = this.zzW ? 1 : 0;
        this.zzal = false;
        this.zzam = 0L;
    }

    protected final void zzaS() {
        zzaR();
        this.zzC = null;
        this.zzE = null;
        this.zzy = null;
        this.zzz = null;
        this.zzA = false;
        this.zzac = false;
        this.zzB = -1.0f;
        this.zzF = 0;
        this.zzG = false;
        this.zzH = false;
        this.zzK = false;
        this.zzM = false;
        this.zzW = false;
        this.zzX = 0;
    }

    protected zzvl zzaT(Throwable th, zzvm zzvmVar) {
        return new zzvl(th, zzvmVar);
    }

    protected boolean zzaU(zzv zzvVar) throws zzjk {
        return true;
    }

    protected void zzaV(zziv zzivVar) throws zzjk {
    }

    protected int zzaW(zziv zzivVar) {
        return 0;
    }

    protected boolean zzaX(zziv zzivVar) {
        return false;
    }

    protected final long zzaY() {
        return this.zzai;
    }

    protected void zzaZ(long j) {
        this.zzai = j;
        while (true) {
            ArrayDeque arrayDeque = this.zzl;
            if (arrayDeque.isEmpty() || j < ((zzvs) arrayDeque.peek()).zzb) {
                return;
            }
            zzvs zzvsVar = (zzvs) arrayDeque.poll();
            zzvsVar.getClass();
            zzbs(zzvsVar);
            zzar();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public boolean zzaa() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public boolean zzab() {
        return this.zzaf;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final int zzad(zzv zzvVar) throws zzjk {
        try {
            return zzae(this.zze, zzvVar);
        } catch (zzvx e) {
            throw zzP(e, zzvVar, false, PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED);
        }
    }

    protected abstract int zzae(zzvv zzvvVar, zzv zzvVar) throws zzvx;

    protected abstract List zzaf(zzvv zzvvVar, zzv zzvVar, boolean z) throws zzvx;

    protected boolean zzag(zzv zzvVar) {
        return false;
    }

    protected abstract zzvg zzah(zzvm zzvmVar, zzv zzvVar, MediaCrypto mediaCrypto, float f);

    protected zzjc zzai(zzvm zzvmVar, zzv zzvVar, zzv zzvVar2) {
        throw null;
    }

    protected long zzaj(long j, long j2, boolean z) {
        return super.zzV(j, j2);
    }

    protected float zzak(float f, zzv zzvVar, zzv[] zzvVarArr) {
        throw null;
    }

    protected void zzal(String str, zzvg zzvgVar, long j, long j2) {
        throw null;
    }

    protected void zzam(String str) {
        throw null;
    }

    protected void zzan(Exception exc) {
        throw null;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d4  */
    protected zzjc zzao(zzlw zzlwVar) throws zzjk {
        int i;
        boolean z = true;
        this.zzag = true;
        zzv zzvVarZzO = zzlwVar.zzb;
        zzvVarZzO.getClass();
        String str = zzvVarZzO.zzp;
        if (str == null) {
            throw zzP(new IllegalArgumentException("Sample MIME type is null."), zzvVarZzO, false, PlaybackException.ERROR_CODE_DECODING_FORMAT_UNSUPPORTED);
        }
        if ((Objects.equals(str, MimeTypes.VIDEO_AV1) || Objects.equals(str, MimeTypes.VIDEO_VP9) || (Objects.equals(str, MimeTypes.VIDEO_DOLBY_VISION) && Objects.equals(zzwf.zzg(zzvVarZzO), MimeTypes.VIDEO_AV1))) && !zzvVarZzO.zzs.isEmpty()) {
            zzt zztVarZza = zzvVarZzO.zza();
            zztVarZza.zzr(null);
            zzvVarZzO = zztVarZza.zzO();
        }
        zzv zzvVar = zzvVarZzO;
        this.zzr = zzlwVar.zza;
        this.zzo = zzvVar;
        if (this.zzT) {
            this.zzV = true;
            return null;
        }
        zzvj zzvjVar = this.zzx;
        if (zzvjVar == null) {
            this.zzC = null;
            zzaE();
            return null;
        }
        zzvm zzvmVar = this.zzE;
        zzvmVar.getClass();
        zzv zzvVar2 = this.zzy;
        zzvVar2.getClass();
        zzug zzugVar = this.zzq;
        zzug zzugVar2 = this.zzr;
        if (zzugVar != zzugVar2) {
            zzbq();
            return new zzjc(zzvmVar.zza, zzvVar2, zzvVar, 0, 128);
        }
        zzjc zzjcVarZzai = zzai(zzvmVar, zzvVar2, zzvVar);
        int i2 = zzjcVarZzai.zzd;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (zzbo(zzvVar)) {
                        this.zzy = zzvVar;
                        if (zzugVar2 != zzugVar && !zzbp()) {
                            i = 2;
                        }
                    } else {
                        i = 16;
                    }
                } else if (zzbo(zzvVar)) {
                    this.zzW = true;
                    this.zzX = 1;
                    int i3 = this.zzF;
                    if (i3 != 2 && (i3 != 1 || zzvVar.zzw != zzvVar2.zzw || zzvVar.zzx != zzvVar2.zzx)) {
                        z = false;
                    }
                    this.zzI = z;
                    this.zzy = zzvVar;
                    if (zzugVar2 != zzugVar && !zzbp()) {
                        i = 2;
                    }
                } else {
                    i = 16;
                }
            } else if (zzbo(zzvVar)) {
                this.zzy = zzvVar;
                if (zzugVar2 != zzugVar) {
                    if (!zzbp()) {
                        i = 2;
                    }
                } else if (this.zzaa) {
                    this.zzY = 1;
                    if (this.zzH) {
                        this.zzZ = 3;
                        i = 2;
                    } else {
                        this.zzZ = 1;
                    }
                }
            } else {
                i = 16;
            }
            return (i2 != 0 || (this.zzx == zzvjVar && this.zzZ != 3)) ? zzjcVarZzai : new zzjc(zzvmVar.zza, zzvVar2, zzvVar, 0, i);
        }
        zzbq();
        i = 0;
        if (i2 != 0) {
        }
    }

    protected void zzap(zzv zzvVar, MediaFormat mediaFormat) throws zzjk {
        throw null;
    }

    protected void zzar() {
    }

    protected abstract boolean zzas(long j, long j2, zzvj zzvjVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzv zzvVar) throws zzjk;

    protected abstract void zzat(zziz zzizVar);

    protected void zzau() throws zzjk {
        throw null;
    }

    protected void zzav(zziv zzivVar) throws zzjk {
        throw null;
    }

    protected final boolean zzba() {
        if (this.zzo == null) {
            return false;
        }
        if (zzS() || zzaC()) {
            return true;
        }
        return this.zzN != C.TIME_UNSET && zzM().zzb() < this.zzN;
    }

    protected final float zzbb() {
        return this.zzv;
    }

    protected final zzmz zzbc() {
        return this.zzs;
    }

    protected final boolean zzbd() throws zzjk {
        return zzbo(this.zzy);
    }

    protected final long zzbe() {
        return this.zzah.zzf;
    }

    protected final long zzbf() {
        return this.zzad;
    }

    protected final long zzbg() {
        return this.zzah.zzd;
    }

    protected final long zzbh() {
        return this.zzah.zzc;
    }

    protected final void zzbi(MediaFormat mediaFormat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.zzan.zzb(mediaFormat);
        }
    }

    final /* synthetic */ void zzbk(zzlw zzlwVar) {
        this.zzn.set(zzQ(zzlwVar, this.zzh, 0));
    }

    final /* synthetic */ zzmz zzbl() {
        return this.zzs;
    }

    @Override // com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zznc
    public final int zzu() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzmv
    public void zzx(int i, Object obj) throws zzjk {
        if (i != 11) {
            return;
        }
        zzmz zzmzVar = (zzmz) obj;
        zzmzVar.getClass();
        this.zzs = zzmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected void zzy(boolean z, boolean z2) throws zzjk {
        this.zza = new zzjb();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r4 >= r0) goto L16;
     */
    @Override // com.google.android.gms.internal.ads.zzix
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void zzz(com.google.android.gms.internal.ads.zzv[] r12, long r13, long r15, com.google.android.gms.internal.ads.zzxk r17) throws com.google.android.gms.internal.ads.zzjk {
        /*
            r11 = this;
            com.google.android.gms.internal.ads.zzvs r12 = r11.zzah
            long r0 = r12.zzd
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r12 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r12 != 0) goto L24
            com.google.android.gms.internal.ads.zzvs r4 = new com.google.android.gms.internal.ads.zzvs
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.zzbs(r4)
            boolean r12 = r11.zzak
            if (r12 == 0) goto L56
            r11.zzar()
            return
        L24:
            java.util.ArrayDeque r12 = r11.zzl
            boolean r0 = r12.isEmpty()
            if (r0 == 0) goto L57
            long r0 = r11.zzad
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L3c
            long r4 = r11.zzai
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 == 0) goto L57
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 < 0) goto L57
        L3c:
            com.google.android.gms.internal.ads.zzvs r4 = new com.google.android.gms.internal.ads.zzvs
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = r13
            r9 = r15
            r4.<init>(r5, r7, r9)
            r11.zzbs(r4)
            com.google.android.gms.internal.ads.zzvs r12 = r11.zzah
            long r12 = r12.zzd
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 == 0) goto L56
            r11.zzar()
        L56:
            return
        L57:
            com.google.android.gms.internal.ads.zzvs r0 = new com.google.android.gms.internal.ads.zzvs
            long r1 = r11.zzad
            r3 = r13
            r5 = r15
            r0.<init>(r1, r3, r5)
            r12.add(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvt.zzz(com.google.android.gms.internal.ads.zzv[], long, long, com.google.android.gms.internal.ads.zzxk):void");
    }

    private final void zzbu() throws zzjk {
        zzug zzugVar = this.zzr;
        zzugVar.getClass();
        this.zzq = zzugVar;
        this.zzY = 0;
        this.zzZ = 0;
    }

    private final void zzbr() throws zzjk {
        int i = this.zzZ;
        if (i == 1) {
            zzay();
            return;
        }
        if (i == 2) {
            zzay();
            zzbu();
        } else if (i != 3) {
            this.zzaf = true;
            zzau();
        } else {
            zzaM();
            zzaE();
        }
    }
}
