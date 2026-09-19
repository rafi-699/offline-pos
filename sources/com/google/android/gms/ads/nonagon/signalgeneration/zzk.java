package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzdzq;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzk extends QueryInfoGenerationCallback {
    private final zzj zza;
    private final zzdzq zzb;
    private final boolean zzc;
    private final int zzd;
    private final long zze = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
    private final Boolean zzf;

    public zzk(zzj zzjVar, boolean z, int i, Boolean bool, zzdzq zzdzqVar) {
        this.zza = zzjVar;
        this.zzc = z;
        this.zzd = i;
        this.zzf = bool;
        this.zzb = zzdzqVar;
    }

    private static long zza() {
        return com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() + ((Long) zzbkv.zzh.zze()).longValue();
    }

    private final long zzb() {
        return com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zze;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        Pair[] pairArr = new Pair[9];
        pairArr[0] = new Pair("sgf_reason", str);
        pairArr[1] = new Pair("se", "query_g");
        pairArr[2] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[3] = new Pair("rtype", Integer.toString(6));
        pairArr[4] = new Pair("scar", "true");
        pairArr[5] = new Pair("lat_ms", Long.toString(zzb()));
        int i = this.zzd;
        pairArr[6] = new Pair("sgpc_rn", Integer.toString(i));
        pairArr[7] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        pairArr[8] = new Pair("tpc", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        zzv.zze(this.zzb, null, "sgpcf", pairArr);
        this.zza.zzc(z, new zzl(null, str, zza(), i));
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        Pair[] pairArr = new Pair[8];
        pairArr[0] = new Pair("se", "query_g");
        pairArr[1] = new Pair(FirebaseAnalytics.Param.AD_FORMAT, AdFormat.BANNER.name());
        pairArr[2] = new Pair("rtype", Integer.toString(6));
        pairArr[3] = new Pair("scar", "true");
        pairArr[4] = new Pair("lat_ms", Long.toString(zzb()));
        int i = this.zzd;
        pairArr[5] = new Pair("sgpc_rn", Integer.toString(i));
        pairArr[6] = new Pair("sgpc_lsu", String.valueOf(this.zzf));
        boolean z = this.zzc;
        pairArr[7] = new Pair("tpc", true != z ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1");
        zzv.zze(this.zzb, null, "sgpcs", pairArr);
        this.zza.zzc(z, new zzl(queryInfo, "", zza(), i));
    }
}
