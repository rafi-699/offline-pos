package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgia extends zzgix {
    private final Activity zza;
    private final View zzb;

    zzgia(zzaxm zzaxmVar, zzght zzghtVar, View view, Activity activity, zzgqh zzgqhVar) {
        super("kICru+RlF37DZcClNNNafekAyIWCS20ItrldPwSS9IbAVJbkDXFc3qpTOJ54cMxf", "nLYdoqqtMnuDPwVM1aO+ZLMTTK034noiKo5dDDQLXK0=", zzaxmVar, zzghtVar, zzgqhVar.zza(111));
        this.zzb = view;
        this.zza = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        Object[] objArr = (Object[]) method.invoke("", this.zzb, this.zza);
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaxmVar) {
            zzaxmVar.zzS(((Long) objArr2[0]).longValue());
            zzaxmVar.zzT(((Long) objArr2[1]).longValue());
            zzaxmVar.zzU((String) objArr2[2]);
        }
    }
}
