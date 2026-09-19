package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzamq extends zzamz {
    private zzagl zza;
    private zzamp zzb;

    zzamq() {
    }

    private static boolean zzd(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final void zza(boolean z) {
        super.zza(z);
        if (z) {
            this.zza = null;
            this.zzb = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    protected final long zzb(zzet zzetVar) {
        if (!zzd(zzetVar.zzi())) {
            return -1L;
        }
        int i = (zzetVar.zzi()[2] & 255) >> 4;
        if (i == 6) {
            zzetVar.zzk(4);
            zzetVar.zzO();
        } else if (i == 7) {
            i = 7;
            zzetVar.zzk(4);
            zzetVar.zzO();
        }
        int iZzc = zzagg.zzc(zzetVar, i);
        zzetVar.zzh(0);
        return iZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzamz
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    protected final boolean zzc(zzet zzetVar, long j, zzamx zzamxVar) {
        byte[] bArrZzi = zzetVar.zzi();
        zzagl zzaglVar = this.zza;
        if (zzaglVar == null) {
            zzagl zzaglVar2 = new zzagl(bArrZzi, 17);
            this.zza = zzaglVar2;
            zzt zztVarZza = zzaglVar2.zzc(Arrays.copyOfRange(bArrZzi, 9, zzetVar.zze()), null).zza();
            zztVarZza.zzn(MimeTypes.AUDIO_OGG);
            zzamxVar.zza = zztVarZza.zzO();
            return true;
        }
        if ((bArrZzi[0] & 127) == 3) {
            zzagk zzagkVarZzc = zzagi.zzc(zzetVar);
            zzagl zzaglVarZze = zzaglVar.zze(zzagkVarZzc);
            this.zza = zzaglVarZze;
            this.zzb = new zzamp(zzaglVarZze, zzagkVarZzc);
            return true;
        }
        if (!zzd(bArrZzi)) {
            return true;
        }
        zzamp zzampVar = this.zzb;
        if (zzampVar != null) {
            zzampVar.zzd(j);
            zzamxVar.zzb = this.zzb;
        }
        zzamxVar.zza.getClass();
        return false;
    }
}
