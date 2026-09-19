package androidx.credentials.provider;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BiometricPromptResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\tJ\u0013\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0015"}, d2 = {"Landroidx/credentials/provider/BiometricPromptResult;", "", "authenticationResult", "Landroidx/credentials/provider/AuthenticationResult;", "authenticationError", "Landroidx/credentials/provider/AuthenticationError;", "<init>", "(Landroidx/credentials/provider/AuthenticationResult;Landroidx/credentials/provider/AuthenticationError;)V", "(Landroidx/credentials/provider/AuthenticationError;)V", "(Landroidx/credentials/provider/AuthenticationResult;)V", "getAuthenticationResult", "()Landroidx/credentials/provider/AuthenticationResult;", "getAuthenticationError", "()Landroidx/credentials/provider/AuthenticationError;", "isSuccessful", "", "()Z", "equals", "other", "hashCode", "", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BiometricPromptResult {
    private final AuthenticationError authenticationError;
    private final AuthenticationResult authenticationResult;
    private final boolean isSuccessful;

    public BiometricPromptResult() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public BiometricPromptResult(AuthenticationResult authenticationResult, AuthenticationError authenticationError) {
        this.authenticationResult = authenticationResult;
        this.authenticationError = authenticationError;
        this.isSuccessful = authenticationResult != null;
    }

    public /* synthetic */ BiometricPromptResult(AuthenticationResult authenticationResult, AuthenticationError authenticationError, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : authenticationResult, (i & 2) != 0 ? null : authenticationError);
    }

    public final AuthenticationResult getAuthenticationResult() {
        return this.authenticationResult;
    }

    public final AuthenticationError getAuthenticationError() {
        return this.authenticationError;
    }

    /* JADX INFO: renamed from: isSuccessful, reason: from getter */
    public final boolean getIsSuccessful() {
        return this.isSuccessful;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BiometricPromptResult(AuthenticationError authenticationError) {
        this(null, authenticationError);
        Intrinsics.checkNotNullParameter(authenticationError, "authenticationError");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BiometricPromptResult(AuthenticationResult authenticationResult) {
        this(authenticationResult, null);
        Intrinsics.checkNotNullParameter(authenticationResult, "authenticationResult");
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BiometricPromptResult) {
            BiometricPromptResult biometricPromptResult = (BiometricPromptResult) other;
            if (this.isSuccessful == biometricPromptResult.isSuccessful && Intrinsics.areEqual(this.authenticationResult, biometricPromptResult.authenticationResult) && Intrinsics.areEqual(this.authenticationError, biometricPromptResult.authenticationError)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.isSuccessful), this.authenticationResult, this.authenticationError);
    }
}
