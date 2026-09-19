package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgik extends zzgix {
    private final zzgdf zza;

    zzgik(zzaxm zzaxmVar, zzght zzghtVar, zzgdf zzgdfVar, zzgqh zzgqhVar) {
        super("de6gUXOvTKpdGE5e57jp8swLYylxAp36VAePPwAMuyFk31nrvwJ6wnCTxnWSrTp+", "XwiXIeWI3naOC54KqLF8O0lcVu19tfx8ftfv+yyfX8s=", zzaxmVar, zzghtVar, zzgqhVar.zza(116));
        this.zza = zzgdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = (Object[]) method.invoke("", this.zza.zzd());
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaxmVar) {
            zzaxmVar.zzb((String) objArr2[0]);
            zzaxmVar.zzaa((String) objArr2[1]);
        }
    }
}
