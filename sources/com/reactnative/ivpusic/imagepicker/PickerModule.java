package com.reactnative.ivpusic.imagepicker;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;

/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = NativeImageCropPickerSpec.NAME)
public class PickerModule extends NativeImageCropPickerSpec {
    private final ImageCropPicker picker;

    public PickerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.picker = new ImageCropPicker(reactApplicationContext);
    }

    @Override // com.reactnative.ivpusic.imagepicker.NativeImageCropPickerSpec
    public void openPicker(ReadableMap readableMap, Promise promise) {
        this.picker.openPicker(readableMap, promise);
    }

    @Override // com.reactnative.ivpusic.imagepicker.NativeImageCropPickerSpec
    public void openCamera(ReadableMap readableMap, Promise promise) {
        this.picker.openCamera(readableMap, promise);
    }

    @Override // com.reactnative.ivpusic.imagepicker.NativeImageCropPickerSpec
    public void openCropper(ReadableMap readableMap, Promise promise) {
        this.picker.openCropper(readableMap, promise);
    }

    @Override // com.reactnative.ivpusic.imagepicker.NativeImageCropPickerSpec
    public void clean(Promise promise) {
        this.picker.clean(promise);
    }

    @Override // com.reactnative.ivpusic.imagepicker.NativeImageCropPickerSpec
    public void cleanSingle(String str, Promise promise) {
        this.picker.cleanSingle(str, promise);
    }
}
