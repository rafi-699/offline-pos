package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgzr {
    public static final FileOutputStream zza(File file, zzgww zzgwwVar, zzgzi zzgziVar) throws IOException {
        return new FileOutputStream(file, zzgwwVar.contains(zzgzq.APPEND));
    }
}
