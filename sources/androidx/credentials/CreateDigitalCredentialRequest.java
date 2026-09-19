package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.internal.RequestValidationHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateDigitalCredentialRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Landroidx/credentials/CreateDigitalCredentialRequest;", "Landroidx/credentials/CreateCredentialRequest;", "requestJson", "", "origin", "credentialData", "Landroid/os/Bundle;", "candidateQueryData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;)V", "(Ljava/lang/String;Ljava/lang/String;)V", "getRequestJson", "()Ljava/lang/String;", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateDigitalCredentialRequest extends CreateCredentialRequest {
    public static final String BUNDLE_KEY_REQUEST_JSON = "androidx.credentials.BUNDLE_KEY_REQUEST_JSON";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String UNUSED_USER_ID = "unused";
    private final String requestJson;

    public /* synthetic */ CreateDigitalCredentialRequest(String str, String str2, Bundle bundle, Bundle bundle2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, bundle, bundle2);
    }

    public final String getRequestJson() {
        return this.requestJson;
    }

    private CreateDigitalCredentialRequest(String str, String str2, Bundle bundle, Bundle bundle2) {
        super(DigitalCredential.TYPE_DIGITAL_CREDENTIAL, bundle, bundle2, false, false, INSTANCE.populateUnusedDisplayInfo$credentials(), str2, false);
        this.requestJson = str;
        if (!RequestValidationHelper.INSTANCE.isValidJSON(str)) {
            throw new IllegalArgumentException("requestJson must not be empty, and must be a valid JSON".toString());
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreateDigitalCredentialRequest(String requestJson, String str) {
        this(requestJson, str, INSTANCE.toBundle$credentials(requestJson), new Bundle());
        Intrinsics.checkNotNullParameter(requestJson, "requestJson");
    }

    /* JADX INFO: compiled from: CreateDigitalCredentialRequest.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\rJ'\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/credentials/CreateDigitalCredentialRequest$Companion;", "", "<init>", "()V", "BUNDLE_KEY_REQUEST_JSON", "", "UNUSED_USER_ID", "populateUnusedDisplayInfo", "Landroidx/credentials/CreateCredentialRequest$DisplayInfo;", "populateUnusedDisplayInfo$credentials", "toBundle", "Landroid/os/Bundle;", "requestJson", "toBundle$credentials", "createFrom", "Landroidx/credentials/CreateDigitalCredentialRequest;", "data", "origin", "candidateQueryData", "createFrom$credentials", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CreateCredentialRequest.DisplayInfo populateUnusedDisplayInfo$credentials() {
            return new CreateCredentialRequest.DisplayInfo(CreateDigitalCredentialRequest.UNUSED_USER_ID, (CharSequence) null, 2, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final Bundle toBundle$credentials(String requestJson) {
            Intrinsics.checkNotNullParameter(requestJson, "requestJson");
            Bundle bundle = new Bundle();
            bundle.putString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON", requestJson);
            return bundle;
        }

        @JvmStatic
        public final CreateDigitalCredentialRequest createFrom$credentials(Bundle data, String origin, Bundle candidateQueryData) throws FrameworkClassParsingException {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(candidateQueryData, "candidateQueryData");
            String string = data.getString("androidx.credentials.BUNDLE_KEY_REQUEST_JSON");
            if (string == null) {
                throw new FrameworkClassParsingException();
            }
            return new CreateDigitalCredentialRequest(string, origin, data, candidateQueryData, null);
        }
    }
}
