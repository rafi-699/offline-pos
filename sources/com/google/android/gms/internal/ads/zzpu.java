package com.google.android.gms.internal.ads;

import android.util.Base64;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzpu implements zzqd {
    public static final zzgub zza = zzps.zza;
    private static final Random zzb = new Random();
    private final zzbe zzc;
    private final zzbd zzd;
    private final HashMap zze;
    private zzqc zzf;
    private zzbf zzg;
    private String zzh;
    private long zzi;

    public zzpu() {
        throw null;
    }

    public zzpu(zzgub zzgubVar) {
        this.zzc = new zzbe();
        this.zzd = new zzbd();
        this.zze = new HashMap();
        this.zzg = zzbf.zza;
        this.zzi = -1L;
    }

    @RequiresNonNull({ServiceSpecificExtraArgs.CastExtraArgs.LISTENER})
    private final void zzl(zznn zznnVar) {
        if (zznnVar.zzb.zzg()) {
            String str = this.zzh;
            if (str != null) {
                zzpt zzptVar = (zzpt) this.zze.get(str);
                zzptVar.getClass();
                zzm(zzptVar);
                return;
            }
            return;
        }
        zzpt zzptVar2 = (zzpt) this.zze.get(this.zzh);
        int i = zznnVar.zzc;
        zzxk zzxkVar = zznnVar.zzd;
        this.zzh = zzo(i, zzxkVar).zze();
        zzc(zznnVar);
        if (zzxkVar == null || !zzxkVar.zzb()) {
            return;
        }
        if (zzptVar2 != null) {
            if (zzptVar2.zzg() == zzxkVar.zzd && zzptVar2.zzh() != null) {
                zzxk zzxkVarZzh = zzptVar2.zzh();
                if (zzxkVarZzh.zzb == zzxkVar.zzb) {
                    zzxk zzxkVarZzh2 = zzptVar2.zzh();
                    if (zzxkVarZzh2.zzc == zzxkVar.zzc) {
                        return;
                    }
                }
            }
        }
        zzo(i, new zzxk(zzxkVar.zza, zzxkVar.zzd));
    }

    private final void zzm(zzpt zzptVar) {
        if (zzptVar.zzg() != -1 && zzptVar.zzi()) {
            this.zzi = zzptVar.zzg();
        }
        this.zzh = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final long zzi() {
        zzpt zzptVar = (zzpt) this.zze.get(this.zzh);
        return (zzptVar == null || zzptVar.zzg() == -1) ? this.zzi + 1 : zzptVar.zzg();
    }

    private final zzpt zzo(int i, zzxk zzxkVar) {
        HashMap map = this.zze;
        long j = Long.MAX_VALUE;
        zzpt zzptVar = null;
        for (zzpt zzptVar2 : map.values()) {
            zzptVar2.zzc(i, zzxkVar);
            if (zzptVar2.zzb(i, zzxkVar)) {
                long jZzg = zzptVar2.zzg();
                if (jZzg == -1 || jZzg < j) {
                    zzptVar = zzptVar2;
                    j = jZzg;
                } else if (jZzg == j) {
                    String str = zzfl.zza;
                    if (zzptVar.zzh() != null && zzptVar2.zzh() != null) {
                        zzptVar = zzptVar2;
                    }
                }
            }
        }
        if (zzptVar != null) {
            return zzptVar;
        }
        String strZzp = zzp();
        zzpt zzptVar3 = new zzpt(this, strZzp, i, zzxkVar);
        map.put(strZzp, zzptVar3);
        return zzptVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzp() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final void zza(zzqc zzqcVar) {
        this.zzf = zzqcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized String zzb(zzbf zzbfVar, zzxk zzxkVar) {
        return zzo(zzbfVar.zzo(zzxkVar.zza, this.zzd).zzc, zzxkVar).zze();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x003f A[Catch: all -> 0x00b3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001b, B:14:0x0023, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0049, B:25:0x0052, B:27:0x0058, B:29:0x006d, B:30:0x0086, B:32:0x008c, B:33:0x008f, B:35:0x009b, B:37:0x00a1, B:43:0x00b2), top: B:47:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0049 A[Catch: all -> 0x00b3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001b, B:14:0x0023, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0049, B:25:0x0052, B:27:0x0058, B:29:0x006d, B:30:0x0086, B:32:0x008c, B:33:0x008f, B:35:0x009b, B:37:0x00a1, B:43:0x00b2), top: B:47:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x006d A[Catch: all -> 0x00b3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001b, B:14:0x0023, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0049, B:25:0x0052, B:27:0x0058, B:29:0x006d, B:30:0x0086, B:32:0x008c, B:33:0x008f, B:35:0x009b, B:37:0x00a1, B:43:0x00b2), top: B:47:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x008c A[Catch: all -> 0x00b3, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:8:0x000f, B:10:0x0013, B:12:0x001b, B:14:0x0023, B:16:0x002f, B:18:0x0037, B:20:0x003f, B:22:0x0049, B:25:0x0052, B:27:0x0058, B:29:0x006d, B:30:0x0086, B:32:0x008c, B:33:0x008f, B:35:0x009b, B:37:0x00a1, B:43:0x00b2), top: B:47:0x0001 }] */
    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized void zzc(zznn zznnVar) {
        int i;
        zzpt zzptVarZzo;
        Object obj;
        int i2;
        zzpt zzptVarZzo2;
        zzpt zzptVar;
        if (this.zzf == null) {
            throw null;
        }
        zzbf zzbfVar = zznnVar.zzb;
        if (!zzbfVar.zzg()) {
            zzxk zzxkVar = zznnVar.zzd;
            if (zzxkVar != null) {
                long j = zzxkVar.zzd;
                if ((j == -1 || j >= zzi()) && ((zzptVar = (zzpt) this.zze.get(this.zzh)) == null || zzptVar.zzg() != -1 || zzptVar.zzf() == zznnVar.zzc)) {
                    i = zznnVar.zzc;
                    zzptVarZzo = zzo(i, zzxkVar);
                    if (this.zzh == null) {
                        this.zzh = zzptVarZzo.zze();
                    }
                    if (zzxkVar != null && zzxkVar.zzb()) {
                        obj = zzxkVar.zza;
                        long j2 = zzxkVar.zzd;
                        i2 = zzxkVar.zzb;
                        zzptVarZzo2 = zzo(i, new zzxk(obj, j2, i2));
                        if (!zzptVarZzo2.zzi()) {
                            zzptVarZzo2.zzj(true);
                            zzbd zzbdVar = this.zzd;
                            zzbfVar.zzo(obj, zzbdVar);
                            zzbdVar.zzc(i2);
                            Math.max(0L, zzfl.zzr(0L) + zzfl.zzr(0L));
                        }
                    }
                    if (!zzptVarZzo.zzi()) {
                        zzptVarZzo.zzj(true);
                    }
                    if (zzptVarZzo.zze().equals(this.zzh) && !zzptVarZzo.zzk()) {
                        zzptVarZzo.zzl(true);
                        this.zzf.zzc(zznnVar, zzptVarZzo.zze());
                    }
                }
            } else {
                i = zznnVar.zzc;
                zzptVarZzo = zzo(i, zzxkVar);
                if (this.zzh == null) {
                    this.zzh = zzptVarZzo.zze();
                }
                if (zzxkVar != null) {
                    obj = zzxkVar.zza;
                    long j3 = zzxkVar.zzd;
                    i2 = zzxkVar.zzb;
                    zzptVarZzo2 = zzo(i, new zzxk(obj, j3, i2));
                    if (!zzptVarZzo2.zzi()) {
                        zzptVarZzo2.zzj(true);
                        zzbd zzbdVar2 = this.zzd;
                        zzbfVar.zzo(obj, zzbdVar2);
                        zzbdVar2.zzc(i2);
                        Math.max(0L, zzfl.zzr(0L) + zzfl.zzr(0L));
                    }
                }
                if (!zzptVarZzo.zzi()) {
                    zzptVarZzo.zzj(true);
                }
                if (zzptVarZzo.zze().equals(this.zzh)) {
                    zzptVarZzo.zzl(true);
                    this.zzf.zzc(zznnVar, zzptVarZzo.zze());
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized void zzd(zznn zznnVar) {
        if (this.zzf == null) {
            throw null;
        }
        zzbf zzbfVar = this.zzg;
        this.zzg = zznnVar.zzb;
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzpt zzptVar = (zzpt) it.next();
            if (!zzptVar.zza(zzbfVar, this.zzg) || zzptVar.zzd(zznnVar)) {
                it.remove();
                if (zzptVar.zze().equals(this.zzh)) {
                    zzm(zzptVar);
                }
                if (zzptVar.zzi()) {
                    this.zzf.zzd(zznnVar, zzptVar.zze(), false);
                }
            }
        }
        zzl(zznnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized void zze(zznn zznnVar, int i) {
        if (this.zzf == null) {
            throw null;
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzpt zzptVar = (zzpt) it.next();
            if (zzptVar.zzd(zznnVar)) {
                it.remove();
                boolean zEquals = zzptVar.zze().equals(this.zzh);
                if (zEquals) {
                    zzm(zzptVar);
                }
                if (zzptVar.zzi()) {
                    boolean z = false;
                    if (i == 0 && zEquals && zzptVar.zzk()) {
                        z = true;
                    }
                    this.zzf.zzd(zznnVar, zzptVar.zze(), z);
                }
            }
        }
        zzl(zznnVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized String zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzqd
    public final synchronized void zzg(zznn zznnVar) {
        zzqc zzqcVar;
        String str = this.zzh;
        if (str != null) {
            zzpt zzptVar = (zzpt) this.zze.get(str);
            if (zzptVar == null) {
                throw null;
            }
            zzm(zzptVar);
        }
        Iterator it = this.zze.values().iterator();
        while (it.hasNext()) {
            zzpt zzptVar2 = (zzpt) it.next();
            it.remove();
            if (zzptVar2.zzi() && (zzqcVar = this.zzf) != null) {
                zzqcVar.zzd(zznnVar, zzptVar2.zze(), false);
            }
        }
    }

    final /* synthetic */ zzbe zzj() {
        return this.zzc;
    }

    final /* synthetic */ zzbd zzk() {
        return this.zzd;
    }
}
