package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentTransaction;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.internal.NativeProtocol;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.Videoio;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdq {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};
    private static final Pattern zzd = Pattern.compile("^\\D?(\\d+)$");

    public static zzgwm zza(byte b, byte b2, byte b3, byte b4) {
        return zzgwm.zzj(new byte[]{1, 1, b, 2, 1, b2, 3, 1, b3, 4, 1, b4});
    }

    public static String zzb(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static String zzc(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        int i5;
        Object[] objArr = {zzc[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(true != z ? 'L' : 'H'), Integer.valueOf(i4)};
        String str = zzfl.zza;
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i6 = 6;
        while (true) {
            if (i6 <= 0) {
                break;
            }
            int i7 = i6 - 1;
            if (iArr[i7] != 0) {
                break;
            }
            i6 = i7;
        }
        for (i5 = 0; i5 < i6; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    public static String zzd(byte[] bArr) {
        int length = bArr.length;
        zzgtj.zzd(length >= 17, "Invalid APV CSD length: %s", length);
        byte b = bArr[0];
        zzgtj.zzd(b == 1, "Invalid APV CSD version: %s", b);
        Object[] objArr = {Integer.valueOf(bArr[5]), Integer.valueOf(bArr[6]), Integer.valueOf(bArr[7])};
        String str = zzfl.zza;
        return String.format(Locale.US, "apv1.apvf%d.apvl%d.apvb%d", objArr);
    }

    public static Pair zze(zzv zzvVar) {
        zzdp zzdpVarZzf = zzf(zzvVar);
        if (zzdpVarZzf == null || !zzdpVarZzf.zzc()) {
            return null;
        }
        return new Pair(Integer.valueOf(zzdpVarZzf.zza()), Integer.valueOf(zzdpVarZzf.zzb()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:111:0x021e  */
    /* JADX WARN: Code duplicated, block: B:113:0x0227  */
    /* JADX WARN: Code duplicated, block: B:117:0x023e  */
    /* JADX WARN: Code duplicated, block: B:121:0x0247 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:122:0x0249  */
    /* JADX WARN: Code duplicated, block: B:125:0x024f  */
    /* JADX WARN: Code duplicated, block: B:126:0x0251  */
    /* JADX WARN: Code duplicated, block: B:128:0x0255  */
    /* JADX WARN: Code duplicated, block: B:132:0x0262  */
    /* JADX WARN: Code duplicated, block: B:134:0x026a  */
    /* JADX WARN: Code duplicated, block: B:135:0x0272  */
    /* JADX WARN: Code duplicated, block: B:137:0x027a  */
    /* JADX WARN: Code duplicated, block: B:138:0x0282  */
    /* JADX WARN: Code duplicated, block: B:140:0x028a  */
    /* JADX WARN: Code duplicated, block: B:141:0x0292  */
    /* JADX WARN: Code duplicated, block: B:143:0x029a  */
    /* JADX WARN: Code duplicated, block: B:144:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:146:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:147:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:149:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:150:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:152:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:155:0x02db  */
    /* JADX WARN: Code duplicated, block: B:156:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:158:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:159:0x02ef  */
    /* JADX WARN: Code duplicated, block: B:161:0x02f7  */
    /* JADX WARN: Code duplicated, block: B:162:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:164:0x0305  */
    /* JADX WARN: Code duplicated, block: B:165:0x030b  */
    /* JADX WARN: Code duplicated, block: B:167:0x0313  */
    /* JADX WARN: Code duplicated, block: B:168:0x0319  */
    /* JADX WARN: Code duplicated, block: B:170:0x0321  */
    /* JADX WARN: Code duplicated, block: B:171:0x0327  */
    /* JADX WARN: Code duplicated, block: B:173:0x032f  */
    /* JADX WARN: Code duplicated, block: B:174:0x0335  */
    /* JADX WARN: Code duplicated, block: B:176:0x033d  */
    /* JADX WARN: Code duplicated, block: B:177:0x0343  */
    /* JADX WARN: Code duplicated, block: B:179:0x034b  */
    /* JADX WARN: Code duplicated, block: B:180:0x0350  */
    /* JADX WARN: Code duplicated, block: B:182:0x0358  */
    /* JADX WARN: Code duplicated, block: B:183:0x035d  */
    /* JADX WARN: Code duplicated, block: B:185:0x0365  */
    /* JADX WARN: Code duplicated, block: B:186:0x036c  */
    /* JADX WARN: Code duplicated, block: B:188:0x0374  */
    /* JADX WARN: Code duplicated, block: B:189:0x037b  */
    /* JADX WARN: Code duplicated, block: B:191:0x0383  */
    /* JADX WARN: Code duplicated, block: B:192:0x0388  */
    /* JADX WARN: Code duplicated, block: B:194:0x0390  */
    /* JADX WARN: Code duplicated, block: B:195:0x0395  */
    /* JADX WARN: Code duplicated, block: B:197:0x039d  */
    /* JADX WARN: Code duplicated, block: B:198:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:200:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:201:0x03af  */
    /* JADX WARN: Code duplicated, block: B:203:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:205:0x03c6  */
    /* JADX WARN: Code duplicated, block: B:207:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:403:0x0755  */
    /* JADX WARN: Code duplicated, block: B:424:0x07b1  */
    /* JADX WARN: Code duplicated, block: B:426:0x07b8  */
    /* JADX WARN: Code duplicated, block: B:430:0x07cf A[Catch: NumberFormatException -> 0x08c3, TryCatch #6 {NumberFormatException -> 0x08c3, blocks: (B:428:0x07c7, B:430:0x07cf, B:432:0x07e7, B:484:0x08a6), top: B:619:0x07c7 }] */
    /* JADX WARN: Code duplicated, block: B:431:0x07e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:432:0x07e7 A[Catch: NumberFormatException -> 0x08c3, TRY_LEAVE, TryCatch #6 {NumberFormatException -> 0x08c3, blocks: (B:428:0x07c7, B:430:0x07cf, B:432:0x07e7, B:484:0x08a6), top: B:619:0x07c7 }] */
    /* JADX WARN: Code duplicated, block: B:435:0x07f7  */
    /* JADX WARN: Code duplicated, block: B:437:0x07fb  */
    /* JADX WARN: Code duplicated, block: B:439:0x07ff  */
    /* JADX WARN: Code duplicated, block: B:441:0x0803  */
    /* JADX WARN: Code duplicated, block: B:443:0x0807  */
    /* JADX WARN: Code duplicated, block: B:445:0x080b  */
    /* JADX WARN: Code duplicated, block: B:447:0x080f  */
    /* JADX WARN: Code duplicated, block: B:448:0x0811  */
    /* JADX WARN: Code duplicated, block: B:449:0x0814  */
    /* JADX WARN: Code duplicated, block: B:450:0x0817  */
    /* JADX WARN: Code duplicated, block: B:451:0x0819  */
    /* JADX WARN: Code duplicated, block: B:452:0x081b  */
    /* JADX WARN: Code duplicated, block: B:453:0x081d  */
    /* JADX WARN: Code duplicated, block: B:455:0x0820  */
    /* JADX WARN: Code duplicated, block: B:457:0x0840  */
    /* JADX WARN: Code duplicated, block: B:458:0x0843  */
    /* JADX WARN: Code duplicated, block: B:459:0x0846  */
    /* JADX WARN: Code duplicated, block: B:460:0x0849  */
    /* JADX WARN: Code duplicated, block: B:461:0x084c  */
    /* JADX WARN: Code duplicated, block: B:462:0x084f  */
    /* JADX WARN: Code duplicated, block: B:463:0x0851  */
    /* JADX WARN: Code duplicated, block: B:464:0x0854  */
    /* JADX WARN: Code duplicated, block: B:465:0x0858  */
    /* JADX WARN: Code duplicated, block: B:466:0x085b  */
    /* JADX WARN: Code duplicated, block: B:467:0x085e  */
    /* JADX WARN: Code duplicated, block: B:468:0x0861  */
    /* JADX WARN: Code duplicated, block: B:469:0x0864  */
    /* JADX WARN: Code duplicated, block: B:470:0x0867  */
    /* JADX WARN: Code duplicated, block: B:471:0x086a  */
    /* JADX WARN: Code duplicated, block: B:472:0x086d  */
    /* JADX WARN: Code duplicated, block: B:473:0x0870  */
    /* JADX WARN: Code duplicated, block: B:474:0x0873  */
    /* JADX WARN: Code duplicated, block: B:475:0x0876  */
    /* JADX WARN: Code duplicated, block: B:476:0x0878  */
    /* JADX WARN: Code duplicated, block: B:477:0x087a  */
    /* JADX WARN: Code duplicated, block: B:478:0x087c  */
    /* JADX WARN: Code duplicated, block: B:480:0x087f  */
    /* JADX WARN: Code duplicated, block: B:482:0x08a0  */
    /* JADX WARN: Code duplicated, block: B:484:0x08a6 A[Catch: NumberFormatException -> 0x08c3, TRY_ENTER, TRY_LEAVE, TryCatch #6 {NumberFormatException -> 0x08c3, blocks: (B:428:0x07c7, B:430:0x07cf, B:432:0x07e7, B:484:0x08a6), top: B:619:0x07c7 }] */
    /* JADX WARN: Code duplicated, block: B:576:0x0aa9  */
    /* JADX WARN: Code duplicated, block: B:610:0x0236 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:619:0x07c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:648:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:649:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:650:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:651:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:652:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:653:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:654:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:655:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:656:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:657:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:658:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:659:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:660:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:661:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:662:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:663:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:664:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:665:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:666:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:667:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:668:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:669:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:670:? A[SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x066f, code lost:
    
        if (r1.equals("mp4a") != true) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x06ac, code lost:
    
        if (r1.equals("ipcm") != true) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x06e9, code lost:
    
        if (r1.equals("fLaC") != true) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x0722, code lost:
    
        if (r1.equals("Opus") != true) goto L403;
     */
    /* JADX WARN: Code restructure failed: missing block: B:404:0x0765, code lost:
    
        r0 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:413:0x078c, code lost:
    
        if (r10.equals("hvc1") != false) goto L417;
     */
    /* JADX WARN: Code restructure failed: missing block: B:416:0x0795, code lost:
    
        if (r10.equals("hev1") != false) goto L417;
     */
    /* JADX WARN: Code restructure failed: missing block: B:418:0x079f, code lost:
    
        return zzg(r28.zzk, r4, r28.zzF);
     */
    /* JADX WARN: Code restructure failed: missing block: B:639:?, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:640:?, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:641:?, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:642:?, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:643:?, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:644:?, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:645:?, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:646:?, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:647:?, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x015f, code lost:
    
        if (r0.equals("09") != true) goto L639;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x016d, code lost:
    
        if (r0.equals("08") != true) goto L640;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x017a, code lost:
    
        if (r0.equals("07") != true) goto L641;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0187, code lost:
    
        if (r0.equals("06") != true) goto L642;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0194, code lost:
    
        if (r0.equals("05") != true) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01a1, code lost:
    
        if (r0.equals("04") != true) goto L644;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01ae, code lost:
    
        if (r0.equals("03") != true) goto L645;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01bb, code lost:
    
        if (r0.equals("02") != true) goto L646;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01c8, code lost:
    
        if (r0.equals("01") != true) goto L647;
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v174 int, still in use, count: 1, list:
  (r1v174 int) from 0x0069: IF  (r1v174 int) != (1567 int)  -> B:17:0x006b A[HIDDEN]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.perform(InsnRemover.java:75)
    	at jadx.core.utils.InsnRemover.removeAllMarked(InsnRemover.java:276)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:354)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r1v174 int, still in use, count: 1, list:
  (r1v174 int) from 0x0069: IF  (r1v174 int) != (1567 int)  -> B:17:0x006b A[HIDDEN]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*  JADX ERROR: UnsupportedOperationException in pass: SwitchBreakVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Unknown Source)
        	at jadx.core.dex.visitors.regions.SwitchBreakVisitor$BaseSwitchRegionVisitor.leaveRegion(SwitchBreakVisitor.java:210)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchBreakVisitor$IterativeSwitchRegionVisitor.leaveRegion(SwitchBreakVisitor.java:177)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.SwitchBreakVisitor.runSwitchTraverse(SwitchBreakVisitor.java:52)
        	at jadx.core.dex.visitors.regions.SwitchBreakVisitor.visit(SwitchBreakVisitor.java:45)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzdp zzf(com.google.android.gms.internal.ads.zzv r28) {
        /*
            Method dump skipped, instruction units count: 3260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdq.zzf(com.google.android.gms.internal.ads.zzv):com.google.android.gms.internal.ads.zzdp");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzdp zzg(String str, String[] strArr, zzi zziVar) {
        int i;
        Integer num = null;
        if (strArr.length < 4) {
            String.valueOf(str);
            zzeg.zzc("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        Matcher matcher = zzd.matcher(strArr[1]);
        if (!matcher.matches()) {
            String.valueOf(str);
            zzeg.zzc("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: ".concat(String.valueOf(str)));
            return null;
        }
        String strGroup = matcher.group(1);
        if ("1".equals(strGroup)) {
            i = 1;
        } else {
            if (!ExifInterface.GPS_MEASUREMENT_2D.equals(strGroup)) {
                String.valueOf(strGroup);
                zzeg.zzc("CodecSpecificDataUtil", "Unknown HEVC profile string: ".concat(String.valueOf(strGroup)));
                return zzdp.zza;
            }
            i = (zziVar == null || zziVar.zzd != 6) ? 2 : 4096;
        }
        String str2 = strArr[3];
        switch (str2.hashCode()) {
            case 70821:
                if (str2.equals("H30")) {
                    num = 2;
                }
                break;
            case 70914:
                if (str2.equals("H60")) {
                    num = 8;
                }
                break;
            case 70917:
                if (str2.equals("H63")) {
                    num = 32;
                }
                break;
            case 71007:
                if (str2.equals("H90")) {
                    num = 128;
                }
                break;
            case 71010:
                if (str2.equals("H93")) {
                    num = 512;
                }
                break;
            case 74665:
                if (str2.equals("L30")) {
                    num = 1;
                }
                break;
            case 74758:
                if (str2.equals("L60")) {
                    num = 4;
                }
                break;
            case 74761:
                if (str2.equals("L63")) {
                    num = 16;
                }
                break;
            case 74851:
                if (str2.equals("L90")) {
                    num = 64;
                }
                break;
            case 74854:
                if (str2.equals("L93")) {
                    num = 256;
                }
                break;
            case 2193639:
                if (str2.equals("H120")) {
                    num = 2048;
                }
                break;
            case 2193642:
                if (str2.equals("H123")) {
                    num = 8192;
                }
                break;
            case 2193732:
                if (str2.equals("H150")) {
                    num = 32768;
                }
                break;
            case 2193735:
                if (str2.equals("H153")) {
                    num = 131072;
                }
                break;
            case 2193738:
                if (str2.equals("H156")) {
                    num = 524288;
                }
                break;
            case 2193825:
                if (str2.equals("H180")) {
                    num = 2097152;
                }
                break;
            case 2193828:
                if (str2.equals("H183")) {
                    num = 8388608;
                }
                break;
            case 2193831:
                if (str2.equals("H186")) {
                    num = 33554432;
                }
                break;
            case 2312803:
                if (str2.equals("L120")) {
                    num = 1024;
                }
                break;
            case 2312806:
                if (str2.equals("L123")) {
                    num = 4096;
                }
                break;
            case 2312896:
                if (str2.equals("L150")) {
                    num = 16384;
                }
                break;
            case 2312899:
                if (str2.equals("L153")) {
                    num = 65536;
                }
                break;
            case 2312902:
                if (str2.equals("L156")) {
                    num = 262144;
                }
                break;
            case 2312989:
                if (str2.equals("L180")) {
                    num = 1048576;
                }
                break;
            case 2312992:
                if (str2.equals("L183")) {
                    num = 4194304;
                }
                break;
            case 2312995:
                if (str2.equals("L186")) {
                    num = 16777216;
                }
                break;
        }
        if (num != null) {
            return new zzdp(i, num.intValue());
        }
        String.valueOf(str2);
        zzeg.zzc("CodecSpecificDataUtil", "Unknown HEVC level string: ".concat(String.valueOf(str2)));
        return zzdp.zza;
    }

    public static byte[] zzh(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2 + 4];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }

    private static int zzi(int i, int i2) {
        switch (i) {
            case 30:
                if (i2 == 0) {
                    return 257;
                }
                if (i2 == 1) {
                    return Imgcodecs.IMWRITE_TIFF_YDPI;
                }
                if (i2 == 2) {
                    return 260;
                }
                if (i2 == 3) {
                    return 264;
                }
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 23);
                sb.append("Unrecognized APV band: ");
                sb.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb.toString());
                return -1;
            case 33:
                if (i2 == 0) {
                    return 513;
                }
                if (i2 == 1) {
                    return 514;
                }
                if (i2 == 2) {
                    return Videoio.CAP_PROP_XI_LENS_FOCAL_LENGTH;
                }
                if (i2 == 3) {
                    return 520;
                }
                StringBuilder sb2 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb2.append("Unrecognized APV band: ");
                sb2.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb2.toString());
                return -1;
            case 60:
                if (i2 == 0) {
                    return 1025;
                }
                if (i2 == 1) {
                    return 1026;
                }
                if (i2 == 2) {
                    return 1028;
                }
                if (i2 == 3) {
                    return AnalyticsListener.EVENT_AUDIO_TRACK_RELEASED;
                }
                StringBuilder sb3 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb3.append("Unrecognized APV band: ");
                sb3.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb3.toString());
                return -1;
            case 63:
                if (i2 == 0) {
                    return 2049;
                }
                if (i2 == 1) {
                    return 2050;
                }
                if (i2 == 2) {
                    return 2052;
                }
                if (i2 == 3) {
                    return 2056;
                }
                StringBuilder sb4 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb4.append("Unrecognized APV band: ");
                sb4.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb4.toString());
                return -1;
            case 90:
                if (i2 == 0) {
                    return FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
                }
                if (i2 == 1) {
                    return InputDeviceCompat.SOURCE_TOUCHSCREEN;
                }
                if (i2 == 2) {
                    return FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN;
                }
                if (i2 == 3) {
                    return 4104;
                }
                StringBuilder sb5 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb5.append("Unrecognized APV band: ");
                sb5.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb5.toString());
                return -1;
            case 93:
                if (i2 == 0) {
                    return 8193;
                }
                if (i2 == 1) {
                    return 8194;
                }
                if (i2 == 2) {
                    return 8196;
                }
                if (i2 == 3) {
                    return 8200;
                }
                StringBuilder sb6 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb6.append("Unrecognized APV band: ");
                sb6.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb6.toString());
                return -1;
            case 120:
                if (i2 == 0) {
                    return 16385;
                }
                if (i2 == 1) {
                    return InputDeviceCompat.SOURCE_STYLUS;
                }
                if (i2 == 2) {
                    return 16388;
                }
                if (i2 == 3) {
                    return 16392;
                }
                StringBuilder sb7 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb7.append("Unrecognized APV band: ");
                sb7.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb7.toString());
                return -1;
            case 123:
                if (i2 == 0) {
                    return 32769;
                }
                if (i2 == 1) {
                    return 32770;
                }
                if (i2 == 2) {
                    return 32772;
                }
                if (i2 == 3) {
                    return 32776;
                }
                StringBuilder sb8 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb8.append("Unrecognized APV band: ");
                sb8.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb8.toString());
                return -1;
            case Imgproc.COLOR_BGR2YUV_YVYU /* 150 */:
                if (i2 == 0) {
                    return NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REPLY;
                }
                if (i2 == 1) {
                    return NativeProtocol.MESSAGE_GET_PROTOCOL_VERSIONS_REQUEST;
                }
                if (i2 == 2) {
                    return 65540;
                }
                if (i2 == 3) {
                    return NativeProtocol.MESSAGE_GET_AK_SEAMLESS_TOKEN_REQUEST;
                }
                StringBuilder sb9 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb9.append("Unrecognized APV band: ");
                sb9.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb9.toString());
                return -1;
            case Imgproc.COLOR_RGBA2YUV_YVYU /* 153 */:
                if (i2 == 0) {
                    return 131073;
                }
                if (i2 == 1) {
                    return 131074;
                }
                if (i2 == 2) {
                    return 131076;
                }
                if (i2 == 3) {
                    return 131080;
                }
                StringBuilder sb10 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb10.append("Unrecognized APV band: ");
                sb10.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb10.toString());
                return -1;
            case RotationOptions.ROTATE_180 /* 180 */:
                if (i2 == 0) {
                    return 262145;
                }
                if (i2 == 1) {
                    return 262146;
                }
                if (i2 == 2) {
                    return 262148;
                }
                if (i2 == 3) {
                    return 262152;
                }
                StringBuilder sb11 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb11.append("Unrecognized APV band: ");
                sb11.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb11.toString());
                return -1;
            case 183:
                if (i2 == 0) {
                    return 524289;
                }
                if (i2 == 1) {
                    return 524290;
                }
                if (i2 == 2) {
                    return 524292;
                }
                if (i2 == 3) {
                    return 524296;
                }
                StringBuilder sb12 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb12.append("Unrecognized APV band: ");
                sb12.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb12.toString());
                return -1;
            case 210:
                if (i2 == 0) {
                    return 1048577;
                }
                if (i2 == 1) {
                    return 1048578;
                }
                if (i2 == 2) {
                    return 1048580;
                }
                if (i2 == 3) {
                    return InputDeviceCompat.SOURCE_TOUCHPAD;
                }
                StringBuilder sb13 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb13.append("Unrecognized APV band: ");
                sb13.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb13.toString());
                return -1;
            case 213:
                if (i2 == 0) {
                    return 2097153;
                }
                if (i2 == 1) {
                    return 2097154;
                }
                if (i2 == 2) {
                    return 2097156;
                }
                if (i2 == 3) {
                    return 2097160;
                }
                StringBuilder sb14 = new StringBuilder(String.valueOf(i2).length() + 23);
                sb14.append("Unrecognized APV band: ");
                sb14.append(i2);
                zzeg.zzc("CodecSpecificDataUtil", sb14.toString());
                return -1;
            default:
                StringBuilder sb15 = new StringBuilder(String.valueOf(i).length() + 30);
                sb15.append("Unrecognized APV level index: ");
                sb15.append(i);
                zzeg.zzc("CodecSpecificDataUtil", sb15.toString());
                return -1;
        }
    }
}
