package com.reactnativegooglesignin;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import androidx.core.app.ActivityCompat;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManager;
import androidx.credentials.CredentialOption;
import androidx.credentials.CustomCredential;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialProviderConfigurationException;
import androidx.credentials.exceptions.NoCredentialException;
import com.facebook.internal.NativeProtocol;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseActivityEventListener;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.util.RNLog;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.auth.api.identity.ClearTokenRequest;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.opencv.imgproc.Imgproc;

/* JADX INFO: compiled from: RNOneTapSignInModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0013\u0018\u0000 32\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010*\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0018\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u00100\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u00101\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u00102\u001a\u00020\u0016H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u00064"}, d2 = {"Lcom/reactnativegooglesignin/RNOneTapSignInModule;", "Lcom/reactnativegooglesignin/NativeOneTapSignInSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "credentialManager", "Landroidx/credentials/CredentialManager;", "getCredentialManager", "()Landroidx/credentials/CredentialManager;", "credentialManager$delegate", "Lkotlin/Lazy;", "requestAuthorizationPromiseWrapper", "Lcom/reactnativegooglesignin/PromiseWrapper;", "oneTapUtils", "Lcom/reactnativegooglesignin/OneTapUtils$OneTapUtils;", "didCheckPlayServicesPresence", "", "activityEventListener", "com/reactnativegooglesignin/RNOneTapSignInModule$activityEventListener$1", "Lcom/reactnativegooglesignin/RNOneTapSignInModule$activityEventListener$1;", "invalidate", "", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "explicitSignIn", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/facebook/react/bridge/ReadableMap;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "signIn", "signInInternal", "credentialOption", "Landroidx/credentials/CredentialOption;", "handleSignInError", "e", "Landroidx/credentials/exceptions/GetCredentialException;", "handleSignInSuccess", "result", "Landroidx/credentials/GetCredentialResponse;", "requestAuthorization", "checkPlayServices", "showErrorResolutionDialog", "clearCachedAccessToken", "tokenString", "", "signOut", "revokeAccess", "warnIfCheckPlayServicesPresenceNotCalled", "Companion", "react-native-google-signin_google-signin_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RNOneTapSignInModule extends NativeOneTapSignInSpec {
    public static final String ONE_TAP_START_FAILED = "ONE_TAP_START_FAILED";
    public static final int REQUEST_AUTHORIZE = 9002;
    public static final int REQUEST_PLAY_SERVICES = 9003;
    private final RNOneTapSignInModule$activityEventListener$1 activityEventListener;

    /* JADX INFO: renamed from: credentialManager$delegate, reason: from kotlin metadata */
    private final Lazy credentialManager;
    private boolean didCheckPlayServicesPresence;
    private final OneTapUtils.C0053OneTapUtils oneTapUtils;
    private final PromiseWrapper requestAuthorizationPromiseWrapper;

    @Override // com.reactnativegooglesignin.NativeOneTapSignInSpec
    public void revokeAccess(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.reactnativegooglesignin.RNOneTapSignInModule$activityEventListener$1] */
    public RNOneTapSignInModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.credentialManager = LazyKt.lazy(new Function0() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RNOneTapSignInModule.credentialManager_delegate$lambda$0(this.f$0);
            }
        });
        this.requestAuthorizationPromiseWrapper = new PromiseWrapper(NativeOneTapSignInSpec.NAME);
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        this.oneTapUtils = new OneTapUtils.C0053OneTapUtils(reactApplicationContext);
        ?? r0 = new BaseActivityEventListener() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$activityEventListener$1
            @Override // com.facebook.react.bridge.BaseActivityEventListener, com.facebook.react.bridge.ActivityEventListener
            public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                if (requestCode != 9002) {
                    return;
                }
                if (resultCode != -1) {
                    if (resultCode != 0) {
                        this.this$0.requestAuthorizationPromiseWrapper.reject("Failed to add scopes.");
                        return;
                    } else {
                        this.this$0.requestAuthorizationPromiseWrapper.resolve(this.this$0.oneTapUtils.getCanceledResult());
                        return;
                    }
                }
                try {
                    AuthorizationResult authorizationResultFromIntent = Identity.getAuthorizationClient(activity).getAuthorizationResultFromIntent(data);
                    Intrinsics.checkNotNullExpressionValue(authorizationResultFromIntent, "getAuthorizationResultFromIntent(...)");
                    this.this$0.requestAuthorizationPromiseWrapper.resolve(this.this$0.oneTapUtils.authorizationResultToJsMap(authorizationResultFromIntent));
                } catch (Exception e) {
                    this.this$0.requestAuthorizationPromiseWrapper.reject(e);
                }
            }
        };
        this.activityEventListener = r0;
        reactContext.addActivityEventListener((ActivityEventListener) r0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CredentialManager credentialManager_delegate$lambda$0(RNOneTapSignInModule rNOneTapSignInModule) {
        CredentialManager.Companion companion = CredentialManager.INSTANCE;
        ReactApplicationContext reactApplicationContext = rNOneTapSignInModule.getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return companion.create(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CredentialManager getCredentialManager() {
        return (CredentialManager) this.credentialManager.getValue();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void invalidate() {
        getReactApplicationContext().removeActivityEventListener(this.activityEventListener);
        super.invalidate();
    }

    public final Activity getActivity() {
        return getReactApplicationContext().getCurrentActivity();
    }

    @Override // com.reactnativegooglesignin.NativeOneTapSignInSpec
    public void explicitSignIn(ReadableMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        signInInternal(this.oneTapUtils.buildExplicitOneTapSignInRequest(params), promise);
    }

    @Override // com.reactnativegooglesignin.NativeOneTapSignInSpec
    public void signIn(ReadableMap params, Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        signInInternal(this.oneTapUtils.buildOneTapSignInRequest(params), promise);
    }

    private final void signInInternal(CredentialOption credentialOption, Promise promise) {
        Activity activity = getActivity();
        if (activity == null) {
            RNGoogleSigninModule.rejectWithNullActivity(promise);
            return;
        }
        warnIfCheckPlayServicesPresenceNotCalled();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate()), null, null, new AnonymousClass1(activity, new GetCredentialRequest.Builder().addCredentialOption(credentialOption).build(), promise, null), 3, null);
    }

    /* JADX INFO: renamed from: com.reactnativegooglesignin.RNOneTapSignInModule$signInInternal$1, reason: invalid class name */
    /* JADX INFO: compiled from: RNOneTapSignInModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.reactnativegooglesignin.RNOneTapSignInModule$signInInternal$1", f = "RNOneTapSignInModule.kt", i = {}, l = {Imgproc.COLOR_YUV2RGBA_YVYU}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ Promise $promise;
        final /* synthetic */ GetCredentialRequest $request;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, GetCredentialRequest getCredentialRequest, Promise promise, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
            this.$request = getCredentialRequest;
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RNOneTapSignInModule.this.new AnonymousClass1(this.$activity, this.$request, this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = RNOneTapSignInModule.this.getCredentialManager().getCredential(this.$activity, this.$request, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                RNOneTapSignInModule.this.handleSignInSuccess((GetCredentialResponse) obj, this.$promise);
            } catch (GetCredentialException e) {
                RNOneTapSignInModule.this.handleSignInError(e, this.$promise);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSignInError(GetCredentialException e, Promise promise) {
        String lowerCase;
        if (e instanceof GetCredentialCancellationException) {
            promise.resolve(this.oneTapUtils.getCanceledResult());
            return;
        }
        if (e instanceof NoCredentialException) {
            if (Intrinsics.areEqual(e.getType(), "android.credentials.GetCredentialException.TYPE_NO_CREDENTIAL")) {
                String message = e.getMessage();
                if (message != null) {
                    lowerCase = message.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                } else {
                    lowerCase = null;
                }
                if (lowerCase != null && StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "too many canceled sign-in prompts", false, 2, (Object) null)) {
                    promise.reject(ONE_TAP_START_FAILED, e.getMessage(), e);
                    return;
                } else if (lowerCase != null && StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "developer console is not set up correctly", false, 2, (Object) null)) {
                    promise.reject("10", "DEVELOPER_ERROR: Follow troubleshooting instructions at https://react-native-google-signin.github.io/docs/troubleshooting . " + e.getMessage(), e);
                    return;
                } else {
                    promise.resolve(this.oneTapUtils.getNoSavedCredentialsResult());
                    return;
                }
            }
            promise.reject(e.getType(), e.getMessage(), e);
            return;
        }
        if (e instanceof GetCredentialProviderConfigurationException) {
            promise.reject(RNGoogleSigninModule.PLAY_SERVICES_NOT_AVAILABLE, e.getType() + ": " + e.getMessage(), e);
            return;
        }
        promise.reject(e.getType(), e.getMessage(), e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSignInSuccess(GetCredentialResponse result, Promise promise) {
        Credential credential = result.getCredential();
        if (credential instanceof CustomCredential) {
            if (Intrinsics.areEqual(credential.getType(), GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL)) {
                try {
                    promise.resolve(this.oneTapUtils.getUserProperties(GoogleIdTokenCredential.INSTANCE.createFrom(credential.getData())));
                    return;
                } catch (Exception e) {
                    promise.reject(NativeOneTapSignInSpec.NAME, e);
                    return;
                }
            }
            promise.reject(NativeOneTapSignInSpec.NAME, "Unexpected type of custom credential: " + credential.getType());
            return;
        }
        promise.reject(NativeOneTapSignInSpec.NAME, "Unexpected type of credential: " + credential.getType());
    }

    @Override // com.reactnativegooglesignin.NativeOneTapSignInSpec
    public void requestAuthorization(ReadableMap params, final Promise promise) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final Activity activity = getActivity();
        if (activity == null) {
            RNGoogleSigninModule.rejectWithNullActivity(promise);
            return;
        }
        warnIfCheckPlayServicesPresenceNotCalled();
        Task<AuthorizationResult> taskAuthorize = Identity.getAuthorizationClient(activity).authorize(this.oneTapUtils.buildAuthorizationRequest(params));
        final Function1 function1 = new Function1() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RNOneTapSignInModule.requestAuthorization$lambda$3(this.f$0, promise, activity, (AuthorizationResult) obj);
            }
        };
        taskAuthorize.addOnSuccessListener(new OnSuccessListener() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                function1.invoke(obj);
            }
        }).addOnCanceledListener(new OnCanceledListener() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                RNOneTapSignInModule.requestAuthorization$lambda$5(promise, this);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                RNOneTapSignInModule.requestAuthorization$lambda$6(promise, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestAuthorization$lambda$3(RNOneTapSignInModule rNOneTapSignInModule, Promise promise, Activity activity, AuthorizationResult authorizationResult) {
        if (authorizationResult.hasResolution()) {
            try {
                PendingIntent pendingIntent = authorizationResult.getPendingIntent();
                Intrinsics.checkNotNull(pendingIntent);
                rNOneTapSignInModule.requestAuthorizationPromiseWrapper.setPromiseWithInProgressCheck(promise, "requestAuthorization");
                ActivityCompat.startIntentSenderForResult(activity, pendingIntent.getIntentSender(), 9002, null, 0, 0, 0, null);
            } catch (IntentSender.SendIntentException e) {
                promise.reject("requestAuthorization", "Couldn't start Authorization UI: " + e.getLocalizedMessage(), e);
            }
        } else {
            OneTapUtils.C0053OneTapUtils c0053OneTapUtils = rNOneTapSignInModule.oneTapUtils;
            Intrinsics.checkNotNull(authorizationResult);
            promise.resolve(c0053OneTapUtils.authorizationResultToJsMap(authorizationResult));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestAuthorization$lambda$5(Promise promise, RNOneTapSignInModule rNOneTapSignInModule) {
        promise.resolve(rNOneTapSignInModule.oneTapUtils.getCanceledResult());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestAuthorization$lambda$6(Promise promise, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        promise.reject("requestAuthorization", e);
    }

    @Override // com.reactnativegooglesignin.NativeOneTapSignInSpec
    public void checkPlayServices(boolean showErrorResolutionDialog, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        final Activity activity = getActivity();
        if (activity == null) {
            RNGoogleSigninModule.rejectWithNullActivity(promise);
            return;
        }
        final GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();
        Intrinsics.checkNotNullExpressionValue(googleApiAvailability, "getInstance(...)");
        final int iIsGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(activity);
        this.didCheckPlayServicesPresence = true;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt("minRequiredVersion", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        Long lInstalledGooglePlayServicesVersion = this.oneTapUtils.installedGooglePlayServicesVersion();
        writableMapCreateMap.putDouble("installedVersion", lInstalledGooglePlayServicesVersion != null ? lInstalledGooglePlayServicesVersion.longValue() : -1L);
        if (iIsGooglePlayServicesAvailable == 0) {
            promise.resolve(writableMapCreateMap);
            return;
        }
        boolean zIsUserResolvableError = googleApiAvailability.isUserResolvableError(iIsGooglePlayServicesAvailable);
        if (showErrorResolutionDialog && zIsUserResolvableError) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    RNOneTapSignInModule.checkPlayServices$lambda$9(googleApiAvailability, activity, iIsGooglePlayServicesAvailable);
                }
            });
        }
        String errorString = googleApiAvailability.getErrorString(iIsGooglePlayServicesAvailable);
        Intrinsics.checkNotNullExpressionValue(errorString, "getErrorString(...)");
        writableMapCreateMap.putBoolean("isUserResolvableError", zIsUserResolvableError);
        writableMapCreateMap.putString("errorDescription", errorString);
        promise.reject(RNGoogleSigninModule.PLAY_SERVICES_NOT_AVAILABLE, errorString, writableMapCreateMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPlayServices$lambda$9(GoogleApiAvailability googleApiAvailability, Activity activity, int i) {
        Dialog errorDialog = googleApiAvailability.getErrorDialog(activity, i, 9003);
        if (errorDialog != null) {
            errorDialog.show();
        }
    }

    @Override // com.reactnativegooglesignin.NativeOneTapSignInSpec
    public void clearCachedAccessToken(String tokenString, final Promise promise) {
        Intrinsics.checkNotNullParameter(tokenString, "tokenString");
        Intrinsics.checkNotNullParameter(promise, "promise");
        Activity activity = getActivity();
        if (activity == null) {
            RNGoogleSigninModule.rejectWithNullActivity(promise);
            return;
        }
        Task<Void> taskClearToken = Identity.getAuthorizationClient(activity).clearToken(ClearTokenRequest.builder().setToken(tokenString).build());
        final Function1 function1 = new Function1() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return RNOneTapSignInModule.clearCachedAccessToken$lambda$11(promise, (Void) obj);
            }
        };
        taskClearToken.addOnSuccessListener(new OnSuccessListener() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                function1.invoke(obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                RNOneTapSignInModule.clearCachedAccessToken$lambda$13(promise, exc);
            }
        }).addOnCanceledListener(new OnCanceledListener() { // from class: com.reactnativegooglesignin.RNOneTapSignInModule$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCanceledListener
            public final void onCanceled() {
                promise.reject("clearCachedAccessToken", "task was cancelled");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clearCachedAccessToken$lambda$11(Promise promise, Void r1) {
        promise.resolve(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCachedAccessToken$lambda$13(Promise promise, Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        promise.reject(e);
    }

    /* JADX INFO: renamed from: com.reactnativegooglesignin.RNOneTapSignInModule$signOut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RNOneTapSignInModule.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.reactnativegooglesignin.RNOneTapSignInModule$signOut$1", f = "RNOneTapSignInModule.kt", i = {}, l = {289}, m = "invokeSuspend", n = {}, s = {})
    static final class C01531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Promise $promise;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01531(Promise promise, Continuation<? super C01531> continuation) {
            super(2, continuation);
            this.$promise = promise;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RNOneTapSignInModule.this.new C01531(this.$promise, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C01531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (RNOneTapSignInModule.this.getCredentialManager().clearCredentialState(new ClearCredentialStateRequest(null, 1, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                this.$promise.resolve(null);
            } catch (Exception e) {
                this.$promise.reject("signOut", e);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.reactnativegooglesignin.NativeOneTapSignInSpec
    public void signOut(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C01531(promise, null), 3, null);
    }

    private final void warnIfCheckPlayServicesPresenceNotCalled() {
        if (this.didCheckPlayServicesPresence) {
            return;
        }
        RNLog.w(getReactApplicationContext(), "RNOneTapSignIn: Call `checkPlayServices()` before using Sign-In features.\nThis verifies that Google Sign-In is supported on the user's device.\n\nExample:\nawait GoogleOneTapSignIn.checkPlayServices()\n");
    }
}
