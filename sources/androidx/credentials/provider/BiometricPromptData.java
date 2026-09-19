package androidx.credentials.provider;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.biometric.BiometricPrompt;
import androidx.credentials.provider.utils.CryptoObjectUtils;
import androidx.media3.extractor.ts.PsExtractor;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BiometricPromptData.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u0000 \u000f2\u00020\u0001:\u0004\u000f\u0010\u0011\u0012B)\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u001f\b\u0017\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/credentials/provider/BiometricPromptData;", "", "cryptoObject", "Landroidx/biometric/BiometricPrompt$CryptoObject;", "allowedAuthenticators", "", "isCreatedFromBundle", "", "<init>", "(Landroidx/biometric/BiometricPrompt$CryptoObject;IZ)V", "(Landroidx/biometric/BiometricPrompt$CryptoObject;I)V", "getCryptoObject", "()Landroidx/biometric/BiometricPrompt$CryptoObject;", "getAllowedAuthenticators", "()I", "Companion", "Builder", "ApiMinImpl", "Api35Impl", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BiometricPromptData {
    public static final String BUNDLE_HINT_ALLOWED_AUTHENTICATORS = "androidx.credentials.provider.BUNDLE_HINT_ALLOWED_AUTHENTICATORS";
    public static final String BUNDLE_HINT_CRYPTO_OP_ID = "androidx.credentials.provider.BUNDLE_HINT_CRYPTO_OP_ID";
    private static final String TAG = "BiometricPromptData";
    private final int allowedAuthenticators;
    private final BiometricPrompt.CryptoObject cryptoObject;
    private boolean isCreatedFromBundle;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<Integer> ALLOWED_AUTHENTICATOR_VALUES = SetsKt.setOf((Object[]) new Integer[]{15, 255, 32768, 32783, 33023});

    public BiometricPromptData() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    public BiometricPromptData(BiometricPrompt.CryptoObject cryptoObject) {
        this(cryptoObject, 0, 2, null);
    }

    @JvmStatic
    public static final BiometricPromptData fromBundle(Bundle bundle) {
        return INSTANCE.fromBundle(bundle);
    }

    @JvmStatic
    public static final Bundle toBundle(BiometricPromptData biometricPromptData) {
        return INSTANCE.toBundle(biometricPromptData);
    }

    public BiometricPromptData(BiometricPrompt.CryptoObject cryptoObject, int i, boolean z) {
        this.cryptoObject = cryptoObject;
        this.allowedAuthenticators = i;
        this.isCreatedFromBundle = z;
        if (!z && !ALLOWED_AUTHENTICATOR_VALUES.contains(Integer.valueOf(i))) {
            throw new IllegalArgumentException("The allowed authenticator must be specified according to the BiometricPrompt spec.".toString());
        }
        if (cryptoObject != null && !INSTANCE.isStrongAuthenticationType(Integer.valueOf(i))) {
            throw new IllegalArgumentException("If the cryptoObject is non-null, the allowedAuthenticator value must be Authenticators.BIOMETRIC_STRONG.".toString());
        }
    }

    public /* synthetic */ BiometricPromptData(BiometricPrompt.CryptoObject cryptoObject, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : cryptoObject, (i2 & 2) != 0 ? 255 : i, (i2 & 4) != 0 ? false : z);
    }

    public final BiometricPrompt.CryptoObject getCryptoObject() {
        return this.cryptoObject;
    }

    public final int getAllowedAuthenticators() {
        return this.allowedAuthenticators;
    }

    public /* synthetic */ BiometricPromptData(BiometricPrompt.CryptoObject cryptoObject, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : cryptoObject, (i2 & 2) != 0 ? 255 : i);
    }

    public BiometricPromptData(BiometricPrompt.CryptoObject cryptoObject, int i) {
        this(cryptoObject, i, false);
    }

    /* JADX INFO: compiled from: BiometricPromptData.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\tH\u0007J\u0017\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Landroidx/credentials/provider/BiometricPromptData$Companion;", "", "<init>", "()V", "TAG", "", "BUNDLE_HINT_ALLOWED_AUTHENTICATORS", "BUNDLE_HINT_CRYPTO_OP_ID", "fromBundle", "Landroidx/credentials/provider/BiometricPromptData;", "bundle", "Landroid/os/Bundle;", "toBundle", "biometricPromptData", "isStrongAuthenticationType", "", "authenticationTypes", "", "(Ljava/lang/Integer;)Z", "ALLOWED_AUTHENTICATOR_VALUES", "", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BiometricPromptData fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            try {
                if (!bundle.containsKey(BiometricPromptData.BUNDLE_HINT_ALLOWED_AUTHENTICATORS)) {
                    throw new IllegalArgumentException("Bundle lacks allowed authenticator key.");
                }
                if (Build.VERSION.SDK_INT >= 35) {
                    return Api35Impl.fromBundle(bundle);
                }
                return ApiMinImpl.fromBundle(bundle);
            } catch (Exception e) {
                Log.i(BiometricPromptData.TAG, "fromSlice failed with: " + e.getMessage());
                return null;
            }
        }

        @JvmStatic
        public final Bundle toBundle(BiometricPromptData biometricPromptData) {
            Intrinsics.checkNotNullParameter(biometricPromptData, "biometricPromptData");
            if (Build.VERSION.SDK_INT >= 35) {
                return Api35Impl.toBundle(biometricPromptData);
            }
            return ApiMinImpl.toBundle(biometricPromptData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isStrongAuthenticationType(Integer authenticationTypes) {
            return authenticationTypes != null && (authenticationTypes.intValue() & PsExtractor.VIDEO_STREAM_MASK) == 0;
        }
    }

    /* JADX INFO: compiled from: BiometricPromptData.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006\r"}, d2 = {"Landroidx/credentials/provider/BiometricPromptData$Builder;", "", "<init>", "()V", "cryptoObject", "Landroidx/biometric/BiometricPrompt$CryptoObject;", "allowedAuthenticators", "", "Ljava/lang/Integer;", "setCryptoObject", "setAllowedAuthenticators", InAppPurchaseConstants.METHOD_BUILD, "Landroidx/credentials/provider/BiometricPromptData;", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private Integer allowedAuthenticators;
        private BiometricPrompt.CryptoObject cryptoObject;

        public final Builder setCryptoObject(BiometricPrompt.CryptoObject cryptoObject) {
            this.cryptoObject = cryptoObject;
            return this;
        }

        public final Builder setAllowedAuthenticators(int allowedAuthenticators) {
            this.allowedAuthenticators = Integer.valueOf(allowedAuthenticators);
            return this;
        }

        public final BiometricPromptData build() {
            Integer num = this.allowedAuthenticators;
            return new BiometricPromptData(this.cryptoObject, num != null ? num.intValue() : 255);
        }
    }

    /* JADX INFO: compiled from: BiometricPromptData.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Landroidx/credentials/provider/BiometricPromptData$ApiMinImpl;", "", "<init>", "()V", "toBundle", "Landroid/os/Bundle;", "biometricPromptData", "Landroidx/credentials/provider/BiometricPromptData;", "fromBundle", "bundle", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class ApiMinImpl {
        public static final ApiMinImpl INSTANCE = new ApiMinImpl();

        private ApiMinImpl() {
        }

        @JvmStatic
        public static final Bundle toBundle(BiometricPromptData biometricPromptData) {
            Intrinsics.checkNotNullParameter(biometricPromptData, "biometricPromptData");
            Bundle bundle = new Bundle();
            bundle.putInt(BiometricPromptData.BUNDLE_HINT_ALLOWED_AUTHENTICATORS, biometricPromptData.getAllowedAuthenticators());
            return bundle;
        }

        @JvmStatic
        public static final BiometricPromptData fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return new BiometricPromptData(null, bundle.getInt(BiometricPromptData.BUNDLE_HINT_ALLOWED_AUTHENTICATORS), true, 1, null);
        }
    }

    /* JADX INFO: compiled from: BiometricPromptData.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Landroidx/credentials/provider/BiometricPromptData$Api35Impl;", "", "<init>", "()V", "toBundle", "Landroid/os/Bundle;", "biometricPromptData", "Landroidx/credentials/provider/BiometricPromptData;", "fromBundle", "bundle", "credentials"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Api35Impl {
        public static final Api35Impl INSTANCE = new Api35Impl();

        private Api35Impl() {
        }

        @JvmStatic
        public static final Bundle toBundle(BiometricPromptData biometricPromptData) {
            Intrinsics.checkNotNullParameter(biometricPromptData, "biometricPromptData");
            Bundle bundle = new Bundle();
            bundle.putInt(BiometricPromptData.BUNDLE_HINT_ALLOWED_AUTHENTICATORS, biometricPromptData.getAllowedAuthenticators());
            if (biometricPromptData.getCryptoObject() != null) {
                bundle.putLong(BiometricPromptData.BUNDLE_HINT_CRYPTO_OP_ID, CryptoObjectUtils.INSTANCE.getOperationHandle(biometricPromptData.getCryptoObject()));
            }
            return bundle;
        }

        @JvmStatic
        public static final BiometricPromptData fromBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return new BiometricPromptData(null, bundle.getInt(BiometricPromptData.BUNDLE_HINT_ALLOWED_AUTHENTICATORS), true);
        }
    }
}
