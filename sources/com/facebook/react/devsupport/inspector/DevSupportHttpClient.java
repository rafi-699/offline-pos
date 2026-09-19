package com.facebook.react.devsupport.inspector;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: DevSupportHttpClient.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0007J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0007J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0007R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/facebook/react/devsupport/inspector/DevSupportHttpClient;", "", "<init>", "()V", "customHeaders", "Ljava/util/concurrent/ConcurrentHashMap;", "", "headerInterceptor", "Lokhttp3/Interceptor;", "httpClient", "Lokhttp3/OkHttpClient;", "getHttpClient", "()Lokhttp3/OkHttpClient;", "websocketClient", "getWebsocketClient", "addRequestHeader", "", "name", "value", "removeRequestHeader", "httpScheme", "host", "wsScheme", "ReactAndroid_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DevSupportHttpClient {
    public static final DevSupportHttpClient INSTANCE = new DevSupportHttpClient();
    private static final ConcurrentHashMap<String, String> customHeaders = new ConcurrentHashMap<>();
    private static final Interceptor headerInterceptor;
    private static final OkHttpClient httpClient;
    private static final OkHttpClient websocketClient;

    private DevSupportHttpClient() {
    }

    static {
        Interceptor interceptor = new Interceptor() { // from class: com.facebook.react.devsupport.inspector.DevSupportHttpClient$$ExternalSyntheticLambda0
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return DevSupportHttpClient.headerInterceptor$lambda$0(chain);
            }
        };
        headerInterceptor = interceptor;
        OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(5L, TimeUnit.SECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MINUTES).build();
        httpClient = okHttpClientBuild;
        websocketClient = okHttpClientBuild.newBuilder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Response headerInterceptor$lambda$0(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request.Builder builderNewBuilder = chain.request().newBuilder();
        for (Map.Entry<String, String> entry : customHeaders.entrySet()) {
            builderNewBuilder.header(entry.getKey(), entry.getValue());
        }
        return chain.proceed(builderNewBuilder.build());
    }

    public final OkHttpClient getHttpClient() {
        return httpClient;
    }

    public final OkHttpClient getWebsocketClient() {
        return websocketClient;
    }

    @JvmStatic
    public static final void addRequestHeader(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        customHeaders.put(name, value);
    }

    @JvmStatic
    public static final void removeRequestHeader(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        customHeaders.remove(name);
    }

    @JvmStatic
    public static final String httpScheme(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return StringsKt.endsWith$default(host, ":443", false, 2, (Object) null) ? "https" : "http";
    }

    @JvmStatic
    public static final String wsScheme(String host) {
        Intrinsics.checkNotNullParameter(host, "host");
        return StringsKt.endsWith$default(host, ":443", false, 2, (Object) null) ? "wss" : "ws";
    }
}
