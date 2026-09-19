package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhnw {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final Map zzd;

    /* synthetic */ zzhnw(zzhnt zzhntVar, byte[] bArr) {
        this.zza = new HashMap(zzhntVar.zze());
        this.zzb = new HashMap(zzhntVar.zzf());
        this.zzc = new HashMap(zzhntVar.zzg());
        this.zzd = new HashMap(zzhntVar.zzh());
    }

    public final boolean zza(zzhns zzhnsVar) {
        return this.zzb.containsKey(new zzhnu(zzhnsVar.getClass(), zzhnsVar.zzf(), null));
    }

    public final zzhdq zzb(zzhns zzhnsVar, @Nullable zzhel zzhelVar) throws GeneralSecurityException {
        zzhnu zzhnuVar = new zzhnu(zzhnsVar.getClass(), zzhnsVar.zzf(), null);
        Map map = this.zzb;
        if (map.containsKey(zzhnuVar)) {
            return ((zzhlr) map.get(zzhnuVar)).zza(zzhnsVar, zzhelVar);
        }
        String string = zzhnuVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 47);
        sb.append("No Key Parser for requested key type ");
        sb.append(string);
        sb.append(" available");
        throw new GeneralSecurityException(sb.toString());
    }

    public final zzhns zzc(zzhdq zzhdqVar, Class cls, @Nullable zzhel zzhelVar) throws GeneralSecurityException {
        zzhnv zzhnvVar = new zzhnv(zzhdqVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzhnvVar)) {
            return ((zzhlu) map.get(zzhnvVar)).zza(zzhdqVar, zzhelVar);
        }
        String string = zzhnvVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 32);
        sb.append("No Key serializer for ");
        sb.append(string);
        sb.append(" available");
        throw new GeneralSecurityException(sb.toString());
    }

    public final boolean zzd(zzhns zzhnsVar) {
        return this.zzd.containsKey(new zzhnu(zzhnsVar.getClass(), zzhnsVar.zzf(), null));
    }

    public final zzheh zze(zzhns zzhnsVar) throws GeneralSecurityException {
        zzhnu zzhnuVar = new zzhnu(zzhnsVar.getClass(), zzhnsVar.zzf(), null);
        Map map = this.zzd;
        if (map.containsKey(zzhnuVar)) {
            return ((zzhmv) map.get(zzhnuVar)).zza(zzhnsVar);
        }
        String string = zzhnuVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 54);
        sb.append("No Parameters Parser for requested key type ");
        sb.append(string);
        sb.append(" available");
        throw new GeneralSecurityException(sb.toString());
    }

    public final zzhns zzf(zzheh zzhehVar, Class cls) throws GeneralSecurityException {
        zzhnv zzhnvVar = new zzhnv(zzhehVar.getClass(), cls, null);
        Map map = this.zzc;
        if (map.containsKey(zzhnvVar)) {
            return ((zzhmy) map.get(zzhnvVar)).zza(zzhehVar);
        }
        String string = zzhnvVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 39);
        sb.append("No Key Format serializer for ");
        sb.append(string);
        sb.append(" available");
        throw new GeneralSecurityException(sb.toString());
    }

    final /* synthetic */ Map zzg() {
        return this.zza;
    }

    final /* synthetic */ Map zzh() {
        return this.zzb;
    }

    final /* synthetic */ Map zzi() {
        return this.zzc;
    }

    final /* synthetic */ Map zzj() {
        return this.zzd;
    }
}
