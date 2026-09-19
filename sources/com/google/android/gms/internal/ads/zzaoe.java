package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaoe {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzaoe(String str, int i, Integer num, Integer num2, float f, boolean z, boolean z2, boolean z3, boolean z4, int i2) {
        this.zza = str;
        this.zzb = i;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f;
        this.zzf = z;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
        this.zzj = i2;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:40:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:46:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:52:0x0106  */
    /* JADX WARN: Code duplicated, block: B:55:0x010c A[Catch: RuntimeException -> 0x0139, TRY_LEAVE, TryCatch #2 {RuntimeException -> 0x0139, blocks: (B:29:0x00b5, B:31:0x00bb, B:35:0x00cb, B:37:0x00cf, B:41:0x00de, B:43:0x00e2, B:47:0x00f3, B:49:0x00f7, B:53:0x0108, B:55:0x010c, B:56:0x0114, B:64:0x0135, B:62:0x0125, B:26:0x009a, B:21:0x0086), top: B:75:0x0086, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0133  */
    public static zzaoe zza(String str, zzaoc zzaocVar) {
        float f;
        int i;
        int i2;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        int i6;
        String strTrim;
        int i7;
        zzgtj.zza(str.startsWith("Style:"));
        String[] strArrSplit = TextUtils.split(str.substring(6), ",");
        int length = strArrSplit.length;
        int i8 = zzaocVar.zzk;
        zzaoe zzaoeVar = null;
        if (length != i8) {
            Object[] objArr = {Integer.valueOf(i8), Integer.valueOf(length), str};
            String str2 = zzfl.zza;
            zzeg.zzc("SsaStyle", String.format(Locale.US, "Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", objArr));
            return null;
        }
        try {
            String strTrim2 = strArrSplit[zzaocVar.zza].trim();
            int i9 = zzaocVar.zzb;
            int iZzd = i9 != -1 ? zzd(strArrSplit[i9].trim()) : -1;
            int i10 = zzaocVar.zzc;
            Integer numZzb = i10 != -1 ? zzb(strArrSplit[i10].trim()) : null;
            int i11 = zzaocVar.zzd;
            Integer numZzb2 = i11 != -1 ? zzb(strArrSplit[i11].trim()) : null;
            int i12 = zzaocVar.zze;
            if (i12 != -1) {
                String strTrim3 = strArrSplit[i12].trim();
                try {
                    try {
                        f = Float.parseFloat(strTrim3);
                        zzaoeVar = null;
                    } catch (NumberFormatException e) {
                        StringBuilder sb = new StringBuilder(String.valueOf(strTrim3).length() + 29);
                        sb.append("Failed to parse font size: '");
                        sb.append(strTrim3);
                        sb.append("'");
                        zzeg.zzd("SsaStyle", sb.toString(), e);
                        f = -3.4028235E38f;
                    }
                    i = zzaocVar.zzf;
                    boolean z4 = false;
                    if (i == -1 && zze(strArrSplit[i].trim())) {
                        z4 = true;
                    }
                    i2 = zzaocVar.zzg;
                    if (i2 == -1 && zze(strArrSplit[i2].trim())) {
                        z = true;
                    } else {
                        z = false;
                    }
                    i3 = zzaocVar.zzh;
                    if (i3 == -1 && zze(strArrSplit[i3].trim())) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    i4 = zzaocVar.zzi;
                    if (i4 == -1 && zze(strArrSplit[i4].trim())) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    i5 = zzaocVar.zzj;
                    if (i5 != -1) {
                        strTrim = strArrSplit[i5].trim();
                        try {
                            i7 = Integer.parseInt(strTrim.trim());
                            if (i7 != 1 || i7 == 3) {
                                i6 = i7;
                            } else {
                                String.valueOf(strTrim);
                                zzeg.zzc("SsaStyle", "Ignoring unknown BorderStyle: ".concat(String.valueOf(strTrim)));
                                i6 = -1;
                            }
                        } catch (NumberFormatException unused) {
                        }
                    } else {
                        i6 = -1;
                    }
                    return new zzaoe(strTrim2, iZzd, numZzb, numZzb2, f, z4, z, z2, z3, i6);
                } catch (RuntimeException e2) {
                    e = e2;
                    StringBuilder sb2 = new StringBuilder(str.length() + 36);
                    sb2.append("Skipping malformed 'Style:' line: '");
                    sb2.append(str);
                    sb2.append("'");
                    zzeg.zzd("SsaStyle", sb2.toString(), e);
                    return zzaoeVar;
                }
            }
            f = -3.4028235E38f;
            i = zzaocVar.zzf;
            boolean z5 = false;
            if (i == -1) {
            }
            i2 = zzaocVar.zzg;
            if (i2 == -1) {
                z = false;
            } else {
                z = false;
            }
            i3 = zzaocVar.zzh;
            if (i3 == -1) {
                z2 = false;
            } else {
                z2 = false;
            }
            i4 = zzaocVar.zzi;
            if (i4 == -1) {
                z3 = false;
            } else {
                z3 = false;
            }
            i5 = zzaocVar.zzj;
            if (i5 != -1) {
                strTrim = strArrSplit[i5].trim();
                i7 = Integer.parseInt(strTrim.trim());
                if (i7 != 1) {
                }
                i6 = i7;
            } else {
                i6 = -1;
            }
            return new zzaoe(strTrim2, iZzd, numZzb, numZzb2, f, z5, z, z2, z3, i6);
        } catch (RuntimeException e3) {
            e = e3;
            zzaoeVar = null;
        }
    }

    public static Integer zzb(String str) {
        try {
            long j = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzgtj.zza(j <= 4294967295L);
            return Integer.valueOf(Color.argb(zzhah.zza(((j >> 24) & 255) ^ 255), zzhah.zza(j & 255), zzhah.zza((j >> 8) & 255), zzhah.zza((j >> 16) & 255)));
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36);
            sb.append("Failed to parse color expression: '");
            sb.append(str);
            sb.append("'");
            zzeg.zzd("SsaStyle", sb.toString(), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        try {
            int i = Integer.parseInt(str.trim());
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    return i;
                default:
                    String.valueOf(str);
                    zzeg.zzc("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
                    return -1;
            }
        } catch (NumberFormatException unused) {
        }
    }

    private static boolean zze(String str) {
        try {
            int i = Integer.parseInt(str);
            return i == 1 || i == -1;
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
            sb.append("Failed to parse boolean value: '");
            sb.append(str);
            sb.append("'");
            zzeg.zzd("SsaStyle", sb.toString(), e);
            return false;
        }
    }
}
