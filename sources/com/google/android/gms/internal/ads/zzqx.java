package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzqx {
    private final zzv zza;
    private AudioDeviceInfo zzc;
    private zzd zzb = zzd.zza;
    private int zzd = 0;
    private int zze = -1;
    private int zzf = -1;

    public zzqx(zzv zzvVar) {
        this.zza = zzvVar;
    }

    public final zzqx zza(zzd zzdVar) {
        this.zzb = zzdVar;
        return this;
    }

    public final zzqx zzb(AudioDeviceInfo audioDeviceInfo) {
        this.zzc = audioDeviceInfo;
        return this;
    }

    public final zzqx zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzqx zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzqx zze(int i) {
        this.zzf = -1;
        return this;
    }

    final /* synthetic */ zzv zzf() {
        return this.zza;
    }

    final /* synthetic */ zzd zzg() {
        return this.zzb;
    }

    final /* synthetic */ AudioDeviceInfo zzh() {
        return this.zzc;
    }

    final /* synthetic */ int zzi() {
        return this.zzd;
    }

    final /* synthetic */ int zzj() {
        return this.zze;
    }

    final /* synthetic */ int zzk() {
        return this.zzf;
    }
}
