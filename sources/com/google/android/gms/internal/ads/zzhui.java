package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhui extends zziee implements zzifq {
    private static final zzhui zzd;
    private static volatile zzifx zze;
    private int zza;
    private int zzb;
    private zzhuk zzc;

    static {
        zzhui zzhuiVar = new zzhui();
        zzd = zzhuiVar;
        zziee.zzbu(zzhui.class, zzhuiVar);
    }

    private zzhui() {
    }

    public static zzhui zzc(zzida zzidaVar, zzido zzidoVar) throws zziet {
        return (zzhui) zziee.zzbT(zzd, zzidaVar, zzidoVar);
    }

    public static zzhuh zzd() {
        return (zzhuh) zzd.zzbn();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhuk zzb() {
        zzhuk zzhukVar = this.zzc;
        return zzhukVar == null ? zzhuk.zzc() : zzhukVar;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhui();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhuh(bArr);
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
        synchronized (zzhui.class) {
            zzidzVar = zze;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzd);
                zze = zzidzVar;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zze(zzhuk zzhukVar) {
        zzhukVar.getClass();
        this.zzc = zzhukVar;
        this.zza |= 1;
    }
}
