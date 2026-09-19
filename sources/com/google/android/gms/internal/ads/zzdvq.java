package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzdvq extends zzdby {
    @Override // com.google.android.gms.internal.ads.zzdby
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    zzdvr zzh();

    zzdvq zzb(zzfhe zzfheVar);

    zzdvq zzc(zzfia zzfiaVar);

    zzdvq zzd(zzdcb zzdcbVar);

    zzdvq zze(zzdir zzdirVar);

    @Override // com.google.android.gms.internal.ads.zzdby
    /* bridge */ /* synthetic */ default zzdby zzi(zzfhe zzfheVar) {
        zzb(zzfheVar);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdby
    /* bridge */ /* synthetic */ default zzdby zzj(zzfia zzfiaVar) {
        zzc(zzfiaVar);
        return this;
    }
}
