package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzful {
    private final zzfux zza;
    private final zzfux zzb;
    private final boolean zzc;
    private final zzfup zzd;
    private final zzfus zze;

    private zzful(zzfup zzfupVar, zzfus zzfusVar, zzfux zzfuxVar, zzfux zzfuxVar2, boolean z) {
        this.zzd = zzfupVar;
        this.zze = zzfusVar;
        this.zza = zzfuxVar;
        if (zzfuxVar2 == null) {
            this.zzb = zzfux.NONE;
        } else {
            this.zzb = zzfuxVar2;
        }
        this.zzc = z;
    }

    public static zzful zza(zzfup zzfupVar, zzfus zzfusVar, zzfux zzfuxVar, zzfux zzfuxVar2, boolean z) {
        zzfwi.zzb(zzfupVar, "CreativeType is null");
        zzfwi.zzb(zzfusVar, "ImpressionType is null");
        zzfwi.zzb(zzfuxVar, "Impression owner is null");
        if (zzfuxVar == zzfux.NONE) {
            throw new IllegalArgumentException("Impression owner is none");
        }
        if (zzfupVar == zzfup.DEFINED_BY_JAVASCRIPT && zzfuxVar == zzfux.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (zzfusVar == zzfus.DEFINED_BY_JAVASCRIPT && zzfuxVar == zzfux.NATIVE) {
            throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        return new zzful(zzfupVar, zzfusVar, zzfuxVar, zzfuxVar2, z);
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfwe.zzc(jSONObject, "impressionOwner", this.zza);
        zzfwe.zzc(jSONObject, "mediaEventsOwner", this.zzb);
        zzfwe.zzc(jSONObject, "creativeType", this.zzd);
        zzfwe.zzc(jSONObject, "impressionType", this.zze);
        zzfwe.zzc(jSONObject, "isolateVerificationScripts", Boolean.valueOf(this.zzc));
        return jSONObject;
    }
}
