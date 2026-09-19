package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhhd {

    @Nullable
    private zzhhf zza;

    @Nullable
    private String zzb;

    @Nullable
    private zzhhe zzc;

    @Nullable
    private zzheu zzd;

    private zzhhd() {
        throw null;
    }

    /* synthetic */ zzhhd(byte[] bArr) {
    }

    public final zzhhd zza(zzhhf zzhhfVar) {
        this.zza = zzhhfVar;
        return this;
    }

    public final zzhhd zzb(String str) {
        this.zzb = str;
        return this;
    }

    public final zzhhd zzc(zzhhe zzhheVar) {
        this.zzc = zzhheVar;
        return this;
    }

    public final zzhhd zzd(zzheu zzheuVar) {
        this.zzd = zzheuVar;
        return this;
    }

    public final zzhhg zze() throws GeneralSecurityException {
        if (this.zza == null) {
            this.zza = zzhhf.zzb;
        }
        if (this.zzb == null) {
            throw new GeneralSecurityException("kekUri must be set");
        }
        zzhhe zzhheVar = this.zzc;
        if (zzhheVar == null) {
            throw new GeneralSecurityException("dekParsingStrategy must be set");
        }
        zzheu zzheuVar = this.zzd;
        if (zzheuVar == null) {
            throw new GeneralSecurityException("dekParametersForNewKeys must be set");
        }
        if (zzheuVar.zza()) {
            throw new GeneralSecurityException("dekParametersForNewKeys must not have ID Requirements");
        }
        if ((zzhheVar.equals(zzhhe.zza) && (zzheuVar instanceof zzhfx)) || ((zzhheVar.equals(zzhhe.zzc) && (zzheuVar instanceof zzhgm)) || ((zzhheVar.equals(zzhhe.zzb) && (zzheuVar instanceof zzhii)) || ((zzhheVar.equals(zzhhe.zzd) && (zzheuVar instanceof zzhfg)) || ((zzhheVar.equals(zzhhe.zze) && (zzheuVar instanceof zzhfo)) || (zzhheVar.equals(zzhhe.zzf) && (zzheuVar instanceof zzhgg))))))) {
            return new zzhhg(this.zza, this.zzb, this.zzc, this.zzd, null);
        }
        String string = this.zzc.toString();
        String strValueOf = String.valueOf(this.zzd);
        StringBuilder sb = new StringBuilder(string.length() + 67 + String.valueOf(strValueOf).length() + 1);
        sb.append("Cannot use parsing strategy ");
        sb.append(string);
        sb.append(" when new keys are picked according to ");
        sb.append(strValueOf);
        sb.append(".");
        throw new GeneralSecurityException(sb.toString());
    }
}
