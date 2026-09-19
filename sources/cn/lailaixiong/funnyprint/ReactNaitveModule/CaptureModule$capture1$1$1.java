package cn.lailaixiong.funnyprint.ReactNaitveModule;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
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

/* JADX INFO: compiled from: CaptureModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"cn/lailaixiong/funnyprint/ReactNaitveModule/CaptureModule$capture1$1$1", "Landroid/webkit/WebViewClient;", "onReceivedError", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "onPageFinished", "url", "", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureModule$capture1$1$1 extends WebViewClient {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ WebView $webView;

    CaptureModule$capture1$1$1(Promise promise, WebView webView) {
        this.$promise = promise;
        this.$webView = webView;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        Log.e("WebViewCapture", "onReceivedError: " + ((Object) (error != null ? error.getDescription() : null)));
        this.$promise.reject("E_WEBVIEW_ERROR", "WebView received an error: " + ((Object) (error != null ? error.getDescription() : null)));
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(final WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        Handler handler = new Handler(Looper.getMainLooper());
        final WebView webView = this.$webView;
        final Promise promise = this.$promise;
        handler.postDelayed(new Runnable() { // from class: cn.lailaixiong.funnyprint.ReactNaitveModule.CaptureModule$capture1$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                CaptureModule$capture1$1$1.onPageFinished$lambda$0(view, webView, promise);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPageFinished$lambda$0(WebView webView, WebView webView2, Promise promise) {
        webView.measure(View.MeasureSpec.makeMeasureSpec(webView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (webView.getMeasuredWidth() > 0 && webView.getMeasuredHeight() > 0) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(webView.getMeasuredWidth(), webView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
            webView2.draw(new Canvas(bitmapCreateBitmap));
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapCreateBitmap, 384, (bitmapCreateBitmap.getHeight() * 384) / bitmapCreateBitmap.getWidth(), true);
            Intrinsics.checkNotNullExpressionValue(bitmapCreateScaledBitmap, "createScaledBitmap(...)");
            promise.resolve(ImageUtil.INSTANCE.bitmapToBase64String(bitmapCreateScaledBitmap) + "|" + ImageUtil.INSTANCE.byteBufferToBase64String(ImageUtil.INSTANCE.bitmapToBinaryBuffer(bitmapCreateScaledBitmap, PsExtractor.VIDEO_STREAM_MASK)));
            return;
        }
        promise.reject("E_LAYOUT", "WebView layout was not properly measured.");
    }
}
