package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfyc extends zziee implements zzifq {
    private static final zzfyc zzf;
    private static volatile zzifx zzg;
    private int zza;
    private int zzb;
    private String zzc = "";
    private String zzd = "";
    private zzfxz zze;

    static {
        zzfyc zzfycVar = new zzfyc();
        zzf = zzfycVar;
        zziee.zzbu(zzfyc.class, zzfycVar);
    }

    private zzfyc() {
    }

    public static zzfya zza() {
        return (zzfya) zzf.zzbn();
    }

    final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    final /* synthetic */ void zzc(zzfxz zzfxzVar) {
        zzfxzVar.getClass();
        this.zze = zzfxzVar;
        this.zza |= 8;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    protected final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zza", "zzb", zzfyb.zza, "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzfyc();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfya(bArr);
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
        synchronized (zzfyc.class) {
            zzidzVar = zzg;
            if (zzidzVar == null) {
                zzidzVar = new zzidz(zzf);
                zzg = zzidzVar;
            }
        }
        return zzidzVar;
    }

    final /* synthetic */ void zze(int i) {
        this.zzb = 1;
        this.zza = 1 | this.zza;
    }
}
