package com.RNAppleAuthentication;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0003&'(BK\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JY\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006)"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "", "clientId", "", "redirectUri", "scope", "responseType", ServerProtocol.DIALOG_PARAM_STATE, "rawNonce", "nonce", "fullScreen", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getClientId", "()Ljava/lang/String;", "getRedirectUri", "getScope", "getResponseType", "getState", "getRawNonce", "getNonce", "getFullScreen", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "Builder", "ResponseType", "Scope", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class SignInWithAppleConfiguration {
    private final String clientId;
    private final boolean fullScreen;
    private final String nonce;
    private final String rawNonce;
    private final String redirectUri;
    private final String responseType;
    private final String scope;
    private final String state;

    public /* synthetic */ SignInWithAppleConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, z);
    }

    public static /* synthetic */ SignInWithAppleConfiguration copy$default(SignInWithAppleConfiguration signInWithAppleConfiguration, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = signInWithAppleConfiguration.clientId;
        }
        if ((i & 2) != 0) {
            str2 = signInWithAppleConfiguration.redirectUri;
        }
        if ((i & 4) != 0) {
            str3 = signInWithAppleConfiguration.scope;
        }
        if ((i & 8) != 0) {
            str4 = signInWithAppleConfiguration.responseType;
        }
        if ((i & 16) != 0) {
            str5 = signInWithAppleConfiguration.state;
        }
        if ((i & 32) != 0) {
            str6 = signInWithAppleConfiguration.rawNonce;
        }
        if ((i & 64) != 0) {
            str7 = signInWithAppleConfiguration.nonce;
        }
        if ((i & 128) != 0) {
            z = signInWithAppleConfiguration.fullScreen;
        }
        String str8 = str7;
        boolean z2 = z;
        String str9 = str5;
        String str10 = str6;
        return signInWithAppleConfiguration.copy(str, str2, str3, str4, str9, str10, str8, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getRedirectUri() {
        return this.redirectUri;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getScope() {
        return this.scope;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getResponseType() {
        return this.responseType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getRawNonce() {
        return this.rawNonce;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    public final SignInWithAppleConfiguration copy(String clientId, String redirectUri, String scope, String responseType, String state, String rawNonce, String nonce, boolean fullScreen) {
        Intrinsics.checkNotNullParameter(clientId, "clientId");
        Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(responseType, "responseType");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(rawNonce, "rawNonce");
        Intrinsics.checkNotNullParameter(nonce, "nonce");
        return new SignInWithAppleConfiguration(clientId, redirectUri, scope, responseType, state, rawNonce, nonce, fullScreen);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SignInWithAppleConfiguration)) {
            return false;
        }
        SignInWithAppleConfiguration signInWithAppleConfiguration = (SignInWithAppleConfiguration) other;
        return Intrinsics.areEqual(this.clientId, signInWithAppleConfiguration.clientId) && Intrinsics.areEqual(this.redirectUri, signInWithAppleConfiguration.redirectUri) && Intrinsics.areEqual(this.scope, signInWithAppleConfiguration.scope) && Intrinsics.areEqual(this.responseType, signInWithAppleConfiguration.responseType) && Intrinsics.areEqual(this.state, signInWithAppleConfiguration.state) && Intrinsics.areEqual(this.rawNonce, signInWithAppleConfiguration.rawNonce) && Intrinsics.areEqual(this.nonce, signInWithAppleConfiguration.nonce) && this.fullScreen == signInWithAppleConfiguration.fullScreen;
    }

    public int hashCode() {
        return (((((((((((((this.clientId.hashCode() * 31) + this.redirectUri.hashCode()) * 31) + this.scope.hashCode()) * 31) + this.responseType.hashCode()) * 31) + this.state.hashCode()) * 31) + this.rawNonce.hashCode()) * 31) + this.nonce.hashCode()) * 31) + Boolean.hashCode(this.fullScreen);
    }

    public String toString() {
        return "SignInWithAppleConfiguration(clientId=" + this.clientId + ", redirectUri=" + this.redirectUri + ", scope=" + this.scope + ", responseType=" + this.responseType + ", state=" + this.state + ", rawNonce=" + this.rawNonce + ", nonce=" + this.nonce + ", fullScreen=" + this.fullScreen + ")";
    }

    private SignInWithAppleConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        this.clientId = str;
        this.redirectUri = str2;
        this.scope = str3;
        this.responseType = str4;
        this.state = str5;
        this.rawNonce = str6;
        this.nonce = str7;
        this.fullScreen = z;
    }

    /* synthetic */ SignInWithAppleConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, str7, (i & 128) != 0 ? true : z);
    }

    public final String getClientId() {
        return this.clientId;
    }

    public final String getRedirectUri() {
        return this.redirectUri;
    }

    public final String getScope() {
        return this.scope;
    }

    public final String getResponseType() {
        return this.responseType;
    }

    public final String getState() {
        return this.state;
    }

    public final String getRawNonce() {
        return this.rawNonce;
    }

    public final String getNonce() {
        return this.nonce;
    }

    public final boolean getFullScreen() {
        return this.fullScreen;
    }

    /* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000eJ\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Builder;", "", "<init>", "()V", "clientId", "", "redirectUri", "scope", "responseType", ServerProtocol.DIALOG_PARAM_STATE, "rawNonce", "nonce", "fullScreen", "", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "type", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", InAppPurchaseConstants.METHOD_BUILD, "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration;", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private String clientId;
        private boolean fullScreen = true;
        private String nonce;
        private String rawNonce;
        private String redirectUri;
        private String responseType;
        private String scope;
        private String state;

        public final Builder clientId(String clientId) {
            Intrinsics.checkNotNullParameter(clientId, "clientId");
            this.clientId = clientId;
            return this;
        }

        public final Builder redirectUri(String redirectUri) {
            Intrinsics.checkNotNullParameter(redirectUri, "redirectUri");
            this.redirectUri = redirectUri;
            return this;
        }

        public final Builder scope(Scope scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            this.scope = scope.signal();
            return this;
        }

        public final Builder responseType(ResponseType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.responseType = type.signal();
            return this;
        }

        public final Builder state(String state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
            return this;
        }

        public final Builder rawNonce(String rawNonce) {
            Intrinsics.checkNotNullParameter(rawNonce, "rawNonce");
            this.rawNonce = rawNonce;
            return this;
        }

        public final Builder nonce(String nonce) {
            Intrinsics.checkNotNullParameter(nonce, "nonce");
            this.nonce = nonce;
            return this;
        }

        public final Builder fullScreen(boolean fullScreen) {
            this.fullScreen = fullScreen;
            return this;
        }

        public final SignInWithAppleConfiguration build() {
            String str = this.clientId;
            String str2 = null;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clientId");
                str = null;
            }
            String str3 = this.redirectUri;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("redirectUri");
                str3 = null;
            }
            String str4 = this.scope;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("scope");
                str4 = null;
            }
            String str5 = this.responseType;
            if (str5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("responseType");
                str5 = null;
            }
            String str6 = this.state;
            if (str6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
                str6 = null;
            }
            String str7 = this.rawNonce;
            if (str7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rawNonce");
                str7 = null;
            }
            String str8 = this.nonce;
            if (str8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("nonce");
            } else {
                str2 = str8;
            }
            return new SignInWithAppleConfiguration(str, str3, str4, str5, str6, str7, str2, this.fullScreen, null);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "", "<init>", "(Ljava/lang/String;I)V", "CODE", "ID_TOKEN", "ALL", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ResponseType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ResponseType[] $VALUES;
        public static final ResponseType CODE = new CODE("CODE", 0);
        public static final ResponseType ID_TOKEN = new ID_TOKEN("ID_TOKEN", 1);
        public static final ResponseType ALL = new ALL("ALL", 2);

        private static final /* synthetic */ ResponseType[] $values() {
            return new ResponseType[]{CODE, ID_TOKEN, ALL};
        }

        public /* synthetic */ ResponseType(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static EnumEntries<ResponseType> getEntries() {
            return $ENTRIES;
        }

        public abstract String signal();

        /* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/RNAppleAuthentication/SignInWithAppleConfiguration.ResponseType.CODE", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        static final class CODE extends ResponseType {
            CODE(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.ResponseType
            public String signal() {
                return "code";
            }
        }

        private ResponseType(String str, int i) {
            super(str, i);
        }

        static {
            ResponseType[] responseTypeArr$values = $values();
            $VALUES = responseTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(responseTypeArr$values);
        }

        /* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/RNAppleAuthentication/SignInWithAppleConfiguration.ResponseType.ID_TOKEN", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        static final class ID_TOKEN extends ResponseType {
            ID_TOKEN(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.ResponseType
            public String signal() {
                return "id_token";
            }
        }

        /* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/RNAppleAuthentication/SignInWithAppleConfiguration.ResponseType.ALL", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$ResponseType;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        static final class ALL extends ResponseType {
            ALL(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.ResponseType
            public String signal() {
                return "code id_token";
            }
        }

        public static ResponseType valueOf(String str) {
            return (ResponseType) Enum.valueOf(ResponseType.class, str);
        }

        public static ResponseType[] values() {
            return (ResponseType[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH&j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "", "<init>", "(Ljava/lang/String;I)V", "NAME", "EMAIL", "ALL", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Scope {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Scope[] $VALUES;
        public static final Scope NAME = new NAME("NAME", 0);
        public static final Scope EMAIL = new EMAIL("EMAIL", 1);
        public static final Scope ALL = new ALL("ALL", 2);

        private static final /* synthetic */ Scope[] $values() {
            return new Scope[]{NAME, EMAIL, ALL};
        }

        public /* synthetic */ Scope(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i);
        }

        public static EnumEntries<Scope> getEntries() {
            return $ENTRIES;
        }

        public abstract String signal();

        /* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/RNAppleAuthentication/SignInWithAppleConfiguration.Scope.NAME", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        static final class NAME extends Scope {
            NAME(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.Scope
            public String signal() {
                return "name";
            }
        }

        private Scope(String str, int i) {
            super(str, i);
        }

        static {
            Scope[] scopeArr$values = $values();
            $VALUES = scopeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scopeArr$values);
        }

        /* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/RNAppleAuthentication/SignInWithAppleConfiguration.Scope.EMAIL", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        static final class EMAIL extends Scope {
            EMAIL(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.Scope
            public String signal() {
                return "email";
            }
        }

        /* JADX INFO: compiled from: SignInWithAppleConfiguration.kt */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\bÊ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/RNAppleAuthentication/SignInWithAppleConfiguration.Scope.ALL", "Lcom/RNAppleAuthentication/SignInWithAppleConfiguration$Scope;", "signal", "", "invertase_react-native-apple-authentication_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        static final class ALL extends Scope {
            ALL(String str, int i) {
                super(str, i, null);
            }

            @Override // com.RNAppleAuthentication.SignInWithAppleConfiguration.Scope
            public String signal() {
                return "name email";
            }
        }

        public static Scope valueOf(String str) {
            return (Scope) Enum.valueOf(Scope.class, str);
        }

        public static Scope[] values() {
            return (Scope[]) $VALUES.clone();
        }
    }
}
