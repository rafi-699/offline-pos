package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgav extends zzidy implements zzifq {
    private zzgav() {
        throw null;
    }

    /* synthetic */ zzgav(byte[] bArr) {
        super(zzgax.zzb);
    }

    public final zzgav zza(String str) {
        str.getClass();
        zzbg();
        ((zzgax) this.zza).zze().remove(str);
        return this;
    }

    public final Map zzb() {
        return Collections.unmodifiableMap(((zzgax) this.zza).zzb());
    }

    public final zzgav zzc(String str, zzgat zzgatVar) {
        str.getClass();
        zzgatVar.getClass();
        zzbg();
        ((zzgax) this.zza).zze().put(str, zzgatVar);
        return this;
    }
}
