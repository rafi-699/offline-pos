package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfkk {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    zzfkk(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        JSONObject jSONObjectZzd = com.google.android.gms.ads.internal.util.zzbp.zzd(jsonReader);
        this.zzd = jSONObjectZzd;
        this.zza = jSONObjectZzd.optString("ad_html", null);
        this.zzb = jSONObjectZzd.optString("ad_base_url", null);
        this.zzc = jSONObjectZzd.optJSONObject("ad_json");
    }
}
