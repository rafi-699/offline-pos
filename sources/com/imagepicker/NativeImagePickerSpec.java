package com.imagepicker;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeImagePickerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "ImagePicker";

    @ReactMethod
    public abstract void launchCamera(ReadableMap readableMap, Callback callback);

    @ReactMethod
    public abstract void launchImageLibrary(ReadableMap readableMap, Callback callback);

    public NativeImagePickerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
