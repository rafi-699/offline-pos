package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzwm implements zzyd {
    private final zzage zza;
    private zzafy zzb;
    private zzafz zzc;

    public zzwm(zzage zzageVar) {
        this.zza = zzageVar;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x007c  */
    @Override // com.google.android.gms.internal.ads.zzyd
    public final void zza(zzj zzjVar, Uri uri, Map map, long j, long j2, zzagb zzagbVar) throws IOException {
        zzafp zzafpVar = new zzafp(zzjVar, j, j2);
        this.zzc = zzafpVar;
        if (this.zzb != null) {
            return;
        }
        zzafy[] zzafyVarArrZzb = this.zza.zzb(uri, map);
        int length = zzafyVarArrZzb.length;
        zzgwj zzgwjVarZzv = zzgwm.zzv(length);
        if (length == 1) {
            this.zzb = zzafyVarArrZzb[0];
        } else {
            for (int i = 0; i < length; i++) {
                zzafy zzafyVar = zzafyVarArrZzb[i];
                try {
                    if (zzafyVar.zza(zzafpVar)) {
                        this.zzb = zzafyVar;
                        zzgtj.zzi(zzafyVar != null || zzafpVar.zzn() == j);
                        zzafpVar.zzl();
                        break;
                    } else {
                        zzgwjVarZzv.zzh(zzafyVar.zzb());
                        boolean z = this.zzb != null || zzafpVar.zzn() == j;
                        zzgtj.zzi(z);
                        zzafpVar.zzl();
                    }
                } catch (EOFException unused) {
                    if (this.zzb != null || zzafpVar.zzn() == j) {
                    }
                } catch (Throwable th) {
                    zzgtj.zzi(this.zzb != null || zzafpVar.zzn() == j);
                    zzafpVar.zzl();
                    throw th;
                }
                zzgtj.zzi(z);
                zzafpVar.zzl();
            }
            if (this.zzb == null) {
                String strZzd = zzgtd.zzd(zzgxm.zzc(zzgwm.zzr(zzafyVarArrZzb), zzwl.zza), ", ");
                StringBuilder sb = new StringBuilder(strZzd.length() + 58);
                sb.append("None of the available extractors (");
                sb.append(strZzd);
                sb.append(") could read the stream.");
                throw new zzzo(sb.toString(), uri, zzgwjVarZzv.zzi());
            }
        }
        this.zzb.zzc(zzagbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final void zzb() {
        zzafy zzafyVar = this.zzb;
        if (zzafyVar != null) {
            zzafyVar.zzf();
            this.zzb = null;
        }
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final void zzc() {
        zzafy zzafyVar = this.zzb;
        if (zzafyVar != null && (zzafyVar instanceof zzakp)) {
            ((zzakp) zzafyVar).zzh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final long zzd() {
        zzafz zzafzVar = this.zzc;
        if (zzafzVar != null) {
            return zzafzVar.zzn();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final void zze(long j, long j2) {
        zzafy zzafyVar = this.zzb;
        zzafyVar.getClass();
        zzafyVar.zze(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzyd
    public final int zzf(zzagy zzagyVar) throws IOException {
        zzafz zzafzVar;
        zzafy zzafyVar = this.zzb;
        if (zzafyVar == null || (zzafzVar = this.zzc) == null) {
            throw null;
        }
        return zzafyVar.zzd(zzafzVar, zzagyVar);
    }
}
