package cn.lailaixiong.funnyprint.ReactNaitveModule;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.media3.extractor.ts.PsExtractor;
import cn.lailaixiong.funnyprint.util.ImageUtil;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.Promise;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: CaptureModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"cn/lailaixiong/funnyprint/ReactNaitveModule/CaptureModule$capture2$1$1", "Landroid/webkit/WebViewClient;", "onReceivedError", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "onPageFinished", "url", "", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureModule$capture2$1$1 extends WebViewClient {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ WebView $webView;

    CaptureModule$capture2$1$1(Promise promise, WebView webView) {
        this.$promise = promise;
        this.$webView = webView;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Log.e("WebViewCapture", "onReceivedError: " + ((Object) (error != null ? error.getDescription() : null)));
        this.$promise.reject("E_WEBVIEW_ERROR", "WebView received an error: " + ((Object) (error != null ? error.getDescription() : null)));
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Handler handler = new Handler(Looper.getMainLooper());
        final WebView webView = this.$webView;
        final Promise promise = this.$promise;
        handler.postDelayed(new Runnable() { // from class: cn.lailaixiong.funnyprint.ReactNaitveModule.CaptureModule$capture2$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CaptureModule$capture2$1$1.onPageFinished$lambda$1(webView, promise);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$1(final WebView webView, final Promise promise) {
        webView.evaluateJavascript("(function() {\n    var element = document.querySelector('p'); // 将 'selector' 替换为您的元素选择器\n    if (element) {\n        var ratio = window.devicePixelRatio;\n        var rect = element.getBoundingClientRect();\n        \n        return JSON.stringify({\n            left: rect.left,\n            top: rect.top,\n            width: rect.width,\n            height: rect.height,\n            ratio: ratio,\n        });\n    }\n    return null;\n})();", new ValueCallback() { // from class: cn.lailaixiong.funnyprint.ReactNaitveModule.CaptureModule$capture2$1$1$$ExternalSyntheticLambda1
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) throws JSONException {
                CaptureModule$capture2$1$1.onPageFinished$lambda$1$lambda$0(webView, promise, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$1$lambda$0(WebView webView, Promise promise, String str) throws JSONException {
        if (!Intrinsics.areEqual(str, "null")) {
            Intrinsics.checkNotNull(str);
            Double doubleOrNull = StringsKt.toDoubleOrNull(str);
            if (doubleOrNull != null) {
                doubleOrNull.doubleValue();
            }
            JSONObject jSONObject = new JSONObject(StringsKt.replace$default(StringsKt.trim(str, Typography.quote), "\\\"", "\"", false, 4, (Object) null));
            double d = jSONObject.getDouble("left");
            double d2 = jSONObject.getDouble("top");
            double d3 = jSONObject.getDouble("width");
            double d4 = jSONObject.getDouble("height");
            double d5 = jSONObject.getDouble("ratio");
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(webView.getWidth(), webView.getHeight(), Bitmap.Config.ARGB_8888);
            webView.draw(new Canvas(bitmapCreateBitmap));
            int i = (int) d5;
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, ((int) d) * i, ((int) d2) * i, ((int) d3) * i, ((int) d4) * i);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap2, "createBitmap(...)");
            Bitmap bitmapRotateImage = ImageUtil.INSTANCE.rotateImage(bitmapCreateBitmap2, 90);
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapRotateImage, 384, (bitmapRotateImage.getHeight() * 384) / bitmapRotateImage.getWidth(), true);
            promise.resolve(ImageUtil.INSTANCE.bitmapToBase64String(bitmapCreateScaledBitmap) + "|" + ImageUtil.INSTANCE.byteBufferToBase64String(ImageUtil.INSTANCE.bitmapToBinaryBuffer(bitmapCreateScaledBitmap, PsExtractor.VIDEO_STREAM_MASK)));
            return;
        }
        promise.reject("E_LAYOUT", "WebView js layout was not properly measured.");
    }
}
