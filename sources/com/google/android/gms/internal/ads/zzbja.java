package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbja extends zzbjb {
    zzbja() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
    
        if (r0 != r6.length()) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.String zzb(java.lang.String r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L7
            goto L37
        L7:
            int r0 = r6.length()
            r1 = 0
            r2 = r1
        Ld:
            int r3 = r6.length()
            r4 = 44
            if (r2 >= r3) goto L1e
            char r3 = r6.charAt(r2)
            if (r3 != r4) goto L1e
            int r2 = r2 + 1
            goto Ld
        L1e:
            if (r0 <= 0) goto L2a
            int r3 = r0 + (-1)
            char r5 = r6.charAt(r3)
            if (r5 != r4) goto L2a
            r0 = r3
            goto L1e
        L2a:
            if (r0 >= r2) goto L2e
            r6 = 0
            return r6
        L2e:
            if (r2 != 0) goto L38
            int r2 = r6.length()
            if (r0 == r2) goto L37
            goto L39
        L37:
            return r6
        L38:
            r1 = r2
        L39:
            java.lang.String r6 = r6.substring(r1, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbja.zzb(java.lang.String):java.lang.String");
    }

    @Override // com.google.android.gms.internal.ads.zzbjb
    public final String zza(String str, String str2) {
        String strZzb = zzb(str);
        String strZzb2 = zzb(str2);
        if (TextUtils.isEmpty(strZzb)) {
            return strZzb2;
        }
        if (TextUtils.isEmpty(strZzb2)) {
            return strZzb;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(strZzb).length() + 1 + String.valueOf(strZzb2).length());
        sb.append(strZzb);
        sb.append(",");
        sb.append(strZzb2);
        return sb.toString();
    }
}
