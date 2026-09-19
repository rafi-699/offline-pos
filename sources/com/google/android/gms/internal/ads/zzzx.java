package com.google.android.gms.internal.ads;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.media3.common.MimeTypes;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzzx extends zzaaq implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzaam zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final int zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final boolean zzx;

    public zzzx(int i, zzbg zzbgVar, int i2, zzaam zzaamVar, int i3, boolean z, zzgtk zzgtkVar, int i4) {
        int i5;
        int iZzj;
        int iHashCode;
        int i6;
        int iZzj2;
        boolean z2;
        super(i, zzbgVar, i2);
        this.zzh = zzaamVar;
        int i7 = 1;
        int i8 = true != zzaamVar.zzT ? 16 : 24;
        boolean z3 = zzaamVar.zzP;
        this.zzg = zzaay.zzi(this.zzd.zzd);
        this.zzi = zznc.zzac(i3, false);
        int i9 = 0;
        while (true) {
            i5 = Integer.MAX_VALUE;
            if (i9 >= zzaamVar.zzq.size()) {
                iZzj = 0;
                i9 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj = zzaay.zzj(this.zzd, (String) zzaamVar.zzq.get(i9), false);
                if (iZzj > 0) {
                    break;
                } else {
                    i9++;
                }
            }
        }
        this.zzk = i9;
        this.zzj = iZzj;
        int i10 = this.zzd.zzf;
        int i11 = zzaamVar.zzs;
        this.zzl = zzaay.zzm(i10, 0);
        this.zzm = zzaay.zzn(this.zzd, zzaamVar.zzr);
        zzv zzvVar = this.zzd;
        int i12 = zzvVar.zzf;
        this.zzn = i12 == 0 || (i12 & 1) != 0;
        this.zzq = 1 == (zzvVar.zze & 1);
        String str = zzvVar.zzp;
        this.zzx = str != null && ((iHashCode = str.hashCode()) == -2123537834 ? str.equals(MimeTypes.AUDIO_E_AC3_JOC) : !(iHashCode == 187078297 ? !str.equals(MimeTypes.AUDIO_AC4) : !(iHashCode == 1504698186 && str.equals("audio/iamf"))));
        this.zzr = zzvVar.zzH;
        this.zzs = zzvVar.zzI;
        this.zzt = zzvVar.zzj;
        int i13 = zzvVar.zzj;
        this.zzf = (i13 == -1 || i13 <= zzaamVar.zzu) && ((i6 = zzvVar.zzH) == -1 || i6 <= zzaamVar.zzt) && zzgtkVar.zza(zzvVar);
        String str2 = zzfl.zza;
        String[] strArrSplit = Resources.getSystem().getConfiguration().getLocales().toLanguageTags().split(",", -1);
        for (int i14 = 0; i14 < strArrSplit.length; i14++) {
            strArrSplit[i14] = zzfl.zzi(strArrSplit[i14]);
        }
        int i15 = 0;
        while (true) {
            if (i15 >= strArrSplit.length) {
                iZzj2 = 0;
                i15 = Integer.MAX_VALUE;
                break;
            } else {
                iZzj2 = zzaay.zzj(this.zzd, strArrSplit[i15], false);
                if (iZzj2 > 0) {
                    break;
                } else {
                    i15++;
                }
            }
        }
        this.zzo = i15;
        this.zzp = iZzj2;
        for (int i16 = 0; i16 < zzaamVar.zzv.size(); i16++) {
            String str3 = this.zzd.zzp;
            if (str3 != null && str3.equals(zzaamVar.zzv.get(i16))) {
                i5 = i16;
                break;
            }
        }
        this.zzu = i5;
        this.zzv = (i3 & 384) == 128;
        this.zzw = (i3 & 64) == 64;
        zzaam zzaamVar2 = this.zzh;
        if (zznc.zzac(i3, zzaamVar2.zzV) && ((z2 = this.zzf) || zzaamVar2.zzO)) {
            int i17 = zzaamVar2.zzw.zzb;
            if (zznc.zzac(i3, false) && z2 && this.zzd.zzj != -1) {
                boolean z4 = zzaamVar2.zzG;
                boolean z5 = zzaamVar2.zzF;
                if ((zzaamVar2.zzX || !z) && (i8 & i3) != 0) {
                    i7 = 2;
                }
            }
        } else {
            i7 = 0;
        }
        this.zze = i7;
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final int zza() {
        return this.zze;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzzx zzzxVar) {
        boolean z = this.zzf;
        zzgyg zzgygVarZza = (z && this.zzi) ? zzaay.zzc : zzaay.zzc.zza();
        zzgvz zzgvzVarZza = zzgvz.zzg().zzd(this.zzi, zzzxVar.zzi).zza(Integer.valueOf(this.zzk), Integer.valueOf(zzzxVar.zzk), zzgyg.zzb().zza()).zzb(this.zzj, zzzxVar.zzj).zzb(this.zzl, zzzxVar.zzl).zza(Integer.valueOf(this.zzm), Integer.valueOf(zzzxVar.zzm), zzgyg.zzb().zza()).zzd(this.zzq, zzzxVar.zzq).zzd(this.zzn, zzzxVar.zzn).zza(Integer.valueOf(this.zzo), Integer.valueOf(zzzxVar.zzo), zzgyg.zzb().zza()).zzb(this.zzp, zzzxVar.zzp).zzd(z, zzzxVar.zzf).zza(Integer.valueOf(this.zzu), Integer.valueOf(zzzxVar.zzu), zzgyg.zzb().zza());
        boolean z2 = this.zzh.zzF;
        zzgvz zzgvzVarZza2 = zzgvzVarZza.zzd(this.zzv, zzzxVar.zzv).zzd(this.zzw, zzzxVar.zzw).zzd(this.zzx, zzzxVar.zzx).zza(Integer.valueOf(this.zzr), Integer.valueOf(zzzxVar.zzr), zzgygVarZza).zza(Integer.valueOf(this.zzs), Integer.valueOf(zzzxVar.zzs), zzgygVarZza);
        if (Objects.equals(this.zzg, zzzxVar.zzg)) {
            zzgvzVarZza2 = zzgvzVarZza2.zza(Integer.valueOf(this.zzt), Integer.valueOf(zzzxVar.zzt), zzgygVarZza);
        }
        return zzgvzVarZza2.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzaaq
    public final /* bridge */ /* synthetic */ boolean zzc(zzaaq zzaaqVar) {
        String str;
        zzaam zzaamVar = this.zzh;
        zzzx zzzxVar = (zzzx) zzaaqVar;
        boolean z = zzaamVar.zzR;
        zzv zzvVar = this.zzd;
        int i = zzvVar.zzH;
        if (i == -1) {
            return false;
        }
        zzv zzvVar2 = zzzxVar.zzd;
        if (i != zzvVar2.zzH || (str = zzvVar.zzp) == null || !TextUtils.equals(str, zzvVar2.zzp)) {
            return false;
        }
        boolean z2 = zzaamVar.zzQ;
        int i2 = zzvVar.zzI;
        if (i2 == -1 || i2 != zzvVar2.zzI) {
            return false;
        }
        boolean z3 = zzaamVar.zzS;
        return this.zzv == zzzxVar.zzv && this.zzw == zzzxVar.zzw;
    }
}
