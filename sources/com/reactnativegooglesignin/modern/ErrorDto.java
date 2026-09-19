package com.reactnativegooglesignin.modern;

import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: compiled from: ErrorDto.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/reactnativegooglesignin/modern/ErrorDto;", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "errCodeFallback", "", "<init>", "(Ljava/lang/Exception;Ljava/lang/String;)V", "code", "getCode", "()Ljava/lang/String;", "message", "getMessage", "react-native-google-signin_google-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ErrorDto {
    private final String code;
    private final String message;

    public ErrorDto(Exception e, String errCodeFallback) {
        String statusCodeString;
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(errCodeFallback, "errCodeFallback");
        String localizedMessage = e.getLocalizedMessage();
        localizedMessage = localizedMessage == null ? e.getMessage() : localizedMessage;
        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            int statusCode = apiException.getStatusCode();
            if (localizedMessage != null && localizedMessage.length() > 10) {
                statusCodeString = new Regex(statusCode + ": ").replaceFirst(localizedMessage, "");
            } else {
                statusCodeString = GoogleSignInStatusCodes.getStatusCodeString(statusCode);
                Intrinsics.checkNotNullExpressionValue(statusCodeString, "getStatusCodeString(...)");
            }
            this.code = String.valueOf((statusCode == 12501 || apiException.getStatus().isCanceled()) ? 12501 : statusCode);
            this.message = statusCodeString;
            return;
        }
        if (e instanceof UnsupportedApiCallException) {
            this.code = errCodeFallback;
            this.message = localizedMessage + " Make sure you have the latest version of Google Play Services installed.";
        } else {
            this.code = errCodeFallback;
            this.message = localizedMessage == null ? e.toString() : localizedMessage;
        }
    }

    public final String getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
