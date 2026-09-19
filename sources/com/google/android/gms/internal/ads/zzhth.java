package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhth extends zziee implements zzifq {
    private static final zzhth zzb;
    private static volatile zzifx zzc;
    private String zza = "";

    static {
        zzhth zzhthVar = new zzhth();
        zzb = zzhthVar;
        zziee.zzbu(zzhth.class, zzhthVar);
    }

    private zzhth() {
    }

    public static zzhth zzb(zzida zzidaVar, zzido zzidoVar) throws zziet {
        return (zzhth) zziee.zzbT(zzb, zzidaVar, zzidoVar);
    }

    public static zzhtg zzc() {
        return (zzhtg) zzb.zzbn();
    }

    public static zzhth zzd() {
        return zzb;
    }

    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhth();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtg(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzc;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzhth.class) {
            zzidzVar = zzc;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzb);
                zzc = zzidzVar;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza = str;
    }
}
