package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.HashSet;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzbk {
    private int zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private boolean zzg;
    private boolean zzh;
    private zzgwm zzi;
    private zzgwm zzj;
    private zzgwm zzk;
    private zzgwm zzl;
    private zzgwm zzm;
    private int zzn;
    private int zzo;
    private zzgwm zzp;
    private zzbj zzq;
    private zzgwm zzr;
    private boolean zzs;
    private zzgwm zzt;
    private HashMap zzu;
    private HashSet zzv;

    public zzbk() {
        this.zza = Integer.MAX_VALUE;
        this.zzb = Integer.MAX_VALUE;
        this.zzc = Integer.MAX_VALUE;
        this.zzd = Integer.MAX_VALUE;
        this.zze = Integer.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = true;
        this.zzh = true;
        this.zzi = zzgwm.zzi();
        this.zzj = zzgwm.zzi();
        this.zzk = zzgwm.zzi();
        this.zzl = zzgwm.zzi();
        this.zzm = zzgwm.zzi();
        this.zzn = Integer.MAX_VALUE;
        this.zzo = Integer.MAX_VALUE;
        this.zzp = zzgwm.zzi();
        this.zzq = zzbj.zza;
        this.zzr = zzgwm.zzi();
        this.zzs = true;
        this.zzt = zzgwm.zzi();
        this.zzu = new HashMap();
        this.zzv = new HashSet();
    }

    @EnsuresNonNull({"preferredVideoMimeTypes", "preferredVideoLanguages", "preferredAudioLanguages", "preferredAudioMimeTypes", "audioOffloadPreferences", "preferredTextLanguages", "overrides", "disabledTrackTypes", "preferredVideoLabels", "preferredAudioLabels", "preferredTextLabels"})
    private final void zzx(zzbl zzblVar) {
        this.zza = zzblVar.zza;
        this.zzb = zzblVar.zzb;
        this.zzc = zzblVar.zzc;
        this.zzd = zzblVar.zzd;
        int i = zzblVar.zze;
        int i2 = zzblVar.zzf;
        int i3 = zzblVar.zzg;
        int i4 = zzblVar.zzh;
        this.zze = zzblVar.zzi;
        this.zzf = zzblVar.zzj;
        this.zzg = zzblVar.zzk;
        this.zzh = zzblVar.zzl;
        this.zzj = zzblVar.zzn;
        this.zzi = zzblVar.zzm;
        this.zzk = zzblVar.zzo;
        int i5 = zzblVar.zzp;
        this.zzl = zzblVar.zzq;
        int i6 = zzblVar.zzs;
        this.zzm = zzblVar.zzr;
        this.zzn = zzblVar.zzt;
        this.zzo = zzblVar.zzu;
        this.zzp = zzblVar.zzv;
        this.zzq = zzblVar.zzw;
        boolean z = zzblVar.zzx;
        this.zzr = zzblVar.zzy;
        int i7 = zzblVar.zzA;
        this.zzs = zzblVar.zzB;
        this.zzt = zzblVar.zzz;
        int i8 = zzblVar.zzC;
        boolean z2 = zzblVar.zzD;
        boolean z3 = zzblVar.zzE;
        boolean z4 = zzblVar.zzF;
        boolean z5 = zzblVar.zzG;
        this.zzv = new HashSet(zzblVar.zzI);
        this.zzu = new HashMap(zzblVar.zzH);
    }

    protected final zzbk zza(zzbl zzblVar) {
        zzx(zzblVar);
        return this;
    }

    final /* synthetic */ int zzb() {
        return this.zza;
    }

    final /* synthetic */ int zzc() {
        return this.zzb;
    }

    final /* synthetic */ int zzd() {
        return this.zzc;
    }

    final /* synthetic */ int zze() {
        return this.zzd;
    }

    final /* synthetic */ int zzf() {
        return this.zze;
    }

    final /* synthetic */ int zzg() {
        return this.zzf;
    }

    final /* synthetic */ boolean zzh() {
        return this.zzg;
    }

    final /* synthetic */ boolean zzi() {
        return this.zzh;
    }

    final /* synthetic */ zzgwm zzj() {
        return this.zzi;
    }

    final /* synthetic */ zzgwm zzk() {
        return this.zzj;
    }

    final /* synthetic */ zzgwm zzl() {
        return this.zzk;
    }

    final /* synthetic */ zzgwm zzm() {
        return this.zzl;
    }

    final /* synthetic */ zzgwm zzn() {
        return this.zzm;
    }

    final /* synthetic */ int zzo() {
        return this.zzn;
    }

    final /* synthetic */ int zzp() {
        return this.zzo;
    }

    final /* synthetic */ zzgwm zzq() {
        return this.zzp;
    }

    final /* synthetic */ zzbj zzr() {
        return this.zzq;
    }

    final /* synthetic */ zzgwm zzs() {
        return this.zzr;
    }

    final /* synthetic */ boolean zzt() {
        return this.zzs;
    }

    final /* synthetic */ zzgwm zzu() {
        return this.zzt;
    }

    final /* synthetic */ HashMap zzv() {
        return this.zzu;
    }

    final /* synthetic */ HashSet zzw() {
        return this.zzv;
    }

    protected zzbk(zzbl zzblVar) {
        zzx(zzblVar);
    }
}
