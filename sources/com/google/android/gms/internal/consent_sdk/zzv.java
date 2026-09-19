package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzv implements zzdk {
    private final zzdp zza;
    private final zzdp zzb;
    private final zzdp zzc;
    private final zzdp zzd;
    private final zzdp zze;
    private final zzdp zzf;
    private final zzdp zzg;

    public zzv(zzdp zzdpVar, zzdp zzdpVar2, zzdp zzdpVar3, zzdp zzdpVar4, zzdp zzdpVar5, zzdp zzdpVar6, zzdp zzdpVar7, zzdp zzdpVar8, zzdp zzdpVar9) {
        this.zza = zzdpVar;
        this.zzb = zzdpVar2;
        this.zzc = zzdpVar5;
        this.zzd = zzdpVar6;
        this.zze = zzdpVar7;
        this.zzf = zzdpVar8;
        this.zzg = zzdpVar9;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdp, com.google.android.gms.internal.consent_sdk.zzdo
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzu zza() {
        return new zzu((Application) this.zza.zza(), (zzab) this.zzb.zza(), zzap.zzb(), zzar.zzb(), (zzam) this.zzc.zza(), (zzbk) this.zzd.zza(), ((zzo) this.zze).zza(), ((zzaa) this.zzf).zza(), (zze) this.zzg.zza());
    }
}
