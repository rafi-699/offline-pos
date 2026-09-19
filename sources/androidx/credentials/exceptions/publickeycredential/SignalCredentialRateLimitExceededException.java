package androidx.credentials.exceptions.publickeycredential;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SignalCredentialRateLimitExceededException.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Landroidx/credentials/exceptions/publickeycredential/SignalCredentialRateLimitExceededException;", "Landroidx/credentials/exceptions/publickeycredential/SignalCredentialStateException;", "retryMillis", "", "errorMessage", "", "<init>", "(JLjava/lang/CharSequence;)V", "getRetryMillis", "()J", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignalCredentialRateLimitExceededException extends SignalCredentialStateException {
    public static final String TYPE_SIGNAL_CREDENTIAL_STATE_RATE_LIMIT_EXCEEDED_EXCEPTION = "androidx.credentials.SignalCredentialStateException.RATE_LIMIT_EXCEEDED";
    private final long retryMillis;

    public SignalCredentialRateLimitExceededException(long j) {
        this(j, null, 2, null);
    }

    public /* synthetic */ SignalCredentialRateLimitExceededException(long j, CharSequence charSequence, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, (i & 2) != 0 ? null : charSequence);
    }

    public final long getRetryMillis() {
        return this.retryMillis;
    }

    public SignalCredentialRateLimitExceededException(long j, CharSequence charSequence) {
        super(TYPE_SIGNAL_CREDENTIAL_STATE_RATE_LIMIT_EXCEEDED_EXCEPTION, charSequence);
        this.retryMillis = j;
    }
}
