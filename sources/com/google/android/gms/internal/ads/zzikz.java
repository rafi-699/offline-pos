package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzikz extends zziee implements zzifq {
    private static final zzikz zzd;
    private static volatile zzifx zze;
    private int zza;
    private String zzb = "";
    private zziem zzc = zzbC();

    static {
        zzikz zzikzVar = new zzikz();
        zzd = zzikzVar;
        zziee.zzbu(zzikz.class, zzikzVar);
    }

    private zzikz() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u0016", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzikz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziky(bArr);
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
        synchronized (zzikz.class) {
            zzidzVar = zze;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzd);
                zze = zzidzVar;
            }
        }
        return zzidzVar;
    }
}
