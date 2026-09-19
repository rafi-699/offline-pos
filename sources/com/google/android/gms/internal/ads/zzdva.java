package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdva extends zzdul implements zzdky {
    private zzdky zza;

    @Override // com.google.android.gms.internal.ads.zzdky
    public final synchronized void zzdR() {
        zzdky zzdkyVar = this.zza;
        if (zzdkyVar != null) {
            zzdkyVar.zzdR();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdky
    public final synchronized void zzdu() {
        zzdky zzdkyVar = this.zza;
        if (zzdkyVar != null) {
            zzdkyVar.zzdu();
        }
    }

    protected final synchronized void zzn(com.google.android.gms.ads.internal.client.zza zzaVar, zzbog zzbogVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzboi zzboiVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, zzdky zzdkyVar) throws Throwable {
        try {
            try {
                super.zzm(zzaVar, zzbogVar, zzrVar, zzboiVar, zzadVar);
                this.zza = zzdkyVar;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }
}
