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
public abstract class NativeGoogleMobileAdsModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNGoogleMobileAdsModule";

    @ReactMethod
    public abstract void initialize(Promise promise);

    @ReactMethod
    public abstract void openAdInspector(Promise promise);

    @ReactMethod
    public abstract void openDebugMenu(String str);

    @ReactMethod
    public abstract void setAppMuted(boolean z);

    @ReactMethod
    public abstract void setAppVolume(double d);

    @ReactMethod
    public abstract void setRequestConfiguration(@Nullable ReadableMap readableMap, Promise promise);

    public NativeGoogleMobileAdsModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNGoogleMobileAdsModule";
    }
}
