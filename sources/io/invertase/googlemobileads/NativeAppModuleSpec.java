package io.invertase.googlemobileads;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeAppModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNAppModule";

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void deleteApp(String str, Promise promise);

    @ReactMethod
    public abstract void eventsAddListener(String str);

    @ReactMethod
    public abstract void eventsGetListeners(Promise promise);

    @ReactMethod
    public abstract void eventsNotifyReady(boolean z);

    @ReactMethod
    public abstract void eventsPing(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void eventsRemoveListener(String str, boolean z);

    @ReactMethod
    public abstract void initializeApp(ReadableMap readableMap, ReadableMap readableMap2, Promise promise);

    @ReactMethod
    public abstract void jsonGetAll(Promise promise);

    @ReactMethod
    public abstract void metaGetAll(Promise promise);

    @ReactMethod
    public abstract void preferencesClearAll(Promise promise);

    @ReactMethod
    public abstract void preferencesGetAll(Promise promise);

    @ReactMethod
    public abstract void preferencesSetBool(String str, boolean z, Promise promise);

    @ReactMethod
    public abstract void preferencesSetString(String str, String str2, Promise promise);

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void setAutomaticDataCollectionEnabled(String str, boolean z);

    public NativeAppModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNAppModule";
    }
}
