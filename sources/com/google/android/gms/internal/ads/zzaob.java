package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.C;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaob implements zzanl {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;
    private final zzaoa zzc;
    private final zzet zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzaob() {
        this(null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void zzb(zzet zzetVar, Charset charset) {
        while (true) {
            String strZzN = zzetVar.zzN(charset);
            if (strZzN == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strZzN)) {
                while (true) {
                    String strZzN2 = zzetVar.zzN(charset);
                    if (strZzN2 == null || (zzetVar.zzd() != 0 && zzetVar.zzp(charset) == 91)) {
                        break;
                    }
                    String[] strArrSplit = strZzN2.split(":");
                    if (strArrSplit.length == 2) {
                        String strZza = zzgss.zza(strArrSplit[0].trim());
                        switch (strZza.hashCode()) {
                            case 1879649548:
                                if (strZza.equals("playresx")) {
                                    this.zzf = Float.parseFloat(strArrSplit[1].trim());
                                }
                                break;
                            case 1879649549:
                                if (strZza.equals("playresy")) {
                                    try {
                                        this.zzg = Float.parseFloat(strArrSplit[1].trim());
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                                break;
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strZzN)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzaoc zzaocVarZza = null;
                while (true) {
                    String strZzN3 = zzetVar.zzN(charset);
                    if (strZzN3 != null && (zzetVar.zzd() == 0 || zzetVar.zzp(charset) != 91)) {
                        if (strZzN3.startsWith("Format:")) {
                            zzaocVarZza = zzaoc.zza(strZzN3);
                        } else if (strZzN3.startsWith("Style:")) {
                            if (zzaocVarZza == null) {
                                zzeg.zzc("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strZzN3));
                            } else {
                                zzaoe zzaoeVarZza = zzaoe.zza(strZzN3, zzaocVarZza);
                                if (zzaoeVarZza != null) {
                                    linkedHashMap.put(zzaoeVarZza.zza, zzaoeVarZza);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strZzN)) {
                zzeg.zzb("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strZzN)) {
                return;
            }
        }
    }

    private static long zzc(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return C.TIME_UNSET;
        }
        String strGroup = matcher.group(1);
        String str2 = zzfl.zza;
        long j = Long.parseLong(strGroup) * 3600000000L;
        long j2 = Long.parseLong(matcher.group(2)) * 60000000;
        return j + j2 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    private static float zzd(int i) {
        if (i == 0) {
            return 0.05f;
        }
        if (i != 1) {
            return i != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zze(long j, List list, List list2) {
        int i;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j) {
                i = size + 1;
                break;
            }
        }
        list.add(i, Long.valueOf(j));
        list2.add(i, i == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i - 1)));
        return i;
    }

    /* JADX WARN: Code duplicated, block: B:127:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:143:0x0316 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzanl
    public final void zza(byte[] bArr, int i, int i2, zzank zzankVar, zzdt zzdtVar) {
        zzaoa zzaoaVarZza;
        zzaoa zzaoaVar;
        int i3;
        Layout.Alignment alignment;
        int i4;
        int i5;
        int i6;
        Integer num;
        int i7;
        zzaob zzaobVar = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        zzet zzetVar = zzaobVar.zzd;
        zzetVar.zzb(bArr, i + i2);
        zzetVar.zzh(i);
        Charset charsetZzR = zzetVar.zzR();
        if (charsetZzR == null) {
            charsetZzR = StandardCharsets.UTF_8;
        }
        if (zzaobVar.zzb) {
            zzaoaVarZza = zzaobVar.zzc;
        } else {
            zzaobVar.zzb(zzetVar, charsetZzR);
            zzaoaVarZza = null;
        }
        while (true) {
            String strZzN = zzetVar.zzN(charsetZzR);
            if (strZzN == null) {
                int i8 = 0;
                while (i8 < arrayList.size()) {
                    List list = (List) arrayList.get(i8);
                    if (!list.isEmpty()) {
                        if (i8 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        long jLongValue = ((Long) arrayList2.get(i8)).longValue();
                        zzdtVar.zza(new zzand(list, jLongValue, ((Long) arrayList2.get(i8 + 1)).longValue() - jLongValue));
                    } else if (i8 == 0) {
                        i8 = 0;
                        if (i8 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        long jLongValue2 = ((Long) arrayList2.get(i8)).longValue();
                        zzdtVar.zza(new zzand(list, jLongValue2, ((Long) arrayList2.get(i8 + 1)).longValue() - jLongValue2));
                    }
                    i8++;
                }
                return;
            }
            if (strZzN.startsWith("Format:")) {
                zzaoaVarZza = zzaoa.zza(strZzN);
            } else {
                if (strZzN.startsWith("Dialogue:")) {
                    if (zzaoaVarZza == null) {
                        zzeg.zzc("SsaParser", "Skipping dialogue line before complete format: ".concat(strZzN));
                    } else {
                        zzgtj.zza(strZzN.startsWith("Dialogue:"));
                        String strSubstring = strZzN.substring(9);
                        int i9 = zzaoaVarZza.zzf;
                        String[] strArrSplit = strSubstring.split(",", i9);
                        if (strArrSplit.length != i9) {
                            zzeg.zzc("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(strZzN));
                        } else {
                            int i10 = zzaoaVarZza.zza;
                            if (i10 != -1) {
                                try {
                                    i3 = Integer.parseInt(strArrSplit[i10].trim());
                                } catch (RuntimeException unused) {
                                    String str = strArrSplit[zzaoaVarZza.zza];
                                    String.valueOf(str);
                                    zzeg.zzc("SsaParser", "Fail to parse layer: ".concat(String.valueOf(str)));
                                    i3 = 0;
                                }
                            } else {
                                i3 = 0;
                            }
                            long jZzc = zzc(strArrSplit[zzaoaVarZza.zzb]);
                            if (jZzc == C.TIME_UNSET) {
                                zzeg.zzc("SsaParser", "Skipping invalid timing: ".concat(strZzN));
                            } else {
                                long jZzc2 = zzc(strArrSplit[zzaoaVarZza.zzc]);
                                if (jZzc2 == C.TIME_UNSET || jZzc2 <= jZzc) {
                                    zzaoaVar = zzaoaVarZza;
                                    zzetVar = zzetVar;
                                    zzeg.zzc("SsaParser", "Skipping invalid timing: ".concat(strZzN));
                                } else {
                                    Map map = zzaobVar.zze;
                                    zzaoe zzaoeVar = (map == null || (i7 = zzaoaVarZza.zzd) == -1) ? null : (zzaoe) map.get(strArrSplit[i7].trim());
                                    String str2 = strArrSplit[zzaoaVarZza.zze];
                                    zzaod zzaodVarZza = zzaod.zza(str2);
                                    String strReplace = zzaod.zzb(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f = zzaobVar.zzf;
                                    float f2 = zzaobVar.zzg;
                                    SpannableString spannableString = new SpannableString(strReplace);
                                    zzcw zzcwVar = new zzcw();
                                    zzcwVar.zza(spannableString);
                                    zzcwVar.zzq(i3);
                                    if (zzaoeVar != null) {
                                        Integer num2 = zzaoeVar.zzc;
                                        zzaoaVar = zzaoaVarZza;
                                        if (num2 != null) {
                                            spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                        }
                                        if (zzaoeVar.zzj == 3 && (num = zzaoeVar.zzd) != null) {
                                            spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                        }
                                        float f3 = zzaoeVar.zze;
                                        if (f3 != -3.4028235E38f && f2 != -3.4028235E38f) {
                                            zzcwVar.zzl(f3 / f2, 1);
                                        }
                                        boolean z = zzaoeVar.zzf;
                                        if (z && zzaoeVar.zzg) {
                                            i5 = 0;
                                            i6 = 33;
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                        } else {
                                            i5 = 0;
                                            i6 = 33;
                                            if (z) {
                                                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                            } else if (zzaoeVar.zzg) {
                                                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                            }
                                        }
                                        if (zzaoeVar.zzh) {
                                            spannableString.setSpan(new UnderlineSpan(), i5, spannableString.length(), i6);
                                        }
                                        if (zzaoeVar.zzi) {
                                            spannableString.setSpan(new StrikethroughSpan(), i5, spannableString.length(), i6);
                                        }
                                    } else {
                                        zzaoaVar = zzaoaVarZza;
                                        zzetVar = zzetVar;
                                        f = f;
                                    }
                                    int i11 = zzaodVarZza.zza;
                                    if (i11 == -1) {
                                        i11 = zzaoeVar != null ? zzaoeVar.zzb : -1;
                                    }
                                    switch (i11) {
                                        case 0:
                                        default:
                                            StringBuilder sb = new StringBuilder(String.valueOf(i11).length() + 19);
                                            sb.append("Unknown alignment: ");
                                            sb.append(i11);
                                            zzeg.zzc("SsaParser", sb.toString());
                                        case -1:
                                            alignment = null;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment = Layout.Alignment.ALIGN_NORMAL;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment = Layout.Alignment.ALIGN_CENTER;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                            break;
                                    }
                                    zzcwVar.zzd(alignment);
                                    int i12 = Integer.MIN_VALUE;
                                    switch (i11) {
                                        case 0:
                                        default:
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(i11).length() + 19);
                                            sb2.append("Unknown alignment: ");
                                            sb2.append(i11);
                                            zzeg.zzc("SsaParser", sb2.toString());
                                        case -1:
                                            i4 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            i4 = 0;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i4 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i4 = 2;
                                            break;
                                    }
                                    zzcwVar.zzj(i4);
                                    switch (i11) {
                                        case -1:
                                            break;
                                        case 0:
                                        default:
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(i11).length() + 19);
                                            sb3.append("Unknown alignment: ");
                                            sb3.append(i11);
                                            zzeg.zzc("SsaParser", sb3.toString());
                                            break;
                                        case 1:
                                        case 2:
                                        case 3:
                                            i12 = 2;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            i12 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            i12 = 0;
                                            break;
                                    }
                                    zzcwVar.zzg(i12);
                                    PointF pointF = zzaodVarZza.zzb;
                                    if (pointF == null || f2 == -3.4028235E38f || f == -3.4028235E38f) {
                                        zzcwVar.zzi(zzd(zzcwVar.zzk()));
                                        zzcwVar.zzf(zzd(zzcwVar.zzh()), 0);
                                    } else {
                                        zzcwVar.zzi(pointF.x / f);
                                        zzcwVar.zzf(pointF.y / f2, 0);
                                    }
                                    zzcx zzcxVarZzr = zzcwVar.zzr();
                                    int iZze = zze(jZzc2, arrayList2, arrayList);
                                    for (int iZze2 = zze(jZzc, arrayList2, arrayList); iZze2 < iZze; iZze2++) {
                                        ((List) arrayList.get(iZze2)).add(zzcxVarZzr);
                                    }
                                }
                            }
                        }
                    }
                    zzaoaVar = zzaoaVarZza;
                    zzetVar = zzetVar;
                } else {
                    zzaoaVar = zzaoaVarZza;
                    zzetVar = zzetVar;
                }
                zzaobVar = this;
                charsetZzR = charsetZzR;
                zzaoaVarZza = zzaoaVar;
                zzetVar = zzetVar;
            }
        }
    }

    public zzaob(List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzet();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzj = zzfl.zzj((byte[]) list.get(0));
        zzgtj.zza(strZzj.startsWith("Format:"));
        zzaoa zzaoaVarZza = zzaoa.zza(strZzj);
        zzaoaVarZza.getClass();
        this.zzc = zzaoaVarZza;
        zzb(new zzet((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }
}
