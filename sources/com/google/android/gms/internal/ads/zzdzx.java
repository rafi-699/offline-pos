package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdzx implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzdzx(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzdzx zza(zzind zzindVar, zzind zzindVar2) {
        return new zzdzx(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdzw((String) this.zza.zzb(), (zzdzq) this.zzb.zzb());
    }
}
