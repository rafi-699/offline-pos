package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbcl implements Callable {
    private final zzbbs zza;
    private final zzaxm zzb;

    public zzbcl(zzbbs zzbbsVar, zzaxm zzaxmVar) {
        this.zza = zzbbsVar;
        this.zzb = zzaxmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbbs zzbbsVar = this.zza;
        if (zzbbsVar.zzm() != null) {
            zzbbsVar.zzm().get();
        }
        zzaym zzaymVarZzl = zzbbsVar.zzl();
        if (zzaymVarZzl == null) {
            return null;
        }
        try {
            zzaxm zzaxmVar = this.zzb;
            synchronized (zzaxmVar) {
                try {
                    zzaxmVar.zzaY(zzaymVarZzl.zzaN(), zzido.zza());
                } catch (Throwable th) {
                    throw th;
                }
            }
            return null;
        } catch (zziet | NullPointerException unused) {
            return null;
        }
    }
}
