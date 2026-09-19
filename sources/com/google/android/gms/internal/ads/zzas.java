package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzas {
    public static final /* synthetic */ int zza = 0;
    private static final ArrayList zzb = new ArrayList();
    private static final Pattern zzc = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static boolean zza(String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(zzj(str));
    }

    public static boolean zzb(String str) {
        return "video".equals(zzj(str));
    }

    public static boolean zzc(String str) {
        return "image".equals(zzj(str)) || MimeTypes.APPLICATION_EXTERNALLY_LOADED_IMAGE.equals(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:80:0x00eb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:81:0x00ec A[RETURN] */
    public static boolean zzd(String str, String str2) {
        zzar zzarVarZzi;
        int iZza;
        if (str == null) {
            return false;
        }
        switch (str.hashCode()) {
            case -2123537834:
                if (str.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                    return true;
                }
                return false;
            case -1354451219:
                if (str.equals(MimeTypes.APPLICATION_AIT)) {
                    return true;
                }
                return false;
            case -1348231605:
                if (str.equals(MimeTypes.APPLICATION_ICY)) {
                    return true;
                }
                return false;
            case -1265048566:
                if (str.equals(MimeTypes.APPLICATION_CAMERA_MOTION)) {
                    return true;
                }
                return false;
            case -1248341703:
                if (str.equals(MimeTypes.APPLICATION_ID3)) {
                    return true;
                }
                return false;
            case -432837260:
                if (str.equals(MimeTypes.AUDIO_MPEG_L1)) {
                    return true;
                }
                return false;
            case -432837259:
                if (str.equals(MimeTypes.AUDIO_MPEG_L2)) {
                    return true;
                }
                return false;
            case -53558318:
                return (!str.equals(MimeTypes.AUDIO_AAC) || str2 == null || (zzarVarZzi = zzi(str2)) == null || (iZza = zzarVarZzi.zza()) == 0 || iZza == 16) ? false : true;
            case -43764892:
                if (str.equals("application/meta")) {
                    return true;
                }
                return false;
            case 187078296:
                if (str.equals(MimeTypes.AUDIO_AC3)) {
                    return true;
                }
                return false;
            case 187094639:
                if (str.equals(MimeTypes.AUDIO_RAW)) {
                    return true;
                }
                return false;
            case 469933706:
                if (str.equals(MimeTypes.APPLICATION_MEDIA3_CUES)) {
                    return true;
                }
                return false;
            case 1054472807:
                if (str.equals("application/x-itut-t35")) {
                    return true;
                }
                return false;
            case 1154383568:
                if (str.equals(MimeTypes.APPLICATION_EMSG)) {
                    return true;
                }
                return false;
            case 1331836563:
                if (str.equals("video/apv")) {
                    return true;
                }
                return false;
            case 1504578661:
                if (str.equals(MimeTypes.AUDIO_E_AC3)) {
                    return true;
                }
                return false;
            case 1504619009:
                if (str.equals(MimeTypes.AUDIO_FLAC)) {
                    return true;
                }
                return false;
            case 1504831518:
                if (str.equals(MimeTypes.AUDIO_MPEG)) {
                    return true;
                }
                return false;
            case 1652648887:
                if (str.equals(MimeTypes.APPLICATION_SCTE35)) {
                    return true;
                }
                return false;
            case 1903231877:
                if (str.equals(MimeTypes.AUDIO_ALAW)) {
                    return true;
                }
                return false;
            case 1903589369:
                if (str.equals(MimeTypes.AUDIO_MLAW)) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public static String zze(int i) {
        if (i == 32) {
            return MimeTypes.VIDEO_MP4V;
        }
        if (i == 33) {
            return MimeTypes.VIDEO_H264;
        }
        if (i == 35) {
            return MimeTypes.VIDEO_H265;
        }
        if (i == 64) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i == 163) {
            return MimeTypes.VIDEO_VC1;
        }
        if (i == 177) {
            return MimeTypes.VIDEO_VP9;
        }
        if (i == 221) {
            return MimeTypes.AUDIO_VORBIS;
        }
        if (i == 165) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i == 166) {
            return MimeTypes.AUDIO_E_AC3;
        }
        switch (i) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return MimeTypes.VIDEO_MPEG2;
            case 102:
            case 103:
            case 104:
                return MimeTypes.AUDIO_AAC;
            case 105:
            case 107:
                return MimeTypes.AUDIO_MPEG;
            case 106:
                return MimeTypes.VIDEO_MPEG;
            case 108:
                return "image/jpeg";
            default:
                switch (i) {
                    case 169:
                    case TsExtractor.TS_STREAM_TYPE_AC4 /* 172 */:
                        return MimeTypes.AUDIO_DTS;
                    case 170:
                    case 171:
                        return MimeTypes.AUDIO_DTS_HD;
                    case 173:
                        return MimeTypes.AUDIO_OPUS;
                    case 174:
                        return MimeTypes.AUDIO_AC4;
                    default:
                        return null;
                }
        }
    }

    public static int zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zza(str)) {
            return 1;
        }
        if (zzb(str)) {
            return 2;
        }
        if ("text".equals(zzj(str)) || MimeTypes.APPLICATION_MEDIA3_CUES.equals(str) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str)) {
            return 3;
        }
        if (zzc(str)) {
            return 4;
        }
        if (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str) || MimeTypes.APPLICATION_ICY.equals(str) || MimeTypes.APPLICATION_AIT.equals(str) || "application/meta".equals(str) || "application/x-itut-t35".equals(str)) {
            return 5;
        }
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        ArrayList arrayList = zzb;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            zzaq zzaqVar = (zzaq) arrayList.get(i);
            String str2 = zzaqVar.zza;
            if (str.equals(null)) {
                int i2 = zzaqVar.zzb;
                return 0;
            }
        }
        return -1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:60:0x00a0 A[RETURN] */
    public static int zzg(String str, String str2) {
        switch (str) {
            case "audio/eac3-joc":
                return 18;
            case "audio/vnd.dts.hd;profile=lbr":
                return 8;
            case "audio/vnd.dts":
                return 7;
            case "audio/mp4a-latm":
                if (!str.equals(MimeTypes.AUDIO_AAC) || str2 == null || (r3 = zzi(str2)) == null) {
                    return 0;
                }
            case "audio/ac3":
                return 5;
            case "audio/ac4":
                return 17;
            case "audio/dsd":
                return 31;
            case "audio/vnd.dts.uhd;profile=p2":
                return 30;
            case "audio/eac3":
                return 6;
            case "audio/mpeg":
                return 9;
            case "audio/opus":
                return 20;
            case "audio/vnd.dts.hd":
                return 8;
            case "audio/true-hd":
                return 14;
            default:
                return 0;
        }
    }

    public static String zzh(String str) {
        if (str == null) {
            return null;
        }
        String strZza = zzgss.zza(str);
        switch (strZza.hashCode()) {
            case -1833600100:
                return strZza.equals("video/x-mvhevc") ? "video/mv-hevc" : strZza;
            case -1007807498:
                return strZza.equals("audio/x-flac") ? MimeTypes.AUDIO_FLAC : strZza;
            case -979095690:
                return strZza.equals("application/x-mpegurl") ? MimeTypes.APPLICATION_M3U8 : strZza;
            case -586683234:
                return strZza.equals("audio/x-wav") ? MimeTypes.AUDIO_WAV : strZza;
            case -432836268:
                return strZza.equals("audio/mpeg-l1") ? MimeTypes.AUDIO_MPEG_L1 : strZza;
            case -432836267:
                return strZza.equals("audio/mpeg-l2") ? MimeTypes.AUDIO_MPEG_L2 : strZza;
            case 187090231:
                return strZza.equals("audio/mp3") ? MimeTypes.AUDIO_MPEG : strZza;
            default:
                return strZza;
        }
    }

    static zzar zzi(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        String strGroup2 = matcher.group(2);
        try {
            return new zzar(Integer.parseInt(strGroup, 16), strGroup2 != null ? Integer.parseInt(strGroup2) : 0);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private static String zzj(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, iIndexOf);
    }
}
