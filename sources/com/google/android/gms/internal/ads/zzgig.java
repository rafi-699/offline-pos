package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgig extends zzgix {
    zzgig(zzaxm zzaxmVar, zzght zzghtVar, zzgqh zzgqhVar) {
        super("EX3s5CgykVWHs0pNTwHE120YyOO6kVwj6XxXcnDAUKRtpcEwHZ8iefuHYFjxhN+G", "iYfOB+UFjdSgOmvtOabB6aboS+drDofqdo6l56HlvdE=", zzaxmVar, zzghtVar, zzgqhVar.zza(114));
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        synchronized (zzaxmVar) {
            zzaxmVar.zza(ExifInterface.LONGITUDE_EAST);
            zzaxmVar.zzB(0L);
            zzaxmVar.zzV("D");
        }
        Object[] objArr = (Object[]) method.invoke("", new Object[0]);
        objArr.getClass();
        Object[] objArr2 = objArr;
        synchronized (zzaxmVar) {
            zzaxmVar.zza((String) objArr2[0]);
            zzaxmVar.zzB(((Long) objArr2[1]).longValue());
            zzaxmVar.zzV((String) objArr2[2]);
        }
    }
}
