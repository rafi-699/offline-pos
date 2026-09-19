package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfbq implements zzfck {
    public static final /* synthetic */ int zzb = 0;
    private static final zzfbr zzc = new zzfbr(new JSONArray().toString(), new Bundle(), "");
    final String zza;
    private final zzhcg zzd;
    private final ScheduledExecutorService zze;
    private final zzerw zzf;
    private final Context zzg;
    private final zzfky zzh;
    private final zzerr zzi;
    private final zzdxc zzj;
    private final zzeby zzk;

    zzfbq(zzhcg zzhcgVar, ScheduledExecutorService scheduledExecutorService, String str, zzerw zzerwVar, Context context, zzfky zzfkyVar, zzerr zzerrVar, zzdxc zzdxcVar, zzeby zzebyVar) {
        this.zzd = zzhcgVar;
        this.zze = scheduledExecutorService;
        this.zza = str;
        this.zzf = zzerwVar;
        this.zzg = context;
        this.zzh = zzfkyVar;
        this.zzi = zzerrVar;
        this.zzj = zzdxcVar;
        this.zzk = zzebyVar;
    }

    private final void zzf(List list, Map map) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            zzesa zzesaVar = (zzesa) ((Map.Entry) it.next()).getValue();
            String str = zzesaVar.zza;
            list.add(zzh(str, Collections.singletonList(zzesaVar.zze), zzg(str), zzesaVar.zzb, zzesaVar.zzc));
        }
    }

    private final Bundle zzg(String str) {
        Bundle bundle = this.zzh.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzhbo zzh(final String str, final List list, final Bundle bundle, final boolean z, final boolean z2) {
        zzhbd zzhbdVar = new zzhbd() { // from class: com.google.android.gms.internal.ads.zzfbl
            @Override // com.google.android.gms.internal.ads.zzhbd
            public final /* synthetic */ ListenableFuture zza() {
                return this.zza.zzd(str, list, bundle, z, z2);
            }
        };
        zzhcg zzhcgVar = this.zzd;
        zzhbo zzhboVarZzw = zzhbo.zzw(zzhbw.zzf(zzhbdVar, zzhcgVar));
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzck)).booleanValue()) {
            zzhboVarZzw = (zzhbo) zzhbw.zzi(zzhboVarZzw, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcd)).longValue(), TimeUnit.MILLISECONDS, this.zze);
        }
        return (zzhbo) zzhbw.zzg(zzhboVarZzw, Throwable.class, new zzgta() { // from class: com.google.android.gms.internal.ads.zzfbm
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                int i = zzfbq.zzb;
                String str2 = str;
                String.valueOf(str2);
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Error calling adapter: ".concat(String.valueOf(str2)));
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzoA)).booleanValue()) {
                    zzcfd zzcfdVarZzh = com.google.android.gms.ads.internal.zzt.zzh();
                    String.valueOf(str2);
                    zzcfdVarZzh.zzh(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                    return null;
                }
                zzcfd zzcfdVarZzh2 = com.google.android.gms.ads.internal.zzt.zzh();
                String.valueOf(str2);
                zzcfdVarZzh2.zzg(th, "rtbSignal.fetchRtbJsonInfo-".concat(String.valueOf(str2)));
                return null;
            }
        }, zzhcgVar);
    }

    private final void zzi(zzbxb zzbxbVar, Bundle bundle, List list, zzerz zzerzVar) throws RemoteException {
        zzbxbVar.zze(ObjectWrapper.wrap(this.zzg), this.zza, bundle, (Bundle) list.get(0), this.zzh.zzf, zzerzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        zzfky zzfkyVar = this.zzh;
        if (zzfkyVar.zzs) {
            if (!Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcq)).split(",")).contains(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzc(zzfkyVar.zzd)))) {
                return zzhbw.zza(zzc);
            }
        }
        return zzhbw.zzf(new zzhbd() { // from class: com.google.android.gms.internal.ads.zzfbo
            @Override // com.google.android.gms.internal.ads.zzhbd
            public final /* synthetic */ ListenableFuture zza() {
                return this.zza.zzc();
            }
        }, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 32;
    }

    final /* synthetic */ ListenableFuture zzc() {
        final String str;
        zzfbq zzfbqVar;
        String lowerCase = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzmp)).booleanValue() ? this.zzh.zzg.toLowerCase(Locale.ROOT) : this.zzh.zzg;
        final Bundle bundleZzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzco)).booleanValue() ? this.zzk.zzg() : new Bundle();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfd)).booleanValue()) {
            int iZzk = com.google.android.gms.ads.internal.zzt.zzh().zzo().zzi().zzk();
            str = iZzk != 1 ? iZzk != 2 ? "EMPTY" : "INVALID" : "VALID";
        } else {
            str = "";
        }
        final ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = this.zzh.zzw;
        if (jSONArray != null) {
            HashMap map = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("rtb_adapters");
                    String string = (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) ? "" : jSONArrayOptJSONArray.getString(0);
                    if (!TextUtils.isEmpty(string)) {
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data");
                        Bundle bundle = new Bundle();
                        if (jSONObjectOptJSONObject != null) {
                            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                bundle.putString(next, jSONObjectOptJSONObject.optString(next, ""));
                            }
                        }
                        map.put(string, new zzesa(string, true, true, false, bundle));
                    }
                } catch (JSONException e) {
                    com.google.android.gms.ads.internal.zzt.zzh().zzg(new JSONException("Malformed RTB adapter config."), "RecursiveRtbAdapterMap.parseAdapters");
                    com.google.android.gms.ads.internal.util.zze.zzb("Malformed RTB adapter config.", e);
                }
            }
            zzf(arrayList, map);
            zzfbqVar = this;
        } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcx)).booleanValue()) {
            zzfbqVar = this;
            zzf(arrayList, zzfbqVar.zzf.zzd(zzfbqVar.zza, lowerCase));
        } else {
            zzerw zzerwVar = this.zzf;
            for (Map.Entry entry : zzerwVar.zzc(this.zza, lowerCase).entrySet()) {
                String str2 = (String) entry.getKey();
                arrayList.add(zzh(str2, (List) entry.getValue(), zzg(str2), true, true));
            }
            zzfbqVar = this;
            zzf(arrayList, zzerwVar.zzb());
        }
        return zzhbw.zzp(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzfbk
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                int i2 = zzfbq.zzb;
                JSONArray jSONArray2 = new JSONArray();
                for (ListenableFuture listenableFuture : arrayList) {
                    if (((JSONObject) listenableFuture.get()) != null) {
                        jSONArray2.put(listenableFuture.get());
                    }
                }
                String str3 = str;
                Bundle bundle2 = bundleZzg;
                if (jSONArray2.length() != 0) {
                    return new zzfbr(jSONArray2.toString(), bundle2, str3);
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzfd)).booleanValue()) {
                    return new zzfbr(new JSONArray().toString(), bundle2, str3);
                }
                return null;
            }
        }, zzfbqVar.zzd);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    final /* synthetic */ ListenableFuture zzd(String str, final List list, final Bundle bundle, boolean z, boolean z2) throws RemoteException {
        final zzbxb zzbxbVar;
        zzbxb zzbxbVarZzb;
        final zzcfw zzcfwVar = new zzcfw();
        if (z2) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcp)).booleanValue()) {
                try {
                    zzbxbVarZzb = this.zzj.zzb(str);
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Couldn't create RTB adapter : ", e);
                    zzbxbVar = null;
                }
            } else {
                zzerr zzerrVar = this.zzi;
                zzerrVar.zza(str);
                zzbxbVarZzb = zzerrVar.zzb(str);
            }
            zzbxbVar = zzbxbVarZzb;
        } else {
            zzbxbVarZzb = this.zzj.zzb(str);
            zzbxbVar = zzbxbVarZzb;
        }
        if (zzbxbVar == null) {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcf)).booleanValue()) {
                throw null;
            }
            zzerz.zzd(str, zzcfwVar);
            return zzcfwVar;
        }
        final zzerz zzerzVar = new zzerz(str, zzbxbVar, zzcfwVar, com.google.android.gms.ads.internal.zzt.zzk().elapsedRealtime());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzck)).booleanValue()) {
            ScheduledExecutorService scheduledExecutorService = this.zze;
            Objects.requireNonNull(zzerzVar);
            scheduledExecutorService.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbp
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzerzVar.zzc();
                }
            }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcd)).longValue(), TimeUnit.MILLISECONDS);
        }
        if (!z) {
            zzerzVar.zzb();
            return zzcfwVar;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcr)).booleanValue()) {
            this.zzd.submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfbn
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zze(zzbxbVar, bundle, list, zzerzVar, zzcfwVar);
                }
            });
            return zzcfwVar;
        }
        zzi(zzbxbVar, bundle, list, zzerzVar);
        return zzcfwVar;
    }

    final /* synthetic */ void zze(zzbxb zzbxbVar, Bundle bundle, List list, zzerz zzerzVar, zzcfw zzcfwVar) {
        try {
            zzi(zzbxbVar, bundle, list, zzerzVar);
        } catch (RemoteException e) {
            zzcfwVar.zzd(e);
        }
    }
}
