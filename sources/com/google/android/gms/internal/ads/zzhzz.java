package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.SystemProperties;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhzz {
    public static final zzhzz zza = new zzhzz(new zziaa());
    public static final zzhzz zzb = new zzhzz(new zziae());
    public static final zzhzz zzc = new zzhzz(new zziag());
    public static final zzhzz zzd = new zzhzz(new zziaf());
    public static final zzhzz zze;
    public static final zzhzz zzf;
    private final zzhzy zzg;

    static {
        new zzhzz(new zziab());
        zze = new zzhzz(new zziad());
        zzf = new zzhzz(new zziac());
    }

    public zzhzz(zziah zziahVar) {
        this.zzg = !zzhks.zza() ? "The Android Project".equals(System.getProperty(SystemProperties.JAVA_VENDOR)) ? new zzhzv(zziahVar, null) : new zzhzw(zziahVar, null) : new zzhzx(zziahVar, null);
    }

    public static List zza(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            }
        }
        return arrayList;
    }

    public final Object zzb(String str) throws GeneralSecurityException {
        return this.zzg.zza(str);
    }
}
