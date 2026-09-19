package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhnj {
    private final Map zza;
    private final Map zzb;

    /* synthetic */ zzhnj(zzhng zzhngVar, byte[] bArr) {
        this.zza = new HashMap(zzhngVar.zzc());
        this.zzb = new HashMap(zzhngVar.zzd());
    }

    private final Object zzf(zzhdq zzhdqVar, Class cls) throws GeneralSecurityException {
        zzhnh zzhnhVar = new zzhnh(zzhdqVar.getClass(), cls, null);
        Map map = this.zza;
        if (map.containsKey(zzhnhVar)) {
            return ((zzhnf) map.get(zzhnhVar)).zza(zzhdqVar);
        }
        String string = zzhnhVar.toString();
        StringBuilder sb = new StringBuilder(string.length() + 102);
        sb.append("No PrimitiveConstructor for ");
        sb.append(string);
        sb.append(" available, see https://developers.google.com/tink/faq/registration_errors");
        throw new GeneralSecurityException(sb.toString());
    }

    public final Object zza(zzhdq zzhdqVar, Class cls) throws GeneralSecurityException {
        return zzf(zzhdqVar, cls);
    }

    public final Object zzb(zzhec zzhecVar, Class cls) throws GeneralSecurityException {
        Map map = this.zzb;
        if (!map.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
        }
        final zzhnl zzhnlVar = (zzhnl) map.get(cls);
        return zzhnlVar.zzd(zzhecVar, new zzhnk() { // from class: com.google.android.gms.internal.ads.zzhni
            @Override // com.google.android.gms.internal.ads.zzhnk
            public final /* synthetic */ Object zza(zzhdz zzhdzVar) {
                return this.zza.zze(zzhnlVar, zzhdzVar);
            }
        });
    }

    final /* synthetic */ Map zzc() {
        return this.zza;
    }

    final /* synthetic */ Map zzd() {
        return this.zzb;
    }

    final /* synthetic */ Object zze(zzhnl zzhnlVar, zzhdz zzhdzVar) {
        return zzf(zzhdzVar.zza(), zzhnlVar.zzb());
    }
}
