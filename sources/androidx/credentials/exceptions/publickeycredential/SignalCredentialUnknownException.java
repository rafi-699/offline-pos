package androidx.credentials.exceptions.publickeycredential;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SignalCredentialUnknownException.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Landroidx/credentials/exceptions/publickeycredential/SignalCredentialUnknownException;", "Landroidx/credentials/exceptions/publickeycredential/SignalCredentialStateException;", "errorMessage", "", "<init>", "(Ljava/lang/CharSequence;)V", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignalCredentialUnknownException extends SignalCredentialStateException {
    public static final String TYPE_SIGNAL_CREDENTIAL_STATE_UNKNOWN_EXCEPTION = "androidx.credentials.SignalCredentialStateException.TYPE_UNKNOWN";

    public SignalCredentialUnknownException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ SignalCredentialUnknownException(CharSequence charSequence, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : charSequence);
    }

    public SignalCredentialUnknownException(CharSequence charSequence) {
        super(TYPE_SIGNAL_CREDENTIAL_STATE_UNKNOWN_EXCEPTION, charSequence);
    }
}
