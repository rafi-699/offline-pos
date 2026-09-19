package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbuu implements zzhbe {
    private final String zza = "google.afma.activeView.handleUpdate";
    private final ListenableFuture zzb;

    zzbuu(ListenableFuture listenableFuture, String str, zzbub zzbubVar, zzbua zzbuaVar) {
        this.zzb = listenableFuture;
    }

    @Override // com.google.android.gms.internal.ads.zzhbe
    public final ListenableFuture zza(Object obj) throws Exception {
        return zzb(obj);
    }

    public final ListenableFuture zzb(final Object obj) {
        return zzhbw.zzj(this.zzb, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzbut
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj2) {
                return this.zza.zzc(obj, (zzbtv) obj2);
            }
        }, zzcfr.zzh);
    }

    final /* synthetic */ ListenableFuture zzc(Object obj, zzbtv zzbtvVar) throws JSONException {
        zzcfw zzcfwVar = new zzcfw();
        com.google.android.gms.ads.internal.zzt.zzc();
        String string = UUID.randomUUID().toString();
        zzbpp.zzo.zzb(string, new zzbus(this, zzcfwVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", string);
        jSONObject.put("args", (JSONObject) obj);
        zzbtvVar.zzb(this.zza, jSONObject);
        return zzcfwVar;
    }
}
