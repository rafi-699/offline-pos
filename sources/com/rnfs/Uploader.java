package com.rnfs;

import android.os.AsyncTask;
import android.webkit.MimeTypeMap;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NoSuchKeyException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.google.common.net.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class Uploader extends AsyncTask<UploadParams, int[], UploadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    private UploadParams mParams;
    private UploadResult res;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public UploadResult doInBackground(UploadParams... uploadParamsArr) {
        this.mParams = uploadParamsArr[0];
        this.res = new UploadResult();
        new Thread(new Runnable() { // from class: com.rnfs.Uploader.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Uploader uploader = Uploader.this;
                    uploader.upload(uploader.mParams, Uploader.this.res);
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                } catch (Exception e) {
                    Uploader.this.res.exception = e;
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:104:0x034c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0351  */
    /* JADX WARN: Code duplicated, block: B:108:0x0356  */
    /* JADX WARN: Code duplicated, block: B:110:0x035b  */
    public void upload(UploadParams uploadParams, UploadResult uploadResult) throws Exception {
        DataOutputStream dataOutputStream;
        BufferedInputStream bufferedInputStream;
        HttpURLConnection httpURLConnection;
        BufferedReader bufferedReader;
        long j;
        HttpURLConnection httpURLConnection2;
        long j2;
        String string;
        String string2;
        String mimeType;
        String str = "filename";
        String str2 = "name";
        try {
            Object[] array = uploadParams.files.toArray();
            boolean z = uploadParams.binaryStreamOnly;
            HttpURLConnection httpURLConnection3 = (HttpURLConnection) uploadParams.src.openConnection();
            boolean z2 = true;
            try {
                httpURLConnection3.setDoOutput(true);
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = uploadParams.headers.keySetIterator();
                httpURLConnection3.setRequestMethod(uploadParams.method);
                if (!z) {
                    httpURLConnection3.setRequestProperty(HttpHeaders.CONTENT_TYPE, "multipart/form-data;boundary=*****");
                }
                while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                    String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                    httpURLConnection3.setRequestProperty(strNextKey, uploadParams.headers.getString(strNextKey));
                }
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator2 = uploadParams.fields.keySetIterator();
                String str3 = "";
                while (true) {
                    boolean z3 = z2;
                    if (!readableMapKeySetIteratorKeySetIterator2.hasNextKey()) {
                        break;
                    }
                    String strNextKey2 = readableMapKeySetIteratorKeySetIterator2.nextKey();
                    str3 = str3 + "--*****\r\nContent-Disposition: form-data; name=\"" + strNextKey2 + "\"\r\n\r\n" + uploadParams.fields.getString(strNextKey2) + "\r\n";
                    z2 = z3;
                    z = z;
                    readableMapKeySetIteratorKeySetIterator2 = readableMapKeySetIteratorKeySetIterator2;
                    httpURLConnection = httpURLConnection3;
                    dataOutputStream = null;
                    bufferedInputStream = null;
                    bufferedReader = null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
                boolean z4 = z;
                String[] strArr = new String[array.length];
                Iterator<ReadableMap> it = uploadParams.files.iterator();
                String str4 = "" + str3;
                int i = 0;
                String str5 = str3;
                long j3 = 0;
                while (true) {
                    j = j3;
                    if (!it.hasNext()) {
                        break;
                    }
                    try {
                        ReadableMap next = it.next();
                        try {
                            string = next.getString(str2);
                            string2 = next.getString(str);
                            mimeType = next.getString("filetype");
                        } catch (NoSuchKeyException unused) {
                            string = next.getString(str2);
                            string2 = next.getString(str);
                            mimeType = getMimeType(next.getString("filepath"));
                        }
                        String str6 = string;
                        String str7 = str;
                        String str8 = string2;
                        String str9 = str2;
                        httpURLConnection2 = httpURLConnection3;
                        try {
                            long length = new File(next.getString("filepath")).length();
                            long length2 = j + length;
                            if (!z4) {
                                String str10 = "--*****\r\nContent-Disposition: form-data; name=\"" + str6 + "\"; filename=\"" + str8 + "\"\r\nContent-Type: " + mimeType + "\r\n";
                                if (array.length - 1 == i) {
                                    length2 += (long) "\r\n--*****--\r\n".length();
                                }
                                String str11 = "Content-length: " + length + "\r\n";
                                strArr[i] = str10 + str11 + "\r\n";
                                str4 = str4 + str10 + str11 + "\r\n";
                            }
                            j3 = length2;
                            i++;
                            str = str7;
                            str2 = str9;
                            httpURLConnection3 = httpURLConnection2;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection2 = httpURLConnection3;
                    }
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    dataOutputStream = null;
                    bufferedInputStream = null;
                    bufferedReader = null;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    if (dataOutputStream != null) {
                        dataOutputStream.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
                httpURLConnection2 = httpURLConnection3;
                try {
                    if (this.mParams.onUploadBegin != null) {
                        this.mParams.onUploadBegin.onUploadBegin();
                    }
                    if (z4) {
                        httpURLConnection3 = httpURLConnection2;
                    } else {
                        int length3 = (int) (j + ((long) (str4.length() + (array.length * "\r\n".length()))));
                        httpURLConnection3 = httpURLConnection2;
                        httpURLConnection3.setRequestProperty("Content-length", "" + length3);
                        httpURLConnection3.setFixedLengthStreamingMode(length3);
                    }
                    httpURLConnection3.connect();
                    dataOutputStream = new DataOutputStream(httpURLConnection3.getOutputStream());
                    try {
                        WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(dataOutputStream);
                        if (!z4) {
                            dataOutputStream.writeBytes(str5);
                        }
                        int i2 = 0;
                        int i3 = 0;
                        for (ReadableMap readableMap : uploadParams.files) {
                            if (!z4) {
                                dataOutputStream.writeBytes(strArr[i2]);
                            }
                            File file = new File(readableMap.getString("filepath"));
                            long length4 = file.length();
                            long jCeil = (long) Math.ceil(length4 / 100.0f);
                            FileInputStream fileInputStream = new FileInputStream(file);
                            FileChannel channel = fileInputStream.getChannel();
                            long j4 = 0;
                            while (j4 < length4) {
                                long j5 = jCeil;
                                long jTransferTo = channel.transferTo(j4, j5, writableByteChannelNewChannel);
                                j4 += jTransferTo;
                                if (this.mParams.onUploadProgress != null) {
                                    int i4 = (int) (((long) i3) + jTransferTo);
                                    j2 = j;
                                    this.mParams.onUploadProgress.onUploadProgress((int) j2, i4);
                                    i3 = i4;
                                } else {
                                    j2 = j;
                                }
                                i2 = i2;
                                j = j2;
                                jCeil = j5;
                            }
                            int i5 = i2;
                            long j6 = j;
                            if (!z4) {
                                dataOutputStream.writeBytes("\r\n");
                            }
                            i2 = i5 + 1;
                            fileInputStream.close();
                            j = j6;
                        }
                        if (!z4) {
                            dataOutputStream.writeBytes("\r\n--*****--\r\n");
                        }
                        dataOutputStream.flush();
                        dataOutputStream.close();
                        bufferedInputStream = new BufferedInputStream(httpURLConnection3.getInputStream());
                        try {
                            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(bufferedInputStream));
                            try {
                                WritableMap writableMapCreateMap = Arguments.createMap();
                                for (Map.Entry<String, List<String>> entry : httpURLConnection3.getHeaderFields().entrySet()) {
                                    writableMapCreateMap.putString(entry.getKey(), entry.getValue().get(0));
                                }
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String line = bufferedReader2.readLine();
                                    if (line == null) {
                                        break;
                                    } else {
                                        sb.append(line).append("\n");
                                    }
                                }
                                String string3 = sb.toString();
                                int responseCode = httpURLConnection3.getResponseCode();
                                this.res.headers = writableMapCreateMap;
                                this.res.body = string3;
                                this.res.statusCode = responseCode;
                                if (httpURLConnection3 != null) {
                                    httpURLConnection3.disconnect();
                                }
                                dataOutputStream.close();
                                bufferedInputStream.close();
                                bufferedReader2.close();
                            } catch (Throwable th3) {
                                th = th3;
                                bufferedReader = bufferedReader2;
                                httpURLConnection = httpURLConnection3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            httpURLConnection = httpURLConnection3;
                            bufferedReader = null;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        httpURLConnection = httpURLConnection3;
                        bufferedInputStream = null;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    httpURLConnection3 = httpURLConnection2;
                    httpURLConnection = httpURLConnection3;
                    dataOutputStream = null;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        } catch (Throwable th8) {
            th = th8;
            dataOutputStream = null;
            bufferedInputStream = null;
            httpURLConnection = null;
        }
    }

    protected String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase()) : null;
        return mimeTypeFromExtension == null ? "*/*" : mimeTypeFromExtension;
    }

    protected void stop() {
        this.mAbort.set(true);
    }
}
