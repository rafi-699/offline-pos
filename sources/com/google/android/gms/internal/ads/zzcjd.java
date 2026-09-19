package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.common.net.HttpHeaders;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcjd extends zzcja {
    public static final /* synthetic */ int zzd = 0;
    private static final Set zze = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzf = new DecimalFormat("#,###");
    private File zzg;
    private boolean zzh;

    public zzcjd(zzchn zzchnVar) {
        super(zzchnVar);
        File cacheDir = this.zza.getCacheDir();
        if (cacheDir == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Context.getCacheDir() returned null");
            return;
        }
        File file = new File(zzfzk.zza().zza(cacheDir, "admobVideoStreams"));
        this.zzg = file;
        if (!file.isDirectory() && !this.zzg.mkdirs()) {
            String absolutePath = this.zzg.getAbsolutePath();
            String.valueOf(absolutePath);
            String strValueOf = String.valueOf(absolutePath);
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not create preload cache directory at ".concat(strValueOf));
            this.zzg = null;
            return;
        }
        if (this.zzg.setReadable(true, false) && this.zzg.setExecutable(true, false)) {
            return;
        }
        String absolutePath2 = this.zzg.getAbsolutePath();
        String.valueOf(absolutePath2);
        String strValueOf2 = String.valueOf(absolutePath2);
        int i3 = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not set cache file permissions at ".concat(strValueOf2));
        this.zzg = null;
    }

    private final File zza(File file) {
        zzfzl zzfzlVarZza = zzfzk.zza();
        File file2 = this.zzg;
        String name = file.getName();
        String.valueOf(name);
        return new File(zzfzlVarZza.zza(file2, String.valueOf(name).concat(".done")));
    }

    @Override // com.google.android.gms.internal.ads.zzcja
    public final void zzl() {
        this.zzh = true;
    }

    /* JADX WARN: Code duplicated, block: B:159:0x044b  */
    /* JADX WARN: Code duplicated, block: B:163:0x045d  */
    /* JADX WARN: Code duplicated, block: B:164:0x0481  */
    /* JADX WARN: Code duplicated, block: B:167:0x04aa  */
    /* JADX WARN: Code duplicated, block: B:18:0x0069  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r33v0, types: [com.google.android.gms.internal.ads.zzcja, com.google.android.gms.internal.ads.zzcjd] */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v24 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v38 */
    @Override // com.google.android.gms.internal.ads.zzcja
    public final boolean zze(final String str) {
        int i;
        Object obj;
        File file;
        Object obj2;
        String str2;
        FileOutputStream fileOutputStream;
        ?? r11;
        ?? r4;
        Object obj3;
        ?? r12;
        int i2;
        ByteBuffer byteBuffer;
        boolean zDelete;
        String str3 = "Preloaded ";
        if (this.zzg == null) {
            zzq(str, null, "noCacheDir", null);
            return false;
        }
        while (true) {
            File file2 = this.zzg;
            if (file2 == null) {
                i = 0;
            } else {
                File[] fileArrListFiles = file2.listFiles();
                int length = fileArrListFiles.length;
                int i3 = 0;
                int i4 = 0;
                while (i3 < length) {
                    int i5 = i3;
                    int i6 = length;
                    if (!fileArrListFiles[i3].getName().endsWith(".done")) {
                        i4++;
                    }
                    i3 = i5 + 1;
                    length = i6;
                }
                i = i4;
            }
            String str4 = str3;
            if (i > ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzu)).intValue()) {
                File file3 = this.zzg;
                if (file3 == null) {
                    zDelete = false;
                } else {
                    File[] fileArrListFiles2 = file3.listFiles();
                    int length2 = fileArrListFiles2.length;
                    int i7 = 0;
                    long j = Long.MAX_VALUE;
                    File file4 = null;
                    while (i7 < length2) {
                        File file5 = fileArrListFiles2[i7];
                        int i8 = length2;
                        int i9 = i7;
                        if (!file5.getName().endsWith(".done")) {
                            long jLastModified = file5.lastModified();
                            if (jLastModified < j) {
                                j = jLastModified;
                                file4 = file5;
                            }
                        }
                        i7 = i9 + 1;
                        length2 = i8;
                    }
                    if (file4 != null) {
                        zDelete = file4.delete();
                        File fileZza = zza(file4);
                        if (fileZza.isFile()) {
                            zDelete = fileZza.delete() & zDelete;
                        }
                    } else {
                        zDelete = false;
                    }
                }
                if (!zDelete) {
                    int i10 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Unable to expire stream cache");
                    zzq(str, null, "expireFailed", null);
                    return false;
                }
                str3 = str4;
            } else {
                File file6 = new File(zzfzk.zza().zza(this.zzg, com.google.android.gms.ads.internal.util.client.zzf.zzg(str)));
                File fileZza2 = zza(file6);
                if (file6.isFile() && fileZza2.isFile()) {
                    int length3 = (int) file6.length();
                    String.valueOf(str);
                    String strValueOf = String.valueOf(str);
                    int i11 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzd("Stream cache hit at ".concat(strValueOf));
                    zzo(str, file6.getAbsolutePath(), length3);
                    return true;
                }
                String absolutePath = this.zzg.getAbsolutePath();
                String.valueOf(absolutePath);
                String.valueOf(str);
                String strValueOf2 = String.valueOf(absolutePath);
                String strValueOf3 = String.valueOf(str);
                Set set = zze;
                String strConcat = strValueOf2.concat(strValueOf3);
                synchronized (set) {
                    if (set.contains(strConcat)) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36);
                        sb.append("Stream cache already in progress at ");
                        sb.append(str);
                        String string = sb.toString();
                        int i12 = com.google.android.gms.ads.internal.util.zze.zza;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi(string);
                        zzq(str, file6.getAbsolutePath(), "inProgress", null);
                        return false;
                    }
                    set.add(strConcat);
                    try {
                        obj = "error";
                        try {
                            try {
                                HttpURLConnection httpURLConnectionZzh = zzgai.zza().zzh(new zzfzy() { // from class: com.google.android.gms.internal.ads.zzcjc
                                    @Override // com.google.android.gms.internal.ads.zzfzy
                                    public final /* synthetic */ URLConnection zza() throws IOException {
                                        int i13 = zzcjd.zzd;
                                        com.google.android.gms.ads.internal.zzt.zzq();
                                        int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzan)).intValue();
                                        URL url = new URL(str);
                                        int i14 = 0;
                                        while (true) {
                                            i14++;
                                            if (i14 > 20) {
                                                throw new IOException("Too many redirects (20)");
                                            }
                                            int i15 = zzfzr.zzb;
                                            URLConnection uRLConnectionOpenConnection = url.openConnection();
                                            uRLConnectionOpenConnection.setConnectTimeout(iIntValue);
                                            uRLConnectionOpenConnection.setReadTimeout(iIntValue);
                                            if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                                                throw new IOException("Invalid protocol.");
                                            }
                                            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                                            com.google.android.gms.ads.internal.util.client.zzl zzlVar = new com.google.android.gms.ads.internal.util.client.zzl(null);
                                            zzlVar.zza(httpURLConnection, null);
                                            httpURLConnection.setInstanceFollowRedirects(false);
                                            int responseCode = httpURLConnection.getResponseCode();
                                            zzlVar.zzc(httpURLConnection, responseCode);
                                            if (responseCode / 100 != 3) {
                                                return httpURLConnection;
                                            }
                                            String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                                            if (headerField == null) {
                                                throw new IOException("Missing Location header in redirect");
                                            }
                                            URL url2 = new URL(url, headerField);
                                            String protocol = url2.getProtocol();
                                            if (protocol == null) {
                                                throw new IOException("Protocol is null");
                                            }
                                            if (!protocol.equals("http") && !protocol.equals("https")) {
                                                throw new IOException("Unsupported scheme: ".concat(protocol));
                                            }
                                            String strConcat2 = "Redirecting to ".concat(headerField);
                                            int i16 = com.google.android.gms.ads.internal.util.zze.zza;
                                            com.google.android.gms.ads.internal.util.client.zzo.zzd(strConcat2);
                                            httpURLConnection.disconnect();
                                            url = url2;
                                        }
                                    }
                                }, 265, -1);
                                if (httpURLConnectionZzh instanceof HttpURLConnection) {
                                    HttpURLConnection httpURLConnection = httpURLConnectionZzh;
                                    int responseCode = httpURLConnectionZzh.getResponseCode();
                                    if (responseCode >= 400) {
                                        try {
                                            String string2 = Integer.toString(responseCode);
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(string2).length() + 27);
                                            sb2.append("HTTP request failed. Code: ");
                                            sb2.append(string2);
                                            String string3 = sb2.toString();
                                            try {
                                                StringBuilder sb3 = new StringBuilder(String.valueOf(responseCode).length() + 21 + String.valueOf(str).length());
                                                sb3.append("HTTP status code ");
                                                sb3.append(responseCode);
                                                sb3.append(" at ");
                                                sb3.append(str);
                                                throw new IOException(sb3.toString());
                                            } catch (IOException | RuntimeException e) {
                                                e = e;
                                                obj3 = "badUrl";
                                                file = file6;
                                                str2 = string3;
                                                fileOutputStream = null;
                                                r4 = str2;
                                                r11 = obj3;
                                                if (e instanceof RuntimeException) {
                                                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "VideoStreamFullFileCache.preload");
                                                }
                                                try {
                                                    fileOutputStream.close();
                                                } catch (IOException | NullPointerException unused) {
                                                }
                                                if (this.zzh) {
                                                    StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 26);
                                                    sb4.append("Preload aborted for URL \"");
                                                    sb4.append(str);
                                                    sb4.append("\"");
                                                    String string4 = sb4.toString();
                                                    int i13 = com.google.android.gms.ads.internal.util.zze.zza;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzh(string4);
                                                } else {
                                                    StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 25);
                                                    sb5.append("Preload failed for URL \"");
                                                    sb5.append(str);
                                                    sb5.append("\"");
                                                    String string5 = sb5.toString();
                                                    int i14 = com.google.android.gms.ads.internal.util.zze.zza;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzj(string5, e);
                                                }
                                                if (file.exists()) {
                                                    String absolutePath2 = file.getAbsolutePath();
                                                    String.valueOf(absolutePath2);
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not delete partial cache file at ".concat(String.valueOf(absolutePath2)));
                                                }
                                                zzq(str, file.getAbsolutePath(), r11, r4);
                                                zze.remove(strConcat);
                                                return false;
                                            }
                                        } catch (IOException | RuntimeException e2) {
                                            e = e2;
                                            obj2 = "badUrl";
                                            file = file6;
                                            str2 = null;
                                            obj3 = obj2;
                                            fileOutputStream = null;
                                            r4 = str2;
                                            r11 = obj3;
                                            if (e instanceof RuntimeException) {
                                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "VideoStreamFullFileCache.preload");
                                            }
                                            fileOutputStream.close();
                                            if (this.zzh) {
                                                StringBuilder sb6 = new StringBuilder(String.valueOf(str).length() + 26);
                                                sb6.append("Preload aborted for URL \"");
                                                sb6.append(str);
                                                sb6.append("\"");
                                                String string6 = sb6.toString();
                                                int i15 = com.google.android.gms.ads.internal.util.zze.zza;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzh(string6);
                                            } else {
                                                StringBuilder sb7 = new StringBuilder(String.valueOf(str).length() + 25);
                                                sb7.append("Preload failed for URL \"");
                                                sb7.append(str);
                                                sb7.append("\"");
                                                String string7 = sb7.toString();
                                                int i16 = com.google.android.gms.ads.internal.util.zze.zza;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzj(string7, e);
                                            }
                                            if (file.exists()) {
                                                String absolutePath3 = file.getAbsolutePath();
                                                String.valueOf(absolutePath3);
                                                com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not delete partial cache file at ".concat(String.valueOf(absolutePath3)));
                                            }
                                            zzq(str, file.getAbsolutePath(), r11, r4);
                                            zze.remove(strConcat);
                                            return false;
                                        }
                                    }
                                }
                                int contentLength = httpURLConnectionZzh.getContentLength();
                                if (contentLength < 0) {
                                    StringBuilder sb8 = new StringBuilder(String.valueOf(str).length() + 55);
                                    sb8.append("Stream cache aborted, missing content-length header at ");
                                    sb8.append(str);
                                    String string8 = sb8.toString();
                                    int i17 = com.google.android.gms.ads.internal.util.zze.zza;
                                    com.google.android.gms.ads.internal.util.client.zzo.zzi(string8);
                                    zzq(str, file6.getAbsolutePath(), "contentLengthMissing", null);
                                    set.remove(strConcat);
                                    return false;
                                }
                                DecimalFormat decimalFormat = zzf;
                                String str5 = decimalFormat.format(contentLength);
                                int iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzv)).intValue();
                                if (contentLength > iIntValue) {
                                    StringBuilder sb9 = new StringBuilder(String.valueOf(str5).length() + 33 + String.valueOf(str).length());
                                    sb9.append("Content length ");
                                    sb9.append(str5);
                                    sb9.append(" exceeds limit at ");
                                    sb9.append(str);
                                    String string9 = sb9.toString();
                                    int i18 = com.google.android.gms.ads.internal.util.zze.zza;
                                    com.google.android.gms.ads.internal.util.client.zzo.zzi(string9);
                                    StringBuilder sb10 = new StringBuilder(String.valueOf(str5).length() + 40);
                                    sb10.append("File too big for full file cache. Size: ");
                                    sb10.append(str5);
                                    zzq(str, file6.getAbsolutePath(), "sizeExceeded", sb10.toString());
                                    set.remove(strConcat);
                                    return false;
                                }
                                StringBuilder sb11 = new StringBuilder(String.valueOf(str5).length() + 20 + String.valueOf(str).length());
                                sb11.append("Caching ");
                                sb11.append(str5);
                                sb11.append(" bytes from ");
                                sb11.append(str);
                                String string10 = sb11.toString();
                                int i19 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzd(string10);
                                ReadableByteChannel readableByteChannelNewChannel = Channels.newChannel(httpURLConnectionZzh.getInputStream());
                                file = file6;
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        try {
                                            FileChannel channel = fileOutputStream.getChannel();
                                            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1048576);
                                            Clock clockZzk = com.google.android.gms.ads.internal.zzt.zzk();
                                            long jCurrentTimeMillis = clockZzk.currentTimeMillis();
                                            com.google.android.gms.ads.internal.util.zzbu zzbuVar = new com.google.android.gms.ads.internal.util.zzbu(((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzam)).longValue());
                                            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzal)).longValue();
                                            int i20 = 0;
                                            while (true) {
                                                int i21 = readableByteChannelNewChannel.read(byteBufferAllocate);
                                                if (i21 < 0) {
                                                    fileOutputStream.close();
                                                    if (com.google.android.gms.ads.internal.util.zze.zzm(3)) {
                                                        String str6 = decimalFormat.format(i20);
                                                        StringBuilder sb12 = new StringBuilder(String.valueOf(str6).length() + 22 + String.valueOf(str).length());
                                                        sb12.append(str4);
                                                        sb12.append(str6);
                                                        sb12.append(" bytes from ");
                                                        sb12.append(str);
                                                        com.google.android.gms.ads.internal.util.client.zzo.zzd(sb12.toString());
                                                    }
                                                    file.setReadable(true, false);
                                                    if (fileZza2.isFile()) {
                                                        fileZza2.setLastModified(System.currentTimeMillis());
                                                    } else {
                                                        try {
                                                            fileZza2.createNewFile();
                                                        } catch (IOException unused2) {
                                                        }
                                                    }
                                                    zzo(str, file.getAbsolutePath(), i20);
                                                    zze.remove(strConcat);
                                                    return true;
                                                }
                                                i20 += i21;
                                                try {
                                                    try {
                                                        if (i20 > iIntValue) {
                                                            String string11 = Integer.toString(i20);
                                                            StringBuilder sb13 = new StringBuilder(String.valueOf(string11).length() + 40);
                                                            sb13.append("File too big for full file cache. Size: ");
                                                            sb13.append(string11);
                                                            sb13.toString();
                                                            throw new IOException("stream cache file size limit exceeded");
                                                        }
                                                        byteBufferAllocate.flip();
                                                        while (channel.write(byteBufferAllocate) > 0) {
                                                        }
                                                        byteBufferAllocate.clear();
                                                        if (clockZzk.currentTimeMillis() - jCurrentTimeMillis > 1000 * jLongValue) {
                                                            String string12 = Long.toString(jLongValue);
                                                            StringBuilder sb14 = new StringBuilder(String.valueOf(string12).length() + 29);
                                                            sb14.append("Timeout exceeded. Limit: ");
                                                            sb14.append(string12);
                                                            sb14.append(" sec");
                                                            sb14.toString();
                                                            throw new IOException("stream cache time limit exceeded");
                                                        }
                                                        if (this.zzh) {
                                                            throw new IOException("abort requested");
                                                        }
                                                        if (zzbuVar.zza()) {
                                                            byteBuffer = byteBufferAllocate;
                                                            i2 = contentLength;
                                                            com.google.android.gms.ads.internal.util.client.zzf.zza.post(new zzciu(this, str, file.getAbsolutePath(), i20, i2, false));
                                                        } else {
                                                            i2 = contentLength;
                                                            byteBuffer = byteBufferAllocate;
                                                        }
                                                        contentLength = i2;
                                                        zzbuVar = zzbuVar;
                                                        byteBufferAllocate = byteBuffer;
                                                        readableByteChannelNewChannel = readableByteChannelNewChannel;
                                                    } catch (IOException | RuntimeException e3) {
                                                        e = e3;
                                                        r12 = iIntValue;
                                                    }
                                                } catch (IOException | RuntimeException e4) {
                                                    e = e4;
                                                    r4 = channel;
                                                    fileOutputStream = fileOutputStream;
                                                    r11 = iIntValue;
                                                }
                                                r4 = 0;
                                                r11 = r12;
                                                if (e instanceof RuntimeException) {
                                                    com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "VideoStreamFullFileCache.preload");
                                                }
                                                fileOutputStream.close();
                                                if (this.zzh) {
                                                    StringBuilder sb15 = new StringBuilder(String.valueOf(str).length() + 26);
                                                    sb15.append("Preload aborted for URL \"");
                                                    sb15.append(str);
                                                    sb15.append("\"");
                                                    String string13 = sb15.toString();
                                                    int i110 = com.google.android.gms.ads.internal.util.zze.zza;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzh(string13);
                                                } else {
                                                    StringBuilder sb16 = new StringBuilder(String.valueOf(str).length() + 25);
                                                    sb16.append("Preload failed for URL \"");
                                                    sb16.append(str);
                                                    sb16.append("\"");
                                                    String string14 = sb16.toString();
                                                    int i111 = com.google.android.gms.ads.internal.util.zze.zza;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzj(string14, e);
                                                }
                                                if (file.exists() && !file.delete()) {
                                                    String absolutePath4 = file.getAbsolutePath();
                                                    String.valueOf(absolutePath4);
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not delete partial cache file at ".concat(String.valueOf(absolutePath4)));
                                                }
                                                zzq(str, file.getAbsolutePath(), r11, r4);
                                                zze.remove(strConcat);
                                                return false;
                                            }
                                        } catch (RuntimeException e5) {
                                            e = e5;
                                            r12 = obj;
                                        }
                                    } catch (IOException e6) {
                                        e = e6;
                                        r12 = obj;
                                    }
                                } catch (IOException e7) {
                                    e = e7;
                                    obj2 = obj;
                                    str2 = null;
                                    obj3 = obj2;
                                    fileOutputStream = null;
                                    r4 = str2;
                                    r11 = obj3;
                                } catch (RuntimeException e8) {
                                    e = e8;
                                    obj2 = obj;
                                    str2 = null;
                                    obj3 = obj2;
                                    fileOutputStream = null;
                                    r4 = str2;
                                    r11 = obj3;
                                }
                            } catch (IOException | RuntimeException e9) {
                                e = e9;
                                file = file6;
                            }
                        } catch (IOException e10) {
                            e = e10;
                            file = file6;
                            obj2 = obj;
                            str2 = null;
                            obj3 = obj2;
                            fileOutputStream = null;
                            r4 = str2;
                            r11 = obj3;
                            if (e instanceof RuntimeException) {
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "VideoStreamFullFileCache.preload");
                            }
                            fileOutputStream.close();
                            if (this.zzh) {
                                StringBuilder sb17 = new StringBuilder(String.valueOf(str).length() + 26);
                                sb17.append("Preload aborted for URL \"");
                                sb17.append(str);
                                sb17.append("\"");
                                String string15 = sb17.toString();
                                int i112 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzh(string15);
                            } else {
                                StringBuilder sb18 = new StringBuilder(String.valueOf(str).length() + 25);
                                sb18.append("Preload failed for URL \"");
                                sb18.append(str);
                                sb18.append("\"");
                                String string16 = sb18.toString();
                                int i113 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzj(string16, e);
                            }
                            if (file.exists()) {
                                String absolutePath5 = file.getAbsolutePath();
                                String.valueOf(absolutePath5);
                                com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not delete partial cache file at ".concat(String.valueOf(absolutePath5)));
                            }
                            zzq(str, file.getAbsolutePath(), r11, r4);
                            zze.remove(strConcat);
                            return false;
                        } catch (RuntimeException e11) {
                            e = e11;
                            file = file6;
                            obj2 = obj;
                            str2 = null;
                            obj3 = obj2;
                            fileOutputStream = null;
                            r4 = str2;
                            r11 = obj3;
                            if (e instanceof RuntimeException) {
                                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "VideoStreamFullFileCache.preload");
                            }
                            fileOutputStream.close();
                            if (this.zzh) {
                                StringBuilder sb19 = new StringBuilder(String.valueOf(str).length() + 26);
                                sb19.append("Preload aborted for URL \"");
                                sb19.append(str);
                                sb19.append("\"");
                                String string17 = sb19.toString();
                                int i114 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzh(string17);
                            } else {
                                StringBuilder sb110 = new StringBuilder(String.valueOf(str).length() + 25);
                                sb110.append("Preload failed for URL \"");
                                sb110.append(str);
                                sb110.append("\"");
                                String string18 = sb110.toString();
                                int i115 = com.google.android.gms.ads.internal.util.zze.zza;
                                com.google.android.gms.ads.internal.util.client.zzo.zzj(string18, e);
                            }
                            if (file.exists()) {
                                String absolutePath6 = file.getAbsolutePath();
                                String.valueOf(absolutePath6);
                                com.google.android.gms.ads.internal.util.client.zzo.zzi("Could not delete partial cache file at ".concat(String.valueOf(absolutePath6)));
                            }
                            zzq(str, file.getAbsolutePath(), r11, r4);
                            zze.remove(strConcat);
                            return false;
                        }
                    } catch (IOException | RuntimeException e12) {
                        e = e12;
                        obj = "error";
                    }
                }
            }
        }
    }
}
