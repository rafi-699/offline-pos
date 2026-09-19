package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhef {
    private static final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public static zzhee zza(String str) throws GeneralSecurityException {
        for (zzhee zzheeVar : zza) {
            if (zzheeVar.zza()) {
                return zzheeVar;
            }
        }
        String.valueOf(str);
        throw new GeneralSecurityException("No KMS client does support: ".concat(String.valueOf(str)));
    }
}
