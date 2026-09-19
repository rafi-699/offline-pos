package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzwn implements zzzc {
    public final zzzc zza;
    final /* synthetic */ zzwo zzb;
    private boolean zzc;

    public zzwn(zzwo zzwoVar, zzzc zzzcVar) {
        Objects.requireNonNull(zzwoVar);
        this.zzb = zzwoVar;
        this.zza = zzzcVar;
    }

    public final void zza() {
        this.zzc = false;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final boolean zzb() {
        return !this.zzb.zzo() && this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004e  */
    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zzd(zzlw zzlwVar, zziv zzivVar, int i) {
        zzwo zzwoVar = this.zzb;
        if (zzwoVar.zzo()) {
            return -3;
        }
        if (this.zzc) {
            zzivVar.zzg(4);
            return -4;
        }
        zzzc zzzcVar = this.zza;
        long jZzi = zzwoVar.zzi();
        int iZzd = zzzcVar.zzd(zzlwVar, zzivVar, i);
        if (zzwoVar.zzq() != C.TIME_UNSET && iZzd != -3) {
            zzwoVar.zzr(C.TIME_UNSET);
        }
        if (iZzd != -5) {
            long j = zzwoVar.zzb;
            if (j == Long.MIN_VALUE || ((iZzd != -4 || zzivVar.zze < j) && !(iZzd == -3 && jZzi == Long.MIN_VALUE && !zzivVar.zzd))) {
                return iZzd;
            }
            zzivVar.zza();
            zzivVar.zzg(4);
            this.zzc = true;
            return -4;
        }
        long j2 = zzwoVar.zzb;
        zzv zzvVar = zzlwVar.zzb;
        zzvVar.getClass();
        int i2 = zzvVar.zzK;
        if (i2 != 0) {
            int i3 = j2 == Long.MIN_VALUE ? zzvVar.zzL : 0;
            zzt zztVarZza = zzvVar.zza();
            zztVarZza.zzJ(i2);
            zztVarZza.zzK(i3);
            zzlwVar.zzb = zztVarZza.zzO();
        } else if (zzvVar.zzL != 0) {
            i2 = 0;
            if (j2 == Long.MIN_VALUE) {
            }
            zzt zztVarZza2 = zzvVar.zza();
            zztVarZza2.zzJ(i2);
            zztVarZza2.zzK(i3);
            zzlwVar.zzb = zztVarZza2.zzO();
        }
        return -5;
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final int zze(long j) {
        if (this.zzb.zzo()) {
            return -3;
        }
        return this.zza.zze(j);
    }
}
