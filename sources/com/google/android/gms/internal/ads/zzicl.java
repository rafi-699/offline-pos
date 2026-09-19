package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzicl implements zzifx {
    static {
        int i = zzido.zzb;
        int i2 = zzicn.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzifx
    public final /* synthetic */ Object zza(InputStream inputStream, zzido zzidoVar) throws zziet {
        zzigs zzigsVarZzaU;
        zzide zzideVarZzH = zzide.zzH(inputStream, 4096);
        zzifp zzifpVar = (zzifp) zzb(zzideVarZzH, zzidoVar);
        zzideVarZzH.zzb(0);
        if (zzifpVar == null || zzifpVar.zzbi()) {
            return zzifpVar;
        }
        if (zzifpVar instanceof zzicj) {
            zzigsVarZzaU = ((zzicj) zzifpVar).zzaU();
        } else {
            if (zzifpVar instanceof zzick) {
                throw null;
            }
            zzigsVarZzaU = new zzigs(zzifpVar);
        }
        throw zzigsVarZzaU.zza();
    }
}
