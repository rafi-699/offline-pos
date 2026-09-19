package com.reactnativecommunity.cameraroll;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeCameraRollModuleSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNCCameraRoll";

    @ReactMethod
    public abstract void addListener(String str);

    @ReactMethod
    public abstract void deletePhotos(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void getAlbums(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void getPhotoByInternalID(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void getPhotoThumbnail(String str, ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void getPhotos(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void removeListeners(double d);

    @ReactMethod
    public abstract void saveToCameraRoll(String str, ReadableMap readableMap, Promise promise);

    public NativeCameraRollModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNCCameraRoll";
    }
}
