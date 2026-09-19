package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzays extends zziee implements zzifq {
    private static final zzays zzf;
    private static volatile zzifx zzg;
    private int zza;
    private zzida zzb;
    private zzida zzc;
    private zzida zzd;
    private zzida zze;

    static {
        zzays zzaysVar = new zzays();
        zzf = zzaysVar;
        zziee.zzbu(zzays.class, zzaysVar);
    }

    private zzays() {
        zzida zzidaVar = zzida.zza;
        this.zzb = zzidaVar;
        this.zzc = zzidaVar;
        this.zzd = zzidaVar;
        this.zze = zzidaVar;
    }

    public static zzays zze(byte[] bArr, zzido zzidoVar) throws zziet {
        return (zzays) zziee.zzbV(zzf, bArr, zzidoVar);
    }

    public static zzayr zzg() {
        return (zzayr) zzf.zzbn();
    }

    public final zzida zza() {
        return this.zzb;
    }

    public final zzida zzb() {
        return this.zzc;
    }

    public final zzida zzc() {
        return this.zzd;
    }

    public final zzida zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzays();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzayr(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzg;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzays.class) {
            zzidzVar = zzg;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzf);
                zzg = zzidzVar;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zzh(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zza |= 1;
        this.zzb = zzidaVar;
    }

    final /* synthetic */ void zzi(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zza |= 2;
        this.zzc = zzidaVar;
    }

    final /* synthetic */ void zzj(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zza |= 4;
        this.zzd = zzidaVar;
    }

    final /* synthetic */ void zzk(zzida zzidaVar) {
        zzidaVar.getClass();
        this.zza |= 8;
        this.zze = zzidaVar;
    }
}
