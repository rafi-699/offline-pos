package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzby implements zzdk {
    private final zzdp zza;
    private final zzdp zzb;
    private final zzdp zzc;
    private final zzdp zzd;
    private final zzdp zze;
    private final zzdp zzf;

    public zzby(zzdp zzdpVar, zzdp zzdpVar2, zzdp zzdpVar3, zzdp zzdpVar4, zzdp zzdpVar5, zzdp zzdpVar6, zzdp zzdpVar7, zzdp zzdpVar8) {
        this.zza = zzdpVar;
        this.zzb = zzdpVar2;
        this.zzc = zzdpVar5;
        this.zzd = zzdpVar6;
        this.zze = zzdpVar7;
        this.zzf = zzdpVar8;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdp, com.google.android.gms.internal.consent_sdk.zzdo
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzbx zza() {
        return new zzbx((Application) this.zza.zza(), (zzbt) this.zzb.zza(), zzap.zzb(), zzar.zzb(), (zze) this.zzc.zza(), ((zzal) this.zzd).zza(), (zzay) this.zze.zza(), (zzam) this.zzf.zza());
    }
}
