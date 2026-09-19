package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaua implements zzaso {
    private final zzatz zzc;
    private final Map zza = new LinkedHashMap(16, 0.75f, true);
    private long zzb = 0;
    private final int zzd = 5242880;

    public zzaua(zzatz zzatzVar, int i) {
        this.zzc = zzatzVar;
    }

    static byte[] zzg(zzaty zzatyVar, long j) throws IOException {
        long jZza = zzatyVar.zza();
        if (j >= 0 && j <= jZza) {
            int i = (int) j;
            if (i == j) {
                byte[] bArr = new byte[i];
                new DataInputStream(zzatyVar).readFully(bArr);
                return bArr;
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(j).length() + 33 + String.valueOf(jZza).length());
        sb.append("streamToBytes length=");
        sb.append(j);
        sb.append(", maxLength=");
        sb.append(jZza);
        throw new IOException(sb.toString());
    }

    static void zzh(OutputStream outputStream, int i) throws IOException {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static int zzi(InputStream inputStream) throws IOException {
        return (zzp(inputStream) << 24) | zzp(inputStream) | (zzp(inputStream) << 8) | (zzp(inputStream) << 16);
    }

    static void zzj(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) j);
        outputStream.write((byte) (j >>> 8));
        outputStream.write((byte) (j >>> 16));
        outputStream.write((byte) (j >>> 24));
        outputStream.write((byte) (j >>> 32));
        outputStream.write((byte) (j >>> 40));
        outputStream.write((byte) (j >>> 48));
        outputStream.write((byte) (j >>> 56));
    }

    static long zzk(InputStream inputStream) throws IOException {
        return (((long) zzp(inputStream)) & 255) | ((((long) zzp(inputStream)) & 255) << 8) | ((((long) zzp(inputStream)) & 255) << 16) | ((((long) zzp(inputStream)) & 255) << 24) | ((((long) zzp(inputStream)) & 255) << 32) | ((((long) zzp(inputStream)) & 255) << 40) | ((((long) zzp(inputStream)) & 255) << 48) | ((((long) zzp(inputStream)) & 255) << 56);
    }

    static void zzl(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes(Key.STRING_CHARSET_NAME);
        int length = bytes.length;
        zzj(outputStream, length);
        outputStream.write(bytes, 0, length);
    }

    static String zzm(zzaty zzatyVar) throws IOException {
        return new String(zzg(zzatyVar, zzk(zzatyVar)), Key.STRING_CHARSET_NAME);
    }

    private final void zzn(String str, zzatx zzatxVar) {
        Map map = this.zza;
        if (map.containsKey(str)) {
            this.zzb += zzatxVar.zza - ((zzatx) map.get(str)).zza;
        } else {
            this.zzb += zzatxVar.zza;
        }
        map.put(str, zzatxVar);
    }

    private final void zzo(String str) {
        zzatx zzatxVar = (zzatx) this.zza.remove(str);
        if (zzatxVar != null) {
            this.zzb -= zzatxVar.zza;
        }
    }

    private static int zzp(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return i;
        }
        throw new EOFException();
    }

    private static final String zzq(String str) {
        int length = str.length() >> 1;
        String strValueOf = String.valueOf(str.substring(0, length).hashCode());
        String strValueOf2 = String.valueOf(str.substring(length).hashCode());
        String.valueOf(strValueOf);
        String.valueOf(strValueOf2);
        return String.valueOf(strValueOf).concat(String.valueOf(strValueOf2));
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final synchronized zzasn zza(String str) {
        zzatx zzatxVar = (zzatx) this.zza.get(str);
        if (zzatxVar == null) {
            return null;
        }
        File fileZzf = zzf(str);
        try {
            zzaty zzatyVar = new zzaty(new BufferedInputStream(new FileInputStream(fileZzf)), fileZzf.length());
            try {
                String str2 = zzatx.zza(zzatyVar).zzb;
                if (!TextUtils.equals(str, str2)) {
                    zzatq.zzb("%s: key=%s, found=%s", fileZzf.getAbsolutePath(), str, str2);
                    zzo(str);
                    zzatyVar.close();
                    return null;
                }
                byte[] bArrZzg = zzg(zzatyVar, zzatyVar.zza());
                zzasn zzasnVar = new zzasn();
                zzasnVar.zza = bArrZzg;
                zzasnVar.zzb = zzatxVar.zzc;
                zzasnVar.zzc = zzatxVar.zzd;
                zzasnVar.zzd = zzatxVar.zze;
                zzasnVar.zze = zzatxVar.zzf;
                zzasnVar.zzf = zzatxVar.zzg;
                List<zzasw> list = zzatxVar.zzh;
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                for (zzasw zzaswVar : list) {
                    treeMap.put(zzaswVar.zza(), zzaswVar.zzb());
                }
                zzasnVar.zzg = treeMap;
                zzasnVar.zzh = Collections.unmodifiableList(list);
                zzatyVar.close();
                return zzasnVar;
            } catch (Throwable th) {
                zzatyVar.close();
                throw th;
            }
        } catch (IOException e) {
            zzatq.zzb("%s: %s", fileZzf.getAbsolutePath(), e.toString());
            zze(str);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final synchronized void zzb(String str, zzasn zzasnVar) {
        long j = this.zzb;
        int length = zzasnVar.zza.length;
        long j2 = j + ((long) length);
        int i = this.zzd;
        float f = 0.9f;
        if (j2 <= i || length <= i * 0.9f) {
            File fileZzf = zzf(str);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileZzf));
                zzatx zzatxVar = new zzatx(str, zzasnVar);
                try {
                    zzh(bufferedOutputStream, 538247942);
                    zzl(bufferedOutputStream, zzatxVar.zzb);
                    String str2 = zzatxVar.zzc;
                    if (str2 == null) {
                        str2 = "";
                    }
                    zzl(bufferedOutputStream, str2);
                    zzj(bufferedOutputStream, zzatxVar.zzd);
                    zzj(bufferedOutputStream, zzatxVar.zze);
                    zzj(bufferedOutputStream, zzatxVar.zzf);
                    zzj(bufferedOutputStream, zzatxVar.zzg);
                    List<zzasw> list = zzatxVar.zzh;
                    if (list != null) {
                        zzh(bufferedOutputStream, list.size());
                        for (zzasw zzaswVar : list) {
                            zzl(bufferedOutputStream, zzaswVar.zza());
                            zzl(bufferedOutputStream, zzaswVar.zzb());
                        }
                    } else {
                        zzh(bufferedOutputStream, 0);
                    }
                    bufferedOutputStream.flush();
                    bufferedOutputStream.write(zzasnVar.zza);
                    bufferedOutputStream.close();
                    zzatxVar.zza = fileZzf.length();
                    zzn(str, zzatxVar);
                    long j3 = this.zzb;
                    int i2 = this.zzd;
                    if (j3 >= i2) {
                        boolean z = zzatq.zzb;
                        if (z) {
                            zzatq.zza("Pruning old cache entries.", new Object[0]);
                        }
                        long j4 = this.zzb;
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        Iterator it = this.zza.entrySet().iterator();
                        int i3 = 0;
                        while (it.hasNext()) {
                            zzatx zzatxVar2 = (zzatx) ((Map.Entry) it.next()).getValue();
                            String str3 = zzatxVar2.zzb;
                            if (zzf(str3).delete()) {
                                this.zzb -= zzatxVar2.zza;
                            } else {
                                zzatq.zzb("Could not delete cache entry for key=%s, filename=%s", str3, zzq(str3));
                            }
                            it.remove();
                            i3++;
                            if (this.zzb < i2 * f) {
                                break;
                            } else {
                                f = f;
                            }
                        }
                        if (z) {
                            zzatq.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.zzb - j4), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
                        }
                    }
                } catch (IOException e) {
                    zzatq.zzb("%s", e.toString());
                    bufferedOutputStream.close();
                    zzatq.zzb("Failed to write header for %s", fileZzf.getAbsolutePath());
                    throw new IOException();
                }
            } catch (IOException unused) {
                if (!fileZzf.delete()) {
                    zzatq.zzb("Could not clean up file %s", fileZzf.getAbsolutePath());
                }
                if (!this.zzc.zza().exists()) {
                    zzatq.zzb("Re-initializing cache after external clearing.", new Object[0]);
                    this.zza.clear();
                    this.zzb = 0L;
                    zzc();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final synchronized void zzc() {
        try {
            File fileZza = this.zzc.zza();
            if (fileZza.exists()) {
                File[] fileArrListFiles = fileZza.listFiles();
                if (fileArrListFiles != null) {
                    for (File file : fileArrListFiles) {
                        try {
                            long length = file.length();
                            zzaty zzatyVar = new zzaty(new BufferedInputStream(new FileInputStream(file)), length);
                            try {
                                zzatx zzatxVarZza = zzatx.zza(zzatyVar);
                                zzatxVarZza.zza = length;
                                zzn(zzatxVarZza.zzb, zzatxVarZza);
                                zzatyVar.close();
                            } catch (Throwable th) {
                                zzatyVar.close();
                                throw th;
                            }
                        } catch (IOException unused) {
                            file.delete();
                        }
                    }
                }
            } else if (!fileZza.mkdirs()) {
                zzatq.zzc("Unable to create cache dir %s", fileZza.getAbsolutePath());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaso
    public final synchronized void zzd(String str, boolean z) {
        zzasn zzasnVarZza = zza(str);
        if (zzasnVarZza != null) {
            zzasnVarZza.zzf = 0L;
            zzasnVarZza.zze = 0L;
            zzb(str, zzasnVarZza);
        }
    }

    public final synchronized void zze(String str) {
        boolean zDelete = zzf(str).delete();
        zzo(str);
        if (zDelete) {
            return;
        }
        zzatq.zzb("Could not delete cache entry for key=%s, filename=%s", str, zzq(str));
    }

    public final File zzf(String str) {
        return new File(this.zzc.zza(), zzq(str));
    }

    public zzaua(File file, int i) {
        this.zzc = new zzatw(this, file);
    }
}
