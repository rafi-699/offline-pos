package com.zoontek.rnpermissions;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NativeRNPermissionsSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "RNPermissions";

    @ReactMethod
    public abstract void canScheduleExactAlarms(Promise promise);

    @ReactMethod
    public abstract void canUseFullScreenIntent(Promise promise);

    @ReactMethod
    public abstract void check(String str, Promise promise);

    @ReactMethod
    public abstract void checkLocationAccuracy(Promise promise);

    @ReactMethod
    public abstract void checkMultiple(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void checkNotifications(Promise promise);

    @ReactMethod
    public abstract void openPhotoPicker(Promise promise);

    @ReactMethod
    public abstract void openSettings(String str, Promise promise);

    @ReactMethod
    public abstract void request(String str, Promise promise);

    @ReactMethod
    public abstract void requestLocationAccuracy(String str, Promise promise);

    @ReactMethod
    public abstract void requestMultiple(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void requestNotifications(ReadableArray readableArray, Promise promise);

    @ReactMethod
    public abstract void shouldShowRequestRationale(String str, Promise promise);

    public NativeRNPermissionsSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNPermissions";
    }
}
