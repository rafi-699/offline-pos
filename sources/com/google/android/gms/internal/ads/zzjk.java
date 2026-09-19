package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzjk extends zzau {
    public final int zzc;
    public final String zzd;
    public final int zze;
    public final zzv zzf;
    public final int zzg;
    public final zzxk zzh;
    final boolean zzi;

    private zzjk(int i, Throwable th, int i2) {
        this(i, th, null, i2, null, -1, null, 4, null, false);
    }

    public static zzjk zza(IOException iOException, int i) {
        return new zzjk(0, iOException, i);
    }

    public static zzjk zzb(Throwable th, String str, int i, zzv zzvVar, int i2, zzxk zzxkVar, boolean z, int i3) {
        if (zzvVar == null) {
            i2 = 4;
        }
        return new zzjk(1, th, null, i3, str, i, zzvVar, i2, zzxkVar, z);
    }

    public static zzjk zzc(RuntimeException runtimeException, int i) {
        return new zzjk(2, runtimeException, i);
    }

    final zzjk zzd(zzxk zzxkVar) {
        String message = getMessage();
        String str = zzfl.zza;
        return new zzjk(message, getCause(), this.zza, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, zzxkVar, this.zzb, this.zzi);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private zzjk(int i, Throwable th, String str, int i2, String str2, int i3, zzv zzvVar, int i4, zzxk zzxkVar, boolean z) {
        String str3;
        int i5;
        String string;
        String str4;
        if (i == 0) {
            str3 = str2;
            i5 = i3;
            string = "Source error";
        } else if (i != 1) {
            string = "Unexpected runtime error";
            str3 = str2;
            i5 = i3;
        } else {
            String strValueOf = String.valueOf(zzvVar);
            String str5 = zzfl.zza;
            if (i4 == 0) {
                str4 = "NO";
            } else if (i4 == 1) {
                str4 = "NO_UNSUPPORTED_SUBTYPE";
            } else if (i4 == 2) {
                str4 = "NO_UNSUPPORTED_DRM";
            } else if (i4 == 3) {
                str4 = "NO_EXCEEDS_CAPABILITIES";
            } else {
                if (i4 != 4) {
                    throw new IllegalStateException();
                }
                str4 = "YES";
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 14 + String.valueOf(i3).length() + 9 + String.valueOf(strValueOf).length() + 19 + str4.length());
            str3 = str2;
            sb.append(str3);
            sb.append(" error, index=");
            i5 = i3;
            sb.append(i5);
            sb.append(", format=");
            sb.append(strValueOf);
            sb.append(", format_supported=");
            sb.append(str4);
            string = sb.toString();
        }
        this(TextUtils.isEmpty(null) ? string : string.concat(": null"), th, i2, i, str3, i5, zzvVar, i4, zzxkVar, SystemClock.elapsedRealtime(), z);
    }

    private zzjk(String str, Throwable th, int i, int i2, String str2, int i3, zzv zzvVar, int i4, zzxk zzxkVar, long j, boolean z) {
        boolean z2;
        super(str, th, i, Bundle.EMPTY, j);
        if (!z) {
            z2 = true;
        } else if (i2 == 1) {
            i2 = 1;
            z2 = true;
        } else {
            z2 = false;
        }
        zzgtj.zza(z2);
        zzgtj.zza(th != null);
        this.zzc = i2;
        this.zzd = str2;
        this.zze = i3;
        this.zzf = zzvVar;
        this.zzg = i4;
        this.zzh = zzxkVar;
        this.zzi = z;
    }
}
