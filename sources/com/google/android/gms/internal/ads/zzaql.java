package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaql implements zzaqt {
    private zzv zza;
    private zzfi zzb;
    private zzahk zzc;

    public zzaql(String str, String str2) {
        zzt zztVar = new zzt();
        zztVar.zzn(MimeTypes.VIDEO_MP2T);
        zztVar.zzo(str);
        this.zza = zztVar.zzO();
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zza(zzfi zzfiVar, zzagb zzagbVar, zzarh zzarhVar) {
        this.zzb = zzfiVar;
        zzarhVar.zza();
        zzahk zzahkVarZzu = zzagbVar.zzu(zzarhVar.zzb(), 5);
        this.zzc = zzahkVarZzu;
        zzahkVarZzu.zzA(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzaqt
    public final void zzb(zzet zzetVar) {
        this.zzb.getClass();
        String str = zzfl.zza;
        long jZzb = this.zzb.zzb();
        long jZzc = this.zzb.zzc();
        if (jZzb == C.TIME_UNSET || jZzc == C.TIME_UNSET) {
            return;
        }
        zzv zzvVar = this.zza;
        if (jZzc != zzvVar.zzu) {
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzt(jZzc);
            zzv zzvVarZzO = zztVarZza.zzO();
            this.zza = zzvVarZzO;
            this.zzc.zzA(zzvVarZzO);
        }
        int iZzd = zzetVar.zzd();
        this.zzc.zzc(zzetVar, iZzd);
        this.zzc.zze(jZzb, 1, iZzd, 0, null);
    }
}
