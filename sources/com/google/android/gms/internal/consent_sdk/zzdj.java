package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdj implements zzdn {
    private static final Object zza = new Object();
    private volatile zzdn zzb;
    private volatile Object zzc = zza;

    private zzdj(zzdn zzdnVar) {
        this.zzb = zzdnVar;
    }

    public static zzdn zzb(zzdn zzdnVar) {
        return zzdnVar instanceof zzdj ? zzdnVar : new zzdj(zzdnVar);
    }

    private final synchronized Object zzc() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj != obj2) {
            return obj;
        }
        Object objZza = this.zzb.zza();
        Object obj3 = this.zzc;
        if (obj3 != obj2 && obj3 != objZza) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objZza + ". This is likely due to a circular dependency.");
        }
        this.zzc = objZza;
        this.zzb = null;
        return objZza;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdp, com.google.android.gms.internal.consent_sdk.zzdo
    public final Object zza() {
        Object obj = this.zzc;
        return obj == zza ? zzc() : obj;
    }
}
