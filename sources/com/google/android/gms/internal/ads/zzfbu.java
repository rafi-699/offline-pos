package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfbu implements zzfck {
    private final zzcdz zza;
    private final zzhcg zzb;
    private final Context zzc;

    public zzfbu(zzcdz zzcdzVar, zzhcg zzhcgVar, Context context) {
        this.zza = zzcdzVar;
        this.zzb = zzhcgVar;
        this.zzc = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zzb.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzfbt
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 34;
    }

    final /* synthetic */ zzfbv zzc() {
        zzcdz zzcdzVar = this.zza;
        Context context = this.zzc;
        if (!zzcdzVar.zza(context)) {
            return new zzfbv(null, null, null, null, null);
        }
        String strZzh = zzcdzVar.zzh(context);
        String str = strZzh == null ? "" : strZzh;
        String strZzi = zzcdzVar.zzi(context);
        String str2 = strZzi == null ? "" : strZzi;
        String strZzj = zzcdzVar.zzj(context);
        String str3 = strZzj == null ? "" : strZzj;
        boolean zZza = zzcdzVar.zza(context);
        Long l = null;
        String str4 = true != zZza ? null : "fa";
        if ("TIME_OUT".equals(str2)) {
            l = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzaV);
        }
        return new zzfbv(str, str2, str3, str4 == null ? "" : str4, l);
    }
}
