package com.swmansion.worklets;

import android.content.res.AssetManager;
import android.os.Build;
import com.facebook.jni.HybridData;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ScriptBufferWrapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0003H\u0082 J\u0011\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0003H\u0082 J\u0019\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0082 R\u0010\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/swmansion/worklets/ScriptBufferWrapper;", "", "uri", "", "assetManager", "Landroid/content/res/AssetManager;", "<init>", "(Ljava/lang/String;Landroid/content/res/AssetManager;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybridFromAssets", "assetURL", "initHybridFromFile", "fileName", "initHybridFromString", "script", "url", "Companion", "react-native-worklets_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScriptBufferWrapper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final HybridData mHybridData;

    private final native HybridData initHybridFromAssets(AssetManager assetManager, String assetURL);

    private final native HybridData initHybridFromFile(String fileName);

    private final native HybridData initHybridFromString(String script, String url);

    public ScriptBufferWrapper(String uri, AssetManager assetManager) {
        HybridData hybridDataInitHybridFromString;
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        if (StringsKt.startsWith$default(uri, "file://", false, 2, (Object) null)) {
            String strSubstring = uri.substring("file://".length());
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            hybridDataInitHybridFromString = initHybridFromFile(strSubstring);
        } else if (StringsKt.startsWith$default(uri, "assets://", false, 2, (Object) null)) {
            String strSubstring2 = uri.substring("assets://".length());
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            hybridDataInitHybridFromString = initHybridFromAssets(assetManager, strSubstring2);
        } else {
            try {
                hybridDataInitHybridFromString = initHybridFromString(INSTANCE.downloadScript(uri), uri);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.mHybridData = hybridDataInitHybridFromString;
    }

    /* JADX INFO: compiled from: ScriptBufferWrapper.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/swmansion/worklets/ScriptBufferWrapper$Companion;", "", "<init>", "()V", "downloadScript", "", "url", "readBytes", "", "inputStream", "Ljava/io/InputStream;", "react-native-worklets_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String downloadScript(String url) throws IOException {
            byte[] bytes;
            URLConnection uRLConnectionOpenConnection = new URL(url).openConnection();
            Intrinsics.checkNotNull(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
            try {
                if (Build.VERSION.SDK_INT >= 33) {
                    bytes = httpURLConnection.getInputStream().readAllBytes();
                    Intrinsics.checkNotNullExpressionValue(bytes, "readAllBytes(...)");
                } else {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
                    bytes = readBytes(inputStream);
                }
                Charset UTF_8 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                return new String(bytes, UTF_8);
            } finally {
                httpURLConnection.disconnect();
            }
        }

        private final byte[] readBytes(InputStream inputStream) throws IOException {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                Ref.IntRef intRef = new Ref.IntRef();
                while (true) {
                    int i = inputStream.read(bArr);
                    intRef.element = i;
                    if (i != -1) {
                        byteArrayOutputStream.write(bArr, 0, intRef.element);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
                        return byteArray;
                    }
                }
            } finally {
                inputStream.close();
            }
        }
    }
}
