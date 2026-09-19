package cn.lailaixiong.funnyprint.ReactNaitveModule;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bumptech.glide.load.Key;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CaptureModule.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcn/lailaixiong/funnyprint/ReactNaitveModule/CaptureModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getName", "", "takeViewShot", "", "viewId", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "capture1", "html", "capture2", "capture3", "app_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaptureModule extends ReactContextBaseJavaModule {
    private final ReactApplicationContext reactContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptureModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "CaptureModule";
    }

    @ReactMethod
    public final void takeViewShot(final int viewId, final Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        UIManagerModule uIManagerModule = (UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class);
        if (uIManagerModule != null) {
            uIManagerModule.addUIBlock(new UIBlock() { // from class: cn.lailaixiong.funnyprint.ReactNaitveModule.CaptureModule$$ExternalSyntheticLambda0
                @Override // com.facebook.react.uimanager.UIBlock
                public final void execute(NativeViewHierarchyManager nativeViewHierarchyManager) throws Throwable {
                    CaptureModule.takeViewShot$lambda$1(viewId, promise, nativeViewHierarchyManager);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void takeViewShot$lambda$1(int i, Promise promise, NativeViewHierarchyManager nativeViewHierarchyManager) throws Throwable {
        Intrinsics.checkNotNullParameter(nativeViewHierarchyManager, "nativeViewHierarchyManager");
        Bitmap bitmap = null;
        try {
            try {
                View viewResolveView = nativeViewHierarchyManager.resolveView(i);
                if (viewResolveView != null && viewResolveView.getWidth() != 0 && viewResolveView.getHeight() != 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(viewResolveView.getWidth(), viewResolveView.getHeight(), Bitmap.Config.ARGB_8888);
                    try {
                        viewResolveView.draw(new Canvas(bitmapCreateBitmap));
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                            bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                            String strEncodeToString = Base64.encodeToString(byteArrayOutputStream2.toByteArray(), 2);
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            promise.resolve(strEncodeToString);
                            if (bitmapCreateBitmap != null) {
                                bitmapCreateBitmap.recycle();
                                return;
                            }
                            return;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(byteArrayOutputStream, th);
                                throw th2;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        bitmap = bitmapCreateBitmap;
                        Log.e("CaptureModule", "Failed to capture view.", e);
                        promise.reject("E_CAPTURE_FAILED", "Failed to capture view.", e);
                        if (bitmap != null) {
                            bitmap.recycle();
                            return;
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        bitmap = bitmapCreateBitmap;
                        if (bitmap != null) {
                            bitmap.recycle();
                        }
                        throw th;
                    }
                }
                promise.reject("E_LAYOUT", "View has zero width or height.");
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    @ReactMethod
    public final void capture1(final String html, final Promise promise) {
        Intrinsics.checkNotNullParameter(html, "html");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: cn.lailaixiong.funnyprint.ReactNaitveModule.CaptureModule$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureModule.capture1$lambda$2(this.f$0, html, promise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void capture1$lambda$2(CaptureModule captureModule, String str, Promise promise) {
        WebView.enableSlowWholeDocumentDraw();
        WebView webView = new WebView(captureModule.reactContext);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        webView.setLayerType(1, null);
        webView.measure(View.MeasureSpec.makeMeasureSpec(captureModule.reactContext.getResources().getDisplayMetrics().widthPixels, 1073741824), View.MeasureSpec.makeMeasureSpec(10000, 1073741824));
        webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());
        webView.setWebViewClient(new CaptureModule$capture1$1$1(promise, webView));
        webView.loadDataWithBaseURL(null, str, "text/html", Key.STRING_CHARSET_NAME, null);
    }

    @ReactMethod
    public final void capture2(final String html, final Promise promise) {
        Intrinsics.checkNotNullParameter(html, "html");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: cn.lailaixiong.funnyprint.ReactNaitveModule.CaptureModule$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureModule.capture2$lambda$3(this.f$0, html, promise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void capture2$lambda$3(CaptureModule captureModule, String str, Promise promise) {
        WebView.enableSlowWholeDocumentDraw();
        WebView webView = new WebView(captureModule.reactContext);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        webView.setLayerType(1, null);
        int i = captureModule.reactContext.getResources().getDisplayMetrics().widthPixels;
        webView.measure(View.MeasureSpec.makeMeasureSpec(8000, 1073741824), View.MeasureSpec.makeMeasureSpec(3000, 1073741824));
        webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());
        webView.setWebViewClient(new CaptureModule$capture2$1$1(promise, webView));
        webView.loadDataWithBaseURL(null, str, "text/html", Key.STRING_CHARSET_NAME, null);
    }

    @ReactMethod
    public final void capture3(final String html, final Promise promise) {
        Intrinsics.checkNotNullParameter(html, "html");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity currentActivity = this.reactContext.getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new Runnable() { // from class: cn.lailaixiong.funnyprint.ReactNaitveModule.CaptureModule$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    CaptureModule.capture3$lambda$4(this.f$0, html, promise);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void capture3$lambda$4(CaptureModule captureModule, String str, Promise promise) {
        WebView.enableSlowWholeDocumentDraw();
        WebView webView = new WebView(captureModule.reactContext);
        webView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setJavaScriptEnabled(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        webView.setLayerType(1, null);
        int i = captureModule.reactContext.getResources().getDisplayMetrics().widthPixels;
        webView.measure(View.MeasureSpec.makeMeasureSpec(1664, 1073741824), View.MeasureSpec.makeMeasureSpec(10000, 1073741824));
        webView.layout(0, 0, webView.getMeasuredWidth(), webView.getMeasuredHeight());
        webView.setWebViewClient(new CaptureModule$capture3$1$1(promise, webView));
        webView.loadDataWithBaseURL(null, str, "text/html", Key.STRING_CHARSET_NAME, null);
    }
}
