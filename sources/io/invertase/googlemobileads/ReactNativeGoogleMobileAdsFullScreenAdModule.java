package io.invertase.googlemobileads;

import android.app.Activity;
import android.util.Log;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.invertase.googlemobileads.common.ReactNativeModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeGoogleMobileAdsFullScreenAdModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001#B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u00020\u0006H&J.\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H&J4\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001eJ&\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule;", "T", "Lio/invertase/googlemobileads/common/ReactNativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "moduleName", "", "<init>", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;)V", "adArray", "Landroid/util/SparseArray;", "getAdEventName", "loadAd", "", "activity", "Landroid/app/Activity;", "adUnitId", "adRequest", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adLoadCallback", "Lcom/google/android/gms/ads/AdLoadCallback;", "sendAdEvent", "type", "requestId", "", "error", "Lcom/facebook/react/bridge/WritableMap;", "data", "load", "adRequestOptions", "Lcom/facebook/react/bridge/ReadableMap;", "show", "showOptions", BaseJavaModule.METHOD_TYPE_PROMISE, "Lcom/facebook/react/bridge/Promise;", "ReactNativeGoogleMobileAdsAdLoadCallback", "react-native-google-mobile-ads_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ReactNativeGoogleMobileAdsFullScreenAdModule<T> extends ReactNativeModule {
    private final SparseArray<T> adArray;

    public abstract String getAdEventName();

    public abstract void loadAd(Activity activity, String adUnitId, AdManagerAdRequest adRequest, AdLoadCallback<T> adLoadCallback);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeGoogleMobileAdsFullScreenAdModule(ReactApplicationContext reactApplicationContext, String moduleName) {
        super(reactApplicationContext, moduleName);
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.adArray = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendAdEvent(String type, int requestId, String adUnitId, WritableMap error, WritableMap data) {
        ReactNativeGoogleMobileAdsCommon.sendAdEvent(getAdEventName(), requestId, type, adUnitId, error, data);
    }

    public final void load(int requestId, final String adUnitId, ReadableMap adRequestOptions) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(adRequestOptions, "adRequestOptions");
        final Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("code", "null-activity");
            writableMapCreateMap.putString("message", "Ad attempted to load but the current Activity was null.");
            sendAdEvent("error", requestId, adUnitId, writableMapCreateMap, null);
            return;
        }
        final AdManagerAdRequest adManagerAdRequestBuildAdRequest = ReactNativeGoogleMobileAdsCommon.buildAdRequest(adRequestOptions);
        final ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback = new ReactNativeGoogleMobileAdsAdLoadCallback(this, requestId, adUnitId, adRequestOptions);
        currentActivity.runOnUiThread(new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ReactNativeGoogleMobileAdsFullScreenAdModule.load$lambda$0(this.f$0, currentActivity, adUnitId, adManagerAdRequestBuildAdRequest, reactNativeGoogleMobileAdsAdLoadCallback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void load$lambda$0(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, Activity activity, String str, AdManagerAdRequest adManagerAdRequest, ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback) {
        Intrinsics.checkNotNull(adManagerAdRequest);
        reactNativeGoogleMobileAdsFullScreenAdModule.loadAd(activity, str, adManagerAdRequest, reactNativeGoogleMobileAdsAdLoadCallback);
    }

    public final void show(final int requestId, final String adUnitId, final ReadableMap showOptions, final Promise promise) {
        Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
        Intrinsics.checkNotNullParameter(showOptions, "showOptions");
        Intrinsics.checkNotNullParameter(promise, "promise");
        final Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null) {
            ReactNativeModule.rejectPromiseWithCodeAndMessage(promise, "null-activity", "Ad attempted to show but the current Activity was null.");
        } else {
            currentActivity.runOnUiThread(new Runnable() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ReactNativeGoogleMobileAdsFullScreenAdModule.show$lambda$2(this.f$0, requestId, showOptions, currentActivity, promise, adUnitId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2(final ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, final int i, ReadableMap readableMap, Activity activity, Promise promise, final String str) {
        ReactNativeGoogleMobileAdsAdHelper reactNativeGoogleMobileAdsAdHelper = new ReactNativeGoogleMobileAdsAdHelper(reactNativeGoogleMobileAdsFullScreenAdModule.adArray.get(i));
        reactNativeGoogleMobileAdsAdHelper.setImmersiveMode(readableMap.hasKey("immersiveModeEnabled") ? readableMap.getBoolean("immersiveModeEnabled") : false);
        reactNativeGoogleMobileAdsAdHelper.show(activity, new OnUserEarnedRewardListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.ads.OnUserEarnedRewardListener
            public final void onUserEarnedReward(RewardItem rewardItem) {
                ReactNativeGoogleMobileAdsFullScreenAdModule.show$lambda$2$lambda$1(this.f$0, i, str, rewardItem);
            }
        });
        promise.resolve(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$2$lambda$1(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, int i, String str, RewardItem rewardItem) {
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", rewardItem.getType());
        writableMapCreateMap.putInt("amount", rewardItem.getAmount());
        reactNativeGoogleMobileAdsFullScreenAdModule.sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_REWARDED_EARNED_REWARD, i, str, null, writableMapCreateMap);
    }

    /* JADX INFO: compiled from: ReactNativeGoogleMobileAdsFullScreenAdModule.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b9¨\u0006\u0011"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback;", "Lcom/google/android/gms/ads/AdLoadCallback;", "requestId", "", "adUnitId", "", "adRequestOptions", "Lcom/facebook/react/bridge/ReadableMap;", "<init>", "(Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule;ILjava/lang/String;Lcom/facebook/react/bridge/ReadableMap;)V", "onAdLoaded", "", "ad", "(Ljava/lang/Object;)V", "onAdFailedToLoad", "loadAdError", "Lcom/google/android/gms/ads/LoadAdError;", "react-native-google-mobile-ads_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class ReactNativeGoogleMobileAdsAdLoadCallback extends AdLoadCallback<T> {
        private final ReadableMap adRequestOptions;
        private final String adUnitId;
        private final int requestId;
        final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule<T> this$0;

        public ReactNativeGoogleMobileAdsAdLoadCallback(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, int i, String adUnitId, ReadableMap adRequestOptions) {
            Intrinsics.checkNotNullParameter(adUnitId, "adUnitId");
            Intrinsics.checkNotNullParameter(adRequestOptions, "adRequestOptions");
            this.this$0 = reactNativeGoogleMobileAdsFullScreenAdModule;
            this.requestId = i;
            this.adUnitId = adUnitId;
            this.adRequestOptions = adRequestOptions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdLoaded(T ad) {
            WritableMap writableMap;
            Intrinsics.checkNotNullParameter(ad, "ad");
            try {
                ReactNativeGoogleMobileAdsAdHelper reactNativeGoogleMobileAdsAdHelper = new ReactNativeGoogleMobileAdsAdHelper(ad);
                String str = ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_LOADED;
                final ReactNativeGoogleMobileAdsFullScreenAdModule<T> reactNativeGoogleMobileAdsFullScreenAdModule = this.this$0;
                OnPaidEventListener onPaidEventListener = new OnPaidEventListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda0
                    @Override // com.google.android.gms.ads.OnPaidEventListener
                    public final void onPaidEvent(AdValue adValue) {
                        ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback.onAdLoaded$lambda$0(reactNativeGoogleMobileAdsFullScreenAdModule, this, adValue);
                    }
                };
                if (ad instanceof AdManagerInterstitialAd) {
                    ((InterstitialAd) ad).setOnPaidEventListener(onPaidEventListener);
                } else if (ad instanceof AppOpenAd) {
                    ((AppOpenAd) ad).setOnPaidEventListener(onPaidEventListener);
                } else if (ad instanceof RewardedAd) {
                    ((RewardedAd) ad).setOnPaidEventListener(onPaidEventListener);
                } else if (ad instanceof RewardedInterstitialAd) {
                    ((RewardedInterstitialAd) ad).setOnPaidEventListener(onPaidEventListener);
                }
                if ((ad instanceof RewardedAd) || (ad instanceof RewardedInterstitialAd)) {
                    str = ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_REWARDED_LOADED;
                    RewardItem rewardItem = reactNativeGoogleMobileAdsAdHelper.getRewardItem();
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putString("type", rewardItem.getType());
                    writableMapCreateMap.putInt("amount", rewardItem.getAmount());
                    ReadableMap map = this.adRequestOptions.getMap("serverSideVerificationOptions");
                    if (map != null) {
                        ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
                        String string = map.getString("userId");
                        if (string != null) {
                            builder.setUserId(string);
                        }
                        String string2 = map.getString("customData");
                        if (string2 != null) {
                            builder.setCustomData(string2);
                        }
                        ServerSideVerificationOptions serverSideVerificationOptionsBuild = builder.build();
                        Intrinsics.checkNotNullExpressionValue(serverSideVerificationOptionsBuild, "build(...)");
                        reactNativeGoogleMobileAdsAdHelper.setServerSideVerificationOptions(serverSideVerificationOptionsBuild);
                    }
                    writableMap = writableMapCreateMap;
                } else {
                    writableMap = null;
                }
                if (ad instanceof AdManagerInterstitialAd) {
                    final ReactNativeGoogleMobileAdsFullScreenAdModule<T> reactNativeGoogleMobileAdsFullScreenAdModule2 = this.this$0;
                    reactNativeGoogleMobileAdsAdHelper.setAppEventListener(new AppEventListener() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda1
                        @Override // com.google.android.gms.ads.admanager.AppEventListener
                        public final void onAppEvent(String str2, String str3) {
                            ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback.onAdLoaded$lambda$4(reactNativeGoogleMobileAdsFullScreenAdModule2, this, str2, str3);
                        }
                    });
                }
                final ReactNativeGoogleMobileAdsFullScreenAdModule<T> reactNativeGoogleMobileAdsFullScreenAdModule3 = this.this$0;
                reactNativeGoogleMobileAdsAdHelper.setFullScreenContentCallback(new FullScreenContentCallback() { // from class: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$onAdLoaded$fullScreenContentCallback$1
                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdImpression() {
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdShowedFullScreenContent() {
                        sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_OPENED);
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdDismissedFullScreenContent() {
                        sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLOSED);
                    }

                    @Override // com.google.android.gms.ads.FullScreenContentCallback
                    public void onAdClicked() {
                        sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_CLICKED);
                    }

                    private final void sendAdEvent(String type) {
                        reactNativeGoogleMobileAdsFullScreenAdModule3.sendAdEvent(type, ((ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback) this).requestId, ((ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback) this).adUnitId, null, null);
                    }
                });
                ((ReactNativeGoogleMobileAdsFullScreenAdModule) this.this$0).adArray.put(this.requestId, ad);
                this.this$0.sendAdEvent(str, this.requestId, this.adUnitId, null, writableMap);
            } catch (Exception e) {
                Log.w("RNGoogleMobileAds", "Unknown error on load");
                Log.w("RNGoogleMobileAds", e);
                WritableMap writableMapCreateMap2 = Arguments.createMap();
                writableMapCreateMap2.putString("code", "internal");
                writableMapCreateMap2.putString("message", e.getMessage());
                this.this$0.sendAdEvent("error", this.requestId, this.adUnitId, writableMapCreateMap2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAdLoaded$lambda$0(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback, AdValue adValue) {
            Intrinsics.checkNotNullParameter(adValue, "adValue");
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("value", adValue.getValueMicros() * 1.0E-6d);
            writableMapCreateMap.putDouble("precision", ((double) adValue.getPrecisionType()) * 1.0d);
            writableMapCreateMap.putString(FirebaseAnalytics.Param.CURRENCY, adValue.getCurrencyCode());
            reactNativeGoogleMobileAdsFullScreenAdModule.sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_PAID, reactNativeGoogleMobileAdsAdLoadCallback.requestId, reactNativeGoogleMobileAdsAdLoadCallback.adUnitId, null, writableMapCreateMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onAdLoaded$lambda$4(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback, String name, String eventData) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(eventData, "eventData");
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putString("name", name);
            writableMapCreateMap.putString("data", eventData);
            reactNativeGoogleMobileAdsFullScreenAdModule.sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_APP_EVENT, reactNativeGoogleMobileAdsAdLoadCallback.requestId, reactNativeGoogleMobileAdsAdLoadCallback.adUnitId, null, writableMapCreateMap);
        }

        @Override // com.google.android.gms.ads.AdLoadCallback
        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Intrinsics.checkNotNullParameter(loadAdError, "loadAdError");
            WritableMap writableMapCreateMap = Arguments.createMap();
            String[] codeAndMessageFromAdError = ReactNativeGoogleMobileAdsCommon.getCodeAndMessageFromAdError(loadAdError);
            writableMapCreateMap.putString("code", codeAndMessageFromAdError[0]);
            writableMapCreateMap.putString("message", codeAndMessageFromAdError[1]);
            this.this$0.sendAdEvent("error", this.requestId, this.adUnitId, writableMapCreateMap, null);
        }
    }
}
