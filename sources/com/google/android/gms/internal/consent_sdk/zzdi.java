package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdi implements zzdk {
    private zzdn zza;

    public static void zzb(zzdn zzdnVar, zzdn zzdnVar2) {
        zzdi zzdiVar = (zzdi) zzdnVar;
        if (zzdiVar.zza != null) {
            throw new IllegalStateException();
        }
        zzdiVar.zza = zzdnVar2;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzdp, com.google.android.gms.internal.consent_sdk.zzdo
    public final Object zza() {
        zzdn zzdnVar = this.zza;
        if (zzdnVar != null) {
            return zzdnVar.zza();
        }
        throw new IllegalStateException();
    }
}
