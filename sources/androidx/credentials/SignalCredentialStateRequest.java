package androidx.credentials;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignalCredentialStateRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B-\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0011"}, d2 = {"Landroidx/credentials/SignalCredentialStateRequest;", "", "type", "", "requestJson", "requestData", "Landroid/os/Bundle;", "origin", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V", "getType", "()Ljava/lang/String;", "getRequestJson", "getRequestData", "()Landroid/os/Bundle;", "getOrigin", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SignalCredentialStateRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SIGNAL_ALL_ACCEPTED_CREDENTIALS_REQUEST_TYPE = "androidx.credentials.SIGNAL_ALL_ACCEPTED_CREDENTIALS_REQUEST_TYPE";
    private static final String SIGNAL_CURRENT_USER_DETAILS_STATE_REQUEST_TYPE = "androidx.credentials.SIGNAL_CURRENT_USER_DETAILS_STATE_REQUEST_TYPE";
    public static final String SIGNAL_REQUEST_JSON_KEY = "androidx.credentials.signal_request_json_key";
    private static final String SIGNAL_UNKNOWN_CREDENTIAL_STATE_REQUEST_TYPE = "androidx.credentials.SIGNAL_UNKNOWN_CREDENTIAL_STATE_REQUEST_TYPE";
    private final String origin;
    private final Bundle requestData;
    private final String requestJson;
    private final String type;

    @JvmStatic
    public static final SignalCredentialStateRequest createFrom(String str, Bundle bundle, String str2) {
        return INSTANCE.createFrom(str, bundle, str2);
    }

    @JvmStatic
    public static final SignalCredentialStateRequest createFrom(String str, String str2, String str3) {
        return INSTANCE.createFrom(str, str2, str3);
    }

    public SignalCredentialStateRequest(String type, String requestJson, Bundle requestData, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        this.type = type;
        this.requestJson = requestJson;
        this.requestData = requestData;
        this.origin = str;
    }

    public /* synthetic */ SignalCredentialStateRequest(String str, String str2, Bundle bundle, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, bundle, (i & 8) != 0 ? null : str3);
    }

    public final String getType() {
        return this.type;
    }

    public final String getRequestJson() {
        return this.requestJson;
    }

    public final Bundle getRequestData() {
        return this.requestData;
    }

    public final String getOrigin() {
        return this.origin;
    }

    /* JADX INFO: compiled from: SignalCredentialStateRequest.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/credentials/SignalCredentialStateRequest$Companion;", "", "<init>", "()V", "SIGNAL_REQUEST_JSON_KEY", "", "SIGNAL_UNKNOWN_CREDENTIAL_STATE_REQUEST_TYPE", "SIGNAL_ALL_ACCEPTED_CREDENTIALS_REQUEST_TYPE", "SIGNAL_CURRENT_USER_DETAILS_STATE_REQUEST_TYPE", "createFrom", "Landroidx/credentials/SignalCredentialStateRequest;", "requestType", "requestData", "Landroid/os/Bundle;", "origin", "requestJson", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SignalCredentialStateRequest createFrom(String requestType, Bundle requestData, String origin) {
            Intrinsics.checkNotNullParameter(requestType, "requestType");
            Intrinsics.checkNotNullParameter(requestData, "requestData");
            String string = requestData.getString("androidx.credentials.signal_request_json_key");
            if (string == null) {
                throw new IllegalArgumentException("Bundle was missing requestJson");
            }
            return createFrom(requestType, string, origin);
        }

        @JvmStatic
        public final SignalCredentialStateRequest createFrom(String requestType, String requestJson, String origin) {
            Intrinsics.checkNotNullParameter(requestType, "requestType");
            Intrinsics.checkNotNullParameter(requestJson, "requestJson");
            int iHashCode = requestType.hashCode();
            if (iHashCode != -1620108889) {
                if (iHashCode != 661746467) {
                    if (iHashCode == 847956843 && requestType.equals("androidx.credentials.SIGNAL_UNKNOWN_CREDENTIAL_STATE_REQUEST_TYPE")) {
                        return new SignalUnknownCredentialRequest(requestJson, origin);
                    }
                } else if (requestType.equals("androidx.credentials.SIGNAL_CURRENT_USER_DETAILS_STATE_REQUEST_TYPE")) {
                    return new SignalCurrentUserDetailsRequest(requestJson, origin);
                }
            } else if (requestType.equals("androidx.credentials.SIGNAL_ALL_ACCEPTED_CREDENTIALS_REQUEST_TYPE")) {
                return new SignalAllAcceptedCredentialIdsRequest(requestJson, origin);
            }
            throw new IllegalArgumentException("Request type is not supported");
        }
    }
}
