package com.reactnativedocumentpicker;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeDocumentPickerSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNDocumentPicker";

    @ReactMethod(isBlockingSynchronousMethod = true)
    public abstract WritableMap isKnownType(String str, String str2);

    @ReactMethod
    public abstract void keepLocalCopy(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void pick(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void pickDirectory(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void releaseLongTermAccess(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void releaseSecureAccess(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void saveDocument(ReadableMap readableMap, Promise promise);

    @ReactMethod
    public abstract void writeDocuments(ReadableMap readableMap, Promise promise);

    public NativeDocumentPickerSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return NAME;
    }
}
