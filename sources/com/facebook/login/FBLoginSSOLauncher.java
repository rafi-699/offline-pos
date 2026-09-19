package com.facebook.login;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: compiled from: FBLoginSSOLauncher.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010 \u001a\u00020\bH\u0002J\u0018\u0010!\u001a\u00020\b2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018H\u0007J2\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0016H\u0002J\u0010\u0010)\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020*H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\n\u001a\u0004\u0018\u00010\u000b8@@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/facebook/login/FBLoginSSOLauncher;", "", "activity", "Landroidx/activity/ComponentActivity;", "callback", "Lcom/facebook/FacebookCallback;", "Lcom/facebook/login/LoginResult;", "showWithoutFBApp", "", "(Landroidx/activity/ComponentActivity;Lcom/facebook/FacebookCallback;Z)V", "appEventsLogger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "getAppEventsLogger$facebook_common_release$annotations", "()V", "getAppEventsLogger$facebook_common_release", "()Lcom/facebook/appevents/InternalAppEventsLogger;", "setAppEventsLogger$facebook_common_release", "(Lcom/facebook/appevents/InternalAppEventsLogger;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "pendingNonce", "", "pendingPermissions", "", "pendingRequest", "Lcom/facebook/login/LoginClient$Request;", "handleActivityResult", "", "resultCode", "", "data", "isFb4aInstalled", "launch", "permissions", "logSsoEvent", "eventName", "authLoggerId", "extras", "Lorg/json/JSONObject;", "result", "markFromSso", "Lcom/facebook/login/LoginClient$Result;", "Companion", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FBLoginSSOLauncher {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SSO_DISMISSED_EXTRA = "sso_dismissed";
    private static final String TAG = "FBLoginSSOLauncher";
    private static String pendingSsoContext;
    private final ComponentActivity activity;
    private InternalAppEventsLogger appEventsLogger;
    private final FacebookCallback<LoginResult> callback;
    private final ActivityResultLauncher<Intent> launcher;
    private String pendingNonce;
    private Collection<String> pendingPermissions;
    private LoginClient.Request pendingRequest;
    private final boolean showWithoutFBApp;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FBLoginSSOLauncher(ComponentActivity activity) {
        this(activity, null, false, 6, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FBLoginSSOLauncher(ComponentActivity activity, FacebookCallback<LoginResult> facebookCallback) {
        this(activity, facebookCallback, false, 4, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public static /* synthetic */ void getAppEventsLogger$facebook_common_release$annotations() {
    }

    public static final String getPendingSsoContext() {
        return INSTANCE.getPendingSsoContext();
    }

    public final boolean launch() {
        return launch$default(this, null, 1, null);
    }

    public FBLoginSSOLauncher(ComponentActivity activity, FacebookCallback<LoginResult> facebookCallback, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
        this.callback = facebookCallback;
        this.showWithoutFBApp = z;
        this.pendingPermissions = CollectionsKt.emptyList();
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = activity.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.facebook.login.FBLoginSSOLauncher$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                FBLoginSSOLauncher._init_$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "activity.registerForActi…e, result.data)\n        }");
        this.launcher = activityResultLauncherRegisterForActivityResult;
    }

    public /* synthetic */ FBLoginSSOLauncher(ComponentActivity componentActivity, FacebookCallback facebookCallback, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentActivity, (i & 2) != 0 ? null : facebookCallback, (i & 4) != 0 ? true : z);
    }

    public final void setAppEventsLogger$facebook_common_release(InternalAppEventsLogger internalAppEventsLogger) {
        this.appEventsLogger = internalAppEventsLogger;
    }

    public final InternalAppEventsLogger getAppEventsLogger$facebook_common_release() {
        if (this.appEventsLogger == null) {
            this.appEventsLogger = new InternalAppEventsLogger(this.activity, FacebookSdk.getApplicationId());
        }
        return this.appEventsLogger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(FBLoginSSOLauncher this$0, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handleActivityResult(activityResult.getResultCode(), activityResult.getData());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean launch$default(FBLoginSSOLauncher fBLoginSSOLauncher, Collection collection, int i, Object obj) {
        if ((i & 1) != 0) {
            collection = CollectionsKt.emptyList();
        }
        return fBLoginSSOLauncher.launch(collection);
    }

    public final boolean launch(Collection<String> permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.pendingPermissions = permissions;
        if (AccessToken.INSTANCE.getCurrentAccessToken() != null) {
            return false;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "randomUUID().toString()");
        Utility.logd(TAG, "auth_logger_id: " + string);
        Collection<String> collection = permissions;
        logSsoEvent$default(this, LoginLogger.EVENT_NAME_SSO_LAUNCH_ATTEMPTED, string, new JSONObject().put("permissions", TextUtils.join(",", collection)), null, 8, null);
        if (!FeatureManager.isEnabled(FeatureManager.Feature.LoginSSO)) {
            pendingSsoContext = "non_sso_login_sso_not_shown";
            logSsoEvent$default(this, LoginLogger.EVENT_NAME_SSO_NOT_SHOWN, string, new JSONObject().put("reason", "gk_disabled"), null, 8, null);
            return false;
        }
        LoginConfiguration loginConfiguration = new LoginConfiguration(permissions, null, 2, null);
        LoginManager companion = LoginManager.INSTANCE.getInstance();
        final LoginClient.Request request = new LoginClient.Request(companion.getLoginBehavior(), loginConfiguration.getPermissions(), companion.getDefaultAudience(), companion.getAuthType(), FacebookSdk.getApplicationId(), string, companion.getLoginTargetApp(), loginConfiguration.getNonce(), null, null, null, FacebookSdk.getRedirectURI(), FacebookSdk.getIntentUriPackageTarget(), 1792, null);
        request.setFamilyLogin(companion.getIsFamilyLogin());
        request.setShouldSkipAccountDeduplication(companion.getShouldSkipAccountDeduplication());
        this.pendingNonce = loginConfiguration.getNonce();
        this.pendingRequest = request;
        for (Intent intent : NativeProtocol.createFBLoginSSOIntents(this.activity, FacebookSdk.getApplicationId(), loginConfiguration.getPermissions(), LoginClient.INSTANCE.getE2E(), false, false, companion.getDefaultAudience(), "{\"0_auth_logger_id\":\"" + string + "\"}", companion.getAuthType(), false, null, false, companion.getIsFamilyLogin(), companion.getShouldSkipAccountDeduplication(), loginConfiguration.getNonce(), null, null, FacebookSdk.getRedirectURI(), FacebookSdk.getIntentUriPackageTarget())) {
            if (this.activity.getPackageManager().resolveActivity(intent, 0) != null) {
                pendingSsoContext = "non_sso_login_sso_shown";
                logSsoEvent$default(this, LoginLogger.EVENT_NAME_SSO_DELEGATED_TO_FB4A, request.getAuthId(), null, null, 12, null);
                this.launcher.launch(intent);
                return true;
            }
        }
        final String str = isFb4aInstalled() ? "fb4a_outdated" : "fb4a_not_installed";
        if (this.showWithoutFBApp) {
            ComponentActivity componentActivity = this.activity;
            FragmentActivity fragmentActivity = componentActivity instanceof FragmentActivity ? (FragmentActivity) componentActivity : null;
            if (fragmentActivity == null) {
                return false;
            }
            FBLoginSSONoAppDialog fBLoginSSONoAppDialogNewInstance$default = FBLoginSSONoAppDialog.Companion.newInstance$default(FBLoginSSONoAppDialog.INSTANCE, false, 1, null);
            fBLoginSSONoAppDialogNewInstance$default.setOnContinueListener(new Function0<Unit>() { // from class: com.facebook.login.FBLoginSSOLauncher.launch.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FBLoginSSOLauncher.logSsoEvent$default(FBLoginSSOLauncher.this, LoginLogger.EVENT_NAME_SSO_CONTINUE_CLICKED, request.getAuthId(), new JSONObject().put("reason", str), null, 8, null);
                    LoginManager.INSTANCE.getInstance().startLoginWithForceConfirmation$facebook_common_release(FBLoginSSOLauncher.this.activity, FBLoginSSOLauncher.this.pendingPermissions, str, request.getAuthId());
                }
            });
            fBLoginSSONoAppDialogNewInstance$default.setOnDismissListener(new Function0<Unit>() { // from class: com.facebook.login.FBLoginSSOLauncher.launch.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FBLoginSSOLauncher.logSsoEvent$default(FBLoginSSOLauncher.this, LoginLogger.EVENT_NAME_SSO_DISMISSED, request.getAuthId(), null, LoginClient.Result.Code.CANCEL.getLoggingValue(), 4, null);
                }
            });
            fBLoginSSONoAppDialogNewInstance$default.show(fragmentActivity.getSupportFragmentManager(), FBLoginSSONoAppDialog.TAG);
            logSsoEvent$default(this, LoginLogger.EVENT_NAME_SSO_SHOWN, request.getAuthId(), new JSONObject().put("reason", str).put("permissions", TextUtils.join(",", collection)), null, 8, null);
            return true;
        }
        logSsoEvent$default(this, LoginLogger.EVENT_NAME_SSO_NOT_SHOWN, request.getAuthId(), new JSONObject().put("reason", str), null, 8, null);
        pendingSsoContext = "non_sso_login_sso_not_shown";
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    private final void handleActivityResult(int resultCode, Intent data) {
        boolean z;
        LoginClient.Request request = this.pendingRequest;
        String str = this.pendingNonce;
        if (data != null) {
            z = data.getBooleanExtra(SSO_DISMISSED_EXTRA, false);
        }
        Utility.logd(TAG, "handleActivityResult: resultCode=" + resultCode + ", sso_dismissed=" + z);
        if (z) {
            Utility.logd(TAG, "SSO popup dismissed by user (not a login cancellation)");
            logSsoEvent$default(this, LoginLogger.EVENT_NAME_SSO_DISMISSED, request != null ? request.getAuthId() : null, null, LoginClient.Result.Code.CANCEL.getLoggingValue(), 4, null);
            FacebookCallback<LoginResult> facebookCallback = this.callback;
            if (facebookCallback != null) {
                facebookCallback.onCancel();
            }
            this.pendingNonce = null;
            this.pendingRequest = null;
            return;
        }
        Intent intent = new Intent();
        if (resultCode == -1 && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                String string = extras.getString("error");
                if (string == null) {
                    string = extras.getString("error_type");
                }
                Object obj = extras.get("error_code");
                String string2 = obj != null ? obj.toString() : null;
                String string3 = extras.getString("error_message");
                if (string3 == null) {
                    string3 = extras.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
                }
                if (string == null && string2 == null && string3 == null) {
                    try {
                        LoginClient.Result resultCreateCompositeTokenResult = LoginClient.Result.INSTANCE.createCompositeTokenResult(request, LoginMethodHandler.INSTANCE.createAccessTokenFromWebBundle(request != null ? request.getPermissions() : null, extras, AccessTokenSource.FACEBOOK_APPLICATION_WEB, FacebookSdk.getApplicationId()), LoginMethodHandler.INSTANCE.createAuthenticationTokenFromWebBundle(extras, str));
                        markFromSso(resultCreateCompositeTokenResult);
                        intent.putExtra(LoginFragment.RESULT_KEY, resultCreateCompositeTokenResult);
                        LoginManager.INSTANCE.getInstance().onActivityResult(-1, intent, this.callback);
                    } catch (Exception e) {
                        LoginClient.Result resultCreateErrorResult$default = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.INSTANCE, request, null, e.getMessage(), null, 8, null);
                        markFromSso(resultCreateErrorResult$default);
                        intent.putExtra(LoginFragment.RESULT_KEY, resultCreateErrorResult$default);
                        LoginManager.INSTANCE.getInstance().onActivityResult(-1, intent, this.callback);
                    }
                } else {
                    LoginClient.Result resultCreateErrorResult = LoginClient.Result.INSTANCE.createErrorResult(request, string, string3, string2);
                    markFromSso(resultCreateErrorResult);
                    intent.putExtra(LoginFragment.RESULT_KEY, resultCreateErrorResult);
                    LoginManager.INSTANCE.getInstance().onActivityResult(-1, intent, this.callback);
                }
            } else {
                LoginClient.Result resultCreateErrorResult$default2 = LoginClient.Result.Companion.createErrorResult$default(LoginClient.Result.INSTANCE, request, null, "Unexpected null extras from SSO activity.", null, 8, null);
                markFromSso(resultCreateErrorResult$default2);
                intent.putExtra(LoginFragment.RESULT_KEY, resultCreateErrorResult$default2);
                LoginManager.INSTANCE.getInstance().onActivityResult(-1, intent, this.callback);
            }
        } else {
            Utility.logd(TAG, "Login cancelled (not SSO dismiss — OAuth dialog was shown)");
            LoginClient.Result resultCreateCancelResult = LoginClient.Result.INSTANCE.createCancelResult(request, "Operation canceled");
            markFromSso(resultCreateCancelResult);
            intent.putExtra(LoginFragment.RESULT_KEY, resultCreateCancelResult);
            LoginManager.INSTANCE.getInstance().onActivityResult(0, intent, this.callback);
        }
        this.pendingNonce = null;
        this.pendingRequest = null;
    }

    static /* synthetic */ void logSsoEvent$default(FBLoginSSOLauncher fBLoginSSOLauncher, String str, String str2, JSONObject jSONObject, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            jSONObject = null;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        fBLoginSSOLauncher.logSsoEvent(str, str2, jSONObject, str3);
    }

    private final void logSsoEvent(String eventName, String authLoggerId, JSONObject extras, String result) {
        String string;
        String string2;
        Bundle bundle = new Bundle();
        bundle.putLong(LoginLogger.EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
        String str = "";
        bundle.putString(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, authLoggerId == null ? "" : authLoggerId);
        bundle.putString(LoginLogger.EVENT_PARAM_LOGIN_RESULT, result == null ? "" : result);
        bundle.putString(LoginLogger.EVENT_PARAM_METHOD, "");
        bundle.putString(LoginLogger.EVENT_PARAM_ERROR_CODE, "");
        bundle.putString(LoginLogger.EVENT_PARAM_ERROR_MESSAGE, "");
        if (extras == null || (string = extras.toString()) == null) {
            string = "";
        }
        bundle.putString(LoginLogger.EVENT_PARAM_EXTRAS, string);
        bundle.putString(LoginLogger.EVENT_PARAM_CHALLENGE, "");
        StringBuilder sbAppend = new StringBuilder("Event: ").append(eventName).append(" | auth_logger_id=");
        if (authLoggerId == null) {
            authLoggerId = "";
        }
        StringBuilder sbAppend2 = sbAppend.append(authLoggerId).append(" | result=");
        if (result == null) {
            result = "";
        }
        StringBuilder sbAppend3 = sbAppend2.append(result).append(" | extras=");
        if (extras != null && (string2 = extras.toString()) != null) {
            str = string2;
        }
        Utility.logd(TAG, sbAppend3.append(str).toString());
        InternalAppEventsLogger appEventsLogger$facebook_common_release = getAppEventsLogger$facebook_common_release();
        if (appEventsLogger$facebook_common_release != null) {
            appEventsLogger$facebook_common_release.logEventImplicitly(eventName, bundle);
        }
    }

    private final void markFromSso(LoginClient.Result result) {
        HashMap map;
        Map<String, String> map2 = result.loggingExtras;
        if (map2 == null || (map = MapsKt.toMutableMap(map2)) == null) {
            map = new HashMap();
        }
        map.put(LoginLogger.EVENT_EXTRAS_FROM_SSO, "true");
        result.loggingExtras = map;
    }

    private final boolean isFb4aInstalled() {
        try {
            this.activity.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: compiled from: FBLoginSSOLauncher.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R0\u0010\u0007\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@@X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/facebook/login/FBLoginSSOLauncher$Companion;", "", "()V", "SSO_DISMISSED_EXTRA", "", "TAG", "<set-?>", "pendingSsoContext", "getPendingSsoContext$annotations", "getPendingSsoContext", "()Ljava/lang/String;", "setPendingSsoContext$facebook_common_release", "(Ljava/lang/String;)V", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getPendingSsoContext$annotations() {
        }

        private Companion() {
        }

        public final String getPendingSsoContext() {
            return FBLoginSSOLauncher.pendingSsoContext;
        }

        public final void setPendingSsoContext$facebook_common_release(String str) {
            FBLoginSSOLauncher.pendingSsoContext = str;
        }
    }
}
