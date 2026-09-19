package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdor implements zzimu {
    private final zzdop zza;

    private zzdor(zzdop zzdopVar) {
        this.zza = zzdopVar;
    }

    public static zzdor zzc(zzdop zzdopVar) {
        return new zzdor(zzdopVar);
    }

    public static JSONObject zzd(zzdop zzdopVar) {
        JSONObject jSONObjectZzc = zzdopVar.zzc();
        zzinc.zzb(jSONObjectZzc);
        return jSONObjectZzc;
    }

    public final JSONObject zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
