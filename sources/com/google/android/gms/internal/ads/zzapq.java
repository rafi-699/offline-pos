package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.media3.common.MimeTypes;
import com.google.common.primitives.SignedBytes;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzapq implements zzarg {
    private final List zza;

    public zzapq() {
        this(0);
    }

    public zzapq(int i, List list) {
        this.zza = list;
    }

    private final zzaqw zzc(zzarf zzarfVar) {
        return new zzaqw(zze(zzarfVar), MimeTypes.VIDEO_MP2T);
    }

    private final zzarl zzd(zzarf zzarfVar) {
        return new zzarl(zze(zzarfVar), MimeTypes.VIDEO_MP2T);
    }

    private final List zze(zzarf zzarfVar) {
        String str;
        int i;
        List listSingletonList;
        zzet zzetVar = new zzet(zzarfVar.zze);
        List arrayList = this.zza;
        while (zzetVar.zzd() > 0) {
            int iZzs = zzetVar.zzs();
            int iZzg = zzetVar.zzg() + zzetVar.zzs();
            if (iZzs == 134) {
                arrayList = new ArrayList();
                int iZzs2 = zzetVar.zzs() & 31;
                for (int i2 = 0; i2 < iZzs2; i2++) {
                    String strZzK = zzetVar.zzK(3, StandardCharsets.UTF_8);
                    int iZzs3 = zzetVar.zzs();
                    boolean z = (iZzs3 & 128) != 0;
                    if (z) {
                        i = iZzs3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i = 1;
                    }
                    byte bZzs = (byte) zzetVar.zzs();
                    zzetVar.zzk(1);
                    if (z) {
                        int i3 = bZzs & SignedBytes.MAX_POWER_OF_TWO;
                        int i4 = zzdq.zza;
                        listSingletonList = Collections.singletonList(i3 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzt zztVar = new zzt();
                    zztVar.zzo(str);
                    zztVar.zze(strZzK);
                    zztVar.zzL(i);
                    zztVar.zzr(listSingletonList);
                    arrayList.add(zztVar.zzO());
                }
            }
            zzetVar.zzh(iZzg);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzarg
    public final SparseArray zza() {
        return new SparseArray();
    }

    public zzapq(int i) {
        this.zza = zzgwm.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzarg
    public final zzari zzb(int i, zzarf zzarfVar) {
        if (i != 2) {
            if (i == 3 || i == 4) {
                return new zzaqm(new zzaqf(zzarfVar.zzb, zzarfVar.zza(), MimeTypes.VIDEO_MP2T));
            }
            if (i == 21) {
                return new zzaqm(new zzaqd(MimeTypes.VIDEO_MP2T));
            }
            if (i == 27) {
                return new zzaqm(new zzaqa(zzc(zzarfVar), false, false, MimeTypes.VIDEO_MP2T));
            }
            if (i == 36) {
                return new zzaqm(new zzaqc(zzc(zzarfVar), MimeTypes.VIDEO_MP2T));
            }
            if (i == 45) {
                return new zzaqm(new zzaqg(MimeTypes.VIDEO_MP2T));
            }
            if (i == 89) {
                return new zzaqm(new zzaps(zzarfVar.zzd, MimeTypes.VIDEO_MP2T));
            }
            if (i == 172) {
                return new zzaqm(new zzapm(zzarfVar.zzb, zzarfVar.zza(), MimeTypes.VIDEO_MP2T));
            }
            if (i == 257) {
                return new zzaqu(new zzaql(MimeTypes.APPLICATION_AIT, MimeTypes.VIDEO_MP2T));
            }
            if (i != 128) {
                if (i != 129) {
                    if (i != 138) {
                        if (i == 139) {
                            return new zzaqm(new zzapr(zzarfVar.zzb, zzarfVar.zza(), 5408, MimeTypes.VIDEO_MP2T));
                        }
                        switch (i) {
                            case 15:
                                return new zzaqm(new zzapp(false, zzarfVar.zzb, zzarfVar.zza(), MimeTypes.VIDEO_MP2T));
                            case 16:
                                return new zzaqm(new zzapy(zzd(zzarfVar), MimeTypes.VIDEO_MP2T));
                            case 17:
                                return new zzaqm(new zzaqe(zzarfVar.zzb, zzarfVar.zza(), MimeTypes.VIDEO_MP2T));
                            default:
                                switch (i) {
                                    case 134:
                                        return new zzaqu(new zzaql(MimeTypes.APPLICATION_SCTE35, MimeTypes.VIDEO_MP2T));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new zzaqm(new zzapr(zzarfVar.zzb, zzarfVar.zza(), 4096, MimeTypes.VIDEO_MP2T));
                }
                return new zzaqm(new zzapj(zzarfVar.zzb, zzarfVar.zza(), MimeTypes.VIDEO_MP2T));
            }
        }
        return new zzaqm(new zzapv(zzd(zzarfVar), MimeTypes.VIDEO_MP2T));
    }
}
