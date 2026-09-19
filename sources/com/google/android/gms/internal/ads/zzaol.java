package com.google.android.gms.internal.ads;

import android.text.Layout;
import androidx.media3.common.C;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.appevents.UserDataStore;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaol implements zzanl {
    private final XmlPullParserFactory zzi;
    private static final Pattern zzc = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    private static final Pattern zzd = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    private static final Pattern zze = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    static final Pattern zza = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    static final Pattern zzb = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
    private static final Pattern zzf = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
    private static final Pattern zzg = Pattern.compile("^(\\d+) (\\d+)$");
    private static final zzaoj zzh = new zzaoj(30.0f, 1, 1);

    private static String[] zzc(String str) {
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return new String[0];
        }
        String str2 = zzfl.zza;
        return strTrim.split("\\s+", -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:117:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:126:0x02da  */
    /* JADX WARN: Code duplicated, block: B:185:0x013e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x0132 A[Catch: zzanh -> 0x01a2, TryCatch #0 {zzanh -> 0x01a2, blocks: (B:34:0x00b8, B:36:0x00d4, B:39:0x00ea, B:41:0x00f0, B:43:0x00f6, B:52:0x0111, B:61:0x012c, B:63:0x0132, B:64:0x013e, B:65:0x013f, B:66:0x015c, B:56:0x011d, B:60:0x0129, B:67:0x015d, B:68:0x015e, B:69:0x017f, B:38:0x00dd, B:70:0x0180, B:71:0x01a1), top: B:170:0x00b8 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static zzaoo zzd(XmlPullParser xmlPullParser, zzaoo zzaooVar) {
        Matcher matcher;
        String strGroup;
        int attributeCount = xmlPullParser.getAttributeCount();
        zzaoo zzaooVarZze = zzaooVar;
        for (int i = 0; i < attributeCount; i++) {
            String attributeValue = xmlPullParser.getAttributeValue(i);
            String attributeName = xmlPullParser.getAttributeName(i);
            switch (attributeName.hashCode()) {
                case -1550943582:
                    if (attributeName.equals("fontStyle")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzg(TtmlNode.ITALIC.equalsIgnoreCase(attributeValue));
                        continue;
                    }
                    break;
                case -1289044182:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_EXTENT)) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzM(attributeValue);
                    } else {
                        continue;
                    }
                    break;
                case -1224696685:
                    if (attributeName.equals("fontFamily")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzi(attributeValue);
                    } else {
                        continue;
                    }
                    break;
                case -1065511464:
                    if (attributeName.equals("textAlign")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzz(zzf(attributeValue));
                    } else {
                        continue;
                    }
                    break;
                case -1008619738:
                    if (attributeName.equals("origin")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzK(attributeValue);
                    } else {
                        continue;
                    }
                    break;
                case -879295043:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                        String strZza = zzgss.zza(attributeValue);
                        switch (strZza.hashCode()) {
                            case -1461280213:
                                if (strZza.equals(TtmlNode.NO_UNDERLINE)) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zze(false);
                                }
                                break;
                            case -1026963764:
                                if (strZza.equals(TtmlNode.UNDERLINE)) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zze(true);
                                }
                                break;
                            case 913457136:
                                if (strZza.equals(TtmlNode.NO_LINETHROUGH)) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzc(false);
                                }
                                break;
                            case 1679736913:
                                if (strZza.equals(TtmlNode.LINETHROUGH)) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzc(true);
                                }
                                break;
                        }
                    }
                    break;
                case -734428249:
                    if (attributeName.equals("fontWeight")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzf(TtmlNode.BOLD.equalsIgnoreCase(attributeValue));
                    }
                    break;
                case 3355:
                    if (attributeName.equals("id") && "style".equals(xmlPullParser.getName())) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzs(attributeValue);
                    }
                    break;
                case 3511770:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_RUBY)) {
                        String strZza2 = zzgss.zza(attributeValue);
                        switch (strZza2.hashCode()) {
                            case -618561360:
                                if (strZza2.equals(TtmlNode.RUBY_BASE_CONTAINER)) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(2);
                                }
                                break;
                            case -410956671:
                                if (strZza2.equals(TtmlNode.RUBY_CONTAINER)) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(1);
                                }
                                break;
                            case -250518009:
                                if (strZza2.equals(TtmlNode.RUBY_DELIMITER)) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(4);
                                }
                                break;
                            case -136074796:
                                if (strZza2.equals(TtmlNode.RUBY_TEXT_CONTAINER)) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(3);
                                }
                                break;
                            case 3016401:
                                if (strZza2.equals("base")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(2);
                                }
                                break;
                            case 3556653:
                                if (strZza2.equals("text")) {
                                    zzaooVarZze = zze(zzaooVarZze);
                                    zzaooVarZze.zzu(3);
                                }
                                break;
                        }
                    }
                    break;
                case 94842723:
                    if (attributeName.equals("color")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        try {
                            zzaooVarZze.zzk(zzdr.zza(attributeValue));
                        } catch (IllegalArgumentException unused) {
                            String.valueOf(attributeValue);
                            zzeg.zzc("TtmlParser", "Failed parsing color value: ".concat(String.valueOf(attributeValue)));
                        }
                    }
                    break;
                case 109403361:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_SHEAR)) {
                        zzaoo zzaooVarZze2 = zze(zzaooVarZze);
                        Matcher matcher2 = zza.matcher(attributeValue);
                        float fMin = Float.MAX_VALUE;
                        if (matcher2.matches()) {
                            try {
                                String strGroup2 = matcher2.group(1);
                                if (strGroup2 == null) {
                                    throw null;
                                }
                                String str = strGroup2;
                                fMin = Math.min(100.0f, Math.max(-100.0f, Float.parseFloat(strGroup2)));
                            } catch (NumberFormatException e) {
                                String.valueOf(attributeValue);
                                zzeg.zzd("TtmlParser", "Failed to parse shear: ".concat(String.valueOf(attributeValue)), e);
                            }
                        } else {
                            String.valueOf(attributeValue);
                            zzeg.zzc("TtmlParser", "Invalid value for shear: ".concat(String.valueOf(attributeValue)));
                        }
                        zzaooVarZze2.zzp(fMin);
                        zzaooVarZze = zzaooVarZze2;
                    }
                    break;
                case 110138194:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_COMBINE)) {
                        String strZza3 = zzgss.zza(attributeValue);
                        int iHashCode = strZza3.hashCode();
                        if (iHashCode == 96673) {
                            if (strZza3.equals(TtmlNode.COMBINE_ALL)) {
                                zzaooVarZze = zze(zzaooVarZze);
                                zzaooVarZze.zzD(true);
                            }
                        } else if (iHashCode == 3387192 && strZza3.equals("none")) {
                            zzaooVarZze = zze(zzaooVarZze);
                            zzaooVarZze.zzD(false);
                        }
                        break;
                    }
                    break;
                case 365601008:
                    if (attributeName.equals("fontSize")) {
                        try {
                            zzaooVarZze = zze(zzaooVarZze);
                            String str2 = zzfl.zza;
                            String[] strArrSplit = attributeValue.split("\\s+", -1);
                            int length = strArrSplit.length;
                            if (length == 1) {
                                matcher = zze.matcher(attributeValue);
                            } else {
                                if (length != 2) {
                                    StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 41);
                                    sb.append("Invalid number of entries for fontSize: ");
                                    sb.append(length);
                                    sb.append(".");
                                    throw new zzanh(sb.toString());
                                }
                                matcher = zze.matcher(strArrSplit[1]);
                                zzeg.zzc("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
                            }
                            if (!matcher.matches()) {
                                StringBuilder sb2 = new StringBuilder(String.valueOf(attributeValue).length() + 36);
                                sb2.append("Invalid expression for fontSize: '");
                                sb2.append(attributeValue);
                                sb2.append("'.");
                                throw new zzanh(sb2.toString());
                            }
                            String strGroup3 = matcher.group(3);
                            if (strGroup3 == null) {
                                throw null;
                            }
                            String str3 = strGroup3;
                            int iHashCode2 = strGroup3.hashCode();
                            if (iHashCode2 == 37) {
                                if (!strGroup3.equals("%")) {
                                    StringBuilder sb3 = new StringBuilder(strGroup3.length() + 30);
                                    sb3.append("Invalid unit for fontSize: '");
                                    sb3.append(strGroup3);
                                    sb3.append("'.");
                                    throw new zzanh(sb3.toString());
                                }
                                zzaooVarZze.zzH(3);
                                strGroup = matcher.group(1);
                                if (strGroup == null) {
                                    throw null;
                                }
                                String str4 = strGroup;
                                zzaooVarZze.zzG(Float.parseFloat(strGroup));
                            } else if (iHashCode2 == 3240) {
                                if (!strGroup3.equals(UserDataStore.EMAIL)) {
                                    StringBuilder sb4 = new StringBuilder(strGroup3.length() + 30);
                                    sb4.append("Invalid unit for fontSize: '");
                                    sb4.append(strGroup3);
                                    sb4.append("'.");
                                    throw new zzanh(sb4.toString());
                                }
                                zzaooVarZze.zzH(2);
                                strGroup = matcher.group(1);
                                if (strGroup == null) {
                                    throw null;
                                }
                                String str5 = strGroup;
                                zzaooVarZze.zzG(Float.parseFloat(strGroup));
                            } else {
                                if (iHashCode2 != 3592 || !strGroup3.equals("px")) {
                                    StringBuilder sb5 = new StringBuilder(strGroup3.length() + 30);
                                    sb5.append("Invalid unit for fontSize: '");
                                    sb5.append(strGroup3);
                                    sb5.append("'.");
                                    throw new zzanh(sb5.toString());
                                }
                                zzaooVarZze.zzH(1);
                                strGroup = matcher.group(1);
                                if (strGroup == null) {
                                    throw null;
                                }
                                String str6 = strGroup;
                                zzaooVarZze.zzG(Float.parseFloat(strGroup));
                            }
                        } catch (zzanh unused2) {
                            String.valueOf(attributeValue);
                            zzeg.zzc("TtmlParser", "Failed parsing fontSize value: ".concat(String.valueOf(attributeValue)));
                        }
                    }
                    break;
                case 921125321:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_TEXT_EMPHASIS)) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzF(zzaoh.zza(attributeValue));
                    }
                    break;
                case 1115953443:
                    if (attributeName.equals(TtmlNode.ATTR_TTS_RUBY_POSITION)) {
                        String strZza4 = zzgss.zza(attributeValue);
                        int iHashCode3 = strZza4.hashCode();
                        if (iHashCode3 != -1392885889) {
                            if (iHashCode3 == 92734940 && strZza4.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                                zzaooVarZze = zze(zzaooVarZze);
                                zzaooVarZze.zzw(2);
                            }
                        } else if (strZza4.equals(TtmlNode.ANNOTATION_POSITION_BEFORE)) {
                            zzaooVarZze = zze(zzaooVarZze);
                            zzaooVarZze.zzw(1);
                        }
                    }
                    break;
                case 1287124693:
                    if (attributeName.equals("backgroundColor")) {
                        zzaooVarZze = zze(zzaooVarZze);
                        try {
                            zzaooVarZze.zzn(zzdr.zza(attributeValue));
                        } catch (IllegalArgumentException unused3) {
                            String.valueOf(attributeValue);
                            zzeg.zzc("TtmlParser", "Failed parsing background value: ".concat(String.valueOf(attributeValue)));
                        }
                    }
                    break;
                case 1754920356:
                    if (attributeName.equals(TtmlNode.ATTR_EBUTTS_MULTI_ROW_ALIGN)) {
                        zzaooVarZze = zze(zzaooVarZze);
                        zzaooVarZze.zzB(zzf(attributeValue));
                    }
                    break;
            }
        }
        return zzaooVarZze;
    }

    private static zzaoo zze(zzaoo zzaooVar) {
        return zzaooVar == null ? new zzaoo() : zzaooVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static Layout.Alignment zzf(String str) {
        String strZza = zzgss.zza(str);
        switch (strZza.hashCode()) {
            case -1364013995:
                if (strZza.equals(TtmlNode.CENTER)) {
                    return Layout.Alignment.ALIGN_CENTER;
                }
                return null;
            case 100571:
                if (!strZza.equals("end")) {
                    return null;
                }
                break;
            case 3317767:
                if (!strZza.equals("left")) {
                    return null;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            case 108511772:
                if (!strZza.equals("right")) {
                    return null;
                }
                break;
            case 109757538:
                if (!strZza.equals("start")) {
                    return null;
                }
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
        return Layout.Alignment.ALIGN_OPPOSITE;
    }

    private static long zzg(String str, zzaoj zzaojVar) throws zzanh {
        double d;
        double d2;
        Matcher matcher = zzc.matcher(str);
        if (matcher.matches()) {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            long j = Long.parseLong(strGroup) * 3600;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            long j2 = Long.parseLong(strGroup2) * 60;
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            double d3 = j + j2;
            double d4 = Long.parseLong(strGroup3);
            String strGroup4 = matcher.group(4);
            double d5 = ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE;
            double d6 = strGroup4 != null ? Double.parseDouble(strGroup4) : 0.0d;
            double d7 = d3 + d4;
            String strGroup5 = matcher.group(5);
            double d8 = strGroup5 != null ? Long.parseLong(strGroup5) / zzaojVar.zza : 0.0d;
            double d9 = d7 + d6;
            String strGroup6 = matcher.group(6);
            if (strGroup6 != null) {
                d5 = (Long.parseLong(strGroup6) / ((double) zzaojVar.zzb)) / ((double) zzaojVar.zza);
            }
            return (long) ((d9 + d8 + d5) * 1000000.0d);
        }
        Matcher matcher2 = zzd.matcher(str);
        if (!matcher2.matches()) {
            String.valueOf(str);
            throw new zzanh("Malformed time expression: ".concat(String.valueOf(str)));
        }
        String strGroup7 = matcher2.group(1);
        strGroup7.getClass();
        double d10 = Double.parseDouble(strGroup7);
        String strGroup8 = matcher2.group(2);
        strGroup8.getClass();
        int iHashCode = strGroup8.hashCode();
        if (iHashCode != 102) {
            if (iHashCode != 104) {
                if (iHashCode != 109) {
                    if (iHashCode != 3494) {
                        if (iHashCode == 115) {
                            strGroup8.equals(CmcdData.Factory.STREAMING_FORMAT_SS);
                        } else if (iHashCode == 116 && strGroup8.equals("t")) {
                            d = zzaojVar.zzc;
                            d10 /= d;
                        }
                    } else if (strGroup8.equals("ms")) {
                        d = 1000.0d;
                        d10 /= d;
                    }
                } else if (strGroup8.equals("m")) {
                    d2 = 60.0d;
                    d10 *= d2;
                }
            } else if (strGroup8.equals(CmcdData.Factory.STREAMING_FORMAT_HLS)) {
                d2 = 3600.0d;
                d10 *= d2;
            }
        } else if (strGroup8.equals("f")) {
            d = zzaojVar.zza;
            d10 /= d;
        }
        return (long) (d10 * 1000000.0d);
    }

    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i, int i2, zzank zzankVar, zzdt zzdtVar) {
        zzanf.zza(zzb(bArr, i, i2), zzankVar, zzdtVar);
    }

    /* JADX WARN: Code duplicated, block: B:143:0x030a A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TRY_LEAVE, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0320  */
    /* JADX WARN: Code duplicated, block: B:148:0x0329 A[Catch: NumberFormatException -> 0x0347, IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #0 {NumberFormatException -> 0x0347, blocks: (B:146:0x0323, B:148:0x0329, B:150:0x0339, B:151:0x0345, B:152:0x0346), top: B:386:0x0323 }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0339 A[Catch: NumberFormatException -> 0x0347, IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #0 {NumberFormatException -> 0x0347, blocks: (B:146:0x0323, B:148:0x0329, B:150:0x0339, B:151:0x0345, B:152:0x0346), top: B:386:0x0323 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x034f A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:156:0x0357 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x0359 A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TRY_LEAVE, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:159:0x0361  */
    /* JADX WARN: Code duplicated, block: B:162:0x0368 A[Catch: NumberFormatException -> 0x038d, IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #12 {NumberFormatException -> 0x038d, blocks: (B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c), top: B:402:0x0362 }] */
    /* JADX WARN: Code duplicated, block: B:164:0x0376 A[Catch: NumberFormatException -> 0x038d, IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #12 {NumberFormatException -> 0x038d, blocks: (B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c), top: B:402:0x0362 }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0395 A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:170:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:179:0x03c4 A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TRY_LEAVE, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:184:0x03dd A[Catch: NumberFormatException -> 0x03fe, IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #4 {NumberFormatException -> 0x03fe, blocks: (B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:187:0x03fc, B:188:0x03fd), top: B:393:0x03d7 }] */
    /* JADX WARN: Code duplicated, block: B:186:0x03ed A[Catch: NumberFormatException -> 0x03fe, IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #4 {NumberFormatException -> 0x03fe, blocks: (B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:187:0x03fc, B:188:0x03fd), top: B:393:0x03d7 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x040d A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:192:0x0413 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x0415 A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TRY_LEAVE, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x0425  */
    /* JADX WARN: Code duplicated, block: B:198:0x042c A[Catch: NumberFormatException -> 0x0453, IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #11 {NumberFormatException -> 0x0453, blocks: (B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452), top: B:401:0x0426 }] */
    /* JADX WARN: Code duplicated, block: B:200:0x043a A[Catch: NumberFormatException -> 0x0453, IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #11 {NumberFormatException -> 0x0453, blocks: (B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452), top: B:401:0x0426 }] */
    /* JADX WARN: Code duplicated, block: B:204:0x0463 A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:205:0x0473  */
    /* JADX WARN: Code duplicated, block: B:208:0x047f A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TRY_LEAVE, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:211:0x048c  */
    /* JADX WARN: Code duplicated, block: B:217:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:219:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:220:0x04b3  */
    /* JADX WARN: Code duplicated, block: B:224:0x04c2 A[Catch: IOException -> 0x074b, XmlPullParserException -> 0x0754, TRY_LEAVE, TryCatch #14 {IOException -> 0x074b, XmlPullParserException -> 0x0754, blocks: (B:3:0x0008, B:6:0x005c, B:8:0x006b, B:11:0x0077, B:14:0x0083, B:16:0x008b, B:18:0x0092, B:20:0x009c, B:24:0x00b2, B:26:0x00cd, B:28:0x00d7, B:29:0x00db, B:31:0x00e7, B:32:0x00eb, B:62:0x0164, B:79:0x01bd, B:82:0x01d7, B:84:0x01dd, B:86:0x01e5, B:88:0x01ed, B:90:0x01f5, B:92:0x01fd, B:94:0x0205, B:96:0x020b, B:98:0x0213, B:100:0x021b, B:102:0x0221, B:104:0x0227, B:106:0x022d, B:108:0x0235, B:111:0x023e, B:371:0x072a, B:112:0x026b, B:114:0x0271, B:116:0x027a, B:118:0x0289, B:120:0x0296, B:122:0x02ac, B:124:0x02b2, B:261:0x0558, B:126:0x02bb, B:129:0x02c7, B:244:0x0509, B:132:0x02e5, B:134:0x02ed, B:136:0x02f5, B:138:0x02fd, B:143:0x030a, B:146:0x0323, B:148:0x0329, B:150:0x0339, B:171:0x03aa, B:173:0x03b0, B:175:0x03b6, B:177:0x03be, B:179:0x03c4, B:182:0x03d7, B:184:0x03dd, B:186:0x03ed, B:206:0x0477, B:208:0x047f, B:222:0x04ba, B:224:0x04c2, B:242:0x04fc, B:187:0x03fc, B:188:0x03fd, B:189:0x03fe, B:190:0x040d, B:193:0x0415, B:196:0x0426, B:198:0x042c, B:200:0x043a, B:201:0x0451, B:202:0x0452, B:203:0x0453, B:204:0x0463, B:151:0x0345, B:152:0x0346, B:153:0x0347, B:154:0x034f, B:157:0x0359, B:160:0x0362, B:162:0x0368, B:164:0x0376, B:165:0x038b, B:166:0x038c, B:167:0x038d, B:168:0x0395, B:247:0x051c, B:249:0x0529, B:251:0x0534, B:253:0x053a, B:255:0x0546, B:266:0x0572, B:268:0x0595, B:304:0x063e, B:273:0x05bc, B:276:0x05c5, B:343:0x06b1, B:282:0x05dc, B:289:0x05f8, B:293:0x060e, B:297:0x0622, B:301:0x0636, B:307:0x064f, B:311:0x065b, B:315:0x0664, B:325:0x0679, B:327:0x067e, B:332:0x068e, B:334:0x069a, B:336:0x069f, B:65:0x0171, B:67:0x017d, B:70:0x0186, B:72:0x018c, B:74:0x019a, B:75:0x01a9, B:76:0x01aa, B:77:0x01ab, B:36:0x0104, B:38:0x0110, B:41:0x011a, B:43:0x0120, B:45:0x012b, B:47:0x0131, B:54:0x0148, B:61:0x015c, B:56:0x0152, B:58:0x0157, B:348:0x06d3, B:350:0x06e3, B:353:0x06e7, B:355:0x06f1, B:357:0x06fb, B:361:0x0706, B:359:0x0703, B:364:0x071b, B:368:0x0723, B:374:0x0744, B:377:0x074a), top: B:404:0x0008 }] */
    /* JADX WARN: Code duplicated, block: B:227:0x04ce  */
    /* JADX WARN: Code duplicated, block: B:229:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:235:0x04e4  */
    /* JADX WARN: Code duplicated, block: B:238:0x04ed  */
    /* JADX WARN: Code duplicated, block: B:240:0x04f5  */
    /* JADX WARN: Code duplicated, block: B:241:0x04f8  */
    /* JADX WARN: Code duplicated, block: B:264:0x0564 A[LOOP:1: B:114:0x0271->B:264:0x0564, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:410:0x0346 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:411:0x0345 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:412:0x038c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:413:0x038b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:414:0x03fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:415:0x03fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:416:0x0452 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:417:0x0451 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:423:0x055e A[SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:269:0x05a1. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v66, types: [com.google.android.gms.internal.ads.zzaom, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v68 */
    /* JADX WARN: Type inference failed for: r10v5, types: [com.google.android.gms.internal.ads.zzaok] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v17 */
    /* JADX WARN: Type inference failed for: r17v18 */
    /* JADX WARN: Type inference failed for: r17v19 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v20 */
    /* JADX WARN: Type inference failed for: r17v21 */
    /* JADX WARN: Type inference failed for: r17v22 */
    /* JADX WARN: Type inference failed for: r17v23 */
    /* JADX WARN: Type inference failed for: r17v24 */
    /* JADX WARN: Type inference failed for: r17v25 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r17v9 */
    /* JADX WARN: Type inference failed for: r47v1, types: [com.google.android.gms.internal.ads.zzaoo, java.lang.Throwable] */
    public final zzang zzb(byte[] bArr, int i, int i2) {
        String str;
        String str2;
        HashMap map;
        ArrayDeque arrayDeque;
        zzaoj zzaojVar;
        ?? r17;
        ?? zzaokVar;
        zzaoj zzaojVar2;
        zzaoi zzaoiVar;
        zzaoi zzaoiVar2;
        long j;
        Object obj;
        String str3;
        String str4;
        String strZzc;
        String str5;
        String strZzL;
        String str6;
        HashMap map2;
        String str7;
        float f;
        float f2;
        ?? zzaomVar;
        String strZzc2;
        float f3;
        float f4;
        String strZzc3;
        int i3;
        float f5;
        String strZzc4;
        int i4;
        String strZza;
        int iHashCode;
        String strZza2;
        int iHashCode2;
        Matcher matcher;
        Matcher matcher2;
        String strGroup;
        int i5;
        String strGroup2;
        String strGroup3;
        float f6;
        String strGroup4;
        String strZzc5;
        zzaoo zzaooVar;
        Matcher matcher3;
        Matcher matcher4;
        String strGroup5;
        int i6;
        String strGroup6;
        String strGroup7;
        float f7;
        String strGroup8;
        zzaoo zzaooVar2;
        String str8;
        float f8;
        boolean z;
        String str9 = "";
        String str10 = "http://www.w3.org/ns/ttml#parameter";
        String str11 = "Ignoring unsupported tag: ";
        try {
            XmlPullParser xmlPullParserNewPullParser = this.zzi.newPullParser();
            HashMap map3 = new HashMap();
            HashMap map4 = new HashMap();
            HashMap map5 = new HashMap();
            map4.put("", new zzaom("", -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE));
            Object obj2 = null;
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i, i2), null);
            ArrayDeque arrayDeque2 = new ArrayDeque();
            int eventType = xmlPullParserNewPullParser.getEventType();
            zzaoj zzaojVar3 = zzh;
            zzaop zzaopVar = null;
            ?? r18 = 0;
            zzaoj zzaojVar4 = zzaojVar3;
            int i7 = 0;
            int i8 = 15;
            while (eventType != 1) {
                zzaoi zzaoiVar3 = (zzaoi) arrayDeque2.peek();
                ?? r47 = obj2;
                if (i7 == 0) {
                    String name = xmlPullParserNewPullParser.getName();
                    str = str9;
                    if (eventType == 2) {
                        if (TtmlNode.TAG_TT.equals(name)) {
                            String attributeValue = xmlPullParserNewPullParser.getAttributeValue(str10, "frameRate");
                            int i9 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
                            zzaopVar = zzaopVar;
                            String attributeValue2 = xmlPullParserNewPullParser.getAttributeValue(str10, "frameRateMultiplier");
                            if (attributeValue2 != null) {
                                String str12 = zzfl.zza;
                                String[] strArrSplit = attributeValue2.split(StringUtils.SPACE, -1);
                                zzgtj.zzb(strArrSplit.length == 2, "frameRateMultiplier doesn't have 2 parts");
                                f8 = Integer.parseInt(strArrSplit[0]) / Integer.parseInt(strArrSplit[1]);
                            } else {
                                f8 = 1.0f;
                            }
                            int i10 = zzaojVar3.zzb;
                            String attributeValue3 = xmlPullParserNewPullParser.getAttributeValue(str10, "subFrameRate");
                            if (attributeValue3 != null) {
                                i10 = Integer.parseInt(attributeValue3);
                            }
                            int i11 = zzaojVar3.zzc;
                            zzaojVar = zzaojVar3;
                            String attributeValue4 = xmlPullParserNewPullParser.getAttributeValue(str10, "tickRate");
                            if (attributeValue4 != null) {
                                i11 = Integer.parseInt(attributeValue4);
                            }
                            zzaojVar4 = new zzaoj(i9 * f8, i10, i11);
                            String attributeValue5 = xmlPullParserNewPullParser.getAttributeValue(str10, "cellResolution");
                            if (attributeValue5 == null) {
                                str2 = str10;
                                zzaojVar4 = zzaojVar4;
                                i8 = 15;
                            } else {
                                Matcher matcher5 = zzg.matcher(attributeValue5);
                                if (matcher5.matches()) {
                                    try {
                                        String strGroup9 = matcher5.group(1);
                                        if (strGroup9 == null) {
                                            throw r47;
                                        }
                                        String str13 = strGroup9;
                                        int i12 = Integer.parseInt(strGroup9);
                                        str2 = str10;
                                        try {
                                            String strGroup10 = matcher5.group(2);
                                            if (strGroup10 == null) {
                                                throw r47;
                                            }
                                            String str14 = strGroup10;
                                            int i13 = Integer.parseInt(strGroup10);
                                            try {
                                                if (i12 != 0) {
                                                    if (i13 != 0) {
                                                        z = true;
                                                    } else {
                                                        i13 = 0;
                                                        z = false;
                                                    }
                                                    zzgtj.zzg(z, "Invalid cell resolution %s %s", i12, i13);
                                                    i8 = i13;
                                                } else {
                                                    z = false;
                                                }
                                                zzgtj.zzg(z, "Invalid cell resolution %s %s", i12, i13);
                                                i8 = i13;
                                            } catch (NumberFormatException unused) {
                                                zzeg.zzc("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                                i8 = 15;
                                            }
                                        } catch (NumberFormatException unused2) {
                                            zzaojVar4 = zzaojVar4;
                                        }
                                    } catch (NumberFormatException unused3) {
                                        str2 = str10;
                                    }
                                    zzaojVar4 = zzaojVar4;
                                    zzeg.zzc("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                    i8 = 15;
                                } else {
                                    zzeg.zzc("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue5));
                                    str2 = str10;
                                    zzaojVar4 = zzaojVar4;
                                    i8 = 15;
                                }
                            }
                            String strZzc6 = zzft.zzc(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                            if (strZzc6 == null) {
                                zzaokVar = r47;
                            } else {
                                Matcher matcher6 = zzf.matcher(strZzc6);
                                if (matcher6.matches()) {
                                    try {
                                        String strGroup11 = matcher6.group(1);
                                        if (strGroup11 == null) {
                                            throw r47;
                                        }
                                        String str15 = strGroup11;
                                        int i14 = Integer.parseInt(strGroup11);
                                        String strGroup12 = matcher6.group(2);
                                        if (strGroup12 == null) {
                                            throw r47;
                                        }
                                        String str16 = strGroup12;
                                        zzaokVar = new zzaok(i14, Integer.parseInt(strGroup12));
                                    } catch (NumberFormatException unused4) {
                                        zzeg.zzc("TtmlParser", "Ignoring malformed tts extent: ".concat(strZzc6));
                                        zzaokVar = r47;
                                    }
                                } else {
                                    zzeg.zzc("TtmlParser", "Ignoring non-pixel tts extent: ".concat(strZzc6));
                                }
                                zzaokVar = r47;
                            }
                        } else {
                            str2 = str10;
                            arrayDeque2 = arrayDeque2;
                            zzaojVar = zzaojVar3;
                            zzaopVar = zzaopVar;
                            i7 = i7;
                            zzaokVar = r18;
                        }
                        zzaoj zzaojVar5 = zzaojVar4;
                        r18 = zzaokVar;
                        i8 = i8;
                        boolean zEquals = name.equals(TtmlNode.TAG_TT);
                        String str17 = "image";
                        String str18 = TtmlNode.TAG_METADATA;
                        String str19 = TtmlNode.TAG_REGION;
                        String str20 = TtmlNode.TAG_HEAD;
                        zzaojVar4 = zzaojVar5;
                        if (zEquals || name.equals(TtmlNode.TAG_HEAD) || name.equals("body") || name.equals(TtmlNode.TAG_DIV) || name.equals("p") || name.equals(TtmlNode.TAG_SPAN) || name.equals("br") || name.equals("style") || name.equals(TtmlNode.TAG_STYLING) || name.equals(TtmlNode.TAG_LAYOUT) || name.equals(TtmlNode.TAG_REGION) || name.equals(TtmlNode.TAG_METADATA) || name.equals("image") || name.equals("data") || name.equals(TtmlNode.TAG_INFORMATION)) {
                            if (TtmlNode.TAG_HEAD.equals(name)) {
                                while (true) {
                                    xmlPullParserNewPullParser.next();
                                    if (zzft.zzb(xmlPullParserNewPullParser, "style")) {
                                        String strZzc7 = zzft.zzc(xmlPullParserNewPullParser, "style");
                                        zzaoo zzaooVarZzd = zzd(xmlPullParserNewPullParser, new zzaoo());
                                        if (strZzc7 != null) {
                                            String[] strArrZzc = zzc(strZzc7);
                                            int i15 = 0;
                                            for (int length = strArrZzc.length; i15 < length; length = length) {
                                                zzaooVarZzd.zzr((zzaoo) map3.get(strArrZzc[i15]));
                                                i15++;
                                            }
                                        }
                                        String strZzt = zzaooVarZzd.zzt();
                                        if (strZzt != null) {
                                            map3.put(strZzt, zzaooVarZzd);
                                        }
                                        map = map5;
                                        str3 = str18;
                                        str4 = str19;
                                    } else {
                                        str11 = str11;
                                        str20 = str20;
                                        if (zzft.zzb(xmlPullParserNewPullParser, str19)) {
                                            str4 = str19;
                                            HashMap map6 = map5;
                                            String strZzc8 = zzft.zzc(xmlPullParserNewPullParser, "id");
                                            if (strZzc8 == null) {
                                                zzaomVar = r47;
                                                str6 = str17;
                                                map2 = map4;
                                                str7 = str18;
                                            } else {
                                                String strZzc9 = zzft.zzc(xmlPullParserNewPullParser, "origin");
                                                if (strZzc9 == null) {
                                                    str5 = strZzc9;
                                                    String strZzc10 = zzft.zzc(xmlPullParserNewPullParser, "style");
                                                    if (strZzc10 != null && (zzaooVar2 = (zzaoo) map3.get(strZzc10)) != null) {
                                                        strZzL = zzaooVar2.zzL();
                                                    }
                                                    if (strZzL != null) {
                                                        str6 = str17;
                                                        matcher3 = zzb.matcher(strZzL);
                                                        str7 = str18;
                                                        matcher4 = zzf.matcher(strZzL);
                                                        if (matcher3.matches()) {
                                                            map2 = map4;
                                                            try {
                                                                strGroup7 = matcher3.group(1);
                                                                if (strGroup7 != null) {
                                                                    throw r47;
                                                                }
                                                                String str21 = strGroup7;
                                                                f7 = Float.parseFloat(strGroup7) / 100.0f;
                                                                strGroup8 = matcher3.group(2);
                                                                if (strGroup8 != null) {
                                                                    throw r47;
                                                                }
                                                                String str22 = strGroup8;
                                                                f = Float.parseFloat(strGroup8) / 100.0f;
                                                                f2 = f7;
                                                            } catch (NumberFormatException unused5) {
                                                                zzeg.zzc("TtmlParser", "Ignoring region with malformed origin: ".concat(strZzL));
                                                            }
                                                        } else {
                                                            map2 = map4;
                                                            if (matcher4.matches()) {
                                                                zzeg.zzc("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZzL));
                                                            } else if (r18 == 0) {
                                                                zzeg.zzc("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZzL));
                                                            } else {
                                                                try {
                                                                    strGroup5 = matcher4.group(1);
                                                                    if (strGroup5 != null) {
                                                                        throw r47;
                                                                    }
                                                                    String str23 = strGroup5;
                                                                    i6 = Integer.parseInt(strGroup5);
                                                                    strGroup6 = matcher4.group(2);
                                                                    if (strGroup6 != null) {
                                                                        throw r47;
                                                                    }
                                                                    String str24 = strGroup6;
                                                                    int i16 = Integer.parseInt(strGroup6);
                                                                    float f9 = i6 / r18.zza;
                                                                    f = i16 / r18.zzb;
                                                                    f2 = f9;
                                                                } catch (NumberFormatException unused6) {
                                                                    zzeg.zzc("TtmlParser", "Ignoring region with malformed origin: ".concat(strZzL));
                                                                }
                                                            }
                                                        }
                                                        zzaomVar = r47;
                                                    } else {
                                                        str6 = str17;
                                                        map2 = map4;
                                                        str7 = str18;
                                                        f = 0.0f;
                                                        f2 = 0.0f;
                                                    }
                                                    strZzc2 = zzft.zzc(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                                                    if (strZzc2 == null && (strZzc5 = zzft.zzc(xmlPullParserNewPullParser, "style")) != null && (zzaooVar = (zzaoo) map3.get(strZzc5)) != null) {
                                                        strZzc2 = zzaooVar.zzN();
                                                    }
                                                    if (strZzc2 != null) {
                                                        matcher = zzb.matcher(strZzc2);
                                                        matcher2 = zzf.matcher(strZzc2);
                                                        if (matcher.matches()) {
                                                            try {
                                                                strGroup3 = matcher.group(1);
                                                                if (strGroup3 != null) {
                                                                    throw r47;
                                                                }
                                                                String str25 = strGroup3;
                                                                f6 = Float.parseFloat(strGroup3) / 100.0f;
                                                                strGroup4 = matcher.group(2);
                                                                if (strGroup4 != null) {
                                                                    throw r47;
                                                                }
                                                                String str26 = strGroup4;
                                                                f3 = f6;
                                                                f4 = Float.parseFloat(strGroup4) / 100.0f;
                                                            } catch (NumberFormatException unused7) {
                                                                String.valueOf(strZzL);
                                                                zzeg.zzc("TtmlParser", "Ignoring region with malformed extent: ".concat(String.valueOf(strZzL)));
                                                                zzaomVar = r47;
                                                            }
                                                        } else {
                                                            if (matcher2.matches()) {
                                                                String.valueOf(strZzL);
                                                                zzeg.zzc("TtmlParser", "Ignoring region with unsupported extent: ".concat(String.valueOf(strZzL)));
                                                            } else if (r18 == 0) {
                                                                String.valueOf(strZzL);
                                                                zzeg.zzc("TtmlParser", "Ignoring region with missing tts:extent: ".concat(String.valueOf(strZzL)));
                                                            } else {
                                                                try {
                                                                    strGroup = matcher2.group(1);
                                                                    if (strGroup != null) {
                                                                        throw r47;
                                                                    }
                                                                    String str27 = strGroup;
                                                                    i5 = Integer.parseInt(strGroup);
                                                                    strGroup2 = matcher2.group(2);
                                                                    if (strGroup2 != null) {
                                                                        throw r47;
                                                                    }
                                                                    String str28 = strGroup2;
                                                                    int i17 = Integer.parseInt(strGroup2);
                                                                    float f10 = i5 / r18.zza;
                                                                    f4 = i17 / r18.zzb;
                                                                    f3 = f10;
                                                                } catch (NumberFormatException unused8) {
                                                                    String.valueOf(strZzL);
                                                                    zzeg.zzc("TtmlParser", "Ignoring region with malformed extent: ".concat(String.valueOf(strZzL)));
                                                                    zzaomVar = r47;
                                                                }
                                                            }
                                                            zzaomVar = r47;
                                                        }
                                                    } else {
                                                        f3 = 1.0f;
                                                        f4 = 1.0f;
                                                    }
                                                    strZzc3 = zzft.zzc(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                    if (strZzc3 != null) {
                                                        strZza2 = zzgss.zza(strZzc3);
                                                        iHashCode2 = strZza2.hashCode();
                                                        if (iHashCode2 != -1364013995) {
                                                            if (iHashCode2 != 92734940 && strZza2.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                                                                f5 = f + f4;
                                                                i3 = 2;
                                                            } else {
                                                                i3 = 0;
                                                                f5 = f;
                                                            }
                                                        } else if (strZza2.equals(TtmlNode.CENTER)) {
                                                            f5 = f + (f4 / 2.0f);
                                                            i3 = 1;
                                                        } else {
                                                            i3 = 0;
                                                            f5 = f;
                                                        }
                                                    } else {
                                                        i3 = 0;
                                                        f5 = f;
                                                    }
                                                    float f11 = 1.0f / i8;
                                                    strZzc4 = zzft.zzc(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_WRITING_MODE);
                                                    if (strZzc4 != null) {
                                                        strZza = zzgss.zza(strZzc4);
                                                        iHashCode = strZza.hashCode();
                                                        if (iHashCode != 3694) {
                                                            if (iHashCode != 3553396) {
                                                                if (iHashCode == 3553576 && strZza.equals(TtmlNode.VERTICAL_RL)) {
                                                                    i4 = 1;
                                                                }
                                                            } else if (strZza.equals(TtmlNode.VERTICAL_LR)) {
                                                                i4 = 2;
                                                            }
                                                            i4 = Integer.MIN_VALUE;
                                                        } else if (strZza.equals("tb")) {
                                                            i4 = 2;
                                                        } else {
                                                            i4 = Integer.MIN_VALUE;
                                                        }
                                                    } else {
                                                        i4 = Integer.MIN_VALUE;
                                                    }
                                                    zzaomVar = new zzaom(strZzc8, f2, f5, 0, i3, f3, f4, 1, f11, i4);
                                                } else {
                                                    str5 = strZzc9;
                                                }
                                                strZzL = str5;
                                                if (strZzL != null) {
                                                    str6 = str17;
                                                    matcher3 = zzb.matcher(strZzL);
                                                    str7 = str18;
                                                    matcher4 = zzf.matcher(strZzL);
                                                    if (matcher3.matches()) {
                                                        map2 = map4;
                                                        strGroup7 = matcher3.group(1);
                                                        if (strGroup7 != null) {
                                                            throw r47;
                                                        }
                                                        String str29 = strGroup7;
                                                        f7 = Float.parseFloat(strGroup7) / 100.0f;
                                                        strGroup8 = matcher3.group(2);
                                                        if (strGroup8 != null) {
                                                            throw r47;
                                                        }
                                                        String str210 = strGroup8;
                                                        f = Float.parseFloat(strGroup8) / 100.0f;
                                                        f2 = f7;
                                                    } else {
                                                        map2 = map4;
                                                        if (matcher4.matches()) {
                                                            zzeg.zzc("TtmlParser", "Ignoring region with unsupported origin: ".concat(strZzL));
                                                        } else if (r18 == 0) {
                                                            zzeg.zzc("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strZzL));
                                                        } else {
                                                            strGroup5 = matcher4.group(1);
                                                            if (strGroup5 != null) {
                                                                throw r47;
                                                            }
                                                            String str211 = strGroup5;
                                                            i6 = Integer.parseInt(strGroup5);
                                                            strGroup6 = matcher4.group(2);
                                                            if (strGroup6 != null) {
                                                                throw r47;
                                                            }
                                                            String str212 = strGroup6;
                                                            int i18 = Integer.parseInt(strGroup6);
                                                            float f12 = i6 / r18.zza;
                                                            f = i18 / r18.zzb;
                                                            f2 = f12;
                                                        }
                                                    }
                                                    zzaomVar = r47;
                                                } else {
                                                    str6 = str17;
                                                    map2 = map4;
                                                    str7 = str18;
                                                    f = 0.0f;
                                                    f2 = 0.0f;
                                                }
                                                strZzc2 = zzft.zzc(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_EXTENT);
                                                if (strZzc2 == null) {
                                                    strZzc2 = zzaooVar.zzN();
                                                }
                                                if (strZzc2 != null) {
                                                    matcher = zzb.matcher(strZzc2);
                                                    matcher2 = zzf.matcher(strZzc2);
                                                    if (matcher.matches()) {
                                                        strGroup3 = matcher.group(1);
                                                        if (strGroup3 != null) {
                                                            throw r47;
                                                        }
                                                        String str213 = strGroup3;
                                                        f6 = Float.parseFloat(strGroup3) / 100.0f;
                                                        strGroup4 = matcher.group(2);
                                                        if (strGroup4 != null) {
                                                            throw r47;
                                                        }
                                                        String str214 = strGroup4;
                                                        f3 = f6;
                                                        f4 = Float.parseFloat(strGroup4) / 100.0f;
                                                    } else {
                                                        if (matcher2.matches()) {
                                                            String.valueOf(strZzL);
                                                            zzeg.zzc("TtmlParser", "Ignoring region with unsupported extent: ".concat(String.valueOf(strZzL)));
                                                        } else if (r18 == 0) {
                                                            String.valueOf(strZzL);
                                                            zzeg.zzc("TtmlParser", "Ignoring region with missing tts:extent: ".concat(String.valueOf(strZzL)));
                                                        } else {
                                                            strGroup = matcher2.group(1);
                                                            if (strGroup != null) {
                                                                throw r47;
                                                            }
                                                            String str215 = strGroup;
                                                            i5 = Integer.parseInt(strGroup);
                                                            strGroup2 = matcher2.group(2);
                                                            if (strGroup2 != null) {
                                                                throw r47;
                                                            }
                                                            String str216 = strGroup2;
                                                            int i19 = Integer.parseInt(strGroup2);
                                                            float f13 = i5 / r18.zza;
                                                            f4 = i19 / r18.zzb;
                                                            f3 = f13;
                                                        }
                                                        zzaomVar = r47;
                                                    }
                                                } else {
                                                    f3 = 1.0f;
                                                    f4 = 1.0f;
                                                }
                                                strZzc3 = zzft.zzc(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_DISPLAY_ALIGN);
                                                if (strZzc3 != null) {
                                                    strZza2 = zzgss.zza(strZzc3);
                                                    iHashCode2 = strZza2.hashCode();
                                                    if (iHashCode2 != -1364013995) {
                                                        if (iHashCode2 != 92734940) {
                                                            i3 = 0;
                                                            f5 = f;
                                                        } else {
                                                            f5 = f + f4;
                                                            i3 = 2;
                                                        }
                                                    } else if (strZza2.equals(TtmlNode.CENTER)) {
                                                        f5 = f + (f4 / 2.0f);
                                                        i3 = 1;
                                                    } else {
                                                        i3 = 0;
                                                        f5 = f;
                                                    }
                                                } else {
                                                    i3 = 0;
                                                    f5 = f;
                                                }
                                                float f14 = 1.0f / i8;
                                                strZzc4 = zzft.zzc(xmlPullParserNewPullParser, TtmlNode.ATTR_TTS_WRITING_MODE);
                                                if (strZzc4 != null) {
                                                    strZza = zzgss.zza(strZzc4);
                                                    iHashCode = strZza.hashCode();
                                                    if (iHashCode != 3694) {
                                                        if (iHashCode != 3553396) {
                                                            if (iHashCode == 3553576) {
                                                                i4 = 1;
                                                            }
                                                        } else if (strZza.equals(TtmlNode.VERTICAL_LR)) {
                                                            i4 = 2;
                                                        }
                                                        i4 = Integer.MIN_VALUE;
                                                    } else if (strZza.equals("tb")) {
                                                        i4 = 2;
                                                    } else {
                                                        i4 = Integer.MIN_VALUE;
                                                    }
                                                } else {
                                                    i4 = Integer.MIN_VALUE;
                                                }
                                                zzaomVar = new zzaom(strZzc8, f2, f5, 0, i3, f3, f4, 1, f14, i4);
                                            }
                                            if (zzaomVar != 0) {
                                                map4 = map2;
                                                map4.put(zzaomVar.zza, zzaomVar);
                                            } else {
                                                map4 = map2;
                                            }
                                            str8 = str20;
                                            map = map6;
                                            str17 = str6;
                                            str3 = str7;
                                        } else {
                                            String str30 = str17;
                                            HashMap map7 = map5;
                                            str3 = str18;
                                            str4 = str19;
                                            if (zzft.zzb(xmlPullParserNewPullParser, str3)) {
                                                while (true) {
                                                    xmlPullParserNewPullParser.next();
                                                    str17 = str30;
                                                    if (!zzft.zzb(xmlPullParserNewPullParser, str17) || (strZzc = zzft.zzc(xmlPullParserNewPullParser, "id")) == null) {
                                                        map = map7;
                                                    } else {
                                                        map = map7;
                                                        map.put(strZzc, xmlPullParserNewPullParser.nextText());
                                                    }
                                                    if (!zzft.zza(xmlPullParserNewPullParser, str3)) {
                                                        str30 = str17;
                                                        map7 = map;
                                                    }
                                                }
                                            } else {
                                                map = map7;
                                                str17 = str30;
                                            }
                                        }
                                        if (zzft.zza(xmlPullParserNewPullParser, str8)) {
                                            zzaojVar2 = zzaojVar4;
                                            arrayDeque = arrayDeque2;
                                        } else {
                                            str18 = str3;
                                            map5 = map;
                                            str19 = str4;
                                            str20 = str8;
                                            str11 = str11;
                                        }
                                    }
                                    str8 = str20;
                                    if (zzft.zza(xmlPullParserNewPullParser, str8)) {
                                        zzaojVar2 = zzaojVar4;
                                        arrayDeque = arrayDeque2;
                                    } else {
                                        str18 = str3;
                                        map5 = map;
                                        str19 = str4;
                                        str20 = str8;
                                        str11 = str11;
                                    }
                                }
                            } else {
                                str11 = str11;
                                map = map5;
                                Object obj3 = TtmlNode.TAG_REGION;
                                try {
                                    int attributeCount = xmlPullParserNewPullParser.getAttributeCount();
                                    zzaoo zzaooVarZzd2 = zzd(xmlPullParserNewPullParser, r47);
                                    int i20 = 0;
                                    String str31 = str;
                                    long jZzg = C.TIME_UNSET;
                                    long jZzg2 = C.TIME_UNSET;
                                    long jZzg3 = C.TIME_UNSET;
                                    String[] strArr = null;
                                    String strSubstring = null;
                                    while (i20 < attributeCount) {
                                        String attributeName = xmlPullParserNewPullParser.getAttributeName(i20);
                                        String attributeValue6 = xmlPullParserNewPullParser.getAttributeValue(i20);
                                        switch (attributeName.hashCode()) {
                                            case -934795532:
                                                zzaojVar2 = zzaojVar4;
                                                obj = obj3;
                                                if (attributeName.equals(obj) && map4.containsKey(attributeValue6)) {
                                                    str31 = attributeValue6;
                                                }
                                                try {
                                                    i20++;
                                                    obj3 = obj;
                                                    zzaojVar4 = zzaojVar2;
                                                } catch (zzanh e) {
                                                    e = e;
                                                    arrayDeque = arrayDeque2;
                                                    zzeg.zzd("TtmlParser", "Suppressing parser error", e);
                                                    zzaojVar4 = zzaojVar2;
                                                    i7 = 1;
                                                    xmlPullParserNewPullParser.next();
                                                    eventType = xmlPullParserNewPullParser.getEventType();
                                                    arrayDeque2 = arrayDeque;
                                                    map5 = map;
                                                    str9 = str;
                                                    zzaojVar3 = zzaojVar;
                                                    str10 = str2;
                                                    str11 = str11;
                                                    obj2 = null;
                                                    r18 = r18;
                                                }
                                                break;
                                            case 99841:
                                                zzaojVar2 = zzaojVar4;
                                                if (attributeName.equals("dur")) {
                                                    jZzg3 = zzg(attributeValue6, zzaojVar2);
                                                }
                                                obj = obj3;
                                                i20++;
                                                obj3 = obj;
                                                zzaojVar4 = zzaojVar2;
                                                break;
                                            case 100571:
                                                zzaojVar2 = zzaojVar4;
                                                if (attributeName.equals("end")) {
                                                    jZzg = zzg(attributeValue6, zzaojVar2);
                                                }
                                                obj = obj3;
                                                i20++;
                                                obj3 = obj;
                                                zzaojVar4 = zzaojVar2;
                                                break;
                                            case 93616297:
                                                if (attributeName.equals("begin")) {
                                                    zzaojVar2 = zzaojVar4;
                                                    jZzg2 = zzg(attributeValue6, zzaojVar2);
                                                } else {
                                                    zzaojVar2 = zzaojVar4;
                                                }
                                                obj = obj3;
                                                i20++;
                                                obj3 = obj;
                                                zzaojVar4 = zzaojVar2;
                                                break;
                                            case 109780401:
                                                if (attributeName.equals("style")) {
                                                    String[] strArrZzc2 = zzc(attributeValue6);
                                                    if (strArrZzc2.length > 0) {
                                                        strArr = strArrZzc2;
                                                    }
                                                }
                                                zzaojVar2 = zzaojVar4;
                                                obj = obj3;
                                                i20++;
                                                obj3 = obj;
                                                zzaojVar4 = zzaojVar2;
                                                break;
                                            case 1292595405:
                                                if (attributeName.equals("backgroundImage")) {
                                                    try {
                                                        if (attributeValue6.startsWith("#")) {
                                                            strSubstring = attributeValue6.substring(1);
                                                        }
                                                    } catch (zzanh e2) {
                                                        e = e2;
                                                        zzaojVar2 = zzaojVar4;
                                                        arrayDeque = arrayDeque2;
                                                        zzeg.zzd("TtmlParser", "Suppressing parser error", e);
                                                        zzaojVar4 = zzaojVar2;
                                                        i7 = 1;
                                                        xmlPullParserNewPullParser.next();
                                                        eventType = xmlPullParserNewPullParser.getEventType();
                                                        arrayDeque2 = arrayDeque;
                                                        map5 = map;
                                                        str9 = str;
                                                        zzaojVar3 = zzaojVar;
                                                        str10 = str2;
                                                        str11 = str11;
                                                        obj2 = null;
                                                        r18 = r18;
                                                    }
                                                }
                                                zzaojVar2 = zzaojVar4;
                                                obj = obj3;
                                                i20++;
                                                obj3 = obj;
                                                zzaojVar4 = zzaojVar2;
                                                break;
                                            default:
                                                zzaojVar2 = zzaojVar4;
                                                obj = obj3;
                                                i20++;
                                                obj3 = obj;
                                                zzaojVar4 = zzaojVar2;
                                                break;
                                        }
                                    }
                                    zzaojVar2 = zzaojVar4;
                                    if (zzaoiVar3 != null) {
                                        zzaoiVar = zzaoiVar3;
                                        long j2 = zzaoiVar.zzd;
                                        if (j2 == C.TIME_UNSET) {
                                            zzaoiVar2 = zzaoiVar;
                                        } else {
                                            jZzg2 = jZzg2 != C.TIME_UNSET ? jZzg2 + j2 : -9223372036854775807L;
                                            if (jZzg != C.TIME_UNSET) {
                                                jZzg += j2;
                                                zzaoiVar2 = zzaoiVar;
                                            } else {
                                                zzaoiVar2 = zzaoiVar;
                                                jZzg = -9223372036854775807L;
                                            }
                                        }
                                    } else {
                                        zzaoiVar = zzaoiVar3;
                                        zzaoiVar2 = null;
                                    }
                                    if (jZzg != C.TIME_UNSET) {
                                        j = jZzg;
                                    } else {
                                        if (jZzg3 != C.TIME_UNSET) {
                                            jZzg = jZzg2 + jZzg3;
                                        } else {
                                            if (zzaoiVar2 != null) {
                                                jZzg = zzaoiVar2.zze;
                                                if (jZzg != C.TIME_UNSET) {
                                                }
                                            }
                                            j = -9223372036854775807L;
                                        }
                                        j = jZzg;
                                    }
                                    zzaoi zzaoiVarZzb = zzaoi.zzb(xmlPullParserNewPullParser.getName(), jZzg2, j, zzaooVarZzd2, strArr, str31, strSubstring, zzaoiVar2);
                                    arrayDeque = arrayDeque2;
                                    try {
                                        arrayDeque.push(zzaoiVarZzb);
                                        if (zzaoiVar != null) {
                                            zzaoiVar.zzd(zzaoiVarZzb);
                                        }
                                    } catch (zzanh e3) {
                                        e = e3;
                                        zzeg.zzd("TtmlParser", "Suppressing parser error", e);
                                        zzaojVar4 = zzaojVar2;
                                        i7 = 1;
                                    }
                                } catch (zzanh e4) {
                                    e = e4;
                                }
                            }
                            zzaojVar4 = zzaojVar2;
                            r17 = r18;
                            i8 = i8;
                        } else {
                            String name2 = xmlPullParserNewPullParser.getName();
                            StringBuilder sb = new StringBuilder(String.valueOf(name2).length() + 26);
                            sb.append(str11);
                            sb.append(name2);
                            zzeg.zzb("TtmlParser", sb.toString());
                            str11 = str11;
                            map = map5;
                            arrayDeque = arrayDeque2;
                        }
                        i7 = 1;
                    } else {
                        str2 = str10;
                        str11 = str11;
                        arrayDeque = arrayDeque2;
                        zzaojVar = zzaojVar3;
                        zzaopVar = zzaopVar;
                        i7 = i7;
                        map = map5;
                        if (eventType != 4) {
                            if (eventType == 3) {
                                if (xmlPullParserNewPullParser.getName().equals(TtmlNode.TAG_TT)) {
                                    zzaoi zzaoiVar4 = (zzaoi) arrayDeque.peek();
                                    if (zzaoiVar4 == null) {
                                        r17 = r18;
                                        throw null;
                                    }
                                    r17 = r18;
                                    zzaopVar = new zzaop(zzaoiVar4, map3, map4, map);
                                } else {
                                    r17 = r18;
                                    zzaopVar = zzaopVar;
                                }
                                arrayDeque.pop();
                                r18 = r18;
                            }
                            i7 = i7;
                        } else {
                            if (zzaoiVar3 == null) {
                                throw null;
                            }
                            zzaoiVar3.zzd(zzaoi.zza(xmlPullParserNewPullParser.getText()));
                            r17 = r18;
                        }
                    }
                    r17 = r18;
                    r17 = r18;
                    zzaopVar = zzaopVar;
                    r18 = r17;
                    i7 = i7;
                } else {
                    str = str9;
                    str2 = str10;
                    str11 = str11;
                    map = map5;
                    arrayDeque = arrayDeque2;
                    zzaojVar = zzaojVar3;
                    zzaopVar = zzaopVar;
                    i7 = i7;
                    if (eventType == 2) {
                        i7++;
                    } else {
                        if (eventType == 3) {
                            r17 = r18;
                            i7--;
                        }
                        r17 = r18;
                        r17 = r18;
                        zzaopVar = zzaopVar;
                        r18 = r17;
                        i7 = i7;
                    }
                    zzaopVar = zzaopVar;
                }
                xmlPullParserNewPullParser.next();
                eventType = xmlPullParserNewPullParser.getEventType();
                arrayDeque2 = arrayDeque;
                map5 = map;
                str9 = str;
                zzaojVar3 = zzaojVar;
                str10 = str2;
                str11 = str11;
                obj2 = null;
                r18 = r18;
            }
            zzaop zzaopVar2 = zzaopVar;
            if (zzaopVar2 != null) {
                return zzaopVar2;
            }
            throw null;
        } catch (IOException e5) {
            throw new IllegalStateException("Unexpected error when reading input.", e5);
        } catch (XmlPullParserException e6) {
            throw new IllegalStateException("Unable to decode source", e6);
        }
    }

    public zzaol() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.zzi = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }
}
