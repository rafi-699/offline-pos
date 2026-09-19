package com.google.android.gms.internal.ads;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzimp {
    final LinkedHashMap zza;

    zzimp(int i) {
        this.zza = zzimr.zzc(i);
    }

    final zzimp zza(Object obj, zzind zzindVar) {
        zzinc.zza(obj, SDKConstants.PARAM_KEY);
        zzinc.zza(zzindVar, "provider");
        this.zza.put(obj, zzindVar);
        return this;
    }
}
