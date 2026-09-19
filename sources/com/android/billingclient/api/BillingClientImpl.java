package com.android.billingclient.api;

import android.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.BundleCompat;
import androidx.media3.common.C;
import com.android.billingclient.BuildConfig;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.android.gms.internal.play_billing.zzdj;
import com.google.android.gms.internal.play_billing.zzdk;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzil;
import com.google.android.gms.internal.play_billing.zziq;
import com.google.android.gms.internal.play_billing.zzis;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zziz;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes2.dex */
class BillingClientImpl extends BillingClient {
    private boolean zzA;
    private boolean zzB;
    private boolean zzC;
    private PendingPurchasesParams zzD;
    private boolean zzE;
    private boolean zzF;
    private volatile BillingClientStateListener zzG;
    private ExecutorService zzH;
    private final Long zzI;
    private com.google.android.gms.internal.play_billing.zzbl zzJ;
    private final Object zza;
    private volatile int zzb;
    private final String zzc;
    private final String zzd;
    private final Handler zze;
    private volatile zzs zzf;
    private Context zzg;
    private zzch zzh;
    private volatile com.google.android.gms.internal.play_billing.zzam zzi;
    private volatile zzbf zzj;
    private boolean zzk;
    private boolean zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private boolean zzy;
    private boolean zzz;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    private BillingClientImpl(Activity activity, PendingPurchasesParams pendingPurchasesParams, String str, BillingClient.Builder builder) {
        this(activity.getApplicationContext(), pendingPurchasesParams, new zzbq(), str, null, null, null, null, builder);
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, zzb zzbVar, String str, zzch zzchVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zziqVarZzc.zzt(str2);
        }
        zziqVarZzc.zzq(this.zzg.getPackageName());
        zziqVarZzc.zzn(this.zzI.longValue());
        zziqVarZzc.zzr(builder.zza);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (zzchVar != null) {
            this.zzh = zzchVar;
        } else {
            this.zzh = new zzcl(this.zzg, (zzis) zziqVarZzc.zze());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzs(this.zzg, purchasesUpdatedListener, null, zzbVar, null, this.zzh);
        this.zzD = pendingPurchasesParams;
        this.zzF = zzbVar != null;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    private int launchBillingFlowCpp(Activity activity, BillingFlowParams billingFlowParams) {
        return launchBillingFlow(activity, billingFlowParams).getResponseCode();
    }

    private void startConnection(long j) {
        startConnection(new zzbq(j));
    }

    public static /* synthetic */ Void zzA(BillingClientImpl billingClientImpl, ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        billingClientImpl.zzaA(externalOfferAvailabilityListener);
        return null;
    }

    public static /* synthetic */ Void zzB(BillingClientImpl billingClientImpl, ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        billingClientImpl.zzaC(externalOfferInformationDialogListener, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Void zzC(BillingClientImpl billingClientImpl, ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, String str) throws Exception {
        billingClientImpl.zzay(externalOfferReportingDetailsListener, null);
        return null;
    }

    public static /* synthetic */ Void zzD(BillingClientImpl billingClientImpl, AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        billingClientImpl.zzax(alternativeBillingOnlyReportingDetailsListener);
        return null;
    }

    public static /* synthetic */ Void zzE(BillingClientImpl billingClientImpl, AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        billingClientImpl.zzaz(alternativeBillingOnlyAvailabilityListener);
        return null;
    }

    static Future zzG(Callable callable, long j, final Runnable runnable, Handler handler, ExecutorService executorService) {
        try {
            final Future futureSubmit = executorService.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzaj
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = futureSubmit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j * 0.95d));
            return futureSubmit;
        } catch (Exception e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Async task throws exception!", e);
            return null;
        }
    }

    public static /* synthetic */ void zzH(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
    }

    public static /* synthetic */ void zzI(BillingClientImpl billingClientImpl, PurchasesResponseListener purchasesResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 9, billingResult);
        purchasesResponseListener.onQueryPurchasesResponse(billingResult, com.google.android.gms.internal.play_billing.zzbt.zzk());
    }

    public static /* synthetic */ void zzJ(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 13, billingResult);
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    public static /* synthetic */ void zzL(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 3, billingResult);
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    public static /* synthetic */ void zzN(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener) {
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzbd(zzieVar, 7, billingResult);
        productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
    }

    public static /* synthetic */ void zzP(BillingClientImpl billingClientImpl, BillingResult billingResult) {
        if (billingClientImpl.zzf.zzd() != null) {
            billingClientImpl.zzf.zzd().onPurchasesUpdated(billingResult, null);
        } else {
            zzs zzsVar = billingClientImpl.zzf;
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    private final /* synthetic */ Void zzaA(ExternalOfferAvailabilityListener externalOfferAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(30000L)) {
                zzaJ(externalOfferAvailabilityListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzB) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaJ(externalOfferAvailabilityListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzamVar.zzq(24, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbm(externalOfferAvailabilityListener, this.zzh, this.zzm, null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support launching external offer flow.");
                zzaJ(externalOfferAvailabilityListener, zzcj.zzA, zzie.LAUNCH_EXTERNAL_OFFER_FLOW_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaJ(externalOfferAvailabilityListener, zzcj.zzj, zzie.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaJ(externalOfferAvailabilityListener, zzcj.zzh, zzie.IS_EXTERNAL_PAYMENT_AVAILABLE_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaB(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzm(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbi(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzj, zzie.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzh, zzie.SHOW_ALTERNATIVE_BILLING_ONLY_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaC(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaK(externalOfferInformationDialogListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzo(22, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbk(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaK(externalOfferInformationDialogListener, zzcj.zzj, zzie.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaK(externalOfferInformationDialogListener, zzcj.zzh, zzie.SHOW_EXTERNAL_PAYMENT_DIALOG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00a5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzaD(com.android.billingclient.api.ConsumeParams r11, com.android.billingclient.api.ConsumeResponseListener r12) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.String r0 = "Error consuming purchase with token. Response code: "
            java.lang.String r1 = "Consuming purchase with token: "
            java.lang.String r4 = r11.getPurchaseToken()
            java.lang.String r11 = "BillingClient"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La7 android.os.DeadObjectException -> Lb6
            r2.<init>(r1)     // Catch: java.lang.Exception -> La7 android.os.DeadObjectException -> Lb6
            r2.append(r4)     // Catch: java.lang.Exception -> La7 android.os.DeadObjectException -> Lb6
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> La7 android.os.DeadObjectException -> Lb6
            com.google.android.gms.internal.play_billing.zzc.zzm(r11, r1)     // Catch: java.lang.Exception -> La7 android.os.DeadObjectException -> Lb6
            java.lang.Object r11 = r10.zza     // Catch: java.lang.Exception -> La7 android.os.DeadObjectException -> Lb6
            monitor-enter(r11)     // Catch: java.lang.Exception -> La7 android.os.DeadObjectException -> Lb6
            com.google.android.gms.internal.play_billing.zzam r1 = r10.zzi     // Catch: java.lang.Throwable -> La0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> La0
            if (r1 != 0) goto L36
            com.android.billingclient.api.BillingResult r5 = com.android.billingclient.api.zzcj.zzj     // Catch: java.lang.Exception -> L2e android.os.DeadObjectException -> L32
            com.google.android.gms.internal.play_billing.zzie r6 = com.google.android.gms.internal.play_billing.zzie.SERVICE_RESET_TO_NULL     // Catch: java.lang.Exception -> L2e android.os.DeadObjectException -> L32
            java.lang.String r7 = "Service has been reset to null."
            r8 = 0
            r2 = r10
            r3 = r12
            r2.zzaG(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            return
        L2e:
            r0 = move-exception
            r2 = r10
            goto La8
        L32:
            r0 = move-exception
            r2 = r10
            goto Lb7
        L36:
            r2 = r10
            r3 = r12
            boolean r11 = r2.zzp     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            if (r11 == 0) goto L6b
            android.content.Context r11 = r2.zzg     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.String r11 = r11.getPackageName()     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            boolean r12 = r2.zzp     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.String r5 = r2.zzc     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.String r6 = r2.zzd     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.Long r7 = r2.zzI     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            long r7 = r7.longValue()     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            android.os.Bundle r9 = new android.os.Bundle     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            r9.<init>()     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            if (r12 == 0) goto L58
            com.google.android.gms.internal.play_billing.zzc.zzc(r9, r5, r6, r7)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
        L58:
            r12 = 9
            android.os.Bundle r11 = r1.zze(r12, r11, r4, r9)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.String r12 = "RESPONSE_CODE"
            int r12 = r11.getInt(r12)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.String r1 = "BillingClient"
            java.lang.String r11 = com.google.android.gms.internal.play_billing.zzc.zzj(r11, r1)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            goto L78
        L6b:
            android.content.Context r11 = r2.zzg     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.String r11 = r11.getPackageName()     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            r12 = 3
            int r12 = r1.zza(r12, r11, r4)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.String r11 = ""
        L78:
            com.android.billingclient.api.BillingResult r5 = com.android.billingclient.api.zzcj.zza(r12, r11)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            if (r12 != 0) goto L89
            java.lang.String r11 = "BillingClient"
            java.lang.String r12 = "Successfully consumed purchase."
            com.google.android.gms.internal.play_billing.zzc.zzm(r11, r12)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            r3.onConsumeResponse(r5, r4)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            return
        L89:
            com.google.android.gms.internal.play_billing.zzie r6 = com.google.android.gms.internal.play_billing.zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            r11.<init>(r0)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            r11.append(r12)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            java.lang.String r7 = r11.toString()     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            r8 = 0
            r2.zzaG(r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
            return
        L9c:
            r0 = move-exception
            goto La9
        L9e:
            r0 = move-exception
            goto Lb8
        La0:
            r0 = move-exception
            r3 = r12
        La2:
            r12 = r0
            monitor-exit(r11)     // Catch: java.lang.Throwable -> La5
            throw r12     // Catch: java.lang.Exception -> L9c android.os.DeadObjectException -> L9e
        La5:
            r0 = move-exception
            goto La2
        La7:
            r0 = move-exception
        La8:
            r3 = r12
        La9:
            r11 = r0
            r8 = r11
            com.android.billingclient.api.BillingResult r5 = com.android.billingclient.api.zzcj.zzh
            com.google.android.gms.internal.play_billing.zzie r6 = com.google.android.gms.internal.play_billing.zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION
            java.lang.String r7 = "Error consuming purchase!"
            r2 = r10
            r2.zzaG(r3, r4, r5, r6, r7, r8)
            return
        Lb6:
            r0 = move-exception
        Lb7:
            r3 = r12
        Lb8:
            r11 = r0
            r8 = r11
            com.android.billingclient.api.BillingResult r5 = com.android.billingclient.api.zzcj.zzj
            com.google.android.gms.internal.play_billing.zzie r6 = com.google.android.gms.internal.play_billing.zzie.CONSUME_PURCHASE_SERVICE_CALL_EXCEPTION
            java.lang.String r7 = "Error consuming purchase!"
            r2 = r10
            r2.zzaG(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.BillingClientImpl.zzaD(com.android.billingclient.api.ConsumeParams, com.android.billingclient.api.ConsumeResponseListener):void");
    }

    private final void zzaE(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error in acknowledge purchase!", exc);
        zzbf(zzieVar, 3, billingResult, zzcg.zza(exc));
        acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaF(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 14, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyAvailabilityListener.onAlternativeBillingOnlyAvailabilityResponse(billingResult);
    }

    private final void zzaG(ConsumeResponseListener consumeResponseListener, String str, BillingResult billingResult, zzie zzieVar, String str2, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str2, exc);
        zzbf(zzieVar, 4, billingResult, zzcg.zza(exc));
        consumeResponseListener.onConsumeResponse(billingResult, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaH(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 15, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyReportingDetailsListener.onAlternativeBillingOnlyTokenResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaI(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 24, billingResult, zzcg.zza(exc));
        externalOfferReportingDetailsListener.onExternalOfferReportingDetailsResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaJ(ExternalOfferAvailabilityListener externalOfferAvailabilityListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 23, billingResult, zzcg.zza(exc));
        externalOfferAvailabilityListener.onExternalOfferAvailabilityResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaK(ExternalOfferInformationDialogListener externalOfferInformationDialogListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 25, billingResult, zzcg.zza(exc));
        externalOfferInformationDialogListener.onExternalOfferInformationDialogResponse(billingResult);
    }

    private final void zzaL(BillingConfigResponseListener billingConfigResponseListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "getBillingConfig got an exception.", exc);
        zzbf(zzieVar, 13, billingResult, zzcg.zza(exc));
        billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaM(AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, BillingResult billingResult, zzie zzieVar, Exception exc) {
        zzbf(zzieVar, 16, billingResult, zzcg.zza(exc));
        alternativeBillingOnlyInformationDialogListener.onAlternativeBillingOnlyInformationDialogResponse(billingResult);
    }

    private final void zzaN(int i, zzie zzieVar, Exception exc) {
        zzhx zzhxVar;
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "showInAppMessages error.", exc);
        zzch zzchVar = this.zzh;
        String strZza = zzcg.zza(exc);
        try {
            zzic zzicVarZzc = zzig.zzc();
            zzicVarZzc.zzo(i);
            if (zzieVar != null) {
                zzicVarZzc.zzn(zzieVar);
            }
            if (strZza != null) {
                zzicVarZzc.zza(strZza);
            }
            zzhv zzhvVarZzc = zzhx.zzc();
            zzhvVarZzc.zzl(zzicVarZzc);
            zzhvVarZzc.zzp(30);
            zzhxVar = (zzhx) zzhvVarZzc.zze();
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", th);
            zzhxVar = null;
        }
        zzchVar.zza(zzhxVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaO(zzhx zzhxVar) {
        try {
            this.zzh.zzb(zzhxVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzaP(zzhx zzhxVar, long j, boolean z) {
        try {
            this.zzh.zze(zzhxVar, this.zzm, j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaQ(zzib zzibVar) {
        try {
            this.zzh.zzg(zzibVar, this.zzm);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaR(zzie zzieVar, BillingResult billingResult, int i) {
        try {
            int i2 = zzcg.zza;
            zzhv zzhvVar = (zzhv) zzcg.zzb(zzieVar, 6, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED).zzm();
            zzjt zzjtVarZzc = zzjv.zzc();
            zzjtVarZzc.zza(i > 0);
            zzjtVarZzc.zzl(i);
            zzhvVar.zzo(zzjtVarZzc);
            zzaO((zzhx) zzhvVar.zze());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaS(int i) {
        synchronized (this.zza) {
            if (this.zzb == 3) {
                return;
            }
            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Setting clientState from " + zzaZ(this.zzb) + " to " + zzaZ(i));
            this.zzb = i;
        }
    }

    private final synchronized void zzaT() {
        ExecutorService executorService = this.zzH;
        if (executorService != null) {
            executorService.shutdownNow();
            this.zzH = null;
        }
    }

    private final void zzaU(BillingClientStateListener billingClientStateListener, int i) {
        zzie zzieVar;
        BillingResult billingResultZzap;
        BillingResult billingResult;
        synchronized (this.zza) {
            if (zzaY()) {
                billingResultZzap = zzap(i);
            } else {
                if (this.zzb == 1) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client is already in the process of connecting to billing service.");
                    zzie zzieVar2 = zzie.BILLING_CLIENT_CONNECTING;
                    billingResult = zzcj.zzd;
                    zzaR(zzieVar2, billingResult, i);
                } else if (this.zzb == 3) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
                    zzie zzieVar3 = zzie.BILLING_CLIENT_CLOSED;
                    billingResult = zzcj.zzj;
                    zzaR(zzieVar3, billingResult, i);
                } else {
                    zzaS(1);
                    if (i == 0) {
                        this.zzG = billingClientStateListener;
                        i = 0;
                    }
                    zzaV();
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Starting in-app billing setup.");
                    this.zzj = new zzbf(this, billingClientStateListener, i, null);
                    this.zzj.zzc();
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    List<ResolveInfo> listQueryIntentServices = this.zzg.getPackageManager().queryIntentServices(intent, 0);
                    if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
                        zzieVar = zzie.INTENT_SERVICE_NOT_FOUND;
                    } else {
                        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
                        if (resolveInfo.serviceInfo != null) {
                            String str = resolveInfo.serviceInfo.packageName;
                            String str2 = resolveInfo.serviceInfo.name;
                            if (!Objects.equals(str, "com.android.vending") || str2 == null) {
                                zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                            } else {
                                ComponentName componentName = new ComponentName(str, str2);
                                Intent intent2 = new Intent(intent);
                                intent2.setComponent(componentName);
                                intent2.putExtra("playBillingLibraryVersion", this.zzc);
                                synchronized (this.zza) {
                                    if (this.zzb == 2) {
                                        billingResultZzap = zzap(i);
                                    } else if (this.zzb != 1) {
                                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Client state no longer CONNECTING, returning service disconnected.");
                                        zzie zzieVar4 = zzie.BILLING_CLIENT_TRANSITIONED_OUT_OF_CONNECTING;
                                        billingResult = zzcj.zzj;
                                        zzaR(zzieVar4, billingResult, i);
                                    } else {
                                        zzbf zzbfVar = this.zzj;
                                        if ((i <= 0 || Build.VERSION.SDK_INT < 29) ? this.zzg.bindService(intent2, zzbfVar, 1) : this.zzg.bindService(intent2, 1, zzF(), zzbfVar)) {
                                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Service was bonded successfully.");
                                            billingResultZzap = null;
                                        } else {
                                            zzieVar = zzie.BILLING_SERVICE_BLOCKED;
                                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Connection to Billing service is blocked.");
                                        }
                                    }
                                }
                            }
                        } else {
                            zzieVar = zzie.INVALID_PHONESKY_PACKAGE;
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "The device doesn't have valid Play Store.");
                        }
                    }
                    zzaS(0);
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Billing service unavailable on device.");
                    BillingResult billingResult2 = zzcj.zzb;
                    zzaR(zzieVar, billingResult2, i);
                    billingResultZzap = billingResult2;
                }
                billingResultZzap = billingResult;
            }
        }
        if (billingResultZzap != null) {
            billingClientStateListener.onBillingSetupFinished(billingResultZzap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaV() {
        synchronized (this.zza) {
            if (this.zzj != null) {
                try {
                    this.zzg.unbindService(this.zzj);
                    this.zzi = null;
                    this.zzj = null;
                } catch (Throwable th) {
                    try {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while unbinding service!", th);
                        this.zzi = null;
                        this.zzj = null;
                    } catch (Throwable th2) {
                        this.zzi = null;
                        this.zzj = null;
                        throw th2;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zzaW(long j) {
        try {
            BillingResult billingResult = (BillingResult) zzar(1).get(Build.VERSION.SDK_INT < 29 ? 0L : C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS, TimeUnit.MILLISECONDS);
            if (billingResult.getResponseCode() == 0) {
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
            }
        } catch (Exception e) {
            if (e instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error during reconnection attempt: ", e);
        }
        return zzaY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean zzaX(long j) {
        com.google.android.gms.internal.play_billing.zzbi zzbiVarZzb = com.google.android.gms.internal.play_billing.zzbi.zzb(this.zzJ);
        long jZza = 30000;
        for (int i = 1; i <= 3; i++) {
            try {
                long jMax = Math.max(0L, jZza);
                if (jMax <= 0) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "No time remaining for reconnection attempt.");
                    return zzaY();
                }
                BillingResult billingResult = (BillingResult) zzar(i).get(jMax, TimeUnit.MILLISECONDS);
                if (billingResult.getResponseCode() == 0) {
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection succeeded with result: " + billingResult.getResponseCode());
                    return zzaY();
                }
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed with result: " + billingResult.getResponseCode());
                jZza = 30000 - zzbiVarZzb.zza(TimeUnit.MILLISECONDS);
                long jPow = ((long) Math.pow(2.0d, i - 1)) * 1000;
                if (jZza < jPow) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Reconnection failed due to timeout limit reached.");
                    return zzaY();
                }
                if (i < 3 && jPow > 0) {
                    try {
                        Thread.sleep(jPow);
                        jZza = 30000 - zzbiVarZzb.zza(TimeUnit.MILLISECONDS);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error sleeping during reconnection attempt: ", e);
                    }
                }
            } catch (Exception e2) {
                if (e2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error during reconnection attempt: ", e2);
            }
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Max retries reached.");
        return zzaY();
    }

    private final boolean zzaY() {
        boolean z;
        synchronized (this.zza) {
            z = false;
            if (this.zzb == 2 && this.zzi != null && this.zzj != null) {
                z = true;
            }
        }
        return z;
    }

    private static final String zzaZ(int i) {
        if (i == 0) {
            return "DISCONNECTED";
        }
        if (i != 1) {
            return i != 2 ? "CLOSED" : "CONNECTED";
        }
        return "CONNECTING";
    }

    static /* bridge */ /* synthetic */ void zzac(BillingClientImpl billingClientImpl, int i) {
        billingClientImpl.zzm = i;
        billingClientImpl.zzC = i >= 26;
        billingClientImpl.zzB = i >= 24;
        billingClientImpl.zzA = i >= 23;
        billingClientImpl.zzz = i >= 22;
        billingClientImpl.zzy = i >= 21;
        billingClientImpl.zzx = i >= 20;
        billingClientImpl.zzw = i >= 19;
        billingClientImpl.zzv = i >= 18;
        billingClientImpl.zzu = i >= 17;
        billingClientImpl.zzt = i >= 16;
        billingClientImpl.zzs = i >= 15;
        billingClientImpl.zzr = i >= 14;
        billingClientImpl.zzq = i >= 12;
        billingClientImpl.zzp = i >= 9;
        billingClientImpl.zzo = i >= 8;
        billingClientImpl.zzn = i >= 6;
    }

    static /* bridge */ /* synthetic */ void zzae(BillingClientImpl billingClientImpl, int i) {
        if (i != 0) {
            billingClientImpl.zzaS(0);
            return;
        }
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb == 3) {
                return;
            }
            billingClientImpl.zzaS(2);
            zzs zzsVar = billingClientImpl.zzf != null ? billingClientImpl.zzf : null;
            if (zzsVar != null) {
                zzsVar.zzg(billingClientImpl.zzy);
            }
        }
    }

    static /* bridge */ /* synthetic */ boolean zzai(BillingClientImpl billingClientImpl) {
        boolean z;
        synchronized (billingClientImpl.zza) {
            z = true;
            if (billingClientImpl.zzb != 1) {
                z = false;
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzal(int i, String str, String str2, BillingFlowParams billingFlowParams, Bundle bundle) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            return zzamVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzcj.zzj, zzie.SERVICE_RESET_TO_NULL) : zzamVar.zzg(i, this.zzg.getPackageName(), str, str2, null, bundle);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzj, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzh, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final /* synthetic */ Bundle zzam(String str, String str2) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            return zzamVar == null ? com.google.android.gms.internal.play_billing.zzc.zzd(zzcj.zzj, zzie.SERVICE_RESET_TO_NULL) : zzamVar.zzf(3, this.zzg.getPackageName(), str, str2, null);
        } catch (DeadObjectException e) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzj, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e));
        } catch (Exception e2) {
            return com.google.android.gms.internal.play_billing.zzc.zze(zzcj.zzh, zzie.LAUNCH_BILLING_FLOW_EXCEPTION, zzcg.zza(e2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler zzan() {
        return Looper.myLooper() == null ? this.zze : new Handler(Looper.myLooper());
    }

    private final zzbo zzao(BillingResult billingResult, zzie zzieVar, String str, Exception exc) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str, exc);
        zzbf(zzieVar, 7, billingResult, zzcg.zza(exc));
        return new zzbo(billingResult.getResponseCode(), billingResult.getDebugMessage(), new ArrayList(), new ArrayList());
    }

    private final BillingResult zzap(int i) {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Service connection is valid. No need to re-initialize.");
        zzhz zzhzVarZzc = zzib.zzc();
        zzhzVarZzc.zzo(6);
        zzjt zzjtVarZzc = zzjv.zzc();
        zzjtVarZzc.zzn(true);
        zzjtVarZzc.zza(i > 0);
        zzjtVarZzc.zzl(i);
        zzhzVarZzc.zzn(zzjtVarZzc);
        zzaQ((zzib) zzhzVarZzc.zze());
        return zzcj.zzi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BillingResult zzaq() {
        int[] iArr = {0, 3};
        synchronized (this.zza) {
            for (int i = 0; i < 2; i++) {
                if (this.zzb == iArr[i]) {
                    return zzcj.zzj;
                }
            }
            return zzcj.zzh;
        }
    }

    private final com.google.android.gms.internal.play_billing.zzcz zzar(final int i) {
        if (this.zzE && !zzaY()) {
            return com.google.android.gms.internal.play_billing.zzu.zza(new com.google.android.gms.internal.play_billing.zzr() { // from class: com.android.billingclient.api.zzu
                @Override // com.google.android.gms.internal.play_billing.zzr
                public final Object zza(com.google.android.gms.internal.play_billing.zzp zzpVar) {
                    return BillingClientImpl.zzq(this.zza, i, zzpVar);
                }
            });
        }
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Already connected or not opted into auto reconnection.");
        return com.google.android.gms.internal.play_billing.zzcu.zza(zzcj.zzi);
    }

    private final /* synthetic */ Object zzas(AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(30000L)) {
                zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzcj.zzj;
                zzbd(zzieVar, 3, billingResult);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult);
            } else if (TextUtils.isEmpty(acknowledgePurchaseParams.getPurchaseToken())) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Please provide a valid purchase token.");
                zzie zzieVar2 = zzie.EMPTY_PURCHASE_TOKEN;
                BillingResult billingResult2 = zzcj.zzg;
                zzbd(zzieVar2, 3, billingResult2);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult2);
            } else if (this.zzp) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar != null) {
                    String packageName = this.zzg.getPackageName();
                    String purchaseToken = acknowledgePurchaseParams.getPurchaseToken();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long jLongValue = this.zzI.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    Bundle bundleZzd = zzamVar.zzd(9, packageName, purchaseToken, bundle);
                    acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(zzcj.zza(com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzd, "BillingClient"), com.google.android.gms.internal.play_billing.zzc.zzj(bundleZzd, "BillingClient")));
                    return null;
                }
                zzaE(acknowledgePurchaseResponseListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzie zzieVar3 = zzie.API_VERSION_NOT_V9;
                BillingResult billingResult3 = zzcj.zza;
                zzbd(zzieVar3, 3, billingResult3);
                acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResult3);
            }
            return null;
        } catch (DeadObjectException e) {
            zzaE(acknowledgePurchaseResponseListener, zzcj.zzj, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e);
            return null;
        } catch (Exception e2) {
            zzaE(acknowledgePurchaseResponseListener, zzcj.zzh, zzie.ACKNOWLEDGE_PURCHASE_SERVICE_CALL_EXCEPTION, e2);
            return null;
        }
    }

    private final /* synthetic */ Object zzat(BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        zzbp zzbpVar = null;
        try {
            if (!zzaX(30000L)) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service disconnected.");
                zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
                BillingResult billingResult = zzcj.zzj;
                zzbd(zzieVar, 13, billingResult);
                billingConfigResponseListener.onBillingConfigResponse(billingResult, null);
            } else if (this.zzv) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaL(billingConfigResponseListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    String str = this.zzc;
                    String str2 = this.zzd;
                    long jLongValue = this.zzI.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str, str2, jLongValue);
                    zzamVar.zzn(18, packageName, bundle, new zzbj(billingConfigResponseListener, this.zzh, this.zzm, zzbpVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support get billing config.");
                zzie zzieVar2 = zzie.GET_BILLING_CONFIG_NOT_SUPPORTED;
                BillingResult billingResult2 = zzcj.zzy;
                zzbd(zzieVar2, 13, billingResult2);
                billingConfigResponseListener.onBillingConfigResponse(billingResult2, null);
            }
        } catch (DeadObjectException e) {
            zzaL(billingConfigResponseListener, zzcj.zzj, zzie.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaL(billingConfigResponseListener, zzcj.zzh, zzie.GET_BILLING_CONFIG_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Object zzau(Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            synchronized (this.zza) {
                zzamVar = this.zzi;
            }
            if (zzamVar == null) {
                zzaN(-1, zzie.SERVICE_RESET_TO_NULL, null);
            } else {
                zzamVar.zzr(12, this.zzg.getPackageName(), bundle, new zzbn(new WeakReference(activity), resultReceiver, null));
            }
        } catch (DeadObjectException e) {
            zzaN(-1, zzie.SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaN(6, zzie.SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final String zzav(QueryProductDetailsParams queryProductDetailsParams) {
        if (TextUtils.isEmpty(null)) {
            return this.zzg.getPackageName();
        }
        return null;
    }

    private static String zzaw() {
        try {
            return (String) Class.forName("com.android.billingclient.ktx.BuildConfig").getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return null;
        }
    }

    private final /* synthetic */ Void zzax(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        zzbp zzbpVar = null;
        try {
            if (!zzaX(30000L)) {
                zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzy) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzamVar.zzk(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbg(alternativeBillingOnlyReportingDetailsListener, this.zzh, this.zzm, zzbpVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzD, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzj, zzie.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzh, zzie.CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzay(ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener, String str) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        zzbp zzbpVar = null;
        try {
            if (!zzaX(30000L)) {
                zzaI(externalOfferReportingDetailsListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzz) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaI(externalOfferReportingDetailsListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    String packageName = this.zzg.getPackageName();
                    long j = this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).firstInstallTime;
                    String str2 = this.zzc;
                    String str3 = this.zzd;
                    long jLongValue = this.zzI.longValue();
                    int i = com.google.android.gms.internal.play_billing.zzc.zza;
                    Bundle bundle = new Bundle();
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str2, str3, jLongValue);
                    bundle.putLong("appInstallTimeMillis", j);
                    zzamVar.zzl(22, packageName, bundle, new zzbh(externalOfferReportingDetailsListener, this.zzh, this.zzm, zzbpVar));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support external offer.");
                zzaI(externalOfferReportingDetailsListener, zzcj.zzt, zzie.EXTERNAL_OFFER_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaI(externalOfferReportingDetailsListener, zzcj.zzj, zzie.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaI(externalOfferReportingDetailsListener, zzcj.zzh, zzie.CREATE_EXTERNAL_PAYMENT_REPORTING_DETAILS_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final /* synthetic */ Void zzaz(AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) throws Exception {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        try {
            if (!zzaX(30000L)) {
                zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzj, zzie.SERVICE_CONNECTION_NOT_READY, null);
            } else if (this.zzy) {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, null);
                } else {
                    zzamVar.zzp(21, this.zzg.getPackageName(), com.google.android.gms.internal.play_billing.zzc.zzg(this.zzc, this.zzd, this.zzI.longValue()), new zzbl(alternativeBillingOnlyAvailabilityListener, this.zzh, this.zzm, null));
                }
            } else {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support alternative billing only.");
                zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzD, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, null);
            }
        } catch (DeadObjectException e) {
            zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzj, zzie.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e);
        } catch (Exception e2) {
            zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzh, zzie.IS_ALTERNATIVE_BILLING_ONLY_AVAILABLE_SERVICE_CALL_EXCEPTION, e2);
        }
        return null;
    }

    private final zzcw zzba(int i, BillingResult billingResult, zzie zzieVar, String str, Exception exc) {
        zzbf(zzieVar, 9, billingResult, zzcg.zza(exc));
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", str, exc);
        return new zzcw(billingResult, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:60:0x0169  */
    /* JADX WARN: Code duplicated, block: B:63:0x0184  */
    /* JADX WARN: Code duplicated, block: B:67:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:94:0x015d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x01bc A[SYNTHETIC] */
    public final zzcw zzbb(String str, boolean z, int i) {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        int i2;
        int i3;
        Bundle bundleZzi;
        BillingResult billingResultBuild;
        zzie zzieVar;
        ArrayList<String> stringArrayList;
        ArrayList<String> stringArrayList2;
        ArrayList<String> stringArrayList3;
        int i4;
        boolean z2;
        Purchase purchase;
        BillingClientImpl billingClientImpl = this;
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z3 = billingClientImpl.zzp;
        boolean z4 = billingClientImpl.zzw;
        boolean zIsEnabledForOneTimeProducts = billingClientImpl.zzD.isEnabledForOneTimeProducts();
        boolean zIsEnabledForPrepaidPlans = billingClientImpl.zzD.isEnabledForPrepaidPlans();
        long jLongValue = billingClientImpl.zzI.longValue();
        Bundle bundle = new Bundle();
        com.google.android.gms.internal.play_billing.zzc.zzc(bundle, billingClientImpl.zzc, billingClientImpl.zzd, jLongValue);
        if (z3 && zIsEnabledForOneTimeProducts) {
            bundle.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
        }
        if (z4 && zIsEnabledForPrepaidPlans) {
            bundle.putBoolean("enablePendingPurchaseForSubscriptions", true);
        }
        String string = null;
        do {
            try {
                synchronized (billingClientImpl.zza) {
                    zzamVar = billingClientImpl.zzi;
                }
                if (zzamVar == null) {
                    return billingClientImpl.zzba(9, zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null", null);
                }
                if (billingClientImpl.zzp) {
                    if (billingClientImpl.zzC) {
                        i3 = 26;
                    } else if (billingClientImpl.zzB) {
                        i3 = 24;
                    } else {
                        if (billingClientImpl.zzw) {
                            i3 = 19;
                        } else {
                            i2 = 9;
                        }
                        bundleZzi = zzamVar.zzi(i2, billingClientImpl.zzg.getPackageName(), str, string, bundle);
                    }
                    i2 = i3;
                    bundleZzi = zzamVar.zzi(i2, billingClientImpl.zzg.getPackageName(), str, string, bundle);
                } else {
                    bundleZzi = zzamVar.zzh(3, billingClientImpl.zzg.getPackageName(), str, string);
                }
                BillingResult billingResult = zzcj.zzh;
                if (bundleZzi == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("%s got null owned items list", "getPurchase()"));
                    zzieVar = zzie.NULL_OWNED_ITEMS_LIST;
                } else {
                    int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzi, "BillingClient");
                    String strZzj = com.google.android.gms.internal.play_billing.zzc.zzj(bundleZzi, "BillingClient");
                    BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
                    builderNewBuilder.setResponseCode(iZzb);
                    builderNewBuilder.setDebugMessage(strZzj);
                    billingResultBuild = builderNewBuilder.build();
                    if (iZzb != 0) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("%s failed. Response code: %s", "getPurchase()", Integer.valueOf(iZzb)));
                        zzieVar = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                    } else if (bundleZzi.containsKey("INAPP_PURCHASE_ITEM_LIST") && bundleZzi.containsKey("INAPP_PURCHASE_DATA_LIST") && bundleZzi.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                        ArrayList<String> stringArrayList4 = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                        ArrayList<String> stringArrayList5 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        ArrayList<String> stringArrayList6 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                        if (stringArrayList4 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null SKUs list.", "getPurchase()"));
                            zzieVar = zzie.NULL_SKUS_LIST;
                        } else if (stringArrayList5 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null purchases list.", "getPurchase()"));
                            zzieVar = zzie.NULL_PURCHASES_LIST;
                        } else if (stringArrayList6 == null) {
                            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s contains null signatures list.", "getPurchase()"));
                            zzieVar = zzie.NULL_SIGNATURES_LIST;
                        } else {
                            billingResultBuild = zzcj.zzi;
                            zzieVar = zzie.REASON_UNSPECIFIED;
                        }
                    } else {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", String.format("Bundle returned from %s doesn't contain required fields.", "getPurchase()"));
                        zzieVar = zzie.MISSING_REQUIRED_PURCHASE_KEY;
                    }
                    if (billingResultBuild != zzcj.zzi) {
                        return billingClientImpl.zzba(9, billingResultBuild, zzieVar, "Purchase bundle invalid", null);
                    }
                    stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                    stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                    stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                    z2 = false;
                    for (i4 = 0; i4 < stringArrayList2.size(); i4++) {
                        String str2 = stringArrayList2.get(i4);
                        String str3 = stringArrayList3.get(i4);
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i4))));
                        try {
                            purchase = new Purchase(str2, str3);
                            if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "BUG: empty/null token!");
                                z2 = true;
                            }
                            arrayList.add(purchase);
                        } catch (JSONException e) {
                            return zzba(9, zzcj.zzh, zzie.ERROR_DECODING_PURCHASE_DATA, "Got an exception trying to decode the purchase!", e);
                        }
                    }
                    billingClientImpl = this;
                    if (z2) {
                        billingClientImpl.zzbd(zzie.EMPTY_PURCHASE_TOKEN, 9, billingResult);
                    }
                    string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
                }
                billingResultBuild = billingResult;
                if (billingResultBuild != zzcj.zzi) {
                    return billingClientImpl.zzba(9, billingResultBuild, zzieVar, "Purchase bundle invalid", null);
                }
                stringArrayList = bundleZzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                stringArrayList2 = bundleZzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                stringArrayList3 = bundleZzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                z2 = false;
                while (i4 < stringArrayList2.size()) {
                    String str4 = stringArrayList2.get(i4);
                    String str5 = stringArrayList3.get(i4);
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i4))));
                    purchase = new Purchase(str4, str5);
                    if (TextUtils.isEmpty(purchase.getPurchaseToken())) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "BUG: empty/null token!");
                        z2 = true;
                    }
                    arrayList.add(purchase);
                }
                billingClientImpl = this;
                if (z2) {
                    billingClientImpl.zzbd(zzie.EMPTY_PURCHASE_TOKEN, 9, billingResult);
                }
                string = bundleZzi.getString("INAPP_CONTINUATION_TOKEN");
                com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Continuation token: ".concat(String.valueOf(string)));
            } catch (DeadObjectException e2) {
                return zzba(9, zzcj.zzj, zzie.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e2);
            } catch (Exception e3) {
                return billingClientImpl.zzba(9, zzcj.zzh, zzie.GET_PURCHASE_SERVICE_CALL_EXCEPTION, "Got exception trying to get purchases try to reconnect", e3);
            }
        } while (!TextUtils.isEmpty(string));
        return new zzcw(zzcj.zzi, arrayList);
    }

    private final void zzbc(BillingResult billingResult, zzie zzieVar, int i) {
        zzib zzibVar = null;
        zzhx zzhxVar = null;
        if (billingResult.getResponseCode() == 0) {
            int i2 = zzcg.zza;
            try {
                zzhz zzhzVarZzc = zzib.zzc();
                zzhzVarZzc.zzo(5);
                zziw zziwVarZzc = zziz.zzc();
                zziwVarZzc.zza(i);
                zzhzVarZzc.zzl((zziz) zziwVarZzc.zze());
                zzibVar = (zzib) zzhzVarZzc.zze();
            } catch (Exception e) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", e);
            }
            zzaQ(zzibVar);
            return;
        }
        int i3 = zzcg.zza;
        try {
            zzhv zzhvVarZzc = zzhx.zzc();
            zzic zzicVarZzc = zzig.zzc();
            zzicVarZzc.zzo(billingResult.getResponseCode());
            zzicVarZzc.zzl(billingResult.getDebugMessage());
            zzicVarZzc.zzn(zzieVar);
            zzhvVarZzc.zzl(zzicVarZzc);
            zzhvVarZzc.zzp(5);
            zziw zziwVarZzc2 = zziz.zzc();
            zziwVarZzc2.zza(i);
            zzhvVarZzc.zzm((zziz) zziwVarZzc2.zze());
            zzhxVar = (zzhx) zzhvVarZzc.zze();
        } catch (Exception e2) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Unable to create logging payload", e2);
        }
        zzaO(zzhxVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzbd(zzie zzieVar, int i, BillingResult billingResult) {
        try {
            int i2 = zzcg.zza;
            zzaO(zzcg.zzb(zzieVar, i, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbe(zzie zzieVar, int i, BillingResult billingResult, long j) {
        try {
            int i2 = zzcg.zza;
            try {
                this.zzh.zzc(zzcg.zzb(zzieVar, 2, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzm, j);
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
            }
        } catch (Throwable th2) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th2);
        }
    }

    private final void zzbf(zzie zzieVar, int i, BillingResult billingResult, String str) {
        try {
            int i2 = zzcg.zza;
            zzaO(zzcg.zzb(zzieVar, i, billingResult, str, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbg(zzie zzieVar, int i, BillingResult billingResult, long j, boolean z) {
        try {
            int i2 = zzcg.zza;
            zzaP(zzcg.zzb(zzieVar, 2, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzbh(zzie zzieVar, int i, BillingResult billingResult, String str, long j, boolean z) {
        try {
            int i2 = zzcg.zza;
            zzaP(zzcg.zzb(zzieVar, 2, billingResult, str, zzil.BROADCAST_ACTION_UNSPECIFIED), j, z);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private void zzbi(int i) {
        try {
            int i2 = zzcg.zza;
            zzaQ(zzcg.zzc(i, zzil.BROADCAST_ACTION_UNSPECIFIED));
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    static /* bridge */ /* synthetic */ BillingResult zzl(Exception exc) {
        return exc instanceof DeadObjectException ? zzcj.zzj : zzcj.zzh;
    }

    public static /* synthetic */ Object zzq(BillingClientImpl billingClientImpl, int i, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        billingClientImpl.zzaU(new zzbc(billingClientImpl, zzpVar), i);
        return "reconnectIfNeeded";
    }

    public static /* synthetic */ Object zzr(BillingClientImpl billingClientImpl, ConsumeResponseListener consumeResponseListener, ConsumeParams consumeParams) throws Throwable {
        if (billingClientImpl.zzaX(30000L)) {
            billingClientImpl.zzaD(consumeParams, consumeResponseListener);
            return null;
        }
        zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
        BillingResult billingResult = zzcj.zzj;
        billingClientImpl.zzbd(zzieVar, 4, billingResult);
        consumeResponseListener.onConsumeResponse(billingResult, consumeParams.getPurchaseToken());
        return null;
    }

    public static /* synthetic */ Object zzs(BillingClientImpl billingClientImpl, ProductDetailsResponseListener productDetailsResponseListener, QueryProductDetailsParams queryProductDetailsParams) throws JSONException {
        if (!billingClientImpl.zzaX(30000L)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            billingClientImpl.zzbd(zzieVar, 7, billingResult);
            productDetailsResponseListener.onProductDetailsResponse(billingResult, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
            return null;
        }
        if (billingClientImpl.zzu) {
            zzbo zzboVarZzg = billingClientImpl.zzg(queryProductDetailsParams);
            productDetailsResponseListener.onProductDetailsResponse(zzcj.zza(zzboVarZzg.zza(), zzboVarZzg.zzb()), new QueryProductDetailsResult(zzboVarZzg.zzc(), zzboVarZzg.zzd()));
            return null;
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Querying product details is not supported.");
        zzie zzieVar2 = zzie.PRODUCT_DETAILS_NOT_SUPPORTED;
        BillingResult billingResult2 = zzcj.zzr;
        billingClientImpl.zzbd(zzieVar2, 7, billingResult2);
        productDetailsResponseListener.onProductDetailsResponse(billingResult2, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
        return null;
    }

    public static /* synthetic */ Object zzt(BillingClientImpl billingClientImpl, AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener, AcknowledgePurchaseParams acknowledgePurchaseParams) throws Exception {
        billingClientImpl.zzas(acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
        return null;
    }

    public static /* synthetic */ Object zzu(BillingClientImpl billingClientImpl, Bundle bundle, Activity activity, ResultReceiver resultReceiver) throws Exception {
        billingClientImpl.zzau(bundle, activity, resultReceiver);
        return null;
    }

    public static /* synthetic */ Object zzv(BillingClientImpl billingClientImpl, BillingConfigResponseListener billingConfigResponseListener) throws Exception {
        billingClientImpl.zzat(billingConfigResponseListener);
        return null;
    }

    public static /* synthetic */ Void zzz(BillingClientImpl billingClientImpl, AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener, Activity activity, ResultReceiver resultReceiver) throws Exception {
        billingClientImpl.zzaB(alternativeBillingOnlyInformationDialogListener, activity, resultReceiver);
        return null;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void acknowledgePurchase(final AcknowledgePurchaseParams acknowledgePurchaseParams, final AcknowledgePurchaseResponseListener acknowledgePurchaseResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzaa
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzt(this.zza, acknowledgePurchaseResponseListener, acknowledgePurchaseParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzab
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzL(this.zza, acknowledgePurchaseResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult billingResultZzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 3, billingResultZzaq);
            acknowledgePurchaseResponseListener.onAcknowledgePurchaseResponse(billingResultZzaq);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void consumeAsync(final ConsumeParams consumeParams, final ConsumeResponseListener consumeResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzak
            @Override // java.util.concurrent.Callable
            public final Object call() throws Throwable {
                BillingClientImpl.zzr(this.zza, consumeResponseListener, consumeParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzam
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzH(this.zza, consumeResponseListener, consumeParams);
            }
        }, zzan(), zzF()) == null) {
            BillingResult billingResultZzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 4, billingResultZzaq);
            consumeResponseListener.onConsumeResponse(billingResultZzaq, consumeParams.getPurchaseToken());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createAlternativeBillingOnlyReportingDetailsAsync(final AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzaf
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzD(this.zza, alternativeBillingOnlyReportingDetailsListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzag
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaH(alternativeBillingOnlyReportingDetailsListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaH(alternativeBillingOnlyReportingDetailsListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void createExternalOfferReportingDetailsAsync(final ExternalOfferReportingDetailsListener externalOfferReportingDetailsListener) {
        final String str = null;
        if (zzG(new Callable(externalOfferReportingDetailsListener, str) { // from class: com.android.billingclient.api.zzaq
            public final /* synthetic */ ExternalOfferReportingDetailsListener zzb;

            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzC(this.zza, this.zzb, null);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzar
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaI(externalOfferReportingDetailsListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaI(externalOfferReportingDetailsListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void endConnection() {
        zzbi(12);
        synchronized (this.zza) {
            try {
                if (this.zzf != null) {
                    this.zzf.zzf();
                    try {
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Unbinding from service.");
                        zzaV();
                    } catch (Throwable th) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while unbinding from the service while ending connection!", th);
                    }
                    try {
                        zzaT();
                    } catch (Throwable th2) {
                        try {
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while shutting down the executor service while ending connection!", th2);
                        } catch (Throwable th3) {
                            zzaS(3);
                            this.zzG = null;
                            throw th3;
                        }
                    }
                    zzaS(3);
                    this.zzG = null;
                } else {
                    com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Unbinding from service.");
                    zzaV();
                    zzaT();
                    zzaS(3);
                    this.zzG = null;
                }
            } catch (Throwable th4) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "There was an exception while shutting down broadcast manager while ending connection!", th4);
            }
            throw th;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void getBillingConfigAsync(GetBillingConfigParams getBillingConfigParams, final BillingConfigResponseListener billingConfigResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzad
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzv(this.zza, billingConfigResponseListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzae
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzJ(this.zza, billingConfigResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult billingResultZzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 13, billingResultZzaq);
            billingConfigResponseListener.onBillingConfigResponse(billingResultZzaq, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final int getConnectionState() {
        int i;
        synchronized (this.zza) {
            i = this.zzb;
        }
        return i;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isAlternativeBillingOnlyAvailableAsync(final AlternativeBillingOnlyAvailabilityListener alternativeBillingOnlyAvailabilityListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzah
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzE(this.zza, alternativeBillingOnlyAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzai
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaF(alternativeBillingOnlyAvailabilityListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaF(alternativeBillingOnlyAvailabilityListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void isExternalOfferAvailableAsync(final ExternalOfferAvailabilityListener externalOfferAvailabilityListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzau
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzA(this.zza, externalOfferAvailabilityListener);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzv
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaJ(externalOfferAvailabilityListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, zzan(), zzF()) == null) {
            zzaJ(externalOfferAvailabilityListener, zzaq(), zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, null);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult isFeatureSupported(String str) {
        if (!zzaW(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)) {
            BillingResult billingResult = zzcj.zzj;
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            if (billingResult.getResponseCode() != 0) {
                zzbd(zzieVar, 5, billingResult);
                return billingResult;
            }
            zzbi(5);
            return billingResult;
        }
        int i = zzcj.zzG;
        switch (str.hashCode()) {
            case -422092961:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS_UPDATE)) {
                    BillingResult billingResult2 = this.zzl ? zzcj.zzi : zzcj.zzm;
                    zzbc(billingResult2, zzie.SUBSCRIPTIONS_UPDATE_NOT_SUPPORTED, 3);
                    return billingResult2;
                }
                break;
            case 96321:
                if (str.equals("aaa")) {
                    BillingResult billingResult3 = this.zzs ? zzcj.zzi : zzcj.zzo;
                    zzbc(billingResult3, zzie.CROSS_APP_NOT_SUPPORTED, 6);
                    return billingResult3;
                }
                break;
            case 97314:
                if (str.equals(BillingClient.FeatureType.IN_APP_MESSAGING)) {
                    BillingResult billingResult4 = this.zzq ? zzcj.zzi : zzcj.zzs;
                    zzbc(billingResult4, zzie.IN_APP_MESSAGE_NOT_SUPPORTED, 5);
                    return billingResult4;
                }
                break;
            case 98307:
                if (str.equals("ccc")) {
                    BillingResult billingResult5 = this.zzt ? zzcj.zzi : zzcj.zzp;
                    zzbc(billingResult5, zzie.MULTI_ITEM_NOT_SUPPORTED, 8);
                    return billingResult5;
                }
                break;
            case 99300:
                if (str.equals("ddd")) {
                    BillingResult billingResult6 = this.zzr ? zzcj.zzi : zzcj.zzq;
                    zzbc(billingResult6, zzie.OFFER_ID_TOKEN_NOT_SUPPORTED, 7);
                    return billingResult6;
                }
                break;
            case 100293:
                if (str.equals("eee")) {
                    BillingResult billingResult7 = this.zzt ? zzcj.zzi : zzcj.zzp;
                    zzbc(billingResult7, zzie.PBL_FOR_PAYMENTS_GATEWAY_BUYFLOW_NOT_SUPPORTED, 9);
                    return billingResult7;
                }
                break;
            case 101286:
                if (str.equals(BillingClient.FeatureType.PRODUCT_DETAILS)) {
                    BillingResult billingResult8 = this.zzu ? zzcj.zzi : zzcj.zzr;
                    zzbc(billingResult8, zzie.PRODUCT_DETAILS_NOT_SUPPORTED, 10);
                    return billingResult8;
                }
                break;
            case 102279:
                if (str.equals(BillingClient.FeatureType.BILLING_CONFIG)) {
                    BillingResult billingResult9 = this.zzv ? zzcj.zzi : zzcj.zzy;
                    zzbc(billingResult9, zzie.GET_BILLING_CONFIG_NOT_SUPPORTED, 11);
                    return billingResult9;
                }
                break;
            case 103272:
                if (str.equals("hhh")) {
                    BillingResult billingResult10 = this.zzv ? zzcj.zzi : zzcj.zzz;
                    zzbc(billingResult10, zzie.QUERY_PRODUCT_DETAILS_WITH_SERIALIZED_DOCID_NOT_SUPPORTED, 12);
                    return billingResult10;
                }
                break;
            case 104265:
                if (str.equals("iii")) {
                    BillingResult billingResult11 = this.zzx ? zzcj.zzi : zzcj.zzC;
                    zzbc(billingResult11, zzie.QUERY_PRODUCT_DETAILS_WITH_DEVELOPER_SPECIFIED_ACCOUNT_NOT_SUPPORTED, 13);
                    return billingResult11;
                }
                break;
            case 105258:
                if (str.equals(BillingClient.FeatureType.ALTERNATIVE_BILLING_ONLY)) {
                    BillingResult billingResult12 = this.zzy ? zzcj.zzi : zzcj.zzD;
                    zzbc(billingResult12, zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED, 14);
                    return billingResult12;
                }
                break;
            case 106251:
                if (str.equals(BillingClient.FeatureType.EXTERNAL_OFFER)) {
                    BillingResult billingResult13 = this.zzB ? zzcj.zzi : zzcj.zzA;
                    zzbc(billingResult13, zzie.LAUNCH_EXTERNAL_OFFER_FLOW_NOT_SUPPORTED, 18);
                    return billingResult13;
                }
                break;
            case 107244:
                if (str.equals("lll")) {
                    BillingResult billingResult14 = this.zzA ? zzcj.zzi : zzcj.zzu;
                    zzbc(billingResult14, zzie.MULTI_ITEM_WITH_SEASON_PASS_NOT_SUPPORTED, 19);
                    return billingResult14;
                }
                break;
            case 108237:
                if (str.equals("mmm")) {
                    BillingResult billingResult15 = this.zzB ? zzcj.zzi : zzcj.zzv;
                    zzbc(billingResult15, zzie.AUTO_PAY_NOT_SUPPORTED, 20);
                    return billingResult15;
                }
                break;
            case 109230:
                if (str.equals("nnn")) {
                    BillingResult billingResult16 = this.zzC ? zzcj.zzi : zzcj.zzw;
                    zzbc(billingResult16, zzie.INCLUDE_SUSPENDED_SUBSCRIPTIONS_NOT_SUPPORTED, 21);
                    return billingResult16;
                }
                break;
            case 207616302:
                if (str.equals(BillingClient.FeatureType.PRICE_CHANGE_CONFIRMATION)) {
                    BillingResult billingResult17 = this.zzo ? zzcj.zzi : zzcj.zzn;
                    zzbc(billingResult17, zzie.PRICE_CHANGE_CONFIRMATION_NOT_SUPPORTED, 4);
                    return billingResult17;
                }
                break;
            case 1987365622:
                if (str.equals(BillingClient.FeatureType.SUBSCRIPTIONS)) {
                    BillingResult billingResult18 = this.zzk ? zzcj.zzi : zzcj.zzl;
                    zzbc(billingResult18, zzie.SUBSCRIPTIONS_NOT_SUPPORTED, 2);
                    return billingResult18;
                }
                break;
        }
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unsupported feature: ".concat(String.valueOf(str)));
        BillingResult billingResult19 = zzcj.zzx;
        zzbc(billingResult19, zzie.UNKNOWN_FEATURE, 1);
        return billingResult19;
    }

    @Override // com.android.billingclient.api.BillingClient
    public final boolean isReady() {
        if (this.zzE) {
            return true;
        }
        return zzaY();
    }

    /* JADX WARN: Code duplicated, block: B:186:0x04a9  */
    /* JADX WARN: Code duplicated, block: B:189:0x04b4  */
    /* JADX WARN: Code duplicated, block: B:190:0x04bc  */
    /* JADX WARN: Code duplicated, block: B:192:0x04c8  */
    /* JADX WARN: Code duplicated, block: B:202:0x04ff  */
    /* JADX WARN: Code duplicated, block: B:204:0x0503 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:206:0x0508  */
    /* JADX WARN: Code duplicated, block: B:208:0x050c  */
    /* JADX WARN: Code duplicated, block: B:209:0x050f  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.android.billingclient.api.BillingClient
    public BillingResult launchBillingFlow(Activity activity, BillingFlowParams billingFlowParams) {
        boolean zZzd;
        String productId;
        String productType;
        long j;
        Future futureZzG;
        long j2;
        zzie zzieVarZzb;
        Object obj;
        int i;
        String str;
        boolean z;
        String str2;
        long j3;
        boolean z2;
        Intent intent;
        int i2;
        long jNextLong = new Random().nextLong();
        if (this.zzf == null || this.zzf.zzd() == null) {
            zzie zzieVar = zzie.MISSING_LISTENER;
            BillingResult billingResult = zzcj.zzE;
            zzbe(zzieVar, 2, billingResult, jNextLong);
            return billingResult;
        }
        if (!zzaW(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)) {
            zzie zzieVar2 = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult2 = zzcj.zzj;
            zzbe(zzieVar2, 2, billingResult2, jNextLong);
            zzm(billingResult2);
            return billingResult2;
        }
        synchronized (this.zza) {
            zZzd = this.zzj != null ? this.zzj.zzd() : false;
        }
        ArrayList<SkuDetails> arrayListZzj = billingFlowParams.zzj();
        List listZzk = billingFlowParams.zzk();
        String string = null;
        SkuDetails skuDetails = (SkuDetails) com.google.android.gms.internal.play_billing.zzby.zza(arrayListZzj, null);
        BillingFlowParams.ProductDetailsParams productDetailsParams = (BillingFlowParams.ProductDetailsParams) com.google.android.gms.internal.play_billing.zzby.zza(listZzk, null);
        if (skuDetails != null) {
            productId = skuDetails.getSku();
            productType = skuDetails.getType();
        } else {
            productId = productDetailsParams.zza().getProductId();
            productType = productDetailsParams.zza().getProductType();
        }
        if (productType.equals("subs") && !this.zzk) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support subscriptions.");
            zzie zzieVar3 = zzie.SUBSCRIPTIONS_NOT_SUPPORTED;
            BillingResult billingResult3 = zzcj.zzl;
            zzbg(zzieVar3, 2, billingResult3, jNextLong, zZzd);
            zzm(billingResult3);
            return billingResult3;
        }
        if (billingFlowParams.zzt() && !this.zzn) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support extra params for buy intent.");
            zzie zzieVar4 = zzie.EXTRA_PARAMS_NOT_SUPPORTED;
            BillingResult billingResult4 = zzcj.zzf;
            zzbg(zzieVar4, 2, billingResult4, jNextLong, zZzd);
            zzm(billingResult4);
            return billingResult4;
        }
        if (arrayListZzj.size() > 1 && !this.zzt) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support multi-item purchases.");
            zzie zzieVar5 = zzie.MULTI_ITEM_NOT_SUPPORTED;
            BillingResult billingResult5 = zzcj.zzp;
            zzbg(zzieVar5, 2, billingResult5, jNextLong, zZzd);
            zzm(billingResult5);
            return billingResult5;
        }
        if (!listZzk.isEmpty() && !this.zzu) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support purchases with ProductDetails.");
            zzie zzieVar6 = zzie.PRODUCT_DETAILS_NOT_SUPPORTED;
            BillingResult billingResult6 = zzcj.zzr;
            zzbg(zzieVar6, 2, billingResult6, jNextLong, zZzd);
            zzm(billingResult6);
            return billingResult6;
        }
        BillingResult billingResultZzd = billingFlowParams.zzd();
        if (billingResultZzd != zzcj.zzi) {
            zzbg(zzie.INVALID_BILLING_FLOW_PARAMS, 2, billingResultZzd, jNextLong, zZzd);
            zzm(billingResultZzd);
            return billingResultZzd;
        }
        if (this.zzn) {
            boolean z3 = this.zzp;
            boolean z4 = this.zzw;
            boolean zIsEnabledForOneTimeProducts = this.zzD.isEnabledForOneTimeProducts();
            boolean zIsEnabledForPrepaidPlans = this.zzD.isEnabledForPrepaidPlans();
            boolean z5 = this.zzF;
            String str3 = this.zzc;
            String str4 = this.zzd;
            boolean z6 = zZzd;
            long jLongValue = this.zzI.longValue();
            this.zzg.getPackageName();
            int i3 = com.google.android.gms.internal.play_billing.zzc.zza;
            final Bundle bundle = new Bundle();
            com.google.android.gms.internal.play_billing.zzc.zzc(bundle, str3, str4, jLongValue);
            bundle.putLong("billingClientTransactionId", jNextLong);
            if (billingFlowParams.zzb() != 0) {
                bundle.putInt("prorationMode", billingFlowParams.zzb());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zze())) {
                bundle.putString("accountId", billingFlowParams.zze());
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzf())) {
                bundle.putString("obfuscatedProfileId", billingFlowParams.zzf());
            }
            if (billingFlowParams.zzs()) {
                i = 1;
                bundle.putBoolean("isOfferPersonalizedByDeveloper", true);
            } else {
                i = 1;
            }
            if (!TextUtils.isEmpty(null)) {
                String[] strArr = new String[i];
                strArr[0] = null;
                bundle.putStringArrayList("skusToReplace", new ArrayList<>(Arrays.asList(strArr)));
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzh())) {
                bundle.putString("oldSkuPurchaseToken", billingFlowParams.zzh());
            }
            billingFlowParams.zzg();
            if (TextUtils.isEmpty(null)) {
                str = null;
            } else {
                billingFlowParams.zzg();
                str = null;
                bundle.putString("oldSkuPurchaseId", null);
            }
            if (!TextUtils.isEmpty(billingFlowParams.zzi())) {
                bundle.putString("originalExternalTransactionId", billingFlowParams.zzi());
            }
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("paymentsPurchaseParams", str);
            }
            if (z3 && zIsEnabledForOneTimeProducts) {
                z = true;
                bundle.putBoolean(InAppPurchaseConstants.METHOD_ENABLE_PENDING_PURCHASES, true);
            } else {
                z = true;
            }
            if (z4 && zIsEnabledForPrepaidPlans) {
                bundle.putBoolean("enablePendingPurchaseForSubscriptions", z);
            }
            if (z5) {
                bundle.putBoolean("enableAlternativeBilling", z);
            }
            billingFlowParams.zzc();
            billingFlowParams.zza();
            ArrayList arrayList = new ArrayList();
            for (BillingFlowParams.ProductDetailsParams productDetailsParams2 : billingFlowParams.zzk()) {
            }
            if (!arrayList.isEmpty()) {
                zzdj zzdjVarZza = zzdk.zza();
                zzdjVarZza.zza(arrayList);
                bundle.putByteArray("subscriptionProductReplacementParamsList", ((zzdk) zzdjVarZza.zze()).zzM());
            }
            if (arrayListZzj.isEmpty()) {
                long j4 = jNextLong;
                str2 = productId;
                ArrayList<String> arrayList2 = new ArrayList<>(listZzk.size() - 1);
                ArrayList<String> arrayList3 = new ArrayList<>(listZzk.size() - 1);
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                ArrayList<String> arrayList6 = new ArrayList<>();
                ArrayList<Integer> arrayList7 = new ArrayList<>();
                for (int i4 = 0; i4 < listZzk.size(); i4++) {
                    BillingFlowParams.ProductDetailsParams productDetailsParams3 = (BillingFlowParams.ProductDetailsParams) listZzk.get(i4);
                    ProductDetails productDetailsZza = productDetailsParams3.zza();
                    if (!productDetailsZza.zzb().isEmpty()) {
                        arrayList4.add(productDetailsZza.zzb());
                    }
                    arrayList5.add(productDetailsParams3.zzb());
                    String strZzc = productDetailsZza.zzc();
                    if (productDetailsZza.zzd() != null && !productDetailsZza.zzd().isEmpty()) {
                        for (ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails : productDetailsZza.zzd()) {
                            if (!TextUtils.isEmpty(oneTimePurchaseOfferDetails.zzb())) {
                                strZzc = oneTimePurchaseOfferDetails.zzb();
                                break;
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(strZzc)) {
                        arrayList6.add(strZzc);
                    }
                    if (i4 > 0) {
                        arrayList2.add(((BillingFlowParams.ProductDetailsParams) listZzk.get(i4)).zza().getProductId());
                        arrayList3.add(((BillingFlowParams.ProductDetailsParams) listZzk.get(i4)).zza().getProductType());
                    }
                }
                bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList5);
                if (!arrayList7.isEmpty()) {
                    bundle.putIntegerArrayList("autoPayBalanceThresholdList", arrayList7);
                }
                if (!arrayList4.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList4);
                }
                if (!arrayList6.isEmpty()) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList6);
                }
                j3 = j4;
                if (!arrayList2.isEmpty()) {
                    bundle.putStringArrayList("additionalSkus", arrayList2);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList3);
                    j3 = j4;
                }
            } else {
                ArrayList<String> arrayList8 = new ArrayList<>();
                ArrayList<String> arrayList9 = new ArrayList<>();
                ArrayList<String> arrayList10 = new ArrayList<>();
                ArrayList<Integer> arrayList11 = new ArrayList<>();
                ArrayList<String> arrayList12 = new ArrayList<>();
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                long j5 = jNextLong;
                for (SkuDetails skuDetails2 : arrayListZzj) {
                    if (!skuDetails2.zzf().isEmpty()) {
                        arrayList8.add(skuDetails2.zzf());
                    }
                    String strZzc2 = skuDetails2.zzc();
                    String strZzb = skuDetails2.zzb();
                    int iZza = skuDetails2.zza();
                    String str5 = productId;
                    String strZze = skuDetails2.zze();
                    arrayList9.add(strZzc2);
                    z7 |= !TextUtils.isEmpty(strZzc2);
                    arrayList10.add(strZzb);
                    z8 |= !TextUtils.isEmpty(strZzb);
                    arrayList11.add(Integer.valueOf(iZza));
                    z9 |= iZza != 0;
                    z10 |= !TextUtils.isEmpty(strZze);
                    arrayList12.add(strZze);
                    j5 = j5;
                    productId = str5;
                }
                long j6 = j5;
                str2 = productId;
                if (!arrayList8.isEmpty()) {
                    bundle.putStringArrayList("skuDetailsTokens", arrayList8);
                }
                if (z7) {
                    bundle.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList9);
                }
                if (z8) {
                    bundle.putStringArrayList("SKU_OFFER_ID_LIST", arrayList10);
                }
                if (z9) {
                    bundle.putIntegerArrayList("SKU_OFFER_TYPE_LIST", arrayList11);
                }
                if (z10) {
                    bundle.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList12);
                }
                j3 = j6;
                if (arrayListZzj.size() > 1) {
                    ArrayList<String> arrayList13 = new ArrayList<>(arrayListZzj.size() - 1);
                    ArrayList<String> arrayList14 = new ArrayList<>(arrayListZzj.size() - 1);
                    for (int i5 = 1; i5 < arrayListZzj.size(); i5++) {
                        arrayList13.add(((SkuDetails) arrayListZzj.get(i5)).getSku());
                        arrayList14.add(((SkuDetails) arrayListZzj.get(i5)).getType());
                    }
                    bundle.putStringArrayList("additionalSkus", arrayList13);
                    bundle.putStringArrayList("additionalSkuTypes", arrayList14);
                    j3 = j6;
                }
            }
            if (bundle.containsKey("SKU_OFFER_ID_TOKEN_LIST") && !this.zzr) {
                zzie zzieVar7 = zzie.OFFER_ID_TOKEN_NOT_SUPPORTED;
                BillingResult billingResult7 = zzcj.zzq;
                zzbg(zzieVar7, 2, billingResult7, j3, z6);
                zzm(billingResult7);
                return billingResult7;
            }
            zZzd = z6;
            if (skuDetails == null || TextUtils.isEmpty(skuDetails.zzd())) {
                if (productDetailsParams == null || TextUtils.isEmpty(productDetailsParams.zza().zza())) {
                    z2 = false;
                    string = null;
                } else {
                    bundle.putString("skuPackageName", productDetailsParams.zza().zza());
                }
                if (!TextUtils.isEmpty(string)) {
                    bundle.putString("accountName", string);
                }
                intent = activity.getIntent();
                if (intent == null) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Activity's intent is null.");
                } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                    String stringExtra = intent.getStringExtra("PROXY_PACKAGE");
                    bundle.putString("proxyPackage", stringExtra);
                    try {
                        bundle.putString("proxyPackageVersion", this.zzg.getPackageManager().getPackageInfo(stringExtra, 0).versionName);
                    } catch (PackageManager.NameNotFoundException unused) {
                        bundle.putString("proxyPackageVersion", "package not found");
                    }
                }
                if (!this.zzu && !listZzk.isEmpty()) {
                    i2 = 17;
                } else if (!this.zzs && z2) {
                    i2 = 15;
                } else if (this.zzp) {
                    i2 = 9;
                } else {
                    i2 = 6;
                }
                final int i6 = i2;
                final BillingFlowParams billingFlowParams2 = billingFlowParams;
                final String str6 = productType;
                final String str7 = str2;
                futureZzG = zzG(new Callable() { // from class: com.android.billingclient.api.zzw
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.zza.zzal(i6, str7, str6, billingFlowParams2, bundle);
                    }
                }, 5000L, null, this.zze, zzF());
                j2 = billingFlowParams2;
                j = j3;
            } else {
                bundle.putString("skuPackageName", skuDetails.zzd());
            }
            string = null;
            z2 = true;
            if (!TextUtils.isEmpty(string)) {
                bundle.putString("accountName", string);
            }
            intent = activity.getIntent();
            if (intent == null) {
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Activity's intent is null.");
            } else if (!TextUtils.isEmpty(intent.getStringExtra("PROXY_PACKAGE"))) {
                String stringExtra2 = intent.getStringExtra("PROXY_PACKAGE");
                bundle.putString("proxyPackage", stringExtra2);
                bundle.putString("proxyPackageVersion", this.zzg.getPackageManager().getPackageInfo(stringExtra2, 0).versionName);
            }
            if (!this.zzu) {
                if (!this.zzs) {
                    if (this.zzp) {
                        i2 = 9;
                    } else {
                        i2 = 6;
                    }
                } else if (this.zzp) {
                    i2 = 9;
                } else {
                    i2 = 6;
                }
            } else if (!this.zzs) {
                if (this.zzp) {
                    i2 = 9;
                } else {
                    i2 = 6;
                }
            } else if (this.zzp) {
                i2 = 9;
            } else {
                i2 = 6;
            }
            final int i7 = i2;
            final BillingFlowParams billingFlowParams3 = billingFlowParams;
            final String str8 = productType;
            final String str9 = str2;
            futureZzG = zzG(new Callable() { // from class: com.android.billingclient.api.zzw
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzal(i7, str9, str8, billingFlowParams3, bundle);
                }
            }, 5000L, null, this.zze, zzF());
            j2 = billingFlowParams3;
            j = j3;
        } else {
            j = jNextLong;
            final String str10 = productId;
            final String str11 = productType;
            futureZzG = zzG(new Callable() { // from class: com.android.billingclient.api.zzx
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzam(str10, str11);
                }
            }, 5000L, null, this.zze, zzF());
            j2 = jNextLong;
        }
        try {
            if (futureZzG != null) {
                long j7 = j;
                Bundle bundle2 = (Bundle) futureZzG.get(5000L, TimeUnit.MILLISECONDS);
                int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle2, "BillingClient");
                String strZzj = com.google.android.gms.internal.play_billing.zzc.zzj(bundle2, "BillingClient");
                if (iZzb == 0) {
                    Intent intent2 = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
                    intent2.putExtra("BUY_INTENT", (PendingIntent) bundle2.getParcelable("BUY_INTENT"));
                    intent2.putExtra("billingClientTransactionId", j7);
                    intent2.putExtra("wasServiceAutoReconnected", zZzd);
                    activity.startActivity(intent2);
                    return zzcj.zzi;
                }
                com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unable to buy item, Error response code: " + iZzb);
                BillingResult billingResultZza = zzcj.zza(iZzb, strZzj);
                try {
                    if (bundle2 == null || (obj = bundle2.get("LOG_REASON")) == null) {
                        zzieVarZzb = zzie.REASON_UNSPECIFIED;
                    } else if (obj instanceof Integer) {
                        zzieVarZzb = zzie.zzb(((Integer) obj).intValue());
                    } else {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Unexpected type for bundle log reason: " + obj.getClass().getName());
                        zzieVarZzb = zzie.REASON_UNSPECIFIED;
                    }
                } catch (Throwable th) {
                    com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Failed to get log reason from bundle: ".concat(String.valueOf(th.getMessage())));
                    zzieVarZzb = zzie.REASON_UNSPECIFIED;
                }
                if (zzieVarZzb == zzie.REASON_UNSPECIFIED) {
                    zzieVarZzb = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
                }
                zzie zzieVar8 = zzieVarZzb;
                if (bundle2 != null) {
                    try {
                        string = bundle2.getString("ADDITIONAL_LOG_DETAILS");
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Failed to get additional log details from bundle: ".concat(String.valueOf(th2.getMessage())));
                    }
                }
                try {
                    zzbh(zzieVar8, 2, billingResultZza, string, j7, zZzd);
                    zzm(billingResultZza);
                    return billingResultZza;
                } catch (CancellationException e) {
                    e = e;
                    j2 = j7;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar9 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult8 = zzcj.zzk;
                    zzbh(zzieVar9, 2, billingResult8, zzcg.zza(e), j2, zZzd);
                    zzm(billingResult8);
                    return billingResult8;
                } catch (TimeoutException e2) {
                    e = e2;
                    j2 = j7;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar10 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult9 = zzcj.zzk;
                    zzbh(zzieVar10, 2, billingResult9, zzcg.zza(e), j2, zZzd);
                    zzm(billingResult9);
                    return billingResult9;
                } catch (Exception e3) {
                    e = e3;
                    j2 = j7;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                    zzie zzieVar11 = zzie.LAUNCH_BILLING_FLOW_EXCEPTION;
                    BillingResult billingResult10 = zzcj.zzj;
                    zzbh(zzieVar11, 2, billingResult10, zzcg.zza(e), j2, zZzd);
                    zzm(billingResult10);
                    return billingResult10;
                }
            }
            try {
                zzie zzieVar12 = zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC;
                BillingResult billingResult11 = zzcj.zzc;
                boolean z11 = zZzd;
                j2 = j;
                try {
                    zzbg(zzieVar12, 2, billingResult11, j2, z11);
                    zzm(billingResult11);
                    return billingResult11;
                } catch (CancellationException e4) {
                    e = e4;
                    zZzd = z11;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar13 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult12 = zzcj.zzk;
                    zzbh(zzieVar13, 2, billingResult12, zzcg.zza(e), j2, zZzd);
                    zzm(billingResult12);
                    return billingResult12;
                } catch (TimeoutException e5) {
                    e = e5;
                    zZzd = z11;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                    zzie zzieVar14 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                    BillingResult billingResult13 = zzcj.zzk;
                    zzbh(zzieVar14, 2, billingResult13, zzcg.zza(e), j2, zZzd);
                    zzm(billingResult13);
                    return billingResult13;
                } catch (Exception e6) {
                    e = e6;
                    zZzd = z11;
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while launching billing flow. Try to reconnect", e);
                    zzie zzieVar15 = zzie.LAUNCH_BILLING_FLOW_EXCEPTION;
                    BillingResult billingResult14 = zzcj.zzj;
                    zzbh(zzieVar15, 2, billingResult14, zzcg.zza(e), j2, zZzd);
                    zzm(billingResult14);
                    return billingResult14;
                }
            } catch (CancellationException e7) {
                e = e7;
                j2 = j;
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzie zzieVar16 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult15 = zzcj.zzk;
                zzbh(zzieVar16, 2, billingResult15, zzcg.zza(e), j2, zZzd);
                zzm(billingResult15);
                return billingResult15;
            } catch (TimeoutException e8) {
                e = e8;
                j2 = j;
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Time out while launching billing flow. Try to reconnect", e);
                zzie zzieVar17 = zzie.LAUNCH_BILLING_FLOW_TIMEOUT;
                BillingResult billingResult16 = zzcj.zzk;
                zzbh(zzieVar17, 2, billingResult16, zzcg.zza(e), j2, zZzd);
                zzm(billingResult16);
                return billingResult16;
            } catch (Exception e9) {
                e = e9;
                j2 = j;
            }
        } catch (CancellationException e10) {
            e = e10;
        } catch (TimeoutException e11) {
            e = e11;
        } catch (Exception e12) {
            e = e12;
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public void queryProductDetailsAsync(final QueryProductDetailsParams queryProductDetailsParams, final ProductDetailsResponseListener productDetailsResponseListener) {
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzal
            @Override // java.util.concurrent.Callable
            public final Object call() throws JSONException {
                BillingClientImpl.zzs(this.zza, productDetailsResponseListener, queryProductDetailsParams);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzap
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzN(this.zza, productDetailsResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult billingResultZzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 7, billingResultZzaq);
            productDetailsResponseListener.onProductDetailsResponse(billingResultZzaq, new QueryProductDetailsResult(com.google.android.gms.internal.play_billing.zzbt.zzk(), com.google.android.gms.internal.play_billing.zzbt.zzk()));
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final void queryPurchasesAsync(QueryPurchasesParams queryPurchasesParams, final PurchasesResponseListener purchasesResponseListener) {
        if (zzG(new zzaw(this, purchasesResponseListener, queryPurchasesParams.zza(), false), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzat
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzI(this.zza, purchasesResponseListener);
            }
        }, zzan(), zzF()) == null) {
            BillingResult billingResultZzaq = zzaq();
            zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 9, billingResultZzaq);
            purchasesResponseListener.onQueryPurchasesResponse(billingResultZzaq, com.google.android.gms.internal.play_billing.zzbt.zzk());
        }
    }

    @Override // com.android.billingclient.api.BillingClient
    public final BillingResult showInAppMessages(final Activity activity, InAppMessageParams inAppMessageParams, InAppMessageResponseListener inAppMessageResponseListener) {
        if (!zzaW(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Service disconnected.");
            return zzcj.zzj;
        }
        if (!this.zzq) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current client doesn't support showing in-app messages.");
            return zzcj.zzs;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        IBinder windowToken = viewFindViewById.getWindowToken();
        Rect rect = new Rect();
        viewFindViewById.getGlobalVisibleRect(rect);
        final Bundle bundle = new Bundle();
        BundleCompat.putBinder(bundle, "KEY_WINDOW_TOKEN", windowToken);
        bundle.putInt("KEY_DIMEN_LEFT", rect.left);
        bundle.putInt("KEY_DIMEN_TOP", rect.top);
        bundle.putInt("KEY_DIMEN_RIGHT", rect.right);
        bundle.putInt("KEY_DIMEN_BOTTOM", rect.bottom);
        bundle.putString("playBillingLibraryVersion", this.zzc);
        String str = this.zzd;
        if (str != null) {
            bundle.putString("playBillingLibraryWrapperVersion", str);
        }
        bundle.putIntegerArrayList("KEY_CATEGORY_IDS", inAppMessageParams.zza());
        Handler handler = this.zze;
        final zzax zzaxVar = new zzax(this, handler, inAppMessageResponseListener);
        zzG(new Callable() { // from class: com.android.billingclient.api.zzas
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzu(this.zza, bundle, activity, zzaxVar);
                return null;
            }
        }, 5000L, null, handler, zzF());
        return zzcj.zzi;
    }

    final synchronized ExecutorService zzF() {
        if (this.zzH == null) {
            this.zzH = Executors.newFixedThreadPool(com.google.android.gms.internal.play_billing.zzc.zza, new zzav(this));
        }
        return this.zzH;
    }

    public final void zzag(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.zze.post(runnable);
        }
    }

    final zzbo zzg(QueryProductDetailsParams queryProductDetailsParams) throws JSONException {
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strZzb = queryProductDetailsParams.zzb();
        com.google.android.gms.internal.play_billing.zzbt zzbtVarZza = queryProductDetailsParams.zza();
        int size = zzbtVarZza.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 20;
            ArrayList<QueryProductDetailsParams.Product> arrayList3 = new ArrayList(zzbtVarZza.subList(i, i2 > size ? size : i2));
            ArrayList<String> arrayList4 = new ArrayList<>();
            int size2 = arrayList3.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList4.add(((QueryProductDetailsParams.Product) arrayList3.get(i3)).zza());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList4);
            String str = this.zzc;
            bundle.putString("playBillingLibraryVersion", str);
            try {
                synchronized (this.zza) {
                    zzamVar = this.zzi;
                }
                if (zzamVar == null) {
                    return zzao(zzcj.zzj, zzie.SERVICE_RESET_TO_NULL, "Service has been reset to null.", null);
                }
                boolean z = this.zzw && this.zzD.isEnabledForPrepaidPlans();
                zzav(queryProductDetailsParams);
                zzav(queryProductDetailsParams);
                zzav(queryProductDetailsParams);
                zzav(queryProductDetailsParams);
                Bundle bundleZzj = zzamVar.zzj(true != this.zzx ? 17 : 20, this.zzg.getPackageName(), strZzb, bundle, com.google.android.gms.internal.play_billing.zzc.zzf(str, this.zzd, arrayList3, null, null, com.google.android.gms.internal.play_billing.zza.zza(z, true, false, true, false, true), this.zzI.longValue()));
                if (bundleZzj == null) {
                    return zzao(zzcj.zzB, zzie.NULL_BUNDLE_FROM_GET_SKU_DETAILS_SERVICE_CALL, "queryProductDetailsAsync got empty product details response.", null);
                }
                if (!bundleZzj.containsKey("DETAILS_LIST")) {
                    int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundleZzj, "BillingClient");
                    String strZzj = com.google.android.gms.internal.play_billing.zzc.zzj(bundleZzj, "BillingClient");
                    if (iZzb == 0) {
                        return zzao(zzcj.zza(6, strZzj), zzie.MISSING_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.", null);
                    }
                    return zzao(zzcj.zza(iZzb, strZzj), zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY, "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + iZzb, null);
                }
                ArrayList<String> stringArrayList = bundleZzj.getStringArrayList("DETAILS_LIST");
                if (stringArrayList == null) {
                    return zzao(zzcj.zzB, zzie.NULL_DETAILS_LIST_IN_GET_SKU_DETAILS_RESPONSE, "queryProductDetailsAsync got null response list", null);
                }
                ArrayList arrayList5 = new ArrayList();
                int size3 = stringArrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    try {
                        ProductDetails productDetails = new ProductDetails(stringArrayList.get(i4));
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Got product details: ".concat(productDetails.toString()));
                        arrayList5.add(productDetails);
                    } catch (JSONException e) {
                        return zzao(zzcj.zza(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e);
                    }
                }
                ArrayList<String> stringArrayList2 = bundleZzj.getStringArrayList("UNFETCHED_PRODUCT_LIST");
                new ArrayList();
                try {
                    ArrayList arrayList6 = new ArrayList();
                    if (stringArrayList2 == null) {
                        for (QueryProductDetailsParams.Product product : arrayList3) {
                            Iterator it = arrayList5.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    arrayList6.add(new UnfetchedProduct(new JSONObject().put("productId", product.zza()).put("type", product.zzb()).put("statusCode", 0).toString()));
                                    break;
                                }
                                ProductDetails productDetails2 = (ProductDetails) it.next();
                                if (product.zza().equals(productDetails2.getProductId()) && product.zzb().equals(productDetails2.getProductType())) {
                                    break;
                                }
                            }
                        }
                    } else {
                        Iterator<String> it2 = stringArrayList2.iterator();
                        while (it2.hasNext()) {
                            UnfetchedProduct unfetchedProduct = new UnfetchedProduct(it2.next());
                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Got unfetchedProduct: ".concat(unfetchedProduct.toString()));
                            arrayList6.add(unfetchedProduct);
                        }
                    }
                    arrayList.addAll(arrayList5);
                    arrayList2.addAll(arrayList6);
                    i = i2;
                } catch (JSONException e2) {
                    return zzao(zzcj.zza(6, "Error trying to decode SkuDetails."), zzie.ERROR_DECODING_SKU_DETAILS, "Got a JSON exception trying to decode UnfetchedProduct. \n Exception: ", e2);
                }
            } catch (DeadObjectException e3) {
                return zzao(zzcj.zzj, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e3);
            } catch (Exception e4) {
                return zzao(zzcj.zzh, zzie.GET_SKU_DETAILS_SERVICE_CALL_EXCEPTION, "queryProductDetailsAsync got a remote exception (try to reconnect).", e4);
            }
        }
        return new zzbo(0, "", arrayList, arrayList2);
    }

    final zzch zzj() {
        return this.zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final BillingResult zzm(final BillingResult billingResult) {
        if (Thread.interrupted()) {
            return billingResult;
        }
        this.zze.post(new Runnable() { // from class: com.android.billingclient.api.zzac
            @Override // java.lang.Runnable
            public final void run() {
                BillingClientImpl.zzP(this.zza, billingResult);
            }
        });
        return billingResult;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showAlternativeBillingOnlyInformationDialog(final Activity activity, final AlternativeBillingOnlyInformationDialogListener alternativeBillingOnlyInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzaW(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            zzbd(zzieVar, 16, billingResult);
            return billingResult;
        }
        if (!this.zzy) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current Play Store version doesn't support alternative billing only.");
            zzie zzieVar2 = zzie.ALTERNATIVE_BILLING_ONLY_NOT_SUPPORTED;
            BillingResult billingResult2 = zzcj.zzD;
            zzbd(zzieVar2, 16, billingResult2);
            return billingResult2;
        }
        Handler handler = this.zze;
        final zzay zzayVar = new zzay(this, handler, alternativeBillingOnlyInformationDialogListener);
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzy
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzz(this.zza, alternativeBillingOnlyInformationDialogListener, activity, zzayVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaM(alternativeBillingOnlyInformationDialogListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, handler, zzF()) != null) {
            return zzcj.zzi;
        }
        BillingResult billingResultZzaq = zzaq();
        zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 16, billingResultZzaq);
        return billingResultZzaq;
    }

    @Override // com.android.billingclient.api.BillingClient
    public BillingResult showExternalOfferInformationDialog(final Activity activity, final ExternalOfferInformationDialogListener externalOfferInformationDialogListener) {
        if (activity == null) {
            throw new IllegalArgumentException("Please provide a valid activity.");
        }
        if (!zzaW(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS)) {
            zzie zzieVar = zzie.SERVICE_CONNECTION_NOT_READY;
            BillingResult billingResult = zzcj.zzj;
            zzbd(zzieVar, 25, billingResult);
            return billingResult;
        }
        if (!this.zzz) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Current Play Store version doesn't support external offer.");
            zzie zzieVar2 = zzie.EXTERNAL_OFFER_NOT_SUPPORTED;
            BillingResult billingResult2 = zzcj.zzt;
            zzbd(zzieVar2, 25, billingResult2);
            return billingResult2;
        }
        Handler handler = this.zze;
        final zzaz zzazVar = new zzaz(this, handler, externalOfferInformationDialogListener);
        if (zzG(new Callable() { // from class: com.android.billingclient.api.zzan
            @Override // java.util.concurrent.Callable
            public final Object call() throws Exception {
                BillingClientImpl.zzB(this.zza, externalOfferInformationDialogListener, activity, zzazVar);
                return null;
            }
        }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzao
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzaK(externalOfferInformationDialogListener, zzcj.zzk, zzie.EXECUTE_ASYNC_TIMEOUT, null);
            }
        }, handler, zzF()) != null) {
            return zzcj.zzi;
        }
        BillingResult billingResultZzaq = zzaq();
        zzbd(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, 25, billingResultZzaq);
        return billingResultZzaq;
    }

    @Override // com.android.billingclient.api.BillingClient
    public void startConnection(BillingClientStateListener billingClientStateListener) {
        zzaU(billingClientStateListener, 0);
    }

    private BillingClientImpl(Context context, PendingPurchasesParams pendingPurchasesParams, PurchasesUpdatedListener purchasesUpdatedListener, String str, String str2, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzI = Long.valueOf(new Random().nextLong());
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = str;
        this.zzd = zzaw();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, userChoiceBillingListener, str, (zzch) null, builder);
    }

    private BillingClientImpl(String str) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzI = Long.valueOf(new Random().nextLong());
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = str;
        this.zzd = zzaw();
    }

    BillingClientImpl(String str, Context context, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzI = lValueOf;
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        String strZzaw = zzaw();
        this.zzd = strZzaw;
        this.zzg = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs(BuildConfig.VERSION_NAME);
        if (strZzaw != null) {
            zziqVarZzc.zzt(strZzaw);
        }
        zziqVarZzc.zzq(this.zzg.getPackageName());
        zziqVarZzc.zzn(lValueOf.longValue());
        zziqVarZzc.zzr(builder.zza);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzcl(this.zzg, (zzis) zziqVarZzc.zze());
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    private void initialize(Context context, PurchasesUpdatedListener purchasesUpdatedListener, PendingPurchasesParams pendingPurchasesParams, UserChoiceBillingListener userChoiceBillingListener, String str, zzch zzchVar, BillingClient.Builder builder) {
        this.zzg = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs(str);
        String str2 = this.zzd;
        if (str2 != null) {
            zziqVarZzc.zzt(str2);
        }
        zziqVarZzc.zzq(this.zzg.getPackageName());
        zziqVarZzc.zzn(this.zzI.longValue());
        zziqVarZzc.zzr(builder.zza);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        if (zzchVar != null) {
            this.zzh = zzchVar;
        } else {
            this.zzh = new zzcl(this.zzg, (zzis) zziqVarZzc.zze());
        }
        if (purchasesUpdatedListener == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.zzf = new zzs(this.zzg, purchasesUpdatedListener, null, null, userChoiceBillingListener, this.zzh);
        this.zzD = pendingPurchasesParams;
        this.zzF = userChoiceBillingListener != null;
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, zzco zzcoVar, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        Long lValueOf = Long.valueOf(new Random().nextLong());
        this.zzI = lValueOf;
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        String strZzaw = zzaw();
        this.zzd = strZzaw;
        this.zzg = context.getApplicationContext();
        zziq zziqVarZzc = zzis.zzc();
        zziqVarZzc.zzs(BuildConfig.VERSION_NAME);
        if (strZzaw != null) {
            zziqVarZzc.zzt(strZzaw);
        }
        zziqVarZzc.zzq(this.zzg.getPackageName());
        zziqVarZzc.zzn(lValueOf.longValue());
        zziqVarZzc.zzr(builder.zza);
        zziqVarZzc.zza(Build.VERSION.SDK_INT);
        zziqVarZzc.zzp(772604006L);
        try {
            zziqVarZzc.zzl(this.zzg.getPackageManager().getPackageInfo(this.zzg.getPackageName(), 0).versionCode);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error getting app version code.", th);
        }
        this.zzh = new zzcl(this.zzg, (zzis) zziqVarZzc.zze());
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.zzf = new zzs(this.zzg, null, null, null, null, this.zzh);
        this.zzD = pendingPurchasesParams;
        this.zzg.getPackageName();
        com.google.android.gms.internal.play_billing.zzbl zzblVar = builder.zzb;
        this.zzE = builder.zza;
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, zzb zzbVar, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this.zza = new Object();
        this.zzb = 0;
        this.zze = new Handler(Looper.getMainLooper());
        this.zzm = 0;
        this.zzI = Long.valueOf(new Random().nextLong());
        this.zzJ = com.google.android.gms.internal.play_billing.zzaz.zza();
        this.zzc = BuildConfig.VERSION_NAME;
        this.zzd = zzaw();
        initialize(context, purchasesUpdatedListener, pendingPurchasesParams, (zzb) null, BuildConfig.VERSION_NAME, (zzch) null, builder);
    }

    BillingClientImpl(String str, PendingPurchasesParams pendingPurchasesParams, Context context, PurchasesUpdatedListener purchasesUpdatedListener, UserChoiceBillingListener userChoiceBillingListener, zzch zzchVar, ExecutorService executorService, BillingClient.Builder builder) {
        this(context, pendingPurchasesParams, purchasesUpdatedListener, BuildConfig.VERSION_NAME, null, userChoiceBillingListener, null, null, builder);
    }
}
