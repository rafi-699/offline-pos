package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbcx extends zzbdf {
    private final StackTraceElement[] zzh;

    public zzbcx(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzbbsVar, "X/GUPFxOS4avlKtq36LXcZb7PXup/zZuW1HHrjvnbrOdArq87fiVHm1/XdqEH3+6", "yUIicuApz/OaGeh0f0RdAIADq1zJ0l0UU+b4jbryt0s=", zzaxmVar, i, 45);
        this.zzh = stackTraceElementArr;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        StackTraceElement[] stackTraceElementArr = this.zzh;
        if (stackTraceElementArr != null) {
            zzbbj zzbbjVar = new zzbbj((String) this.zze.invoke(null, stackTraceElementArr));
            zzaxm zzaxmVar = this.zzd;
            synchronized (zzaxmVar) {
                zzaxmVar.zzC(zzbbjVar.zza.longValue());
                if (zzbbjVar.zzb.booleanValue()) {
                    zzaxmVar.zzag(true != zzbbjVar.zzc.booleanValue() ? 2 : 1);
                } else {
                    zzaxmVar.zzag(3);
                }
            }
        }
    }
}
