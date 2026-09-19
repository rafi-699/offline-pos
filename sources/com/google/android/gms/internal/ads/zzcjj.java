package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.credentials.exceptions.publickeycredential.DomExceptionUtils;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcjj extends zzcja implements zzchd {
    public static final /* synthetic */ int zzd = 0;
    private zzche zze;
    private String zzf;
    private boolean zzg;
    private boolean zzh;
    private zzcis zzi;
    private long zzj;
    private long zzk;

    public zzcjj(zzchn zzchnVar, zzchm zzchmVar) {
        super(zzchnVar);
        zzckc zzckcVar = new zzckc(zzchnVar.getContext(), zzchmVar, (zzchn) this.zzc.get(), null);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzh("ExoPlayerAdapter initialized.");
        this.zze = zzckcVar;
        zzckcVar.zzs(this);
    }

    protected static final String zzc(String str) {
        String strZzg = com.google.android.gms.ads.internal.util.client.zzf.zzg(str);
        String.valueOf(strZzg);
        return "cache:".concat(String.valueOf(strZzg));
    }

    private final void zzd(long j) {
        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() throws Throwable {
                this.zza.zzb();
            }
        }, j);
    }

    private static String zzx(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(str.length() + 1 + length + 1 + String.valueOf(message).length());
        sb.append(str);
        sb.append(DomExceptionUtils.SEPARATOR);
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzcja, com.google.android.gms.common.api.Releasable
    public final void release() {
        zzche zzcheVar = this.zze;
        if (zzcheVar != null) {
            zzcheVar.zzs(null);
            this.zze.zzt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzD() {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Precache onRenderedFirstFrame");
    }

    public final zzche zza() {
        synchronized (this) {
            this.zzh = true;
            notify();
        }
        this.zze.zzs(null);
        zzche zzcheVar = this.zze;
        this.zze = null;
        return zzcheVar;
    }

    final /* synthetic */ void zzb() throws Throwable {
        long j;
        long j2;
        long j3;
        String strZzc = zzc(this.zzf);
        String str = "error";
        try {
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzal)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzw)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcB)).booleanValue();
            synchronized (this) {
                try {
                    if (com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis() - this.zzj <= jLongValue) {
                        try {
                            if (this.zzg) {
                                throw new IOException("Abort requested before buffering finished. ");
                            }
                            if (!this.zzh) {
                                if (!this.zze.zzB()) {
                                    throw new IOException("ExoPlayer was released during preloading.");
                                }
                                long jZzH = this.zze.zzH();
                                if (jZzH > 0) {
                                    long jZzN = this.zze.zzN();
                                    if (jZzN != this.zzk) {
                                        boolean z = jZzN > 0;
                                        j2 = jZzH;
                                        j3 = jZzN;
                                        j = jIntValue;
                                        zzm(this.zzf, strZzc, j3, j2, z, zBooleanValue ? this.zze.zzI() : -1L, zBooleanValue ? this.zze.zzJ() : -1L, zBooleanValue ? this.zze.zzK() : -1L, zzche.zzP(), zzche.zzQ());
                                        this.zzk = j3;
                                    } else {
                                        j = jIntValue;
                                        j2 = jZzH;
                                        j3 = jZzN;
                                    }
                                    if (j3 >= j2) {
                                        zzp(this.zzf, strZzc, j2);
                                    } else if (this.zze.zzO() >= j && j3 > 0) {
                                    }
                                }
                                zzd(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzam)).longValue());
                                return;
                            }
                            com.google.android.gms.ads.internal.zzt.zzB().zzd(this.zzi);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            str = "Timeout reached. Limit: ";
                            throw th;
                        }
                    }
                    try {
                        StringBuilder sb = new StringBuilder(String.valueOf(jLongValue).length() + 27);
                        sb.append("Timeout reached. Limit: ");
                        sb.append(jLongValue);
                        sb.append(" ms");
                        throw new IOException(sb.toString());
                    } catch (Throwable th2) {
                        th = th2;
                        str = "downloadTimeout";
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                throw th;
            }
        } catch (Exception e) {
            String str2 = str;
            String str3 = this.zzf;
            String message = e.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 34 + String.valueOf(message).length());
            sb2.append("Failed to preload url ");
            sb2.append(str3);
            sb2.append(" Exception: ");
            sb2.append(message);
            String string = sb2.toString();
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(this.zzf, strZzc, str2, zzx(str2, e));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final boolean zze(String str) {
        return zzf(str, new String[]{str});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r35v0 */
    /* JADX WARN: Type inference failed for: r37v0 */
    /* JADX WARN: Type inference failed for: r37v1 */
    /* JADX WARN: Type inference failed for: r37v2 */
    /* JADX WARN: Type inference failed for: r43v0, types: [com.google.android.gms.internal.ads.zzcja, com.google.android.gms.internal.ads.zzcjj, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [long] */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v25 */
    @Override // com.google.android.gms.internal.ads.zzcja
    public final boolean zzf(String str, String[] strArr) throws Throwable {
        ?? r4;
        ?? r37;
        long j;
        long j2;
        this.zzf = str;
        ?? r17 = "error";
        String strZzc = zzc(str);
        String str2 = " ms";
        String str3 = "Timeout reached. Limit: ";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzq(uriArr, this.zzb);
            zzchn zzchnVar = (zzchn) this.zzc.get();
            if (zzchnVar != null) {
                zzchnVar.zzt(strZzc, this);
            }
            Clock clockZzk = com.google.android.gms.ads.internal.zzt.zzk();
            long jCurrentTimeMillis = clockZzk.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzam)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzal)).longValue() * 1000;
            long jIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzw)).intValue();
            boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcB)).booleanValue();
            long j3 = -1;
            ?? r6 = jLongValue;
            while (true) {
                synchronized (this) {
                    try {
                        if (clockZzk.currentTimeMillis() - jCurrentTimeMillis > jLongValue2) {
                            String str4 = str2;
                            String str5 = str3;
                            long j4 = jLongValue2;
                            StringBuilder sb = new StringBuilder(String.valueOf(j4).length() + 27);
                            sb.append(str5);
                            sb.append(j4);
                            sb.append(str4);
                            throw new IOException(sb.toString());
                        }
                        if (this.zzg) {
                            throw new IOException("Abort requested before buffering finished. ");
                        }
                        if (!this.zzh) {
                            if (!this.zze.zzB()) {
                                throw new IOException("ExoPlayer was released during preloading.");
                            }
                            long jZzH = this.zze.zzH();
                            if (jZzH > 0) {
                                long jZzN = this.zze.zzN();
                                if (jZzN != j3) {
                                    ?? r35 = r6;
                                    j = jZzH;
                                    r37 = r35;
                                    j2 = jZzN;
                                    zzm(str, strZzc, j2, j, jZzN > 0, zBooleanValue ? this.zze.zzI() : -1L, zBooleanValue ? this.zze.zzJ() : -1L, zBooleanValue ? this.zze.zzK() : -1L, zzche.zzP(), zzche.zzQ());
                                    j3 = j2;
                                } else {
                                    r37 = r6;
                                    j = jZzH;
                                    j2 = jZzN;
                                }
                                if (j2 >= j) {
                                    zzp(str, strZzc, j);
                                } else if (this.zze.zzO() < jIntValue || j2 <= 0) {
                                    r4 = r37;
                                }
                            } else {
                                str2 = str2;
                                str3 = str3;
                                jLongValue2 = jLongValue2;
                                jIntValue = jIntValue;
                                r4 = r6;
                            }
                            try {
                                try {
                                    wait(r4);
                                } catch (InterruptedException unused) {
                                    throw new IOException("Wait interrupted.");
                                }
                            } catch (Throwable th) {
                                th = th;
                                r17 = r4;
                                throw th;
                            }
                        }
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return true;
                r6 = r4;
                str2 = str2;
                jLongValue2 = jLongValue2;
                jIntValue = jIntValue;
                str3 = str3;
                clockZzk = clockZzk;
            }
        } catch (Exception e) {
            ?? r5 = r17;
            String message = e.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
            sb2.append("Failed to preload url ");
            sb2.append(str);
            sb2.append(" Exception: ");
            sb2.append(message);
            String string = sb2.toString();
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(str, strZzc, r5, zzx(r5, e));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final boolean zzg(String str, String[] strArr, zzcis zzcisVar) {
        this.zzf = str;
        this.zzi = zzcisVar;
        String strZzc = zzc(str);
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                uriArr[i] = Uri.parse(strArr[i]);
            }
            this.zze.zzq(uriArr, this.zzb);
            zzchn zzchnVar = (zzchn) this.zzc.get();
            if (zzchnVar != null) {
                zzchnVar.zzt(strZzc, this);
            }
            this.zzj = com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis();
            this.zzk = -1L;
            zzd(0L);
            return true;
        } catch (Exception e) {
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
            sb.append("Failed to preload url ");
            sb.append(str);
            sb.append(" Exception: ");
            sb.append(message);
            String string = sb.toString();
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
            com.google.android.gms.ads.internal.zzt.zzh().zzh(e, "VideoStreamExoPlayerCache.preload");
            release();
            zzq(str, strZzc, "error", zzx("error", e));
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzh(int i) {
        this.zze.zzG(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzi(int i) {
        this.zze.zzF(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzj(int i) {
        this.zze.zzy(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzk(int i) {
        this.zze.zzz(i);
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzl() {
        synchronized (this) {
            this.zzg = true;
            notify();
            release();
        }
        String str = this.zzf;
        if (str != null) {
            zzq(this.zzf, zzc(str), "externalAbort", "Programmatic precache abort.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzr(final boolean z, final long j) {
        final zzchn zzchnVar = (zzchn) this.zzc.get();
        if (zzchnVar != null) {
            zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcji
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    int i = zzcjj.zzd;
                    zzchnVar.zzu(z, j);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzs(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzt(int i, int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzu(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache error", exc);
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "VideoStreamExoPlayerCache.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzchd
    public final void zzv(String str, Exception exc) {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzj("Precache exception", exc);
        com.google.android.gms.ads.internal.zzt.zzh().zzh(exc, "VideoStreamExoPlayerCache.onException");
    }
}
