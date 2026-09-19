package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.mp4.Atom;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaia implements zzafy {
    private final zzet zza = new zzet(4);
    private final zzahd zzb = new zzahd(-1, -1, MimeTypes.IMAGE_AVIF);

    private final boolean zzh(zzafz zzafzVar, int i) throws IOException {
        zzet zzetVar = this.zza;
        zzetVar.zza(4);
        ((zzafp) zzafzVar).zzh(zzetVar.zzi(), 0, 4, false);
        return zzetVar.zzz() == ((long) i);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final boolean zza(zzafz zzafzVar) throws IOException {
        ((zzafp) zzafzVar).zzj(4, false);
        return zzh(zzafzVar, Atom.TYPE_ftyp) && zzh(zzafzVar, 1635150182);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzc(zzagb zzagbVar) {
        this.zzb.zzc(zzagbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final int zzd(zzafz zzafzVar, zzagy zzagyVar) throws IOException {
        return this.zzb.zzd(zzafzVar, zzagyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zze(long j, long j2) {
        this.zzb.zze(j, j2);
    }

    @Override // com.google.android.gms.internal.ads.zzafy
    public final void zzf() {
    }
}
