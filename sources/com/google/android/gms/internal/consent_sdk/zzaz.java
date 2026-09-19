package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaz implements zzdk {
    private final zzdp zza;
    private final zzdp zzb;
    private final zzdp zzc;
    private final zzdp zzd;
    private final zzdp zze;
    private final zzdp zzf;

    public zzaz(zzdp zzdpVar, zzdp zzdpVar2, zzdp zzdpVar3, zzdp zzdpVar4, zzdp zzdpVar5, zzdp zzdpVar6) {
        this.zza = zzdpVar;
        this.zzb = zzdpVar2;
        this.zzc = zzdpVar3;
        this.zzd = zzdpVar4;
        this.zze = zzdpVar5;
        this.zzf = zzdpVar6;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdp, com.google.android.gms.internal.consent_sdk.zzdo
    public final /* bridge */ /* synthetic */ Object zza() {
        return new zzay((Application) this.zza.zza(), (zzab) this.zzb.zza(), (zzbt) this.zzc.zza(), (zzam) this.zzd.zza(), (zzbm) this.zze.zza(), this.zzf);
    }
}
