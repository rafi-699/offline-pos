package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaps implements zzapt {
    private final List zza;
    private final zzahk[] zzc;
    private boolean zzd;
    private int zze;
    private int zzf;
    private final String zzb = MimeTypes.VIDEO_MP2T;
    private long zzg = C.TIME_UNSET;

    public zzaps(List list, String str) {
        this.zza = list;
        this.zzc = new zzahk[list.size()];
    }

    private final boolean zzf(zzet zzetVar, int i) {
        if (zzetVar.zzd() == 0) {
            return false;
        }
        if (zzetVar.zzs() != i) {
            this.zzd = false;
        }
        this.zze--;
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzd = false;
        this.zzg = C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        int i = 0;
        while (true) {
            zzahk[] zzahkVarArr = this.zzc;
            if (i >= zzahkVarArr.length) {
                return;
            }
            zzare zzareVar = (zzare) this.zza.get(i);
            zzarhVar.zza();
            zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 3);
            zzt zztVar = new zzt();
            zztVar.zza(zzarhVar.zzc());
            zztVar.zzn(this.zzb);
            zztVar.zzo(MimeTypes.APPLICATION_DVBSUBS);
            zztVar.zzr(Collections.singletonList(zzareVar.zzb));
            zztVar.zze(zzareVar.zza);
            zzahkVarZzu.zzA(zztVar.zzO());
            zzahkVarArr[i] = zzahkVarZzu;
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.zzd = true;
        this.zzg = j;
        this.zzf = 0;
        this.zze = 2;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) {
        if (this.zzd) {
            if (this.zze != 2 || zzf(zzetVar, 32)) {
                if (this.zze != 1 || zzf(zzetVar, 0)) {
                    int iZzg = zzetVar.zzg();
                    int iZzd = zzetVar.zzd();
                    for (zzahk zzahkVar : this.zzc) {
                        zzetVar.zzh(iZzg);
                        zzahkVar.zzc(zzetVar, iZzd);
                    }
                    this.zzf += iZzd;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
        if (this.zzd) {
            zzgtj.zzi(this.zzg != C.TIME_UNSET);
            for (zzahk zzahkVar : this.zzc) {
                zzahkVar.zze(this.zzg, 1, this.zzf, 0, null);
            }
            this.zzd = false;
        }
    }
}
