package com.google.android.gms.internal.ads;

import androidx.media3.extractor.avi.AviExtractor;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzahz implements zzahq {
    public final String zza;

    private zzahz(String str) {
        this.zza = str;
    }

    public static zzahz zzb(zzet zzetVar) {
        return new zzahz(zzetVar.zzK(zzetVar.zzd(), StandardCharsets.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final int zza() {
        return AviExtractor.FOURCC_strn;
    }
}
