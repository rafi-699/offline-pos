package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.yoga.YogaDirection;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(since = "This class is part of Legacy Architecture and will be removed in a future release")
public class NativeViewHierarchyManager {
    public void setLayoutAnimationEnabled(boolean z) {
    }

    @Deprecated
    public void updateLayout(int i, int i2, int i3, int i4, int i5) {
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("NativeViewHierarchyManager", LegacyArchitectureLogLevel.ERROR);
    }

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry) {
    }

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager) {
    }

    public final synchronized View resolveView(int i) {
        return null;
    }

    public final synchronized ViewManager resolveViewManager(int i) {
        return null;
    }

    public synchronized void updateInstanceHandle(int i, long j) {
    }

    public synchronized void updateProperties(int i, ReactStylesDiffMap reactStylesDiffMap) {
    }

    public synchronized void updateViewExtraData(int i, Object obj) {
    }

    public synchronized void updateLayout(int i, int i2, int i3, int i4, int i5, int i6, YogaDirection yogaDirection) {
    }

    public synchronized long getInstanceHandle(int i) {
        return 0L;
    }

    public synchronized void createView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
    }

    public synchronized void manageChildren(int i, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
    }

    public synchronized void setChildren(int i, ReadableArray readableArray) {
    }

    public synchronized void addRootView(int i, View view) {
    }

    protected final synchronized void addRootViewGroup(int i, View view) {
    }

    protected synchronized void dropView(View view) {
    }

    public synchronized void removeRootView(int i) {
    }

    public synchronized int getRootViewNum() {
        return 0;
    }

    public synchronized void measure(int i, int[] iArr) {
    }

    public synchronized void measureInWindow(int i, int[] iArr) {
    }

    public synchronized int findTargetTagForTouch(int i, float f, float f2) {
        return 0;
    }

    public synchronized void setJSResponder(int i, int i2, boolean z) {
    }

    public synchronized void clearJSResponder() {
    }

    @Deprecated
    public synchronized void dispatchCommand(int i, int i2, ReadableArray readableArray) {
    }

    public synchronized void dispatchCommand(int i, String str, ReadableArray readableArray) {
    }

    public synchronized void sendAccessibilityEvent(int i, int i2) {
    }
}
