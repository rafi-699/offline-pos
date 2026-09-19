package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfrj extends zziee implements zzifq {
    private static final zzfrj zzb;
    private static volatile zzifx zzc;
    private zzieq zza = zzbM();

    static {
        zzfrj zzfrjVar = new zzfrj();
        zzb = zzfrjVar;
        zziee.zzbu(zzfrj.class, zzfrjVar);
    }

    private zzfrj() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzfrh.class});
        }
        if (iOrdinal == 3) {
            return new zzfrj();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfri(bArr);
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
        synchronized (zzfrj.class) {
            zzidzVar = zzc;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzb);
                zzc = zzidzVar;
            }
        }
        return zzidzVar;
    }
}
