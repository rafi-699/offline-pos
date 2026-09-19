package com.swmansion.worklets;

import android.content.res.AssetManager;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.soloader.SoLoader;
import com.swmansion.worklets.runloop.AnimationFrameCallback;
import com.swmansion.worklets.runloop.AnimationFrameQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkletsModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = "WorkletsModule")
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0004J3\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0082 J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0017J\b\u0010\u001e\u001a\u00020\u0011H\u0017J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J\b\u0010#\u001a\u00020\u0011H\u0007J\u0006\u0010$\u001a\u00020 J\b\u0010%\u001a\u00020\u0011H\u0017J\b\u0010&\u001a\u00020 H\u0016J\t\u0010'\u001a\u00020 H\u0082 J\t\u0010(\u001a\u00020 H\u0082 J\b\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020 H\u0016J\b\u0010+\u001a\u00020 H\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\nR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/swmansion/worklets/WorkletsModule;", "Lcom/swmansion/worklets/NativeWorkletsModuleSpec;", "Lcom/facebook/react/bridge/LifecycleEventListener;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "getMHybridData$annotations", "()V", "getHybridData", "mAndroidUIScheduler", "Lcom/swmansion/worklets/AndroidUIScheduler;", "mAnimationFrameQueue", "Lcom/swmansion/worklets/runloop/AnimationFrameQueue;", "mSlowAnimationsEnabled", "", "mInvalidated", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initHybrid", "bundleModeEnabled", "jsContext", "", "jsCallInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "androidUIScheduler", "scriptBufferWrapper", "Lcom/swmansion/worklets/ScriptBufferWrapper;", "installTurboModule", "start", "requestAnimationFrame", "", "animationFrameCallback", "Lcom/swmansion/worklets/runloop/AnimationFrameCallback;", "isOnJSQueueThread", "toggleSlowAnimations", "toggleSlowAnimationsOnUIRuntime", "invalidate", "invalidateCpp", "startCpp", "onHostResume", "onHostPause", "onHostDestroy", "Companion", "react-native-worklets_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkletsModule extends NativeWorkletsModuleSpec implements LifecycleEventListener {
    public static final String NAME = "WorkletsModule";
    private final AndroidUIScheduler mAndroidUIScheduler;
    private final AnimationFrameQueue mAnimationFrameQueue;
    private HybridData mHybridData;
    private final AtomicBoolean mInvalidated;
    private boolean mSlowAnimationsEnabled;

    private static /* synthetic */ void getMHybridData$annotations() {
    }

    private final native HybridData initHybrid(boolean bundleModeEnabled, long jsContext, CallInvokerHolderImpl jsCallInvokerHolder, AndroidUIScheduler androidUIScheduler, ScriptBufferWrapper scriptBufferWrapper);

    private final native void invalidateCpp();

    private final native void startCpp();

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WorkletsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        reactContext.assertOnJSQueueThread();
        this.mAndroidUIScheduler = new AndroidUIScheduler(reactContext);
        this.mAnimationFrameQueue = new AnimationFrameQueue(reactContext);
        this.mInvalidated = new AtomicBoolean(false);
    }

    static {
        SoLoader.loadLibrary("worklets");
    }

    /* JADX INFO: renamed from: getHybridData, reason: from getter */
    protected final HybridData getMHybridData() {
        return this.mHybridData;
    }

    @Override // com.swmansion.worklets.NativeWorkletsModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean installTurboModule(boolean bundleModeEnabled) {
        ScriptBufferWrapper scriptBufferWrapper;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        reactApplicationContext.assertOnJSQueueThread();
        JavaScriptContextHolder javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder();
        if (javaScriptContextHolder == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        long context = javaScriptContextHolder.getContext();
        CallInvokerHolder jSCallInvokerHolder = reactApplicationContext.getJSCallInvokerHolder();
        Intrinsics.checkNotNull(jSCallInvokerHolder, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
        CallInvokerHolderImpl callInvokerHolderImpl = (CallInvokerHolderImpl) jSCallInvokerHolder;
        String sourceURL = reactApplicationContext.getSourceURL();
        if (bundleModeEnabled) {
            Intrinsics.checkNotNull(sourceURL);
            AssetManager assets = reactApplicationContext.getAssets();
            Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
            scriptBufferWrapper = new ScriptBufferWrapper(sourceURL, assets);
        } else {
            scriptBufferWrapper = null;
        }
        this.mHybridData = initHybrid(bundleModeEnabled, context, callInvokerHolderImpl, this.mAndroidUIScheduler, scriptBufferWrapper);
        return true;
    }

    @Override // com.swmansion.worklets.NativeWorkletsModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean start() {
        getReactApplicationContext().assertOnJSQueueThread();
        startCpp();
        return true;
    }

    public final void requestAnimationFrame(AnimationFrameCallback animationFrameCallback) {
        Intrinsics.checkNotNullParameter(animationFrameCallback, "animationFrameCallback");
        this.mAnimationFrameQueue.requestAnimationFrame(animationFrameCallback);
    }

    public final boolean isOnJSQueueThread() {
        return getReactApplicationContext().isOnJSQueueThread();
    }

    public final void toggleSlowAnimations() {
        boolean z = !this.mSlowAnimationsEnabled;
        this.mSlowAnimationsEnabled = z;
        this.mAnimationFrameQueue.enableSlowAnimations(z, 10);
    }

    @Override // com.swmansion.worklets.NativeWorkletsModuleSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean toggleSlowAnimationsOnUIRuntime() {
        toggleSlowAnimations();
        return this.mSlowAnimationsEnabled;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void invalidate() {
        if (this.mInvalidated.getAndSet(true)) {
            return;
        }
        HybridData hybridData = this.mHybridData;
        if (hybridData != null) {
            Intrinsics.checkNotNull(hybridData);
            if (hybridData.isValid()) {
                invalidateCpp();
            }
        }
        this.mAndroidUIScheduler.deactivate();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.mAnimationFrameQueue.resume();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this.mAnimationFrameQueue.pause();
    }
}
