package androidx.credentials.internal;

import android.credentials.Credential;
import android.credentials.GetCredentialRequest;
import android.os.Bundle;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FrameworkImplHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/credentials/internal/FrameworkImplHelper;", "", "<init>", "()V", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FrameworkImplHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @JvmStatic
    public static final GetCredentialRequest convertGetRequestToFrameworkClass(androidx.credentials.GetCredentialRequest getCredentialRequest) {
        return INSTANCE.convertGetRequestToFrameworkClass(getCredentialRequest);
    }

    @JvmStatic
    public static final GetCredentialResponse convertGetResponseToJetpackClass(android.credentials.GetCredentialResponse getCredentialResponse) {
        return INSTANCE.convertGetResponseToJetpackClass(getCredentialResponse);
    }

    @JvmStatic
    public static final void setOriginForGetRequest(androidx.credentials.GetCredentialRequest getCredentialRequest, GetCredentialRequest.Builder builder) {
        INSTANCE.setOriginForGetRequest(getCredentialRequest, builder);
    }

    /* JADX INFO: compiled from: FrameworkImplHelper.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, d2 = {"Landroidx/credentials/internal/FrameworkImplHelper$Companion;", "", "<init>", "()V", "convertGetResponseToJetpackClass", "Landroidx/credentials/GetCredentialResponse;", "response", "Landroid/credentials/GetCredentialResponse;", "convertGetRequestToFrameworkClass", "Landroid/credentials/GetCredentialRequest;", "request", "Landroidx/credentials/GetCredentialRequest;", "setOriginForGetRequest", "", "builder", "Landroid/credentials/GetCredentialRequest$Builder;", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GetCredentialResponse convertGetResponseToJetpackClass(android.credentials.GetCredentialResponse response) {
            Intrinsics.checkNotNullParameter(response, "response");
            Credential credential = response.getCredential();
            Intrinsics.checkNotNullExpressionValue(credential, "getCredential(...)");
            androidx.credentials.Credential.Companion companion = androidx.credentials.Credential.INSTANCE;
            String type = credential.getType();
            Intrinsics.checkNotNullExpressionValue(type, "getType(...)");
            Bundle data = credential.getData();
            Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
            return new GetCredentialResponse(companion.createFrom(type, data));
        }

        @JvmStatic
        public final GetCredentialRequest convertGetRequestToFrameworkClass(androidx.credentials.GetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            GetCredentialRequest.Builder builder = new GetCredentialRequest.Builder(androidx.credentials.GetCredentialRequest.INSTANCE.getRequestMetadataBundle(request));
            for (CredentialOption credentialOption : request.getCredentialOptions()) {
                builder.addCredentialOption(new android.credentials.CredentialOption.Builder(credentialOption.getType(), credentialOption.getRequestData(), credentialOption.getCandidateQueryData()).setIsSystemProviderRequired(credentialOption.getIsSystemProviderRequired()).setAllowedProviders(credentialOption.getAllowedProviders()).build());
            }
            setOriginForGetRequest(request, builder);
            GetCredentialRequest getCredentialRequestBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(getCredentialRequestBuild, "build(...)");
            return getCredentialRequestBuild;
        }

        @JvmStatic
        public final void setOriginForGetRequest(androidx.credentials.GetCredentialRequest request, GetCredentialRequest.Builder builder) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(builder, "builder");
            if (request.getOrigin() != null) {
                builder.setOrigin(request.getOrigin());
            }
        }
    }
}
