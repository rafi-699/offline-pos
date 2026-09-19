package androidx.credentials;

import android.os.Bundle;
import android.util.Log;
import androidx.credentials.internal.ConversionUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SignalAllAcceptedCredentialIdsRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\tB\u001b\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\n¨\u0006\f"}, d2 = {"Landroidx/credentials/SignalAllAcceptedCredentialIdsRequest;", "Landroidx/credentials/SignalCredentialStateRequest;", "requestJson", "", "requestData", "Landroid/os/Bundle;", "origin", "<init>", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignalAllAcceptedCredentialIdsRequest extends SignalCredentialStateRequest {
    public static final String SIGNAL_ALL_ACCEPTED_CREDENTIALS_REQUEST_TYPE = "androidx.credentials.SIGNAL_ALL_ACCEPTED_CREDENTIALS_REQUEST_TYPE";
    private static final String TAG = "SignalAcceptedIdsReq";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String RP_ID_KEY = "rpId";
    private static final String USER_ID_KEY = "userId";
    private static final String ACCEPTED_CREDENTIAL_IDS_KEY = "allAcceptedCredentialIds";
    private static final List<String> REQUIRED_KEYS = CollectionsKt.listOf((Object[]) new String[]{RP_ID_KEY, USER_ID_KEY, ACCEPTED_CREDENTIAL_IDS_KEY});

    public /* synthetic */ SignalAllAcceptedCredentialIdsRequest(String str, Bundle bundle, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bundle, (i & 4) != 0 ? null : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignalAllAcceptedCredentialIdsRequest(String requestJson, Bundle requestData, String str) {
        super(SIGNAL_ALL_ACCEPTED_CREDENTIALS_REQUEST_TYPE, requestJson, requestData, str);
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        if (!INSTANCE.isValidRequestJson(requestJson)) {
            throw new IllegalArgumentException(("Structural/type validation failed for JSON: '" + requestJson + '\'').toString());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SignalAllAcceptedCredentialIdsRequest(String requestJson) {
        this(requestJson, null);
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SignalAllAcceptedCredentialIdsRequest(String requestJson, String str) {
        this(requestJson, INSTANCE.toRequestData(requestJson), str);
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
    }

    /* JADX INFO: compiled from: SignalAllAcceptedCredentialIdsRequest.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/credentials/SignalAllAcceptedCredentialIdsRequest$Companion;", "", "<init>", "()V", "SIGNAL_ALL_ACCEPTED_CREDENTIALS_REQUEST_TYPE", "", "TAG", "RP_ID_KEY", "USER_ID_KEY", "ACCEPTED_CREDENTIAL_IDS_KEY", "REQUIRED_KEYS", "", "toRequestData", "Landroid/os/Bundle;", "requestJson", "isValidRequestJson", "", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Bundle toRequestData(String requestJson) {
            Intrinsics.checkNotNullParameter(requestJson, "requestJson");
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.signal_request_json_key", requestJson);
            return bundle;
        }

        public final boolean isValidRequestJson(String requestJson) {
            Intrinsics.checkNotNullParameter(requestJson, "requestJson");
            try {
                JSONObject jSONObject = new JSONObject(requestJson);
                for (String str : SignalAllAcceptedCredentialIdsRequest.REQUIRED_KEYS) {
                    if (!jSONObject.has(str)) {
                        Log.e(SignalAllAcceptedCredentialIdsRequest.TAG, "Request json is missing required key " + str);
                        return false;
                    }
                }
                String string = jSONObject.getString(SignalAllAcceptedCredentialIdsRequest.USER_ID_KEY);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                if (!ConversionUtilsKt.isValidBase64Url(string)) {
                    return false;
                }
                JSONArray jSONArray = jSONObject.getJSONArray(SignalAllAcceptedCredentialIdsRequest.ACCEPTED_CREDENTIAL_IDS_KEY);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    Object obj = jSONArray.get(i);
                    if (!(obj instanceof String) || !ConversionUtilsKt.isValidBase64Url((String) obj)) {
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }
}
