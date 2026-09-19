package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.extractor.ts.TsExtractor;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaqx implements zzafj {
    private final zzfi zza;
    private final zzet zzb = new zzet();
    private final int zzc;

    public zzaqx(int i, zzfi zzfiVar, int i2) {
        this.zzc = i;
        this.zza = zzfiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final zzafi zza(zzafz zzafzVar, long j) throws IOException {
        int iZza;
        int iZza2;
        long jZzn = zzafzVar.zzn();
        int iMin = (int) Math.min(112800L, zzafzVar.zzo() - jZzn);
        zzet zzetVar = this.zzb;
        zzetVar.zza(iMin);
        zzafzVar.zzi(zzetVar.zzi(), 0, iMin);
        int iZze = zzetVar.zze();
        long j2 = -1;
        long j3 = -9223372036854775807L;
        long j4 = -1;
        while (zzetVar.zzd() >= 188 && (iZza2 = (iZza = zzarj.zza(zzetVar.zzi(), zzetVar.zzg(), iZze)) + TsExtractor.TS_PACKET_SIZE) <= iZze) {
            long jZzb = zzarj.zzb(zzetVar, iZza, this.zzc);
            if (jZzb != C.TIME_UNSET) {
                long jZze = this.zza.zze(jZzb);
                if (jZze > j) {
                    return j3 == C.TIME_UNSET ? zzafi.zza(jZze, jZzn) : zzafi.zzc(jZzn + j4);
                }
                j4 = iZza;
                if (SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + jZze > j) {
                    return zzafi.zzc(jZzn + j4);
                }
                j3 = jZze;
            }
            zzetVar.zzh(iZza2);
            j2 = iZza2;
        }
        return j3 != C.TIME_UNSET ? zzafi.zzb(j3, jZzn + j2) : zzafi.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final void zzb() {
        byte[] bArr = zzfl.zzb;
        int length = bArr.length;
        this.zzb.zzb(bArr, 0);
    }
}
