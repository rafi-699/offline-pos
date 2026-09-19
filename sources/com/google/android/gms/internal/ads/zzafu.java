package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.ts.TsExtractor;
import com.google.common.net.HttpHeaders;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzafu implements zzage {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};
    private static final zzaft zzc = new zzaft(zzafr.zza);
    private static final zzaft zzd = new zzaft(zzafq.zza);
    private zzgwm zze;
    private final zzanj zzf = new zzane();

    @Override // com.google.android.gms.internal.ads.zzage
    public final synchronized zzafy[] zza() {
        return zzb(Uri.EMPTY, new HashMap());
    }

    /* JADX WARN: Code duplicated, block: B:116:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:12:0x0043  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.ads.zzage
    public final synchronized zzafy[] zzb(Uri uri, Map map) {
        ArrayList arrayList;
        int i;
        int i2;
        arrayList = new ArrayList(21);
        List list = (List) map.get(HttpHeaders.CONTENT_TYPE);
        String str = null;
        if (list != null && !list.isEmpty()) {
            str = (String) list.get(0);
        }
        if (str != null) {
            String strZzh = zzas.zzh(str);
            switch (strZzh.hashCode()) {
                case -2123537834:
                    if (strZzh.equals(MimeTypes.AUDIO_E_AC3_JOC)) {
                        i = 0;
                    } else {
                        i = -1;
                    }
                    break;
                case -1662384011:
                    if (strZzh.equals(MimeTypes.VIDEO_PS)) {
                        i = 10;
                    } else {
                        i = -1;
                    }
                    break;
                case -1662384007:
                    if (strZzh.equals(MimeTypes.VIDEO_MP2T)) {
                        i = 11;
                    } else {
                        i = -1;
                    }
                    break;
                case -1662095187:
                    if (strZzh.equals(MimeTypes.VIDEO_WEBM)) {
                        i = 6;
                    } else {
                        i = -1;
                    }
                    break;
                case -1606874997:
                    if (strZzh.equals(MimeTypes.AUDIO_AMR_WB)) {
                        i = 3;
                    } else {
                        i = -1;
                    }
                    break;
                case -1487656890:
                    if (strZzh.equals(MimeTypes.IMAGE_AVIF)) {
                        i = 21;
                    } else {
                        i = -1;
                    }
                    break;
                case -1487464693:
                    if (strZzh.equals("image/heic")) {
                        i = 20;
                    } else {
                        i = -1;
                    }
                    break;
                case -1487464690:
                    if (strZzh.equals("image/heif")) {
                        i = 20;
                    } else {
                        i = -1;
                    }
                    break;
                case -1487394660:
                    if (strZzh.equals("image/jpeg")) {
                        i = 14;
                    } else {
                        i = -1;
                    }
                    break;
                case -1487018032:
                    if (strZzh.equals("image/webp")) {
                        i = 18;
                    } else {
                        i = -1;
                    }
                    break;
                case -1248337486:
                    if (strZzh.equals(MimeTypes.APPLICATION_MP4)) {
                        i = 8;
                    } else {
                        i = -1;
                    }
                    break;
                case -1079884372:
                    if (strZzh.equals(MimeTypes.VIDEO_AVI)) {
                        i = 16;
                    } else {
                        i = -1;
                    }
                    break;
                case -1004728940:
                    if (strZzh.equals(MimeTypes.TEXT_VTT)) {
                        i = 13;
                    } else {
                        i = -1;
                    }
                    break;
                case -879272239:
                    if (strZzh.equals(MimeTypes.IMAGE_BMP)) {
                        i = 19;
                    } else {
                        i = -1;
                    }
                    break;
                case -879258763:
                    if (strZzh.equals("image/png")) {
                        i = 17;
                    } else {
                        i = -1;
                    }
                    break;
                case -387023398:
                    if (strZzh.equals(MimeTypes.AUDIO_MATROSKA)) {
                        i = 6;
                    } else {
                        i = -1;
                    }
                    break;
                case -43467528:
                    if (strZzh.equals(MimeTypes.APPLICATION_WEBM)) {
                        i = 6;
                    } else {
                        i = -1;
                    }
                    break;
                case 13915911:
                    if (strZzh.equals(MimeTypes.VIDEO_FLV)) {
                        i = 5;
                    } else {
                        i = -1;
                    }
                    break;
                case 187078296:
                    if (strZzh.equals(MimeTypes.AUDIO_AC3)) {
                        i = 0;
                    } else {
                        i = -1;
                    }
                    break;
                case 187078297:
                    if (strZzh.equals(MimeTypes.AUDIO_AC4)) {
                        i = 1;
                    } else {
                        i = -1;
                    }
                    break;
                case 187078669:
                    if (strZzh.equals(MimeTypes.AUDIO_AMR)) {
                        i = 3;
                    } else {
                        i = -1;
                    }
                    break;
                case 187090232:
                    if (strZzh.equals(MimeTypes.AUDIO_MP4)) {
                        i = 8;
                    } else {
                        i = -1;
                    }
                    break;
                case 187091926:
                    if (strZzh.equals(MimeTypes.AUDIO_OGG)) {
                        i = 9;
                    } else {
                        i = -1;
                    }
                    break;
                case 187099443:
                    if (strZzh.equals(MimeTypes.AUDIO_WAV)) {
                        i = 12;
                    } else {
                        i = -1;
                    }
                    break;
                case 1331848029:
                    if (strZzh.equals(MimeTypes.VIDEO_MP4)) {
                        i = 8;
                    } else {
                        i = -1;
                    }
                    break;
                case 1503095341:
                    if (strZzh.equals(MimeTypes.AUDIO_AMR_NB)) {
                        i = 3;
                    } else {
                        i = -1;
                    }
                    break;
                case 1504578661:
                    if (strZzh.equals(MimeTypes.AUDIO_E_AC3)) {
                        i = 0;
                    } else {
                        i = -1;
                    }
                    break;
                case 1504619009:
                    if (strZzh.equals(MimeTypes.AUDIO_FLAC)) {
                        i = 4;
                    } else {
                        i = -1;
                    }
                    break;
                case 1504824762:
                    if (strZzh.equals(MimeTypes.AUDIO_MIDI)) {
                        i = 15;
                    } else {
                        i = -1;
                    }
                    break;
                case 1504831518:
                    if (strZzh.equals(MimeTypes.AUDIO_MPEG)) {
                        i = 7;
                    } else {
                        i = -1;
                    }
                    break;
                case 1505118770:
                    if (strZzh.equals(MimeTypes.AUDIO_WEBM)) {
                        i = 6;
                    } else {
                        i = -1;
                    }
                    break;
                case 2039520277:
                    if (strZzh.equals(MimeTypes.VIDEO_MATROSKA)) {
                        i = 6;
                    } else {
                        i = -1;
                    }
                    break;
                default:
                    i = -1;
                    break;
            }
        } else {
            i = -1;
        }
        if (i != -1) {
            zzc(i, arrayList);
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            i2 = -1;
        } else if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            i2 = 0;
        } else if (lastPathSegment.endsWith(".ac4")) {
            i2 = 1;
        } else if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            i2 = 2;
        } else if (lastPathSegment.endsWith(".amr")) {
            i2 = 3;
        } else if (lastPathSegment.endsWith(".flac")) {
            i2 = 4;
        } else if (lastPathSegment.endsWith(".flv")) {
            i2 = 5;
        } else if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            i2 = 15;
        } else if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            i2 = 6;
        } else if (lastPathSegment.endsWith(".mp3")) {
            i2 = 7;
        } else if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            i2 = 8;
        } else if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            i2 = 9;
        } else if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            i2 = 10;
        } else if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            i2 = 11;
        } else if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            i2 = 12;
        } else if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            i2 = 13;
        } else if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            i2 = 14;
        } else if (lastPathSegment.endsWith(".avi")) {
            i2 = 16;
        } else if (lastPathSegment.endsWith(".png")) {
            i2 = 17;
        } else if (lastPathSegment.endsWith(".webp")) {
            i2 = 18;
        } else if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            i2 = 19;
        } else if (lastPathSegment.endsWith(".heic") || lastPathSegment.endsWith(".heif")) {
            i2 = 20;
        } else if (lastPathSegment.endsWith(".avif")) {
            i2 = 21;
        } else {
            i2 = -1;
        }
        if (i2 != -1 && i2 != i) {
            zzc(i2, arrayList);
        }
        int[] iArr = zzb;
        for (int i3 = 0; i3 < 21; i3++) {
            int i4 = iArr[i3];
            if (i4 != i && i4 != i2) {
                zzc(i4, arrayList);
            }
        }
        return (zzafy[]) arrayList.toArray(new zzafy[0]);
    }

    private final void zzc(int i, List list) {
        switch (i) {
            case 0:
                list.add(new zzapi());
                break;
            case 1:
                list.add(new zzapl());
                break;
            case 2:
                list.add(new zzapo(0));
                break;
            case 3:
                list.add(new zzahp(0));
                break;
            case 4:
                zzafy zzafyVarZza = zzc.zza(0);
                if (zzafyVarZza == null) {
                    list.add(new zzaig(0));
                } else {
                    list.add(zzafyVarZza);
                }
                break;
            case 5:
                list.add(new zzaij());
                break;
            case 6:
                list.add(new zzakh(this.zzf, 0));
                break;
            case 7:
                list.add(new zzakp(0));
                break;
            case 8:
                zzanj zzanjVar = this.zzf;
                list.add(new zzalr(zzanjVar, 704, null, null, zzgwm.zzi(), null));
                list.add(new zzamc(zzanjVar, 160));
                break;
            case 9:
                list.add(new zzams());
                break;
            case 10:
                list.add(new zzaqs());
                break;
            case 11:
                if (this.zze == null) {
                    this.zze = zzgwm.zzi();
                }
                list.add(new zzard(1, 0, this.zzf, new zzfi(0L), new zzapq(0, this.zze), TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES));
                break;
            case 12:
                list.add(new zzarq());
                break;
            case 14:
                list.add(new zzaiq(0));
                break;
            case 15:
                zzafy zzafyVarZza2 = zzd.zza(new Object[0]);
                if (zzafyVarZza2 != null) {
                    list.add(zzafyVarZza2);
                }
                break;
            case 16:
                list.add(new zzaht(0, this.zzf));
                break;
            case 17:
                list.add(new zzanc());
                break;
            case 18:
                list.add(new zzarv());
                break;
            case 19:
                list.add(new zzaib());
                break;
            case 20:
                list.add(new zzaip(0));
                break;
            case 21:
                list.add(new zzaia());
                break;
        }
    }
}
