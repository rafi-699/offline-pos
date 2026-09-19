package androidx.credentials.provider;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.credentials.CredentialOption;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: ProviderGetCredentialRequest.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B3\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB+\b\u0017\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\rR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\t\u001a\u0004\u0018\u00010\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Landroidx/credentials/provider/ProviderGetCredentialRequest;", "", "credentialOptions", "", "Landroidx/credentials/CredentialOption;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "biometricPromptResult", "Landroidx/credentials/provider/BiometricPromptResult;", "sourceBundle", "Landroid/os/Bundle;", "<init>", "(Ljava/util/List;Landroidx/credentials/provider/CallingAppInfo;Landroidx/credentials/provider/BiometricPromptResult;Landroid/os/Bundle;)V", "(Ljava/util/List;Landroidx/credentials/provider/CallingAppInfo;Landroidx/credentials/provider/BiometricPromptResult;)V", "getCredentialOptions", "()Ljava/util/List;", "getCallingAppInfo", "()Landroidx/credentials/provider/CallingAppInfo;", "getBiometricPromptResult", "()Landroidx/credentials/provider/BiometricPromptResult;", "getSourceBundle", "()Landroid/os/Bundle;", "Companion", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProviderGetCredentialRequest {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_CREDENTIAL_OPTION_ALLOWED_PROVIDERS_PREFIX = "androidx.credentials.provider.extra.CREDENTIAL_OPTION_ALLOWED_PROVIDERS_";
    private static final String EXTRA_CREDENTIAL_OPTION_CANDIDATE_QUERY_DATA_PREFIX = "androidx.credentials.provider.extra.CREDENTIAL_OPTION_CANDIDATE_QUERY_DATA_";
    private static final String EXTRA_CREDENTIAL_OPTION_CREDENTIAL_RETRIEVAL_DATA_PREFIX = "androidx.credentials.provider.extra.CREDENTIAL_OPTION_CREDENTIAL_RETRIEVAL_DATA_";
    private static final String EXTRA_CREDENTIAL_OPTION_IS_SYSTEM_PROVIDER_REQUIRED_PREFIX = "androidx.credentials.provider.extra.CREDENTIAL_OPTION_IS_SYSTEM_PROVIDER_REQUIRED_";
    private static final String EXTRA_CREDENTIAL_OPTION_SIZE = "androidx.credentials.provider.extra.CREDENTIAL_OPTION_SIZE";
    private static final String EXTRA_CREDENTIAL_OPTION_TYPE_PREFIX = "androidx.credentials.provider.extra.CREDENTIAL_OPTION_TYPE_";
    private final BiometricPromptResult biometricPromptResult;
    private final CallingAppInfo callingAppInfo;
    private final List<CredentialOption> credentialOptions;
    private final Bundle sourceBundle;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProviderGetCredentialRequest(List<? extends CredentialOption> credentialOptions, CallingAppInfo callingAppInfo) {
        this(credentialOptions, callingAppInfo, null, 4, null);
        Intrinsics.checkNotNullParameter(credentialOptions, "credentialOptions");
        Intrinsics.checkNotNullParameter(callingAppInfo, "callingAppInfo");
    }

    @JvmStatic
    public static final Bundle asBundle(ProviderGetCredentialRequest providerGetCredentialRequest) {
        return INSTANCE.asBundle(providerGetCredentialRequest);
    }

    @JvmStatic
    public static final ProviderGetCredentialRequest fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProviderGetCredentialRequest(List<? extends CredentialOption> credentialOptions, CallingAppInfo callingAppInfo, BiometricPromptResult biometricPromptResult, Bundle bundle) {
        Intrinsics.checkNotNullParameter(credentialOptions, "credentialOptions");
        Intrinsics.checkNotNullParameter(callingAppInfo, "callingAppInfo");
        this.credentialOptions = credentialOptions;
        this.callingAppInfo = callingAppInfo;
        this.biometricPromptResult = biometricPromptResult;
        this.sourceBundle = bundle;
    }

    public final List<CredentialOption> getCredentialOptions() {
        return this.credentialOptions;
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

    public /* synthetic */ ProviderGetCredentialRequest(List list, CallingAppInfo callingAppInfo, BiometricPromptResult biometricPromptResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, callingAppInfo, (i & 4) != 0 ? null : biometricPromptResult);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProviderGetCredentialRequest(List<? extends CredentialOption> credentialOptions, CallingAppInfo callingAppInfo, BiometricPromptResult biometricPromptResult) {
        this(credentialOptions, callingAppInfo, biometricPromptResult, null);
        Intrinsics.checkNotNullParameter(credentialOptions, "credentialOptions");
        Intrinsics.checkNotNullParameter(callingAppInfo, "callingAppInfo");
    }

    /* JADX INFO: compiled from: ProviderGetCredentialRequest.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0001¢\u0006\u0002\b\u000fJ\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0005H\u0007J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000eH\u0007R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/credentials/provider/ProviderGetCredentialRequest$Companion;", "", "<init>", "()V", "createFrom", "Landroidx/credentials/provider/ProviderGetCredentialRequest;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "Landroidx/credentials/CredentialOption;", "callingAppInfo", "Landroidx/credentials/provider/CallingAppInfo;", "biometricPromptResult", "Landroidx/credentials/provider/BiometricPromptResult;", "sourceBundle", "Landroid/os/Bundle;", "createFrom$credentials", "EXTRA_CREDENTIAL_OPTION_SIZE", "", "EXTRA_CREDENTIAL_OPTION_TYPE_PREFIX", "EXTRA_CREDENTIAL_OPTION_CREDENTIAL_RETRIEVAL_DATA_PREFIX", "EXTRA_CREDENTIAL_OPTION_CANDIDATE_QUERY_DATA_PREFIX", "EXTRA_CREDENTIAL_OPTION_IS_SYSTEM_PROVIDER_REQUIRED_PREFIX", "EXTRA_CREDENTIAL_OPTION_ALLOWED_PROVIDERS_PREFIX", "asBundle", "request", "fromBundle", "bundle", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ProviderGetCredentialRequest createFrom$credentials$default(Companion companion, List list, CallingAppInfo callingAppInfo, BiometricPromptResult biometricPromptResult, Bundle bundle, int i, Object obj) {
            if ((i & 4) != 0) {
                biometricPromptResult = null;
            }
            return companion.createFrom$credentials(list, callingAppInfo, biometricPromptResult, bundle);
        }

        @JvmStatic
        public final ProviderGetCredentialRequest createFrom$credentials(List<? extends CredentialOption> options, CallingAppInfo callingAppInfo, BiometricPromptResult biometricPromptResult, Bundle sourceBundle) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(callingAppInfo, "callingAppInfo");
            return new ProviderGetCredentialRequest(options, callingAppInfo, biometricPromptResult, sourceBundle);
        }

        @JvmStatic
        public final Bundle asBundle(ProviderGetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Bundle bundle = new Bundle();
            int size = request.getCredentialOptions().size();
            bundle.putInt(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_SIZE, size);
            for (int i = 0; i < size; i++) {
                CredentialOption credentialOption = request.getCredentialOptions().get(i);
                bundle.putString("androidx.credentials.provider.extra.CREDENTIAL_OPTION_TYPE_" + i, credentialOption.getType());
                bundle.putBundle(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_CANDIDATE_QUERY_DATA_PREFIX + i, credentialOption.getCandidateQueryData());
                bundle.putBundle(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_CREDENTIAL_RETRIEVAL_DATA_PREFIX + i, credentialOption.getRequestData());
                bundle.putBoolean(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_IS_SYSTEM_PROVIDER_REQUIRED_PREFIX + i, credentialOption.getIsSystemProviderRequired());
                bundle.putParcelableArray(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_ALLOWED_PROVIDERS_PREFIX + i, (Parcelable[]) credentialOption.getAllowedProviders().toArray(new ComponentName[0]));
            }
            CallingAppInfo.INSTANCE.setCallingAppInfo$credentials(bundle, request.getCallingAppInfo());
            return bundle;
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00b2 A[Catch: Exception -> 0x00b7, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b7, blocks: (B:15:0x0077, B:17:0x0090, B:19:0x009b, B:21:0x00a1, B:22:0x00a4, B:23:0x00a7, B:26:0x00b2), top: B:42:0x0077 }] */
        @JvmStatic
        public final ProviderGetCredentialRequest fromBundle(Bundle bundle) {
            Set<ComponentName> setEmptySet;
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            CallingAppInfo callingAppInfoExtractCallingAppInfo = CallingAppInfo.INSTANCE.extractCallingAppInfo(bundle);
            if (callingAppInfoExtractCallingAppInfo == null) {
                throw new IllegalArgumentException("Bundle was missing CallingAppInfo.");
            }
            int i = bundle.getInt(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_SIZE, -1);
            if (i < 0) {
                throw new IllegalArgumentException("Bundle had invalid option size as " + i + ClassUtils.PACKAGE_SEPARATOR_CHAR);
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                String string = bundle.getString("androidx.credentials.provider.extra.CREDENTIAL_OPTION_TYPE_" + i2);
                if (string == null) {
                    throw new IllegalArgumentException("Bundle was missing option type at index " + i + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
                Bundle bundle2 = bundle.getBundle(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_CANDIDATE_QUERY_DATA_PREFIX + i2);
                if (bundle2 == null) {
                    throw new IllegalArgumentException("Bundle was missing candidate query data at index " + i + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
                Bundle bundle3 = bundle.getBundle(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_CREDENTIAL_RETRIEVAL_DATA_PREFIX + i2);
                if (bundle3 == null) {
                    throw new IllegalArgumentException("Bundle was missing request data at index " + i + ClassUtils.PACKAGE_SEPARATOR_CHAR);
                }
                boolean z = bundle.getBoolean(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_IS_SYSTEM_PROVIDER_REQUIRED_PREFIX + i2, false);
                try {
                    Parcelable[] parcelableArray = bundle.getParcelableArray(ProviderGetCredentialRequest.EXTRA_CREDENTIAL_OPTION_ALLOWED_PROVIDERS_PREFIX + i2);
                    if (parcelableArray != null) {
                        ArrayList arrayList2 = new ArrayList();
                        for (Parcelable parcelable : parcelableArray) {
                            ComponentName componentName = (ComponentName) parcelable;
                            if (componentName != null) {
                                arrayList2.add(componentName);
                            }
                        }
                        setEmptySet = CollectionsKt.toSet(arrayList2);
                        if (setEmptySet == null) {
                            setEmptySet = SetsKt.emptySet();
                        }
                    } else {
                        setEmptySet = SetsKt.emptySet();
                    }
                } catch (Exception unused) {
                    setEmptySet = SetsKt.emptySet();
                }
                arrayList.add(CredentialOption.INSTANCE.createFrom(string, bundle3, bundle2, z, setEmptySet));
            }
            return createFrom$credentials(arrayList, callingAppInfoExtractCallingAppInfo, null, bundle);
        }
    }
}
