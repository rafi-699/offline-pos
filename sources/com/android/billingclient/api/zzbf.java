package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.internal.play_billing.zzhv;
import com.google.android.gms.internal.play_billing.zzhx;
import com.google.android.gms.internal.play_billing.zzhz;
import com.google.android.gms.internal.play_billing.zzib;
import com.google.android.gms.internal.play_billing.zzic;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzig;
import com.google.android.gms.internal.play_billing.zzij;
import com.google.android.gms.internal.play_billing.zzjm;
import com.google.android.gms.internal.play_billing.zzjo;
import com.google.android.gms.internal.play_billing.zzjs;
import com.google.android.gms.internal.play_billing.zzjt;
import com.google.android.gms.internal.play_billing.zzjv;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.android.billingclient:billing@@8.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbf implements ServiceConnection {
    final /* synthetic */ BillingClientImpl zza;
    private final BillingClientStateListener zzb;
    private final com.google.android.gms.internal.play_billing.zzbi zzc;
    private final com.google.android.gms.internal.play_billing.zzbi zzd;
    private final int zze;

    /* synthetic */ zzbf(BillingClientImpl billingClientImpl, BillingClientStateListener billingClientStateListener, int i, zzbp zzbpVar) {
        Objects.requireNonNull(billingClientImpl);
        this.zza = billingClientImpl;
        this.zzc = com.google.android.gms.internal.play_billing.zzbi.zzc(billingClientImpl.zzJ);
        this.zzd = com.google.android.gms.internal.play_billing.zzbi.zzc(billingClientImpl.zzJ);
        this.zzb = billingClientStateListener;
        this.zze = i;
    }

    public static /* synthetic */ Object zza(zzbf zzbfVar) {
        Bundle bundle;
        com.google.android.gms.internal.play_billing.zzam zzamVar;
        zzie zzieVar;
        BillingClientImpl billingClientImpl = zzbfVar.zza;
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb != 3) {
                boolean z = billingClientImpl.zzb == 1;
                if (TextUtils.isEmpty(null)) {
                    bundle = null;
                } else {
                    bundle = new Bundle();
                    bundle.putString("accountName", null);
                    com.google.android.gms.internal.play_billing.zzc.zzc(bundle, billingClientImpl.zzc, billingClientImpl.zzd, billingClientImpl.zzI.longValue());
                }
                zzie zzieVar2 = zzie.REASON_UNSPECIFIED;
                synchronized (billingClientImpl.zza) {
                    zzamVar = billingClientImpl.zzi;
                }
                if (zzamVar == null) {
                    BillingClientImpl billingClientImpl2 = zzbfVar.zza;
                    billingClientImpl2.zzaS(0);
                    int i = zzbfVar.zze;
                    zzie zzieVar3 = zzie.SERVICE_RESET_TO_NULL;
                    BillingResult billingResult = zzcj.zzj;
                    billingClientImpl2.zzaR(zzieVar3, billingResult, i);
                    zzbfVar.zzg(billingResult);
                } else {
                    BillingClientImpl billingClientImpl3 = zzbfVar.zza;
                    String packageName = billingClientImpl3.zzg.getPackageName();
                    int iZzw = 3;
                    int i2 = 25;
                    while (true) {
                        if (i2 < 3) {
                            i2 = 0;
                            break;
                        }
                        if (bundle == null) {
                            try {
                                iZzw = zzamVar.zzw(i2, packageName, "subs");
                            } catch (Exception e) {
                                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while checking if billing is supported; try to reconnect", e);
                                if (e instanceof DeadObjectException) {
                                    zzieVar = zzie.IS_BILLING_SUPPORTED_DEAD_OBJECT_EXCEPTION;
                                } else if (e instanceof RemoteException) {
                                    zzieVar = zzie.IS_BILLING_SUPPORTED_REMOTE_EXCEPTION;
                                } else {
                                    zzieVar = e instanceof SecurityException ? zzie.IS_BILLING_SUPPORTED_SECURITY_EXCEPTION : zzie.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION;
                                }
                                String strZza = zzieVar.equals(zzie.IS_BILLING_SUPPORTED_SERVICE_CALL_EXCEPTION) ? zzcg.zza(e) : null;
                                zzbfVar.zza.zzaS(0);
                                zzbfVar.zzf(BillingClientImpl.zzl(e), zzieVar, strZza, z);
                                zzbfVar.zzg(BillingClientImpl.zzl(e));
                            }
                        } else {
                            iZzw = zzamVar.zzc(i2, packageName, "subs", bundle);
                        }
                        if (iZzw == 0) {
                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "highestLevelSupportedForSubs: " + i2);
                            break;
                        }
                        i2--;
                    }
                    billingClientImpl3.zzl = i2 >= 5;
                    billingClientImpl3.zzk = i2 >= 3;
                    if (i2 < 3) {
                        zzieVar2 = zzie.SUBSCRIPTIONS_NOT_SUPPORTED;
                        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "In-app billing API does not support subscription on this device.");
                    }
                    for (int i3 = 25; i3 >= 3; i3--) {
                        iZzw = bundle == null ? zzamVar.zzw(i3, packageName, "inapp") : zzamVar.zzc(i3, packageName, "inapp", bundle);
                        if (iZzw == 0) {
                            billingClientImpl3.zzm = i3;
                            com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "mHighestLevelSupportedForInApp: " + billingClientImpl3.zzm);
                            break;
                        }
                    }
                    BillingClientImpl.zzac(billingClientImpl3, billingClientImpl3.zzm);
                    if (billingClientImpl3.zzm < 3) {
                        zzieVar2 = zzie.ONE_TIME_PRODUCT_NOT_SUPPORTED;
                        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "In-app billing API version 3 is not supported on this device.");
                    }
                    BillingClientImpl.zzae(billingClientImpl3, iZzw);
                    if (iZzw != 0) {
                        BillingResult billingResult2 = zzcj.zzb;
                        zzbfVar.zzf(billingResult2, zzieVar2, null, z);
                        zzbfVar.zzg(billingResult2);
                    } else {
                        try {
                            Long lZze = zzbfVar.zze(z);
                            if (z) {
                                zzhz zzhzVarZzc = zzib.zzc();
                                zzhzVarZzc.zzo(6);
                                zzjt zzjtVarZzc = zzjv.zzc();
                                int i4 = zzbfVar.zze;
                                zzjtVarZzc.zza(i4 > 0);
                                zzjtVarZzc.zzl(i4);
                                if (lZze != null) {
                                    zzjtVarZzc.zzm(lZze.longValue());
                                }
                                BillingClientImpl billingClientImpl4 = zzbfVar.zza;
                                zzhzVarZzc.zzn(zzjtVarZzc);
                                billingClientImpl4.zzaQ((zzib) zzhzVarZzc.zze());
                            } else {
                                zzjm zzjmVarZzc = zzjo.zzc();
                                zzic zzicVarZzc = zzig.zzc();
                                zzicVarZzc.zzo(0);
                                zzjmVarZzc.zza(zzicVarZzc);
                                if (lZze != null) {
                                    zzjmVarZzc.zzl(lZze.longValue());
                                }
                                zzbfVar.zza.zzh.zzj((zzjo) zzjmVarZzc.zze());
                            }
                        } catch (Throwable th) {
                            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
                        }
                        zzbfVar.zzg(zzcj.zzi);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ void zzb(zzbf zzbfVar) {
        BillingClientImpl billingClientImpl = zzbfVar.zza;
        billingClientImpl.zzaS(0);
        zzie zzieVar = zzie.EXECUTE_ASYNC_TIMEOUT;
        BillingResult billingResult = zzcj.zzk;
        billingClientImpl.zzaR(zzieVar, billingResult, zzbfVar.zze);
        zzbfVar.zzg(billingResult);
    }

    private final Long zze(boolean z) {
        if (z) {
            com.google.android.gms.internal.play_billing.zzbi zzbiVar = this.zzc;
            if (!zzbiVar.zzg()) {
                return null;
            }
            zzbiVar.zzf();
            return Long.valueOf(zzbiVar.zza(TimeUnit.MILLISECONDS));
        }
        com.google.android.gms.internal.play_billing.zzbi zzbiVar2 = this.zzd;
        if (!zzbiVar2.zzg()) {
            return null;
        }
        zzbiVar2.zzf();
        return Long.valueOf(zzbiVar2.zza(TimeUnit.MILLISECONDS));
    }

    private final void zzf(BillingResult billingResult, zzie zzieVar, String str, boolean z) {
        try {
            zzic zzicVarZzc = zzig.zzc();
            zzicVarZzc.zzo(billingResult.getResponseCode());
            zzicVarZzc.zzl(billingResult.getDebugMessage());
            zzicVarZzc.zzn(zzieVar);
            if (str != null) {
                zzicVarZzc.zza(str);
            }
            Long lZze = zze(z);
            if (!z) {
                zzjm zzjmVarZzc = zzjo.zzc();
                zzjmVarZzc.zza(zzicVarZzc);
                if (lZze != null) {
                    zzjmVarZzc.zzl(lZze.longValue());
                }
                this.zza.zzh.zzj((zzjo) zzjmVarZzc.zze());
                return;
            }
            zzjt zzjtVarZzc = zzjv.zzc();
            int i = this.zze;
            zzjtVarZzc.zza(i > 0);
            zzjtVarZzc.zzl(i);
            if (lZze != null) {
                zzjtVarZzc.zzm(lZze.longValue());
            }
            BillingClientImpl billingClientImpl = this.zza;
            zzhv zzhvVarZzc = zzhx.zzc();
            zzhvVarZzc.zzl(zzicVarZzc);
            zzhvVarZzc.zzp(6);
            zzhvVarZzc.zzo(zzjtVarZzc);
            billingClientImpl.zzaO((zzhx) zzhvVarZzc.zze());
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
    }

    private final void zzg(BillingResult billingResult) {
        BillingClientImpl billingClientImpl = this.zza;
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb == 3) {
                return;
            }
            try {
                this.zzb.onBillingSetupFinished(billingResult);
            } catch (Throwable th) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while calling onBillingSetupFinished.", th);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing service died.");
        try {
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzai(billingClientImpl)) {
                zzch zzchVar = billingClientImpl.zzh;
                zzhv zzhvVarZzc = zzhx.zzc();
                zzhvVarZzc.zzp(6);
                zzic zzicVarZzc = zzig.zzc();
                zzicVarZzc.zzn(zzie.BINDING_DIED);
                zzhvVarZzc.zzl(zzicVarZzc);
                zzjt zzjtVarZzc = zzjv.zzc();
                int i = this.zze;
                zzjtVarZzc.zza(i > 0);
                zzjtVarZzc.zzl(i);
                zzhvVarZzc.zzo(zzjtVarZzc);
                zzchVar.zza((zzhx) zzhvVarZzc.zze());
            } else {
                billingClientImpl.zzh.zzi(zzij.zzd());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
        BillingClientImpl billingClientImpl2 = this.zza;
        synchronized (billingClientImpl2.zza) {
            if (billingClientImpl2.zzb != 3 && billingClientImpl2.zzb != 0) {
                billingClientImpl2.zzaS(0);
                billingClientImpl2.zzaV();
                try {
                    this.zzb.onBillingServiceDisconnected();
                } catch (Throwable th2) {
                    com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
                }
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Billing service connected.");
        BillingClientImpl billingClientImpl = this.zza;
        synchronized (billingClientImpl.zza) {
            if (billingClientImpl.zzb == 3) {
                return;
            }
            billingClientImpl.zzi = com.google.android.gms.internal.play_billing.zzal.zzs(iBinder);
            if (BillingClientImpl.zzG(new Callable() { // from class: com.android.billingclient.api.zzbd
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzbf.zza(this.zza);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzbe
                @Override // java.lang.Runnable
                public final void run() {
                    zzbf.zzb(this.zza);
                }
            }, billingClientImpl.zzan(), billingClientImpl.zzF()) == null) {
                int i = this.zze;
                BillingResult billingResultZzaq = billingClientImpl.zzaq();
                billingClientImpl.zzaR(zzie.MISSING_RESULT_FROM_EXECUTE_ASYNC, billingResultZzaq, i);
                zzg(billingResultZzaq);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "Billing service disconnected.");
        try {
            BillingClientImpl billingClientImpl = this.zza;
            if (BillingClientImpl.zzai(billingClientImpl)) {
                zzch zzchVar = billingClientImpl.zzh;
                zzhv zzhvVarZzc = zzhx.zzc();
                zzhvVarZzc.zzp(6);
                zzic zzicVarZzc = zzig.zzc();
                zzicVarZzc.zzn(zzie.SERVICE_DISCONNECTED);
                zzhvVarZzc.zzl(zzicVarZzc);
                zzjt zzjtVarZzc = zzjv.zzc();
                int i = this.zze;
                zzjtVarZzc.zza(i > 0);
                zzjtVarZzc.zzl(i);
                zzhvVarZzc.zzo(zzjtVarZzc);
                zzchVar.zza((zzhx) zzhvVarZzc.zze());
            } else {
                billingClientImpl.zzh.zzk(zzjs.zzd());
            }
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to log.", th);
        }
        com.google.android.gms.internal.play_billing.zzbi zzbiVar = this.zzd;
        zzbiVar.zzd();
        zzbiVar.zze();
        BillingClientImpl billingClientImpl2 = this.zza;
        synchronized (billingClientImpl2.zza) {
            if (billingClientImpl2.zzb == 3) {
                return;
            }
            billingClientImpl2.zzaS(0);
            try {
                this.zzb.onBillingServiceDisconnected();
            } catch (Throwable th2) {
                com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception while calling onBillingServiceDisconnected.", th2);
            }
        }
    }

    public final void zzc() {
        com.google.android.gms.internal.play_billing.zzbi zzbiVar = this.zzc;
        zzbiVar.zzd();
        zzbiVar.zze();
    }

    final boolean zzd() {
        return this.zze > 0;
    }
}
