package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfrp extends zziee implements zzifq {
    private static final zzfrp zzf;
    private static volatile zzifx zzg;
    private long zza;
    private long zzb;
    private zzieq zzc = zzbM();
    private zzieq zzd = zzbM();
    private zzieq zze = zzbM();

    static {
        zzfrp zzfrpVar = new zzfrp();
        zzf = zzfrpVar;
        zziee.zzbu(zzfrp.class, zzfrpVar);
    }

    private zzfrp() {
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0004\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0003\u0000\u0001\u0002\u0002\u0002\u0003Ț\u0004Ț\u0005Ț", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzfrp();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfro(bArr);
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
        synchronized (zzfrp.class) {
            zzidzVar = zzg;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzf);
                zzg = zzidzVar;
            }
        }
        return zzidzVar;
    }
}
