package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcwt implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzcwt(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        this.zza = zzindVar2;
        this.zzb = zzindVar3;
    }

    public static zzcwt zza(zzind zzindVar, zzind zzindVar2, zzind zzindVar3) {
        return new zzcwt(zzindVar, zzindVar2, zzindVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        boolean zBooleanValue = Boolean.valueOf(zzcwr.zza()).booleanValue();
        zzels zzelsVarZzb = ((zzeow) this.zza).zzb();
        zzequ zzequVarZzb = ((zzeqv) this.zzb).zzb();
        if (true != zBooleanValue) {
            zzelsVarZzb = zzequVarZzb;
        }
        return zzelsVarZzb;
    }
}
