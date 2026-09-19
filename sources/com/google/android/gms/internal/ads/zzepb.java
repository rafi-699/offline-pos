package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MobileAds;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzepb implements zzhbt {
    final /* synthetic */ long zza;
    final /* synthetic */ zzfki zzb;
    final /* synthetic */ zzfkf zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfry zze;
    final /* synthetic */ zzfkq zzf;
    final /* synthetic */ zzepd zzg;

    zzepb(zzepd zzepdVar, long j, zzfki zzfkiVar, zzfkf zzfkfVar, String str, zzfry zzfryVar, zzfkq zzfkqVar) {
        this.zza = j;
        this.zzb = zzfkiVar;
        this.zzc = zzfkfVar;
        this.zzd = str;
        this.zze = zzfryVar;
        this.zzf = zzfkqVar;
        Objects.requireNonNull(zzepdVar);
        this.zzg = zzepdVar;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006a A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x0076 A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0091 A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00ac A[Catch: all -> 0x00ef, DONT_GENERATE, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ae A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00c9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:47:0x00cb A[Catch: all -> 0x00ef, TryCatch #0 {, blocks: (B:31:0x0064, B:33:0x006a, B:35:0x0076, B:36:0x0079, B:37:0x007f, B:39:0x0091, B:40:0x00a6, B:42:0x00ac, B:44:0x00ae, B:52:0x00e6, B:53:0x00ed, B:47:0x00cb, B:49:0x00cf, B:51:0x00d9), top: B:59:0x0064 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        int i;
        int i2;
        com.google.android.gms.ads.internal.client.zze zzeVarZzb;
        Integer numValueOf;
        com.google.android.gms.ads.internal.client.zze zzeVarZza;
        int i3;
        com.google.android.gms.ads.internal.client.zze zzeVar;
        zzepd zzepdVar = this.zzg;
        long jElapsedRealtime = zzepdVar.zzj().elapsedRealtime() - this.zza;
        if (!(th instanceof TimeoutException)) {
            if (th instanceof zzeol) {
                i = 3;
            } else if (th instanceof CancellationException) {
                i2 = 4;
            } else {
                if (!(th instanceof zzflf)) {
                    if (th instanceof zzeed) {
                        i2 = zzfma.zza(th).zza == 3 ? 1 : 6;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcn)).booleanValue() && (th instanceof zzelw) && (zzeVarZzb = ((zzelw) th).zzb()) != null) {
                            numValueOf = Integer.valueOf(zzeVarZzb.zza);
                            i = i2;
                        }
                    } else {
                        i = 6;
                    }
                    synchronized (zzepdVar) {
                        if (zzepdVar.zzn()) {
                            zzepdVar.zzk().zza(this.zzb, this.zzc, i, th instanceof zzelw ? (zzelw) th : null, jElapsedRealtime);
                            jElapsedRealtime = jElapsedRealtime;
                        }
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjE)).booleanValue()) {
                            zzfsc zzfscVarZzl = zzepdVar.zzl();
                            zzfry zzfryVar = this.zze;
                            zzfkq zzfkqVar = this.zzf;
                            zzfkf zzfkfVar = this.zzc;
                            zzfscVarZzl.zza(zzfryVar.zza(zzfkqVar, zzfkfVar, zzfkfVar.zzn), zzfkfVar.zzax);
                        }
                        if (zzepdVar.zzp()) {
                            return;
                        }
                        LinkedHashMap linkedHashMapZzm = zzepdVar.zzm();
                        zzfkf zzfkfVar2 = this.zzc;
                        linkedHashMapZzm.put(zzfkfVar2, new zzepc(this.zzd, zzfkfVar2.zzaf, i, jElapsedRealtime, numValueOf));
                        zzeVarZza = zzfma.zza(th);
                        i3 = zzeVarZza.zza;
                        if ((i3 != 3 || i3 == 0) && (zzeVar = zzeVarZza.zzd) != null && !zzeVar.zzc.equals(MobileAds.ERROR_DOMAIN)) {
                        }
                        zzepdVar.zzo().zze(zzfkfVar2, jElapsedRealtime, zzeVarZza);
                    }
                }
                i2 = 5;
            }
            numValueOf = null;
            synchronized (zzepdVar) {
                if (zzepdVar.zzn()) {
                    zzepdVar.zzk().zza(this.zzb, this.zzc, i, th instanceof zzelw ? (zzelw) th : null, jElapsedRealtime);
                    jElapsedRealtime = jElapsedRealtime;
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjE)).booleanValue()) {
                    zzfsc zzfscVarZzl2 = zzepdVar.zzl();
                    zzfry zzfryVar2 = this.zze;
                    zzfkq zzfkqVar2 = this.zzf;
                    zzfkf zzfkfVar3 = this.zzc;
                    zzfscVarZzl2.zza(zzfryVar2.zza(zzfkqVar2, zzfkfVar3, zzfkfVar3.zzn), zzfkfVar3.zzax);
                }
                if (zzepdVar.zzp()) {
                    return;
                }
                LinkedHashMap linkedHashMapZzm2 = zzepdVar.zzm();
                zzfkf zzfkfVar4 = this.zzc;
                linkedHashMapZzm2.put(zzfkfVar4, new zzepc(this.zzd, zzfkfVar4.zzaf, i, jElapsedRealtime, numValueOf));
                zzeVarZza = zzfma.zza(th);
                i3 = zzeVarZza.zza;
                zzeVarZza = i3 != 3 ? zzfma.zza(new zzelw(13, zzeVarZza.zzd)) : zzfma.zza(new zzelw(13, zzeVarZza.zzd));
                zzepdVar.zzo().zze(zzfkfVar4, jElapsedRealtime, zzeVarZza);
            }
        }
        i2 = 2;
        i = i2;
        numValueOf = null;
        synchronized (zzepdVar) {
            if (zzepdVar.zzn()) {
                zzepdVar.zzk().zza(this.zzb, this.zzc, i, th instanceof zzelw ? (zzelw) th : null, jElapsedRealtime);
                jElapsedRealtime = jElapsedRealtime;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzjE)).booleanValue()) {
                zzfsc zzfscVarZzl3 = zzepdVar.zzl();
                zzfry zzfryVar3 = this.zze;
                zzfkq zzfkqVar3 = this.zzf;
                zzfkf zzfkfVar5 = this.zzc;
                zzfscVarZzl3.zza(zzfryVar3.zza(zzfkqVar3, zzfkfVar5, zzfkfVar5.zzn), zzfkfVar5.zzax);
            }
            if (zzepdVar.zzp()) {
                return;
            }
            LinkedHashMap linkedHashMapZzm3 = zzepdVar.zzm();
            zzfkf zzfkfVar6 = this.zzc;
            linkedHashMapZzm3.put(zzfkfVar6, new zzepc(this.zzd, zzfkfVar6.zzaf, i, jElapsedRealtime, numValueOf));
            zzeVarZza = zzfma.zza(th);
            i3 = zzeVarZza.zza;
            if (i3 != 3) {
            }
            zzepdVar.zzo().zze(zzfkfVar6, jElapsedRealtime, zzeVarZza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zzb(Object obj) {
        long j;
        zzepd zzepdVar = this.zzg;
        long jElapsedRealtime = zzepdVar.zzj().elapsedRealtime() - this.zza;
        synchronized (zzepdVar) {
            if (zzepdVar.zzn()) {
                j = jElapsedRealtime;
                zzepdVar.zzk().zza(this.zzb, this.zzc, 0, null, j);
            } else {
                j = jElapsedRealtime;
            }
            if (zzepdVar.zzp()) {
                return;
            }
            zzfkf zzfkfVar = this.zzc;
            if (zzepdVar.zzi(zzfkfVar)) {
                ((zzepc) zzepdVar.zzm().get(zzfkfVar)).zzd = j;
            } else {
                long j2 = j;
                j = j2;
                zzepdVar.zzm().put(zzfkfVar, new zzepc(this.zzd, zzfkfVar.zzaf, 0, j2, null));
            }
            zzepdVar.zzo().zzd(zzfkfVar, j, null);
        }
    }
}
