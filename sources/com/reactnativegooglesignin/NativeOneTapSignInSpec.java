package com.reactnativegooglesignin;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeOneTapSignInSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNOneTapSignIn";

    @ReactMethod
    public abstract void checkPlayServices(boolean z, Promise promise);

    @ReactMethod
    public abstract void clearCachedAccessToken(String str, Promise promise);

    @ReactMethod
    public abstract void explicitSignIn(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void requestAuthorization(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void revokeAccess(Promise promise);

    @ReactMethod
    public abstract void signIn(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void signOut(Promise promise);

    public NativeOneTapSignInSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
