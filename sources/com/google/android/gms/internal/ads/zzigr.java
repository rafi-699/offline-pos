package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzigr extends zziee implements zzifq {
    private static final zzigr zzc;
    private static volatile zzifx zzd;
    private long zza;
    private int zzb;

    static {
        zzigr zzigrVar = new zzigr();
        zzc = zzigrVar;
        zziee.zzbu(zzigr.class, zzigrVar);
    }

    private zzigr() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzigr();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzigq(bArr);
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
        synchronized (zzigr.class) {
            zzidzVar = zzd;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzc);
                zzd = zzidzVar;
            }
        }
        return zzidzVar;
    }
}
