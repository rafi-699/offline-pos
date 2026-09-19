package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzapm implements zzapt {
    private final zzes zza;
    private final zzet zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private String zzf;
    private zzahk zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private zzv zzm;
    private int zzn;
    private long zzo;

    public zzapm(String str, int i, String str2) {
        zzes zzesVar = new zzes(new byte[16], 16);
        this.zza = zzesVar;
        this.zzb = new zzet(zzesVar.zza);
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzk = false;
        this.zzo = C.TIME_UNSET;
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzk = false;
        this.zzo = C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzb(zzagb zzagbVar, zzarh zzarhVar) {
        zzarhVar.zza();
        this.zzf = zzarhVar.zzc();
        this.zzg = zzagbVar.zzu(zzarhVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzc(long j, int i) {
        this.zzo = j;
    }

    /* JADX WARN: Code duplicated, block: B:50:0x012c  */
    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zzd(zzet zzetVar) {
        boolean z;
        this.zzg.getClass();
        while (zzetVar.zzd() > 0) {
            int i = this.zzh;
            if (i == 0) {
                while (true) {
                    if (zzetVar.zzd() > 0) {
                        if (this.zzj) {
                            int iZzs = zzetVar.zzs();
                            this.zzj = iZzs == 172;
                            byte b = SignedBytes.MAX_POWER_OF_TWO;
                            if (iZzs == 64) {
                                if (iZzs != 65) {
                                    z = false;
                                }
                                this.zzk = z;
                                this.zzh = 1;
                                zzet zzetVar2 = this.zzb;
                                zzetVar2.zzi()[0] = -84;
                                byte[] bArrZzi = zzetVar2.zzi();
                                if (true == this.zzk) {
                                    b = 65;
                                }
                                bArrZzi[1] = b;
                                this.zzi = 2;
                            } else if (iZzs == 65) {
                            }
                            z = true;
                            this.zzk = z;
                            this.zzh = 1;
                            zzet zzetVar3 = this.zzb;
                            zzetVar3.zzi()[0] = -84;
                            byte[] bArrZzi2 = zzetVar3.zzi();
                            if (true == this.zzk) {
                                b = 65;
                            }
                            bArrZzi2[1] = b;
                            this.zzi = 2;
                        } else {
                            this.zzj = zzetVar.zzs() == 172;
                        }
                    }
                }
            } else if (i != 1) {
                int iMin = Math.min(zzetVar.zzd(), this.zzn - this.zzi);
                this.zzg.zzc(zzetVar, iMin);
                int i2 = this.zzi + iMin;
                this.zzi = i2;
                if (i2 == this.zzn) {
                    zzgtj.zzi(this.zzo != C.TIME_UNSET);
                    this.zzg.zze(this.zzo, 1, this.zzn, 0, null);
                    this.zzo += this.zzl;
                    this.zzh = 0;
                }
            } else {
                zzet zzetVar4 = this.zzb;
                byte[] bArrZzi3 = zzetVar4.zzi();
                int iMin2 = Math.min(zzetVar.zzd(), 16 - this.zzi);
                zzetVar.zzm(bArrZzi3, this.zzi, iMin2);
                int i3 = this.zzi + iMin2;
                this.zzi = i3;
                if (i3 == 16) {
                    zzes zzesVar = this.zza;
                    zzesVar.zzf(0);
                    zzafa zzafaVarZzb = zzafb.zzb(zzesVar);
                    zzv zzvVar = this.zzm;
                    if (zzvVar == null || zzvVar.zzH != 2 || zzafaVarZzb.zza != zzvVar.zzI || !MimeTypes.AUDIO_AC4.equals(zzvVar.zzp)) {
                        zzt zztVar = new zzt();
                        zztVar.zza(this.zzf);
                        zztVar.zzn(this.zze);
                        zztVar.zzo(MimeTypes.AUDIO_AC4);
                        zztVar.zzG(2);
                        zztVar.zzH(zzafaVarZzb.zza);
                        zztVar.zze(this.zzc);
                        zztVar.zzg(this.zzd);
                        zzv zzvVarZzO = zztVar.zzO();
                        this.zzm = zzvVarZzO;
                        this.zzg.zzA(zzvVarZzO);
                    }
                    this.zzn = zzafaVarZzb.zzb;
                    this.zzl = (((long) zzafaVarZzb.zzc) * 1000000) / ((long) this.zzm.zzI);
                    zzetVar4.zzh(0);
                    this.zzg.zzc(zzetVar4, 16);
                    this.zzh = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapt
    public final void zze(boolean z) {
    }
}
