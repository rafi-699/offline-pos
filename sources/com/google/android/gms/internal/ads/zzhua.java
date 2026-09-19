package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhua extends zziee implements zzifq {
    private static final zzhua zzd;
    private static volatile zzifx zze;
    private int zza;
    private int zzb;
    private int zzc;

    static {
        zzhua zzhuaVar = new zzhua();
        zzd = zzhuaVar;
        zziee.zzbu(zzhua.class, zzhuaVar);
    }

    private zzhua() {
    }

    public static zzhtz zzd() {
        return (zzhtz) zzd.zzbn();
    }

    public static zzhua zze() {
        return zzd;
    }

    public final zzhsh zza() {
        zzhsh zzhshVarZzb = zzhsh.zzb(this.zza);
        return zzhshVarZzb == null ? zzhsh.UNRECOGNIZED : zzhshVarZzb;
    }

    public final zzhsh zzb() {
        zzhsh zzhshVarZzb = zzhsh.zzb(this.zzb);
        return zzhshVarZzb == null ? zzhsh.UNRECOGNIZED : zzhshVarZzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\u0004", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhua();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtz(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zze;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhua.class) {
            zzidzVar = zze;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzd);
                zze = zzidzVar;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zzg(zzhsh zzhshVar) {
        this.zza = zzhshVar.zza();
    }

    final /* synthetic */ void zzh(zzhsh zzhshVar) {
        this.zzb = zzhshVar.zza();
    }

    final /* synthetic */ void zzi(int i) {
        this.zzc = i;
    }
}
