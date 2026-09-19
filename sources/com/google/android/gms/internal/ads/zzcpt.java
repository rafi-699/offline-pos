package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcpt implements zzehi {
    private final zzcox zza;
    private Context zzb;

    /* synthetic */ zzcpt(zzcox zzcoxVar, byte[] bArr) {
        this.zza = zzcoxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final zzehj zza() {
        zzinc.zzc(this.zzb, Context.class);
        return new zzcpu(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzehi
    public final /* bridge */ /* synthetic */ zzehi zzb(Context context) {
        this.zzb = context;
        return this;
    }
}
