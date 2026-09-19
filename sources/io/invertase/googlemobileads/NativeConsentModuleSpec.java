package io.invertase.googlemobileads;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeConsentModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNGoogleMobileAdsConsentModule";

    @ReactMethod
    public abstract void getConsentInfo(Promise promise);

    @ReactMethod
    public abstract void getGdprApplies(Promise promise);

    @ReactMethod
    public abstract void getPurposeConsents(Promise promise);

    @ReactMethod
    public abstract void getPurposeLegitimateInterests(Promise promise);

    @ReactMethod
    public abstract void getTCString(Promise promise);

    @ReactMethod
    public abstract void loadAndShowConsentFormIfRequired(Promise promise);

    @ReactMethod
    public abstract void requestInfoUpdate(@Nullable ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void reset();

    @ReactMethod
    public abstract void showForm(Promise promise);

    @ReactMethod
    public abstract void showPrivacyOptionsForm(Promise promise);

    public NativeConsentModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
