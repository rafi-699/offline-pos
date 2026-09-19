package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbul implements zzbqg {
    final /* synthetic */ zzbum zza;
    private final zzbto zzb;
    private final zzcfw zzc;

    public zzbul(zzbum zzbumVar, zzbto zzbtoVar, zzcfw zzcfwVar) {
        Objects.requireNonNull(zzbumVar);
        this.zza = zzbumVar;
        this.zzb = zzbtoVar;
        this.zzc = zzcfwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zza(JSONObject jSONObject) {
        try {
            try {
                this.zzc.zzc(this.zza.zzd().zza(jSONObject));
            } catch (IllegalStateException unused) {
            } catch (JSONException e) {
                this.zzc.zzd(e);
            }
        } finally {
            this.zzb.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zzb(String str) {
        try {
            if (str == null) {
                this.zzc.zzd(new zzbtx());
            } else {
                this.zzc.zzd(new zzbtx(str));
            }
        } catch (IllegalStateException unused) {
        } finally {
            this.zzb.zza();
        }
    }
}
