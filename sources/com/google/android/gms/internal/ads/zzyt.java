package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzyt implements zzxj {
    private final zzho zza;
    private final zzyc zzb;
    private int zzc;
    private final zzabu zzd;

    public zzyt(zzho zzhoVar, final zzage zzageVar) {
        zzyc zzycVar = new zzyc() { // from class: com.google.android.gms.internal.ads.zzys
            @Override // com.google.android.gms.internal.ads.zzyc
            public final /* synthetic */ zzyd zza(zzqf zzqfVar) {
                return new zzwm(zzageVar);
            }
        };
        zzabu zzabuVar = new zzabu(-1);
        this.zza = zzhoVar;
        this.zzb = zzycVar;
        this.zzd = zzabuVar;
        this.zzc = 1048576;
    }

    public final zzyt zza(int i) {
        this.zzc = i;
        return this;
    }

    public final zzyu zzb(zzak zzakVar) {
        zzag zzagVar = zzakVar.zzb;
        zzagVar.getClass();
        zzho zzhoVar = this.zza;
        zzyc zzycVar = this.zzb;
        zzagVar.getClass();
        return new zzyu(zzakVar, zzhoVar, zzycVar, zzun.zza, this.zzd, this.zzc, false, 0, null, null, null);
    }
}
