package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgtc extends zzgsz implements Serializable {
    private final Pattern zza;

    public final String toString() {
        return this.zza.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public final zzgsy zza(CharSequence charSequence) {
        return new zzgtb(this.zza.matcher(charSequence));
    }

    zzgtc(Pattern pattern) {
        pattern.getClass();
        this.zza = pattern;
    }
}
