package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.react.animated.InterpolationAnimatedNode;
import com.google.common.net.HttpHeaders;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.HttpURLConnection;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@25.2.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzcjl extends zzhh implements zzii {
    private static final Pattern zza = Pattern.compile("^bytes (\\d+)-(\\d+)/(\\d+)$");
    private static final AtomicReference zzb = new AtomicReference();
    private final SSLSocketFactory zzc;
    private final int zzd;
    private final int zze;
    private final String zzf;
    private final zzih zzg;
    private zzht zzh;
    private HttpURLConnection zzi;
    private InputStream zzj;
    private boolean zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private final Set zzr;

    zzcjl(String str, zzin zzinVar, int i, int i2, int i3) {
        super(true);
        this.zzc = new zzcjk(this);
        this.zzr = new HashSet();
        zzdg.zza(str);
        this.zzf = str;
        this.zzg = new zzih();
        this.zzd = i;
        this.zze = i2;
        this.zzq = i3;
        if (zzinVar != null) {
            zze(zzinVar);
        }
    }

    private final void zzn() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                int i = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Unexpected error while disconnecting", e);
            }
            this.zzi = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x02c5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:126:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x00dd A[Catch: IOException -> 0x02eb, TryCatch #4 {IOException -> 0x02eb, blocks: (B:3:0x000e, B:4:0x0027, B:6:0x002f, B:8:0x003d, B:9:0x0045, B:10:0x005d, B:12:0x0063, B:19:0x0090, B:21:0x00b0, B:22:0x00cf, B:23:0x00d4, B:25:0x00dd, B:26:0x00e4, B:39:0x010c, B:93:0x0284, B:95:0x0291, B:97:0x02a2, B:100:0x02ab, B:101:0x02bb, B:103:0x02c5, B:104:0x02cc, B:105:0x02cd, B:106:0x02ea), top: B:118:0x000e }] */
    /* JADX WARN: Code duplicated, block: B:49:0x0126  */
    /* JADX WARN: Code duplicated, block: B:87:0x0259  */
    /* JADX WARN: Code duplicated, block: B:95:0x0291 A[Catch: IOException -> 0x02eb, TryCatch #4 {IOException -> 0x02eb, blocks: (B:3:0x000e, B:4:0x0027, B:6:0x002f, B:8:0x003d, B:9:0x0045, B:10:0x005d, B:12:0x0063, B:19:0x0090, B:21:0x00b0, B:22:0x00cf, B:23:0x00d4, B:25:0x00dd, B:26:0x00e4, B:39:0x010c, B:93:0x0284, B:95:0x0291, B:97:0x02a2, B:100:0x02ab, B:101:0x02bb, B:103:0x02c5, B:104:0x02cc, B:105:0x02cd, B:106:0x02ea), top: B:118:0x000e }] */
    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) throws zzie {
        long j;
        int responseCode;
        String headerField;
        String protocol;
        int responseCode2;
        zzig zzigVar;
        long j2;
        long jMax;
        this.zzh = zzhtVar;
        long j3 = 0;
        this.zzp = 0L;
        this.zzo = 0L;
        try {
            URL url = new URL(zzhtVar.zza.toString());
            byte[] bArr = zzhtVar.zzc;
            long j4 = zzhtVar.zze;
            long j5 = zzhtVar.zzf;
            boolean zZza = zzhtVar.zza(1);
            int i = 0;
            while (true) {
                int i2 = i + 1;
                long j6 = j3;
                if (i > 20) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 20);
                    sb.append("Too many redirects: ");
                    sb.append(i2);
                    throw new NoRouteToHostException(sb.toString());
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if (httpURLConnection instanceof HttpsURLConnection) {
                    ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(this.zzc);
                }
                httpURLConnection.setConnectTimeout(this.zzd);
                httpURLConnection.setReadTimeout(this.zze);
                for (Map.Entry entry : this.zzg.zza().entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    j4 = j4;
                }
                long j7 = j4;
                if (j7 == j6) {
                    if (j5 != -1) {
                        j = j6;
                    }
                    httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.zzf);
                    if (!zZza) {
                        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
                    }
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setDoOutput(false);
                    httpURLConnection.connect();
                    responseCode = httpURLConnection.getResponseCode();
                    if (responseCode != 300 && responseCode != 301 && responseCode != 302 && responseCode != 303 && responseCode != 307 && responseCode != 308) {
                        this.zzi = httpURLConnection;
                        try {
                            responseCode2 = httpURLConnection.getResponseCode();
                            this.zzl = responseCode2;
                            if (responseCode2 >= 200 || responseCode2 > 299) {
                                Map<String, List<String>> headerFields = this.zzi.getHeaderFields();
                                zzn();
                                zzigVar = new zzig(this.zzl, null, null, headerFields, zzhtVar, zzfl.zzb);
                                if (this.zzl == 416) {
                                    throw zzigVar;
                                }
                                zzigVar.initCause(new zzhq(2008));
                                throw zzigVar;
                            }
                            if (responseCode2 == 200) {
                                j2 = zzhtVar.zze;
                                if (j2 == j6) {
                                    j2 = j6;
                                }
                            } else {
                                j2 = j6;
                            }
                            this.zzm = j2;
                            if (zzhtVar.zza(1)) {
                                this.zzn = zzhtVar.zzf;
                            } else {
                                long j8 = zzhtVar.zzf;
                                if (j8 != -1) {
                                    this.zzn = j8;
                                } else {
                                    HttpURLConnection httpURLConnection2 = this.zzi;
                                    String headerField2 = httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_LENGTH);
                                    if (TextUtils.isEmpty(headerField2)) {
                                        jMax = -1;
                                    } else {
                                        try {
                                            jMax = Long.parseLong(headerField2);
                                        } catch (NumberFormatException unused) {
                                            StringBuilder sb2 = new StringBuilder(String.valueOf(headerField2).length() + 28);
                                            sb2.append("Unexpected Content-Length [");
                                            sb2.append(headerField2);
                                            sb2.append("]");
                                            String string = sb2.toString();
                                            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
                                            com.google.android.gms.ads.internal.util.client.zzo.zzf(string);
                                            jMax = -1;
                                        }
                                    }
                                    String headerField3 = httpURLConnection2.getHeaderField(HttpHeaders.CONTENT_RANGE);
                                    if (!TextUtils.isEmpty(headerField3)) {
                                        Matcher matcher = zza.matcher(headerField3);
                                        if (matcher.find()) {
                                            try {
                                                long j9 = (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                                                if (jMax < j6) {
                                                    jMax = j9;
                                                } else if (jMax != j9) {
                                                    StringBuilder sb3 = new StringBuilder(String.valueOf(headerField2).length() + 25 + String.valueOf(headerField3).length() + 1);
                                                    sb3.append("Inconsistent headers [");
                                                    sb3.append(headerField2);
                                                    sb3.append("] [");
                                                    sb3.append(headerField3);
                                                    sb3.append("]");
                                                    String string2 = sb3.toString();
                                                    int i4 = com.google.android.gms.ads.internal.util.zze.zza;
                                                    com.google.android.gms.ads.internal.util.client.zzo.zzi(string2);
                                                    jMax = Math.max(jMax, j9);
                                                }
                                            } catch (NumberFormatException unused2) {
                                                StringBuilder sb4 = new StringBuilder(String.valueOf(headerField3).length() + 27);
                                                sb4.append("Unexpected Content-Range [");
                                                sb4.append(headerField3);
                                                sb4.append("]");
                                                String string3 = sb4.toString();
                                                int i5 = com.google.android.gms.ads.internal.util.zze.zza;
                                                com.google.android.gms.ads.internal.util.client.zzo.zzf(string3);
                                            }
                                        }
                                    }
                                    this.zzn = jMax != -1 ? jMax - this.zzm : -1L;
                                }
                            }
                            try {
                                this.zzj = this.zzi.getInputStream();
                                this.zzk = true;
                                zzg(zzhtVar);
                                return this.zzn;
                            } catch (IOException e) {
                                zzn();
                                throw new zzie(e, zzhtVar, 2000, 1);
                            }
                        } catch (IOException e2) {
                            zzn();
                            String string4 = zzhtVar.zza.toString();
                            String.valueOf(string4);
                            throw new zzie("Unable to connect to ".concat(String.valueOf(string4)), e2, zzhtVar, 2000, 1);
                        }
                    }
                    headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    httpURLConnection.disconnect();
                    if (headerField != null) {
                        throw new ProtocolException("Null location redirect");
                    }
                    URL url2 = new URL(url, headerField);
                    protocol = url2.getProtocol();
                    if (!"https".equals(protocol) && !"http".equals(protocol)) {
                        String.valueOf(protocol);
                        throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                    }
                    url = url2;
                    i = i2;
                    j3 = j6;
                    j4 = j7;
                } else {
                    j = j7;
                }
                StringBuilder sb5 = new StringBuilder(String.valueOf(j).length() + 7);
                sb5.append("bytes=");
                sb5.append(j);
                sb5.append("-");
                String string5 = sb5.toString();
                if (j5 != -1) {
                    long j10 = (j + j5) - 1;
                    StringBuilder sb6 = new StringBuilder(string5.length() + String.valueOf(j10).length());
                    sb6.append(string5);
                    sb6.append(j10);
                    string5 = sb6.toString();
                }
                httpURLConnection.setRequestProperty(HttpHeaders.RANGE, string5);
                httpURLConnection.setRequestProperty(HttpHeaders.USER_AGENT, this.zzf);
                if (!zZza) {
                    httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
                }
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.connect();
                responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 300) {
                    this.zzi = httpURLConnection;
                    responseCode2 = httpURLConnection.getResponseCode();
                    this.zzl = responseCode2;
                    if (responseCode2 >= 200) {
                    }
                    Map<String, List<String>> headerFields2 = this.zzi.getHeaderFields();
                    zzn();
                    zzigVar = new zzig(this.zzl, null, null, headerFields2, zzhtVar, zzfl.zzb);
                    if (this.zzl == 416) {
                        throw zzigVar;
                    }
                    zzigVar.initCause(new zzhq(2008));
                    throw zzigVar;
                }
                headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                httpURLConnection.disconnect();
                if (headerField != null) {
                    throw new ProtocolException("Null location redirect");
                }
                URL url3 = new URL(url, headerField);
                protocol = url3.getProtocol();
                if (!"https".equals(protocol)) {
                    String.valueOf(protocol);
                    throw new ProtocolException("Unsupported protocol redirect: ".concat(String.valueOf(protocol)));
                }
                url = url3;
                i = i2;
                j3 = j6;
                j4 = j7;
            }
        } catch (IOException e3) {
            String string6 = zzhtVar.zza.toString();
            String.valueOf(string6);
            throw new zzie("Unable to connect to ".concat(String.valueOf(string6)), e3, zzhtVar, 2000, 1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() throws zzie {
        try {
            InputStream inputStream = this.zzj;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new zzie(e, this.zzh, 2000, 3);
                }
            }
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzi();
            }
            this.zzr.clear();
        } catch (Throwable th) {
            this.zzj = null;
            zzn();
            if (this.zzk) {
                this.zzk = false;
                zzi();
            }
            this.zzr.clear();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        HttpURLConnection httpURLConnection = this.zzi;
        if (httpURLConnection == null) {
            return null;
        }
        return httpURLConnection.getHeaderFields();
    }

    final void zzk(int i) {
        this.zzq = i;
        for (Socket socket : this.zzr) {
            if (!socket.isClosed()) {
                try {
                    socket.setReceiveBufferSize(this.zzq);
                } catch (SocketException e) {
                    int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                    com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to update receive buffer size.", e);
                }
            }
        }
    }

    final /* synthetic */ void zzl(Socket socket) {
        this.zzr.add(socket);
    }

    final /* synthetic */ int zzm() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i, int i2) throws zzie {
        try {
            if (this.zzo != this.zzm) {
                AtomicReference atomicReference = zzb;
                byte[] bArr2 = (byte[]) atomicReference.getAndSet(null);
                if (bArr2 == null) {
                    bArr2 = new byte[4096];
                }
                while (true) {
                    long j = this.zzo;
                    long j2 = this.zzm;
                    if (j == j2) {
                        atomicReference.set(bArr2);
                        break;
                    }
                    int i3 = this.zzj.read(bArr2, 0, (int) Math.min(j2 - j, bArr2.length));
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (i3 == -1) {
                        throw new EOFException();
                    }
                    this.zzo += (long) i3;
                    zzh(i3);
                }
            }
            if (i2 == 0) {
                return 0;
            }
            long j3 = this.zzn;
            if (j3 != -1) {
                long j4 = j3 - this.zzp;
                if (j4 == 0) {
                    return -1;
                }
                i2 = (int) Math.min(i2, j4);
            }
            int i4 = this.zzj.read(bArr, i, i2);
            if (i4 == -1) {
                if (this.zzn == -1) {
                    return -1;
                }
                throw new EOFException();
            }
            this.zzp += (long) i4;
            zzh(i4);
            return i4;
        } catch (IOException e) {
            throw new zzie(e, this.zzh, 2000, 2);
        }
    }
}
