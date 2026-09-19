package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzeos implements zzels {
    private static Bundle zzd(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final boolean zza(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        return !TextUtils.isEmpty(zzfkfVar.zzv.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzels
    public final ListenableFuture zzb(zzfkq zzfkqVar, zzfkf zzfkfVar) {
        JSONObject jSONObject = zzfkfVar.zzv;
        String strOptString = jSONObject.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzfky zzfkyVar = zzfkqVar.zza.zza;
        zzfkx zzfkxVar = new zzfkx();
        zzfkxVar.zzA(zzfkyVar);
        zzfkxVar.zzg(strOptString);
        zzfkxVar.zzy(true);
        com.google.android.gms.ads.internal.client.zzm zzmVar = zzfkyVar.zzd;
        Bundle bundleZzd = zzd(zzmVar.zzm);
        Bundle bundleZzd2 = zzd(bundleZzd.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        bundleZzd2.putInt("gw", 1);
        String strOptString2 = jSONObject.optString("mad_hac", null);
        if (strOptString2 != null) {
            bundleZzd2.putString("mad_hac", strOptString2);
        }
        String strOptString3 = jSONObject.optString("adJson", null);
        if (strOptString3 != null) {
            bundleZzd2.putString("_ad", strOptString3);
        }
        bundleZzd2.putBoolean("_noRefresh", true);
        JSONObject jSONObject2 = zzfkfVar.zzD;
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString4 = jSONObject2.optString(next, null);
            if (next != null) {
                bundleZzd2.putString(next, strOptString4);
            }
        }
        bundleZzd.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundleZzd2);
        zzfkxVar.zza(new com.google.android.gms.ads.internal.client.zzm(zzmVar.zza, zzmVar.zzb, bundleZzd2, zzmVar.zzd, zzmVar.zze, zzmVar.zzf, zzmVar.zzg, zzmVar.zzh, zzmVar.zzi, zzmVar.zzj, zzmVar.zzk, zzmVar.zzl, bundleZzd, zzmVar.zzn, zzmVar.zzo, zzmVar.zzp, zzmVar.zzq, zzmVar.zzr, zzmVar.zzs, zzmVar.zzt, zzmVar.zzu, zzmVar.zzv, zzmVar.zzw, zzmVar.zzx, zzmVar.zzy, zzmVar.zzz, zzmVar.zzA));
        zzfkxVar.zzz(zzfkfVar.zzaH);
        zzfky zzfkyVarZzB = zzfkxVar.zzB();
        Bundle bundle = new Bundle();
        zzfki zzfkiVar = zzfkqVar.zzb.zzb;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzfkiVar.zza));
        bundle2.putInt("refresh_interval", zzfkiVar.zzc);
        bundle2.putString("gws_query_id", zzfkiVar.zzb);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzfkyVar.zzg;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzfkfVar.zzw);
        bundle3.putString("ad_source_name", zzfkfVar.zzF);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzfkfVar.zzc));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzfkfVar.zzd));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzfkfVar.zzp));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzfkfVar.zzm));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzfkfVar.zzg));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzfkfVar.zzh));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzfkfVar.zzi));
        bundle3.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzfkfVar.zzj);
        bundle3.putString("valid_from_timestamp", zzfkfVar.zzk);
        bundle3.putBoolean("is_closable_area_disabled", zzfkfVar.zzP);
        bundle3.putString("recursive_server_response_data", zzfkfVar.zzao);
        bundle3.putBoolean("is_analytics_logging_enabled", zzfkfVar.zzW);
        zzccb zzccbVar = zzfkfVar.zzl;
        if (zzccbVar != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzccbVar.zzb);
            bundle4.putString("rb_type", zzccbVar.zza);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zzc(zzfkyVarZzB, bundle, zzfkfVar, zzfkqVar);
    }

    protected abstract ListenableFuture zzc(zzfky zzfkyVar, Bundle bundle, zzfkf zzfkfVar, zzfkq zzfkqVar);
}
