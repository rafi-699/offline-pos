package com.google.android.gms.internal.identity_googleid;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.libraries.identity.googleid:googleid@@1.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzg extends zzd {
    public zzg() {
        super(4);
    }

    public final zzg zza(Object obj) {
        int i;
        int length = this.zza.length;
        int i2 = this.zzb;
        int i3 = i2 + 1;
        if (i3 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i3 <= length) {
            i = length;
        } else {
            i = (length >> 1) + length + 1;
            if (i < i3) {
                int iHighestOneBit = Integer.highestOneBit(i2);
                i = iHighestOneBit + iHighestOneBit;
            }
            if (i < 0) {
                i = Integer.MAX_VALUE;
            }
        }
        if (i > length || this.zzc) {
            this.zza = Arrays.copyOf(this.zza, i);
            this.zzc = false;
        }
        Object[] objArr = this.zza;
        int i4 = this.zzb;
        this.zzb = i4 + 1;
        objArr[i4] = obj;
        return this;
    }

    public final zzj zzb() {
        this.zzc = true;
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = zzj.zzd;
        return i == 0 ? zzk.zza : new zzk(objArr, i);
    }
}
