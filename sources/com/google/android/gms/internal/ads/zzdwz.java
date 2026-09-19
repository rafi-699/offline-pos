package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdwz {
    private final Map zza = new HashMap();

    zzdwz() {
    }

    final synchronized void zza(String str, @Nullable zzflw zzflwVar) {
        zzbxq zzbxqVarZzB;
        if (this.zza.containsKey(str)) {
            return;
        }
        zzbxq zzbxqVarZzC = null;
        if (zzflwVar == null) {
            zzbxqVarZzB = null;
        } else {
            try {
                zzbxqVarZzB = zzflwVar.zzB();
            } catch (zzflf unused) {
                zzbxqVarZzB = null;
            }
        }
        if (zzflwVar != null) {
            try {
                zzbxqVarZzC = zzflwVar.zzC();
            } catch (zzflf unused2) {
            }
        }
        boolean z = true;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzkL)).booleanValue()) {
            if (zzflwVar == null) {
                z = false;
            } else {
                try {
                    zzflwVar.zzn();
                } catch (zzflf unused3) {
                    z = false;
                }
            }
        }
        this.zza.put(str, new zzdwy(str, zzbxqVarZzB, zzbxqVarZzC, z));
    }

    final synchronized void zzb(String str, zzbxb zzbxbVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdwy(str, zzbxbVar.zzf(), zzbxbVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }

    @Nullable
    public final synchronized zzdwy zzc(String str) {
        return (zzdwy) this.zza.get(str);
    }

    public final String zzd(String str) {
        zzbxq zzbxqVar;
        zzdwy zzdwyVarZzc = zzc(str);
        return (zzdwyVarZzc == null || (zzbxqVar = zzdwyVarZzc.zzb) == null) ? "" : zzbxqVar.toString();
    }
}
