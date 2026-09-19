package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcur implements zzimu {
    private final zzind zza;

    private zzcur(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzcur zza(zzind zzindVar) {
        return new zzcur(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcyk) this.zza).zza().zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
