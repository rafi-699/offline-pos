package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzher implements zzhdn {
    zzher() {
    }

    @Override // com.google.android.gms.internal.ads.zzhdn
    public final Object zza(zzhec zzhecVar, Class cls) throws GeneralSecurityException {
        if (cls == zzhdi.class) {
            return cls.cast(zzhjy.zza(zzhecVar, zzheq.zza));
        }
        throw new GeneralSecurityException("AeadConfigurationV1 can only create AEADs");
    }
}
