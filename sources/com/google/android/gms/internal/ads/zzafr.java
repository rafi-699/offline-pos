package com.google.android.gms.internal.ads;

import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class zzafr implements zzafs {
    static final /* synthetic */ zzafr zza = new zzafr();

    private /* synthetic */ zzafr() {
    }

    @Override // com.google.android.gms.internal.ads.zzafs
    public final /* synthetic */ Constructor zza() {
        int i = zzafu.zza;
        if (Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(zzafy.class).getConstructor(Integer.TYPE);
        }
        return null;
    }
}
