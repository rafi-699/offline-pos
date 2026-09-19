package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzezz implements zzfck {
    private final zzhcg zza;
    private final zzecr zzb;

    zzezz(zzhcg zzhcgVar, zzecr zzecrVar) {
        this.zza = zzhcgVar;
        this.zzb = zzecrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzezy
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 23;
    }

    final /* synthetic */ zzfaa zzc() {
        zzecr zzecrVar = this.zzb;
        return new zzfaa(zzecrVar.zzg(), zzecrVar.zzd(), com.google.android.gms.ads.internal.zzt.zzo().zzk(), zzecrVar.zzq(), zzecrVar.zzm());
    }
}
