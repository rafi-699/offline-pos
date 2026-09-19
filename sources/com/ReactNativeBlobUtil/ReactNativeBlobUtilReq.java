package com.ReactNativeBlobUtil;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.webkit.CookieManager;
import androidx.exifinterface.media.ExifInterface;
import androidx.webkit.internal.AssetHelper;
import androidx.work.Data;
import com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilDefaultResp;
import com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilFileResp;
import com.bumptech.glide.load.Key;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.common.net.HttpHeaders;
import com.polidea.rxandroidble2.ClientComponent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes2.dex */
public class ReactNativeBlobUtilReq extends BroadcastReceiver implements Runnable {
    Callback callback;
    boolean callbackfired;
    OkHttpClient client;
    long contentLength;
    String customPath;
    String destPath;
    long downloadManagerId;
    private Future<?> future;
    ReadableMap headers;
    String method;
    ReactNativeBlobUtilConfig options;
    String rawRequestBody;
    ReadableArray rawRequestBodyArray;
    ReactNativeBlobUtilBody requestBody;
    RequestType requestType;
    WritableMap respInfo;
    ResponseType responseType;
    String taskId;
    String url;
    public static HashMap<String, Call> taskTable = new HashMap<>();
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> progressReport = new HashMap<>();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> uploadProgressReport = new HashMap<>();
    static ConnectionPool pool = new ConnectionPool();
    ResponseFormat responseFormat = ResponseFormat.Auto;
    boolean timeout = false;
    ArrayList<String> redirects = new ArrayList<>();
    private final int QUERY = 1314;
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1314 && message.getData().getLong("downloadManagerId") == ReactNativeBlobUtilReq.this.downloadManagerId) {
                DownloadManager downloadManager = (DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download");
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(ReactNativeBlobUtilReq.this.downloadManagerId);
                Cursor cursorQuery = downloadManager.query(query);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    long j = cursorQuery.getInt(cursorQuery.getColumnIndex("bytes_so_far"));
                    long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("total_size"));
                    cursorQuery.close();
                    ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilReq.this.taskId);
                    float f = j2 > 0 ? j / j2 : 0.0f;
                    if (reportProgress != null && reportProgress.shouldReport(f)) {
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putString("taskId", String.valueOf(ReactNativeBlobUtilReq.this.taskId));
                        writableMapCreateMap.putString("written", String.valueOf(j));
                        writableMapCreateMap.putString("total", String.valueOf(j2));
                        writableMapCreateMap.putString("chunk", "");
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, writableMapCreateMap);
                    }
                    if (j2 == j) {
                        ReactNativeBlobUtilReq.this.future.cancel(true);
                    }
                }
            }
            return true;
        }
    });

    enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        return builder;
    }

    private boolean shouldTransformFile() {
        if (this.options.transformFile.booleanValue()) {
            return this.options.fileCache.booleanValue() || this.options.path != null;
        }
        return false;
    }

    public ReactNativeBlobUtilReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback) {
        this.method = str2.toUpperCase(Locale.ROOT);
        ReactNativeBlobUtilConfig reactNativeBlobUtilConfig = new ReactNativeBlobUtilConfig(readableMap);
        this.options = reactNativeBlobUtilConfig;
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        this.callbackfired = false;
        if ((reactNativeBlobUtilConfig.fileCache.booleanValue() || this.options.path != null) && !shouldTransformFile()) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        Call call = taskTable.get(str);
        if (call != null) {
            call.cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download")).remove(androidDownloadManagerTaskTable.get(str).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invoke_callback(Object... objArr) {
        if (this.callbackfired) {
            return;
        }
        this.callback.invoke(objArr);
        this.callbackfired = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        OkHttpClient.Builder builderNewBuilder;
        InetAddress byName;
        Context applicationContext = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext();
        if (this.options.addAndroidDownloads != null && this.options.addAndroidDownloads.hasKey("useDownloadManager") && this.options.addAndroidDownloads.getBoolean("useDownloadManager")) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.url));
            if (this.options.addAndroidDownloads.hasKey("notification") && this.options.addAndroidDownloads.getBoolean("notification")) {
                request.setNotificationVisibility(1);
            } else {
                request.setNotificationVisibility(2);
            }
            if (this.options.addAndroidDownloads.hasKey("title")) {
                request.setTitle(this.options.addAndroidDownloads.getString("title"));
            }
            if (this.options.addAndroidDownloads.hasKey("description")) {
                request.setDescription(this.options.addAndroidDownloads.getString("description"));
            }
            if (this.options.addAndroidDownloads.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
                String string = this.options.addAndroidDownloads.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
                File file = new File(string);
                File parentFile = file.getParentFile();
                if (!file.exists() && parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    invoke_callback("Failed to create parent directory of '" + string + "'", null, null);
                    return;
                } else {
                    request.setDestinationUri(Uri.parse("file://" + string));
                    this.customPath = string;
                }
            }
            if (this.options.addAndroidDownloads.hasKey("storeLocal") && this.options.addAndroidDownloads.getBoolean("storeLocal")) {
                String str = ((String) ReactNativeBlobUtilFS.getSystemfolders(ReactNativeBlobUtilImpl.RCTContext).get("DownloadDir")) + UUID.randomUUID().toString();
                File file2 = new File(str);
                File parentFile2 = file2.getParentFile();
                if (!file2.exists() && parentFile2 != null && !parentFile2.exists() && !parentFile2.mkdirs() && !parentFile2.exists()) {
                    invoke_callback("Failed to create parent directory of '" + str + "'", null, null);
                    return;
                } else {
                    request.setDestinationUri(Uri.parse("file://" + str));
                    this.customPath = str;
                }
            }
            if (this.options.addAndroidDownloads.hasKey("mime")) {
                request.setMimeType(this.options.addAndroidDownloads.getString("mime"));
            }
            if (this.options.addAndroidDownloads.hasKey("mediaScannable") && this.options.addAndroidDownloads.getBoolean("mediaScannable")) {
                request.allowScanningByMediaScanner();
            }
            if (Build.VERSION.SDK_INT >= 29 && this.options.addAndroidDownloads.hasKey("storeInDownloads") && this.options.addAndroidDownloads.getBoolean("storeInDownloads")) {
                String string2 = this.options.addAndroidDownloads.getString("title");
                if (string2 == null || string2.isEmpty()) {
                    string2 = UUID.randomUUID().toString();
                }
                if (this.options.appendExt != null && !this.options.appendExt.isEmpty()) {
                    string2 = string2 + "." + this.options.appendExt;
                }
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, string2);
            }
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = this.headers.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                request.addRequestHeader(strNextKey, this.headers.getString(strNextKey));
            }
            try {
                URL url = new URL(this.url);
                request.addRequestHeader(HttpHeaders.COOKIE, CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            long jEnqueue = ((DownloadManager) applicationContext.getSystemService("download")).enqueue(request);
            this.downloadManagerId = jEnqueue;
            androidDownloadManagerTaskTable.put(this.taskId, Long.valueOf(jEnqueue));
            if (Build.VERSION.SDK_INT >= 34) {
                applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
            } else {
                applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            }
            this.future = this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.2
                @Override // java.lang.Runnable
                public void run() {
                    Message messageObtainMessage = ReactNativeBlobUtilReq.this.mHandler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putLong("downloadManagerId", ReactNativeBlobUtilReq.this.downloadManagerId);
                    messageObtainMessage.setData(bundle);
                    messageObtainMessage.what = 1314;
                    ReactNativeBlobUtilReq.this.mHandler.sendMessage(messageObtainMessage);
                }
            }, 0L, 100L, TimeUnit.MILLISECONDS);
            return;
        }
        String md5 = this.taskId;
        String str2 = (this.options.appendExt == null || this.options.appendExt.isEmpty()) ? "" : "." + this.options.appendExt;
        if (this.options.key != null) {
            md5 = ReactNativeBlobUtilUtils.getMD5(this.options.key);
            if (md5 == null) {
                md5 = this.taskId;
            }
            File file3 = new File(ReactNativeBlobUtilFS.getTmpPath(md5) + str2);
            if (file3.exists()) {
                invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, file3.getAbsolutePath());
                return;
            }
        }
        if (this.options.path != null) {
            this.destPath = this.options.path;
        } else if (this.options.fileCache.booleanValue()) {
            this.destPath = ReactNativeBlobUtilFS.getTmpPath(md5) + str2;
        }
        try {
            if (this.options.trusty.booleanValue()) {
                builderNewBuilder = ReactNativeBlobUtilUtils.getUnsafeOkHttpClient(this.client);
            } else {
                builderNewBuilder = this.client.newBuilder();
            }
            OkHttpClient.Builder builder = builderNewBuilder;
            String str3 = this.options.targetHostIp;
            boolean z = (str3 == null || str3.isEmpty()) ? false : true;
            if (this.options.wifiOnly.booleanValue()) {
                if (z) {
                    try {
                        byName = InetAddress.getByName(str3);
                    } catch (UnknownHostException unused) {
                        byName = null;
                    }
                } else {
                    byName = null;
                }
                ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.RCTContext;
                ReactApplicationContext reactApplicationContext2 = ReactNativeBlobUtilImpl.RCTContext;
                ConnectivityManager connectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
                boolean z2 = false;
                for (Network network : connectivityManager.getAllNetworks()) {
                    if (isValidWifiNetwork(connectivityManager, network)) {
                        if (z && networkMatchesTargetIp(connectivityManager, network, str3, byName)) {
                            builder.proxy(Proxy.NO_PROXY);
                            builder.socketFactory(network.getSocketFactory());
                        } else if (z2) {
                            continue;
                        } else {
                            builder.proxy(Proxy.NO_PROXY);
                            builder.socketFactory(network.getSocketFactory());
                            if (z) {
                                z2 = true;
                            }
                        }
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    invoke_callback("No available WiFi connections.", null, null);
                    releaseTaskResource();
                    return;
                }
            }
            Request.Builder builder2 = new Request.Builder();
            try {
                builder2.url(new URL(this.url));
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
            HashMap<String, String> map = new HashMap<>();
            ReadableMap readableMap = this.headers;
            if (readableMap != null) {
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator2 = readableMap.keySetIterator();
                while (readableMapKeySetIteratorKeySetIterator2.hasNextKey()) {
                    String strNextKey2 = readableMapKeySetIteratorKeySetIterator2.nextKey();
                    String string3 = this.headers.getString(strNextKey2);
                    if (strNextKey2.equalsIgnoreCase("RNFB-Response")) {
                        if (string3.equalsIgnoreCase("base64")) {
                            this.responseFormat = ResponseFormat.BASE64;
                        } else if (string3.equalsIgnoreCase(ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8)) {
                            this.responseFormat = ResponseFormat.UTF8;
                        }
                    } else {
                        builder2.header(strNextKey2.toLowerCase(Locale.ROOT), string3);
                        map.put(strNextKey2.toLowerCase(Locale.ROOT), string3);
                    }
                }
            }
            if (this.method.equalsIgnoreCase("post") || this.method.equalsIgnoreCase("put") || this.method.equalsIgnoreCase("patch")) {
                String lowerCase = getHeaderIgnoreCases(map, HttpHeaders.CONTENT_TYPE).toLowerCase(Locale.ROOT);
                if (this.rawRequestBodyArray != null) {
                    this.requestType = RequestType.Form;
                } else if (lowerCase == null || lowerCase.isEmpty()) {
                    if (!lowerCase.equalsIgnoreCase("")) {
                        builder2.header(HttpHeaders.CONTENT_TYPE, "application/octet-stream");
                    }
                    this.requestType = RequestType.SingleFile;
                }
                String str4 = this.rawRequestBody;
                if (str4 != null) {
                    if (str4.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX) || this.rawRequestBody.startsWith(ReactNativeBlobUtilConst.CONTENT_PREFIX)) {
                        this.requestType = RequestType.SingleFile;
                    } else if (lowerCase.toLowerCase(Locale.ROOT).contains(";base64") || lowerCase.toLowerCase(Locale.ROOT).startsWith("application/octet")) {
                        String strReplace = lowerCase.replace(";base64", "").replace(";BASE64", "");
                        if (map.containsKey("content-type")) {
                            map.put("content-type", strReplace);
                        }
                        if (map.containsKey(HttpHeaders.CONTENT_TYPE)) {
                            map.put(HttpHeaders.CONTENT_TYPE, strReplace);
                        }
                        this.requestType = RequestType.SingleFile;
                    } else {
                        this.requestType = RequestType.AsIs;
                    }
                }
            } else {
                this.requestType = RequestType.WithoutBody;
            }
            boolean zEqualsIgnoreCase = getHeaderIgnoreCases(map, HttpHeaders.TRANSFER_ENCODING).equalsIgnoreCase("chunked");
            int i = AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[this.requestType.ordinal()];
            if (i == 1) {
                ReactNativeBlobUtilBody mime = new ReactNativeBlobUtilBody(this.taskId).chunkedEncoding(zEqualsIgnoreCase).setRequestType(this.requestType).setBody(this.rawRequestBody).setMIME(MediaType.parse(getHeaderIgnoreCases(map, "content-type")));
                this.requestBody = mime;
                builder2.method(this.method, mime);
            } else if (i == 2) {
                ReactNativeBlobUtilBody mime2 = new ReactNativeBlobUtilBody(this.taskId).chunkedEncoding(zEqualsIgnoreCase).setRequestType(this.requestType).setBody(this.rawRequestBody).setMIME(MediaType.parse(getHeaderIgnoreCases(map, "content-type")));
                this.requestBody = mime2;
                builder2.method(this.method, mime2);
            } else if (i == 3) {
                ReactNativeBlobUtilBody mime3 = new ReactNativeBlobUtilBody(this.taskId).chunkedEncoding(zEqualsIgnoreCase).setRequestType(this.requestType).setBody(this.rawRequestBodyArray).setMIME(MediaType.parse("multipart/form-data; boundary=" + ("ReactNativeBlobUtil-" + this.taskId)));
                this.requestBody = mime3;
                builder2.method(this.method, mime3);
            } else if (i == 4) {
                if (this.method.equalsIgnoreCase("post") || this.method.equalsIgnoreCase("put") || this.method.equalsIgnoreCase("patch")) {
                    builder2.method(this.method, RequestBody.create((MediaType) null, new byte[0]));
                } else {
                    builder2.method(this.method, null);
                }
            }
            final Request requestBuild = builder2.build();
            builder.addNetworkInterceptor(new Interceptor() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.3
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    ReactNativeBlobUtilReq.this.redirects.add(chain.request().url().getUrl());
                    return chain.proceed(chain.request());
                }
            });
            builder.addInterceptor(new Interceptor() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.4
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    ResponseBody reactNativeBlobUtilDefaultResp;
                    Response responseProceed = null;
                    try {
                        responseProceed = chain.proceed(requestBuild);
                        int i2 = AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType[ReactNativeBlobUtilReq.this.responseType.ordinal()];
                        if (i2 != 1 && i2 == 2) {
                            reactNativeBlobUtilDefaultResp = new ReactNativeBlobUtilFileResp(ReactNativeBlobUtilImpl.RCTContext, ReactNativeBlobUtilReq.this.taskId, responseProceed.body(), ReactNativeBlobUtilReq.this.destPath, ReactNativeBlobUtilReq.this.options.overwrite.booleanValue());
                        } else {
                            reactNativeBlobUtilDefaultResp = new ReactNativeBlobUtilDefaultResp(ReactNativeBlobUtilImpl.RCTContext, ReactNativeBlobUtilReq.this.taskId, responseProceed.body(), ReactNativeBlobUtilReq.this.options.increment.booleanValue());
                        }
                        return responseProceed.newBuilder().body(reactNativeBlobUtilDefaultResp).build();
                    } catch (SocketException unused2) {
                        ReactNativeBlobUtilReq.this.timeout = true;
                        if (responseProceed != null) {
                            responseProceed.close();
                        }
                        return chain.proceed(chain.request());
                    } catch (SocketTimeoutException unused3) {
                        ReactNativeBlobUtilReq.this.timeout = true;
                        if (responseProceed != null) {
                            responseProceed.close();
                        }
                        return chain.proceed(chain.request());
                    } catch (Exception unused4) {
                        if (responseProceed != null) {
                            responseProceed.close();
                        }
                        return chain.proceed(chain.request());
                    }
                }
            });
            if (this.options.timeout >= 0) {
                builder.connectTimeout(this.options.timeout, TimeUnit.MILLISECONDS);
                builder.readTimeout(this.options.timeout, TimeUnit.MILLISECONDS);
            }
            builder.connectionPool(pool);
            builder.retryOnConnectionFailure(false);
            builder.followRedirects(this.options.followRedirect.booleanValue());
            builder.followSslRedirects(this.options.followRedirect.booleanValue());
            builder.retryOnConnectionFailure(true);
            Call callNewCall = enableTls12OnPreLollipop(builder).build().newCall(requestBuild);
            taskTable.put(this.taskId, callNewCall);
            callNewCall.enqueue(new okhttp3.Callback() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.5
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    ReactNativeBlobUtilReq.cancelTask(ReactNativeBlobUtilReq.this.taskId);
                    if (ReactNativeBlobUtilReq.this.respInfo == null) {
                        ReactNativeBlobUtilReq.this.respInfo = Arguments.createMap();
                    }
                    if (iOException.getClass().equals(SocketTimeoutException.class)) {
                        ReactNativeBlobUtilReq.this.respInfo.putBoolean(ClientComponent.NamedSchedulers.TIMEOUT, true);
                        ReactNativeBlobUtilReq.this.invoke_callback("The request timed out.", null, null);
                    } else {
                        ReactNativeBlobUtilReq.this.invoke_callback(iOException.getLocalizedMessage(), null, null);
                    }
                    ReactNativeBlobUtilReq.this.releaseTaskResource();
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    String string4;
                    ReadableMap readableMap2 = ReactNativeBlobUtilReq.this.options.addAndroidDownloads;
                    if (readableMap2 != null) {
                        String string5 = readableMap2.hasKey("title") ? ReactNativeBlobUtilReq.this.options.addAndroidDownloads.getString("title") : "";
                        String string6 = readableMap2.hasKey("description") ? readableMap2.getString("description") : "";
                        if (!readableMap2.hasKey("mime")) {
                            string4 = AssetHelper.DEFAULT_MIME_TYPE;
                        } else {
                            string4 = readableMap2.getString("mime");
                        }
                        String str5 = string4;
                        boolean z3 = readableMap2.hasKey("mediaScannable") ? readableMap2.getBoolean("mediaScannable") : false;
                        boolean z4 = readableMap2.hasKey("notification") ? readableMap2.getBoolean("notification") : false;
                        ReactApplicationContext reactApplicationContext3 = ReactNativeBlobUtilImpl.RCTContext;
                        ReactApplicationContext reactApplicationContext4 = ReactNativeBlobUtilImpl.RCTContext;
                        ((DownloadManager) reactApplicationContext3.getSystemService("download")).addCompletedDownload(string5, string6, z3, str5, ReactNativeBlobUtilReq.this.destPath, ReactNativeBlobUtilReq.this.contentLength, z4);
                    }
                    ReactNativeBlobUtilReq.this.done(response);
                }
            });
        } catch (Exception e3) {
            e3.printStackTrace();
            releaseTaskResource();
            invoke_callback("ReactNativeBlobUtil request error: " + e3.getMessage() + e3.getCause());
        }
    }

    /* JADX INFO: renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType;
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType;

        static {
            int[] iArr = new int[ResponseType.values().length];
            $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType = iArr;
            try {
                iArr[ResponseType.KeepInMemory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType[ResponseType.FileStorage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[RequestType.values().length];
            $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType = iArr2;
            try {
                iArr2[RequestType.SingleFile.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[RequestType.AsIs.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[RequestType.Form.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[RequestType.WithoutBody.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        ReactNativeBlobUtilBody reactNativeBlobUtilBody = this.requestBody;
        if (reactNativeBlobUtilBody != null) {
            reactNativeBlobUtilBody.clearRequestBody();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x0135 A[Catch: IOException -> 0x0209, TryCatch #1 {IOException -> 0x0209, blocks: (B:33:0x00ee, B:35:0x00f8, B:36:0x0114, B:38:0x011b, B:39:0x011f, B:40:0x0135, B:42:0x0143, B:44:0x0147, B:46:0x015c, B:47:0x015f, B:49:0x016d, B:50:0x0170, B:59:0x0189, B:57:0x0187, B:56:0x0184, B:61:0x01a6, B:62:0x01ad, B:63:0x01ae, B:66:0x01b6, B:68:0x01c6, B:70:0x01e2, B:72:0x01e8, B:73:0x01f9), top: B:81:0x00ee, inners: #0, #4 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0143 A[Catch: IOException -> 0x0209, TryCatch #1 {IOException -> 0x0209, blocks: (B:33:0x00ee, B:35:0x00f8, B:36:0x0114, B:38:0x011b, B:39:0x011f, B:40:0x0135, B:42:0x0143, B:44:0x0147, B:46:0x015c, B:47:0x015f, B:49:0x016d, B:50:0x0170, B:59:0x0189, B:57:0x0187, B:56:0x0184, B:61:0x01a6, B:62:0x01ad, B:63:0x01ae, B:66:0x01b6, B:68:0x01c6, B:70:0x01e2, B:72:0x01e8, B:73:0x01f9), top: B:81:0x00ee, inners: #0, #4 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0147 A[Catch: IOException -> 0x0209, TryCatch #1 {IOException -> 0x0209, blocks: (B:33:0x00ee, B:35:0x00f8, B:36:0x0114, B:38:0x011b, B:39:0x011f, B:40:0x0135, B:42:0x0143, B:44:0x0147, B:46:0x015c, B:47:0x015f, B:49:0x016d, B:50:0x0170, B:59:0x0189, B:57:0x0187, B:56:0x0184, B:61:0x01a6, B:62:0x01ad, B:63:0x01ae, B:66:0x01b6, B:68:0x01c6, B:70:0x01e2, B:72:0x01e8, B:73:0x01f9), top: B:81:0x00ee, inners: #0, #4 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x015c A[Catch: IOException -> 0x0209, TRY_LEAVE, TryCatch #1 {IOException -> 0x0209, blocks: (B:33:0x00ee, B:35:0x00f8, B:36:0x0114, B:38:0x011b, B:39:0x011f, B:40:0x0135, B:42:0x0143, B:44:0x0147, B:46:0x015c, B:47:0x015f, B:49:0x016d, B:50:0x0170, B:59:0x0189, B:57:0x0187, B:56:0x0184, B:61:0x01a6, B:62:0x01ad, B:63:0x01ae, B:66:0x01b6, B:68:0x01c6, B:70:0x01e2, B:72:0x01e8, B:73:0x01f9), top: B:81:0x00ee, inners: #0, #4 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x01a6 A[Catch: IOException -> 0x0209, TryCatch #1 {IOException -> 0x0209, blocks: (B:33:0x00ee, B:35:0x00f8, B:36:0x0114, B:38:0x011b, B:39:0x011f, B:40:0x0135, B:42:0x0143, B:44:0x0147, B:46:0x015c, B:47:0x015f, B:49:0x016d, B:50:0x0170, B:59:0x0189, B:57:0x0187, B:56:0x0184, B:61:0x01a6, B:62:0x01ad, B:63:0x01ae, B:66:0x01b6, B:68:0x01c6, B:70:0x01e2, B:72:0x01e8, B:73:0x01f9), top: B:81:0x00ee, inners: #0, #4 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x01ae A[Catch: IOException -> 0x0209, TRY_LEAVE, TryCatch #1 {IOException -> 0x0209, blocks: (B:33:0x00ee, B:35:0x00f8, B:36:0x0114, B:38:0x011b, B:39:0x011f, B:40:0x0135, B:42:0x0143, B:44:0x0147, B:46:0x015c, B:47:0x015f, B:49:0x016d, B:50:0x0170, B:59:0x0189, B:57:0x0187, B:56:0x0184, B:61:0x01a6, B:62:0x01ad, B:63:0x01ae, B:66:0x01b6, B:68:0x01c6, B:70:0x01e2, B:72:0x01e8, B:73:0x01f9), top: B:81:0x00ee, inners: #0, #4 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x01b6 A[Catch: IOException -> 0x0209, TRY_ENTER, TRY_LEAVE, TryCatch #1 {IOException -> 0x0209, blocks: (B:33:0x00ee, B:35:0x00f8, B:36:0x0114, B:38:0x011b, B:39:0x011f, B:40:0x0135, B:42:0x0143, B:44:0x0147, B:46:0x015c, B:47:0x015f, B:49:0x016d, B:50:0x0170, B:59:0x0189, B:57:0x0187, B:56:0x0184, B:61:0x01a6, B:62:0x01ad, B:63:0x01ae, B:66:0x01b6, B:68:0x01c6, B:70:0x01e2, B:72:0x01e8, B:73:0x01f9), top: B:81:0x00ee, inners: #0, #4 }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void done(Response response) throws IOException {
        byte[] bArrBytes;
        File file;
        FileOutputStream fileOutputStream;
        boolean zIsBlobResponse = isBlobResponse(response);
        WritableMap responseInfo = getResponseInfo(response, zIsBlobResponse);
        emitStateEvent(responseInfo.copy());
        emitStateEvent(getResponseInfo(response, zIsBlobResponse));
        int i = AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType[this.responseType.ordinal()];
        String strString = null;
        if (i != 1) {
            if (i == 2) {
                ResponseBody responseBodyBody = response.body();
                try {
                    responseBodyBody.bytes();
                } catch (Exception unused) {
                }
                try {
                    ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp = (ReactNativeBlobUtilFileResp) responseBodyBody;
                    if (reactNativeBlobUtilFileResp != null && !reactNativeBlobUtilFileResp.isDownloadComplete()) {
                        invoke_callback("Download interrupted.", responseInfo.copy());
                    } else {
                        String strReplace = this.destPath.replace("?append=true", "");
                        this.destPath = strReplace;
                        invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, strReplace, responseInfo.copy());
                    }
                } catch (ClassCastException unused2) {
                    if (responseBodyBody != null) {
                        try {
                            boolean z = responseBodyBody.getBodySource().getBufferField().size() > 0;
                            boolean z2 = responseBodyBody.getContentLength() > 0;
                            if (z && z2) {
                                strString = responseBodyBody.string();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        invoke_callback("Unexpected FileStorage response file: " + strString, responseInfo.copy());
                        return;
                    }
                    invoke_callback("Unexpected FileStorage response with no file.", responseInfo.copy());
                    return;
                }
            } else {
                try {
                    invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(response.body().bytes(), Key.STRING_CHARSET_NAME), responseInfo.copy());
                } catch (IOException unused3) {
                    invoke_callback("ReactNativeBlobUtil failed to encode response data to UTF8 string.", responseInfo.copy());
                }
            }
        } else if (zIsBlobResponse) {
            try {
                if (this.options.auto.booleanValue()) {
                    String tmpPath = ReactNativeBlobUtilFS.getTmpPath(this.taskId);
                    InputStream inputStreamByteStream = response.body().byteStream();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(tmpPath));
                    byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                    while (true) {
                        int i2 = inputStreamByteStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        } else {
                            fileOutputStream2.write(bArr, 0, i2);
                        }
                    }
                    inputStreamByteStream.close();
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, tmpPath, responseInfo.copy());
                } else {
                    bArrBytes = response.body().bytes();
                    if (shouldTransformFile()) {
                        if (ReactNativeBlobUtilFileTransformer.sharedFileTransformer != null) {
                            throw new IllegalStateException("Write file with transform was specified but the shared file transformer is not set");
                        }
                        this.destPath = this.destPath.replace("?append=true", "");
                        file = new File(this.destPath);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                fileOutputStream.write(ReactNativeBlobUtilFileTransformer.sharedFileTransformer.onWriteFile(bArrBytes));
                                fileOutputStream.close();
                                invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, this.destPath, responseInfo.copy());
                                return;
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            invoke_callback("Error from file transformer:" + e2.getLocalizedMessage(), responseInfo.copy());
                            return;
                        }
                    }
                    if (this.responseFormat == ResponseFormat.BASE64) {
                        invoke_callback(null, "base64", Base64.encodeToString(bArrBytes, 2), responseInfo.copy());
                        return;
                    }
                    try {
                        Charset charsetForName = Charset.forName(Key.STRING_CHARSET_NAME);
                        charsetForName.newDecoder().decode(ByteBuffer.wrap(bArrBytes));
                        invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(bArrBytes, charsetForName));
                    } catch (CharacterCodingException unused4) {
                        if (this.responseFormat == ResponseFormat.UTF8) {
                            invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(bArrBytes), responseInfo.copy());
                        } else {
                            invoke_callback(null, "base64", Base64.encodeToString(bArrBytes, 2), responseInfo.copy());
                        }
                    }
                    invoke_callback("ReactNativeBlobUtil failed to encode response data to BASE64 string.", responseInfo.copy());
                }
            } catch (IOException unused5) {
                invoke_callback("ReactNativeBlobUtil failed to encode response data to BASE64 string.", responseInfo.copy());
            }
        } else {
            bArrBytes = response.body().bytes();
            if (shouldTransformFile()) {
                if (ReactNativeBlobUtilFileTransformer.sharedFileTransformer != null) {
                    throw new IllegalStateException("Write file with transform was specified but the shared file transformer is not set");
                }
                this.destPath = this.destPath.replace("?append=true", "");
                file = new File(this.destPath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(ReactNativeBlobUtilFileTransformer.sharedFileTransformer.onWriteFile(bArrBytes));
                fileOutputStream.close();
                invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, this.destPath, responseInfo.copy());
                return;
            }
            if (this.responseFormat == ResponseFormat.BASE64) {
                invoke_callback(null, "base64", Base64.encodeToString(bArrBytes, 2), responseInfo.copy());
                return;
            } else {
                Charset charsetForName2 = Charset.forName(Key.STRING_CHARSET_NAME);
                charsetForName2.newDecoder().decode(ByteBuffer.wrap(bArrBytes));
                invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(bArrBytes, charsetForName2));
            }
            invoke_callback("ReactNativeBlobUtil failed to encode response data to BASE64 string.", responseInfo.copy());
        }
        response.body().close();
        releaseTaskResource();
    }

    public static ReactNativeBlobUtilProgressConfig getReportProgress(String str) {
        if (progressReport.containsKey(str)) {
            return progressReport.get(str);
        }
        return null;
    }

    public static ReactNativeBlobUtilProgressConfig getReportUploadProgress(String str) {
        if (uploadProgressReport.containsKey(str)) {
            return uploadProgressReport.get(str);
        }
        return null;
    }

    private WritableMap getResponseInfo(Response response, boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("status", response.code());
        writableMapCreateMap.putString(ServerProtocol.DIALOG_PARAM_STATE, ExifInterface.GPS_MEASUREMENT_2D);
        writableMapCreateMap.putString("taskId", this.taskId);
        writableMapCreateMap.putBoolean(ClientComponent.NamedSchedulers.TIMEOUT, this.timeout);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        for (int i = 0; i < response.headers().size(); i++) {
            writableMapCreateMap2.putString(response.headers().name(i), response.headers().value(i));
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<String> it = this.redirects.iterator();
        while (it.hasNext()) {
            writableArrayCreateArray.pushString(it.next());
        }
        writableMapCreateMap.putArray("redirects", writableArrayCreateArray);
        writableMapCreateMap.putMap("headers", writableMapCreateMap2);
        Headers headers = response.headers();
        if (z) {
            writableMapCreateMap.putString("respType", "blob");
            return writableMapCreateMap;
        }
        if (getHeaderIgnoreCases(headers, "content-type").equalsIgnoreCase("text/")) {
            writableMapCreateMap.putString("respType", "text");
            return writableMapCreateMap;
        }
        if (getHeaderIgnoreCases(headers, "content-type").contains("application/json")) {
            writableMapCreateMap.putString("respType", "json");
            return writableMapCreateMap;
        }
        writableMapCreateMap.putString("respType", "");
        return writableMapCreateMap;
    }

    private boolean isBlobResponse(Response response) {
        boolean z;
        String headerIgnoreCases = getHeaderIgnoreCases(response.headers(), HttpHeaders.CONTENT_TYPE);
        boolean zEqualsIgnoreCase = headerIgnoreCases.equalsIgnoreCase("text/");
        boolean zEqualsIgnoreCase2 = headerIgnoreCases.equalsIgnoreCase("application/json");
        if (this.options.binaryContentTypes == null) {
            z = false;
            break;
        }
        int i = 0;
        while (true) {
            if (i >= this.options.binaryContentTypes.size()) {
                z = false;
                break;
            }
            if (headerIgnoreCases.toLowerCase(Locale.ROOT).contains(this.options.binaryContentTypes.getString(i).toLowerCase(Locale.ROOT))) {
                z = true;
                break;
            }
            i++;
        }
        return (zEqualsIgnoreCase2 && zEqualsIgnoreCase) || z;
    }

    private String getHeaderIgnoreCases(Headers headers, String str) {
        String str2 = headers.get(str);
        if (str2 != null) {
            return str2;
        }
        return headers.get(str.toLowerCase(Locale.ROOT)) == null ? "" : headers.get(str.toLowerCase(Locale.ROOT));
    }

    private String getHeaderIgnoreCases(HashMap<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = map.get(str.toLowerCase(Locale.ROOT));
        return str3 == null ? "" : str3;
    }

    private void emitStateEvent(WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_HTTP_STATE, writableMap);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00cf  */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String string;
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
            Context applicationContext = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext();
            if (intent.getExtras().getLong("extra_download_id") == this.downloadManagerId) {
                releaseTaskResource();
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(this.downloadManagerId);
                DownloadManager downloadManager = (DownloadManager) applicationContext.getSystemService("download");
                downloadManager.query(query);
                Cursor cursorQuery = downloadManager.query(query);
                if (cursorQuery == null) {
                    invoke_callback("Download manager failed to download from  " + this.url + ". Query was unsuccessful ", null, null);
                    return;
                }
                try {
                    if (cursorQuery.moveToFirst()) {
                        int i = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                        if (i == 16) {
                            invoke_callback("Download manager failed to download from  " + this.url + ". Status Code = " + i, null, null);
                            if (cursorQuery != null) {
                                cursorQuery.close();
                                return;
                            }
                            return;
                        }
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("local_uri"));
                        if (string2 != null) {
                            Cursor cursorQuery2 = applicationContext.getContentResolver().query(Uri.parse(string2), new String[]{"_data"}, null, null, null);
                            if (cursorQuery2 != null) {
                                cursorQuery2.moveToFirst();
                                string = cursorQuery2.getString(0);
                                cursorQuery2.close();
                            } else {
                                string = null;
                            }
                        } else {
                            string = null;
                        }
                    } else {
                        string = null;
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                    if (this.options.addAndroidDownloads.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH) || this.options.addAndroidDownloads.hasKey("storeLocal")) {
                        try {
                            String str = this.customPath;
                            if (!new File(str).exists()) {
                                throw new Exception("Download manager download failed, the file does not downloaded to destination.");
                            }
                            invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, str);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            invoke_callback(e.getLocalizedMessage(), null);
                            return;
                        }
                    }
                    if (Build.VERSION.SDK_INT < 29 || !this.options.addAndroidDownloads.hasKey("storeInDownloads") || !this.options.addAndroidDownloads.getBoolean("storeInDownloads")) {
                        if (string == null) {
                            invoke_callback("Download manager could not resolve downloaded file path.", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, null);
                            return;
                        } else {
                            invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, string);
                            return;
                        }
                    }
                    Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(this.downloadManagerId);
                    if (uriForDownloadedFile == null) {
                        invoke_callback("Download manager could not resolve downloaded file uri.", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, null);
                    } else {
                        invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, uriForDownloadedFile.toString());
                    }
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                        throw th;
                    }
                    throw th;
                }
            }
        }
    }

    private boolean isValidWifiNetwork(ConnectivityManager connectivityManager, Network network) {
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
        if (networkCapabilities == null || networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }

    private boolean networkMatchesTargetIp(ConnectivityManager connectivityManager, Network network, String str, InetAddress inetAddress) {
        List<RouteInfo> routes;
        Inet4Address dhcpServerAddress;
        LinkProperties linkProperties = connectivityManager.getLinkProperties(network);
        if (linkProperties == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 30 && (dhcpServerAddress = linkProperties.getDhcpServerAddress()) != null && dhcpServerAddress.getHostAddress().equals(str)) {
            return true;
        }
        if (inetAddress != null && (routes = linkProperties.getRoutes()) != null) {
            for (RouteInfo routeInfo : routes) {
                if (!routeInfo.isDefaultRoute() && routeInfo.matches(inetAddress)) {
                    return true;
                }
            }
        }
        return false;
    }
}
