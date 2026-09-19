package androidx.credentials;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClearCredentialStateRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0013\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Landroidx/credentials/ClearCredentialStateRequest;", "", "requestType", "", "<init>", "(Ljava/lang/String;)V", "getRequestType", "()Ljava/lang/String;", "requestBundle", "Landroid/os/Bundle;", "getRequestBundle", "()Landroid/os/Bundle;", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClearCredentialStateRequest {
    private static final String BUNDLE_KEY_CLEAR_RESTORE_CREDENTIAL_REQUEST = "androidx.credentials.BUNDLE_KEY_CLEAR_RESTORE_CREDENTIAL_REQUEST";
    public static final String TYPE_CLEAR_CREDENTIAL_STATE = "androidx.credentials.TYPE_CLEAR_CREDENTIAL_STATE";
    public static final String TYPE_CLEAR_RESTORE_CREDENTIAL = "androidx.credentials.TYPE_CLEAR_RESTORE_CREDENTIAL";
    private final Bundle requestBundle;
    private final String requestType;

    public ClearCredentialStateRequest() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public ClearCredentialStateRequest(String requestType) {
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        this.requestType = requestType;
        Bundle bundle = new Bundle();
        this.requestBundle = bundle;
        if (!Intrinsics.areEqual(requestType, TYPE_CLEAR_CREDENTIAL_STATE) && !Intrinsics.areEqual(requestType, TYPE_CLEAR_RESTORE_CREDENTIAL)) {
            throw new IllegalArgumentException("The request type " + requestType + " is not supported.");
        }
        if (Intrinsics.areEqual(requestType, TYPE_CLEAR_RESTORE_CREDENTIAL)) {
            bundle.putBoolean(BUNDLE_KEY_CLEAR_RESTORE_CREDENTIAL_REQUEST, true);
        }
    }

    public /* synthetic */ ClearCredentialStateRequest(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TYPE_CLEAR_CREDENTIAL_STATE : str);
    }

    public final String getRequestType() {
        return this.requestType;
    }

    public final Bundle getRequestBundle() {
        return this.requestBundle;
    }
}
