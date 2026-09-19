package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzilu extends zziee implements zzifq {
    private static final zzilu zzf;
    private static volatile zzifx zzg;
    private int zza;
    private int zzb;
    private int zzc;
    private int zzd;
    private zzieq zze = zzbM();

    static {
        zzilu zziluVar = new zzilu();
        zzf = zziluVar;
        zziee.zzbu(zzilu.class, zziluVar);
    }

    private zzilu() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004\u001a", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzilu();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzilt(bArr);
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
        synchronized (zzilu.class) {
            zzidzVar = zzg;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzf);
                zzg = zzidzVar;
            }
        }
        return zzidzVar;
    }
}
