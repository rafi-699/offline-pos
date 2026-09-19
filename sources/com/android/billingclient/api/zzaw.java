package com.android.billingclient.api;

import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzie;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaw implements Callable {
    final /* synthetic */ PurchasesResponseListener zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ BillingClientImpl zzc;

    zzaw(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener, String str, boolean z) {
        this.zza = purchasesResponseListener;
        this.zzb = str;
        Objects.requireNonNull(billingClientImpl);
        this.zzc = billingClientImpl;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        BillingClientImpl billingClientImpl = this.zzc;
        if (!billingClientImpl.zzaX(30000L)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            billingClientImpl.zzbd(zzieVar, 9, billingResult);
            this.zza.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzbt.zzk());
            return null;
        }
        String str = this.zzb;
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Please provide a valid product type.");
            zzie zzieVar2 = zzie.EMPTY_PRODUCT_TYPE;
            BillingResult billingResult2 = zzcj.zze;
            billingClientImpl.zzbd(zzieVar2, 9, billingResult2);
            this.zza.onQueryPurchasesResponse(billingResult2, com.google.android.gms.internal.play_billing.zzbt.zzk());
            return null;
        }
        zzcw zzcwVarZzbb = billingClientImpl.zzbb(str, false, 9);
        if (zzcwVarZzbb.zzb() != null) {
            this.zza.onQueryPurchasesResponse(zzcwVarZzbb.zza(), zzcwVarZzbb.zzb());
            return null;
        }
        this.zza.onQueryPurchasesResponse(zzcwVarZzbb.zza(), com.google.android.gms.internal.play_billing.zzbt.zzk());
        return null;
    }
}
