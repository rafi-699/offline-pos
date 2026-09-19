package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgwk extends zzguj {
    private final zzgwm zza;

    zzgwk(zzgwm zzgwmVar, int i) {
        super(zzgwmVar.size(), i);
        this.zza = zzgwmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguj
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
