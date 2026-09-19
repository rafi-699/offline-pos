package io.invertase.googlemobileads;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.ViewManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeGoogleMobileAdsPackage.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsPackage;", "Lcom/facebook/react/TurboReactPackage;", "<init>", "()V", "createViewManagers", "", "Lcom/facebook/react/uimanager/ViewManager;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getModule", "Lcom/facebook/react/bridge/NativeModule;", "name", "", "getReactModuleInfoProvider", "Lcom/facebook/react/module/model/ReactModuleInfoProvider;", "react-native-google-mobile-ads_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeGoogleMobileAdsPackage extends TurboReactPackage {
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public List<ViewManager<?, ?>> createViewManagers(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return CollectionsKt.listOf((Object[]) new BaseViewManager[]{new ReactNativeGoogleMobileAdsBannerAdViewManager(), new ReactNativeGoogleMobileAdsNativeAdViewManager(reactContext), new ReactNativeGoogleMobileAdsMediaViewManager(reactContext)});
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.facebook.react.BaseReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        switch (name.hashCode()) {
            case -1537499885:
                if (name.equals("RNGoogleMobileAdsRewardedModule")) {
                    return new ReactNativeGoogleMobileAdsRewardedModule(reactContext);
                }
                return null;
            case -1403759859:
                if (name.equals(NativeConsentModuleSpec.NAME)) {
                    return new ReactNativeGoogleMobileAdsConsentModule(reactContext);
                }
                return null;
            case -1205003041:
                if (name.equals("RNGoogleMobileAdsRewardedInterstitialModule")) {
                    return new ReactNativeGoogleMobileAdsRewardedInterstitialModule(reactContext);
                }
                return null;
            case -1135042404:
                if (name.equals("RNGoogleMobileAdsNativeModule")) {
                    return new ReactNativeGoogleMobileAdsNativeModule(reactContext);
                }
                return null;
            case -437253871:
                if (name.equals("RNAppModule")) {
                    return new ReactNativeAppModule(reactContext);
                }
                return null;
            case 471412837:
                if (name.equals("RNGoogleMobileAdsModule")) {
                    return new ReactNativeGoogleMobileAdsModule(reactContext);
                }
                return null;
            case 522077489:
                if (name.equals("RNGoogleMobileAdsInterstitialModule")) {
                    return new ReactNativeGoogleMobileAdsInterstitialModule(reactContext);
                }
                return null;
            case 555103806:
                if (name.equals("RNGoogleMobileAdsAppOpenModule")) {
                    return new ReactNativeGoogleMobileAdsAppOpenModule(reactContext);
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.facebook.react.BaseReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return ReactNativeGoogleMobileAdsPackage.getReactModuleInfoProvider$lambda$0();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map getReactModuleInfoProvider$lambda$0() {
        HashMap map = new HashMap();
        String name = ReactNativeAppModule.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        map.put("RNAppModule", new ReactModuleInfo("RNAppModule", name, false, false, false, true));
        map.put("RNGoogleMobileAdsModule", new ReactModuleInfo("RNGoogleMobileAdsModule", "RNGoogleMobileAdsModule", false, false, false, false));
        map.put(NativeConsentModuleSpec.NAME, new ReactModuleInfo(NativeConsentModuleSpec.NAME, NativeConsentModuleSpec.NAME, false, false, false, false));
        map.put("RNGoogleMobileAdsAppOpenModule", new ReactModuleInfo("RNGoogleMobileAdsAppOpenModule", "RNGoogleMobileAdsAppOpenModule", false, false, false, false));
        map.put("RNGoogleMobileAdsInterstitialModule", new ReactModuleInfo("RNGoogleMobileAdsInterstitialModule", "RNGoogleMobileAdsInterstitialModule", false, false, false, false));
        map.put("RNGoogleMobileAdsRewardedModule", new ReactModuleInfo("RNGoogleMobileAdsRewardedModule", "RNGoogleMobileAdsRewardedModule", false, false, false, false));
        map.put("RNGoogleMobileAdsRewardedInterstitialModule", new ReactModuleInfo("RNGoogleMobileAdsRewardedInterstitialModule", "RNGoogleMobileAdsRewardedInterstitialModule", false, false, false, false));
        map.put("RNGoogleMobileAdsNativeModule", new ReactModuleInfo("RNGoogleMobileAdsNativeModule", "RNGoogleMobileAdsNativeModule", false, false, false, true));
        return map;
    }
}
