package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhq extends IllegalArgumentException {
    zzhq(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
