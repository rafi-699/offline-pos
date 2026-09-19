package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.media3.common.C;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzzg extends zzbf {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;
    private final boolean zze;
    private final zzak zzf;
    private final zzaf zzg;

    static {
        zzz zzzVar = new zzz();
        zzzVar.zza("SinglePeriodTimeline");
        zzzVar.zzb(Uri.EMPTY);
        zzzVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zza() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbe zzb(int i, zzbe zzbeVar, long j) {
        zzgtj.zzm(i, 1, FirebaseAnalytics.Param.INDEX);
        boolean z = this.zze;
        zzbeVar.zza(zzbe.zza, this.zzf, null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, z, false, this.zzg, 0L, this.zzd, 0, 0, 0L);
        return zzbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zzc() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i, zzbd zzbdVar, boolean z) {
        zzgtj.zzm(i, 1, FirebaseAnalytics.Param.INDEX);
        zzbdVar.zza(null, z ? zzb : null, 0, this.zzc, 0L, zzc.zza, false);
        return zzbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final int zze(Object obj) {
        return zzb.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbf
    public final Object zzf(int i) {
        zzgtj.zzm(i, 1, FirebaseAnalytics.Param.INDEX);
        return zzb;
    }

    public zzzg(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, zzak zzakVar, zzaf zzafVar) {
        this.zzc = j4;
        this.zzd = j5;
        this.zze = z;
        zzakVar.getClass();
        this.zzf = zzakVar;
        this.zzg = zzafVar;
    }
}
