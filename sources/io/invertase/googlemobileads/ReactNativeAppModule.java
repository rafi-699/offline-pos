package io.invertase.googlemobileads;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import io.invertase.googlemobileads.common.RCTConvert;
import io.invertase.googlemobileads.common.ReactNativeEvent;
import io.invertase.googlemobileads.common.ReactNativeEventEmitter;
import io.invertase.googlemobileads.common.ReactNativeJSON;
import io.invertase.googlemobileads.common.ReactNativeMeta;
import io.invertase.googlemobileads.common.ReactNativePreferences;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeAppModule extends NativeAppModuleSpec {
    public static final String NAME = "RNAppModule";

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void addListener(String str) {
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void removeListeners(double d) {
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void setAutomaticDataCollectionEnabled(String str, boolean z) {
    }

    ReactNativeAppModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        super.initialize();
        ReactNativeEventEmitter.getSharedInstance().attachReactContext(getReactApplicationContext());
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void initializeApp(ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        promise.resolve(readableMap);
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void deleteApp(String str, Promise promise) {
        promise.resolve(null);
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void eventsNotifyReady(boolean z) {
        ReactNativeEventEmitter.getSharedInstance().notifyJsReady(Boolean.valueOf(z));
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void eventsGetListeners(Promise promise) {
        promise.resolve(ReactNativeEventEmitter.getSharedInstance().getListenersMap());
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void eventsPing(String str, ReadableMap readableMap, Promise promise) {
        ReactNativeEventEmitter.getSharedInstance().sendEvent(new ReactNativeEvent(str, RCTConvert.readableMapToWritableMap(readableMap)));
        promise.resolve(RCTConvert.readableMapToWritableMap(readableMap));
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void eventsAddListener(String str) {
        ReactNativeEventEmitter.getSharedInstance().addListener(str);
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void eventsRemoveListener(String str, boolean z) {
        ReactNativeEventEmitter.getSharedInstance().removeListener(str, Boolean.valueOf(z));
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void metaGetAll(Promise promise) {
        promise.resolve(ReactNativeMeta.getSharedInstance().getAll());
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void jsonGetAll(Promise promise) {
        promise.resolve(ReactNativeJSON.getSharedInstance().getAll());
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void preferencesSetBool(String str, boolean z, Promise promise) {
        ReactNativePreferences.getSharedInstance().setBooleanValue(str, z);
        promise.resolve(null);
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void preferencesSetString(String str, String str2, Promise promise) {
        ReactNativePreferences.getSharedInstance().setStringValue(str, str2);
        promise.resolve(null);
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void preferencesGetAll(Promise promise) {
        promise.resolve(ReactNativePreferences.getSharedInstance().getAll());
    }

    @Override // io.invertase.googlemobileads.NativeAppModuleSpec
    @ReactMethod
    public void preferencesClearAll(Promise promise) {
        ReactNativePreferences.getSharedInstance().clearAll();
        promise.resolve(null);
    }
}
