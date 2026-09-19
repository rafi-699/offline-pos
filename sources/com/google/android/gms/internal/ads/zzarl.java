package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzarl {
    private final List zza;
    private final String zzb = MimeTypes.VIDEO_MP2T;
    private final zzahk[] zzc;
    private final zzgz zzd;

    public zzarl(List list, String str) {
        this.zza = list;
        this.zzc = new zzahk[list.size()];
        zzgz zzgzVar = new zzgz(new zzgy() { // from class: com.google.android.gms.internal.ads.zzark
            @Override // com.google.android.gms.internal.ads.zzgy
            public final /* synthetic */ void zza(long j, zzet zzetVar) {
                this.zza.zzc(j, zzetVar);
            }
        });
        this.zzd = zzgzVar;
        zzgzVar.zza(3);
    }

    public final void zza(zzagb zzagbVar, zzarh zzarhVar) {
        int i = 0;
        while (true) {
            zzahk[] zzahkVarArr = this.zzc;
            if (i >= zzahkVarArr.length) {
                return;
            }
            zzarhVar.zza();
            zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 3);
            zzv zzvVar = (zzv) this.zza.get(i);
            String str = zzvVar.zzp;
            boolean z = true;
            if (!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) {
                z = false;
            }
            zzgtj.zzf(z, "Invalid closed caption MIME type provided: %s", str);
            zzt zztVar = new zzt();
            zztVar.zza(zzarhVar.zzc());
            zztVar.zzn(this.zzb);
            zztVar.zzo(str);
            zztVar.zzf(zzvVar.zze);
            zztVar.zze(zzvVar.zzd);
            zztVar.zzL(zzvVar.zzM);
            zztVar.zzr(zzvVar.zzs);
            zzahkVarZzu.zzA(zztVar.zzO());
            zzahkVarArr[i] = zzahkVarZzu;
            i++;
        }
    }

    public final void zzb(long j, zzet zzetVar) {
        if (zzetVar.zzd() < 9) {
            return;
        }
        int iZzB = zzetVar.zzB();
        int iZzB2 = zzetVar.zzB();
        int iZzs = zzetVar.zzs();
        if (iZzB == 434 && iZzB2 == 1195456820 && iZzs == 3) {
            this.zzd.zzc(j, zzetVar);
        }
    }

    final /* synthetic */ void zzc(long j, zzet zzetVar) {
        zzafl.zzb(j, zzetVar, this.zzc);
    }
}
