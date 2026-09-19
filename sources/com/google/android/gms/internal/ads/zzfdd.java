package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.Topic;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzfdd implements zzhbe {
    static final /* synthetic */ zzfdd zza = new zzfdd();

    private /* synthetic */ zzfdd() {
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final /* synthetic */ ListenableFuture zza(Object obj) {
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (getTopicsResponse == null) {
            return zzhbw.zza(new zzfdf("", 1, null));
        }
        zzihy zzihyVarZzc = zzihz.zzc();
        for (Topic topic : getTopicsResponse.getTopics()) {
            zzihw zzihwVarZzc = zzihx.zzc();
            zzihwVarZzc.zza(topic.getTopicId());
            zzihwVarZzc.zzb(topic.getModelVersion());
            zzihwVarZzc.zzc(topic.getTaxonomyVersion());
            zzihyVarZzc.zza((zzihx) zzihwVarZzc.zzbu());
        }
        return zzhbw.zza(new zzfdf(Base64.encodeToString(((zzihz) zzihyVarZzc.zzbu()).zzaN(), 1), 1, null));
    }
}
