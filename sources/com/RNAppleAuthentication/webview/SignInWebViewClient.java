package com.RNAppleAuthentication.webview;

import android.os.Handler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.browser.trusted.sharing.ShareTarget;
import com.RNAppleAuthentication.SignInWithAppleService;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SignInWebViewClient.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/RNAppleAuthentication/webview/SignInWebViewClient;", "Landroid/webkit/WebViewClient;", "attempt", "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "javascriptToInject", "", "<init>", "(Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;Ljava/lang/String;)V", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "setMainHandler", "(Landroid/os/Handler;)V", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", ViewHierarchyConstants.VIEW_KEY, "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignInWebViewClient extends WebViewClient {
    private final SignInWithAppleService.AuthenticationAttempt attempt;
    private final String javascriptToInject;
    private Handler mainHandler;

    public SignInWebViewClient(SignInWithAppleService.AuthenticationAttempt attempt, String javascriptToInject) {
        Intrinsics.checkNotNullParameter(attempt, "attempt");
        Intrinsics.checkNotNullParameter(javascriptToInject, "javascriptToInject");
        this.attempt = attempt;
        this.javascriptToInject = javascriptToInject;
        this.mainHandler = new Handler();
    }

    public final Handler getMainHandler() {
        return this.mainHandler;
    }

    public final void setMainHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.mainHandler = handler;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(final WebView view, WebResourceRequest request) {
        if (Intrinsics.areEqual(request != null ? request.getMethod() : null, ShareTarget.METHOD_POST)) {
            String string = request.getUrl().toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (StringsKt.contains$default((CharSequence) string, (CharSequence) this.attempt.getRedirectUri(), false, 2, (Object) null)) {
                try {
                    Thread.currentThread().interrupt();
                } catch (Exception unused) {
                }
                this.mainHandler.post(new Runnable() { // from class: com.RNAppleAuthentication.webview.SignInWebViewClient$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SignInWebViewClient.shouldInterceptRequest$lambda$0(view, this);
                    }
                });
            }
        }
        return super.shouldInterceptRequest(view, request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shouldInterceptRequest$lambda$0(WebView webView, SignInWebViewClient signInWebViewClient) {
        if (webView != null) {
            webView.stopLoading();
        }
        if (webView != null) {
            webView.loadUrl("javascript:" + signInWebViewClient.javascriptToInject);
        }
    }
}
