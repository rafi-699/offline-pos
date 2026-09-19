package io.invertase.googlemobileads;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNGoogleMobileAdsMediaViewManagerDelegate;
import com.facebook.react.viewmanagers.RNGoogleMobileAdsMediaViewManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeGoogleMobileAdsMediaViewManager.kt */
/* JADX INFO: loaded from: classes4.dex */
@ReactModule(name = ReactNativeGoogleMobileAdsMediaViewManager.NAME)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\fH\u0017J\u001a\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0017R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsMediaViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsMediaView;", "Lcom/facebook/react/viewmanagers/RNGoogleMobileAdsMediaViewManagerInterface;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "delegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "getDelegate", "getName", "", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "setResponseId", "", ViewHierarchyConstants.VIEW_KEY, "responseId", "setResizeMode", ViewProps.RESIZE_MODE, "Companion", "react-native-google-mobile-ads_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeGoogleMobileAdsMediaViewManager extends ViewGroupManager<ReactNativeGoogleMobileAdsMediaView> implements RNGoogleMobileAdsMediaViewManagerInterface<ReactNativeGoogleMobileAdsMediaView> {
    public static final String NAME = "RNGoogleMobileAdsMediaView";
    private final ViewManagerDelegate<ReactNativeGoogleMobileAdsMediaView> delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeGoogleMobileAdsMediaViewManager(ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.delegate = new RNGoogleMobileAdsMediaViewManagerDelegate(this);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<ReactNativeGoogleMobileAdsMediaView> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public ReactNativeGoogleMobileAdsMediaView createViewInstance(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ReactNativeGoogleMobileAdsMediaView(context);
    }

    @Override // com.facebook.react.viewmanagers.RNGoogleMobileAdsMediaViewManagerInterface
    @ReactProp(name = "responseId")
    public void setResponseId(ReactNativeGoogleMobileAdsMediaView view, String responseId) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setResponseId(responseId);
    }

    @Override // com.facebook.react.viewmanagers.RNGoogleMobileAdsMediaViewManagerInterface
    @ReactProp(name = ViewProps.RESIZE_MODE)
    public void setResizeMode(ReactNativeGoogleMobileAdsMediaView view, String resizeMode) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setResizeMode(resizeMode);
    }
}
