package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzars {
    public final int zza;
    public final long zzb;

    private zzars(int i, long j) {
        this.zza = i;
        this.zzb = j;
    }

    public static zzars zza(zzafz zzafzVar, zzet zzetVar) throws IOException {
        zzafzVar.zzi(zzetVar.zzi(), 0, 8);
        zzetVar.zzh(0);
        return new zzars(zzetVar.zzB(), zzetVar.zzA());
    }
}
