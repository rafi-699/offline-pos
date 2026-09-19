package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzihz extends zziee implements zzifq {
    private static final zzihz zzb;
    private static volatile zzifx zzc;
    private zzieq zza = zzbM();

    static {
        zzihz zzihzVar = new zzihz();
        zzb = zzihzVar;
        zziee.zzbu(zzihz.class, zzihzVar);
    }

    private zzihz() {
    }

    public static zzihy zzc() {
        return (zzihy) zzb.zzbn();
    }

    final /* synthetic */ void zzd(zzihx zzihxVar) {
        zzihxVar.getClass();
        zzieq zzieqVar = this.zza;
        if (!zzieqVar.zza()) {
            this.zza = zziee.zzbN(zzieqVar);
        }
        this.zza.add(zzihxVar);
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzihx.class});
        }
        if (iOrdinal == 3) {
            return new zzihz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzihy(bArr);
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
        synchronized (zzihz.class) {
            zzidzVar = zzc;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzb);
                zzc = zzidzVar;
            }
        }
        return zzidzVar;
    }
}
