package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzabh {
    private zzabg zza;
    private zzabq zzb;

    public void zzb() {
        this.zza = null;
        this.zzb = null;
    }

    public boolean zzd() {
        throw null;
    }

    public void zze(zzd zzdVar) {
        throw null;
    }

    public zznb zzg() {
        throw null;
    }

    public abstract void zzq(Object obj);

    public abstract zzabi zzr(zznc[] zzncVarArr, zzzn zzznVar, zzxk zzxkVar, zzbf zzbfVar) throws zzjk;

    public final void zzs(zzabg zzabgVar, zzabq zzabqVar) {
        zzgtj.zzi(this.zza == null);
        this.zza = zzabgVar;
        this.zzb = zzabqVar;
    }

    protected final void zzt() {
        zzabg zzabgVar = this.zza;
        if (zzabgVar != null) {
            zzabgVar.zzq();
        }
    }

    protected final zzabq zzu() {
        zzabq zzabqVar = this.zzb;
        zzabqVar.getClass();
        return zzabqVar;
    }
}
