package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbm extends com.google.android.gms.internal.play_billing.zzai {
    final ExternalOfferAvailabilityListener zza;
    final zzch zzb;
    final int zzc;

    /* synthetic */ zzbm(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, zzch zzchVar, int i, zzbp zzbpVar) {
        this.zza = externalOfferAvailabilityListener;
        this.zzb = zzchVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzaj
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            zzch zzchVar = this.zzb;
            zzie zzieVar = zzie.NULL_BUNDLE_FROM_IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL;
            BillingResult billingResult = zzcj.zzh;
            int i = zzcg.zza;
            zzchVar.zzb(zzcg.zzb(zzieVar, 23, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onExternalOfferAvailabilityResponse(billingResult);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        BillingResult billingResultZza = zzcj.zza(iZzb, com.google.android.gms.internal.play_billing.zzc.zzj(bundle, "BillingClient"));
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "isExternalOfferAvailableAsync() failed. Response code: " + iZzb);
            zzch zzchVar2 = this.zzb;
            zzie zzieVar2 = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i2 = zzcg.zza;
            zzchVar2.zzb(zzcg.zzb(zzieVar2, 23, billingResultZza, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
        }
        this.zza.onExternalOfferAvailabilityResponse(billingResultZza);
    }
}
