package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaid implements zzafj {
    private final zzagl zza;
    private final int zzb;
    private final zzagf zzc = new zzagf();

    /* synthetic */ zzaid(zzagl zzaglVar, int i, byte[] bArr) {
        this.zza = zzaglVar;
        this.zzb = i;
    }

    private final long zzc(zzafz zzafzVar) throws IOException {
        while (zzafzVar.zzm() < zzafzVar.zzo() - 6) {
            zzagl zzaglVar = this.zza;
            int i = this.zzb;
            zzagf zzagfVar = this.zzc;
            long jZzm = zzafzVar.zzm();
            zzet zzetVar = new zzet(17);
            zzafzVar.zzi(zzetVar.zzi(), 0, 2);
            if (zzetVar.zzo() != i) {
                zzafzVar.zzl();
                zzafzVar.zzk((int) (jZzm - zzafzVar.zzn()));
            } else {
                zzetVar.zzf(zzagc.zzb(zzafzVar, zzetVar.zzi(), 2, 15) + 2);
                zzafzVar.zzl();
                zzafzVar.zzk((int) (jZzm - zzafzVar.zzn()));
                if (zzagg.zza(zzetVar, zzaglVar, i, zzagfVar)) {
                    break;
                }
            }
            zzafzVar.zzk(1);
        }
        if (zzafzVar.zzm() < zzafzVar.zzo() - 6) {
            return this.zzc.zza;
        }
        zzafzVar.zzk((int) (zzafzVar.zzo() - zzafzVar.zzm()));
        return this.zza.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zzafj
    public final zzafi zza(zzafz zzafzVar, long j) throws IOException {
        long jZzn = zzafzVar.zzn();
        long jZzc = zzc(zzafzVar);
        long jZzm = zzafzVar.zzm();
        zzafzVar.zzk(Math.max(6, this.zza.zzc));
        long jZzc2 = zzc(zzafzVar);
        long jZzm2 = zzafzVar.zzm();
        if (jZzc > j || jZzc2 <= j) {
            return jZzc2 <= j ? zzafi.zzb(jZzc2, jZzm2) : zzafi.zza(jZzc, jZzn);
        }
        return zzafi.zzc(jZzm);
    }
}
