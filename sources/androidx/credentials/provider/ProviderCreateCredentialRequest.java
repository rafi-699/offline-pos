package androidx.credentials.provider;

import android.os.Bundle;
import androidx.credentials.CreateCredentialRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProviderCreateCredentialRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B-\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bB%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Landroidx/credentials/provider/ProviderCreateCredentialRequest;", "", "callingRequest", "Landroidx/credentials/CreateCredentialRequest;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "biometricPromptResult", "Landroidx/credentials/provider/BiometricPromptResult;", "sourceBundle", "Landroid/os/Bundle;", "<init>", "(Landroidx/credentials/CreateCredentialRequest;Landroidx/credentials/provider/CallingAppInfo;Landroidx/credentials/provider/BiometricPromptResult;Landroid/os/Bundle;)V", "(Landroidx/credentials/CreateCredentialRequest;Landroidx/credentials/provider/CallingAppInfo;Landroidx/credentials/provider/BiometricPromptResult;)V", "getCallingRequest", "()Landroidx/credentials/CreateCredentialRequest;", "getCallingAppInfo", "()Landroidx/credentials/provider/CallingAppInfo;", "getBiometricPromptResult", "()Landroidx/credentials/provider/BiometricPromptResult;", "getSourceBundle", "()Landroid/os/Bundle;", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProviderCreateCredentialRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CREATE_CREDENTIAL_REQUEST_TYPE = "androidx.credentials.provider.extra.CREATE_CREDENTIAL_REQUEST_TYPE";
    private static final String EXTRA_CREATE_REQUEST_CANDIDATE_QUERY_DATA = "androidx.credentials.provider.extra.CREATE_REQUEST_CANDIDATE_QUERY_DATA";
    private static final String EXTRA_CREATE_REQUEST_CREDENTIAL_DATA = "androidx.credentials.provider.extra.CREATE_REQUEST_CREDENTIAL_DATA";
    private final BiometricPromptResult biometricPromptResult;
    private final CallingAppInfo callingAppInfo;
    private final CreateCredentialRequest callingRequest;
    private final Bundle sourceBundle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProviderCreateCredentialRequest(CreateCredentialRequest callingRequest, CallingAppInfo callingAppInfo) {
        this(callingRequest, callingAppInfo, null, 4, null);
        Intrinsics.checkNotNullParameter(callingRequest, "callingRequest");
        Intrinsics.checkNotNullParameter(callingAppInfo, "callingAppInfo");
    }

    @JvmStatic
    public static final Bundle asBundle(ProviderCreateCredentialRequest providerCreateCredentialRequest) {
        return INSTANCE.asBundle(providerCreateCredentialRequest);
    }

    @JvmStatic
    public static final ProviderCreateCredentialRequest fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    public ProviderCreateCredentialRequest(CreateCredentialRequest callingRequest, CallingAppInfo callingAppInfo, BiometricPromptResult biometricPromptResult, Bundle bundle) {
        Intrinsics.checkNotNullParameter(callingRequest, "callingRequest");
        Intrinsics.checkNotNullParameter(callingAppInfo, "callingAppInfo");
        this.callingRequest = callingRequest;
        this.callingAppInfo = callingAppInfo;
        this.biometricPromptResult = biometricPromptResult;
        this.sourceBundle = bundle;
    }

    public final CreateCredentialRequest getCallingRequest() {
        return this.callingRequest;
    }

    public final CallingAppInfo getCallingAppInfo() {
        return this.callingAppInfo;
    }

    public final BiometricPromptResult getBiometricPromptResult() {
        return this.biometricPromptResult;
    }

    public final Bundle getSourceBundle() {
        return this.sourceBundle;
    }

    public /* synthetic */ ProviderCreateCredentialRequest(CreateCredentialRequest createCredentialRequest, CallingAppInfo callingAppInfo, BiometricPromptResult biometricPromptResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(createCredentialRequest, callingAppInfo, (i & 4) != 0 ? null : biometricPromptResult);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProviderCreateCredentialRequest(CreateCredentialRequest callingRequest, CallingAppInfo callingAppInfo, BiometricPromptResult biometricPromptResult) {
        this(callingRequest, callingAppInfo, biometricPromptResult, null);
        Intrinsics.checkNotNullParameter(callingRequest, "callingRequest");
        Intrinsics.checkNotNullParameter(callingAppInfo, "callingAppInfo");
    }

    /* JADX INFO: compiled from: ProviderCreateCredentialRequest.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Landroidx/credentials/provider/ProviderCreateCredentialRequest$Companion;", "", "<init>", "()V", "EXTRA_CREATE_CREDENTIAL_REQUEST_TYPE", "", "EXTRA_CREATE_REQUEST_CANDIDATE_QUERY_DATA", "EXTRA_CREATE_REQUEST_CREDENTIAL_DATA", "asBundle", "Landroid/os/Bundle;", "request", "Landroidx/credentials/provider/ProviderCreateCredentialRequest;", "fromBundle", "bundle", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Bundle asBundle(ProviderCreateCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Bundle bundle = new Bundle();
            bundle.putString(ProviderCreateCredentialRequest.EXTRA_CREATE_CREDENTIAL_REQUEST_TYPE, request.getCallingRequest().getType());
            bundle.putBundle(ProviderCreateCredentialRequest.EXTRA_CREATE_REQUEST_CREDENTIAL_DATA, request.getCallingRequest().getCredentialData());
            bundle.putBundle(ProviderCreateCredentialRequest.EXTRA_CREATE_REQUEST_CANDIDATE_QUERY_DATA, request.getCallingRequest().getCandidateQueryData());
            CallingAppInfo.INSTANCE.setCallingAppInfo$credentials(bundle, request.getCallingAppInfo());
            return bundle;
        }

        @JvmStatic
        public final ProviderCreateCredentialRequest fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            String string = bundle.getString(ProviderCreateCredentialRequest.EXTRA_CREATE_CREDENTIAL_REQUEST_TYPE);
            if (string == null) {
                throw new IllegalArgumentException("Bundle was missing request type.");
            }
            Bundle bundle2 = bundle.getBundle(ProviderCreateCredentialRequest.EXTRA_CREATE_REQUEST_CREDENTIAL_DATA);
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            Bundle bundle4 = bundle.getBundle(ProviderCreateCredentialRequest.EXTRA_CREATE_REQUEST_CANDIDATE_QUERY_DATA);
            if (bundle4 == null) {
                bundle4 = new Bundle();
            }
            Bundle bundle5 = bundle4;
            String string2 = bundle.getString(CallingAppInfo.EXTRA_CREDENTIAL_REQUEST_ORIGIN);
            CallingAppInfo callingAppInfoExtractCallingAppInfo = CallingAppInfo.INSTANCE.extractCallingAppInfo(bundle);
            if (callingAppInfoExtractCallingAppInfo == null) {
                throw new IllegalArgumentException("Bundle was missing CallingAppInfo.");
            }
            try {
                return new ProviderCreateCredentialRequest(CreateCredentialRequest.INSTANCE.createFrom(string, bundle3, bundle5, false, string2), callingAppInfoExtractCallingAppInfo, null, bundle);
            } catch (Exception e) {
                throw new IllegalArgumentException("Conversion failed with " + e);
            }
        }
    }
}
