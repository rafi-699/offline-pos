package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzbka {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbka(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbka zza(String str, boolean z) {
        return new zzbka(str, Boolean.valueOf(z), 1);
    }

    public static zzbka zzb(String str, long j) {
        return new zzbka(str, Long.valueOf(j), 2);
    }

    public static zzbka zzc(String str, double d) {
        return new zzbka(str, Double.valueOf(d), 3);
    }

    public static zzbka zzd(String str, String str2) {
        return new zzbka("gad:dynamite_module:experiment_id", "", 4);
    }

    public final Object zze() {
        zzblg zzblgVarZza = zzbli.zza();
        if (zzblgVarZza == null) {
            if (zzbli.zzb() != null) {
                zzbli.zzb().zza();
            }
            return this.zzb;
        }
        int i = this.zzc - 1;
        if (i == 0) {
            return zzblgVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (i != 1) {
            return i != 2 ? zzblgVarZza.zzd(this.zza, (String) this.zzb) : zzblgVarZza.zzc(this.zza, ((Double) this.zzb).doubleValue());
        }
        return zzblgVarZza.zzb(this.zza, ((Long) this.zzb).longValue());
    }
}
