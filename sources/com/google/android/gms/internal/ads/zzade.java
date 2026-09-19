package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.util.Pair;
import android.view.Surface;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import com.google.android.gms.common.Scopes;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.PriorityQueue;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzade extends zzvt implements zzadt {
    private static final int[] zzb = {1920, Videoio.CAP_OPENNI2, 1440, 1280, 960, 854, Imgcodecs.IMWRITE_JPEGXL_QUALITY, Videoio.CAP_PROP_XI_BUFFER_POLICY, Videoio.CAP_PROP_XI_CC_MATRIX_01};
    private static boolean zzc;
    private static boolean zzd;
    private int zzA;
    private long zzB;
    private int zzC;
    private int zzD;
    private int zzE;
    private zznh zzF;
    private long zzG;
    private boolean zzH;
    private long zzI;
    private int zzJ;
    private long zzK;
    private zzbv zzL;
    private zzbv zzM;
    private int zzN;
    private int zzO;
    private zzadr zzP;
    private long zzQ;
    private long zzR;
    private boolean zzS;
    private int zzT;
    private final Context zze;
    private final boolean zzf;
    private final zzaeo zzg;
    private final boolean zzh;
    private final zzadu zzi;
    private final zzads zzj;
    private final zzacn zzk;
    private final long zzl;
    private final zzadv zzm;
    private final PriorityQueue zzn;
    private zzadd zzo;
    private boolean zzp;
    private boolean zzq;
    private zzaeu zzr;
    private boolean zzs;
    private int zzt;
    private List zzu;
    private Surface zzv;
    private zzadg zzw;
    private zzeu zzx;
    private boolean zzy;
    private int zzz;

    protected zzade(zzadc zzadcVar) {
        super(zzadcVar.zze().getApplicationContext(), 2, zzadcVar.zzg(), zzadcVar.zzf(), false, 30.0f);
        Context applicationContext = zzadcVar.zze().getApplicationContext();
        this.zze = applicationContext;
        this.zzr = null;
        this.zzg = new zzaeo(zzadcVar.zzh(), zzadcVar.zzi());
        this.zzf = this.zzr == null;
        this.zzi = new zzadu(applicationContext, this, 0L);
        this.zzj = new zzads();
        this.zzh = "NVIDIA".equals(Build.MANUFACTURER);
        this.zzx = zzeu.zza;
        this.zzz = 1;
        this.zzA = 0;
        this.zzL = zzbv.zza;
        this.zzO = 0;
        this.zzM = null;
        this.zzN = -1000;
        this.zzQ = C.TIME_UNSET;
        this.zzR = C.TIME_UNSET;
        this.zzk = new zzacn();
        this.zzn = new PriorityQueue();
        this.zzl = -15000L;
        this.zzm = new zzadv(1.0f);
        this.zzF = null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:21:0x0042  */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if (r3.equals(androidx.media3.common.MimeTypes.VIDEO_VP8) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a9, code lost:
    
        if (r3.equals(androidx.media3.common.MimeTypes.VIDEO_MP4V) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c1, code lost:
    
        if (r3.equals(androidx.media3.common.MimeTypes.VIDEO_AV1) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ca, code lost:
    
        if (r3.equals(androidx.media3.common.MimeTypes.VIDEO_H263) != false) goto L57;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int zzaw(com.google.android.gms.internal.ads.zzvm r8, com.google.android.gms.internal.ads.zzv r9) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzade.zzaw(com.google.android.gms.internal.ads.zzvm, com.google.android.gms.internal.ads.zzv):int");
    }

    private final void zzbA() {
        zzadg zzadgVar = this.zzw;
        if (zzadgVar != null) {
            zzadgVar.release();
            this.zzw = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresNonNull({"displaySurface"})
    /* JADX INFO: renamed from: zzbB, reason: merged with bridge method [inline-methods] */
    public final void zzbo() {
        this.zzg.zzg(this.zzv);
        this.zzy = true;
    }

    private final void zzbC() {
        zzbv zzbvVar = this.zzM;
        if (zzbvVar != null) {
            this.zzg.zzf(zzbvVar);
        }
    }

    protected static int zzbm(zzvm zzvmVar, zzv zzvVar) {
        int i = zzvVar.zzq;
        if (i == -1) {
            return zzaw(zzvmVar, zzvVar);
        }
        List list = zzvVar.zzs;
        int size = list.size();
        int length = 0;
        for (int i2 = 0; i2 < size; i2++) {
            length += ((byte[]) list.get(i2)).length;
        }
        return i + length;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x0131  */
    /* JADX WARN: Code duplicated, block: B:103:0x013b  */
    /* JADX WARN: Code duplicated, block: B:106:0x0145  */
    /* JADX WARN: Code duplicated, block: B:109:0x014f  */
    /* JADX WARN: Code duplicated, block: B:112:0x0159  */
    /* JADX WARN: Code duplicated, block: B:115:0x0163  */
    /* JADX WARN: Code duplicated, block: B:118:0x016d  */
    /* JADX WARN: Code duplicated, block: B:121:0x0177  */
    /* JADX WARN: Code duplicated, block: B:124:0x0181  */
    /* JADX WARN: Code duplicated, block: B:127:0x018b  */
    /* JADX WARN: Code duplicated, block: B:130:0x0195  */
    /* JADX WARN: Code duplicated, block: B:133:0x019f  */
    /* JADX WARN: Code duplicated, block: B:136:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:148:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:151:0x01db  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:157:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:160:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:163:0x0203  */
    /* JADX WARN: Code duplicated, block: B:166:0x020d  */
    /* JADX WARN: Code duplicated, block: B:169:0x0217  */
    /* JADX WARN: Code duplicated, block: B:172:0x0221  */
    /* JADX WARN: Code duplicated, block: B:175:0x022b  */
    /* JADX WARN: Code duplicated, block: B:178:0x0235  */
    /* JADX WARN: Code duplicated, block: B:181:0x023f  */
    /* JADX WARN: Code duplicated, block: B:184:0x0249  */
    /* JADX WARN: Code duplicated, block: B:187:0x0253  */
    /* JADX WARN: Code duplicated, block: B:190:0x025d  */
    /* JADX WARN: Code duplicated, block: B:193:0x0267  */
    /* JADX WARN: Code duplicated, block: B:196:0x0271  */
    /* JADX WARN: Code duplicated, block: B:199:0x027b  */
    /* JADX WARN: Code duplicated, block: B:202:0x0285  */
    /* JADX WARN: Code duplicated, block: B:205:0x028f  */
    /* JADX WARN: Code duplicated, block: B:208:0x0299  */
    /* JADX WARN: Code duplicated, block: B:211:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:214:0x02ad  */
    /* JADX WARN: Code duplicated, block: B:217:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:220:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:223:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:226:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:229:0x02df  */
    /* JADX WARN: Code duplicated, block: B:232:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:235:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:238:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:241:0x0307  */
    /* JADX WARN: Code duplicated, block: B:244:0x0311  */
    /* JADX WARN: Code duplicated, block: B:247:0x031b  */
    /* JADX WARN: Code duplicated, block: B:250:0x0325  */
    /* JADX WARN: Code duplicated, block: B:253:0x032f  */
    /* JADX WARN: Code duplicated, block: B:256:0x0339  */
    /* JADX WARN: Code duplicated, block: B:259:0x0343  */
    /* JADX WARN: Code duplicated, block: B:262:0x034d  */
    /* JADX WARN: Code duplicated, block: B:265:0x0357  */
    /* JADX WARN: Code duplicated, block: B:268:0x0361  */
    /* JADX WARN: Code duplicated, block: B:271:0x036b  */
    /* JADX WARN: Code duplicated, block: B:274:0x0375  */
    /* JADX WARN: Code duplicated, block: B:277:0x037f  */
    /* JADX WARN: Code duplicated, block: B:280:0x0389  */
    /* JADX WARN: Code duplicated, block: B:283:0x0393  */
    /* JADX WARN: Code duplicated, block: B:286:0x039d  */
    /* JADX WARN: Code duplicated, block: B:289:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:292:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:295:0x03bb  */
    /* JADX WARN: Code duplicated, block: B:298:0x03c5  */
    /* JADX WARN: Code duplicated, block: B:301:0x03cf  */
    /* JADX WARN: Code duplicated, block: B:304:0x03d9  */
    /* JADX WARN: Code duplicated, block: B:307:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:310:0x03ed  */
    /* JADX WARN: Code duplicated, block: B:313:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:316:0x0401  */
    /* JADX WARN: Code duplicated, block: B:319:0x040b  */
    /* JADX WARN: Code duplicated, block: B:322:0x0415  */
    /* JADX WARN: Code duplicated, block: B:325:0x041f  */
    /* JADX WARN: Code duplicated, block: B:328:0x0429  */
    /* JADX WARN: Code duplicated, block: B:331:0x0433  */
    /* JADX WARN: Code duplicated, block: B:334:0x043d  */
    /* JADX WARN: Code duplicated, block: B:337:0x0447  */
    /* JADX WARN: Code duplicated, block: B:340:0x0451  */
    /* JADX WARN: Code duplicated, block: B:343:0x045b  */
    /* JADX WARN: Code duplicated, block: B:346:0x0465  */
    /* JADX WARN: Code duplicated, block: B:349:0x046f  */
    /* JADX WARN: Code duplicated, block: B:352:0x0479  */
    /* JADX WARN: Code duplicated, block: B:355:0x0483  */
    /* JADX WARN: Code duplicated, block: B:358:0x048d  */
    /* JADX WARN: Code duplicated, block: B:361:0x0497  */
    /* JADX WARN: Code duplicated, block: B:364:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:367:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:370:0x04b5  */
    /* JADX WARN: Code duplicated, block: B:373:0x04bf  */
    /* JADX WARN: Code duplicated, block: B:376:0x04c9  */
    /* JADX WARN: Code duplicated, block: B:379:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:382:0x04dd  */
    /* JADX WARN: Code duplicated, block: B:385:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:388:0x04f1  */
    /* JADX WARN: Code duplicated, block: B:38:0x006b  */
    /* JADX WARN: Code duplicated, block: B:391:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:394:0x0505  */
    /* JADX WARN: Code duplicated, block: B:397:0x050f  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e A[Catch: all -> 0x0677, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x000d, B:507:0x0673, B:10:0x0013, B:12:0x001a, B:506:0x066f, B:39:0x006e, B:41:0x0074, B:44:0x007f, B:74:0x00da, B:76:0x00e0, B:499:0x0659), top: B:513:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:400:0x0519  */
    /* JADX WARN: Code duplicated, block: B:403:0x0523  */
    /* JADX WARN: Code duplicated, block: B:406:0x052d  */
    /* JADX WARN: Code duplicated, block: B:409:0x0537  */
    /* JADX WARN: Code duplicated, block: B:412:0x0541  */
    /* JADX WARN: Code duplicated, block: B:415:0x054b  */
    /* JADX WARN: Code duplicated, block: B:418:0x0555  */
    /* JADX WARN: Code duplicated, block: B:41:0x0074 A[Catch: all -> 0x0677, TryCatch #0 {, blocks: (B:7:0x000d, B:507:0x0673, B:10:0x0013, B:12:0x001a, B:506:0x066f, B:39:0x006e, B:41:0x0074, B:44:0x007f, B:74:0x00da, B:76:0x00e0, B:499:0x0659), top: B:513:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:421:0x055f  */
    /* JADX WARN: Code duplicated, block: B:424:0x0569  */
    /* JADX WARN: Code duplicated, block: B:427:0x0573  */
    /* JADX WARN: Code duplicated, block: B:430:0x057d  */
    /* JADX WARN: Code duplicated, block: B:433:0x0587  */
    /* JADX WARN: Code duplicated, block: B:436:0x0591  */
    /* JADX WARN: Code duplicated, block: B:439:0x059b  */
    /* JADX WARN: Code duplicated, block: B:442:0x05a5  */
    /* JADX WARN: Code duplicated, block: B:445:0x05af  */
    /* JADX WARN: Code duplicated, block: B:448:0x05b9  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f A[Catch: all -> 0x0677, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000d, B:507:0x0673, B:10:0x0013, B:12:0x001a, B:506:0x066f, B:39:0x006e, B:41:0x0074, B:44:0x007f, B:74:0x00da, B:76:0x00e0, B:499:0x0659), top: B:513:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:451:0x05c3  */
    /* JADX WARN: Code duplicated, block: B:454:0x05cd  */
    /* JADX WARN: Code duplicated, block: B:457:0x05d7  */
    /* JADX WARN: Code duplicated, block: B:460:0x05e1  */
    /* JADX WARN: Code duplicated, block: B:463:0x05eb  */
    /* JADX WARN: Code duplicated, block: B:466:0x05f5  */
    /* JADX WARN: Code duplicated, block: B:469:0x05fe  */
    /* JADX WARN: Code duplicated, block: B:472:0x0607  */
    /* JADX WARN: Code duplicated, block: B:475:0x0610  */
    /* JADX WARN: Code duplicated, block: B:478:0x0619  */
    /* JADX WARN: Code duplicated, block: B:47:0x0089  */
    /* JADX WARN: Code duplicated, block: B:481:0x0622  */
    /* JADX WARN: Code duplicated, block: B:484:0x062b  */
    /* JADX WARN: Code duplicated, block: B:487:0x0634  */
    /* JADX WARN: Code duplicated, block: B:490:0x063d  */
    /* JADX WARN: Code duplicated, block: B:493:0x0646  */
    /* JADX WARN: Code duplicated, block: B:496:0x064f  */
    /* JADX WARN: Code duplicated, block: B:499:0x0659 A[Catch: all -> 0x0677, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000d, B:507:0x0673, B:10:0x0013, B:12:0x001a, B:506:0x066f, B:39:0x006e, B:41:0x0074, B:44:0x007f, B:74:0x00da, B:76:0x00e0, B:499:0x0659), top: B:513:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:503:0x0665  */
    /* JADX WARN: Code duplicated, block: B:50:0x0092  */
    /* JADX WARN: Code duplicated, block: B:53:0x009b  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da A[Catch: all -> 0x0677, TRY_ENTER, TryCatch #0 {, blocks: (B:7:0x000d, B:507:0x0673, B:10:0x0013, B:12:0x001a, B:506:0x066f, B:39:0x006e, B:41:0x0074, B:44:0x007f, B:74:0x00da, B:76:0x00e0, B:499:0x0659), top: B:513:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:76:0x00e0 A[Catch: all -> 0x0677, TRY_LEAVE, TryCatch #0 {, blocks: (B:7:0x000d, B:507:0x0673, B:10:0x0013, B:12:0x001a, B:506:0x066f, B:39:0x006e, B:41:0x0074, B:44:0x007f, B:74:0x00da, B:76:0x00e0, B:499:0x0659), top: B:513:0x000d }] */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:88:0x0109  */
    /* JADX WARN: Code duplicated, block: B:91:0x0113  */
    /* JADX WARN: Code duplicated, block: B:94:0x011d  */
    /* JADX WARN: Code duplicated, block: B:97:0x0127  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:322:0x0415
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    protected static final boolean zzbq(java.lang.String r5) {
        /*
            Method dump skipped, instruction units count: 2292
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzade.zzbq(java.lang.String):boolean");
    }

    protected static final boolean zzbr(zzvm zzvmVar) {
        return Build.VERSION.SDK_INT >= 35 && zzvmVar.zzh;
    }

    private static List zzbs(Context context, zzvv zzvvVar, zzv zzvVar, boolean z, boolean z2) throws zzvx {
        String str = zzvVar.zzp;
        if (str == null) {
            return zzgwm.zzi();
        }
        if (Build.VERSION.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(str) && !zzadb.zza(context)) {
            List listZzd = zzwf.zzd(zzvvVar, zzvVar, z, z2);
            if (!listZzd.isEmpty()) {
                return listZzd;
            }
        }
        return zzwf.zzc(zzvvVar, zzvVar, z, z2);
    }

    private final void zzbt(zzxk zzxkVar) {
        int iZze;
        zzbf zzbfVarZzN = zzN();
        if (zzbfVarZzN.zzg() || (iZze = zzbfVarZzN.zze(zzxkVar.zza)) == -1) {
            this.zzR = C.TIME_UNSET;
        } else {
            this.zzR = zzbfVarZzN.zzd(iZze, new zzbd(), false).zzd;
        }
    }

    private final void zzbu(Object obj) throws zzjk {
        Surface surface = obj instanceof Surface ? (Surface) obj : null;
        if (this.zzv == surface) {
            if (surface != null) {
                zzbC();
                Surface surface2 = this.zzv;
                if (surface2 == null || !this.zzy) {
                    return;
                }
                this.zzg.zzg(surface2);
                return;
            }
            return;
        }
        this.zzv = surface;
        if (this.zzr == null) {
            this.zzi.zzd(surface);
        }
        this.zzy = false;
        int iZze = zze();
        zzvj zzvjVarZzaI = zzaI();
        if (zzvjVarZzaI != null && this.zzr == null) {
            zzvm zzvmVarZzaL = zzaL();
            zzvmVarZzaL.getClass();
            if (!zzby(zzvmVarZzaL) || this.zzp) {
                zzaM();
                zzaE();
            } else {
                Surface surfaceZzbz = zzbz(zzvmVarZzaL);
                if (surfaceZzbz != null) {
                    zzvjVarZzaI.zzn(surfaceZzbz);
                } else {
                    if (Build.VERSION.SDK_INT < 35) {
                        throw new IllegalStateException();
                    }
                    zzvjVarZzaI.zzo();
                }
            }
        }
        if (surface != null) {
            zzbC();
        } else {
            this.zzM = null;
            zzaeu zzaeuVar = this.zzr;
            if (zzaeuVar != null) {
                zzaeuVar.zzq();
            }
        }
        if (iZze == 2) {
            zzaeu zzaeuVar2 = this.zzr;
            if (zzaeuVar2 != null) {
                zzaeuVar2.zzw(true);
            } else {
                this.zzi.zzj(true);
            }
        }
    }

    private final boolean zzbv(zziv zzivVar) {
        if (zzcW() || zzivVar.zzd() || this.zzR == C.TIME_UNSET) {
            return true;
        }
        return this.zzR - (zzivVar.zze - zzbg()) <= SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    private final boolean zzbw(zziv zzivVar) {
        return zzivVar.zze < zzH();
    }

    private final void zzbx(long j, long j2, zzv zzvVar) {
        zzadr zzadrVar = this.zzP;
        if (zzadrVar != null) {
            zzadrVar.zzcS(j, j2, zzvVar, zzaK());
        }
    }

    private final boolean zzby(zzvm zzvmVar) {
        if (this.zzr != null) {
            return true;
        }
        Surface surface = this.zzv;
        return (surface != null && surface.isValid()) || zzbr(zzvmVar) || zzaC(zzvmVar);
    }

    private final Surface zzbz(zzvm zzvmVar) {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            return zzaeuVar.zzk();
        }
        Surface surface = this.zzv;
        if (surface != null) {
            return surface;
        }
        if (zzbr(zzvmVar)) {
            return null;
        }
        zzgtj.zzi(zzaC(zzvmVar));
        zzadg zzadgVar = this.zzw;
        if (zzadgVar != null) {
            if (zzadgVar.zza != zzvmVar.zzf) {
                zzbA();
            }
        }
        if (this.zzw == null) {
            this.zzw = zzadg.zzb(this.zze, zzvmVar.zzf);
        }
        return this.zzw;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzA(long j, boolean z, boolean z2) throws zzjk {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null && !z) {
            zzaeuVar.zzg(true);
        }
        if (z2) {
            this.zzG = j;
        }
        super.zzA(j, z, z2);
        if (this.zzr == null) {
            this.zzi.zzl();
        }
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
        if (z) {
            zzaeu zzaeuVar2 = this.zzr;
            if (zzaeuVar2 != null) {
                zzaeuVar2.zzw(false);
            } else {
                this.zzi.zzj(false);
            }
        }
        this.zzD = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzB() {
        this.zzC = 0;
        this.zzB = zzM().zzb();
        this.zzI = 0L;
        this.zzJ = 0;
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zza();
        } else {
            this.zzi.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzC() {
        if (this.zzC > 0) {
            long jZzb = zzM().zzb();
            this.zzg.zzd(this.zzC, jZzb - this.zzB);
            this.zzC = 0;
            this.zzB = jZzb;
        }
        int i = this.zzJ;
        if (i != 0) {
            this.zzg.zze(this.zzI, i);
            this.zzI = 0L;
            this.zzJ = 0;
        }
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzb();
        } else {
            this.zzi.zzc();
        }
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzD() {
        this.zzM = null;
        this.zzR = C.TIME_UNSET;
        this.zzy = false;
        this.zzH = true;
        try {
            super.zzD();
        } finally {
            zzaeo zzaeoVar = this.zzg;
            zzaeoVar.zzi(this.zza);
            zzaeoVar.zzf(zzbv.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzE() {
        try {
            super.zzE();
        } finally {
            this.zzs = false;
            this.zzQ = C.TIME_UNSET;
            zzbA();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzF() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null || !this.zzf) {
            return;
        }
        zzaeuVar.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzix
    protected final void zzG(zzbf zzbfVar) {
        zzxk zzxkVarZzO = zzO();
        if (zzxkVarZzO != null) {
            zzbt(zzxkVarZzO);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna, com.google.android.gms.internal.ads.zznc
    public final String zzU() {
        return "MediaCodecVideoRenderer";
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final boolean zzW(long j) {
        if (zzbf() == C.TIME_UNSET || j < this.zzG) {
            return false;
        }
        long jZzaY = zzaY();
        return jZzaY == C.TIME_UNSET || j > jZzaY;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final void zzX(float f, float f2) throws zzjk {
        super.zzX(f, f2);
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzm(f);
        } else {
            this.zzi.zzn(f);
        }
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzc(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zzY() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null) {
            this.zzi.zzh();
            return;
        }
        int i = this.zzt;
        if (i == 0 || i == 1) {
            this.zzt = 0;
        } else {
            zzaeuVar.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final void zzZ(long j, long j2) throws Throwable {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            try {
                zzaeuVar.zzv(j, j2);
            } catch (zzaet e) {
                throw zzP(e, e.zza, false, PlaybackException.ERROR_CODE_VIDEO_FRAME_PROCESSING_FAILED);
            }
        }
        super.zzZ(j, j2);
    }

    protected final void zzaA(long j) {
        zzjb zzjbVar = this.zza;
        zzjbVar.zzk += j;
        zzjbVar.zzl++;
        this.zzI += j;
        this.zzJ++;
    }

    protected final void zzaB(zzvj zzvjVar, int i, long j, long j2) {
        Trace.beginSection("releaseOutputBuffer");
        zzvjVar.zzd(i, j2);
        Trace.endSection();
        this.zza.zze++;
        this.zzD = 0;
        if (this.zzr == null) {
            zzbv zzbvVar = this.zzL;
            if (!zzbvVar.equals(zzbv.zza) && !zzbvVar.equals(this.zzM)) {
                this.zzM = zzbvVar;
                this.zzg.zzf(zzbvVar);
            }
            if (!this.zzi.zzf() || this.zzv == null) {
                return;
            }
            zzbo();
        }
    }

    protected final boolean zzaC(zzvm zzvmVar) {
        if (zzbq(zzvmVar.zza)) {
            return false;
        }
        return !zzvmVar.zzf || zzadg.zza(this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzaG(zzvm zzvmVar) {
        return zzby(zzvmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzaO() {
        zzvm zzvmVarZzaL = zzaL();
        if (this.zzr != null && zzvmVarZzaL != null) {
            String str = zzvmVarZzaL.zza;
            if (str.equals("c2.mtk.avc.decoder") || str.equals("c2.mtk.hevc.decoder")) {
                return true;
            }
        }
        return super.zzaO();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002d  */
    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzaP() {
        boolean z;
        zzv zzvVarZzaJ = zzaJ();
        long j = this.zzR;
        if (j != C.TIME_UNSET) {
            if (zzaQ() + j + 1 > Long.MAX_VALUE - (zzbg() + this.zzR)) {
                z = true;
            } else {
                z = false;
            }
        } else {
            z = true;
        }
        return this.zzF == null || this.zzH || (zzvVarZzaJ != null && zzvVarZzaJ.zzr > 0) || z || zzbe() != C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzaR() {
        super.zzaR();
        this.zzn.clear();
        this.zzE = 0;
        this.zzT = 0;
        this.zzH = false;
        zzacn zzacnVar = this.zzk;
        if (zzacnVar != null) {
            zzacnVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzvl zzaT(Throwable th, zzvm zzvmVar) {
        return new zzacy(th, zzvmVar, this.zzv);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzaU(zzv zzvVar) throws zzjk {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null || zzaeuVar.zze()) {
            return true;
        }
        try {
            zzaeuVar.zzd(zzvVar);
            return true;
        } catch (zzaet e) {
            throw zzP(e, zzvVar, false, 7000);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzaV(zziv zzivVar) throws zzjk {
        ByteBuffer byteBuffer;
        zzacn zzacnVar = this.zzk;
        if (zzacnVar != null) {
            zzvm zzvmVarZzaL = zzaL();
            zzvmVarZzaL.getClass();
            if (zzvmVarZzaL.zzb.equals(MimeTypes.VIDEO_AV1) && zzivVar.zzc() && (byteBuffer = zzivVar.zzc) != null) {
                zzacnVar.zzb(byteBuffer);
            }
        }
        this.zzT = 0;
        int iZzaW = zzaW(zzivVar);
        if (Build.VERSION.SDK_INT < 34 || (iZzaW & 32) == 0) {
            this.zzE++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final int zzaW(zziv zzivVar) {
        return (Build.VERSION.SDK_INT < 34 || this.zzF == null || !zzbw(zzivVar) || zzbv(zzivVar)) ? 0 : 32;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0028  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ac  */
    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzaX(zziv zzivVar) {
        boolean z;
        ByteBuffer byteBuffer;
        boolean z2 = false;
        if (zzbv(zzivVar)) {
            return false;
        }
        boolean zZzbw = zzbw(zzivVar);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            long jZzb = zzadvVar.zzb(zzivVar.zze);
            if (jZzb == C.TIME_UNSET || jZzb >= this.zzl) {
                z = false;
            } else {
                z = true;
            }
        } else {
            z = false;
        }
        if ((!zZzbw && !z) || zzivVar.zze()) {
            return false;
        }
        if (!zzivVar.zzf()) {
            zzacn zzacnVar = this.zzk;
            if (zzacnVar != null) {
                zzvm zzvmVarZzaL = zzaL();
                zzvmVarZzaL.getClass();
                if (zzvmVarZzaL.zzb.equals(MimeTypes.VIDEO_AV1) && (byteBuffer = zzivVar.zzc) != null) {
                    boolean z3 = zZzbw || this.zzT <= 0;
                    ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                    byteBufferAsReadOnlyBuffer.flip();
                    int iZza = zzacnVar.zza(byteBufferAsReadOnlyBuffer, z3);
                    if (iZza == 0) {
                        zzivVar.zza();
                    } else if (iZza != byteBufferAsReadOnlyBuffer.limit()) {
                        zzadd zzaddVar = this.zzo;
                        zzaddVar.getClass();
                        if (zzaddVar.zzc + iZza < byteBufferAsReadOnlyBuffer.capacity() && !zzivVar.zzk()) {
                            ByteBuffer byteBuffer2 = zzivVar.zzc;
                            byteBuffer2.getClass();
                            byteBuffer2.position(iZza);
                        }
                    }
                }
            }
            if (z2) {
                if (zZzbw) {
                    this.zza.zzd++;
                    return z2;
                }
                this.zzn.add(Long.valueOf(zzivVar.zze));
                this.zzT++;
            }
            return z2;
        }
        zzivVar.zza();
        z2 = true;
        if (z2) {
            if (zZzbw) {
                this.zza.zzd++;
                return z2;
            }
            this.zzn.add(Long.valueOf(zzivVar.zze));
            this.zzT++;
        }
        return z2;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzaZ(long j) {
        super.zzaZ(j);
        this.zzE--;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final boolean zzaa() {
        boolean zZzba = zzba();
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            return zzaeuVar.zzh(zZzba);
        }
        if (zZzba && zzaI() == null) {
            return true;
        }
        return this.zzi.zzi(zZzba);
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzna
    public final boolean zzab() {
        if (!super.zzab()) {
            return false;
        }
        zzaeu zzaeuVar = this.zzr;
        return zzaeuVar == null || zzaeuVar.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final int zzae(zzvv zzvvVar, zzv zzvVar) throws zzvx {
        boolean z;
        String str = zzvVar.zzp;
        if (!zzas.zzb(str)) {
            return 128;
        }
        Context context = this.zze;
        int i = 0;
        boolean z2 = zzvVar.zzt != null;
        List listZzbs = zzbs(context, zzvvVar, zzvVar, z2, false);
        if (z2 && listZzbs.isEmpty()) {
            listZzbs = zzbs(context, zzvvVar, zzvVar, false, false);
        }
        if (listZzbs.isEmpty()) {
            return 129;
        }
        if (!zzbj(zzvVar)) {
            return 130;
        }
        zzvm zzvmVar = (zzvm) listZzbs.get(0);
        boolean zZzc = zzvmVar.zzc(context, zzvVar);
        if (!zZzc) {
            int i2 = 1;
            while (true) {
                if (i2 >= listZzbs.size()) {
                    z = true;
                    break;
                }
                zzvm zzvmVar2 = (zzvm) listZzbs.get(i2);
                if (zzvmVar2.zzc(context, zzvVar)) {
                    zZzc = true;
                    z = false;
                    zzvmVar = zzvmVar2;
                    break;
                }
                i2++;
            }
        } else {
            z = true;
            break;
        }
        int i3 = true != zZzc ? 3 : 4;
        int i4 = true != zzvmVar.zze(zzvVar) ? 8 : 16;
        int i5 = true != zzvmVar.zzg ? 0 : 64;
        int i6 = true != z ? 0 : 128;
        if (Build.VERSION.SDK_INT >= 26 && MimeTypes.VIDEO_DOLBY_VISION.equals(str) && !zzadb.zza(context)) {
            i6 = 256;
        }
        if (zZzc) {
            List listZzbs2 = zzbs(context, zzvvVar, zzvVar, z2, true);
            if (!listZzbs2.isEmpty()) {
                zzvm zzvmVar3 = (zzvm) zzwf.zze(context, listZzbs2, zzvVar).get(0);
                if (zzvmVar3.zzc(context, zzvVar) && zzvmVar3.zze(zzvVar)) {
                    i = 32;
                }
            }
        }
        return i3 | i4 | i | i5 | i6;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final List zzaf(zzvv zzvvVar, zzv zzvVar, boolean z) throws zzvx {
        Context context = this.zze;
        return zzwf.zze(context, zzbs(context, zzvvVar, zzvVar, false, false), zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzvg zzah(zzvm zzvmVar, zzv zzvVar, MediaCrypto mediaCrypto, float f) {
        int i;
        zzadd zzaddVar;
        Point pointZzi;
        int i2;
        zzv[] zzvVarArr;
        byte b;
        boolean z;
        Pair pairZze;
        int iZzaw;
        zzv[] zzvVarArrZzJ = zzJ();
        int length = zzvVarArrZzJ.length;
        int iZzbm = zzbm(zzvmVar, zzvVar);
        int i3 = zzvVar.zzx;
        int i4 = zzvVar.zzw;
        if (length == 1) {
            if (iZzbm != -1 && (iZzaw = zzaw(zzvmVar, zzvVar)) != -1) {
                iZzbm = Math.min((int) (iZzbm * 1.5f), iZzaw);
            }
            zzaddVar = new zzadd(i4, i3, iZzbm);
            i = 35;
        } else {
            int iMax = i3;
            int iMax2 = i4;
            int i5 = 0;
            boolean z2 = false;
            i = 35;
            while (i5 < length) {
                zzv zzvVarZzO = zzvVarArrZzJ[i5];
                zzi zziVar = zzvVar.zzF;
                if (zziVar != null && zzvVarZzO.zzF == null) {
                    zzt zztVarZza = zzvVarZzO.zza();
                    zztVarZza.zzE(zziVar);
                    zzvVarZzO = zztVarZza.zzO();
                }
                if (zzvmVar.zzf(zzvVar, zzvVarZzO).zzd != 0) {
                    int i6 = zzvVarZzO.zzw;
                    b = -1;
                    if (i6 != -1) {
                        zzvVarArr = zzvVarArrZzJ;
                        if (zzvVarZzO.zzx != -1) {
                            z = false;
                        }
                        z2 |= z;
                        iMax2 = Math.max(iMax2, i6);
                        iMax = Math.max(iMax, zzvVarZzO.zzx);
                        iZzbm = Math.max(iZzbm, zzbm(zzvmVar, zzvVarZzO));
                    } else {
                        zzvVarArr = zzvVarArrZzJ;
                    }
                    z = true;
                    z2 |= z;
                    iMax2 = Math.max(iMax2, i6);
                    iMax = Math.max(iMax, zzvVarZzO.zzx);
                    iZzbm = Math.max(iZzbm, zzbm(zzvmVar, zzvVarZzO));
                } else {
                    zzvVarArr = zzvVarArrZzJ;
                    b = -1;
                }
                i5++;
                zzvVarArrZzJ = zzvVarArr;
            }
            if (z2) {
                StringBuilder sb = new StringBuilder(String.valueOf(iMax2).length() + 44 + String.valueOf(iMax).length());
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(iMax2);
                sb.append("x");
                sb.append(iMax);
                zzeg.zzc("MediaCodecVideoRenderer", sb.toString());
                boolean z3 = i3 > i4;
                int i7 = z3 ? i3 : i4;
                int i8 = true != z3 ? i3 : i4;
                int[] iArr = zzb;
                int i9 = 0;
                while (true) {
                    if (i9 < 9) {
                        float f2 = i8;
                        float f3 = i7;
                        int i10 = iArr[i9];
                        int i11 = i9;
                        float f4 = i10;
                        if (i10 > i7 && (i2 = (int) (f4 * (f2 / f3))) > i8) {
                            int i12 = i7;
                            int i13 = true != z3 ? i10 : i2;
                            if (true != z3) {
                                i10 = i2;
                            }
                            pointZzi = zzvmVar.zzi(i13, i10);
                            float f5 = zzvVar.zzA;
                            if (pointZzi != null) {
                                if (zzvmVar.zzg(pointZzi.x, pointZzi.y, f5)) {
                                    break;
                                }
                            }
                            i9 = i11 + 1;
                            i7 = i12;
                            i8 = i8;
                            z3 = z3;
                        }
                    }
                    pointZzi = null;
                    break;
                }
                if (pointZzi != null) {
                    iMax2 = Math.max(iMax2, pointZzi.x);
                    iMax = Math.max(iMax, pointZzi.y);
                    zzt zztVarZza2 = zzvVar.zza();
                    zztVarZza2.zzv(iMax2);
                    zztVarZza2.zzw(iMax);
                    iZzbm = Math.max(iZzbm, zzaw(zzvmVar, zztVarZza2.zzO()));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(iMax2).length() + 35 + String.valueOf(iMax).length());
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(iMax2);
                    sb2.append("x");
                    sb2.append(iMax);
                    zzeg.zzc("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zzaddVar = new zzadd(iMax2, iMax, iZzbm);
        }
        String str = zzvmVar.zzc;
        this.zzo = zzaddVar;
        boolean z4 = this.zzh;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", i4);
        mediaFormat.setInteger("height", i3);
        zzej.zza(mediaFormat, zzvVar.zzs);
        float f6 = zzvVar.zzA;
        if (f6 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f6);
        }
        zzej.zzb(mediaFormat, "rotation-degrees", zzvVar.zzB);
        zzi zziVar2 = zzvVar.zzF;
        if (zziVar2 != null) {
            zzej.zzb(mediaFormat, "color-transfer", zziVar2.zzd);
            zzej.zzb(mediaFormat, "color-standard", zziVar2.zzb);
            zzej.zzb(mediaFormat, "color-range", zziVar2.zzc);
            byte[] bArr = zziVar2.zze;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(zzvVar.zzp) && (pairZze = zzdq.zze(zzvVar)) != null) {
            zzej.zzb(mediaFormat, Scopes.PROFILE, ((Integer) pairZze.first).intValue());
        }
        mediaFormat.setInteger("max-width", zzaddVar.zza);
        mediaFormat.setInteger("max-height", zzaddVar.zzb);
        zzej.zzb(mediaFormat, "max-input-size", zzaddVar.zzc);
        mediaFormat.setInteger("priority", 0);
        if (f != -1.0f) {
            mediaFormat.setFloat("operating-rate", f);
        }
        if (z4) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (Build.VERSION.SDK_INT >= i) {
            mediaFormat.setInteger("importance", Math.max(0, -this.zzN));
        }
        zzbi(mediaFormat);
        Surface surfaceZzbz = zzbz(zzvmVar);
        if (this.zzr != null && !zzfl.zzU(this.zze)) {
            mediaFormat.setInteger("allow-frame-drop", 0);
        }
        return zzvg.zzb(zzvmVar, mediaFormat, zzvVar, surfaceZzbz, null);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzjc zzai(zzvm zzvmVar, zzv zzvVar, zzv zzvVar2) {
        int i;
        int i2;
        zzjc zzjcVarZzf = zzvmVar.zzf(zzvVar, zzvVar2);
        int i3 = zzjcVarZzf.zze;
        zzadd zzaddVar = this.zzo;
        zzaddVar.getClass();
        if (zzvVar2.zzw > zzaddVar.zza || zzvVar2.zzx > zzaddVar.zzb) {
            i3 |= 256;
        }
        if (zzbm(zzvmVar, zzvVar2) > zzaddVar.zzc) {
            i3 |= 64;
        }
        if (this.zzA != Integer.MIN_VALUE) {
            float f = zzvVar.zzA;
            if (f != -1.0f) {
                float f2 = zzvVar2.zzA;
                if (f2 != -1.0f && Math.abs(f2 - f) > 1.0f && (Build.VERSION.SDK_INT < 30 || (Build.VERSION.SDK_INT == 30 && Build.MODEL.startsWith("MiTV")))) {
                    i3 |= 65536;
                }
            }
        }
        String str = zzvmVar.zza;
        if (i3 != 0) {
            i2 = 0;
            i = i3;
        } else {
            i = 0;
            i2 = zzjcVarZzf.zzd;
        }
        return new zzjc(str, zzvVar, zzvVar2, i2, i);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final float zzak(float f, zzv zzvVar, zzv[] zzvVarArr) {
        zzvm zzvmVarZzaL;
        float fMax = -1.0f;
        for (zzv zzvVar2 : zzvVarArr) {
            float f2 = zzvVar2.zzA;
            if (f2 != -1.0f) {
                fMax = Math.max(fMax, f2);
            }
        }
        float f3 = fMax == -1.0f ? -1.0f : fMax * f;
        if (this.zzF == null || (zzvmVarZzaL = zzaL()) == null) {
            return f3;
        }
        float fZzh = zzvmVarZzaL.zzh(zzvVar.zzw, zzvVar.zzx);
        return f3 != -1.0f ? Math.max(f3, fZzh) : fZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzal(String str, zzvg zzvgVar, long j, long j2) {
        this.zzg.zzb(str, j, j2);
        this.zzp = zzbq(str);
        zzvm zzvmVarZzaL = zzaL();
        zzvmVarZzaL.getClass();
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 29 && MimeTypes.VIDEO_VP9.equals(zzvmVarZzaL.zzb)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzvmVarZzaL.zzb()) {
                if (codecProfileLevel.profile == 16384) {
                    z = true;
                    break;
                }
            }
        }
        this.zzq = z;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzam(String str) {
        this.zzg.zzh(str);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzan(Exception exc) {
        zzeg.zzf("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzj(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final zzjc zzao(zzlw zzlwVar) throws zzjk {
        zzjc zzjcVarZzao = super.zzao(zzlwVar);
        zzv zzvVar = zzlwVar.zzb;
        zzvVar.getClass();
        this.zzg.zzc(zzvVar, zzjcVarZzao);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
        return zzjcVarZzao;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzap(zzv zzvVar, MediaFormat mediaFormat) {
        zzvj zzvjVarZzaI = zzaI();
        if (zzvjVarZzaI != null) {
            zzvjVarZzaI.zzq(this.zzz);
        }
        mediaFormat.getClass();
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        int integer = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        int integer2 = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        float f = zzvVar.zzC;
        int i = zzvVar.zzB;
        if (i == 90 || i == 270) {
            f = 1.0f / f;
            int i2 = integer2;
            integer2 = integer;
            integer = i2;
        }
        this.zzL = new zzbv(integer, integer2, f);
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null || !this.zzS) {
            this.zzi.zze(zzvVar.zzA);
        } else {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzv(integer);
            zztVarZza.zzw(integer2);
            zztVarZza.zzB(f);
            zzv zzvVarZzO = zztVarZza.zzO();
            int i3 = this.zzt;
            List listZzi = this.zzu;
            if (listZzi == null) {
                listZzi = zzgwm.zzi();
            }
            zzaeuVar.zzs(1, zzvVarZzO, zzbh(), i3, listZzi);
            this.zzt = 2;
        }
        this.zzS = false;
    }

    @Override // com.google.android.gms.internal.ads.zzadt
    public final boolean zzaq(long j, long j2, long j3, boolean z, boolean z2) throws zzjk {
        int iZzR;
        if (this.zzr != null && this.zzf) {
            j2 -= -this.zzQ;
        }
        if (j >= -500000 || z || (iZzR = zzR(j2)) == 0) {
            return false;
        }
        this.zzG = j2;
        if (z2) {
            zzjb zzjbVar = this.zza;
            int i = zzjbVar.zzd + iZzR;
            zzjbVar.zzd = i;
            zzjbVar.zzf += this.zzE;
            zzjbVar.zzd = i + this.zzn.size();
        } else {
            this.zza.zzj++;
            zzaz(iZzR + this.zzn.size(), this.zzE);
        }
        zzaN();
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzg(false);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzar() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzi();
            long jZzbh = this.zzQ;
            if (jZzbh == C.TIME_UNSET) {
                jZzbh = zzbh();
                this.zzQ = jZzbh;
            }
            this.zzr.zzo(-jZzbh);
        } else {
            this.zzi.zza(2);
        }
        this.zzS = true;
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzat(zziz zzizVar) {
        this.zzg.zzk(zzizVar);
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzau() {
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            zzaeuVar.zzi();
        } else if (zzbe() != C.TIME_UNSET) {
            zzbe();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvt
    protected final void zzav(zziv zzivVar) throws zzjk {
        if (this.zzq) {
            ByteBuffer byteBuffer = zzivVar.zzf;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        zzvj zzvjVarZzaI = zzaI();
                        zzvjVarZzaI.getClass();
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("hdr10-plus-info", bArr);
                        zzvjVarZzaI.zzp(bundle);
                    }
                }
            }
        }
    }

    protected final void zzax(zzvj zzvjVar, int i, long j) {
        Trace.beginSection("skipVideoBuffer");
        zzvjVar.zzc(i, false);
        Trace.endSection();
        this.zza.zzf++;
    }

    protected final void zzay(zzvj zzvjVar, int i, long j) {
        Trace.beginSection("dropVideoBuffer");
        zzvjVar.zzc(i, false);
        Trace.endSection();
        zzaz(0, 1);
    }

    protected final void zzaz(int i, int i2) {
        zzjb zzjbVar = this.zza;
        zzjbVar.zzh += i;
        int i3 = i + i2;
        zzjbVar.zzg += i3;
        this.zzC += i3;
        int i4 = this.zzD + i3;
        this.zzD = i4;
        zzjbVar.zzi = Math.max(i4, zzjbVar.zzi);
    }

    final /* synthetic */ Surface zzbp() {
        return this.zzv;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzy(boolean z, boolean z2) throws zzjk {
        super.zzy(z, z2);
        zzK();
        this.zzg.zza(this.zza);
        if (!this.zzs) {
            if (this.zzu != null && this.zzr == null) {
                zzadi zzadiVar = new zzadi(this.zze, this.zzi);
                zzadiVar.zza(true);
                zzadiVar.zzc(-this.zzl);
                zzadiVar.zzb(zzM());
                zzadq zzadqVarZzd = zzadiVar.zzd();
                zzadqVarZzd.zza(1);
                this.zzr = zzadqVarZzd.zzb(0);
            }
            this.zzs = true;
        }
        int i = !z2 ? 1 : 0;
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar == null) {
            zzadu zzaduVar = this.zzi;
            zzaduVar.zzg(zzM());
            zzaduVar.zza(i);
            return;
        }
        zzaeuVar.zzc(new zzacz(this), zzhcn.zza());
        zzadr zzadrVar = this.zzP;
        if (zzadrVar != null) {
            this.zzr.zzl(zzadrVar);
        }
        if (this.zzv != null && !this.zzx.equals(zzeu.zza)) {
            this.zzr.zzp(this.zzv, this.zzx);
        }
        this.zzr.zzr(this.zzA);
        this.zzr.zzm(zzbb());
        List list = this.zzu;
        if (list != null) {
            this.zzr.zzn(list);
        }
        this.zzt = i;
        zzaD();
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix
    protected final void zzz(zzv[] zzvVarArr, long j, long j2, zzxk zzxkVar) throws zzjk {
        super.zzz(zzvVarArr, j, j2, zzxkVar);
        zzbt(zzxkVar);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar != null) {
            zzadvVar.zzd();
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0077 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0079  */
    /* JADX WARN: Code duplicated, block: B:27:0x007c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0080  */
    /* JADX WARN: Code duplicated, block: B:32:0x008d  */
    /* JADX WARN: Code duplicated, block: B:34:0x009a  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:40:0x00d3  */
    @Override // com.google.android.gms.internal.ads.zzvt
    protected final boolean zzas(long j, long j2, zzvj zzvjVar, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, zzv zzvVar) throws zzjk {
        long jZzb;
        zzade zzadeVar;
        long j4;
        zzvjVar.getClass();
        long jZzbg = j3 - zzbg();
        int i4 = 0;
        while (true) {
            PriorityQueue priorityQueue = this.zzn;
            Long l = (Long) priorityQueue.peek();
            if (l == null || l.longValue() >= j3) {
                break;
            }
            priorityQueue.poll();
            i4++;
        }
        zzaz(i4, 0);
        zzaeu zzaeuVar = this.zzr;
        if (zzaeuVar != null) {
            if (!z || z2) {
                return zzaeuVar.zzu(j3, new zzada(this, zzvjVar, i, jZzbg));
            }
            zzax(zzvjVar, i, jZzbg);
            return true;
        }
        zzadu zzaduVar = this.zzi;
        long jZzbh = zzbh();
        zzads zzadsVar = this.zzj;
        int iZzk = zzaduVar.zzk(j3, j, j2, jZzbh, z, z2, zzadsVar);
        zzadv zzadvVar = this.zzm;
        if (zzadvVar == null) {
            if (iZzk != 0) {
                long jZzc = zzM().zzc();
                zzbx(jZzbg, jZzc, zzvVar);
                zzaB(zzvjVar, i, jZzbg, jZzc);
                zzaA(zzadsVar.zza());
                return true;
            }
            if (iZzk != 1) {
                jZzb = zzadsVar.zzb();
                long jZza = zzadsVar.zza();
                if (jZzb == this.zzK) {
                    zzax(zzvjVar, i, jZzbg);
                    j4 = jZzb;
                    zzadeVar = this;
                } else {
                    zzbx(jZzbg, jZzb, zzvVar);
                    zzaB(zzvjVar, i, jZzbg, jZzb);
                    zzadeVar = this;
                    j4 = jZzb;
                }
                zzadeVar.zzaA(jZza);
                zzadeVar.zzK = j4;
                return true;
            }
            if (iZzk != 2) {
                zzay(zzvjVar, i, jZzbg);
                zzaA(zzadsVar.zza());
                return true;
            }
            if (iZzk == 3) {
                zzax(zzvjVar, i, jZzbg);
                zzaA(zzadsVar.zza());
                return true;
            }
        } else if (iZzk != 5 && iZzk != 4) {
            zzadvVar.zza(j3, zzadsVar.zza());
            if (iZzk != 0) {
                long jZzc2 = zzM().zzc();
                zzbx(jZzbg, jZzc2, zzvVar);
                zzaB(zzvjVar, i, jZzbg, jZzc2);
                zzaA(zzadsVar.zza());
                return true;
            }
            if (iZzk != 1) {
                jZzb = zzadsVar.zzb();
                long jZza2 = zzadsVar.zza();
                if (jZzb == this.zzK) {
                    zzax(zzvjVar, i, jZzbg);
                    j4 = jZzb;
                    zzadeVar = this;
                } else {
                    zzbx(jZzbg, jZzb, zzvVar);
                    zzaB(zzvjVar, i, jZzbg, jZzb);
                    zzadeVar = this;
                    j4 = jZzb;
                }
                zzadeVar.zzaA(jZza2);
                zzadeVar.zzK = j4;
                return true;
            }
            if (iZzk != 2) {
                zzay(zzvjVar, i, jZzbg);
                zzaA(zzadsVar.zza());
                return true;
            }
            if (iZzk == 3) {
                zzax(zzvjVar, i, jZzbg);
                zzaA(zzadsVar.zza());
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvt, com.google.android.gms.internal.ads.zzix, com.google.android.gms.internal.ads.zzmv
    public final void zzx(int i, Object obj) throws zzjk {
        if (i == 1) {
            zzbu(obj);
            return;
        }
        if (i == 7) {
            obj.getClass();
            zzadr zzadrVar = (zzadr) obj;
            this.zzP = zzadrVar;
            zzaeu zzaeuVar = this.zzr;
            if (zzaeuVar != null) {
                zzaeuVar.zzl(zzadrVar);
                return;
            }
            return;
        }
        if (i == 10) {
            obj.getClass();
            int iIntValue = ((Integer) obj).intValue();
            if (this.zzO != iIntValue) {
                this.zzO = iIntValue;
                return;
            }
            return;
        }
        if (i == 4) {
            obj.getClass();
            int iIntValue2 = ((Integer) obj).intValue();
            this.zzz = iIntValue2;
            zzvj zzvjVarZzaI = zzaI();
            if (zzvjVarZzaI != null) {
                zzvjVarZzaI.zzq(iIntValue2);
                return;
            }
            return;
        }
        if (i == 5) {
            obj.getClass();
            int iIntValue3 = ((Integer) obj).intValue();
            this.zzA = iIntValue3;
            zzaeu zzaeuVar2 = this.zzr;
            if (zzaeuVar2 != null) {
                zzaeuVar2.zzr(iIntValue3);
                return;
            } else {
                this.zzi.zzm(iIntValue3);
                return;
            }
        }
        if (i == 13) {
            obj.getClass();
            List list = (List) obj;
            if (list.equals(zzbr.zza)) {
                zzaeu zzaeuVar3 = this.zzr;
                if (zzaeuVar3 == null || !zzaeuVar3.zze()) {
                    return;
                }
                zzaeuVar3.zzf();
                return;
            }
            this.zzu = list;
            zzaeu zzaeuVar4 = this.zzr;
            if (zzaeuVar4 != null) {
                zzaeuVar4.zzn(list);
                return;
            }
            return;
        }
        if (i == 14) {
            obj.getClass();
            zzeu zzeuVar = (zzeu) obj;
            if (zzeuVar.zza() == 0 || zzeuVar.zzb() == 0) {
                return;
            }
            this.zzx = zzeuVar;
            zzaeu zzaeuVar5 = this.zzr;
            if (zzaeuVar5 != null) {
                Surface surface = this.zzv;
                surface.getClass();
                zzaeuVar5.zzp(surface, zzeuVar);
                return;
            }
            return;
        }
        switch (i) {
            case 16:
                obj.getClass();
                this.zzN = ((Integer) obj).intValue();
                zzvj zzvjVarZzaI2 = zzaI();
                if (zzvjVarZzaI2 != null && Build.VERSION.SDK_INT >= 35) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("importance", Math.max(0, -this.zzN));
                    zzvjVarZzaI2.zzp(bundle);
                    break;
                }
                break;
            case 17:
                Surface surface2 = this.zzv;
                zzbu(null);
                obj.getClass();
                ((zzade) obj).zzx(1, surface2);
                break;
            case 18:
                boolean z = this.zzF != null;
                zznh zznhVar = (zznh) obj;
                this.zzF = zznhVar;
                if (z != (zznhVar != null)) {
                    zzbd();
                }
                break;
            default:
                super.zzx(i, obj);
                break;
        }
    }
}
