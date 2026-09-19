package io.invertase.googlemobileads;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNGoogleMobileAdsNativeViewManagerDelegate;
import com.facebook.react.viewmanagers.RNGoogleMobileAdsNativeViewManagerInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeGoogleMobileAdsNativeAdViewManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = ReactNativeGoogleMobileAdsNativeAdViewManager.NAME)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001#B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0002H\u0014J\u001a\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\fH\u0017J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u001a\u0010!\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001aH\u0016J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001aH\u0016R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsNativeAdViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsNativeAdView;", "Lcom/facebook/react/viewmanagers/RNGoogleMobileAdsNativeViewManagerInterface;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "getName", "", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "onDropViewInstance", "", "adView", "prepareToRecycleView", ViewHierarchyConstants.VIEW_KEY, "setResponseId", "responseId", "registerAsset", "assetKey", "reactTag", "", "addView", "parent", "child", "Landroid/view/View;", FirebaseAnalytics.Param.INDEX, "getChildCount", "getChildAt", "removeViewAt", "Companion", "react-native-google-mobile-ads_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeGoogleMobileAdsNativeAdViewManager extends ViewGroupManager<ReactNativeGoogleMobileAdsNativeAdView> implements RNGoogleMobileAdsNativeViewManagerInterface<ReactNativeGoogleMobileAdsNativeAdView> {
    public static final String NAME = "RNGoogleMobileAdsNativeView";
    private final ViewManagerDelegate<ReactNativeGoogleMobileAdsNativeAdView> delegate;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public ReactNativeGoogleMobileAdsNativeAdView prepareToRecycleView(ThemedReactContext reactContext, ReactNativeGoogleMobileAdsNativeAdView view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        return null;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeGoogleMobileAdsNativeAdViewManager(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.delegate = new RNGoogleMobileAdsNativeViewManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ReactNativeGoogleMobileAdsNativeAdView> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactNativeGoogleMobileAdsNativeAdView createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ReactNativeGoogleMobileAdsNativeAdView(context);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ReactNativeGoogleMobileAdsNativeAdView adView) {
        Intrinsics.checkNotNullParameter(adView, "adView");
        super.onDropViewInstance(adView);
        adView.destroy();
    }

    @Override // com.facebook.react.viewmanagers.RNGoogleMobileAdsNativeViewManagerInterface
    @ReactProp(name = "responseId")
    public void setResponseId(ReactNativeGoogleMobileAdsNativeAdView view, String responseId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setResponseId(responseId);
    }

    @Override // com.facebook.react.viewmanagers.RNGoogleMobileAdsNativeViewManagerInterface
    @ReactMethod
    public void registerAsset(ReactNativeGoogleMobileAdsNativeAdView view, String assetKey, int reactTag) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(assetKey, "assetKey");
        view.registerAsset(assetKey, reactTag);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(ReactNativeGoogleMobileAdsNativeAdView parent, View child, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        parent.getViewGroup().addView(child, index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(ReactNativeGoogleMobileAdsNativeAdView parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getViewGroup().getChildCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public View getChildAt(ReactNativeGoogleMobileAdsNativeAdView parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getViewGroup().getChildAt(index);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(ReactNativeGoogleMobileAdsNativeAdView parent, int index) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.getViewGroup().removeViewAt(index);
    }
}
