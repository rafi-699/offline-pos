package io.invertase.googlemobileads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.invertase.googlemobileads.common.ReactNativeAdView;
import io.invertase.googlemobileads.common.SharedUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeGoogleMobileAdsBannerAdViewManager extends SimpleViewManager<ReactNativeAdView> {
    private static final String REACT_CLASS = "RNGoogleMobileAdsBannerView";
    private final String EVENT_AD_LOADED = "onAdLoaded";
    private final String EVENT_AD_IMPRESSION = "onAdImpression";
    private final String EVENT_AD_CLICKED = "onAdClicked";
    private final String EVENT_AD_FAILED_TO_LOAD = "onAdFailedToLoad";
    private final String EVENT_AD_OPENED = "onAdOpened";
    private final String EVENT_AD_CLOSED = "onAdClosed";
    private final String EVENT_PAID = "onPaid";
    private final String EVENT_SIZE_CHANGE = "onSizeChange";
    private final String EVENT_APP_EVENT = "onAppEvent";
    private final String COMMAND_ID_RECORD_MANUAL_IMPRESSION = "recordManualImpression";
    private final String COMMAND_ID_LOAD = "load";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nonnull
    public ReactNativeAdView createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        return new ReactNativeAdView(themedReactContext);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnNativeEvent.EVENT_NAME, MapBuilder.of("registrationName", "onNativeEvent"));
        return builder.build();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(ReactNativeAdView reactNativeAdView, String str, @Nullable ReadableArray readableArray) {
        super.receiveCommand(reactNativeAdView, str, readableArray);
        if (str.equals("recordManualImpression")) {
            BaseAdView adView = getAdView(reactNativeAdView);
            if (adView instanceof AdManagerAdView) {
                ((AdManagerAdView) adView).recordManualImpression();
                return;
            }
            return;
        }
        if (str.equals("load")) {
            getAdView(reactNativeAdView).loadAd(reactNativeAdView.getRequest());
        }
    }

    @ReactProp(name = "unitId")
    public void setUnitId(ReactNativeAdView reactNativeAdView, String str) {
        reactNativeAdView.setUnitId(str);
        reactNativeAdView.setPropsChanged(true);
    }

    @ReactProp(name = "request")
    public void setRequest(ReactNativeAdView reactNativeAdView, String str) {
        try {
            reactNativeAdView.setRequest(ReactNativeGoogleMobileAdsCommon.buildAdRequest(SharedUtils.jsonObjectToWritableMap(new JSONObject(str))));
            reactNativeAdView.setPropsChanged(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @ReactProp(name = "sizeConfig")
    public void setSizeConfig(ReactNativeAdView reactNativeAdView, ReadableMap readableMap) {
        ReadableArray array;
        if (readableMap != null) {
            if (readableMap.hasKey(ViewProps.MAX_HEIGHT) && !readableMap.isNull(ViewProps.MAX_HEIGHT)) {
                reactNativeAdView.setMaxAdHeight((float) readableMap.getDouble(ViewProps.MAX_HEIGHT));
            } else {
                reactNativeAdView.setMaxAdHeight(0.0f);
            }
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                reactNativeAdView.setAdWidth((float) readableMap.getDouble("width"));
            } else {
                reactNativeAdView.setAdWidth(0.0f);
            }
            if (readableMap.hasKey("sizes") && !readableMap.isNull("sizes") && (array = readableMap.getArray("sizes")) != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < array.size(); i++) {
                    if (array.getType(i) == ReadableType.String) {
                        arrayList.add(ReactNativeGoogleMobileAdsCommon.getAdSize(array.getString(i), reactNativeAdView));
                    }
                }
                if (arrayList.size() > 0 && !arrayList.contains(AdSize.FLUID)) {
                    AdSize adSize = arrayList.get(0);
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putDouble("width", adSize.getWidth());
                    writableMapCreateMap.putDouble("height", adSize.getHeight());
                    sendEvent(reactNativeAdView, "onSizeChange", writableMapCreateMap);
                }
                reactNativeAdView.setSizes(arrayList);
            }
            reactNativeAdView.setPropsChanged(true);
        }
    }

    @ReactProp(name = "manualImpressionsEnabled")
    public void setManualImpressionsEnabled(ReactNativeAdView reactNativeAdView, boolean z) {
        reactNativeAdView.setManualImpressionsEnabled(z);
        reactNativeAdView.setPropsChanged(true);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(ReactNativeAdView reactNativeAdView) {
        super.onAfterUpdateTransaction(reactNativeAdView);
        if (reactNativeAdView.getPropsChanged()) {
            requestAd(reactNativeAdView);
        }
        reactNativeAdView.setPropsChanged(false);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(ReactNativeAdView reactNativeAdView) {
        BaseAdView adView = getAdView(reactNativeAdView);
        if (adView != null) {
            adView.setAdListener(null);
            if (adView instanceof AdManagerAdView) {
                ((AdManagerAdView) adView).setAppEventListener(null);
            }
            adView.destroy();
            reactNativeAdView.removeView(adView);
        }
        super.onDropViewInstance(reactNativeAdView);
    }

    private BaseAdView initAdView(final ReactNativeAdView reactNativeAdView) {
        BaseAdView adView;
        BaseAdView adView2 = getAdView(reactNativeAdView);
        if (adView2 != null) {
            adView2.setAdListener(null);
            if (adView2 instanceof AdManagerAdView) {
                ((AdManagerAdView) adView2).setAppEventListener(null);
            }
            adView2.destroy();
            reactNativeAdView.removeView(adView2);
        }
        Activity currentActivity = ((ReactContext) reactNativeAdView.getContext()).getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        if (ReactNativeGoogleMobileAdsCommon.isAdManagerUnit(reactNativeAdView.getUnitId())) {
            adView = new AdManagerAdView(currentActivity);
        } else {
            adView = new AdView(currentActivity);
        }
        adView.setDescendantFocusability(393216);
        adView.setOnPaidEventListener(new OnPaidEventListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager.1
            @Override // com.google.android.gms.ads.OnPaidEventListener
            public void onPaidEvent(AdValue adValue) {
                WritableMap writableMapCreateMap = Arguments.createMap();
                writableMapCreateMap.putDouble("value", adValue.getValueMicros() * 1.0E-6d);
                writableMapCreateMap.putDouble("precision", adValue.getPrecisionType());
                writableMapCreateMap.putString(FirebaseAnalytics.Param.CURRENCY, adValue.getCurrencyCode());
                ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onPaid", writableMapCreateMap);
            }
        });
        adView.setAdListener(new AnonymousClass2(adView, reactNativeAdView));
        if (adView instanceof AdManagerAdView) {
            ((AdManagerAdView) adView).setAppEventListener(new AppEventListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager.3
                @Override // com.google.android.gms.ads.admanager.AppEventListener
                public void onAppEvent(String str, @Nullable String str2) {
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putString("name", str);
                    writableMapCreateMap.putString("data", str2);
                    ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onAppEvent", writableMapCreateMap);
                }
            });
        }
        reactNativeAdView.addView(adView);
        return adView;
    }

    /* JADX INFO: renamed from: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager$2, reason: invalid class name */
    class AnonymousClass2 extends AdListener {
        final /* synthetic */ BaseAdView val$adView;
        final /* synthetic */ ReactNativeAdView val$reactViewGroup;

        AnonymousClass2(BaseAdView baseAdView, ReactNativeAdView reactNativeAdView) {
            this.val$adView = baseAdView;
            this.val$reactViewGroup = reactNativeAdView;
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdLoaded() {
            int height;
            int width;
            AdSize adSize = this.val$adView.getAdSize();
            if (this.val$reactViewGroup.getIsFluid()) {
                width = this.val$reactViewGroup.getWidth();
                height = this.val$reactViewGroup.getHeight();
                BaseAdView baseAdView = this.val$adView;
                final ReactNativeAdView reactNativeAdView = this.val$reactViewGroup;
                baseAdView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsBannerAdViewManager$2$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                        this.f$0.lambda$onAdLoaded$0(reactNativeAdView, view, i, i2, i3, i4, i5, i6, i7, i8);
                    }
                });
            } else {
                int left = this.val$adView.getLeft();
                int top = this.val$adView.getTop();
                int widthInPixels = adSize.getWidthInPixels(this.val$reactViewGroup.getContext());
                int heightInPixels = adSize.getHeightInPixels(this.val$reactViewGroup.getContext());
                this.val$adView.measure(widthInPixels, heightInPixels);
                this.val$adView.layout(left, top, left + widthInPixels, top + heightInPixels);
                height = heightInPixels;
                width = widthInPixels;
            }
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("width", PixelUtil.toDIPFromPixel(width));
            writableMapCreateMap.putDouble("height", PixelUtil.toDIPFromPixel(height));
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdLoaded", writableMapCreateMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onAdLoaded$0(ReactNativeAdView reactNativeAdView, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("width", PixelUtil.toDIPFromPixel(i3 - i));
            writableMapCreateMap.putDouble("height", PixelUtil.toDIPFromPixel(i4 - i2));
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onSizeChange", writableMapCreateMap);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdFailedToLoad", ReactNativeGoogleMobileAdsCommon.errorCodeToMap(loadAdError.getCode()));
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdOpened() {
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdOpened", null);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdClosed() {
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdClosed", null);
        }

        @Override // com.google.android.gms.ads.AdListener
        public void onAdImpression() {
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdImpression", null);
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
        public void onAdClicked() {
            ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(this.val$reactViewGroup, "onAdClicked", null);
        }
    }

    @Nullable
    private BaseAdView getAdView(ViewGroup viewGroup) {
        return (BaseAdView) viewGroup.getChildAt(0);
    }

    private void requestAd(ReactNativeAdView reactNativeAdView) {
        BaseAdView baseAdViewInitAdView;
        String unitId = reactNativeAdView.getUnitId();
        List<AdSize> sizes = reactNativeAdView.getSizes();
        AdRequest request = reactNativeAdView.getRequest();
        Boolean boolValueOf = Boolean.valueOf(reactNativeAdView.getManualImpressionsEnabled());
        if (sizes == null || unitId == null || request == null || boolValueOf == null || (baseAdViewInitAdView = initAdView(reactNativeAdView)) == null) {
            return;
        }
        baseAdViewInitAdView.setAdUnitId(unitId);
        reactNativeAdView.setIsFluid(false);
        if (baseAdViewInitAdView instanceof AdManagerAdView) {
            if (sizes.contains(AdSize.FLUID)) {
                reactNativeAdView.setIsFluid(true);
            }
            AdManagerAdView adManagerAdView = (AdManagerAdView) baseAdViewInitAdView;
            adManagerAdView.setAdSizes((AdSize[]) sizes.toArray(new AdSize[0]));
            if (boolValueOf.booleanValue()) {
                adManagerAdView.setManualImpressionsEnabled(true);
            }
        } else {
            baseAdViewInitAdView.setAdSize(sizes.get(0));
        }
        baseAdViewInitAdView.loadAd(request);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(ReactNativeAdView reactNativeAdView, String str, WritableMap writableMap) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", str);
        if (writableMap != null) {
            writableMapCreateMap.merge(writableMap);
        }
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ThemedReactContext) reactNativeAdView.getContext(), reactNativeAdView.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new OnNativeEvent(reactNativeAdView.getId(), writableMapCreateMap));
        }
    }
}
