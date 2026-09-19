package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzmx extends zzwy {
    private final zzbe zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzmx(zzmy zzmyVar, zzbf zzbfVar) {
        super(zzbfVar);
        Objects.requireNonNull(zzmyVar);
        this.zzc = new zzbe();
    }

    @Override // com.google.android.gms.internal.ads.zzwy, com.google.android.gms.internal.ads.zzbf
    public final zzbd zzd(int i, zzbd zzbdVar, boolean z) {
        zzbf zzbfVar = this.zzb;
        zzbd zzbdVarZzd = zzbfVar.zzd(i, zzbdVar, z);
        if (!zzbfVar.zzb(zzbdVarZzd.zzc, this.zzc, 0L).zzb()) {
            zzbdVarZzd.zzf = true;
            return zzbdVarZzd;
        }
        Object obj = zzbdVar.zza;
        Object obj2 = zzbdVar.zzb;
        int i2 = zzbdVar.zzc;
        long j = zzbdVar.zzd;
        long j2 = zzbdVar.zze;
        zzbdVarZzd.zza(obj, obj2, i2, j, 0L, zzc.zza, true);
        return zzbdVarZzd;
    }
}
