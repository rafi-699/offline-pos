package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.media3.common.MimeTypes;
import java.io.IOException;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzarq implements zzafy {
    private zzagb zza;
    private zzahk zzb;
    private zzarn zze;
    private int zzc = 0;
    private long zzd = -1;
    private int zzf = -1;
    private long zzg = -1;

    static {
        int i = zzarp.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        return zzart.zza(zzafzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zza = zzagbVar;
        this.zzb = zzagbVar.zzu(0, 1);
        zzagbVar.zzv();
    }

    /* JADX WARN: Code duplicated, block: B:45:0x010a  */
    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        int iZzB;
        int i;
        this.zzb.getClass();
        String str = zzfl.zza;
        int i2 = this.zzc;
        if (i2 == 0) {
            zzgtj.zzi(zzafzVar.zzn() == 0);
            int i3 = this.zzf;
            if (i3 != -1) {
                zzafzVar.zzf(i3);
                this.zzc = 4;
            } else {
                if (!zzart.zza(zzafzVar)) {
                    throw zzat.zzb("Unsupported or unrecognized wav file type.", null);
                }
                zzafzVar.zzf((int) (zzafzVar.zzm() - zzafzVar.zzn()));
                this.zzc = 1;
            }
            return 0;
        }
        long jZzE = -1;
        if (i2 == 1) {
            int i4 = zzart.zza;
            zzet zzetVar = new zzet(8);
            zzars zzarsVarZza = zzars.zza(zzafzVar, zzetVar);
            if (zzarsVarZza.zza != 1685272116) {
                zzafzVar.zzl();
            } else {
                zzafzVar.zzk(8);
                zzetVar.zzh(0);
                zzafzVar.zzi(zzetVar.zzi(), 0, 8);
                jZzE = zzetVar.zzE();
                zzafzVar.zzf(((int) zzarsVarZza.zzb) + 8);
            }
            this.zzd = jZzE;
            this.zzc = 2;
            return 0;
        }
        if (i2 == 2) {
            zzarr zzarrVarZzb = zzart.zzb(zzafzVar);
            int i5 = zzarrVarZzb.zza;
            if (i5 == 17) {
                this.zze = new zzarm(this.zza, this.zzb, zzarrVarZzb);
            } else if (i5 == 6) {
                this.zze = new zzaro(this.zza, this.zzb, zzarrVarZzb, MimeTypes.AUDIO_ALAW, -1);
            } else if (i5 == 7) {
                this.zze = new zzaro(this.zza, this.zzb, zzarrVarZzb, MimeTypes.AUDIO_MLAW, -1);
            } else {
                int i6 = zzarrVarZzb.zze;
                if (i5 == 1) {
                    iZzB = zzfl.zzB(i6, ByteOrder.LITTLE_ENDIAN);
                    i = iZzB;
                } else if (i5 == 3) {
                    iZzB = zzfl.zzC(i6);
                    i = iZzB;
                } else if (i5 != 65534) {
                    i = 0;
                } else {
                    iZzB = zzfl.zzB(i6, ByteOrder.LITTLE_ENDIAN);
                    i = iZzB;
                }
                if (i == 0) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 29);
                    sb.append("Unsupported WAV format type: ");
                    sb.append(i5);
                    throw zzat.zzc(sb.toString());
                }
                this.zze = new zzaro(this.zza, this.zzb, zzarrVarZzb, MimeTypes.AUDIO_RAW, i);
            }
            this.zzc = 3;
            return 0;
        }
        if (i2 != 3) {
            zzgtj.zzi(this.zzg != -1);
            long jZzn = this.zzg - zzafzVar.zzn();
            zzarn zzarnVar = this.zze;
            zzarnVar.getClass();
            return zzarnVar.zzc(zzafzVar, jZzn) ? -1 : 0;
        }
        Pair pairZzc = zzart.zzc(zzafzVar);
        this.zzf = ((Long) pairZzc.first).intValue();
        long jLongValue = ((Long) pairZzc.second).longValue();
        long j = this.zzd;
        if (j != -1 && jLongValue == 4294967295L) {
            jLongValue = j;
        }
        long j2 = ((long) this.zzf) + jLongValue;
        this.zzg = j2;
        long jZzo = zzafzVar.zzo();
        if (jZzo != -1 && j2 > jZzo) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(j2).length() + 29 + String.valueOf(jZzo).length());
            sb2.append("Data exceeds input length: ");
            sb2.append(j2);
            sb2.append(", ");
            sb2.append(jZzo);
            zzeg.zzc("WavExtractor", sb2.toString());
            this.zzg = jZzo;
            j2 = jZzo;
        }
        zzarn zzarnVar2 = this.zze;
        zzarnVar2.getClass();
        zzarnVar2.zzb(this.zzf, j2);
        this.zzc = 4;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        this.zzc = j == 0 ? 0 : 4;
        zzarn zzarnVar = this.zze;
        if (zzarnVar != null) {
            zzarnVar.zza(j2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
