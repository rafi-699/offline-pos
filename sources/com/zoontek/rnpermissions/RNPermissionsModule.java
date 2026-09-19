package com.zoontek.rnpermissions;

import android.util.SparseArray;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RNPermissionsModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "RNPermissions")
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J+\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0&2\u0006\u0010'\u001a\u00020(H\u0016¢\u0006\u0002\u0010)R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/zoontek/rnpermissions/RNPermissionsModule;", "Lcom/zoontek/rnpermissions/NativeRNPermissionsSpec;", "Lcom/facebook/react/modules/core/PermissionListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "callbacks", "Landroid/util/SparseArray;", "Lcom/facebook/react/bridge/Callback;", "getName", "", "openSettings", "", "type", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "canScheduleExactAlarms", "canUseFullScreenIntent", "check", "permission", "checkNotifications", "checkMultiple", "permissions", "Lcom/facebook/react/bridge/ReadableArray;", "request", "requestNotifications", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "requestMultiple", "shouldShowRequestRationale", "checkLocationAccuracy", "requestLocationAccuracy", "purposeKey", "openPhotoPicker", "onRequestPermissionsResult", "", "requestCode", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)Z", "react-native-permissions_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RNPermissionsModule extends NativeRNPermissionsSpec implements PermissionListener {
    private final SparseArray<Callback> callbacks;

    public RNPermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.callbacks = new SparseArray<>();
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec, com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNPermissions";
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void openSettings(String type, Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.openSettings(reactApplicationContext, type, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void canScheduleExactAlarms(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.canScheduleExactAlarms(reactApplicationContext, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void canUseFullScreenIntent(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.canUseFullScreenIntent(reactApplicationContext, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void check(String permission, Promise promise) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.check(reactApplicationContext, permission, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void checkNotifications(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.checkNotifications(reactApplicationContext, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void checkMultiple(ReadableArray permissions, Promise promise) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.checkMultiple(reactApplicationContext, permissions, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void request(String permission, Promise promise) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.request(reactApplicationContext, this, this.callbacks, permission, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void requestNotifications(ReadableArray options, Promise promise) {
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.requestNotifications(reactApplicationContext, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void requestMultiple(ReadableArray permissions, Promise promise) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.requestMultiple(reactApplicationContext, this, this.callbacks, permissions, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void shouldShowRequestRationale(String permission, Promise promise) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        rNPermissionsModuleImpl.shouldShowRequestRationale(reactApplicationContext, permission, promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void checkLocationAccuracy(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl.INSTANCE.checkLocationAccuracy(promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void requestLocationAccuracy(String purposeKey, Promise promise) {
        Intrinsics.checkNotNullParameter(purposeKey, "purposeKey");
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl.INSTANCE.requestLocationAccuracy(promise);
    }

    @Override // com.zoontek.rnpermissions.NativeRNPermissionsSpec
    public void openPhotoPicker(Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        RNPermissionsModuleImpl.INSTANCE.openPhotoPicker(promise);
    }

    @Override // com.facebook.react.modules.core.PermissionListener
    public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        RNPermissionsModuleImpl rNPermissionsModuleImpl = RNPermissionsModuleImpl.INSTANCE;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        return rNPermissionsModuleImpl.onRequestPermissionsResult(reactApplicationContext, this.callbacks, requestCode, grantResults);
    }
}
