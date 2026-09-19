package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdww {
    private final zzdzl zza;

    zzdww(zzdzl zzdzlVar) {
        this.zza = zzdzlVar;
    }

    public final boolean zza(zzgat zzgatVar) {
        if (zzgatVar.zzj()) {
            zzdzk zzdzkVarZza = this.zza.zza();
            zzdzkVarZza.zzc("action", "aq_ad_closed");
            zzdzkVarZza.zzc("gqi", zzgatVar.zza());
            zzdzkVarZza.zzc("aq_ad_duration", String.valueOf(zzgatVar.zzb()));
            zzdzkVarZza.zzc("aq_ad_bounce_cnt", String.valueOf(zzgatVar.zzc()));
            zzdzkVarZza.zzc("aq_time_away", String.valueOf(zzgatVar.zzg()));
            return Boolean.valueOf(zzdzkVarZza.zze().equals(com.google.android.gms.ads.internal.util.client.zzt.SUCCESS)).booleanValue();
        }
        zzdzk zzdzkVarZza2 = this.zza.zza();
        zzdzkVarZza2.zzc("action", "aq_ad_kill");
        zzdzkVarZza2.zzc("gqi", zzgatVar.zza());
        zzdzkVarZza2.zzc("aq_ad_duration", String.valueOf(zzgatVar.zzb()));
        zzdzkVarZza2.zzc("aq_ad_bounce_cnt", String.valueOf(zzgatVar.zzc()));
        zzdzkVarZza2.zzc("aq_time_away", String.valueOf(zzgatVar.zzg()));
        zzdzkVarZza2.zzc("aq_is_os_kill", String.valueOf(zzgatVar.zze()));
        return Boolean.valueOf(zzdzkVarZza2.zze().equals(com.google.android.gms.ads.internal.util.client.zzt.SUCCESS)).booleanValue();
    }
}
