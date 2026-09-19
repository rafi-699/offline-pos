package com.RNAppleAuthentication.webview;

import com.RNAppleAuthentication.SignInWithAppleResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInWebViewDialogFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* synthetic */ class SignInWebViewDialogFragment$onCreateView$formInterceptorInterface$1 extends FunctionReferenceImpl implements Function1<SignInWithAppleResult, Unit> {
    SignInWebViewDialogFragment$onCreateView$formInterceptorInterface$1(Object obj) {
        super(1, obj, SignInWebViewDialogFragment.class, "onCallback", "onCallback(Lcom/RNAppleAuthentication/SignInWithAppleResult;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SignInWithAppleResult signInWithAppleResult) {
        invoke2(signInWithAppleResult);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SignInWithAppleResult p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((SignInWebViewDialogFragment) this.receiver).onCallback(p0);
    }
}
