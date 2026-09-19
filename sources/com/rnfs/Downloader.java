package com.rnfs;

import android.os.AsyncTask;
import android.util.Log;
import com.brentvatne.exoplayer.ReactExoplayerView;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class Downloader extends AsyncTask<DownloadParams, long[], DownloadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    private DownloadParams mParam;
    DownloadResult res;

    protected void onPostExecute(Exception exc) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public DownloadResult doInBackground(DownloadParams... downloadParamsArr) {
        this.mParam = downloadParamsArr[0];
        this.res = new DownloadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Downloader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Downloader downloader = Downloader.this;
                    downloader.download(downloader.mParam, Downloader.this.res);
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                } catch (Exception e) {
                    Downloader.this.res.exception = e;
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x01da  */
    /* JADX WARN: Code duplicated, block: B:78:0x01df  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e9  */
    public void download(DownloadParams downloadParams, DownloadResult downloadResult) throws Exception {
        HttpURLConnection httpURLConnection;
        BufferedInputStream bufferedInputStream;
        int i;
        long j;
        long j2;
        int i2;
        int i3;
        FileOutputStream fileOutputStream = null;
        try {
            httpURLConnection = (HttpURLConnection) downloadParams.src.openConnection();
            try {
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = downloadParams.headers.keySetIterator();
                while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    httpURLConnection.setRequestProperty(strNextKey, downloadParams.headers.getString(strNextKey));
                }
                httpURLConnection.setConnectTimeout(downloadParams.connectionTimeout);
                httpURLConnection.setReadTimeout(downloadParams.readTimeout);
                httpURLConnection.connect();
                int responseCode = httpURLConnection.getResponseCode();
                long contentLength = getContentLength(httpURLConnection);
                if (responseCode != 200 && (responseCode == 301 || responseCode == 302 || responseCode == 307 || responseCode == 308)) {
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    httpURLConnection.disconnect();
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(headerField).openConnection();
                    try {
                        httpURLConnection2.setConnectTimeout(5000);
                        httpURLConnection2.connect();
                        int responseCode2 = httpURLConnection2.getResponseCode();
                        contentLength = getContentLength(httpURLConnection2);
                        responseCode = responseCode2;
                        httpURLConnection = httpURLConnection2;
                        if (responseCode >= 200) {
                            bufferedInputStream = null;
                        } else {
                            bufferedInputStream = null;
                        }
                        downloadResult.statusCode = responseCode;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            return;
                        }
                        return;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = null;
                        httpURLConnection = httpURLConnection2;
                    }
                } else {
                    if (responseCode >= 200 || responseCode >= 300) {
                        bufferedInputStream = null;
                    } else {
                        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                        HashMap map = new HashMap();
                        Iterator<Map.Entry<String, List<String>>> it = headerFields.entrySet().iterator();
                        while (true) {
                            i = 0;
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry<String, List<String>> next = it.next();
                            String key = next.getKey();
                            String str = next.getValue().get(0);
                            if (key != null && str != null) {
                                map.put(key, str);
                            }
                        }
                        if (this.mParam.onDownloadBegin != null) {
                            this.mParam.onDownloadBegin.onDownloadBegin(responseCode, contentLength, map);
                        }
                        bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream(), 8192);
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(downloadParams.dest);
                            try {
                                byte[] bArr = new byte[8192];
                                boolean z = this.mParam.onDownloadProgress != null;
                                long j3 = 0;
                                long j4 = 0;
                                double d = ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE;
                                while (true) {
                                    int i4 = bufferedInputStream.read(bArr);
                                    int i5 = i;
                                    if (i4 != -1) {
                                        if (this.mAbort.get()) {
                                            throw new Exception("Download has been aborted");
                                        }
                                        boolean z2 = z;
                                        long j5 = j4 + ((long) i4);
                                        if (z2) {
                                            if (downloadParams.progressInterval > 0) {
                                                long jCurrentTimeMillis = System.currentTimeMillis();
                                                if (jCurrentTimeMillis - j3 > downloadParams.progressInterval) {
                                                    long[] jArr = new long[2];
                                                    jArr[i5] = contentLength;
                                                    jArr[1] = j5;
                                                    publishProgress(jArr);
                                                    j3 = jCurrentTimeMillis;
                                                }
                                                j = contentLength;
                                                i3 = i4;
                                                j2 = j5;
                                            } else if (downloadParams.progressDivider <= 0.0f) {
                                                long[] jArr2 = new long[2];
                                                jArr2[i5] = contentLength;
                                                jArr2[1] = j5;
                                                publishProgress(jArr2);
                                                j = contentLength;
                                                i2 = i4;
                                                j2 = j5;
                                            } else {
                                                i2 = i4;
                                                j2 = j5;
                                                double dRound = Math.round((j2 * 100.0d) / contentLength);
                                                j = contentLength;
                                                if (dRound % ((double) downloadParams.progressDivider) == ReactExoplayerView.DEFAULT_MIN_BUFFER_MEMORY_RESERVE && (dRound != d || j2 == j)) {
                                                    Log.d("Downloader", "EMIT: " + String.valueOf(dRound) + ", TOTAL:" + String.valueOf(j2));
                                                    long[] jArr3 = new long[2];
                                                    jArr3[i5] = j;
                                                    jArr3[1] = j2;
                                                    publishProgress(jArr3);
                                                    d = dRound;
                                                }
                                            }
                                            fileOutputStream2.write(bArr, i5, i3);
                                            j4 = j2;
                                            z = z2;
                                            i = i5;
                                            contentLength = j;
                                        } else {
                                            j = contentLength;
                                            j2 = j5;
                                            i2 = i4;
                                        }
                                        i3 = i2;
                                        fileOutputStream2.write(bArr, i5, i3);
                                        j4 = j2;
                                        z = z2;
                                        i = i5;
                                        contentLength = j;
                                    } else {
                                        fileOutputStream2.flush();
                                        downloadResult.bytesWritten = j4;
                                        fileOutputStream = fileOutputStream2;
                                        break;
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    downloadResult.statusCode = responseCode;
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                        return;
                    }
                    return;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection = null;
            bufferedInputStream = null;
        }
        if (fileOutputStream != null) {
            fileOutputStream.close();
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        throw th;
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getContentLengthLong();
    }

    protected void stop() {
        this.mAbort.set(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onProgressUpdate(long[]... jArr) {
        super.onProgressUpdate((Object[]) jArr);
        if (this.mParam.onDownloadProgress != null) {
            DownloadParams.OnDownloadProgress onDownloadProgress = this.mParam.onDownloadProgress;
            long[] jArr2 = jArr[0];
            onDownloadProgress.onDownloadProgress(jArr2[0], jArr2[1]);
        }
    }
}
