package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.preload.PreloadCallback;
import com.google.android.gms.ads.preload.PreloadConfiguration;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbko;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbrx;
import com.google.android.gms.internal.ads.zzbry;
import com.google.android.gms.internal.ads.zzbuy;
import com.google.android.gms.internal.ads.zzgua;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzeu {
    public static final Set zza = new HashSet(Arrays.asList(AdFormat.APP_OPEN_AD, AdFormat.INTERSTITIAL, AdFormat.REWARDED));
    private static zzeu zze;
    private zzem zzb;
    private zzey zzc;
    private zzel zzd;
    private zzcy zzl;
    private final Object zzf = new Object();
    private final Object zzg = new Object();
    private boolean zzi = false;
    private boolean zzj = false;
    private final Object zzk = new Object();
    private OnAdInspectorClosedListener zzm = null;
    private RequestConfiguration zzn = new RequestConfiguration.Builder().build();
    private final ArrayList zzh = new ArrayList();

    private zzeu() {
    }

    public static InitializationStatus zzB(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzbrp zzbrpVar = (zzbrp) it.next();
            map.put(zzbrpVar.zza, new zzbrx(zzbrpVar.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, zzbrpVar.zzd, zzbrpVar.zzc));
        }
        return new zzbry(map);
    }

    private final void zzC(RequestConfiguration requestConfiguration) {
        zzcy zzcyVar = this.zzl;
        if (zzcyVar == null) {
            return;
        }
        try {
            zzcyVar.zzr(new zzfr(requestConfiguration));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set request configuration parcel.", e);
        }
    }

    private final void zzD(Context context) {
        if (this.zzl == null) {
            this.zzl = (zzcy) new zzat(zzay.zzb(), context).zzd(context, false);
        }
    }

    private final void zzE(String str) {
        zzcy zzcyVar = this.zzl;
        if (zzcyVar == null) {
            return;
        }
        try {
            zzcyVar.zze();
            this.zzl.zzj(null, ObjectWrapper.wrap(null));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzj("MobileAdsSettingManager initialization failed", e);
        }
    }

    public static zzeu zzb() {
        zzeu zzeuVar;
        synchronized (zzeu.class) {
            if (zze == null) {
                zze = new zzeu();
            }
            zzeuVar = zze;
        }
        return zzeuVar;
    }

    final /* synthetic */ OnAdInspectorClosedListener zzA() {
        return this.zzm;
    }

    public final com.google.android.gms.ads.preload.zzb zza(AdFormat adFormat) {
        AdFormat adFormat2 = AdFormat.BANNER;
        int iOrdinal = adFormat.ordinal();
        if (iOrdinal == 1) {
            return this.zzb;
        }
        if (iOrdinal == 2) {
            return this.zzc;
        }
        if (iOrdinal != 5) {
            return null;
        }
        return this.zzd;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x009c A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:24:0x0030, B:26:0x0037, B:27:0x0049, B:29:0x0052, B:37:0x0069, B:39:0x007a, B:41:0x008c, B:48:0x00cf, B:49:0x00e4, B:42:0x009c, B:44:0x00aa, B:46:0x00bc, B:47:0x00c7, B:31:0x005a, B:36:0x0064), top: B:58:0x0030, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:24:0x0030, B:26:0x0037, B:27:0x0049, B:29:0x0052, B:37:0x0069, B:39:0x007a, B:41:0x008c, B:48:0x00cf, B:49:0x00e4, B:42:0x009c, B:44:0x00aa, B:46:0x00bc, B:47:0x00c7, B:31:0x005a, B:36:0x0064), top: B:58:0x0030, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00bc A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:24:0x0030, B:26:0x0037, B:27:0x0049, B:29:0x0052, B:37:0x0069, B:39:0x007a, B:41:0x008c, B:48:0x00cf, B:49:0x00e4, B:42:0x009c, B:44:0x00aa, B:46:0x00bc, B:47:0x00c7, B:31:0x005a, B:36:0x0064), top: B:58:0x0030, inners: #2 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x00c7 A[Catch: all -> 0x0060, TryCatch #0 {, blocks: (B:24:0x0030, B:26:0x0037, B:27:0x0049, B:29:0x0052, B:37:0x0069, B:39:0x007a, B:41:0x008c, B:48:0x00cf, B:49:0x00e4, B:42:0x009c, B:44:0x00aa, B:46:0x00bc, B:47:0x00c7, B:31:0x005a, B:36:0x0064), top: B:58:0x0030, inners: #2 }] */
    public final void zzc(Context context, String str, OnInitializationCompleteListener onInitializationCompleteListener) {
        synchronized (this.zzf) {
            if (this.zzi) {
                if (onInitializationCompleteListener != null) {
                    this.zzh.add(onInitializationCompleteListener);
                }
                return;
            }
            if (this.zzj) {
                if (onInitializationCompleteListener != null) {
                    onInitializationCompleteListener.onInitializationComplete(zzl());
                }
                return;
            }
            this.zzi = true;
            if (onInitializationCompleteListener != null) {
                this.zzh.add(onInitializationCompleteListener);
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            synchronized (this.zzk) {
                byte[] bArr = null;
                byte b = 0;
                byte b2 = 0;
                try {
                    zzD(context);
                    zzcy zzcyVar = this.zzl;
                    if (zzcyVar != null) {
                        zzcyVar.zzp(new zzet(this, bArr));
                        this.zzl.zzo(new zzbuy());
                    }
                    if (this.zzn.getTagForChildDirectedTreatment() != -1 || this.zzn.getTagForUnderAgeOfConsent() != -1) {
                        zzC(this.zzn);
                    }
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("MobileAdsSettingManager initialization failed", e);
                }
                zzbiq.zza(context);
                if (((Boolean) zzbko.zza.zze()).booleanValue()) {
                    if (((Boolean) zzba.zzc().zzd(zzbiq.zzmC)).booleanValue()) {
                        com.google.android.gms.ads.internal.util.client.zzo.zzd("Initializing on bg thread");
                        ThreadPoolExecutor threadPoolExecutor = com.google.android.gms.ads.internal.util.client.zzb.zza;
                        final byte b3 = b2 == true ? 1 : 0;
                        threadPoolExecutor.execute(new Runnable(b3) { // from class: com.google.android.gms.ads.internal.client.zzer
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzt(null);
                            }
                        });
                    } else if (((Boolean) zzbko.zzb.zze()).booleanValue()) {
                        if (((Boolean) zzba.zzc().zzd(zzbiq.zzmC)).booleanValue()) {
                            ExecutorService executorService = com.google.android.gms.ads.internal.util.client.zzb.zzb;
                            final byte b4 = b == true ? 1 : 0;
                            executorService.execute(new Runnable(b4) { // from class: com.google.android.gms.ads.internal.client.zzep
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    this.zza.zzu(null);
                                }
                            });
                        } else {
                            com.google.android.gms.ads.internal.util.client.zzo.zzd("Initializing on calling thread");
                            zzE(null);
                        }
                    } else {
                        com.google.android.gms.ads.internal.util.client.zzo.zzd("Initializing on calling thread");
                        zzE(null);
                    }
                } else if (((Boolean) zzbko.zzb.zze()).booleanValue()) {
                    if (((Boolean) zzba.zzc().zzd(zzbiq.zzmC)).booleanValue()) {
                        ExecutorService executorService2 = com.google.android.gms.ads.internal.util.client.zzb.zzb;
                        final String b5 = b == true ? 1 : 0;
                        executorService2.execute(new Runnable(b5) { // from class: com.google.android.gms.ads.internal.client.zzep
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.zza.zzu(null);
                            }
                        });
                    } else {
                        com.google.android.gms.ads.internal.util.client.zzo.zzd("Initializing on calling thread");
                        zzE(null);
                    }
                } else {
                    com.google.android.gms.ads.internal.util.client.zzo.zzd("Initializing on calling thread");
                    zzE(null);
                }
                this.zzb = new zzem(context);
                this.zzc = new zzey(context);
                this.zzd = new zzel(context);
            }
        }
    }

    public final void zzd() {
        synchronized (this.zzf) {
            this.zzj = false;
            this.zzi = false;
            this.zzh.clear();
        }
        synchronized (this.zzk) {
            try {
                zzcy zzcyVar = this.zzl;
                if (zzcyVar != null) {
                    zzcyVar.zzw();
                }
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to stop the SDK.", e);
            }
            this.zzl = null;
            zzem zzemVar = this.zzb;
            if (zzemVar != null) {
                zzemVar.zzg();
                this.zzb = null;
            }
            zzey zzeyVar = this.zzc;
            if (zzeyVar != null) {
                zzeyVar.zzg();
                this.zzc = null;
            }
            zzel zzelVar = this.zzd;
            if (zzelVar != null) {
                zzelVar.zzg();
                this.zzd = null;
            }
        }
    }

    public final Status zze(Context context, List list, PreloadCallback preloadCallback) {
        boolean z;
        Status status;
        zzbiq.zza(context);
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            PreloadConfiguration preloadConfiguration = (PreloadConfiguration) it.next();
            String strValueOf = String.valueOf(preloadConfiguration.getAdFormat());
            String adUnitId = preloadConfiguration.getAdUnitId();
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 1 + String.valueOf(adUnitId).length());
            sb.append(strValueOf);
            sb.append("#");
            sb.append(adUnitId);
            String string = sb.toString();
            map.put(string, Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzd(map, string, 0)).intValue() + 1));
        }
        Iterator it2 = map.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                z = false;
                break;
            }
            if (((Integer) ((Map.Entry) it2.next()).getValue()).intValue() > 1) {
                hashSet.add("Preload configurations include duplicated ad unit IDs and ad format combinations");
                z = true;
                break;
            }
        }
        HashMap map2 = new HashMap();
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            PreloadConfiguration preloadConfiguration2 = (PreloadConfiguration) it3.next();
            AdFormat adFormat = preloadConfiguration2.getAdFormat();
            if (zza.contains(preloadConfiguration2.getAdFormat())) {
                map2.put(adFormat, Integer.valueOf(((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzd(map2, adFormat, 0)).intValue() + 1));
                if (preloadConfiguration2.getBufferSize() > 15) {
                    hashSet.add(String.format(Locale.US, "Preload configurations' buffer size exceeds the maximum limit %d for %s", 15, adFormat.name()));
                } else if (preloadConfiguration2.getBufferSize() < 0) {
                    hashSet.add(String.format(Locale.US, "Preload configurations' buffer size less than 0 for %s", adFormat.name()));
                }
            } else {
                String strValueOf2 = String.valueOf(preloadConfiguration2.getAdFormat());
                String.valueOf(strValueOf2);
                hashSet.add("PreloadConfiguration ad format is not supported:".concat(String.valueOf(strValueOf2)));
            }
            z = true;
        }
        EnumMap enumMap = new EnumMap(AdFormat.class);
        enumMap.put(AdFormat.APP_OPEN_AD, (Integer) zzba.zzc().zzd(zzbiq.zzfv));
        enumMap.put(AdFormat.INTERSTITIAL, (Integer) zzba.zzc().zzd(zzbiq.zzft));
        enumMap.put(AdFormat.REWARDED, (Integer) zzba.zzc().zzd(zzbiq.zzfu));
        for (Map.Entry entry : map2.entrySet()) {
            AdFormat adFormat2 = (AdFormat) entry.getKey();
            int iIntValue = ((Integer) entry.getValue()).intValue();
            int iIntValue2 = ((Integer) com.google.android.gms.ads.internal.util.client.zzf.zzd(enumMap, adFormat2, 0)).intValue();
            if (iIntValue > iIntValue2) {
                hashSet.add(String.format(Locale.US, "Preload configurations' size exceeds the maximum limit %d for %s", Integer.valueOf(iIntValue2), adFormat2.name()));
                z = true;
            }
        }
        if (z) {
            StringBuilder sb2 = new StringBuilder();
            Iterator it4 = hashSet.iterator();
            while (it4.hasNext()) {
                sb2.append((String) it4.next());
                if (it4.hasNext()) {
                    sb2.append(", ");
                }
            }
            String string2 = sb2.toString();
            com.google.android.gms.ads.internal.util.client.zzo.zzf(string2);
            status = new Status(13, string2);
        } else {
            status = Status.RESULT_SUCCESS;
        }
        String statusMessage = status.getStatusMessage();
        if (statusMessage == null) {
            statusMessage = "";
        }
        Preconditions.checkArgument(status.isSuccess(), statusMessage);
        synchronized (this.zzg) {
            ArrayList arrayList = new ArrayList();
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                arrayList.add(com.google.android.gms.ads.internal.util.client.zzf.zzv(context, (PreloadConfiguration) it5.next(), 1));
            }
            try {
                com.google.android.gms.ads.zzb.zza(context).zze(arrayList, new zzen(this, preloadCallback));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to start preload.", e);
                return Status.RESULT_INTERNAL_ERROR;
            }
        }
        return Status.RESULT_SUCCESS;
    }

    public final void zzf(float f) {
        boolean z = true;
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.zzk) {
            if (this.zzl == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return;
            }
            try {
                zzcyVar.zzf(f);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set app volume.", e);
            }
        }
    }

    public final void zzh(boolean z) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return;
            }
            try {
                zzcyVar.zzh(z);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set app mute state.", e);
            }
        }
    }

    public final void zzj(Context context, String str) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return;
            }
            try {
                zzcyVar.zzi(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to open debug menu.", e);
            }
        }
    }

    public final InitializationStatus zzl() {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzeq
                    @Override // com.google.android.gms.ads.initialization.InitializationStatus
                    public final /* synthetic */ Map getAdapterStatusMap() {
                        HashMap map = new HashMap();
                        map.put("com.google.android.gms.ads.MobileAds", new zzeo(this.zza));
                        return map;
                    }
                };
            }
            try {
                return zzB(zzcyVar.zzq());
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to get Initialization status.");
                return new InitializationStatus() { // from class: com.google.android.gms.ads.internal.client.zzeq
                    @Override // com.google.android.gms.ads.initialization.InitializationStatus
                    public final /* synthetic */ Map getAdapterStatusMap() {
                        HashMap map = new HashMap();
                        map.put("com.google.android.gms.ads.MobileAds", new zzeo(this.zza));
                        return map;
                    }
                };
            }
        }
    }

    public final void zzm(Context context) {
        synchronized (this.zzk) {
            zzD(context);
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return;
            }
            try {
                zzcyVar.zzs();
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to disable mediation adapter initialization.");
            }
        }
    }

    public final void zzn(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        synchronized (this.zzk) {
            zzD(context);
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return;
            }
            this.zzm = onAdInspectorClosedListener;
            try {
                zzcyVar.zzt(new zzes(null));
            } catch (RemoteException unused) {
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Unable to open the ad inspector.");
                if (onAdInspectorClosedListener != null) {
                    onAdInspectorClosedListener.onAdInspectorClosed(new AdInspectorError(0, "Ad inspector had an internal error.", MobileAds.ERROR_DOMAIN));
                }
            }
        }
    }

    public final String zzo() {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to getting version string.");
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return "";
            }
            try {
                return zzgua.zza(zzcyVar.zzm());
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to get internal version.", e);
                return "";
            }
        }
    }

    public final RequestConfiguration zzp() {
        return this.zzn;
    }

    public final void zzq(RequestConfiguration requestConfiguration) {
        Preconditions.checkArgument(requestConfiguration != null, "Null passed to setRequestConfiguration.");
        synchronized (this.zzk) {
            RequestConfiguration requestConfiguration2 = this.zzn;
            this.zzn = requestConfiguration;
            if (this.zzl == null) {
                return;
            }
            if (requestConfiguration2.getTagForChildDirectedTreatment() != requestConfiguration.getTagForChildDirectedTreatment() || requestConfiguration2.getTagForUnderAgeOfConsent() != requestConfiguration.getTagForUnderAgeOfConsent()) {
                zzC(requestConfiguration);
            }
        }
    }

    public final boolean zzr(boolean z) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to enable/disable the publisher first-party ID.");
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return false;
            }
            try {
                zzcyVar.zzu(z);
                return true;
            } catch (RemoteException e) {
                String str = z ? "enable" : "disable";
                StringBuilder sb = new StringBuilder(str.length() + 40);
                sb.append("Unable to ");
                sb.append(str);
                sb.append(" the publisher first-party ID.");
                com.google.android.gms.ads.internal.util.client.zzo.zzg(sb.toString(), e);
                return false;
            }
        }
    }

    public final void zzs(String str) {
        synchronized (this.zzk) {
            Preconditions.checkState(this.zzl != null, "MobileAds.initialize() must be called prior to setting the plugin.");
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return;
            }
            try {
                zzcyVar.zzv(str);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to set plugin.", e);
            }
        }
    }

    final /* synthetic */ void zzt(String str) {
        synchronized (this.zzk) {
            zzE(null);
        }
    }

    final /* synthetic */ void zzu(String str) {
        synchronized (this.zzk) {
            zzE(null);
        }
    }

    final /* synthetic */ Object zzw() {
        return this.zzf;
    }

    final /* synthetic */ ArrayList zzx() {
        return this.zzh;
    }

    final /* synthetic */ void zzy(boolean z) {
        this.zzi = false;
    }

    final /* synthetic */ void zzz(boolean z) {
        this.zzj = true;
    }

    public final float zzg() {
        synchronized (this.zzk) {
            zzcy zzcyVar = this.zzl;
            float fZzk = 1.0f;
            if (zzcyVar == null) {
                return 1.0f;
            }
            try {
                fZzk = zzcyVar.zzk();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to get app volume.", e);
            }
            return fZzk;
        }
    }

    public final boolean zzi() {
        synchronized (this.zzk) {
            zzcy zzcyVar = this.zzl;
            boolean zZzl = false;
            if (zzcyVar == null) {
                return false;
            }
            try {
                zZzl = zzcyVar.zzl();
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to get app mute state.", e);
            }
            return zZzl;
        }
    }

    public final void zzk(Class cls) {
        synchronized (this.zzk) {
            zzcy zzcyVar = this.zzl;
            if (zzcyVar == null) {
                return;
            }
            try {
                zzcyVar.zzn(cls.getCanonicalName());
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unable to register RtbAdapter", e);
            }
        }
    }
}
