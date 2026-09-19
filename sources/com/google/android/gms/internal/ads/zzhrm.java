package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhrm extends zziee implements zzifq {
    private static final zzhrm zzc;
    private static volatile zzifx zzd;
    private int zza;
    private int zzb;

    static {
        zzhrm zzhrmVar = new zzhrm();
        zzc = zzhrmVar;
        zziee.zzbu(zzhrm.class, zzhrmVar);
    }

    private zzhrm() {
    }

    public static zzhrm zzc(zzida zzidaVar, zzido zzidoVar) throws zziet {
        return (zzhrm) zziee.zzbT(zzc, zzidaVar, zzidoVar);
    }

    public static zzhrl zzd() {
        return (zzhrl) zzc.zzbn();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zzb", "zza"});
        }
        if (iOrdinal == 3) {
            return new zzhrm();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhrl(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzd;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhrm.class) {
            zzidzVar = zzd;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzc);
                zzd = zzidzVar;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zze(int i) {
        this.zza = i;
    }
}
