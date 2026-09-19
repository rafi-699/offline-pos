package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgbc implements zzimu {
    private final zzind zza;

    private zzgbc(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzgbc zza(zzind zzindVar, zzind zzindVar2) {
        return new zzgbc(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = ((zzcnq) this.zza).zza();
        zzgbg coroutineScopeProvider = zzcnu.zzc();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(coroutineScopeProvider, "coroutineScopeProvider");
        DataStore dataStoreCreate$default = DataStoreFactory.create$default(DataStoreFactory.INSTANCE, zzgba.zza, null, null, coroutineScopeProvider.zza(), new Function0() { // from class: com.google.android.gms.internal.ads.zzgbb
            @Override // kotlin.jvm.functions.Function0
            public final /* synthetic */ Object invoke() {
                return DataStoreFile.dataStoreFile(context, "ad_quality_data.pb");
            }
        }, 6, null);
        zzinc.zzb(dataStoreCreate$default);
        return dataStoreCreate$default;
    }
}
