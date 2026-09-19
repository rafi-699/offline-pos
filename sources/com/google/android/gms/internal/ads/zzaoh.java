package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaoh {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzgww zze = zzgww.zzj("auto", "none");
    private static final zzgww zzf = zzgww.zzk(TtmlNode.TEXT_EMPHASIS_MARK_DOT, TtmlNode.TEXT_EMPHASIS_MARK_SESAME, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
    private static final zzgww zzg = zzgww.zzj(TtmlNode.TEXT_EMPHASIS_MARK_FILLED, "open");
    private static final zzgww zzh = zzgww.zzk(TtmlNode.ANNOTATION_POSITION_AFTER, TtmlNode.ANNOTATION_POSITION_BEFORE, TtmlNode.ANNOTATION_POSITION_OUTSIDE);
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaoh(int i, int i2, int i3) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004d  */
    /* JADX WARN: Code duplicated, block: B:30:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dc  */
    public static zzaoh zza(String str) {
        int i;
        if (str == null) {
            return null;
        }
        String strZza = zzgss.zza(str.trim());
        if (strZza.isEmpty()) {
            return null;
        }
        zzgww zzgwwVarZzq = zzgww.zzq(TextUtils.split(strZza, zzd));
        String str2 = (String) zzgxa.zzb(zzgyw.zza(zzh, zzgwwVarZzq), TtmlNode.ANNOTATION_POSITION_OUTSIDE);
        int iHashCode = str2.hashCode();
        int i2 = 2;
        if (iHashCode != -1106037339) {
            if (iHashCode == 92734940 && str2.equals(TtmlNode.ANNOTATION_POSITION_AFTER)) {
                i = 2;
            } else {
                i = 1;
            }
        } else if (str2.equals(TtmlNode.ANNOTATION_POSITION_OUTSIDE)) {
            i = -2;
        } else {
            i = 1;
        }
        zzgyv zzgyvVarZza = zzgyw.zza(zze, zzgwwVarZzq);
        int i3 = 0;
        if (zzgyvVarZza.isEmpty()) {
            zzgyv zzgyvVarZza2 = zzgyw.zza(zzg, zzgwwVarZzq);
            zzgyv zzgyvVarZza3 = zzgyw.zza(zzf, zzgwwVarZzq);
            if (zzgyvVarZza2.isEmpty() && zzgyvVarZza3.isEmpty()) {
                i2 = -1;
            } else {
                String str3 = (String) zzgxa.zzb(zzgyvVarZza2, TtmlNode.TEXT_EMPHASIS_MARK_FILLED);
                i3 = (str3.hashCode() == 3417674 && str3.equals("open")) ? 2 : 1;
                String str4 = (String) zzgxa.zzb(zzgyvVarZza3, TtmlNode.TEXT_EMPHASIS_MARK_CIRCLE);
                int iHashCode2 = str4.hashCode();
                if (iHashCode2 != -905816648) {
                    if (iHashCode2 != 99657 || !str4.equals(TtmlNode.TEXT_EMPHASIS_MARK_DOT)) {
                        i2 = 1;
                    }
                } else if (str4.equals(TtmlNode.TEXT_EMPHASIS_MARK_SESAME)) {
                    i2 = 3;
                } else {
                    i2 = 1;
                }
            }
        } else {
            String str5 = (String) zzgyvVarZza.iterator().next();
            if (str5.hashCode() == 3387192 && str5.equals("none")) {
                i2 = 0;
            } else {
                i2 = -1;
            }
        }
        return new zzaoh(i2, i3, i);
    }
}
