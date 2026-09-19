package com.google.android.gms.internal.ads;

import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzimm {
    public static zzimm zzb(Class cls) {
        return System.getProperty(SystemProperties.JAVA_VM_NAME).equalsIgnoreCase("Dalvik") ? new zzimh(cls.getSimpleName()) : new zzimj(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
