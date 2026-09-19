package com.reactnativegooglesignin.modern;

import android.accounts.Account;
import android.net.Uri;
import android.os.Build;
import android.util.Base64;
import androidx.autofill.HintConstants;
import androidx.core.content.pm.PackageInfoCompat;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.libraries.identity.googleid.GetGoogleIdOption;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import com.reactnativegooglesignin.Utils;
import java.security.SecureRandom;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OneTapUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/reactnativegooglesignin/modern/OneTapUtils;", "", "<init>", "()V", "OneTapUtils", "react-native-google-signin_google-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OneTapUtils {

    /* JADX INFO: renamed from: com.reactnativegooglesignin.modern.OneTapUtils$OneTapUtils, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OneTapUtils.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0007J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0007H\u0002J\u000e\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0011J\u0006\u0010\"\u001a\u00020\u0011J\u0010\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0002J\u000e\u0010%\u001a\u00020\u00112\u0006\u0010&\u001a\u00020'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006("}, d2 = {"Lcom/reactnativegooglesignin/modern/OneTapUtils$OneTapUtils;", "", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "detectedWebClientId", "", "getDetectedWebClientId", "()Ljava/lang/String;", "detectedWebClientId$delegate", "Lkotlin/Lazy;", "installedGooglePlayServicesVersion", "", "()Ljava/lang/Long;", "getWebClientId", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/facebook/react/bridge/ReadableMap;", "buildOneTapSignInRequest", "Lcom/google/android/libraries/identity/googleid/GetGoogleIdOption;", "getNonce", "generateUrlSafeNonce", "buildExplicitOneTapSignInRequest", "Lcom/google/android/libraries/identity/googleid/GetSignInWithGoogleOption;", "buildAuthorizationRequest", "Lcom/google/android/gms/auth/api/identity/AuthorizationRequest;", "resolvePromptParam", "", "promptStringToNative", "prompt", "getUserProperties", "acct", "Lcom/google/android/libraries/identity/googleid/GoogleIdTokenCredential;", "getCanceledResult", "getNoSavedCredentialsResult", "getSuccessResult", "data", "authorizationResultToJsMap", "authorizationResult", "Lcom/google/android/gms/auth/api/identity/AuthorizationResult;", "react-native-google-signin_google-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C0054OneTapUtils {
        private final ReactApplicationContext context;

        /* JADX INFO: renamed from: detectedWebClientId$delegate, reason: from kotlin metadata */
        private final Lazy detectedWebClientId;

        public C0054OneTapUtils(ReactApplicationContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.detectedWebClientId = LazyKt.lazy(new Function0() { // from class: com.reactnativegooglesignin.modern.OneTapUtils$OneTapUtils$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return OneTapUtils.C0054OneTapUtils.detectedWebClientId_delegate$lambda$0(this.f$0);
                }
            });
        }

        private final String getDetectedWebClientId() {
            return (String) this.detectedWebClientId.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String detectedWebClientId_delegate$lambda$0(C0054OneTapUtils c0054OneTapUtils) {
            int identifier = c0054OneTapUtils.context.getResources().getIdentifier("default_web_client_id", "string", c0054OneTapUtils.context.getPackageName());
            if (identifier != 0) {
                return c0054OneTapUtils.context.getResources().getString(identifier);
            }
            return null;
        }

        public final Long installedGooglePlayServicesVersion() {
            Object objM1405constructorimpl;
            long longVersionCode;
            try {
                Result.Companion companion = Result.INSTANCE;
                C0054OneTapUtils c0054OneTapUtils = this;
                if (Build.VERSION.SDK_INT >= 28) {
                    longVersionCode = PackageInfoCompat.getLongVersionCode(this.context.getPackageManager().getPackageInfo("com.google.android.gms", 0));
                } else {
                    longVersionCode = this.context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
                }
                objM1405constructorimpl = Result.m1405constructorimpl(Long.valueOf(longVersionCode));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM1405constructorimpl = Result.m1405constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m1411isFailureimpl(objM1405constructorimpl)) {
                objM1405constructorimpl = null;
            }
            return (Long) objM1405constructorimpl;
        }

        private final String getWebClientId(ReadableMap params) {
            String detectedWebClientId;
            if (!params.hasKey("webClientId") || Intrinsics.areEqual("autoDetect", params.getString("webClientId"))) {
                detectedWebClientId = getDetectedWebClientId();
            } else {
                detectedWebClientId = params.getString("webClientId");
            }
            if (detectedWebClientId != null) {
                return detectedWebClientId;
            }
            throw new IllegalArgumentException("`webClientId` is required but was not provided, and not found in the Android resources. To fix this, provide it in the params, or make sure you have set up Firebase correctly. Read the Android guide / Expo guide to learn more.");
        }

        public final GetGoogleIdOption buildOneTapSignInRequest(ReadableMap params) {
            Intrinsics.checkNotNullParameter(params, "params");
            String nonce = getNonce(params);
            return new GetGoogleIdOption.Builder().setServerClientId(getWebClientId(params)).setFilterByAuthorizedAccounts(params.getBoolean("filterByAuthorizedAccounts")).setNonce(nonce).setAutoSelectEnabled(params.getBoolean("autoSignIn")).setRequestVerifiedPhoneNumber(params.hasKey("requestVerifiedPhoneNumber") && params.getBoolean("requestVerifiedPhoneNumber")).build();
        }

        public final String getNonce(ReadableMap params) {
            Intrinsics.checkNotNullParameter(params, "params");
            String string = params.getString("nonce");
            return string == null ? generateUrlSafeNonce() : string;
        }

        public final String generateUrlSafeNonce() {
            byte[] bArr = new byte[32];
            new SecureRandom().nextBytes(bArr);
            String strEncodeToString = Base64.encodeToString(bArr, 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
            return strEncodeToString;
        }

        public final GetSignInWithGoogleOption buildExplicitOneTapSignInRequest(ReadableMap params) {
            Intrinsics.checkNotNullParameter(params, "params");
            String nonce = getNonce(params);
            String string = params.getString("hostedDomain");
            GetSignInWithGoogleOption.Builder builder = new GetSignInWithGoogleOption.Builder(getWebClientId(params));
            builder.setNonce(nonce);
            if (string != null) {
                builder.setHostedDomainFilter(string);
            }
            return builder.build();
        }

        public final AuthorizationRequest buildAuthorizationRequest(ReadableMap params) {
            Intrinsics.checkNotNullParameter(params, "params");
            boolean z = params.getBoolean("offlineAccessEnabled");
            String string = params.getString("hostedDomain");
            String string2 = params.getString("accountName");
            AuthorizationRequest.Builder builder = AuthorizationRequest.builder();
            Scope[] scopeArrCreateScopesArray = Utils.createScopesArray(params.getArray("scopes"));
            Intrinsics.checkNotNullExpressionValue(scopeArrCreateScopesArray, "createScopesArray(...)");
            builder.setRequestedScopes(ArraysKt.asList(scopeArrCreateScopesArray));
            if (z) {
                builder.requestOfflineAccess(getWebClientId(params), params.getBoolean("forceCodeForRefreshToken"));
            }
            builder.setPrompt(resolvePromptParam(params));
            if (string != null) {
                builder.filterByHostedDomain(string);
            }
            if (string2 != null) {
                builder.setAccount(new Account(string2, "com.google"));
            }
            AuthorizationRequest authorizationRequestBuild = builder.build();
            Intrinsics.checkNotNullExpressionValue(authorizationRequestBuild, "build(...)");
            return authorizationRequestBuild;
        }

        private final int resolvePromptParam(ReadableMap params) {
            if (!params.hasKey("prompt")) {
                return 0;
            }
            ReadableArray array = params.getArray("prompt");
            Intrinsics.checkNotNull(array);
            int size = array.size();
            int iPromptStringToNative = 0;
            for (int i = 0; i < size; i++) {
                String string = array.getString(i);
                Intrinsics.checkNotNull(string);
                iPromptStringToNative |= promptStringToNative(string);
            }
            return iPromptStringToNative;
        }

        private final int promptStringToNative(String prompt) {
            if (Intrinsics.areEqual(prompt, "consent")) {
                return 1;
            }
            return Intrinsics.areEqual(prompt, "select_account") ? 2 : 0;
        }

        public final ReadableMap getUserProperties(GoogleIdTokenCredential acct) {
            Intrinsics.checkNotNullParameter(acct, "acct");
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("id", acct.getZzi());
            writableMapCreateMap.putString("email", acct.getZzh());
            writableMapCreateMap.putString("name", acct.getZzc());
            writableMapCreateMap.putString("givenName", acct.getZze());
            writableMapCreateMap.putString("familyName", acct.getZzd());
            writableMapCreateMap.putString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, acct.getZzg());
            Uri zzf = acct.getZzf();
            writableMapCreateMap.putString(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, zzf != null ? zzf.toString() : null);
            WritableMap writableMapCreateMap2 = Arguments.createMap();
            writableMapCreateMap2.putMap("user", writableMapCreateMap);
            writableMapCreateMap2.putString("idToken", acct.getZzb());
            writableMapCreateMap2.putString("credentialOrigin", "user");
            return getSuccessResult(writableMapCreateMap2);
        }

        public final ReadableMap getCanceledResult() {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
            writableMapCreateMap.putNull("data");
            return writableMapCreateMap;
        }

        public final ReadableMap getNoSavedCredentialsResult() {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", "noSavedCredentialFound");
            writableMapCreateMap.putNull("credential");
            return writableMapCreateMap;
        }

        private final ReadableMap getSuccessResult(ReadableMap data) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("type", "success");
            writableMapCreateMap.putMap("data", data);
            return writableMapCreateMap;
        }

        public final ReadableMap authorizationResultToJsMap(AuthorizationResult authorizationResult) {
            Intrinsics.checkNotNullParameter(authorizationResult, "authorizationResult");
            String accessToken = authorizationResult.getAccessToken();
            String serverAuthCode = authorizationResult.getServerAuthCode();
            List<String> grantedScopes = authorizationResult.getGrantedScopes();
            Intrinsics.checkNotNullExpressionValue(grantedScopes, "getGrantedScopes(...)");
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString(SDKConstants.PARAM_ACCESS_TOKEN, accessToken);
            writableMapCreateMap.putString("serverAuthCode", serverAuthCode);
            writableMapCreateMap.putArray("grantedScopes", Arguments.fromList(grantedScopes));
            return getSuccessResult(writableMapCreateMap);
        }
    }
}
