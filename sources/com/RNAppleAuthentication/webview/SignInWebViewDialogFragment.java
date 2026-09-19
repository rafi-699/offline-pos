package com.RNAppleAuthentication.webview;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.fragment.app.DialogFragment;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.RNAppleAuthentication.FormInterceptorInterface;
import com.RNAppleAuthentication.R;
import com.RNAppleAuthentication.SignInWithAppleResult;
import com.RNAppleAuthentication.SignInWithAppleService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInWebViewDialogFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u000e\u001a\u00020\t2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006!"}, d2 = {"Lcom/RNAppleAuthentication/webview/SignInWebViewDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", SignInWebViewDialogFragment.AUTHENTICATION_ATTEMPT_KEY, "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "callback", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "webViewIfCreated", "Landroid/webkit/WebView;", "getWebViewIfCreated", "()Landroid/webkit/WebView;", "configure", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onStart", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCallback", "result", "Companion", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignInWebViewDialogFragment extends DialogFragment {
    private static final String AUTHENTICATION_ATTEMPT_KEY = "authenticationAttempt";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FULL_SCREEN_KEY = "fullScreen";
    private static final String WEB_VIEW_KEY = "webView";
    private SignInWithAppleService.AuthenticationAttempt authenticationAttempt;
    private Function1<? super SignInWithAppleResult, Unit> callback;

    /* JADX INFO: compiled from: SignInWebViewDialogFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/RNAppleAuthentication/webview/SignInWebViewDialogFragment$Companion;", "", "<init>", "()V", "AUTHENTICATION_ATTEMPT_KEY", "", "FULL_SCREEN_KEY", "WEB_VIEW_KEY", "newInstance", "Lcom/RNAppleAuthentication/webview/SignInWebViewDialogFragment;", SignInWebViewDialogFragment.AUTHENTICATION_ATTEMPT_KEY, "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", SignInWebViewDialogFragment.FULL_SCREEN_KEY, "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SignInWebViewDialogFragment newInstance(SignInWithAppleService.AuthenticationAttempt authenticationAttempt, boolean fullScreen) {
            Intrinsics.checkNotNullParameter(authenticationAttempt, "authenticationAttempt");
            SignInWebViewDialogFragment signInWebViewDialogFragment = new SignInWebViewDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelable(SignInWebViewDialogFragment.AUTHENTICATION_ATTEMPT_KEY, authenticationAttempt);
            bundle.putBoolean(SignInWebViewDialogFragment.FULL_SCREEN_KEY, fullScreen);
            signInWebViewDialogFragment.setArguments(bundle);
            return signInWebViewDialogFragment;
        }
    }

    private final WebView getWebViewIfCreated() {
        View view = getView();
        if (view instanceof WebView) {
            return (WebView) view;
        }
        return null;
    }

    public final void configure(Function1<? super SignInWithAppleResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        SignInWithAppleService.AuthenticationAttempt authenticationAttempt = arguments != null ? (SignInWithAppleService.AuthenticationAttempt) arguments.getParcelable(AUTHENTICATION_ATTEMPT_KEY) : null;
        Intrinsics.checkNotNull(authenticationAttempt);
        this.authenticationAttempt = authenticationAttempt;
        Bundle arguments2 = getArguments();
        boolean z = arguments2 != null ? arguments2.getBoolean(FULL_SCREEN_KEY, true) : true;
        setStyle(0, R.style.sign_in_with_apple_button_DialogTheme);
        if (z) {
            return;
        }
        setStyle(1, R.style.sign_in_with_apple_button_DialogTheme_Floating);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        WebView webView = new WebView(requireContext());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        SignInWithAppleService.AuthenticationAttempt authenticationAttempt = this.authenticationAttempt;
        SignInWithAppleService.AuthenticationAttempt authenticationAttempt2 = null;
        if (authenticationAttempt == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AUTHENTICATION_ATTEMPT_KEY);
            authenticationAttempt = null;
        }
        webView.addJavascriptInterface(new FormInterceptorInterface(authenticationAttempt.getState(), new SignInWebViewDialogFragment$onCreateView$formInterceptorInterface$1(this)), FormInterceptorInterface.NAME);
        SignInWithAppleService.AuthenticationAttempt authenticationAttempt3 = this.authenticationAttempt;
        if (authenticationAttempt3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(AUTHENTICATION_ATTEMPT_KEY);
            authenticationAttempt3 = null;
        }
        webView.setWebViewClient(new SignInWebViewClient(authenticationAttempt3, FormInterceptorInterface.INSTANCE.getJS_TO_INJECT()));
        if (savedInstanceState != null) {
            Bundle bundle = savedInstanceState.getBundle(WEB_VIEW_KEY);
            if (bundle != null) {
                webView.restoreState(bundle);
            }
        } else {
            SignInWithAppleService.AuthenticationAttempt authenticationAttempt4 = this.authenticationAttempt;
            if (authenticationAttempt4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(AUTHENTICATION_ATTEMPT_KEY);
            } else {
                authenticationAttempt2 = authenticationAttempt4;
            }
            webView.loadUrl(authenticationAttempt2.getAuthenticationUri());
        }
        return webView;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Bundle bundle = new Bundle();
        WebView webViewIfCreated = getWebViewIfCreated();
        if (webViewIfCreated != null) {
            webViewIfCreated.saveState(bundle);
        }
        Unit unit = Unit.INSTANCE;
        outState.putBundle(WEB_VIEW_KEY, bundle);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -1);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        onCallback(SignInWithAppleResult.Cancel.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCallback(SignInWithAppleResult result) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.dismiss();
        }
        Function1<? super SignInWithAppleResult, Unit> function1 = this.callback;
        if (function1 == null) {
            return;
        }
        function1.invoke(result);
    }
}
