package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaqw {
    private final List zza;
    private final zzahk[] zzc;
    private final String zzb = MimeTypes.VIDEO_MP2T;
    private final zzgz zzd = new zzgz(new zzgy() { // from class: com.google.android.gms.internal.ads.zzaqv
        @Override // com.google.android.gms.internal.ads.zzgy
        public final /* synthetic */ void zza(long j, zzet zzetVar) {
            this.zza.zzf(j, zzetVar);
        }
    });

    public zzaqw(List list, String str) {
        this.zza = list;
        this.zzc = new zzahk[list.size()];
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
            String strZzc = zzvVar.zza;
            if (strZzc == null) {
                strZzc = zzarhVar.zzc();
            }
            zzt zztVar = new zzt();
            zztVar.zza(strZzc);
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

    public final void zzb(int i) {
        this.zzd.zza(i);
    }

    public final void zzc(long j, zzet zzetVar) {
        this.zzd.zzc(j, zzetVar);
    }

    public final void zzd() {
        this.zzd.zze();
    }

    public final void zze() {
        this.zzd.zze();
    }

    final /* synthetic */ void zzf(long j, zzet zzetVar) {
        zzafl.zza(j, zzetVar, this.zzc);
    }
}
