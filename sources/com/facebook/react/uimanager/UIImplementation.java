package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogLevel;
import com.facebook.react.common.annotations.internal.LegacyArchitectureLogger;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated(since = "This class is part of Legacy Architecture and will be removed in a future release")
public class UIImplementation {

    public interface LayoutUpdateListener {
        void onLayoutUpdated(ReactShadowNode reactShadowNode);
    }

    public void addUIBlock(UIBlock uIBlock) {
    }

    protected void calculateRootLayout(ReactShadowNode reactShadowNode) {
    }

    public void clearJSResponder() {
    }

    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback) {
    }

    protected ReactShadowNode createRootShadowNode() {
        return null;
    }

    protected ReactShadowNode createShadowNode(String str) {
        return null;
    }

    public void createView(int i, String str, int i2, ReadableMap readableMap) {
    }

    @Deprecated
    public void dispatchViewManagerCommand(int i, int i2, ReadableArray readableArray) {
    }

    public void dispatchViewManagerCommand(int i, String str, ReadableArray readableArray) {
    }

    public void dispatchViewUpdates(int i) {
    }

    public void findSubviewIn(int i, float f, float f2, Callback callback) {
    }

    public int getRootViewNum() {
        return 0;
    }

    UIViewOperationQueue getUIViewOperationQueue() {
        return null;
    }

    protected void handleCreateView(ReactShadowNode reactShadowNode, int i, ReactStylesDiffMap reactStylesDiffMap) {
    }

    protected void handleUpdateView(ReactShadowNode reactShadowNode, String str, ReactStylesDiffMap reactStylesDiffMap) {
    }

    public void manageChildren(int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
    }

    public void measure(int i, Callback callback) {
    }

    public void measureInWindow(int i, Callback callback) {
    }

    public void measureLayout(int i, int i2, Callback callback, Callback callback2) {
    }

    public void measureLayoutRelativeToParent(int i, Callback callback, Callback callback2) {
    }

    public void onCatalystInstanceDestroyed() {
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    public void prependUIBlock(UIBlock uIBlock) {
    }

    public void profileNextBatch() {
    }

    public <T extends View> void registerRootView(T t, int i, ThemedReactContext themedReactContext) {
    }

    public void removeLayoutUpdateListener() {
    }

    public void removeRootShadowNode(int i) {
    }

    public void removeRootView(int i) {
    }

    protected final void removeShadowNode(ReactShadowNode reactShadowNode) {
    }

    public void replaceExistingNonRootView(int i, int i2) {
    }

    public int resolveRootTagFromReactTag(int i) {
        return 0;
    }

    public final ReactShadowNode resolveShadowNode(int i) {
        return null;
    }

    protected final ViewManager resolveViewManager(String str) {
        return null;
    }

    public void sendAccessibilityEvent(int i, int i2) {
    }

    public void setChildren(int i, ReadableArray readableArray) {
    }

    public void setJSResponder(int i, boolean z) {
    }

    public void setLayoutAnimationEnabledExperimental(boolean z) {
    }

    public void setLayoutUpdateListener(LayoutUpdateListener layoutUpdateListener) {
    }

    public void setViewLocalData(int i, Object obj) {
    }

    public void synchronouslyUpdateViewOnUIThread(int i, ReactStylesDiffMap reactStylesDiffMap) {
    }

    public void updateInsetsPadding(int i, int i2, int i3, int i4, int i5) {
    }

    public void updateNodeSize(int i, int i2, int i3) {
    }

    public void updateRootView(int i, int i2, int i3) {
    }

    public void updateRootView(ReactShadowNode reactShadowNode, int i, int i2) {
    }

    public void updateView(int i, String str, ReadableMap readableMap) {
    }

    protected void updateViewHierarchy() {
    }

    @Deprecated
    public void viewIsDescendantOf(int i, int i2, Callback callback) {
    }

    static {
        LegacyArchitectureLogger.assertLegacyArchitecture("UIImplementation", LegacyArchitectureLogLevel.ERROR);
    }

    UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, EventDispatcher eventDispatcher, int i) {
    }

    protected UIImplementation(ReactApplicationContext reactApplicationContext, ViewManagerRegistry viewManagerRegistry, UIViewOperationQueue uIViewOperationQueue, EventDispatcher eventDispatcher) {
    }

    public Map<String, Long> getProfiledBatchPerfCounters() {
        return new HashMap();
    }
}
