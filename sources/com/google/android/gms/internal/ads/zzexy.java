package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzexy implements zzimu {
    private final zzind zza;
    private final zzind zzb;
    private final zzind zzc;

    private zzexy(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
        this.zzc = zzindVar3;
    }

    public static zzexy zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzexy(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfck zzfckVarZzb = ((zzeuc) this.zza).zzb();
        zzewy zzewyVar = (zzewy) this.zzb.zzb();
        if (true == ((List) this.zzc.zzb()).contains(ExifInterface.GPS_MEASUREMENT_2D)) {
            zzfckVarZzb = zzewyVar;
        }
        zzinc.zzb(zzfckVarZzb);
        return zzfckVarZzb;
    }
}
