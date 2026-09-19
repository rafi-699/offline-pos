package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdyb implements zzdfx, zzdef, zzdcu, zzddl, com.google.android.gms.ads.internal.client.zza, zzdii {
    private final zzbhp zza;
    private boolean zzb = false;

    public zzdyb(zzbhp zzbhpVar, @Nullable zzfia zzfiaVar) {
        this.zza = zzbhpVar;
        zzbhpVar.zzc(2);
        if (zzfiaVar != null) {
            zzbhpVar.zzc(1101);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final synchronized void onAdClicked() {
        if (this.zzb) {
            this.zza.zzc(8);
        } else {
            this.zza.zzc(7);
            this.zzb = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        switch (zzeVar.zza) {
            case 1:
                this.zza.zzc(101);
                break;
            case 2:
                this.zza.zzc(102);
                break;
            case 3:
                this.zza.zzc(5);
                break;
            case 4:
                this.zza.zzc(103);
                break;
            case 5:
                this.zza.zzc(104);
                break;
            case 6:
                this.zza.zzc(105);
                break;
            case 7:
                this.zza.zzc(106);
                break;
            default:
                this.zza.zzc(4);
                break;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(final zzfkq zzfkqVar) {
        this.zza.zzb(new zzbho() { // from class: com.google.android.gms.internal.ads.zzdya
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar) {
                zzbhv.zza.zzb zzbVarZzcc = zzaVar.zzY().zzcc();
                zzbhv.zzi.zza zzaVarZzcc = zzaVar.zzY().zzp().zzcc();
                zzaVarZzcc.zzd(zzfkqVar.zzb.zzb.zzb);
                zzbVarZzcc.zzr(zzaVarZzcc);
                zzaVar.zzaa(zzbVarZzcc);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final synchronized void zzdr() {
        this.zza.zzc(6);
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        this.zza.zzc(3);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzj(final zzbhv.zzb zzbVar) {
        zzbho zzbhoVar = new zzbho() { // from class: com.google.android.gms.internal.ads.zzdxx
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar) {
                zzaVar.zzar(zzbVar);
            }
        };
        zzbhp zzbhpVar = this.zza;
        zzbhpVar.zzb(zzbhoVar);
        zzbhpVar.zzc(1103);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzk(final zzbhv.zzb zzbVar) {
        zzbho zzbhoVar = new zzbho() { // from class: com.google.android.gms.internal.ads.zzdxy
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar) {
                zzaVar.zzar(zzbVar);
            }
        };
        zzbhp zzbhpVar = this.zza;
        zzbhpVar.zzb(zzbhoVar);
        zzbhpVar.zzc(1102);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzl(final zzbhv.zzb zzbVar) {
        zzbho zzbhoVar = new zzbho() { // from class: com.google.android.gms.internal.ads.zzdxz
            @Override // com.google.android.gms.internal.ads.zzbho
            public final /* synthetic */ void zza(zzbhv.zzt.zza zzaVar) {
                zzaVar.zzar(zzbVar);
            }
        };
        zzbhp zzbhpVar = this.zza;
        zzbhpVar.zzb(zzbhoVar);
        zzbhpVar.zzc(1104);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzm(boolean z) {
        this.zza.zzc(true != z ? 1106 : 1105);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzn(boolean z) {
        this.zza.zzc(true != z ? 1108 : 1107);
    }

    @Override // com.google.android.gms.internal.ads.zzdii
    public final void zzo() {
        this.zza.zzc(1109);
    }
}
