package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzik implements zzfl {
    static final zzfl zza = new zzik();

    private zzik() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfl
    public final boolean zza(int i) {
        zzil zzilVar;
        if (i == 0) {
            zzilVar = zzil.BROADCAST_ACTION_UNSPECIFIED;
        } else if (i == 1) {
            zzilVar = zzil.PURCHASES_UPDATED_ACTION;
        } else if (i != 2) {
            zzilVar = i != 3 ? null : zzil.ALTERNATIVE_BILLING_ACTION;
        } else {
            zzilVar = zzil.LOCAL_PURCHASES_UPDATED_ACTION;
        }
        return zzilVar != null;
    }
}
