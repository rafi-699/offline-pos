package com.RNAppleAuthentication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.RNAppleAuthentication.webview.SignInWebViewDialogFragment;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.hermes.intl.Constants;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SignInWithAppleService.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0011B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleService;", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "fragmentTag", "", "configuration", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "callback", "Lkotlin/Function1;", "Lcom/RNAppleAuthentication/SignInWithAppleResult;", "", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;Lkotlin/jvm/functions/Function1;)V", "Lcom/RNAppleAuthentication/SignInWithAppleCallback;", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;Lcom/RNAppleAuthentication/SignInWithAppleCallback;)V", "show", "AuthenticationAttempt", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SignInWithAppleService {
    private final Function1<SignInWithAppleResult, Unit> callback;
    private final SignInWithAppleConfiguration configuration;
    private final FragmentManager fragmentManager;
    private final String fragmentTag;

    /* JADX WARN: Multi-variable type inference failed */
    public SignInWithAppleService(FragmentManager fragmentManager, String fragmentTag, SignInWithAppleConfiguration configuration, Function1<? super SignInWithAppleResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.fragmentManager = fragmentManager;
        this.fragmentTag = fragmentTag;
        this.configuration = configuration;
        this.callback = callback;
        Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(fragmentTag);
        SignInWebViewDialogFragment signInWebViewDialogFragment = fragmentFindFragmentByTag instanceof SignInWebViewDialogFragment ? (SignInWebViewDialogFragment) fragmentFindFragmentByTag : null;
        if (signInWebViewDialogFragment != null) {
            signInWebViewDialogFragment.configure(callback);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SignInWithAppleService(FragmentManager fragmentManager, String fragmentTag, SignInWithAppleConfiguration configuration, SignInWithAppleCallback callback) {
        this(fragmentManager, fragmentTag, configuration, SignInWithAppleCallbackKt.toFunction(callback));
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(fragmentTag, "fragmentTag");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    /* JADX INFO: compiled from: SignInWithAppleService.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0080\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0012HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "Landroid/os/Parcelable;", "authenticationUri", "", "redirectUri", ServerProtocol.DIALOG_PARAM_STATE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAuthenticationUri", "()Ljava/lang/String;", "getRedirectUri", "getState", "writeToParcel", "", "flags", "", "describeContents", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "CREATOR", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class AuthenticationAttempt implements Parcelable {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String authenticationUri;
        private final String redirectUri;
        private final String state;

        public static /* synthetic */ AuthenticationAttempt copy$default(AuthenticationAttempt authenticationAttempt, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = authenticationAttempt.authenticationUri;
            }
            if ((i & 2) != 0) {
                str2 = authenticationAttempt.redirectUri;
            }
            if ((i & 4) != 0) {
                str3 = authenticationAttempt.state;
            }
            return authenticationAttempt.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAuthenticationUri() {
            return this.authenticationUri;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getRedirectUri() {
            return this.redirectUri;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getState() {
            return this.state;
        }

        public final AuthenticationAttempt copy(String authenticationUri, String redirectUri, String state) {
            Intrinsics.checkNotNullParameter(authenticationUri, "authenticationUri");
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            Intrinsics.checkNotNullParameter(state, "state");
            return new AuthenticationAttempt(authenticationUri, redirectUri, state);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AuthenticationAttempt)) {
                return false;
            }
            AuthenticationAttempt authenticationAttempt = (AuthenticationAttempt) other;
            return Intrinsics.areEqual(this.authenticationUri, authenticationAttempt.authenticationUri) && Intrinsics.areEqual(this.redirectUri, authenticationAttempt.redirectUri) && Intrinsics.areEqual(this.state, authenticationAttempt.state);
        }

        public int hashCode() {
            return (((this.authenticationUri.hashCode() * 31) + this.redirectUri.hashCode()) * 31) + this.state.hashCode();
        }

        public String toString() {
            return "AuthenticationAttempt(authenticationUri=" + this.authenticationUri + ", redirectUri=" + this.redirectUri + ", state=" + this.state + ")";
        }

        public AuthenticationAttempt(String authenticationUri, String redirectUri, String state) {
            Intrinsics.checkNotNullParameter(authenticationUri, "authenticationUri");
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            Intrinsics.checkNotNullParameter(state, "state");
            this.authenticationUri = authenticationUri;
            this.redirectUri = redirectUri;
            this.state = state;
        }

        public final String getAuthenticationUri() {
            return this.authenticationUri;
        }

        public final String getRedirectUri() {
            return this.redirectUri;
        }

        public final String getState() {
            return this.state;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public AuthenticationAttempt(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String str = Constants.COLLATION_INVALID;
            string = string == null ? Constants.COLLATION_INVALID : string;
            String string2 = parcel.readString();
            string2 = string2 == null ? Constants.COLLATION_INVALID : string2;
            String string3 = parcel.readString();
            this(string, string2, string3 != null ? string3 : str);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.authenticationUri);
            parcel.writeString(this.redirectUri);
            parcel.writeString(this.state);
        }

        /* JADX INFO: renamed from: com.RNAppleAuthentication.SignInWithAppleService$AuthenticationAttempt$CREATOR, reason: from kotlin metadata */
        /* JADX INFO: compiled from: SignInWithAppleService.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/RNAppleAuthentication/SignInWithAppleService$AuthenticationAttempt;", "create", "configuration", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion implements Parcelable.Creator<AuthenticationAttempt> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AuthenticationAttempt createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new AuthenticationAttempt(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public AuthenticationAttempt[] newArray(int size) {
                return new AuthenticationAttempt[size];
            }

            public final AuthenticationAttempt create(SignInWithAppleConfiguration configuration) {
                Intrinsics.checkNotNullParameter(configuration, "configuration");
                Uri.Builder builderBuildUpon = Uri.parse("https://appleid.apple.com/auth/authorize").buildUpon();
                builderBuildUpon.appendQueryParameter("client_id", configuration.getClientId());
                builderBuildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_REDIRECT_URI, configuration.getRedirectUri());
                builderBuildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, configuration.getResponseType());
                builderBuildUpon.appendQueryParameter("scope", configuration.getScope());
                builderBuildUpon.appendQueryParameter("response_mode", "form_post");
                builderBuildUpon.appendQueryParameter(ServerProtocol.DIALOG_PARAM_STATE, configuration.getState());
                if (!StringsKt.isBlank(configuration.getNonce())) {
                    builderBuildUpon.appendQueryParameter("nonce", configuration.getNonce());
                }
                String string = builderBuildUpon.build().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                return new AuthenticationAttempt(string, configuration.getRedirectUri(), configuration.getState());
            }
        }
    }

    public final void show() {
        SignInWebViewDialogFragment signInWebViewDialogFragmentNewInstance = SignInWebViewDialogFragment.INSTANCE.newInstance(AuthenticationAttempt.INSTANCE.create(this.configuration), this.configuration.getFullScreen());
        signInWebViewDialogFragmentNewInstance.configure(this.callback);
        signInWebViewDialogFragmentNewInstance.show(this.fragmentManager, this.fragmentTag);
    }
}
