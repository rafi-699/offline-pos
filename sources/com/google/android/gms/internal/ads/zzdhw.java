package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdhw implements zzimu {
    private final zzind zza;

    private zzdhw(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzdhw zza(zzind zzindVar) {
        return new zzdhw(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdhv(((zzing) this.zza).zzb());
    }
}
