package io.invertase.googlemobileads;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeGoogleMobileAdsNativeModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNGoogleMobileAdsNativeModule";

    @ReactMethod
    public abstract void destroy(String str);

    @ReactMethod
    public abstract void load(String str, ReadableMap readableMap, Promise promise);

    public NativeGoogleMobileAdsNativeModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNGoogleMobileAdsNativeModule";
    }

    protected final void emitOnAdEvent(ReadableMap readableMap) {
        this.mEventEmitterCallback.invoke("onAdEvent", readableMap);
    }
}
