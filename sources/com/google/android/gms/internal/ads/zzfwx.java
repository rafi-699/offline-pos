package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfwx extends zzfwt {
    public zzfwx(zzfwm zzfwmVar, HashSet hashSet, JSONObject jSONObject, long j) {
        super(zzfwmVar, hashSet, jSONObject, j);
    }

    private final void zzc(String str) {
        zzfvi zzfviVarZza = zzfvi.zza();
        if (zzfviVarZza != null) {
            for (zzfuo zzfuoVar : zzfviVarZza.zze()) {
                if (this.zza.contains(zzfuoVar.zzh())) {
                    zzfuoVar.zzg().zzi(str, this.zzc);
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return this.zzb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzfwu, android.os.AsyncTask
    protected final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        zzc(str);
        super.onPostExecute(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzfwu
    /* JADX INFO: renamed from: zza */
    public final void onPostExecute(String str) {
        zzc(str);
        super.onPostExecute(str);
    }
}
