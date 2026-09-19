package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.1.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcy extends zzcv {
    private final zzda zza;

    zzcy(zzda zzdaVar, int i) {
        super(zzdaVar.size(), i);
        this.zza = zzdaVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzcv
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
