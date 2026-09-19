package com.google.android.gms.internal.identity_googleid;

/* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzh extends zzc {
    private final zzj zza;

    zzh(zzj zzjVar, int i) {
        super(zzjVar.size(), i);
        this.zza = zzjVar;
    }

    @Override // com.google.android.gms.internal.identity_googleid.zzc
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
