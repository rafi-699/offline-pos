package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhlo {
    private static final Logger zza = Logger.getLogger(zzhlo.class.getName());
    private static final zzhlo zzd = new zzhlo();
    private final ConcurrentMap zzb = new ConcurrentHashMap();
    private final ConcurrentMap zzc = new ConcurrentHashMap();

    public static zzhlo zza() {
        return zzd;
    }

    private final synchronized zzhdr zzg(String str) throws GeneralSecurityException {
        ConcurrentMap concurrentMap;
        concurrentMap = this.zzb;
        if (!concurrentMap.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 98);
            sb.append("No key manager found for key type ");
            sb.append(str);
            sb.append(", see https://developers.google.com/tink/faq/registration_errors");
            throw new GeneralSecurityException(sb.toString());
        }
        return (zzhdr) concurrentMap.get(str);
    }

    private final synchronized void zzh(zzhdr zzhdrVar, boolean z, boolean z2) throws GeneralSecurityException {
        String strZzb = zzhdrVar.zzb();
        if (z2) {
            ConcurrentMap concurrentMap = this.zzc;
            if (concurrentMap.containsKey(strZzb) && !((Boolean) concurrentMap.get(strZzb)).booleanValue()) {
                throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(strZzb));
            }
        }
        ConcurrentMap concurrentMap2 = this.zzb;
        zzhdr zzhdrVar2 = (zzhdr) concurrentMap2.get(strZzb);
        if (zzhdrVar2 != null && !zzhdrVar2.getClass().equals(zzhdrVar.getClass())) {
            zza.logp(Level.WARNING, "com.google.crypto.tink.internal.KeyManagerRegistry", "insertKeyManager", "Attempted overwrite of a registered key manager for key type ".concat(strZzb));
            throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", strZzb, zzhdrVar2.getClass().getName(), zzhdrVar.getClass().getName()));
        }
        concurrentMap2.putIfAbsent(strZzb, zzhdrVar);
        this.zzc.put(strZzb, Boolean.valueOf(z2));
    }

    public final synchronized void zzb(zzhdr zzhdrVar, boolean z) throws GeneralSecurityException {
        zzf(zzhdrVar, 1, z);
    }

    public final zzhdr zzc(String str, Class cls) throws GeneralSecurityException {
        zzhdr zzhdrVarZzg = zzg(str);
        if (zzhdrVarZzg.zzc().equals(cls)) {
            return zzhdrVarZzg;
        }
        String name = cls.getName();
        String strValueOf = String.valueOf(zzhdrVarZzg.getClass());
        String string = zzhdrVarZzg.zzc().toString();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 53 + String.valueOf(strValueOf).length() + 23 + string.length());
        sb.append("Primitive type ");
        sb.append(name);
        sb.append(" not supported by key manager of type ");
        sb.append(strValueOf);
        sb.append(", which only supports: ");
        sb.append(string);
        throw new GeneralSecurityException(sb.toString());
    }

    public final zzhdr zzd(String str) throws GeneralSecurityException {
        return zzg(str);
    }

    public final boolean zze(String str) {
        return ((Boolean) this.zzc.get(str)).booleanValue();
    }

    public final synchronized void zzf(zzhdr zzhdrVar, int i, boolean z) throws GeneralSecurityException {
        if (!zzhkr.zza(i)) {
            throw new GeneralSecurityException("Cannot register key manager: FIPS compatibility insufficient");
        }
        zzh(zzhdrVar, false, z);
    }
}
