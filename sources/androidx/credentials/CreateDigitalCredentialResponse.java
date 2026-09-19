package androidx.credentials;

import android.os.Bundle;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.internal.RequestValidationHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateDigitalCredentialResponse.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/credentials/CreateDigitalCredentialResponse;", "Landroidx/credentials/CreateCredentialResponse;", "responseJson", "", "<init>", "(Ljava/lang/String;)V", "getResponseJson", "()Ljava/lang/String;", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreateDigitalCredentialResponse extends CreateCredentialResponse {
    public static final String BUNDLE_KEY_RESPONSE_JSON = "androidx.credentials.BUNDLE_KEY_RESPONSE_JSON";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String responseJson;

    public final String getResponseJson() {
        return this.responseJson;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateDigitalCredentialResponse(String responseJson) {
        super(DigitalCredential.TYPE_DIGITAL_CREDENTIAL, INSTANCE.toBundle$credentials(responseJson));
        Intrinsics.checkNotNullParameter(responseJson, "responseJson");
        this.responseJson = responseJson;
        if (!RequestValidationHelper.INSTANCE.isValidJSON(responseJson)) {
            throw new IllegalArgumentException("responseJson must not be empty, and must be a valid JSON".toString());
        }
    }

    /* JADX INFO: compiled from: CreateDigitalCredentialResponse.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0001¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/credentials/CreateDigitalCredentialResponse$Companion;", "", "<init>", "()V", "BUNDLE_KEY_RESPONSE_JSON", "", "toBundle", "Landroid/os/Bundle;", "responseJson", "toBundle$credentials", "createFrom", "Landroidx/credentials/CreateDigitalCredentialResponse;", "data", "createFrom$credentials", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Bundle toBundle$credentials(String responseJson) {
            Intrinsics.checkNotNullParameter(responseJson, "responseJson");
            Bundle bundle = new Bundle();
            bundle.putString(CreateDigitalCredentialResponse.BUNDLE_KEY_RESPONSE_JSON, responseJson);
            return bundle;
        }

        @JvmStatic
        public final CreateDigitalCredentialResponse createFrom$credentials(Bundle data) throws FrameworkClassParsingException {
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                String string = data.getString(CreateDigitalCredentialResponse.BUNDLE_KEY_RESPONSE_JSON);
                Intrinsics.checkNotNull(string);
                return new CreateDigitalCredentialResponse(string);
            } catch (Exception unused) {
                throw new FrameworkClassParsingException();
            }
        }
    }
}
