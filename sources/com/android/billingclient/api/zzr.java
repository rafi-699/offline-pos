package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zzeu;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzr extends BroadcastReceiver {
    final /* synthetic */ zzs zza;
    private boolean zzb;
    private final boolean zzc;

    zzr(zzs zzsVar, boolean z) {
        Objects.requireNonNull(zzsVar);
        this.zza = zzsVar;
        this.zzc = z;
    }

    private final void zzd(Bundle bundle, BillingResult billingResult, int i, zzil zzilVar, long j, boolean z) {
        try {
            if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
                this.zza.zze.zzd(zzhx.zzA(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD"), zzeu.zza()), j, z);
            } else {
                this.zza.zze.zzd(zzcg.zzb(zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY, i, billingResult, null, zzilVar), j, z);
            }
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003a  */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzil zzilVar;
        int i;
        int i2;
        BillingResult billingResultZzh;
        int iIntValue;
        String action = intent.getAction();
        int iHashCode = action.hashCode();
        if (iHashCode != -1484087650) {
            if (iHashCode != -337612916) {
                if (iHashCode == 345207161 && action.equals("com.android.vending.billing.ALTERNATIVE_BILLING")) {
                    zzilVar = zzil.ALTERNATIVE_BILLING_ACTION;
                } else {
                    zzilVar = zzil.BROADCAST_ACTION_UNSPECIFIED;
                }
            } else if (action.equals("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED")) {
                zzilVar = zzil.LOCAL_PURCHASES_UPDATED_ACTION;
            } else {
                zzilVar = zzil.BROADCAST_ACTION_UNSPECIFIED;
            }
        } else if (action.equals("com.android.vending.billing.PURCHASES_UPDATED")) {
            zzilVar = zzil.PURCHASES_UPDATED_ACTION;
        } else {
            zzilVar = zzil.BROADCAST_ACTION_UNSPECIFIED;
        }
        zzil zzilVar2 = zzilVar;
        zzil zzilVar3 = zzil.LOCAL_PURCHASES_UPDATED_ACTION;
        if (zzilVar2.equals(zzilVar3) || zzilVar2.equals(zzil.ALTERNATIVE_BILLING_ACTION)) {
            i = 2;
            i2 = 2;
        } else {
            i2 = zzilVar2.equals(zzil.PURCHASES_UPDATED_ACTION) ? 32 : 1;
            i = 2;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Bundle is null.");
            zzs zzsVar = this.zza;
            zzch zzchVar = zzsVar.zze;
            zzie zzieVar = zzie.NULL_BUNDLE_IN_BROADCAST_RECEIVER;
            BillingResult billingResult = zzcj.zzh;
            zzchVar.zza(zzcg.zzb(zzieVar, i2, billingResult, null, zzilVar2));
            if (zzsVar.zzb != null) {
                zzsVar.zzb.onPurchasesUpdated(billingResult, null);
            }
        } else {
            if (i2 == i) {
                int i3 = com.google.android.gms.internal.play_billing.zzc.zza;
                if (intent == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingHelper", "Got null intent!");
                    BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                    builderNewBuilder.setResponseCode(6);
                    builderNewBuilder.setOnPurchasesUpdatedSubResponseCode(0);
                    builderNewBuilder.setDebugMessage("An internal error occurred.");
                    billingResultZzh = builderNewBuilder.build();
                } else {
                    BillingResult.Builder builderNewBuilder2 = BillingResult.newBuilder();
                    builderNewBuilder2.setResponseCode(com.google.android.gms.internal.play_billing.zzc.zzb(intent.getExtras(), "BillingBroadcastManager"));
                    Bundle extras2 = intent.getExtras();
                    if (extras2 == null) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Unexpected null bundle received!");
                    } else {
                        Object obj = extras2.get("SUB_RESPONSE_CODE");
                        if (obj == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingBroadcastManager", "getLaunchBillingFlowSubResponseCodeFromBundle() got null response code, assuming OK");
                        } else {
                            if (obj instanceof Integer) {
                                iIntValue = ((Integer) obj).intValue();
                            } else {
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Unexpected type for bundle sub response code: ".concat(String.valueOf(obj.getClass().getName())));
                            }
                            builderNewBuilder2.setOnPurchasesUpdatedSubResponseCode(iIntValue);
                            builderNewBuilder2.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
                            billingResultZzh = builderNewBuilder2.build();
                        }
                    }
                    iIntValue = 0;
                    builderNewBuilder2.setOnPurchasesUpdatedSubResponseCode(iIntValue);
                    builderNewBuilder2.setDebugMessage(com.google.android.gms.internal.play_billing.zzc.zzj(intent.getExtras(), "BillingBroadcastManager"));
                    billingResultZzh = builderNewBuilder2.build();
                }
            } else {
                billingResultZzh = com.google.android.gms.internal.play_billing.zzc.zzh(intent, "BillingBroadcastManager");
            }
            BillingResult billingResult2 = billingResultZzh;
            long j = extras.getLong("billingClientTransactionId", 0L);
            boolean z = extras.getBoolean("wasServiceAutoReconnected", false);
            if (zzilVar2.equals(zzil.PURCHASES_UPDATED_ACTION) || zzilVar2.equals(zzilVar3)) {
                List<Purchase> listZzl = com.google.android.gms.internal.play_billing.zzc.zzl(extras);
                if (billingResult2.getResponseCode() == 0) {
                    this.zza.zze.zzh(zzcg.zzc(i2, zzilVar2), j, z);
                } else {
                    zzd(extras, billingResult2, i2, zzilVar2, j, z);
                }
                this.zza.zzb.onPurchasesUpdated(billingResult2, listZzl);
                return;
            }
            if (zzilVar2.equals(zzil.ALTERNATIVE_BILLING_ACTION)) {
                if (billingResult2.getResponseCode() != 0) {
                    zzd(extras, billingResult2, i2, zzilVar2, j, z);
                    this.zza.zzb.onPurchasesUpdated(billingResult2, com.google.android.gms.internal.play_billing.zzbt.zzk());
                    return;
                }
                zzs zzsVar2 = this.zza;
                if (zzsVar2.zzc == null && zzsVar2.zzd == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "AlternativeBillingListener and UserChoiceBillingListener is null.");
                    zzs zzsVar3 = this.zza;
                    zzch zzchVar2 = zzsVar3.zze;
                    zzie zzieVar2 = zzie.MISSING_USER_CHOICE_BILLING_LISTENER;
                    BillingResult billingResult3 = zzcj.zzh;
                    zzchVar2.zzd(zzcg.zzb(zzieVar2, i2, billingResult3, null, zzilVar2), j, z);
                    zzsVar3.zzb.onPurchasesUpdated(billingResult3, com.google.android.gms.internal.play_billing.zzbt.zzk());
                    return;
                }
                String string = extras.getString("ALTERNATIVE_BILLING_USER_CHOICE_DATA");
                if (string == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Couldn't find alternative billing user choice data in bundle.");
                    zzch zzchVar3 = zzsVar2.zze;
                    zzie zzieVar3 = zzie.MISSING_ALTERNATIVE_BILLING_USER_CHOICE_DATA;
                    BillingResult billingResult4 = zzcj.zzh;
                    zzchVar3.zzd(zzcg.zzb(zzieVar3, i2, billingResult4, null, zzilVar2), j, z);
                    zzsVar2.zzb.onPurchasesUpdated(billingResult4, com.google.android.gms.internal.play_billing.zzbt.zzk());
                    return;
                }
                try {
                    if (zzsVar2.zzd != null) {
                        zzsVar2.zzd.userSelectedAlternativeBilling(new UserChoiceDetails(string));
                    } else {
                        JSONArray jSONArrayOptJSONArray = new JSONObject(string).optJSONArray("products");
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                                if (jSONObjectOptJSONObject != null) {
                                    arrayList.add(new zzc(jSONObjectOptJSONObject, null));
                                }
                            }
                        }
                        zzsVar2.zzc.zza();
                    }
                    this.zza.zze.zzh(zzcg.zzc(i2, zzilVar2), j, z);
                } catch (JSONException unused) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", String.format("Error when parsing invalid user choice data: [%s]", string));
                    zzs zzsVar4 = this.zza;
                    zzch zzchVar4 = zzsVar4.zze;
                    zzie zzieVar4 = zzie.INVALID_ALTERNATIVE_BILLING_USER_CHOICE_DATA;
                    BillingResult billingResult5 = zzcj.zzh;
                    zzchVar4.zzd(zzcg.zzb(zzieVar4, i2, billingResult5, null, zzilVar2), j, z);
                    zzsVar4.zzb.onPurchasesUpdated(billingResult5, com.google.android.gms.internal.play_billing.zzbt.zzk());
                }
            }
        }
    }

    public final synchronized void zza(Context context, IntentFilter intentFilter) {
        if (this.zzb) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            context.registerReceiver(this, intentFilter, true != this.zzc ? 4 : 2);
        } else {
            context.registerReceiver(this, intentFilter);
        }
        this.zzb = true;
    }

    public final synchronized void zzb(Context context, IntentFilter intentFilter, String str) {
        zzr zzrVar;
        try {
            try {
                if (this.zzb) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    zzrVar = this;
                    context.registerReceiver(zzrVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.zzc ? 4 : 2);
                } else {
                    zzrVar = this;
                    context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                zzrVar.zzb = true;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized void zzc(Context context) {
        if (!this.zzb) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.zzb = false;
        }
    }
}
