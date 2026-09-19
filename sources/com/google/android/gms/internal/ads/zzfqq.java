package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfqq extends zziee implements zzifq {
    private static final zzfqq zzd;
    private static volatile zzifx zze;
    private int zza;
    private zzieq zzb = zzbM();
    private zzihr zzc;

    static {
        zzfqq zzfqqVar = new zzfqq();
        zzd = zzfqqVar;
        zziee.zzbu(zzfqq.class, zzfqqVar);
    }

    private zzfqq() {
    }

    public static zzfqn zzb() {
        return (zzfqn) zzd.zzbn();
    }

    public final int zza() {
        return this.zzb.size();
    }

    final /* synthetic */ void zzc(zzfqp zzfqpVar) {
        zzfqpVar.getClass();
        zzieq zzieqVar = this.zzb;
        if (!zzieqVar.zza()) {
            this.zzb = zziee.zzbN(zzieqVar);
        }
        this.zzb.add(zzfqpVar);
    }

    final /* synthetic */ void zzd() {
        this.zzb = zzbM();
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zza", "zzb", zzfqp.class, "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzfqq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfqn(bArr);
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
        synchronized (zzfqq.class) {
            zzidzVar = zze;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzd);
                zze = zzidzVar;
            }
        }
        return zzidzVar;
    }
}
