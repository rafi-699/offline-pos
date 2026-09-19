package com.RNAppleAuthentication;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInWithAppleCallback.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toFunction", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "Lcom/RNAppleAuthentication/SignInWithAppleCallback;", "invertase_react-native-apple-authentication_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class SignInWithAppleCallbackKt {
    public static final Function1<SignInWithAppleResult, Unit> toFunction(final SignInWithAppleCallback signInWithAppleCallback) {
        Intrinsics.checkNotNullParameter(signInWithAppleCallback, "<this>");
        return new Function1() { // from class: com.RNAppleAuthentication.SignInWithAppleCallbackKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SignInWithAppleCallbackKt.toFunction$lambda$0(signInWithAppleCallback, (SignInWithAppleResult) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit toFunction$lambda$0(SignInWithAppleCallback signInWithAppleCallback, SignInWithAppleResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result instanceof SignInWithAppleResult.Success) {
            SignInWithAppleResult.Success success = (SignInWithAppleResult.Success) result;
            signInWithAppleCallback.onSignInWithAppleSuccess(success.getCode(), success.getId_token(), success.getState(), success.getUser());
        } else if (result instanceof SignInWithAppleResult.Failure) {
            signInWithAppleCallback.onSignInWithAppleFailure(((SignInWithAppleResult.Failure) result).getError());
        } else {
            if (!(result instanceof SignInWithAppleResult.Cancel)) {
                throw new NoWhenBranchMatchedException();
            }
            signInWithAppleCallback.onSignInWithAppleCancel();
        }
        return Unit.INSTANCE;
    }
}
