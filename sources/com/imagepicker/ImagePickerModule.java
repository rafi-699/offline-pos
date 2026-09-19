package com.imagepicker;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;

/* JADX INFO: loaded from: classes4.dex */
public class ImagePickerModule extends NativeImagePickerSpec {
    final ImagePickerModuleImpl imagePickerModuleImpl;

    ImagePickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.imagePickerModuleImpl = new ImagePickerModuleImpl(reactApplicationContext);
    }

    @Override // com.imagepicker.NativeImagePickerSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NativeImagePickerSpec.NAME;
    }

    @Override // com.imagepicker.NativeImagePickerSpec
    public void launchCamera(ReadableMap readableMap, Callback callback) {
        this.imagePickerModuleImpl.launchCamera(readableMap, callback);
    }

    @Override // com.imagepicker.NativeImagePickerSpec
    public void launchImageLibrary(ReadableMap readableMap, Callback callback) {
        this.imagePickerModuleImpl.launchImageLibrary(readableMap, callback);
    }
}
