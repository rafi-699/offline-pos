package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaa implements zzdk {
    private final zzdp zza;
    private final zzdp zzb;
    private final zzdp zzc;

    public zzaa(zzdp zzdpVar, zzdp zzdpVar2, zzdp zzdpVar3) {
        this.zza = zzdpVar;
        this.zzb = zzdpVar2;
        this.zzc = zzdpVar3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdp, com.google.android.gms.internal.consent_sdk.zzdo
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzx zza() {
        return new zzx((zze) this.zza.zza(), ((zzal) this.zzb).zza(), (zzam) this.zzc.zza());
    }
}
