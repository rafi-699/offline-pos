package com.google.android.gms.internal.ads;

import androidx.media3.common.C;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzaiw implements zzaiv {
    private final long zza;
    private final String zzb;

    public zzaiw(long j, long j2, String str) {
        this.zza = j;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaiw zzaiwVar = (zzaiw) obj;
            if (this.zza == zzaiwVar.zza && Objects.equals(this.zzb, zzaiwVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Long.hashCode(this.zza) + 527) * 31) + Long.hashCode(C.TIME_UNSET)) * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        long j = this.zza;
        Object objValueOf = j == C.TIME_UNSET ? "UNSET" : Long.valueOf(j);
        String str = this.zzb;
        String string = objValueOf.toString();
        int length = string.length();
        String strConcat = ", title=".concat(str);
        StringBuilder sb = new StringBuilder(length + 21 + strConcat.length());
        sb.append("Chapter: startTimeMs=");
        sb.append(string);
        sb.append("");
        sb.append(strConcat);
        return sb.toString();
    }
}
