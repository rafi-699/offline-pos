package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfpt extends zziee implements zzifq {
    private static final zzfpt zzg;
    private static volatile zzifx zzh;
    private long zza;
    private zziem zzb = zzbC();
    private zzieq zzc = zzbM();
    private zzieq zzd = zzbM();
    private zzieq zze = zzbM();
    private zzieq zzf = zzbM();

    static {
        zzfpt zzfptVar = new zzfpt();
        zzg = zzfptVar;
        zziee.zzbu(zzfpt.class, zzfptVar);
    }

    private zzfpt() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzg, "\u0004\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0005\u0000\u0001\u0002\u0002,\u0003Ț\u0004Ț\u0005Ț\u0006Ț", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzfpt();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfps(bArr);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzh;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzfpt.class) {
            zzidzVar = zzh;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzg);
                zzh = zzidzVar;
            }
        }
        return zzidzVar;
    }
}
