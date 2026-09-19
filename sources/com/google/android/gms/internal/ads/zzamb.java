package com.google.android.gms.internal.ads;

import androidx.media3.common.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzamb {
    public final zzami zza;
    public final zzaml zzb;
    public final zzahk zzc;
    public final zzahl zzd;
    public int zze;
    public zzv zzf;

    public zzamb(zzami zzamiVar, zzaml zzamlVar, zzahk zzahkVar) {
        this.zza = zzamiVar;
        this.zzb = zzamlVar;
        this.zzc = zzahkVar;
        this.zzd = MimeTypes.AUDIO_TRUEHD.equals(zzamiVar.zzg.zzp) ? new zzahl() : null;
    }
}
