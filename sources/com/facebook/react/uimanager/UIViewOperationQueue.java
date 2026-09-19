package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.yoga.YogaDirection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(since = "This class is part of Legacy Architecture and will be removed in a future release")
public class UIViewOperationQueue {
    public static final int DEFAULT_MIN_TIME_LEFT_IN_FRAME_FOR_NONBATCHED_OPERATION_MS = 8;

    public interface UIOperation {
        void execute();
    }

    public void addRootView(int i, View view) {
    }

    public void dispatchViewUpdates(int i, long j, long j2) {
    }

    public void enqueueClearJSResponder() {
    }

    public void enqueueConfigureLayoutAnimation(ReadableMap readableMap, Callback callback) {
    }

    public void enqueueCreateView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
    }

    @Deprecated
    public void enqueueDispatchCommand(int i, int i2, ReadableArray readableArray) {
    }

    public void enqueueDispatchCommand(int i, String str, ReadableArray readableArray) {
    }

    public void enqueueFindTargetForTouch(int i, float f, float f2, Callback callback) {
    }

    public void enqueueLayoutUpdateFinished(ReactShadowNode reactShadowNode, UIImplementation.LayoutUpdateListener layoutUpdateListener) {
    }

    public void enqueueManageChildren(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
    }

    public void enqueueMeasure(int i, Callback callback) {
    }

    public void enqueueMeasureInWindow(int i, Callback callback) {
    }

    public void enqueueRemoveRootView(int i) {
    }

    public void enqueueSendAccessibilityEvent(int i, int i2) {
    }

    public void enqueueSetChildren(int i, ReadableArray readableArray) {
    }

    public void enqueueSetJSResponder(int i, int i2, boolean z) {
    }

    public void enqueueSetLayoutAnimationEnabled(boolean z) {
    }

    public void enqueueUIBlock(UIBlock uIBlock) {
    }

    protected void enqueueUIOperation(UIOperation uIOperation) {
    }

    public void enqueueUpdateExtraData(int i, Object obj) {
    }

    public void enqueueUpdateInstanceHandle(int i, long j) {
    }

    @Deprecated
    public void enqueueUpdateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
    }

    public void enqueueUpdateLayout(int i, int i2, int i3, int i4, int i5, int i6, YogaDirection yogaDirection) {
    }

    public void enqueueUpdateProperties(int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
    }

    public boolean isEmpty() {
        return true;
    }

    void pauseFrameCallback() {
    }

    public void prependUIBlock(UIBlock uIBlock) {
    }

    public void profileNextBatch() {
    }

    void resumeFrameCallback() {
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("UIViewOperationQueue", LegacyArchitectureLogLevel.ERROR);
    }

    public UIViewOperationQueue(ReactApplicationContext reactApplicationContext, int i) {
    }

    public Map<String, Long> getProfiledBatchPerfCounters() {
        return new HashMap();
    }
}
