package com.google.android.gms.internal.ads;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgaz {
    private final zzgav zza;

    public final /* synthetic */ zzgax zza() {
        zziee zzieeVarZzbu = this.zza.zzbu();
        Intrinsics.checkNotNullExpressionValue(zzieeVarZzbu, "build(...)");
        return (zzgax) zzieeVarZzbu;
    }

    public final /* synthetic */ zzihj zzb() {
        Map mapZzb = this.zza.zzb();
        Intrinsics.checkNotNullExpressionValue(mapZzb, "getQueryIdToAdQualityDataMapMap(...)");
        return new zzihj(mapZzb);
    }

    public final void zzc(zzihj zzihjVar, String key, zzgat value) {
        Intrinsics.checkNotNullParameter(zzihjVar, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.zza.zzc(key, value);
    }

    public final /* synthetic */ void zzd(zzihj zzihjVar, String key) {
        Intrinsics.checkNotNullParameter(zzihjVar, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        this.zza.zza(key);
    }
}
