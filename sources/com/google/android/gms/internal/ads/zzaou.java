package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.facebook.appevents.UserDataStore;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaou {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzet zzc = new zzet();
    private final StringBuilder zzd = new StringBuilder();

    static void zzb(zzet zzetVar) {
        while (true) {
            for (boolean z = true; zzetVar.zzd() > 0 && z; z = false) {
                char c = (char) zzetVar.zzi()[zzetVar.zzg()];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    zzetVar.zzk(1);
                } else {
                    int iZzg = zzetVar.zzg();
                    int iZze = zzetVar.zze();
                    byte[] bArrZzi = zzetVar.zzi();
                    if (iZzg + 2 <= iZze) {
                        int i = iZzg + 1;
                        if (bArrZzi[iZzg] == 47) {
                            int i2 = iZzg + 2;
                            if (bArrZzi[i] == 42) {
                                while (true) {
                                    int i3 = i2 + 1;
                                    if (i3 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzi[i2]) == '*' && ((char) bArrZzi[i3]) == '/') {
                                        iZze = i2 + 2;
                                        i2 = iZze;
                                    } else {
                                        i2 = i3;
                                    }
                                }
                                zzetVar.zzk(iZze - zzetVar.zzg());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    static String zzc(zzet zzetVar, StringBuilder sb) {
        zzb(zzetVar);
        if (zzetVar.zzd() == 0) {
            return null;
        }
        String strZzd = zzd(zzetVar, sb);
        if (!strZzd.isEmpty()) {
            return strZzd;
        }
        char cZzs = (char) zzetVar.zzs();
        StringBuilder sb2 = new StringBuilder(String.valueOf(cZzs).length());
        sb2.append(cZzs);
        return sb2.toString();
    }

    private static String zzd(zzet zzetVar, StringBuilder sb) {
        char c;
        sb.setLength(0);
        int iZzg = zzetVar.zzg();
        int iZze = zzetVar.zze();
        loop0: while (true) {
            boolean z = false;
            while (true) {
                if (iZzg < iZze && !z) {
                    c = (char) zzetVar.zzi()[iZzg];
                    if ((c >= 'A' && c <= 'Z') || ((c >= 'a' && c <= 'z') || ((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                        break;
                    }
                    z = true;
                } else {
                    break loop0;
                }
            }
            sb.append(c);
            iZzg++;
        }
        zzetVar.zzk(iZzg - zzetVar.zzg());
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:102:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:105:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:108:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:110:0x0203  */
    /* JADX WARN: Code duplicated, block: B:116:0x0216  */
    /* JADX WARN: Code duplicated, block: B:118:0x021c  */
    /* JADX WARN: Code duplicated, block: B:120:0x0224  */
    /* JADX WARN: Code duplicated, block: B:122:0x022c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0231  */
    /* JADX WARN: Code duplicated, block: B:125:0x0239  */
    /* JADX WARN: Code duplicated, block: B:126:0x023e  */
    /* JADX WARN: Code duplicated, block: B:128:0x0246  */
    /* JADX WARN: Code duplicated, block: B:130:0x024e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0253  */
    /* JADX WARN: Code duplicated, block: B:133:0x025b  */
    /* JADX WARN: Code duplicated, block: B:135:0x0263  */
    /* JADX WARN: Code duplicated, block: B:136:0x0268  */
    /* JADX WARN: Code duplicated, block: B:138:0x0270  */
    /* JADX WARN: Code duplicated, block: B:140:0x0280  */
    /* JADX WARN: Code duplicated, block: B:141:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:143:0x02b4  */
    /* JADX WARN: Code duplicated, block: B:145:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:150:0x02c8  */
    /* JADX WARN: Code duplicated, block: B:152:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:153:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:155:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:171:0x02f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:172:0x02f2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:190:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:192:0x02f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x003d  */
    /* JADX WARN: Code duplicated, block: B:96:0x01be  */
    /* JADX WARN: Code duplicated, block: B:97:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:99:0x01cf  */
    public final List zza(zzet zzetVar) {
        String strTrim;
        String string;
        Matcher matcher;
        String strGroup;
        int iHashCode;
        boolean z;
        StringBuilder sb = this.zzd;
        int i = 0;
        sb.setLength(0);
        int iZzg = zzetVar.zzg();
        while (!TextUtils.isEmpty(zzetVar.zzN(StandardCharsets.UTF_8))) {
        }
        zzet zzetVar2 = this.zzc;
        zzetVar2.zzb(zzetVar.zzi(), zzetVar.zzg());
        zzetVar2.zzh(iZzg);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzb(zzetVar2);
            if (zzetVar2.zzd() >= 5 && "::cue".equals(zzetVar2.zzK(5, StandardCharsets.UTF_8))) {
                int iZzg2 = zzetVar2.zzg();
                String strZzc = zzc(zzetVar2, sb);
                if (strZzc == null) {
                    strTrim = null;
                } else if ("{".equals(strZzc)) {
                    zzetVar2.zzh(iZzg2);
                    strTrim = "";
                } else {
                    if ("(".equals(strZzc)) {
                        int iZzg3 = zzetVar2.zzg();
                        int iZze = zzetVar2.zze();
                        int i2 = i;
                        while (iZzg3 < iZze && i2 == 0) {
                            int i3 = iZzg3 + 1;
                            i2 = ((char) zzetVar2.zzi()[iZzg3]) == ')' ? 1 : i;
                            iZzg3 = i3;
                        }
                        strTrim = zzetVar2.zzK((iZzg3 - 1) - zzetVar2.zzg(), StandardCharsets.UTF_8).trim();
                    } else {
                        strTrim = null;
                    }
                    if (!")".equals(zzc(zzetVar2, sb))) {
                        strTrim = null;
                    }
                }
            } else {
                strTrim = null;
            }
            if (strTrim == null || !"{".equals(zzc(zzetVar2, sb))) {
                break;
            }
            zzaov zzaovVar = new zzaov();
            if (!strTrim.isEmpty()) {
                int iIndexOf = strTrim.indexOf(91);
                if (iIndexOf != -1) {
                    Matcher matcher2 = zza.matcher(strTrim.substring(iIndexOf));
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        strGroup2.getClass();
                        zzaovVar.zzd(strGroup2);
                    }
                    strTrim = strTrim.substring(i, iIndexOf);
                }
                String str = zzfl.zza;
                String[] strArrSplit = strTrim.split("\\.", -1);
                String str2 = strArrSplit[i];
                int iIndexOf2 = str2.indexOf(35);
                if (iIndexOf2 != -1) {
                    zzaovVar.zzb(str2.substring(i, iIndexOf2));
                    zzaovVar.zza(str2.substring(iIndexOf2 + 1));
                } else {
                    zzaovVar.zzb(str2);
                }
                int length = strArrSplit.length;
                if (length > 1) {
                    zzaovVar.zzc((String[]) Arrays.copyOfRange(strArrSplit, 1, length));
                }
            }
            int i4 = i;
            String strZzc2 = null;
            while (i4 == 0) {
                int iZzg4 = zzetVar2.zzg();
                strZzc2 = zzc(zzetVar2, sb);
                int i5 = (strZzc2 == null || "}".equals(strZzc2)) ? 1 : i;
                if (i5 == 0) {
                    zzetVar2.zzh(iZzg4);
                    zzb(zzetVar2);
                    String strZzd = zzd(zzetVar2, sb);
                    if (!strZzd.isEmpty() && ":".equals(zzc(zzetVar2, sb))) {
                        zzb(zzetVar2);
                        StringBuilder sb2 = new StringBuilder();
                        int i6 = i;
                        while (true) {
                            if (i6 != 0) {
                                string = sb2.toString();
                                break;
                            }
                            int iZzg5 = zzetVar2.zzg();
                            String strZzc3 = zzc(zzetVar2, sb);
                            if (strZzc3 == null) {
                                string = null;
                                break;
                            }
                            if ("}".equals(strZzc3) || ";".equals(strZzc3)) {
                                zzetVar2.zzh(iZzg5);
                                i6 = 1;
                            } else {
                                sb2.append(strZzc3);
                            }
                        }
                        if (string != null && !string.isEmpty()) {
                            int iZzg6 = zzetVar2.zzg();
                            String strZzc4 = zzc(zzetVar2, sb);
                            if (";".equals(strZzc4)) {
                                if ("color".equals(strZzd)) {
                                    zzaovVar.zzn(zzdr.zzb(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzaovVar.zzq(zzdr.zzb(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzaovVar.zzw(1);
                                    } else if ("under".equals(string)) {
                                        zzaovVar.zzw(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if (TtmlNode.COMBINE_ALL.equals(string)) {
                                        z = true;
                                    } else {
                                        z = true;
                                    }
                                    zzaovVar.zzy(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if (TtmlNode.UNDERLINE.equals(string)) {
                                        zzaovVar.zzh(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzaovVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if (TtmlNode.BOLD.equals(string)) {
                                        zzaovVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if (TtmlNode.ITALIC.equals(string)) {
                                        zzaovVar.zzj(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzgss.zza(string));
                                    if (matcher.matches()) {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode == 3592) {
                                                }
                                                throw new IllegalStateException();
                                            }
                                            if (strGroup.equals(UserDataStore.EMAIL)) {
                                                throw new IllegalStateException();
                                            }
                                            zzaovVar.zzt(2);
                                            String strGroup3 = matcher.group(1);
                                            strGroup3.getClass();
                                            zzaovVar.zzs(Float.parseFloat(strGroup3));
                                        } else {
                                            if (strGroup.equals("%")) {
                                                throw new IllegalStateException();
                                            }
                                            zzaovVar.zzt(3);
                                            String strGroup4 = matcher.group(1);
                                            strGroup4.getClass();
                                            zzaovVar.zzs(Float.parseFloat(strGroup4));
                                        }
                                    } else {
                                        StringBuilder sb3 = new StringBuilder(string.length() + 22);
                                        sb3.append("Invalid font-size: '");
                                        sb3.append(string);
                                        sb3.append("'.");
                                        zzeg.zzc("WebvttCssParser", sb3.toString());
                                    }
                                } else {
                                    continue;
                                }
                            } else if ("}".equals(strZzc4)) {
                                zzetVar2.zzh(iZzg6);
                                if ("color".equals(strZzd)) {
                                    zzaovVar.zzn(zzdr.zzb(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzaovVar.zzq(zzdr.zzb(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzaovVar.zzw(1);
                                    } else if ("under".equals(string)) {
                                        zzaovVar.zzw(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if (TtmlNode.COMBINE_ALL.equals(string) || string.startsWith("digits")) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    zzaovVar.zzy(z);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if (TtmlNode.UNDERLINE.equals(string)) {
                                        zzaovVar.zzh(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzaovVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if (TtmlNode.BOLD.equals(string)) {
                                        zzaovVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if (TtmlNode.ITALIC.equals(string)) {
                                        zzaovVar.zzj(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzgss.zza(string));
                                    if (matcher.matches()) {
                                        StringBuilder sb4 = new StringBuilder(string.length() + 22);
                                        sb4.append("Invalid font-size: '");
                                        sb4.append(string);
                                        sb4.append("'.");
                                        zzeg.zzc("WebvttCssParser", sb4.toString());
                                    } else {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode == 3592 || !strGroup.equals("px")) {
                                                    throw new IllegalStateException();
                                                }
                                                zzaovVar.zzt(1);
                                                String strGroup5 = matcher.group(1);
                                                strGroup5.getClass();
                                                zzaovVar.zzs(Float.parseFloat(strGroup5));
                                            } else {
                                                if (strGroup.equals(UserDataStore.EMAIL)) {
                                                    throw new IllegalStateException();
                                                }
                                                zzaovVar.zzt(2);
                                                String strGroup6 = matcher.group(1);
                                                strGroup6.getClass();
                                                zzaovVar.zzs(Float.parseFloat(strGroup6));
                                            }
                                        } else {
                                            if (strGroup.equals("%")) {
                                                throw new IllegalStateException();
                                            }
                                            zzaovVar.zzt(3);
                                            String strGroup7 = matcher.group(1);
                                            strGroup7.getClass();
                                            zzaovVar.zzs(Float.parseFloat(strGroup7));
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
                i4 = i5;
                i = 0;
            }
            if ("}".equals(strZzc2)) {
                arrayList.add(zzaovVar);
            }
            i = 0;
        }
        return arrayList;
    }
}
