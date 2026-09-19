package com.google.android.gms.internal.ads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgzt {
    public static void zza(byte[] bArr, File file) throws IOException {
        zzgzi zzgziVar = new zzgzi();
        file.getClass();
        FileOutputStream fileOutputStreamZza = zzgzr.zza(file, zzgww.zzq(new zzgzq[0]), zzgziVar);
        try {
            fileOutputStreamZza.write(bArr);
            fileOutputStreamZza.close();
        } catch (Throwable th) {
            try {
                fileOutputStreamZza.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void zzb(File file) throws IOException {
        file.getClass();
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException("Unable to create parent directories of ".concat(file.toString()));
        }
    }

    public static void zzc(File file, File file2) throws Throwable {
        file.getClass();
        file2.getClass();
        zzgtj.zzh(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (file.renameTo(file2)) {
            return;
        }
        zzgtj.zzh(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        zzgzs zzgzsVar = new zzgzs(file, null);
        zzgzi zzgziVar = new zzgzi();
        zzgww zzgwwVarZzq = zzgww.zzq(new zzgzq[0]);
        zzgzp zzgzpVarZza = zzgzp.zza();
        try {
            InputStream inputStreamZza = zzgzsVar.zza();
            zzgzpVarZza.zzb(inputStreamZza);
            InputStream inputStream = inputStreamZza;
            FileOutputStream fileOutputStreamZza = zzgzr.zza(file2, zzgwwVarZzq, zzgziVar);
            zzgzpVarZza.zzb(fileOutputStreamZza);
            FileOutputStream fileOutputStream = fileOutputStreamZza;
            int i = zzgzm.zza;
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = inputStreamZza.read(bArr);
                if (i2 == -1) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, i2);
                }
            }
            zzgzpVarZza.close();
            if (file.delete()) {
                return;
            }
            if (!file2.delete()) {
                throw new IOException("Unable to delete ".concat(file2.toString()));
            }
            throw new IOException("Unable to delete ".concat(file.toString()));
        } catch (Throwable th) {
            try {
                throw zzgzpVarZza.zzc(th);
            } catch (Throwable th2) {
                zzgzpVarZza.close();
                throw th2;
            }
        }
    }
}
